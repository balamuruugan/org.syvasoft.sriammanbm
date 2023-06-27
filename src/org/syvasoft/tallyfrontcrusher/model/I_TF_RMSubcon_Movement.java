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

/** Generated Interface for TF_RMSubcon_Movement
 *  @author iDempiere (generated) 
 *  @version Release 10
 */
@SuppressWarnings("all")
public interface I_TF_RMSubcon_Movement 
{

    /** TableName=TF_RMSubcon_Movement */
    public static final String Table_Name = "TF_RMSubcon_Movement";

    /** AD_Table_ID=1000228 */
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

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner.
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner.
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_Invoice_ID */
    public static final String COLUMNNAME_C_Invoice_ID = "C_Invoice_ID";

	/** Set Invoice.
	  * Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID);

	/** Get Invoice.
	  * Invoice Identifier
	  */
	public int getC_Invoice_ID();

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException;

    /** Column name C_Order_ID */
    public static final String COLUMNNAME_C_Order_ID = "C_Order_ID";

	/** Set Order.
	  * Order
	  */
	public void setC_Order_ID (int C_Order_ID);

	/** Get Order.
	  * Order
	  */
	public int getC_Order_ID();

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException;

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

    /** Column name MovementDate */
    public static final String COLUMNNAME_MovementDate = "MovementDate";

	/** Set Movement Date.
	  * Date a product was moved in or out of inventory
	  */
	public void setMovementDate (Timestamp MovementDate);

	/** Get Movement Date.
	  * Date a product was moved in or out of inventory
	  */
	public Timestamp getMovementDate();

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

    /** Column name Qty_Payment */
    public static final String COLUMNNAME_Qty_Payment = "Qty_Payment";

	/** Set Payment Qty	  */
	public void setQty_Payment (BigDecimal Qty_Payment);

	/** Get Payment Qty	  */
	public BigDecimal getQty_Payment();

    /** Column name Qty_Receipt */
    public static final String COLUMNNAME_Qty_Receipt = "Qty_Receipt";

	/** Set Receipt Qty	  */
	public void setQty_Receipt (BigDecimal Qty_Receipt);

	/** Get Receipt Qty	  */
	public BigDecimal getQty_Receipt();

    /** Column name TF_Boulder_Receipt_ID */
    public static final String COLUMNNAME_TF_Boulder_Receipt_ID = "TF_Boulder_Receipt_ID";

	/** Set Boulder Receipt	  */
	public void setTF_Boulder_Receipt_ID (int TF_Boulder_Receipt_ID);

	/** Get Boulder Receipt	  */
	public int getTF_Boulder_Receipt_ID();

	public I_TF_Boulder_Receipt getTF_Boulder_Receipt() throws RuntimeException;

    /** Column name TF_Boulder_Wastage_ID */
    public static final String COLUMNNAME_TF_Boulder_Wastage_ID = "TF_Boulder_Wastage_ID";

	/** Set Boulder Wastage	  */
	public void setTF_Boulder_Wastage_ID (int TF_Boulder_Wastage_ID);

	/** Get Boulder Wastage	  */
	public int getTF_Boulder_Wastage_ID();

	public I_TF_Boulder_Wastage getTF_Boulder_Wastage() throws RuntimeException;

    /** Column name TF_CrusherKatingEntry_ID */
    public static final String COLUMNNAME_TF_CrusherKatingEntry_ID = "TF_CrusherKatingEntry_ID";

	/** Set Crusher Kating Entry	  */
	public void setTF_CrusherKatingEntry_ID (int TF_CrusherKatingEntry_ID);

	/** Get Crusher Kating Entry	  */
	public int getTF_CrusherKatingEntry_ID();

	public I_TF_CrusherKatingEntry getTF_CrusherKatingEntry() throws RuntimeException;

    /** Column name TF_RMSubcon_Movement_ID */
    public static final String COLUMNNAME_TF_RMSubcon_Movement_ID = "TF_RMSubcon_Movement_ID";

	/** Set Subcontract Material Movement	  */
	public void setTF_RMSubcon_Movement_ID (int TF_RMSubcon_Movement_ID);

	/** Get Subcontract Material Movement	  */
	public int getTF_RMSubcon_Movement_ID();

    /** Column name TF_RMSubcon_Movement_UU */
    public static final String COLUMNNAME_TF_RMSubcon_Movement_UU = "TF_RMSubcon_Movement_UU";

	/** Set TF_RMSubcon_Movement_UU	  */
	public void setTF_RMSubcon_Movement_UU (String TF_RMSubcon_Movement_UU);

	/** Get TF_RMSubcon_Movement_UU	  */
	public String getTF_RMSubcon_Movement_UU();

    /** Column name TF_WeighmentEntry_ID */
    public static final String COLUMNNAME_TF_WeighmentEntry_ID = "TF_WeighmentEntry_ID";

	/** Set Weighment Entry	  */
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID);

	/** Get Weighment Entry	  */
	public int getTF_WeighmentEntry_ID();

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException;

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
