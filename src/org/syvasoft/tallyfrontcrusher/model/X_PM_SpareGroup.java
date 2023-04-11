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

/** Generated Model for PM_SpareGroup
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_PM_SpareGroup extends PO implements I_PM_SpareGroup, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20201210L;

    /** Standard Constructor */
    public X_PM_SpareGroup (Properties ctx, int PM_SpareGroup_ID, String trxName)
    {
      super (ctx, PM_SpareGroup_ID, trxName);
      /** if (PM_SpareGroup_ID == 0)
        {
			setName (null);
			setPM_SpareGroup_ID (0);
        } */
    }

    /** Load Constructor */
    public X_PM_SpareGroup (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_PM_SpareGroup[")
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

	/** Set Spare Group.
		@param PM_SpareGroup_ID Spare Group	  */
	public void setPM_SpareGroup_ID (int PM_SpareGroup_ID)
	{
		if (PM_SpareGroup_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PM_SpareGroup_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PM_SpareGroup_ID, Integer.valueOf(PM_SpareGroup_ID));
	}

	/** Get Spare Group.
		@return Spare Group	  */
	public int getPM_SpareGroup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_SpareGroup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PM_SpareGroup_UU.
		@param PM_SpareGroup_UU PM_SpareGroup_UU	  */
	public void setPM_SpareGroup_UU (String PM_SpareGroup_UU)
	{
		set_ValueNoCheck (COLUMNNAME_PM_SpareGroup_UU, PM_SpareGroup_UU);
	}

	/** Get PM_SpareGroup_UU.
		@return PM_SpareGroup_UU	  */
	public String getPM_SpareGroup_UU () 
	{
		return (String)get_Value(COLUMNNAME_PM_SpareGroup_UU);
	}
}