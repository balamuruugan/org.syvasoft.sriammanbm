package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_CalcRentPayable implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		boolean isSOTrx = Env.getContext(ctx, WindowNo, "IsSOTrx").equals("Y");
		if(isSOTrx) {
			BigDecimal rent = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Rent_Amt);
			BigDecimal rentMargin = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_RentMargin);
			BigDecimal rentPayable = rent.subtract(rentMargin);
			mTab.setValue(TF_MOrder.COLUMNNAME_RentPayable, rentPayable);
		}
		return null;
	}

}
