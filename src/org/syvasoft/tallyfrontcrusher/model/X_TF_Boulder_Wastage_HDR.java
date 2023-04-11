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

/** Generated Model for TF_Boulder_Wastage_HDR
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_Boulder_Wastage_HDR extends PO implements I_TF_Boulder_Wastage_HDR, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220804L;

    /** Standard Constructor */
    public X_TF_Boulder_Wastage_HDR (Properties ctx, int TF_Boulder_Wastage_HDR_ID, String trxName)
    {
      super (ctx, TF_Boulder_Wastage_HDR_ID, trxName);
      /** if (TF_Boulder_Wastage_HDR_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
			setDocAction (null);
// CO
			setDocStatus (null);
// DR
			setDocumentNo (null);
			setProcessed (false);
			setTF_Boulder_Wastage_HDR_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Boulder_Wastage_HDR (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Boulder_Wastage_HDR[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Belt Scale Closing.
		@param BS_Closing Belt Scale Closing	  */
	public void setBS_Closing (BigDecimal BS_Closing)
	{
		set_Value (COLUMNNAME_BS_Closing, BS_Closing);
	}

	/** Get Belt Scale Closing.
		@return Belt Scale Closing	  */
	public BigDecimal getBS_Closing () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BS_Closing);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Belt Scale Opening.
		@param BS_Opening Belt Scale Opening	  */
	public void setBS_Opening (BigDecimal BS_Opening)
	{
		set_Value (COLUMNNAME_BS_Opening, BS_Opening);
	}

	/** Get Belt Scale Opening.
		@return Belt Scale Opening	  */
	public BigDecimal getBS_Opening () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BS_Opening);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Belt Scale Qty.
		@param BS_Qty Belt Scale Qty	  */
	public void setBS_Qty (BigDecimal BS_Qty)
	{
		set_Value (COLUMNNAME_BS_Qty, BS_Qty);
	}

	/** Get Belt Scale Qty.
		@return Belt Scale Qty	  */
	public BigDecimal getBS_Qty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BS_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Crushing Qty.
		@param Crusher_Qty Crushing Qty	  */
	public void setCrusher_Qty (BigDecimal Crusher_Qty)
	{
		set_Value (COLUMNNAME_Crusher_Qty, Crusher_Qty);
	}

	/** Get Crushing Qty.
		@return Crushing Qty	  */
	public BigDecimal getCrusher_Qty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Crusher_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Crushing Trip.
		@param Crusher_Trip Crushing Trip	  */
	public void setCrusher_Trip (int Crusher_Trip)
	{
		set_Value (COLUMNNAME_Crusher_Trip, Integer.valueOf(Crusher_Trip));
	}

	/** Get Crushing Trip.
		@return Crushing Trip	  */
	public int getCrusher_Trip () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Crusher_Trip);
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
	/** Start  = ST */
	public static final String DOCACTION_Start = "ST";
	/** Modify = MO */
	public static final String DOCACTION_Modify = "MO";
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

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
    {
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_Name)
			.getPO(getM_Warehouse_ID(), get_TrxName());	}

	/** Set Warehouse.
		@param M_Warehouse_ID 
		Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
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

	/** Set Scalping Percentage.
		@param Scalping_Percent Scalping Percentage	  */
	public void setScalping_Percent (BigDecimal Scalping_Percent)
	{
		set_Value (COLUMNNAME_Scalping_Percent, Scalping_Percent);
	}

	/** Get Scalping Percentage.
		@return Scalping Percentage	  */
	public BigDecimal getScalping_Percent () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Scalping_Percent);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Scalping Qty.
		@param Scalping_Qty Scalping Qty	  */
	public void setScalping_Qty (BigDecimal Scalping_Qty)
	{
		set_Value (COLUMNNAME_Scalping_Qty, Scalping_Qty);
	}

	/** Get Scalping Qty.
		@return Scalping Qty	  */
	public BigDecimal getScalping_Qty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Scalping_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Boulder Wastage Header.
		@param TF_Boulder_Wastage_HDR_ID Boulder Wastage Header	  */
	public void setTF_Boulder_Wastage_HDR_ID (int TF_Boulder_Wastage_HDR_ID)
	{
		if (TF_Boulder_Wastage_HDR_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_HDR_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_HDR_ID, Integer.valueOf(TF_Boulder_Wastage_HDR_ID));
	}

	/** Get Boulder Wastage Header.
		@return Boulder Wastage Header	  */
	public int getTF_Boulder_Wastage_HDR_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Wastage_HDR_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Boulder_Wastage_HDR_UU.
		@param TF_Boulder_Wastage_HDR_UU TF_Boulder_Wastage_HDR_UU	  */
	public void setTF_Boulder_Wastage_HDR_UU (String TF_Boulder_Wastage_HDR_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_HDR_UU, TF_Boulder_Wastage_HDR_UU);
	}

	/** Get TF_Boulder_Wastage_HDR_UU.
		@return TF_Boulder_Wastage_HDR_UU	  */
	public String getTF_Boulder_Wastage_HDR_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Boulder_Wastage_HDR_UU);
	}
}