package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTripSheet;

public class CalloutTripSheetRunningMeter implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal openingMeter = (BigDecimal) mTab.getValue(MTripSheet.COLUMNNAME_Opening_Meter);
		BigDecimal closingMeter = (BigDecimal) mTab.getValue(MTripSheet.COLUMNNAME_Closing_Meter);
		BigDecimal runningMeter = BigDecimal.ZERO;
		
		if(openingMeter != null && closingMeter != null)
			runningMeter = closingMeter.subtract(openingMeter);
		
		mTab.setValue(MTripSheet.COLUMNNAME_Running_Meter, runningMeter);
		
		return null;
	}

}
