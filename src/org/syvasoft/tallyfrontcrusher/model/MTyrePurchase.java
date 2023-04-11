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

public class MTyrePurchase extends X_TF_TyrePurchase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5088402226363379288L;

	public MTyrePurchase(Properties ctx, int TF_TyrePurchase_ID, String trxName) {
		super(ctx, TF_TyrePurchase_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyrePurchase(Properties ctx, ResultSet rs, String trxName) {
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

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		calcTotalAmount(getCtx(), getTF_TyrePurchase_ID(), get_TrxName());
		return super.afterSave(newRecord, success);
	}

	public static void calcTotalAmount(Properties ctx, int TF_TyrePurchase_ID, String trxName) {
		String sql = "SELECT SUM(LineTotalAmt) FROM TF_TyrePurchaseLine WHERE TF_TyrePurchase_ID = " + TF_TyrePurchase_ID;
		BigDecimal total = DB.getSQLValueBD(trxName, sql);		
		if(total == null)
			total = BigDecimal.ZERO;
		
		sql = "SELECT SUM(GSTAmount) FROM TF_TyrePurchaseLine WHERE TF_TyrePurchase_ID = " + TF_TyrePurchase_ID;
		BigDecimal gstAmount = DB.getSQLValueBD(trxName, sql);
		if(gstAmount == null)
			gstAmount = BigDecimal.ZERO;
		
		sql = "UPDATE TF_TyrePurchase SET GrandTotal = " + total.doubleValue() + 
				", GSTAmount = "+ gstAmount.doubleValue() +" WHERE TF_TyrePurchase_ID = " + TF_TyrePurchase_ID;
		DB.executeUpdate(sql, trxName);
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
			
			MTyre.deleteTyres(this);
			
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
		
		String description = "Tyre Purchase : " + getDocumentNo();
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
		
		//Invoice Line - Tyre
		
		List<MTyrePurchaseLine> tyrePOLines = new Query(getCtx(), MTyrePurchaseLine.Table_Name, "TF_TyrePurchase_ID=?", get_TrxName())
			.setClient_ID()
			.setParameters(getTF_TyrePurchase_ID())
			.setOrderBy("LineNo")
			.list();
		
		for(MTyrePurchaseLine tyrePOLine : tyrePOLines) {
			
			MTyre tyre = MTyre.createTyre(this, tyrePOLine);
			
			invLine = new MInvoiceLine(invoice);
			TF_MCharge ch = TF_MCharge.createChargeFromAccount(getCtx(),config.getIncentiveAcct_ID() , null);
			//TF_MCharge ch = TF_MCharge.createChargeFromAccount(getCtx(),config.getTyrePurchaseAcct_ID() , null);
			invLine.setC_Charge_ID(ch.getC_Charge_ID());
			invLine.setQty(BigDecimal.ONE);
			description = "Tyre No: " + tyre.getTyreNo() + " - Brand: " + tyre.getBrand() +
					" - Size: " + tyre.getSize();
			invLine.setDescription(description);
			
			BigDecimal price = tyrePOLine.getPrice();
			
			invLine.setPriceActual(price);
			invLine.setPriceList(price);
			invLine.setPriceLimit(price);
			invLine.setPriceEntered(price);						
			invLine.setC_Tax_ID(1000000);		
			
			invLine.saveEx();
			
		}
		
		if(getGSTAmount().doubleValue() > 0) {
			invLine = new MInvoiceLine(invoice);
			invLine.setC_Charge_ID(config.getIncentiveAcct_ID());
			//invLine.setC_Charge_ID(config.getC_ChargeGSTAmt_ID());
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
