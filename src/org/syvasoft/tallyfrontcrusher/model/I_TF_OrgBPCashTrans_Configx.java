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

/** Generated Interface for TF_OrgBPCashTrans_Configx
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_OrgBPCashTrans_Configx 
{

    /** TableName=TF_OrgBPCashTrans_Configx */
    public static final String Table_Name = "TF_OrgBPCashTrans_Configx";

    /** AD_Table_ID=1000243 */
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

    /** Column name C_DocType_ID */
    public static final String COLUMNNAME_C_DocType_ID = "C_DocType_ID";

	/** Set Document Type.
	  * Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID);

	/** Get Document Type.
	  * Document type or rules
	  */
	public int getC_DocType_ID();

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException;

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

    /** Column name Dest_Acct_ID */
    public static final String COLUMNNAME_Dest_Acct_ID = "Dest_Acct_ID";

	/** Set Destination Org Account	  */
	public void setDest_Acct_ID (int Dest_Acct_ID);

	/** Get Destination Org Account	  */
	public int getDest_Acct_ID();

	public org.compiere.model.I_C_ElementValue getDest_Acct() throws RuntimeException;

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

    /** Column name IsDefault */
    public static final String COLUMNNAME_IsDefault = "IsDefault";

	/** Set Default.
	  * Default value
	  */
	public void setIsDefault (boolean IsDefault);

	/** Get Default.
	  * Default value
	  */
	public boolean isDefault();

    /** Column name TF_OrgBPCashTrans_Configx_ID */
    public static final String COLUMNNAME_TF_OrgBPCashTrans_Configx_ID = "TF_OrgBPCashTrans_Configx_ID";

	/** Set Additional BP Cash Transfer in Destination Org	  */
	public void setTF_OrgBPCashTrans_Configx_ID (int TF_OrgBPCashTrans_Configx_ID);

	/** Get Additional BP Cash Transfer in Destination Org	  */
	public int getTF_OrgBPCashTrans_Configx_ID();

    /** Column name TF_OrgBPCashTrans_Configx_UU */
    public static final String COLUMNNAME_TF_OrgBPCashTrans_Configx_UU = "TF_OrgBPCashTrans_Configx_UU";

	/** Set TF_OrgBPCashTrans_Configx_UU	  */
	public void setTF_OrgBPCashTrans_Configx_UU (String TF_OrgBPCashTrans_Configx_UU);

	/** Get TF_OrgBPCashTrans_Configx_UU	  */
	public String getTF_OrgBPCashTrans_Configx_UU();

    /** Column name TF_OrgBPCashTransfer_Config_ID */
    public static final String COLUMNNAME_TF_OrgBPCashTransfer_Config_ID = "TF_OrgBPCashTransfer_Config_ID";

	/** Set Inter Organization BP Cash Transfer	  */
	public void setTF_OrgBPCashTransfer_Config_ID (int TF_OrgBPCashTransfer_Config_ID);

	/** Get Inter Organization BP Cash Transfer	  */
	public int getTF_OrgBPCashTransfer_Config_ID();

	public I_TF_OrgBPCashTransfer_Config getTF_OrgBPCashTransfer_Config() throws RuntimeException;

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
