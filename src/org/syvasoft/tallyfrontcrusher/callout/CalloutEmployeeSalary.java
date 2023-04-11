package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MEmployeeIncentive;
import org.syvasoft.tallyfrontcrusher.model.MEmployeeSalaryOld;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;

public class CalloutEmployeeSalary implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal stdDays = CalloutUtil.getBDValue(mTab, MEmployeeSalaryOld.COLUMNNAME_Std_Days);
		BigDecimal stdWage = BigDecimal.ZERO;
		BigDecimal presentDays = BigDecimal.ZERO;
		int AD_Org_ID = CalloutUtil.getIntValue(mTab, MEmployeeSalaryOld.COLUMNNAME_AD_Org_ID);
		boolean isCalculated = mTab.getValueAsBoolean(MEmployeeSalaryOld.COLUMNNAME_IsCalculated);		
		BigDecimal incentiveEligibleDays = BigDecimal.ZERO;
		BigDecimal incentiveDays = BigDecimal.ZERO;
		boolean incentiveAsDayWage = true;
		BigDecimal earnedSalary = BigDecimal.ZERO; 
		
		
		presentDays = CalloutUtil.getBDValue(mTab, MEmployeeSalaryOld.COLUMNNAME_Present_Days);
		int bpartner_ID = CalloutUtil.getIntValue(mTab, MEmployeeSalaryOld.COLUMNNAME_C_BPartner_ID);		
		MEmployeeIncentive inc = MEmployeeIncentive.get(ctx, AD_Org_ID, MEmployeeIncentive.INCENTIVETYPE_Month);
		
		BigDecimal incentiveAmt = BigDecimal.ZERO;
		
		if(inc != null) {
			incentiveAsDayWage = inc.isIncentiveAsDayWage();
			incentiveEligibleDays = inc.getEligibleUnit();
			if(presentDays.doubleValue() >= incentiveEligibleDays.doubleValue())
				incentiveDays = stdDays.subtract(incentiveEligibleDays);	
			
			if(incentiveDays.doubleValue() >= 4)
				incentiveDays = new BigDecimal(4);
		}
		
		
		if(bpartner_ID > 0) {
							
			TF_MBPartner bp = new TF_MBPartner(ctx, bpartner_ID, null);
			//stdWage = bp.getStd_Wage();
			
			if(bp.getStd_Wage() == null || stdWage.doubleValue() == 0) {
				mTab.setValue(MEmployeeSalaryOld.COLUMNNAME_MonthlySalaryAmt, bp.getStd_Wage());
				BigDecimal monthlySalary = bp.getStd_Wage();
				BigDecimal workingDays = stdDays;
				if(workingDays.doubleValue() == 0 )
					workingDays = BigDecimal.ONE;
				stdWage = monthlySalary.divide(workingDays, 2, RoundingMode.HALF_EVEN);
			}
			
			earnedSalary = CalloutUtil.getBDValue(mTab, MEmployeeSalaryOld.COLUMNNAME_Salary_Amt);
			
			incentiveAmt = incentiveDays.multiply(stdWage);
					
			if(stdDays.doubleValue() !=0  && isCalculated)
				earnedSalary = stdWage.multiply(presentDays).setScale(0, RoundingMode.HALF_UP);
			else if(isCalculated)
				earnedSalary = BigDecimal.ZERO;
				
		}
		earnedSalary = earnedSalary.setScale(-1, RoundingMode.HALF_UP);
		incentiveAmt = incentiveAmt.setScale(-1, RoundingMode.HALF_UP);
		mTab.setValue(MEmployeeSalaryOld.COLUMNNAME_Std_Days, stdDays);
		mTab.setValue(MEmployeeSalaryOld.COLUMNNAME_Std_Wage, stdWage);
		mTab.setValue(MEmployeeSalaryOld.COLUMNNAME_Salary_Amt, earnedSalary);
		mTab.setValue(MEmployeeSalaryOld.COLUMNNAME_IncentiveDays, incentiveDays);
		mTab.setValue(MEmployeeSalaryOld.COLUMNNAME_IncentiveEligibleDays, incentiveEligibleDays);
		mTab.setValue(MEmployeeSalaryOld.COLUMNNAME_Incentive, incentiveAmt);
		return null;
	}

	
}
