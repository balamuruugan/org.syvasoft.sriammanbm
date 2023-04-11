package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MPermitPurchase;

public class CalloutPermitPurchase_CalcAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal qty = (BigDecimal) mTab.getValue(MPermitPurchase.COLUMNNAME_PermitQty);
		BigDecimal price = (BigDecimal) mTab.getValue(MPermitPurchase.COLUMNNAME_Price);
		mTab.setValue(MPermitPurchase.COLUMNNAME_PermitAmount, qty.multiply(price));
		
		return null;
	}

}
