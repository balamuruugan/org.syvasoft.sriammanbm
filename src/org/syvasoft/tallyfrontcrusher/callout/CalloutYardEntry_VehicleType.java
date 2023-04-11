package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MYardEntry;
import org.syvasoft.tallyfrontcrusher.model.MYardEntryConfig;

public class CalloutYardEntry_VehicleType implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mTab.getValue(MYardEntry.COLUMNNAME_TF_VehicleType_ID) != null) {
			int AD_Org_ID = (int) mTab.getValue(MYardEntry.COLUMNNAME_AD_Org_ID);
			int vehicleType = (int) mTab.getValue(MYardEntry.COLUMNNAME_TF_VehicleType_ID);
			int C_BPartner_ID = 0;
			
			if(mTab.getValue(MYardEntry.COLUMNNAME_C_BPartner_ID) != null)
				C_BPartner_ID = (int) mTab.getValue(MYardEntry.COLUMNNAME_C_BPartner_ID);
			
			MYardEntryConfig config = MYardEntryConfig.getConfig(AD_Org_ID, vehicleType, C_BPartner_ID);
			
			if(config != null) {
				mTab.setValue(MYardEntry.COLUMNNAME_PermitPrice, config.getPermitPrice());
				mTab.setValue(MYardEntry.COLUMNNAME_ExtraBucketPrice, config.getExtraBucketPrice());
				mTab.setValue(MYardEntry.COLUMNNAME_WpPrice, config.getWpPrice());
			}
		}
		return null;
	}

}
