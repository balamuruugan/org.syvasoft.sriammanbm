package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTyreAssignment;

public class CalloutTyreAssignment_CalcRunningMeter implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal releasedStartMeter = BigDecimal.ZERO;
		BigDecimal releasedEndMeter = BigDecimal.ZERO;
		BigDecimal runningMeter = BigDecimal.ZERO;
		
		if(mTab.getValue(MTyreAssignment.COLUMNNAME_RD_End_Meter) != null)
			releasedEndMeter = (BigDecimal) mTab.getValue(MTyreAssignment.COLUMNNAME_RD_End_Meter);
		if(mTab.getValue(MTyreAssignment.COLUMNNAME_RD_Start_Meter) != null)
			releasedStartMeter = (BigDecimal) mTab.getValue(MTyreAssignment.COLUMNNAME_RD_Start_Meter);
		
		runningMeter = releasedEndMeter.subtract(releasedStartMeter);
		
		mTab.setValue(MTyreAssignment.COLUMNNAME_RD_Running_Meter, runningMeter);
		
		return null;
	}

}
