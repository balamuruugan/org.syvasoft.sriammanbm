package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAccount;
import org.compiere.model.MClient;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.model.MProductCategoryAcct;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MPermitLedgerLine extends X_TF_PermitLedgerLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = -819528765567044826L;

	public MPermitLedgerLine(Properties ctx, int TF_PermitLedgerLine_ID, String trxName) {
		super(ctx, TF_PermitLedgerLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MPermitLedgerLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		if(newRecord)
			postPermitExpense();
		return super.afterSave(newRecord, success);
	}
	
	public void postPermitExpense() {
		String whereClause = "C_ValidCombination_ID =  (SELECT  p_expense_acct "
				+ "FROM M_Product_Acct WHERE M_Product_ID=?)";
		int PermitLedger_ID = getTF_PermitLedger().getM_Product_ID();
		MAccount permitStockAcct = new Query(getCtx(), MAccount.Table_Name, whereClause, get_TrxName())
				.setParameters(PermitLedger_ID).first();
		if(permitStockAcct == null) {
			throw new AdempiereException("Not able to find Permit Stock Ledger!");			
		}		
		int permitStockAcct_ID = permitStockAcct.getAccount_ID();
		TF_MProduct prodPermit = new TF_MProduct(getCtx(), PermitLedger_ID, get_TrxName());
		int permitExpenseAcct_ID = prodPermit.getPermitExpenseAccount_ID();
		if(permitExpenseAcct_ID == 0)
			throw new AdempiereException("Permit Expense Ledger is not yet configured!");
		

		int m_C_DocTypeTarget_ID = 1000000;
		TF_MJournal j = new TF_MJournal(getCtx(), 0, get_TrxName());
		j.setDescription("Permit Expense");
		j.setAD_Org_ID(getAD_Org_ID());		
		j.setC_AcctSchema_ID(MClient.get(getCtx()).getAcctSchema().get_ID());
		j.setC_Currency_ID(MClient.get(getCtx()).getAcctSchema().getC_Currency_ID());
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
		
		
		BigDecimal Amt = getQtyIssued().multiply(getUnitPrice());		
		
		String desc = "Permit Issued from " + getC_Order().getDocumentNo() +
				" | Issued Qty: " + getQtyIssued() +" , Tone per Bucket: " + getTonePerBucket().toString();
		if(getDescription() != null && getDescription().trim().length() > 0)
			desc = desc + " | " + getDescription();
		
		
		//Debit Permit Expense
		MJournalLine jl;			
		jl = new MJournalLine(j);
		jl.setLine(10);			
		jl.setAccount_ID(permitExpenseAcct_ID);		
		jl.setDescription(desc);
		jl.setAmtSourceDr(Amt);
		jl.setAmtAcctDr(Amt);
		jl.setIsGenerated(true);
		jl.saveEx();
		
		
		//Credit Permit Stock						
		jl = new MJournalLine(j);
		jl.setLine(20);			
		jl.setAccount_ID(permitStockAcct_ID);		
		jl.setDescription(desc);
		jl.setAmtSourceCr(Amt);
		jl.setAmtAcctCr(Amt);
		jl.setIsGenerated(true);
		jl.saveEx();
		
		//DocAction
		if (!j.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
		j.saveEx();
		
		//setGL_JournalInvAcct_ID(j.getGL_Journal_ID());
		DB.executeUpdate("UPDATE TF_PermitLedgerLine SET GL_Journal_ID=" + j.getGL_Journal_ID() + " WHERE TF_PermitLedgerLine_ID ="
				+ getTF_PermitLedgerLine_ID() , get_TrxName());
		
	}
	
	public void reversePermitExpense() {
		if(getGL_Journal_ID() > 0) {
			TF_MJournal j = new TF_MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
			if(j.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!j.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
				j.saveEx();
			}
			DB.executeUpdate("UPDATE TF_PermitLedgerLine SET GL_Journal_ID=NULL  WHERE TF_PermitLedgerLine_ID ="
					+ getTF_PermitLedgerLine_ID() , get_TrxName());
		}
	}

}
