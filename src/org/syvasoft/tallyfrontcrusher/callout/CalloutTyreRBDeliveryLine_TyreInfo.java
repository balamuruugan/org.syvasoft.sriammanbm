package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTyre;
import org.syvasoft.tallyfrontcrusher.model.MTyreRebuttonDeliveryLine;

public class CalloutTyreRBDeliveryLine_TyreInfo implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		
		int TF_Tyre_ID = 0;
		if(mTab.getValue(MTyreRebuttonDeliveryLine.COLUMNNAME_TF_Tyre_ID) != null)
			TF_Tyre_ID = (int) mTab.getValue(MTyreRebuttonDeliveryLine.COLUMNNAME_TF_Tyre_ID);
		
		MTyre tyre = new MTyre(ctx, TF_Tyre_ID, null);
		String size = null;
		String brand = null;
		int TF_TyreType_ID = 0;
		if(TF_Tyre_ID > 0) {
			size = tyre.getSize();
			brand = tyre.getBrand();
			TF_TyreType_ID = tyre.getCurrent_TyreType_ID();
		}
		
		mTab.setValue(MTyreRebuttonDeliveryLine.COLUMNNAME_Size, size);
		mTab.setValue(MTyreRebuttonDeliveryLine.COLUMNNAME_Brand, brand);
		mTab.setValue("TF_TyreType_ID", TF_TyreType_ID);
		return null;
	}

}
