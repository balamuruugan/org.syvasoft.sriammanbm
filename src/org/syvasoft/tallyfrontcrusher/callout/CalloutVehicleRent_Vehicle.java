package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MJobworkAssignedVehicle;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRent;

public class CalloutVehicleRent_Vehicle implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int VehicleID = 0;
		int AD_Org_ID = (int) mTab.getValue(MVehicleRent.COLUMNNAME_AD_Org_ID);
		if(value != null && mField.getColumnName().equals(MVehicleRent.COLUMNNAME_Vehicle_ID)) {
			VehicleID = (int) value;
			MRentedVehicle rv = new MRentedVehicle(ctx, VehicleID, null);
			MJobworkAssignedVehicle jwVehicle = MJobworkAssignedVehicle.getJobwork(AD_Org_ID, rv.getM_Product_ID());
			if(jwVehicle != null) {
				mTab.setValue(MVehicleRent.COLUMNNAME_C_Project_ID, jwVehicle.getC_Project_ID());			
			}
			else {
				mTab.setValue(MVehicleRent.COLUMNNAME_C_Project_ID, null);
			}
			mTab.setValue(MVehicleRent.COLUMNNAME_Price, rv.getUnitPrice());
			mTab.setValue(MVehicleRent.COLUMNNAME_C_UOM_ID, rv.getC_UOM_ID());
		}		
		return null;
	}

}
