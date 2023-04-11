package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MLumpSumRentConfig;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_Distance implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		int AD_Org_ID = 0;
		int TF_Destination_ID = 0;
		int TF_VehicleType_ID = 0;
		BigDecimal Distance=BigDecimal.ZERO;
		Boolean isLumpSumRent=false;
		
		if(mTab.getValue(TF_MOrder.COLUMNNAME_TF_RentedVehicle_ID) != null &&  mTab.getValue(TF_MOrder.COLUMNNAME_Distance) != null) {
			
			if(mTab.getValue(TF_MOrder.COLUMNNAME_IsLumpSumRent)!=null) {
				isLumpSumRent = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsLumpSumRent);
			}
			if(mTab.getValue(TF_MOrder.COLUMNNAME_AD_Org_ID)!=null) {					
				AD_Org_ID = (int)mTab.getValue(TF_MOrder.COLUMNNAME_AD_Org_ID);
			}
			if(mTab.getValue(TF_MOrder.COLUMNNAME_TF_Destination_ID)!=null) {
				TF_Destination_ID = (int)mTab.getValue(TF_MOrder.COLUMNNAME_TF_Destination_ID);				
			}
			if(mTab.getValue(TF_MOrder.COLUMNNAME_Item1_VehicleType_ID)!=null) {
				TF_VehicleType_ID = (int)mTab.getValue(TF_MOrder.COLUMNNAME_Item1_VehicleType_ID);
			}
		}
		return null;
	}

}
