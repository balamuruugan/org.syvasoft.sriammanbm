package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTripSheet;

public class CalloutTripSheetFuelExpensed implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal openingFuel = (BigDecimal) mTab.getValue(MTripSheet.COLUMNNAME_Opening_Fuel);
		BigDecimal closingFuel = (BigDecimal) mTab.getValue(MTripSheet.COLUMNNAME_Closing_Fuel);
		BigDecimal receivedFuel = (BigDecimal) mTab.getValue(MTripSheet.COLUMNNAME_Received_Fuel);
		BigDecimal fuelExpensed = BigDecimal.ZERO;
		
		if(openingFuel != null && closingFuel != null && receivedFuel != null)
			fuelExpensed = openingFuel.add(receivedFuel).subtract(closingFuel);
		
		mTab.setValue(MTripSheet.COLUMNNAME_Expensed_Fuel, fuelExpensed);
		
		return null;
	}

}
