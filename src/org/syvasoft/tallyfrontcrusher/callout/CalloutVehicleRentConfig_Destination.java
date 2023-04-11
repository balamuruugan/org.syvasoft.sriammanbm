package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MDestination;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRentConfig;

public class CalloutVehicleRentConfig_Destination implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int tf_destination_id = 0;
		BigDecimal rate = BigDecimal.ZERO;
		
		
		if ( mTab.getValue(MVehicleRentConfig.COLUMNNAME_TF_Destination_ID) != null) 
			tf_destination_id = (int) mTab.getValue(MVehicleRentConfig.COLUMNNAME_TF_Destination_ID);	
		
		if(tf_destination_id > 0) {
			MDestination dest = new MDestination(ctx, tf_destination_id, null);
			rate = dest.getRate();
		}
		mTab.setValue(MVehicleRentConfig.COLUMNNAME_Rate, rate);
		return null;
	}

}
