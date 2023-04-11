package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.syvasoft.tallyfrontcrusher.model.MGLPostingConfig;
import org.syvasoft.tallyfrontcrusher.model.MLabourWageIssue;

public class CalloutLabourWageIssue_SetOpenAmt implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
				
		//Best practice for getting Open Amounts would be
		//Aggregate fact_amt + previous balance amount (opening balance for current dateacct)
		//This may result wrong opening balance if the dateacct are not entered in chronological order.
		//That's why the Dirty and Quick Approach is taken. It's accurate, but it becomes slow over the period.
		
		//Dirty and Quick Approach
		//Just Aggregate All the record by account_id and c_bpartner_id except dateAcct
		
		BigDecimal earnedWage = BigDecimal.ZERO;
		BigDecimal advancePaid = BigDecimal.ZERO;
		BigDecimal advanceDeduct = BigDecimal.ZERO; 
		BigDecimal advanceBalance = BigDecimal.ZERO;
		BigDecimal wagesPaid = BigDecimal.ZERO;
		BigDecimal wagesBalance = BigDecimal.ZERO;
		
		if(mTab.getValue(MLabourWageIssue.COLUMNNAME_C_BPartner_ID) != null &&
				mTab.getValue(MLabourWageIssue.COLUMNNAME_DateAcct) != null) {
			
			int bPartner_ID = (int) mTab.getValue(MLabourWageIssue.COLUMNNAME_C_BPartner_ID);
			Timestamp dateAcct = (Timestamp) mTab.getValue(MLabourWageIssue.COLUMNNAME_DateAcct);
			MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(ctx);
			int wagePayable_acctID = glConfig.getWagePayableAcct_ID();			
			int advancePaid_acctID = glConfig.getWageAdvanceAcct_ID();
			
			//Wage Payable
			String sql = "SELECT 	SUM(AmtAcctCr - AmtAcctDr) Earned_Wage FROM Fact_Acct_Balance " +
					" WHERE Account_ID = ? AND C_BPartner_ID = ? AND postingtype='A' AND DateAcct <= ?";
			earnedWage = DB.getSQLValueBD(null, sql, wagePayable_acctID, bPartner_ID, dateAcct);
			if(earnedWage == null)
				earnedWage = BigDecimal.ZERO;
			wagesPaid = earnedWage.subtract(advanceDeduct);
			wagesBalance = earnedWage.subtract(advanceDeduct).subtract(wagesPaid);
			
			//Advance Paid
			sql = "SELECT 	SUM(AmtAcctDr - AmtAcctCr) Advance_Paid FROM Fact_Acct_Balance " +
					" WHERE Account_ID = ? AND C_BPartner_ID = ? AND postingtype='A' AND DateAcct <= ?";
			advancePaid = DB.getSQLValueBD(null, sql, advancePaid_acctID, bPartner_ID, dateAcct);
			if(advancePaid == null)
				advancePaid = BigDecimal.ZERO;
			
			if(advancePaid.doubleValue() > earnedWage.doubleValue())
				advanceDeduct = earnedWage;
			else
				advanceDeduct = advancePaid;
			
			advanceBalance = advancePaid.subtract(advanceDeduct);
		}
		
		mTab.setValue(MLabourWageIssue.COLUMNNAME_Earned_Wage, earnedWage);
		mTab.setValue(MLabourWageIssue.COLUMNNAME_Advance_Paid, advancePaid);
		mTab.setValue(MLabourWageIssue.COLUMNNAME_Advance_Deduct, advanceDeduct);
		mTab.setValue(MLabourWageIssue.COLUMNNAME_Advance_Balance, advanceBalance);
		mTab.setValue(MLabourWageIssue.COLUMNNAME_Wages_Paid, wagesPaid);
		mTab.setValue(MLabourWageIssue.COLUMNNAME_Wages_Payable, wagesBalance);
		
		return null;
	}

}
