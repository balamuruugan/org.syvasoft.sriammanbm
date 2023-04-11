package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBPartner;
import org.compiere.model.MClient;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MTyreRebuttonReceipt extends X_TF_Tyre_RBReceipt {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6889140455405444961L;

	public MTyreRebuttonReceipt(Properties ctx, int TF_Tyre_RBReceipt_ID,
			String trxName) {
		super(ctx, TF_Tyre_RBReceipt_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyreRebuttonReceipt(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			setGrandTotal(getGSTAmount());
		}
		return super.beforeSave(newRecord);
	}

	public static void calcTotalAmount(Properties ctx, int TF_Tyre_RBReceipt_ID, String trxName) {
		String sql = "SELECT SUM(LineTotalAmt) FROM TF_Tyre_RBReceiptLine WHERE TF_Tyre_RBReceipt_ID = " + TF_Tyre_RBReceipt_ID;
		BigDecimal total = DB.getSQLValueBD(trxName, sql);
		if(total == null)
			total = BigDecimal.ZERO;
		
		sql = "SELECT SUM(GSTAmount) FROM TF_Tyre_RBReceiptLine WHERE TF_Tyre_RBReceipt_ID = " + TF_Tyre_RBReceipt_ID;
		BigDecimal gstAmount = DB.getSQLValueBD(trxName, sql);
		if(gstAmount == null)
			gstAmount = BigDecimal.ZERO;
		
		sql = "UPDATE TF_Tyre_RBReceipt SET GrandTotal =  " + total.doubleValue() + 
				", GSTAmount = "+ gstAmount.doubleValue() +" WHERE TF_Tyre_RBReceipt_ID = " + TF_Tyre_RBReceipt_ID;
		DB.executeUpdate(sql, trxName);
	}
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		calcTotalAmount(getCtx(), getTF_Tyre_RBReceipt_ID(), get_TrxName());
		return super.afterSave(newRecord, success);
	}

	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			createPurchaseInvoice();
		}
	}
	public void reverseIt() {			
		if(getC_Invoice_ID() > 0) {
			
			List<MTyreRebuttonReceiptLine> rbLines = new Query(getCtx(), MTyreRebuttonReceiptLine.Table_Name, 
					"TF_Tyre_RBReceipt_ID =?", get_TrxName())
			.setClient_ID()
			.setParameters(getTF_Tyre_RBReceipt_ID())
			.setOrderBy("Line")
			.list();
			
			for(MTyreRebuttonReceiptLine rbLine : rbLines) {
				//Update Receipt Line
				rbLine.setProcessed(false);
				rbLine.saveEx();
				
				//Update Delivery Line
				MTyreRebuttonDeliveryLine dLine = (MTyreRebuttonDeliveryLine) rbLine.getTF_Tyre_RBDeliveryLine();
				dLine.setRebuttonReceiptLine(0);
				dLine.saveEx(get_TrxName());
				
				//Update Tyre
				MTyre tyre = (MTyre) rbLine.getTF_Tyre_RBDeliveryLine().getTF_Tyre();
				tyre.setCurrent_TyreType_ID(dLine.getTF_TyreType_ID());
				tyre.setTF_TyreStatus_ID(MTyreStatus.SENT_TO_REBUTTON);
				tyre.saveEx(get_TrxName());
				
				//Update Tyre Life
				MTyreLife tyreLife = MTyreLife.getTyreLife(tyre.getTF_Tyre_ID(), rbLine.getTF_TyreType_ID(), get_TrxName());
				//tyreLife.setTyreCost(BigDecimal.ZERO);
				if(rbLine.getTF_Tyre_RBReceiptLine_ID() == tyreLife.getTF_Tyre_RBReceiptLine_ID())
					tyreLife.setTF_Tyre_RBReceiptLine_ID(0);
				tyreLife.saveEx();
			}
			
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getC_Invoice_ID(), get_TrxName());
			if(inv.getDocStatus().equals(DOCSTATUS_Completed))
				inv.reverseCorrectIt();
			inv.saveEx();			
		}
		setProcessed(false);
		setDocStatus(DOCSTATUS_InProgress);
		setC_Invoice_ID(0);
	}
	
	private void createPurchaseInvoice() {
		MGLPostingConfig config = MGLPostingConfig.getMGLPostingConfig(getCtx());
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		//invoice.setC_DocTypeTarget_ID(config.getC_DocTypePurchaseInvoice_ID());	// AP Invoice		
		invoice.setDateInvoiced(getDateAcct());
		invoice.setDateAcct(getDateAcct());
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
		
		MBPartner bp = new MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
		invoice.setBPartner(bp);
		invoice.setIsSOTrx(false);
		
		String description = "Tyre Rebutton Receipt : " + getDocumentNo();
		invoice.setDescription(description);
		if(getDescription() != null)
			invoice.addDescription(getDescription());
		
		int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
		if(bp.getPO_PriceList_ID() > 0)
			m_M_PriceList_ID = bp.getPO_PriceList_ID();
		if(m_M_PriceList_ID == 0) {
			MPriceList pl = new Query(getCtx(), MPriceList.Table_Name, "IsDefault='Y' AND IsActive='Y'", get_TrxName())
					.setClient_ID().first();
			if(pl != null)
				m_M_PriceList_ID = pl.getM_PriceList_ID();
		}
		invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		if(invoice.getC_Currency_ID() == 0)
			invoice.setC_Currency_ID(MClient.get(Env.getCtx()).getC_Currency_ID());
		
				
		invoice.saveEx();
		
		MInvoiceLine invLine = null;
		
		List<MTyreRebuttonReceiptLine> rbLines = new Query(getCtx(), MTyreRebuttonReceiptLine.Table_Name, "TF_Tyre_RBReceipt_ID =?", get_TrxName())
			.setClient_ID()
			.setParameters(getTF_Tyre_RBReceipt_ID())
			.setOrderBy("Line")
			.list();
		
		for(MTyreRebuttonReceiptLine rbLine : rbLines) {
			
			invLine = new MInvoiceLine(invoice);
			TF_MCharge ch = TF_MCharge.createChargeFromAccount(getCtx(),config.getIncentiveAcct_ID() , null);
			invLine.setC_Charge_ID(ch.getC_Charge_ID());
			invLine.setQty(BigDecimal.ONE);
			MTyre tyre = (MTyre) rbLine.getTF_Tyre_RBDeliveryLine().getTF_Tyre();
			description = "Tyre No: " + tyre.getTyreNo() + " - Brand: " + tyre.getBrand() +
					" - Size: " + tyre.getSize();
			invLine.setDescription(description);
			
			BigDecimal price = rbLine.getPrice();
			
			invLine.setPriceActual(price);
			invLine.setPriceList(price);
			invLine.setPriceLimit(price);
			invLine.setPriceEntered(price);						
			invLine.setC_Tax_ID(1000000);		
			
			invLine.saveEx();
			
			
			//Update Receipt Line
			rbLine.setProcessed(true);
			rbLine.saveEx();
			
			//Update Tyre Master
			tyre.setCurrent_TyreType_ID(rbLine.getTF_TyreType_ID());
			tyre.setTF_TyreStatus_ID(MTyreStatus.IN_STOCK);
			tyre.saveEx(get_TrxName());
			
			//Tyre Life			
			MTyreLife tLife = MTyreLife.getTyreLife(tyre.getTF_Tyre_ID(), rbLine.getTF_TyreType_ID(), get_TrxName());
			tLife.setTyreCost(rbLine.getLineTotalAmt());
			tLife.setTF_Tyre_RBReceiptLine_ID(rbLine.getTF_Tyre_RBReceiptLine_ID());
			tLife.saveEx();
			
			//Update Delivery Line
			MTyreRebuttonDeliveryLine dLine = (MTyreRebuttonDeliveryLine) rbLine.getTF_Tyre_RBDeliveryLine();
			dLine.setRebuttonReceiptLine(rbLine.getTF_Tyre_RBReceiptLine_ID());
			dLine.saveEx(get_TrxName());
			
		}
		
		if(getGSTAmount().doubleValue() > 0) {
			invLine = new MInvoiceLine(invoice);			
			invLine.setC_Charge_ID(config.getIncentiveAcct_ID());
			invLine.setQty(BigDecimal.ONE);			
			
			BigDecimal price = getGSTAmount();
			
			invLine.setPriceActual(price);
			invLine.setPriceList(price);
			invLine.setPriceLimit(price);
			invLine.setPriceEntered(price);						
			invLine.setC_Tax_ID(1000000);		
			
			invLine.saveEx();
		}
		
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		//End DocAction
		
		setC_Invoice_ID(invoice.getC_Invoice_ID());
		
		
	}
	
}
