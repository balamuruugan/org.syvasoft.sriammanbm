package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MEmployeeSalaryIssue extends X_TF_Employee_Salary_Issue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2047481242708130880L;
	public MEmployeeSalaryIssue(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	public MEmployeeSalaryIssue(Properties ctx,
			int TF_Employee_Salary_Issue_ID, String trxName) {
		super(ctx, TF_Employee_Salary_Issue_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public void postAdvanceDeductJV(MGLPostingConfig glConfig) {
		//Post Advance Deduct Adjustment journal entry
		if(getAdvance_Deduct().doubleValue()>0 || getPFAmt().doubleValue()>0) {
			MJournal j = new MJournal(getCtx(), 0, get_TrxName());
			j.setAD_Org_ID(getAD_Org_ID());
			j.setDescription("Generated from Employee Salary Issue Entry - " + getDocumentNo());
			j.setC_AcctSchema_ID(Env.getContextAsInt(getCtx(), "$C_AcctSchema_ID"));
			j.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
			j.setPostingType(MJournal.POSTINGTYPE_Actual);
			j.setC_DocType_ID(1000000);
			j.setDateDoc(getDateAcct());
			j.setDateAcct(getDateAcct());
			j.setDocStatus(DOCSTATUS_Drafted);
			MPeriod period = MPeriod.get(getCtx(), getDateAcct());
			j.setC_Period_ID(period.getC_Period_ID());
			j.setGL_Category_ID(1000000);
			j.setC_ConversionType_ID(114);
			j.saveEx();
			
			//Salaries Payable Dr.
			MJournalLine jl;				
			jl = new MJournalLine(j);
			jl.setLine(10);			
			jl.setAccount_ID(glConfig.getSalaryPayable_Acct());
			jl.setC_BPartner_ID(getC_BPartner_ID());
			jl.setUser1_ID(getUser1_ID()); 
			jl.setAmtSourceDr(getAdvance_Deduct().add(getPFAmt()));
			jl.setAmtAcctDr(getAdvance_Deduct().add(getPFAmt()));
			jl.setIsGenerated(true);
			jl.saveEx();
			
			//Salary Advance Cr.
			if(getAdvance_Deduct().doubleValue()>0) {
				jl = new MJournalLine(j);
				jl.setLine(10);			
				jl.setAccount_ID(glConfig.getSalariesAdvanceAcct_ID());
				jl.setC_BPartner_ID(getC_BPartner_ID());
				jl.setUser1_ID(getUser1_ID()); 
				jl.setAmtSourceCr(getAdvance_Deduct());
				jl.setAmtAcctCr(getAdvance_Deduct());
				jl.setIsGenerated(true);
				jl.saveEx();
			}
			
			//PF Payable Cr.
			if(getPFAmt().doubleValue() > 0) {
				jl = new MJournalLine(j);
				jl.setLine(10);			
				jl.setAccount_ID(glConfig.getPFPayableAcct_ID());
				jl.setC_BPartner_ID(getC_BPartner_ID());
				jl.setUser1_ID(getUser1_ID()); 
				jl.setAmtSourceCr(getPFAmt());
				jl.setAmtAcctCr(getPFAmt());
				jl.setIsGenerated(true);
				jl.saveEx();
			}
			j.processIt(MJournal.ACTION_Complete);
			j.saveEx();
			
			setGL_Journal_ID(j.getGL_Journal_ID());
		}
		
	}
	
	public void processIt(String docAction) {
		//if(getAdvance_Deduct().doubleValue() == 0 && getSalary_Paid().doubleValue() == 0)
		//	throw new AdempiereException("Invalid Salary Issue Entry due to both Advance Deduct and Salary Paid are ZERO");
		
		if(getDocStatus() == null)
			setDocStatus(DOCSTATUS_Drafted);
		
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			if(getDocStatus().equals(DOCSTATUS_Completed))
				return;
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(getCtx());
			
			postAdvanceDeductJV(glConfig);
					
			
			//Post Cash Book Entry for Salary Paid
			if(getSalary_Paid().doubleValue()>0) {
				//Create Salaries Payable Charge if it is not there already.
				//It should be in atomic transaction to get account settings of Charge for the current docaction transaction.				
				TF_MCharge charge = TF_MCharge.createChargeFromAccount(getCtx(), glConfig.getSalaryPayable_Acct(), null);
				MSalaryIssueHdr hdr = getParent();
				String desc = hdr.getDocumentNo() + " - Salary Issue for " + hdr.getC_Period().getName();
				if(getIssuedCashAmt().doubleValue() > 0) {
					//Posting Payment Document for Employee Salary Issue 
					TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
					payment.setAD_Org_ID(getAD_Org_ID());
					payment.setDateAcct(getDateAcct());
					payment.setDateTrx(getDateAcct());
					payment.setDescription(desc);
					payment.setCashType(TF_MPayment.CASHTYPE_EmployeePayment);
					payment.setC_DocType_ID(false);
					payment.setC_BPartner_ID(getC_BPartner_ID());
					payment.setC_Charge_ID(charge.getC_Charge_ID());
					payment.setUser1_ID(getUser1_ID());
					payment.setC_ElementValue_ID(glConfig.getSalaryPayable_Acct());
					payment.setC_BankAccount_ID(getC_BankAccount_ID());
					payment.setPayAmt(getIssuedCashAmt());
					payment.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
					payment.setDocStatus(DOCSTATUS_InProgress);
					payment.setTenderType(TF_MPayment.TENDERTYPE_Cash);
					payment.saveEx();
					payment.processIt(DocAction.ACTION_Complete);
					payment.saveEx();
					
					setC_Payment_ID(payment.get_ID());
				}
				
				if(getIssuedBankAmt().doubleValue() > 0) {
					//Posting Payment Document for Employee Salary Issue 
					TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
					payment.setAD_Org_ID(getAD_Org_ID());
					payment.setDateAcct(getDateAcct());
					payment.setDateTrx(getDateAcct());
					payment.setDescription(desc);
					payment.setCashType(TF_MPayment.CASHTYPE_EmployeePayment);
					payment.setC_DocType_ID(false);
					payment.setC_BPartner_ID(getC_BPartner_ID());
					payment.setC_Charge_ID(charge.getC_Charge_ID());
					payment.setUser1_ID(getUser1_ID());
					payment.setC_ElementValue_ID(glConfig.getSalaryPayable_Acct());
					payment.setC_BankAccount_ID(getC_BankAccountBnk_ID());
					payment.setPayAmt(getIssuedBankAmt());
					payment.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
					payment.setDocStatus(DOCSTATUS_InProgress);
					payment.setTenderType(TF_MPayment.TENDERTYPE_Cash);
					payment.saveEx();
					payment.processIt(DocAction.ACTION_Complete);
					payment.saveEx();
					
					setC_PaymentBank_ID(payment.getC_Payment_ID());
				}
				
			}
		}
	}
	
	public void reverseIt() {
		boolean isReversed = false;
		if(getC_Payment_ID()>0) {
			isReversed = true;
			TF_MPayment payment = new TF_MPayment(getCtx(), getC_Payment_ID(), get_TrxName());
			if(payment.getDocStatus().equals(TF_MPayment.DOCSTATUS_Completed))
				payment.reverseCorrectIt();
			payment.saveEx();
			
			setC_Payment_ID(0);
		}
		if(getC_PaymentBank_ID()>0) {
			isReversed = true;
			TF_MPayment payment = new TF_MPayment(getCtx(), getC_PaymentBank_ID(), get_TrxName());
			if(payment.getDocStatus().equals(TF_MPayment.DOCSTATUS_Completed))
				payment.reverseCorrectIt();
			payment.saveEx();
			
			setC_PaymentBank_ID(0);
		}
		if(getGL_Journal_ID()>0) {
			isReversed = true;
			MJournal j = new MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
			if(j.getDocStatus().equals(TF_MPayment.DOCSTATUS_Completed))
				j.reverseCorrectIt();
			j.saveEx();
			
			setGL_Journal_ID(0);			
		}
		if(isReversed) {
			setProcessed(false);
			setDocStatus(DOCSTATUS_Drafted);			
		}
	}
	
	public MSalaryIssueHdr getParent() {
		return (MSalaryIssueHdr) getTF_SalaryIssueHdr();
	}
	
	public void setDefaults(TF_MBPartner bp) {
		MSalaryIssueHdr hdr = getParent();
		if(hdr == null)
			return;
		
		setAD_Org_ID(hdr.getAD_Org_ID());
		setDateAcct(hdr.getDateAcct());
		setC_BankAccount_ID(hdr.getC_BankAccount_ID());
		setC_BankAccountBnk_ID(hdr.getC_BankAccountBnk_ID());
		setC_BPartner_ID(bp.getC_BPartner_ID());
		setUser1_ID(bp.getUser1_ID());
		setMonthlySalaryAmt(bp.getStd_Wage());
		setBasicSalary(bp.getBasicSalary());
		setLoan_Deduct(BigDecimal.ZERO);
		setLoan_Balance(BigDecimal.ZERO);
		setLoan_Paid(BigDecimal.ZERO);		
		setPFAmt(bp.getPFAmt());
		
		BigDecimal salaryAmt = getSalaryPayable(getCtx(), getAD_Org_ID(), getC_BPartner_ID(), getDateAcct());
		setSalary_Amt(salaryAmt);		
		
		BigDecimal advancePaid = getAdvancePaid(getCtx(), getAD_Org_ID(), getC_BPartner_ID(), getDateAcct());		
		setAdvance_Paid(advancePaid);
		
		BigDecimal advanceDeduct = BigDecimal.ZERO;
		BigDecimal advanceBalance = BigDecimal.ZERO; 
		
		if(salaryAmt.subtract(getPFAmt()).doubleValue() > advancePaid.doubleValue()) 
			advanceDeduct = advancePaid;
		else
			advanceDeduct = salaryAmt.subtract(getPFAmt());
		
		advanceBalance = advancePaid.subtract(advanceDeduct);
		
		BigDecimal salaryPaid= salaryAmt.subtract(advanceDeduct).subtract(getPFAmt());
		BigDecimal salaryBalance = advancePaid.subtract(advanceDeduct).subtract(salaryPaid);
		
		if(salaryBalance.doubleValue() < 0)
			salaryBalance = BigDecimal.ZERO;
		
		BigDecimal bank = bp.getBasicSalary().subtract(bp.getPFAmt());
		BigDecimal cash = BigDecimal.ZERO;
		if(salaryPaid.doubleValue() < bank.doubleValue()) {
			bank = salaryPaid;
		}
		cash = salaryPaid.subtract(bank);
		
		setAdvance_Deduct(advanceDeduct);
		setAdvance_Balance(advanceBalance);
		
		setSalary_Paid(salaryPaid);
		setSalary_Payable(salaryBalance);
		setIssuedBankAmt(bank);
		setIssuedCashAmt(cash);
		
	}

	
	public static BigDecimal getSalaryPayable(Properties ctx, int AD_Org_ID, int C_BPartner_ID, Timestamp dateAcct) {
		MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(ctx);
		int salaryPayable_acctID = glConfig.getSalaryPayable_Acct();
		
		String sql = "SELECT 	SUM(AmtAcctCr - AmtAcctDr) Earned_Wage FROM Fact_Acct_Balance " +
				" WHERE AD_Org_ID = ? AND Account_ID = ? AND C_BPartner_ID = ? AND postingtype='A' AND DateAcct <= ?";
		BigDecimal salaryAmt = DB.getSQLValueBD(null, sql, AD_Org_ID, salaryPayable_acctID, C_BPartner_ID, dateAcct);
		if(salaryAmt == null)
			salaryAmt = BigDecimal.ZERO;			
		
		return salaryAmt;
	}
	
	public static BigDecimal getAdvancePaid(Properties ctx, int AD_Org_ID, int C_BPartner_ID, Timestamp dateAcct) {
		MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(ctx);
		int salaryAdvance_acctID = glConfig.getSalariesAdvanceAcct_ID();
		
		String sql = "SELECT 	SUM(AmtAcctDr - AmtAcctCr) Advance_Paid FROM Fact_Acct_Balance " +
				" WHERE AD_Org_ID = ?  AND Account_ID = ? AND C_BPartner_ID = ? AND postingtype='A' AND DateAcct <= ? ";
		BigDecimal advancePaid = DB.getSQLValueBD(null, sql, AD_Org_ID, salaryAdvance_acctID, C_BPartner_ID, dateAcct);
		if(advancePaid == null)
			advancePaid = BigDecimal.ZERO;				
		
		return advancePaid;
	}
	
}
