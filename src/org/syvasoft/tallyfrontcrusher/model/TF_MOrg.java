package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MOrg;
import org.compiere.model.MTable;

public class TF_MOrg extends MOrg {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3099755752711559455L;

	public TF_MOrg(Properties ctx, int AD_Org_ID, String trxName) {
		super(ctx, AD_Org_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MOrg(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	/** Column name AD_OrgHO_ID */
    public static final String COLUMNNAME_AD_OrgHO_ID = "AD_OrgHO_ID";
    /** Set Head Office.
	@param AD_OrgHO_ID Head Office	  */
	public void setAD_OrgHO_ID (int AD_OrgHO_ID)
	{
		if (AD_OrgHO_ID < 1) 
			set_Value (COLUMNNAME_AD_OrgHO_ID, null);
		else 
			set_Value (COLUMNNAME_AD_OrgHO_ID, Integer.valueOf(AD_OrgHO_ID));
	}
	
	/** Get Head Office.
		@return Head Office	  */
	public int getAD_OrgHO_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_OrgHO_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Column name InvestmentAcct_ID */
    public static final String COLUMNNAME_InvestmentAcct_ID = "InvestmentAcct_ID";
    
    public org.compiere.model.I_C_ElementValue getInvestmentAcct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getInvestmentAcct_ID(), get_TrxName());	}

	/** Set Investment Account.
		@param InvestmentAcct_ID Investment Account	  */
	public void setInvestmentAcct_ID (int InvestmentAcct_ID)
	{
		if (InvestmentAcct_ID < 1) 
			set_Value (COLUMNNAME_InvestmentAcct_ID, null);
		else 
			set_Value (COLUMNNAME_InvestmentAcct_ID, Integer.valueOf(InvestmentAcct_ID));
	}

	/** Get Investment Account.
		@return Investment Account	  */
	public int getInvestmentAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_InvestmentAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	public TF_MOrg getHeadOffice() {
		TF_MOrg org = null;
		if(getAD_OrgHO_ID() > 0 )
			org = new TF_MOrg(getCtx(), getAD_OrgHO_ID(), get_TrxName());
		return org;
	}
	
    /** Column name ShortName */
    public static final String COLUMNNAME_ShortName = "ShortName";
    /** Set Short Name.
	@param ShortName Short Name	  */
	public void setShortName (String ShortName)
	{
		set_Value (COLUMNNAME_ShortName, ShortName);
	}
	
	/** Get Short Name.
		@return Short Name	  */
	public String getShortName () 
	{
		String shortName = (String)get_Value(COLUMNNAME_ShortName); 
		if(shortName == null || shortName.trim().length() == 0)
			shortName = getName();
		return shortName;		
	}
	
	/** Column name IsDemo */
    public static final String COLUMNNAME_IsDemo = "IsDemo";
    /** Set Demo.
	@param IsDemo Demo	  */
	public void setIsDemo (boolean IsDemo)
	{
		set_Value (COLUMNNAME_IsDemo, Boolean.valueOf(IsDemo));
	}
	
	/** Get Demo.
		@return Demo	  */
	public boolean isDemo () 
	{
		Object oo = get_Value(COLUMNNAME_IsDemo);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
    /** Column name OrgType */
    public static final String COLUMNNAME_OrgType = "OrgType";
    /** Crusher = C */
	public static final String ORGTYPE_Crusher = "C";
	/** Sand Block Bucket = S */
	public static final String ORGTYPE_SandBlockBucket = "S";
	/** Trading = T */
	public static final String ORGTYPE_Trading = "T";
	/** Head Office = H */
	public static final String ORGTYPE_HeadOffice = "H";
	/** Sand Block Weighbridge = W */
	public static final String ORGTYPE_SandBlockWeighbridge = "W";
	/** Set Organization Type.
		@param OrgType Organization Type	  */
    /** Set Organization Type.
	@param OrgType Organization Type	  */
	public void setOrgType (String OrgType)
	{
	
		set_Value (COLUMNNAME_OrgType, OrgType);
	}
	
	/** Get Organization Type.
		@return Organization Type	  */
	public String getOrgType () 
	{
		return (String)get_Value(COLUMNNAME_OrgType);
	}
	
	/** Column name OrganizationAcct_ID */
    public static final String COLUMNNAME_OrganizationAcct_ID = "OrganizationAcct_ID";
    public org.compiere.model.I_C_ElementValue getOrganizationAcct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getOrganizationAcct_ID(), get_TrxName());	}

	/** Set Organization Account.
		@param OrganizationAcct_ID Organization Account	  */
	public void setOrganizationAcct_ID (int OrganizationAcct_ID)
	{
		if (OrganizationAcct_ID < 1) 
			set_Value (COLUMNNAME_OrganizationAcct_ID, null);
		else 
			set_Value (COLUMNNAME_OrganizationAcct_ID, Integer.valueOf(OrganizationAcct_ID));
	}

	/** Get Organization Account.
		@return Organization Account	  */
	public int getOrganizationAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_OrganizationAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name OrganizationEarningsAcct_ID */
    public static final String COLUMNNAME_OrganizationEarningsAcct_ID = "OrganizationEarningsAcct_ID";
    
    public org.compiere.model.I_C_ElementValue getOrganizationEarningsAcct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getOrganizationEarningsAcct_ID(), get_TrxName());	}

	/** Set Earnings Account.
		@param OrganizationEarningsAcct_ID Earnings Account	  */
	public void setOrganizationEarningsAcct_ID (int OrganizationEarningsAcct_ID)
	{
		if (OrganizationEarningsAcct_ID < 1) 
			set_Value (COLUMNNAME_OrganizationEarningsAcct_ID, null);
		else 
			set_Value (COLUMNNAME_OrganizationEarningsAcct_ID, Integer.valueOf(OrganizationEarningsAcct_ID));
	}

	/** Get Earnings Account.
		@return Earnings Account	  */
	public int getOrganizationEarningsAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_OrganizationEarningsAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name InstantPettyCashAcct_ID */
    public static final String COLUMNNAME_InstantPettyCashAcct_ID = "InstantPettyCashAcct_ID";
    
	public org.compiere.model.I_C_ElementValue getInstantPettyCashAcct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getInstantPettyCashAcct_ID(), get_TrxName());	}

	/** Set Instant Petty Cash Account.
		@param InstantPettyCashAcct_ID Instant Petty Cash Account	  */
	public void setInstantPettyCashAcct_ID (int InstantPettyCashAcct_ID)
	{
		if (InstantPettyCashAcct_ID < 1) 
			set_Value (COLUMNNAME_InstantPettyCashAcct_ID, null);
		else 
			set_Value (COLUMNNAME_InstantPettyCashAcct_ID, Integer.valueOf(InstantPettyCashAcct_ID));
	}

	/** Get Instant Petty Cash Account.
		@return Instant Petty Cash Account	  */
	public int getInstantPettyCashAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_InstantPettyCashAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
    /** Column name eInvAuthenticationURL */
    public static final String COLUMNNAME_eInvAuthenticationURL = "eInvAuthenticationURL";
	/** Set eInvoice Authentication URL.
		@param eInvAuthenticationURL eInvoice Authentication URL	  */
	public void seteInvAuthenticationURL (String eInvAuthenticationURL)
	{
		set_Value (COLUMNNAME_eInvAuthenticationURL, eInvAuthenticationURL);
	}

	/** Get eInvoice Authentication URL.
		@return eInvoice Authentication URL	  */
	public String geteInvAuthenticationURL () 
	{
		return (String)get_Value(COLUMNNAME_eInvAuthenticationURL);
	}
    /** Column name eInvoiceBaseURL */
    public static final String COLUMNNAME_eInvoiceBaseURL = "eInvoiceBaseURL";

	/** Set eInvoice Base URL.
		@param eInvoiceBaseURL eInvoice Base URL	  */
	public void seteInvoiceBaseURL (String eInvoiceBaseURL)
	{
		set_Value (COLUMNNAME_eInvoiceBaseURL, eInvoiceBaseURL);
	}

	/** Get eInvoice Base URL.
		@return eInvoice Base URL	  */
	public String geteInvoiceBaseURL () 
	{
		return (String)get_Value(COLUMNNAME_eInvoiceBaseURL);
	}
	 /** Column name EMail */
    public static final String COLUMNNAME_EMail = "EMail";

	/** Set EMail Address.
	@param EMail 
	Electronic Mail Address
  	*/
	public void setEMail (String EMail)
	{
		set_Value (COLUMNNAME_EMail, EMail);
	}

	/** Get EMail Address.
		@return Electronic Mail Address
  	*/
	public String getEMail () 
	{
		return (String)get_Value(COLUMNNAME_EMail);
	}
    /** Column name gstin */
    public static final String COLUMNNAME_gstin = "gstin";

	/** Set gstin.
		@param gstin gstin	  */
	public void setgstin (String gstin)
	{
		set_Value (COLUMNNAME_gstin, gstin);
	}

	/** Get gstin.
		@return gstin	  */
	public String getgstin () 
	{
		return (String)get_Value(COLUMNNAME_gstin);
	}
	  /** Column name UserName */
    public static final String COLUMNNAME_UserName = "UserName";

	/** Set User Name.
		@param UserName User Name	  */
	public void setUserName (String UserName)
	{
		set_Value (COLUMNNAME_UserName, UserName);
	}

	/** Get User Name.
		@return User Name	  */
	public String getUserName () 
	{
		return (String)get_Value(COLUMNNAME_UserName);
	}
    /** Column name Password */
    public static final String COLUMNNAME_Password = "Password";
	/** Set Password.
		@param Password 
		Password of any length (case sensitive)
	 */
	public void setPassword (String Password)
	{
		set_Value (COLUMNNAME_Password, Password);
	}

	/** Get Password.
		@return Password of any length (case sensitive)
  	*/
	public String getPassword () 
	{
		return (String)get_Value(COLUMNNAME_Password);
	}
    /** Column name IP_Address */
    public static final String COLUMNNAME_IP_Address = "IP_Address";
    public void setIP_Address (String IP_Address)
	{
		set_Value (COLUMNNAME_IP_Address, IP_Address);
	}

	/** Get IP Address.
		@return Defines the IP address to transfer data to
  	*/
	public String getIP_Address () 
	{
		return (String)get_Value(COLUMNNAME_IP_Address);
	}
	 /** Column name ClientValue */
    public static final String COLUMNNAME_ClientValue = "ClientValue";
	
	/** Set Client Key.
		@param ClientValue 
		Key of the Client
	 */
	public void setClientValue (String ClientValue)
	{
		set_Value (COLUMNNAME_ClientValue, ClientValue);
	}

	/** Get Client Key.
		@return Key of the Client
  	*/
	public String getClientValue () 
	{
		return (String)get_Value(COLUMNNAME_ClientValue);
	}
    public static final String COLUMNNAME_Client = "Client";
	/** Set Client.
	@param Client Client	  */
	public void setClient (String Client)
	{
		set_Value (COLUMNNAME_Client, Client);
	}

	/** Get Client.
	@return Client	  */
	public String getClient () 
	{
		return (String)get_Value(COLUMNNAME_Client);
	} 
	/** Column name eInvoiceGenerationURL */
    public static final String COLUMNNAME_eInvoiceGenerationURL = "eInvoiceGenerationURL";

	/** Set eInvoice Generation URL.
	@param eInvoiceGenerationURL eInvoice Generation URL	  */
	public void seteInvoiceGenerationURL (String eInvoiceGenerationURL)
	{
		set_Value (COLUMNNAME_eInvoiceGenerationURL, eInvoiceGenerationURL);
	}

	/** Get eInvoice Generation URL.
		@return eInvoice Generation URL	  */
	public String geteInvoiceGenerationURL () 
	{
		return (String)get_Value(COLUMNNAME_eInvoiceGenerationURL);
	}
	/** Column name StateCode */
    public static final String COLUMNNAME_StateCode = "StateCode";

	/** Set State Code.
	@param StateCode State Code	  */
	public void setStateCode (String StateCode)
	{
		set_Value (COLUMNNAME_StateCode, StateCode);
	}

	/** Get State Code.
		@return State Code	  */
	public String getStateCode () 
	{
		return (String)get_Value(COLUMNNAME_StateCode);
	}


}
