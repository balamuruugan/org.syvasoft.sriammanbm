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

/** Generated Interface for TF_VehicleTypeSalary
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_TF_VehicleTypeSalary 
{

    /** TableName=TF_VehicleTypeSalary */
    public static final String Table_Name = "TF_VehicleTypeSalary";

    /** AD_Table_ID=1000687 */
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

    /** Column name DateFrom */
    public static final String COLUMNNAME_DateFrom = "DateFrom";

	/** Set Date From.
	  * Starting date for a range
	  */
	public void setDateFrom (Timestamp DateFrom);

	/** Get Date From.
	  * Starting date for a range
	  */
	public Timestamp getDateFrom();

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

    /** Column name MaxKM */
    public static final String COLUMNNAME_MaxKM = "MaxKM";

	/** Set MaxKM	  */
	public void setMaxKM (int MaxKM);

	/** Get MaxKM	  */
	public int getMaxKM();

    /** Column name MinKM */
    public static final String COLUMNNAME_MinKM = "MinKM";

	/** Set MinKM	  */
	public void setMinKM (int MinKM);

	/** Get MinKM	  */
	public int getMinKM();

    /** Column name Std_Wage */
    public static final String COLUMNNAME_Std_Wage = "Std_Wage";

	/** Set Wage / day	  */
	public void setStd_Wage (BigDecimal Std_Wage);

	/** Get Wage / day	  */
	public BigDecimal getStd_Wage();

    /** Column name TF_VehicleType_ID */
    public static final String COLUMNNAME_TF_VehicleType_ID = "TF_VehicleType_ID";

	/** Set Vehicle Type	  */
	public void setTF_VehicleType_ID (int TF_VehicleType_ID);

	/** Get Vehicle Type	  */
	public int getTF_VehicleType_ID();

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException;

    /** Column name TF_VehicleTypeSalary_ID */
    public static final String COLUMNNAME_TF_VehicleTypeSalary_ID = "TF_VehicleTypeSalary_ID";

	/** Set Line Driver Salary Configuration	  */
	public void setTF_VehicleTypeSalary_ID (int TF_VehicleTypeSalary_ID);

	/** Get Line Driver Salary Configuration	  */
	public int getTF_VehicleTypeSalary_ID();

    /** Column name TF_VehicleTypeSalary_UU */
    public static final String COLUMNNAME_TF_VehicleTypeSalary_UU = "TF_VehicleTypeSalary_UU";

	/** Set TF_VehicleTypeSalary_UU	  */
	public void setTF_VehicleTypeSalary_UU (String TF_VehicleTypeSalary_UU);

	/** Get TF_VehicleTypeSalary_UU	  */
	public String getTF_VehicleTypeSalary_UU();

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
