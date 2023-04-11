package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrg;

public class CalloutBPartner_IsPermitSales implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(!mTab.getValueAsBoolean(TF_MBPartner.COLUMNNAME_IsPermitSales)) {
			mTab.setValue(TF_MBPartner.COLUMNNAME_ApplyTCS, false);	
		}
		
		return null;
	}

}
