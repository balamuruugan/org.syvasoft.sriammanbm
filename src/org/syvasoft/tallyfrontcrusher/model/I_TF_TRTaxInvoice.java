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

/** Generated Interface for TF_TRTaxInvoice
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_TRTaxInvoice 
{

    /** TableName=TF_TRTaxInvoice */
    public static final String Table_Name = "TF_TRTaxInvoice";

    /** AD_Table_ID=1000296 */
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

    /** Column name ApplyTCS */
    public static final String COLUMNNAME_ApplyTCS = "ApplyTCS";

	/** Set Apply TCS	  */
	public void setApplyTCS (boolean ApplyTCS);

	/** Get Apply TCS	  */
	public boolean isApplyTCS();

    /** Column name BillingName */
    public static final String COLUMNNAME_BillingName = "BillingName";

	/** Set Billing Name	  */
	public void setBillingName (String BillingName);

	/** Get Billing Name	  */
	public String getBillingName();

    /** Column name C_BankAccount_ID */
    public static final String COLUMNNAME_C_BankAccount_ID = "C_BankAccount_ID";

	/** Set Bank/Cash Account.
	  * Account at the Bank
	  */
	public void setC_BankAccount_ID (int C_BankAccount_ID);

	/** Get Bank/Cash Account.
	  * Account at the Bank
	  */
	public int getC_BankAccount_ID();

	public org.compiere.model.I_C_BankAccount getC_BankAccount() throws RuntimeException;

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

    /** Column name C_BPartnerShipTo_ID */
    public static final String COLUMNNAME_C_BPartnerShipTo_ID = "C_BPartnerShipTo_ID";

	/** Set Ship to party	  */
	public void setC_BPartnerShipTo_ID (int C_BPartnerShipTo_ID);

	/** Get Ship to party	  */
	public int getC_BPartnerShipTo_ID();

	public org.compiere.model.I_C_BPartner getC_BPartnerShipTo() throws RuntimeException;

    /** Column name C_DocType_ID */
    public static final String COLUMNNAME_C_DocType_ID = "C_DocType_ID";

	/** Set Document Type.
	  * Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID);

	/** Get Document Type.
	  * Document type or rules
	  */
	public int getC_DocType_ID();

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException;

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

    /** Column name DateSupply */
    public static final String COLUMNNAME_DateSupply = "DateSupply";

	/** Set Date of Supply.
	  * Date of Supply
	  */
	public void setDateSupply (Timestamp DateSupply);

	/** Get Date of Supply.
	  * Date of Supply
	  */
	public Timestamp getDateSupply();

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

    /** Column name DriverDocNo */
    public static final String COLUMNNAME_DriverDocNo = "DriverDocNo";

	/** Set Driver Doc No	  */
	public void setDriverDocNo (String DriverDocNo);

	/** Get Driver Doc No	  */
	public String getDriverDocNo();

    /** Column name DriverMobNo */
    public static final String COLUMNNAME_DriverMobNo = "DriverMobNo";

	/** Set Driver Mobile No	  */
	public void setDriverMobNo (String DriverMobNo);

	/** Get Driver Mobile No	  */
	public String getDriverMobNo();

    /** Column name DriverName */
    public static final String COLUMNNAME_DriverName = "DriverName";

	/** Set Driver Name	  */
	public void setDriverName (String DriverName);

	/** Get Driver Name	  */
	public String getDriverName();

    /** Column name DspFrom_Address */
    public static final String COLUMNNAME_DspFrom_Address = "DspFrom_Address";

	/** Set Dispatch From Address	  */
	public void setDspFrom_Address (String DspFrom_Address);

	/** Get Dispatch From Address	  */
	public String getDspFrom_Address();

    /** Column name DspFrom_Name */
    public static final String COLUMNNAME_DspFrom_Name = "DspFrom_Name";

	/** Set Dispatch From	  */
	public void setDspFrom_Name (String DspFrom_Name);

	/** Get Dispatch From	  */
	public String getDspFrom_Name();

    /** Column name DspFrom_Place */
    public static final String COLUMNNAME_DspFrom_Place = "DspFrom_Place";

	/** Set Dispatch From Place	  */
	public void setDspFrom_Place (String DspFrom_Place);

	/** Get Dispatch From Place	  */
	public String getDspFrom_Place();

    /** Column name eWayBillNo */
    public static final String COLUMNNAME_eWayBillNo = "eWayBillNo";

	/** Set eWay Bill No	  */
	public void seteWayBillNo (String eWayBillNo);

	/** Get eWay Bill No	  */
	public String geteWayBillNo();

    /** Column name GL_Journal_ID */
    public static final String COLUMNNAME_GL_Journal_ID = "GL_Journal_ID";

	/** Set Journal.
	  * General Ledger Journal
	  */
	public void setGL_Journal_ID (int GL_Journal_ID);

	/** Get Journal.
	  * General Ledger Journal
	  */
	public int getGL_Journal_ID();

	public org.compiere.model.I_GL_Journal getGL_Journal() throws RuntimeException;

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

    /** Column name IsInterState */
    public static final String COLUMNNAME_IsInterState = "IsInterState";

	/** Set Inter State	  */
	public void setIsInterState (boolean IsInterState);

	/** Get Inter State	  */
	public boolean isInterState();

    /** Column name IsSOTrx */
    public static final String COLUMNNAME_IsSOTrx = "IsSOTrx";

	/** Set Sales Transaction.
	  * This is a Sales Transaction
	  */
	public void setIsSOTrx (boolean IsSOTrx);

	/** Get Sales Transaction.
	  * This is a Sales Transaction
	  */
	public boolean isSOTrx();

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

    /** Column name PartyName */
    public static final String COLUMNNAME_PartyName = "PartyName";

	/** Set Party Name	  */
	public void setPartyName (String PartyName);

	/** Get Party Name	  */
	public String getPartyName();

    /** Column name PlaceOfSupply */
    public static final String COLUMNNAME_PlaceOfSupply = "PlaceOfSupply";

	/** Set Place of Supply	  */
	public void setPlaceOfSupply (String PlaceOfSupply);

	/** Get Place of Supply	  */
	public String getPlaceOfSupply();

    /** Column name PostGSTAsExpense */
    public static final String COLUMNNAME_PostGSTAsExpense = "PostGSTAsExpense";

	/** Set Post GST as Expenses	  */
	public void setPostGSTAsExpense (boolean PostGSTAsExpense);

	/** Get Post GST as Expenses	  */
	public boolean isPostGSTAsExpense();

    /** Column name PostTaxToCustomer */
    public static final String COLUMNNAME_PostTaxToCustomer = "PostTaxToCustomer";

	/** Set Post GST to Customer	  */
	public void setPostTaxToCustomer (boolean PostTaxToCustomer);

	/** Get Post GST to Customer	  */
	public boolean isPostTaxToCustomer();

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

    /** Column name RMCPermitNo */
    public static final String COLUMNNAME_RMCPermitNo = "RMCPermitNo";

	/** Set RMC Permit No	  */
	public void setRMCPermitNo (String RMCPermitNo);

	/** Get RMC Permit No	  */
	public String getRMCPermitNo();

    /** Column name RoundOff */
    public static final String COLUMNNAME_RoundOff = "RoundOff";

	/** Set Round Off	  */
	public void setRoundOff (BigDecimal RoundOff);

	/** Get Round Off	  */
	public BigDecimal getRoundOff();

    /** Column name TaxID */
    public static final String COLUMNNAME_TaxID = "TaxID";

	/** Set Tax ID.
	  * Tax Identification
	  */
	public void setTaxID (String TaxID);

	/** Get Tax ID.
	  * Tax Identification
	  */
	public String getTaxID();

    /** Column name TCSAmount */
    public static final String COLUMNNAME_TCSAmount = "TCSAmount";

	/** Set TCS Amount	  */
	public void setTCSAmount (BigDecimal TCSAmount);

	/** Get TCS Amount	  */
	public BigDecimal getTCSAmount();

    /** Column name TF_Generate_Taxinvoice_ID */
    public static final String COLUMNNAME_TF_Generate_Taxinvoice_ID = "TF_Generate_Taxinvoice_ID";

	/** Set Generate Tax Invoice	  */
	public void setTF_Generate_Taxinvoice_ID (int TF_Generate_Taxinvoice_ID);

	/** Get Generate Tax Invoice	  */
	public int getTF_Generate_Taxinvoice_ID();

	
    /** Column name TF_TRTaxInvoice_ID */
    public static final String COLUMNNAME_TF_TRTaxInvoice_ID = "TF_TRTaxInvoice_ID";

	/** Set Sales Tax Invoice (Trading)	  */
	public void setTF_TRTaxInvoice_ID (int TF_TRTaxInvoice_ID);

	/** Get Sales Tax Invoice (Trading)	  */
	public int getTF_TRTaxInvoice_ID();

    /** Column name TF_TRTaxInvoice_UU */
    public static final String COLUMNNAME_TF_TRTaxInvoice_UU = "TF_TRTaxInvoice_UU";

	/** Set TF_TRTaxInvoice_UU	  */
	public void setTF_TRTaxInvoice_UU (String TF_TRTaxInvoice_UU);

	/** Get TF_TRTaxInvoice_UU	  */
	public String getTF_TRTaxInvoice_UU();

    /** Column name TF_WeighmentEntry_ID */
    public static final String COLUMNNAME_TF_WeighmentEntry_ID = "TF_WeighmentEntry_ID";

	/** Set Weighment Entry	  */
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID);

	/** Get Weighment Entry	  */
	public int getTF_WeighmentEntry_ID();

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException;

    /** Column name Total */
    public static final String COLUMNNAME_Total = "Total";

	/** Set Total	  */
	public void setTotal (BigDecimal Total);

	/** Get Total	  */
	public BigDecimal getTotal();

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

    /** Column name VehicleNo */
    public static final String COLUMNNAME_VehicleNo = "VehicleNo";

	/** Set Vehicle No	  */
	public void setVehicleNo (String VehicleNo);

	/** Get Vehicle No	  */
	public String getVehicleNo();
}
