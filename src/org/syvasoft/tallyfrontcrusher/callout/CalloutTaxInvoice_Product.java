package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.osgi.service.wireadmin.Producer;
import org.syvasoft.tallyfrontcrusher.model.MTaxInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class CalloutTaxInvoice_Product implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int M_Product_ID = 0;
		if(mTab.getValue(MTaxInvoice.COLUMNNAME_M_Product_ID) != null) {
			M_Product_ID = (int) mTab.getValue(MTaxInvoice.COLUMNNAME_M_Product_ID);
			TF_MProduct prod = new TF_MProduct(ctx, M_Product_ID, null);
			mTab.setValue(MTaxInvoice.COLUMNNAME_C_UOM_ID, prod.getC_UOM_ID());
		}
		return null;
	}

}
