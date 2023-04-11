package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MJournalLine;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MInvestmentStructure extends X_TF_InvestmentStructure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2233954973943104380L;

	public MInvestmentStructure(Properties ctx, int TF_InvestmentStructure_ID, String trxName) {
		super(ctx, TF_InvestmentStructure_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MInvestmentStructure(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		
		MOrg org = new MOrg(getCtx(), getAD_Org_ID(), get_TrxName());
		boolean isOffsetCapitalAcct = org.get_ValueAsBoolean("IsOffsetCapitalAcct");
				
		if(newRecord || is_ValueChanged(COLUMNNAME_Payable_Amount)) {
			MShareholder.updateInvestmentReceivable(getAD_Org_ID(), get_TrxName());
			if(isOffsetCapitalAcct) {
				postInitialExpenseAllocationJournalEntry();				
			}
		}
		
		return super.afterSave(newRecord, success);
	}
	
	public static void updateInvestmentPaid(int AD_Org_ID, String trxName) {
		String sql = " UPDATE TF_InvestmentStructure s SET Paid_Amount = COALESCE((SELECT SUM(PayAmt) FROM TF_InvestmentReceipt r " +
				" WHERE r.AD_Org_ID = s.AD_Org_ID AND r.C_ElementValue_ID = s.C_ElementValue_ID AND  r.DocStatus = 'CO' AND Processed ='Y'"
				+ " AND r.InvestmentReceiptType IN ('B','P')),0) "
				+ " WHERE s.AD_Org_ID = " + AD_Org_ID + "  AND s.TF_InvestmentStructure_ID = (SELECT MIN(s1.TF_InvestmentStructure_ID) "
				+ " FROM TF_InvestmentStructure s1 WHERE s1.AD_Org_ID = s.AD_Org_ID AND s.C_ElementValue_ID = s1.C_ElementValue_ID ) " ;
		DB.executeUpdate(sql, trxName);		
		MShareholder.updateInvestmentReceived(AD_Org_ID, trxName);
		MShareholder.updateUnallocatedAmt(AD_Org_ID, trxName);
	}
	
	private void postInitialExpenseAllocationJournalEntry() {
		reverseInitialExpenseAllocation();
		if(getPayable_Amount().doubleValue() == 0) 
			return;
		String usrDesc = getDescription();
		TF_MOrg orgHO = new TF_MOrg(getCtx(), getAD_Org_ID(), get_TrxName()).getHeadOffice();
		int investmentAccount = orgHO.getInvestmentAcct_ID();
		int m_C_DocTypeTarget_ID = 1000000;		
		TF_MJournal j = new TF_MJournal(getCtx(), 0, get_TrxName());
		j.setDescription("Initial Expense");
		j.setAD_Org_ID(getAD_Org_ID());
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
		
		//Initial Expense Dr.
		MJournalLine jl;			
		jl = new MJournalLine(j);
		jl.setLine(10);			
		jl.setAccount_ID(getC_ElementValue_ID());		
		jl.setDescription(usrDesc != null ? usrDesc : "Initial Expense Payable");
		jl.setAmtSourceCr(getPayable_Amount());
		jl.setAmtAcctCr(getPayable_Amount());
		jl.setIsGenerated(true);
		jl.saveEx();
		TF_MOrg org = new TF_MOrg(getCtx(), getAD_Org_ID(), get_TrxName());
		String sandPoint = org.getShortName();		
		String desc = "In " + sandPoint;
		
		List<MShareholder> partners = new Query(getCtx(), MShareholder.Table_Name, "AD_Org_ID=?" , get_TrxName())
				.setParameters(getAD_Org_ID()).list();
		int line = 10;
		for(MShareholder partner : partners) {
			jl = new MJournalLine(j);
			line = line + 10;
			jl.setLine(line);
			String  subshareholder="";
			int capAcct_ID = partner.getCapitalAcct_ID();
			if(partner.getTF_ShareholderMain_ID() > 0 &&
					partner.getTF_ShareholderMain().getCapitalAcct_ID() == investmentAccount) {				
				capAcct_ID = partner.getTF_ShareholderMain().getCapitalAcct_ID();				 
				subshareholder = " (" + partner.getName() + ")"; 
			}
			
			jl.setAccount_ID(capAcct_ID);
			if(usrDesc == null || usrDesc.length() == 0)
				jl.setDescription( desc + ", Receivable for " + getC_ElementValue().getName() + subshareholder);
			else
				jl.setDescription( desc + ", " + usrDesc  + subshareholder);
			
			double perecent = partner.getInvestmentShare().doubleValue() / 100;
			BigDecimal drAmt = getPayable_Amount().multiply(new BigDecimal(perecent));					
					
			jl.setAmtSourceDr(drAmt);
			jl.setAmtAcctDr(drAmt);
			jl.setIsGenerated(true);
			jl.saveEx();
		}
		//
				
		
		//DocAction
		if (!j.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
		j.saveEx();
		
		DB.executeUpdate("UPDATE TF_InvestmentStructure SET GL_Journal_ID=" + j.getGL_Journal_ID() + " WHERE TF_InvestmentStructure_ID ="
				+ getTF_InvestmentStructure_ID() , get_TrxName());
		adjustSubShareholderAccountInHeadOffice();
		adjustInvestmentAccountInHeadOffice();
				
	}

	private void reverseInitialExpenseAllocation() {
		if(getGL_Journal_ID() > 0) {
			TF_MJournal j = new TF_MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
			if(j.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!j.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
				j.saveEx();
			}
			DB.executeUpdate("UPDATE TF_InvestmentStructure SET GL_Journal_ID=NULL  WHERE TF_InvestmentStructure_ID ="
					+ getTF_InvestmentStructure_ID() , get_TrxName());
		}
		if(getGL_JournalInvAcct_ID() > 0) {
			TF_MJournal j = new TF_MJournal(getCtx(), getGL_JournalInvAcct_ID(), get_TrxName());
			if(j.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!j.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
				j.saveEx();
			}
			DB.executeUpdate("UPDATE TF_InvestmentStructure SET GL_JournalInvAcct_ID=NULL  WHERE TF_InvestmentStructure_ID ="
					+ getTF_InvestmentStructure_ID() , get_TrxName());
		}
		if(getGL_JournalSubPartnerAdj_ID() > 0) {
			TF_MJournal j = new TF_MJournal(getCtx(), getGL_JournalSubPartnerAdj_ID(), get_TrxName());
			if(j.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!j.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
				j.saveEx();
			}
			DB.executeUpdate("UPDATE TF_InvestmentStructure SET GL_JournalSubPartnerAdj_ID=NULL  WHERE TF_InvestmentStructure_ID ="
					+ getTF_InvestmentStructure_ID() , get_TrxName());
		}
	}
	
	public void adjustSubShareholderAccountInHeadOffice() {
		TF_MOrg org = new TF_MOrg(getCtx(), getAD_Org_ID(), get_TrxName());
		int investmentAccount = org.getHeadOffice().getInvestmentAcct_ID();
		List<MShareholder> subPartners = new Query(getCtx(), MShareholder.Table_Name, "AD_Org_ID=? AND TF_ShareholderMain_ID IS NOT NULL"
				 , get_TrxName()).setParameters(getAD_Org_ID()).list();
		if(subPartners.size() == 0 || org.getAD_OrgHO_ID() == 0)
			return;	
		
		int mainShareholderCapitalAcct = 0;
		for(MShareholder subPartner : subPartners) {
				if (subPartner.getTF_ShareholderMain().getCapitalAcct_ID() == investmentAccount) {
					mainShareholderCapitalAcct = investmentAccount;
					break;
				}
		}
		
		if(org.getHeadOffice().getInvestmentAcct_ID() != mainShareholderCapitalAcct) {
			log.warning("Main Shareholder does not match with Head Office Investment Account!");
			return;
		}
			
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
		
		String sandPoint = org.getShortName();
		StringBuilder sbSubPartners = new StringBuilder();		
		int line = 10;
		MJournalLine jl;
		BigDecimal crAmt = BigDecimal.ZERO;

		String desc = null;
		if(getDescription() == null || getDescription().trim().length() == 0)
			desc = "In " + sandPoint + ", Paid for " + getC_ElementValue().getName();
		else
			desc = " In " + sandPoint + ", " + getDescription();
		
		for(MShareholder partner : subPartners) {
			if(partner.getTF_ShareholderMain().getCapitalAcct_ID() != investmentAccount)
				continue;
			
			double perecent = partner.getInvestmentShare().doubleValue() / 100;
			BigDecimal Amt = getPayable_Amount().multiply(new BigDecimal(perecent));
			crAmt = crAmt.add(Amt);
			sbSubPartners.append(partner.getName() + ",");
			//Debit Sub-Shareholder in Head Office.						
			jl = new MJournalLine(j);
			jl.setLine(line);			
			jl.setAccount_ID(partner.getCapitalAcct_ID());		
			jl.setDescription(desc);
			jl.setAmtSourceDr(Amt);
			jl.setAmtAcctDr(Amt);
			jl.setIsGenerated(true);
			jl.saveEx();
			line = line + 10;			
		}
		//Credit Main Shareholder in Head Office.						
		jl = new MJournalLine(j);
		jl.setLine(20);			
		jl.setAccount_ID(org.getOrganizationAcct_ID());		
		jl.setDescription(desc + " by " + sbSubPartners.toString());
		jl.setAmtSourceCr(crAmt);
		jl.setAmtAcctCr(crAmt);
		jl.setIsGenerated(true);
		jl.saveEx();
		//DocAction
		if (!j.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
		j.saveEx();
		
		//setGL_JournalSubPartnerAdj_ID(j.getGL_Journal_ID());		
		DB.executeUpdate("UPDATE TF_InvestmentStructure SET GL_JournalSubPartnerAdj_ID=" + j.getGL_Journal_ID() + " WHERE TF_InvestmentStructure_ID ="
				+ getTF_InvestmentStructure_ID() , get_TrxName());
	}
	
	
	public void adjustInvestmentAccountInHeadOffice() {
		TF_MOrg org = new TF_MOrg(getCtx(), getAD_Org_ID(), get_TrxName());
		if(org.getAD_OrgHO_ID() == 0)
			throw new AdempiereException("Please specify Head Office!");
		
		MShareholder partner = new Query(getCtx(), MShareholder.Table_Name, "AD_Org_ID=? AND CapitalAcct_ID = ?" , get_TrxName())
				.setParameters(getAD_Org_ID(), org.getHeadOffice().getInvestmentAcct_ID()).first();
		if (partner == null || org.getAD_OrgHO_ID() == 0)
			return;
					
		int m_C_DocTypeTarget_ID = 1000000;
		String sandPoint = org.getShortName();
		
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
		
		double perecent = partner.getInvestmentShare().doubleValue() / 100;
		BigDecimal Amt = getPayable_Amount().multiply(new BigDecimal(perecent));
		
		String desc = null;
		if(getDescription() == null || getDescription().trim().length() == 0)
			desc = "In " + sandPoint + ", " + partner.getName() + " paid for " + getC_ElementValue().getName();
		else
			desc = " In " + sandPoint + ", " + getDescription();
		
		//Debit Initial Expense in Head Office.
		MJournalLine jl;			
		jl = new MJournalLine(j);
		jl.setLine(10);			
		jl.setAccount_ID(getC_ElementValue_ID());		
		jl.setDescription(desc);
		jl.setAmtSourceDr(Amt);
		jl.setAmtAcctDr(Amt);
		jl.setIsGenerated(true);
		jl.saveEx();
		
		
		//Credit Main Shareholder in Head Office.						
		jl = new MJournalLine(j);
		jl.setLine(20);			
		jl.setAccount_ID(org.getOrganizationAcct_ID());		
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
		DB.executeUpdate("UPDATE TF_InvestmentStructure SET GL_JournalInvAcct_ID=" + j.getGL_Journal_ID() + " WHERE TF_InvestmentStructure_ID ="
				+ getTF_InvestmentStructure_ID() , get_TrxName());
		
	}
	
}
