package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class CalloutWeighmentEntry_CalcAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal qty = CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_NetWeightUnit);
		BigDecimal price = CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_GrossPrice);
		BigDecimal rentprice = CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_GrossRent);
		BigDecimal passqty = CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_PermitIssuedQty);
		BigDecimal passprice = CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_PassPricePerUnit);
		BigDecimal billprice = CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_BillPrice);
		BigDecimal otherCharges = CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_OtherCharges);
		
		int passID = CalloutUtil.getIntValue(mTab, MWeighmentEntry.COLUMNNAME_M_Product_Pass_ID);;
		int freight_uom_id = CalloutUtil.getIntValue(mTab, MWeighmentEntry.COLUMNNAME_FreightRule_ID);
		int C_UOM_ID = CalloutUtil.getIntValue(mTab, MWeighmentEntry.COLUMNNAME_C_UOM_ID);
		
		boolean isTaxIncluded = (boolean) mTab.getValue(MWeighmentEntry.COLUMNNAME_IsTaxIncluded);
		boolean isRentIncludesTax = (boolean) mTab.getValue(MWeighmentEntry.COLUMNNAME_RentIncludesTax);
		
		BigDecimal PassAmount = BigDecimal.ZERO;
		BigDecimal priceExcludesTax = BigDecimal.ZERO;
		BigDecimal rentExcludesTax = BigDecimal.ZERO;
		
		TF_MProduct prod=new TF_MProduct(ctx, CalloutUtil.getIntValue(mTab, MWeighmentEntry.COLUMNNAME_M_Product_ID), null);
		MTax tax = new MTax(ctx, prod.getTax_ID(true, false), null);				
		BigDecimal taxRate = tax.getRate();
		BigDecimal hundred = new BigDecimal("100");
		
		if(isTaxIncluded) {
			priceExcludesTax = price.divide(BigDecimal.ONE.add(taxRate.divide(hundred,2,RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);	
		}
		else {
			priceExcludesTax = price;	
		}
		
		if(isRentIncludesTax) {
			rentExcludesTax = rentprice.divide(BigDecimal.ONE.add(taxRate.divide(hundred,2,RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);	
		}
		else {
			rentExcludesTax = rentprice;	
		}
			
		BigDecimal Amount = qty.multiply(priceExcludesTax);
		
		if(passqty != null && passprice != null) {
			PassAmount = passqty.multiply(passprice);
		}
		
		BigDecimal GrandTotalAmt = BigDecimal.ZERO;
		BigDecimal RentAmount = BigDecimal.ZERO;// CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_Rent_Amt);
		
		if(passID > 0) {
			PassAmount = passqty.multiply(passprice);
		}
		
		if(freight_uom_id > 0) {
			//int KM_UOM_ID = MSysConfig.getIntValue("KM_UOM", 1000071, Env.getAD_Client_ID(ctx));
			//int MT_KM_UOM_ID = MSysConfig.getIntValue("MT_KM_UOM", 1000093, Env.getAD_Client_ID(ctx));
			int MT_UOM_ID = MSysConfig.getIntValue("MT_KM_UOM", 1000069, Env.getAD_Client_ID(ctx));
			int LOAD_UOM_ID = MSysConfig.getIntValue("MT_KM_UOM", 1000072, Env.getAD_Client_ID(ctx));
			
			if(freight_uom_id == LOAD_UOM_ID) {
				RentAmount = rentExcludesTax;
			}	
			else if(freight_uom_id == MT_UOM_ID || C_UOM_ID == freight_uom_id) {
				RentAmount = rentExcludesTax.multiply(qty);
			}
		}
		
		
		BigDecimal GstAmt = BigDecimal.ZERO;		
		
		BigDecimal TCSAmt = BigDecimal.ZERO;
		
		BigDecimal driverTips = CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_DriverTips);
		
		
		BigDecimal discountAmt = CalloutUtil.getBDValue(mTab,MWeighmentEntry.COLUMNNAME_DiscountAmount);
		BigDecimal gstrate = CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_GSTRate);
		Boolean ApplyTax = mTab.getValueAsBoolean(MWeighmentEntry.COLUMNNAME_IsPermitSales);
		Boolean ApplyTCS = mTab.getValueAsBoolean(MWeighmentEntry.COLUMNNAME_ApplyTCS);
		Boolean BillPriceGST = mTab.getValueAsBoolean(MWeighmentEntry.COLUMNNAME_BillPriceGST);
		Boolean IncludePassAmtInvoice = mTab.getValueAsBoolean(MWeighmentEntry.COLUMNNAME_IncludePassAmtInvoice);
		
		BigDecimal unitPrice = BigDecimal.ZERO;
		BigDecimal amt = BigDecimal.ZERO;
		
		if(ApplyTax) {
			if(IncludePassAmtInvoice) {
				amt = PassAmount;
			}
			GstAmt = amt.add(RentAmount).add(Amount).add(otherCharges).multiply(gstrate.divide(new BigDecimal(100))).setScale(2, RoundingMode.HALF_EVEN);
		}
		else if(BillPriceGST) {
			GstAmt = (billprice.multiply(qty)).multiply(gstrate.divide(new BigDecimal(100))).setScale(2, RoundingMode.HALF_EVEN);
		}
		
		BigDecimal TotalAmount = BigDecimal.ZERO;
		
		if(ApplyTax) {
			TotalAmount = Amount.add(GstAmt).add(RentAmount).add(otherCharges);
			//if(IncludePassAmtInvoice) 
			{
				TotalAmount = TotalAmount.add(PassAmount);
			}
		}
		else if(BillPriceGST) {
			TotalAmount = (billprice.multiply(qty)).add(GstAmt);
		}
		
		if(ApplyTCS && (ApplyTax || BillPriceGST)) {
			TCSAmt = TotalAmount.multiply(new BigDecimal(0.001)).setScale(2, RoundingMode.HALF_EVEN);
		}
			
		BigDecimal SalesAmt = Amount.add(RentAmount).add(PassAmount).add(GstAmt).add(TCSAmt);
		GrandTotalAmt = Amount.add(RentAmount).add(PassAmount).add(otherCharges).add(GstAmt).add(TCSAmt).subtract(driverTips).subtract(discountAmt);
		
		mTab.setValue(MWeighmentEntry.COLUMNNAME_Price, priceExcludesTax);
		mTab.setValue(MWeighmentEntry.COLUMNNAME_FreightPrice, rentExcludesTax);	
		mTab.setValue(MWeighmentEntry.COLUMNNAME_Rent_Amt, RentAmount);
		mTab.setValue(MWeighmentEntry.COLUMNNAME_GSTAmount, GstAmt);		
		mTab.setValue(MWeighmentEntry.COLUMNNAME_Amount, Amount);
		mTab.setValue(MWeighmentEntry.COLUMNNAME_PermitPassAmount, PassAmount);
		mTab.setValue(MWeighmentEntry.COLUMNNAME_TotalAmt, GrandTotalAmt);
		mTab.setValue(MWeighmentEntry.COLUMNNAME_SalesAmt, SalesAmt);
		mTab.setValue(MWeighmentEntry.COLUMNNAME_TCSAmount, TCSAmt);
		return null;
	}
}
