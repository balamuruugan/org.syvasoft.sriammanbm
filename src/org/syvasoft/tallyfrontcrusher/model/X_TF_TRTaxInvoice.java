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

/** Generated Model for TF_TRTaxInvoice
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="TF_TRTaxInvoice")
public class X_TF_TRTaxInvoice extends PO implements I_TF_TRTaxInvoice, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240320L;

    /** Standard Constructor */
    public X_TF_TRTaxInvoice (Properties ctx, int TF_TRTaxInvoice_ID, String trxName)
    {
      super (ctx, TF_TRTaxInvoice_ID, trxName);
      /** if (TF_TRTaxInvoice_ID == 0)
        {
			setC_BankAccount_ID (0);
			setC_BPartner_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDocumentNo (null);
			setIsInterState (false);
// N
			setIsSOTrx (true);
// Y
			setPostGSTAsExpense (false);
// N
			setProcessed (false);
			setTF_TRTaxInvoice_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_TRTaxInvoice (Properties ctx, int TF_TRTaxInvoice_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_TRTaxInvoice_ID, trxName, virtualColumns);
      /** if (TF_TRTaxInvoice_ID == 0)
        {
			setC_BankAccount_ID (0);
			setC_BPartner_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDocumentNo (null);
			setIsInterState (false);
// N
			setIsSOTrx (true);
// Y
			setPostGSTAsExpense (false);
// N
			setProcessed (false);
			setTF_TRTaxInvoice_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TRTaxInvoice (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_TF_TRTaxInvoice[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AckDt.
		@param AckDt AckDt
	*/
	public void setAckDt (String AckDt)
	{
		set_Value (COLUMNNAME_AckDt, AckDt);
	}

	/** Get AckDt.
		@return AckDt	  */
	public String getAckDt()
	{
		return (String)get_Value(COLUMNNAME_AckDt);
	}

	/** Set AckNo.
		@param AckNo AckNo
	*/
	public void setAckNo (String AckNo)
	{
		set_Value (COLUMNNAME_AckNo, AckNo);
	}

	/** Get AckNo.
		@return AckNo	  */
	public String getAckNo()
	{
		return (String)get_Value(COLUMNNAME_AckNo);
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

	public org.compiere.model.I_C_BankAccount getC_BankAccount() throws RuntimeException
	{
		return (org.compiere.model.I_C_BankAccount)MTable.get(getCtx(), org.compiere.model.I_C_BankAccount.Table_ID)
			.getPO(getC_BankAccount_ID(), get_TrxName());
	}

	/** Set Bank/Cash Account.
		@param C_BankAccount_ID Account at the Bank
	*/
	public void setC_BankAccount_ID (int C_BankAccount_ID)
	{
		if (C_BankAccount_ID < 1)
			set_Value (COLUMNNAME_C_BankAccount_ID, null);
		else
			set_Value (COLUMNNAME_C_BankAccount_ID, Integer.valueOf(C_BankAccount_ID));
	}

	/** Get Bank/Cash Account.
		@return Account at the Bank
	  */
	public int getC_BankAccount_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BankAccount_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.compiere.model.I_C_BPartner getC_BPartnerShipTo() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartnerShipTo_ID(), get_TrxName());
	}

	/** Set Ship to party.
		@param C_BPartnerShipTo_ID Ship to party
	*/
	public void setC_BPartnerShipTo_ID (int C_BPartnerShipTo_ID)
	{
		if (C_BPartnerShipTo_ID < 1)
			set_Value (COLUMNNAME_C_BPartnerShipTo_ID, null);
		else
			set_Value (COLUMNNAME_C_BPartnerShipTo_ID, Integer.valueOf(C_BPartnerShipTo_ID));
	}

	/** Get Ship to party.
		@return Ship to party	  */
	public int getC_BPartnerShipTo_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartnerShipTo_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
	{
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_ID)
			.getPO(getC_DocType_ID(), get_TrxName());
	}

	/** Set Document Type.
		@param C_DocType_ID Document type or rules
	*/
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0)
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
	{
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_ID)
			.getPO(getC_Invoice_ID(), get_TrxName());
	}

	/** Set Invoice.
		@param C_Invoice_ID Invoice Identifier
	*/
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1)
			set_Value (COLUMNNAME_C_Invoice_ID, null);
		else
			set_Value (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
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

	/** Set Date of Supply.
		@param DateSupply Date of Supply
	*/
	public void setDateSupply (Timestamp DateSupply)
	{
		set_Value (COLUMNNAME_DateSupply, DateSupply);
	}

	/** Get Date of Supply.
		@return Date of Supply
	  */
	public Timestamp getDateSupply()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateSupply);
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

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** Activated = AC */
	public static final String DOCSTATUS_Activated = "AC";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Canceled = CA */
	public static final String DOCSTATUS_Canceled = "CA";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Due = DU */
	public static final String DOCSTATUS_Due = "DU";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Overdue = OD */
	public static final String DOCSTATUS_Overdue = "OD";
	/** Partially Billed = PB */
	public static final String DOCSTATUS_PartiallyBilled = "PB";
	/** Pending = PE */
	public static final String DOCSTATUS_Pending = "PE";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Rejected = RJ */
	public static final String DOCSTATUS_Rejected = "RJ";
	/** Suspended = SU */
	public static final String DOCSTATUS_Suspended = "SU";
	/** Upcoming = UP */
	public static final String DOCSTATUS_Upcoming = "UP";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Set Document Status.
		@param DocStatus The current status of the document
	*/
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus()
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
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

	/** Set Driver Doc No.
		@param DriverDocNo Driver Doc No
	*/
	public void setDriverDocNo (String DriverDocNo)
	{
		set_Value (COLUMNNAME_DriverDocNo, DriverDocNo);
	}

	/** Get Driver Doc No.
		@return Driver Doc No	  */
	public String getDriverDocNo()
	{
		return (String)get_Value(COLUMNNAME_DriverDocNo);
	}

	/** Set Driver Mobile No.
		@param DriverMobNo Driver Mobile No
	*/
	public void setDriverMobNo (String DriverMobNo)
	{
		set_Value (COLUMNNAME_DriverMobNo, DriverMobNo);
	}

	/** Get Driver Mobile No.
		@return Driver Mobile No	  */
	public String getDriverMobNo()
	{
		return (String)get_Value(COLUMNNAME_DriverMobNo);
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

	/** Set Dispatch From Address.
		@param DspFrom_Address Dispatch From Address
	*/
	public void setDspFrom_Address (String DspFrom_Address)
	{
		set_Value (COLUMNNAME_DspFrom_Address, DspFrom_Address);
	}

	/** Get Dispatch From Address.
		@return Dispatch From Address	  */
	public String getDspFrom_Address()
	{
		return (String)get_Value(COLUMNNAME_DspFrom_Address);
	}

	/** Set Dispatch From.
		@param DspFrom_Name Dispatch From
	*/
	public void setDspFrom_Name (String DspFrom_Name)
	{
		set_Value (COLUMNNAME_DspFrom_Name, DspFrom_Name);
	}

	/** Get Dispatch From.
		@return Dispatch From	  */
	public String getDspFrom_Name()
	{
		return (String)get_Value(COLUMNNAME_DspFrom_Name);
	}

	/** Set Dispatch From Place.
		@param DspFrom_Place Dispatch From Place
	*/
	public void setDspFrom_Place (String DspFrom_Place)
	{
		set_Value (COLUMNNAME_DspFrom_Place, DspFrom_Place);
	}

	/** Get Dispatch From Place.
		@return Dispatch From Place	  */
	public String getDspFrom_Place()
	{
		return (String)get_Value(COLUMNNAME_DspFrom_Place);
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

	/** Set Generate eInvoice.
		@param GenerateeInvoice Generate eInvoice
	*/
	public void setGenerateeInvoice (String GenerateeInvoice)
	{
		set_Value (COLUMNNAME_GenerateeInvoice, GenerateeInvoice);
	}

	/** Get Generate eInvoice.
		@return Generate eInvoice	  */
	public String getGenerateeInvoice()
	{
		return (String)get_Value(COLUMNNAME_GenerateeInvoice);
	}

	public org.compiere.model.I_GL_Journal getGL_Journal() throws RuntimeException
	{
		return (org.compiere.model.I_GL_Journal)MTable.get(getCtx(), org.compiere.model.I_GL_Journal.Table_ID)
			.getPO(getGL_Journal_ID(), get_TrxName());
	}

	/** Set Journal.
		@param GL_Journal_ID General Ledger Journal
	*/
	public void setGL_Journal_ID (int GL_Journal_ID)
	{
		if (GL_Journal_ID < 1)
			set_Value (COLUMNNAME_GL_Journal_ID, null);
		else
			set_Value (COLUMNNAME_GL_Journal_ID, Integer.valueOf(GL_Journal_ID));
	}

	/** Get Journal.
		@return General Ledger Journal
	  */
	public int getGL_Journal_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GL_Journal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Grand Total.
		@param GrandTotal Total amount of document
	*/
	public void setGrandTotal (BigDecimal GrandTotal)
	{
		set_ValueNoCheck (COLUMNNAME_GrandTotal, GrandTotal);
	}

	/** Get Grand Total.
		@return Total amount of document
	  */
	public BigDecimal getGrandTotal()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GrandTotal);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set IRN.
		@param IRN IRN
	*/
	public void setIRN (String IRN)
	{
		set_ValueNoCheck (COLUMNNAME_IRN, IRN);
	}

	/** Get IRN.
		@return IRN	  */
	public String getIRN()
	{
		return (String)get_Value(COLUMNNAME_IRN);
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

	/** Set Sales Transaction.
		@param IsSOTrx This is a Sales Transaction
	*/
	public void setIsSOTrx (boolean IsSOTrx)
	{
		set_ValueNoCheck (COLUMNNAME_IsSOTrx, Boolean.valueOf(IsSOTrx));
	}

	/** Get Sales Transaction.
		@return This is a Sales Transaction
	  */
	public boolean isSOTrx()
	{
		Object oo = get_Value(COLUMNNAME_IsSOTrx);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Place of Supply.
		@param PlaceOfSupply Place of Supply
	*/
	public void setPlaceOfSupply (String PlaceOfSupply)
	{
		set_Value (COLUMNNAME_PlaceOfSupply, PlaceOfSupply);
	}

	/** Get Place of Supply.
		@return Place of Supply	  */
	public String getPlaceOfSupply()
	{
		return (String)get_Value(COLUMNNAME_PlaceOfSupply);
	}

	/** Set Post GST as Expenses.
		@param PostGSTAsExpense Post GST as Expenses
	*/
	public void setPostGSTAsExpense (boolean PostGSTAsExpense)
	{
		set_Value (COLUMNNAME_PostGSTAsExpense, Boolean.valueOf(PostGSTAsExpense));
	}

	/** Get Post GST as Expenses.
		@return Post GST as Expenses	  */
	public boolean isPostGSTAsExpense()
	{
		Object oo = get_Value(COLUMNNAME_PostGSTAsExpense);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Post GST to Customer.
		@param PostTaxToCustomer Post GST to Customer
	*/
	public void setPostTaxToCustomer (boolean PostTaxToCustomer)
	{
		set_Value (COLUMNNAME_PostTaxToCustomer, Boolean.valueOf(PostTaxToCustomer));
	}

	/** Get Post GST to Customer.
		@return Post GST to Customer	  */
	public boolean isPostTaxToCustomer()
	{
		Object oo = get_Value(COLUMNNAME_PostTaxToCustomer);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Print eInvoice.
		@param PrinteInvoice Print eInvoice
	*/
	public void setPrinteInvoice (String PrinteInvoice)
	{
		set_Value (COLUMNNAME_PrinteInvoice, PrinteInvoice);
	}

	/** Get Print eInvoice.
		@return Print eInvoice	  */
	public String getPrinteInvoice()
	{
		return (String)get_Value(COLUMNNAME_PrinteInvoice);
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

	/** Set Process Now.
		@param Processing Process Now
	*/
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing()
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set RMC Permit No.
		@param RMCPermitNo RMC Permit No
	*/
	public void setRMCPermitNo (String RMCPermitNo)
	{
		set_Value (COLUMNNAME_RMCPermitNo, RMCPermitNo);
	}

	/** Get RMC Permit No.
		@return RMC Permit No	  */
	public String getRMCPermitNo()
	{
		return (String)get_Value(COLUMNNAME_RMCPermitNo);
	}

	/** Set Round Off.
		@param RoundOff Round Off
	*/
	public void setRoundOff (BigDecimal RoundOff)
	{
		set_Value (COLUMNNAME_RoundOff, RoundOff);
	}

	/** Get Round Off.
		@return Round Off	  */
	public BigDecimal getRoundOff()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RoundOff);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set SignedQRCode.
		@param SignedQRCode SignedQRCode
	*/
	public void setSignedQRCode (String SignedQRCode)
	{
		set_Value (COLUMNNAME_SignedQRCode, SignedQRCode);
	}

	/** Get SignedQRCode.
		@return SignedQRCode	  */
	public String getSignedQRCode()
	{
		return (String)get_Value(COLUMNNAME_SignedQRCode);
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
	
	/** Set Generate Tax Invoice.
		@param TF_Generate_Taxinvoice_ID Generate Tax Invoice
	*/
	public void setTF_Generate_Taxinvoice_ID (int TF_Generate_Taxinvoice_ID)
	{
		if (TF_Generate_Taxinvoice_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_Generate_Taxinvoice_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_Generate_Taxinvoice_ID, Integer.valueOf(TF_Generate_Taxinvoice_ID));
	}

	/** Get Generate Tax Invoice.
		@return Generate Tax Invoice	  */
	public int getTF_Generate_Taxinvoice_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Generate_Taxinvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Sales Tax Invoice (Trading).
		@param TF_TRTaxInvoice_ID Sales Tax Invoice (Trading)
	*/
	public void setTF_TRTaxInvoice_ID (int TF_TRTaxInvoice_ID)
	{
		if (TF_TRTaxInvoice_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_TRTaxInvoice_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_TRTaxInvoice_ID, Integer.valueOf(TF_TRTaxInvoice_ID));
	}

	/** Get Sales Tax Invoice (Trading).
		@return Sales Tax Invoice (Trading)	  */
	public int getTF_TRTaxInvoice_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TRTaxInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TRTaxInvoice_UU.
		@param TF_TRTaxInvoice_UU TF_TRTaxInvoice_UU
	*/
	public void setTF_TRTaxInvoice_UU (String TF_TRTaxInvoice_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TRTaxInvoice_UU, TF_TRTaxInvoice_UU);
	}

	/** Get TF_TRTaxInvoice_UU.
		@return TF_TRTaxInvoice_UU	  */
	public String getTF_TRTaxInvoice_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_TRTaxInvoice_UU);
	}

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException
	{
		return (I_TF_WeighmentEntry)MTable.get(getCtx(), I_TF_WeighmentEntry.Table_ID)
			.getPO(getTF_WeighmentEntry_ID(), get_TrxName());
	}

	/** Set Weighment Entry.
		@param TF_WeighmentEntry_ID Weighment Entry
	*/
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID)
	{
		if (TF_WeighmentEntry_ID < 1)
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, null);
		else
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, Integer.valueOf(TF_WeighmentEntry_ID));
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

	/** Set Total.
		@param Total Total
	*/
	public void setTotal (BigDecimal Total)
	{
		set_Value (COLUMNNAME_Total, Total);
	}

	/** Get Total.
		@return Total	  */
	public BigDecimal getTotal()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Total);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total Kg.
		@param TotalKg Total Kg
	*/
	public void setTotalKg (BigDecimal TotalKg)
	{
		throw new IllegalArgumentException ("TotalKg is virtual column");	}

	/** Get Total Kg.
		@return Total Kg	  */
	public BigDecimal getTotalKg()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalKg);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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
}