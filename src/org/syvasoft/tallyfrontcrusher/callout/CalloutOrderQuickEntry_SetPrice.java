package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPricing;
import org.compiere.model.MTax;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrderQuickEntry_SetPrice implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal price = BigDecimal.ZERO;		
		
		if(mField.getColumnName().equals(TF_MOrder.COLUMNNAME_Item1_ID) && value != null
				&& mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID) != null
				&& mTab.getValue(TF_MOrder.COLUMNNAME_DateAcct) != null
				&& mTab.getValue(TF_MOrder.COLUMNNAME_M_PriceList_ID) != null) {
			int bPartner_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID);
			Timestamp dateAcct = (Timestamp) mTab.getValue(TF_MOrder.COLUMNNAME_DateAcct);
			int product_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_ID);
			int priceList_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_M_PriceList_ID);
			boolean isSOTrx = Env.getContext(ctx, WindowNo, "IsSOTrx").equals("Y");
			BigDecimal qty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Qty);
			
			MProductPricing pp = TF_MOrder.getProductPricing(product_ID, priceList_ID, bPartner_ID, qty, dateAcct, isSOTrx);
			price = pp.getPriceStd();
			if(price == null)
				price = BigDecimal.ZERO;
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Price, price);
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_UnitPrice, price);
			if(qty != null)
				mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Amt, price.multiply(qty).divide(BigDecimal.ONE, 2, RoundingMode.HALF_UP));
			
			MProduct prod = MProduct.get(ctx, product_ID);
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_UOM_ID, prod.getC_UOM_ID());
			int defaultTaxID = Env.getContextAsInt(ctx, "#C_Tax_ID");
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Tax_ID, defaultTaxID);
		}
		
		if(mField.getColumnName().equals(TF_MOrder.COLUMNNAME_Item2_ID) && value != null
				&& mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID) != null
				&& mTab.getValue(TF_MOrder.COLUMNNAME_DateAcct) != null
				&& mTab.getValue(TF_MOrder.COLUMNNAME_M_PriceList_ID) != null) {
			int bPartner_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID);
			Timestamp dateAcct = (Timestamp) mTab.getValue(TF_MOrder.COLUMNNAME_DateAcct);
			int product_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_ID);
			int priceList_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_M_PriceList_ID);
			boolean isSOTrx = Env.getContext(ctx, WindowNo, "IsSOTrx").equals("Y");
			BigDecimal qty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_Qty);
			
			MProductPricing pp = TF_MOrder.getProductPricing(product_ID, priceList_ID, bPartner_ID, qty, dateAcct, isSOTrx);
			price = pp.getPriceStd();
			if(price == null)
				price = BigDecimal.ZERO;
			mTab.setValue(TF_MOrder.COLUMNNAME_Item2_Price, price);
			mTab.setValue(TF_MOrder.COLUMNNAME_Item2_Amt, price.multiply(qty).divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN));		
			
			MProduct prod = MProduct.get(ctx, product_ID);
			mTab.setValue(TF_MOrder.COLUMNNAME_Item2_UOM_ID, prod.getC_UOM_ID());
			int defaultTaxID = Env.getContextAsInt(ctx, "#C_Tax_ID");
			mTab.setValue(TF_MOrder.COLUMNNAME_Item2_Tax_ID, defaultTaxID);
			
		}
		return null;
	}

}
