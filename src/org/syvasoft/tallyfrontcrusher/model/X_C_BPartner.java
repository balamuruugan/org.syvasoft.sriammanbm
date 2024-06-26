/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for C_BPartner
 *  @author iDempiere (generated) 
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="C_BPartner")
public class X_C_BPartner extends PO implements I_C_BPartner, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240129L;

    /** Standard Constructor */
    public X_C_BPartner (Properties ctx, int C_BPartner_ID, String trxName)
    {
      super (ctx, C_BPartner_ID, trxName);
      /** if (C_BPartner_ID == 0)
        {
			setC_BP_Group_ID (0);
			setC_BPartner_ID (0);
			setIs1099Vendor (false);
// N
			setIsCustomer (false);
			setIsEmployee (false);
			setIsInterState (false);
// N
			setIsOneTime (false);
			setIsPOSCashBP (false);
// N
			setIsPOTaxExempt (false);
// N
			setIsProspect (false);
// N
			setIsRentBreakup (false);
// N
			setIsRentInclusive (false);
// N
			setIsRequiredTaxInvoicePerLoad (false);
// N
			setIsSalesRep (false);
			setIsSummary (false);
			setIsTaxIncluded (false);
// N
			setIsVendor (false);
			setName (null);
			setPFAmt (Env.ZERO);
// 0
			setSendEMail (false);
			setSO_CreditLimit (Env.ZERO);
			setSO_CreditUsed (Env.ZERO);
			setSOCreditStatus (null);
// X
			setValue (null);
        } */
    }

    /** Standard Constructor */
    public X_C_BPartner (Properties ctx, int C_BPartner_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, C_BPartner_ID, trxName, virtualColumns);
      /** if (C_BPartner_ID == 0)
        {
			setC_BP_Group_ID (0);
			setC_BPartner_ID (0);
			setIs1099Vendor (false);
// N
			setIsCustomer (false);
			setIsEmployee (false);
			setIsInterState (false);
// N
			setIsOneTime (false);
			setIsPOSCashBP (false);
// N
			setIsPOTaxExempt (false);
// N
			setIsProspect (false);
// N
			setIsRentBreakup (false);
// N
			setIsRentInclusive (false);
// N
			setIsRequiredTaxInvoicePerLoad (false);
// N
			setIsSalesRep (false);
			setIsSummary (false);
			setIsTaxIncluded (false);
// N
			setIsVendor (false);
			setName (null);
			setPFAmt (Env.ZERO);
// 0
			setSendEMail (false);
			setSO_CreditLimit (Env.ZERO);
			setSO_CreditUsed (Env.ZERO);
			setSOCreditStatus (null);
// X
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_C_BPartner (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_C_BPartner[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Aadhar Card No.
		@param AadharNo Aadhar Card No
	*/
	public void setAadharNo (String AadharNo)
	{
		set_Value (COLUMNNAME_AadharNo, AadharNo);
	}

	/** Get Aadhar Card No.
		@return Aadhar Card No	  */
	public String getAadharNo()
	{
		return (String)get_Value(COLUMNNAME_AadharNo);
	}

	/** Set Acquisition Cost.
		@param AcqusitionCost The cost of gaining the prospect as a customer
	*/
	public void setAcqusitionCost (BigDecimal AcqusitionCost)
	{
		set_Value (COLUMNNAME_AcqusitionCost, AcqusitionCost);
	}

	/** Get Acquisition Cost.
		@return The cost of gaining the prospect as a customer
	  */
	public BigDecimal getAcqusitionCost()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AcqusitionCost);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Actual Life Time Value.
		@param ActualLifeTimeValue Actual Life Time Revenue
	*/
	public void setActualLifeTimeValue (BigDecimal ActualLifeTimeValue)
	{
		set_Value (COLUMNNAME_ActualLifeTimeValue, ActualLifeTimeValue);
	}

	/** Get Actual Life Time Value.
		@return Actual Life Time Revenue
	  */
	public BigDecimal getActualLifeTimeValue()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ActualLifeTimeValue);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** AD_Language AD_Reference_ID=327 */
	public static final int AD_LANGUAGE_AD_Reference_ID=327;
	/** Set Language.
		@param AD_Language Language for this entity
	*/
	public void setAD_Language (String AD_Language)
	{

		set_Value (COLUMNNAME_AD_Language, AD_Language);
	}

	/** Get Language.
		@return Language for this entity
	  */
	public String getAD_Language()
	{
		return (String)get_Value(COLUMNNAME_AD_Language);
	}

	/** Set Linked Organization.
		@param AD_OrgBP_ID The Business Partner is another Organization for explicit Inter-Org transactions
	*/
	public void setAD_OrgBP_ID (int AD_OrgBP_ID)
	{
		if (AD_OrgBP_ID < 1)
			set_Value (COLUMNNAME_AD_OrgBP_ID, null);
		else
			set_Value (COLUMNNAME_AD_OrgBP_ID, Integer.valueOf(AD_OrgBP_ID));
	}

	/** Get Linked Organization.
		@return The Business Partner is another Organization for explicit Inter-Org transactions
	  */
	public int getAD_OrgBP_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_OrgBP_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getAD_User_ID(), get_TrxName());
	}

	/** Set User/Contact.
		@param AD_User_ID User within the system - Internal or Business Partner Contact
	*/
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1)
			set_Value (COLUMNNAME_AD_User_ID, null);
		else
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Address 1.
		@param Address1 Address line 1 for this location
	*/
	public void setAddress1 (String Address1)
	{
		set_Value (COLUMNNAME_Address1, Address1);
	}

	/** Get Address 1.
		@return Address line 1 for this location
	  */
	public String getAddress1()
	{
		return (String)get_Value(COLUMNNAME_Address1);
	}

	/** Set Address 2.
		@param Address2 Address line 2 for this location
	*/
	public void setAddress2 (String Address2)
	{
		set_Value (COLUMNNAME_Address2, Address2);
	}

	/** Get Address 2.
		@return Address line 2 for this location
	  */
	public String getAddress2()
	{
		return (String)get_Value(COLUMNNAME_Address2);
	}

	/** Set Address 3.
		@param Address3 Address Line 3 for the location
	*/
	public void setAddress3 (String Address3)
	{
		set_Value (COLUMNNAME_Address3, Address3);
	}

	/** Get Address 3.
		@return Address Line 3 for the location
	  */
	public String getAddress3()
	{
		return (String)get_Value(COLUMNNAME_Address3);
	}

	/** Set Address 4.
		@param Address4 Address Line 4 for the location
	*/
	public void setAddress4 (String Address4)
	{
		set_Value (COLUMNNAME_Address4, Address4);
	}

	/** Get Address 4.
		@return Address Line 4 for the location
	  */
	public String getAddress4()
	{
		return (String)get_Value(COLUMNNAME_Address4);
	}

	/** Set Apply TCS.
		@param ApplyTCS Apply TCS
	*/
	public void setApplyTCS (boolean ApplyTCS)
	{
		set_Value (COLUMNNAME_ApplyTCS, Boolean.valueOf(ApplyTCS));
	}

	/** Get Apply TCS.
		@return Apply TCS	  */
	public boolean isApplyTCS()
	{
		Object oo = get_Value(COLUMNNAME_ApplyTCS);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Bank Account No.
		@param BankAccountNo Bank Account Number
	*/
	public void setBankAccountNo (String BankAccountNo)
	{
		set_Value (COLUMNNAME_BankAccountNo, BankAccountNo);
	}

	/** Get Bank Account No.
		@return Bank Account Number
	  */
	public String getBankAccountNo()
	{
		return (String)get_Value(COLUMNNAME_BankAccountNo);
	}

	/** Set Bank Name.
		@param BankName Bank Name
	*/
	public void setBankName (String BankName)
	{
		set_Value (COLUMNNAME_BankName, BankName);
	}

	/** Get Bank Name.
		@return Bank Name	  */
	public String getBankName()
	{
		return (String)get_Value(COLUMNNAME_BankName);
	}

	/** Set Basic Salary.
		@param BasicSalary Basic Salary
	*/
	public void setBasicSalary (BigDecimal BasicSalary)
	{
		set_Value (COLUMNNAME_BasicSalary, BasicSalary);
	}

	/** Get Basic Salary.
		@return Basic Salary	  */
	public BigDecimal getBasicSalary()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BasicSalary);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Bill Price GST.
		@param BillPriceGST Bill Price GST
	*/
	public void setBillPriceGST (boolean BillPriceGST)
	{
		set_Value (COLUMNNAME_BillPriceGST, Boolean.valueOf(BillPriceGST));
	}

	/** Get Bill Price GST.
		@return Bill Price GST	  */
	public boolean isBillPriceGST()
	{
		Object oo = get_Value(COLUMNNAME_BillPriceGST);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Partner Parent.
		@param BPartner_Parent_ID Business Partner Parent
	*/
	public void setBPartner_Parent_ID (int BPartner_Parent_ID)
	{
		if (BPartner_Parent_ID < 1)
			set_Value (COLUMNNAME_BPartner_Parent_ID, null);
		else
			set_Value (COLUMNNAME_BPartner_Parent_ID, Integer.valueOf(BPartner_Parent_ID));
	}

	/** Get Partner Parent.
		@return Business Partner Parent
	  */
	public int getBPartner_Parent_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BPartner_Parent_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Branch Code.
		@param BranchCode Branch Code
	*/
	public void setBranchCode (String BranchCode)
	{
		set_Value (COLUMNNAME_BranchCode, BranchCode);
	}

	/** Get Branch Code.
		@return Branch Code	  */
	public String getBranchCode()
	{
		return (String)get_Value(COLUMNNAME_BranchCode);
	}

	public org.compiere.model.I_C_BP_Group getC_BP_Group() throws RuntimeException
	{
		return (org.compiere.model.I_C_BP_Group)MTable.get(getCtx(), org.compiere.model.I_C_BP_Group.Table_ID)
			.getPO(getC_BP_Group_ID(), get_TrxName());
	}

	/** Set Business Partner Group.
		@param C_BP_Group_ID Business Partner Group
	*/
	public void setC_BP_Group_ID (int C_BP_Group_ID)
	{
		if (C_BP_Group_ID < 1)
			set_Value (COLUMNNAME_C_BP_Group_ID, null);
		else
			set_Value (COLUMNNAME_C_BP_Group_ID, Integer.valueOf(C_BP_Group_ID));
	}

	/** Get Business Partner Group.
		@return Business Partner Group
	  */
	public int getC_BP_Group_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BP_Group_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set C_BPartner_UU.
		@param C_BPartner_UU C_BPartner_UU
	*/
	public void setC_BPartner_UU (String C_BPartner_UU)
	{
		set_Value (COLUMNNAME_C_BPartner_UU, C_BPartner_UU);
	}

	/** Get C_BPartner_UU.
		@return C_BPartner_UU	  */
	public String getC_BPartner_UU()
	{
		return (String)get_Value(COLUMNNAME_C_BPartner_UU);
	}

	public org.compiere.model.I_C_Country getC_Country() throws RuntimeException
	{
		return (org.compiere.model.I_C_Country)MTable.get(getCtx(), org.compiere.model.I_C_Country.Table_ID)
			.getPO(getC_Country_ID(), get_TrxName());
	}

	/** Set Country.
		@param C_Country_ID Country 
	*/
	public void setC_Country_ID (int C_Country_ID)
	{
		if (C_Country_ID < 1)
			set_Value (COLUMNNAME_C_Country_ID, null);
		else
			set_Value (COLUMNNAME_C_Country_ID, Integer.valueOf(C_Country_ID));
	}

	/** Get Country.
		@return Country 
	  */
	public int getC_Country_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Country_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Dunning getC_Dunning() throws RuntimeException
	{
		return (org.compiere.model.I_C_Dunning)MTable.get(getCtx(), org.compiere.model.I_C_Dunning.Table_ID)
			.getPO(getC_Dunning_ID(), get_TrxName());
	}

	/** Set Dunning.
		@param C_Dunning_ID Dunning Rules for overdue invoices
	*/
	public void setC_Dunning_ID (int C_Dunning_ID)
	{
		if (C_Dunning_ID < 1)
			set_Value (COLUMNNAME_C_Dunning_ID, null);
		else
			set_Value (COLUMNNAME_C_Dunning_ID, Integer.valueOf(C_Dunning_ID));
	}

	/** Get Dunning.
		@return Dunning Rules for overdue invoices
	  */
	public int getC_Dunning_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Dunning_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Greeting getC_Greeting() throws RuntimeException
	{
		return (org.compiere.model.I_C_Greeting)MTable.get(getCtx(), org.compiere.model.I_C_Greeting.Table_ID)
			.getPO(getC_Greeting_ID(), get_TrxName());
	}

	/** Set Greeting.
		@param C_Greeting_ID Greeting to print on correspondence
	*/
	public void setC_Greeting_ID (int C_Greeting_ID)
	{
		if (C_Greeting_ID < 1)
			set_Value (COLUMNNAME_C_Greeting_ID, null);
		else
			set_Value (COLUMNNAME_C_Greeting_ID, Integer.valueOf(C_Greeting_ID));
	}

	/** Get Greeting.
		@return Greeting to print on correspondence
	  */
	public int getC_Greeting_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Greeting_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
	{
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_ID)
			.getPO(getC_Invoice_ID(), get_TrxName());
	}

	/** Set Invoice.
		@param C_Invoice_ID Invoice Identifier
	*/
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_InvoiceSchedule getC_InvoiceSchedule() throws RuntimeException
	{
		return (org.compiere.model.I_C_InvoiceSchedule)MTable.get(getCtx(), org.compiere.model.I_C_InvoiceSchedule.Table_ID)
			.getPO(getC_InvoiceSchedule_ID(), get_TrxName());
	}

	/** Set Invoice Schedule.
		@param C_InvoiceSchedule_ID Schedule for generating Invoices
	*/
	public void setC_InvoiceSchedule_ID (int C_InvoiceSchedule_ID)
	{
		if (C_InvoiceSchedule_ID < 1)
			set_Value (COLUMNNAME_C_InvoiceSchedule_ID, null);
		else
			set_Value (COLUMNNAME_C_InvoiceSchedule_ID, Integer.valueOf(C_InvoiceSchedule_ID));
	}

	/** Get Invoice Schedule.
		@return Schedule for generating Invoices
	  */
	public int getC_InvoiceSchedule_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_InvoiceSchedule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_Location getC_Location() throws RuntimeException
	{
		return (I_C_Location)MTable.get(getCtx(), I_C_Location.Table_ID)
			.getPO(getC_Location_ID(), get_TrxName());
	}

	/** Set Address.
		@param C_Location_ID Location or Address
	*/
	public void setC_Location_ID (int C_Location_ID)
	{
		if (C_Location_ID < 1)
			set_Value (COLUMNNAME_C_Location_ID, null);
		else
			set_Value (COLUMNNAME_C_Location_ID, Integer.valueOf(C_Location_ID));
	}

	/** Get Address.
		@return Location or Address
	  */
	public int getC_Location_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_PaymentTerm getC_PaymentTerm() throws RuntimeException
	{
		return (org.compiere.model.I_C_PaymentTerm)MTable.get(getCtx(), org.compiere.model.I_C_PaymentTerm.Table_ID)
			.getPO(getC_PaymentTerm_ID(), get_TrxName());
	}

	/** Set Payment Term.
		@param C_PaymentTerm_ID The terms of Payment (timing, discount)
	*/
	public void setC_PaymentTerm_ID (int C_PaymentTerm_ID)
	{
		if (C_PaymentTerm_ID < 1)
			set_Value (COLUMNNAME_C_PaymentTerm_ID, null);
		else
			set_Value (COLUMNNAME_C_PaymentTerm_ID, Integer.valueOf(C_PaymentTerm_ID));
	}

	/** Get Payment Term.
		@return The terms of Payment (timing, discount)
	  */
	public int getC_PaymentTerm_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PaymentTerm_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Period getC_Period() throws RuntimeException
	{
		return (org.compiere.model.I_C_Period)MTable.get(getCtx(), org.compiere.model.I_C_Period.Table_ID)
			.getPO(getC_Period_ID(), get_TrxName());
	}

	/** Set Period.
		@param C_Period_ID Period of the Calendar
	*/
	public void setC_Period_ID (int C_Period_ID)
	{
		if (C_Period_ID < 1)
			set_Value (COLUMNNAME_C_Period_ID, null);
		else
			set_Value (COLUMNNAME_C_Period_ID, Integer.valueOf(C_Period_ID));
	}

	/** Get Period.
		@return Period of the Calendar
	  */
	public int getC_Period_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Period_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eevolution.model.I_C_TaxGroup getC_TaxGroup() throws RuntimeException
	{
		return (org.eevolution.model.I_C_TaxGroup)MTable.get(getCtx(), org.eevolution.model.I_C_TaxGroup.Table_ID)
			.getPO(getC_TaxGroup_ID(), get_TrxName());
	}

	/** Set Tax Group.
		@param C_TaxGroup_ID Tax Group
	*/
	public void setC_TaxGroup_ID (int C_TaxGroup_ID)
	{
		if (C_TaxGroup_ID < 1)
			set_Value (COLUMNNAME_C_TaxGroup_ID, null);
		else
			set_Value (COLUMNNAME_C_TaxGroup_ID, Integer.valueOf(C_TaxGroup_ID));
	}

	/** Get Tax Group.
		@return Tax Group	  */
	public int getC_TaxGroup_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_TaxGroup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Care Of.
		@param CareOf Care Of
	*/
	public void setCareOf (String CareOf)
	{
		set_Value (COLUMNNAME_CareOf, CareOf);
	}

	/** Get Care Of.
		@return Care Of	  */
	public String getCareOf()
	{
		return (String)get_Value(COLUMNNAME_CareOf);
	}

	/** Set City.
		@param City Identifies a City
	*/
	public void setCity (String City)
	{
		set_Value (COLUMNNAME_City, City);
	}

	/** Get City.
		@return Identifies a City
	  */
	public String getCity()
	{
		return (String)get_Value(COLUMNNAME_City);
	}

	/** Set Contact Name.
		@param ContactName Business Partner Contact Name
	*/
	public void setContactName (String ContactName)
	{
		set_Value (COLUMNNAME_ContactName, ContactName);
	}

	/** Get Contact Name.
		@return Business Partner Contact Name
	  */
	public String getContactName()
	{
		return (String)get_Value(COLUMNNAME_ContactName);
	}

	/** Set Credit Balance.
		@param CreditBalance Credit Balance
	*/
	public void setCreditBalance (BigDecimal CreditBalance)
	{
		set_Value (COLUMNNAME_CreditBalance, CreditBalance);
	}

	/** Get Credit Balance.
		@return Credit Balance	  */
	public BigDecimal getCreditBalance()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CreditBalance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Customer Profile ID.
		@param CustomerProfileID Customer Profile ID
	*/
	public void setCustomerProfileID (String CustomerProfileID)
	{
		set_Value (COLUMNNAME_CustomerProfileID, CustomerProfileID);
	}

	/** Get Customer Profile ID.
		@return Customer Profile ID	  */
	public String getCustomerProfileID()
	{
		return (String)get_Value(COLUMNNAME_CustomerProfileID);
	}

	/** Set Date Of Join.
		@param DateOfJoin Date Of Join
	*/
	public void setDateOfJoin (Timestamp DateOfJoin)
	{
		set_Value (COLUMNNAME_DateOfJoin, DateOfJoin);
	}

	/** Get Date Of Join.
		@return Date Of Join	  */
	public Timestamp getDateOfJoin()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateOfJoin);
	}

	/** Set Debit Balance.
		@param DebitBalance Debit Balance
	*/
	public void setDebitBalance (BigDecimal DebitBalance)
	{
		set_Value (COLUMNNAME_DebitBalance, DebitBalance);
	}

	/** Get Debit Balance.
		@return Debit Balance	  */
	public BigDecimal getDebitBalance()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DebitBalance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_1099Box getDefault1099Box() throws RuntimeException
	{
		return (org.compiere.model.I_C_1099Box)MTable.get(getCtx(), org.compiere.model.I_C_1099Box.Table_ID)
			.getPO(getDefault1099Box_ID(), get_TrxName());
	}

	/** Set Default 1099 Box.
		@param Default1099Box_ID Default 1099 Box
	*/
	public void setDefault1099Box_ID (int Default1099Box_ID)
	{
		if (Default1099Box_ID < 1)
			set_Value (COLUMNNAME_Default1099Box_ID, null);
		else
			set_Value (COLUMNNAME_Default1099Box_ID, Integer.valueOf(Default1099Box_ID));
	}

	/** Get Default 1099 Box.
		@return Default 1099 Box	  */
	public int getDefault1099Box_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Default1099Box_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** DeliveryRule AD_Reference_ID=151 */
	public static final int DELIVERYRULE_AD_Reference_ID=151;
	/** Availability = A */
	public static final String DELIVERYRULE_Availability = "A";
	/** Custom = C */
	public static final String DELIVERYRULE_Custom = "C";
	/** Force = F */
	public static final String DELIVERYRULE_Force = "F";
	/** Complete Line = L */
	public static final String DELIVERYRULE_CompleteLine = "L";
	/** Manual = M */
	public static final String DELIVERYRULE_Manual = "M";
	/** Complete Order = O */
	public static final String DELIVERYRULE_CompleteOrder = "O";
	/** After Payment = R */
	public static final String DELIVERYRULE_AfterPayment = "R";
	/** Set Delivery Rule.
		@param DeliveryRule Defines the timing of Delivery
	*/
	public void setDeliveryRule (String DeliveryRule)
	{

		set_Value (COLUMNNAME_DeliveryRule, DeliveryRule);
	}

	/** Get Delivery Rule.
		@return Defines the timing of Delivery
	  */
	public String getDeliveryRule()
	{
		return (String)get_Value(COLUMNNAME_DeliveryRule);
	}

	/** DeliveryViaRule AD_Reference_ID=152 */
	public static final int DELIVERYVIARULE_AD_Reference_ID=152;
	/** Delivery = D */
	public static final String DELIVERYVIARULE_Delivery = "D";
	/** Pickup = P */
	public static final String DELIVERYVIARULE_Pickup = "P";
	/** Shipper = S */
	public static final String DELIVERYVIARULE_Shipper = "S";
	/** Set Delivery Via.
		@param DeliveryViaRule How the order will be delivered
	*/
	public void setDeliveryViaRule (String DeliveryViaRule)
	{

		set_Value (COLUMNNAME_DeliveryViaRule, DeliveryViaRule);
	}

	/** Get Delivery Via.
		@return How the order will be delivered
	  */
	public String getDeliveryViaRule()
	{
		return (String)get_Value(COLUMNNAME_DeliveryViaRule);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Designation.
		@param Designation Designation
	*/
	public void setDesignation (String Designation)
	{
		set_Value (COLUMNNAME_Designation, Designation);
	}

	/** Get Designation.
		@return Designation	  */
	public String getDesignation()
	{
		return (String)get_Value(COLUMNNAME_Designation);
	}

	/** Set Document Copies.
		@param DocumentCopies Number of copies to be printed
	*/
	public void setDocumentCopies (int DocumentCopies)
	{
		set_Value (COLUMNNAME_DocumentCopies, Integer.valueOf(DocumentCopies));
	}

	/** Get Document Copies.
		@return Number of copies to be printed
	  */
	public int getDocumentCopies()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DocumentCopies);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Dunning Grace Date.
		@param DunningGrace Dunning Grace Date
	*/
	public void setDunningGrace (Timestamp DunningGrace)
	{
		set_Value (COLUMNNAME_DunningGrace, DunningGrace);
	}

	/** Get Dunning Grace Date.
		@return Dunning Grace Date	  */
	public Timestamp getDunningGrace()
	{
		return (Timestamp)get_Value(COLUMNNAME_DunningGrace);
	}

	/** Set D-U-N-S.
		@param DUNS Dun &amp; Bradstreet Number
	*/
	public void setDUNS (String DUNS)
	{
		set_Value (COLUMNNAME_DUNS, DUNS);
	}

	/** Get D-U-N-S.
		@return Dun &amp; Bradstreet Number
	  */
	public String getDUNS()
	{
		return (String)get_Value(COLUMNNAME_DUNS);
	}

	/** Set EMail Address.
		@param EMail Electronic Mail Address
	*/
	public void setEMail (String EMail)
	{
		set_Value (COLUMNNAME_EMail, EMail);
	}

	/** Get EMail Address.
		@return Electronic Mail Address
	  */
	public String getEMail()
	{
		return (String)get_Value(COLUMNNAME_EMail);
	}

	/** Set Enroll No.
		@param EnrollNo Enroll No
	*/
	public void setEnrollNo (int EnrollNo)
	{
		set_Value (COLUMNNAME_EnrollNo, Integer.valueOf(EnrollNo));
	}

	/** Get Enroll No.
		@return Enroll No	  */
	public int getEnrollNo()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_EnrollNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Export Customer.
		@param ExportCustomer Export Customer
	*/
	public void setExportCustomer (boolean ExportCustomer)
	{
		set_Value (COLUMNNAME_ExportCustomer, Boolean.valueOf(ExportCustomer));
	}

	/** Get Export Customer.
		@return Export Customer	  */
	public boolean isExportCustomer()
	{
		Object oo = get_Value(COLUMNNAME_ExportCustomer);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set First Sale.
		@param FirstSale Date of First Sale
	*/
	public void setFirstSale (Timestamp FirstSale)
	{
		set_Value (COLUMNNAME_FirstSale, FirstSale);
	}

	/** Get First Sale.
		@return Date of First Sale
	  */
	public Timestamp getFirstSale()
	{
		return (Timestamp)get_Value(COLUMNNAME_FirstSale);
	}

	/** Set Flat Discount %.
		@param FlatDiscount Flat discount percentage 
	*/
	public void setFlatDiscount (BigDecimal FlatDiscount)
	{
		set_Value (COLUMNNAME_FlatDiscount, FlatDiscount);
	}

	/** Get Flat Discount %.
		@return Flat discount percentage 
	  */
	public BigDecimal getFlatDiscount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FlatDiscount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** FreightCostRule AD_Reference_ID=153 */
	public static final int FREIGHTCOSTRULE_AD_Reference_ID=153;
	/** Calculated = C */
	public static final String FREIGHTCOSTRULE_Calculated = "C";
	/** Fix price = F */
	public static final String FREIGHTCOSTRULE_FixPrice = "F";
	/** Freight included = I */
	public static final String FREIGHTCOSTRULE_FreightIncluded = "I";
	/** Line = L */
	public static final String FREIGHTCOSTRULE_Line = "L";
	/** Customer Account = U */
	public static final String FREIGHTCOSTRULE_CustomerAccount = "U";
	/** Set Freight Cost Rule.
		@param FreightCostRule Method for charging Freight
	*/
	public void setFreightCostRule (String FreightCostRule)
	{

		set_Value (COLUMNNAME_FreightCostRule, FreightCostRule);
	}

	/** Get Freight Cost Rule.
		@return Method for charging Freight
	  */
	public String getFreightCostRule()
	{
		return (String)get_Value(COLUMNNAME_FreightCostRule);
	}

	/** Set Increment Amount.
		@param IncrementAmt Increment Amount
	*/
	public void setIncrementAmt (BigDecimal IncrementAmt)
	{
		set_Value (COLUMNNAME_IncrementAmt, IncrementAmt);
	}

	/** Get Increment Amount.
		@return Increment Amount	  */
	public BigDecimal getIncrementAmt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_IncrementAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_AD_PrintFormat getInvoice_PrintFormat() throws RuntimeException
	{
		return (org.compiere.model.I_AD_PrintFormat)MTable.get(getCtx(), org.compiere.model.I_AD_PrintFormat.Table_ID)
			.getPO(getInvoice_PrintFormat_ID(), get_TrxName());
	}

	/** Set Invoice Print Format.
		@param Invoice_PrintFormat_ID Print Format for printing Invoices
	*/
	public void setInvoice_PrintFormat_ID (int Invoice_PrintFormat_ID)
	{
		if (Invoice_PrintFormat_ID < 1)
			set_Value (COLUMNNAME_Invoice_PrintFormat_ID, null);
		else
			set_Value (COLUMNNAME_Invoice_PrintFormat_ID, Integer.valueOf(Invoice_PrintFormat_ID));
	}

	/** Get Invoice Print Format.
		@return Print Format for printing Invoices
	  */
	public int getInvoice_PrintFormat_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Invoice_PrintFormat_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** InvoiceRule AD_Reference_ID=150 */
	public static final int INVOICERULE_AD_Reference_ID=150;
	/** After Delivery = D */
	public static final String INVOICERULE_AfterDelivery = "D";
	/** Immediate = I */
	public static final String INVOICERULE_Immediate = "I";
	/** After Order delivered = O */
	public static final String INVOICERULE_AfterOrderDelivered = "O";
	/** Customer Schedule after Delivery = S */
	public static final String INVOICERULE_CustomerScheduleAfterDelivery = "S";
	/** Set Invoice Rule.
		@param InvoiceRule Frequency and method of invoicing 
	*/
	public void setInvoiceRule (String InvoiceRule)
	{

		set_Value (COLUMNNAME_InvoiceRule, InvoiceRule);
	}

	/** Get Invoice Rule.
		@return Frequency and method of invoicing 
	  */
	public String getInvoiceRule()
	{
		return (String)get_Value(COLUMNNAME_InvoiceRule);
	}

	/** Set 1099 Vendor.
		@param Is1099Vendor 1099 Vendor
	*/
	public void setIs1099Vendor (boolean Is1099Vendor)
	{
		set_Value (COLUMNNAME_Is1099Vendor, Boolean.valueOf(Is1099Vendor));
	}

	/** Get 1099 Vendor.
		@return 1099 Vendor	  */
	public boolean is1099Vendor()
	{
		Object oo = get_Value(COLUMNNAME_Is1099Vendor);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Customer.
		@param IsCustomer Indicates if this Business Partner is a Customer
	*/
	public void setIsCustomer (boolean IsCustomer)
	{
		set_Value (COLUMNNAME_IsCustomer, Boolean.valueOf(IsCustomer));
	}

	/** Get Customer.
		@return Indicates if this Business Partner is a Customer
	  */
	public boolean isCustomer()
	{
		Object oo = get_Value(COLUMNNAME_IsCustomer);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Discount Printed.
		@param IsDiscountPrinted Print Discount on Invoice and Order
	*/
	public void setIsDiscountPrinted (boolean IsDiscountPrinted)
	{
		set_Value (COLUMNNAME_IsDiscountPrinted, Boolean.valueOf(IsDiscountPrinted));
	}

	/** Get Discount Printed.
		@return Print Discount on Invoice and Order
	  */
	public boolean isDiscountPrinted()
	{
		Object oo = get_Value(COLUMNNAME_IsDiscountPrinted);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Employee.
		@param IsEmployee Indicates if  this Business Partner is an employee
	*/
	public void setIsEmployee (boolean IsEmployee)
	{
		set_Value (COLUMNNAME_IsEmployee, Boolean.valueOf(IsEmployee));
	}

	/** Get Employee.
		@return Indicates if  this Business Partner is an employee
	  */
	public boolean isEmployee()
	{
		Object oo = get_Value(COLUMNNAME_IsEmployee);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Enrolled.
		@param IsEnrolled Is Enrolled
	*/
	public void setIsEnrolled (boolean IsEnrolled)
	{
		set_Value (COLUMNNAME_IsEnrolled, Boolean.valueOf(IsEnrolled));
	}

	/** Get Is Enrolled.
		@return Is Enrolled	  */
	public boolean isEnrolled()
	{
		Object oo = get_Value(COLUMNNAME_IsEnrolled);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Inter State.
		@param IsInterState Inter State
	*/
	public void setIsInterState (boolean IsInterState)
	{
		set_Value (COLUMNNAME_IsInterState, Boolean.valueOf(IsInterState));
	}

	/** Get Inter State.
		@return Inter State	  */
	public boolean isInterState()
	{
		Object oo = get_Value(COLUMNNAME_IsInterState);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Manufacturer.
		@param IsManufacturer Indicate role of this Business partner as Manufacturer
	*/
	public void setIsManufacturer (boolean IsManufacturer)
	{
		set_Value (COLUMNNAME_IsManufacturer, Boolean.valueOf(IsManufacturer));
	}

	/** Get Is Manufacturer.
		@return Indicate role of this Business partner as Manufacturer
	  */
	public boolean isManufacturer()
	{
		Object oo = get_Value(COLUMNNAME_IsManufacturer);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set One time transaction.
		@param IsOneTime One time transaction
	*/
	public void setIsOneTime (boolean IsOneTime)
	{
		set_Value (COLUMNNAME_IsOneTime, Boolean.valueOf(IsOneTime));
	}

	/** Get One time transaction.
		@return One time transaction	  */
	public boolean isOneTime()
	{
		Object oo = get_Value(COLUMNNAME_IsOneTime);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Permit Sales.
		@param IsPermitSales Permit Sales
	*/
	public void setIsPermitSales (boolean IsPermitSales)
	{
		set_Value (COLUMNNAME_IsPermitSales, Boolean.valueOf(IsPermitSales));
	}

	/** Get Permit Sales.
		@return Permit Sales	  */
	public boolean isPermitSales()
	{
		Object oo = get_Value(COLUMNNAME_IsPermitSales);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set POS Cash BP.
		@param IsPOSCashBP POS Cash BP
	*/
	public void setIsPOSCashBP (boolean IsPOSCashBP)
	{
		set_Value (COLUMNNAME_IsPOSCashBP, Boolean.valueOf(IsPOSCashBP));
	}

	/** Get POS Cash BP.
		@return POS Cash BP	  */
	public boolean isPOSCashBP()
	{
		Object oo = get_Value(COLUMNNAME_IsPOSCashBP);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set PO Tax exempt.
		@param IsPOTaxExempt Business partner is exempt from tax on purchases
	*/
	public void setIsPOTaxExempt (boolean IsPOTaxExempt)
	{
		set_Value (COLUMNNAME_IsPOTaxExempt, Boolean.valueOf(IsPOTaxExempt));
	}

	/** Get PO Tax exempt.
		@return Business partner is exempt from tax on purchases
	  */
	public boolean isPOTaxExempt()
	{
		Object oo = get_Value(COLUMNNAME_IsPOTaxExempt);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Price Confidential.
		@param IsPriceConfidential Price Confidential
	*/
	public void setIsPriceConfidential (boolean IsPriceConfidential)
	{
		set_Value (COLUMNNAME_IsPriceConfidential, Boolean.valueOf(IsPriceConfidential));
	}

	/** Get Price Confidential.
		@return Price Confidential	  */
	public boolean isPriceConfidential()
	{
		Object oo = get_Value(COLUMNNAME_IsPriceConfidential);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Prospect.
		@param IsProspect Indicates this is a Prospect
	*/
	public void setIsProspect (boolean IsProspect)
	{
		set_Value (COLUMNNAME_IsProspect, Boolean.valueOf(IsProspect));
	}

	/** Get Prospect.
		@return Indicates this is a Prospect
	  */
	public boolean isProspect()
	{
		Object oo = get_Value(COLUMNNAME_IsProspect);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Show Rent Breakup.
		@param IsRentBreakup Show Rent Breakup
	*/
	public void setIsRentBreakup (boolean IsRentBreakup)
	{
		set_Value (COLUMNNAME_IsRentBreakup, Boolean.valueOf(IsRentBreakup));
	}

	/** Get Show Rent Breakup.
		@return Show Rent Breakup	  */
	public boolean isRentBreakup()
	{
		Object oo = get_Value(COLUMNNAME_IsRentBreakup);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Freight Inclusive.
		@param IsRentInclusive Whether Unit Price includes rent?
	*/
	public void setIsRentInclusive (boolean IsRentInclusive)
	{
		set_Value (COLUMNNAME_IsRentInclusive, Boolean.valueOf(IsRentInclusive));
	}

	/** Get Freight Inclusive.
		@return Whether Unit Price includes rent?
	  */
	public boolean isRentInclusive()
	{
		Object oo = get_Value(COLUMNNAME_IsRentInclusive);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Required Taxinvoice per load.
		@param IsRequiredTaxInvoicePerLoad Required Taxinvoice per load
	*/
	public void setIsRequiredTaxInvoicePerLoad (boolean IsRequiredTaxInvoicePerLoad)
	{
		set_Value (COLUMNNAME_IsRequiredTaxInvoicePerLoad, Boolean.valueOf(IsRequiredTaxInvoicePerLoad));
	}

	/** Get Required Taxinvoice per load.
		@return Required Taxinvoice per load	  */
	public boolean isRequiredTaxInvoicePerLoad()
	{
		Object oo = get_Value(COLUMNNAME_IsRequiredTaxInvoicePerLoad);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Sales Representative.
		@param IsSalesRep Indicates if  the business partner is a sales representative or company agent
	*/
	public void setIsSalesRep (boolean IsSalesRep)
	{
		set_Value (COLUMNNAME_IsSalesRep, Boolean.valueOf(IsSalesRep));
	}

	/** Get Sales Representative.
		@return Indicates if  the business partner is a sales representative or company agent
	  */
	public boolean isSalesRep()
	{
		Object oo = get_Value(COLUMNNAME_IsSalesRep);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Subcontractor.
		@param IsSubcontractor Indicates if  this Business Partner is Subcontractor
	*/
	public void setIsSubcontractor (boolean IsSubcontractor)
	{
		set_Value (COLUMNNAME_IsSubcontractor, Boolean.valueOf(IsSubcontractor));
	}

	/** Get Subcontractor.
		@return Indicates if  this Business Partner is Subcontractor
	  */
	public boolean isSubcontractor()
	{
		Object oo = get_Value(COLUMNNAME_IsSubcontractor);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Summary Level.
		@param IsSummary This is a summary entity
	*/
	public void setIsSummary (boolean IsSummary)
	{
		set_Value (COLUMNNAME_IsSummary, Boolean.valueOf(IsSummary));
	}

	/** Get Summary Level.
		@return This is a summary entity
	  */
	public boolean isSummary()
	{
		Object oo = get_Value(COLUMNNAME_IsSummary);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set SO Tax exempt.
		@param IsTaxExempt Business partner is exempt from tax on sales
	*/
	public void setIsTaxExempt (boolean IsTaxExempt)
	{
		set_Value (COLUMNNAME_IsTaxExempt, Boolean.valueOf(IsTaxExempt));
	}

	/** Get SO Tax exempt.
		@return Business partner is exempt from tax on sales
	  */
	public boolean isTaxExempt()
	{
		Object oo = get_Value(COLUMNNAME_IsTaxExempt);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Price includes Tax.
		@param IsTaxIncluded Tax is included in the price 
	*/
	public void setIsTaxIncluded (boolean IsTaxIncluded)
	{
		set_Value (COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
	}

	/** Get Price includes Tax.
		@return Tax is included in the price 
	  */
	public boolean isTaxIncluded()
	{
		Object oo = get_Value(COLUMNNAME_IsTaxIncluded);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Vendor.
		@param IsVendor Indicates if this Business Partner is a Vendor
	*/
	public void setIsVendor (boolean IsVendor)
	{
		set_Value (COLUMNNAME_IsVendor, Boolean.valueOf(IsVendor));
	}

	/** Get Vendor.
		@return Indicates if this Business Partner is a Vendor
	  */
	public boolean isVendor()
	{
		Object oo = get_Value(COLUMNNAME_IsVendor);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Kuthavakkam = K */
	public static final String LOCATION_Kuthavakkam = "K";
	/** Office = O */
	public static final String LOCATION_Office = "O";
	/** Plant = P */
	public static final String LOCATION_Plant = "P";
	/** Set Location.
		@param Location Location
	*/
	public void setLocation (String Location)
	{

		set_Value (COLUMNNAME_Location, Location);
	}

	/** Get Location.
		@return Location	  */
	public String getLocation()
	{
		return (String)get_Value(COLUMNNAME_Location);
	}

	/** Set Logo.
		@param Logo_ID Logo
	*/
	public void setLogo_ID (int Logo_ID)
	{
		if (Logo_ID < 1)
			set_Value (COLUMNNAME_Logo_ID, null);
		else
			set_Value (COLUMNNAME_Logo_ID, Integer.valueOf(Logo_ID));
	}

	/** Get Logo.
		@return Logo	  */
	public int getLogo_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Logo_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_DiscountSchema getM_DiscountSchema() throws RuntimeException
	{
		return (org.compiere.model.I_M_DiscountSchema)MTable.get(getCtx(), org.compiere.model.I_M_DiscountSchema.Table_ID)
			.getPO(getM_DiscountSchema_ID(), get_TrxName());
	}

	/** Set Discount Schema.
		@param M_DiscountSchema_ID Schema to calculate the trade discount percentage
	*/
	public void setM_DiscountSchema_ID (int M_DiscountSchema_ID)
	{
		if (M_DiscountSchema_ID < 1)
			set_Value (COLUMNNAME_M_DiscountSchema_ID, null);
		else
			set_Value (COLUMNNAME_M_DiscountSchema_ID, Integer.valueOf(M_DiscountSchema_ID));
	}

	/** Get Discount Schema.
		@return Schema to calculate the trade discount percentage
	  */
	public int getM_DiscountSchema_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_DiscountSchema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_PriceList getM_PriceList() throws RuntimeException
	{
		return (org.compiere.model.I_M_PriceList)MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_ID)
			.getPO(getM_PriceList_ID(), get_TrxName());
	}

	/** Set Price List.
		@param M_PriceList_ID Unique identifier of a Price List
	*/
	public void setM_PriceList_ID (int M_PriceList_ID)
	{
		if (M_PriceList_ID < 1)
			set_Value (COLUMNNAME_M_PriceList_ID, null);
		else
			set_Value (COLUMNNAME_M_PriceList_ID, Integer.valueOf(M_PriceList_ID));
	}

	/** Get Price List.
		@return Unique identifier of a Price List
	  */
	public int getM_PriceList_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_PriceList_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set NAICS/SIC.
		@param NAICS Standard Industry Code or its successor NAIC - http://www.osha.gov/oshstats/sicser.html
	*/
	public void setNAICS (String NAICS)
	{
		set_Value (COLUMNNAME_NAICS, NAICS);
	}

	/** Get NAICS/SIC.
		@return Standard Industry Code or its successor NAIC - http://www.osha.gov/oshstats/sicser.html
	  */
	public String getNAICS()
	{
		return (String)get_Value(COLUMNNAME_NAICS);
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Name 2.
		@param Name2 Additional Name
	*/
	public void setName2 (String Name2)
	{
		set_Value (COLUMNNAME_Name2, Name2);
	}

	/** Get Name 2.
		@return Additional Name
	  */
	public String getName2()
	{
		return (String)get_Value(COLUMNNAME_Name2);
	}

	/** Set Name + Outstanding Balance.
		@param NameOutstanding Name + Outstanding Balance
	*/
	public void setNameOutstanding (String NameOutstanding)
	{
		throw new IllegalArgumentException ("NameOutstanding is virtual column");	}

	/** Get Name + Outstanding Balance.
		@return Name + Outstanding Balance	  */
	public String getNameOutstanding()
	{
		return (String)get_Value(COLUMNNAME_NameOutstanding);
	}

	/** Set Employees.
		@param NumberEmployees Number of employees
	*/
	public void setNumberEmployees (int NumberEmployees)
	{
		set_Value (COLUMNNAME_NumberEmployees, Integer.valueOf(NumberEmployees));
	}

	/** Get Employees.
		@return Number of employees
	  */
	public int getNumberEmployees()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_NumberEmployees);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Opening Date.
		@param OpeningDate Opening Date
	*/
	public void setOpeningDate (Timestamp OpeningDate)
	{
		set_Value (COLUMNNAME_OpeningDate, OpeningDate);
	}

	/** Get Opening Date.
		@return Opening Date	  */
	public Timestamp getOpeningDate()
	{
		return (Timestamp)get_Value(COLUMNNAME_OpeningDate);
	}

	/** Set PanNo.
		@param PanNo PanNo
	*/
	public void setPanNo (String PanNo)
	{
		set_Value (COLUMNNAME_PanNo, PanNo);
	}

	/** Get PanNo.
		@return PanNo	  */
	public String getPanNo()
	{
		return (String)get_Value(COLUMNNAME_PanNo);
	}

	/** PaymentRule AD_Reference_ID=195 */
	public static final int PAYMENTRULE_AD_Reference_ID=195;
	/** Cash = B */
	public static final String PAYMENTRULE_Cash = "B";
	/** Direct Debit = D */
	public static final String PAYMENTRULE_DirectDebit = "D";
	/** Credit Card = K */
	public static final String PAYMENTRULE_CreditCard = "K";
	/** Mixed POS Payment = M */
	public static final String PAYMENTRULE_MixedPOSPayment = "M";
	/** Mixed Payment = O */
	public static final String PAYMENTRULE_MixedPayment = "O";
	/** Credit = P */
	public static final String PAYMENTRULE_Credit = "P";
	/** Check = S */
	public static final String PAYMENTRULE_Check = "S";
	/** Direct Deposit = T */
	public static final String PAYMENTRULE_DirectDeposit = "T";
	/** Prepaid Cash = Z */
	public static final String PAYMENTRULE_PrepaidCash = "Z";
	/** Set Payment Rule.
		@param PaymentRule How you pay the invoice
	*/
	public void setPaymentRule (String PaymentRule)
	{

		set_Value (COLUMNNAME_PaymentRule, PaymentRule);
	}

	/** Get Payment Rule.
		@return How you pay the invoice
	  */
	public String getPaymentRule()
	{
		return (String)get_Value(COLUMNNAME_PaymentRule);
	}

	/** PaymentRulePO AD_Reference_ID=195 */
	public static final int PAYMENTRULEPO_AD_Reference_ID=195;
	/** Cash = B */
	public static final String PAYMENTRULEPO_Cash = "B";
	/** Direct Debit = D */
	public static final String PAYMENTRULEPO_DirectDebit = "D";
	/** Credit Card = K */
	public static final String PAYMENTRULEPO_CreditCard = "K";
	/** Mixed POS Payment = M */
	public static final String PAYMENTRULEPO_MixedPOSPayment = "M";
	/** Mixed Payment = O */
	public static final String PAYMENTRULEPO_MixedPayment = "O";
	/** Credit = P */
	public static final String PAYMENTRULEPO_Credit = "P";
	/** Check = S */
	public static final String PAYMENTRULEPO_Check = "S";
	/** Direct Deposit = T */
	public static final String PAYMENTRULEPO_DirectDeposit = "T";
	/** Prepaid Cash = Z */
	public static final String PAYMENTRULEPO_PrepaidCash = "Z";
	/** Set Payment Rule.
		@param PaymentRulePO Purchase payment option
	*/
	public void setPaymentRulePO (String PaymentRulePO)
	{

		set_Value (COLUMNNAME_PaymentRulePO, PaymentRulePO);
	}

	/** Get Payment Rule.
		@return Purchase payment option
	  */
	public String getPaymentRulePO()
	{
		return (String)get_Value(COLUMNNAME_PaymentRulePO);
	}

	/** Set PF Amount.
		@param PFAmt PF Amount
	*/
	public void setPFAmt (BigDecimal PFAmt)
	{
		set_Value (COLUMNNAME_PFAmt, PFAmt);
	}

	/** Get PF Amount.
		@return PF Amount	  */
	public BigDecimal getPFAmt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PFAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Phone.
		@param Phone Identifies a telephone number
	*/
	public void setPhone (String Phone)
	{
		set_Value (COLUMNNAME_Phone, Phone);
	}

	/** Get Phone.
		@return Identifies a telephone number
	  */
	public String getPhone()
	{
		return (String)get_Value(COLUMNNAME_Phone);
	}

	public org.compiere.model.I_M_DiscountSchema getPO_DiscountSchema() throws RuntimeException
	{
		return (org.compiere.model.I_M_DiscountSchema)MTable.get(getCtx(), org.compiere.model.I_M_DiscountSchema.Table_ID)
			.getPO(getPO_DiscountSchema_ID(), get_TrxName());
	}

	/** Set PO Discount Schema.
		@param PO_DiscountSchema_ID Schema to calculate the purchase trade discount percentage
	*/
	public void setPO_DiscountSchema_ID (int PO_DiscountSchema_ID)
	{
		if (PO_DiscountSchema_ID < 1)
			set_Value (COLUMNNAME_PO_DiscountSchema_ID, null);
		else
			set_Value (COLUMNNAME_PO_DiscountSchema_ID, Integer.valueOf(PO_DiscountSchema_ID));
	}

	/** Get PO Discount Schema.
		@return Schema to calculate the purchase trade discount percentage
	  */
	public int getPO_DiscountSchema_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PO_DiscountSchema_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_PaymentTerm getPO_PaymentTerm() throws RuntimeException
	{
		return (org.compiere.model.I_C_PaymentTerm)MTable.get(getCtx(), org.compiere.model.I_C_PaymentTerm.Table_ID)
			.getPO(getPO_PaymentTerm_ID(), get_TrxName());
	}

	/** Set PO Payment Term.
		@param PO_PaymentTerm_ID Payment rules for a purchase order
	*/
	public void setPO_PaymentTerm_ID (int PO_PaymentTerm_ID)
	{
		if (PO_PaymentTerm_ID < 1)
			set_Value (COLUMNNAME_PO_PaymentTerm_ID, null);
		else
			set_Value (COLUMNNAME_PO_PaymentTerm_ID, Integer.valueOf(PO_PaymentTerm_ID));
	}

	/** Get PO Payment Term.
		@return Payment rules for a purchase order
	  */
	public int getPO_PaymentTerm_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PO_PaymentTerm_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_PriceList getPO_PriceList() throws RuntimeException
	{
		return (org.compiere.model.I_M_PriceList)MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_ID)
			.getPO(getPO_PriceList_ID(), get_TrxName());
	}

	/** Set Purchase Price List.
		@param PO_PriceList_ID Price List used by this Business Partner
	*/
	public void setPO_PriceList_ID (int PO_PriceList_ID)
	{
		if (PO_PriceList_ID < 1)
			set_Value (COLUMNNAME_PO_PriceList_ID, null);
		else
			set_Value (COLUMNNAME_PO_PriceList_ID, Integer.valueOf(PO_PriceList_ID));
	}

	/** Get Purchase Price List.
		@return Price List used by this Business Partner
	  */
	public int getPO_PriceList_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PO_PriceList_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Order Reference.
		@param POReference Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	*/
	public void setPOReference (String POReference)
	{
		set_Value (COLUMNNAME_POReference, POReference);
	}

	/** Get Order Reference.
		@return Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	  */
	public String getPOReference()
	{
		return (String)get_Value(COLUMNNAME_POReference);
	}

	/** Set ZIP.
		@param Postal Postal code
	*/
	public void setPostal (String Postal)
	{
		set_Value (COLUMNNAME_Postal, Postal);
	}

	/** Get ZIP.
		@return Postal code
	  */
	public String getPostal()
	{
		return (String)get_Value(COLUMNNAME_Postal);
	}

	/** Set Potential Life Time Value.
		@param PotentialLifeTimeValue Total Revenue expected
	*/
	public void setPotentialLifeTimeValue (BigDecimal PotentialLifeTimeValue)
	{
		set_Value (COLUMNNAME_PotentialLifeTimeValue, PotentialLifeTimeValue);
	}

	/** Get Potential Life Time Value.
		@return Total Revenue expected
	  */
	public BigDecimal getPotentialLifeTimeValue()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PotentialLifeTimeValue);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Rating.
		@param Rating Classification or Importance
	*/
	public void setRating (String Rating)
	{
		set_Value (COLUMNNAME_Rating, Rating);
	}

	/** Get Rating.
		@return Classification or Importance
	  */
	public String getRating()
	{
		return (String)get_Value(COLUMNNAME_Rating);
	}

	/** Set Reference No.
		@param ReferenceNo Your customer or vendor number at the Business Partner&#039;s site
	*/
	public void setReferenceNo (String ReferenceNo)
	{
		set_Value (COLUMNNAME_ReferenceNo, ReferenceNo);
	}

	/** Get Reference No.
		@return Your customer or vendor number at the Business Partner&#039;s site
	  */
	public String getReferenceNo()
	{
		return (String)get_Value(COLUMNNAME_ReferenceNo);
	}

	/** Set Region.
		@param RegionName Name of the Region
	*/
	public void setRegionName (String RegionName)
	{
		set_Value (COLUMNNAME_RegionName, RegionName);
	}

	/** Get Region.
		@return Name of the Region
	  */
	public String getRegionName()
	{
		return (String)get_Value(COLUMNNAME_RegionName);
	}

	/** Set Reverse Charge.
		@param ReverseCharge Reverse Charge
	*/
	public void setReverseCharge (boolean ReverseCharge)
	{
		set_Value (COLUMNNAME_ReverseCharge, Boolean.valueOf(ReverseCharge));
	}

	/** Get Reverse Charge.
		@return Reverse Charge	  */
	public boolean isReverseCharge()
	{
		Object oo = get_Value(COLUMNNAME_ReverseCharge);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_AD_User getSalesRep() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getSalesRep_ID(), get_TrxName());
	}

	/** Set Sales Representative.
		@param SalesRep_ID Sales Representative or Company Agent
	*/
	public void setSalesRep_ID (int SalesRep_ID)
	{
		if (SalesRep_ID < 1)
			set_Value (COLUMNNAME_SalesRep_ID, null);
		else
			set_Value (COLUMNNAME_SalesRep_ID, Integer.valueOf(SalesRep_ID));
	}

	/** Get Sales Representative.
		@return Sales Representative or Company Agent
	  */
	public int getSalesRep_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SalesRep_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Sales Volume in 1.000.
		@param SalesVolume Total Volume of Sales in Thousands of Currency
	*/
	public void setSalesVolume (int SalesVolume)
	{
		set_Value (COLUMNNAME_SalesVolume, Integer.valueOf(SalesVolume));
	}

	/** Get Sales Volume in 1.000.
		@return Total Volume of Sales in Thousands of Currency
	  */
	public int getSalesVolume()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SalesVolume);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Send EMail.
		@param SendEMail Enable sending Document EMail
	*/
	public void setSendEMail (boolean SendEMail)
	{
		set_Value (COLUMNNAME_SendEMail, Boolean.valueOf(SendEMail));
	}

	/** Get Send EMail.
		@return Enable sending Document EMail
	  */
	public boolean isSendEMail()
	{
		Object oo = get_Value(COLUMNNAME_SendEMail);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Set Opening Balance.
		@param SetOpeningBalance Sets Opening Balance
	*/
	public void setSetOpeningBalance (String SetOpeningBalance)
	{
		set_Value (COLUMNNAME_SetOpeningBalance, SetOpeningBalance);
	}

	/** Get Set Opening Balance.
		@return Sets Opening Balance
	  */
	public String getSetOpeningBalance()
	{
		return (String)get_Value(COLUMNNAME_SetOpeningBalance);
	}

	/** Set Share.
		@param ShareOfCustomer Share of Customer&#039;s business as a percentage
	*/
	public void setShareOfCustomer (int ShareOfCustomer)
	{
		set_Value (COLUMNNAME_ShareOfCustomer, Integer.valueOf(ShareOfCustomer));
	}

	/** Get Share.
		@return Share of Customer&#039;s business as a percentage
	  */
	public int getShareOfCustomer()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ShareOfCustomer);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Min Shelf Life %.
		@param ShelfLifeMinPct Minimum Shelf Life in percent based on Product Instance Guarantee Date
	*/
	public void setShelfLifeMinPct (int ShelfLifeMinPct)
	{
		set_Value (COLUMNNAME_ShelfLifeMinPct, Integer.valueOf(ShelfLifeMinPct));
	}

	/** Get Min Shelf Life %.
		@return Minimum Shelf Life in percent based on Product Instance Guarantee Date
	  */
	public int getShelfLifeMinPct()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ShelfLifeMinPct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Credit Limit.
		@param SO_CreditLimit Total outstanding invoice amounts allowed
	*/
	public void setSO_CreditLimit (BigDecimal SO_CreditLimit)
	{
		set_Value (COLUMNNAME_SO_CreditLimit, SO_CreditLimit);
	}

	/** Get Credit Limit.
		@return Total outstanding invoice amounts allowed
	  */
	public BigDecimal getSO_CreditLimit()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SO_CreditLimit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Credit Used.
		@param SO_CreditUsed Current open balance
	*/
	public void setSO_CreditUsed (BigDecimal SO_CreditUsed)
	{
		set_ValueNoCheck (COLUMNNAME_SO_CreditUsed, SO_CreditUsed);
	}

	/** Get Credit Used.
		@return Current open balance
	  */
	public BigDecimal getSO_CreditUsed()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SO_CreditUsed);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Order Description.
		@param SO_Description Description to be used on orders
	*/
	public void setSO_Description (String SO_Description)
	{
		set_Value (COLUMNNAME_SO_Description, SO_Description);
	}

	/** Get Order Description.
		@return Description to be used on orders
	  */
	public String getSO_Description()
	{
		return (String)get_Value(COLUMNNAME_SO_Description);
	}

	/** SOCreditStatus AD_Reference_ID=289 */
	public static final int SOCREDITSTATUS_AD_Reference_ID=289;
	/** Credit Hold = H */
	public static final String SOCREDITSTATUS_CreditHold = "H";
	/** Credit OK = O */
	public static final String SOCREDITSTATUS_CreditOK = "O";
	/** Credit Stop = S */
	public static final String SOCREDITSTATUS_CreditStop = "S";
	/** Credit Watch = W */
	public static final String SOCREDITSTATUS_CreditWatch = "W";
	/** No Credit Check = X */
	public static final String SOCREDITSTATUS_NoCreditCheck = "X";
	/** Set Credit Status.
		@param SOCreditStatus Business Partner Credit Status
	*/
	public void setSOCreditStatus (String SOCreditStatus)
	{

		set_Value (COLUMNNAME_SOCreditStatus, SOCreditStatus);
	}

	/** Get Credit Status.
		@return Business Partner Credit Status
	  */
	public String getSOCreditStatus()
	{
		return (String)get_Value(COLUMNNAME_SOCreditStatus);
	}

	/** JAMMU AND KASHMIR = 01 */
	public static final String STATECODE_JAMMUANDKASHMIR = "01";
	/** HIMACHAL PRADESH = 02 */
	public static final String STATECODE_HIMACHALPRADESH = "02";
	/** PUNJAB = 03 */
	public static final String STATECODE_PUNJAB = "03";
	/** CHANDIGARH = 04 */
	public static final String STATECODE_CHANDIGARH = "04";
	/** UTTARAKHAND = 05 */
	public static final String STATECODE_UTTARAKHAND = "05";
	/** HARYANA = 06 */
	public static final String STATECODE_HARYANA = "06";
	/** DELHI = 07 */
	public static final String STATECODE_DELHI = "07";
	/** RAJASTHAN = 08 */
	public static final String STATECODE_RAJASTHAN = "08";
	/** UTTAR PRADESH = 09 */
	public static final String STATECODE_UTTARPRADESH = "09";
	/** BIHAR = 10 */
	public static final String STATECODE_BIHAR = "10";
	/** SIKKIM = 11 */
	public static final String STATECODE_SIKKIM = "11";
	/** ARUNACHAL PRADESH = 12 */
	public static final String STATECODE_ARUNACHALPRADESH = "12";
	/** NAGALAND = 13 */
	public static final String STATECODE_NAGALAND = "13";
	/** MANIPUR = 14 */
	public static final String STATECODE_MANIPUR = "14";
	/** MIZORAM = 15 */
	public static final String STATECODE_MIZORAM = "15";
	/** TRIPURA = 16 */
	public static final String STATECODE_TRIPURA = "16";
	/** MEGHALAYA = 17 */
	public static final String STATECODE_MEGHALAYA = "17";
	/** ASSAM = 18 */
	public static final String STATECODE_ASSAM = "18";
	/** WEST BENGAL = 19 */
	public static final String STATECODE_WESTBENGAL = "19";
	/** JHARKHAND = 20 */
	public static final String STATECODE_JHARKHAND = "20";
	/** ODISHA = 21 */
	public static final String STATECODE_ODISHA = "21";
	/** CHATTISGARH = 22 */
	public static final String STATECODE_CHATTISGARH = "22";
	/** MADHYA PRADESH = 23 */
	public static final String STATECODE_MADHYAPRADESH = "23";
	/** GUJARAT = 24 */
	public static final String STATECODE_GUJARAT = "24";
	/** DADRA AND NAGAR HAVELI AND DAMAN AND DIU (NEWLY MERGED UT) = 26 */
	public static final String STATECODE_DADRAANDNAGARHAVELIANDDAMANANDDIUNEWLYMERGEDUT = "26";
	/** MAHARASHTRA = 27 */
	public static final String STATECODE_MAHARASHTRA = "27";
	/** KARNATAKA = 29 */
	public static final String STATECODE_KARNATAKA = "29";
	/** GOA = 30 */
	public static final String STATECODE_GOA = "30";
	/** LAKSHADWEEP = 31 */
	public static final String STATECODE_LAKSHADWEEP = "31";
	/** KERALA = 32 */
	public static final String STATECODE_KERALA = "32";
	/** TAMIL NADU = 33 */
	public static final String STATECODE_TAMILNADU = "33";
	/** PUDUCHERRY = 34 */
	public static final String STATECODE_PUDUCHERRY = "34";
	/** ANDAMAN AND NICOBAR ISLAND = 35 */
	public static final String STATECODE_ANDAMANANDNICOBARISLAND = "35";
	/** TELANGANA = 36 */
	public static final String STATECODE_TELANGANA = "36";
	/** ANDHRA PRADESH  = 37 */
	public static final String STATECODE_ANDHRAPRADESH = "37";
	/** LADAKH = 38 */
	public static final String STATECODE_LADAKH = "38";
	/** Foreign Country = 96 */
	public static final String STATECODE_ForeignCountry = "96";
	/** OTHER TERRITORY = 97 */
	public static final String STATECODE_OTHERTERRITORY = "97";
	/** CENTRE JURISDICTION = 99 */
	public static final String STATECODE_CENTREJURISDICTION = "99";
	/** Set State Code.
		@param StateCode State Code
	*/
	public void setStateCode (String StateCode)
	{

		set_Value (COLUMNNAME_StateCode, StateCode);
	}

	/** Get State Code.
		@return State Code	  */
	public String getStateCode()
	{
		return (String)get_Value(COLUMNNAME_StateCode);
	}

	/** Set Standard Days.
		@param Std_Days Standard Days
	*/
	public void setStd_Days (BigDecimal Std_Days)
	{
		set_Value (COLUMNNAME_Std_Days, Std_Days);
	}

	/** Get Standard Days.
		@return Standard Days	  */
	public BigDecimal getStd_Days()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Std_Days);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Wage / day.
		@param Std_Wage Wage / day
	*/
	public void setStd_Wage (BigDecimal Std_Wage)
	{
		set_Value (COLUMNNAME_Std_Wage, Std_Wage);
	}

	/** Get Wage / day.
		@return Wage / day	  */
	public BigDecimal getStd_Wage()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Std_Wage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tax ID.
		@param TaxID Tax Identification
	*/
	public void setTaxID (String TaxID)
	{
		set_Value (COLUMNNAME_TaxID, TaxID);
	}

	/** Get Tax ID.
		@return Tax Identification
	  */
	public String getTaxID()
	{
		return (String)get_Value(COLUMNNAME_TaxID);
	}

	/** Set Customer Type.
		@param TF_CustomerType_ID Customer Type
	*/
	public void setTF_CustomerType_ID (int TF_CustomerType_ID)
	{
		if (TF_CustomerType_ID < 1)
			set_Value (COLUMNNAME_TF_CustomerType_ID, null);
		else
			set_Value (COLUMNNAME_TF_CustomerType_ID, Integer.valueOf(TF_CustomerType_ID));
	}

	/** Get Customer Type.
		@return Customer Type	  */
	public int getTF_CustomerType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CustomerType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Destination.
		@param TF_Destination_ID Destination
	*/
	public void setTF_Destination_ID (int TF_Destination_ID)
	{
		if (TF_Destination_ID < 1)
			set_Value (COLUMNNAME_TF_Destination_ID, null);
		else
			set_Value (COLUMNNAME_TF_Destination_ID, Integer.valueOf(TF_Destination_ID));
	}

	/** Get Destination.
		@return Destination	  */
	public int getTF_Destination_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Destination_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tax Invoice Cycle.
		@param TF_TaxInvoiceCycle_ID Tax Invoice Cycle
	*/
	public void setTF_TaxInvoiceCycle_ID (int TF_TaxInvoiceCycle_ID)
	{
		if (TF_TaxInvoiceCycle_ID < 1)
			set_Value (COLUMNNAME_TF_TaxInvoiceCycle_ID, null);
		else
			set_Value (COLUMNNAME_TF_TaxInvoiceCycle_ID, Integer.valueOf(TF_TaxInvoiceCycle_ID));
	}

	/** Get Tax Invoice Cycle.
		@return Tax Invoice Cycle	  */
	public int getTF_TaxInvoiceCycle_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TaxInvoiceCycle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Open Balance.
		@param TotalOpenBalance Total Open Balance Amount in primary Accounting Currency
	*/
	public void setTotalOpenBalance (BigDecimal TotalOpenBalance)
	{
		set_Value (COLUMNNAME_TotalOpenBalance, TotalOpenBalance);
	}

	/** Get Open Balance.
		@return Total Open Balance Amount in primary Accounting Currency
	  */
	public BigDecimal getTotalOpenBalance()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalOpenBalance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set URL.
		@param URL Full URL address - e.g. http://www.idempiere.org
	*/
	public void setURL (String URL)
	{
		set_Value (COLUMNNAME_URL, URL);
	}

	/** Get URL.
		@return Full URL address - e.g. http://www.idempiere.org
	  */
	public String getURL()
	{
		return (String)get_Value(COLUMNNAME_URL);
	}

	public org.compiere.model.I_C_ElementValue getUser1() throws RuntimeException
	{
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_ID)
			.getPO(getUser1_ID(), get_TrxName());
	}

	/** Set Department.
		@param User1_ID User defined list element #1
	*/
	public void setUser1_ID (int User1_ID)
	{
		if (User1_ID < 1)
			set_Value (COLUMNNAME_User1_ID, null);
		else
			set_Value (COLUMNNAME_User1_ID, Integer.valueOf(User1_ID));
	}

	/** Get Department.
		@return User defined list element #1
	  */
	public int getUser1_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

	/** Set Weighment Enabled.
		@param WeighmentEnabled Weighment Enabled
	*/
	public void setWeighmentEnabled (boolean WeighmentEnabled)
	{
		set_Value (COLUMNNAME_WeighmentEnabled, Boolean.valueOf(WeighmentEnabled));
	}

	/** Get Weighment Enabled.
		@return Weighment Enabled	  */
	public boolean isWeighmentEnabled()
	{
		Object oo = get_Value(COLUMNNAME_WeighmentEnabled);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}