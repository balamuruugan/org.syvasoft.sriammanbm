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

/** Generated Interface for TF_Jobwork_ResRentEntry
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_Jobwork_ResRentEntry 
{

    /** TableName=TF_Jobwork_ResRentEntry */
    public static final String Table_Name = "TF_Jobwork_ResRentEntry";

    /** AD_Table_ID=1000205 */
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

    /** Column name Subcon_Invoice_ID */
    public static final String COLUMNNAME_Subcon_Invoice_ID = "Subcon_Invoice_ID";

	/** Set Subcontractor Invoice	  */
	public void setSubcon_Invoice_ID (int Subcon_Invoice_ID);

	/** Get Subcontractor Invoice	  */
	public int getSubcon_Invoice_ID();

	public org.compiere.model.I_C_Invoice getSubcon_Invoice() throws RuntimeException;

    /** Column name TF_Jobwork_IssuedResource_ID */
    public static final String COLUMNNAME_TF_Jobwork_IssuedResource_ID = "TF_Jobwork_IssuedResource_ID";

	/** Set Issued Vehicles / Resources	  */
	public void setTF_Jobwork_IssuedResource_ID (int TF_Jobwork_IssuedResource_ID);

	/** Get Issued Vehicles / Resources	  */
	public int getTF_Jobwork_IssuedResource_ID();

	public I_TF_Jobwork_IssuedResource getTF_Jobwork_IssuedResource() throws RuntimeException;

    /** Column name TF_Jobwork_ResRentEntry_ID */
    public static final String COLUMNNAME_TF_Jobwork_ResRentEntry_ID = "TF_Jobwork_ResRentEntry_ID";

	/** Set Rent Entry	  */
	public void setTF_Jobwork_ResRentEntry_ID (int TF_Jobwork_ResRentEntry_ID);

	/** Get Rent Entry	  */
	public int getTF_Jobwork_ResRentEntry_ID();

    /** Column name TF_Jobwork_ResRentEntry_UU */
    public static final String COLUMNNAME_TF_Jobwork_ResRentEntry_UU = "TF_Jobwork_ResRentEntry_UU";

	/** Set TF_Jobwork_ResRentEntry_UU	  */
	public void setTF_Jobwork_ResRentEntry_UU (String TF_Jobwork_ResRentEntry_UU);

	/** Get TF_Jobwork_ResRentEntry_UU	  */
	public String getTF_Jobwork_ResRentEntry_UU();

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
}
