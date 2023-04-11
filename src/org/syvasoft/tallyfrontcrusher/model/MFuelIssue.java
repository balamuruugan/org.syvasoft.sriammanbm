package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.acct.Doc;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MClient;
import org.compiere.model.MCost;
import org.compiere.model.MCostElement;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInventory;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MLocator;
import org.compiere.model.MPriceList;
import org.compiere.model.MSysConfig;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;


public class MFuelIssue extends X_TF_Fuel_Issue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3927519272739123306L;
	public MFuelIssue(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MFuelIssue(Properties ctx, int TF_Fuel_Issue_ID, String trxName) {
		super(ctx, TF_Fuel_Issue_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public boolean validateStock = true;
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(getVehicle_ID() == 0) {
			if(getPM_Machinery_ID() > 0) {
				MMachinery m = new MMachinery(getCtx(), getPM_Machinery_ID(), get_TrxName());
				setVehicle_ID(m.getM_Product_ID());
			}
		}
		//MResource resource  = (MResource)getVehicle().getS_Resource();		
		//setC_ElementValue_ID(resource.get_ValueAsInt(COLUMNNAME_C_ElementValue_ID));
		
		//Set Costing
		//MProduct product = MProduct.get(getCtx(), getM_Product_ID());
		//MClient client = MClient.get(getCtx());
		//MAcctSchema as = client.getAcctSchema();
		//String costingMethod = product.getCostingMethod(as);		
		//MCost cost = product.getCostingRecord(as, getAD_Org_ID(), 0, costingMethod);
		//if(cost == null)
		//	throw new AdempiereException("No Costing Info for : "  + product.getName());
		//setRate(cost.getCurrentCostPrice());
		
		//if(isCalculated()) {			
			//setAmt(getQty().multiply(getRate()));
		//}
		
		//if(is_ValueChanged(COLUMNNAME_M_Product_ID) || is_ValueChanged(COLUMNNAME_Qty)) {
			MLocator lc=new MLocator(getCtx(), getM_Locator_ID(), get_TrxName());
			setM_Warehouse_ID(lc.getM_Warehouse_ID());
			
			/*
			String sql = " SELECT " +
								" bomQtyOnHand(" + getM_Product_ID() + "," + getM_Warehouse_ID() + " ,0) - " + 
								" bomQtyReserved(" + getM_Product_ID() + "," + getM_Warehouse_ID() + " ,0) - " +
								" prodQtyReserved(" + getM_Product_ID() + "," + getM_Warehouse_ID() + " ) " +							 
							" FROM " + 
								" M_Locator l " + 
							" WHERE l.M_Locator_ID=" + wh.getDefaultLocator().get_ID();
			*/
		//}
		setDefaultValues(newRecord);	
		TF_MCharge.createChargeFromAccount(getCtx(), getAccount_ID(), get_TrxName());
		
		if(getIssueType().equals(ISSUETYPE_OwnExpense)) {
			TF_MProduct p = new TF_MProduct(getCtx(), getM_Product_ID(), get_TrxName());
			MMachineryType mt = (MMachineryType) getPM_Machinery().getPM_MachineryType();
			if(p.IsIssuedMeterRequired() && mt != null && mt.issuedMeterRequired()  && getIssueMeter().doubleValue() == 0) {
				throw new AdempiereException("Required Issue Meter!");
			}
		}
		
		if(getPM_Machinery_ID() > 0) {
			if(isFullTank()) {
				String mileageType = getPM_Machinery().getPM_MachineryType().getMileageType();
				setMileageType(mileageType);
				
				if(is_ValueChanged(COLUMNNAME_IsFullTank) || is_ValueChanged(COLUMNNAME_IssueMeter) || is_ValueChanged(COLUMNNAME_PrevIssueMeter))
					calculateMileage();
			}
			else {
				setMileage(null);
				setMileageType(null);
				setTF_Fuel_IssueOp_ID(0);
			}
		}
		
		
		calculateSimpleMileage();
		return super.beforeSave(newRecord);
	}
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		
		
		if(!newRecord && getDocStatus().equals(DOCSTATUS_Completed)  &&  (is_ValueChanged(COLUMNNAME_IsFullTank) ||
				is_ValueChanged(COLUMNNAME_IssueMeter) || is_ValueChanged(COLUMNNAME_DocStatus) ||
				is_ValueChanged(COLUMNNAME_PrevIssueMeter))) {
			reCalculateMileage();
		}
		postImmediate(newRecord);
		return super.afterSave(newRecord, success);
	}
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);			
			MRentedVehicle rv = null;
			TF_MProject proj = null;
			TF_MBPartner bp = null;

			
			String sql = " SELECT  COALESCE(qtyonhand,0) FROM m_storeageonhand_v s WHERE s.M_Locator_ID=" + getM_Locator_ID()+ " AND s.M_Product_ID="+getM_Product_ID();

			BigDecimal qtyAvailable = DB.getSQLValueBD(null, sql);
			if(qtyAvailable==null) {
				qtyAvailable=BigDecimal.ZERO;
			}
			
			if(qtyAvailable.doubleValue() < getQty().doubleValue() && validateStock && getMovementQty().doubleValue() > 0) {
				//log.saveError("NotEnoughStocked", Msg.getElement(getCtx(), COLUMNNAME_Qty));
				throw new AdempiereException("Inventory on Hand : " + qtyAvailable);				
			}

			if(getC_BPartner_ID() > 0) {
				 bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
			}
			else if(getVehicle_ID() > 0)
				rv = new Query(getCtx(), MRentedVehicle.Table_Name, "M_Product_ID=?", get_TrxName())
						.setParameters(getVehicle_ID()).first();
			else if(getC_Project_ID() > 0)
				proj = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());
			
				
			
			
			if(ISSUETYPE_Payment.equals(getIssueType())  && (rv != null || proj != null || bp!=null)) {
				if(getRate().doubleValue() > 0)
					createDebitNote(rv, proj,bp);
				else
					VendorIssue(rv, proj, bp);
			}
			else if(ISSUETYPE_OwnExpense.equals(getIssueType()) || ISSUETYPE_OwnExpenseReturn.equals(getIssueType())) {
				createInternalUseInventory(docAction);
				
				TF_MProduct product = new TF_MProduct(getCtx(),getM_Product_ID(),get_TrxName());
				
				if(product != null) {
					if(product.isTrackSpareLife() == true)
					{
						MSpareMaster.createSpareMaster(getCtx(),get_TrxName(), getTF_Fuel_Issue_ID(), getPM_Machinery_ID(), product.getSpareLife_UOM_ID(), getM_Product_ID(), getDateAcct(), getQty());
					}
				}
			}
	
			if(getPM_Machinery_ID()>0) {
				createMachineryStatement();
			}
			
			
			
			calculateMileage();
		}
	}
	
	private void createMachineryStatement() {
		MMachineryStatement mStatement=new MMachineryStatement(getCtx(), 0, get_TrxName());
		mStatement.setAD_Org_ID(getAD_Org_ID());
		mStatement.setDateAcct(getDateAcct());
		mStatement.setUser1_ID(getUser1_ID());
		mStatement.setPM_Machinery_ID(getPM_Machinery_ID());
		mStatement.setM_Product_ID(getM_Product_ID());
		mStatement.setQty(getMovementQty());
		mStatement.setRate(getRate());
		mStatement.setC_UOM_ID(getC_UOM_ID());
		
		mStatement.setExpense(getMovementQty().doubleValue() > 0 ? getAmt() : getAmt().negate());
		mStatement.setDescription(getDescription());
		mStatement.setC_ElementValue_ID(getAccount_ID());
		mStatement.setTF_Fuel_Issue_ID(getTF_Fuel_Issue_ID());
		mStatement.setPM_Job_ID(getPM_Job_ID());
		//mStatement.setC_Activity_ID(getC_Activity_ID());
		mStatement.saveEx();
	}
	
	@Override
	public int getAccount_ID() {
		int account_id = super.getAccount_ID();
		if(account_id == 0) {
			account_id = MSysConfig.getIntValue("InventoryConsumptionAccount_ID", 1000330);
		}
		return account_id;
	}
	
	private BigDecimal getMovementQty() {
		if(getIssueType().equals(ISSUETYPE_OwnExpenseReturn)) 
			return getQty().negate();
		else
			return getQty();
	}
	
	private void createInternalUseInventory(String docAction) {
		setCost();
		
		
		//Post Inventory Use Inventory for Fuel Expense.
		MWarehouse wh = (MWarehouse) getM_Warehouse();
		//Inventory Use Header
		MInventory inv = new MInventory(wh, get_TrxName());
		inv.setC_DocType_ID(1000026);
		String prdName = TF_MProduct.get(getCtx(), getM_Product_ID()).getName();
		String desc = "Issued " + prdName + " to " +  getVehicle().getName();
		if(getPM_Machinery_ID() > 0) {
			desc = "Issued " + prdName + " to " +  getPM_Machinery().getMachineryNo();
		}
			
		if(getC_Project_ID() > 0) {
			desc = desc + " for " + getC_Project().getName();
		}
		inv.setDescription(getDocumentNo());
		//inv.addDescription(getDescription());
		inv.setMovementDate(getDateAcct());
		inv.setUser1_ID(getC_ElementValue_ID());
		inv.setC_Project_ID(getC_Project_ID());
		inv.setDocStatus(DOCSTATUS_Drafted);
		inv.saveEx();
		
		//Inventory Use Line
		MInventoryLine line = new MInventoryLine(inv, getM_Locator_ID(), getM_Product_ID(), 0, null, null, getMovementQty());
		line.setAD_Org_ID(getAD_Org_ID());
		TF_MCharge chrg = TF_MCharge.createChargeFromAccount(getCtx(), getAccount_ID(), get_TrxName());
		line.setC_Charge_ID(chrg.getC_Charge_ID());
		
		line.setDescription(desc);
		//line.setCurrentCostPrice(getRate());
		line.saveEx();
		
		//Complete Inventory Use Document
		inv.processIt(docAction);
		inv.saveEx();
		
		//Update Inventory Use ID back to Fuel Issue Entry.
		setM_Inventory_ID(inv.getM_Inventory_ID());
		updateReference(COLUMNNAME_M_Inventory_ID, inv.get_ID());
	}
	private void setCost() {
		MAcctSchema as = (MAcctSchema) MGLPostingConfig.getMGLPostingConfig(getCtx()).getC_AcctSchema();
		TF_MProduct prod = new TF_MProduct(getCtx(), getM_Product_ID(), get_TrxName());
		MCost cost = prod.getCostingRecord(as,0, 0, prod.getCostingMethod(as));
		
		//Create Costing record for the product.		
		int M_CostElement_ID = MCostElement.getByCostingMethod(getCtx(), prod.getCostingMethod(as)).get(0).get_ID();
		cost = MCost.get(prod, 0,
				as, 0,M_CostElement_ID , get_TrxName());
		cost.setCurrentQty(getQtyAvailable());
		if(cost.getCumulatedQty().doubleValue() <=0) {
			cost.setCumulatedQty(getQtyAvailable());
			cost.setCumulatedAmt(getQtyAvailable().multiply(getRate()));
		}
		cost.saveEx();
				
		if (cost != null && cost.getCurrentCostPrice().equals(getRate())) {			
			return;
		}
				
		
		
		if(getRate().doubleValue() ==0)
			return;
		
		//Cost Adjustment Header
		MWarehouse[] whs = MWarehouse.getForOrg(getCtx(), getAD_Org_ID());
		if(whs.length==0)
			throw new AdempiereException("Create Warehouse for this Organization!");
		MWarehouse wh = whs[0];		
		MInventory inv = new MInventory(getCtx(), 0, get_TrxName());
		inv.setC_DocType_ID(1000027); //Cost Adjustment		
		String desc = getDocumentNo() + " Own Expense consumption Cost Update";
		inv.setAD_Org_ID(getAD_Org_ID());
		inv.setDescription(desc);
		inv.setC_Currency_ID(as.getC_Currency_ID());
		inv.setMovementDate(getDateAcct());
		inv.setCostingMethod(prod.getCostingMethod(as));
		inv.setDocStatus(MInventory.DOCSTATUS_Drafted);		
		inv.saveEx();
		//End Physical Inventory Header
		
		
		//Inventory Line
		int M_Locator_ID = wh.getDefaultLocator().get_ID();		
		MInventoryLine costingLine = new MInventoryLine(getCtx(), 0, get_TrxName());
		costingLine.setM_Inventory_ID(inv.getM_Inventory_ID());
		costingLine.setM_Product_ID(getM_Product_ID());		
		costingLine.setCurrentCostPrice(cost==null?BigDecimal.ZERO:cost.getCurrentCostPrice());
		costingLine.setNewCostPrice(getRate());
		costingLine.setM_Locator_ID(M_Locator_ID);
		costingLine.setAD_Org_ID(getAD_Org_ID());		
		costingLine.setM_AttributeSetInstance_ID(0);
		costingLine.saveEx();
		//Inventory Line	
		
		//inv.processIt(DocAction.ACTION_Prepare);
		inv.processIt(DocAction.ACTION_Complete);
		inv.saveEx();
		
		MClient client = MClient.get(getCtx());
		MAcctSchema[] ass= new MAcctSchema[1];
		ass[0] =  client.getAcctSchema();
		Doc.postImmediate(ass, MInventory.Table_ID, inv.get_ID(), true, get_TrxName());
		
	}
	private void createDebitNote(MRentedVehicle rv, TF_MProject proj,TF_MBPartner bp) {	
		int bPartnerID = 0;

		if(bp != null)
			bPartnerID = bp.getC_BPartner_ID();
		else if(rv != null)
			bPartnerID = rv.getC_BPartner_ID();
		else
			bPartnerID = proj.getC_BPartner_ID();
		
		if(bp == null)
			bp = new TF_MBPartner(getCtx(), bPartnerID, get_TrxName());
		
		//Debit Note Header
		//if(getRate().doubleValue() > 0) {
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(MGLPostingConfig.getMGLPostingConfig(getCtx()).getDebitNote_DocType_ID());			
		invoice.setDateInvoiced(getDateAcct());
		invoice.setDateAcct(getDateAcct());
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
		//
		
		invoice.setBPartner(bp);
		invoice.setIsSOTrx(false);		
		
		//String description = getDocumentNo();		
		invoice.setDescription(getDocumentNo());
		if(getDescription() != null && getDescription().length() > 0)			 		
			invoice.addDescription(getDescription());
		
		//Price List
		int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
		if(bp.getPO_PriceList_ID() > 0)
			m_M_PriceList_ID = bp.getPO_PriceList_ID();			
		invoice.setM_PriceList_ID(m_M_PriceList_ID);
		invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		
		//Financial Dimension - Profit Center
		invoice.setUser1_ID(getC_ElementValue_ID());
		invoice.setC_Project_ID(getC_Project_ID());
		
		invoice.saveEx();
		//End Invoice Header
		
		//Invoice Line - Vehicle Rental Charge
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		
		if(getM_Product_ID() > 0) {
			invLine.setM_Product_ID(getM_Product_ID(), true);
			invLine.setQty(getMovementQty());
			BigDecimal price = getRate();			
			
			invLine.setPriceActual(price);
			invLine.setPriceList(price);
			invLine.setPriceLimit(price);
			invLine.setPriceEntered(price);
		}
		
		if(rv != null)
			invoice.addDescription("Fuel / Material Issued to " + rv.getVehicleNo());
		else if(proj != null && getM_Product_ID() > 0)
			invoice.addDescription("Fuel / Material Issued to " + proj.getName() + " Subcontract");
		else if(bp != null && getC_BPartner_ID() > 0) {
			invoice.addDescription("Fuel / Material Issued to " + bp.getName());
		}
		else {
			TF_MCharge ch = TF_MCharge.createChargeFromAccount(getCtx(), getAccount_ID(), null);
			invLine.setC_Charge_ID(ch.getC_Charge_ID());
			invLine.setC_UOM_ID(getC_UOM_ID());
			invLine.setQty(BigDecimal.ONE);
			BigDecimal price = getAmt(); 			
			
			invLine.setPriceActual(price);
			invLine.setPriceList(price);
			invLine.setPriceLimit(price);
			invLine.setPriceEntered(price);
			invoice.addDescription("Expense incurred to " + proj.getName() + " Subcontract");
			
		}
		invoice.saveEx();
		invLine.setC_Tax_ID(1000000);
		
		if(getM_Product_ID() > 0) { 
			//Material Issue
			MInOut inout = new MInOut(invoice, MGLPostingConfig.getMGLPostingConfig(getCtx()).getMaterialIssue_DocType_ID(), getDateAcct(), getM_Warehouse_ID());
			inout.setDescription(invoice.getDescription());
			inout.setMovementType(MInOut.MOVEMENTTYPE_VendorReturns);
			inout.saveEx(get_TrxName());
			
			//Material Issue Line
			MInOutLine ioLine = new MInOutLine(inout);
			MWarehouse wh = (MWarehouse) getM_Warehouse();
			ioLine.setInvoiceLine(invLine, getM_Locator_ID(), getMovementQty());
			ioLine.setQty(getMovementQty());
			ioLine.saveEx(get_TrxName());
			
			//Material Issue DocAction
			if (!inout.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
			inout.saveEx();
			//End DocAction
			
			invLine.setM_InOutLine_ID(ioLine.getM_InOutLine_ID());
			setM_InOut_ID(inout.getM_InOut_ID());
			updateReference(COLUMNNAME_M_InOut_ID, inout.get_ID());
		}
				
		invLine.saveEx();
		
		//Debit Note DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		//End DocAction
		
		setDebitNote_Invoice_ID(invoice.getC_Invoice_ID());		
		updateReference(COLUMNNAME_DebitNote_Invoice_ID, invoice.getC_Invoice_ID());
	}
	
	private void VendorIssue(MRentedVehicle rv, TF_MProject proj,TF_MBPartner bp) {
		int bPartnerID = 0;

		if(bp != null)
			bPartnerID = bp.getC_BPartner_ID();
		else if(rv != null)
			bPartnerID = rv.getC_BPartner_ID();
		else
			bPartnerID = proj.getC_BPartner_ID();
		
		if(bp == null)
			bp = new TF_MBPartner(getCtx(), bPartnerID, get_TrxName());
		
		//Material Issue
		MInOut inout = new MInOut(getCtx(), 0, get_TrxName()); 
				//new MInOut(invoice, MGLPostingConfig.getMGLPostingConfig(getCtx()).getMaterialIssue_DocType_ID(), getDateAcct(), getM_Warehouse_ID());
		inout.setIsSOTrx(false);
		inout.setC_DocType_ID( MGLPostingConfig.getMGLPostingConfig(getCtx()).getMaterialIssue_DocType_ID());
		inout.setMovementType(MInOut.MOVEMENTTYPE_VendorReceipts);
		inout.setMovementDate(getDateAcct());
		inout.setDateAcct(getDateAcct());		
		inout.setC_BPartner_ID(bPartnerID);
		inout.setC_BPartner_Location_ID(bp.getPrimaryC_BPartner_Location_ID());
		inout.setAD_User_ID(bp.getAD_User_ID());
		inout.setM_Warehouse_ID(getM_Warehouse_ID());
		inout.setPriorityRule(TF_MInOut.PRIORITYRULE_Medium);
		inout.setFreightCostRule(TF_MInOut.FREIGHTCOSTRULE_FreightIncluded);		
		inout.setMovementType(MInOut.MOVEMENTTYPE_VendorReturns);
		inout.saveEx(get_TrxName());
		
		//Material Issue Line
		MInOutLine ioLine = new MInOutLine(inout);
		MWarehouse wh = (MWarehouse) getM_Warehouse();
		ioLine.setM_Locator_ID(getM_Locator_ID());
		ioLine.setM_Product_ID(getM_Product_ID(), true);		
		ioLine.setQty(getMovementQty());
		ioLine.saveEx(get_TrxName());
		
		//Material Issue DocAction
		if (!inout.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + inout.getProcessMsg());
		inout.saveEx();
		//End DocAction
				
		setM_InOut_ID(inout.getM_InOut_ID());
		updateReference(COLUMNNAME_M_InOut_ID, inout.get_ID());
	}
	
	public void reverseIt() {
		String whereClause="";
		if(getDebitNote_Invoice_ID() > 0) {			
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getDebitNote_Invoice_ID(), get_TrxName());
			if(inv.getDocStatus().equals(DOCSTATUS_Completed))
				inv.reverseCorrectIt();
			inv.saveEx();
			setDebitNote_Invoice_ID(0);
		}
		if(getM_InOut_ID() > 0) {
			MInOut io = new MInOut(getCtx(), getM_InOut_ID(), get_TrxName());
			io.reverseCorrectIt();
			io.saveEx();
			setM_InOut_ID(0);
		}
		if(getM_Inventory_ID() > 0) {
			MInventory inv = new MInventory(getCtx(), getM_Inventory_ID(), get_TrxName());
			if(!inv.getDocStatus().equals(DOCSTATUS_Reversed)) {
				inv.reverseCorrectIt();
				inv.saveEx();
			}
			setM_Inventory_ID(0);			
		}
		if(getPM_Machinery_ID()>0) {
			whereClause="TF_Fuel_Issue_ID=?";
			MMachineryStatement mStatement=new Query(getCtx(), MMachineryStatement.Table_Name, whereClause, get_TrxName())
							.setClient_ID()
							.setParameters(getTF_Fuel_Issue_ID())
							.first();
			if(mStatement!=null) {
				mStatement.delete(true);
			}
		}
		MSpareMaster.reverseSpareEntries(getCtx(),get_TrxName(),getTF_Fuel_Issue_ID());
		setQty(BigDecimal.ZERO);			
		setProcessed(false);
		setDocStatus(DOCSTATUS_Drafted);
		calculateMileage();
		validateStock = false;
	}
	
	public static BigDecimal getPreviousMeter(Properties ctx, int AD_Org_ID, Timestamp dateAcct, int Vehicle_ID, int M_Product_ID) {
		String sql = "SELECT IssueMeter  FROM TF_Fuel_Issue WHERE AD_Org_ID = ? AND DateAcct < ? "
				+ " AND M_Product_ID = ? AND Vehicle_ID = ? AND DocStatus='CO' ORDER BY DateAcct DESC, TF_Fuel_Issue_ID DESC";
		BigDecimal prevIssuedMeter = DB.getSQLValueBDEx(null, sql, AD_Org_ID, dateAcct, M_Product_ID, Vehicle_ID);
						
		return prevIssuedMeter;
	}
	
	public void calculateMileage() {
		boolean fulltankMileage = MSysConfig.getBooleanValue("FULLTANK_MILEAGE", false);
		if(fulltankMileage)
			return;
		
		if(!isFullTank() || !getDocStatus().equals(DOCSTATUS_Completed)) {			
			return;
		}
		String sql = "SELECT MAX(TF_Fuel_Issue_ID) FROM TF_Fuel_Issue WHERE AD_Org_ID = ? AND PM_Machinery_ID = ? AND "
				+ " M_Product_ID = ? AND IsFullTank='Y' AND DocStatus='CO' AND TF_Fuel_Issue_ID < ?";
		
		int prevFuelIssue_ID = DB.getSQLValue(get_TrxName(), sql, getAD_Org_ID(), getPM_Machinery_ID(), 
				getM_Product_ID(), getTF_Fuel_Issue_ID());
		
		if(prevFuelIssue_ID <= 0)
			return;
		
		MFuelIssue prevIssue = new MFuelIssue(getCtx(), prevFuelIssue_ID, get_TrxName());
		BigDecimal RunningMeter = getIssueMeter().subtract(prevIssue.getIssueMeter());
				
		String sqlSum = "SELECT SUM(Qty) FROM TF_Fuel_Issue WHERE (AD_Org_ID = ? AND TF_Fuel_Issue_ID > ? "
				+ "AND TF_Fuel_Issue_ID <= ? "
				+ "AND PM_Machinery_ID = ? AND M_Product_ID = ? AND DocStatus = 'CO') OR (TF_Fuel_Issue_ID = ?)";
		
		BigDecimal totalQty = DB.getSQLValueBD(get_TrxName(), sqlSum, getAD_Org_ID(), prevFuelIssue_ID, 
				getTF_Fuel_Issue_ID(), getPM_Machinery_ID(), getM_Product_ID(), getTF_Fuel_Issue_ID());
		
		BigDecimal mileage = null;
		if(getMileageType() == null) {
			throw new AdempiereException("Mileage Type should not be empty!");
		}
		else if(getMileageType().equals(MMachineryType.MILEAGETYPE_KmLitre)) {
			mileage = RunningMeter.divide(totalQty, 2, RoundingMode.HALF_EVEN);
		}
		else if(getMileageType().equals(MMachineryType.MILEAGETYPE_LitreHr)) {
			mileage = totalQty.divide(RunningMeter, 2, RoundingMode.HALF_EVEN);
		}
		else {
			//throw new AdempiereException(getMileageType() + " - Mileage Type not implemented!");
			setDescription("Mileage Type is not set or not implemented");
		}
		
		setTF_Fuel_IssueOp_ID(prevIssue.getTF_Fuel_Issue_ID());
		setMileage(mileage);				
	}
	
	public void reCalculateMileage() {
		String whereClause = "TF_Fuel_Issue_ID > ? AND AD_Org_ID = ? AND IsFullTank = 'Y' AND "
				+ " PM_Machinery_ID = ? AND M_Product_ID = ? AND DocStatus = 'CO'";
		List<MFuelIssue> list = new Query(getCtx(), Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_Fuel_Issue_ID(), getAD_Org_ID(), getPM_Machinery_ID(), getM_Product_ID())
				.setOrderBy(COLUMNNAME_DateAcct)
				.list();
		
		for(MFuelIssue issue : list) {
			issue.calculateMileage();
			issue.saveEx();
		}
		
	}
	
	public void setDefaultValues(boolean newRecord) {
		
		// request from Mobile App
		if(newRecord && getDocStatus().equals(DOCSTATUS_Completed)) {
			if(getPM_Machinery_ID() == 0 ) {
				int PM_Machinery_ID = MMachinery.getPM_Machinery_ID(getCtx(), getVehicle_ID(), get_TrxName());
				setPM_Machinery_ID(PM_Machinery_ID);				
			}
			
			if(getC_ElementValue_ID() == 0) {
				TF_MProduct p = new TF_MProduct(getCtx(), getM_Product_ID(), get_TrxName());
				int account_Id = p.getSpareExpenseAccount_ID();
				
				if(account_Id == 0) {
					account_Id = MSysConfig.getIntValue("DEFAULT_SPAREEXPENSES_ACCOUNT_ID", 1000331);
				}
				
				setAccount_ID(account_Id);
			}
			
		}
	}
	
	public void calculateSimpleMileage() {
		boolean fulltankMileage = MSysConfig.getBooleanValue("FULLTANK_MILEAGE", false);
		if(fulltankMileage)
			return;
		
		if(getPM_Machinery_ID() == 0)
			return;
		
		int diesel_id = MSysConfig.getIntValue("DIESEL_PRODUCT_ID", 1016771);
		if(getM_Product_ID() != diesel_id)
			return;
		int PM_MachineryType_ID = getPM_Machinery().getPM_MachineryType_ID();
		MMachineryType mt = new MMachineryType(getCtx(), PM_MachineryType_ID, get_TrxName());
		setMileageType(mt.getMileageType());
		BigDecimal mileage = BigDecimal.ZERO;
		
		if(getPrevIssueMeter() == null)
			setPrevIssueMeter(BigDecimal.ZERO);
		
		if(getIssueMeter() == null)
			setIssueMeter(BigDecimal.ZERO);
		
		if(getPrevIssueMeter().doubleValue() > 0 && getIssueMeter().doubleValue() > 0) {
			BigDecimal runningMeter = getIssueMeter().subtract(getPrevIssueMeter());
			
			 if(getMileageType().equals(MMachineryType.MILEAGETYPE_KmLitre)) {
					mileage = runningMeter.divide(getQty(), 2, RoundingMode.HALF_EVEN);
			 }
			 else if(getMileageType().equals(MMachineryType.MILEAGETYPE_LitreHr)) {
					mileage = getQty().divide(runningMeter, 2, RoundingMode.HALF_EVEN);
			 }
			 
			 setMileage(mileage);
		}
	}
	
	public void postImmediate(boolean newRecord) {
		if(newRecord && getDocStatus().equals(DOCSTATUS_Completed)) {
			immediatePosting = true;
			processIt(DocAction.ACTION_Complete);
			
			String sqlUpdate = "UPDATE TF_FUel_Issue SET Processed = 'Y' WHERE TF_Fuel_Issue_ID = " + getTF_Fuel_Issue_ID();
			DB.executeUpdate(sqlUpdate, get_TrxName());
		}
	}
	
	public boolean immediatePosting = false;
	
	public void updateReference(String columnName, int ID) {
		if(!immediatePosting)
			return;
		
		String sqlUpdate = "UPDATE TF_FUel_Issue SET " + columnName + " = " + ID + " WHERE TF_Fuel_Issue_ID = " + getTF_Fuel_Issue_ID();
		DB.executeUpdate(sqlUpdate, get_TrxName());
	}
}

