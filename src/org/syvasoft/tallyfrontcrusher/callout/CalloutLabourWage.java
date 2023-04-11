package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MLabourWage;
import org.syvasoft.tallyfrontcrusher.model.MLabourWageConfig;


public class CalloutLabourWage implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal stdDays = BigDecimal.ZERO;
		BigDecimal stdWage = BigDecimal.ZERO;		
		BigDecimal presentDays = BigDecimal.ZERO;
		int vehicleType_ID = 0;
		boolean isCalculated = mTab.getValueAsBoolean(MLabourWage.COLUMNNAME_IsCalculated);
		
		if(mTab.getValue(MLabourWage.COLUMNNAME_TF_VehicleType_ID) != null)
			vehicleType_ID = (int) mTab.getValue(MLabourWage.COLUMNNAME_TF_VehicleType_ID);
		
		if(mTab.getValue(MLabourWage.COLUMNNAME_Present_Days) != null)
			presentDays = (BigDecimal) mTab.getValue(MLabourWage.COLUMNNAME_Present_Days);
		
		if(value == null || mTab.getValue(MLabourWage.COLUMNNAME_DateAcct) == null 
				|| mTab.getValue(MLabourWage.COLUMNNAME_C_BPartner_ID) == null) {
			mTab.setValue(MLabourWage.COLUMNNAME_Std_Days, stdDays);
			mTab.setValue(MLabourWage.COLUMNNAME_Std_Wage, stdWage);
			mTab.setValue(MLabourWage.COLUMNNAME_Earned_Wage, BigDecimal.ZERO);		
		}
		else {
			Timestamp dateAcct = null;
			dateAcct = (Timestamp) mTab.getValue(MLabourWage.COLUMNNAME_DateAcct);		
			int bpartner_ID = (int)  mTab.getValue(MLabourWage.COLUMNNAME_C_BPartner_ID);			
			MLabourWageConfig wageConfig = MLabourWageConfig.getLabourWageConfig(ctx, bpartner_ID, vehicleType_ID, dateAcct);
			
			if(wageConfig != null && isCalculated) {
				stdDays = wageConfig.getStd_Days();
				stdWage = wageConfig.getStd_Wage();
			}
			
			BigDecimal earnedWage = (BigDecimal) mTab.getValue(MLabourWage.COLUMNNAME_Earned_Wage);
			if(stdDays.doubleValue() !=0 && isCalculated)
				earnedWage = stdWage.multiply(presentDays.divide(stdDays));
			
			mTab.setValue(MLabourWage.COLUMNNAME_Std_Days, stdDays);
			mTab.setValue(MLabourWage.COLUMNNAME_Std_Wage, stdWage);
			mTab.setValue(MLabourWage.COLUMNNAME_Earned_Wage, earnedWage);
			
			BigDecimal incentive = BigDecimal.ZERO;
			if(mTab.getValue(MLabourWage.COLUMNNAME_Incentive) != null)
				incentive = (BigDecimal) mTab.getValue(MLabourWage.COLUMNNAME_Incentive);
			
			mTab.setValue(MLabourWage.COLUMNNAME_Total_Wage, earnedWage.add(incentive));
		}
		return null;
	}

}
