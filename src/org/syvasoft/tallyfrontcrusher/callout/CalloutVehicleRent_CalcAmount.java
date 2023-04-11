package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRent;

public class CalloutVehicleRent_CalcAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal qty = BigDecimal.ZERO;
		BigDecimal price = BigDecimal.ZERO;
		if(mTab.getValue(MVehicleRent.COLUMNNAME_Qty) != null)
			qty = (BigDecimal) mTab.getValue(MVehicleRent.COLUMNNAME_Qty);
		if(mTab.getValue(MVehicleRent.COLUMNNAME_Price) != null)
			price = (BigDecimal) mTab.getValue(MVehicleRent.COLUMNNAME_Price);
		mTab.setValue(MVehicleRent.COLUMNNAME_Rent_Amt, qty.multiply(price));
		
		return null;
	}

}
