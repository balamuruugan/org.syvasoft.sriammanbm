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

/** Generated Interface for TF_OrgBPCashTransfer_Config
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_OrgBPCashTransfer_Config 
{

    /** TableName=TF_OrgBPCashTransfer_Config */
    public static final String Table_Name = "TF_OrgBPCashTransfer_Config";

    /** AD_Table_ID=1000242 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 2 - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(2);

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

    /** Column name Dest_BankAccount_ID */
    public static final String COLUMNNAME_Dest_BankAccount_ID = "Dest_BankAccount_ID";

	/** Set Destination Org Bank/Cash	  */
	public void setDest_BankAccount_ID (int Dest_BankAccount_ID);

	/** Get Destination Org Bank/Cash	  */
	public int getDest_BankAccount_ID();

	public org.compiere.model.I_C_BankAccount getDest_BankAccount() throws RuntimeException;

    /** Column name Dest_Org_ID */
    public static final String COLUMNNAME_Dest_Org_ID = "Dest_Org_ID";

	/** Set Destination Organization	  */
	public void setDest_Org_ID (int Dest_Org_ID);

	/** Get Destination Organization	  */
	public int getDest_Org_ID();

    /** Column name Dest_Partner_ID */
    public static final String COLUMNNAME_Dest_Partner_ID = "Dest_Partner_ID";

	/** Set Destination Org Business Partner	  */
	public void setDest_Partner_ID (int Dest_Partner_ID);

	/** Get Destination Org Business Partner	  */
	public int getDest_Partner_ID();

	public org.compiere.model.I_C_BPartner getDest_Partner() throws RuntimeException;

    /** Column name Dest_Project_ID */
    public static final String COLUMNNAME_Dest_Project_ID = "Dest_Project_ID";

	/** Set Destination Org Project	  */
	public void setDest_Project_ID (int Dest_Project_ID);

	/** Get Destination Org Project	  */
	public int getDest_Project_ID();

	public org.compiere.model.I_C_Project getDest_Project() throws RuntimeException;

    /** Column name Direction */
    public static final String COLUMNNAME_Direction = "Direction";

	/** Set Cash Transfer Direction	  */
	public void setDirection (String Direction);

	/** Get Cash Transfer Direction	  */
	public String getDirection();

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

    /** Column name RequiredApproval */
    public static final String COLUMNNAME_RequiredApproval = "RequiredApproval";

	/** Set Required Approval.
	  * Indicates that the transaction is required Approval
	  */
	public void setRequiredApproval (boolean RequiredApproval);

	/** Get Required Approval.
	  * Indicates that the transaction is required Approval
	  */
	public boolean isRequiredApproval();

    /** Column name Src_BankAccount_ID */
    public static final String COLUMNNAME_Src_BankAccount_ID = "Src_BankAccount_ID";

	/** Set Source Org Bank/Cash	  */
	public void setSrc_BankAccount_ID (int Src_BankAccount_ID);

	/** Get Source Org Bank/Cash	  */
	public int getSrc_BankAccount_ID();

	public org.compiere.model.I_C_BankAccount getSrc_BankAccount() throws RuntimeException;

    /** Column name Src_Org_ID */
    public static final String COLUMNNAME_Src_Org_ID = "Src_Org_ID";

	/** Set Source Organization	  */
	public void setSrc_Org_ID (int Src_Org_ID);

	/** Get Source Organization	  */
	public int getSrc_Org_ID();

    /** Column name Src_Partner_ID */
    public static final String COLUMNNAME_Src_Partner_ID = "Src_Partner_ID";

	/** Set Source Org Business Partner	  */
	public void setSrc_Partner_ID (int Src_Partner_ID);

	/** Get Source Org Business Partner	  */
	public int getSrc_Partner_ID();

	public org.compiere.model.I_C_BPartner getSrc_Partner() throws RuntimeException;

    /** Column name TF_OrgBPCashTransfer_Config_ID */
    public static final String COLUMNNAME_TF_OrgBPCashTransfer_Config_ID = "TF_OrgBPCashTransfer_Config_ID";

	/** Set Inter Organization BP Cash Transfer	  */
	public void setTF_OrgBPCashTransfer_Config_ID (int TF_OrgBPCashTransfer_Config_ID);

	/** Get Inter Organization BP Cash Transfer	  */
	public int getTF_OrgBPCashTransfer_Config_ID();

    /** Column name TF_OrgBPCashTransfer_Config_UU */
    public static final String COLUMNNAME_TF_OrgBPCashTransfer_Config_UU = "TF_OrgBPCashTransfer_Config_UU";

	/** Set TF_OrgBPCashTransfer_Config_UU	  */
	public void setTF_OrgBPCashTransfer_Config_UU (String TF_OrgBPCashTransfer_Config_UU);

	/** Get TF_OrgBPCashTransfer_Config_UU	  */
	public String getTF_OrgBPCashTransfer_Config_UU();

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
