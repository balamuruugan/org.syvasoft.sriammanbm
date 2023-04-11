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

/** Generated Interface for TF_Generate_TaxInvoiceLine
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_Generate_TaxInvoiceLine 
{

    /** TableName=TF_Generate_TaxInvoiceLine */
    public static final String Table_Name = "TF_Generate_TaxInvoiceLine";

    /** AD_Table_ID=1000299 */
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

    /** Column name C_UOM_ID */
    public static final String COLUMNNAME_C_UOM_ID = "C_UOM_ID";

	/** Set UOM.
	  * Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID);

	/** Get UOM.
	  * Unit of Measure
	  */
	public int getC_UOM_ID();

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException;

    /** Column name CGST_Amt */
    public static final String COLUMNNAME_CGST_Amt = "CGST_Amt";

	/** Set CGST Amount	  */
	public void setCGST_Amt (BigDecimal CGST_Amt);

	/** Get CGST Amount	  */
	public BigDecimal getCGST_Amt();

    /** Column name CGST_Rate */
    public static final String COLUMNNAME_CGST_Rate = "CGST_Rate";

	/** Set CGST %	  */
	public void setCGST_Rate (BigDecimal CGST_Rate);

	/** Get CGST %	  */
	public BigDecimal getCGST_Rate();

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

    /** Column name IGST_Amt */
    public static final String COLUMNNAME_IGST_Amt = "IGST_Amt";

	/** Set IGST Amt	  */
	public void setIGST_Amt (BigDecimal IGST_Amt);

	/** Get IGST Amt	  */
	public BigDecimal getIGST_Amt();

    /** Column name IGST_Rate */
    public static final String COLUMNNAME_IGST_Rate = "IGST_Rate";

	/** Set IGST %	  */
	public void setIGST_Rate (BigDecimal IGST_Rate);

	/** Get IGST %	  */
	public BigDecimal getIGST_Rate();

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

    /** Column name LineTotalAmt */
    public static final String COLUMNNAME_LineTotalAmt = "LineTotalAmt";

	/** Set Line Total.
	  * Total line amount incl. Tax
	  */
	public void setLineTotalAmt (BigDecimal LineTotalAmt);

	/** Get Line Total.
	  * Total line amount incl. Tax
	  */
	public BigDecimal getLineTotalAmt();

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

    /** Column name Price */
    public static final String COLUMNNAME_Price = "Price";

	/** Set Price.
	  * Price
	  */
	public void setPrice (BigDecimal Price);

	/** Get Price.
	  * Price
	  */
	public BigDecimal getPrice();

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

    /** Column name SGST_Amt */
    public static final String COLUMNNAME_SGST_Amt = "SGST_Amt";

	/** Set SGST Amount	  */
	public void setSGST_Amt (BigDecimal SGST_Amt);

	/** Get SGST Amount	  */
	public BigDecimal getSGST_Amt();

    /** Column name SGST_Rate */
    public static final String COLUMNNAME_SGST_Rate = "SGST_Rate";

	/** Set SGSt %	  */
	public void setSGST_Rate (BigDecimal SGST_Rate);

	/** Get SGSt %	  */
	public BigDecimal getSGST_Rate();

    /** Column name TaxableAmount */
    public static final String COLUMNNAME_TaxableAmount = "TaxableAmount";

	/** Set Taxable Amount	  */
	public void setTaxableAmount (BigDecimal TaxableAmount);

	/** Get Taxable Amount	  */
	public BigDecimal getTaxableAmount();

    /** Column name TF_Destination_ID */
    public static final String COLUMNNAME_TF_Destination_ID = "TF_Destination_ID";

	/** Set Destination	  */
	public void setTF_Destination_ID (int TF_Destination_ID);

	/** Get Destination	  */
	public int getTF_Destination_ID();

	public I_TF_Destination getTF_Destination() throws RuntimeException;

    /** Column name TF_Generate_Taxinvoice_ID */
    public static final String COLUMNNAME_TF_Generate_Taxinvoice_ID = "TF_Generate_Taxinvoice_ID";

	/** Set Generate Taxinvoice	  */
	public void setTF_Generate_Taxinvoice_ID (int TF_Generate_Taxinvoice_ID);

	/** Get Generate Taxinvoice	  */
	public int getTF_Generate_Taxinvoice_ID();

	public I_TF_Generate_TaxInvoice getTF_Generate_Taxinvoice() throws RuntimeException;

    /** Column name TF_Generate_TaxinvoiceLine_ID */
    public static final String COLUMNNAME_TF_Generate_TaxinvoiceLine_ID = "TF_Generate_TaxinvoiceLine_ID";

	/** Set TF_Generate_TaxinvoiceLine_ID	  */
	public void setTF_Generate_TaxinvoiceLine_ID (int TF_Generate_TaxinvoiceLine_ID);

	/** Get TF_Generate_TaxinvoiceLine_ID	  */
	public int getTF_Generate_TaxinvoiceLine_ID();

    /** Column name TF_Generate_TaxinvoiceLine_UU */
    public static final String COLUMNNAME_TF_Generate_TaxinvoiceLine_UU = "TF_Generate_TaxinvoiceLine_UU";

	/** Set TF_Generate_TaxinvoiceLine_UU	  */
	public void setTF_Generate_TaxinvoiceLine_UU (String TF_Generate_TaxinvoiceLine_UU);

	/** Get TF_Generate_TaxinvoiceLine_UU	  */
	public String getTF_Generate_TaxinvoiceLine_UU();

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
