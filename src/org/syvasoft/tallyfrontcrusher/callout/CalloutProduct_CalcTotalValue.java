package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class CalloutProduct_CalcTotalValue implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal qty = (BigDecimal) mTab.getValue(TF_MProduct.COLUMNNAME_Qty);
		BigDecimal price = (BigDecimal) mTab.getValue(TF_MProduct.COLUMNNAME_Price);
		mTab.setValue(TF_MProduct.COLUMNNAME_ValueNumber, qty.multiply(price));
		return null;
	}

}
