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

/** Generated Model for TF_ShareholderType
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_ShareholderType extends PO implements I_TF_ShareholderType, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171211L;

    /** Standard Constructor */
    public X_TF_ShareholderType (Properties ctx, int TF_ShareholderType_ID, String trxName)
    {
      super (ctx, TF_ShareholderType_ID, trxName);
      /** if (TF_ShareholderType_ID == 0)
        {
			setName (null);
			setTF_ShareholderType_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_TF_ShareholderType (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_ShareholderType[")
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

	/** Set Shareholder Type.
		@param TF_ShareholderType_ID Shareholder Type	  */
	public void setTF_ShareholderType_ID (int TF_ShareholderType_ID)
	{
		if (TF_ShareholderType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_ShareholderType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_ShareholderType_ID, Integer.valueOf(TF_ShareholderType_ID));
	}

	/** Get Shareholder Type.
		@return Shareholder Type	  */
	public int getTF_ShareholderType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ShareholderType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_ShareholderType_UU.
		@param TF_ShareholderType_UU TF_ShareholderType_UU	  */
	public void setTF_ShareholderType_UU (String TF_ShareholderType_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_ShareholderType_UU, TF_ShareholderType_UU);
	}

	/** Get TF_ShareholderType_UU.
		@return TF_ShareholderType_UU	  */
	public String getTF_ShareholderType_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_ShareholderType_UU);
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