package org.syvasoft.tallyfrontcrusher.callout;

import java.util.List;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBankAccount;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class CalloutPayment_Org implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		/// Commented to preserve previous entry's bank account to current entry.
		//if(mTab.getValue(TF_MPayment.COLUMNNAME_AD_Org_ID) != null) {
		//	int orgId = (int) mTab.getValue(TF_MPayment.COLUMNNAME_AD_Org_ID);
		//	List<MBankAccount> accts = new Query(ctx, MBankAccount.Table_Name, "AD_Org_ID=?", null)
		//			.setOnlyActiveRecords(true).setParameters(orgId).setOrderBy("IsDefault DESC, BankAccountType").list();
		//	if(accts.size() > 0)
		//		mTab.setValue(TF_MPayment.COLUMNNAME_C_BankAccount_ID, accts.get(0).getC_BankAccount_ID());
		//}
		return null;
	}

}
