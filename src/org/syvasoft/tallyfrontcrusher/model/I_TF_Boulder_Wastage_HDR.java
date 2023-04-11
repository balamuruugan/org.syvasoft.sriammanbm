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

/** Generated Interface for TF_Boulder_Wastage_HDR
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_Boulder_Wastage_HDR 
{

    /** TableName=TF_Boulder_Wastage_HDR */
    public static final String Table_Name = "TF_Boulder_Wastage_HDR";

    /** AD_Table_ID=1000400 */
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

    /** Column name BS_Closing */
    public static final String COLUMNNAME_BS_Closing = "BS_Closing";

	/** Set Belt Scale Closing	  */
	public void setBS_Closing (BigDecimal BS_Closing);

	/** Get Belt Scale Closing	  */
	public BigDecimal getBS_Closing();

    /** Column name BS_Opening */
    public static final String COLUMNNAME_BS_Opening = "BS_Opening";

	/** Set Belt Scale Opening	  */
	public void setBS_Opening (BigDecimal BS_Opening);

	/** Get Belt Scale Opening	  */
	public BigDecimal getBS_Opening();

    /** Column name BS_Qty */
    public static final String COLUMNNAME_BS_Qty = "BS_Qty";

	/** Set Belt Scale Qty	  */
	public void setBS_Qty (BigDecimal BS_Qty);

	/** Get Belt Scale Qty	  */
	public BigDecimal getBS_Qty();

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

    /** Column name Crusher_Qty */
    public static final String COLUMNNAME_Crusher_Qty = "Crusher_Qty";

	/** Set Crushing Qty	  */
	public void setCrusher_Qty (BigDecimal Crusher_Qty);

	/** Get Crushing Qty	  */
	public BigDecimal getCrusher_Qty();

    /** Column name Crusher_Trip */
    public static final String COLUMNNAME_Crusher_Trip = "Crusher_Trip";

	/** Set Crushing Trip	  */
	public void setCrusher_Trip (int Crusher_Trip);

	/** Get Crushing Trip	  */
	public int getCrusher_Trip();

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

    /** Column name DocAction */
    public static final String COLUMNNAME_DocAction = "DocAction";

	/** Set Document Action.
	  * The targeted status of the document
	  */
	public void setDocAction (String DocAction);

	/** Get Document Action.
	  * The targeted status of the document
	  */
	public String getDocAction();

    /** Column name DocStatus */
    public static final String COLUMNNAME_DocStatus = "DocStatus";

	/** Set Document Status.
	  * The current status of the document
	  */
	public void setDocStatus (String DocStatus);

	/** Get Document Status.
	  * The current status of the document
	  */
	public String getDocStatus();

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

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

    /** Column name M_Warehouse_ID */
    public static final String COLUMNNAME_M_Warehouse_ID = "M_Warehouse_ID";

	/** Set Warehouse.
	  * Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID);

	/** Get Warehouse.
	  * Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID();

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException;

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

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

    /** Column name Scalping_Percent */
    public static final String COLUMNNAME_Scalping_Percent = "Scalping_Percent";

	/** Set Scalping Percentage	  */
	public void setScalping_Percent (BigDecimal Scalping_Percent);

	/** Get Scalping Percentage	  */
	public BigDecimal getScalping_Percent();

    /** Column name Scalping_Qty */
    public static final String COLUMNNAME_Scalping_Qty = "Scalping_Qty";

	/** Set Scalping Qty	  */
	public void setScalping_Qty (BigDecimal Scalping_Qty);

	/** Get Scalping Qty	  */
	public BigDecimal getScalping_Qty();

    /** Column name TF_Boulder_Wastage_HDR_ID */
    public static final String COLUMNNAME_TF_Boulder_Wastage_HDR_ID = "TF_Boulder_Wastage_HDR_ID";

	/** Set Boulder Wastage Header	  */
	public void setTF_Boulder_Wastage_HDR_ID (int TF_Boulder_Wastage_HDR_ID);

	/** Get Boulder Wastage Header	  */
	public int getTF_Boulder_Wastage_HDR_ID();

    /** Column name TF_Boulder_Wastage_HDR_UU */
    public static final String COLUMNNAME_TF_Boulder_Wastage_HDR_UU = "TF_Boulder_Wastage_HDR_UU";

	/** Set TF_Boulder_Wastage_HDR_UU	  */
	public void setTF_Boulder_Wastage_HDR_UU (String TF_Boulder_Wastage_HDR_UU);

	/** Get TF_Boulder_Wastage_HDR_UU	  */
	public String getTF_Boulder_Wastage_HDR_UU();

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
