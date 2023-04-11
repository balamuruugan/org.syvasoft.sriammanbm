package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;

public class CalloutWeighmentEntry_UOM implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		
		int UOM_ID = 0;
		
		if(mTab.getValue(MWeighmentEntry.COLUMNNAME_M_Product_ID) != null) {
			int Product_ID = (int) mTab.getValue(MWeighmentEntry.COLUMNNAME_M_Product_ID);
			MProduct prod = new MProduct(ctx, Product_ID, null);
			if(mTab.getValue(MWeighmentEntry.COLUMNNAME_WeighmentEntryType) != "1SO") {
				UOM_ID = prod.getC_UOM_ID();
				mTab.setValue(MWeighmentEntry.COLUMNNAME_C_UOM_ID, UOM_ID);
			}
			else {
//				UOM_ID = prod.sales
			}
			
		}
		return null;
	}

}
