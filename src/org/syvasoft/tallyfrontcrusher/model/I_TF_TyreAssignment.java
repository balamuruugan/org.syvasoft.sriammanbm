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

/** Generated Interface for TF_TyreAssignment
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_TyreAssignment 
{

    /** TableName=TF_TyreAssignment */
    public static final String Table_Name = "TF_TyreAssignment";

    /** AD_Table_ID=1000204 */
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

    /** Column name AD_MovementDate */
    public static final String COLUMNNAME_AD_MovementDate = "AD_MovementDate";

	/** Set Movement Date	  */
	public void setAD_MovementDate (Timestamp AD_MovementDate);

	/** Get Movement Date	  */
	public Timestamp getAD_MovementDate();

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

    /** Column name AD_Start_Meter */
    public static final String COLUMNNAME_AD_Start_Meter = "AD_Start_Meter";

	/** Set Assigned Start Meter	  */
	public void setAD_Start_Meter (BigDecimal AD_Start_Meter);

	/** Get Assigned Start Meter	  */
	public BigDecimal getAD_Start_Meter();

    /** Column name AD_TF_TyreMovement_ID */
    public static final String COLUMNNAME_AD_TF_TyreMovement_ID = "AD_TF_TyreMovement_ID";

	/** Set Assigned Tyre Movement	  */
	public void setAD_TF_TyreMovement_ID (int AD_TF_TyreMovement_ID);

	/** Get Assigned Tyre Movement	  */
	public int getAD_TF_TyreMovement_ID();

	public I_TF_TyreMovement getAD_TF_TyreMovement() throws RuntimeException;

    /** Column name AD_TF_TyrePosition_ID */
    public static final String COLUMNNAME_AD_TF_TyrePosition_ID = "AD_TF_TyrePosition_ID";

	/** Set To Tyre Position	  */
	public void setAD_TF_TyrePosition_ID (int AD_TF_TyrePosition_ID);

	/** Get To Tyre Position	  */
	public int getAD_TF_TyrePosition_ID();

	public I_TF_TyrePosition getAD_TF_TyrePosition() throws RuntimeException;

    /** Column name AD_To_Vehicle_ID */
    public static final String COLUMNNAME_AD_To_Vehicle_ID = "AD_To_Vehicle_ID";

	/** Set To Vehicle	  */
	public void setAD_To_Vehicle_ID (int AD_To_Vehicle_ID);

	/** Get To Vehicle	  */
	public int getAD_To_Vehicle_ID();

	public org.compiere.model.I_M_Product getAD_To_Vehicle() throws RuntimeException;

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

    /** Column name DocAction */
    public static final String COLUMNNAME_DocAction = "DocAction";

	/** Set Document Action.
	  * The targeted status of the document
	  */
	public void setDocAction (String DocAction);

	/** Get Document Action.
	  * The targeted status of the document
	  */
	public String getDocAction();

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

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

    /** Column name RD_AssignedDate */
    public static final String COLUMNNAME_RD_AssignedDate = "RD_AssignedDate";

	/** Set Assigned Date	  */
	public void setRD_AssignedDate (Timestamp RD_AssignedDate);

	/** Get Assigned Date	  */
	public Timestamp getRD_AssignedDate();

    /** Column name RD_End_Meter */
    public static final String COLUMNNAME_RD_End_Meter = "RD_End_Meter";

	/** Set End Meter	  */
	public void setRD_End_Meter (BigDecimal RD_End_Meter);

	/** Get End Meter	  */
	public BigDecimal getRD_End_Meter();

    /** Column name RD_From_Vehicle_ID */
    public static final String COLUMNNAME_RD_From_Vehicle_ID = "RD_From_Vehicle_ID";

	/** Set From Vehicle	  */
	public void setRD_From_Vehicle_ID (int RD_From_Vehicle_ID);

	/** Get From Vehicle	  */
	public int getRD_From_Vehicle_ID();

	public org.compiere.model.I_M_Product getRD_From_Vehicle() throws RuntimeException;

    /** Column name RD_ReleasedDate */
    public static final String COLUMNNAME_RD_ReleasedDate = "RD_ReleasedDate";

	/** Set Released Date	  */
	public void setRD_ReleasedDate (Timestamp RD_ReleasedDate);

	/** Get Released Date	  */
	public Timestamp getRD_ReleasedDate();

    /** Column name RD_Running_Meter */
    public static final String COLUMNNAME_RD_Running_Meter = "RD_Running_Meter";

	/** Set Running Meter	  */
	public void setRD_Running_Meter (BigDecimal RD_Running_Meter);

	/** Get Running Meter	  */
	public BigDecimal getRD_Running_Meter();

    /** Column name RD_Start_Meter */
    public static final String COLUMNNAME_RD_Start_Meter = "RD_Start_Meter";

	/** Set Assigned Start Meter	  */
	public void setRD_Start_Meter (BigDecimal RD_Start_Meter);

	/** Get Assigned Start Meter	  */
	public BigDecimal getRD_Start_Meter();

    /** Column name RD_TF_TyreMovement_ID */
    public static final String COLUMNNAME_RD_TF_TyreMovement_ID = "RD_TF_TyreMovement_ID";

	/** Set Release Tyre Movement	  */
	public void setRD_TF_TyreMovement_ID (int RD_TF_TyreMovement_ID);

	/** Get Release Tyre Movement	  */
	public int getRD_TF_TyreMovement_ID();

	public I_TF_TyreMovement getRD_TF_TyreMovement() throws RuntimeException;

    /** Column name RD_TF_TyrePosition_ID */
    public static final String COLUMNNAME_RD_TF_TyrePosition_ID = "RD_TF_TyrePosition_ID";

	/** Set From Tyre Position	  */
	public void setRD_TF_TyrePosition_ID (int RD_TF_TyrePosition_ID);

	/** Get From Tyre Position	  */
	public int getRD_TF_TyrePosition_ID();

	public I_TF_TyrePosition getRD_TF_TyrePosition() throws RuntimeException;

    /** Column name SendTo */
    public static final String COLUMNNAME_SendTo = "SendTo";

	/** Set Send To	  */
	public void setSendTo (String SendTo);

	/** Get Send To	  */
	public String getSendTo();

    /** Column name TF_Tyre_ID */
    public static final String COLUMNNAME_TF_Tyre_ID = "TF_Tyre_ID";

	/** Set Tyre	  */
	public void setTF_Tyre_ID (int TF_Tyre_ID);

	/** Get Tyre	  */
	public int getTF_Tyre_ID();

	public I_TF_Tyre getTF_Tyre() throws RuntimeException;

    /** Column name TF_Tyre_RBDelivery_ID */
    public static final String COLUMNNAME_TF_Tyre_RBDelivery_ID = "TF_Tyre_RBDelivery_ID";

	/** Set Tyre Rebutton Delivery	  */
	public void setTF_Tyre_RBDelivery_ID (int TF_Tyre_RBDelivery_ID);

	/** Get Tyre Rebutton Delivery	  */
	public int getTF_Tyre_RBDelivery_ID();

	public I_TF_Tyre_RBDelivery getTF_Tyre_RBDelivery() throws RuntimeException;

    /** Column name TF_TyreAssignment_ID */
    public static final String COLUMNNAME_TF_TyreAssignment_ID = "TF_TyreAssignment_ID";

	/** Set Tyre Assignment / Release	  */
	public void setTF_TyreAssignment_ID (int TF_TyreAssignment_ID);

	/** Get Tyre Assignment / Release	  */
	public int getTF_TyreAssignment_ID();

    /** Column name TF_TyreAssignment_UU */
    public static final String COLUMNNAME_TF_TyreAssignment_UU = "TF_TyreAssignment_UU";

	/** Set TF_TyreAssignment_UU	  */
	public void setTF_TyreAssignment_UU (String TF_TyreAssignment_UU);

	/** Get TF_TyreAssignment_UU	  */
	public String getTF_TyreAssignment_UU();

    /** Column name TF_TyreStatusChange_ID */
    public static final String COLUMNNAME_TF_TyreStatusChange_ID = "TF_TyreStatusChange_ID";

	/** Set Tyre Status Change	  */
	public void setTF_TyreStatusChange_ID (int TF_TyreStatusChange_ID);

	/** Get Tyre Status Change	  */
	public int getTF_TyreStatusChange_ID();

	public I_TF_TyreStatusChange getTF_TyreStatusChange() throws RuntimeException;

    /** Column name TF_TyreType_ID */
    public static final String COLUMNNAME_TF_TyreType_ID = "TF_TyreType_ID";

	/** Set Tyre Type	  */
	public void setTF_TyreType_ID (int TF_TyreType_ID);

	/** Get Tyre Type	  */
	public int getTF_TyreType_ID();

	public I_TF_TyreType getTF_TyreType() throws RuntimeException;

    /** Column name TyreAssignmentType */
    public static final String COLUMNNAME_TyreAssignmentType = "TyreAssignmentType";

	/** Set Tyre Assignment Type	  */
	public void setTyreAssignmentType (String TyreAssignmentType);

	/** Get Tyre Assignment Type	  */
	public String getTyreAssignmentType();

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
}
