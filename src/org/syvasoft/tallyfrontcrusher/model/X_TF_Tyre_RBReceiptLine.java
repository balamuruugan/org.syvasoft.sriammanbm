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

/** Generated Model for TF_Tyre_RBReceiptLine
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_Tyre_RBReceiptLine extends PO implements I_TF_Tyre_RBReceiptLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190411L;

    /** Standard Constructor */
    public X_TF_Tyre_RBReceiptLine (Properties ctx, int TF_Tyre_RBReceiptLine_ID, String trxName)
    {
      super (ctx, TF_Tyre_RBReceiptLine_ID, trxName);
      /** if (TF_Tyre_RBReceiptLine_ID == 0)
        {
			setPrice (Env.ZERO);
			setProcessed (false);
// N
			setTF_Tyre_RBDeliveryLine_ID (0);
			setTF_Tyre_RBReceipt_ID (0);
			setTF_Tyre_RBReceiptLine_ID (0);
			setTF_TyreType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Tyre_RBReceiptLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Tyre_RBReceiptLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Brand.
		@param Brand Brand	  */
	public void setBrand (String Brand)
	{
		set_Value (COLUMNNAME_Brand, Brand);
	}

	/** Get Brand.
		@return Brand	  */
	public String getBrand () 
	{
		return (String)get_Value(COLUMNNAME_Brand);
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

	/** Set GST Amount.
		@param GSTAmount GST Amount	  */
	public void setGSTAmount (BigDecimal GSTAmount)
	{
		set_Value (COLUMNNAME_GSTAmount, GSTAmount);
	}

	/** Get GST Amount.
		@return GST Amount	  */
	public BigDecimal getGSTAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GSTAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set GST %.
		@param GSTRate GST %	  */
	public void setGSTRate (BigDecimal GSTRate)
	{
		set_Value (COLUMNNAME_GSTRate, GSTRate);
	}

	/** Get GST %.
		@return GST %	  */
	public BigDecimal getGSTRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GSTRate);
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
		set_Value (COLUMNNAME_Line, Integer.valueOf(Line));
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

	/** Set Size.
		@param Size Size	  */
	public void setSize (String Size)
	{
		set_Value (COLUMNNAME_Size, Size);
	}

	/** Get Size.
		@return Size	  */
	public String getSize () 
	{
		return (String)get_Value(COLUMNNAME_Size);
	}

	public I_TF_Tyre_RBDeliveryLine getTF_Tyre_RBDeliveryLine() throws RuntimeException
    {
		return (I_TF_Tyre_RBDeliveryLine)MTable.get(getCtx(), I_TF_Tyre_RBDeliveryLine.Table_Name)
			.getPO(getTF_Tyre_RBDeliveryLine_ID(), get_TrxName());	}

	/** Set Rebutton Tyres.
		@param TF_Tyre_RBDeliveryLine_ID Rebutton Tyres	  */
	public void setTF_Tyre_RBDeliveryLine_ID (int TF_Tyre_RBDeliveryLine_ID)
	{
		if (TF_Tyre_RBDeliveryLine_ID < 1) 
			set_Value (COLUMNNAME_TF_Tyre_RBDeliveryLine_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Tyre_RBDeliveryLine_ID, Integer.valueOf(TF_Tyre_RBDeliveryLine_ID));
	}

	/** Get Rebutton Tyres.
		@return Rebutton Tyres	  */
	public int getTF_Tyre_RBDeliveryLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_RBDeliveryLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Tyre_RBReceipt getTF_Tyre_RBReceipt() throws RuntimeException
    {
		return (I_TF_Tyre_RBReceipt)MTable.get(getCtx(), I_TF_Tyre_RBReceipt.Table_Name)
			.getPO(getTF_Tyre_RBReceipt_ID(), get_TrxName());	}

	/** Set Tyre Rebutton Receipt.
		@param TF_Tyre_RBReceipt_ID Tyre Rebutton Receipt	  */
	public void setTF_Tyre_RBReceipt_ID (int TF_Tyre_RBReceipt_ID)
	{
		if (TF_Tyre_RBReceipt_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBReceipt_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBReceipt_ID, Integer.valueOf(TF_Tyre_RBReceipt_ID));
	}

	/** Get Tyre Rebutton Receipt.
		@return Tyre Rebutton Receipt	  */
	public int getTF_Tyre_RBReceipt_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_RBReceipt_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Received Rebutton Tyre.
		@param TF_Tyre_RBReceiptLine_ID Received Rebutton Tyre	  */
	public void setTF_Tyre_RBReceiptLine_ID (int TF_Tyre_RBReceiptLine_ID)
	{
		if (TF_Tyre_RBReceiptLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBReceiptLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBReceiptLine_ID, Integer.valueOf(TF_Tyre_RBReceiptLine_ID));
	}

	/** Get Received Rebutton Tyre.
		@return Received Rebutton Tyre	  */
	public int getTF_Tyre_RBReceiptLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_RBReceiptLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Tyre_RBReceiptLine_UU.
		@param TF_Tyre_RBReceiptLine_UU TF_Tyre_RBReceiptLine_UU	  */
	public void setTF_Tyre_RBReceiptLine_UU (String TF_Tyre_RBReceiptLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBReceiptLine_UU, TF_Tyre_RBReceiptLine_UU);
	}

	/** Get TF_Tyre_RBReceiptLine_UU.
		@return TF_Tyre_RBReceiptLine_UU	  */
	public String getTF_Tyre_RBReceiptLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Tyre_RBReceiptLine_UU);
	}

	public I_TF_TyreType getTF_TyreType() throws RuntimeException
    {
		return (I_TF_TyreType)MTable.get(getCtx(), I_TF_TyreType.Table_Name)
			.getPO(getTF_TyreType_ID(), get_TrxName());	}

	/** Set Tyre Type.
		@param TF_TyreType_ID Tyre Type	  */
	public void setTF_TyreType_ID (int TF_TyreType_ID)
	{
		if (TF_TyreType_ID < 1) 
			set_Value (COLUMNNAME_TF_TyreType_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TyreType_ID, Integer.valueOf(TF_TyreType_ID));
	}

	/** Get Tyre Type.
		@return Tyre Type	  */
	public int getTF_TyreType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}