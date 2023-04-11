package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MPeriod;
import org.syvasoft.tallyfrontcrusher.model.MSalaryHdr;

public class CalloutSalaryHdr_Period implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int C_Period_ID = CalloutUtil.getIntValue(mTab, MSalaryHdr.COLUMNNAME_C_Period_ID);
		MPeriod p = new MPeriod(ctx, C_Period_ID, null);
		mTab.setValue(MSalaryHdr.COLUMNNAME_DateAcct, p.getEndDate());
		mTab.setValue(MSalaryHdr.COLUMNNAME_DateFrom, p.getStartDate());
		mTab.setValue(MSalaryHdr.COLUMNNAME_DateTo, p.getEndDate());
		return null;
	}

}
