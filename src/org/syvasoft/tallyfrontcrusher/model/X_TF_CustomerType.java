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

/** Generated Model for TF_CustomerType
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_CustomerType extends PO implements I_TF_CustomerType, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200214L;

    /** Standard Constructor */
    public X_TF_CustomerType (Properties ctx, int TF_CustomerType_ID, String trxName)
    {
      super (ctx, TF_CustomerType_ID, trxName);
      /** if (TF_CustomerType_ID == 0)
        {
			setName (null);
			setTF_CustomerType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_CustomerType (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client 
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
      StringBuffer sb = new StringBuffer ("X_TF_CustomerType[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Billing Price Ratio.
		@param BillingPriceRatio Billing Price Ratio	  */
	public void setBillingPriceRatio (BigDecimal BillingPriceRatio)
	{
		set_Value (COLUMNNAME_BillingPriceRatio, BillingPriceRatio);
	}

	/** Get Billing Price Ratio.
		@return Billing Price Ratio	  */
	public BigDecimal getBillingPriceRatio () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BillingPriceRatio);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Billing Qty Ratio.
		@param BillingQtyRatio Billing Qty Ratio	  */
	public void setBillingQtyRatio (BigDecimal BillingQtyRatio)
	{
		set_Value (COLUMNNAME_BillingQtyRatio, BillingQtyRatio);
	}

	/** Get Billing Qty Ratio.
		@return Billing Qty Ratio	  */
	public BigDecimal getBillingQtyRatio () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BillingQtyRatio);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Customer Type.
		@param TF_CustomerType_ID Customer Type	  */
	public void setTF_CustomerType_ID (int TF_CustomerType_ID)
	{
		if (TF_CustomerType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CustomerType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CustomerType_ID, Integer.valueOf(TF_CustomerType_ID));
	}

	/** Get Customer Type.
		@return Customer Type	  */
	public int getTF_CustomerType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CustomerType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_CustomerType_UU.
		@param TF_CustomerType_UU TF_CustomerType_UU	  */
	public void setTF_CustomerType_UU (String TF_CustomerType_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_CustomerType_UU, TF_CustomerType_UU);
	}

	/** Get TF_CustomerType_UU.
		@return TF_CustomerType_UU	  */
	public String getTF_CustomerType_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_CustomerType_UU);
	}
}