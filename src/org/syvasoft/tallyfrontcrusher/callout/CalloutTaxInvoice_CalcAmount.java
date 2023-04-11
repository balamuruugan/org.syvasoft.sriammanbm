package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTaxInvoice;

public class CalloutTaxInvoice_CalcAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal qty = (BigDecimal) mTab.getValue(MTaxInvoice.COLUMNNAME_Qty);
		BigDecimal price = (BigDecimal) mTab.getValue(MTaxInvoice.COLUMNNAME_Price);
		BigDecimal amount = qty.multiply(price);
		
		BigDecimal cgstRate = (BigDecimal) mTab.getValue(MTaxInvoice.COLUMNNAME_CGST_Rate);
		BigDecimal sgstRate = (BigDecimal) mTab.getValue(MTaxInvoice.COLUMNNAME_SGST_Rate);
		BigDecimal igstRate = (BigDecimal) mTab.getValue(MTaxInvoice.COLUMNNAME_IGST_Rate);
		BigDecimal roundingOff = (BigDecimal) mTab.getValue(MTaxInvoice.COLUMNNAME_RoundingOff);
		
		BigDecimal divisor = new BigDecimal(100);		
		BigDecimal cgstAmt = cgstRate.multiply(amount).divide(divisor);
		BigDecimal sgstAmt = sgstRate.multiply(amount).divide(divisor);
		BigDecimal igstAmt = igstRate.multiply(amount).divide(divisor);
		
		BigDecimal total = amount.add(cgstAmt).add(sgstAmt)
				.add(igstAmt).add(roundingOff);
		
		mTab.setValue(MTaxInvoice.COLUMNNAME_TaxableAmount, amount);
		mTab.setValue(MTaxInvoice.COLUMNNAME_CGST_Amt, cgstAmt);
		mTab.setValue(MTaxInvoice.COLUMNNAME_SGST_Amt, sgstAmt);
		mTab.setValue(MTaxInvoice.COLUMNNAME_IGST_Amt, igstAmt);
		mTab.setValue(MTaxInvoice.COLUMNNAME_GrandTotal, total);
		return null;
	}

}
