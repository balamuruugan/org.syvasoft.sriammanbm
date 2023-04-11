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

/** Generated Model for TF_PermitPurchaseLine
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_PermitPurchaseLine extends PO implements I_TF_PermitPurchaseLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180401L;

    /** Standard Constructor */
    public X_TF_PermitPurchaseLine (Properties ctx, int TF_PermitPurchaseLine_ID, String trxName)
    {
      super (ctx, TF_PermitPurchaseLine_ID, trxName);
      /** if (TF_PermitPurchaseLine_ID == 0)
        {
			setM_Product_ID (0);
			setTF_PermitPurchase_ID (0);
			setTF_PermitPurchaseLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_PermitPurchaseLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_PermitPurchaseLine[")
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

	/** Set Permit Quantity (Tonne).
		@param PermitQty Permit Quantity (Tonne)	  */
	public void setPermitQty (BigDecimal PermitQty)
	{
		set_Value (COLUMNNAME_PermitQty, PermitQty);
	}

	/** Get Permit Quantity (Tonne).
		@return Permit Quantity (Tonne)	  */
	public BigDecimal getPermitQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_PermitPurchase getTF_PermitPurchase() throws RuntimeException
    {
		return (I_TF_PermitPurchase)MTable.get(getCtx(), I_TF_PermitPurchase.Table_Name)
			.getPO(getTF_PermitPurchase_ID(), get_TrxName());	}

	/** Set Permit Purchase Entry.
		@param TF_PermitPurchase_ID Permit Purchase Entry	  */
	public void setTF_PermitPurchase_ID (int TF_PermitPurchase_ID)
	{
		if (TF_PermitPurchase_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_PermitPurchase_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_PermitPurchase_ID, Integer.valueOf(TF_PermitPurchase_ID));
	}

	/** Get Permit Purchase Entry.
		@return Permit Purchase Entry	  */
	public int getTF_PermitPurchase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_PermitPurchase_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Permit Purchase Line.
		@param TF_PermitPurchaseLine_ID Permit Purchase Line	  */
	public void setTF_PermitPurchaseLine_ID (int TF_PermitPurchaseLine_ID)
	{
		if (TF_PermitPurchaseLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_PermitPurchaseLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_PermitPurchaseLine_ID, Integer.valueOf(TF_PermitPurchaseLine_ID));
	}

	/** Get Permit Purchase Line.
		@return Permit Purchase Line	  */
	public int getTF_PermitPurchaseLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_PermitPurchaseLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_PermitPurchaseLine_UU.
		@param TF_PermitPurchaseLine_UU TF_PermitPurchaseLine_UU	  */
	public void setTF_PermitPurchaseLine_UU (String TF_PermitPurchaseLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_PermitPurchaseLine_UU, TF_PermitPurchaseLine_UU);
	}

	/** Get TF_PermitPurchaseLine_UU.
		@return TF_PermitPurchaseLine_UU	  */
	public String getTF_PermitPurchaseLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_PermitPurchaseLine_UU);
	}
}