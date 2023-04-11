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

/** Generated Interface for TF_YardEntryApproveLine
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_YardEntryApproveLine 
{

    /** TableName=TF_YardEntryApproveLine */
    public static final String Table_Name = "TF_YardEntryApproveLine";

    /** AD_Table_ID=1000251 */
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

    /** Column name Bucket_Discount */
    public static final String COLUMNNAME_Bucket_Discount = "Bucket_Discount";

	/** Set Buckets Discounted	  */
	public void setBucket_Discount (BigDecimal Bucket_Discount);

	/** Get Buckets Discounted	  */
	public BigDecimal getBucket_Discount();

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

    /** Column name DiscountAmt */
    public static final String COLUMNNAME_DiscountAmt = "DiscountAmt";

	/** Set Discount Amount.
	  * Calculated amount of discount
	  */
	public void setDiscountAmt (BigDecimal DiscountAmt);

	/** Get Discount Amount.
	  * Calculated amount of discount
	  */
	public BigDecimal getDiscountAmt();

    /** Column name ExtraBucketAmount */
    public static final String COLUMNNAME_ExtraBucketAmount = "ExtraBucketAmount";

	/** Set Extra Bucket Amount	  */
	public void setExtraBucketAmount (BigDecimal ExtraBucketAmount);

	/** Get Extra Bucket Amount	  */
	public BigDecimal getExtraBucketAmount();

    /** Column name ExtraBucketPrice */
    public static final String COLUMNNAME_ExtraBucketPrice = "ExtraBucketPrice";

	/** Set Extra Bucket Price	  */
	public void setExtraBucketPrice (BigDecimal ExtraBucketPrice);

	/** Get Extra Bucket Price	  */
	public BigDecimal getExtraBucketPrice();

    /** Column name ExtraBucketQty */
    public static final String COLUMNNAME_ExtraBucketQty = "ExtraBucketQty";

	/** Set Extra Bucket Qty	  */
	public void setExtraBucketQty (BigDecimal ExtraBucketQty);

	/** Get Extra Bucket Qty	  */
	public BigDecimal getExtraBucketQty();

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

    /** Column name PermitAmount */
    public static final String COLUMNNAME_PermitAmount = "PermitAmount";

	/** Set Permit Amount	  */
	public void setPermitAmount (BigDecimal PermitAmount);

	/** Get Permit Amount	  */
	public BigDecimal getPermitAmount();

    /** Column name PermitCancelledQty */
    public static final String COLUMNNAME_PermitCancelledQty = "PermitCancelledQty";

	/** Set Permit Cancelled Qty	  */
	public void setPermitCancelledQty (BigDecimal PermitCancelledQty);

	/** Get Permit Cancelled Qty	  */
	public BigDecimal getPermitCancelledQty();

    /** Column name PermitIssuedQty */
    public static final String COLUMNNAME_PermitIssuedQty = "PermitIssuedQty";

	/** Set Permit Issued Qty	  */
	public void setPermitIssuedQty (BigDecimal PermitIssuedQty);

	/** Get Permit Issued Qty	  */
	public BigDecimal getPermitIssuedQty();

    /** Column name PermitPrice */
    public static final String COLUMNNAME_PermitPrice = "PermitPrice";

	/** Set Permit Price	  */
	public void setPermitPrice (BigDecimal PermitPrice);

	/** Get Permit Price	  */
	public BigDecimal getPermitPrice();

    /** Column name PermitSalesQty */
    public static final String COLUMNNAME_PermitSalesQty = "PermitSalesQty";

	/** Set Permit Sales Qty	  */
	public void setPermitSalesQty (BigDecimal PermitSalesQty);

	/** Get Permit Sales Qty	  */
	public BigDecimal getPermitSalesQty();

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

    /** Column name TF_VehicleType_ID */
    public static final String COLUMNNAME_TF_VehicleType_ID = "TF_VehicleType_ID";

	/** Set Vehicle Type	  */
	public void setTF_VehicleType_ID (int TF_VehicleType_ID);

	/** Get Vehicle Type	  */
	public int getTF_VehicleType_ID();

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException;

    /** Column name TF_YardEntry_ID */
    public static final String COLUMNNAME_TF_YardEntry_ID = "TF_YardEntry_ID";

	/** Set Yard Entry	  */
	public void setTF_YardEntry_ID (int TF_YardEntry_ID);

	/** Get Yard Entry	  */
	public int getTF_YardEntry_ID();

	public I_TF_YardEntry getTF_YardEntry() throws RuntimeException;

    /** Column name TF_YardEntryApprove_ID */
    public static final String COLUMNNAME_TF_YardEntryApprove_ID = "TF_YardEntryApprove_ID";

	/** Set Approve Yard Entry	  */
	public void setTF_YardEntryApprove_ID (int TF_YardEntryApprove_ID);

	/** Get Approve Yard Entry	  */
	public int getTF_YardEntryApprove_ID();

	public I_TF_YardEntryApprove getTF_YardEntryApprove() throws RuntimeException;

    /** Column name TF_YardEntryApproveLine_ID */
    public static final String COLUMNNAME_TF_YardEntryApproveLine_ID = "TF_YardEntryApproveLine_ID";

	/** Set Yard Entry Generated	  */
	public void setTF_YardEntryApproveLine_ID (int TF_YardEntryApproveLine_ID);

	/** Get Yard Entry Generated	  */
	public int getTF_YardEntryApproveLine_ID();

    /** Column name TF_YardEntryApproveLine_UU */
    public static final String COLUMNNAME_TF_YardEntryApproveLine_UU = "TF_YardEntryApproveLine_UU";

	/** Set TF_YardEntryApproveLine_UU	  */
	public void setTF_YardEntryApproveLine_UU (String TF_YardEntryApproveLine_UU);

	/** Get TF_YardEntryApproveLine_UU	  */
	public String getTF_YardEntryApproveLine_UU();

    /** Column name TotalLoad */
    public static final String COLUMNNAME_TotalLoad = "TotalLoad";

	/** Set Total Load	  */
	public void setTotalLoad (BigDecimal TotalLoad);

	/** Get Total Load	  */
	public BigDecimal getTotalLoad();

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

    /** Column name WPAmount */
    public static final String COLUMNNAME_WPAmount = "WPAmount";

	/** Set W/P Amount	  */
	public void setWPAmount (BigDecimal WPAmount);

	/** Get W/P Amount	  */
	public BigDecimal getWPAmount();

    /** Column name WpPrice */
    public static final String COLUMNNAME_WpPrice = "WpPrice";

	/** Set W/P Price	  */
	public void setWpPrice (BigDecimal WpPrice);

	/** Get W/P Price	  */
	public BigDecimal getWpPrice();

    /** Column name WPQty */
    public static final String COLUMNNAME_WPQty = "WPQty";

	/** Set W/P Qty	  */
	public void setWPQty (BigDecimal WPQty);

	/** Get W/P Qty	  */
	public BigDecimal getWPQty();
}
