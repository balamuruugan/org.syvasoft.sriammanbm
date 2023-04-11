package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MJobworkIssuedResource;
import org.syvasoft.tallyfrontcrusher.model.MTripSheet;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRentalContract;

public class CalloutTripSheetJobwork implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		int jobWorkID = 0;
		
		if(value != null) {
			int vehicle_ID = (int) mTab.getValue(MTripSheet.COLUMNNAME_Vehicle_ID);
			jobWorkID = MJobworkIssuedResource.getJobworkID(vehicle_ID);
		}
		if(jobWorkID > 0) {
			mTab.setValue(MTripSheet.COLUMNNAME_C_Project_ID, jobWorkID);
		}
		return null;
	}

}
