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
/** Generated Model - DO NOT CHANGE */
package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for TF_WeighmentEntry
 *  @author iDempiere (generated) 
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="TF_WeighmentEntry")
public class X_TF_WeighmentEntry extends PO implements I_TF_WeighmentEntry, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230226L;

    /** Standard Constructor */
    public X_TF_WeighmentEntry (Properties ctx, int TF_WeighmentEntry_ID, String trxName)
    {
      super (ctx, TF_WeighmentEntry_ID, trxName);
      /** if (TF_WeighmentEntry_ID == 0)
        {
			setCreateTwoInvoices (false);
// N
			setDocumentNo (null);
			setInvoiceType (null);
// AW
			setIsRentInclusive (false);
// N
			setIsRoyaltyPassInclusive (false);
// N
			setIsSecondary (false);
// N
			setIsTaxIncluded (false);
// N
			setPassPricePerUnit (Env.ZERO);
			setProcessed (false);
			setStatus (null);
// IP
			setTF_WeighmentEntry_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_WeighmentEntry (Properties ctx, int TF_WeighmentEntry_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_WeighmentEntry_ID, trxName, virtualColumns);
      /** if (TF_WeighmentEntry_ID == 0)
        {
			setCreateTwoInvoices (false);
// N
			setDocumentNo (null);
			setInvoiceType (null);
// AW
			setIsRentInclusive (false);
// N
			setIsRoyaltyPassInclusive (false);
// N
			setIsSecondary (false);
// N
			setIsTaxIncluded (false);
// N
			setPassPricePerUnit (Env.ZERO);
			setProcessed (false);
			setStatus (null);
// IP
			setTF_WeighmentEntry_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_WeighmentEntry (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_TF_WeighmentEntry[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Actual Weight.
		@param ActualWeight Actual Weight
	*/
	public void setActualWeight (BigDecimal ActualWeight)
	{
		set_Value (COLUMNNAME_ActualWeight, ActualWeight);
	}

	/** Get Actual Weight.
		@return Actual Weight	  */
	public BigDecimal getActualWeight()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ActualWeight);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getAD_User_ID(), get_TrxName());
	}

	/** Set User/Contact.
		@param AD_User_ID User within the system - Internal or Business Partner Contact
	*/
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Amount.
		@param Amount Amount in a defined currency
	*/
	public void setAmount (BigDecimal Amount)
	{
		set_Value (COLUMNNAME_Amount, Amount);
	}

	/** Get Amount.
		@return Amount in a defined currency
	  */
	public BigDecimal getAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Apply TCS.
		@param ApplyTCS Apply TCS
	*/
	public void setApplyTCS (boolean ApplyTCS)
	{
		set_Value (COLUMNNAME_ApplyTCS, Boolean.valueOf(ApplyTCS));
	}

	/** Get Apply TCS.
		@return Apply TCS	  */
	public boolean isApplyTCS()
	{
		Object oo = get_Value(COLUMNNAME_ApplyTCS);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Billing Name.
		@param BillingName Billing Name
	*/
	public void setBillingName (String BillingName)
	{
		set_Value (COLUMNNAME_BillingName, BillingName);
	}

	/** Get Billing Name.
		@return Billing Name	  */
	public String getBillingName()
	{
		return (String)get_Value(COLUMNNAME_BillingName);
	}

	/** Set Bill Price.
		@param BillPrice Bill Price
	*/
	public void setBillPrice (BigDecimal BillPrice)
	{
		set_Value (COLUMNNAME_BillPrice, BillPrice);
	}

	/** Get Bill Price.
		@return Bill Price	  */
	public BigDecimal getBillPrice()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BillPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Bill Price GST.
		@param BillPriceGST Bill Price GST
	*/
	public void setBillPriceGST (boolean BillPriceGST)
	{
		set_Value (COLUMNNAME_BillPriceGST, Boolean.valueOf(BillPriceGST));
	}

	/** Get Bill Price GST.
		@return Bill Price GST	  */
	public boolean isBillPriceGST()
	{
		Object oo = get_Value(COLUMNNAME_BillPriceGST);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getc_bpartnertransporter() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getc_bpartnertransporter_id(), get_TrxName());
	}

	/** Set c_bpartnertransporter_id.
		@param c_bpartnertransporter_id c_bpartnertransporter_id
	*/
	public void setc_bpartnertransporter_id (int c_bpartnertransporter_id)
	{
		throw new IllegalArgumentException ("c_bpartnertransporter_id is virtual column");	}

	/** Get c_bpartnertransporter_id.
		@return c_bpartnertransporter_id	  */
	public int getc_bpartnertransporter_id()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_c_bpartnertransporter_id);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartnerWB() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartnerWB_ID(), get_TrxName());
	}

	/** Set 3rd Party Weighbridge.
		@param C_BPartnerWB_ID 3rd Party Weighbridge
	*/
	public void setC_BPartnerWB_ID (int C_BPartnerWB_ID)
	{
		if (C_BPartnerWB_ID < 1)
			set_Value (COLUMNNAME_C_BPartnerWB_ID, null);
		else
			set_Value (COLUMNNAME_C_BPartnerWB_ID, Integer.valueOf(C_BPartnerWB_ID));
	}

	/** Get 3rd Party Weighbridge.
		@return 3rd Party Weighbridge	  */
	public int getC_BPartnerWB_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartnerWB_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPDriver() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPDriver_ID(), get_TrxName());
	}

	/** Set Driver Name.
		@param C_BPDriver_ID Driver Name
	*/
	public void setC_BPDriver_ID (int C_BPDriver_ID)
	{
		if (C_BPDriver_ID < 1)
			set_Value (COLUMNNAME_C_BPDriver_ID, null);
		else
			set_Value (COLUMNNAME_C_BPDriver_ID, Integer.valueOf(C_BPDriver_ID));
	}

	/** Get Driver Name.
		@return Driver Name	  */
	public int getC_BPDriver_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPDriver_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException
	{
		return (org.compiere.model.I_C_Order)MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_ID)
			.getPO(getC_Order_ID(), get_TrxName());
	}

	/** Set Order.
		@param C_Order_ID Order
	*/
	public void setC_Order_ID (int C_Order_ID)
	{
		if (C_Order_ID < 1)
			set_Value (COLUMNNAME_C_Order_ID, null);
		else
			set_Value (COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
	}

	/** Get Order.
		@return Order
	  */
	public int getC_Order_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException
	{
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_ID)
			.getPO(getC_OrderLine_ID(), get_TrxName());
	}

	/** Set Sales Order Line.
		@param C_OrderLine_ID Sales Order Line
	*/
	public void setC_OrderLine_ID (int C_OrderLine_ID)
	{
		if (C_OrderLine_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_OrderLine_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_OrderLine_ID, Integer.valueOf(C_OrderLine_ID));
	}

	/** Get Sales Order Line.
		@return Sales Order Line
	  */
	public int getC_OrderLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_OrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
	{
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_ID)
			.getPO(getC_Project_ID(), get_TrxName());
	}

	/** Set Subcontract / Project.
		@param C_Project_ID Financial Project
	*/
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1)
			set_Value (COLUMNNAME_C_Project_ID, null);
		else
			set_Value (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Subcontract / Project.
		@return Financial Project
	  */
	public int getC_Project_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException
	{
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_ID)
			.getPO(getC_UOM_ID(), get_TrxName());
	}

	/** Set UOM.
		@param C_UOM_ID Unit of Measure
	*/
	public void setC_UOM_ID (int C_UOM_ID)
	{
		if (C_UOM_ID < 1)
			set_Value (COLUMNNAME_C_UOM_ID, null);
		else
			set_Value (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
	}

	/** Get UOM.
		@return Unit of Measure
	  */
	public int getC_UOM_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Cash Amount.
		@param CashAmount Cash Amount
	*/
	public void setCashAmount (BigDecimal CashAmount)
	{
		throw new IllegalArgumentException ("CashAmount is virtual column");	}

	/** Get Cash Amount.
		@return Cash Amount	  */
	public BigDecimal getCashAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CashAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Change Amt.
		@param ChangeAmt Change Amt
	*/
	public void setChangeAmt (BigDecimal ChangeAmt)
	{
		set_ValueNoCheck (COLUMNNAME_ChangeAmt, ChangeAmt);
	}

	/** Get Change Amt.
		@return Change Amt	  */
	public BigDecimal getChangeAmt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ChangeAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Completed By.
		@param CompletedBy Completed By
	*/
	public void setCompletedBy (String CompletedBy)
	{
		set_Value (COLUMNNAME_CompletedBy, CompletedBy);
	}

	/** Get Completed By.
		@return Completed By	  */
	public String getCompletedBy()
	{
		return (String)get_Value(COLUMNNAME_CompletedBy);
	}

	/** Set Create Two Invoices.
		@param CreateTwoInvoices Create Two Invoices by TP Weight and the remaining Weight
	*/
	public void setCreateTwoInvoices (boolean CreateTwoInvoices)
	{
		set_Value (COLUMNNAME_CreateTwoInvoices, Boolean.valueOf(CreateTwoInvoices));
	}

	/** Get Create Two Invoices.
		@return Create Two Invoices by TP Weight and the remaining Weight
	  */
	public boolean isCreateTwoInvoices()
	{
		Object oo = get_Value(COLUMNNAME_CreateTwoInvoices);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Credit Amount.
		@param CreditAmount Credit Amount
	*/
	public void setCreditAmount (BigDecimal CreditAmount)
	{
		throw new IllegalArgumentException ("CreditAmount is virtual column");	}

	/** Get Credit Amount.
		@return Credit Amount	  */
	public BigDecimal getCreditAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CreditAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Customer&#039;s Transporter.
		@param CustomerTransporter Customer&#039;s Transporter
	*/
	public void setCustomerTransporter (boolean CustomerTransporter)
	{
		set_Value (COLUMNNAME_CustomerTransporter, Boolean.valueOf(CustomerTransporter));
	}

	/** Get Customer&#039;s Transporter.
		@return Customer&#039;s Transporter	  */
	public boolean isCustomerTransporter()
	{
		Object oo = get_Value(COLUMNNAME_CustomerTransporter);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Account Date.
		@param DateAcct Accounting Date
	*/
	public void setDateAcct (Timestamp DateAcct)
	{
		set_Value (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Discount Amount.
		@param DiscountAmount Discount Amount
	*/
	public void setDiscountAmount (BigDecimal DiscountAmount)
	{
		set_Value (COLUMNNAME_DiscountAmount, DiscountAmount);
	}

	/** Get Discount Amount.
		@return Discount Amount	  */
	public BigDecimal getDiscountAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DiscountAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Distribute Rent Amount into GST Invoice.
		@param DistributeRentAmt Distribute Rent Amount into GST Invoice
	*/
	public void setDistributeRentAmt (boolean DistributeRentAmt)
	{
		set_Value (COLUMNNAME_DistributeRentAmt, Boolean.valueOf(DistributeRentAmt));
	}

	/** Get Distribute Rent Amount into GST Invoice.
		@return Distribute Rent Amount into GST Invoice	  */
	public boolean isDistributeRentAmt()
	{
		Object oo = get_Value(COLUMNNAME_DistributeRentAmt);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Document No.
		@param DocumentNo Document sequence number of the document
	*/
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo()
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Driver Contact No.
		@param DriverContact Driver Contact No
	*/
	public void setDriverContact (String DriverContact)
	{
		set_Value (COLUMNNAME_DriverContact, DriverContact);
	}

	/** Get Driver Contact No.
		@return Driver Contact No	  */
	public String getDriverContact()
	{
		return (String)get_Value(COLUMNNAME_DriverContact);
	}

	/** Set Driver Name.
		@param DriverName Driver Name
	*/
	public void setDriverName (String DriverName)
	{
		set_Value (COLUMNNAME_DriverName, DriverName);
	}

	/** Get Driver Name.
		@return Driver Name	  */
	public String getDriverName()
	{
		return (String)get_Value(COLUMNNAME_DriverName);
	}

	/** Set Driver Tips.
		@param DriverTips Driver Tips
	*/
	public void setDriverTips (BigDecimal DriverTips)
	{
		set_Value (COLUMNNAME_DriverTips, DriverTips);
	}

	/** Get Driver Tips.
		@return Driver Tips	  */
	public BigDecimal getDriverTips()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DriverTips);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set eWay Bill No.
		@param eWayBillNo eWay Bill No
	*/
	public void seteWayBillNo (String eWayBillNo)
	{
		set_Value (COLUMNNAME_eWayBillNo, eWayBillNo);
	}

	/** Get eWay Bill No.
		@return eWay Bill No	  */
	public String geteWayBillNo()
	{
		return (String)get_Value(COLUMNNAME_eWayBillNo);
	}

	/** Set Exit Time.
		@param ExitTime Exit Time
	*/
	public void setExitTime (Timestamp ExitTime)
	{
		set_Value (COLUMNNAME_ExitTime, ExitTime);
	}

	/** Get Exit Time.
		@return Exit Time	  */
	public Timestamp getExitTime()
	{
		return (Timestamp)get_Value(COLUMNNAME_ExitTime);
	}

	/** Set Export Customer.
		@param ExportCustomer Export Customer
	*/
	public void setExportCustomer (boolean ExportCustomer)
	{
		set_ValueNoCheck (COLUMNNAME_ExportCustomer, Boolean.valueOf(ExportCustomer));
	}

	/** Get Export Customer.
		@return Export Customer	  */
	public boolean isExportCustomer()
	{
		Object oo = get_Value(COLUMNNAME_ExportCustomer);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Boulder = BOULDER */
	public static final String FIRSTWEIGHBRIDGENAME_Boulder = "BOULDER";
	/** Sales = SALES */
	public static final String FIRSTWEIGHBRIDGENAME_Sales = "SALES";
	/** Stockyard = STOCKYARD */
	public static final String FIRSTWEIGHBRIDGENAME_Stockyard = "STOCKYARD";
	/** Set First Weighbridge Name.
		@param FirstWeighbridgeName First Weighbridge Name
	*/
	public void setFirstWeighbridgeName (String FirstWeighbridgeName)
	{

		set_Value (COLUMNNAME_FirstWeighbridgeName, FirstWeighbridgeName);
	}

	/** Get First Weighbridge Name.
		@return First Weighbridge Name	  */
	public String getFirstWeighbridgeName()
	{
		return (String)get_Value(COLUMNNAME_FirstWeighbridgeName);
	}

	/** Set Freight Rate.
		@param FreightPrice Freight Rate
	*/
	public void setFreightPrice (BigDecimal FreightPrice)
	{
		set_Value (COLUMNNAME_FreightPrice, FreightPrice);
	}

	/** Get Freight Rate.
		@return Freight Rate	  */
	public BigDecimal getFreightPrice()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FreightPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Freight Qty.
		@param FreightQty Own Vehicle Freight Qty for TripSheet and Machinery Statement Posting
	*/
	public void setFreightQty (BigDecimal FreightQty)
	{
		set_Value (COLUMNNAME_FreightQty, FreightQty);
	}

	/** Get Freight Qty.
		@return Own Vehicle Freight Qty for TripSheet and Machinery Statement Posting
	  */
	public BigDecimal getFreightQty()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FreightQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_UOM getFreightRule() throws RuntimeException
	{
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_ID)
			.getPO(getFreightRule_ID(), get_TrxName());
	}

	/** Set Freight Rule.
		@param FreightRule_ID Freight Rule
	*/
	public void setFreightRule_ID (int FreightRule_ID)
	{
		if (FreightRule_ID < 1)
			set_Value (COLUMNNAME_FreightRule_ID, null);
		else
			set_Value (COLUMNNAME_FreightRule_ID, Integer.valueOf(FreightRule_ID));
	}

	/** Get Freight Rule.
		@return Freight Rule
	  */
	public int getFreightRule_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FreightRule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Gross Price.
		@param GrossPrice Gross Price
	*/
	public void setGrossPrice (BigDecimal GrossPrice)
	{
		set_Value (COLUMNNAME_GrossPrice, GrossPrice);
	}

	/** Get Gross Price.
		@return Gross Price	  */
	public BigDecimal getGrossPrice()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GrossPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Gross Rent.
		@param GrossRent Gross Rent
	*/
	public void setGrossRent (BigDecimal GrossRent)
	{
		set_Value (COLUMNNAME_GrossRent, GrossRent);
	}

	/** Get Gross Rent.
		@return Gross Rent	  */
	public BigDecimal getGrossRent()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GrossRent);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Gross Total.
		@param GrossTotal Gross Total
	*/
	public void setGrossTotal (BigDecimal GrossTotal)
	{
		set_Value (COLUMNNAME_GrossTotal, GrossTotal);
	}

	/** Get Gross Total.
		@return Gross Total	  */
	public BigDecimal getGrossTotal()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GrossTotal);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Gross Weight (Kg).
		@param GrossWeight Gross Weight (Kg)
	*/
	public void setGrossWeight (BigDecimal GrossWeight)
	{
		set_Value (COLUMNNAME_GrossWeight, GrossWeight);
	}

	/** Get Gross Weight (Kg).
		@return Gross Weight (Kg)	  */
	public BigDecimal getGrossWeight()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GrossWeight);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Gross Weight Time.
		@param GrossWeightTime Gross Weight Time
	*/
	public void setGrossWeightTime (Timestamp GrossWeightTime)
	{
		set_Value (COLUMNNAME_GrossWeightTime, GrossWeightTime);
	}

	/** Get Gross Weight Time.
		@return Gross Weight Time	  */
	public Timestamp getGrossWeightTime()
	{
		return (Timestamp)get_Value(COLUMNNAME_GrossWeightTime);
	}

	/** Set Gross Weight Time String.
		@param GrossWeightTimeString Gross Weight Time String
	*/
	public void setGrossWeightTimeString (String GrossWeightTimeString)
	{
		throw new IllegalArgumentException ("GrossWeightTimeString is virtual column");	}

	/** Get Gross Weight Time String.
		@return Gross Weight Time String	  */
	public String getGrossWeightTimeString()
	{
		return (String)get_Value(COLUMNNAME_GrossWeightTimeString);
	}

	/** Set GST Amount.
		@param GSTAmount GST Amount
	*/
	public void setGSTAmount (BigDecimal GSTAmount)
	{
		set_Value (COLUMNNAME_GSTAmount, GSTAmount);
	}

	/** Get GST Amount.
		@return GST Amount	  */
	public BigDecimal getGSTAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GSTAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set GST %.
		@param GSTRate GST %
	*/
	public void setGSTRate (BigDecimal GSTRate)
	{
		set_ValueNoCheck (COLUMNNAME_GSTRate, GSTRate);
	}

	/** Get GST %.
		@return GST %	  */
	public BigDecimal getGSTRate()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GSTRate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Has Balance.
		@param HasBalance Permit Sales / Non Permit Sales
	*/
	public void setHasBalance (boolean HasBalance)
	{
		set_Value (COLUMNNAME_HasBalance, Boolean.valueOf(HasBalance));
	}

	/** Get Has Balance.
		@return Permit Sales / Non Permit Sales
	  */
	public boolean isHasBalance()
	{
		Object oo = get_Value(COLUMNNAME_HasBalance);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Include Pass Amount Invoice.
		@param IncludePassAmtInvoice Include Pass Amount Invoice
	*/
	public void setIncludePassAmtInvoice (boolean IncludePassAmtInvoice)
	{
		set_Value (COLUMNNAME_IncludePassAmtInvoice, Boolean.valueOf(IncludePassAmtInvoice));
	}

	/** Get Include Pass Amount Invoice.
		@return Include Pass Amount Invoice	  */
	public boolean isIncludePassAmtInvoice()
	{
		Object oo = get_Value(COLUMNNAME_IncludePassAmtInvoice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Include Rent Amount Invoice.
		@param IncludeRentAmtInvoice Include Rent Amount Invoice
	*/
	public void setIncludeRentAmtInvoice (boolean IncludeRentAmtInvoice)
	{
		set_Value (COLUMNNAME_IncludeRentAmtInvoice, Boolean.valueOf(IncludeRentAmtInvoice));
	}

	/** Get Include Rent Amount Invoice.
		@return Include Rent Amount Invoice	  */
	public boolean isIncludeRentAmtInvoice()
	{
		Object oo = get_Value(COLUMNNAME_IncludeRentAmtInvoice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Invoice No.
		@param InvoiceNo Invoice No generated from weighbridge app
	*/
	public void setInvoiceNo (String InvoiceNo)
	{
		set_Value (COLUMNNAME_InvoiceNo, InvoiceNo);
	}

	/** Get Invoice No.
		@return Invoice No generated from weighbridge app
	  */
	public String getInvoiceNo()
	{
		return (String)get_Value(COLUMNNAME_InvoiceNo);
	}

	/** Set 2nd Inovice No.
		@param InvoiceNo2 2nd Inovice No
	*/
	public void setInvoiceNo2 (String InvoiceNo2)
	{
		set_Value (COLUMNNAME_InvoiceNo2, InvoiceNo2);
	}

	/** Get 2nd Inovice No.
		@return 2nd Inovice No	  */
	public String getInvoiceNo2()
	{
		return (String)get_Value(COLUMNNAME_InvoiceNo2);
	}

	/** Actual Weight = AW */
	public static final String INVOICETYPE_ActualWeight = "AW";
	/** TP Weight = TW */
	public static final String INVOICETYPE_TPWeight = "TW";
	/** Set Invoice Type.
		@param InvoiceType Actual Weight / TP Weight
	*/
	public void setInvoiceType (String InvoiceType)
	{

		set_Value (COLUMNNAME_InvoiceType, InvoiceType);
	}

	/** Get Invoice Type.
		@return Actual Weight / TP Weight
	  */
	public String getInvoiceType()
	{
		return (String)get_Value(COLUMNNAME_InvoiceType);
	}

	/** Set Inter State.
		@param IsInterState Inter State
	*/
	public void setIsInterState (boolean IsInterState)
	{
		set_Value (COLUMNNAME_IsInterState, Boolean.valueOf(IsInterState));
	}

	/** Get Inter State.
		@return Inter State	  */
	public boolean isInterState()
	{
		Object oo = get_Value(COLUMNNAME_IsInterState);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Manual.
		@param IsManual This is a manual process
	*/
	public void setIsManual (boolean IsManual)
	{
		set_Value (COLUMNNAME_IsManual, Boolean.valueOf(IsManual));
	}

	/** Get Manual.
		@return This is a manual process
	  */
	public boolean isManual()
	{
		Object oo = get_Value(COLUMNNAME_IsManual);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Permit Sales.
		@param IsPermitSales Permit Sales
	*/
	public void setIsPermitSales (boolean IsPermitSales)
	{
		set_Value (COLUMNNAME_IsPermitSales, Boolean.valueOf(IsPermitSales));
	}

	/** Get Permit Sales.
		@return Permit Sales	  */
	public boolean isPermitSales()
	{
		Object oo = get_Value(COLUMNNAME_IsPermitSales);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Price Confidential.
		@param IsPriceConfidential Price Confidential
	*/
	public void setIsPriceConfidential (boolean IsPriceConfidential)
	{
		set_Value (COLUMNNAME_IsPriceConfidential, Boolean.valueOf(IsPriceConfidential));
	}

	/** Get Price Confidential.
		@return Price Confidential	  */
	public boolean isPriceConfidential()
	{
		Object oo = get_Value(COLUMNNAME_IsPriceConfidential);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Freight Inclusive.
		@param IsRentInclusive Whether Unit Price includes rent?
	*/
	public void setIsRentInclusive (boolean IsRentInclusive)
	{
		set_Value (COLUMNNAME_IsRentInclusive, Boolean.valueOf(IsRentInclusive));
	}

	/** Get Freight Inclusive.
		@return Whether Unit Price includes rent?
	  */
	public boolean isRentInclusive()
	{
		Object oo = get_Value(COLUMNNAME_IsRentInclusive);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Required Taxinvoice per load.
		@param IsRequiredTaxInvoicePerLoad Required Taxinvoice per load
	*/
	public void setIsRequiredTaxInvoicePerLoad (boolean IsRequiredTaxInvoicePerLoad)
	{
		set_Value (COLUMNNAME_IsRequiredTaxInvoicePerLoad, Boolean.valueOf(IsRequiredTaxInvoicePerLoad));
	}

	/** Get Required Taxinvoice per load.
		@return Required Taxinvoice per load	  */
	public boolean isRequiredTaxInvoicePerLoad()
	{
		Object oo = get_Value(COLUMNNAME_IsRequiredTaxInvoicePerLoad);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Royalty Pass Inclusive.
		@param IsRoyaltyPassInclusive Royalty Pass Inclusive
	*/
	public void setIsRoyaltyPassInclusive (boolean IsRoyaltyPassInclusive)
	{
		set_Value (COLUMNNAME_IsRoyaltyPassInclusive, Boolean.valueOf(IsRoyaltyPassInclusive));
	}

	/** Get Royalty Pass Inclusive.
		@return Royalty Pass Inclusive	  */
	public boolean isRoyaltyPassInclusive()
	{
		Object oo = get_Value(COLUMNNAME_IsRoyaltyPassInclusive);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Secondary.
		@param IsSecondary Secondary
	*/
	public void setIsSecondary (boolean IsSecondary)
	{
		set_Value (COLUMNNAME_IsSecondary, Boolean.valueOf(IsSecondary));
	}

	/** Get Secondary.
		@return Secondary	  */
	public boolean isSecondary()
	{
		Object oo = get_Value(COLUMNNAME_IsSecondary);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Price includes Tax.
		@param IsTaxIncluded Tax is included in the price 
	*/
	public void setIsTaxIncluded (boolean IsTaxIncluded)
	{
		set_Value (COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
	}

	/** Get Price includes Tax.
		@return Tax is included in the price 
	  */
	public boolean isTaxIncluded()
	{
		Object oo = get_Value(COLUMNNAME_IsTaxIncluded);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Loaded Time.
		@param LoadedTime Loaded Time
	*/
	public void setLoadedTime (Timestamp LoadedTime)
	{
		set_Value (COLUMNNAME_LoadedTime, LoadedTime);
	}

	/** Get Loaded Time.
		@return Loaded Time	  */
	public Timestamp getLoadedTime()
	{
		return (Timestamp)get_Value(COLUMNNAME_LoadedTime);
	}

	public org.compiere.model.I_AD_User getLoader_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getLoader_User_ID(), get_TrxName());
	}

	/** Set Loader Operator.
		@param Loader_User_ID Loader Operator
	*/
	public void setLoader_User_ID (int Loader_User_ID)
	{
		if (Loader_User_ID < 1)
			set_Value (COLUMNNAME_Loader_User_ID, null);
		else
			set_Value (COLUMNNAME_Loader_User_ID, Integer.valueOf(Loader_User_ID));
	}

	/** Get Loader Operator.
		@return Loader Operator	  */
	public int getLoader_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Loader_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_M_Product_Attribute getM_Product_Attribute() throws RuntimeException
	{
		return (I_M_Product_Attribute)MTable.get(getCtx(), I_M_Product_Attribute.Table_ID)
			.getPO(getM_Product_Attribute_ID(), get_TrxName());
	}

	/** Set Product Attribute.
		@param M_Product_Attribute_ID Product Attribute
	*/
	public void setM_Product_Attribute_ID (int M_Product_Attribute_ID)
	{
		if (M_Product_Attribute_ID < 1)
			set_Value (COLUMNNAME_M_Product_Attribute_ID, null);
		else
			set_Value (COLUMNNAME_M_Product_Attribute_ID, Integer.valueOf(M_Product_Attribute_ID));
	}

	/** Get Product Attribute.
		@return Product Attribute	  */
	public int getM_Product_Attribute_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_Attribute_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_ID)
			.getPO(getM_Product_ID(), get_TrxName());
	}

	/** Set Product.
		@param M_Product_ID Product, Service, Item
	*/
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1)
			set_Value (COLUMNNAME_M_Product_ID, null);
		else
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product_Pass() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_ID)
			.getPO(getM_Product_Pass_ID(), get_TrxName());
	}

	/** Set Pass ID.
		@param M_Product_Pass_ID Pass ID
	*/
	public void setM_Product_Pass_ID (int M_Product_Pass_ID)
	{
		if (M_Product_Pass_ID < 1)
			set_Value (COLUMNNAME_M_Product_Pass_ID, null);
		else
			set_Value (COLUMNNAME_M_Product_Pass_ID, Integer.valueOf(M_Product_Pass_ID));
	}

	/** Get Pass ID.
		@return Pass ID	  */
	public int getM_Product_Pass_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_Pass_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product2() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_ID)
			.getPO(getM_Product2_ID(), get_TrxName());
	}

	/** Set Product 2.
		@param M_Product2_ID Product 2
	*/
	public void setM_Product2_ID (int M_Product2_ID)
	{
		if (M_Product2_ID < 1)
			set_Value (COLUMNNAME_M_Product2_ID, null);
		else
			set_Value (COLUMNNAME_M_Product2_ID, Integer.valueOf(M_Product2_ID));
	}

	/** Get Product 2.
		@return Product 2	  */
	public int getM_Product2_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
	{
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_ID)
			.getPO(getM_Warehouse_ID(), get_TrxName());
	}

	/** Set Warehouse.
		@param M_Warehouse_ID Storage Warehouse and Service Point
	*/
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1)
			set_Value (COLUMNNAME_M_Warehouse_ID, null);
		else
			set_Value (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set MDP No.
		@param MDPNo MDP No
	*/
	public void setMDPNo (String MDPNo)
	{
		set_Value (COLUMNNAME_MDPNo, MDPNo);
	}

	/** Get MDP No.
		@return MDP No	  */
	public String getMDPNo()
	{
		return (String)get_Value(COLUMNNAME_MDPNo);
	}

	/** Set ML No.
		@param MLNo ML No
	*/
	public void setMLNo (String MLNo)
	{
		set_Value (COLUMNNAME_MLNo, MLNo);
	}

	/** Get ML No.
		@return ML No	  */
	public String getMLNo()
	{
		return (String)get_Value(COLUMNNAME_MLNo);
	}

	/** Set Net Weight (Kg).
		@param NetWeight Net Weight (Kg)
	*/
	public void setNetWeight (BigDecimal NetWeight)
	{
		set_Value (COLUMNNAME_NetWeight, NetWeight);
	}

	/** Get Net Weight (Kg).
		@return Net Weight (Kg)	  */
	public BigDecimal getNetWeight()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NetWeight);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Net Weight (Unit).
		@param NetWeightUnit Net Weight (Unit)
	*/
	public void setNetWeightUnit (BigDecimal NetWeightUnit)
	{
		set_Value (COLUMNNAME_NetWeightUnit, NetWeightUnit);
	}

	/** Get Net Weight (Unit).
		@return Net Weight (Unit)	  */
	public BigDecimal getNetWeightUnit()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NetWeightUnit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set New Destination.
		@param NewDestination New Destination
	*/
	public void setNewDestination (String NewDestination)
	{
		set_Value (COLUMNNAME_NewDestination, NewDestination);
	}

	/** Get New Destination.
		@return New Destination	  */
	public String getNewDestination()
	{
		return (String)get_Value(COLUMNNAME_NewDestination);
	}

	/** Set New Driver Name.
		@param NewDriverName New Driver Name
	*/
	public void setNewDriverName (String NewDriverName)
	{
		set_Value (COLUMNNAME_NewDriverName, NewDriverName);
	}

	/** Get New Driver Name.
		@return New Driver Name	  */
	public String getNewDriverName()
	{
		return (String)get_Value(COLUMNNAME_NewDriverName);
	}

	/** Set New Product.
		@param NewProduct New Product
	*/
	public void setNewProduct (String NewProduct)
	{
		set_Value (COLUMNNAME_NewProduct, NewProduct);
	}

	/** Get New Product.
		@return New Product	  */
	public String getNewProduct()
	{
		return (String)get_Value(COLUMNNAME_NewProduct);
	}

	/** Set Other Charges.
		@param OtherCharges Other Charges
	*/
	public void setOtherCharges (BigDecimal OtherCharges)
	{
		set_Value (COLUMNNAME_OtherCharges, OtherCharges);
	}

	/** Get Other Charges.
		@return Other Charges	  */
	public BigDecimal getOtherCharges()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_OtherCharges);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Party Name.
		@param PartyName Party Name
	*/
	public void setPartyName (String PartyName)
	{
		set_Value (COLUMNNAME_PartyName, PartyName);
	}

	/** Get Party Name.
		@return Party Name	  */
	public String getPartyName()
	{
		return (String)get_Value(COLUMNNAME_PartyName);
	}

	/** Set Pass Includes Tax.
		@param PassIncludesTax Pass Includes Tax
	*/
	public void setPassIncludesTax (boolean PassIncludesTax)
	{
		set_Value (COLUMNNAME_PassIncludesTax, Boolean.valueOf(PassIncludesTax));
	}

	/** Get Pass Includes Tax.
		@return Pass Includes Tax	  */
	public boolean isPassIncludesTax()
	{
		Object oo = get_Value(COLUMNNAME_PassIncludesTax);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Pass Price.
		@param PassPricePerUnit Pass Price
	*/
	public void setPassPricePerUnit (BigDecimal PassPricePerUnit)
	{
		set_Value (COLUMNNAME_PassPricePerUnit, PassPricePerUnit);
	}

	/** Get Pass Price.
		@return Pass Price	  */
	public BigDecimal getPassPricePerUnit()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PassPricePerUnit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set PassQtyIssued.
		@param PassQtyIssued PassQtyIssued
	*/
	public void setPassQtyIssued (BigDecimal PassQtyIssued)
	{
		set_Value (COLUMNNAME_PassQtyIssued, PassQtyIssued);
	}

	/** Get PassQtyIssued.
		@return PassQtyIssued	  */
	public BigDecimal getPassQtyIssued()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PassQtyIssued);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** PaymentRule AD_Reference_ID=195 */
	public static final int PAYMENTRULE_AD_Reference_ID=195;
	/** Cash = B */
	public static final String PAYMENTRULE_Cash = "B";
	/** Direct Debit = D */
	public static final String PAYMENTRULE_DirectDebit = "D";
	/** Credit Card = K */
	public static final String PAYMENTRULE_CreditCard = "K";
	/** Mixed POS Payment = M */
	public static final String PAYMENTRULE_MixedPOSPayment = "M";
	/** Mixed Payment = O */
	public static final String PAYMENTRULE_MixedPayment = "O";
	/** Credit = P */
	public static final String PAYMENTRULE_Credit = "P";
	/** Check = S */
	public static final String PAYMENTRULE_Check = "S";
	/** Direct Deposit = T */
	public static final String PAYMENTRULE_DirectDeposit = "T";
	/** Prepaid Cash = Z */
	public static final String PAYMENTRULE_PrepaidCash = "Z";
	/** Set Payment Rule.
		@param PaymentRule How you pay the invoice
	*/
	public void setPaymentRule (String PaymentRule)
	{

		set_Value (COLUMNNAME_PaymentRule, PaymentRule);
	}

	/** Get Payment Rule.
		@return How you pay the invoice
	  */
	public String getPaymentRule()
	{
		return (String)get_Value(COLUMNNAME_PaymentRule);
	}

	/** Set TP Weight.
		@param PermitIssuedQty TP Weight
	*/
	public void setPermitIssuedQty (BigDecimal PermitIssuedQty)
	{
		set_Value (COLUMNNAME_PermitIssuedQty, PermitIssuedQty);
	}

	/** Get TP Weight.
		@return TP Weight	  */
	public BigDecimal getPermitIssuedQty()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitIssuedQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Permit Issue Amount.
		@param PermitPassAmount Permit Issue Amount
	*/
	public void setPermitPassAmount (BigDecimal PermitPassAmount)
	{
		set_Value (COLUMNNAME_PermitPassAmount, PermitPassAmount);
	}

	/** Get Permit Issue Amount.
		@return Permit Issue Amount	  */
	public BigDecimal getPermitPassAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitPassAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Permit Quantity (Tonne).
		@param PermitQty Permit Quantity (Tonne)
	*/
	public void setPermitQty (BigDecimal PermitQty)
	{
		set_Value (COLUMNNAME_PermitQty, PermitQty);
	}

	/** Get Permit Quantity (Tonne).
		@return Permit Quantity (Tonne)	  */
	public BigDecimal getPermitQty()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Phone.
		@param Phone Identifies a telephone number
	*/
	public void setPhone (String Phone)
	{
		set_Value (COLUMNNAME_Phone, Phone);
	}

	/** Get Phone.
		@return Identifies a telephone number
	  */
	public String getPhone()
	{
		return (String)get_Value(COLUMNNAME_Phone);
	}

	/** Set PIT No.
		@param PITNo PIT No
	*/
	public void setPITNo (String PITNo)
	{
		set_Value (COLUMNNAME_PITNo, PITNo);
	}

	/** Get PIT No.
		@return PIT No	  */
	public String getPITNo()
	{
		return (String)get_Value(COLUMNNAME_PITNo);
	}

	public I_PM_Machinery getPM_Machinery() throws RuntimeException
	{
		return (I_PM_Machinery)MTable.get(getCtx(), I_PM_Machinery.Table_ID)
			.getPO(getPM_Machinery_ID(), get_TrxName());
	}

	/** Set Machinery.
		@param PM_Machinery_ID Machinery
	*/
	public void setPM_Machinery_ID (int PM_Machinery_ID)
	{
		if (PM_Machinery_ID < 1)
			set_ValueNoCheck (COLUMNNAME_PM_Machinery_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_PM_Machinery_ID, Integer.valueOf(PM_Machinery_ID));
	}

	/** Get Machinery.
		@return Machinery	  */
	public int getPM_Machinery_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_Machinery_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Previous Challan No.
		@param PreviousChallanNo Previous Challan No
	*/
	public void setPreviousChallanNo (String PreviousChallanNo)
	{
		set_Value (COLUMNNAME_PreviousChallanNo, PreviousChallanNo);
	}

	/** Get Previous Challan No.
		@return Previous Challan No	  */
	public String getPreviousChallanNo()
	{
		return (String)get_Value(COLUMNNAME_PreviousChallanNo);
	}

	/** Set Price.
		@param Price Price
	*/
	public void setPrice (BigDecimal Price)
	{
		set_Value (COLUMNNAME_Price, Price);
	}

	/** Get Price.
		@return Price
	  */
	public BigDecimal getPrice()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Primary Document No.
		@param PrimaryDocumentNo Primary Document No
	*/
	public void setPrimaryDocumentNo (String PrimaryDocumentNo)
	{
		set_Value (COLUMNNAME_PrimaryDocumentNo, PrimaryDocumentNo);
	}

	/** Get Primary Document No.
		@return Primary Document No	  */
	public String getPrimaryDocumentNo()
	{
		return (String)get_Value(COLUMNNAME_PrimaryDocumentNo);
	}

	/** Set PrimaryDocumentNo2.
		@param PrimaryDocumentNo2 PrimaryDocumentNo2
	*/
	public void setPrimaryDocumentNo2 (String PrimaryDocumentNo2)
	{
		throw new IllegalArgumentException ("PrimaryDocumentNo2 is virtual column");	}

	/** Get PrimaryDocumentNo2.
		@return PrimaryDocumentNo2	  */
	public String getPrimaryDocumentNo2()
	{
		return (String)get_Value(COLUMNNAME_PrimaryDocumentNo2);
	}

	/** Set Print Delivery Estimate.
		@param PrintDeliveryEstimate Print Delivery Estimate
	*/
	public void setPrintDeliveryEstimate (String PrintDeliveryEstimate)
	{
		set_Value (COLUMNNAME_PrintDeliveryEstimate, PrintDeliveryEstimate);
	}

	/** Get Print Delivery Estimate.
		@return Print Delivery Estimate	  */
	public String getPrintDeliveryEstimate()
	{
		return (String)get_Value(COLUMNNAME_PrintDeliveryEstimate);
	}

	/** Set Print Invoice.
		@param PrintInvoice Print Invoice
	*/
	public void setPrintInvoice (String PrintInvoice)
	{
		set_Value (COLUMNNAME_PrintInvoice, PrintInvoice);
	}

	/** Get Print Invoice.
		@return Print Invoice	  */
	public String getPrintInvoice()
	{
		return (String)get_Value(COLUMNNAME_PrintInvoice);
	}

	/** Set Processed.
		@param Processed The document has been processed
	*/
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed()
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Graweller = G */
	public static final String QUARRYPRODUCTIONTYPE_Graweller = "G";
	/** Jack Hammer = J */
	public static final String QUARRYPRODUCTIONTYPE_JackHammer = "J";
	/** Set Quarry Production Type.
		@param QuarryProductionType Quarry Production Type
	*/
	public void setQuarryProductionType (String QuarryProductionType)
	{

		set_Value (COLUMNNAME_QuarryProductionType, QuarryProductionType);
	}

	/** Get Quarry Production Type.
		@return Quarry Production Type	  */
	public String getQuarryProductionType()
	{
		return (String)get_Value(COLUMNNAME_QuarryProductionType);
	}

	public I_TF_WeighmentEntry getRef_WeighmentEntry() throws RuntimeException
	{
		return (I_TF_WeighmentEntry)MTable.get(getCtx(), I_TF_WeighmentEntry.Table_ID)
			.getPO(getRef_WeighmentEntry_ID(), get_TrxName());
	}

	/** Set Reference Weighment Entry.
		@param Ref_WeighmentEntry_ID Reference Weighment Entry
	*/
	public void setRef_WeighmentEntry_ID (int Ref_WeighmentEntry_ID)
	{
		if (Ref_WeighmentEntry_ID < 1)
			set_Value (COLUMNNAME_Ref_WeighmentEntry_ID, null);
		else
			set_Value (COLUMNNAME_Ref_WeighmentEntry_ID, Integer.valueOf(Ref_WeighmentEntry_ID));
	}

	/** Get Reference Weighment Entry.
		@return Reference Weighment Entry	  */
	public int getRef_WeighmentEntry_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Ref_WeighmentEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Remarks.
		@param Remarks Remarks
	*/
	public void setRemarks (String Remarks)
	{
		set_Value (COLUMNNAME_Remarks, Remarks);
	}

	/** Get Remarks.
		@return Remarks	  */
	public String getRemarks()
	{
		return (String)get_Value(COLUMNNAME_Remarks);
	}

	/** Set Rent (Amount).
		@param Rent_Amt Rent (Amount)
	*/
	public void setRent_Amt (BigDecimal Rent_Amt)
	{
		set_Value (COLUMNNAME_Rent_Amt, Rent_Amt);
	}

	/** Get Rent (Amount).
		@return Rent (Amount)	  */
	public BigDecimal getRent_Amt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Rent_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Rent Includes Tax.
		@param RentIncludesTax Rent Includes Tax
	*/
	public void setRentIncludesTax (boolean RentIncludesTax)
	{
		set_Value (COLUMNNAME_RentIncludesTax, Boolean.valueOf(RentIncludesTax));
	}

	/** Get Rent Includes Tax.
		@return Rent Includes Tax	  */
	public boolean isRentIncludesTax()
	{
		Object oo = get_Value(COLUMNNAME_RentIncludesTax);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Rounding Off.
		@param RoundingOff Rounding Off
	*/
	public void setRoundingOff (BigDecimal RoundingOff)
	{
		set_Value (COLUMNNAME_RoundingOff, RoundingOff);
	}

	/** Get Rounding Off.
		@return Rounding Off	  */
	public BigDecimal getRoundingOff()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RoundingOff);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set TP No.
		@param RoyaltyNo TP No
	*/
	public void setRoyaltyNo (String RoyaltyNo)
	{
		set_Value (COLUMNNAME_RoyaltyNo, RoyaltyNo);
	}

	/** Get TP No.
		@return TP No	  */
	public String getRoyaltyNo()
	{
		return (String)get_Value(COLUMNNAME_RoyaltyNo);
	}

	/** Set Sales Amount.
		@param SalesAmt Sales Amount
	*/
	public void setSalesAmt (BigDecimal SalesAmt)
	{
		throw new IllegalArgumentException ("SalesAmt is virtual column");	}

	/** Get Sales Amount.
		@return Sales Amount	  */
	public BigDecimal getSalesAmt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SalesAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_BPartner getSalesRep() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getSalesRep_ID(), get_TrxName());
	}

	/** Set Sales Representative.
		@param SalesRep_ID Sales Representative or Company Agent
	*/
	public void setSalesRep_ID (int SalesRep_ID)
	{
		if (SalesRep_ID < 1)
			set_ValueNoCheck (COLUMNNAME_SalesRep_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_SalesRep_ID, Integer.valueOf(SalesRep_ID));
	}

	/** Get Sales Representative.
		@return Sales Representative or Company Agent
	  */
	public int getSalesRep_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SalesRep_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Boulder = BOULDER */
	public static final String SECONDWEIGHBRIDGENAME_Boulder = "BOULDER";
	/** Sales = SALES */
	public static final String SECONDWEIGHBRIDGENAME_Sales = "SALES";
	/** Stockyard = STOCKYARD */
	public static final String SECONDWEIGHBRIDGENAME_Stockyard = "STOCKYARD";
	/** Set Second Weighbridge Name.
		@param SecondWeighbridgeName Second Weighbridge Name
	*/
	public void setSecondWeighbridgeName (String SecondWeighbridgeName)
	{

		set_Value (COLUMNNAME_SecondWeighbridgeName, SecondWeighbridgeName);
	}

	/** Get Second Weighbridge Name.
		@return Second Weighbridge Name	  */
	public String getSecondWeighbridgeName()
	{
		return (String)get_Value(COLUMNNAME_SecondWeighbridgeName);
	}

	/** Set Shipment To.
		@param ShipmentTo Shipment To
	*/
	public void setShipmentTo (String ShipmentTo)
	{
		set_Value (COLUMNNAME_ShipmentTo, ShipmentTo);
	}

	/** Get Shipment To.
		@return Shipment To	  */
	public String getShipmentTo()
	{
		return (String)get_Value(COLUMNNAME_ShipmentTo);
	}

	/** Billed = CL */
	public static final String STATUS_Billed = "CL";
	/** Unbilled = CO */
	public static final String STATUS_Unbilled = "CO";
	/** Error = ER */
	public static final String STATUS_Error = "ER";
	/** In Progress = IP */
	public static final String STATUS_InProgress = "IP";
	/** Primary DC void = PV */
	public static final String STATUS_PrimaryDCVoid = "PV";
	/** Under Review = UR */
	public static final String STATUS_UnderReview = "UR";
	/** Voided = VO */
	public static final String STATUS_Voided = "VO";
	/** Pending = P */
	public static final String STATUS_Pending = "P";
	/** Set Status.
		@param Status Status of the currently running check
	*/
	public void setStatus (String Status)
	{

		set_Value (COLUMNNAME_Status, Status);
	}

	/** Get Status.
		@return Status of the currently running check
	  */
	public String getStatus()
	{
		return (String)get_Value(COLUMNNAME_Status);
	}

	/** Set Tare Weight (Kg).
		@param TareWeight Tare Weight (Kg)
	*/
	public void setTareWeight (BigDecimal TareWeight)
	{
		set_Value (COLUMNNAME_TareWeight, TareWeight);
	}

	/** Get Tare Weight (Kg).
		@return Tare Weight (Kg)	  */
	public BigDecimal getTareWeight()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TareWeight);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tare Weight Time.
		@param TareWeightTime Tare Weight Time
	*/
	public void setTareWeightTime (Timestamp TareWeightTime)
	{
		set_Value (COLUMNNAME_TareWeightTime, TareWeightTime);
	}

	/** Get Tare Weight Time.
		@return Tare Weight Time	  */
	public Timestamp getTareWeightTime()
	{
		return (Timestamp)get_Value(COLUMNNAME_TareWeightTime);
	}

	/** Set Tare Weight Time String.
		@param TareWeightTimeString Tare Weight Time String
	*/
	public void setTareWeightTimeString (String TareWeightTimeString)
	{
		throw new IllegalArgumentException ("TareWeightTimeString is virtual column");	}

	/** Get Tare Weight Time String.
		@return Tare Weight Time String	  */
	public String getTareWeightTimeString()
	{
		return (String)get_Value(COLUMNNAME_TareWeightTimeString);
	}

	/** Set Tax ID.
		@param TaxID Tax Identification
	*/
	public void setTaxID (String TaxID)
	{
		set_ValueNoCheck (COLUMNNAME_TaxID, TaxID);
	}

	/** Get Tax ID.
		@return Tax Identification
	  */
	public String getTaxID()
	{
		return (String)get_Value(COLUMNNAME_TaxID);
	}

	/** Set TCS Amount.
		@param TCSAmount TCS Amount
	*/
	public void setTCSAmount (BigDecimal TCSAmount)
	{
		set_Value (COLUMNNAME_TCSAmount, TCSAmount);
	}

	/** Get TCS Amount.
		@return TCS Amount	  */
	public BigDecimal getTCSAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TCSAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tender Amount.
		@param TenderAmount Tender Amount
	*/
	public void setTenderAmount (BigDecimal TenderAmount)
	{
		set_Value (COLUMNNAME_TenderAmount, TenderAmount);
	}

	/** Get Tender Amount.
		@return Tender Amount
	  */
	public BigDecimal getTenderAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TenderAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** TenderType AD_Reference_ID=214 */
	public static final int TENDERTYPE_AD_Reference_ID=214;
	/** Advance = A */
	public static final String TENDERTYPE_Advance = "A";
	/** Credit Card = C */
	public static final String TENDERTYPE_CreditCard = "C";
	/** Direct Debit = D */
	public static final String TENDERTYPE_DirectDebit = "D";
	/** GPay = G */
	public static final String TENDERTYPE_GPay = "G";
	/** IMPS = I */
	public static final String TENDERTYPE_IMPS = "I";
	/** Check = K */
	public static final String TENDERTYPE_Check = "K";
	/** NEFT = N */
	public static final String TENDERTYPE_NEFT = "N";
	/** PayTM = P */
	public static final String TENDERTYPE_PayTM = "P";
	/** RTGS = R */
	public static final String TENDERTYPE_RTGS = "R";
	/** Account = T */
	public static final String TENDERTYPE_Account = "T";
	/** UPI = U */
	public static final String TENDERTYPE_UPI = "U";
	/** Cash = X */
	public static final String TENDERTYPE_Cash = "X";
	/** Set Tender type.
		@param TenderType Method of Payment
	*/
	public void setTenderType (String TenderType)
	{

		set_ValueNoCheck (COLUMNNAME_TenderType, TenderType);
	}

	/** Get Tender type.
		@return Method of Payment
	  */
	public String getTenderType()
	{
		return (String)get_Value(COLUMNNAME_TenderType);
	}

	/** 40 MM only = 40 */
	public static final String TF_BLUEMETAL_TYPE_40MMOnly = "40";
	/** GSB = GSB */
	public static final String TF_BLUEMETAL_TYPE_GSB = "GSB";
	/** Regular = R */
	public static final String TF_BLUEMETAL_TYPE_Regular = "R";
	/** Regular + Geosand = RG */
	public static final String TF_BLUEMETAL_TYPE_RegularPlusGeosand = "RG";
	/** SO = SO */
	public static final String TF_BLUEMETAL_TYPE_SO = "SO";
	/** Wetmix = W */
	public static final String TF_BLUEMETAL_TYPE_Wetmix = "W";
	/** Set Production Type.
		@param TF_BlueMetal_Type Production Type
	*/
	public void setTF_BlueMetal_Type (String TF_BlueMetal_Type)
	{

		set_Value (COLUMNNAME_TF_BlueMetal_Type, TF_BlueMetal_Type);
	}

	/** Get Production Type.
		@return Production Type	  */
	public String getTF_BlueMetal_Type()
	{
		return (String)get_Value(COLUMNNAME_TF_BlueMetal_Type);
	}

	public I_TF_Boulder_Receipt getTF_Boulder_Receipt() throws RuntimeException
	{
		return (I_TF_Boulder_Receipt)MTable.get(getCtx(), I_TF_Boulder_Receipt.Table_ID)
			.getPO(getTF_Boulder_Receipt_ID(), get_TrxName());
	}

	/** Set Boulder Receipt.
		@param TF_Boulder_Receipt_ID Boulder Receipt
	*/
	public void setTF_Boulder_Receipt_ID (int TF_Boulder_Receipt_ID)
	{
		if (TF_Boulder_Receipt_ID < 1)
			set_Value (COLUMNNAME_TF_Boulder_Receipt_ID, null);
		else
			set_Value (COLUMNNAME_TF_Boulder_Receipt_ID, Integer.valueOf(TF_Boulder_Receipt_ID));
	}

	/** Get Boulder Receipt.
		@return Boulder Receipt	  */
	public int getTF_Boulder_Receipt_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Receipt_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Destination getTF_Destination() throws RuntimeException
	{
		return (I_TF_Destination)MTable.get(getCtx(), I_TF_Destination.Table_ID)
			.getPO(getTF_Destination_ID(), get_TrxName());
	}

	/** Set Destination.
		@param TF_Destination_ID Destination
	*/
	public void setTF_Destination_ID (int TF_Destination_ID)
	{
		if (TF_Destination_ID < 1)
			set_Value (COLUMNNAME_TF_Destination_ID, null);
		else
			set_Value (COLUMNNAME_TF_Destination_ID, Integer.valueOf(TF_Destination_ID));
	}

	/** Get Destination.
		@return Destination	  */
	public int getTF_Destination_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Destination_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_DispensePlanLine getTF_DispensePlanLine() throws RuntimeException
	{
		return (I_TF_DispensePlanLine)MTable.get(getCtx(), I_TF_DispensePlanLine.Table_ID)
			.getPO(getTF_DispensePlanLine_ID(), get_TrxName());
	}

	/** Set Dispatch Plan Line.
		@param TF_DispensePlanLine_ID Dispatch Plan Line
	*/
	public void setTF_DispensePlanLine_ID (int TF_DispensePlanLine_ID)
	{
		if (TF_DispensePlanLine_ID < 1)
			set_Value (COLUMNNAME_TF_DispensePlanLine_ID, null);
		else
			set_Value (COLUMNNAME_TF_DispensePlanLine_ID, Integer.valueOf(TF_DispensePlanLine_ID));
	}

	/** Get Dispatch Plan Line.
		@return Dispatch Plan Line	  */
	public int getTF_DispensePlanLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_DispensePlanLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_LumpSumRent_Config getTF_LumpSumRent_Config() throws RuntimeException
	{
		return (I_TF_LumpSumRent_Config)MTable.get(getCtx(), I_TF_LumpSumRent_Config.Table_ID)
			.getPO(getTF_LumpSumRent_Config_ID(), get_TrxName());
	}

	/** Set TF_LumpSumRent_Config.
		@param TF_LumpSumRent_Config_ID TF_LumpSumRent_Config
	*/
	public void setTF_LumpSumRent_Config_ID (int TF_LumpSumRent_Config_ID)
	{
		if (TF_LumpSumRent_Config_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_LumpSumRent_Config_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_LumpSumRent_Config_ID, Integer.valueOf(TF_LumpSumRent_Config_ID));
	}

	/** Get TF_LumpSumRent_Config.
		@return TF_LumpSumRent_Config	  */
	public int getTF_LumpSumRent_Config_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_LumpSumRent_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_PriceListUOM getTF_PriceListUOM() throws RuntimeException
	{
		return (I_TF_PriceListUOM)MTable.get(getCtx(), I_TF_PriceListUOM.Table_ID)
			.getPO(getTF_PriceListUOM_ID(), get_TrxName());
	}

	/** Set Price List by UOM.
		@param TF_PriceListUOM_ID Price List by UOM
	*/
	public void setTF_PriceListUOM_ID (int TF_PriceListUOM_ID)
	{
		if (TF_PriceListUOM_ID < 1)
			set_Value (COLUMNNAME_TF_PriceListUOM_ID, null);
		else
			set_Value (COLUMNNAME_TF_PriceListUOM_ID, Integer.valueOf(TF_PriceListUOM_ID));
	}

	/** Get Price List by UOM.
		@return Price List by UOM	  */
	public int getTF_PriceListUOM_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_PriceListUOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_ProductionPlant getTF_ProductionPlant() throws RuntimeException
	{
		return (I_TF_ProductionPlant)MTable.get(getCtx(), I_TF_ProductionPlant.Table_ID)
			.getPO(getTF_ProductionPlant_ID(), get_TrxName());
	}

	/** Set Production Plant.
		@param TF_ProductionPlant_ID Production Plant
	*/
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID)
	{
		if (TF_ProductionPlant_ID < 1)
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, null);
		else
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, Integer.valueOf(TF_ProductionPlant_ID));
	}

	/** Get Production Plant.
		@return Production Plant	  */
	public int getTF_ProductionPlant_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ProductionPlant_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Quarry getTF_Quarry() throws RuntimeException
	{
		return (I_TF_Quarry)MTable.get(getCtx(), I_TF_Quarry.Table_ID)
			.getPO(getTF_Quarry_ID(), get_TrxName());
	}

	/** Set Quarry.
		@param TF_Quarry_ID Quarry
	*/
	public void setTF_Quarry_ID (int TF_Quarry_ID)
	{
		if (TF_Quarry_ID < 1)
			set_Value (COLUMNNAME_TF_Quarry_ID, null);
		else
			set_Value (COLUMNNAME_TF_Quarry_ID, Integer.valueOf(TF_Quarry_ID));
	}

	/** Get Quarry.
		@return Quarry	  */
	public int getTF_Quarry_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Quarry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_RentedVehicle getTF_RentedVehicle() throws RuntimeException
	{
		return (I_TF_RentedVehicle)MTable.get(getCtx(), I_TF_RentedVehicle.Table_ID)
			.getPO(getTF_RentedVehicle_ID(), get_TrxName());
	}

	/** Set Rented Vehicle.
		@param TF_RentedVehicle_ID Rented Vehicle
	*/
	public void setTF_RentedVehicle_ID (int TF_RentedVehicle_ID)
	{
		if (TF_RentedVehicle_ID < 1)
			set_Value (COLUMNNAME_TF_RentedVehicle_ID, null);
		else
			set_Value (COLUMNNAME_TF_RentedVehicle_ID, Integer.valueOf(TF_RentedVehicle_ID));
	}

	/** Get Rented Vehicle.
		@return Rented Vehicle	  */
	public int getTF_RentedVehicle_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_RentedVehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Production = P */
	public static final String TF_SEND_TO_Production = "P";
	/** Stock = S */
	public static final String TF_SEND_TO_Stock = "S";
	/** Subcontract Production = T */
	public static final String TF_SEND_TO_SubcontractProduction = "T";
	/** Set Send To.
		@param TF_Send_To Send To
	*/
	public void setTF_Send_To (String TF_Send_To)
	{

		set_Value (COLUMNNAME_TF_Send_To, TF_Send_To);
	}

	/** Get Send To.
		@return Send To	  */
	public String getTF_Send_To()
	{
		return (String)get_Value(COLUMNNAME_TF_Send_To);
	}

	public I_TF_TripSheet getTF_TripSheet() throws RuntimeException
	{
		return (I_TF_TripSheet)MTable.get(getCtx(), I_TF_TripSheet.Table_ID)
			.getPO(getTF_TripSheet_ID(), get_TrxName());
	}

	/** Set Trip Sheet.
		@param TF_TripSheet_ID Trip Sheet
	*/
	public void setTF_TripSheet_ID (int TF_TripSheet_ID)
	{
		if (TF_TripSheet_ID < 1)
			set_Value (COLUMNNAME_TF_TripSheet_ID, null);
		else
			set_Value (COLUMNNAME_TF_TripSheet_ID, Integer.valueOf(TF_TripSheet_ID));
	}

	/** Get Trip Sheet.
		@return Trip Sheet	  */
	public int getTF_TripSheet_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TripSheet_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TripSheetProduct getTF_TripSheetProduct() throws RuntimeException
	{
		return (I_TF_TripSheetProduct)MTable.get(getCtx(), I_TF_TripSheetProduct.Table_ID)
			.getPO(getTF_TripSheetProduct_ID(), get_TrxName());
	}

	/** Set Trip Sheet Product Detail.
		@param TF_TripSheetProduct_ID Trip Sheet Product Detail
	*/
	public void setTF_TripSheetProduct_ID (int TF_TripSheetProduct_ID)
	{
		if (TF_TripSheetProduct_ID < 1)
			set_Value (COLUMNNAME_TF_TripSheetProduct_ID, null);
		else
			set_Value (COLUMNNAME_TF_TripSheetProduct_ID, Integer.valueOf(TF_TripSheetProduct_ID));
	}

	/** Get Trip Sheet Product Detail.
		@return Trip Sheet Product Detail	  */
	public int getTF_TripSheetProduct_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TripSheetProduct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException
	{
		return (I_TF_VehicleType)MTable.get(getCtx(), I_TF_VehicleType.Table_ID)
			.getPO(getTF_VehicleType_ID(), get_TrxName());
	}

	/** Set Vehicle Type.
		@param TF_VehicleType_ID Vehicle Type
	*/
	public void setTF_VehicleType_ID (int TF_VehicleType_ID)
	{
		if (TF_VehicleType_ID < 1)
			set_Value (COLUMNNAME_TF_VehicleType_ID, null);
		else
			set_Value (COLUMNNAME_TF_VehicleType_ID, Integer.valueOf(TF_VehicleType_ID));
	}

	/** Get Vehicle Type.
		@return Vehicle Type	  */
	public int getTF_VehicleType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_VehicleType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Weighment Entry.
		@param TF_WeighmentEntry_ID Weighment Entry
	*/
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID)
	{
		if (TF_WeighmentEntry_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_WeighmentEntry_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_WeighmentEntry_ID, Integer.valueOf(TF_WeighmentEntry_ID));
	}

	/** Get Weighment Entry.
		@return Weighment Entry	  */
	public int getTF_WeighmentEntry_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_WeighmentEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_WeighmentEntry_UU.
		@param TF_WeighmentEntry_UU TF_WeighmentEntry_UU
	*/
	public void setTF_WeighmentEntry_UU (String TF_WeighmentEntry_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_WeighmentEntry_UU, TF_WeighmentEntry_UU);
	}

	/** Get TF_WeighmentEntry_UU.
		@return TF_WeighmentEntry_UU	  */
	public String getTF_WeighmentEntry_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_WeighmentEntry_UU);
	}

	public I_TF_WeighmentEntry getTF_WeighmentEntryPrimary() throws RuntimeException
	{
		return (I_TF_WeighmentEntry)MTable.get(getCtx(), I_TF_WeighmentEntry.Table_ID)
			.getPO(getTF_WeighmentEntryPrimary_ID(), get_TrxName());
	}

	/** Set Primary Weighment Entry.
		@param TF_WeighmentEntryPrimary_ID Primary Weighment Entry
	*/
	public void setTF_WeighmentEntryPrimary_ID (int TF_WeighmentEntryPrimary_ID)
	{
		if (TF_WeighmentEntryPrimary_ID < 1)
			set_Value (COLUMNNAME_TF_WeighmentEntryPrimary_ID, null);
		else
			set_Value (COLUMNNAME_TF_WeighmentEntryPrimary_ID, Integer.valueOf(TF_WeighmentEntryPrimary_ID));
	}

	/** Get Primary Weighment Entry.
		@return Primary Weighment Entry	  */
	public int getTF_WeighmentEntryPrimary_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_WeighmentEntryPrimary_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Time.
		@param Time Time
	*/
	public void setTime (String Time)
	{
		throw new IllegalArgumentException ("Time is virtual column");	}

	/** Get Time.
		@return Time	  */
	public String getTime()
	{
		return (String)get_Value(COLUMNNAME_Time);
	}

	/** Set Total Amount.
		@param TotalAmt Total Amount
	*/
	public void setTotalAmt (BigDecimal TotalAmt)
	{
		set_ValueNoCheck (COLUMNNAME_TotalAmt, TotalAmt);
	}

	/** Get Total Amount.
		@return Total Amount
	  */
	public BigDecimal getTotalAmt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_BPartner getTransporter() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getTransporter_ID(), get_TrxName());
	}

	/** Set Transporter.
		@param Transporter_ID Transporter
	*/
	public void setTransporter_ID (int Transporter_ID)
	{
		if (Transporter_ID < 1)
			set_Value (COLUMNNAME_Transporter_ID, null);
		else
			set_Value (COLUMNNAME_Transporter_ID, Integer.valueOf(Transporter_ID));
	}

	/** Get Transporter.
		@return Transporter	  */
	public int getTransporter_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Transporter_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Unloading Weight (MT).
		@param UnloadingWeight Unloading Weight (MT)
	*/
	public void setUnloadingWeight (BigDecimal UnloadingWeight)
	{
		set_Value (COLUMNNAME_UnloadingWeight, UnloadingWeight);
	}

	/** Get Unloading Weight (MT).
		@return Unloading Weight (MT)	  */
	public BigDecimal getUnloadingWeight()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_UnloadingWeight);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set User Name.
		@param UserName User Name
	*/
	public void setUserName (String UserName)
	{
		set_Value (COLUMNNAME_UserName, UserName);
	}

	/** Get User Name.
		@return User Name	  */
	public String getUserName()
	{
		return (String)get_Value(COLUMNNAME_UserName);
	}

	/** Set Vehicle No.
		@param VehicleNo Vehicle No
	*/
	public void setVehicleNo (String VehicleNo)
	{
		set_Value (COLUMNNAME_VehicleNo, VehicleNo);
	}

	/** Get Vehicle No.
		@return Vehicle No	  */
	public String getVehicleNo()
	{
		return (String)get_Value(COLUMNNAME_VehicleNo);
	}

	/** Set Vendor DC #.
		@param VendorDCNo Vendor DC #
	*/
	public void setVendorDCNo (String VendorDCNo)
	{
		set_Value (COLUMNNAME_VendorDCNo, VendorDCNo);
	}

	/** Get Vendor DC #.
		@return Vendor DC #	  */
	public String getVendorDCNo()
	{
		return (String)get_Value(COLUMNNAME_VendorDCNo);
	}

	/** Sales = 1SO */
	public static final String WEIGHMENTENTRYTYPE_Sales = "1SO";
	/** Input = 2PO */
	public static final String WEIGHMENTENTRYTYPE_Input = "2PO";
	/** Own Production Receipt = 3PR */
	public static final String WEIGHMENTENTRYTYPE_OwnProductionReceipt = "3PR";
	/** Subcontract Production Receipt = 4SR */
	public static final String WEIGHMENTENTRYTYPE_SubcontractProductionReceipt = "4SR";
	/** Stock to Crusher = 5KA */
	public static final String WEIGHMENTENTRYTYPE_StockToCrusher = "5KA";
	/** Other Purchase = 8OP */
	public static final String WEIGHMENTENTRYTYPE_OtherPurchase = "8OP";
	/** Crusher to Stock = 9CA */
	public static final String WEIGHMENTENTRYTYPE_CrusherToStock = "9CA";
	/** Set Type.
		@param WeighmentEntryType Type
	*/
	public void setWeighmentEntryType (String WeighmentEntryType)
	{

		set_Value (COLUMNNAME_WeighmentEntryType, WeighmentEntryType);
	}

	/** Get Type.
		@return Type	  */
	public String getWeighmentEntryType()
	{
		return (String)get_Value(COLUMNNAME_WeighmentEntryType);
	}
}