package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;
import org.syvasoft.tallyfrontcrusher.model.MVehicleType;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;

public class CalloutWeighmentEntry_Vehicle implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		String vehicleNo = "";
		BigDecimal tareWeight = BigDecimal.ZERO;
		if(mTab.getValue(MWeighmentEntry.COLUMNNAME_TF_RentedVehicle_ID) != null) {
			int vehicleId = (int) mTab.getValue(MWeighmentEntry.COLUMNNAME_TF_RentedVehicle_ID);
			MRentedVehicle vehicle = new MRentedVehicle(ctx, vehicleId, null);
			vehicleNo = vehicle.getVehicleNo();	
			tareWeight = vehicle.getTareWeight();
		}
		mTab.setValue(MWeighmentEntry.COLUMNNAME_VehicleNo, vehicleNo);
		//mTab.setValue(MWeighmentEntry.COLUMNNAME_TareWeight, tareWeight);
		return null;
	}

}
