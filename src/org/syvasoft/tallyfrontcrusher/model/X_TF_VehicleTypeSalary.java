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

/** Generated Model for TF_VehicleTypeSalary
 *  @author iDempiere (generated) 
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="TF_VehicleTypeSalary")
public class X_TF_VehicleTypeSalary extends PO implements I_TF_VehicleTypeSalary, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240117L;

    /** Standard Constructor */
    public X_TF_VehicleTypeSalary (Properties ctx, int TF_VehicleTypeSalary_ID, String trxName)
    {
      super (ctx, TF_VehicleTypeSalary_ID, trxName);
      /** if (TF_VehicleTypeSalary_ID == 0)
        {
			setDateFrom (new Timestamp( System.currentTimeMillis() ));
			setTF_VehicleTypeSalary_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_VehicleTypeSalary (Properties ctx, int TF_VehicleTypeSalary_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_VehicleTypeSalary_ID, trxName, virtualColumns);
      /** if (TF_VehicleTypeSalary_ID == 0)
        {
			setDateFrom (new Timestamp( System.currentTimeMillis() ));
			setTF_VehicleTypeSalary_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_VehicleTypeSalary (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_TF_VehicleTypeSalary[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Date From.
		@param DateFrom Starting date for a range
	*/
	public void setDateFrom (Timestamp DateFrom)
	{
		set_Value (COLUMNNAME_DateFrom, DateFrom);
	}

	/** Get Date From.
		@return Starting date for a range
	  */
	public Timestamp getDateFrom()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateFrom);
	}

	/** Set MaxKM.
		@param MaxKM MaxKM
	*/
	public void setMaxKM (int MaxKM)
	{
		set_Value (COLUMNNAME_MaxKM, Integer.valueOf(MaxKM));
	}

	/** Get MaxKM.
		@return MaxKM	  */
	public int getMaxKM()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MaxKM);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set MinKM.
		@param MinKM MinKM
	*/
	public void setMinKM (int MinKM)
	{
		set_Value (COLUMNNAME_MinKM, Integer.valueOf(MinKM));
	}

	/** Get MinKM.
		@return MinKM	  */
	public int getMinKM()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MinKM);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Wage / day.
		@param Std_Wage Wage / day
	*/
	public void setStd_Wage (BigDecimal Std_Wage)
	{
		set_Value (COLUMNNAME_Std_Wage, Std_Wage);
	}

	/** Get Wage / day.
		@return Wage / day	  */
	public BigDecimal getStd_Wage()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Std_Wage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException
	{
		return (I_TF_VehicleType)MTable.get(getCtx(), I_TF_VehicleType.Table_ID)
			.getPO(getTF_VehicleType_ID(), get_TrxName());
	}

	/** Set Vehicle Type.
		@param TF_VehicleType_ID Vehicle Type
	*/
	public void setTF_VehicleType_ID (int TF_VehicleType_ID)
	{
		if (TF_VehicleType_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_VehicleType_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_VehicleType_ID, Integer.valueOf(TF_VehicleType_ID));
	}

	/** Get Vehicle Type.
		@return Vehicle Type	  */
	public int getTF_VehicleType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_VehicleType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Line Driver Salary Configuration.
		@param TF_VehicleTypeSalary_ID Line Driver Salary Configuration
	*/
	public void setTF_VehicleTypeSalary_ID (int TF_VehicleTypeSalary_ID)
	{
		if (TF_VehicleTypeSalary_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_VehicleTypeSalary_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_VehicleTypeSalary_ID, Integer.valueOf(TF_VehicleTypeSalary_ID));
	}

	/** Get Line Driver Salary Configuration.
		@return Line Driver Salary Configuration	  */
	public int getTF_VehicleTypeSalary_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_VehicleTypeSalary_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_VehicleTypeSalary_UU.
		@param TF_VehicleTypeSalary_UU TF_VehicleTypeSalary_UU
	*/
	public void setTF_VehicleTypeSalary_UU (String TF_VehicleTypeSalary_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_VehicleTypeSalary_UU, TF_VehicleTypeSalary_UU);
	}

	/** Get TF_VehicleTypeSalary_UU.
		@return TF_VehicleTypeSalary_UU	  */
	public String getTF_VehicleTypeSalary_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_VehicleTypeSalary_UU);
	}
}