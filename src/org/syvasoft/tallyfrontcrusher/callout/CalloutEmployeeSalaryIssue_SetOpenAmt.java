package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.net.ProtocolFamily;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.syvasoft.tallyfrontcrusher.model.MEmployeeSalaryIssue;
import org.syvasoft.tallyfrontcrusher.model.MGLPostingConfig;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;

public class CalloutEmployeeSalaryIssue_SetOpenAmt implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		//Best practice for getting Open Amounts would be
		//Aggregate fact_amt + previous balance amount (opening balance for current dateacct)
		//This may result wrong opening balance if the dateacct are not entered in chronological order.
		//That's why the Dirty and Quick Approach is taken. It's accurate, but it becomes slow over the period.
		
		//Dirty and Quick Approach
		//Just Aggregate All the record by account_id and c_bpartner_id except dateAcct
		
		int AD_Org_ID = CalloutUtil.getIntValue(mTab, MEmployeeSalaryIssue.COLUMNNAME_AD_Org_ID);
		
		
		BigDecimal salaryAmt = BigDecimal.ZERO;
		BigDecimal salaryPaid = BigDecimal.ZERO;
		BigDecimal loanPaid = BigDecimal.ZERO;
		BigDecimal loanDeduct = BigDecimal.ZERO; 
		BigDecimal loanBalance = BigDecimal.ZERO;
		BigDecimal advancePaid = BigDecimal.ZERO;
		BigDecimal advanceDeduct = BigDecimal.ZERO; 
		BigDecimal advanceBalance = BigDecimal.ZERO;
		BigDecimal salaryBalance = BigDecimal.ZERO;
		
		
		int bPartner_ID = CalloutUtil.getIntValue(mTab, MEmployeeSalaryIssue.COLUMNNAME_C_BPartner_ID);
		Timestamp dateAcct = CalloutUtil.getTimestamp(mTab, MEmployeeSalaryIssue.COLUMNNAME_DateAcct);
		MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(ctx);
		int salaryPayable_acctID = glConfig.getSalaryPayable_Acct();
		int salaryAdvance_acctID = glConfig.getSalariesAdvanceAcct_ID();
		int loan_accID = glConfig.getLoan_ID();
		
		
		TF_MBPartner bp = new TF_MBPartner(ctx, bPartner_ID, null);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_User1_ID, bp.getUser1_ID());
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_PFAmt, bp.getPFAmt());
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_BasicSalary, bp.getBasicSalary());
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_MonthlySalaryAmt, bp.getStd_Wage());
		
		
		//Salary Payable
		String sql = "SELECT 	SUM(AmtAcctCr - AmtAcctDr) Earned_Wage FROM Fact_Acct_Balance " +
				" WHERE AD_Org_ID = ? AND Account_ID = ? AND C_BPartner_ID = ? AND postingtype='A' AND DateAcct <= ?";
		salaryAmt = DB.getSQLValueBD(null, sql, AD_Org_ID, salaryPayable_acctID, bPartner_ID, dateAcct);
		if(salaryAmt == null)
			salaryAmt = BigDecimal.ZERO;			
		
		//Loan Paid
		sql = "SELECT 	SUM(AmtAcctDr - AmtAcctCr) Loan_Paid FROM Fact_Acct_Balance " +
				" WHERE AD_Org_ID = ?  AND Account_ID = ? AND C_BPartner_ID = ? AND postingtype='A' AND DateAcct <= ?";
		loanPaid = DB.getSQLValueBD(null, sql, AD_Org_ID, loan_accID, bPartner_ID, dateAcct);
		if(loanPaid == null)
			loanPaid = BigDecimal.ZERO;
		loanBalance = loanPaid.subtract(loanDeduct);
		
		//Advance Paid
		sql = "SELECT 	SUM(AmtAcctDr - AmtAcctCr) Advance_Paid FROM Fact_Acct_Balance " +
				" WHERE AD_Org_ID = ?  AND Account_ID = ? AND C_BPartner_ID = ? AND postingtype='A' AND DateAcct <= ? ";
		advancePaid = DB.getSQLValueBD(null, sql, AD_Org_ID, salaryAdvance_acctID, bPartner_ID, dateAcct);
		if(advancePaid == null)
			advancePaid = BigDecimal.ZERO;
		
		if(salaryAmt.doubleValue() > advancePaid.doubleValue()) 
			advanceDeduct = advancePaid;
		else
			advanceDeduct = salaryAmt.subtract(bp.getPFAmt());
		
		advanceBalance = advancePaid.subtract(advanceDeduct);
		
		salaryPaid= salaryAmt.subtract(advanceDeduct).subtract(loanDeduct).subtract(bp.getPFAmt());
		salaryBalance = salaryPaid.subtract(advanceDeduct).subtract(salaryPaid).subtract(loanDeduct);
		
		BigDecimal bank = bp.getBasicSalary().subtract(bp.getPFAmt());
		BigDecimal cash = BigDecimal.ZERO;
		if(salaryPaid.doubleValue() < bank.doubleValue()) {
			bank = salaryPaid;
		}
		cash = salaryPaid.subtract(bank);
		
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Salary_Amt, salaryAmt);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Salary_Paid, salaryPaid);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Loan_Paid, loanPaid);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Loan_Deduct, loanDeduct);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Loan_Balance, loanBalance);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Advance_Paid, advancePaid);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Advance_Deduct, advanceDeduct);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Advance_Balance, advanceBalance);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_Salary_Payable, salaryBalance);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_IssuedBankAmt, bank);
		mTab.setValue(MEmployeeSalaryIssue.COLUMNNAME_IssuedCashAmt, cash);
		
		return null;
	}

}
