package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.TF_MElementValue;

public class CalloutElementValue_AccountGroup implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mTab.getValue(TF_MElementValue.COLUMNNAME_AccountGroup_ID) != null) {			
			int accountGroup_ID = (int) mTab.getValue(TF_MElementValue.COLUMNNAME_AccountGroup_ID);
			TF_MElementValue account = new TF_MElementValue(ctx, accountGroup_ID, null);
			String accountType = account.getAccountType();
			String accountSign = account.getAccountSign();
			mTab.setValue(TF_MElementValue.COLUMNNAME_AccountType, accountType);
			mTab.setValue(TF_MElementValue.COLUMNNAME_AccountSign, accountSign);
		}
		return null;
	}

}
