package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class TF_MJournal extends MJournal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8714595661068888689L;

	public TF_MJournal(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MJournal(Properties ctx, int GL_Journal_ID, String trxName) {
		super(ctx, GL_Journal_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MJournal(MJournalBatch parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	public TF_MJournal(MJournal original) {
		super(original);
		// TODO Auto-generated constructor stub
	}

	/** Column name IsQuickEntry */
    public static final String COLUMNNAME_IsQuickEntry = "IsQuickEntry";
    
    /** Set Quick Entry.
	@param IsQuickEntry Quick Entry	  */
    public void setIsQuickEntry (boolean IsQuickEntry)
	{
		set_Value (COLUMNNAME_IsQuickEntry, Boolean.valueOf(IsQuickEntry));
	}
	
	/** Get Quick Entry.
		@return Quick Entry	  */
	public boolean isQuickEntry () 
	{
		Object oo = get_Value(COLUMNNAME_IsQuickEntry);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Column name TF_DebitAcct_ID */
    public static final String COLUMNNAME_TF_DebitAcct_ID = "TF_DebitAcct_ID";
    
    public org.compiere.model.I_C_ElementValue getTF_DebitAcct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getTF_DebitAcct_ID(), get_TrxName());	}

	/** Set Debit Account.
		@param TF_DebitAcct_ID Debit Account	  */
	public void setTF_DebitAcct_ID (int TF_DebitAcct_ID)
	{
		if (TF_DebitAcct_ID < 1) 
			set_Value (COLUMNNAME_TF_DebitAcct_ID, null);
		else 
			set_Value (COLUMNNAME_TF_DebitAcct_ID, Integer.valueOf(TF_DebitAcct_ID));
	}

	/** Get Debit Account.
		@return Debit Account	  */
	public int getTF_DebitAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_DebitAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name TF_DebitLine_ID */
    public static final String COLUMNNAME_TF_DebitLine_ID = "TF_DebitLine_ID";
    
    public org.compiere.model.I_GL_JournalLine getTF_DebitLine() throws RuntimeException
    {
		return (org.compiere.model.I_GL_JournalLine)MTable.get(getCtx(), org.compiere.model.I_GL_JournalLine.Table_Name)
			.getPO(getTF_DebitLine_ID(), get_TrxName());	}

	/** Set Journal Debit Account Line.
		@param TF_DebitLine_ID Journal Debit Account Line	  */
	public void setTF_DebitLine_ID (int TF_DebitLine_ID)
	{
		if (TF_DebitLine_ID < 1) 
			set_Value (COLUMNNAME_TF_DebitLine_ID, null);
		else 
			set_Value (COLUMNNAME_TF_DebitLine_ID, Integer.valueOf(TF_DebitLine_ID));
	}

	/** Get Journal Debit Account Line.
		@return Journal Debit Account Line	  */
	public int getTF_DebitLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_DebitLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name TF_CreditAcct_ID */
    public static final String COLUMNNAME_TF_CreditAcct_ID = "TF_CreditAcct_ID";
    
    public org.compiere.model.I_C_ElementValue getTF_CreditAcct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getTF_CreditAcct_ID(), get_TrxName());	}

	/** Set Credit Account.
		@param TF_CreditAcct_ID Credit Account	  */
	public void setTF_CreditAcct_ID (int TF_CreditAcct_ID)
	{
		if (TF_CreditAcct_ID < 1) 
			set_Value (COLUMNNAME_TF_CreditAcct_ID, null);
		else 
			set_Value (COLUMNNAME_TF_CreditAcct_ID, Integer.valueOf(TF_CreditAcct_ID));
	}

	/** Get Credit Account.
		@return Credit Account	  */
	public int getTF_CreditAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CreditAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name TF_CreditLine_ID */
    public static final String COLUMNNAME_TF_CreditLine_ID = "TF_CreditLine_ID";
    
    public org.compiere.model.I_GL_JournalLine getTF_CreditLine() throws RuntimeException
    {
		return (org.compiere.model.I_GL_JournalLine)MTable.get(getCtx(), org.compiere.model.I_GL_JournalLine.Table_Name)
			.getPO(getTF_CreditLine_ID(), get_TrxName());	}

	/** Set Journal Credit Account Line.
		@param TF_CreditLine_ID Journal Credit Account Line	  */
	public void setTF_CreditLine_ID (int TF_CreditLine_ID)
	{
		if (TF_CreditLine_ID < 1) 
			set_Value (COLUMNNAME_TF_CreditLine_ID, null);
		else 
			set_Value (COLUMNNAME_TF_CreditLine_ID, Integer.valueOf(TF_CreditLine_ID));
	}

	/** Get Journal Credit Account Line.
		@return Journal Credit Account Line	  */
	public int getTF_CreditLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CreditLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Column name Amount */
    public static final String COLUMNNAME_Amount = "Amount";
    
    /** Set Amount.
	@param Amount 
	Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount)
	{
		set_Value (COLUMNNAME_Amount, Amount);
	}
	
	/** Get Amount.
		@return Amount in a defined currency
	  */
	public BigDecimal getAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name IsDistributeProfit */
    public static final String COLUMNNAME_IsDistributeProfit = "IsDistributeProfit";
    /** Set Distribute Profit / Loss.
	@param IsDistributeProfit Distribute Profit / Loss	  */
	public void setIsDistributeProfit (boolean IsDistributeProfit)
	{
		set_Value (COLUMNNAME_IsDistributeProfit, Boolean.valueOf(IsDistributeProfit));
	}
	
	/** Get Distribute Profit / Loss.
		@return Distribute Profit / Loss	  */
	public boolean isDistributeProfit () 
	{
		Object oo = get_Value(COLUMNNAME_IsDistributeProfit);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Column name NetProfit */
    public static final String COLUMNNAME_NetProfit = "NetProfit";
    /** Set Net Profit / Loss.
	@param NetProfit Net Profit / Loss	  */
	public void setNetProfit (BigDecimal NetProfit)
	{
		set_Value (COLUMNNAME_NetProfit, NetProfit);
	}
	
	/** Get Net Profit / Loss.
		@return Net Profit / Loss	  */
	public BigDecimal getNetProfit () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NetProfit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}    
	
	/** Column name GL_JournalProftShare_ID */
    public static final String COLUMNNAME_GL_JournalProftShare_ID = "GL_JournalProftShare_ID";
	public org.compiere.model.I_GL_Journal getGL_JournalProftShare() throws RuntimeException
    {
		return (org.compiere.model.I_GL_Journal)MTable.get(getCtx(), org.compiere.model.I_GL_Journal.Table_Name)
			.getPO(getGL_JournalProftShare_ID(), get_TrxName());	}

	/** Set HO Profit Share Journal.
		@param GL_JournalProftShare_ID HO Profit Share Journal	  */
	public void setGL_JournalProftShare_ID (int GL_JournalProftShare_ID)
	{
		if (GL_JournalProftShare_ID < 1) 
			set_Value (COLUMNNAME_GL_JournalProftShare_ID, null);
		else 
			set_Value (COLUMNNAME_GL_JournalProftShare_ID, Integer.valueOf(GL_JournalProftShare_ID));
	}

	/** Get HO Profit Share Journal.
		@return HO Profit Share Journal	  */
	public int getGL_JournalProftShare_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GL_JournalProftShare_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name C_Project_ID */
    public static final String COLUMNNAME_C_Project_ID = "C_Project_ID";
    public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getC_Project_ID(), get_TrxName());	}

	/** Set Project.
		@param C_Project_ID 
		Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1) 
			set_Value (COLUMNNAME_C_Project_ID, null);
		else 
			set_Value (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Project.
		@return Financial Project
	  */
	public int getC_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		// TODO Auto-generated method stub
		boolean ok = super.afterSave(newRecord, success);
		if(!isProcessed()) {
			updateQuickEntryLines(newRecord);
			createProfitShareLines(newRecord);
		}
		return ok;
	}
	
	private void updateQuickEntryLines(boolean newRecord) {
		boolean isDebitDeleted = false;
		boolean isCreditDeleted = false;
		
		//Delete Debit Line when Debit Account is empty.
		if(getTF_DebitAcct_ID() == 0 && getTF_DebitLine_ID() > 0) {
			MJournalLine jl = new MJournalLine(getCtx(), getTF_DebitLine_ID(), get_TrxName());			
			jl.deleteEx(true);
			DB.executeUpdate("UPDATE GL_Journal SET " + COLUMNNAME_TF_DebitLine_ID + " = NULL "
					+ " WHERE GL_Journal_ID = " + getGL_Journal_ID(), get_TrxName());
			
			isDebitDeleted = true;
		}			
		
		//Delete Credit Line when Credit Account is empty.
		if(getTF_CreditAcct_ID() == 0 && getTF_CreditLine_ID() > 0) {
			MJournalLine jl = new MJournalLine(getCtx(), getTF_CreditLine_ID(), get_TrxName());
			jl.deleteEx(true);
			DB.executeUpdate("UPDATE GL_Journal SET " + COLUMNNAME_TF_CreditLine_ID + " = NULL "
					+ " WHERE GL_Journal_ID = " + getGL_Journal_ID(), get_TrxName());
			isCreditDeleted = true;
		}			
		
		if(isDebitDeleted && isCreditDeleted)
			return;
		
		boolean isAmountChanged = is_ValueChanged(COLUMNNAME_Amount);
		
		//Create/Update Debit Journal Line from Quick Entry field.
		if((getTF_DebitAcct_ID() > 0  && getTF_DebitLine_ID() == 0) || 
				((is_ValueChanged(COLUMNNAME_TF_DebitAcct_ID) || isAmountChanged) && getTF_DebitLine_ID() > 0)) {
			MJournalLine drjl;
			if(getTF_DebitLine_ID() > 0) {
				drjl = new MJournalLine(getCtx(), getTF_DebitLine_ID(), get_TrxName());
			}
			else {
				drjl = new MJournalLine(this);
				drjl.setLine(10);
			}			
			drjl.setAccount_ID(getTF_DebitAcct_ID());
			drjl.setAmtSourceDr(getAmount());
			drjl.setAmtAcctDr(getAmount());
			drjl.setIsGenerated(true);			
			drjl.saveEx();
			
			if(getTF_DebitLine_ID() == 0)
			DB.executeUpdate("UPDATE GL_Journal SET " + COLUMNNAME_TF_DebitLine_ID + " = "
					+ drjl.getGL_JournalLine_ID() + " WHERE GL_Journal_ID = " + getGL_Journal_ID(), get_TrxName());			
		}
		
		//Create/Update Credit Journal Line from Quick Entry field.
		if((getTF_CreditAcct_ID() > 0  && getTF_CreditLine_ID() == 0) || 
				((is_ValueChanged(COLUMNNAME_TF_CreditAcct_ID) || isAmountChanged) && getTF_CreditLine_ID() > 0)) {
			MJournalLine drjl;
			if(getTF_CreditLine_ID() > 0) {
				drjl = new MJournalLine(getCtx(), getTF_CreditLine_ID(), get_TrxName());
			}
			else {
				drjl = new MJournalLine(this);
				drjl.setLine(20);
			}
			drjl.setAccount_ID(getTF_CreditAcct_ID());
			drjl.setAmtSourceCr(getAmount());
			drjl.setAmtAcctCr(getAmount());
			drjl.setIsGenerated(true);
			drjl.saveEx();
			
			if(getTF_CreditLine_ID() == 0)
			DB.executeUpdate("UPDATE GL_Journal SET " + COLUMNNAME_TF_CreditLine_ID + " = "
					+ drjl.getGL_JournalLine_ID() + " WHERE GL_Journal_ID = " + getGL_Journal_ID(), get_TrxName());			
		}
			
	}
	
	private void createProfitShareLines(boolean newRecord) {
		if(isDistributeProfit() && (newRecord || is_ValueChanged(COLUMNNAME_NetProfit) || is_ValueChanged(COLUMNNAME_DateAcct))) {
			MJournalLine[] lines = getLines(true);
			//Deleting all lines to create new profit share lines.
			for(MJournalLine line : lines) {
				MJournalLine l = new MJournalLine(getCtx(), line.getGL_JournalLine_ID(), get_TrxName());
				l.deleteEx(true);
			}
		}
		else {
			return;
		}
		
		if(getNetProfit().doubleValue() == 0 && isDistributeProfit()) 
			return;
			
		
		List<MShareholder> partners = new Query(getCtx(), MShareholder.Table_Name, "AD_Org_ID = ? AND TF_ShareholderMain_ID IS NULL AND ProfitShare > 0", get_TrxName())
				.setClient_ID().setParameters(getAD_Org_ID()).list();
		
		boolean isProfit = getNetProfit().doubleValue() > 0 ;		
		BigDecimal netProfit = getNetProfit().abs();
		
		int PLApprAcct_ID = MGLPostingConfig.getMGLPostingConfig(getCtx()).getPLApprAcct_ID();
		
		// P & L Appr. a/c
		MJournalLine jl = new MJournalLine(this);
		int line = 10;
		jl.setLine(line);			
		jl.setAccount_ID(PLApprAcct_ID);
		jl.setDescription("Net Profit Transferred to " + partners.size() + " Shareholders");
		if(isProfit) {
			jl.setAmtSourceDr(netProfit);
			jl.setAmtAcctDr(netProfit);
		}
		else {
			jl.setAmtSourceCr(netProfit);
			jl.setAmtAcctCr(netProfit);
		}
		jl.setIsGenerated(true);
		jl.saveEx();
		
		for(MShareholder partner : partners) {
			jl = new MJournalLine(this);
			line = line + 10;
			jl.setLine(line);			
			jl.setAccount_ID(partner.getCapitalAcct_ID());
			BigDecimal profitShare = partner.getProfitShare(true);
			String desc = "PROFIT SHARE " + profitShare.toString() + "% of Rs." + getNetProfit().toString();
			jl.setDescription(desc);
			BigDecimal profitShareAmt = profitShare.multiply(netProfit).divide(new BigDecimal(100), 0, RoundingMode.HALF_EVEN);
			if(isProfit) {
				jl.setAmtSourceCr(profitShareAmt);
				jl.setAmtAcctCr(profitShareAmt);
			}
			else {
				jl.setAmtSourceDr(profitShareAmt);
				jl.setAmtAcctDr(profitShareAmt);
			}
			jl.setIsGenerated(true);
			jl.saveEx();
		}
	}
	
	private void postProfitSharetoHeadOffice() {
		if(!isDistributeProfit() || getNetProfit().doubleValue() == 0)
			return;
				
		TF_MOrg org = new TF_MOrg(getCtx(), getAD_Org_ID(), get_TrxName());
		if(org.getAD_OrgHO_ID() == 0)
			return;
		
		TF_MOrg HO = (TF_MOrg) org.getHeadOffice();
		
		String whereClause = "AD_Org_ID = ? AND GL_Journal_ID = ? AND Account_ID = ?";
		MJournalLine jl = new Query(getCtx(), MJournalLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID().setParameters(getAD_Org_ID(), getGL_Journal_ID(), HO.getInvestmentAcct_ID()).first();
		if(jl == null)
			throw new AdempiereException("Investment Account is not found in Profit Share Lines!");
		
		BigDecimal ProfitEarned;
		Boolean isProfit = jl.getAmtAcctCr().doubleValue() > 0;
		if(isProfit) 
			ProfitEarned = jl.getAmtAcctCr();
		else
			ProfitEarned = jl.getAmtAcctDr();
		
		if(ProfitEarned.doubleValue() == 0)
			return; //No Posting
		
		whereClause = "AD_Org_ID = ? AND CapitalAcct_ID = ?";
		MShareholder partner = new Query(getCtx(), MShareholder.Table_Name, whereClause, get_TrxName())
				.setClient_ID().setParameters(getAD_Org_ID(), HO.getInvestmentAcct_ID()).first();
		if(partner == null)
			throw new AdempiereException("Invalid Investment/Capital account defined in Shareholder Structure!");
		
		BigDecimal totalPercent = partner.getProfitShare(true);
		int orgAcct_ID = org.getOrganizationAcct_ID();
		int orgEarningsAcct_ID = org.getOrganizationEarningsAcct_ID();
		if(orgEarningsAcct_ID == 0)
			throw new AdempiereException("Please specify Organization's Earnings Account!");
		
		String sandPoint = org.getShortName();
		
		int m_C_DocTypeTarget_ID = 1000000;		
		TF_MJournal j = new TF_MJournal(getCtx(), 0, get_TrxName());
		j.setDescription("Profit / Loss Received from " + sandPoint);
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
		
		
		
		// Organization Account
		jl = new MJournalLine(j);
		int line = 10;
		jl.setLine(line);			
		jl.setAccount_ID(orgAcct_ID);		
		if(isProfit) {
			jl.setDescription("Net Profit Transferred to Shareholders");
			jl.setAmtSourceDr(ProfitEarned);
			jl.setAmtAcctDr(ProfitEarned);
		}
		else {
			jl.setDescription("Net Loss Transferred to Shareholders");
			jl.setAmtSourceCr(ProfitEarned);
			jl.setAmtAcctCr(ProfitEarned);
		}
		jl.setIsGenerated(true);
		jl.saveEx();
	
		// Organization Earnigs Account (HO Income Account)
		jl = new MJournalLine(j);
		line = line + 10;
		jl.setLine(line);			
		jl.setAccount_ID(orgEarningsAcct_ID);
		BigDecimal HOIncome = partner.getProfitShare().divide(totalPercent, 4, RoundingMode.HALF_EVEN).multiply(ProfitEarned);
		BigDecimal percent = partner.getProfitShare().divide(totalPercent, 4, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
		if(isProfit) {
			String desc = "PROFIT SHARE " + percent.toString() + "% of Rs." + ProfitEarned;
			jl.setDescription(desc);
			jl.setAmtSourceCr(HOIncome);
			jl.setAmtAcctCr(HOIncome);
		}
		else {
			String desc = "LOSS SHARE " + percent.toString() + "% of Rs." + ProfitEarned;
			jl.setDescription(desc);
			jl.setAmtSourceDr(ProfitEarned);
			jl.setAmtAcctDr(ProfitEarned);
		}
		jl.setIsGenerated(true);
		jl.saveEx();
		
		//Subshareholders Profit Distribution
		for(MShareholder subPartner : partner.getSubShareholders()) {
			// Subshareholder's capital Account
			jl = new MJournalLine(j);
			line = line + 10;
			jl.setLine(line);			
			jl.setAccount_ID(subPartner.getCapitalAcct_ID());
			BigDecimal SubShareholderIncome = subPartner.getProfitShare().divide(totalPercent, 4, RoundingMode.HALF_EVEN).multiply(ProfitEarned);
			percent = subPartner.getProfitShare().divide(totalPercent, 4, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
			if(isProfit) {
				String desc = "FROM " + sandPoint + ", PROFIT SHARE " + percent.toString() + "% of Rs." + ProfitEarned;
				jl.setDescription(desc);
				jl.setAmtSourceCr(SubShareholderIncome);
				jl.setAmtAcctCr(SubShareholderIncome);
			}
			else {
				String desc = "FROM " + sandPoint + ", LOSS SHARE " + percent.toString() + "% of Rs." + ProfitEarned;
				jl.setDescription(desc);
				jl.setAmtSourceCr(SubShareholderIncome);
				jl.setAmtAcctCr(SubShareholderIncome);
			}
			jl.setIsGenerated(true);
			jl.saveEx();
		}
		
		//DocAction
		if (!j.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
		j.saveEx();
		
		//setGL_JournalProfitShare_ID(j.getGL_Journal_ID());		
		DB.executeUpdate("UPDATE GL_Journal SET GL_JournalProftShare_ID=" + j.getGL_Journal_ID() + " WHERE GL_Journal_ID ="
				+ getGL_Journal_ID() , get_TrxName());
		
	}
	
	private void reverseProfitSharetoHeadOffice() {
		if(getGL_JournalProftShare_ID() > 0) {
			TF_MJournal j = new TF_MJournal(getCtx(), getGL_JournalProftShare_ID(), get_TrxName());
			if(j.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!j.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
				j.saveEx();
			}					
			DB.executeUpdate("UPDATE GL_Journal SET GL_JournalProftShare_ID= NULL WHERE GL_Journal_ID ="
					+ getGL_Journal_ID() , get_TrxName());
		}
	}
	
	@Override
	public String completeIt() {		
		postProfitSharetoHeadOffice();
		String msg = super.completeIt();		
		return msg;
	}

	@Override
	public boolean reverseCorrectIt() {
		reverseProfitSharetoHeadOffice();
		return super.reverseCorrectIt();
	}

	@Override
	public boolean reverseAccrualIt() {
		reverseProfitSharetoHeadOffice();
		return super.reverseAccrualIt();
	}

	@Override
	public boolean reActivateIt() {
		reverseProfitSharetoHeadOffice();
		return super.reActivateIt();
	}

	public static BigDecimal getNetProfit(int AD_Org_ID, Timestamp dateAcct) {
		String sql = "SELECT SUM(AmtAcct) * -1  FROM rv_fact_acct_day WHERE Account_ID = ? AND AD_Org_ID = ? AND DateAcct <= ? ";		
		int PLAcct = MGLPostingConfig.getMGLPostingConfig(Env.getCtx()).getPLApprAcct_ID();
		
		BigDecimal netProfit = DB.getSQLValueBD(null, sql, PLAcct, AD_Org_ID, dateAcct);
		
		if(netProfit == null)
			netProfit = BigDecimal.ZERO;
		
		return netProfit;
	}

}
