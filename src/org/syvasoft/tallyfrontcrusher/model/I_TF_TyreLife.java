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

/** Generated Interface for TF_TyreLife
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_TF_TyreLife 
{

    /** TableName=TF_TyreLife */
    public static final String Table_Name = "TF_TyreLife";

    /** AD_Table_ID=1000199 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

    /** Load Meta Data */

    /** Column name ActRunning_Meter */
    public static final String COLUMNNAME_ActRunning_Meter = "ActRunning_Meter";

	/** Set Actual Running Meter	  */
	public void setActRunning_Meter (BigDecimal ActRunning_Meter);

	/** Get Actual Running Meter	  */
	public BigDecimal getActRunning_Meter();

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

    /** Column name EstRunning_Meter */
    public static final String COLUMNNAME_EstRunning_Meter = "EstRunning_Meter";

	/** Set Estimated Running Meter	  */
	public void setEstRunning_Meter (BigDecimal EstRunning_Meter);

	/** Get Estimated Running Meter	  */
	public BigDecimal getEstRunning_Meter();

    /** Column name ExpiryDate */
    public static final String COLUMNNAME_ExpiryDate = "ExpiryDate";

	/** Set Expiry Date	  */
	public void setExpiryDate (Timestamp ExpiryDate);

	/** Get Expiry Date	  */
	public Timestamp getExpiryDate();

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

    /** Column name Opening_Meter */
    public static final String COLUMNNAME_Opening_Meter = "Opening_Meter";

	/** Set Opening Meter	  */
	public void setOpening_Meter (BigDecimal Opening_Meter);

	/** Get Opening Meter	  */
	public BigDecimal getOpening_Meter();

    /** Column name OpeningDate */
    public static final String COLUMNNAME_OpeningDate = "OpeningDate";

	/** Set Opening Date	  */
	public void setOpeningDate (Timestamp OpeningDate);

	/** Get Opening Date	  */
	public Timestamp getOpeningDate();

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public int getSeqNo();

    /** Column name TF_Tyre_ID */
    public static final String COLUMNNAME_TF_Tyre_ID = "TF_Tyre_ID";

	/** Set Tyre	  */
	public void setTF_Tyre_ID (int TF_Tyre_ID);

	/** Get Tyre	  */
	public int getTF_Tyre_ID();

	public I_TF_Tyre getTF_Tyre() throws RuntimeException;

    /** Column name TF_Tyre_RBReceiptLine_ID */
    public static final String COLUMNNAME_TF_Tyre_RBReceiptLine_ID = "TF_Tyre_RBReceiptLine_ID";

	/** Set Received Rebutton Tyre	  */
	public void setTF_Tyre_RBReceiptLine_ID (int TF_Tyre_RBReceiptLine_ID);

	/** Get Received Rebutton Tyre	  */
	public int getTF_Tyre_RBReceiptLine_ID();

	public I_TF_Tyre_RBReceiptLine getTF_Tyre_RBReceiptLine() throws RuntimeException;

    /** Column name TF_TyreLife_ID */
    public static final String COLUMNNAME_TF_TyreLife_ID = "TF_TyreLife_ID";

	/** Set Tyre Life	  */
	public void setTF_TyreLife_ID (int TF_TyreLife_ID);

	/** Get Tyre Life	  */
	public int getTF_TyreLife_ID();

    /** Column name TF_TyreLife_UU */
    public static final String COLUMNNAME_TF_TyreLife_UU = "TF_TyreLife_UU";

	/** Set TF_TyreLife_UU	  */
	public void setTF_TyreLife_UU (String TF_TyreLife_UU);

	/** Get TF_TyreLife_UU	  */
	public String getTF_TyreLife_UU();

    /** Column name TF_TyrePurchase_ID */
    public static final String COLUMNNAME_TF_TyrePurchase_ID = "TF_TyrePurchase_ID";

	/** Set Tyre Purchase	  */
	public void setTF_TyrePurchase_ID (int TF_TyrePurchase_ID);

	/** Get Tyre Purchase	  */
	public int getTF_TyrePurchase_ID();

	public I_TF_TyrePurchase getTF_TyrePurchase() throws RuntimeException;

    /** Column name TF_TyrePurchaseLine_ID */
    public static final String COLUMNNAME_TF_TyrePurchaseLine_ID = "TF_TyrePurchaseLine_ID";

	/** Set Tyre Purchase Line	  */
	public void setTF_TyrePurchaseLine_ID (int TF_TyrePurchaseLine_ID);

	/** Get Tyre Purchase Line	  */
	public int getTF_TyrePurchaseLine_ID();

	public I_TF_TyrePurchaseLine getTF_TyrePurchaseLine() throws RuntimeException;

    /** Column name TF_TyreType_ID */
    public static final String COLUMNNAME_TF_TyreType_ID = "TF_TyreType_ID";

	/** Set Tyre Type	  */
	public void setTF_TyreType_ID (int TF_TyreType_ID);

	/** Get Tyre Type	  */
	public int getTF_TyreType_ID();

	public I_TF_TyreType getTF_TyreType() throws RuntimeException;

    /** Column name TyreCost */
    public static final String COLUMNNAME_TyreCost = "TyreCost";

	/** Set Tyre Cost	  */
	public void setTyreCost (BigDecimal TyreCost);

	/** Get Tyre Cost	  */
	public BigDecimal getTyreCost();

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
