package org.syvasoft.tallyfrontcrusher.callout;

import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTripSheet;

public class CalloutTripsheet_time implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		String Shift = (String) mTab.getValue(MTripSheet.COLUMNNAME_Shift);
		Timestamp DateReport = (Timestamp) mTab.getValue(MTripSheet.COLUMNNAME_DateReport);
		Timestamp starttime = MTripSheet.getstarttime(ctx, Shift,DateReport, null);
		Timestamp endtime = MTripSheet.getendtime(ctx, Shift, DateReport, null);

		mTab.setValue(MTripSheet.COLUMNNAME_DateStart, starttime);
		mTab.setValue(MTripSheet.COLUMNNAME_DateEnd, endtime);
		
		
		return  null;
	}

}
