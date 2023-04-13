package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_CalcRentAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal distance = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Distance);		
		BigDecimal rate = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Rate);		
		BigDecimal tonnage = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Tonnage);;
		Boolean isLumpSumRent = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsLumpSumRent);
		if(!isLumpSumRent) {
			BigDecimal rent = tonnage.multiply(rate);//.multiply(tonnage);
			mTab.setValue(TF_MOrder.COLUMNNAME_Rent_Amt, rent);
		}
		return null;
	}

}
