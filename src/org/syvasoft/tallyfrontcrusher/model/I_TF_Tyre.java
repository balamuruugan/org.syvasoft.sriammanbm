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

/** Generated Interface for TF_Tyre
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_TF_Tyre 
{

    /** TableName=TF_Tyre */
    public static final String Table_Name = "TF_Tyre";

    /** AD_Table_ID=1000198 */
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

    /** Column name Brand */
    public static final String COLUMNNAME_Brand = "Brand";

	/** Set Brand	  */
	public void setBrand (String Brand);

	/** Get Brand	  */
	public String getBrand();

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

    /** Column name Current_TyreType_ID */
    public static final String COLUMNNAME_Current_TyreType_ID = "Current_TyreType_ID";

	/** Set Current Tyre Type	  */
	public void setCurrent_TyreType_ID (int Current_TyreType_ID);

	/** Get Current Tyre Type	  */
	public int getCurrent_TyreType_ID();

	public I_TF_TyreType getCurrent_TyreType() throws RuntimeException;

    /** Column name DatePurchased */
    public static final String COLUMNNAME_DatePurchased = "DatePurchased";

	/** Set Date Purchased	  */
	public void setDatePurchased (Timestamp DatePurchased);

	/** Get Date Purchased	  */
	public Timestamp getDatePurchased();

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

    /** Column name Mounted_To_ID */
    public static final String COLUMNNAME_Mounted_To_ID = "Mounted_To_ID";

	/** Set Mounted To	  */
	public void setMounted_To_ID (int Mounted_To_ID);

	/** Get Mounted To	  */
	public int getMounted_To_ID();

	public org.compiere.model.I_M_Product getMounted_To() throws RuntimeException;

    /** Column name Purchased_TyreType_ID */
    public static final String COLUMNNAME_Purchased_TyreType_ID = "Purchased_TyreType_ID";

	/** Set Purchased Tyre Type	  */
	public void setPurchased_TyreType_ID (int Purchased_TyreType_ID);

	/** Get Purchased Tyre Type	  */
	public int getPurchased_TyreType_ID();

	public I_TF_TyreType getPurchased_TyreType() throws RuntimeException;

    /** Column name Running_Meter */
    public static final String COLUMNNAME_Running_Meter = "Running_Meter";

	/** Set Running Meter	  */
	public void setRunning_Meter (BigDecimal Running_Meter);

	/** Get Running Meter	  */
	public BigDecimal getRunning_Meter();

    /** Column name SerNo */
    public static final String COLUMNNAME_SerNo = "SerNo";

	/** Set Serial No.
	  * Product Serial Number 
	  */
	public void setSerNo (String SerNo);

	/** Get Serial No.
	  * Product Serial Number 
	  */
	public String getSerNo();

    /** Column name Size */
    public static final String COLUMNNAME_Size = "Size";

	/** Set Size	  */
	public void setSize (String Size);

	/** Get Size	  */
	public String getSize();

    /** Column name TF_Tyre_ID */
    public static final String COLUMNNAME_TF_Tyre_ID = "TF_Tyre_ID";

	/** Set Tyre	  */
	public void setTF_Tyre_ID (int TF_Tyre_ID);

	/** Get Tyre	  */
	public int getTF_Tyre_ID();

    /** Column name TF_Tyre_UU */
    public static final String COLUMNNAME_TF_Tyre_UU = "TF_Tyre_UU";

	/** Set TF_Tyre_UU	  */
	public void setTF_Tyre_UU (String TF_Tyre_UU);

	/** Get TF_Tyre_UU	  */
	public String getTF_Tyre_UU();

    /** Column name TF_TyrePosition_ID */
    public static final String COLUMNNAME_TF_TyrePosition_ID = "TF_TyrePosition_ID";

	/** Set Tyre Position	  */
	public void setTF_TyrePosition_ID (int TF_TyrePosition_ID);

	/** Get Tyre Position	  */
	public int getTF_TyrePosition_ID();

	public I_TF_TyrePosition getTF_TyrePosition() throws RuntimeException;

    /** Column name TF_TyrePurchase_ID */
    public static final String COLUMNNAME_TF_TyrePurchase_ID = "TF_TyrePurchase_ID";

	/** Set Tyre Purchase	  */
	public void setTF_TyrePurchase_ID (int TF_TyrePurchase_ID);

	/** Get Tyre Purchase	  */
	public int getTF_TyrePurchase_ID();

	public I_TF_TyrePurchase getTF_TyrePurchase() throws RuntimeException;

    /** Column name TF_TyreStatus_ID */
    public static final String COLUMNNAME_TF_TyreStatus_ID = "TF_TyreStatus_ID";

	/** Set Tyre Status	  */
	public void setTF_TyreStatus_ID (int TF_TyreStatus_ID);

	/** Get Tyre Status	  */
	public int getTF_TyreStatus_ID();

	public I_TF_TyreStatus getTF_TyreStatus() throws RuntimeException;

    /** Column name TyreNo */
    public static final String COLUMNNAME_TyreNo = "TyreNo";

	/** Set Tyre No	  */
	public void setTyreNo (String TyreNo);

	/** Get Tyre No	  */
	public String getTyreNo();

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
