package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MToken;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class CalloutToken_SetUOM implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int M_Product_ID=0;
		if(mTab.getValue(MToken.COLUMNNAME_M_Product_ID)!=null) {
			M_Product_ID=(int)mTab.getValue(MToken.COLUMNNAME_M_Product_ID);	
		}
		
		TF_MProduct prod=new TF_MProduct(ctx, M_Product_ID, null);
		
		if(prod!=null) {
			mTab.setValue(MToken.COLUMNNAME_C_UOM_ID, prod.getC_UOM_ID());
		}		
		return null;
	}

}




