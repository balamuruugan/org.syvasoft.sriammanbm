package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProductPricing;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrderQuickEntry_CalcAmt implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
	BigDecimal price = BigDecimal.ZERO;
	BigDecimal qty = BigDecimal.ONE;
		
		if(mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Qty) != null && mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Price) != null) {			
			qty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Qty);
			price = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Price);			
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Amt, price.multiply(qty).divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN));			
		}
		
		if(mTab.getValue(TF_MOrder.COLUMNNAME_Item2_Qty) != null && mTab.getValue(TF_MOrder.COLUMNNAME_Item2_Price) != null) {			
			qty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_Qty);
			price = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_Price);			
			mTab.setValue(TF_MOrder.COLUMNNAME_Item2_Amt, price.multiply(qty).divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN));			
		}
		return null;
	}

}
