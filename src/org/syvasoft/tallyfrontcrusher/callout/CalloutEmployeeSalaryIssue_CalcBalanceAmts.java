package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MEmployeeSalaryIssue;

public class CalloutEmployeeSalaryIssue_CalcBalanceAmts implements
		IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		BigDecimal salaryPaid = (BigDecimal) mTab.getValue(MEmployeeSalaryIssue.COLUMNNAME_Salary_Paid);
		BigDecimal bank = CalloutUtil.getBDValue(mTab, MEmployeeSalaryIssue.COLUMNNAME_IssuedBankAmt);
		BigDecimal cash = CalloutUtil.getBDValue(mTab, MEmployeeSalaryIssue.COLUMNNAME_IssuedCashAmt);
		
		if(mField.getColumnName().equals(MEmployeeSalaryIssue.COLUMNNAME_IssuedBankAmt)) {
			cash = salaryPaid.subtract(bank);
			mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_IssuedCashAmt, cash);
			return null;
		}
		else if(mField.getColumnName().equals(MEmployeeSalaryIssue.COLUMNNAME_IssuedCashAmt)) {
			bank = salaryPaid.subtract(cash);
			mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_IssuedBankAmt, bank);
			return null;
		}
		
		BigDecimal salaryAmt = (BigDecimal) mTab.getValue(MEmployeeSalaryIssue.COLUMNNAME_Salary_Amt);
		BigDecimal loanPaid = (BigDecimal) mTab.getValue(MEmployeeSalaryIssue.COLUMNNAME_Loan_Paid);
		BigDecimal loanDeduct = (BigDecimal) mTab.getValue(MEmployeeSalaryIssue.COLUMNNAME_Loan_Deduct);
		BigDecimal loanBalance = (BigDecimal) mTab.getValue(MEmployeeSalaryIssue.COLUMNNAME_Loan_Balance);
		BigDecimal advancePaid = (BigDecimal) mTab.getValue(MEmployeeSalaryIssue.COLUMNNAME_Advance_Paid);
		BigDecimal advanceDeduct = (BigDecimal) mTab.getValue(MEmployeeSalaryIssue.COLUMNNAME_Advance_Deduct);
		BigDecimal advanceBalance = (BigDecimal) mTab.getValue(MEmployeeSalaryIssue.COLUMNNAME_Advance_Balance);		
		BigDecimal salaryBalance = (BigDecimal) mTab.getValue(MEmployeeSalaryIssue.COLUMNNAME_Salary_Payable);
		BigDecimal pfAmt = CalloutUtil.getBDValue(mTab, MEmployeeSalaryIssue.COLUMNNAME_PFAmt);
		
		loanBalance = loanPaid.subtract(loanDeduct);
		advanceBalance = advancePaid.subtract(advanceDeduct);
		
		
		if(!mField.getColumnName().equals(MEmployeeSalaryIssue.COLUMNNAME_Salary_Paid))
			salaryPaid = salaryAmt.subtract(advanceDeduct).subtract(loanDeduct).subtract(pfAmt);
		salaryBalance = salaryAmt.subtract(advanceDeduct.add(salaryPaid).add(loanDeduct));
		
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Loan_Balance, loanBalance);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Advance_Balance, advanceBalance);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Salary_Paid, salaryPaid);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Salary_Payable, salaryBalance);
		
		BigDecimal basicSalary = CalloutUtil.getBDValue(mTab, MEmployeeSalaryIssue.COLUMNNAME_BasicSalary);
		
		
		bank = basicSalary.subtract(pfAmt);
		cash = BigDecimal.ZERO;
		if(salaryPaid.doubleValue() < bank.doubleValue()) {
			bank = salaryPaid;
		}
		cash = salaryPaid.subtract(bank);
		
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_IssuedBankAmt, bank);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_IssuedCashAmt, cash);
		
		
		
		return null;
	}

}
