package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MBankAccount;
import org.compiere.model.MClient;
import org.compiere.model.MTable;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class TF_MBankAccount extends MBankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2319405472266282417L;

	public TF_MBankAccount(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MBankAccount(Properties ctx, int C_BankAccount_ID, String trxName) {
		super(ctx, C_BankAccount_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	/** Column name AccountGroup_ID */
    public static final String COLUMNNAME_AccountGroup_ID = "AccountGroup_ID";
    
    public org.compiere.model.I_C_ElementValue getAccountGroup() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getAccountGroup_ID(), get_TrxName());	}

	/** Set Account Group.
		@param AccountGroup_ID Account Group	  */
	public void setAccountGroup_ID (int AccountGroup_ID)
	{
		if (AccountGroup_ID < 1) 
			set_Value (COLUMNNAME_AccountGroup_ID, null);
		else 
			set_Value (COLUMNNAME_AccountGroup_ID, Integer.valueOf(AccountGroup_ID));
	}

	/** Get Account Group.
		@return Account Group	  */
	public int getAccountGroup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AccountGroup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name BankAsset_ID */
    public static final String COLUMNNAME_BankAsset_ID = "BankAsset_ID";
    
    public org.compiere.model.I_C_ElementValue getBankAsset() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getBankAsset_ID(), get_TrxName());	
	}

	/** Set Bank/Cash Asset Account.
		@param BankAsset_ID Bank/Cash Asset Account	  */
	public void setBankAsset_ID (int BankAsset_ID)
	{
		if (BankAsset_ID < 1) 
			set_Value (COLUMNNAME_BankAsset_ID, null);
		else 
			set_Value (COLUMNNAME_BankAsset_ID, Integer.valueOf(BankAsset_ID));
	}

	/** Get Bank/Cash Asset Account.
		@return Bank/Cash Asset Account	  */
	public int getBankAsset_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BankAsset_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
    
	/** Column name BankInTransit_ID */
    public static final String COLUMNNAME_BankInTransit_ID = "BankInTransit_ID";
    public org.compiere.model.I_C_ElementValue getBankInTransit() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getBankInTransit_ID(), get_TrxName());	}

	/** Set Bank In Transit Account.
		@param BankInTransit_ID Bank In Transit Account	  */
	public void setBankInTransit_ID (int BankInTransit_ID)
	{
		if (BankInTransit_ID < 1) 
			set_Value (COLUMNNAME_BankInTransit_ID, null);
		else 
			set_Value (COLUMNNAME_BankInTransit_ID, Integer.valueOf(BankInTransit_ID));
	}

	/** Get Bank In Transit Account.
		@return Bank In Transit Account	  */
	public int getBankInTransit_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BankInTransit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Column name DebitBalance */
    public static final String COLUMNNAME_DebitBalance = "DebitBalance";
    /** Set Debit Balance.
	@param DebitBalance Debit Balance	  */
	public void setDebitBalance (BigDecimal DebitBalance)
	{
		set_Value (COLUMNNAME_DebitBalance, DebitBalance);
	}
	
	/** Get Debit Balance.
		@return Debit Balance	  */
	public BigDecimal getDebitBalance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DebitBalance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name CreditBalance */
    public static final String COLUMNNAME_CreditBalance = "CreditBalance";

    /** Set Credit Balance.
	@param CreditBalance Credit Balance	  */
	public void setCreditBalance (BigDecimal CreditBalance)
	{
		set_Value (COLUMNNAME_CreditBalance, CreditBalance);
	}
	
	/** Get Credit Balance.
		@return Credit Balance	  */
	public BigDecimal getCreditBalance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CreditBalance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

    /** Column name OpeningDate */
    public static final String COLUMNNAME_OpeningDate = "OpeningDate";
    /** Set AS On.
	@param OpeningDate AS On	  */
	public void setOpeningDate (Timestamp OpeningDate)
	{
		set_Value (COLUMNNAME_OpeningDate, OpeningDate);
	}
	
	/** Get AS On.
		@return AS On	  */
	public Timestamp getOpeningDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_OpeningDate);
	}

    /** Column name C_Payment_ID */
    public static final String COLUMNNAME_C_Payment_ID = "C_Payment_ID";
    public org.compiere.model.I_C_Payment getC_Payment() throws RuntimeException
    {
		return (org.compiere.model.I_C_Payment)MTable.get(getCtx(), org.compiere.model.I_C_Payment.Table_Name)
			.getPO(getC_Payment_ID(), get_TrxName());	}

	/** Set Payment.
		@param C_Payment_ID 
		Payment identifier
	  */
	public void setC_Payment_ID (int C_Payment_ID)
	{
		if (C_Payment_ID < 1) 
			set_Value (COLUMNNAME_C_Payment_ID, null);
		else 
			set_Value (COLUMNNAME_C_Payment_ID, Integer.valueOf(C_Payment_ID));
	}

	/** Get Payment.
		@return Payment identifier
	  */
	public int getC_Payment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    
	@Override
	protected boolean beforeSave(boolean newRecord) {		
		if(getBankAsset_ID() == 0) {			
			 setBankAsset_ID(createBankCashAccount(getValue(), getName()));			 
		 }		
		if(!getBankAccountType().equals(TF_MBankAccount.BANKACCOUNTTYPE_Cash) && getBankInTransit_ID()==0) {
			setBankInTransit_ID(createBankCashAccount(getValue() + " In-Transfer", getName() + " In-Transfer"));
		}
		else if (getBankAccountType().equals(TF_MBankAccount.BANKACCOUNTTYPE_Cash)){
			setBankInTransit_ID(getBankAsset_ID());
		}
		return super.beforeSave(newRecord);
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {		
		 boolean ok = super.afterSave(newRecord, success);
		 
		 if(getBankAsset_ID() > 0) {
			 MAccount account = getAccount(getBankAsset_ID());
			if(account.getC_ValidCombination_ID() == 0)
				account.saveEx(); // Create new account combination
			
			String sql = "UPDATE C_BankAccount_Acct SET B_Asset_Acct=" + account.get_ID() + 
						" WHERE C_BankAccount_ID= " + getC_BankAccount_ID() + " AND C_AcctSchema_ID= " + account.getC_AcctSchema_ID();
			DB.executeUpdate(sql, get_TrxName());
		 }
		 if(getBankInTransit_ID() > 0) {
			 MAccount account = getAccount(getBankInTransit_ID());
			if(account.getC_ValidCombination_ID() == 0)
				account.saveEx(); // Create new account combination
			
			String sql = "UPDATE C_BankAccount_Acct SET B_InTransit_Acct=" + account.get_ID() + 
						" WHERE C_BankAccount_ID= " + getC_BankAccount_ID() + " AND C_AcctSchema_ID= " + account.getC_AcctSchema_ID();
			DB.executeUpdate(sql, get_TrxName());
		 }
		 
		 setOpeningBalance(newRecord);
		 
		 return ok;
	}

	private int createBankCashAccount(String value, String name) {
		int elementID = Env.getContextAsInt(getCtx(), "#C_Element_ID");
		String where = "C_Element_ID = ? AND Value=?";
		List<TF_MElementValue> accts = new Query(getCtx(), TF_MElementValue.Table_Name, where, get_TrxName())
				.setClient_ID().setParameters(elementID, name).list();
		if(accts.size() > 0 ) {
			return accts.get(0).getC_ElementValue_ID();
		}
		else {
			 TF_MElementValue acct = new TF_MElementValue(getCtx(), 0, get_TrxName());		 
			 acct.setC_Element_ID(elementID);
			 acct.setValue(name);
			 acct.setName(name);
			 acct.setAccountGroup_ID(getAccountGroup_ID());
			 acct.setAccountType(TF_MElementValue.ACCOUNTTYPE_Asset);
			 acct.setAccountSign(TF_MElementValue.ACCOUNTSIGN_Natural);
			 acct.setPostActual(true);
			 acct.setPostBudget(true);
			 acct.setPostStatistical(true);
			 acct.setIsSummary(false);
			 acct.setIsBankAccount(true);
			 acct.setIsDocControlled(true);
			 acct.setDefaultOrg_ID(getAD_Org_ID());
			 acct.saveEx();
		 return acct.getC_ElementValue_ID();
		}
	}
	
	 /**
     * Gets the account for the specified charge and element value.
     * The account is created if it doesn't already exist.
     * @param elementValueId    identifier for the element value
     * @return the account
     */
    private MAccount getAccount(int elementValueId)
    {
    	Properties ctx = Env.getCtx();
    	MAcctSchema m_acctSchema = MClient.get(getCtx()).getAcctSchema();
        MAccount defaultAccount = MAccount.getDefault(m_acctSchema, true); //  optional null
        MAccount account = MAccount.get(ctx,
            Env.getAD_Client_ID(ctx),
            getAD_Org_ID(),
            m_acctSchema.getC_AcctSchema_ID(),
            elementValueId,
            defaultAccount.getC_SubAcct_ID(),
            defaultAccount.getM_Product_ID(),
            defaultAccount.getC_BPartner_ID(),
            defaultAccount.getAD_OrgTrx_ID(),
            defaultAccount.getC_LocFrom_ID(),
            defaultAccount.getC_LocTo_ID(),
            defaultAccount.getC_SalesRegion_ID(),
            defaultAccount.getC_Project_ID(),
            defaultAccount.getC_Campaign_ID(),
            defaultAccount.getC_Activity_ID(),
            defaultAccount.getUser1_ID(),
            defaultAccount.getUser2_ID(),
            defaultAccount.getUserElement1_ID(),
            defaultAccount.getUserElement2_ID(),
            get_TrxName());

        return account;
    }
	
    public void setOpeningBalance(boolean newRecord) {
    	if(newRecord || is_ValueChanged(COLUMNNAME_DebitBalance) || is_ValueChanged(COLUMNNAME_CreditBalance)
				|| is_ValueChanged(COLUMNNAME_OpeningDate)) {
			if(getC_Payment_ID() > 0) {
				TF_MPayment p = new TF_MPayment(getCtx(), getC_Payment_ID(), get_TrxName());
				if(p.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
					if (!p.processIt(DocAction.ACTION_Reverse_Correct))
						throw new AdempiereException("Failed when processing document - " + p.getProcessMsg());
					p.saveEx();
				}								
			}
    	}
		BigDecimal DebitAmt = getDebitBalance();
		BigDecimal CreditAmt = getCreditBalance();
		boolean isReceipt;			
		int m_C_DocTypeTarget_ID;
		MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(getCtx());
		BigDecimal amount;
		
		if(DebitAmt.doubleValue()!=0) {
			m_C_DocTypeTarget_ID = 1000008;				
			isReceipt = true;
			amount = DebitAmt;
		}				
		else if(CreditAmt.doubleValue() != 0) {
			m_C_DocTypeTarget_ID = 1000009;				
			isReceipt = false;
			amount = CreditAmt;
		}
		else {
			DB.executeUpdate("UPDATE C_BankAccount SET C_Payment_ID=NULL  WHERE C_BankAccount_ID ="
					+ getC_BankAccount_ID(), get_TrxName());
			return;
		}
		
		MUser user = MUser.get(getCtx(), Env.getAD_User_ID(getCtx()));				
		int bPartnerID = user.getC_BPartner_ID();
		
		//Posting Payment Document for Opening Balance
		TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
		payment.setC_DocType_ID(m_C_DocTypeTarget_ID);
		payment.setIsReceipt(isReceipt);
		payment.setDateAcct(getOpeningDate());
		payment.setDateTrx(getOpeningDate());
		payment.setDescription("Opening Balance Entered");
		payment.setC_BPartner_ID(bPartnerID);
		payment.setC_ElementValue_ID(glConfig.getOpeningBalAcct_ID());
		payment.setC_BankAccount_ID(getC_BankAccount_ID());
		payment.setPayAmt(amount);
		payment.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
		payment.setDocStatus(TF_MPayment.DOCSTATUS_InProgress);
		payment.setTenderType(TF_MPayment.TENDERTYPE_Cash);
		payment.saveEx();
		payment.processIt(DocAction.ACTION_Complete);
		payment.saveEx();
		
		DB.executeUpdate("UPDATE C_BankAccount SET C_Payment_ID=" + payment.getC_Payment_ID() + " WHERE C_BankAccount_ID ="
				+ getC_BankAccount_ID(), get_TrxName());			
    	
			
    }
    public static int getDefaultCashAccount(Properties ctx,int AD_Org_ID,String trxName)
    {
		String Where=" AD_Org_ID=? AND BankAccountType='B' AND IsDefault='Y'";
		MBankAccount cashAccount = new Query(ctx, Table_Name, Where, trxName)
				.setClient_ID()
				.setOnlyActiveRecords(true)
				.setParameters(AD_Org_ID)
				.first();
		if(cashAccount != null)
		{
			return cashAccount.getC_BankAccount_ID();
		}
		else
		{
			throw new AdempiereException("No Cash Account Configured for this Organization!");
		}
    	
    }
    
    public static int getDefaultBankAccount(Properties ctx,int AD_Org_ID,String trxName)
    {
		String Where=" AD_Org_ID=? AND BankAccountType='X'";
		MBankAccount bankAccount = new Query(ctx, Table_Name, Where, trxName)
				.setClient_ID()
				.setOnlyActiveRecords(true)
				.setParameters(AD_Org_ID)
				.setOrderBy(COLUMNNAME_IsDefault)
				.first();
		
		if(bankAccount != null)
		{
			return bankAccount.getC_BankAccount_ID();
		}
		else
		{
			throw new AdempiereException("No Bank Account Configured for this Organization!");
		}
    	
    }
}
