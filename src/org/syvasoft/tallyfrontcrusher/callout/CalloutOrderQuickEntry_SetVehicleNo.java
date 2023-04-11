package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrderQuickEntry_SetVehicleNo implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		String vehicleNo = "";		
		if(value != null) {
			int vehicle_ID = (int) value;
			MProduct prod = MProduct.get(ctx, vehicle_ID);
			vehicleNo = prod.getName();
		}
		else {
			mTab.setValue(TF_MOrder.COLUMNNAME_Rent_Amt, BigDecimal.ZERO);
		}
		
		mTab.setValue(TF_MOrder.COLUMNNAME_VehicleNo, vehicleNo);
					
		return null;
	}

}
