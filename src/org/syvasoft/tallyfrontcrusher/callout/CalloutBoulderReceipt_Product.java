package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;

public class CalloutBoulderReceipt_Product implements IColumnCallout {
	
	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int M_Product_ID = 0;
		int C_UOM_ID = 0;
		if(mTab.getValue(MBoulderReceipt.COLUMNNAME_M_Product_ID) != null) {
			M_Product_ID = (int) mTab.getValue(MBoulderReceipt.COLUMNNAME_M_Product_ID);
			MProduct prod = MProduct.get(ctx, M_Product_ID);
			C_UOM_ID = prod.getC_UOM_ID();
		}
		mTab.setValue(MBoulderReceipt.COLUMNNAME_C_UOM_ID, C_UOM_ID == 0 ? null : C_UOM_ID);
		return null;
	}

}
