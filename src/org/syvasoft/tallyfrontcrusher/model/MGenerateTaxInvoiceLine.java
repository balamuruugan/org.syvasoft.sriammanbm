package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.util.DB;


public class MGenerateTaxInvoiceLine extends X_TF_Generate_TaxInvoiceLine{

	/* 
	 */
	private static final long serialVersionUID = 2998552885424149296L;
	
	/**
	 * 	Overwrite Client/Org if required
	 * 	@param AD_Client_ID client
	 * 	@param AD_Org_ID org
	 */
	public void setClientOrg (int AD_Client_ID, int AD_Org_ID)
	{
		super.setClientOrg(AD_Client_ID, AD_Org_ID);
	}	//	setClientOrg

	public MGenerateTaxInvoiceLine(Properties ctx, int TF_Generate_TaxInvoice_ID, String trxName) {
		super(ctx, TF_Generate_TaxInvoice_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MGenerateTaxInvoiceLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	private void updateHeaderTotal() {
		String Sql="SELECT SUM(LineTotalAmt) FROM Tf_Generate_TaxInvoiceLine WHERE Tf_Generate_TaxInvoice_ID=?";
		BigDecimal RoundOffAmt = BigDecimal.ZERO;
		BigDecimal GrandTotal = DB.getSQLValueBD(get_TrxName(), Sql, getTF_Generate_Taxinvoice_ID());
		
		MGenerateTaxInvoice ti= new MGenerateTaxInvoice(getCtx(), getTF_Generate_Taxinvoice_ID(), get_TrxName());
		ti.setGrandTotal(GrandTotal);
		RoundOffAmt = ti.getRoundOff();
		
		if(GrandTotal != null) {
			//Auto Round off to Rupees			
			RoundOffAmt = GrandTotal.setScale(0, RoundingMode.HALF_UP).subtract(GrandTotal);
			ti.setRoundOff(RoundOffAmt);			
			ti.setTotal(GrandTotal.add(RoundOffAmt));
		}
		ti.saveEx();
	}
	
	public void calcAmounts() {
		setTaxableAmount(getQty().multiply(getPrice()).setScale(2, RoundingMode.HALF_UP));		
		BigDecimal divisor = new BigDecimal(100);		
		BigDecimal cgstAmt = getCGST_Rate().multiply(getTaxableAmount()).divide(divisor, 2, RoundingMode.HALF_UP);
		BigDecimal sgstAmt = getSGST_Rate().multiply(getTaxableAmount()).divide(divisor, 2, RoundingMode.HALF_UP);		
		
		setCGST_Amt(cgstAmt);
		setSGST_Amt(sgstAmt);
		
		BigDecimal total = getTaxableAmount().add(cgstAmt).add(sgstAmt).setScale(2, RoundingMode.HALF_UP);				
		setLineTotalAmt(total);
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

}
