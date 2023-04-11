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

/** Generated Model for M_Product_Attribute
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_M_Product_Attribute extends PO implements I_M_Product_Attribute, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220711L;

    /** Standard Constructor */
    public X_M_Product_Attribute (Properties ctx, int M_Product_Attribute_ID, String trxName)
    {
      super (ctx, M_Product_Attribute_ID, trxName);
      /** if (M_Product_Attribute_ID == 0)
        {
			setM_Product_Attribute_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_M_Product_Attribute (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_M_Product_Attribute[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Product Attribute.
		@param M_Product_Attribute_ID Product Attribute	  */
	public void setM_Product_Attribute_ID (int M_Product_Attribute_ID)
	{
		if (M_Product_Attribute_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Product_Attribute_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Product_Attribute_ID, Integer.valueOf(M_Product_Attribute_ID));
	}

	/** Get Product Attribute.
		@return Product Attribute	  */
	public int getM_Product_Attribute_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_Attribute_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set M_Product_Attribute_UU.
		@param M_Product_Attribute_UU M_Product_Attribute_UU	  */
	public void setM_Product_Attribute_UU (String M_Product_Attribute_UU)
	{
		set_ValueNoCheck (COLUMNNAME_M_Product_Attribute_UU, M_Product_Attribute_UU);
	}

	/** Get M_Product_Attribute_UU.
		@return M_Product_Attribute_UU	  */
	public String getM_Product_Attribute_UU () 
	{
		return (String)get_Value(COLUMNNAME_M_Product_Attribute_UU);
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