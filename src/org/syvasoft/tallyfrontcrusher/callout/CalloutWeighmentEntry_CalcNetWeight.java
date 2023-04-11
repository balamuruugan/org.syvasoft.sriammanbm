package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MSysConfig;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;

public class CalloutWeighmentEntry_CalcNetWeight implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal netWeight = BigDecimal.ZERO;
		BigDecimal tareWeight = BigDecimal.ZERO; 
		if(mTab.getValue(MWeighmentEntry.COLUMNNAME_TareWeight) != null)
			tareWeight = (BigDecimal) mTab.getValue(MWeighmentEntry.COLUMNNAME_TareWeight);
			
		BigDecimal grossWeight = BigDecimal.ZERO; 
		if(mTab.getValue(MWeighmentEntry.COLUMNNAME_GrossWeight) != null)
			grossWeight = (BigDecimal) mTab.getValue(MWeighmentEntry.COLUMNNAME_GrossWeight);
		
		if(tareWeight.doubleValue() > 0 && grossWeight.doubleValue() > 0)
			netWeight = grossWeight.subtract(tareWeight);
		
		mTab.setValue(MWeighmentEntry.COLUMNNAME_NetWeight, netWeight);
		
		int C_UOM_ID = CalloutUtil.getIntValue(mTab, MWeighmentEntry.COLUMNNAME_C_UOM_ID);
		int M_Product_ID = CalloutUtil.getIntValue(mTab, MWeighmentEntry.COLUMNNAME_M_Product_ID);
		int M_Product_Attribute_ID = CalloutUtil.getIntValue(mTab, MWeighmentEntry.COLUMNNAME_M_Product_Attribute_ID);
		
		int tonnage_uom_id = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, Env.getAD_Client_ID(ctx));
		
		BigDecimal netweightunit = netWeight.divide(new BigDecimal(1000));
		
		if(C_UOM_ID != tonnage_uom_id)
			netweightunit = MWeighmentEntry.qtyUOMConvert(tonnage_uom_id, C_UOM_ID, M_Product_ID, netWeight.divide(new BigDecimal(1000)), M_Product_Attribute_ID);
		
		mTab.setValue(MWeighmentEntry.COLUMNNAME_NetWeightUnit, netweightunit);
		
		return null;
	}
	 
}
