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

/** Generated Interface for TF_CrusherProduction_Config
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_CrusherProduction_Config 
{

    /** TableName=TF_CrusherProduction_Config */
    public static final String Table_Name = "TF_CrusherProduction_Config";

    /** AD_Table_ID=1000178 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

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

    /** Column name Percent */
    public static final String COLUMNNAME_Percent = "Percent";

	/** Set Percent.
	  * Percentage
	  */
	public void setPercent (BigDecimal Percent);

	/** Get Percent.
	  * Percentage
	  */
	public BigDecimal getPercent();

    /** Column name Production_Formula */
    public static final String COLUMNNAME_Production_Formula = "Production_Formula";

	/** Set Production Formula	  */
	public void setProduction_Formula (BigDecimal Production_Formula);

	/** Get Production Formula	  */
	public BigDecimal getProduction_Formula();

    /** Column name RM_Product_ID */
    public static final String COLUMNNAME_RM_Product_ID = "RM_Product_ID";

	/** Set Raw Material	  */
	public void setRM_Product_ID (int RM_Product_ID);

	/** Get Raw Material	  */
	public int getRM_Product_ID();

	public org.compiere.model.I_M_Product getRM_Product() throws RuntimeException;

    /** Column name TF_BlueMetal_Type */
    public static final String COLUMNNAME_TF_BlueMetal_Type = "TF_BlueMetal_Type";

	/** Set Blue Metal Type	  */
	public void setTF_BlueMetal_Type (String TF_BlueMetal_Type);

	/** Get Blue Metal Type	  */
	public String getTF_BlueMetal_Type();

    /** Column name TF_CrusherProduction_Config_ID */
    public static final String COLUMNNAME_TF_CrusherProduction_Config_ID = "TF_CrusherProduction_Config_ID";

	/** Set Crusher Production Configuration	  */
	public void setTF_CrusherProduction_Config_ID (int TF_CrusherProduction_Config_ID);

	/** Get Crusher Production Configuration	  */
	public int getTF_CrusherProduction_Config_ID();

    /** Column name TF_CrusherProduction_Config_UU */
    public static final String COLUMNNAME_TF_CrusherProduction_Config_UU = "TF_CrusherProduction_Config_UU";

	/** Set TF_CrusherProduction_Config_UU	  */
	public void setTF_CrusherProduction_Config_UU (String TF_CrusherProduction_Config_UU);

	/** Get TF_CrusherProduction_Config_UU	  */
	public String getTF_CrusherProduction_Config_UU();

    /** Column name TF_ProductionPlant_ID */
    public static final String COLUMNNAME_TF_ProductionPlant_ID = "TF_ProductionPlant_ID";

	/** Set TF_ProductionPlant	  */
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID);

	/** Get TF_ProductionPlant	  */
	public int getTF_ProductionPlant_ID();

	public I_TF_ProductionPlant getTF_ProductionPlant() throws RuntimeException;

    /** Column name Unit_Divisor */
    public static final String COLUMNNAME_Unit_Divisor = "Unit_Divisor";

	/** Set Unit Divisor	  */
	public void setUnit_Divisor (BigDecimal Unit_Divisor);

	/** Get Unit Divisor	  */
	public BigDecimal getUnit_Divisor();

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
