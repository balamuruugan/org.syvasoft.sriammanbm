package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTyrePurchaseLine;

public class CalloutTyrePurchaseLine_GST implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal GSTRate = (BigDecimal) mTab.getValue(MTyrePurchaseLine.COLUMNNAME_GSTRate);
		BigDecimal price = 	(BigDecimal) mTab.getValue(MTyrePurchaseLine.COLUMNNAME_Price);
		BigDecimal gstAmt = price.multiply(GSTRate).divide(new BigDecimal(100),2, RoundingMode.HALF_EVEN);				
		BigDecimal lineTotal = gstAmt.add(price);
		mTab.setValue(MTyrePurchaseLine.COLUMNNAME_GSTAmount, gstAmt);
		mTab.setValue(MTyrePurchaseLine.COLUMNNAME_LineTotalAmt, lineTotal);
		return null;
	}

}
