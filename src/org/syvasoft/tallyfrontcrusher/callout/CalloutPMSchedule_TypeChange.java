package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.TimeUtil;
import org.syvasoft.tallyfrontcrusher.model.MMachinery;
import org.syvasoft.tallyfrontcrusher.model.MPMPeriod;
import org.syvasoft.tallyfrontcrusher.model.MPMSchedule;

public class CalloutPMSchedule_TypeChange implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal interval = (BigDecimal) mTab.getValue(MPMSchedule.COLUMNNAME_Interval);
		String scheduleType = (String) mTab.getValue(MPMSchedule.COLUMNNAME_ScheduleType);
		
		//Schedule Type : Usage
		if(mTab.getValue(MPMSchedule.COLUMNNAME_C_UOM_ID) != null && 
				scheduleType.equals(MPMSchedule.SCHEDULETYPE_Usage)) {
			int PM_Machinery_ID = (int) mTab.getValue(MPMSchedule.COLUMNNAME_PM_Machinery_ID);
			int C_UOM_ID = (int) mTab.getValue(MPMSchedule.COLUMNNAME_C_UOM_ID);
			BigDecimal lastMeter = (BigDecimal) mTab.getValue(MPMSchedule.COLUMNNAME_LastMeter);
			if(mField.getColumnName().equals(MPMSchedule.COLUMNNAME_C_UOM_ID))
				lastMeter = MMachinery.getCurrentMeter(ctx, PM_Machinery_ID, C_UOM_ID);
			mTab.setValue(MPMSchedule.COLUMNNAME_LastMeter, lastMeter);
			mTab.setValue(MPMSchedule.COLUMNNAME_NextMeter, lastMeter.add(interval));
		}
		else {
			mTab.setValue(MPMSchedule.COLUMNNAME_LastMeter, BigDecimal.ZERO);
			mTab.setValue(MPMSchedule.COLUMNNAME_NextMeter, BigDecimal.ZERO);
		}
		
		
		//Schedule Type : Time
		if(scheduleType.equals(MPMSchedule.SCHEDULETYPE_Time)) {
			Timestamp lastRun = null;
			Timestamp nextRun = null;
			int PM_Period_ID = 0;
			if(mTab.getValue(MPMSchedule.COLUMNNAME_DateLastRun) != null) {
				lastRun = (Timestamp) mTab.getValue(MPMSchedule.COLUMNNAME_DateLastRun);
				if(mTab.getValue(MPMSchedule.COLUMNNAME_PM_Period_ID) != null)
					PM_Period_ID = (int) mTab.getValue(MPMSchedule.COLUMNNAME_PM_Period_ID);
				MPMPeriod p = new MPMPeriod(ctx, PM_Period_ID, null);
				
				if(mField.getColumnName().equals(MPMSchedule.COLUMNNAME_Interval)) {
					interval = (BigDecimal) mTab.getValue(MPMSchedule.COLUMNNAME_Interval);
					mTab.setValue(MPMSchedule.COLUMNNAME_DateNextRun, TimeUtil.addDays(lastRun, interval.intValue()));
				}
				else {
					mTab.setValue(MPMSchedule.COLUMNNAME_Interval, p.getDays());
					nextRun = TimeUtil.addDays(lastRun, p.getDays().intValue());
					mTab.setValue(MPMSchedule.COLUMNNAME_DateNextRun, nextRun);
				}
			}
		}
		
		return null;
	}

}
