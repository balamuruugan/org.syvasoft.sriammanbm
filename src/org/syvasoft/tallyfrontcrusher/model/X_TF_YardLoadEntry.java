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

/** Generated Model for TF_YardLoadEntry
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_YardLoadEntry extends PO implements I_TF_YardLoadEntry, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180207L;

    /** Standard Constructor */
    public X_TF_YardLoadEntry (Properties ctx, int TF_YardLoadEntry_ID, String trxName)
    {
      super (ctx, TF_YardLoadEntry_ID, trxName);
      /** if (TF_YardLoadEntry_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setTF_YardLoadEntry_ID (0);
			setVehicleNo (null);
        } */
    }

    /** Load Constructor */
    public X_TF_YardLoadEntry (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_YardLoadEntry[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Buckets Discounted.
		@param Bucket_Discount Buckets Discounted	  */
	public void setBucket_Discount (BigDecimal Bucket_Discount)
	{
		set_Value (COLUMNNAME_Bucket_Discount, Bucket_Discount);
	}

	/** Get Buckets Discounted.
		@return Buckets Discounted	  */
	public BigDecimal getBucket_Discount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Bucket_Discount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Full = F */
	public static final String BUCKET1_Full = "F";
	/** Half = H */
	public static final String BUCKET1_Half = "H";
	/** Set Bucket 1.
		@param Bucket1 Bucket 1	  */
	public void setBucket1 (String Bucket1)
	{

		set_Value (COLUMNNAME_Bucket1, Bucket1);
	}

	/** Get Bucket 1.
		@return Bucket 1	  */
	public String getBucket1 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket1);
	}

	/** Full = F */
	public static final String BUCKET10_Full = "F";
	/** Half = H */
	public static final String BUCKET10_Half = "H";
	/** Set Bucket 10.
		@param Bucket10 Bucket 10	  */
	public void setBucket10 (String Bucket10)
	{

		set_Value (COLUMNNAME_Bucket10, Bucket10);
	}

	/** Get Bucket 10.
		@return Bucket 10	  */
	public String getBucket10 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket10);
	}

	/** Full = F */
	public static final String BUCKET11_Full = "F";
	/** Half = H */
	public static final String BUCKET11_Half = "H";
	/** Set Bucket 11.
		@param Bucket11 Bucket 11	  */
	public void setBucket11 (String Bucket11)
	{

		set_Value (COLUMNNAME_Bucket11, Bucket11);
	}

	/** Get Bucket 11.
		@return Bucket 11	  */
	public String getBucket11 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket11);
	}

	/** Full = F */
	public static final String BUCKET12_Full = "F";
	/** Half = H */
	public static final String BUCKET12_Half = "H";
	/** Set Bucket 12.
		@param Bucket12 Bucket 12	  */
	public void setBucket12 (String Bucket12)
	{

		set_Value (COLUMNNAME_Bucket12, Bucket12);
	}

	/** Get Bucket 12.
		@return Bucket 12	  */
	public String getBucket12 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket12);
	}

	/** Full = F */
	public static final String BUCKET2_Full = "F";
	/** Half = H */
	public static final String BUCKET2_Half = "H";
	/** Set Bucket 2.
		@param Bucket2 Bucket 2	  */
	public void setBucket2 (String Bucket2)
	{

		set_Value (COLUMNNAME_Bucket2, Bucket2);
	}

	/** Get Bucket 2.
		@return Bucket 2	  */
	public String getBucket2 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket2);
	}

	/** Full = F */
	public static final String BUCKET3_Full = "F";
	/** Half = H */
	public static final String BUCKET3_Half = "H";
	/** Set Bucket 3.
		@param Bucket3 Bucket 3	  */
	public void setBucket3 (String Bucket3)
	{

		set_Value (COLUMNNAME_Bucket3, Bucket3);
	}

	/** Get Bucket 3.
		@return Bucket 3	  */
	public String getBucket3 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket3);
	}

	/** Full = F */
	public static final String BUCKET4_Full = "F";
	/** Half = H */
	public static final String BUCKET4_Half = "H";
	/** Set Bucket 4.
		@param Bucket4 Bucket 4	  */
	public void setBucket4 (String Bucket4)
	{

		set_Value (COLUMNNAME_Bucket4, Bucket4);
	}

	/** Get Bucket 4.
		@return Bucket 4	  */
	public String getBucket4 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket4);
	}

	/** Full = F */
	public static final String BUCKET5_Full = "F";
	/** Half = H */
	public static final String BUCKET5_Half = "H";
	/** Set Bucket 5.
		@param Bucket5 Bucket 5	  */
	public void setBucket5 (String Bucket5)
	{

		set_Value (COLUMNNAME_Bucket5, Bucket5);
	}

	/** Get Bucket 5.
		@return Bucket 5	  */
	public String getBucket5 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket5);
	}

	/** Full = F */
	public static final String BUCKET6_Full = "F";
	/** Half = H */
	public static final String BUCKET6_Half = "H";
	/** Set Bucket 6.
		@param Bucket6 Bucket 6	  */
	public void setBucket6 (String Bucket6)
	{

		set_Value (COLUMNNAME_Bucket6, Bucket6);
	}

	/** Get Bucket 6.
		@return Bucket 6	  */
	public String getBucket6 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket6);
	}

	/** Full = F */
	public static final String BUCKET7_Full = "F";
	/** Half = H */
	public static final String BUCKET7_Half = "H";
	/** Set Bucket 7.
		@param Bucket7 Bucket 7	  */
	public void setBucket7 (String Bucket7)
	{

		set_Value (COLUMNNAME_Bucket7, Bucket7);
	}

	/** Get Bucket 7.
		@return Bucket 7	  */
	public String getBucket7 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket7);
	}

	/** Full = F */
	public static final String BUCKET8_Full = "F";
	/** Half = H */
	public static final String BUCKET8_Half = "H";
	/** Set Bucket 8.
		@param Bucket8 Bucket 8	  */
	public void setBucket8 (String Bucket8)
	{

		set_Value (COLUMNNAME_Bucket8, Bucket8);
	}

	/** Get Bucket 8.
		@return Bucket 8	  */
	public String getBucket8 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket8);
	}

	/** Full = F */
	public static final String BUCKET9_Full = "F";
	/** Half = H */
	public static final String BUCKET9_Half = "H";
	/** Set Bucket 9.
		@param Bucket9 Bucket 9	  */
	public void setBucket9 (String Bucket9)
	{

		set_Value (COLUMNNAME_Bucket9, Bucket9);
	}

	/** Get Bucket 9.
		@return Bucket 9	  */
	public String getBucket9 () 
	{
		return (String)get_Value(COLUMNNAME_Bucket9);
	}

	/** Set Bucket / Load.
		@param BucketPerLoad Bucket / Load	  */
	public void setBucketPerLoad (BigDecimal BucketPerLoad)
	{
		set_Value (COLUMNNAME_BucketPerLoad, BucketPerLoad);
	}

	/** Get Bucket / Load.
		@return Bucket / Load	  */
	public BigDecimal getBucketPerLoad () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BucketPerLoad);
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

	/** Set Comments.
		@param Comments 
		Comments or additional information
	  */
	public void setComments (String Comments)
	{
		set_Value (COLUMNNAME_Comments, Comments);
	}

	/** Get Comments.
		@return Comments or additional information
	  */
	public String getComments () 
	{
		return (String)get_Value(COLUMNNAME_Comments);
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
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Driver Name.
		@param DriverName Driver Name	  */
	public void setDriverName (String DriverName)
	{
		set_Value (COLUMNNAME_DriverName, DriverName);
	}

	/** Get Driver Name.
		@return Driver Name	  */
	public String getDriverName () 
	{
		return (String)get_Value(COLUMNNAME_DriverName);
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

	/** Set Process Load Entry.
		@param Processing Process Load Entry	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Load Entry.
		@return Process Load Entry	  */
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

	/** Set Yard Load Entry.
		@param TF_YardLoadEntry_ID Yard Load Entry	  */
	public void setTF_YardLoadEntry_ID (int TF_YardLoadEntry_ID)
	{
		if (TF_YardLoadEntry_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_YardLoadEntry_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_YardLoadEntry_ID, Integer.valueOf(TF_YardLoadEntry_ID));
	}

	/** Get Yard Load Entry.
		@return Yard Load Entry	  */
	public int getTF_YardLoadEntry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_YardLoadEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_YardLoadEntry_UU.
		@param TF_YardLoadEntry_UU TF_YardLoadEntry_UU	  */
	public void setTF_YardLoadEntry_UU (String TF_YardLoadEntry_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_YardLoadEntry_UU, TF_YardLoadEntry_UU);
	}

	/** Get TF_YardLoadEntry_UU.
		@return TF_YardLoadEntry_UU	  */
	public String getTF_YardLoadEntry_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_YardLoadEntry_UU);
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

	/** Set Total Bucket.
		@param Total_Bucket Total Bucket	  */
	public void setTotal_Bucket (BigDecimal Total_Bucket)
	{
		set_Value (COLUMNNAME_Total_Bucket, Total_Bucket);
	}

	/** Get Total Bucket.
		@return Total Bucket	  */
	public BigDecimal getTotal_Bucket () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total_Bucket);
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