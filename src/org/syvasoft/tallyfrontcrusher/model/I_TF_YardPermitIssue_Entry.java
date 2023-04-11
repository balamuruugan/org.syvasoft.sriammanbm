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

/** Generated Interface for TF_YardPermitIssue_Entry
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_YardPermitIssue_Entry 
{

    /** TableName=TF_YardPermitIssue_Entry */
    public static final String Table_Name = "TF_YardPermitIssue_Entry";

    /** AD_Table_ID=1000247 */
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

    /** Column name BucketQty */
    public static final String COLUMNNAME_BucketQty = "BucketQty";

	/** Set Bucket Qty	  */
	public void setBucketQty (BigDecimal BucketQty);

	/** Get Bucket Qty	  */
	public BigDecimal getBucketQty();

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

    /** Column name MDPNo */
    public static final String COLUMNNAME_MDPNo = "MDPNo";

	/** Set MDP No	  */
	public void setMDPNo (String MDPNo);

	/** Get MDP No	  */
	public String getMDPNo();

    /** Column name PermitIssue_Type */
    public static final String COLUMNNAME_PermitIssue_Type = "PermitIssue_Type";

	/** Set Permit Issue Type	  */
	public void setPermitIssue_Type (String PermitIssue_Type);

	/** Get Permit Issue Type	  */
	public String getPermitIssue_Type();

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

	/** Set Process Permit Issue Entry	  */
	public void setProcessing (boolean Processing);

	/** Get Process Permit Issue Entry	  */
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

    /** Column name TF_YardPermitIssue_Entry_ID */
    public static final String COLUMNNAME_TF_YardPermitIssue_Entry_ID = "TF_YardPermitIssue_Entry_ID";

	/** Set Yard Permit Issue Entry	  */
	public void setTF_YardPermitIssue_Entry_ID (int TF_YardPermitIssue_Entry_ID);

	/** Get Yard Permit Issue Entry	  */
	public int getTF_YardPermitIssue_Entry_ID();

    /** Column name TF_YardPermitIssue_Entry_UU */
    public static final String COLUMNNAME_TF_YardPermitIssue_Entry_UU = "TF_YardPermitIssue_Entry_UU";

	/** Set TF_YardPermitIssue_Entry_UU	  */
	public void setTF_YardPermitIssue_Entry_UU (String TF_YardPermitIssue_Entry_UU);

	/** Get TF_YardPermitIssue_Entry_UU	  */
	public String getTF_YardPermitIssue_Entry_UU();

    /** Column name Time */
    public static final String COLUMNNAME_Time = "Time";

	/** Set Time	  */
	public void setTime (String Time);

	/** Get Time	  */
	public String getTime();

    /** Column name Tonnage */
    public static final String COLUMNNAME_Tonnage = "Tonnage";

	/** Set Tonnage	  */
	public void setTonnage (BigDecimal Tonnage);

	/** Get Tonnage	  */
	public BigDecimal getTonnage();

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
