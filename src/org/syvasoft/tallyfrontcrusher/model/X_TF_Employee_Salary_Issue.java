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

/** Generated Model for TF_Employee_Salary_Issue
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_Employee_Salary_Issue extends PO implements I_TF_Employee_Salary_Issue, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220701L;

    /** Standard Constructor */
    public X_TF_Employee_Salary_Issue (Properties ctx, int TF_Employee_Salary_Issue_ID, String trxName)
    {
      super (ctx, TF_Employee_Salary_Issue_ID, trxName);
      /** if (TF_Employee_Salary_Issue_ID == 0)
        {
			setBasicSalary (Env.ZERO);
// 0
			setC_BankAccount_ID (0);
			setC_BPartner_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDocumentNo (null);
			setIssuedBankAmt (Env.ZERO);
			setIssuedCashAmt (Env.ZERO);
			setProcessed (false);
			setTF_Employee_Salary_Issue_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Employee_Salary_Issue (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Employee_Salary_Issue[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Balance Advance.
		@param Advance_Balance Balance Advance	  */
	public void setAdvance_Balance (BigDecimal Advance_Balance)
	{
		set_Value (COLUMNNAME_Advance_Balance, Advance_Balance);
	}

	/** Get Balance Advance.
		@return Balance Advance	  */
	public BigDecimal getAdvance_Balance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Advance_Balance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Deduct Advance.
		@param Advance_Deduct Deduct Advance	  */
	public void setAdvance_Deduct (BigDecimal Advance_Deduct)
	{
		set_Value (COLUMNNAME_Advance_Deduct, Advance_Deduct);
	}

	/** Get Deduct Advance.
		@return Deduct Advance	  */
	public BigDecimal getAdvance_Deduct () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Advance_Deduct);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Advance Paid.
		@param Advance_Paid Advance Paid	  */
	public void setAdvance_Paid (BigDecimal Advance_Paid)
	{
		set_Value (COLUMNNAME_Advance_Paid, Advance_Paid);
	}

	/** Get Advance Paid.
		@return Advance Paid	  */
	public BigDecimal getAdvance_Paid () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Advance_Paid);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Basic Salary.
		@param BasicSalary Basic Salary	  */
	public void setBasicSalary (BigDecimal BasicSalary)
	{
		set_Value (COLUMNNAME_BasicSalary, BasicSalary);
	}

	/** Get Basic Salary.
		@return Basic Salary	  */
	public BigDecimal getBasicSalary () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BasicSalary);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	public org.compiere.model.I_C_BankAccount getC_BankAccountBnk() throws RuntimeException
    {
		return (org.compiere.model.I_C_BankAccount)MTable.get(getCtx(), org.compiere.model.I_C_BankAccount.Table_Name)
			.getPO(getC_BankAccountBnk_ID(), get_TrxName());	}

	/** Set Bank Account.
		@param C_BankAccountBnk_ID Bank Account	  */
	public void setC_BankAccountBnk_ID (int C_BankAccountBnk_ID)
	{
		if (C_BankAccountBnk_ID < 1) 
			set_Value (COLUMNNAME_C_BankAccountBnk_ID, null);
		else 
			set_Value (COLUMNNAME_C_BankAccountBnk_ID, Integer.valueOf(C_BankAccountBnk_ID));
	}

	/** Get Bank Account.
		@return Bank Account	  */
	public int getC_BankAccountBnk_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BankAccountBnk_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
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

	public org.compiere.model.I_C_Payment getC_PaymentBank() throws RuntimeException
    {
		return (org.compiere.model.I_C_Payment)MTable.get(getCtx(), org.compiere.model.I_C_Payment.Table_Name)
			.getPO(getC_PaymentBank_ID(), get_TrxName());	}

	/** Set Bank Book Entry.
		@param C_PaymentBank_ID Bank Book Entry	  */
	public void setC_PaymentBank_ID (int C_PaymentBank_ID)
	{
		if (C_PaymentBank_ID < 1) 
			set_Value (COLUMNNAME_C_PaymentBank_ID, null);
		else 
			set_Value (COLUMNNAME_C_PaymentBank_ID, Integer.valueOf(C_PaymentBank_ID));
	}

	/** Get Bank Book Entry.
		@return Bank Book Entry	  */
	public int getC_PaymentBank_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PaymentBank_ID);
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
		set_Value (COLUMNNAME_DateAcct, DateAcct);
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
	/** Overdue = OD */
	public static final String DOCSTATUS_Overdue = "OD";
	/** Due = DU */
	public static final String DOCSTATUS_Due = "DU";
	/** Upcoming = UP */
	public static final String DOCSTATUS_Upcoming = "UP";
	/** Partially Billed = PB */
	public static final String DOCSTATUS_PartiallyBilled = "PB";
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
			set_ValueNoCheck (COLUMNNAME_GL_Journal_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_GL_Journal_ID, Integer.valueOf(GL_Journal_ID));
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

	/** Set Bank.
		@param IssuedBankAmt Bank	  */
	public void setIssuedBankAmt (BigDecimal IssuedBankAmt)
	{
		set_Value (COLUMNNAME_IssuedBankAmt, IssuedBankAmt);
	}

	/** Get Bank.
		@return Bank	  */
	public BigDecimal getIssuedBankAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_IssuedBankAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Cash.
		@param IssuedCashAmt Cash	  */
	public void setIssuedCashAmt (BigDecimal IssuedCashAmt)
	{
		set_Value (COLUMNNAME_IssuedCashAmt, IssuedCashAmt);
	}

	/** Get Cash.
		@return Cash	  */
	public BigDecimal getIssuedCashAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_IssuedCashAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Balance Loan.
		@param Loan_Balance Balance Loan	  */
	public void setLoan_Balance (BigDecimal Loan_Balance)
	{
		set_Value (COLUMNNAME_Loan_Balance, Loan_Balance);
	}

	/** Get Balance Loan.
		@return Balance Loan	  */
	public BigDecimal getLoan_Balance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Loan_Balance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Deduct Loan.
		@param Loan_Deduct Deduct Loan	  */
	public void setLoan_Deduct (BigDecimal Loan_Deduct)
	{
		set_Value (COLUMNNAME_Loan_Deduct, Loan_Deduct);
	}

	/** Get Deduct Loan.
		@return Deduct Loan	  */
	public BigDecimal getLoan_Deduct () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Loan_Deduct);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Loan Paid.
		@param Loan_Paid Loan Paid	  */
	public void setLoan_Paid (BigDecimal Loan_Paid)
	{
		set_Value (COLUMNNAME_Loan_Paid, Loan_Paid);
	}

	/** Get Loan Paid.
		@return Loan Paid	  */
	public BigDecimal getLoan_Paid () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Loan_Paid);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Monthly Salary.
		@param MonthlySalaryAmt Monthly Salary	  */
	public void setMonthlySalaryAmt (BigDecimal MonthlySalaryAmt)
	{
		set_Value (COLUMNNAME_MonthlySalaryAmt, MonthlySalaryAmt);
	}

	/** Get Monthly Salary.
		@return Monthly Salary	  */
	public BigDecimal getMonthlySalaryAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_MonthlySalaryAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set PF Amount.
		@param PFAmt PF Amount	  */
	public void setPFAmt (BigDecimal PFAmt)
	{
		set_Value (COLUMNNAME_PFAmt, PFAmt);
	}

	/** Get PF Amount.
		@return PF Amount	  */
	public BigDecimal getPFAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PFAmt);
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

	/** Set Earned Salary.
		@param Salary_Amt Earned Salary	  */
	public void setSalary_Amt (BigDecimal Salary_Amt)
	{
		set_Value (COLUMNNAME_Salary_Amt, Salary_Amt);
	}

	/** Get Earned Salary.
		@return Earned Salary	  */
	public BigDecimal getSalary_Amt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Salary_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Salary Paid.
		@param Salary_Paid Salary Paid	  */
	public void setSalary_Paid (BigDecimal Salary_Paid)
	{
		set_Value (COLUMNNAME_Salary_Paid, Salary_Paid);
	}

	/** Get Salary Paid.
		@return Salary Paid	  */
	public BigDecimal getSalary_Paid () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Salary_Paid);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Balance Salary.
		@param Salary_Payable Balance Salary	  */
	public void setSalary_Payable (BigDecimal Salary_Payable)
	{
		set_Value (COLUMNNAME_Salary_Payable, Salary_Payable);
	}

	/** Get Balance Salary.
		@return Balance Salary	  */
	public BigDecimal getSalary_Payable () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Salary_Payable);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Employee Salary Issue.
		@param TF_Employee_Salary_Issue_ID Employee Salary Issue	  */
	public void setTF_Employee_Salary_Issue_ID (int TF_Employee_Salary_Issue_ID)
	{
		if (TF_Employee_Salary_Issue_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Employee_Salary_Issue_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Employee_Salary_Issue_ID, Integer.valueOf(TF_Employee_Salary_Issue_ID));
	}

	/** Get Employee Salary Issue.
		@return Employee Salary Issue	  */
	public int getTF_Employee_Salary_Issue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Employee_Salary_Issue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Employee_Salary_Issue_UU.
		@param TF_Employee_Salary_Issue_UU TF_Employee_Salary_Issue_UU	  */
	public void setTF_Employee_Salary_Issue_UU (String TF_Employee_Salary_Issue_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Employee_Salary_Issue_UU, TF_Employee_Salary_Issue_UU);
	}

	/** Get TF_Employee_Salary_Issue_UU.
		@return TF_Employee_Salary_Issue_UU	  */
	public String getTF_Employee_Salary_Issue_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Employee_Salary_Issue_UU);
	}

	public I_TF_SalaryIssueHdr getTF_SalaryIssueHdr() throws RuntimeException
    {
		return (I_TF_SalaryIssueHdr)MTable.get(getCtx(), I_TF_SalaryIssueHdr.Table_Name)
			.getPO(getTF_SalaryIssueHdr_ID(), get_TrxName());	}

	/** Set Process Salary Issue.
		@param TF_SalaryIssueHdr_ID Process Salary Issue	  */
	public void setTF_SalaryIssueHdr_ID (int TF_SalaryIssueHdr_ID)
	{
		if (TF_SalaryIssueHdr_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_SalaryIssueHdr_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_SalaryIssueHdr_ID, Integer.valueOf(TF_SalaryIssueHdr_ID));
	}

	/** Get Process Salary Issue.
		@return Process Salary Issue	  */
	public int getTF_SalaryIssueHdr_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_SalaryIssueHdr_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUser1() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUser1_ID(), get_TrxName());	}

	/** Set Department.
		@param User1_ID 
		User defined list element #1
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
	public int getUser1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}