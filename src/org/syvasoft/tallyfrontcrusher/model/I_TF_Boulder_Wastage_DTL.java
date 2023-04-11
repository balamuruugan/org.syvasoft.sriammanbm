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

/** Generated Interface for TF_Boulder_Wastage_DTL
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_Boulder_Wastage_DTL 
{

    /** TableName=TF_Boulder_Wastage_DTL */
    public static final String Table_Name = "TF_Boulder_Wastage_DTL";

    /** AD_Table_ID=1000401 */
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

    /** Column name AllowScalping_Percent */
    public static final String COLUMNNAME_AllowScalping_Percent = "AllowScalping_Percent";

	/** Set Allow Scalping Percentage	  */
	public void setAllowScalping_Percent (BigDecimal AllowScalping_Percent);

	/** Get Allow Scalping Percentage	  */
	public BigDecimal getAllowScalping_Percent();

    /** Column name AllowScalping_Qty */
    public static final String COLUMNNAME_AllowScalping_Qty = "AllowScalping_Qty";

	/** Set Allow Scalping Qty	  */
	public void setAllowScalping_Qty (BigDecimal AllowScalping_Qty);

	/** Get Allow Scalping Qty	  */
	public BigDecimal getAllowScalping_Qty();

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

    /** Column name C_Project_ID */
    public static final String COLUMNNAME_C_Project_ID = "C_Project_ID";

	/** Set Subcontract / Project.
	  * Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID);

	/** Get Subcontract / Project.
	  * Financial Project
	  */
	public int getC_Project_ID();

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException;

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

    /** Column name JobWork_Product_ID */
    public static final String COLUMNNAME_JobWork_Product_ID = "JobWork_Product_ID";

	/** Set Job Work	  */
	public void setJobWork_Product_ID (int JobWork_Product_ID);

	/** Get Job Work	  */
	public int getJobWork_Product_ID();

	public org.compiere.model.I_M_Product getJobWork_Product() throws RuntimeException;

    /** Column name M_InOut_ID */
    public static final String COLUMNNAME_M_InOut_ID = "M_InOut_ID";

	/** Set Shipment/Receipt.
	  * Material Shipment Document
	  */
	public void setM_InOut_ID (int M_InOut_ID);

	/** Get Shipment/Receipt.
	  * Material Shipment Document
	  */
	public int getM_InOut_ID();

	public org.compiere.model.I_M_InOut getM_InOut() throws RuntimeException;

    /** Column name NetQty */
    public static final String COLUMNNAME_NetQty = "NetQty";

	/** Set Net Qty	  */
	public void setNetQty (BigDecimal NetQty);

	/** Get Net Qty	  */
	public BigDecimal getNetQty();

    /** Column name NoTrips */
    public static final String COLUMNNAME_NoTrips = "NoTrips";

	/** Set No Trips	  */
	public void setNoTrips (int NoTrips);

	/** Get No Trips	  */
	public int getNoTrips();

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

    /** Column name QtyAdjustment */
    public static final String COLUMNNAME_QtyAdjustment = "QtyAdjustment";

	/** Set Adjustment Qty	  */
	public void setQtyAdjustment (BigDecimal QtyAdjustment);

	/** Get Adjustment Qty	  */
	public BigDecimal getQtyAdjustment();

    /** Column name Scalping_Qty */
    public static final String COLUMNNAME_Scalping_Qty = "Scalping_Qty";

	/** Set Scalping Qty	  */
	public void setScalping_Qty (BigDecimal Scalping_Qty);

	/** Get Scalping Qty	  */
	public BigDecimal getScalping_Qty();

    /** Column name TF_Boulder_Wastage_DTL_ID */
    public static final String COLUMNNAME_TF_Boulder_Wastage_DTL_ID = "TF_Boulder_Wastage_DTL_ID";

	/** Set Boulder Wastage Detail	  */
	public void setTF_Boulder_Wastage_DTL_ID (int TF_Boulder_Wastage_DTL_ID);

	/** Get Boulder Wastage Detail	  */
	public int getTF_Boulder_Wastage_DTL_ID();

    /** Column name TF_Boulder_Wastage_DTL_UU */
    public static final String COLUMNNAME_TF_Boulder_Wastage_DTL_UU = "TF_Boulder_Wastage_DTL_UU";

	/** Set TF_Boulder_Wastage_DTL_UU	  */
	public void setTF_Boulder_Wastage_DTL_UU (String TF_Boulder_Wastage_DTL_UU);

	/** Get TF_Boulder_Wastage_DTL_UU	  */
	public String getTF_Boulder_Wastage_DTL_UU();

    /** Column name TF_Boulder_Wastage_HDR_ID */
    public static final String COLUMNNAME_TF_Boulder_Wastage_HDR_ID = "TF_Boulder_Wastage_HDR_ID";

	/** Set Boulder Wastage Header	  */
	public void setTF_Boulder_Wastage_HDR_ID (int TF_Boulder_Wastage_HDR_ID);

	/** Get Boulder Wastage Header	  */
	public int getTF_Boulder_Wastage_HDR_ID();

	public I_TF_Boulder_Wastage_HDR getTF_Boulder_Wastage_HDR() throws RuntimeException;

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
