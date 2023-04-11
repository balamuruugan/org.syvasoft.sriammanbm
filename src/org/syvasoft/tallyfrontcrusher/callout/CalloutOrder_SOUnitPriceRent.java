package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MSysConfig;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_SOUnitPriceRent implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		boolean isSOTrx = Env.getContext(ctx, WindowNo, "IsSOTrx").equals("Y");
		
		if(isSOTrx) {
			BigDecimal unitPrice = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_UnitPrice);			
			BigDecimal rentAmount = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Rent_Amt);
			BigDecimal qty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_Qty);
			if(qty.equals(BigDecimal.ZERO))
				qty = BigDecimal.ONE;
			BigDecimal unitRent = BigDecimal.ZERO;
			if(qty.doubleValue() != 0)
				unitRent = rentAmount.divide(qty,2,RoundingMode.HALF_UP);
			
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_UnitRent, unitRent);
			BigDecimal price = unitPrice;
			boolean isRentBreakup = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsRentBreakup);
			boolean isRentInclusive = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsRentInclusive);
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
			String orgType = (String) mTab.getValue(TF_MOrder.COLUMNNAME_OrgType);
			
			
			//Calculate Pass Unit Price
			//based on the item 2 Royalty pass amount, unit price has to be calculate dn set it here.
			
			int AD_Org_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_AD_Org_ID);
			int Item2_ID = 0;
			if(mTab.getValue(TF_MOrder.COLUMNNAME_Item2_ID) != null)
				Item2_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_ID);
			
			if(Item2_ID ==  MSysConfig.getIntValue("ROYALTY_PASS_PRODUCT_ID", 1000329, Env.getAD_Client_ID(ctx), AD_Org_ID)) {
			
				BigDecimal RoyaltyPassAmount = BigDecimal.ZERO;
				if(mTab.getValue(TF_MOrder.COLUMNNAME_Item2_Amt) != null)
					RoyaltyPassAmount = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_Amt);
				BigDecimal RoyaltyPassUnitPrice = BigDecimal.ZERO;
				if(qty.doubleValue() != 0)
					RoyaltyPassUnitPrice = RoyaltyPassAmount.divide(qty,2,RoundingMode.HALF_UP);
				
				boolean isRoyaltyPassInclusive = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsRoyaltyPassInclusive);
				boolean isRoyaltyPassBreakup = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsRoyaltyPassBreakup);
				
				mTab.setValue(TF_MOrder.COLUMNNAME_Item1_PassUnitPrice, RoyaltyPassUnitPrice);
				
				if(isRoyaltyPassInclusive) {
					if(isRoyaltyPassBreakup)
						price = price.subtract(RoyaltyPassUnitPrice);					
				}
				else {					
					if(!isRoyaltyPassBreakup)
						price = price.add(RoyaltyPassUnitPrice);										
				}
			
			}
			
			if(orgType != null)
			{
				if(orgType.equals(TF_MOrder.ORGTYPE_SandBlockWeighbridge)) {
					MWeighmentEntry weighment = null;
					if(mTab.getValue(TF_MOrder.COLUMNNAME_TF_WeighmentEntry_ID) != null) {
						int weighment_id = (int) mTab.getValue(TF_MOrder.COLUMNNAME_TF_WeighmentEntry_ID);
						weighment = new MWeighmentEntry(ctx, weighment_id, null);
					}
					if(weighment != null && weighment.getPrice() != null) 
						price = weighment.getPrice();
				}
				mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Price, price);
				mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Amt, price.multiply(qty).setScale(2, RoundingMode.HALF_EVEN));
			}
		}
		return null;
	}

}
