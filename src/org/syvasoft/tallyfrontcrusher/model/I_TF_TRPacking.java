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

/** Generated Interface for TF_TRPacking
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_TRPacking 
{

    /** TableName=TF_TRPacking */
    public static final String Table_Name = "TF_TRPacking";

    /** AD_Table_ID=1000298 */
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

    /** Column name BagType */
    public static final String COLUMNNAME_BagType = "BagType";

	/** Set Bag Type	  */
	public void setBagType (String BagType);

	/** Get Bag Type	  */
	public String getBagType();

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

    /** Column name KgPerBag */
    public static final String COLUMNNAME_KgPerBag = "KgPerBag";

	/** Set Kg / Bag	  */
	public void setKgPerBag (BigDecimal KgPerBag);

	/** Get Kg / Bag	  */
	public BigDecimal getKgPerBag();

    /** Column name Line */
    public static final String COLUMNNAME_Line = "Line";

	/** Set Line No.
	  * Unique line for this document
	  */
	public void setLine (int Line);

	/** Get Line No.
	  * Unique line for this document
	  */
	public int getLine();

    /** Column name QtyBag */
    public static final String COLUMNNAME_QtyBag = "QtyBag";

	/** Set Bag Qty	  */
	public void setQtyBag (BigDecimal QtyBag);

	/** Get Bag Qty	  */
	public BigDecimal getQtyBag();

    /** Column name TF_TRPacking_ID */
    public static final String COLUMNNAME_TF_TRPacking_ID = "TF_TRPacking_ID";

	/** Set Packing Detail	  */
	public void setTF_TRPacking_ID (int TF_TRPacking_ID);

	/** Get Packing Detail	  */
	public int getTF_TRPacking_ID();

    /** Column name TF_TRPacking_UU */
    public static final String COLUMNNAME_TF_TRPacking_UU = "TF_TRPacking_UU";

	/** Set TF_TRPacking_UU	  */
	public void setTF_TRPacking_UU (String TF_TRPacking_UU);

	/** Get TF_TRPacking_UU	  */
	public String getTF_TRPacking_UU();

    /** Column name TF_TRTaxInvoice_ID */
    public static final String COLUMNNAME_TF_TRTaxInvoice_ID = "TF_TRTaxInvoice_ID";

	/** Set Sales Tax Invoice (Trading)	  */
	public void setTF_TRTaxInvoice_ID (int TF_TRTaxInvoice_ID);

	/** Get Sales Tax Invoice (Trading)	  */
	public int getTF_TRTaxInvoice_ID();

	public I_TF_TRTaxInvoice getTF_TRTaxInvoice() throws RuntimeException;

    /** Column name TotalKg */
    public static final String COLUMNNAME_TotalKg = "TotalKg";

	/** Set Total Kg	  */
	public void setTotalKg (BigDecimal TotalKg);

	/** Get Total Kg	  */
	public BigDecimal getTotalKg();

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
