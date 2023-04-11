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
package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for TF_YardLoadEntry
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_YardLoadEntry 
{

    /** TableName=TF_YardLoadEntry */
    public static final String Table_Name = "TF_YardLoadEntry";

    /** AD_Table_ID=1000246 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Bucket_Discount */
    public static final String COLUMNNAME_Bucket_Discount = "Bucket_Discount";

	/** Set Buckets Discounted	  */
	public void setBucket_Discount (BigDecimal Bucket_Discount);

	/** Get Buckets Discounted	  */
	public BigDecimal getBucket_Discount();

    /** Column name Bucket1 */
    public static final String COLUMNNAME_Bucket1 = "Bucket1";

	/** Set Bucket 1	  */
	public void setBucket1 (String Bucket1);

	/** Get Bucket 1	  */
	public String getBucket1();

    /** Column name Bucket10 */
    public static final String COLUMNNAME_Bucket10 = "Bucket10";

	/** Set Bucket 10	  */
	public void setBucket10 (String Bucket10);

	/** Get Bucket 10	  */
	public String getBucket10();

    /** Column name Bucket11 */
    public static final String COLUMNNAME_Bucket11 = "Bucket11";

	/** Set Bucket 11	  */
	public void setBucket11 (String Bucket11);

	/** Get Bucket 11	  */
	public String getBucket11();

    /** Column name Bucket12 */
    public static final String COLUMNNAME_Bucket12 = "Bucket12";

	/** Set Bucket 12	  */
	public void setBucket12 (String Bucket12);

	/** Get Bucket 12	  */
	public String getBucket12();

    /** Column name Bucket2 */
    public static final String COLUMNNAME_Bucket2 = "Bucket2";

	/** Set Bucket 2	  */
	public void setBucket2 (String Bucket2);

	/** Get Bucket 2	  */
	public String getBucket2();

    /** Column name Bucket3 */
    public static final String COLUMNNAME_Bucket3 = "Bucket3";

	/** Set Bucket 3	  */
	public void setBucket3 (String Bucket3);

	/** Get Bucket 3	  */
	public String getBucket3();

    /** Column name Bucket4 */
    public static final String COLUMNNAME_Bucket4 = "Bucket4";

	/** Set Bucket 4	  */
	public void setBucket4 (String Bucket4);

	/** Get Bucket 4	  */
	public String getBucket4();

    /** Column name Bucket5 */
    public static final String COLUMNNAME_Bucket5 = "Bucket5";

	/** Set Bucket 5	  */
	public void setBucket5 (String Bucket5);

	/** Get Bucket 5	  */
	public String getBucket5();

    /** Column name Bucket6 */
    public static final String COLUMNNAME_Bucket6 = "Bucket6";

	/** Set Bucket 6	  */
	public void setBucket6 (String Bucket6);

	/** Get Bucket 6	  */
	public String getBucket6();

    /** Column name Bucket7 */
    public static final String COLUMNNAME_Bucket7 = "Bucket7";

	/** Set Bucket 7	  */
	public void setBucket7 (String Bucket7);

	/** Get Bucket 7	  */
	public String getBucket7();

    /** Column name Bucket8 */
    public static final String COLUMNNAME_Bucket8 = "Bucket8";

	/** Set Bucket 8	  */
	public void setBucket8 (String Bucket8);

	/** Get Bucket 8	  */
	public String getBucket8();

    /** Column name Bucket9 */
    public static final String COLUMNNAME_Bucket9 = "Bucket9";

	/** Set Bucket 9	  */
	public void setBucket9 (String Bucket9);

	/** Get Bucket 9	  */
	public String getBucket9();

    /** Column name BucketPerLoad */
    public static final String COLUMNNAME_BucketPerLoad = "BucketPerLoad";

	/** Set Bucket / Load	  */
	public void setBucketPerLoad (BigDecimal BucketPerLoad);

	/** Get Bucket / Load	  */
	public BigDecimal getBucketPerLoad();

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name Comments */
    public static final String COLUMNNAME_Comments = "Comments";

	/** Set Comments.
	  * Comments or additional information
	  */
	public void setComments (String Comments);

	/** Get Comments.
	  * Comments or additional information
	  */
	public String getComments();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name DateAcct */
    public static final String COLUMNNAME_DateAcct = "DateAcct";

	/** Set Account Date.
	  * Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct);

	/** Get Account Date.
	  * Accounting Date
	  */
	public Timestamp getDateAcct();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name DocStatus */
    public static final String COLUMNNAME_DocStatus = "DocStatus";

	/** Set Document Status.
	  * The current status of the document
	  */
	public void setDocStatus (String DocStatus);

	/** Get Document Status.
	  * The current status of the document
	  */
	public String getDocStatus();

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

    /** Column name DriverName */
    public static final String COLUMNNAME_DriverName = "DriverName";

	/** Set Driver Name	  */
	public void setDriverName (String DriverName);

	/** Get Driver Name	  */
	public String getDriverName();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Load Entry	  */
	public void setProcessing (boolean Processing);

	/** Get Process Load Entry	  */
	public boolean isProcessing();

    /** Column name TF_VehicleType_ID */
    public static final String COLUMNNAME_TF_VehicleType_ID = "TF_VehicleType_ID";

	/** Set Vehicle Type	  */
	public void setTF_VehicleType_ID (int TF_VehicleType_ID);

	/** Get Vehicle Type	  */
	public int getTF_VehicleType_ID();

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException;

    /** Column name TF_YardCustomerVehicle_ID */
    public static final String COLUMNNAME_TF_YardCustomerVehicle_ID = "TF_YardCustomerVehicle_ID";

	/** Set Yard Customer Vehicle	  */
	public void setTF_YardCustomerVehicle_ID (int TF_YardCustomerVehicle_ID);

	/** Get Yard Customer Vehicle	  */
	public int getTF_YardCustomerVehicle_ID();

	public I_TF_YardCustomerVehicle getTF_YardCustomerVehicle() throws RuntimeException;

    /** Column name TF_YardEntryApprove_ID */
    public static final String COLUMNNAME_TF_YardEntryApprove_ID = "TF_YardEntryApprove_ID";

	/** Set Approve Yard Entry	  */
	public void setTF_YardEntryApprove_ID (int TF_YardEntryApprove_ID);

	/** Get Approve Yard Entry	  */
	public int getTF_YardEntryApprove_ID();

	public I_TF_YardEntryApprove getTF_YardEntryApprove() throws RuntimeException;

    /** Column name TF_YardLoadEntry_ID */
    public static final String COLUMNNAME_TF_YardLoadEntry_ID = "TF_YardLoadEntry_ID";

	/** Set Yard Load Entry	  */
	public void setTF_YardLoadEntry_ID (int TF_YardLoadEntry_ID);

	/** Get Yard Load Entry	  */
	public int getTF_YardLoadEntry_ID();

    /** Column name TF_YardLoadEntry_UU */
    public static final String COLUMNNAME_TF_YardLoadEntry_UU = "TF_YardLoadEntry_UU";

	/** Set TF_YardLoadEntry_UU	  */
	public void setTF_YardLoadEntry_UU (String TF_YardLoadEntry_UU);

	/** Get TF_YardLoadEntry_UU	  */
	public String getTF_YardLoadEntry_UU();

    /** Column name Time */
    public static final String COLUMNNAME_Time = "Time";

	/** Set Time	  */
	public void setTime (String Time);

	/** Get Time	  */
	public String getTime();

    /** Column name Total_Bucket */
    public static final String COLUMNNAME_Total_Bucket = "Total_Bucket";

	/** Set Total Bucket	  */
	public void setTotal_Bucket (BigDecimal Total_Bucket);

	/** Get Total Bucket	  */
	public BigDecimal getTotal_Bucket();

    /** Column name TripNo */
    public static final String COLUMNNAME_TripNo = "TripNo";

	/** Set Trip No	  */
	public void setTripNo (BigDecimal TripNo);

	/** Get Trip No	  */
	public BigDecimal getTripNo();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name VehicleNo */
    public static final String COLUMNNAME_VehicleNo = "VehicleNo";

	/** Set Vehicle No	  */
	public void setVehicleNo (String VehicleNo);

	/** Get Vehicle No	  */
	public String getVehicleNo();
}
