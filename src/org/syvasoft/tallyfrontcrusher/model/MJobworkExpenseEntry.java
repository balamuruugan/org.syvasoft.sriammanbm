package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.process.DocAction;
import org.compiere.util.Env;

public class MJobworkExpenseEntry extends X_TF_Jobwork_Expense_Entry {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2036669654190744287L;

	public MJobworkExpenseEntry(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MJobworkExpenseEntry(Properties ctx,
			int TF_Jobwork_Expense_Entry_ID, String trxName) {
		super(ctx, TF_Jobwork_Expense_Entry_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			//Posting GL journal for Subcontract / Job Work Expense 
			MJournal j = new MJournal(getCtx(), 0, get_TrxName());
			j.setDescription("Generated from Subcontract / Job Work - " + getDocumentNo());
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
			
			//Dr to Account Head with Project
			//Cr from only Account Head
			// It will reverse the amount from Acount head and debited to Project level
			
			MJournalLine jl = new MJournalLine(j);
			jl.setLine(10);			
			jl.setDescription(getDescription());
			jl.setAccount_ID(getC_ElementValue_ID());
			jl.setC_Project_ID(getC_Project_ID());
			jl.setAmtSourceDr(getAmount());
			jl.setAmtAcctDr(getAmount());
			jl.setIsGenerated(true);
			jl.saveEx();
			
			jl = new MJournalLine(j);
			jl.setLine(20);
			jl.setDescription(getDescription());
			jl.setAccount_ID(getC_ElementValue_ID());			
			jl.setAmtSourceCr(getAmount());
			jl.setAmtAcctCr(getAmount());
			jl.setIsGenerated(true);
			jl.saveEx();
			
			j.processIt(MJournal.ACTION_Complete);
			j.saveEx();
			
			setGL_Journal_ID(j.getGL_Journal_ID());
			
			MJobworkExpense.updateJobworkExpense(getCtx(), getC_Project_ID(), getC_ElementValue_ID(), getAmount(), get_TrxName());
		}
	}
	

	public void reverseIt() {
		
		if(getSubcon_Invoice_ID()>0) {			
			throw new AdempiereException("You cannot modify this entry before Reverse Correct Subcontractor Invoice!");
		}
		
		if(getGL_Journal_ID()>0) {
			MJournal j = new MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
			j.reverseCorrectIt();
			j.saveEx();
			
			setGL_Journal_ID(0);
			setProcessed(false);
			setDocStatus(DOCSTATUS_Drafted);
			
			//TODO: Need to be revised the reversal logic
			MJobworkExpense.updateJobworkExpense(getCtx(), getC_Project_ID(), getC_ElementValue_ID(), getAmount().negate(), get_TrxName());
		}
	}
}
