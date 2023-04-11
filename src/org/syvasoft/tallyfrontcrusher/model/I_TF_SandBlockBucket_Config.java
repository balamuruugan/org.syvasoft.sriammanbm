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

/** Generated Interface for TF_SandBlockBucket_Config
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_SandBlockBucket_Config 
{

    /** TableName=TF_SandBlockBucket_Config */
    public static final String Table_Name = "TF_SandBlockBucket_Config";

    /** AD_Table_ID=1000229 */
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

    /** Column name M_Product_ID */
    public static final String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/** Set Product.
	  * Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID);

	/** Get Product.
	  * Product, Service, Item
	  */
	public int getM_Product_ID();

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException;

    /** Column name M_ProductPermitLedger_ID */
    public static final String COLUMNNAME_M_ProductPermitLedger_ID = "M_ProductPermitLedger_ID";

	/** Set Permit Ledger	  */
	public void setM_ProductPermitLedger_ID (int M_ProductPermitLedger_ID);

	/** Get Permit Ledger	  */
	public int getM_ProductPermitLedger_ID();

	public org.compiere.model.I_M_Product getM_ProductPermitLedger() throws RuntimeException;

    /** Column name PermitTonnagePerBucket */
    public static final String COLUMNNAME_PermitTonnagePerBucket = "PermitTonnagePerBucket";

	/** Set Permit Tonnage Per Bucket	  */
	public void setPermitTonnagePerBucket (BigDecimal PermitTonnagePerBucket);

	/** Get Permit Tonnage Per Bucket	  */
	public BigDecimal getPermitTonnagePerBucket();

    /** Column name SalesRatePerBucket */
    public static final String COLUMNNAME_SalesRatePerBucket = "SalesRatePerBucket";

	/** Set Sales Rate Per Bucket	  */
	public void setSalesRatePerBucket (BigDecimal SalesRatePerBucket);

	/** Get Sales Rate Per Bucket	  */
	public BigDecimal getSalesRatePerBucket();

    /** Column name SalesRatePerTon */
    public static final String COLUMNNAME_SalesRatePerTon = "SalesRatePerTon";

	/** Set Sales Rate Per Tonne	  */
	public void setSalesRatePerTon (BigDecimal SalesRatePerTon);

	/** Get Sales Rate Per Tonne	  */
	public BigDecimal getSalesRatePerTon();

    /** Column name SalesTonnagePerBucket */
    public static final String COLUMNNAME_SalesTonnagePerBucket = "SalesTonnagePerBucket";

	/** Set Sales Tonnage Per Bucket	  */
	public void setSalesTonnagePerBucket (BigDecimal SalesTonnagePerBucket);

	/** Get Sales Tonnage Per Bucket	  */
	public BigDecimal getSalesTonnagePerBucket();

    /** Column name SandType */
    public static final String COLUMNNAME_SandType = "SandType";

	/** Set Sand Type	  */
	public void setSandType (String SandType);

	/** Get Sand Type	  */
	public String getSandType();

    /** Column name TF_SandBlockBucket_Config_ID */
    public static final String COLUMNNAME_TF_SandBlockBucket_Config_ID = "TF_SandBlockBucket_Config_ID";

	/** Set Sand Block Bucket Configuration	  */
	public void setTF_SandBlockBucket_Config_ID (int TF_SandBlockBucket_Config_ID);

	/** Get Sand Block Bucket Configuration	  */
	public int getTF_SandBlockBucket_Config_ID();

    /** Column name TF_SandBlockBucket_Config_UU */
    public static final String COLUMNNAME_TF_SandBlockBucket_Config_UU = "TF_SandBlockBucket_Config_UU";

	/** Set TF_SandBlockBucket_Config_UU	  */
	public void setTF_SandBlockBucket_Config_UU (String TF_SandBlockBucket_Config_UU);

	/** Get TF_SandBlockBucket_Config_UU	  */
	public String getTF_SandBlockBucket_Config_UU();

    /** Column name TF_VehicleType_ID */
    public static final String COLUMNNAME_TF_VehicleType_ID = "TF_VehicleType_ID";

	/** Set Vehicle Type	  */
	public void setTF_VehicleType_ID (int TF_VehicleType_ID);

	/** Get Vehicle Type	  */
	public int getTF_VehicleType_ID();

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException;

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
