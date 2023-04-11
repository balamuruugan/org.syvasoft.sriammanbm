package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;
import org.compiere.model.MProductCategory;
import org.compiere.model.MProductPricing;
import org.compiere.model.MTax;
import org.compiere.model.M_Registration;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MPriceListUOM;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;


public class CalloutOrder_Item1Tax implements IColumnCallout{

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {		
		if(value != null){
			boolean isSOTrx = Env.getContext(ctx, WindowNo, "IsSOTrx").equals("Y");
			
			if(isSOTrx) {
				BigDecimal unitPrice = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_UnitPrice);
				boolean isRentBreakup = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsRentBreakup);
				boolean isRentInclusive = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsRentInclusive);
				
			if((boolean)mTab.getValue(TF_MOrder.COLUMNNAME_IsSOTrx) == true) {
				if(mTab.getValue(TF_MOrder.COLUMNNAME_IsTaxIncluded1) != null &&
						((boolean)mTab.getValue(TF_MOrder.COLUMNNAME_IsTaxIncluded1)) == true) {
					BigDecimal priceExcludesTax;
					int tax_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Tax_ID);
					MTax tax = new MTax(ctx, tax_ID, null);
					BigDecimal taxRate = (BigDecimal)tax.getRate();
					BigDecimal hundred = new BigDecimal("100");
					
					BigDecimal price = unitPrice;				
					BigDecimal unitRent = BigDecimal.ZERO;
					BigDecimal rentAmount = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Rent_Amt);
					BigDecimal qty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Qty);
					
					if(qty.doubleValue() != 0)
						unitRent = rentAmount.divide(qty,2,RoundingMode.HALF_UP);
					
					if(isRentInclusive) { 
						if(isRentBreakup) {
							price = unitPrice.subtract(unitRent);
						}
						else {
							price = unitPrice;
						}
					}
					else {
						if(isRentBreakup) {
							price = unitPrice;
						}
						else {
							price = unitPrice.add(unitRent);
						}
					}
					
					priceExcludesTax = price.divide(BigDecimal.ONE.add(taxRate.divide(hundred,2,RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);
					mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Price, priceExcludesTax);
				}
				else {
					BigDecimal price = BigDecimal.ZERO;		
					
					if((mField.getColumnName().equals(TF_MOrder.COLUMNNAME_Item1_ID) || mField.getColumnName().equals(TF_MOrder.COLUMNNAME_IsTaxIncluded1)) && value != null
							&& mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID) != null
							&& mTab.getValue(TF_MOrder.COLUMNNAME_DateAcct) != null
							&& mTab.getValue(TF_MOrder.COLUMNNAME_M_PriceList_ID) != null) {
						BigDecimal qty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Qty);
						unitPrice = (BigDecimal)mTab.getValue(TF_MOrder.COLUMNNAME_Item1_UnitPrice);
											
						BigDecimal unitRent = BigDecimal.ZERO;
						BigDecimal rentAmount = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Rent_Amt);
						
						if(qty.doubleValue() != 0)
							unitRent = rentAmount.divide(qty,2,RoundingMode.HALF_UP);
						
						if(isRentInclusive) { 
							if(isRentBreakup) {
								price = unitPrice.subtract(unitRent);
							}
							else {
								price = unitPrice;
							}
						}
						else {
							if(isRentBreakup) {
								price = unitPrice;
							}
							else {
								price = unitPrice.add(unitRent);
							}
						}
						
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Price, price);
						if(qty != null)
							mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Amt, price.multiply(qty).divide(BigDecimal.ONE, 2, RoundingMode.HALF_UP));
					}
				}
			}
			}
		}
		return null;
	}
}
