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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for TF_Quarry_Rent_Config
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_Quarry_Rent_Config extends PO implements I_TF_Quarry_Rent_Config, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20170124L;

    /** Standard Constructor */
    public X_TF_Quarry_Rent_Config (Properties ctx, int TF_Quarry_Rent_Config_ID, String trxName)
    {
      super (ctx, TF_Quarry_Rent_Config_ID, trxName);
      /** if (TF_Quarry_Rent_Config_ID == 0)
        {
			setTF_Quarry_ID (0);
			setTF_Quarry_Rent_Config_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Quarry_Rent_Config (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Quarry_Rent_Config[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Standard Days.
		@param Std_Days Standard Days	  */
	public void setStd_Days (BigDecimal Std_Days)
	{
		set_Value (COLUMNNAME_Std_Days, Std_Days);
	}

	/** Get Standard Days.
		@return Standard Days	  */
	public BigDecimal getStd_Days () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Std_Days);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Standard Rent.
		@param Std_Rent Standard Rent	  */
	public void setStd_Rent (BigDecimal Std_Rent)
	{
		set_Value (COLUMNNAME_Std_Rent, Std_Rent);
	}

	/** Get Standard Rent.
		@return Standard Rent	  */
	public BigDecimal getStd_Rent () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Std_Rent);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_Quarry getTF_Quarry() throws RuntimeException
    {
		return (I_TF_Quarry)MTable.get(getCtx(), I_TF_Quarry.Table_Name)
			.getPO(getTF_Quarry_ID(), get_TrxName());	}

	/** Set Quarry.
		@param TF_Quarry_ID Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID)
	{
		if (TF_Quarry_ID < 1) 
			set_Value (COLUMNNAME_TF_Quarry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Quarry_ID, Integer.valueOf(TF_Quarry_ID));
	}

	/** Get Quarry.
		@return Quarry	  */
	public int getTF_Quarry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Quarry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Quarry Rent Configuration.
		@param TF_Quarry_Rent_Config_ID Quarry Rent Configuration	  */
	public void setTF_Quarry_Rent_Config_ID (int TF_Quarry_Rent_Config_ID)
	{
		if (TF_Quarry_Rent_Config_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Quarry_Rent_Config_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Quarry_Rent_Config_ID, Integer.valueOf(TF_Quarry_Rent_Config_ID));
	}

	/** Get Quarry Rent Configuration.
		@return Quarry Rent Configuration	  */
	public int getTF_Quarry_Rent_Config_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Quarry_Rent_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Quarry_Rent_Config_UU.
		@param TF_Quarry_Rent_Config_UU TF_Quarry_Rent_Config_UU	  */
	public void setTF_Quarry_Rent_Config_UU (String TF_Quarry_Rent_Config_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Quarry_Rent_Config_UU, TF_Quarry_Rent_Config_UU);
	}

	/** Get TF_Quarry_Rent_Config_UU.
		@return TF_Quarry_Rent_Config_UU	  */
	public String getTF_Quarry_Rent_Config_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Quarry_Rent_Config_UU);
	}

	/** Set Valid from.
		@param ValidFrom 
		Valid from including this date (first day)
	  */
	public void setValidFrom (Timestamp ValidFrom)
	{
		set_Value (COLUMNNAME_ValidFrom, ValidFrom);
	}

	/** Get Valid from.
		@return Valid from including this date (first day)
	  */
	public Timestamp getValidFrom () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidFrom);
	}

	/** Set Valid to.
		@param ValidTo 
		Valid to including this date (last day)
	  */
	public void setValidTo (Timestamp ValidTo)
	{
		set_Value (COLUMNNAME_ValidTo, ValidTo);
	}

	/** Get Valid to.
		@return Valid to including this date (last day)
	  */
	public Timestamp getValidTo () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidTo);
	}
}