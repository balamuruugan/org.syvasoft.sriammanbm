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

/** Generated Model for PM_Period
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_PM_Period extends PO implements I_PM_Period, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200612L;

    /** Standard Constructor */
    public X_PM_Period (Properties ctx, int PM_Period_ID, String trxName)
    {
      super (ctx, PM_Period_ID, trxName);
      /** if (PM_Period_ID == 0)
        {
			setName (null);
			setPM_Period_ID (0);
        } */
    }

    /** Load Constructor */
    public X_PM_Period (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_PM_Period[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Days.
		@param Days Days	  */
	public void setDays (BigDecimal Days)
	{
		set_Value (COLUMNNAME_Days, Days);
	}

	/** Get Days.
		@return Days	  */
	public BigDecimal getDays () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Days);
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

	/** Set Maintenance Period.
		@param PM_Period_ID Maintenance Period	  */
	public void setPM_Period_ID (int PM_Period_ID)
	{
		if (PM_Period_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PM_Period_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PM_Period_ID, Integer.valueOf(PM_Period_ID));
	}

	/** Get Maintenance Period.
		@return Maintenance Period	  */
	public int getPM_Period_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_Period_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PM_Period_UU.
		@param PM_Period_UU PM_Period_UU	  */
	public void setPM_Period_UU (String PM_Period_UU)
	{
		set_ValueNoCheck (COLUMNNAME_PM_Period_UU, PM_Period_UU);
	}

	/** Get PM_Period_UU.
		@return PM_Period_UU	  */
	public String getPM_Period_UU () 
	{
		return (String)get_Value(COLUMNNAME_PM_Period_UU);
	}
}