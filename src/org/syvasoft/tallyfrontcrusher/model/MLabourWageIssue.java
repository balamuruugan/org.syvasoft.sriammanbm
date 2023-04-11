package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.process.DocAction;
import org.compiere.util.Env;

public class MLabourWageIssue extends X_TF_Labour_Wage_Issue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4342813143616564698L;
	public MLabourWageIssue(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	public MLabourWageIssue(Properties ctx, int TF_Labour_Wage_Issue_ID,
			String trxName) {
		super(ctx, TF_Labour_Wage_Issue_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public void processIt(String docAction) {
		if(getAdvance_Deduct().doubleValue() == 0 && getWages_Paid().doubleValue() == 0)
			throw new AdempiereException("Invalid Wage Issue Entry due to both Advance Deduct and Wages Paid are ZERO");
		
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
						
			MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(getCtx());
			
			//Post Advance Deduct Adjustment journal entry
			if(getAdvance_Deduct().doubleValue()>0) {
				MJournal j = new MJournal(getCtx(), 0, get_TrxName());
				j.setDescription("Generated from Labour Wage Issue Entry - " + getDocumentNo());
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
				
				//Wages Payable Dr.
				MJournalLine jl;				
				jl = new MJournalLine(j);
				jl.setLine(10);			
				jl.setAccount_ID(glConfig.getWagePayableAcct_ID());
				jl.setC_BPartner_ID(getC_BPartner_ID());
				jl.setUser1_ID(getC_ElementValue_ID()); // Quarry Profit Center
				jl.setAmtSourceDr(getAdvance_Deduct());
				jl.setAmtAcctDr(getAdvance_Deduct());
				jl.setIsGenerated(true);
				jl.saveEx();
				
				//Wages Advance Cr.
				jl = new MJournalLine(j);
				jl.setLine(10);			
				jl.setAccount_ID(glConfig.getWageAdvanceAcct_ID());
				jl.setC_BPartner_ID(getC_BPartner_ID());
				jl.setUser1_ID(getC_ElementValue_ID()); // Quarry Profit Center
				jl.setAmtSourceCr(getAdvance_Deduct());
				jl.setAmtAcctCr(getAdvance_Deduct());
				jl.setIsGenerated(true);
				jl.saveEx();
				
				j.processIt(MJournal.ACTION_Complete);
				j.saveEx();
				
				setGL_Journal_ID(j.getGL_Journal_ID());
			}
			
			if(getWages_Paid().doubleValue()>0) {
				//Create Wages Payable Charge if it is not there already.
				//It should be in atomic transaction to get account settings of Charge for the current docaction transaction.
				TF_MCharge charge = TF_MCharge.createChargeFromAccount(getCtx(), glConfig.getWagePayableAcct_ID(), null);			
				//Posting Payment Document for Labour Wage Issue 
				TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
				payment.setDateAcct(getDateAcct());
				payment.setDateTrx(getDateAcct());
				payment.setDescription("Generated from Labour Wage Issue Entry - " + getDocumentNo());
				payment.setCashType(TF_MPayment.CASHTYPE_EmployeePayment);
				payment.setC_DocType_ID(false);
				payment.setC_BPartner_ID(getC_BPartner_ID());
				payment.setC_Charge_ID(charge.getC_Charge_ID());
				payment.setUser1_ID(getC_ElementValue_ID()); // Profit Center
				payment.setC_ElementValue_ID(glConfig.getWagePayableAcct_ID());
				payment.setC_BankAccount_ID(getC_BankAccount_ID());
				payment.setPayAmt(getWages_Paid());
				payment.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
				payment.setDocStatus(DOCSTATUS_InProgress);
				payment.setTenderType(TF_MPayment.TENDERTYPE_Cash);
				payment.saveEx();
				payment.processIt(DocAction.ACTION_Complete);
				payment.saveEx();
				
				setC_Payment_ID(payment.get_ID());
			}
		}
	}
	
	public void reverseIt() {
		boolean isReversed = false;
		if(getC_Payment_ID()>0) {
			isReversed = true;
			TF_MPayment payment = new TF_MPayment(getCtx(), getC_Payment_ID(), get_TrxName());
			payment.reverseCorrectIt();
			payment.saveEx();
			
			setC_Payment_ID(0);
		}
		if(getGL_Journal_ID()>0) {
			isReversed = true;
			MJournal j = new MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
			j.reverseCorrectIt();
			j.saveEx();
			
			setGL_Journal_ID(0);
		}
		
		if(isReversed) {
			setProcessed(false);
			setDocStatus(DOCSTATUS_Drafted);			
		}
	}
	
}
