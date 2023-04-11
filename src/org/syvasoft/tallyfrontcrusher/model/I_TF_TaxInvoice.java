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

/** Generated Interface for TF_TaxInvoice
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_TaxInvoice 
{

    /** TableName=TF_TaxInvoice */
    public static final String Table_Name = "TF_TaxInvoice";

    /** AD_Table_ID=1000260 */
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

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_BPartner_Location_ID */
    public static final String COLUMNNAME_C_BPartner_Location_ID = "C_BPartner_Location_ID";

	/** Set Partner Location.
	  * Identifies the (ship to) address for this Business Partner
	  */
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID);

	/** Get Partner Location.
	  * Identifies the (ship to) address for this Business Partner
	  */
	public int getC_BPartner_Location_ID();

	public org.compiere.model.I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException;

    /** Column name C_ElementValueGST_ID */
    public static final String COLUMNNAME_C_ElementValueGST_ID = "C_ElementValueGST_ID";

	/** Set GST Account Head	  */
	public void setC_ElementValueGST_ID (int C_ElementValueGST_ID);

	/** Get GST Account Head	  */
	public int getC_ElementValueGST_ID();

	public org.compiere.model.I_C_ElementValue getC_ElementValueGST() throws RuntimeException;

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

    /** Column name Destination */
    public static final String COLUMNNAME_Destination = "Destination";

	/** Set Destination	  */
	public void setDestination (String Destination);

	/** Get Destination	  */
	public String getDestination();

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

    /** Column name GrandTotal */
    public static final String COLUMNNAME_GrandTotal = "GrandTotal";

	/** Set Grand Total.
	  * Total amount of document
	  */
	public void setGrandTotal (BigDecimal GrandTotal);

	/** Get Grand Total.
	  * Total amount of document
	  */
	public BigDecimal getGrandTotal();

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

    /** Column name MDPNo */
    public static final String COLUMNNAME_MDPNo = "MDPNo";

	/** Set MDP No	  */
	public void setMDPNo (String MDPNo);

	/** Get MDP No	  */
	public String getMDPNo();

    /** Column name PartyName */
    public static final String COLUMNNAME_PartyName = "PartyName";

	/** Set Party Name	  */
	public void setPartyName (String PartyName);

	/** Get Party Name	  */
	public String getPartyName();

    /** Column name PermitAmount */
    public static final String COLUMNNAME_PermitAmount = "PermitAmount";

	/** Set Permit Amount	  */
	public void setPermitAmount (BigDecimal PermitAmount);

	/** Get Permit Amount	  */
	public BigDecimal getPermitAmount();

    /** Column name PostPermitAmtToCustomer */
    public static final String COLUMNNAME_PostPermitAmtToCustomer = "PostPermitAmtToCustomer";

	/** Set Post Permit Amount to Customer	  */
	public void setPostPermitAmtToCustomer (boolean PostPermitAmtToCustomer);

	/** Get Post Permit Amount to Customer	  */
	public boolean isPostPermitAmtToCustomer();

    /** Column name PostTaxToCustomer */
    public static final String COLUMNNAME_PostTaxToCustomer = "PostTaxToCustomer";

	/** Set Post GST to Customer	  */
	public void setPostTaxToCustomer (boolean PostTaxToCustomer);

	/** Get Post GST to Customer	  */
	public boolean isPostTaxToCustomer();

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

    /** Column name QtyPermitDeducted */
    public static final String COLUMNNAME_QtyPermitDeducted = "QtyPermitDeducted";

	/** Set Permit Deducted Qty	  */
	public void setQtyPermitDeducted (BigDecimal QtyPermitDeducted);

	/** Get Permit Deducted Qty	  */
	public BigDecimal getQtyPermitDeducted();

    /** Column name RoundingOff */
    public static final String COLUMNNAME_RoundingOff = "RoundingOff";

	/** Set Rounding Off	  */
	public void setRoundingOff (BigDecimal RoundingOff);

	/** Get Rounding Off	  */
	public BigDecimal getRoundingOff();

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

    /** Column name TF_Quarry_ID */
    public static final String COLUMNNAME_TF_Quarry_ID = "TF_Quarry_ID";

	/** Set Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID);

	/** Get Quarry	  */
	public int getTF_Quarry_ID();

	public I_TF_Quarry getTF_Quarry() throws RuntimeException;

    /** Column name TF_TaxInvoice_ID */
    public static final String COLUMNNAME_TF_TaxInvoice_ID = "TF_TaxInvoice_ID";

	/** Set Tax Invoice	  */
	public void setTF_TaxInvoice_ID (int TF_TaxInvoice_ID);

	/** Get Tax Invoice	  */
	public int getTF_TaxInvoice_ID();

    /** Column name TF_TaxInvoice_UU */
    public static final String COLUMNNAME_TF_TaxInvoice_UU = "TF_TaxInvoice_UU";

	/** Set TF_TaxInvoice_UU	  */
	public void setTF_TaxInvoice_UU (String TF_TaxInvoice_UU);

	/** Get TF_TaxInvoice_UU	  */
	public String getTF_TaxInvoice_UU();

    /** Column name TF_Weighment_Permit_ID */
    public static final String COLUMNNAME_TF_Weighment_Permit_ID = "TF_Weighment_Permit_ID";

	/** Set Weighment Entry (Permit)	  */
	public void setTF_Weighment_Permit_ID (int TF_Weighment_Permit_ID);

	/** Get Weighment Entry (Permit)	  */
	public int getTF_Weighment_Permit_ID();

	public I_TF_Weighment_Permit getTF_Weighment_Permit() throws RuntimeException;

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

    /** Column name VehicleNo */
    public static final String COLUMNNAME_VehicleNo = "VehicleNo";

	/** Set Vehicle No	  */
	public void setVehicleNo (String VehicleNo);

	/** Get Vehicle No	  */
	public String getVehicleNo();
}
