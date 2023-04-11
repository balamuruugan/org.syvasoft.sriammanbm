package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MFuelIssue;

public class CalloutFuelIssue_CalcAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal qty = (BigDecimal) mTab.getValue(MFuelIssue.COLUMNNAME_Qty);
		BigDecimal price = (BigDecimal) mTab.getValue(MFuelIssue.COLUMNNAME_Rate);
		BigDecimal amount = BigDecimal.ZERO;
		if(qty != null && price != null) {
			amount = qty.multiply(price);
		}		
		mTab.setValue(MFuelIssue.COLUMNNAME_Amt, amount);		
		return null;
	}

}
