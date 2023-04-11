package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrg;

public class CalloutOrder_Org implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		String orgType=null;
		int orgID = 0;
		if(mTab.getValue(TF_MOrder.COLUMNNAME_AD_Org_ID) != null) {
			orgID = (int)  mTab.getValue(TF_MOrg.COLUMNNAME_AD_Org_ID);
			TF_MOrg org = new TF_MOrg(ctx, orgID, null);
			orgType = org.getOrgType();
		}
		mTab.setValue(TF_MOrder.COLUMNNAME_OrgType, orgType);
		return null;
	}

}
