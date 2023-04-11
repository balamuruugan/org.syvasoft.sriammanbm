package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MPeriod;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MCOAOpeningBalance extends X_TF_COAOpeningBalance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7379557412058661325L;

	public MCOAOpeningBalance(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);		
	}

	public MCOAOpeningBalance(Properties ctx, int TF_COAOpeningBalance_ID, String trxName) {
		super(ctx, TF_COAOpeningBalance_ID, trxName);		
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {		
		boolean ok = super.afterSave(newRecord, success);
		setOpeningBalance(newRecord);
		return ok;
	}

	@Override
	protected boolean beforeDelete() {		
		boolean ok = super.beforeDelete();
		if(getGL_Journal_ID() > 0) {
			throw new AdempiereException("Reset Debit or Credit Balance to ZERO to delete this recod!");
		}
		return ok;
	}

	public void setOpeningBalance(boolean newRecord) {
		if(newRecord || is_ValueChanged(COLUMNNAME_DebitBalance) || is_ValueChanged(COLUMNNAME_CreditBalance)
				|| is_ValueChanged(COLUMNNAME_OpeningDate)) {
			if(getGL_Journal_ID() > 0) {
				TF_MJournal j = new TF_MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
				if(j.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
					if (!j.processIt(DocAction.ACTION_Reverse_Correct))
						throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
					j.saveEx();
				}
			}
			
			BigDecimal DebitAmt = getDebitBalance();
			BigDecimal CreditAmt = getCreditBalance();						
			int m_C_DocTypeTarget_ID = 1000000;
			int Dr_ElementValue_ID;
			int Cr_ElementValue_ID;
			BigDecimal Amount;
			
			MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(getCtx());
			if(DebitAmt.doubleValue()!=0) {
				Dr_ElementValue_ID = getC_ElementValue_ID();
				Cr_ElementValue_ID = glConfig.getOpeningBalAcct_ID();
				Amount = DebitAmt;
			}				
			else if(CreditAmt.doubleValue() != 0) {
				Cr_ElementValue_ID = getC_ElementValue_ID();
				Dr_ElementValue_ID = glConfig.getOpeningBalAcct_ID();
				Amount = CreditAmt;
			}
			else {
				DB.executeUpdate("UPDATE TF_COAOpeningBalance SET GL_Journal_ID=NULL WHERE TF_COAOpeningBalance_ID ="
						+ getTF_COAOpeningBalance_ID() , get_TrxName());
				return;
			}
			
			//Posting Opening Balance GL journal 
			TF_MJournal j = new TF_MJournal(getCtx(), 0, get_TrxName());
			j.setDescription("Opening Balance Set");
			j.setAD_Org_ID(getAD_Org_ID());
			j.setC_AcctSchema_ID(Env.getContextAsInt(getCtx(), "$C_AcctSchema_ID"));
			j.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
			j.setPostingType(TF_MJournal.POSTINGTYPE_Actual);
			j.setC_DocType_ID(m_C_DocTypeTarget_ID);
			j.setDateDoc(getOpeningDate());
			j.setDateAcct(getOpeningDate());
			j.setDocStatus(TF_MJournal.DOCSTATUS_Drafted);
			MPeriod period = MPeriod.get(getCtx(), getOpeningDate());
			j.setC_Period_ID(period.getC_Period_ID());
			j.setGL_Category_ID(1000000);
			j.setC_ConversionType_ID(114);
			j.setIsQuickEntry(true);
			j.setAmount(Amount);
			j.setTF_DebitAcct_ID(Dr_ElementValue_ID);
			j.setTF_CreditAcct_ID(Cr_ElementValue_ID);			
			j.saveEx();
			
			//DocAction
			if (!j.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
			j.saveEx();
			
			DB.executeUpdate("UPDATE TF_COAOpeningBalance SET GL_Journal_ID=" + j.getGL_Journal_ID() + " WHERE TF_COAOpeningBalance_ID ="
					+ getTF_COAOpeningBalance_ID() , get_TrxName());
			
		}
	}
}
