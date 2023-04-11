package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.TF_MJournal;

public class CalloutJournal_QuickEntryMode implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		boolean isQuickEntryMode = mTab.getValueAsBoolean(TF_MJournal.COLUMNNAME_IsQuickEntry);
		if(!isQuickEntryMode) {
			mTab.setValue(TF_MJournal.COLUMNNAME_Amount, BigDecimal.ZERO);
			mTab.setValue(TF_MJournal.COLUMNNAME_TF_DebitAcct_ID, 0);
			mTab.setValue(TF_MJournal.COLUMNNAME_TF_CreditAcct_ID, 0);			
		}
		else {
			mTab.setValue(TF_MJournal.COLUMNNAME_IsDistributeProfit, false);
		}
		return null;
	}

}
