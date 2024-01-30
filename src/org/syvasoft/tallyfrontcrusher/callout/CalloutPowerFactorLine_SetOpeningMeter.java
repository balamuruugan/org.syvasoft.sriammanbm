package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MTab;
import org.syvasoft.tallyfrontcrusher.model.MPowerFactorLine;

public class CalloutPowerFactorLine_SetOpeningMeter implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		Timestamp date = CalloutUtil.getTimestamp(mTab, MPowerFactorLine.COLUMNNAME_DateAcct);
		int org = CalloutUtil.getIntValue(mTab, MPowerFactorLine.COLUMNNAME_AD_Org_ID);
		BigDecimal openingKWH = MPowerFactorLine.getOpeningKWH(date, org);
		BigDecimal openingKVAH = MPowerFactorLine.getOpeningKVAH(date);
		
		mTab.setValue(MPowerFactorLine.COLUMNNAME_openingkwh, openingKWH);
		mTab.setValue(MPowerFactorLine.COLUMNNAME_openingkvah, openingKVAH);
		return null;
	}

}
