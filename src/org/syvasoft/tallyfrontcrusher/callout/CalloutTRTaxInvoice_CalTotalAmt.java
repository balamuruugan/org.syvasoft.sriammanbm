package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoice;

public class CalloutTRTaxInvoice_CalTotalAmt implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		if(mTab.getValue(MTRTaxInvoice.COLUMNNAME_RoundOff)!=null) {
			BigDecimal GrandTotal= (BigDecimal) mTab.getValue(MTRTaxInvoice.COLUMNNAME_GrandTotal);
			BigDecimal RoundOff =(BigDecimal) mTab.getValue(MTRTaxInvoice.COLUMNNAME_RoundOff);
			BigDecimal TotalAmt=GrandTotal.add(RoundOff);
			mTab.setValue(MTRTaxInvoice.COLUMNNAME_Total, TotalAmt);
		}
		return null;
	}

}
