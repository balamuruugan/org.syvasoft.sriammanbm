package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MPermitPurchase;
import org.syvasoft.tallyfrontcrusher.model.MQuarry;

public class CalloutPermitPurchase_Quarry implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mTab.getValue(MPermitPurchase.COLUMNNAME_TF_Quarry_ID) != null) {
			//int quarry_id = (int) mTab.getValue(MPermitPurchase.COLUMNNAME_TF_Quarry_ID);
			//MQuarry quarry = new MQuarry(ctx, quarry_id, null);
			//mTab.setValue(MPermitPurchase.COLUMNNAME_C_ElementValue_ID, quarry.getC_ElementValuePermitExp_ID());
		}
		else
			mTab.setValue(MPermitPurchase.COLUMNNAME_C_ElementValue_ID, null);
		return null;
	}

}
