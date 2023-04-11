package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MLabourWageIssue;

public class CalloutLabourWageIssue_CalcBalanceAmts implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal earnedWage = (BigDecimal) mTab.getValue(MLabourWageIssue.COLUMNNAME_Earned_Wage);
		BigDecimal advancePaid = (BigDecimal) mTab.getValue(MLabourWageIssue.COLUMNNAME_Advance_Paid);
		BigDecimal advanceDeduct = (BigDecimal) mTab.getValue(MLabourWageIssue.COLUMNNAME_Advance_Deduct);
		BigDecimal advanceBalance = (BigDecimal) mTab.getValue(MLabourWageIssue.COLUMNNAME_Advance_Balance);
		BigDecimal wagesPaid = (BigDecimal) mTab.getValue(MLabourWageIssue.COLUMNNAME_Wages_Paid);
		BigDecimal wagesBalance = (BigDecimal) mTab.getValue(MLabourWageIssue.COLUMNNAME_Wages_Payable);
		
		advanceBalance = advancePaid.subtract(advanceDeduct);
		if(!mField.getColumnName().equals(MLabourWageIssue.COLUMNNAME_Wages_Paid))
			wagesPaid = earnedWage.subtract(advanceDeduct);
		wagesBalance = earnedWage.subtract(advanceDeduct.add(wagesPaid));
		
		mTab.setValue(MLabourWageIssue.COLUMNNAME_Advance_Balance, advanceBalance);
		mTab.setValue(MLabourWageIssue.COLUMNNAME_Wages_Paid, wagesPaid);
		mTab.setValue(MLabourWageIssue.COLUMNNAME_Wages_Payable, wagesBalance);
		
		return null;
	}

}
