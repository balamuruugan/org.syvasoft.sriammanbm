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

/** Generated Interface for TF_Jobwork_IssuedResource
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_Jobwork_IssuedResource 
{

    /** TableName=TF_Jobwork_IssuedResource */
    public static final String Table_Name = "TF_Jobwork_IssuedResource";

    /** AD_Table_ID=1000193 */
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

    /** Column name C_Project_ID */
    public static final String COLUMNNAME_C_Project_ID = "C_Project_ID";

	/** Set Project.
	  * Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID);

	/** Get Project.
	  * Financial Project
	  */
	public int getC_Project_ID();

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException;

    /** Column name CloseDate */
    public static final String COLUMNNAME_CloseDate = "CloseDate";

	/** Set Close Date.
	  * Close Date
	  */
	public void setCloseDate (Timestamp CloseDate);

	/** Get Close Date.
	  * Close Date
	  */
	public Timestamp getCloseDate();

    /** Column name Contract_Amt_Act */
    public static final String COLUMNNAME_Contract_Amt_Act = "Contract_Amt_Act";

	/** Set Contract Amt (Actual)	  */
	public void setContract_Amt_Act (BigDecimal Contract_Amt_Act);

	/** Get Contract Amt (Actual)	  */
	public BigDecimal getContract_Amt_Act();

    /** Column name ContractBase */
    public static final String COLUMNNAME_ContractBase = "ContractBase";

	/** Set Contract Base.
	  * Represents how the contract amount will be calculated.
	  */
	public void setContractBase (String ContractBase);

	/** Get Contract Base.
	  * Represents how the contract amount will be calculated.
	  */
	public String getContractBase();

    /** Column name ContractStatus */
    public static final String COLUMNNAME_ContractStatus = "ContractStatus";

	/** Set Contract Status	  */
	public void setContractStatus (String ContractStatus);

	/** Get Contract Status	  */
	public String getContractStatus();

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

    /** Column name DeductedAmt */
    public static final String COLUMNNAME_DeductedAmt = "DeductedAmt";

	/** Set Deducted Amount	  */
	public void setDeductedAmt (BigDecimal DeductedAmt);

	/** Get Deducted Amount	  */
	public BigDecimal getDeductedAmt();

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

    /** Column name IsFuelIncluded */
    public static final String COLUMNNAME_IsFuelIncluded = "IsFuelIncluded";

	/** Set Fuel Included	  */
	public void setIsFuelIncluded (boolean IsFuelIncluded);

	/** Get Fuel Included	  */
	public boolean isFuelIncluded();

    /** Column name IsOperatorWageIncluded */
    public static final String COLUMNNAME_IsOperatorWageIncluded = "IsOperatorWageIncluded";

	/** Set Operator Wage Included	  */
	public void setIsOperatorWageIncluded (boolean IsOperatorWageIncluded);

	/** Get Operator Wage Included	  */
	public boolean isOperatorWageIncluded();

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

    /** Column name OperatorDeductedWage */
    public static final String COLUMNNAME_OperatorDeductedWage = "OperatorDeductedWage";

	/** Set Operator Deducted Wage	  */
	public void setOperatorDeductedWage (BigDecimal OperatorDeductedWage);

	/** Get Operator Deducted Wage	  */
	public BigDecimal getOperatorDeductedWage();

    /** Column name OperatorTotalWage */
    public static final String COLUMNNAME_OperatorTotalWage = "OperatorTotalWage";

	/** Set Total Wage	  */
	public void setOperatorTotalWage (BigDecimal OperatorTotalWage);

	/** Get Total Wage	  */
	public BigDecimal getOperatorTotalWage();

    /** Column name Qty */
    public static final String COLUMNNAME_Qty = "Qty";

	/** Set Quantity.
	  * Quantity
	  */
	public void setQty (BigDecimal Qty);

	/** Get Quantity.
	  * Quantity
	  */
	public BigDecimal getQty();

    /** Column name QtyDeducted */
    public static final String COLUMNNAME_QtyDeducted = "QtyDeducted";

	/** Set Quantity Deducted	  */
	public void setQtyDeducted (BigDecimal QtyDeducted);

	/** Get Quantity Deducted	  */
	public BigDecimal getQtyDeducted();

    /** Column name TF_Jobwork_IssuedResource_ID */
    public static final String COLUMNNAME_TF_Jobwork_IssuedResource_ID = "TF_Jobwork_IssuedResource_ID";

	/** Set Issued Vehicles / Resources	  */
	public void setTF_Jobwork_IssuedResource_ID (int TF_Jobwork_IssuedResource_ID);

	/** Get Issued Vehicles / Resources	  */
	public int getTF_Jobwork_IssuedResource_ID();

    /** Column name TF_Jobwork_IssuedResource_UU */
    public static final String COLUMNNAME_TF_Jobwork_IssuedResource_UU = "TF_Jobwork_IssuedResource_UU";

	/** Set TF_Jobwork_IssuedResource_UU	  */
	public void setTF_Jobwork_IssuedResource_UU (String TF_Jobwork_IssuedResource_UU);

	/** Get TF_Jobwork_IssuedResource_UU	  */
	public String getTF_Jobwork_IssuedResource_UU();

    /** Column name Unit_Price */
    public static final String COLUMNNAME_Unit_Price = "Unit_Price";

	/** Set Unit Price	  */
	public void setUnit_Price (BigDecimal Unit_Price);

	/** Get Unit Price	  */
	public BigDecimal getUnit_Price();

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

    /** Column name Wage_Charge_ID */
    public static final String COLUMNNAME_Wage_Charge_ID = "Wage_Charge_ID";

	/** Set Operator Wage Expense	  */
	public void setWage_Charge_ID (int Wage_Charge_ID);

	/** Get Operator Wage Expense	  */
	public int getWage_Charge_ID();

	public org.compiere.model.I_C_Charge getWage_Charge() throws RuntimeException;
}
