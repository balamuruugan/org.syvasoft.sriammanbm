package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MUser;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MGLPostingConfig;
import org.syvasoft.tallyfrontcrusher.model.MInterOrgBPCashTransferConfigLine;
import org.syvasoft.tallyfrontcrusher.model.MInterOrgCashTransfer;
import org.syvasoft.tallyfrontcrusher.model.MInterOrgCashTransferConfigLine;
import org.syvasoft.tallyfrontcrusher.model.MJobworkAssignedAccount;
import org.syvasoft.tallyfrontcrusher.model.TF_MElementValue;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class CalloutPayment_ElementValue implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		boolean isSalaryPayment = false;
		boolean isSalaryAdvance = false;
		boolean isReceipt = mTab.getValueAsBoolean(TF_MPayment.COLUMNNAME_IsReceipt);
		MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(ctx);
		String description = null;
		int acct_id = 0;
		if(mTab.getValue(TF_MPayment.COLUMNNAME_C_ElementValue_ID) != null) {
			mTab.setValue(TF_MPayment.COLUMNNAME_C_Invoice_ID, 0);
			acct_id = (int) mTab.getValue(TF_MPayment.COLUMNNAME_C_ElementValue_ID);
			isSalaryPayment = glConfig.getSalaryPayable_Acct() == acct_id; // && !isReceipt;
			isSalaryAdvance = glConfig.getSalariesAdvanceAcct_ID() == acct_id; // && !isReceipt;
		}
				
		mTab.setValue(TF_MPayment.COLUMNNAME_IsSalaryPayment, isSalaryPayment);
		
		int salaryPayable_acctID = glConfig.getSalaryPayable_Acct();
		int salaryAdvance_acctID = glConfig.getSalariesAdvanceAcct_ID();
		BigDecimal salaryAmt = BigDecimal.ZERO;
		BigDecimal advancePaid = BigDecimal.ZERO;
		if(isSalaryPayment) {
			description = "Salary Paid";
			
			int bPartnerID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_TF_BPartner_ID);
			int adorgID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_AD_Org_ID);
			Timestamp dateAcct = (Timestamp) mTab.getValue(TF_MPayment.COLUMNNAME_DateAcct);
			
			//Salary Payable
			String sql = "SELECT 	SUM(AmtAcctCr - AmtAcctDr) Earned_Wage FROM Fact_Acct_Balance " +
					" WHERE AD_Org_ID = ? AND Account_ID = ? AND C_BPartner_ID = ? AND postingtype='A' AND DateAcct <= ?";
			//salaryAmt = DB.getSQLValueBD(null, sql, adorgID, salaryPayable_acctID, bPartnerID, dateAcct);
			if(salaryAmt == null)
				salaryAmt = BigDecimal.ZERO;				
			
			//Advance Paid
			sql = "SELECT 	SUM(AmtAcctDr - AmtAcctCr) Advance_Paid FROM Fact_Acct_Balance " +
					" WHERE AD_Org_ID = ? AND Account_ID = ? AND C_BPartner_ID = ? AND postingtype='A' AND DateAcct <= ? ";
			advancePaid = DB.getSQLValueBD(null, sql, adorgID, salaryAdvance_acctID, bPartnerID, dateAcct);
			if(advancePaid == null)
				advancePaid = BigDecimal.ZERO;
			
		}
		else if(isSalaryAdvance) {
			description = "Advance Paid";
		}
		else if(mTab.getValue(TF_MPayment.COLUMNNAME_FromTo_BankAccount_ID) != null) {
			//do not change description.
			description = (String) mTab.getValue(TF_MPayment.COLUMNNAME_Description); 
		}		
		else {			
			description = null;
			if(acct_id > 0) {
				TF_MElementValue acct = new TF_MElementValue(ctx, acct_id, null);
				if(!isReceipt)
					description = "Cash Paid to " + acct.getName();
				else
					description = "Cash Received from " + acct.getName();
				int AD_Org_ID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_AD_Org_ID);
				MJobworkAssignedAccount jwAcct = MJobworkAssignedAccount.getJobwork(AD_Org_ID, acct_id);				
				if(jwAcct != null) {
					mTab.setValue(TF_MPayment.COLUMNNAME_C_Project_ID, jwAcct.getC_Project_ID());					
				}
				else {
					mTab.setValue(TF_MPayment.COLUMNNAME_C_Project_ID, null);	
				}
				
				MUser user = MUser.get(ctx, Env.getAD_User_ID(ctx));				
				int bPartnerID = user.getC_BPartner_ID();
				
				mTab.setValue(TF_MPayment.COLUMNNAME_IsEmployee, false);
				mTab.setValue(TF_MPayment.COLUMNNAME_C_BPartner_ID, bPartnerID);
				
			}
			
		}
		
		mTab.setValue(TF_MPayment.COLUMNNAME_Description, description);		
		mTab.setValue(TF_MPayment.COLUMNNAME_Salary_Amt, salaryAmt);
		mTab.setValue(TF_MPayment.COLUMNNAME_Advance_Paid, advancePaid);
		
		
		//Inter Org Cash Additional Transfer
		boolean isInterOrgCash = false;
		mTab.setValue(TF_MPayment.COLUMNNAME_IsInterOrgCashTransferX, isInterOrgCash);
		mTab.setValue(TF_MPayment.COLUMNNAME_TF_OrgCashTransfer_Configx_ID, null);
		if(!isReceipt && acct_id > 0){
			int C_BankAccount_ID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_C_BankAccount_ID);
			MInterOrgCashTransferConfigLine config = MInterOrgCashTransfer.getDefaultAddionalCashTransfer(C_BankAccount_ID, acct_id, false);
			if(config != null) {
				isInterOrgCash = true;
				config = MInterOrgCashTransfer.getDefaultAddionalCashTransfer(C_BankAccount_ID, acct_id, true);
				if(config != null)
					mTab.setValue(TF_MPayment.COLUMNNAME_TF_OrgCashTransfer_Configx_ID, config.getTF_OrgCashTransfer_Configx_ID());
				
				mTab.setValue(TF_MPayment.COLUMNNAME_IsInterOrgCashTransferX, isInterOrgCash);
			}			
		}
		return null;
	}

}
