package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MJobworkAssignedAccount;
import org.syvasoft.tallyfrontcrusher.model.TF_MJournal;

public class CalloutJournal_SetJobWork implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(value != null && value instanceof Integer) {
			int AD_Org_ID = (int) mTab.getValue(TF_MJournal.COLUMNNAME_AD_Org_ID);
			int acct_id = (int) value;
			MJobworkAssignedAccount jwAcct = MJobworkAssignedAccount.getJobwork(AD_Org_ID, acct_id);
			if(jwAcct != null) {
				mTab.setValue(TF_MJournal.COLUMNNAME_C_Project_ID, jwAcct.getC_Project_ID());
			}
		}
		return null;
	}

}
