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

/** Generated Interface for TF_TyreStatusChange
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_TF_TyreStatusChange 
{

    /** TableName=TF_TyreStatusChange */
    public static final String Table_Name = "TF_TyreStatusChange";

    /** AD_Table_ID=1000206 */
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

    /** Column name ChangeTyreType */
    public static final String COLUMNNAME_ChangeTyreType = "ChangeTyreType";

	/** Set Change Tyre Type	  */
	public void setChangeTyreType (boolean ChangeTyreType);

	/** Get Change Tyre Type	  */
	public boolean isChangeTyreType();

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

    /** Column name Curr_TF_TyreStatus_ID */
    public static final String COLUMNNAME_Curr_TF_TyreStatus_ID = "Curr_TF_TyreStatus_ID";

	/** Set Current Tyre Status	  */
	public void setCurr_TF_TyreStatus_ID (int Curr_TF_TyreStatus_ID);

	/** Get Current Tyre Status	  */
	public int getCurr_TF_TyreStatus_ID();

	public I_TF_TyreStatus getCurr_TF_TyreStatus() throws RuntimeException;

    /** Column name Curr_TF_TyreType_ID */
    public static final String COLUMNNAME_Curr_TF_TyreType_ID = "Curr_TF_TyreType_ID";

	/** Set Current Tyre Type	  */
	public void setCurr_TF_TyreType_ID (int Curr_TF_TyreType_ID);

	/** Get Current Tyre Type	  */
	public int getCurr_TF_TyreType_ID();

	public I_TF_TyreType getCurr_TF_TyreType() throws RuntimeException;

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

    /** Column name New_TF_TyreStatus_ID */
    public static final String COLUMNNAME_New_TF_TyreStatus_ID = "New_TF_TyreStatus_ID";

	/** Set New Tyre Status	  */
	public void setNew_TF_TyreStatus_ID (int New_TF_TyreStatus_ID);

	/** Get New Tyre Status	  */
	public int getNew_TF_TyreStatus_ID();

	public I_TF_TyreStatus getNew_TF_TyreStatus() throws RuntimeException;

    /** Column name New_TF_TyreType_ID */
    public static final String COLUMNNAME_New_TF_TyreType_ID = "New_TF_TyreType_ID";

	/** Set New Tyre Type	  */
	public void setNew_TF_TyreType_ID (int New_TF_TyreType_ID);

	/** Get New Tyre Type	  */
	public int getNew_TF_TyreType_ID();

	public I_TF_TyreType getNew_TF_TyreType() throws RuntimeException;

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

    /** Column name Reason */
    public static final String COLUMNNAME_Reason = "Reason";

	/** Set Reason for Change	  */
	public void setReason (String Reason);

	/** Get Reason for Change	  */
	public String getReason();

    /** Column name TF_Tyre_ID */
    public static final String COLUMNNAME_TF_Tyre_ID = "TF_Tyre_ID";

	/** Set Tyre	  */
	public void setTF_Tyre_ID (int TF_Tyre_ID);

	/** Get Tyre	  */
	public int getTF_Tyre_ID();

	public I_TF_Tyre getTF_Tyre() throws RuntimeException;

    /** Column name TF_TyreStatusChange_ID */
    public static final String COLUMNNAME_TF_TyreStatusChange_ID = "TF_TyreStatusChange_ID";

	/** Set Tyre Status Change	  */
	public void setTF_TyreStatusChange_ID (int TF_TyreStatusChange_ID);

	/** Get Tyre Status Change	  */
	public int getTF_TyreStatusChange_ID();

    /** Column name TF_TyreStatusChange_UU */
    public static final String COLUMNNAME_TF_TyreStatusChange_UU = "TF_TyreStatusChange_UU";

	/** Set TF_TyreStatusChange_UU	  */
	public void setTF_TyreStatusChange_UU (String TF_TyreStatusChange_UU);

	/** Get TF_TyreStatusChange_UU	  */
	public String getTF_TyreStatusChange_UU();

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
