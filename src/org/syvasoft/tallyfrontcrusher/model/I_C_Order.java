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

/** Generated Interface for C_Order
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_C_Order 
{

    /** TableName=C_Order */
    public static final String Table_Name = "C_Order";

    /** AD_Table_ID=259 */
    public static final int Table_ID = 259;

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

    /** Column name AD_OrgTrx_ID */
    public static final String COLUMNNAME_AD_OrgTrx_ID = "AD_OrgTrx_ID";

	/** Set Trx Organization.
	  * Performing or initiating organization
	  */
	public void setAD_OrgTrx_ID (int AD_OrgTrx_ID);

	/** Get Trx Organization.
	  * Performing or initiating organization
	  */
	public int getAD_OrgTrx_ID();

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

    /** Column name AmountRefunded */
    public static final String COLUMNNAME_AmountRefunded = "AmountRefunded";

	/** Set AmountRefunded	  */
	public void setAmountRefunded (BigDecimal AmountRefunded);

	/** Get AmountRefunded	  */
	public BigDecimal getAmountRefunded();

    /** Column name AmountTendered */
    public static final String COLUMNNAME_AmountTendered = "AmountTendered";

	/** Set AmountTendered	  */
	public void setAmountTendered (BigDecimal AmountTendered);

	/** Get AmountTendered	  */
	public BigDecimal getAmountTendered();

    /** Column name ApprovedPrice */
    public static final String COLUMNNAME_ApprovedPrice = "ApprovedPrice";

	/** Set Approved Price	  */
	public void setApprovedPrice (BigDecimal ApprovedPrice);

	/** Get Approved Price	  */
	public BigDecimal getApprovedPrice();

    /** Column name BarcodeScanner_POS */
    public static final String COLUMNNAME_BarcodeScanner_POS = "BarcodeScanner_POS";

	/** Set Barcode Scanner	  */
	public void setBarcodeScanner_POS (String BarcodeScanner_POS);

	/** Get Barcode Scanner	  */
	public String getBarcodeScanner_POS();

    /** Column name Bill_BPartner_ID */
    public static final String COLUMNNAME_Bill_BPartner_ID = "Bill_BPartner_ID";

	/** Set Invoice Partner.
	  * Business Partner to be invoiced
	  */
	public void setBill_BPartner_ID (int Bill_BPartner_ID);

	/** Get Invoice Partner.
	  * Business Partner to be invoiced
	  */
	public int getBill_BPartner_ID();

	public org.compiere.model.I_C_BPartner getBill_BPartner() throws RuntimeException;

    /** Column name Bill_Location_ID */
    public static final String COLUMNNAME_Bill_Location_ID = "Bill_Location_ID";

	/** Set Invoice Location.
	  * Business Partner Location for invoicing
	  */
	public void setBill_Location_ID (int Bill_Location_ID);

	/** Get Invoice Location.
	  * Business Partner Location for invoicing
	  */
	public int getBill_Location_ID();

	public org.compiere.model.I_C_BPartner_Location getBill_Location() throws RuntimeException;

    /** Column name Bill_User_ID */
    public static final String COLUMNNAME_Bill_User_ID = "Bill_User_ID";

	/** Set Invoice Contact.
	  * Business Partner Contact for invoicing
	  */
	public void setBill_User_ID (int Bill_User_ID);

	/** Get Invoice Contact.
	  * Business Partner Contact for invoicing
	  */
	public int getBill_User_ID();

	public org.compiere.model.I_AD_User getBill_User() throws RuntimeException;

    /** Column name C_Activity_ID */
    public static final String COLUMNNAME_C_Activity_ID = "C_Activity_ID";

	/** Set Activity.
	  * Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID);

	/** Get Activity.
	  * Business Activity
	  */
	public int getC_Activity_ID();

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException;

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

    /** Column name C_Campaign_ID */
    public static final String COLUMNNAME_C_Campaign_ID = "C_Campaign_ID";

	/** Set Campaign.
	  * Marketing Campaign
	  */
	public void setC_Campaign_ID (int C_Campaign_ID);

	/** Get Campaign.
	  * Marketing Campaign
	  */
	public int getC_Campaign_ID();

	public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException;

    /** Column name C_CashLine_ID */
    public static final String COLUMNNAME_C_CashLine_ID = "C_CashLine_ID";

	/** Set Cash Journal Line.
	  * Cash Journal Line
	  */
	public void setC_CashLine_ID (int C_CashLine_ID);

	/** Get Cash Journal Line.
	  * Cash Journal Line
	  */
	public int getC_CashLine_ID();

	public org.compiere.model.I_C_CashLine getC_CashLine() throws RuntimeException;

    /** Column name C_CashPlanLine_ID */
    public static final String COLUMNNAME_C_CashPlanLine_ID = "C_CashPlanLine_ID";

	/** Set Cash Plan Line	  */
	public void setC_CashPlanLine_ID (int C_CashPlanLine_ID);

	/** Get Cash Plan Line	  */
	public int getC_CashPlanLine_ID();

	public org.compiere.model.I_C_CashPlanLine getC_CashPlanLine() throws RuntimeException;

    /** Column name C_Charge_ID */
    public static final String COLUMNNAME_C_Charge_ID = "C_Charge_ID";

	/** Set Charge.
	  * Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID);

	/** Get Charge.
	  * Additional document charges
	  */
	public int getC_Charge_ID();

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException;

    /** Column name C_ConversionType_ID */
    public static final String COLUMNNAME_C_ConversionType_ID = "C_ConversionType_ID";

	/** Set Currency Type.
	  * Currency Conversion Rate Type
	  */
	public void setC_ConversionType_ID (int C_ConversionType_ID);

	/** Get Currency Type.
	  * Currency Conversion Rate Type
	  */
	public int getC_ConversionType_ID();

	public org.compiere.model.I_C_ConversionType getC_ConversionType() throws RuntimeException;

    /** Column name C_Currency_ID */
    public static final String COLUMNNAME_C_Currency_ID = "C_Currency_ID";

	/** Set Currency.
	  * The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID);

	/** Get Currency.
	  * The Currency for this record
	  */
	public int getC_Currency_ID();

	public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException;

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

    /** Column name C_DocTypeTarget_ID */
    public static final String COLUMNNAME_C_DocTypeTarget_ID = "C_DocTypeTarget_ID";

	/** Set Target Document Type.
	  * Target document type for conversing documents
	  */
	public void setC_DocTypeTarget_ID (int C_DocTypeTarget_ID);

	/** Get Target Document Type.
	  * Target document type for conversing documents
	  */
	public int getC_DocTypeTarget_ID();

	public org.compiere.model.I_C_DocType getC_DocTypeTarget() throws RuntimeException;

    /** Column name C_Opportunity_ID */
    public static final String COLUMNNAME_C_Opportunity_ID = "C_Opportunity_ID";

	/** Set Sales Opportunity	  */
	public void setC_Opportunity_ID (int C_Opportunity_ID);

	/** Get Sales Opportunity	  */
	public int getC_Opportunity_ID();

	public org.compiere.model.I_C_Opportunity getC_Opportunity() throws RuntimeException;

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

    /** Column name C_Order_UU */
    public static final String COLUMNNAME_C_Order_UU = "C_Order_UU";

	/** Set C_Order_UU	  */
	public void setC_Order_UU (String C_Order_UU);

	/** Get C_Order_UU	  */
	public String getC_Order_UU();

    /** Column name C_OrderSource_ID */
    public static final String COLUMNNAME_C_OrderSource_ID = "C_OrderSource_ID";

	/** Set Order Source	  */
	public void setC_OrderSource_ID (int C_OrderSource_ID);

	/** Get Order Source	  */
	public int getC_OrderSource_ID();

	public org.compiere.model.I_C_OrderSource getC_OrderSource() throws RuntimeException;

    /** Column name C_Payment_ID */
    public static final String COLUMNNAME_C_Payment_ID = "C_Payment_ID";

	/** Set Payment.
	  * Payment identifier
	  */
	public void setC_Payment_ID (int C_Payment_ID);

	/** Get Payment.
	  * Payment identifier
	  */
	public int getC_Payment_ID();

	public org.compiere.model.I_C_Payment getC_Payment() throws RuntimeException;

    /** Column name C_PaymentSalesDiscount_ID */
    public static final String COLUMNNAME_C_PaymentSalesDiscount_ID = "C_PaymentSalesDiscount_ID";

	/** Set Sales Discount Payment	  */
	public void setC_PaymentSalesDiscount_ID (int C_PaymentSalesDiscount_ID);

	/** Get Sales Discount Payment	  */
	public int getC_PaymentSalesDiscount_ID();

	public org.compiere.model.I_C_Payment getC_PaymentSalesDiscount() throws RuntimeException;

    /** Column name C_PaymentTerm_ID */
    public static final String COLUMNNAME_C_PaymentTerm_ID = "C_PaymentTerm_ID";

	/** Set Payment Term.
	  * The terms of Payment (timing, discount)
	  */
	public void setC_PaymentTerm_ID (int C_PaymentTerm_ID);

	/** Get Payment Term.
	  * The terms of Payment (timing, discount)
	  */
	public int getC_PaymentTerm_ID();

	public org.compiere.model.I_C_PaymentTerm getC_PaymentTerm() throws RuntimeException;

    /** Column name C_POS_ID */
    public static final String COLUMNNAME_C_POS_ID = "C_POS_ID";

	/** Set POS Terminal.
	  * Point of Sales Terminal
	  */
	public void setC_POS_ID (int C_POS_ID);

	/** Get POS Terminal.
	  * Point of Sales Terminal
	  */
	public int getC_POS_ID();

	public org.compiere.model.I_C_POS getC_POS() throws RuntimeException;

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

    /** Column name ChargeAmt */
    public static final String COLUMNNAME_ChargeAmt = "ChargeAmt";

	/** Set Charge amount.
	  * Charge Amount
	  */
	public void setChargeAmt (BigDecimal ChargeAmt);

	/** Get Charge amount.
	  * Charge Amount
	  */
	public BigDecimal getChargeAmt();

    /** Column name CopyFrom */
    public static final String COLUMNNAME_CopyFrom = "CopyFrom";

	/** Set Copy From.
	  * Copy From Record
	  */
	public void setCopyFrom (String CopyFrom);

	/** Get Copy From.
	  * Copy From Record
	  */
	public String getCopyFrom();

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

    /** Column name CreateDiscountRequest */
    public static final String COLUMNNAME_CreateDiscountRequest = "CreateDiscountRequest";

	/** Set Create Discount Request	  */
	public void setCreateDiscountRequest (String CreateDiscountRequest);

	/** Get Create Discount Request	  */
	public String getCreateDiscountRequest();

    /** Column name CreateTaxInvoice */
    public static final String COLUMNNAME_CreateTaxInvoice = "CreateTaxInvoice";

	/** Set Create Tax Invoice	  */
	public void setCreateTaxInvoice (String CreateTaxInvoice);

	/** Get Create Tax Invoice	  */
	public String getCreateTaxInvoice();

    /** Column name CreateTransporterInvoice */
    public static final String COLUMNNAME_CreateTransporterInvoice = "CreateTransporterInvoice";

	/** Set Create Transporter Invoice	  */
	public void setCreateTransporterInvoice (boolean CreateTransporterInvoice);

	/** Get Create Transporter Invoice	  */
	public boolean isCreateTransporterInvoice();

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

    /** Column name DateOrdered */
    public static final String COLUMNNAME_DateOrdered = "DateOrdered";

	/** Set Date Ordered.
	  * Date of Order
	  */
	public void setDateOrdered (Timestamp DateOrdered);

	/** Get Date Ordered.
	  * Date of Order
	  */
	public Timestamp getDateOrdered();

    /** Column name DatePrinted */
    public static final String COLUMNNAME_DatePrinted = "DatePrinted";

	/** Set Date printed.
	  * Date the document was printed.
	  */
	public void setDatePrinted (Timestamp DatePrinted);

	/** Get Date printed.
	  * Date the document was printed.
	  */
	public Timestamp getDatePrinted();

    /** Column name DatePromised */
    public static final String COLUMNNAME_DatePromised = "DatePromised";

	/** Set Date Promised.
	  * Date Order was promised
	  */
	public void setDatePromised (Timestamp DatePromised);

	/** Get Date Promised.
	  * Date Order was promised
	  */
	public Timestamp getDatePromised();

    /** Column name DeliveryChallan */
    public static final String COLUMNNAME_DeliveryChallan = "DeliveryChallan";

	/** Set Delivery Challan	  */
	public void setDeliveryChallan (String DeliveryChallan);

	/** Get Delivery Challan	  */
	public String getDeliveryChallan();

    /** Column name DeliveryChallanTP */
    public static final String COLUMNNAME_DeliveryChallanTP = "DeliveryChallanTP";

	/** Set Delivery Challan (TP)	  */
	public void setDeliveryChallanTP (String DeliveryChallanTP);

	/** Get Delivery Challan (TP)	  */
	public String getDeliveryChallanTP();

    /** Column name DeliveryRule */
    public static final String COLUMNNAME_DeliveryRule = "DeliveryRule";

	/** Set Delivery Rule.
	  * Defines the timing of Delivery
	  */
	public void setDeliveryRule (String DeliveryRule);

	/** Get Delivery Rule.
	  * Defines the timing of Delivery
	  */
	public String getDeliveryRule();

    /** Column name DeliveryViaRule */
    public static final String COLUMNNAME_DeliveryViaRule = "DeliveryViaRule";

	/** Set Delivery Via.
	  * How the order will be delivered
	  */
	public void setDeliveryViaRule (String DeliveryViaRule);

	/** Get Delivery Via.
	  * How the order will be delivered
	  */
	public String getDeliveryViaRule();

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

    /** Column name DiscntStatus */
    public static final String COLUMNNAME_DiscntStatus = "DiscntStatus";

	/** Set Discount Status	  */
	public void setDiscntStatus (String DiscntStatus);

	/** Get Discount Status	  */
	public String getDiscntStatus();

    /** Column name Distance */
    public static final String COLUMNNAME_Distance = "Distance";

	/** Set Distance (km)	  */
	public void setDistance (BigDecimal Distance);

	/** Get Distance (km)	  */
	public BigDecimal getDistance();

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

    /** Column name DriverTips */
    public static final String COLUMNNAME_DriverTips = "DriverTips";

	/** Set Driver Tips	  */
	public void setDriverTips (BigDecimal DriverTips);

	/** Get Driver Tips	  */
	public BigDecimal getDriverTips();

    /** Column name DropShip_BPartner_ID */
    public static final String COLUMNNAME_DropShip_BPartner_ID = "DropShip_BPartner_ID";

	/** Set Drop Ship Business Partner.
	  * Business Partner to ship to
	  */
	public void setDropShip_BPartner_ID (int DropShip_BPartner_ID);

	/** Get Drop Ship Business Partner.
	  * Business Partner to ship to
	  */
	public int getDropShip_BPartner_ID();

	public org.compiere.model.I_C_BPartner getDropShip_BPartner() throws RuntimeException;

    /** Column name DropShip_Location_ID */
    public static final String COLUMNNAME_DropShip_Location_ID = "DropShip_Location_ID";

	/** Set Drop Shipment Location.
	  * Business Partner Location for shipping to
	  */
	public void setDropShip_Location_ID (int DropShip_Location_ID);

	/** Get Drop Shipment Location.
	  * Business Partner Location for shipping to
	  */
	public int getDropShip_Location_ID();

	public org.compiere.model.I_C_BPartner_Location getDropShip_Location() throws RuntimeException;

    /** Column name DropShip_User_ID */
    public static final String COLUMNNAME_DropShip_User_ID = "DropShip_User_ID";

	/** Set Drop Shipment Contact.
	  * Business Partner Contact for drop shipment
	  */
	public void setDropShip_User_ID (int DropShip_User_ID);

	/** Get Drop Shipment Contact.
	  * Business Partner Contact for drop shipment
	  */
	public int getDropShip_User_ID();

	public org.compiere.model.I_AD_User getDropShip_User() throws RuntimeException;

    /** Column name FreightAmt */
    public static final String COLUMNNAME_FreightAmt = "FreightAmt";

	/** Set Freight Amount.
	  * Freight Amount 
	  */
	public void setFreightAmt (BigDecimal FreightAmt);

	/** Get Freight Amount.
	  * Freight Amount 
	  */
	public BigDecimal getFreightAmt();

    /** Column name FreightCostRule */
    public static final String COLUMNNAME_FreightCostRule = "FreightCostRule";

	/** Set Freight Cost Rule.
	  * Method for charging Freight
	  */
	public void setFreightCostRule (String FreightCostRule);

	/** Get Freight Cost Rule.
	  * Method for charging Freight
	  */
	public String getFreightCostRule();

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

    /** Column name InvoiceRule */
    public static final String COLUMNNAME_InvoiceRule = "InvoiceRule";

	/** Set Invoice Rule.
	  * Frequency and method of invoicing 
	  */
	public void setInvoiceRule (String InvoiceRule);

	/** Get Invoice Rule.
	  * Frequency and method of invoicing 
	  */
	public String getInvoiceRule();

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

    /** Column name IsApproved */
    public static final String COLUMNNAME_IsApproved = "IsApproved";

	/** Set Approved.
	  * Indicates if this document requires approval
	  */
	public void setIsApproved (boolean IsApproved);

	/** Get Approved.
	  * Indicates if this document requires approval
	  */
	public boolean isApproved();

    /** Column name IsCreditApproved */
    public static final String COLUMNNAME_IsCreditApproved = "IsCreditApproved";

	/** Set Credit Approved.
	  * Credit  has been approved
	  */
	public void setIsCreditApproved (boolean IsCreditApproved);

	/** Get Credit Approved.
	  * Credit  has been approved
	  */
	public boolean isCreditApproved();

    /** Column name IsDelivered */
    public static final String COLUMNNAME_IsDelivered = "IsDelivered";

	/** Set Delivered	  */
	public void setIsDelivered (boolean IsDelivered);

	/** Get Delivered	  */
	public boolean isDelivered();

    /** Column name IsDiscountPrinted */
    public static final String COLUMNNAME_IsDiscountPrinted = "IsDiscountPrinted";

	/** Set Discount Printed.
	  * Print Discount on Invoice and Order
	  */
	public void setIsDiscountPrinted (boolean IsDiscountPrinted);

	/** Get Discount Printed.
	  * Print Discount on Invoice and Order
	  */
	public boolean isDiscountPrinted();

    /** Column name IsDropShip */
    public static final String COLUMNNAME_IsDropShip = "IsDropShip";

	/** Set Drop Shipment.
	  * Drop Shipments are sent from the Vendor directly to the Customer
	  */
	public void setIsDropShip (boolean IsDropShip);

	/** Get Drop Shipment.
	  * Drop Shipments are sent from the Vendor directly to the Customer
	  */
	public boolean isDropShip();

    /** Column name IsInvoiced */
    public static final String COLUMNNAME_IsInvoiced = "IsInvoiced";

	/** Set Invoiced.
	  * Is this invoiced?
	  */
	public void setIsInvoiced (boolean IsInvoiced);

	/** Get Invoiced.
	  * Is this invoiced?
	  */
	public boolean isInvoiced();

    /** Column name IsLumpSumRent */
    public static final String COLUMNNAME_IsLumpSumRent = "IsLumpSumRent";

	/** Set Lump Sum Rent	  */
	public void setIsLumpSumRent (boolean IsLumpSumRent);

	/** Get Lump Sum Rent	  */
	public boolean isLumpSumRent();

    /** Column name IsPayScheduleValid */
    public static final String COLUMNNAME_IsPayScheduleValid = "IsPayScheduleValid";

	/** Set Pay Schedule valid.
	  * Is the Payment Schedule is valid
	  */
	public void setIsPayScheduleValid (boolean IsPayScheduleValid);

	/** Get Pay Schedule valid.
	  * Is the Payment Schedule is valid
	  */
	public boolean isPayScheduleValid();

    /** Column name IsPrinted */
    public static final String COLUMNNAME_IsPrinted = "IsPrinted";

	/** Set Printed.
	  * Indicates if this document / line is printed
	  */
	public void setIsPrinted (boolean IsPrinted);

	/** Get Printed.
	  * Indicates if this document / line is printed
	  */
	public boolean isPrinted();

    /** Column name IsPriviledgedRate */
    public static final String COLUMNNAME_IsPriviledgedRate = "IsPriviledgedRate";

	/** Set Priviledged Rate	  */
	public void setIsPriviledgedRate (boolean IsPriviledgedRate);

	/** Get Priviledged Rate	  */
	public boolean isPriviledgedRate();

    /** Column name IsRentBreakup */
    public static final String COLUMNNAME_IsRentBreakup = "IsRentBreakup";

	/** Set Show Rent Breakup	  */
	public void setIsRentBreakup (boolean IsRentBreakup);

	/** Get Show Rent Breakup	  */
	public boolean isRentBreakup();

    /** Column name IsRentInclusive */
    public static final String COLUMNNAME_IsRentInclusive = "IsRentInclusive";

	/** Set Rent Inclusive.
	  * Whether Unit Price includes rent?
	  */
	public void setIsRentInclusive (boolean IsRentInclusive);

	/** Get Rent Inclusive.
	  * Whether Unit Price includes rent?
	  */
	public boolean isRentInclusive();

    /** Column name IsRoyaltyPassInclusive */
    public static final String COLUMNNAME_IsRoyaltyPassInclusive = "IsRoyaltyPassInclusive";

	/** Set Royalty Pass Inclusive	  */
	public void setIsRoyaltyPassInclusive (boolean IsRoyaltyPassInclusive);

	/** Get Royalty Pass Inclusive	  */
	public boolean isRoyaltyPassInclusive();

    /** Column name IsSelected */
    public static final String COLUMNNAME_IsSelected = "IsSelected";

	/** Set Selected	  */
	public void setIsSelected (boolean IsSelected);

	/** Get Selected	  */
	public boolean isSelected();

    /** Column name IsSelfService */
    public static final String COLUMNNAME_IsSelfService = "IsSelfService";

	/** Set Self-Service.
	  * This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public void setIsSelfService (boolean IsSelfService);

	/** Get Self-Service.
	  * This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public boolean isSelfService();

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

    /** Column name IssueToSubcontract_ID */
    public static final String COLUMNNAME_IssueToSubcontract_ID = "IssueToSubcontract_ID";

	/** Set Issue to Subcontract	  */
	public void setIssueToSubcontract_ID (int IssueToSubcontract_ID);

	/** Get Issue to Subcontract	  */
	public int getIssueToSubcontract_ID();

	public org.compiere.model.I_C_Project getIssueToSubcontract() throws RuntimeException;

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

    /** Column name IsTaxIncluded1 */
    public static final String COLUMNNAME_IsTaxIncluded1 = "IsTaxIncluded1";

	/** Set IsTaxIncluded1	  */
	public void setIsTaxIncluded1 (boolean IsTaxIncluded1);

	/** Get IsTaxIncluded1	  */
	public boolean isTaxIncluded1();

    /** Column name IsTicketPrinter */
    public static final String COLUMNNAME_IsTicketPrinter = "IsTicketPrinter";

	/** Set Ticket Printer	  */
	public void setIsTicketPrinter (boolean IsTicketPrinter);

	/** Get Ticket Printer	  */
	public boolean isTicketPrinter();

    /** Column name IsTransferred */
    public static final String COLUMNNAME_IsTransferred = "IsTransferred";

	/** Set Transferred.
	  * Transferred to General Ledger (i.e. accounted)
	  */
	public void setIsTransferred (boolean IsTransferred);

	/** Get Transferred.
	  * Transferred to General Ledger (i.e. accounted)
	  */
	public boolean isTransferred();

    /** Column name Item1_Amt */
    public static final String COLUMNNAME_Item1_Amt = "Item1_Amt";

	/** Set Item1 Amount	  */
	public void setItem1_Amt (BigDecimal Item1_Amt);

	/** Get Item1 Amount	  */
	public BigDecimal getItem1_Amt();

    /** Column name Item1_BucketQty */
    public static final String COLUMNNAME_Item1_BucketQty = "Item1_BucketQty";

	/** Set Bucket Qty	  */
	public void setItem1_BucketQty (BigDecimal Item1_BucketQty);

	/** Get Bucket Qty	  */
	public BigDecimal getItem1_BucketQty();

    /** Column name Item1_BucketRate */
    public static final String COLUMNNAME_Item1_BucketRate = "Item1_BucketRate";

	/** Set Bucket Rate	  */
	public void setItem1_BucketRate (BigDecimal Item1_BucketRate);

	/** Get Bucket Rate	  */
	public BigDecimal getItem1_BucketRate();

    /** Column name Item1_C_OrderLine_ID */
    public static final String COLUMNNAME_Item1_C_OrderLine_ID = "Item1_C_OrderLine_ID";

	/** Set Item1 OrderLine ID	  */
	public void setItem1_C_OrderLine_ID (int Item1_C_OrderLine_ID);

	/** Get Item1 OrderLine ID	  */
	public int getItem1_C_OrderLine_ID();

	public org.compiere.model.I_C_OrderLine getItem1_C_OrderLine() throws RuntimeException;

    /** Column name Item1_Desc */
    public static final String COLUMNNAME_Item1_Desc = "Item1_Desc";

	/** Set Description	  */
	public void setItem1_Desc (String Item1_Desc);

	/** Get Description	  */
	public String getItem1_Desc();

    /** Column name Item1_ID */
    public static final String COLUMNNAME_Item1_ID = "Item1_ID";

	/** Set Item1	  */
	public void setItem1_ID (int Item1_ID);

	/** Get Item1	  */
	public int getItem1_ID();

	public org.compiere.model.I_M_Product getItem1() throws RuntimeException;

    /** Column name Item1_IsPermitSales */
    public static final String COLUMNNAME_Item1_IsPermitSales = "Item1_IsPermitSales";

	/** Set Permit Sales	  */
	public void setItem1_IsPermitSales (boolean Item1_IsPermitSales);

	/** Get Permit Sales	  */
	public boolean isItem1_IsPermitSales();

    /** Column name Item1_IsUpdatePrice */
    public static final String COLUMNNAME_Item1_IsUpdatePrice = "Item1_IsUpdatePrice";

	/** Set Update Price.
	  * Update Price into Price List
	  */
	public void setItem1_IsUpdatePrice (boolean Item1_IsUpdatePrice);

	/** Get Update Price.
	  * Update Price into Price List
	  */
	public boolean isItem1_IsUpdatePrice();

    /** Column name Item1_PassUnitPrice */
    public static final String COLUMNNAME_Item1_PassUnitPrice = "Item1_PassUnitPrice";

	/** Set Royalty Pass Unit Price	  */
	public void setItem1_PassUnitPrice (BigDecimal Item1_PassUnitPrice);

	/** Get Royalty Pass Unit Price	  */
	public BigDecimal getItem1_PassUnitPrice();

    /** Column name Item1_PermitIssued */
    public static final String COLUMNNAME_Item1_PermitIssued = "Item1_PermitIssued";

	/** Set Permit Issued	  */
	public void setItem1_PermitIssued (BigDecimal Item1_PermitIssued);

	/** Get Permit Issued	  */
	public BigDecimal getItem1_PermitIssued();

    /** Column name Item1_Price */
    public static final String COLUMNNAME_Item1_Price = "Item1_Price";

	/** Set Item1 Price	  */
	public void setItem1_Price (BigDecimal Item1_Price);

	/** Get Item1 Price	  */
	public BigDecimal getItem1_Price();

    /** Column name Item1_Qty */
    public static final String COLUMNNAME_Item1_Qty = "Item1_Qty";

	/** Set Item1 Qty	  */
	public void setItem1_Qty (BigDecimal Item1_Qty);

	/** Get Item1 Qty	  */
	public BigDecimal getItem1_Qty();

    /** Column name Item1_SandType */
    public static final String COLUMNNAME_Item1_SandType = "Item1_SandType";

	/** Set Sand Type	  */
	public void setItem1_SandType (String Item1_SandType);

	/** Get Sand Type	  */
	public String getItem1_SandType();

    /** Column name Item1_Tax_ID */
    public static final String COLUMNNAME_Item1_Tax_ID = "Item1_Tax_ID";

	/** Set Tax.
	  * Tax Identifier
	  */
	public void setItem1_Tax_ID (int Item1_Tax_ID);

	/** Get Tax.
	  * Tax Identifier
	  */
	public int getItem1_Tax_ID();

	public org.compiere.model.I_C_Tax getItem1_Tax() throws RuntimeException;

    /** Column name Item1_TotalLoad */
    public static final String COLUMNNAME_Item1_TotalLoad = "Item1_TotalLoad";

	/** Set Total Load	  */
	public void setItem1_TotalLoad (BigDecimal Item1_TotalLoad);

	/** Get Total Load	  */
	public BigDecimal getItem1_TotalLoad();

    /** Column name Item1_UnitPrice */
    public static final String COLUMNNAME_Item1_UnitPrice = "Item1_UnitPrice";

	/** Set Unit Price	  */
	public void setItem1_UnitPrice (BigDecimal Item1_UnitPrice);

	/** Get Unit Price	  */
	public BigDecimal getItem1_UnitPrice();

    /** Column name Item1_UnitRent */
    public static final String COLUMNNAME_Item1_UnitRent = "Item1_UnitRent";

	/** Set Unit Rent	  */
	public void setItem1_UnitRent (BigDecimal Item1_UnitRent);

	/** Get Unit Rent	  */
	public BigDecimal getItem1_UnitRent();

    /** Column name Item1_UOM_ID */
    public static final String COLUMNNAME_Item1_UOM_ID = "Item1_UOM_ID";

	/** Set UOM	  */
	public void setItem1_UOM_ID (int Item1_UOM_ID);

	/** Get UOM	  */
	public int getItem1_UOM_ID();

	public org.compiere.model.I_C_UOM getItem1_UOM() throws RuntimeException;

    /** Column name Item1_VehicleType_ID */
    public static final String COLUMNNAME_Item1_VehicleType_ID = "Item1_VehicleType_ID";

	/** Set Vehicle Type	  */
	public void setItem1_VehicleType_ID (int Item1_VehicleType_ID);

	/** Get Vehicle Type	  */
	public int getItem1_VehicleType_ID();

    /** Column name Item2_Amt */
    public static final String COLUMNNAME_Item2_Amt = "Item2_Amt";

	/** Set Item2 Amount	  */
	public void setItem2_Amt (BigDecimal Item2_Amt);

	/** Get Item2 Amount	  */
	public BigDecimal getItem2_Amt();

    /** Column name Item2_BucketQty */
    public static final String COLUMNNAME_Item2_BucketQty = "Item2_BucketQty";

	/** Set Bucket Qty	  */
	public void setItem2_BucketQty (BigDecimal Item2_BucketQty);

	/** Get Bucket Qty	  */
	public BigDecimal getItem2_BucketQty();

    /** Column name Item2_BucketRate */
    public static final String COLUMNNAME_Item2_BucketRate = "Item2_BucketRate";

	/** Set Bucket Rate	  */
	public void setItem2_BucketRate (BigDecimal Item2_BucketRate);

	/** Get Bucket Rate	  */
	public BigDecimal getItem2_BucketRate();

    /** Column name Item2_C_OrderLine_ID */
    public static final String COLUMNNAME_Item2_C_OrderLine_ID = "Item2_C_OrderLine_ID";

	/** Set Item2 OrderLine ID	  */
	public void setItem2_C_OrderLine_ID (int Item2_C_OrderLine_ID);

	/** Get Item2 OrderLine ID	  */
	public int getItem2_C_OrderLine_ID();

	public org.compiere.model.I_C_OrderLine getItem2_C_OrderLine() throws RuntimeException;

    /** Column name Item2_Desc */
    public static final String COLUMNNAME_Item2_Desc = "Item2_Desc";

	/** Set Description	  */
	public void setItem2_Desc (String Item2_Desc);

	/** Get Description	  */
	public String getItem2_Desc();

    /** Column name Item2_ID */
    public static final String COLUMNNAME_Item2_ID = "Item2_ID";

	/** Set Item2	  */
	public void setItem2_ID (int Item2_ID);

	/** Get Item2	  */
	public int getItem2_ID();

	public org.compiere.model.I_M_Product getItem2() throws RuntimeException;

    /** Column name Item2_IsPermitSales */
    public static final String COLUMNNAME_Item2_IsPermitSales = "Item2_IsPermitSales";

	/** Set Permit Sales	  */
	public void setItem2_IsPermitSales (boolean Item2_IsPermitSales);

	/** Get Permit Sales	  */
	public boolean isItem2_IsPermitSales();

    /** Column name Item2_Price */
    public static final String COLUMNNAME_Item2_Price = "Item2_Price";

	/** Set Item2 Price	  */
	public void setItem2_Price (BigDecimal Item2_Price);

	/** Get Item2 Price	  */
	public BigDecimal getItem2_Price();

    /** Column name Item2_Qty */
    public static final String COLUMNNAME_Item2_Qty = "Item2_Qty";

	/** Set Item2 Qty	  */
	public void setItem2_Qty (BigDecimal Item2_Qty);

	/** Get Item2 Qty	  */
	public BigDecimal getItem2_Qty();

    /** Column name Item2_SandType */
    public static final String COLUMNNAME_Item2_SandType = "Item2_SandType";

	/** Set Sand Type	  */
	public void setItem2_SandType (String Item2_SandType);

	/** Get Sand Type	  */
	public String getItem2_SandType();

    /** Column name Item2_Tax_ID */
    public static final String COLUMNNAME_Item2_Tax_ID = "Item2_Tax_ID";

	/** Set Tax.
	  * Tax Identifier
	  */
	public void setItem2_Tax_ID (int Item2_Tax_ID);

	/** Get Tax.
	  * Tax Identifier
	  */
	public int getItem2_Tax_ID();

	public org.compiere.model.I_C_Tax getItem2_Tax() throws RuntimeException;

    /** Column name Item2_TonePerBucket */
    public static final String COLUMNNAME_Item2_TonePerBucket = "Item2_TonePerBucket";

	/** Set Tone (per Bucket)	  */
	public void setItem2_TonePerBucket (BigDecimal Item2_TonePerBucket);

	/** Get Tone (per Bucket)	  */
	public BigDecimal getItem2_TonePerBucket();

    /** Column name Item2_TotalLoad */
    public static final String COLUMNNAME_Item2_TotalLoad = "Item2_TotalLoad";

	/** Set Total Load	  */
	public void setItem2_TotalLoad (BigDecimal Item2_TotalLoad);

	/** Get Total Load	  */
	public BigDecimal getItem2_TotalLoad();

    /** Column name Item2_UOM_ID */
    public static final String COLUMNNAME_Item2_UOM_ID = "Item2_UOM_ID";

	/** Set UOM	  */
	public void setItem2_UOM_ID (int Item2_UOM_ID);

	/** Get UOM	  */
	public int getItem2_UOM_ID();

	public org.compiere.model.I_C_UOM getItem2_UOM() throws RuntimeException;

    /** Column name ItemName */
    public static final String COLUMNNAME_ItemName = "ItemName";

	/** Set Print Item Name	  */
	public void setItemName (String ItemName);

	/** Get Print Item Name	  */
	public String getItemName();

    /** Column name KBD_Msg */
    public static final String COLUMNNAME_KBD_Msg = "KBD_Msg";

	/** Set Kanban Message	  */
	public void setKBD_Msg (String KBD_Msg);

	/** Get Kanban Message	  */
	public String getKBD_Msg();

    /** Column name Link_Order_ID */
    public static final String COLUMNNAME_Link_Order_ID = "Link_Order_ID";

	/** Set Linked Order.
	  * This field links a sales order to the purchase order that is generated from it.
	  */
	public void setLink_Order_ID (int Link_Order_ID);

	/** Get Linked Order.
	  * This field links a sales order to the purchase order that is generated from it.
	  */
	public int getLink_Order_ID();

	public org.compiere.model.I_C_Order getLink_Order() throws RuntimeException;

    /** Column name M_FreightCategory_ID */
    public static final String COLUMNNAME_M_FreightCategory_ID = "M_FreightCategory_ID";

	/** Set Freight Category.
	  * Category of the Freight
	  */
	public void setM_FreightCategory_ID (int M_FreightCategory_ID);

	/** Get Freight Category.
	  * Category of the Freight
	  */
	public int getM_FreightCategory_ID();

	public org.compiere.model.I_M_FreightCategory getM_FreightCategory() throws RuntimeException;

    /** Column name M_PriceList_ID */
    public static final String COLUMNNAME_M_PriceList_ID = "M_PriceList_ID";

	/** Set Price List.
	  * Unique identifier of a Price List
	  */
	public void setM_PriceList_ID (int M_PriceList_ID);

	/** Get Price List.
	  * Unique identifier of a Price List
	  */
	public int getM_PriceList_ID();

	public org.compiere.model.I_M_PriceList getM_PriceList() throws RuntimeException;

    /** Column name M_Shipper_ID */
    public static final String COLUMNNAME_M_Shipper_ID = "M_Shipper_ID";

	/** Set Shipper.
	  * Method or manner of product delivery
	  */
	public void setM_Shipper_ID (int M_Shipper_ID);

	/** Get Shipper.
	  * Method or manner of product delivery
	  */
	public int getM_Shipper_ID();

	public org.compiere.model.I_M_Shipper getM_Shipper() throws RuntimeException;

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

    /** Column name OnAccount */
    public static final String COLUMNNAME_OnAccount = "OnAccount";

	/** Set On Account	  */
	public void setOnAccount (boolean OnAccount);

	/** Get On Account	  */
	public boolean isOnAccount();

    /** Column name OrgType */
    public static final String COLUMNNAME_OrgType = "OrgType";

	/** Set Organization Type	  */
	public void setOrgType (String OrgType);

	/** Get Organization Type	  */
	public String getOrgType();

    /** Column name PartyName */
    public static final String COLUMNNAME_PartyName = "PartyName";

	/** Set Party Name	  */
	public void setPartyName (String PartyName);

	/** Get Party Name	  */
	public String getPartyName();

    /** Column name Pay_BPartner_ID */
    public static final String COLUMNNAME_Pay_BPartner_ID = "Pay_BPartner_ID";

	/** Set Payment BPartner.
	  * Business Partner responsible for the payment
	  */
	public void setPay_BPartner_ID (int Pay_BPartner_ID);

	/** Get Payment BPartner.
	  * Business Partner responsible for the payment
	  */
	public int getPay_BPartner_ID();

    /** Column name Pay_Location_ID */
    public static final String COLUMNNAME_Pay_Location_ID = "Pay_Location_ID";

	/** Set Payment Location.
	  * Location of the Business Partner responsible for the payment
	  */
	public void setPay_Location_ID (int Pay_Location_ID);

	/** Get Payment Location.
	  * Location of the Business Partner responsible for the payment
	  */
	public int getPay_Location_ID();

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

    /** Column name POReference */
    public static final String COLUMNNAME_POReference = "POReference";

	/** Set Order Reference.
	  * Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	  */
	public void setPOReference (String POReference);

	/** Get Order Reference.
	  * Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	  */
	public String getPOReference();

    /** Column name Posted */
    public static final String COLUMNNAME_Posted = "Posted";

	/** Set Posted.
	  * Posting status
	  */
	public void setPosted (boolean Posted);

	/** Get Posted.
	  * Posting status
	  */
	public boolean isPosted();

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

    /** Column name PriorityRule */
    public static final String COLUMNNAME_PriorityRule = "PriorityRule";

	/** Set Priority.
	  * Priority of a document
	  */
	public void setPriorityRule (String PriorityRule);

	/** Get Priority.
	  * Priority of a document
	  */
	public String getPriorityRule();

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

    /** Column name ProcessedOn */
    public static final String COLUMNNAME_ProcessedOn = "ProcessedOn";

	/** Set Processed On.
	  * The date+time (expressed in decimal format) when the document has been processed
	  */
	public void setProcessedOn (BigDecimal ProcessedOn);

	/** Get Processed On.
	  * The date+time (expressed in decimal format) when the document has been processed
	  */
	public BigDecimal getProcessedOn();

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

    /** Column name PromotionCode */
    public static final String COLUMNNAME_PromotionCode = "PromotionCode";

	/** Set Promotion Code.
	  * User entered promotion code at sales time
	  */
	public void setPromotionCode (String PromotionCode);

	/** Get Promotion Code.
	  * User entered promotion code at sales time
	  */
	public String getPromotionCode();

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

    /** Column name QuotationOrder_ID */
    public static final String COLUMNNAME_QuotationOrder_ID = "QuotationOrder_ID";

	/** Set Quotation.
	  * Quotation used for generating this order
	  */
	public void setQuotationOrder_ID (int QuotationOrder_ID);

	/** Get Quotation.
	  * Quotation used for generating this order
	  */
	public int getQuotationOrder_ID();

	public org.compiere.model.I_C_Order getQuotationOrder() throws RuntimeException;

    /** Column name Rate */
    public static final String COLUMNNAME_Rate = "Rate";

	/** Set Rate.
	  * Rate or Tax or Exchange
	  */
	public void setRate (BigDecimal Rate);

	/** Get Rate.
	  * Rate or Tax or Exchange
	  */
	public BigDecimal getRate();

    /** Column name Ref_Order_ID */
    public static final String COLUMNNAME_Ref_Order_ID = "Ref_Order_ID";

	/** Set Referenced Order.
	  * Reference to corresponding Sales/Purchase Order
	  */
	public void setRef_Order_ID (int Ref_Order_ID);

	/** Get Referenced Order.
	  * Reference to corresponding Sales/Purchase Order
	  */
	public int getRef_Order_ID();

	public org.compiere.model.I_C_Order getRef_Order() throws RuntimeException;

    /** Column name Rent_Amt */
    public static final String COLUMNNAME_Rent_Amt = "Rent_Amt";

	/** Set Rent (Amount)	  */
	public void setRent_Amt (BigDecimal Rent_Amt);

	/** Get Rent (Amount)	  */
	public BigDecimal getRent_Amt();

    /** Column name Rent_Tax_ID */
    public static final String COLUMNNAME_Rent_Tax_ID = "Rent_Tax_ID";

	/** Set Tax for Delivery	  */
	public void setRent_Tax_ID (int Rent_Tax_ID);

	/** Get Tax for Delivery	  */
	public int getRent_Tax_ID();

	public org.compiere.model.I_C_Tax getRent_Tax() throws RuntimeException;

    /** Column name RentMargin */
    public static final String COLUMNNAME_RentMargin = "RentMargin";

	/** Set Rent Margin	  */
	public void setRentMargin (BigDecimal RentMargin);

	/** Get Rent Margin	  */
	public BigDecimal getRentMargin();

    /** Column name RentPayable */
    public static final String COLUMNNAME_RentPayable = "RentPayable";

	/** Set Rent Payable.
	  * Rent Payable for Transporter
	  */
	public void setRentPayable (BigDecimal RentPayable);

	/** Get Rent Payable.
	  * Rent Payable for Transporter
	  */
	public BigDecimal getRentPayable();

    /** Column name RequireDiscRequest */
    public static final String COLUMNNAME_RequireDiscRequest = "RequireDiscRequest";

	/** Set Require Discount Request	  */
	public void setRequireDiscRequest (boolean RequireDiscRequest);

	/** Get Require Discount Request	  */
	public boolean isRequireDiscRequest();

    /** Column name Sales_Return */
    public static final String COLUMNNAME_Sales_Return = "Sales_Return";

	/** Set Sales Return	  */
	public void setSales_Return (boolean Sales_Return);

	/** Get Sales Return	  */
	public boolean isSales_Return();

    /** Column name SalesDiscountAmt */
    public static final String COLUMNNAME_SalesDiscountAmt = "SalesDiscountAmt";

	/** Set SalesDiscountAmt	  */
	public void setSalesDiscountAmt (BigDecimal SalesDiscountAmt);

	/** Get SalesDiscountAmt	  */
	public BigDecimal getSalesDiscountAmt();

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

	public org.compiere.model.I_AD_User getSalesRep() throws RuntimeException;

    /** Column name SendEMail */
    public static final String COLUMNNAME_SendEMail = "SendEMail";

	/** Set Send EMail.
	  * Enable sending Document EMail
	  */
	public void setSendEMail (boolean SendEMail);

	/** Get Send EMail.
	  * Enable sending Document EMail
	  */
	public boolean isSendEMail();

    /** Column name ShippingRateInquiry */
    public static final String COLUMNNAME_ShippingRateInquiry = "ShippingRateInquiry";

	/** Set Rate Inquiry	  */
	public void setShippingRateInquiry (String ShippingRateInquiry);

	/** Get Rate Inquiry	  */
	public String getShippingRateInquiry();

    /** Column name Subcon_Invoice_ID */
    public static final String COLUMNNAME_Subcon_Invoice_ID = "Subcon_Invoice_ID";

	/** Set Subcontractor Invoice	  */
	public void setSubcon_Invoice_ID (int Subcon_Invoice_ID);

	/** Get Subcontractor Invoice	  */
	public int getSubcon_Invoice_ID();

	public org.compiere.model.I_C_Invoice getSubcon_Invoice() throws RuntimeException;

    /** Column name Subcon_Receipt_ID */
    public static final String COLUMNNAME_Subcon_Receipt_ID = "Subcon_Receipt_ID";

	/** Set Subcontractor Material Receipt	  */
	public void setSubcon_Receipt_ID (int Subcon_Receipt_ID);

	/** Get Subcontractor Material Receipt	  */
	public int getSubcon_Receipt_ID();

	public org.compiere.model.I_M_InOut getSubcon_Receipt() throws RuntimeException;

    /** Column name TF_BlueMetal_Type */
    public static final String COLUMNNAME_TF_BlueMetal_Type = "TF_BlueMetal_Type";

	/** Set Production Type	  */
	public void setTF_BlueMetal_Type (String TF_BlueMetal_Type);

	/** Get Production Type	  */
	public String getTF_BlueMetal_Type();

    /** Column name TF_Crusher_Production_ID */
    public static final String COLUMNNAME_TF_Crusher_Production_ID = "TF_Crusher_Production_ID";

	/** Set Crusher Production	  */
	public void setTF_Crusher_Production_ID (int TF_Crusher_Production_ID);

	/** Get Crusher Production	  */
	public int getTF_Crusher_Production_ID();

    /** Column name TF_Destination_ID */
    public static final String COLUMNNAME_TF_Destination_ID = "TF_Destination_ID";

	/** Set Destination	  */
	public void setTF_Destination_ID (int TF_Destination_ID);

	/** Get Destination	  */
	public int getTF_Destination_ID();

    /** Column name TF_DiscountRequest_ID */
    public static final String COLUMNNAME_TF_DiscountRequest_ID = "TF_DiscountRequest_ID";

	/** Set Discount Request	  */
	public void setTF_DiscountRequest_ID (int TF_DiscountRequest_ID);

	/** Get Discount Request	  */
	public int getTF_DiscountRequest_ID();

    /** Column name TF_DriverTips_Pay_ID */
    public static final String COLUMNNAME_TF_DriverTips_Pay_ID = "TF_DriverTips_Pay_ID";

	/** Set Driver Tips Payment	  */
	public void setTF_DriverTips_Pay_ID (int TF_DriverTips_Pay_ID);

	/** Get Driver Tips Payment	  */
	public int getTF_DriverTips_Pay_ID();

	public org.compiere.model.I_C_Payment getTF_DriverTips_Pay() throws RuntimeException;

    /** Column name TF_ProductionPlant_ID */
    public static final String COLUMNNAME_TF_ProductionPlant_ID = "TF_ProductionPlant_ID";

	/** Set Production Plant	  */
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID);

	/** Get Production Plant	  */
	public int getTF_ProductionPlant_ID();

    /** Column name TF_RentedVehicle_ID */
    public static final String COLUMNNAME_TF_RentedVehicle_ID = "TF_RentedVehicle_ID";

	/** Set Rented Vehicle	  */
	public void setTF_RentedVehicle_ID (int TF_RentedVehicle_ID);

	/** Get Rented Vehicle	  */
	public int getTF_RentedVehicle_ID();

    /** Column name TF_Send_To */
    public static final String COLUMNNAME_TF_Send_To = "TF_Send_To";

	/** Set Send To	  */
	public void setTF_Send_To (String TF_Send_To);

	/** Get Send To	  */
	public String getTF_Send_To();

    /** Column name TF_TaxInvoice_ID */
    public static final String COLUMNNAME_TF_TaxInvoice_ID = "TF_TaxInvoice_ID";

	/** Set Tax Invoice	  */
	public void setTF_TaxInvoice_ID (int TF_TaxInvoice_ID);

	/** Get Tax Invoice	  */
	public int getTF_TaxInvoice_ID();

    /** Column name TF_Token_ID */
    public static final String COLUMNNAME_TF_Token_ID = "TF_Token_ID";

	/** Set Token	  */
	public void setTF_Token_ID (int TF_Token_ID);

	/** Get Token	  */
	public int getTF_Token_ID();

    /** Column name TF_TRTaxInvoice_ID */
    public static final String COLUMNNAME_TF_TRTaxInvoice_ID = "TF_TRTaxInvoice_ID";

	/** Set Sales Tax Invoice (Trading)	  */
	public void setTF_TRTaxInvoice_ID (int TF_TRTaxInvoice_ID);

	/** Get Sales Tax Invoice (Trading)	  */
	public int getTF_TRTaxInvoice_ID();

    /** Column name TF_WeighmentEntry_ID */
    public static final String COLUMNNAME_TF_WeighmentEntry_ID = "TF_WeighmentEntry_ID";

	/** Set Weighment Entry	  */
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID);

	/** Get Weighment Entry	  */
	public int getTF_WeighmentEntry_ID();

    /** Column name TF_YardEntry_ID */
    public static final String COLUMNNAME_TF_YardEntry_ID = "TF_YardEntry_ID";

	/** Set Yard Entry	  */
	public void setTF_YardEntry_ID (int TF_YardEntry_ID);

	/** Get Yard Entry	  */
	public int getTF_YardEntry_ID();

    /** Column name TF_YardEntryApprove_ID */
    public static final String COLUMNNAME_TF_YardEntryApprove_ID = "TF_YardEntryApprove_ID";

	/** Set Approve Yard Entry	  */
	public void setTF_YardEntryApprove_ID (int TF_YardEntryApprove_ID);

	/** Get Approve Yard Entry	  */
	public int getTF_YardEntryApprove_ID();

    /** Column name TonePerBucket */
    public static final String COLUMNNAME_TonePerBucket = "TonePerBucket";

	/** Set Tone (per Bucket)	  */
	public void setTonePerBucket (BigDecimal TonePerBucket);

	/** Get Tone (per Bucket)	  */
	public BigDecimal getTonePerBucket();

    /** Column name Tonnage */
    public static final String COLUMNNAME_Tonnage = "Tonnage";

	/** Set Tonnage	  */
	public void setTonnage (BigDecimal Tonnage);

	/** Get Tonnage	  */
	public BigDecimal getTonnage();

    /** Column name TotalLines */
    public static final String COLUMNNAME_TotalLines = "TotalLines";

	/** Set Total Lines.
	  * Total of all document lines
	  */
	public void setTotalLines (BigDecimal TotalLines);

	/** Get Total Lines.
	  * Total of all document lines
	  */
	public BigDecimal getTotalLines();

    /** Column name TransporterInvoice_ID */
    public static final String COLUMNNAME_TransporterInvoice_ID = "TransporterInvoice_ID";

	/** Set Transporter Invoice	  */
	public void setTransporterInvoice_ID (int TransporterInvoice_ID);

	/** Get Transporter Invoice	  */
	public int getTransporterInvoice_ID();

	public org.compiere.model.I_C_Invoice getTransporterInvoice() throws RuntimeException;

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

    /** Column name User1_ID */
    public static final String COLUMNNAME_User1_ID = "User1_ID";

	/** Set Profit Center.
	  * User defined list element #1
	  */
	public void setUser1_ID (int User1_ID);

	/** Get Profit Center.
	  * User defined list element #1
	  */
	public int getUser1_ID();

	public org.compiere.model.I_C_ElementValue getUser1() throws RuntimeException;

    /** Column name User2_ID */
    public static final String COLUMNNAME_User2_ID = "User2_ID";

	/** Set User Element List 2.
	  * User defined list element #2
	  */
	public void setUser2_ID (int User2_ID);

	/** Get User Element List 2.
	  * User defined list element #2
	  */
	public int getUser2_ID();

	public org.compiere.model.I_C_ElementValue getUser2() throws RuntimeException;

    /** Column name Vehicle_C_OrderLine_ID */
    public static final String COLUMNNAME_Vehicle_C_OrderLine_ID = "Vehicle_C_OrderLine_ID";

	/** Set Vehicle OrderLine ID	  */
	public void setVehicle_C_OrderLine_ID (int Vehicle_C_OrderLine_ID);

	/** Get Vehicle OrderLine ID	  */
	public int getVehicle_C_OrderLine_ID();

	public org.compiere.model.I_C_OrderLine getVehicle_C_OrderLine() throws RuntimeException;

    /** Column name Vehicle_ID */
    public static final String COLUMNNAME_Vehicle_ID = "Vehicle_ID";

	/** Set Vehicle	  */
	public void setVehicle_ID (int Vehicle_ID);

	/** Get Vehicle	  */
	public int getVehicle_ID();

	public org.compiere.model.I_M_Product getVehicle() throws RuntimeException;

    /** Column name VehicleNo */
    public static final String COLUMNNAME_VehicleNo = "VehicleNo";

	/** Set Vehicle No	  */
	public void setVehicleNo (String VehicleNo);

	/** Get Vehicle No	  */
	public String getVehicleNo();

    /** Column name Volume */
    public static final String COLUMNNAME_Volume = "Volume";

	/** Set Volume.
	  * Volume of a product
	  */
	public void setVolume (BigDecimal Volume);

	/** Get Volume.
	  * Volume of a product
	  */
	public BigDecimal getVolume();

    /** Column name Weight */
    public static final String COLUMNNAME_Weight = "Weight";

	/** Set Weight.
	  * Weight of a product
	  */
	public void setWeight (BigDecimal Weight);

	/** Get Weight.
	  * Weight of a product
	  */
	public BigDecimal getWeight();
}
