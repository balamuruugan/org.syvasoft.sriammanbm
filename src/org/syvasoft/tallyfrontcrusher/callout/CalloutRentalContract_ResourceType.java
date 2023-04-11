package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRentalContract;
import org.syvasoft.tallyfrontcrusher.model.TF_MResourceType;

public class CalloutRentalContract_ResourceType implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		int S_ResourceType_ID = 0;
		boolean isFuelIncluded = false;
		String ContractBase = null;
		if(value != null) {
			S_ResourceType_ID = (int) value;
			TF_MResourceType resType = new TF_MResourceType(ctx, S_ResourceType_ID, null);
			isFuelIncluded = resType.isFuelIncluded();
			ContractBase = resType.getContractBase();
		}
		mTab.setValue(MVehicleRentalContract.COLUMNNAME_IsFuelIncluded, isFuelIncluded);
		mTab.setValue(MVehicleRentalContract.COLUMNNAME_ContractBase, ContractBase);
		return null;
	}

}
