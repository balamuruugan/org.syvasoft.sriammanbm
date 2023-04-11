package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTripSheet;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRentalContract;

public class CalloutTripSheetRentalContract implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		int rentalContractID = 0;
		
		if(value != null) {
			int vehicle_ID = (int) mTab.getValue(MTripSheet.COLUMNNAME_Vehicle_ID);
			rentalContractID = MVehicleRentalContract.getActiveRentalContract(vehicle_ID);
		}
		
		mTab.setValue(MTripSheet.COLUMNNAME_TF_Vehicle_Rental_Contract_ID, rentalContractID);
		if(rentalContractID > 0) {
			BigDecimal openingMeter = (BigDecimal) mTab.getValue(MTripSheet.COLUMNNAME_Opening_Meter);
			BigDecimal openingFuel = (BigDecimal) mTab.getValue(MTripSheet.COLUMNNAME_Opening_Fuel);
			MVehicleRentalContract rentalContract = new MVehicleRentalContract(ctx, rentalContractID, null);
			if(openingMeter.doubleValue() == 0)
				mTab.setValue(MTripSheet.COLUMNNAME_Opening_Meter, rentalContract.getOpening_Meter());
			if(openingMeter.doubleValue() == 0)
				mTab.setValue(MTripSheet.COLUMNNAME_Opening_Fuel, rentalContract.getOpening_Fuel());
		}
		return null;
	}

}
