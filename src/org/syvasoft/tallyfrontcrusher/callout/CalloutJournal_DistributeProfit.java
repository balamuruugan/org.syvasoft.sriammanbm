package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.TF_MJournal;

public class CalloutJournal_DistributeProfit implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		boolean distributeProfit = mTab.getValueAsBoolean(TF_MJournal.COLUMNNAME_IsDistributeProfit);
		if(distributeProfit) {		
			//Set Net Profit / Loss
			int AD_Org_ID = (int) mTab.getValue(TF_MJournal.COLUMNNAME_AD_Org_ID);
			Timestamp dateAcct = (Timestamp) mTab.getValue(TF_MJournal.COLUMNNAME_DateAcct);
			BigDecimal NetProfit = TF_MJournal.getNetProfit(AD_Org_ID, dateAcct);
			mTab.setValue(TF_MJournal.COLUMNNAME_NetProfit, NetProfit);
			
			//Reset Quick Entry Lines
			mTab.setValue(TF_MJournal.COLUMNNAME_IsQuickEntry, false);
			mTab.setValue(TF_MJournal.COLUMNNAME_TF_CreditAcct_ID, null);
			mTab.setValue(TF_MJournal.COLUMNNAME_TF_DebitAcct_ID, null);
		}	
		else {
			mTab.setValue(TF_MJournal.COLUMNNAME_NetProfit, BigDecimal.ZERO);
		}
		return null;
	}

}
