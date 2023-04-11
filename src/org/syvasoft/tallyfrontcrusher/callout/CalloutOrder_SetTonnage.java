package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MSysConfig;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_SetTonnage implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mTab.getValue(TF_MOrder.COLUMNNAME_Item1_UOM_ID) != null) {
			int uom_id = (int) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_UOM_ID);
			int tonnage_uom_id = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, Env.getAD_Client_ID(ctx));
			int kg_uom_id = MSysConfig.getIntValue("KG_UOM", 1000070, Env.getAD_Client_ID(ctx));
			if(uom_id == tonnage_uom_id) {
				BigDecimal qty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Qty);
				mTab.setValue(TF_MOrder.COLUMNNAME_Tonnage, qty);
			}
			else if(uom_id == kg_uom_id) {
				BigDecimal qty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Qty);
				mTab.setValue(TF_MOrder.COLUMNNAME_Tonnage, qty.divide(new BigDecimal(1000)));
			}
		}
		return null;
	}

}
