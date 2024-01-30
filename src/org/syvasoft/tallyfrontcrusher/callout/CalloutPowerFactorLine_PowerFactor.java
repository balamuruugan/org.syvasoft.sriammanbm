package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MPowerFactorLine;

public class CalloutPowerFactorLine_PowerFactor implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		BigDecimal openingKWH = CalloutUtil.getBDValue(mTab, MPowerFactorLine.COLUMNNAME_openingkwh);
		BigDecimal closingKWH = CalloutUtil.getBDValue(mTab, MPowerFactorLine.COLUMNNAME_closingkwh);
		BigDecimal openingKVAH = CalloutUtil.getBDValue(mTab, MPowerFactorLine.COLUMNNAME_openingkvah);
		BigDecimal closingKVAH  = CalloutUtil.getBDValue(mTab, MPowerFactorLine.COLUMNNAME_closingkvah);
		BigDecimal Tonnage =CalloutUtil.getBDValue(mTab, MPowerFactorLine.COLUMNNAME_Tonnage);
		BigDecimal UnitPrice=CalloutUtil.getBDValue(mTab, MPowerFactorLine.COLUMNNAME_Unit_Price);
		
		BigDecimal diffKWH = closingKWH.subtract(openingKWH);
		BigDecimal diffKVAH = closingKVAH.subtract(openingKVAH);
		
		BigDecimal pf = BigDecimal.ZERO;
		BigDecimal Unit=BigDecimal.ZERO;
		//BigDecimal TonnMT=BigDecimal.ZERO;
		BigDecimal UnitMt=BigDecimal.ZERO;
		BigDecimal EBCost=BigDecimal.ZERO;
		
		if(diffKWH.doubleValue() > 0)
			Unit=diffKWH.multiply(new BigDecimal(800));
		if(diffKVAH.doubleValue() > 0)
			pf = diffKWH.divide(diffKVAH, 2, RoundingMode.HALF_EVEN);
		if(Tonnage.doubleValue()>0 && Unit.doubleValue()>0)
			//TonnMT=Tonnage.divide(new BigDecimal(1000));
			UnitMt=Unit.divide(Tonnage, 2, RoundingMode.HALF_EVEN);
		if(Unit.doubleValue()>0 && UnitPrice.doubleValue()>0)
			EBCost=Unit.multiply(UnitPrice);
		
		mTab.setValue(MPowerFactorLine.COLUMNNAME_kwhusage, diffKWH);
		mTab.setValue(MPowerFactorLine.COLUMNNAME_Units, Unit);
		mTab.setValue(MPowerFactorLine.COLUMNNAME_kvahusage, diffKVAH);
		mTab.setValue(MPowerFactorLine.COLUMNNAME_powerfactor, pf);
		mTab.setValue(MPowerFactorLine.COLUMNNAME_UnitPerMT, UnitMt);
		mTab.setValue(MPowerFactorLine.COLUMNNAME_EBCost, EBCost);
		return null;
	}

}
