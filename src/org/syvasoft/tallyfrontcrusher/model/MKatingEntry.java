package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.model.MPriceList;
import org.compiere.model.MWarehouse;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MKatingEntry extends X_TF_KatingEntry {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6988529344057864435L;
	public MKatingEntry(Properties ctx, int TF_KatingEntry_ID, String trxName) {
		super(ctx, TF_KatingEntry_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MKatingEntry(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
		
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord || is_ValueChanged(COLUMNNAME_TF_RentedVehicle_ID) 
				|| is_ValueChanged(COLUMNNAME_Tonnage) || is_ValueChanged(COLUMNNAME_TotalLoad)) {
			if(getTF_RentedVehicle_ID() > 0) {
				MRentedVehicle rv = new MRentedVehicle(getCtx(), getTF_RentedVehicle_ID(), get_TrxName());
				setTonnage(rv.getTonnagePerLoad());
				if(getTonnage() == null || getTonnage().doubleValue() ==0)
					throw new AdempiereException("No Tonnage found for the selected Vehicle!");
				
				MJobworkAssignedVehicle jwVehicle = MJobworkAssignedVehicle.getJobwork(getAD_Org_ID(), rv.getM_Product_ID());
				if(jwVehicle != null) {
					setC_Project_ID(jwVehicle.getC_Project_ID());
					TF_MProject proj = new TF_MProject(getCtx(), jwVehicle.getC_Project_ID(), get_TrxName());
					setM_Product_ID(proj.getJobWork_Product_ID());
					BigDecimal price = MJobworkProductPrice.getPrice(getCtx(), proj.getC_Project_ID(), getM_Product_ID(), getDateAcct());
					if(price == null) {
						throw new AdempiereException("Please specify contract price for " + getM_Product().getName());
					}
					else {
						setPrice(price);
					}
					if(getDescription() == null || getDescription().length() == 0)
						setDescription(rv.getVehicleNo());
				}				
				else {
					throw new AdempiereException("No Kating Project found for the selected Vehicle!");
					//TODO: OWN Production code ..
				}
			}
			else if(getC_Project_ID() > 0) {
				TF_MProject proj = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());
				setM_Product_ID(proj.getJobWork_Product_ID());
				BigDecimal price = MJobworkProductPrice.getPrice(getCtx(), proj.getC_Project_ID(), getM_Product_ID(), getDateAcct());
				if(price == null) {
					throw new AdempiereException("Please specify contract price for " + getM_Product().getName());
				}
				else {
					setPrice(price);
				}
			}
			else if(getC_Project_ID() == 0) {
				throw new AdempiereException("Please specify Kating Project!");
			}
		}
		return super.beforeSave(newRecord);
	}
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		if(newRecord && getDocStatus().equals(DOCSTATUS_Completed)) {
			processIt(DocAction.ACTION_Complete);
		}
		TF_MProject proj = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());		
		proj.updateQtyProcessed();
		proj.saveEx();
		
		return super.afterSave(newRecord, success);
	}
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			TF_MProject proj = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());
			MSubcontractType subconType = new MSubcontractType(getCtx(), proj.getTF_SubcontractType_ID(), get_TrxName());
			
			if(!proj.isSOTrx()) {
				createSubcontractPurchaseEntry();
				DB.executeUpdate("UPDATE TF_KatingEntry SET Processed='Y' WHERE TF_KatingEntry_ID ="
						+ getTF_KatingEntry_ID() , get_TrxName());
				return;
			}
			
			int unbilledJobworkAcct = subconType.getUnbilledKatingJobworkAcct_ID();
			int unbilledJobworkReceivableAcct = subconType.getUnbillKatingReceivableAcct_ID();
			
			int m_C_DocTypeTarget_ID = 1000000;						
			TF_MJournal j = new TF_MJournal(getCtx(), 0, get_TrxName());
			j.setDescription("Unbilled Kating Jobwork");
			j.setAD_Org_ID(getAD_Org_ID());
			j.setC_AcctSchema_ID(Env.getContextAsInt(getCtx(), "$C_AcctSchema_ID"));
			j.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
			j.setPostingType(TF_MJournal.POSTINGTYPE_Actual);
			j.setC_DocType_ID(m_C_DocTypeTarget_ID);
			j.setDateDoc(getDateAcct());
			j.setDateAcct(getDateAcct());
			j.setDocStatus(TF_MJournal.DOCSTATUS_Drafted);
			MPeriod period = MPeriod.get(getCtx(), getDateAcct());
			j.setC_Period_ID(period.getC_Period_ID());
			j.setGL_Category_ID(1000000);
			j.setC_ConversionType_ID(114);
			j.setC_Project_ID(getC_Project_ID());
			j.saveEx();
						
			BigDecimal Amt = getTonnage().multiply(getPrice());
			
			String desc = getDocumentNo() +  " | Tonnage: " + getTonnage() + ", Price: " + getPrice();
			if(getDescription() != null && getDescription().length() > 0) {
				desc = desc + " | " + getDescription();
			}
			
			//Debit Unbilled Jobwork Receivable
			MJournalLine jl;			
			jl = new MJournalLine(j);
			jl.setLine(10);			
			jl.setAccount_ID(unbilledJobworkReceivableAcct);
			jl.setM_Product_ID(getM_Product_ID());
			jl.setC_BPartner_ID(proj.getC_BPartner_ID());
			jl.setQty(getTonnage());
			jl.setC_UOM_ID(proj.getC_UOM_ID());
			jl.setDescription(desc);
			jl.setAmtSourceDr(Amt);
			jl.setAmtAcctDr(Amt);
			jl.setIsGenerated(true);
			jl.saveEx();
			
			
			//Credit Unbilled Jobwork						
			jl = new MJournalLine(j);
			jl.setLine(20);			
			jl.setAccount_ID(unbilledJobworkAcct);
			jl.setM_Product_ID(getM_Product_ID());
			jl.setC_BPartner_ID(proj.getC_BPartner_ID());
			jl.setQty(getTonnage());
			jl.setC_UOM_ID(proj.getC_UOM_ID());
			jl.setDescription(desc);
			jl.setAmtSourceCr(Amt);
			jl.setAmtAcctCr(Amt);
			jl.setIsGenerated(true);
			jl.saveEx();
			
			//DocAction
			if (!j.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
			j.saveEx();
				
			DB.executeUpdate("UPDATE TF_KatingEntry SET Processed='Y', GL_Journal_ID=" + j.getGL_Journal_ID() + " WHERE TF_KatingEntry_ID ="
					+ getTF_KatingEntry_ID() , get_TrxName());
					
		}
	}
	
	public void reverseIt() {
		if(getGL_Journal_ID() > 0) {
			TF_MJournal j = new TF_MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
			if(j.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!j.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
				j.saveEx();
			}
			DB.executeUpdate("UPDATE TF_KatingEntry SET GL_Journal_ID=NULL  WHERE TF_KatingEntry_ID ="
					+ getTF_KatingEntry_ID() , get_TrxName());
		}
		
		if(getSubcon_Invoice_ID() > 0) {			
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getSubcon_Invoice_ID(), get_TrxName());
			if(inv.getDocStatus().equals(DOCSTATUS_Completed)) {
				inv.reverseCorrectIt();
				inv.saveEx();
			}
			MSubcontractMaterialMovement.deleteInvoiceMovement(inv.getC_Invoice_ID(), get_TrxName());
			setSubcon_Invoice_ID(0);
			TF_MProject proj = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());
			proj.updateQtyBilled();
			proj.saveEx();
		}
		if(getSubcon_Receipt_ID() > 0) {
			MInOut io = new MInOut(getCtx(), getSubcon_Receipt_ID(), get_TrxName());
			if(io.getDocStatus().equals(DOCSTATUS_Completed)) {
				io.reverseCorrectIt();
				io.saveEx();
			}
			setSubcon_Receipt_ID(0);
		}
		
		setProcessed(false);
		setDocStatus(DOCSTATUS_InProgress);		
	}

	public void createSubcontractPurchaseEntry() {
		if(getC_Project_ID() == 0)
			return;
				
		TF_MProject proj = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());
		if(!TF_MProject.SUBCONTRACTTYPE_SandMining.equals(proj.getSubcontractType()) )
			return;
		
		MSubcontractType st = new MSubcontractType(getCtx(), proj.getTF_SubcontractType_ID(), get_TrxName());
		
		//Do not create invoice from Kating
		if(!st.isCreateInvFromKating())
			return;
				
		int priceItem_Id = proj.getJobWork_Product_ID();
		
		//Crusher Production Subcontract Purchase		
		BigDecimal purchasePrice = MJobworkProductPrice.getPrice(getCtx(), getC_Project_ID(), priceItem_Id, getDateAcct()) ;		
		
		if(purchasePrice == null)
			throw new AdempiereException("Please setup Contract Price for " + getM_Product().getName() + "!");
		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), proj.getC_BPartner_ID(), get_TrxName());
		
		//Invoice Header
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(1000005);	// AP Invoice		
		invoice.setDateInvoiced(getDateAcct());
		invoice.setDateAcct(getDateAcct());
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));		
		//
		
		invoice.setBPartner(bp);
		invoice.setIsSOTrx(false);		
		invoice.setVehicleNo(getTF_RentedVehicle().getVehicleNo());		
		invoice.setDescription("(" + getDocumentNo() + ")");
		
		//Price List
		int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
		if(bp.getPO_PriceList_ID() > 0)
			m_M_PriceList_ID = bp.getPO_PriceList_ID();			
		invoice.setM_PriceList_ID(m_M_PriceList_ID);
		invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		
		//Financial Dimension - Profit Center		
		invoice.setC_Project_ID(getC_Project_ID());
		
		invoice.saveEx();
		//End Invoice Header
		
		//Invoice Line - Item1
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		invLine.setM_Product_ID(getM_Product_ID() , true);
		invLine.setQty(getTonnage());					
		invLine.setPriceActual(purchasePrice);
		invLine.setPriceList(purchasePrice);
		invLine.setPriceLimit(purchasePrice);
		invLine.setPriceEntered(purchasePrice);		
		invLine.setC_Tax_ID(1000000);		
				
		//MM Receipt
		if(st.isCreateMRFromSales()) {
			MInOut inout = new MInOut(invoice, 1000014, getDateAcct(), proj.getM_Warehouse_ID());
			inout.setDescription(invoice.getDescription());
			inout.setMovementType(MInOut.MOVEMENTTYPE_VendorReceipts);
			inout.saveEx(get_TrxName());
			
			//Material Receipt Line - Item 1
			MInOutLine ioLine = new MInOutLine(inout);
			MWarehouse wh = (MWarehouse) proj.getM_Warehouse();
			ioLine.setInvoiceLine(invLine, wh.getDefaultLocator().get_ID(), getTonnage());
			ioLine.setQty(getTonnage());
			ioLine.saveEx(get_TrxName());
			
			//Material Receipt DocAction
			if (!inout.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
			inout.saveEx();
			//End DocAction
			
			invLine.setM_InOutLine_ID(ioLine.getM_InOutLine_ID());
			invLine.saveEx();
									
			setSubcon_Receipt_ID(inout.getM_InOut_ID());
			DB.executeUpdate("UPDATE TF_KatingEntry SET Subcon_Receipt_ID="+ getSubcon_Receipt_ID() +"  WHERE TF_KatingEntry_ID ="
					+ getTF_KatingEntry_ID() , get_TrxName());
		}
		
		//Invoice DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		//End DocAction
				
		setSubcon_Invoice_ID(invoice.getC_Invoice_ID());
		DB.executeUpdate("UPDATE TF_KatingEntry SET Subcon_Invoice_ID="+ getSubcon_Invoice_ID() +"  WHERE TF_KatingEntry_ID ="
				+ getTF_KatingEntry_ID() , get_TrxName());
		
		proj.updateQtyBilled();
		proj.saveEx();
				
	}
}
