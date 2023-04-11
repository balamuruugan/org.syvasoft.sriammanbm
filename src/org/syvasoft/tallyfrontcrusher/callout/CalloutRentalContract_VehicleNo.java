package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MResource;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRentalContract;
import org.syvasoft.tallyfrontcrusher.model.TF_MResource;
import org.syvasoft.tallyfrontcrusher.model.TF_MResourceType;

public class CalloutRentalContract_VehicleNo implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		int S_ResourceType_ID = 0;
		boolean fuelIncluded = false;
		int M_Product_ID = 0;
		int S_Resource_ID = 0;
		String ContractBase = null;
		
		if(value != null) {
			TF_MResource res = TF_MResource.getTF_MResource(ctx, value.toString());
			if(res != null) {
				S_ResourceType_ID = res.getS_ResourceType_ID();
				M_Product_ID = res.getProduct().getM_Product_ID();
				S_Resource_ID = res.getS_Resource_ID();
				TF_MResourceType resType = new TF_MResourceType(ctx, S_ResourceType_ID, null);
				fuelIncluded = resType.isFuelIncluded();
				ContractBase = resType.getContractBase();
				mTab.setValue(MVehicleRentalContract.COLUMNNAME_M_Product_ID, M_Product_ID);
			}
		}
		else {
			mTab.setValue(MVehicleRentalContract.COLUMNNAME_M_Product_ID, null);
		}
		
		mTab.setValue(MVehicleRentalContract.COLUMNNAME_S_ResourceType_ID, S_ResourceType_ID);
		mTab.setValue(MVehicleRentalContract.COLUMNNAME_S_Resource_ID, S_Resource_ID);
		mTab.setValue(MVehicleRentalContract.COLUMNNAME_IsFuelIncluded, fuelIncluded);
		mTab.setValue(MVehicleRentalContract.COLUMNNAME_ContractBase, ContractBase);
		
		
		return null;
	}

}
