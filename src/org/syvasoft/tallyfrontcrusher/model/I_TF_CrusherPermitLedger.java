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

/** Generated Interface for TF_CrusherPermitLedger
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_CrusherPermitLedger 
{

    /** TableName=TF_CrusherPermitLedger */
    public static final String Table_Name = "TF_CrusherPermitLedger";

    /** AD_Table_ID=1000261 */
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

    /** Column name PurchasedAmt */
    public static final String COLUMNNAME_PurchasedAmt = "PurchasedAmt";

	/** Set Purchased Amount	  */
	public void setPurchasedAmt (BigDecimal PurchasedAmt);

	/** Get Purchased Amount	  */
	public BigDecimal getPurchasedAmt();

    /** Column name QtyIssued */
    public static final String COLUMNNAME_QtyIssued = "QtyIssued";

	/** Set Quantity Issued	  */
	public void setQtyIssued (BigDecimal QtyIssued);

	/** Get Quantity Issued	  */
	public BigDecimal getQtyIssued();

    /** Column name QtyPurchased */
    public static final String COLUMNNAME_QtyPurchased = "QtyPurchased";

	/** Set Qty Purchased	  */
	public void setQtyPurchased (BigDecimal QtyPurchased);

	/** Get Qty Purchased	  */
	public BigDecimal getQtyPurchased();

    /** Column name TF_CrusherPermitLedger_ID */
    public static final String COLUMNNAME_TF_CrusherPermitLedger_ID = "TF_CrusherPermitLedger_ID";

	/** Set Crusher Permit Ledger	  */
	public void setTF_CrusherPermitLedger_ID (int TF_CrusherPermitLedger_ID);

	/** Get Crusher Permit Ledger	  */
	public int getTF_CrusherPermitLedger_ID();

    /** Column name TF_CrusherPermitLedger_UU */
    public static final String COLUMNNAME_TF_CrusherPermitLedger_UU = "TF_CrusherPermitLedger_UU";

	/** Set TF_CrusherPermitLedger_UU	  */
	public void setTF_CrusherPermitLedger_UU (String TF_CrusherPermitLedger_UU);

	/** Get TF_CrusherPermitLedger_UU	  */
	public String getTF_CrusherPermitLedger_UU();

    /** Column name TF_PermitPurchase_ID */
    public static final String COLUMNNAME_TF_PermitPurchase_ID = "TF_PermitPurchase_ID";

	/** Set Permit Purchase Entry	  */
	public void setTF_PermitPurchase_ID (int TF_PermitPurchase_ID);

	/** Get Permit Purchase Entry	  */
	public int getTF_PermitPurchase_ID();

	public I_TF_PermitPurchase getTF_PermitPurchase() throws RuntimeException;

    /** Column name TF_PermitPurchaseLine_ID */
    public static final String COLUMNNAME_TF_PermitPurchaseLine_ID = "TF_PermitPurchaseLine_ID";

	/** Set Permit Purchase Line	  */
	public void setTF_PermitPurchaseLine_ID (int TF_PermitPurchaseLine_ID);

	/** Get Permit Purchase Line	  */
	public int getTF_PermitPurchaseLine_ID();

	public I_TF_PermitPurchaseLine getTF_PermitPurchaseLine() throws RuntimeException;

    /** Column name TF_Quarry_ID */
    public static final String COLUMNNAME_TF_Quarry_ID = "TF_Quarry_ID";

	/** Set Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID);

	/** Get Quarry	  */
	public int getTF_Quarry_ID();

	public I_TF_Quarry getTF_Quarry() throws RuntimeException;

    /** Column name UnitPrice */
    public static final String COLUMNNAME_UnitPrice = "UnitPrice";

	/** Set Unit Price	  */
	public void setUnitPrice (BigDecimal UnitPrice);

	/** Get Unit Price	  */
	public BigDecimal getUnitPrice();

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
