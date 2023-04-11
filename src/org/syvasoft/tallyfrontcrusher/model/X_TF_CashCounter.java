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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for TF_CashCounter
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_CashCounter extends PO implements I_TF_CashCounter, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20181216L;

    /** Standard Constructor */
    public X_TF_CashCounter (Properties ctx, int TF_CashCounter_ID, String trxName)
    {
      super (ctx, TF_CashCounter_ID, trxName);
      /** if (TF_CashCounter_ID == 0)
        {
			setName (null);
			setTF_CashCounter_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_TF_CashCounter (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_CashCounter[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set Default.
		@param IsDefault 
		Default value
	  */
	public void setIsDefault (boolean IsDefault)
	{
		set_Value (COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
	}

	/** Get Default.
		@return Default value
	  */
	public boolean isDefault () 
	{
		Object oo = get_Value(COLUMNNAME_IsDefault);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Cash Counter.
		@param TF_CashCounter_ID Cash Counter	  */
	public void setTF_CashCounter_ID (int TF_CashCounter_ID)
	{
		if (TF_CashCounter_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CashCounter_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CashCounter_ID, Integer.valueOf(TF_CashCounter_ID));
	}

	/** Get Cash Counter.
		@return Cash Counter	  */
	public int getTF_CashCounter_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CashCounter_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set tf_cashcounter_UU.
		@param tf_cashcounter_UU tf_cashcounter_UU	  */
	public void settf_cashcounter_UU (String tf_cashcounter_UU)
	{
		set_ValueNoCheck (COLUMNNAME_tf_cashcounter_UU, tf_cashcounter_UU);
	}

	/** Get tf_cashcounter_UU.
		@return tf_cashcounter_UU	  */
	public String gettf_cashcounter_UU () 
	{
		return (String)get_Value(COLUMNNAME_tf_cashcounter_UU);
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}