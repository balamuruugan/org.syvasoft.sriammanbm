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

/** Generated Model for TF_TyrePurchaseLine
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_TyrePurchaseLine extends PO implements I_TF_TyrePurchaseLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190411L;

    /** Standard Constructor */
    public X_TF_TyrePurchaseLine (Properties ctx, int TF_TyrePurchaseLine_ID, String trxName)
    {
      super (ctx, TF_TyrePurchaseLine_ID, trxName);
      /** if (TF_TyrePurchaseLine_ID == 0)
        {
			setBrand (null);
			setPrice (Env.ZERO);
			setSize (null);
			setTF_TyrePurchase_ID (0);
			setTF_TyrePurchaseLine_ID (0);
			setTF_TyreType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TyrePurchaseLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TyrePurchaseLine[")
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

	/** Set Line.
		@param LineNo 
		Line No
	  */
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
		@return Line No
	  */
	public int getLineNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
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

	public I_TF_TyrePurchase getTF_TyrePurchase() throws RuntimeException
    {
		return (I_TF_TyrePurchase)MTable.get(getCtx(), I_TF_TyrePurchase.Table_Name)
			.getPO(getTF_TyrePurchase_ID(), get_TrxName());	}

	/** Set Tyre Purchase.
		@param TF_TyrePurchase_ID Tyre Purchase	  */
	public void setTF_TyrePurchase_ID (int TF_TyrePurchase_ID)
	{
		if (TF_TyrePurchase_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyrePurchase_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyrePurchase_ID, Integer.valueOf(TF_TyrePurchase_ID));
	}

	/** Get Tyre Purchase.
		@return Tyre Purchase	  */
	public int getTF_TyrePurchase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyrePurchase_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tyre Purchase Line.
		@param TF_TyrePurchaseLine_ID Tyre Purchase Line	  */
	public void setTF_TyrePurchaseLine_ID (int TF_TyrePurchaseLine_ID)
	{
		if (TF_TyrePurchaseLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyrePurchaseLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyrePurchaseLine_ID, Integer.valueOf(TF_TyrePurchaseLine_ID));
	}

	/** Get Tyre Purchase Line.
		@return Tyre Purchase Line	  */
	public int getTF_TyrePurchaseLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyrePurchaseLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TyrePurchaseLine_UU.
		@param TF_TyrePurchaseLine_UU TF_TyrePurchaseLine_UU	  */
	public void setTF_TyrePurchaseLine_UU (String TF_TyrePurchaseLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TyrePurchaseLine_UU, TF_TyrePurchaseLine_UU);
	}

	/** Get TF_TyrePurchaseLine_UU.
		@return TF_TyrePurchaseLine_UU	  */
	public String getTF_TyrePurchaseLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TyrePurchaseLine_UU);
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

	/** Set Tyre No.
		@param TyreNo Tyre No	  */
	public void setTyreNo (String TyreNo)
	{
		set_Value (COLUMNNAME_TyreNo, TyreNo);
	}

	/** Get Tyre No.
		@return Tyre No	  */
	public String getTyreNo () 
	{
		return (String)get_Value(COLUMNNAME_TyreNo);
	}
}