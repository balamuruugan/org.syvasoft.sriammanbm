package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MInvoice;
import org.compiere.util.DB;

public class MTRTaxInvoiceLine extends X_TF_TRTaxInvoiceLine {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7092237924258680168L;

	public MTRTaxInvoiceLine(Properties ctx, int TF_TRTaxInvoiceLine_ID, String trxName) {
		super(ctx, TF_TRTaxInvoiceLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTRTaxInvoiceLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MTRTaxInvoiceLine (MTRTaxInvoice invoice)
	{
		this (invoice.getCtx(), 0, invoice.get_TrxName());
		if (invoice.get_ID() == 0)
			throw new IllegalArgumentException("Header not saved");
		setClientOrg(invoice.getAD_Client_ID(), invoice.getAD_Org_ID());
		setTF_TRTaxInvoice_ID(invoice.getTF_TRTaxInvoice_ID());
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		updateHeaderTotal();
		return super.afterSave(newRecord, success);
	}
	
	@Override
	protected boolean afterDelete(boolean success) {
		updateHeaderTotal();
		return super.afterDelete(success);
	}
	
	private void updateHeaderTotal() {
		String Sql="SELECT SUM(LineTotalAmt) FROM TF_TRTaxInvoiceLine WHERE TF_TRTaxInvoice_ID=?";
		BigDecimal RoundOffAmt = BigDecimal.ZERO;
		BigDecimal GrandTotal = DB.getSQLValueBD(get_TrxName(), Sql, getTF_TRTaxInvoice_ID());
		
		MTRTaxInvoice ti= new MTRTaxInvoice(getCtx(), getTF_TRTaxInvoice_ID(), get_TrxName());
		ti.setGrandTotal(GrandTotal);
		RoundOffAmt = ti.getRoundOff();
		
		if(ti.isApplyTCS()) {
			GrandTotal = ti.getGrandTotal();			
			BigDecimal TCSAmt = GrandTotal.multiply(new BigDecimal(0.001)).setScale(2, RoundingMode.HALF_EVEN);
			
			ti.setTCSAmount(TCSAmt);
			GrandTotal = GrandTotal.add(TCSAmt);			
		}
		
		if(GrandTotal != null) {
			//Auto Round off to Rupees			
			RoundOffAmt = GrandTotal.setScale(0, RoundingMode.HALF_UP).subtract(GrandTotal);
			ti.setRoundOff(RoundOffAmt);			
			ti.setTotal(GrandTotal.add(RoundOffAmt));
		}
		
		ti.saveEx();
	}

	public void calcAmounts() {
		
		setTaxableAmount(getQty().multiply(getPrice()));		
		BigDecimal divisor = new BigDecimal(100);		
		BigDecimal cgstAmt = getCGST_Rate().multiply(getTaxableAmount()).divide(divisor, 2, RoundingMode.HALF_UP);
		BigDecimal sgstAmt = getSGST_Rate().multiply(getTaxableAmount()).divide(divisor, 2, RoundingMode.HALF_UP);
		BigDecimal igstAmt = getIGST_Rate().multiply(getTaxableAmount()).divide(divisor, 2, RoundingMode.HALF_UP);
		
		setCGST_Amt(cgstAmt);
		setSGST_Amt(sgstAmt);
		setIGST_Amt(igstAmt);
		
		BigDecimal total = getTaxableAmount().add(cgstAmt).add(sgstAmt).add(igstAmt).setScale(2, RoundingMode.HALF_UP);				
		setLineTotalAmt(total);		
	
	}
	
	public BigDecimal getTaxRate() {
		if(getCGST_Rate().doubleValue() > 0) 
			return getCGST_Rate().add(getSGST_Rate()).setScale(2, RoundingMode.HALF_EVEN);
		else
			return getIGST_Rate().setScale(2, RoundingMode.HALF_EVEN);
	}
}
