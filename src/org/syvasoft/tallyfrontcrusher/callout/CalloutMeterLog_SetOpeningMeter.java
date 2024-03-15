package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MMachinery;
import org.syvasoft.tallyfrontcrusher.model.MMeterLog;
import org.syvasoft.tallyfrontcrusher.model.MPMSchedule;

public class CalloutMeterLog_SetOpeningMeter implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int C_UOM_ID = 0;
		int PM_Machinery_ID = 0;
		Timestamp date = null;
		String Shift = null;
		if(mTab.getValue(MMeterLog.COLUMNNAME_PM_Machinery_ID) != null && mTab.getValue(MMeterLog.COLUMNNAME_C_UOM_ID) != null) {
			PM_Machinery_ID = (int) mTab.getValue(MMeterLog.COLUMNNAME_PM_Machinery_ID);
			C_UOM_ID = (int) mTab.getValue(MMeterLog.COLUMNNAME_C_UOM_ID);
			Shift = CalloutUtil.getString(mTab, MMeterLog.COLUMNNAME_Shift);
			date = CalloutUtil.getTimestamp(mTab, MMeterLog.COLUMNNAME_DateReport);
			
						
			String whereClause = "PM_Machinery_ID = ? AND C_UOM_ID = ? AND DateReport <= ? ";
			
			MMeterLog meterLog = new Query(ctx, MMeterLog.Table_Name, whereClause, null)
			.setClient_ID()
			.setParameters(PM_Machinery_ID,C_UOM_ID,date).setOrderBy(MMeterLog.COLUMNNAME_DateReport + " desc , " + MMeterLog.COLUMNNAME_Shift + " desc")
			.first();
			
			if(meterLog != null) {
				mTab.setValue(MMeterLog.COLUMNNAME_Opening_Meter,meterLog.getClosing_Meter());
			}
			else {
				mTab.setValue(MMeterLog.COLUMNNAME_Opening_Meter,BigDecimal.ZERO);
			}
		}
		
		
		
		
		return null;
	}

}
