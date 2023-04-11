package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoiceLine;

public class CalloutTRTaxInvoiceLine_CalcAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		if(mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_M_Product_ID)!=null && mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_Price)!=null && mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_Qty)!=null) {
			BigDecimal  Price= (BigDecimal) mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_Price);
			BigDecimal  Qty= (BigDecimal) mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_Qty);
			BigDecimal TaxableAmount = Qty.multiply(Price).setScale(2, RoundingMode.HALF_EVEN);
			BigDecimal SGSTRate=BigDecimal.ZERO;
			BigDecimal SGSTAmt=BigDecimal.ZERO;
			BigDecimal CGSTRate=BigDecimal.ZERO;
			BigDecimal CGSTAmt=BigDecimal.ZERO;
			BigDecimal IGSTRate=BigDecimal.ZERO;
			BigDecimal IGSTAmt=BigDecimal.ZERO;
			
			mTab.setValue(MTRTaxInvoiceLine.COLUMNNAME_TaxableAmount, TaxableAmount);
			if(mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_SGST_Rate)!=null) {
				SGSTRate=(BigDecimal) mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_SGST_Rate);
				SGSTAmt =(BigDecimal) TaxableAmount.multiply(SGSTRate.divide(new BigDecimal(100))).setScale(2, RoundingMode.HALF_EVEN);
				mTab.setValue(MTRTaxInvoiceLine.COLUMNNAME_SGST_Amt,SGSTAmt);
			}

			if(mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_CGST_Rate)!=null) {
				CGSTRate=(BigDecimal) mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_CGST_Rate);
				CGSTAmt =(BigDecimal) TaxableAmount.multiply(CGSTRate.divide(new BigDecimal(100))).setScale(2, RoundingMode.HALF_EVEN);;
				mTab.setValue(MTRTaxInvoiceLine.COLUMNNAME_CGST_Amt,CGSTAmt);
			}

			if(mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_IGST_Rate)!=null) {
				IGSTRate=(BigDecimal) mTab.getValue(MTRTaxInvoiceLine.COLUMNNAME_IGST_Rate);
				IGSTAmt =(BigDecimal) TaxableAmount.multiply(IGSTRate.divide(new BigDecimal(100))).setScale(2, RoundingMode.HALF_EVEN);;
				mTab.setValue(MTRTaxInvoiceLine.COLUMNNAME_IGST_Amt,IGSTAmt);
			}

			BigDecimal Total = TaxableAmount.add(SGSTAmt).add(CGSTAmt).add(IGSTAmt);
			mTab.setValue(MTRTaxInvoiceLine.COLUMNNAME_LineTotalAmt, Total);
		}
		return null;
	}

}
