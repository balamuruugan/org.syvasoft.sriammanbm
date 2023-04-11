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

/** Generated Model for PM_Meter
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_PM_Meter extends PO implements I_PM_Meter, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200612L;

    /** Standard Constructor */
    public X_PM_Meter (Properties ctx, int PM_Meter_ID, String trxName)
    {
      super (ctx, PM_Meter_ID, trxName);
      /** if (PM_Meter_ID == 0)
        {
			setC_UOM_ID (0);
			setPM_Machinery_ID (0);
			setPM_Meter_ID (0);
        } */
    }

    /** Load Constructor */
    public X_PM_Meter (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_PM_Meter[")
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

	/** Set Current Meter.
		@param CurrentMeter Current Meter	  */
	public void setCurrentMeter (BigDecimal CurrentMeter)
	{
		set_Value (COLUMNNAME_CurrentMeter, CurrentMeter);
	}

	/** Get Current Meter.
		@return Current Meter	  */
	public BigDecimal getCurrentMeter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CurrentMeter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_PM_Machinery getPM_Machinery() throws RuntimeException
    {
		return (I_PM_Machinery)MTable.get(getCtx(), I_PM_Machinery.Table_Name)
			.getPO(getPM_Machinery_ID(), get_TrxName());	}

	/** Set Machinery.
		@param PM_Machinery_ID Machinery	  */
	public void setPM_Machinery_ID (int PM_Machinery_ID)
	{
		if (PM_Machinery_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PM_Machinery_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PM_Machinery_ID, Integer.valueOf(PM_Machinery_ID));
	}

	/** Get Machinery.
		@return Machinery	  */
	public int getPM_Machinery_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_Machinery_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Machinery Meter.
		@param PM_Meter_ID Machinery Meter	  */
	public void setPM_Meter_ID (int PM_Meter_ID)
	{
		if (PM_Meter_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PM_Meter_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PM_Meter_ID, Integer.valueOf(PM_Meter_ID));
	}

	/** Get Machinery Meter.
		@return Machinery Meter	  */
	public int getPM_Meter_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_Meter_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PM_Meter_UU.
		@param PM_Meter_UU PM_Meter_UU	  */
	public void setPM_Meter_UU (String PM_Meter_UU)
	{
		set_ValueNoCheck (COLUMNNAME_PM_Meter_UU, PM_Meter_UU);
	}

	/** Get PM_Meter_UU.
		@return PM_Meter_UU	  */
	public String getPM_Meter_UU () 
	{
		return (String)get_Value(COLUMNNAME_PM_Meter_UU);
	}
}