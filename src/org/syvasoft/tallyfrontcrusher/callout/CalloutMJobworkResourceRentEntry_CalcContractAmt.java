package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MJobworkIssuedResource;
import org.syvasoft.tallyfrontcrusher.model.MJobworkResourceRentEntry;

public class CalloutMJobworkResourceRentEntry_CalcContractAmt implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal qty = BigDecimal.ZERO;
		BigDecimal unitPrice = BigDecimal.ZERO;
		BigDecimal contractAmt;
		
		int TF_Jobwork_IssuedResource_ID = 0;
		if(mTab.getValue(MJobworkResourceRentEntry.COLUMNNAME_TF_Jobwork_IssuedResource_ID) != null)
			TF_Jobwork_IssuedResource_ID = (int) mTab.getValue(MJobworkResourceRentEntry.COLUMNNAME_TF_Jobwork_IssuedResource_ID);
		
		if(mTab.getValue(MJobworkResourceRentEntry.COLUMNNAME_Qty) != null)
			qty = (BigDecimal) mTab.getValue(MJobworkResourceRentEntry.COLUMNNAME_Qty);
		
		if(mField.getColumnName().equals(MJobworkResourceRentEntry.COLUMNNAME_Qty)) {					
			MJobworkIssuedResource issuedRes = new MJobworkIssuedResource(ctx, TF_Jobwork_IssuedResource_ID, null);
			unitPrice = issuedRes.getUnit_Price();
			mTab.setValue(MJobworkResourceRentEntry.COLUMNNAME_Unit_Price, unitPrice);
		}
		else { //user modified unit price should be taken, not standrad unit price from parent tab.
			unitPrice = (BigDecimal) mTab.getValue(MJobworkResourceRentEntry.COLUMNNAME_Unit_Price);
		}
		contractAmt = qty.multiply(unitPrice);
		
				
		mTab.setValue(MJobworkResourceRentEntry.COLUMNNAME_Contract_Amt_Act, contractAmt);
		
		return null;
	}

}
