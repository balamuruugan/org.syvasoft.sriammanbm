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

/** Generated Model for TF_TRTaxInvoiceLine
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_TRTaxInvoiceLine extends PO implements I_TF_TRTaxInvoiceLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190709L;

    /** Standard Constructor */
    public X_TF_TRTaxInvoiceLine (Properties ctx, int TF_TRTaxInvoiceLine_ID, String trxName)
    {
      super (ctx, TF_TRTaxInvoiceLine_ID, trxName);
      /** if (TF_TRTaxInvoiceLine_ID == 0)
        {
			setC_UOM_ID (0);
			setM_Product_ID (0);
			setTF_TRTaxInvoice_ID (0);
			setTF_TRTaxInvoiceLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TRTaxInvoiceLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TRTaxInvoiceLine[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set Line Total.
		@param LineTotalAmt 
		Total line amount incl. Tax
	  */
	public void setLineTotalAmt (BigDecimal LineTotalAmt)
	{
		set_Value (COLUMNNAME_LineTotalAmt, LineTotalAmt);
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

	public I_TF_TRTaxInvoice getTF_TRTaxInvoice() throws RuntimeException
    {
		return (I_TF_TRTaxInvoice)MTable.get(getCtx(), I_TF_TRTaxInvoice.Table_Name)
			.getPO(getTF_TRTaxInvoice_ID(), get_TrxName());	}

	/** Set Sales Tax Invoice (Trading).
		@param TF_TRTaxInvoice_ID Sales Tax Invoice (Trading)	  */
	public void setTF_TRTaxInvoice_ID (int TF_TRTaxInvoice_ID)
	{
		if (TF_TRTaxInvoice_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TRTaxInvoice_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TRTaxInvoice_ID, Integer.valueOf(TF_TRTaxInvoice_ID));
	}

	/** Get Sales Tax Invoice (Trading).
		@return Sales Tax Invoice (Trading)	  */
	public int getTF_TRTaxInvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TRTaxInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tax Invoice Line (Trading).
		@param TF_TRTaxInvoiceLine_ID Tax Invoice Line (Trading)	  */
	public void setTF_TRTaxInvoiceLine_ID (int TF_TRTaxInvoiceLine_ID)
	{
		if (TF_TRTaxInvoiceLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TRTaxInvoiceLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TRTaxInvoiceLine_ID, Integer.valueOf(TF_TRTaxInvoiceLine_ID));
	}

	/** Get Tax Invoice Line (Trading).
		@return Tax Invoice Line (Trading)	  */
	public int getTF_TRTaxInvoiceLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TRTaxInvoiceLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TRTaxInvoiceLine_UU.
		@param TF_TRTaxInvoiceLine_UU TF_TRTaxInvoiceLine_UU	  */
	public void setTF_TRTaxInvoiceLine_UU (String TF_TRTaxInvoiceLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TRTaxInvoiceLine_UU, TF_TRTaxInvoiceLine_UU);
	}

	/** Get TF_TRTaxInvoiceLine_UU.
		@return TF_TRTaxInvoiceLine_UU	  */
	public String getTF_TRTaxInvoiceLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TRTaxInvoiceLine_UU);
	}
}