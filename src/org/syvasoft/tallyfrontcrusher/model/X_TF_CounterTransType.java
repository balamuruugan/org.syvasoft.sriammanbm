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

/** Generated Model for TF_CounterTransType
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_CounterTransType extends PO implements I_TF_CounterTransType, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20191213L;

    /** Standard Constructor */
    public X_TF_CounterTransType (Properties ctx, int TF_CounterTransType_ID, String trxName)
    {
      super (ctx, TF_CounterTransType_ID, trxName);
      /** if (TF_CounterTransType_ID == 0)
        {
			setDescription (null);
			setName (null);
			setTF_CounterTransType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_CounterTransType (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_CounterTransType[")
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

	/** Set Counter Transaction Type.
		@param TF_CounterTransType_ID Counter Transaction Type	  */
	public void setTF_CounterTransType_ID (int TF_CounterTransType_ID)
	{
		if (TF_CounterTransType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CounterTransType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CounterTransType_ID, Integer.valueOf(TF_CounterTransType_ID));
	}

	/** Get Counter Transaction Type.
		@return Counter Transaction Type	  */
	public int getTF_CounterTransType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CounterTransType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_CounterTransType_UU.
		@param TF_CounterTransType_UU TF_CounterTransType_UU	  */
	public void setTF_CounterTransType_UU (String TF_CounterTransType_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_CounterTransType_UU, TF_CounterTransType_UU);
	}

	/** Get TF_CounterTransType_UU.
		@return TF_CounterTransType_UU	  */
	public String getTF_CounterTransType_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_CounterTransType_UU);
	}
}