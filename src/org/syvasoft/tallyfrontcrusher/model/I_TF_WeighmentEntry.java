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

/** Generated Interface for TF_WeighmentEntry
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_TF_WeighmentEntry 
{

    /** TableName=TF_WeighmentEntry */
    public static final String Table_Name = "TF_WeighmentEntry";

    /** AD_Table_ID=1000212 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

    /** Load Meta Data */

    /** Column name ActualWeight */
    public static final String COLUMNNAME_ActualWeight = "ActualWeight";

	/** Set Actual Weight	  */
	public void setActualWeight (BigDecimal ActualWeight);

	/** Get Actual Weight	  */
	public BigDecimal getActualWeight();

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

    /** Column name AD_User_ID */
    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";

	/** Set User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID);

	/** Get User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID();

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException;

    /** Column name Amount */
    public static final String COLUMNNAME_Amount = "Amount";

	/** Set Amount.
	  * Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount);

	/** Get Amount.
	  * Amount in a defined currency
	  */
	public BigDecimal getAmount();

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

    /** Column name BillPrice */
    public static final String COLUMNNAME_BillPrice = "BillPrice";

	/** Set Bill Price	  */
	public void setBillPrice (BigDecimal BillPrice);

	/** Get Bill Price	  */
	public BigDecimal getBillPrice();

    /** Column name BillPriceGST */
    public static final String COLUMNNAME_BillPriceGST = "BillPriceGST";

	/** Set Bill Price GST	  */
	public void setBillPriceGST (boolean BillPriceGST);

	/** Get Bill Price GST	  */
	public boolean isBillPriceGST();

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

    /** Column name C_BPartnerWB_ID */
    public static final String COLUMNNAME_C_BPartnerWB_ID = "C_BPartnerWB_ID";

	/** Set 3rd Party Weighbridge	  */
	public void setC_BPartnerWB_ID (int C_BPartnerWB_ID);

	/** Get 3rd Party Weighbridge	  */
	public int getC_BPartnerWB_ID();

	public org.compiere.model.I_C_BPartner getC_BPartnerWB() throws RuntimeException;

    /** Column name C_BPDriver_ID */
    public static final String COLUMNNAME_C_BPDriver_ID = "C_BPDriver_ID";

	/** Set Driver Name	  */
	public void setC_BPDriver_ID (int C_BPDriver_ID);

	/** Get Driver Name	  */
	public int getC_BPDriver_ID();

	public org.compiere.model.I_C_BPartner getC_BPDriver() throws RuntimeException;

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

    /** Column name C_OrderLine_ID */
    public static final String COLUMNNAME_C_OrderLine_ID = "C_OrderLine_ID";

	/** Set Sales Order Line.
	  * Sales Order Line
	  */
	public void setC_OrderLine_ID (int C_OrderLine_ID);

	/** Get Sales Order Line.
	  * Sales Order Line
	  */
	public int getC_OrderLine_ID();

	public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException;

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

    /** Column name CashAmount */
    public static final String COLUMNNAME_CashAmount = "CashAmount";

	/** Set Cash Amount	  */
	public void setCashAmount (BigDecimal CashAmount);

	/** Get Cash Amount	  */
	public BigDecimal getCashAmount();

    /** Column name CashReceived */
    public static final String COLUMNNAME_CashReceived = "CashReceived";

	/** Set Cash Received	  */
	public void setCashReceived (BigDecimal CashReceived);

	/** Get Cash Received	  */
	public BigDecimal getCashReceived();

    /** Column name ChangeAmt */
    public static final String COLUMNNAME_ChangeAmt = "ChangeAmt";

	/** Set Change Amt	  */
	public void setChangeAmt (BigDecimal ChangeAmt);

	/** Get Change Amt	  */
	public BigDecimal getChangeAmt();

    /** Column name CommissionQty */
    public static final String COLUMNNAME_CommissionQty = "CommissionQty";

	/** Set Commission Qty.
	  * Commission calculation basis Quantity
	  */
	public void setCommissionQty (BigDecimal CommissionQty);

	/** Get Commission Qty.
	  * Commission calculation basis Quantity
	  */
	public BigDecimal getCommissionQty();

    /** Column name CompletedBy */
    public static final String COLUMNNAME_CompletedBy = "CompletedBy";

	/** Set Completed By	  */
	public void setCompletedBy (String CompletedBy);

	/** Get Completed By	  */
	public String getCompletedBy();

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

    /** Column name CreateTwoInvoices */
    public static final String COLUMNNAME_CreateTwoInvoices = "CreateTwoInvoices";

	/** Set Create Two Invoices.
	  * Create Two Invoices by TP Weight and the remaining Weight
	  */
	public void setCreateTwoInvoices (boolean CreateTwoInvoices);

	/** Get Create Two Invoices.
	  * Create Two Invoices by TP Weight and the remaining Weight
	  */
	public boolean isCreateTwoInvoices();

    /** Column name CreditAmount */
    public static final String COLUMNNAME_CreditAmount = "CreditAmount";

	/** Set Credit Amount	  */
	public void setCreditAmount (BigDecimal CreditAmount);

	/** Get Credit Amount	  */
	public BigDecimal getCreditAmount();

    /** Column name CustomerTransporter */
    public static final String COLUMNNAME_CustomerTransporter = "CustomerTransporter";

	/** Set Customer&#039;
s Transporter	  */
	public void setCustomerTransporter (boolean CustomerTransporter);

	/** Get Customer&#039;
s Transporter	  */
	public boolean isCustomerTransporter();

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

    /** Column name DateInvoiced */
    public static final String COLUMNNAME_DateInvoiced = "DateInvoiced";

	/** Set Date Invoiced.
	  * Date printed on Invoice
	  */
	public void setDateInvoiced (Timestamp DateInvoiced);

	/** Get Date Invoiced.
	  * Date printed on Invoice
	  */
	public Timestamp getDateInvoiced();

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

    /** Column name DiscountAmount */
    public static final String COLUMNNAME_DiscountAmount = "DiscountAmount";

	/** Set Discount Amount	  */
	public void setDiscountAmount (BigDecimal DiscountAmount);

	/** Get Discount Amount	  */
	public BigDecimal getDiscountAmount();

    /** Column name DistributeRentAmt */
    public static final String COLUMNNAME_DistributeRentAmt = "DistributeRentAmt";

	/** Set Distribute Rent Amount into GST Invoice	  */
	public void setDistributeRentAmt (boolean DistributeRentAmt);

	/** Get Distribute Rent Amount into GST Invoice	  */
	public boolean isDistributeRentAmt();

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

    /** Column name DriverContact */
    public static final String COLUMNNAME_DriverContact = "DriverContact";

	/** Set Driver Contact No	  */
	public void setDriverContact (String DriverContact);

	/** Get Driver Contact No	  */
	public String getDriverContact();

    /** Column name DriverName */
    public static final String COLUMNNAME_DriverName = "DriverName";

	/** Set Driver Name	  */
	public void setDriverName (String DriverName);

	/** Get Driver Name	  */
	public String getDriverName();

    /** Column name DriverTips */
    public static final String COLUMNNAME_DriverTips = "DriverTips";

	/** Set Driver Tips	  */
	public void setDriverTips (BigDecimal DriverTips);

	/** Get Driver Tips	  */
	public BigDecimal getDriverTips();

    /** Column name eWayBillNo */
    public static final String COLUMNNAME_eWayBillNo = "eWayBillNo";

	/** Set eWay Bill No	  */
	public void seteWayBillNo (String eWayBillNo);

	/** Get eWay Bill No	  */
	public String geteWayBillNo();

    /** Column name ExitTime */
    public static final String COLUMNNAME_ExitTime = "ExitTime";

	/** Set Exit Time	  */
	public void setExitTime (Timestamp ExitTime);

	/** Get Exit Time	  */
	public Timestamp getExitTime();

    /** Column name ExportCustomer */
    public static final String COLUMNNAME_ExportCustomer = "ExportCustomer";

	/** Set Export Customer	  */
	public void setExportCustomer (boolean ExportCustomer);

	/** Get Export Customer	  */
	public boolean isExportCustomer();

    /** Column name FastagID */
    public static final String COLUMNNAME_FastagID = "FastagID";

	/** Set FastagID	  */
	public void setFastagID (String FastagID);

	/** Get FastagID	  */
	public String getFastagID();

    /** Column name FirstWeighbridgeName */
    public static final String COLUMNNAME_FirstWeighbridgeName = "FirstWeighbridgeName";

	/** Set First Weighbridge Name	  */
	public void setFirstWeighbridgeName (String FirstWeighbridgeName);

	/** Get First Weighbridge Name	  */
	public String getFirstWeighbridgeName();

    /** Column name FreightPrice */
    public static final String COLUMNNAME_FreightPrice = "FreightPrice";

	/** Set Freight Rate	  */
	public void setFreightPrice (BigDecimal FreightPrice);

	/** Get Freight Rate	  */
	public BigDecimal getFreightPrice();

    /** Column name FreightQty */
    public static final String COLUMNNAME_FreightQty = "FreightQty";

	/** Set Freight Qty.
	  * Own Vehicle Freight Qty for TripSheet and Machinery Statement Posting
	  */
	public void setFreightQty (BigDecimal FreightQty);

	/** Get Freight Qty.
	  * Own Vehicle Freight Qty for TripSheet and Machinery Statement Posting
	  */
	public BigDecimal getFreightQty();

    /** Column name FreightRule_ID */
    public static final String COLUMNNAME_FreightRule_ID = "FreightRule_ID";

	/** Set Freight Rule.
	  * Freight Rule
	  */
	public void setFreightRule_ID (int FreightRule_ID);

	/** Get Freight Rule.
	  * Freight Rule
	  */
	public int getFreightRule_ID();

	public org.compiere.model.I_C_UOM getFreightRule() throws RuntimeException;

    /** Column name GrossPrice */
    public static final String COLUMNNAME_GrossPrice = "GrossPrice";

	/** Set Gross Price	  */
	public void setGrossPrice (BigDecimal GrossPrice);

	/** Get Gross Price	  */
	public BigDecimal getGrossPrice();

    /** Column name GrossRent */
    public static final String COLUMNNAME_GrossRent = "GrossRent";

	/** Set Gross Rent	  */
	public void setGrossRent (BigDecimal GrossRent);

	/** Get Gross Rent	  */
	public BigDecimal getGrossRent();

    /** Column name GrossTotal */
    public static final String COLUMNNAME_GrossTotal = "GrossTotal";

	/** Set Gross Total	  */
	public void setGrossTotal (BigDecimal GrossTotal);

	/** Get Gross Total	  */
	public BigDecimal getGrossTotal();

    /** Column name GrossWeight */
    public static final String COLUMNNAME_GrossWeight = "GrossWeight";

	/** Set Gross Weight (Kg)	  */
	public void setGrossWeight (BigDecimal GrossWeight);

	/** Get Gross Weight (Kg)	  */
	public BigDecimal getGrossWeight();

    /** Column name GrossWeightTime */
    public static final String COLUMNNAME_GrossWeightTime = "GrossWeightTime";

	/** Set Gross Weight Time	  */
	public void setGrossWeightTime (Timestamp GrossWeightTime);

	/** Get Gross Weight Time	  */
	public Timestamp getGrossWeightTime();

    /** Column name GrossWeightTimeString */
    public static final String COLUMNNAME_GrossWeightTimeString = "GrossWeightTimeString";

	/** Set Gross Weight Time String	  */
	public void setGrossWeightTimeString (String GrossWeightTimeString);

	/** Get Gross Weight Time String	  */
	public String getGrossWeightTimeString();

    /** Column name GSTAmount */
    public static final String COLUMNNAME_GSTAmount = "GSTAmount";

	/** Set GST Amount	  */
	public void setGSTAmount (BigDecimal GSTAmount);

	/** Get GST Amount	  */
	public BigDecimal getGSTAmount();

    /** Column name GSTRate */
    public static final String COLUMNNAME_GSTRate = "GSTRate";

	/** Set GST %	  */
	public void setGSTRate (BigDecimal GSTRate);

	/** Get GST %	  */
	public BigDecimal getGSTRate();

    /** Column name HasBalance */
    public static final String COLUMNNAME_HasBalance = "HasBalance";

	/** Set Has Balance.
	  * Permit Sales / Non Permit Sales
	  */
	public void setHasBalance (boolean HasBalance);

	/** Get Has Balance.
	  * Permit Sales / Non Permit Sales
	  */
	public boolean isHasBalance();

    /** Column name IncludePassAmtInvoice */
    public static final String COLUMNNAME_IncludePassAmtInvoice = "IncludePassAmtInvoice";

	/** Set Include Pass Amount Invoice	  */
	public void setIncludePassAmtInvoice (boolean IncludePassAmtInvoice);

	/** Get Include Pass Amount Invoice	  */
	public boolean isIncludePassAmtInvoice();

    /** Column name IncludeRentAmtInvoice */
    public static final String COLUMNNAME_IncludeRentAmtInvoice = "IncludeRentAmtInvoice";

	/** Set Include Rent Amount Invoice	  */
	public void setIncludeRentAmtInvoice (boolean IncludeRentAmtInvoice);

	/** Get Include Rent Amount Invoice	  */
	public boolean isIncludeRentAmtInvoice();

    /** Column name IndentNo */
    public static final String COLUMNNAME_IndentNo = "IndentNo";

	/** Set IndentNo	  */
	public void setIndentNo (int IndentNo);

	/** Get IndentNo	  */
	public int getIndentNo();

    /** Column name InvoiceNo */
    public static final String COLUMNNAME_InvoiceNo = "InvoiceNo";

	/** Set Invoice No.
	  * Invoice No generated from weighbridge app
	  */
	public void setInvoiceNo (String InvoiceNo);

	/** Get Invoice No.
	  * Invoice No generated from weighbridge app
	  */
	public String getInvoiceNo();

    /** Column name InvoiceNo2 */
    public static final String COLUMNNAME_InvoiceNo2 = "InvoiceNo2";

	/** Set 2nd Inovice No	  */
	public void setInvoiceNo2 (String InvoiceNo2);

	/** Get 2nd Inovice No	  */
	public String getInvoiceNo2();

    /** Column name InvoiceType */
    public static final String COLUMNNAME_InvoiceType = "InvoiceType";

	/** Set Invoice Type.
	  * Actual Weight / TP Weight
	  */
	public void setInvoiceType (String InvoiceType);

	/** Get Invoice Type.
	  * Actual Weight / TP Weight
	  */
	public String getInvoiceType();

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

    /** Column name IsManual */
    public static final String COLUMNNAME_IsManual = "IsManual";

	/** Set Manual.
	  * This is a manual process
	  */
	public void setIsManual (boolean IsManual);

	/** Get Manual.
	  * This is a manual process
	  */
	public boolean isManual();

    /** Column name IsPermitSales */
    public static final String COLUMNNAME_IsPermitSales = "IsPermitSales";

	/** Set Permit Sales	  */
	public void setIsPermitSales (boolean IsPermitSales);

	/** Get Permit Sales	  */
	public boolean isPermitSales();

    /** Column name IsPriceConfidential */
    public static final String COLUMNNAME_IsPriceConfidential = "IsPriceConfidential";

	/** Set Price Confidential	  */
	public void setIsPriceConfidential (boolean IsPriceConfidential);

	/** Get Price Confidential	  */
	public boolean isPriceConfidential();

    /** Column name IsRentInclusive */
    public static final String COLUMNNAME_IsRentInclusive = "IsRentInclusive";

	/** Set Freight Inclusive.
	  * Whether Unit Price includes rent?
	  */
	public void setIsRentInclusive (boolean IsRentInclusive);

	/** Get Freight Inclusive.
	  * Whether Unit Price includes rent?
	  */
	public boolean isRentInclusive();

    /** Column name IsRequiredTaxInvoicePerLoad */
    public static final String COLUMNNAME_IsRequiredTaxInvoicePerLoad = "IsRequiredTaxInvoicePerLoad";

	/** Set Required Taxinvoice per load	  */
	public void setIsRequiredTaxInvoicePerLoad (boolean IsRequiredTaxInvoicePerLoad);

	/** Get Required Taxinvoice per load	  */
	public boolean isRequiredTaxInvoicePerLoad();

    /** Column name IsRoyaltyPassInclusive */
    public static final String COLUMNNAME_IsRoyaltyPassInclusive = "IsRoyaltyPassInclusive";

	/** Set Royalty Pass Inclusive	  */
	public void setIsRoyaltyPassInclusive (boolean IsRoyaltyPassInclusive);

	/** Get Royalty Pass Inclusive	  */
	public boolean isRoyaltyPassInclusive();

    /** Column name IsSecondary */
    public static final String COLUMNNAME_IsSecondary = "IsSecondary";

	/** Set Secondary	  */
	public void setIsSecondary (boolean IsSecondary);

	/** Get Secondary	  */
	public boolean isSecondary();

    /** Column name IsTaxIncluded */
    public static final String COLUMNNAME_IsTaxIncluded = "IsTaxIncluded";

	/** Set Price includes Tax.
	  * Tax is included in the price 
	  */
	public void setIsTaxIncluded (boolean IsTaxIncluded);

	/** Get Price includes Tax.
	  * Tax is included in the price 
	  */
	public boolean isTaxIncluded();

    /** Column name LoadedTime */
    public static final String COLUMNNAME_LoadedTime = "LoadedTime";

	/** Set Loaded Time	  */
	public void setLoadedTime (Timestamp LoadedTime);

	/** Get Loaded Time	  */
	public Timestamp getLoadedTime();

    /** Column name Loader_User_ID */
    public static final String COLUMNNAME_Loader_User_ID = "Loader_User_ID";

	/** Set Loader Operator	  */
	public void setLoader_User_ID (int Loader_User_ID);

	/** Get Loader Operator	  */
	public int getLoader_User_ID();

	public org.compiere.model.I_AD_User getLoader_User() throws RuntimeException;

    /** Column name M_Product_Attribute_ID */
    public static final String COLUMNNAME_M_Product_Attribute_ID = "M_Product_Attribute_ID";

	/** Set Product Attribute	  */
	public void setM_Product_Attribute_ID (int M_Product_Attribute_ID);

	/** Get Product Attribute	  */
	public int getM_Product_Attribute_ID();

	public I_M_Product_Attribute getM_Product_Attribute() throws RuntimeException;

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

    /** Column name M_Product_Pass_ID */
    public static final String COLUMNNAME_M_Product_Pass_ID = "M_Product_Pass_ID";

	/** Set Pass ID	  */
	public void setM_Product_Pass_ID (int M_Product_Pass_ID);

	/** Get Pass ID	  */
	public int getM_Product_Pass_ID();

	public org.compiere.model.I_M_Product getM_Product_Pass() throws RuntimeException;

    /** Column name M_Product2_ID */
    public static final String COLUMNNAME_M_Product2_ID = "M_Product2_ID";

	/** Set Product 2	  */
	public void setM_Product2_ID (int M_Product2_ID);

	/** Get Product 2	  */
	public int getM_Product2_ID();

	public org.compiere.model.I_M_Product getM_Product2() throws RuntimeException;

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

    /** Column name MDPNo */
    public static final String COLUMNNAME_MDPNo = "MDPNo";

	/** Set MDP No	  */
	public void setMDPNo (String MDPNo);

	/** Get MDP No	  */
	public String getMDPNo();

    /** Column name MLNo */
    public static final String COLUMNNAME_MLNo = "MLNo";

	/** Set ML No	  */
	public void setMLNo (String MLNo);

	/** Get ML No	  */
	public String getMLNo();

    /** Column name NetWeight */
    public static final String COLUMNNAME_NetWeight = "NetWeight";

	/** Set Net Weight (Kg)	  */
	public void setNetWeight (BigDecimal NetWeight);

	/** Get Net Weight (Kg)	  */
	public BigDecimal getNetWeight();

    /** Column name NetWeightUnit */
    public static final String COLUMNNAME_NetWeightUnit = "NetWeightUnit";

	/** Set Net Weight (Unit)	  */
	public void setNetWeightUnit (BigDecimal NetWeightUnit);

	/** Get Net Weight (Unit)	  */
	public BigDecimal getNetWeightUnit();

    /** Column name NewDestination */
    public static final String COLUMNNAME_NewDestination = "NewDestination";

	/** Set New Destination	  */
	public void setNewDestination (String NewDestination);

	/** Get New Destination	  */
	public String getNewDestination();

    /** Column name NewDriverName */
    public static final String COLUMNNAME_NewDriverName = "NewDriverName";

	/** Set New Driver Name	  */
	public void setNewDriverName (String NewDriverName);

	/** Get New Driver Name	  */
	public String getNewDriverName();

    /** Column name NewProduct */
    public static final String COLUMNNAME_NewProduct = "NewProduct";

	/** Set New Product	  */
	public void setNewProduct (String NewProduct);

	/** Get New Product	  */
	public String getNewProduct();

    /** Column name OpeningMeter */
    public static final String COLUMNNAME_OpeningMeter = "OpeningMeter";

	/** Set Opening Meter	  */
	public void setOpeningMeter (int OpeningMeter);

	/** Get Opening Meter	  */
	public int getOpeningMeter();

    /** Column name OtherCharges */
    public static final String COLUMNNAME_OtherCharges = "OtherCharges";

	/** Set Other Charges	  */
	public void setOtherCharges (BigDecimal OtherCharges);

	/** Get Other Charges	  */
	public BigDecimal getOtherCharges();

    /** Column name PartyName */
    public static final String COLUMNNAME_PartyName = "PartyName";

	/** Set Party Name	  */
	public void setPartyName (String PartyName);

	/** Get Party Name	  */
	public String getPartyName();

    /** Column name PassIncludesTax */
    public static final String COLUMNNAME_PassIncludesTax = "PassIncludesTax";

	/** Set Pass Includes Tax	  */
	public void setPassIncludesTax (boolean PassIncludesTax);

	/** Get Pass Includes Tax	  */
	public boolean isPassIncludesTax();

    /** Column name PassPricePerUnit */
    public static final String COLUMNNAME_PassPricePerUnit = "PassPricePerUnit";

	/** Set Pass Price	  */
	public void setPassPricePerUnit (BigDecimal PassPricePerUnit);

	/** Get Pass Price	  */
	public BigDecimal getPassPricePerUnit();

    /** Column name PaymentRule */
    public static final String COLUMNNAME_PaymentRule = "PaymentRule";

	/** Set Payment Rule.
	  * How you pay the invoice
	  */
	public void setPaymentRule (String PaymentRule);

	/** Get Payment Rule.
	  * How you pay the invoice
	  */
	public String getPaymentRule();

    /** Column name PermitIssuedQty */
    public static final String COLUMNNAME_PermitIssuedQty = "PermitIssuedQty";

	/** Set TP Weight	  */
	public void setPermitIssuedQty (BigDecimal PermitIssuedQty);

	/** Get TP Weight	  */
	public BigDecimal getPermitIssuedQty();

    /** Column name PermitPassAmount */
    public static final String COLUMNNAME_PermitPassAmount = "PermitPassAmount";

	/** Set Permit Issue Amount	  */
	public void setPermitPassAmount (BigDecimal PermitPassAmount);

	/** Get Permit Issue Amount	  */
	public BigDecimal getPermitPassAmount();

    /** Column name PermitQty */
    public static final String COLUMNNAME_PermitQty = "PermitQty";

	/** Set Permit Quantity (Tonne)	  */
	public void setPermitQty (BigDecimal PermitQty);

	/** Get Permit Quantity (Tonne)	  */
	public BigDecimal getPermitQty();

    /** Column name Phone */
    public static final String COLUMNNAME_Phone = "Phone";

	/** Set Phone.
	  * Identifies a telephone number
	  */
	public void setPhone (String Phone);

	/** Get Phone.
	  * Identifies a telephone number
	  */
	public String getPhone();

    /** Column name PITNo */
    public static final String COLUMNNAME_PITNo = "PITNo";

	/** Set PIT No	  */
	public void setPITNo (String PITNo);

	/** Get PIT No	  */
	public String getPITNo();

    /** Column name PM_Machinery_ID */
    public static final String COLUMNNAME_PM_Machinery_ID = "PM_Machinery_ID";

	/** Set Machinery	  */
	public void setPM_Machinery_ID (int PM_Machinery_ID);

	/** Get Machinery	  */
	public int getPM_Machinery_ID();

	public I_PM_Machinery getPM_Machinery() throws RuntimeException;

    /** Column name PreviousChallanNo */
    public static final String COLUMNNAME_PreviousChallanNo = "PreviousChallanNo";

	/** Set Previous Challan No	  */
	public void setPreviousChallanNo (String PreviousChallanNo);

	/** Get Previous Challan No	  */
	public String getPreviousChallanNo();

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

    /** Column name PrimaryDocumentNo */
    public static final String COLUMNNAME_PrimaryDocumentNo = "PrimaryDocumentNo";

	/** Set Primary Document No	  */
	public void setPrimaryDocumentNo (String PrimaryDocumentNo);

	/** Get Primary Document No	  */
	public String getPrimaryDocumentNo();

    /** Column name PrimaryDocumentNo2 */
    public static final String COLUMNNAME_PrimaryDocumentNo2 = "PrimaryDocumentNo2";

	/** Set PrimaryDocumentNo2	  */
	public void setPrimaryDocumentNo2 (String PrimaryDocumentNo2);

	/** Get PrimaryDocumentNo2	  */
	public String getPrimaryDocumentNo2();

    /** Column name PrintDeliveryEstimate */
    public static final String COLUMNNAME_PrintDeliveryEstimate = "PrintDeliveryEstimate";

	/** Set Print Delivery Estimate	  */
	public void setPrintDeliveryEstimate (String PrintDeliveryEstimate);

	/** Get Print Delivery Estimate	  */
	public String getPrintDeliveryEstimate();

    /** Column name PrintInvoice */
    public static final String COLUMNNAME_PrintInvoice = "PrintInvoice";

	/** Set Print Invoice	  */
	public void setPrintInvoice (String PrintInvoice);

	/** Get Print Invoice	  */
	public String getPrintInvoice();

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

    /** Column name QuarryProductionType */
    public static final String COLUMNNAME_QuarryProductionType = "QuarryProductionType";

	/** Set Quarry Production Type	  */
	public void setQuarryProductionType (String QuarryProductionType);

	/** Get Quarry Production Type	  */
	public String getQuarryProductionType();

    /** Column name Ref_WeighmentEntry_ID */
    public static final String COLUMNNAME_Ref_WeighmentEntry_ID = "Ref_WeighmentEntry_ID";

	/** Set Reference Weighment Entry	  */
	public void setRef_WeighmentEntry_ID (int Ref_WeighmentEntry_ID);

	/** Get Reference Weighment Entry	  */
	public int getRef_WeighmentEntry_ID();

	public I_TF_WeighmentEntry getRef_WeighmentEntry() throws RuntimeException;

    /** Column name Remarks */
    public static final String COLUMNNAME_Remarks = "Remarks";

	/** Set Remarks	  */
	public void setRemarks (String Remarks);

	/** Get Remarks	  */
	public String getRemarks();

    /** Column name RemoveWE */
    public static final String COLUMNNAME_RemoveWE = "RemoveWE";

	/** Set Remove	  */
	public void setRemoveWE (String RemoveWE);

	/** Get Remove	  */
	public String getRemoveWE();

    /** Column name Rent_Amt */
    public static final String COLUMNNAME_Rent_Amt = "Rent_Amt";

	/** Set Rent (Amount)	  */
	public void setRent_Amt (BigDecimal Rent_Amt);

	/** Get Rent (Amount)	  */
	public BigDecimal getRent_Amt();

    /** Column name RentIncludesTax */
    public static final String COLUMNNAME_RentIncludesTax = "RentIncludesTax";

	/** Set Rent Includes Tax	  */
	public void setRentIncludesTax (boolean RentIncludesTax);

	/** Get Rent Includes Tax	  */
	public boolean isRentIncludesTax();

    /** Column name RoundingOff */
    public static final String COLUMNNAME_RoundingOff = "RoundingOff";

	/** Set Rounding Off	  */
	public void setRoundingOff (BigDecimal RoundingOff);

	/** Get Rounding Off	  */
	public BigDecimal getRoundingOff();

    /** Column name RoyaltyNo */
    public static final String COLUMNNAME_RoyaltyNo = "RoyaltyNo";

	/** Set TP No	  */
	public void setRoyaltyNo (String RoyaltyNo);

	/** Get TP No	  */
	public String getRoyaltyNo();

    /** Column name SalesAmt */
    public static final String COLUMNNAME_SalesAmt = "SalesAmt";

	/** Set Sales Amount	  */
	public void setSalesAmt (BigDecimal SalesAmt);

	/** Get Sales Amount	  */
	public BigDecimal getSalesAmt();

    /** Column name SalesRep_ID */
    public static final String COLUMNNAME_SalesRep_ID = "SalesRep_ID";

	/** Set Sales Representative.
	  * Sales Representative or Company Agent
	  */
	public void setSalesRep_ID (int SalesRep_ID);

	/** Get Sales Representative.
	  * Sales Representative or Company Agent
	  */
	public int getSalesRep_ID();

	public org.compiere.model.I_C_BPartner getSalesRep() throws RuntimeException;

    /** Column name SecondWeighbridgeName */
    public static final String COLUMNNAME_SecondWeighbridgeName = "SecondWeighbridgeName";

	/** Set Second Weighbridge Name	  */
	public void setSecondWeighbridgeName (String SecondWeighbridgeName);

	/** Get Second Weighbridge Name	  */
	public String getSecondWeighbridgeName();

    /** Column name ShipmentTo */
    public static final String COLUMNNAME_ShipmentTo = "ShipmentTo";

	/** Set Shipment To	  */
	public void setShipmentTo (String ShipmentTo);

	/** Get Shipment To	  */
	public String getShipmentTo();

    /** Column name ShippingAddress */
    public static final String COLUMNNAME_ShippingAddress = "ShippingAddress";

	/** Set ShippingAddress	  */
	public void setShippingAddress (String ShippingAddress);

	/** Get ShippingAddress	  */
	public String getShippingAddress();

    /** Column name Status */
    public static final String COLUMNNAME_Status = "Status";

	/** Set Status.
	  * Status of the currently running check
	  */
	public void setStatus (String Status);

	/** Get Status.
	  * Status of the currently running check
	  */
	public String getStatus();

    /** Column name TareWeight */
    public static final String COLUMNNAME_TareWeight = "TareWeight";

	/** Set Tare Weight (Kg)	  */
	public void setTareWeight (BigDecimal TareWeight);

	/** Get Tare Weight (Kg)	  */
	public BigDecimal getTareWeight();

    /** Column name TareWeightTime */
    public static final String COLUMNNAME_TareWeightTime = "TareWeightTime";

	/** Set Tare Weight Time	  */
	public void setTareWeightTime (Timestamp TareWeightTime);

	/** Get Tare Weight Time	  */
	public Timestamp getTareWeightTime();

    /** Column name TareWeightTimeString */
    public static final String COLUMNNAME_TareWeightTimeString = "TareWeightTimeString";

	/** Set Tare Weight Time String	  */
	public void setTareWeightTimeString (String TareWeightTimeString);

	/** Get Tare Weight Time String	  */
	public String getTareWeightTimeString();

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

    /** Column name TenderAmount */
    public static final String COLUMNNAME_TenderAmount = "TenderAmount";

	/** Set Tender Amount.
	  * Tender Amount
	  */
	public void setTenderAmount (BigDecimal TenderAmount);

	/** Get Tender Amount.
	  * Tender Amount
	  */
	public BigDecimal getTenderAmount();

    /** Column name TenderType */
    public static final String COLUMNNAME_TenderType = "TenderType";

	/** Set Tender type.
	  * Method of Payment
	  */
	public void setTenderType (String TenderType);

	/** Get Tender type.
	  * Method of Payment
	  */
	public String getTenderType();

    /** Column name TF_BlueMetal_Type */
    public static final String COLUMNNAME_TF_BlueMetal_Type = "TF_BlueMetal_Type";

	/** Set Production Type	  */
	public void setTF_BlueMetal_Type (String TF_BlueMetal_Type);

	/** Get Production Type	  */
	public String getTF_BlueMetal_Type();

    /** Column name TF_Boulder_Receipt_ID */
    public static final String COLUMNNAME_TF_Boulder_Receipt_ID = "TF_Boulder_Receipt_ID";

	/** Set Boulder Receipt	  */
	public void setTF_Boulder_Receipt_ID (int TF_Boulder_Receipt_ID);

	/** Get Boulder Receipt	  */
	public int getTF_Boulder_Receipt_ID();

	public I_TF_Boulder_Receipt getTF_Boulder_Receipt() throws RuntimeException;

    /** Column name TF_Destination_ID */
    public static final String COLUMNNAME_TF_Destination_ID = "TF_Destination_ID";

	/** Set Destination	  */
	public void setTF_Destination_ID (int TF_Destination_ID);

	/** Get Destination	  */
	public int getTF_Destination_ID();

	public I_TF_Destination getTF_Destination() throws RuntimeException;

    /** Column name TF_DispensePlanLine_ID */
    public static final String COLUMNNAME_TF_DispensePlanLine_ID = "TF_DispensePlanLine_ID";

	/** Set Dispatch Plan Line	  */
	public void setTF_DispensePlanLine_ID (int TF_DispensePlanLine_ID);

	/** Get Dispatch Plan Line	  */
	public int getTF_DispensePlanLine_ID();

	public I_TF_DispensePlanLine getTF_DispensePlanLine() throws RuntimeException;

    /** Column name TF_LumpSumRent_Config_ID */
    public static final String COLUMNNAME_TF_LumpSumRent_Config_ID = "TF_LumpSumRent_Config_ID";

	/** Set TF_LumpSumRent_Config	  */
	public void setTF_LumpSumRent_Config_ID (int TF_LumpSumRent_Config_ID);

	/** Get TF_LumpSumRent_Config	  */
	public int getTF_LumpSumRent_Config_ID();

	public I_TF_LumpSumRent_Config getTF_LumpSumRent_Config() throws RuntimeException;

    /** Column name TF_PriceListUOM_ID */
    public static final String COLUMNNAME_TF_PriceListUOM_ID = "TF_PriceListUOM_ID";

	/** Set Price List by UOM	  */
	public void setTF_PriceListUOM_ID (int TF_PriceListUOM_ID);

	/** Get Price List by UOM	  */
	public int getTF_PriceListUOM_ID();

	public I_TF_PriceListUOM getTF_PriceListUOM() throws RuntimeException;

    /** Column name TF_ProductionPlant_ID */
    public static final String COLUMNNAME_TF_ProductionPlant_ID = "TF_ProductionPlant_ID";

	/** Set Production Plant	  */
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID);

	/** Get Production Plant	  */
	public int getTF_ProductionPlant_ID();

	public I_TF_ProductionPlant getTF_ProductionPlant() throws RuntimeException;

    /** Column name TF_Quarry_ID */
    public static final String COLUMNNAME_TF_Quarry_ID = "TF_Quarry_ID";

	/** Set Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID);

	/** Get Quarry	  */
	public int getTF_Quarry_ID();

	public I_TF_Quarry getTF_Quarry() throws RuntimeException;

    /** Column name TF_RentedVehicle_ID */
    public static final String COLUMNNAME_TF_RentedVehicle_ID = "TF_RentedVehicle_ID";

	/** Set Rented Vehicle	  */
	public void setTF_RentedVehicle_ID (int TF_RentedVehicle_ID);

	/** Get Rented Vehicle	  */
	public int getTF_RentedVehicle_ID();

	public I_TF_RentedVehicle getTF_RentedVehicle() throws RuntimeException;

    /** Column name TF_Send_To */
    public static final String COLUMNNAME_TF_Send_To = "TF_Send_To";

	/** Set Send To	  */
	public void setTF_Send_To (String TF_Send_To);

	/** Get Send To	  */
	public String getTF_Send_To();

    /** Column name TF_TripSheet_ID */
    public static final String COLUMNNAME_TF_TripSheet_ID = "TF_TripSheet_ID";

	/** Set Trip Sheet	  */
	public void setTF_TripSheet_ID (int TF_TripSheet_ID);

	/** Get Trip Sheet	  */
	public int getTF_TripSheet_ID();

	public I_TF_TripSheet getTF_TripSheet() throws RuntimeException;

    /** Column name TF_TripSheetProduct_ID */
    public static final String COLUMNNAME_TF_TripSheetProduct_ID = "TF_TripSheetProduct_ID";

	/** Set Trip Sheet Product Detail	  */
	public void setTF_TripSheetProduct_ID (int TF_TripSheetProduct_ID);

	/** Get Trip Sheet Product Detail	  */
	public int getTF_TripSheetProduct_ID();

	public I_TF_TripSheetProduct getTF_TripSheetProduct() throws RuntimeException;

    /** Column name TF_VehicleType_ID */
    public static final String COLUMNNAME_TF_VehicleType_ID = "TF_VehicleType_ID";

	/** Set Vehicle Type	  */
	public void setTF_VehicleType_ID (int TF_VehicleType_ID);

	/** Get Vehicle Type	  */
	public int getTF_VehicleType_ID();

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException;

    /** Column name TF_WeighmentEntry_ID */
    public static final String COLUMNNAME_TF_WeighmentEntry_ID = "TF_WeighmentEntry_ID";

	/** Set Weighment Entry	  */
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID);

	/** Get Weighment Entry	  */
	public int getTF_WeighmentEntry_ID();

    /** Column name TF_WeighmentEntry_UU */
    public static final String COLUMNNAME_TF_WeighmentEntry_UU = "TF_WeighmentEntry_UU";

	/** Set TF_WeighmentEntry_UU	  */
	public void setTF_WeighmentEntry_UU (String TF_WeighmentEntry_UU);

	/** Get TF_WeighmentEntry_UU	  */
	public String getTF_WeighmentEntry_UU();

    /** Column name TF_WeighmentEntryPrimary_ID */
    public static final String COLUMNNAME_TF_WeighmentEntryPrimary_ID = "TF_WeighmentEntryPrimary_ID";

	/** Set Primary Weighment Entry	  */
	public void setTF_WeighmentEntryPrimary_ID (int TF_WeighmentEntryPrimary_ID);

	/** Get Primary Weighment Entry	  */
	public int getTF_WeighmentEntryPrimary_ID();

	public I_TF_WeighmentEntry getTF_WeighmentEntryPrimary() throws RuntimeException;

    /** Column name Time */
    public static final String COLUMNNAME_Time = "Time";

	/** Set Time	  */
	public void setTime (String Time);

	/** Get Time	  */
	public String getTime();

    /** Column name TotalAmt */
    public static final String COLUMNNAME_TotalAmt = "TotalAmt";

	/** Set Total Amount.
	  * Total Amount
	  */
	public void setTotalAmt (BigDecimal TotalAmt);

	/** Get Total Amount.
	  * Total Amount
	  */
	public BigDecimal getTotalAmt();

    /** Column name transporter */
    public static final String COLUMNNAME_transporter = "transporter";

	/** Set transporter	  */
	public void settransporter (String transporter);

	/** Get transporter	  */
	public String gettransporter();

    /** Column name Transporter_ID */
    public static final String COLUMNNAME_Transporter_ID = "Transporter_ID";

	/** Set Transporter	  */
	public void setTransporter_ID (int Transporter_ID);

	/** Get Transporter	  */
	public int getTransporter_ID();

	public org.compiere.model.I_C_BPartner getTransporter() throws RuntimeException;

    /** Column name UnloadingWeight */
    public static final String COLUMNNAME_UnloadingWeight = "UnloadingWeight";

	/** Set Unloading Weight (MT)	  */
	public void setUnloadingWeight (BigDecimal UnloadingWeight);

	/** Get Unloading Weight (MT)	  */
	public BigDecimal getUnloadingWeight();

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

    /** Column name UserName */
    public static final String COLUMNNAME_UserName = "UserName";

	/** Set User Name	  */
	public void setUserName (String UserName);

	/** Get User Name	  */
	public String getUserName();

    /** Column name VehicleMovementID */
    public static final String COLUMNNAME_VehicleMovementID = "VehicleMovementID";

	/** Set VehicleMovementID	  */
	public void setVehicleMovementID (int VehicleMovementID);

	/** Get VehicleMovementID	  */
	public int getVehicleMovementID();

    /** Column name VehicleNo */
    public static final String COLUMNNAME_VehicleNo = "VehicleNo";

	/** Set Vehicle No	  */
	public void setVehicleNo (String VehicleNo);

	/** Get Vehicle No	  */
	public String getVehicleNo();

    /** Column name VendorDCNo */
    public static final String COLUMNNAME_VendorDCNo = "VendorDCNo";

	/** Set Vendor DC #	  */
	public void setVendorDCNo (String VendorDCNo);

	/** Get Vendor DC #	  */
	public String getVendorDCNo();

    /** Column name WeighmentEntryType */
    public static final String COLUMNNAME_WeighmentEntryType = "WeighmentEntryType";

	/** Set Type	  */
	public void setWeighmentEntryType (String WeighmentEntryType);

	/** Get Type	  */
	public String getWeighmentEntryType();
}
