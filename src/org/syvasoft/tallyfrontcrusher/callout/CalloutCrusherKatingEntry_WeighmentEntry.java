package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MCrusherKatingConfig;
import org.syvasoft.tallyfrontcrusher.model.MCrusherKatingEntry;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;

public class CalloutCrusherKatingEntry_WeighmentEntry implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		//Set Kating Entry Type, Product, Warehouse, Tonnage, Load,
		//Vehicle
		
		if(mTab.getValue(MCrusherKatingEntry.COLUMNNAME_TF_WeighmentEntry_ID) != null) {
			int TF_WeighmentEntry_ID = (int) mTab.getValue(MCrusherKatingEntry.COLUMNNAME_TF_WeighmentEntry_ID);
			MWeighmentEntry wEntry = new MWeighmentEntry(ctx, TF_WeighmentEntry_ID, null);
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_M_Warehouse_ID, wEntry.getM_Warehouse_ID());
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_M_Product_ID, wEntry.getM_Product_ID());
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_Tonnage, wEntry.getNetWeight().divide(new BigDecimal(1000)));
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_TotalLoad, BigDecimal.ONE);
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_TF_RentedVehicle_ID, wEntry.getTF_RentedVehicle_ID());
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_DateAcct, wEntry.getGrossWeightTime());
			mTab.setValue(MCrusherKatingEntry.COLUMNNAME_Description, wEntry.getDescription());
			
		}
		
		return null;
	}

}
