package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MTab;
import org.syvasoft.tallyfrontcrusher.model.MLumpSumRentConfig;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRentConfig;
import org.syvasoft.tallyfrontcrusher.model.MVehicleType;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_RentedVehicle implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal rate = BigDecimal.ZERO;
		if(mTab.getValue(TF_MOrder.COLUMNNAME_TF_RentedVehicle_ID) == null) {
			mTab.setValue(TF_MOrder.COLUMNNAME_Rent_Amt, BigDecimal.ZERO);
			//mTab.setValue(TF_MOrder.COLUMNNAME_IsLumpSumRent, false);
			mTab.setValue(TF_MOrder.COLUMNNAME_RentMargin, BigDecimal.ZERO);
			mTab.setValue(TF_MOrder.COLUMNNAME_RentPayable, BigDecimal.ZERO);
			mTab.setValue(TF_MOrder.COLUMNNAME_VehicleNo, null);
			mTab.setValue(TF_MOrder.COLUMNNAME_IsRentBreakup, false);
		}
		if(mTab.getValue(TF_MOrder.COLUMNNAME_TF_RentedVehicle_ID) != null) {
			int vehicle_id = (int) mTab.getValue(TF_MOrder.COLUMNNAME_TF_RentedVehicle_ID);
			MRentedVehicle rv = new MRentedVehicle(ctx, vehicle_id, null);
			int TF_VehicleType_ID = (int) rv.get_ValueAsInt("TF_VehicleType_ID");
			mTab.setValue(TF_MOrder.COLUMNNAME_VehicleNo, rv.getVehicleNo());
			int C_BPartner_ID = CalloutUtil.getIntValue(mTab, TF_MOrder.COLUMNNAME_C_BPartner_ID);
			TF_MBPartner bp = new TF_MBPartner(ctx, C_BPartner_ID, null);			
			mTab.setValue(TF_MOrder.COLUMNNAME_IsRentBreakup, false);//bp.isRentBreakup());
			mTab.setValue(TF_MOrder.COLUMNNAME_IsRentInclusive, true);
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_VehicleType_ID, TF_VehicleType_ID);
		}		
		
		mTab.setValue(TF_MOrder.COLUMNNAME_Rate, rate);
		return null;
	}

}
