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

/** Generated Model for TF_YardPermitIssue_Entry
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_YardPermitIssue_Entry extends PO implements I_TF_YardPermitIssue_Entry, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180207L;

    /** Standard Constructor */
    public X_TF_YardPermitIssue_Entry (Properties ctx, int TF_YardPermitIssue_Entry_ID, String trxName)
    {
      super (ctx, TF_YardPermitIssue_Entry_ID, trxName);
      /** if (TF_YardPermitIssue_Entry_ID == 0)
        {
			setMDPNo (null);
			setTF_YardPermitIssue_Entry_ID (0);
			setVehicleNo (null);
        } */
    }

    /** Load Constructor */
    public X_TF_YardPermitIssue_Entry (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_YardPermitIssue_Entry[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Bucket Qty.
		@param BucketQty Bucket Qty	  */
	public void setBucketQty (BigDecimal BucketQty)
	{
		set_Value (COLUMNNAME_BucketQty, BucketQty);
	}

	/** Get Bucket Qty.
		@return Bucket Qty	  */
	public BigDecimal getBucketQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BucketQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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
		set_Value (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set MDP No.
		@param MDPNo MDP No	  */
	public void setMDPNo (String MDPNo)
	{
		set_Value (COLUMNNAME_MDPNo, MDPNo);
	}

	/** Get MDP No.
		@return MDP No	  */
	public String getMDPNo () 
	{
		return (String)get_Value(COLUMNNAME_MDPNo);
	}

	/** Issued = I */
	public static final String PERMITISSUE_TYPE_Issued = "I";
	/** Cancelled = C */
	public static final String PERMITISSUE_TYPE_Cancelled = "C";
	/** Set Permit Issue Type.
		@param PermitIssue_Type Permit Issue Type	  */
	public void setPermitIssue_Type (String PermitIssue_Type)
	{

		set_Value (COLUMNNAME_PermitIssue_Type, PermitIssue_Type);
	}

	/** Get Permit Issue Type.
		@return Permit Issue Type	  */
	public String getPermitIssue_Type () 
	{
		return (String)get_Value(COLUMNNAME_PermitIssue_Type);
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

	/** Set Process Permit Issue Entry.
		@param Processing Process Permit Issue Entry	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Permit Issue Entry.
		@return Process Permit Issue Entry	  */
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

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException
    {
		return (I_TF_VehicleType)MTable.get(getCtx(), I_TF_VehicleType.Table_Name)
			.getPO(getTF_VehicleType_ID(), get_TrxName());	}

	/** Set Vehicle Type.
		@param TF_VehicleType_ID Vehicle Type	  */
	public void setTF_VehicleType_ID (int TF_VehicleType_ID)
	{
		if (TF_VehicleType_ID < 1) 
			set_Value (COLUMNNAME_TF_VehicleType_ID, null);
		else 
			set_Value (COLUMNNAME_TF_VehicleType_ID, Integer.valueOf(TF_VehicleType_ID));
	}

	/** Get Vehicle Type.
		@return Vehicle Type	  */
	public int getTF_VehicleType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_VehicleType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_YardCustomerVehicle getTF_YardCustomerVehicle() throws RuntimeException
    {
		return (I_TF_YardCustomerVehicle)MTable.get(getCtx(), I_TF_YardCustomerVehicle.Table_Name)
			.getPO(getTF_YardCustomerVehicle_ID(), get_TrxName());	}

	/** Set Yard Customer Vehicle.
		@param TF_YardCustomerVehicle_ID Yard Customer Vehicle	  */
	public void setTF_YardCustomerVehicle_ID (int TF_YardCustomerVehicle_ID)
	{
		if (TF_YardCustomerVehicle_ID < 1) 
			set_Value (COLUMNNAME_TF_YardCustomerVehicle_ID, null);
		else 
			set_Value (COLUMNNAME_TF_YardCustomerVehicle_ID, Integer.valueOf(TF_YardCustomerVehicle_ID));
	}

	/** Get Yard Customer Vehicle.
		@return Yard Customer Vehicle	  */
	public int getTF_YardCustomerVehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_YardCustomerVehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_YardEntryApprove getTF_YardEntryApprove() throws RuntimeException
    {
		return (I_TF_YardEntryApprove)MTable.get(getCtx(), I_TF_YardEntryApprove.Table_Name)
			.getPO(getTF_YardEntryApprove_ID(), get_TrxName());	}

	/** Set Approve Yard Entry.
		@param TF_YardEntryApprove_ID Approve Yard Entry	  */
	public void setTF_YardEntryApprove_ID (int TF_YardEntryApprove_ID)
	{
		if (TF_YardEntryApprove_ID < 1) 
			set_Value (COLUMNNAME_TF_YardEntryApprove_ID, null);
		else 
			set_Value (COLUMNNAME_TF_YardEntryApprove_ID, Integer.valueOf(TF_YardEntryApprove_ID));
	}

	/** Get Approve Yard Entry.
		@return Approve Yard Entry	  */
	public int getTF_YardEntryApprove_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_YardEntryApprove_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Yard Permit Issue Entry.
		@param TF_YardPermitIssue_Entry_ID Yard Permit Issue Entry	  */
	public void setTF_YardPermitIssue_Entry_ID (int TF_YardPermitIssue_Entry_ID)
	{
		if (TF_YardPermitIssue_Entry_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_YardPermitIssue_Entry_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_YardPermitIssue_Entry_ID, Integer.valueOf(TF_YardPermitIssue_Entry_ID));
	}

	/** Get Yard Permit Issue Entry.
		@return Yard Permit Issue Entry	  */
	public int getTF_YardPermitIssue_Entry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_YardPermitIssue_Entry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_YardPermitIssue_Entry_UU.
		@param TF_YardPermitIssue_Entry_UU TF_YardPermitIssue_Entry_UU	  */
	public void setTF_YardPermitIssue_Entry_UU (String TF_YardPermitIssue_Entry_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_YardPermitIssue_Entry_UU, TF_YardPermitIssue_Entry_UU);
	}

	/** Get TF_YardPermitIssue_Entry_UU.
		@return TF_YardPermitIssue_Entry_UU	  */
	public String getTF_YardPermitIssue_Entry_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_YardPermitIssue_Entry_UU);
	}

	/** Set Time.
		@param Time Time	  */
	public void setTime (String Time)
	{
		set_Value (COLUMNNAME_Time, Time);
	}

	/** Get Time.
		@return Time	  */
	public String getTime () 
	{
		return (String)get_Value(COLUMNNAME_Time);
	}

	/** Set Tonnage.
		@param Tonnage Tonnage	  */
	public void setTonnage (BigDecimal Tonnage)
	{
		set_Value (COLUMNNAME_Tonnage, Tonnage);
	}

	/** Get Tonnage.
		@return Tonnage	  */
	public BigDecimal getTonnage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Tonnage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Trip No.
		@param TripNo Trip No	  */
	public void setTripNo (BigDecimal TripNo)
	{
		set_Value (COLUMNNAME_TripNo, TripNo);
	}

	/** Get Trip No.
		@return Trip No	  */
	public BigDecimal getTripNo () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TripNo);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Vehicle No.
		@param VehicleNo Vehicle No	  */
	public void setVehicleNo (String VehicleNo)
	{
		set_Value (COLUMNNAME_VehicleNo, VehicleNo);
	}

	/** Get Vehicle No.
		@return Vehicle No	  */
	public String getVehicleNo () 
	{
		return (String)get_Value(COLUMNNAME_VehicleNo);
	}
}