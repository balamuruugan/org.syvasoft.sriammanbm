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

/** Generated Model for TF_InvestmentReceipt
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_InvestmentReceipt extends PO implements I_TF_InvestmentReceipt, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171221L;

    /** Standard Constructor */
    public X_TF_InvestmentReceipt (Properties ctx, int TF_InvestmentReceipt_ID, String trxName)
    {
      super (ctx, TF_InvestmentReceipt_ID, trxName);
      /** if (TF_InvestmentReceipt_ID == 0)
        {
			setC_BankAccount_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @DateAcct@
			setDocumentNo (null);
			setInvestmentReceiptType (null);
// B
			setProcessed (false);
			setTF_InvestmentReceipt_ID (0);
			setTF_Shareholder_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_InvestmentReceipt (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
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
      StringBuffer sb = new StringBuffer ("X_TF_InvestmentReceipt[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BankAccount getC_BankAccount() throws RuntimeException
    {
		return (org.compiere.model.I_C_BankAccount)MTable.get(getCtx(), org.compiere.model.I_C_BankAccount.Table_Name)
			.getPO(getC_BankAccount_ID(), get_TrxName());	}

	/** Set Bank/Cash Account.
		@param C_BankAccount_ID 
		Account at the Bank
	  */
	public void setC_BankAccount_ID (int C_BankAccount_ID)
	{
		if (C_BankAccount_ID < 1) 
			set_Value (COLUMNNAME_C_BankAccount_ID, null);
		else 
			set_Value (COLUMNNAME_C_BankAccount_ID, Integer.valueOf(C_BankAccount_ID));
	}

	/** Get Bank/Cash Account.
		@return Account at the Bank
	  */
	public int getC_BankAccount_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BankAccount_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValue_ID(), get_TrxName());	}

	/** Set Account Element.
		@param C_ElementValue_ID 
		Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID)
	{
		if (C_ElementValue_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
	}

	/** Get Account Element.
		@return Account Element
	  */
	public int getC_ElementValue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

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
			set_ValueNoCheck (COLUMNNAME_C_Payment_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Payment_ID, Integer.valueOf(C_Payment_ID));
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

	public org.compiere.model.I_C_Payment getC_PaymentReceipt() throws RuntimeException
    {
		return (org.compiere.model.I_C_Payment)MTable.get(getCtx(), org.compiere.model.I_C_Payment.Table_Name)
			.getPO(getC_PaymentReceipt_ID(), get_TrxName());	}

	/** Set Cash Book Receipt.
		@param C_PaymentReceipt_ID Cash Book Receipt	  */
	public void setC_PaymentReceipt_ID (int C_PaymentReceipt_ID)
	{
		if (C_PaymentReceipt_ID < 1) 
			set_Value (COLUMNNAME_C_PaymentReceipt_ID, null);
		else 
			set_Value (COLUMNNAME_C_PaymentReceipt_ID, Integer.valueOf(C_PaymentReceipt_ID));
	}

	/** Get Cash Book Receipt.
		@return Cash Book Receipt	  */
	public int getC_PaymentReceipt_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PaymentReceipt_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Account Date.
		@param DateAcct 
		Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct)
	{
		set_ValueNoCheck (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Suspended = SU */
	public static final String DOCSTATUS_Suspended = "SU";
	/** Activated = AC */
	public static final String DOCSTATUS_Activated = "AC";
	/** Canceled = CA */
	public static final String DOCSTATUS_Canceled = "CA";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	public org.compiere.model.I_GL_Journal getGL_Journal() throws RuntimeException
    {
		return (org.compiere.model.I_GL_Journal)MTable.get(getCtx(), org.compiere.model.I_GL_Journal.Table_Name)
			.getPO(getGL_Journal_ID(), get_TrxName());	}

	/** Set Journal.
		@param GL_Journal_ID 
		General Ledger Journal
	  */
	public void setGL_Journal_ID (int GL_Journal_ID)
	{
		if (GL_Journal_ID < 1) 
			set_Value (COLUMNNAME_GL_Journal_ID, null);
		else 
			set_Value (COLUMNNAME_GL_Journal_ID, Integer.valueOf(GL_Journal_ID));
	}

	/** Get Journal.
		@return General Ledger Journal
	  */
	public int getGL_Journal_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GL_Journal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Capital A/c to Initial Expense A/c = B */
	public static final String INVESTMENTRECEIPTTYPE_CapitalACToInitialExpenseAC = "B";
	/** Capital A/c to Cash A/c = C */
	public static final String INVESTMENTRECEIPTTYPE_CapitalACToCashAC = "C";
	/** Cash A/c to Initial Expense A/c = P */
	public static final String INVESTMENTRECEIPTTYPE_CashACToInitialExpenseAC = "P";
	/** Set Investment Receipt Type.
		@param InvestmentReceiptType Investment Receipt Type	  */
	public void setInvestmentReceiptType (String InvestmentReceiptType)
	{

		set_Value (COLUMNNAME_InvestmentReceiptType, InvestmentReceiptType);
	}

	/** Get Investment Receipt Type.
		@return Investment Receipt Type	  */
	public String getInvestmentReceiptType () 
	{
		return (String)get_Value(COLUMNNAME_InvestmentReceiptType);
	}

	/** Set Amount Payable.
		@param Payable_Amount Amount Payable	  */
	public void setPayable_Amount (BigDecimal Payable_Amount)
	{
		set_Value (COLUMNNAME_Payable_Amount, Payable_Amount);
	}

	/** Get Amount Payable.
		@return Amount Payable	  */
	public BigDecimal getPayable_Amount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Payable_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Payment amount.
		@param PayAmt 
		Amount being paid
	  */
	public void setPayAmt (BigDecimal PayAmt)
	{
		set_Value (COLUMNNAME_PayAmt, PayAmt);
	}

	/** Get Payment amount.
		@return Amount being paid
	  */
	public BigDecimal getPayAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PayAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Investment Receipt.
		@param TF_InvestmentReceipt_ID Investment Receipt	  */
	public void setTF_InvestmentReceipt_ID (int TF_InvestmentReceipt_ID)
	{
		if (TF_InvestmentReceipt_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_InvestmentReceipt_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_InvestmentReceipt_ID, Integer.valueOf(TF_InvestmentReceipt_ID));
	}

	/** Get Investment Receipt.
		@return Investment Receipt	  */
	public int getTF_InvestmentReceipt_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_InvestmentReceipt_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_InvestmentReceipt_UU.
		@param TF_InvestmentReceipt_UU TF_InvestmentReceipt_UU	  */
	public void setTF_InvestmentReceipt_UU (String TF_InvestmentReceipt_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_InvestmentReceipt_UU, TF_InvestmentReceipt_UU);
	}

	/** Get TF_InvestmentReceipt_UU.
		@return TF_InvestmentReceipt_UU	  */
	public String getTF_InvestmentReceipt_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_InvestmentReceipt_UU);
	}

	public I_TF_Shareholder getTF_Shareholder() throws RuntimeException
    {
		return (I_TF_Shareholder)MTable.get(getCtx(), I_TF_Shareholder.Table_Name)
			.getPO(getTF_Shareholder_ID(), get_TrxName());	}

	/** Set Shareholder.
		@param TF_Shareholder_ID Shareholder	  */
	public void setTF_Shareholder_ID (int TF_Shareholder_ID)
	{
		if (TF_Shareholder_ID < 1) 
			set_Value (COLUMNNAME_TF_Shareholder_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Shareholder_ID, Integer.valueOf(TF_Shareholder_ID));
	}

	/** Get Shareholder.
		@return Shareholder	  */
	public int getTF_Shareholder_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Shareholder_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}