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

/** Generated Model for TF_Labour_Wage_Config
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_Labour_Wage_Config extends PO implements I_TF_Labour_Wage_Config, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20170301L;

    /** Standard Constructor */
    public X_TF_Labour_Wage_Config (Properties ctx, int TF_Labour_Wage_Config_ID, String trxName)
    {
      super (ctx, TF_Labour_Wage_Config_ID, trxName);
      /** if (TF_Labour_Wage_Config_ID == 0)
        {
			setTF_Labour_Wage_Config_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Labour_Wage_Config (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Labour_Wage_Config[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Standard Wage.
		@param Std_Wage Standard Wage	  */
	public void setStd_Wage (BigDecimal Std_Wage)
	{
		set_Value (COLUMNNAME_Std_Wage, Std_Wage);
	}

	/** Get Standard Wage.
		@return Standard Wage	  */
	public BigDecimal getStd_Wage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Std_Wage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Labour Wage Configuration.
		@param TF_Labour_Wage_Config_ID Labour Wage Configuration	  */
	public void setTF_Labour_Wage_Config_ID (int TF_Labour_Wage_Config_ID)
	{
		if (TF_Labour_Wage_Config_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Labour_Wage_Config_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Labour_Wage_Config_ID, Integer.valueOf(TF_Labour_Wage_Config_ID));
	}

	/** Get Labour Wage Configuration.
		@return Labour Wage Configuration	  */
	public int getTF_Labour_Wage_Config_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Labour_Wage_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Labour_Wage_Config_UU.
		@param TF_Labour_Wage_Config_UU TF_Labour_Wage_Config_UU	  */
	public void setTF_Labour_Wage_Config_UU (String TF_Labour_Wage_Config_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Labour_Wage_Config_UU, TF_Labour_Wage_Config_UU);
	}

	/** Get TF_Labour_Wage_Config_UU.
		@return TF_Labour_Wage_Config_UU	  */
	public String getTF_Labour_Wage_Config_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Labour_Wage_Config_UU);
	}

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException
    {
		return (I_TF_VehicleType)MTable.get(getCtx(), I_TF_VehicleType.Table_Name)
			.getPO(getTF_VehicleType_ID(), get_TrxName());	}

	/** Set Vehicle Type.
		@param TF_VehicleType_ID Vehicle Type	  */
	public void setTF_VehicleType_ID (int TF_VehicleType_ID)
	{
		if (TF_VehicleType_ID < 1) 
			set_Value (COLUMNNAME_TF_VehicleType_ID, null);
		else 
			set_Value (COLUMNNAME_TF_VehicleType_ID, Integer.valueOf(TF_VehicleType_ID));
	}

	/** Get Vehicle Type.
		@return Vehicle Type	  */
	public int getTF_VehicleType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_VehicleType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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