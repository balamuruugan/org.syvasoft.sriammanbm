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

/** Generated Model for TF_TaxInvoice
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_TaxInvoice extends PO implements I_TF_TaxInvoice, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180506L;

    /** Standard Constructor */
    public X_TF_TaxInvoice (Properties ctx, int TF_TaxInvoice_ID, String trxName)
    {
      super (ctx, TF_TaxInvoice_ID, trxName);
      /** if (TF_TaxInvoice_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_UOM_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDocumentNo (null);
			setM_Product_ID (0);
			setProcessed (false);
			setQtyPermitDeducted (Env.ZERO);
			setSGST_Amt (Env.ZERO);
			setTF_TaxInvoice_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TaxInvoice (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TaxInvoice[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
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

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner_Location)MTable.get(getCtx(), org.compiere.model.I_C_BPartner_Location.Table_Name)
			.getPO(getC_BPartner_Location_ID(), get_TrxName());	}

	/** Set Partner Location.
		@param C_BPartner_Location_ID 
		Identifies the (ship to) address for this Business Partner
	  */
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID)
	{
		if (C_BPartner_Location_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
	}

	/** Get Partner Location.
		@return Identifies the (ship to) address for this Business Partner
	  */
	public int getC_BPartner_Location_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getC_ElementValueGST() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValueGST_ID(), get_TrxName());	}

	/** Set GST Account Head.
		@param C_ElementValueGST_ID GST Account Head	  */
	public void setC_ElementValueGST_ID (int C_ElementValueGST_ID)
	{
		if (C_ElementValueGST_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValueGST_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValueGST_ID, Integer.valueOf(C_ElementValueGST_ID));
	}

	/** Get GST Account Head.
		@return GST Account Head	  */
	public int getC_ElementValueGST_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValueGST_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
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
	public int getC_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
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

	/** Set CGST Amount.
		@param CGST_Amt CGST Amount	  */
	public void setCGST_Amt (BigDecimal CGST_Amt)
	{
		set_Value (COLUMNNAME_CGST_Amt, CGST_Amt);
	}

	/** Get CGST Amount.
		@return CGST Amount	  */
	public BigDecimal getCGST_Amt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CGST_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set CGST %.
		@param CGST_Rate CGST %	  */
	public void setCGST_Rate (BigDecimal CGST_Rate)
	{
		set_Value (COLUMNNAME_CGST_Rate, CGST_Rate);
	}

	/** Get CGST %.
		@return CGST %	  */
	public BigDecimal getCGST_Rate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CGST_Rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Destination.
		@param Destination Destination	  */
	public void setDestination (String Destination)
	{
		set_Value (COLUMNNAME_Destination, Destination);
	}

	/** Get Destination.
		@return Destination	  */
	public String getDestination () 
	{
		return (String)get_Value(COLUMNNAME_Destination);
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

	/** Set Grand Total.
		@param GrandTotal 
		Total amount of document
	  */
	public void setGrandTotal (BigDecimal GrandTotal)
	{
		set_ValueNoCheck (COLUMNNAME_GrandTotal, GrandTotal);
	}

	/** Get Grand Total.
		@return Total amount of document
	  */
	public BigDecimal getGrandTotal () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GrandTotal);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set IGST Amt.
		@param IGST_Amt IGST Amt	  */
	public void setIGST_Amt (BigDecimal IGST_Amt)
	{
		set_Value (COLUMNNAME_IGST_Amt, IGST_Amt);
	}

	/** Get IGST Amt.
		@return IGST Amt	  */
	public BigDecimal getIGST_Amt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_IGST_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set IGST %.
		@param IGST_Rate IGST %	  */
	public void setIGST_Rate (BigDecimal IGST_Rate)
	{
		set_Value (COLUMNNAME_IGST_Rate, IGST_Rate);
	}

	/** Get IGST %.
		@return IGST %	  */
	public BigDecimal getIGST_Rate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_IGST_Rate);
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

	/** Set MDP No.
		@param MDPNo MDP No	  */
	public void setMDPNo (String MDPNo)
	{
		set_Value (COLUMNNAME_MDPNo, MDPNo);
	}

	/** Get MDP No.
		@return MDP No	  */
	public String getMDPNo () 
	{
		return (String)get_Value(COLUMNNAME_MDPNo);
	}

	/** Set Party Name.
		@param PartyName Party Name	  */
	public void setPartyName (String PartyName)
	{
		set_Value (COLUMNNAME_PartyName, PartyName);
	}

	/** Get Party Name.
		@return Party Name	  */
	public String getPartyName () 
	{
		return (String)get_Value(COLUMNNAME_PartyName);
	}

	/** Set Permit Amount.
		@param PermitAmount Permit Amount	  */
	public void setPermitAmount (BigDecimal PermitAmount)
	{
		set_Value (COLUMNNAME_PermitAmount, PermitAmount);
	}

	/** Get Permit Amount.
		@return Permit Amount	  */
	public BigDecimal getPermitAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Post Permit Amount to Customer.
		@param PostPermitAmtToCustomer Post Permit Amount to Customer	  */
	public void setPostPermitAmtToCustomer (boolean PostPermitAmtToCustomer)
	{
		set_Value (COLUMNNAME_PostPermitAmtToCustomer, Boolean.valueOf(PostPermitAmtToCustomer));
	}

	/** Get Post Permit Amount to Customer.
		@return Post Permit Amount to Customer	  */
	public boolean isPostPermitAmtToCustomer () 
	{
		Object oo = get_Value(COLUMNNAME_PostPermitAmtToCustomer);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Post GST to Customer.
		@param PostTaxToCustomer Post GST to Customer	  */
	public void setPostTaxToCustomer (boolean PostTaxToCustomer)
	{
		set_Value (COLUMNNAME_PostTaxToCustomer, Boolean.valueOf(PostTaxToCustomer));
	}

	/** Get Post GST to Customer.
		@return Post GST to Customer	  */
	public boolean isPostTaxToCustomer () 
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

	/** Set Price.
		@param Price 
		Price
	  */
	public void setPrice (BigDecimal Price)
	{
		set_Value (COLUMNNAME_Price, Price);
	}

	/** Get Price.
		@return Price
	  */
	public BigDecimal getPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price);
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

	/** Set Permit Deducted Qty.
		@param QtyPermitDeducted Permit Deducted Qty	  */
	public void setQtyPermitDeducted (BigDecimal QtyPermitDeducted)
	{
		set_Value (COLUMNNAME_QtyPermitDeducted, QtyPermitDeducted);
	}

	/** Get Permit Deducted Qty.
		@return Permit Deducted Qty	  */
	public BigDecimal getQtyPermitDeducted () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyPermitDeducted);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Rounding Off.
		@param RoundingOff Rounding Off	  */
	public void setRoundingOff (BigDecimal RoundingOff)
	{
		set_Value (COLUMNNAME_RoundingOff, RoundingOff);
	}

	/** Get Rounding Off.
		@return Rounding Off	  */
	public BigDecimal getRoundingOff () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RoundingOff);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set SGST Amount.
		@param SGST_Amt SGST Amount	  */
	public void setSGST_Amt (BigDecimal SGST_Amt)
	{
		set_Value (COLUMNNAME_SGST_Amt, SGST_Amt);
	}

	/** Get SGST Amount.
		@return SGST Amount	  */
	public BigDecimal getSGST_Amt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SGST_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set SGSt %.
		@param SGST_Rate SGSt %	  */
	public void setSGST_Rate (BigDecimal SGST_Rate)
	{
		set_Value (COLUMNNAME_SGST_Rate, SGST_Rate);
	}

	/** Get SGSt %.
		@return SGSt %	  */
	public BigDecimal getSGST_Rate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SGST_Rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Taxable Amount.
		@param TaxableAmount Taxable Amount	  */
	public void setTaxableAmount (BigDecimal TaxableAmount)
	{
		set_Value (COLUMNNAME_TaxableAmount, TaxableAmount);
	}

	/** Get Taxable Amount.
		@return Taxable Amount	  */
	public BigDecimal getTaxableAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TaxableAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_Quarry getTF_Quarry() throws RuntimeException
    {
		return (I_TF_Quarry)MTable.get(getCtx(), I_TF_Quarry.Table_Name)
			.getPO(getTF_Quarry_ID(), get_TrxName());	}

	/** Set Quarry.
		@param TF_Quarry_ID Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID)
	{
		if (TF_Quarry_ID < 1) 
			set_Value (COLUMNNAME_TF_Quarry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Quarry_ID, Integer.valueOf(TF_Quarry_ID));
	}

	/** Get Quarry.
		@return Quarry	  */
	public int getTF_Quarry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Quarry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tax Invoice.
		@param TF_TaxInvoice_ID Tax Invoice	  */
	public void setTF_TaxInvoice_ID (int TF_TaxInvoice_ID)
	{
		if (TF_TaxInvoice_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TaxInvoice_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TaxInvoice_ID, Integer.valueOf(TF_TaxInvoice_ID));
	}

	/** Get Tax Invoice.
		@return Tax Invoice	  */
	public int getTF_TaxInvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TaxInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TaxInvoice_UU.
		@param TF_TaxInvoice_UU TF_TaxInvoice_UU	  */
	public void setTF_TaxInvoice_UU (String TF_TaxInvoice_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TaxInvoice_UU, TF_TaxInvoice_UU);
	}

	/** Get TF_TaxInvoice_UU.
		@return TF_TaxInvoice_UU	  */
	public String getTF_TaxInvoice_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TaxInvoice_UU);
	}

	public I_TF_Weighment_Permit getTF_Weighment_Permit() throws RuntimeException
    {
		return (I_TF_Weighment_Permit)MTable.get(getCtx(), I_TF_Weighment_Permit.Table_Name)
			.getPO(getTF_Weighment_Permit_ID(), get_TrxName());	}

	/** Set Weighment Entry (Permit).
		@param TF_Weighment_Permit_ID Weighment Entry (Permit)	  */
	public void setTF_Weighment_Permit_ID (int TF_Weighment_Permit_ID)
	{
		if (TF_Weighment_Permit_ID < 1) 
			set_Value (COLUMNNAME_TF_Weighment_Permit_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Weighment_Permit_ID, Integer.valueOf(TF_Weighment_Permit_ID));
	}

	/** Get Weighment Entry (Permit).
		@return Weighment Entry (Permit)	  */
	public int getTF_Weighment_Permit_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Weighment_Permit_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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