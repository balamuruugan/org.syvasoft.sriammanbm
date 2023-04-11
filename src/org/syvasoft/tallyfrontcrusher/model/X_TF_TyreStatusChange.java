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

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for TF_TyreStatusChange
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_TyreStatusChange extends PO implements I_TF_TyreStatusChange, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190209L;

    /** Standard Constructor */
    public X_TF_TyreStatusChange (Properties ctx, int TF_TyreStatusChange_ID, String trxName)
    {
      super (ctx, TF_TyreStatusChange_ID, trxName);
      /** if (TF_TyreStatusChange_ID == 0)
        {
			setChangeTyreType (false);
// N
			setCurr_TF_TyreStatus_ID (0);
			setCurr_TF_TyreType_ID (0);
			setDocAction (null);
// CO
			setDocStatus (null);
// DR
			setDocumentNo (null);
			setNew_TF_TyreStatus_ID (0);
			setProcessed (false);
			setTF_Tyre_ID (0);
			setTF_TyreStatusChange_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TyreStatusChange (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TyreStatusChange[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Change Tyre Type.
		@param ChangeTyreType Change Tyre Type	  */
	public void setChangeTyreType (boolean ChangeTyreType)
	{
		set_Value (COLUMNNAME_ChangeTyreType, Boolean.valueOf(ChangeTyreType));
	}

	/** Get Change Tyre Type.
		@return Change Tyre Type	  */
	public boolean isChangeTyreType () 
	{
		Object oo = get_Value(COLUMNNAME_ChangeTyreType);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public I_TF_TyreStatus getCurr_TF_TyreStatus() throws RuntimeException
    {
		return (I_TF_TyreStatus)MTable.get(getCtx(), I_TF_TyreStatus.Table_Name)
			.getPO(getCurr_TF_TyreStatus_ID(), get_TrxName());	}

	/** Set Current Tyre Status.
		@param Curr_TF_TyreStatus_ID Current Tyre Status	  */
	public void setCurr_TF_TyreStatus_ID (int Curr_TF_TyreStatus_ID)
	{
		if (Curr_TF_TyreStatus_ID < 1) 
			set_Value (COLUMNNAME_Curr_TF_TyreStatus_ID, null);
		else 
			set_Value (COLUMNNAME_Curr_TF_TyreStatus_ID, Integer.valueOf(Curr_TF_TyreStatus_ID));
	}

	/** Get Current Tyre Status.
		@return Current Tyre Status	  */
	public int getCurr_TF_TyreStatus_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Curr_TF_TyreStatus_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyreType getCurr_TF_TyreType() throws RuntimeException
    {
		return (I_TF_TyreType)MTable.get(getCtx(), I_TF_TyreType.Table_Name)
			.getPO(getCurr_TF_TyreType_ID(), get_TrxName());	}

	/** Set Current Tyre Type.
		@param Curr_TF_TyreType_ID Current Tyre Type	  */
	public void setCurr_TF_TyreType_ID (int Curr_TF_TyreType_ID)
	{
		if (Curr_TF_TyreType_ID < 1) 
			set_Value (COLUMNNAME_Curr_TF_TyreType_ID, null);
		else 
			set_Value (COLUMNNAME_Curr_TF_TyreType_ID, Integer.valueOf(Curr_TF_TyreType_ID));
	}

	/** Get Current Tyre Type.
		@return Current Tyre Type	  */
	public int getCurr_TF_TyreType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Curr_TF_TyreType_ID);
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

	/** DocAction AD_Reference_ID=135 */
	public static final int DOCACTION_AD_Reference_ID=135;
	/** Complete = CO */
	public static final String DOCACTION_Complete = "CO";
	/** Approve = AP */
	public static final String DOCACTION_Approve = "AP";
	/** Reject = RJ */
	public static final String DOCACTION_Reject = "RJ";
	/** Post = PO */
	public static final String DOCACTION_Post = "PO";
	/** Void = VO */
	public static final String DOCACTION_Void = "VO";
	/** Close = CL */
	public static final String DOCACTION_Close = "CL";
	/** Reverse - Correct = RC */
	public static final String DOCACTION_Reverse_Correct = "RC";
	/** Reverse - Accrual = RA */
	public static final String DOCACTION_Reverse_Accrual = "RA";
	/** Invalidate = IN */
	public static final String DOCACTION_Invalidate = "IN";
	/** Re-activate = RE */
	public static final String DOCACTION_Re_Activate = "RE";
	/** <None> = -- */
	public static final String DOCACTION_None = "--";
	/** Prepare = PR */
	public static final String DOCACTION_Prepare = "PR";
	/** Unlock = XL */
	public static final String DOCACTION_Unlock = "XL";
	/** Wait Complete = WC */
	public static final String DOCACTION_WaitComplete = "WC";
	/** Suspend = SU */
	public static final String DOCACTION_Suspend = "SU";
	/** Cancel = CA */
	public static final String DOCACTION_Cancel = "CA";
	/** Activate = AC */
	public static final String DOCACTION_Activate = "AC";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
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

	public I_TF_TyreStatus getNew_TF_TyreStatus() throws RuntimeException
    {
		return (I_TF_TyreStatus)MTable.get(getCtx(), I_TF_TyreStatus.Table_Name)
			.getPO(getNew_TF_TyreStatus_ID(), get_TrxName());	}

	/** Set New Tyre Status.
		@param New_TF_TyreStatus_ID New Tyre Status	  */
	public void setNew_TF_TyreStatus_ID (int New_TF_TyreStatus_ID)
	{
		if (New_TF_TyreStatus_ID < 1) 
			set_Value (COLUMNNAME_New_TF_TyreStatus_ID, null);
		else 
			set_Value (COLUMNNAME_New_TF_TyreStatus_ID, Integer.valueOf(New_TF_TyreStatus_ID));
	}

	/** Get New Tyre Status.
		@return New Tyre Status	  */
	public int getNew_TF_TyreStatus_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_New_TF_TyreStatus_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyreType getNew_TF_TyreType() throws RuntimeException
    {
		return (I_TF_TyreType)MTable.get(getCtx(), I_TF_TyreType.Table_Name)
			.getPO(getNew_TF_TyreType_ID(), get_TrxName());	}

	/** Set New Tyre Type.
		@param New_TF_TyreType_ID New Tyre Type	  */
	public void setNew_TF_TyreType_ID (int New_TF_TyreType_ID)
	{
		if (New_TF_TyreType_ID < 1) 
			set_Value (COLUMNNAME_New_TF_TyreType_ID, null);
		else 
			set_Value (COLUMNNAME_New_TF_TyreType_ID, Integer.valueOf(New_TF_TyreType_ID));
	}

	/** Get New Tyre Type.
		@return New Tyre Type	  */
	public int getNew_TF_TyreType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_New_TF_TyreType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Reason for Change.
		@param Reason Reason for Change	  */
	public void setReason (String Reason)
	{
		set_Value (COLUMNNAME_Reason, Reason);
	}

	/** Get Reason for Change.
		@return Reason for Change	  */
	public String getReason () 
	{
		return (String)get_Value(COLUMNNAME_Reason);
	}

	public I_TF_Tyre getTF_Tyre() throws RuntimeException
    {
		return (I_TF_Tyre)MTable.get(getCtx(), I_TF_Tyre.Table_Name)
			.getPO(getTF_Tyre_ID(), get_TrxName());	}

	/** Set Tyre.
		@param TF_Tyre_ID Tyre	  */
	public void setTF_Tyre_ID (int TF_Tyre_ID)
	{
		if (TF_Tyre_ID < 1) 
			set_Value (COLUMNNAME_TF_Tyre_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Tyre_ID, Integer.valueOf(TF_Tyre_ID));
	}

	/** Get Tyre.
		@return Tyre	  */
	public int getTF_Tyre_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tyre Status Change.
		@param TF_TyreStatusChange_ID Tyre Status Change	  */
	public void setTF_TyreStatusChange_ID (int TF_TyreStatusChange_ID)
	{
		if (TF_TyreStatusChange_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreStatusChange_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreStatusChange_ID, Integer.valueOf(TF_TyreStatusChange_ID));
	}

	/** Get Tyre Status Change.
		@return Tyre Status Change	  */
	public int getTF_TyreStatusChange_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreStatusChange_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TyreStatusChange_UU.
		@param TF_TyreStatusChange_UU TF_TyreStatusChange_UU	  */
	public void setTF_TyreStatusChange_UU (String TF_TyreStatusChange_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TyreStatusChange_UU, TF_TyreStatusChange_UU);
	}

	/** Get TF_TyreStatusChange_UU.
		@return TF_TyreStatusChange_UU	  */
	public String getTF_TyreStatusChange_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TyreStatusChange_UU);
	}
}