
package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPayment;
import org.compiere.model.MPeriod;
import org.compiere.model.MUser;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MInvestmentReceipt extends X_TF_InvestmentReceipt {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3277316969251826275L;

	public MInvestmentReceipt(Properties ctx, int TF_InvestmentReceipt_ID, String trxName) {
		super(ctx, TF_InvestmentReceipt_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MInvestmentReceipt(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		if(newRecord) {
			TF_MCharge.createChargeFromAccount(getCtx(), getTF_Shareholder().getCapitalAcct_ID(), get_TrxName());
			TF_MCharge.createChargeFromAccount(getCtx(), getC_ElementValue_ID(), get_TrxName());
		}
		return super.afterSave(newRecord, success);
	}

	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			MUser user = MUser.get(getCtx(), Env.getAD_User_ID(getCtx()));				
			int bPartnerID = user.getC_BPartner_ID();	
			
			if(!getInvestmentReceiptType().equals(INVESTMENTRECEIPTTYPE_CashACToInitialExpenseAC)) {
				//Cash Book Receipt
				TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
				payment.setAD_Org_ID(getAD_Org_ID());			
				payment.setDateTrx(getDateAcct());
				payment.setDateAcct(getDateAcct());		
				payment.setC_BankAccount_ID(getC_BankAccount_ID());
				payment.setC_DocType_ID(1000008);
				payment.setIsReceipt(true);
				payment.setC_ElementValue_ID(getTF_Shareholder().getCapitalAcct_ID());
				TF_MCharge charge = TF_MCharge.createChargeFromAccount(getCtx(), payment.getC_ElementValue_ID(), get_TrxName());
				if(charge != null )
					payment.setC_Charge_ID(charge.get_ID());			
						
				payment.setC_BPartner_ID(bPartnerID);		
				payment.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
				payment.setPayAmt(getPayAmt());
				payment.setTenderType(TF_MPayment.TENDERTYPE_Cash);
				payment.setDescription(getDescription());		
				payment.saveEx();
				
				if(!payment.processIt(DocAction.ACTION_Complete))
					throw new AdempiereException("Failed when processing document - " + payment.getProcessMsg());
				payment.saveEx();
				
				setC_PaymentReceipt_ID(payment.getC_Payment_ID());
			
			}
			if(!getInvestmentReceiptType().equals(INVESTMENTRECEIPTTYPE_CapitalACToCashAC)) {
			//Cash Book Payment
				TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
				payment.setAD_Org_ID(getAD_Org_ID());			
				payment.setDateTrx(getDateAcct());
				payment.setDateAcct(getDateAcct());		
				payment.setC_BankAccount_ID(getC_BankAccount_ID());
				payment.setC_DocType_ID(1000009);
				payment.setIsReceipt(false);
				payment.setC_ElementValue_ID(getC_ElementValue_ID());
				TF_MCharge charge = TF_MCharge.createChargeFromAccount(getCtx(), payment.getC_ElementValue_ID(), get_TrxName());
				if(charge != null )
					payment.setC_Charge_ID(charge.get_ID());			
				payment.setC_BPartner_ID(bPartnerID);		
				payment.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
				payment.setPayAmt(getPayAmt());
				payment.setTenderType(TF_MPayment.TENDERTYPE_Cash);
				payment.setDescription(getDescription());
				payment.saveEx();
				
				if(!payment.processIt(DocAction.ACTION_Complete))
					throw new AdempiereException("Failed when processing document - " + payment.getProcessMsg());
				payment.saveEx();
				
				setC_Payment_ID(payment.getC_Payment_ID());
				
				adjustSubShareholderAccountInHeadOffice();
				adjustInvestmentAccountInHeadOffice();
			}
			MInvestmentStructure.updateInvestmentPaid(getAD_Org_ID(), get_TrxName());
			
			
		}
	}
	
	public void reverseIt() {
		if(getC_Payment_ID() > 0) {
			TF_MPayment payment = new TF_MPayment(getCtx(), getC_Payment_ID(), get_TrxName());
			if(payment.getDocStatus().equals(DOCSTATUS_Completed)){
				 if(!payment.reverseCorrectIt())
					 throw new AdempiereException("Cash Book Payment cannot be reversed!");
				 payment.saveEx();
			}
			setC_Payment_ID(0);
		}
		
		if(getC_PaymentReceipt_ID() > 0) {
			TF_MPayment payment = new TF_MPayment(getCtx(), getC_PaymentReceipt_ID(), get_TrxName());
			if(payment.getDocStatus().equals(DOCSTATUS_Completed)){
				 if(!payment.reverseCorrectIt())
					 throw new AdempiereException("Cash Book Receipt cannot be reversed!");
				 payment.saveEx();				 
			}
			setC_PaymentReceipt_ID(0);
		}
		
		if(getGL_Journal_ID() > 0) {
			TF_MJournal j = new TF_MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
			if(j.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!j.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
				j.saveEx();
			}
			setGL_Journal_ID(0);
		}
		
		setProcessed(false);
		setDocStatus(DOCSTATUS_Drafted);
	}
	
	public void adjustSubShareholderAccountInHeadOffice() {
		TF_MOrg org = new TF_MOrg(getCtx(), getAD_Org_ID(), get_TrxName());
		if(getTF_Shareholder().getTF_ShareholderMain_ID() > 0 && org.getAD_OrgHO_ID() > 0) {
			int subShareholderCapitalAcct = getTF_Shareholder().getCapitalAcct_ID();
			int mainShareholderCapitalAcct = getTF_Shareholder().getTF_ShareholderMain().getCapitalAcct_ID();
			String sandPoint = org.getName();
			
			int m_C_DocTypeTarget_ID = 1000000;		
			TF_MJournal j = new TF_MJournal(getCtx(), 0, get_TrxName());
			j.setDescription("Initial Expense Paid");
			j.setAD_Org_ID(org.getAD_OrgHO_ID());
			j.setC_AcctSchema_ID(Env.getContextAsInt(getCtx(), "$C_AcctSchema_ID"));
			j.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
			j.setPostingType(TF_MJournal.POSTINGTYPE_Actual);
			j.setC_DocType_ID(m_C_DocTypeTarget_ID);
			j.setDateDoc(getDateAcct());
			j.setDateAcct(getDateAcct());
			j.setDocStatus(TF_MJournal.DOCSTATUS_Drafted);
			MPeriod period = MPeriod.get(getCtx(), getDateAcct());
			j.setC_Period_ID(period.getC_Period_ID());
			j.setGL_Category_ID(1000000);
			j.setC_ConversionType_ID(114);				
			j.saveEx();
			
			
			//Debit Sub-Shareholder in Head Office.
			MJournalLine jl;			
			jl = new MJournalLine(j);
			jl.setLine(10);			
			jl.setAccount_ID(subShareholderCapitalAcct);		
			jl.setDescription("In " + sandPoint + ", " + getDescription());
			jl.setAmtSourceDr(getPayAmt());
			jl.setAmtAcctDr(getPayAmt());
			jl.setIsGenerated(true);
			jl.saveEx();
			
			//Credit Main Shareholder in Head Office.						
			jl = new MJournalLine(j);
			jl.setLine(20);			
			jl.setAccount_ID(mainShareholderCapitalAcct);		
			jl.setDescription("In " + sandPoint + ", " + getDescription());
			jl.setAmtSourceCr(getPayAmt());
			jl.setAmtAcctCr(getPayAmt());
			jl.setIsGenerated(true);
			jl.saveEx();
			
			//DocAction
			if (!j.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
			j.saveEx();
			
			setGL_Journal_ID(j.getGL_Journal_ID());
			
		}
	}
	
	public void adjustInvestmentAccountInHeadOffice() {
		TF_MOrg org = new TF_MOrg(getCtx(), getAD_Org_ID(), get_TrxName());
		if(getTF_Shareholder().getCapitalAcct_ID() == org.getHeadOffice().getInvestmentAcct_ID()) {			
			int m_C_DocTypeTarget_ID = 1000000;
			String sandPoint = org.getName();
			
			TF_MJournal j = new TF_MJournal(getCtx(), 0, get_TrxName());
			j.setDescription("Initial Expense");
			j.setAD_Org_ID(org.getAD_OrgHO_ID());
			j.setC_AcctSchema_ID(Env.getContextAsInt(getCtx(), "$C_AcctSchema_ID"));
			j.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
			j.setPostingType(TF_MJournal.POSTINGTYPE_Actual);
			j.setC_DocType_ID(m_C_DocTypeTarget_ID);
			j.setDateDoc(getDateAcct());
			j.setDateAcct(getDateAcct());
			j.setDocStatus(TF_MJournal.DOCSTATUS_Drafted);
			MPeriod period = MPeriod.get(getCtx(), getDateAcct());
			j.setC_Period_ID(period.getC_Period_ID());
			j.setGL_Category_ID(1000000);
			j.setC_ConversionType_ID(114);				
			j.saveEx();
			
			
			//Debit Initial Expense in Head Office.
			MJournalLine jl;			
			jl = new MJournalLine(j);
			jl.setLine(10);			
			jl.setAccount_ID(getC_ElementValue_ID());		
			jl.setDescription("In " + sandPoint + ", " + getDescription());
			jl.setAmtSourceDr(getPayAmt());
			jl.setAmtAcctDr(getPayAmt());
			jl.setIsGenerated(true);
			jl.saveEx();
			
			
			//Credit Main Shareholder in Head Office.						
			jl = new MJournalLine(j);
			jl.setLine(20);			
			jl.setAccount_ID(getTF_Shareholder().getCapitalAcct_ID());		
			jl.setDescription("In " + sandPoint + ", " + getDescription());
			jl.setAmtSourceCr(getPayAmt());
			jl.setAmtAcctCr(getPayAmt());
			jl.setIsGenerated(true);
			jl.saveEx();
			
			//DocAction
			if (!j.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
			j.saveEx();
			
			setGL_Journal_ID(j.getGL_Journal_ID());
		}
	}
}

