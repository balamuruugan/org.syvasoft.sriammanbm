package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;

public class CalloutWeighmentEntry_VehiicleType implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		
		int TF_VehicleType_ID = 0;
		if(mTab.getValue(MWeighmentEntry.COLUMNNAME_TF_RentedVehicle_ID) != null) {	
			
			int TF_RentedVehicle_ID = (int) mTab.getValue(MWeighmentEntry.COLUMNNAME_TF_RentedVehicle_ID);
			
			MRentedVehicle veh = new MRentedVehicle(ctx, TF_RentedVehicle_ID, null);
			TF_VehicleType_ID = veh.getTF_VehicleType_ID();

//			String sql = "SELECT TF_VehicleType_ID FROM TF_RentedVehicle WHERE TF_RentedVehicle_ID =?";
//			TF_VehicleType_ID = DB.getSQLValue(null, sql, TF_RentedVehicle_ID);
			
			mTab.setValue(MWeighmentEntry.COLUMNNAME_TF_VehicleType_ID, TF_VehicleType_ID);
		
		}
		return null;
	}
}
