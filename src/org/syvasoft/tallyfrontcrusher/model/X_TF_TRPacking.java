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

/** Generated Model for TF_TRPacking
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_TRPacking extends PO implements I_TF_TRPacking, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190620L;

    /** Standard Constructor */
    public X_TF_TRPacking (Properties ctx, int TF_TRPacking_ID, String trxName)
    {
      super (ctx, TF_TRPacking_ID, trxName);
      /** if (TF_TRPacking_ID == 0)
        {
			setBagType (null);
			setKgPerBag (Env.ZERO);
			setQtyBag (Env.ZERO);
			setTF_TRPacking_ID (0);
			setTF_TRTaxInvoice_ID (0);
			setTotalKg (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_TF_TRPacking (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TRPacking[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Bag Type.
		@param BagType Bag Type	  */
	public void setBagType (String BagType)
	{
		set_Value (COLUMNNAME_BagType, BagType);
	}

	/** Get Bag Type.
		@return Bag Type	  */
	public String getBagType () 
	{
		return (String)get_Value(COLUMNNAME_BagType);
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

	/** Set Kg / Bag.
		@param KgPerBag Kg / Bag	  */
	public void setKgPerBag (BigDecimal KgPerBag)
	{
		set_Value (COLUMNNAME_KgPerBag, KgPerBag);
	}

	/** Get Kg / Bag.
		@return Kg / Bag	  */
	public BigDecimal getKgPerBag () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_KgPerBag);
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

	/** Set Bag Qty.
		@param QtyBag Bag Qty	  */
	public void setQtyBag (BigDecimal QtyBag)
	{
		set_Value (COLUMNNAME_QtyBag, QtyBag);
	}

	/** Get Bag Qty.
		@return Bag Qty	  */
	public BigDecimal getQtyBag () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyBag);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Packing Detail.
		@param TF_TRPacking_ID Packing Detail	  */
	public void setTF_TRPacking_ID (int TF_TRPacking_ID)
	{
		if (TF_TRPacking_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TRPacking_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TRPacking_ID, Integer.valueOf(TF_TRPacking_ID));
	}

	/** Get Packing Detail.
		@return Packing Detail	  */
	public int getTF_TRPacking_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TRPacking_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TRPacking_UU.
		@param TF_TRPacking_UU TF_TRPacking_UU	  */
	public void setTF_TRPacking_UU (String TF_TRPacking_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TRPacking_UU, TF_TRPacking_UU);
	}

	/** Get TF_TRPacking_UU.
		@return TF_TRPacking_UU	  */
	public String getTF_TRPacking_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TRPacking_UU);
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

	/** Set Total Kg.
		@param TotalKg Total Kg	  */
	public void setTotalKg (BigDecimal TotalKg)
	{
		set_Value (COLUMNNAME_TotalKg, TotalKg);
	}

	/** Get Total Kg.
		@return Total Kg	  */
	public BigDecimal getTotalKg () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalKg);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}