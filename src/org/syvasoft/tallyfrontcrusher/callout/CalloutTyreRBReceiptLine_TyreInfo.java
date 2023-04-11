package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTyreRebuttonDeliveryLine;
import org.syvasoft.tallyfrontcrusher.model.MTyreRebuttonReceiptLine;

public class CalloutTyreRBReceiptLine_TyreInfo implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		int rbDeliveryLine_ID = 0;
		if(mTab.getValue(MTyreRebuttonReceiptLine.COLUMNNAME_TF_Tyre_RBDeliveryLine_ID) != null)
			rbDeliveryLine_ID = (int) mTab.getValue(MTyreRebuttonReceiptLine.COLUMNNAME_TF_Tyre_RBDeliveryLine_ID);
		MTyreRebuttonDeliveryLine rbDelivery = new MTyreRebuttonDeliveryLine(ctx, rbDeliveryLine_ID, null);
		mTab.setValue(MTyreRebuttonReceiptLine.COLUMNNAME_Brand, rbDelivery.getBrand());
		mTab.setValue(MTyreRebuttonReceiptLine.COLUMNNAME_Size, rbDelivery.getSize());
		mTab.setValue(MTyreRebuttonReceiptLine.COLUMNNAME_TF_TyreType_ID, rbDelivery.getNew_TF_TyreType_ID());
		return null;
	}

}
