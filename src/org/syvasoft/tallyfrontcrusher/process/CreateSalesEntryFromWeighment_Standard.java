package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.sql.Savepoint;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.editor.WNumberEditor;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MNote;
import org.compiere.model.MOrderLine;
import org.compiere.model.MPriceList;
import org.compiere.model.MProduct;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;
import org.compiere.util.Trx;
import org.syvasoft.tallyfrontcrusher.model.MDestination;
import org.syvasoft.tallyfrontcrusher.model.MLumpSumRentConfig;
import org.syvasoft.tallyfrontcrusher.model.MPriceListUOM;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoice;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrderLine;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class CreateSalesEntryFromWeighment_Standard extends SvrProcess {
	
	Savepoint sp = null;
	/*
	private Timestamp DateFrom = null;
	private Timestamp DateTo = null;
	*/		
	private int RecordId = 0;
	private Timestamp DateAcct = null;
	private boolean IsInfo = false;
	@Override
	protected void prepare() {
		
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
		
			if(name.equals("DateAcct"))
				DateAcct = para[i].getParameterAsTimestamp();
			if(name.equals("IsInfo"))
				IsInfo = para[i].getParameterAsBoolean();
		}
		
		RecordId = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		
		String whereClause = "";
		List<MWeighmentEntry> wEntries;
		
		if(RecordId > 0) {
			whereClause =" WeighmentEntryType = '1SO' AND (TF_WeighmentEntry_ID = ? AND TF_WeighmentEntry.Status IN ('UR','CO','P')) ";
			wEntries = new Query(getCtx(), MWeighmentEntry.Table_Name, whereClause, get_TrxName())
					.setClient_ID()
					.setParameters(RecordId)
					.list();
		}
		else {
			if(IsInfo) {
				whereClause =" WeighmentEntryType = '1SO' AND ((TF_WeighmentEntry.Status IN ('UR','CO','ER') AND (SELECT OrgType FROM AD_Org WHERE "				
						+ "AD_Org.AD_Org_ID = TF_WeighmentEntry.AD_Org_ID) = 'C' AND (EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE  " + 
						" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = TF_WeighmentEntry.TF_WeighmentEntry_ID)) "
						+ " AND NOT EXISTS(SELECT C_Order.TF_WeighmentEntry_ID FROM C_Order WHERE "
						+ "C_Order.TF_WeighmentEntry_ID =  TF_WeighmentEntry.TF_WeighmentEntry_ID AND C_Order.DocStatus <> 'VO')))";
				wEntries = new Query(getCtx(), MWeighmentEntry.Table_Name, whereClause, get_TrxName())
						.setClient_ID()
						.setParameters(getAD_PInstance_ID()).setOrderBy("GrossWeightTime")
						.list();
				
				String whereInnerClause =" WeighmentEntryType = '1SO' AND DateAcct > ? AND ((TF_WeighmentEntry.Status IN ('UR','CO','ER') AND (SELECT OrgType FROM AD_Org WHERE "				
						+ "AD_Org.AD_Org_ID = TF_WeighmentEntry.AD_Org_ID) = 'C' AND (EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE  " + 
						" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = TF_WeighmentEntry.TF_WeighmentEntry_ID)) "
						+ " AND NOT EXISTS(SELECT C_Order.TF_WeighmentEntry_ID FROM C_Order WHERE "
						+ "C_Order.TF_WeighmentEntry_ID =  TF_WeighmentEntry.TF_WeighmentEntry_ID AND C_Order.DocStatus <> 'VO')))";
				
				MWeighmentEntry wEntry = new Query(getCtx(), MWeighmentEntry.Table_Name, whereInnerClause, get_TrxName())
						.setClient_ID()
						.setParameters(DateAcct, getAD_PInstance_ID()).setOrderBy("GrossWeightTime")
						.first();
				
				if(wEntry != null) {
					throw new AdempiereException("The given Acctout Date should be greater than equal to Weighment Account Date");
				}
			}
			else {
				whereClause =" WeighmentEntryType = '1SO' AND IsRequiredTaxInvoicePerLoad = 'Y' AND ((TF_WeighmentEntry.Status IN ('CO','P') AND (SELECT OrgType FROM AD_Org WHERE "				
						+ "AD_Org.AD_Org_ID = TF_WeighmentEntry.AD_Org_ID) = 'C' "
						//+ " AND (EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE  " + 
						//" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = TF_WeighmentEntry.TF_WeighmentEntry_ID)) "
						+ " AND NOT EXISTS(SELECT C_Order.TF_WeighmentEntry_ID FROM C_Order WHERE "
						+ "C_Order.TF_WeighmentEntry_ID =  TF_WeighmentEntry.TF_WeighmentEntry_ID AND C_Order.DocStatus <> 'VO')))";
				
				wEntries = new Query(getCtx(), MWeighmentEntry.Table_Name, whereClause, get_TrxName())
						.setClient_ID()
						//.setParameters(getAD_PInstance_ID())
						.setOrderBy("GrossWeightTime")
						.list();
			}
		}
		
		//+ "AND C_Order.DocStatus IN ('CO','DR','IR'))";
		int i = 0;
		
		for(MWeighmentEntry wEntry : wEntries) {
			if(wEntry.getDescription() != null && wEntry.getDescription().contains("ERROR:")) {
				addLog(wEntry.get_Table_ID(), wEntry.getGrossWeightTime(), null, wEntry.getDescription(), wEntry.get_Table_ID(), wEntry.get_ID());
				continue;
			}
			
			if(wEntry.getPaymentRule().equals(MWeighmentEntry.PAYMENTRULE_MixedPayment) &&
					wEntry.getSalesTotalAmount().subtract(wEntry.getTotalMixedPayment()).abs().doubleValue() >= 1) {
//				wEntry.setDescription("ERROR: " + "Invalid Mixed Payment Total");;
				wEntry.setStatus(MWeighmentEntry.STATUS_Pending);
				wEntry.saveEx();
				
				addLog(wEntry.get_Table_ID(), wEntry.getGrossWeightTime(), null, "Invalid Mixed Payment Total", wEntry.get_Table_ID(), wEntry.get_ID());				
				continue;
			}
			
			Trx trx = Trx.get(get_TrxName(), false);
			
			if(wEntry.getStatus().equals(MWeighmentEntry.STATUS_UnderReview)) {
				wEntry.setStatus(MWeighmentEntry.STATUS_Unbilled);
				wEntry.saveEx();
			}
			
			try {
				
				String msg = null;
				//if(wEntry.getInvoiceNo() == null) 
				{
					/*String checkValidation = " AD_Org_ID = ? AND WeighmentEntryType = '1SO' AND Status IN ('ER','IP','UR','CO') AND InvoiceNo IS NULL AND GrossWeightTime < ?";
					
					List<MWeighmentEntry> prevEntries = new Query(getCtx(), MWeighmentEntry.Table_Name, checkValidation, get_TrxName())
							.setClient_ID()
							.setParameters(wEntry.getAD_Org_ID(), wEntry.getGrossWeightTime())
							.list();					
					
					if(prevEntries.size() > 0) {
						msg = wEntry.getDocumentNo() +  " : DC cannot be converted as invoice before Old DCs converted as invoice!";
						addLog(wEntry.get_Table_ID(), wEntry.getGrossWeightTime(), null, msg, wEntry.get_Table_ID(), wEntry.get_ID());
						continue;
					}*/					
				}
								
				if(wEntry.getPrice().doubleValue() == 0) {
					msg = wEntry.getDocumentNo() +  " : Material Price not Set!";
					addLog(wEntry.get_Table_ID(), wEntry.getGrossWeightTime(), null, msg, wEntry.get_Table_ID(), wEntry.get_ID());
					continue;
				}
				
				if(!IsInfo) {
					if(!wEntry.isRequiredTaxInvoicePerLoad())
						continue;
				}
				{
					BigDecimal billQty = wEntry.getNetWeightUnit();
					
					if(wEntry.getC_OrderLine_ID() == 0)
						createSalesQuickEntry(wEntry, billQty, true, trx);
					else
						createInvoiceCustomer(wEntry, billQty, true, trx);
					
					//if(MSysConfig.getValue("INCLUDE_PASS_AMOUNT_IN_INVOICE", wEntry.getAD_Client_ID(), wEntry.getAD_Org_ID()).equals("N")) {
					if((!wEntry.isIncludePassAmtInvoice() && !wEntry.isRoyaltyPassInclusive() && wEntry.getPermitPassAmount().doubleValue()>0   )
							|| 
						(!wEntry.isIncludeRentAmtInvoice() && !wEntry.isRentInclusive())	
						) {
						if(wEntry.getPermitPassAmount().doubleValue() > 0 || wEntry.getRent_Amt().doubleValue() > 0) {
							createSalesQuickEntryForRoyaltyPass(wEntry, wEntry.getPermitIssuedQty(), true, trx);
						}
					}
				}
				i++;
			}
			catch (Exception ex) {
				try {
				if(sp != null)
					trx.rollback(sp);
				}
				catch(Exception e) {
					
				}
				if(!ex.getMessage().contains("Current Invoice Date : ")) {
					String desc = wEntry.getDescription();
					if(desc == null)
						desc = "";
					if(!desc.contains("ERROR:")) {
						wEntry.setDescription(desc + 
								" | ERROR: " + ex.getMessage());					
					}			
					wEntry.setStatus(MWeighmentEntry.STATUS_Error);
					wEntry.saveEx();					
				}
				//throw new AdempiereException(ex);
				addLog(wEntry.get_Table_ID(), wEntry.getGrossWeightTime(), null, ex.getMessage(), wEntry.get_Table_ID(), wEntry.get_ID());
			}
		}
		return i + " Weighment Entries are processed!";
	}
	
	
	private void createSalesQuickEntry(MWeighmentEntry wEntry, BigDecimal billedQty, boolean firstInvoice, Trx trx) throws Exception {
		TF_MOrder ord = new TF_MOrder(getCtx(), 0, get_TrxName());
		ord.firstInvoice = firstInvoice;
		ord.setAD_Org_ID(wEntry.getAD_Org_ID());
		ord.setC_DocType_ID(wEntry.getC_DocType_ID(wEntry.getWeighmentEntryType()));
		ord.setC_DocTypeTarget_ID(wEntry.getC_DocType_ID(wEntry.getWeighmentEntryType()));
		ord.setM_Warehouse_ID(wEntry.getM_Warehouse_ID());
		
		if(wEntry.isRequiredTaxInvoicePerLoad())
			DateAcct = wEntry.getGrossWeightTime();
		
		if(wEntry.getDateInvoiced() == null) {
			ord.setDateAcct(DateAcct);
			ord.setDateOrdered(DateAcct);
		}
		else {
			ord.setDateAcct(wEntry.getDateInvoiced());
			ord.setDateOrdered(wEntry.getDateInvoiced());
		}
		
		int C_BParner_ID = wEntry.getC_BPartner_ID();
		if(C_BParner_ID == 0)
			C_BParner_ID = 1000020;		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), C_BParner_ID, get_TrxName());
		ord.setBPartner(bp);
		ord.setPartyName(wEntry.getPartyName());
		ord.setPhone(wEntry.getPhone());
		ord.setDescription(wEntry.getDescription());
		if(wEntry.getPartyName() != null && bp.getIsPOSCashBP())
			ord.addDescription("Customer Name : " + wEntry.getPartyName());
		
		ord.setPaymentRule(wEntry.getPaymentRule());
		ord.setOnAccount(false);
		ord.setC_Project_ID(wEntry.getC_Project_ID());
		//Price List
		int m_M_PriceList_ID = MPriceList.getDefault(getCtx(), true).getM_PriceList_ID();							
		ord.setM_PriceList_ID(m_M_PriceList_ID);
		ord.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		ord.setIsSOTrx(true);
		ord.setTF_WeighmentEntry_ID(wEntry.getTF_WeighmentEntry_ID());	
		ord.setTF_Destination_ID(wEntry.getTF_Destination_ID());
		ord.setVehicleNo(wEntry.getVehicleNo());
		ord.setTF_RentedVehicle_ID(wEntry.getTF_RentedVehicle_ID());
		ord.setItem1_BucketQty(null);
		
		
		//Item
		ord.setItem1_IsPermitSales(wEntry.isHasBalance());
		ord.setItem1_VehicleType_ID(wEntry.getTF_VehicleType_ID());
		if(wEntry.isHasBalance())
			ord.setItem1_SandType(TF_MOrder.ITEM1_SANDTYPE_PermitSand);
		else
			ord.setItem1_SandType(TF_MOrder.ITEM1_SANDTYPE_WithoutPermit);
		ord.setItem1_ID(wEntry.getM_Product_ID());
				
		int uom_id = wEntry.getC_UOM_ID();
		if(uom_id == 0)
			uom_id = wEntry.getM_Product().getC_UOM_ID();
		
		ord.setItem1_UOM_ID(wEntry.getC_UOM_ID());
		ord.setItem1_Tax_ID(wEntry.getC_Tax_ID(ord.isReverseCharge()));
		BigDecimal qty = wEntry.getBilledQty();
		if(billedQty != null)
			qty = billedQty;
		
		if(qty.doubleValue() == 0)
			throw new AdempiereException("Invalid Billing Qty!");
		
		//BigDecimal qty = wEntry.getNetWeight();
		//if(uom_id == tonnage_uom_id)
		//	qty = qty.divide(new BigDecimal(1000));
		//else
		//	qty = wEntry.getNetWeightUnit();
		ord.setTonnage(qty);
		ord.setItem1_TotalLoad(BigDecimal.ONE);
		ord.setItem1_PermitIssued(wEntry.getPermitIssuedQty()); 
		ord.setMDPNo(wEntry.getMDPNo());
		ord.setItem1_Qty(qty);
		BigDecimal price = wEntry.getMaterialPriceIncludedRent();
		price = wEntry.getMaterialPriceIncludedRoyaltyPass(price);
		ord.setItem1_Price(price);
		ord.setItem1_UnitPrice(price);
		ord.setItem1_Amt(ord.getItem1_Qty().multiply(ord.getItem1_Price()));
			
		//Item2
		ord.setItem2_UOM_ID(ord.getItem2().getC_UOM_ID());
		ord.setItem2_Tax_ID(1000000);
		
		if(wEntry.getM_Product2() != null && wEntry.getM_Product2_ID()>0) {
			ord.setItem2_ID(wEntry.getM_Product2_ID());
			ord.setItem2_Qty(wEntry.getPermitIssuedQty());	
			ord.setItem2_UOM_ID(wEntry.getC_UOM_ID());
			ord.setItem2_Price(wEntry.getPassPricePerUnit());
			ord.setItem2_Amt(wEntry.getPermitPassAmount());
			ord.setItem2_Tax_ID(wEntry.getC_Tax_ID(ord.isReverseCharge()));
		}
		else {
			ord.setItem2_ID(0);
			ord.setItem2_Qty(BigDecimal.ZERO);
		}
				
		if(wEntry.getOtherCharges().doubleValue() > 0) {
			int OTHER_CHARGES_PRODUCT_ID =  MSysConfig.getIntValue("OTHER_CHARGES_PRODUCT_ID", 1015583, wEntry.getAD_Client_ID());
			TF_MProduct prod = new TF_MProduct(getCtx(), OTHER_CHARGES_PRODUCT_ID, get_TrxName());
			
			ord.setItem2_ID(OTHER_CHARGES_PRODUCT_ID);
			ord.setItem2_Qty(BigDecimal.ONE);	
			ord.setItem2_UOM_ID(prod.getC_UOM_ID());
			ord.setItem2_Price(wEntry.getOtherCharges());
			ord.setItem2_Amt(wEntry.getOtherCharges());		
			ord.setItem2_Tax_ID(wEntry.getC_Tax_ID(ord.isReverseCharge()));
		}
		
		ord.setRent_Amt(wEntry.getRent_Amt());										
		ord.setRentMargin(BigDecimal.ZERO);
		ord.setRentPayable(wEntry.getRent_Amt());
		
		ord.setIsRentBreakup(false);
		ord.setIsRentInclusive(true);			
		
		ord.setRent_Tax_ID(1000000);
		//ord.setRent_Amt(wEntry.getRent_Amt());
		ord.setSalesDiscountAmt(wEntry.getDiscountAmount());

		ord.setDriverTips(wEntry.getDriverTips());
		ord.setProcessed(false);		
		ord.setC_BankAccount_ID(wEntry.getC_BankAccount_ID());
		ord.setInvoiceNo(wEntry.getInvoiceNo());
		ord.saveEx();				
		
		sp = trx.setSavepoint(wEntry.getDocumentNo());
		ord.setDocAction(DocAction.ACTION_Complete);
		ord.completeIt();
		ord.setDocStatus(TF_MOrder.DOCSTATUS_Completed);
		ord.saveEx();
		
		//Assigning new generated invoices
		List<TF_MInvoice> invList = ord.getTFInvoices();
		if(invList.size() > 0) {
			if(firstInvoice && wEntry.getInvoiceNo() == null) {
				wEntry.setInvoiceNo(invList.get(0).getDocumentNo());				
			}
			else if(!firstInvoice & wEntry.getInvoiceNo2() == null) {
				wEntry.setInvoiceNo2(invList.get(0).getDocumentNo());				
			}
			wEntry.setDateInvoiced(invList.get(0).getDateInvoiced());
			wEntry.saveEx();
		}
		/*
		ord.setDocAction(DocAction.ACTION_Prepare);
		ord.setDocStatus(TF_MOrder.DOCSTATUS_Drafted);
		ord.saveEx();
		*/
		//String error = DocumentEngine.postImmediate(Env.getCtx(), ord.getAD_Client_ID(), ord.get_Table_ID(), ord.get_ID(), true, ord.get_TrxName());				
		//if (! Util.isEmpty(error)) {
		//		throw new AdempiereException(error);
		//}
		trx.releaseSavepoint(sp);
		addLog(ord.get_Table_ID(), ord.getCreated(), null, " Sales Entry : " + ord.getDocumentNo() + " is created!", ord.get_Table_ID(), ord.get_ID());
	}

	private void createInvoiceCustomer(MWeighmentEntry wEntry, BigDecimal billedQty,  boolean firstInvoice, Trx trx) throws Exception {
		
		
		MOrderLine oLine = (MOrderLine) wEntry.getC_OrderLine();
		int C_Order_ID = oLine.getC_Order_ID();
		TF_MOrder order = new TF_MOrder(getCtx(), C_Order_ID, get_TrxName());
				
		//Invoice Header
		TF_MBPartner bp = new TF_MBPartner(getCtx(), order.getC_BPartner_ID(), get_TrxName());
				
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setC_Order_ID(C_Order_ID);
		invoice.setClientOrg(getAD_Client_ID(), wEntry.getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(wEntry.getC_DocTypeInvoice_ID());
		invoice.setIsSOTrx(true);
		invoice.setDateInvoiced(wEntry.getGrossWeightTime());
		invoice.setDateAcct(wEntry.getGrossWeightTime());
		
		//fetching already generated invoice no in case of reversing and recreating the existing invoices.
		if(wEntry.getInvoiceNo() != null && bp.getIsPOSCashBP()) {
			invoice.setDocumentNo(wEntry.getInvoiceNo());
			
			if(invoice.getDocumentNo() == null)
				invoice.setDocumentNo(wEntry.getDocumentNo());
		}
		else
			invoice.setDocumentNo(wEntry.getDocumentNo());
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));	
		
		invoice.setC_PaymentTerm_ID(order.getC_PaymentTerm_ID());
		//
		invoice.setC_Project_ID(wEntry.getC_Project_ID());
		invoice.setBPartner(bp);				
		invoice.setPaymentRule(order.getPaymentRule());
		invoice.setVehicleNo(wEntry.getVehicleNo());
		invoice.setDescription(wEntry.getDescription());
		
		//Price List
				
		
		invoice.setM_PriceList_ID(order.getM_PriceList_ID());
		invoice.setC_Currency_ID(order.getC_Currency_ID());
		
		//Financial Dimension - Profit Center		
		//invoice.setC_Project_ID(counterProj.getC_Project_ID());
		invoice.setTF_WeighmentEntry_ID(wEntry.getTF_WeighmentEntry_ID());		
		invoice.saveEx();
				
		//Create Invoice Line		
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		int M_Product_ID = oLine.getM_Product_ID();
		invLine.setM_Product_ID(M_Product_ID , true);
		invLine.setC_UOM_ID(oLine.getC_UOM_ID());
		BigDecimal qty = wEntry.getBilledQty();
		if(billedQty != null)
			qty = billedQty;
		
		if(qty.doubleValue() == 0)
			throw new AdempiereException("Invalid Billing Qty!");
		
		invLine.setQty(qty);
		BigDecimal price = wEntry.getMaterialPriceIncludedRent();
		
		price = wEntry.getMaterialPriceIncludedRoyaltyPass(price);
		
		invLine.setPriceActual(price);
		invLine.setPriceList(price);
		invLine.setPriceLimit(price);
		invLine.setPriceEntered(price);		
		invLine.setC_Tax_ID(oLine.getC_Tax_ID());
		invLine.setDescription(oLine.getDescription());
		invLine.setC_Project_ID(order.getC_Project_ID());
		invLine.setC_OrderLine_ID(wEntry.getC_OrderLine_ID());
		if(oLine.getPriceEntered().doubleValue() == 0) {
			throw new AdempiereException("Invalid Price at Line: " + oLine.getLine() + " for Product Name : " + oLine.getM_Product().getName());
		}
		
		invLine.setM_InOutLine_ID(wEntry.getM_InOutLine_ID(invLine.getM_Product_ID()));
		
		invLine.saveEx();
				
		
		sp = trx.setSavepoint(wEntry.getDocumentNo());
		
		//Invoice DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		
		//Set generated Invoice Number for the future refernce
		if(firstInvoice && wEntry.getInvoiceNo() == null) {
			wEntry.setInvoiceNo(invoice.getDocumentNo());				
		}
		else if(!firstInvoice & wEntry.getInvoiceNo2() == null) {
			wEntry.setInvoiceNo2(invoice.getDocumentNo());				
		}
		
		wEntry.saveEx();
		
		trx.releaseSavepoint(sp);
		addLog(invoice.get_Table_ID(), invoice.getCreated(), null, " Invoice No : " +  invoice.getDocumentNo() + " is created!", invoice.get_Table_ID(), invoice.get_ID());
	}	
	
	private void createSalesQuickEntryForRoyaltyPass(MWeighmentEntry wEntry, BigDecimal billedQty, boolean firstInvoice, Trx trx) throws Exception {
		TF_MOrder ord = new TF_MOrder(getCtx(), 0, get_TrxName());
		ord.firstInvoice = firstInvoice;
		ord.setAD_Org_ID(wEntry.getAD_Org_ID());
		ord.setC_DocType_ID(wEntry.getRoyaltyPass_DocType_ID());
		ord.setC_DocTypeTarget_ID(wEntry.getRoyaltyPass_DocType_ID());
		ord.setM_Warehouse_ID(wEntry.getM_Warehouse_ID());
		ord.setDateAcct(wEntry.getGrossWeightTime());
		ord.setDateOrdered(wEntry.getGrossWeightTime());
		int C_BParner_ID = wEntry.getC_BPartner_ID();
		if(C_BParner_ID == 0)
			C_BParner_ID = 1000020;		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), C_BParner_ID, get_TrxName());
		ord.setBPartner(bp);
		ord.setPartyName(wEntry.getPartyName());
		ord.setPhone(wEntry.getPhone());
		ord.setDescription(wEntry.getDescription());
		if(wEntry.getPartyName() != null && bp.getIsPOSCashBP())
			ord.addDescription("Customer Name : " + wEntry.getPartyName());
		
		ord.setPaymentRule(wEntry.getPaymentRule());
		ord.setOnAccount(false);

		//Price List
		int m_M_PriceList_ID = MPriceList.getDefault(getCtx(), true).getM_PriceList_ID();							
		ord.setM_PriceList_ID(m_M_PriceList_ID);
		ord.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		ord.setIsSOTrx(true);
		ord.setTF_WeighmentEntry_ID(wEntry.getTF_WeighmentEntry_ID());	
		ord.setTF_Destination_ID(wEntry.getTF_Destination_ID());
		ord.setVehicleNo(wEntry.getVehicleNo());
		ord.setTF_RentedVehicle_ID(wEntry.getTF_RentedVehicle_ID());
	
		ord.setProcessed(false);		
		ord.saveEx();	
		if(wEntry.getRent_Amt().doubleValue() > 0 && (!wEntry.isIncludeRentAmtInvoice() && !wEntry.isRentInclusive()))
		{
			int Load_UOM_ID = MSysConfig.getIntValue("LOAD_UOM", 1000072, wEntry.getAD_Client_ID());
			int MT_UOM = MSysConfig.getIntValue("MT_UOM", 1000069, wEntry.getAD_Client_ID());
			int KM_UOM_ID = MSysConfig.getIntValue("KM_UOM", 1000071, wEntry.getAD_Client_ID());
			int MT_KM_UOM_ID = MSysConfig.getIntValue("MT_KM_UOM", 1000071, wEntry.getAD_Client_ID());
			MDestination dest = new MDestination(getCtx(), wEntry.getTF_Destination_ID(), get_TrxName());
			
			BigDecimal qty = BigDecimal.ZERO;
			BigDecimal price = BigDecimal.ZERO;
			BigDecimal RateMTKM = BigDecimal.ZERO;
			
			if(!wEntry.isRentInclusive()) {
				price = wEntry.getFreightPrice();
				if(wEntry.getFreightRule_ID() == Load_UOM_ID)
				{
					qty = BigDecimal.ONE;							
				}
				else if(wEntry.getFreightRule_ID() == KM_UOM_ID)
				{
					qty = dest.getDistance();							
				}
				else if(wEntry.getFreightRule_ID() == MT_KM_UOM_ID)
				{
					qty = wEntry.getMT().multiply(dest.getDistance()).setScale(2, RoundingMode.HALF_EVEN);;
				}
				else if(wEntry.getFreightRule_ID() == MT_UOM)
				{
					qty = wEntry.getMT();		
				}
				else
				{
					qty = wEntry.getNetWeightUnit();							
				}
			}
			
			MRentedVehicle rentedvehicle = new MRentedVehicle(getCtx(), wEntry.getTF_RentedVehicle_ID(), get_TrxName());
			TF_MOrderLine ordLine = new TF_MOrderLine(ord);
			ordLine.setM_Product_ID(rentedvehicle.getM_Product_ID(), true);
			ordLine.setC_UOM_ID(wEntry.getFreightRule_ID());								
			ordLine.setQty(qty);
			ordLine.setPriceActual(wEntry.getFreightPrice());
			ordLine.setPriceList(wEntry.getFreightPrice());
			ordLine.setPriceLimit(wEntry.getFreightPrice());
			ordLine.setPriceEntered(wEntry.getFreightPrice());
			ordLine.setC_Order_ID(ord.getC_Order_ID());
			TF_MProduct prod = new TF_MProduct(getCtx(), rentedvehicle.getM_Product_ID(), get_TrxName());
			ordLine.setC_Tax_ID(1000000);
			ordLine.saveEx();
		}
		
		if(wEntry.getPermitPassAmount().doubleValue() > 0 && (!wEntry.isIncludePassAmtInvoice() && !wEntry.isRoyaltyPassInclusive()))
		{
			TF_MProduct product = new TF_MProduct(getCtx(),wEntry.getM_Product_Pass_ID(),get_TrxName());
			
			int uom_id = product.getC_UOM_ID();
			
			TF_MOrderLine ordLine = new TF_MOrderLine(ord);
			ordLine.setM_Product_ID(wEntry.getM_Product_Pass_ID(), true);
			ordLine.setC_UOM_ID(uom_id);								
			
			BigDecimal price = wEntry.getPassPricePerUnit();
			BigDecimal qty = wEntry.getPermitIssuedQty();
			
			if(qty.doubleValue() == 0)
				throw new AdempiereException("Invalid Billing Qty!");
			
			ordLine.setQty(qty);
			ordLine.setPriceActual(price);
			ordLine.setPriceList(price);
			ordLine.setPriceLimit(price);
			ordLine.setPriceEntered(price);
			ordLine.setC_Order_ID(ord.getC_Order_ID());
			ordLine.setC_Tax_ID(1000000);
			ordLine.saveEx();
		}		
	
					
		
		sp = trx.setSavepoint(wEntry.getDocumentNo());
		ord.setDocAction(DocAction.ACTION_Complete);
		ord.completeIt();
		ord.setDocStatus(TF_MOrder.DOCSTATUS_Completed);
		ord.saveEx();
		
	
		trx.releaseSavepoint(sp);
		addLog(ord.get_Table_ID(), ord.getCreated(), null, " Sales Entry : " + ord.getDocumentNo() + " is created!", ord.get_Table_ID(), ord.get_ID());
	}
	
}
