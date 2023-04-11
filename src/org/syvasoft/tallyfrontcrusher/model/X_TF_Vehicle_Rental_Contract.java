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

/** Generated Model for TF_Vehicle_Rental_Contract
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_Vehicle_Rental_Contract extends PO implements I_TF_Vehicle_Rental_Contract, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20170322L;

    /** Standard Constructor */
    public X_TF_Vehicle_Rental_Contract (Properties ctx, int TF_Vehicle_Rental_Contract_ID, String trxName)
    {
      super (ctx, TF_Vehicle_Rental_Contract_ID, trxName);
      /** if (TF_Vehicle_Rental_Contract_ID == 0)
        {
			setC_BPartner_ID (0);
			setContractBase (null);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDateEnd (new Timestamp( System.currentTimeMillis() ));
			setDateStart (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDocumentNo (null);
			setIsFuelIncluded (false);
			setProcessed (false);
			setQty (Env.ZERO);
			setQtyInvoiced (Env.ZERO);
// 0
			setS_ResourceType_ID (0);
			setTF_Vehicle_Rental_Contract_ID (0);
			setVehicleNo (null);
        } */
    }

    /** Load Constructor */
    public X_TF_Vehicle_Rental_Contract (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Vehicle_Rental_Contract[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Vendor.
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Vendor.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException
    {
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getC_Charge_ID(), get_TrxName());	}

	/** Set Charge.
		@param C_Charge_ID 
		Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID)
	{
		if (C_Charge_ID < 1) 
			set_Value (COLUMNNAME_C_Charge_ID, null);
		else 
			set_Value (COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
	}

	/** Get Charge.
		@return Additional document charges
	  */
	public int getC_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Charge_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValue_ID(), get_TrxName());	}

	/** Set Account Element.
		@param C_ElementValue_ID 
		Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID)
	{
		if (C_ElementValue_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
	}

	/** Get Account Element.
		@return Account Element
	  */
	public int getC_ElementValue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getC_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param C_UOM_ID 
		Unit of Measure
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
	public int getC_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Closing Meter.
		@param Closing_Meter Closing Meter	  */
	public void setClosing_Meter (BigDecimal Closing_Meter)
	{
		set_Value (COLUMNNAME_Closing_Meter, Closing_Meter);
	}

	/** Get Closing Meter.
		@return Closing Meter	  */
	public BigDecimal getClosing_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Closing_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Contract Amt (Actual).
		@param Contract_Amt_Act Contract Amt (Actual)	  */
	public void setContract_Amt_Act (BigDecimal Contract_Amt_Act)
	{
		set_Value (COLUMNNAME_Contract_Amt_Act, Contract_Amt_Act);
	}

	/** Get Contract Amt (Actual).
		@return Contract Amt (Actual)	  */
	public BigDecimal getContract_Amt_Act () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Contract_Amt_Act);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Contract Amt (Estimated).
		@param Contract_Amt_Est Contract Amt (Estimated)	  */
	public void setContract_Amt_Est (BigDecimal Contract_Amt_Est)
	{
		set_Value (COLUMNNAME_Contract_Amt_Est, Contract_Amt_Est);
	}

	/** Get Contract Amt (Estimated).
		@return Contract Amt (Estimated)	  */
	public BigDecimal getContract_Amt_Est () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Contract_Amt_Est);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Day = D */
	public static final String CONTRACTBASE_Day = "D";
	/** Meter = M */
	public static final String CONTRACTBASE_Meter = "M";
	/** Month = O */
	public static final String CONTRACTBASE_Month = "O";
	/** Set Contract Base.
		@param ContractBase 
		Represents how the contract amount will be calculated.
	  */
	public void setContractBase (String ContractBase)
	{

		set_Value (COLUMNNAME_ContractBase, ContractBase);
	}

	/** Get Contract Base.
		@return Represents how the contract amount will be calculated.
	  */
	public String getContractBase () 
	{
		return (String)get_Value(COLUMNNAME_ContractBase);
	}

	/** Set Create Invoice.
		@param CreateInvoice Create Invoice	  */
	public void setCreateInvoice (String CreateInvoice)
	{
		set_Value (COLUMNNAME_CreateInvoice, CreateInvoice);
	}

	/** Get Create Invoice.
		@return Create Invoice	  */
	public String getCreateInvoice () 
	{
		return (String)get_Value(COLUMNNAME_CreateInvoice);
	}

	/** Set Account Date.
		@param DateAcct 
		Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct)
	{
		set_Value (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set End Date.
		@param DateEnd End Date	  */
	public void setDateEnd (Timestamp DateEnd)
	{
		set_Value (COLUMNNAME_DateEnd, DateEnd);
	}

	/** Get End Date.
		@return End Date	  */
	public Timestamp getDateEnd () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd);
	}

	/** Set Date Start.
		@param DateStart 
		Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart)
	{
		set_Value (COLUMNNAME_DateStart, DateStart);
	}

	/** Get Date Start.
		@return Date Start for this Order
	  */
	public Timestamp getDateStart () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Start = S */
	public static final String DOCACTION_Start = "S";
	/** End = E */
	public static final String DOCACTION_End = "E";
	/** Modify = D */
	public static final String DOCACTION_Modify = "D";
	/** Force Close = X */
	public static final String DOCACTION_ForceClose = "X";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Suspended = SU */
	public static final String DOCSTATUS_Suspended = "SU";
	/** Activated = AC */
	public static final String DOCSTATUS_Activated = "AC";
	/** Canceled = CA */
	public static final String DOCSTATUS_Canceled = "CA";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Fuel Deducted Qty.
		@param Fuel_Deducted_Qty Fuel Deducted Qty	  */
	public void setFuel_Deducted_Qty (BigDecimal Fuel_Deducted_Qty)
	{
		set_Value (COLUMNNAME_Fuel_Deducted_Qty, Fuel_Deducted_Qty);
	}

	/** Get Fuel Deducted Qty.
		@return Fuel Deducted Qty	  */
	public BigDecimal getFuel_Deducted_Qty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Fuel_Deducted_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Fuel Issued Total Qty.
		@param Fuel_Issued_Total_Qty Fuel Issued Total Qty	  */
	public void setFuel_Issued_Total_Qty (BigDecimal Fuel_Issued_Total_Qty)
	{
		throw new IllegalArgumentException ("Fuel_Issued_Total_Qty is virtual column");	}

	/** Get Fuel Issued Total Qty.
		@return Fuel Issued Total Qty	  */
	public BigDecimal getFuel_Issued_Total_Qty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Fuel_Issued_Total_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Fuel Price.
		@param Fuel_Price Fuel Price	  */
	public void setFuel_Price (BigDecimal Fuel_Price)
	{
		set_Value (COLUMNNAME_Fuel_Price, Fuel_Price);
	}

	/** Get Fuel Price.
		@return Fuel Price	  */
	public BigDecimal getFuel_Price () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Fuel_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Fuel Total Cost.
		@param Fuel_Total_Cost Fuel Total Cost	  */
	public void setFuel_Total_Cost (BigDecimal Fuel_Total_Cost)
	{
		set_Value (COLUMNNAME_Fuel_Total_Cost, Fuel_Total_Cost);
	}

	/** Get Fuel Total Cost.
		@return Fuel Total Cost	  */
	public BigDecimal getFuel_Total_Cost () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Fuel_Total_Cost);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Invoiced Amount.
		@param Invoiced_Amt Invoiced Amount	  */
	public void setInvoiced_Amt (BigDecimal Invoiced_Amt)
	{
		set_Value (COLUMNNAME_Invoiced_Amt, Invoiced_Amt);
	}

	/** Get Invoiced Amount.
		@return Invoiced Amount	  */
	public BigDecimal getInvoiced_Amt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Invoiced_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Fuel Included.
		@param IsFuelIncluded Fuel Included	  */
	public void setIsFuelIncluded (boolean IsFuelIncluded)
	{
		set_Value (COLUMNNAME_IsFuelIncluded, Boolean.valueOf(IsFuelIncluded));
	}

	/** Get Fuel Included.
		@return Fuel Included	  */
	public boolean isFuelIncluded () 
	{
		Object oo = get_Value(COLUMNNAME_IsFuelIncluded);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Issued Fuel.
		@param Issued_Fuel Issued Fuel	  */
	public void setIssued_Fuel (BigDecimal Issued_Fuel)
	{
		set_Value (COLUMNNAME_Issued_Fuel, Issued_Fuel);
	}

	/** Get Issued Fuel.
		@return Issued Fuel	  */
	public BigDecimal getIssued_Fuel () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Issued_Fuel);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
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
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Opening Fuel.
		@param Opening_Fuel Opening Fuel	  */
	public void setOpening_Fuel (BigDecimal Opening_Fuel)
	{
		set_Value (COLUMNNAME_Opening_Fuel, Opening_Fuel);
	}

	/** Get Opening Fuel.
		@return Opening Fuel	  */
	public BigDecimal getOpening_Fuel () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Opening_Fuel);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Opening Meter.
		@param Opening_Meter Opening Meter	  */
	public void setOpening_Meter (BigDecimal Opening_Meter)
	{
		set_Value (COLUMNNAME_Opening_Meter, Opening_Meter);
	}

	/** Get Opening Meter.
		@return Opening Meter	  */
	public BigDecimal getOpening_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Opening_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
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
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
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

	/** Set Quantity.
		@param Qty 
		Quantity
	  */
	public void setQty (BigDecimal Qty)
	{
		set_Value (COLUMNNAME_Qty, Qty);
	}

	/** Get Quantity.
		@return Quantity
	  */
	public BigDecimal getQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Quantity Invoiced.
		@param QtyInvoiced 
		Invoiced Quantity
	  */
	public void setQtyInvoiced (BigDecimal QtyInvoiced)
	{
		set_Value (COLUMNNAME_QtyInvoiced, QtyInvoiced);
	}

	/** Get Quantity Invoiced.
		@return Invoiced Quantity
	  */
	public BigDecimal getQtyInvoiced () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyInvoiced);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Running Meter.
		@param Running_Meter Running Meter	  */
	public void setRunning_Meter (BigDecimal Running_Meter)
	{
		set_Value (COLUMNNAME_Running_Meter, Running_Meter);
	}

	/** Get Running Meter.
		@return Running Meter	  */
	public BigDecimal getRunning_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Running_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_S_Resource getS_Resource() throws RuntimeException
    {
		return (org.compiere.model.I_S_Resource)MTable.get(getCtx(), org.compiere.model.I_S_Resource.Table_Name)
			.getPO(getS_Resource_ID(), get_TrxName());	}

	/** Set Resource.
		@param S_Resource_ID 
		Resource
	  */
	public void setS_Resource_ID (int S_Resource_ID)
	{
		if (S_Resource_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_S_Resource_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_S_Resource_ID, Integer.valueOf(S_Resource_ID));
	}

	/** Get Resource.
		@return Resource
	  */
	public int getS_Resource_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_S_Resource_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_S_ResourceType getS_ResourceType() throws RuntimeException
    {
		return (org.compiere.model.I_S_ResourceType)MTable.get(getCtx(), org.compiere.model.I_S_ResourceType.Table_Name)
			.getPO(getS_ResourceType_ID(), get_TrxName());	}

	/** Set Resource Type.
		@param S_ResourceType_ID Resource Type	  */
	public void setS_ResourceType_ID (int S_ResourceType_ID)
	{
		if (S_ResourceType_ID < 1) 
			set_Value (COLUMNNAME_S_ResourceType_ID, null);
		else 
			set_Value (COLUMNNAME_S_ResourceType_ID, Integer.valueOf(S_ResourceType_ID));
	}

	/** Get Resource Type.
		@return Resource Type	  */
	public int getS_ResourceType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_S_ResourceType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Vehicle Rental Contract.
		@param TF_Vehicle_Rental_Contract_ID Vehicle Rental Contract	  */
	public void setTF_Vehicle_Rental_Contract_ID (int TF_Vehicle_Rental_Contract_ID)
	{
		if (TF_Vehicle_Rental_Contract_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Vehicle_Rental_Contract_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Vehicle_Rental_Contract_ID, Integer.valueOf(TF_Vehicle_Rental_Contract_ID));
	}

	/** Get Vehicle Rental Contract.
		@return Vehicle Rental Contract	  */
	public int getTF_Vehicle_Rental_Contract_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Vehicle_Rental_Contract_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Vehicle_Rental_Contract_UU.
		@param TF_Vehicle_Rental_Contract_UU TF_Vehicle_Rental_Contract_UU	  */
	public void setTF_Vehicle_Rental_Contract_UU (String TF_Vehicle_Rental_Contract_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Vehicle_Rental_Contract_UU, TF_Vehicle_Rental_Contract_UU);
	}

	/** Get TF_Vehicle_Rental_Contract_UU.
		@return TF_Vehicle_Rental_Contract_UU	  */
	public String getTF_Vehicle_Rental_Contract_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Vehicle_Rental_Contract_UU);
	}

	/** Set Unit Price.
		@param Unit_Price Unit Price	  */
	public void setUnit_Price (BigDecimal Unit_Price)
	{
		set_Value (COLUMNNAME_Unit_Price, Unit_Price);
	}

	/** Get Unit Price.
		@return Unit Price	  */
	public BigDecimal getUnit_Price () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Unit_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Vehicle No.
		@param VehicleNo Vehicle No	  */
	public void setVehicleNo (String VehicleNo)
	{
		set_Value (COLUMNNAME_VehicleNo, VehicleNo);
	}

	/** Get Vehicle No.
		@return Vehicle No	  */
	public String getVehicleNo () 
	{
		return (String)get_Value(COLUMNNAME_VehicleNo);
	}
}