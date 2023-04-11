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
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for TF_Generate_TaxInvoiceLine
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_Generate_TaxInvoiceLine extends PO implements I_TF_Generate_TaxInvoiceLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200212L;

    /** Standard Constructor */
    public X_TF_Generate_TaxInvoiceLine (Properties ctx, int TF_Generate_TaxInvoiceLine_ID, String trxName)
    {
      super (ctx, TF_Generate_TaxInvoiceLine_ID, trxName);
      /** if (TF_Generate_TaxInvoiceLine_ID == 0)
        {
			setC_UOM_ID (0);
			setM_Product_ID (0);
			setTF_Generate_Taxinvoice_ID (0);
			setTF_Generate_TaxinvoiceLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Generate_TaxInvoiceLine (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
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
      StringBuffer sb = new StringBuffer ("X_TF_Generate_TaxInvoiceLine[")
        .append(get_ID()).append("]");
      return sb.toString();
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
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
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

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException
    {
		return (org.compiere.model.I_C_Order)MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
			.getPO(getC_Order_ID(), get_TrxName());	}

	/** Set Order.
		@param C_Order_ID 
		Order
	  */
	public void setC_Order_ID (int C_Order_ID)
	{
		if (C_Order_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Order_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
	}

	/** Get Order.
		@return Order
	  */
	public int getC_Order_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
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
			set_ValueNoCheck (COLUMNNAME_C_UOM_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
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

	/** Set Line No.
		@param Line 
		Unique line for this document
	  */
	public void setLine (int Line)
	{
		set_ValueNoCheck (COLUMNNAME_Line, Integer.valueOf(Line));
	}

	/** Get Line No.
		@return Unique line for this document
	  */
	public int getLine () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Line);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Line Total.
		@param LineTotalAmt 
		Total line amount incl. Tax
	  */
	public void setLineTotalAmt (BigDecimal LineTotalAmt)
	{
		set_ValueNoCheck (COLUMNNAME_LineTotalAmt, LineTotalAmt);
	}

	/** Get Line Total.
		@return Total line amount incl. Tax
	  */
	public BigDecimal getLineTotalAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LineTotalAmt);
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
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
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

	public I_TF_Destination getTF_Destination() throws RuntimeException
    {
		return (I_TF_Destination)MTable.get(getCtx(), I_TF_Destination.Table_Name)
			.getPO(getTF_Destination_ID(), get_TrxName());	}

	/** Set Destination.
		@param TF_Destination_ID Destination	  */
	public void setTF_Destination_ID (int TF_Destination_ID)
	{
		if (TF_Destination_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Destination_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Destination_ID, Integer.valueOf(TF_Destination_ID));
	}

	/** Get Destination.
		@return Destination	  */
	public int getTF_Destination_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Destination_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Generate_TaxInvoice getTF_Generate_Taxinvoice() throws RuntimeException
    {
		return (I_TF_Generate_TaxInvoice)MTable.get(getCtx(), I_TF_Generate_TaxInvoice.Table_Name)
			.getPO(getTF_Generate_Taxinvoice_ID(), get_TrxName());	}

	/** Set Generate Taxinvoice.
		@param TF_Generate_Taxinvoice_ID Generate Taxinvoice	  */
	public void setTF_Generate_Taxinvoice_ID (int TF_Generate_Taxinvoice_ID)
	{
		if (TF_Generate_Taxinvoice_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Generate_Taxinvoice_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Generate_Taxinvoice_ID, Integer.valueOf(TF_Generate_Taxinvoice_ID));
	}

	/** Get Generate Taxinvoice.
		@return Generate Taxinvoice	  */
	public int getTF_Generate_Taxinvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Generate_Taxinvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Generate_TaxinvoiceLine_ID.
		@param TF_Generate_TaxinvoiceLine_ID TF_Generate_TaxinvoiceLine_ID	  */
	public void setTF_Generate_TaxinvoiceLine_ID (int TF_Generate_TaxinvoiceLine_ID)
	{
		if (TF_Generate_TaxinvoiceLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Generate_TaxinvoiceLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Generate_TaxinvoiceLine_ID, Integer.valueOf(TF_Generate_TaxinvoiceLine_ID));
	}

	/** Get TF_Generate_TaxinvoiceLine_ID.
		@return TF_Generate_TaxinvoiceLine_ID	  */
	public int getTF_Generate_TaxinvoiceLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Generate_TaxinvoiceLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Generate_TaxinvoiceLine_UU.
		@param TF_Generate_TaxinvoiceLine_UU TF_Generate_TaxinvoiceLine_UU	  */
	public void setTF_Generate_TaxinvoiceLine_UU (String TF_Generate_TaxinvoiceLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Generate_TaxinvoiceLine_UU, TF_Generate_TaxinvoiceLine_UU);
	}

	/** Get TF_Generate_TaxinvoiceLine_UU.
		@return TF_Generate_TaxinvoiceLine_UU	  */
	public String getTF_Generate_TaxinvoiceLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Generate_TaxinvoiceLine_UU);
	}
}