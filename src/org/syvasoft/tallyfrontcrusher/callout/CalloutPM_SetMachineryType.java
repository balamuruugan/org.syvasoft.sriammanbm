package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MMachinery;
import org.syvasoft.tallyfrontcrusher.model.MPMSchedule;

public class CalloutPM_SetMachineryType implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int PM_MachineryType_ID = 0;
		int PM_Machinery_ID = 0;
		if(mTab.getValue(MPMSchedule.COLUMNNAME_PM_Machinery_ID) != null) {
			PM_Machinery_ID = (int) mTab.getValue(MPMSchedule.COLUMNNAME_PM_Machinery_ID);
			MMachinery m = new MMachinery(ctx, PM_Machinery_ID, null);
			PM_MachineryType_ID = m.getPM_MachineryType_ID();
		}
		
		mTab.setValue(MPMSchedule.COLUMNNAME_PM_MachineryType_ID, PM_MachineryType_ID == 0? null : PM_MachineryType_ID);
		
		
		return null;
	}

}
