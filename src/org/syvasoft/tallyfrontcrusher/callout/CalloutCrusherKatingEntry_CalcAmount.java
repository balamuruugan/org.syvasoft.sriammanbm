package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MCrusherKatingEntry;

public class CalloutCrusherKatingEntry_CalcAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal load = (BigDecimal) mTab.getValue(MCrusherKatingEntry.COLUMNNAME_TotalLoad);
		BigDecimal tonnage = (BigDecimal) mTab.getValue(MCrusherKatingEntry.COLUMNNAME_Tonnage);
		BigDecimal loadingPrice = (BigDecimal) mTab.getValue(MCrusherKatingEntry.COLUMNNAME_Loading_Price);
		BigDecimal transportPrice = (BigDecimal) mTab.getValue(MCrusherKatingEntry.COLUMNNAME_Transport_Price);
		String katingType = (String) mTab.getValue(MCrusherKatingEntry.COLUMNNAME_KatingEntryType);
		
		BigDecimal LoadingCharge = BigDecimal.ZERO;
		BigDecimal TransportCharge = BigDecimal.ZERO;
		BigDecimal qty = BigDecimal.ZERO;
		
		if(MCrusherKatingEntry.KATINGENTRYTYPE_Load.equals(katingType))
			qty = load;
		else
			qty = tonnage;
		
		if(loadingPrice != null) {
			LoadingCharge = qty.multiply(loadingPrice);
		}
		
		if(transportPrice != null) {
			TransportCharge = qty.multiply(transportPrice);
		}
		
		mTab.setValue(MCrusherKatingEntry.COLUMNNAME_Loading_Amount, LoadingCharge);
		mTab.setValue(MCrusherKatingEntry.COLUMNNAME_Transport_Amount, TransportCharge);
		
		return null;
	}

}
