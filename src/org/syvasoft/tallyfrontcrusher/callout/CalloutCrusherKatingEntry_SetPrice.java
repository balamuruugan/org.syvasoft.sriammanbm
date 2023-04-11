package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MCrusherKatingConfig;
import org.syvasoft.tallyfrontcrusher.model.MCrusherKatingEntry;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;

public class CalloutCrusherKatingEntry_SetPrice implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int AD_Org_ID = (int) mTab.getValue(MCrusherKatingEntry.COLUMNNAME_AD_Org_ID);
		MCrusherKatingConfig config = MCrusherKatingConfig.getConfig(AD_Org_ID);
		if(config != null) {
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_KatingEntryType, config.getKatingEntryType());
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_Transport_Price, config.getTransport_Price());
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_LoaderVehicle_ID, config.getLoaderVehicle_ID());
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_Loading_Price, config.getLoading_Price());
		}
		return null;
	}

}
