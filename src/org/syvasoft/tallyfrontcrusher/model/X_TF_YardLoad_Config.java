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

/** Generated Model for TF_YardLoad_Config
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_YardLoad_Config extends PO implements I_TF_YardLoad_Config, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180207L;

    /** Standard Constructor */
    public X_TF_YardLoad_Config (Properties ctx, int TF_YardLoad_Config_ID, String trxName)
    {
      super (ctx, TF_YardLoad_Config_ID, trxName);
      /** if (TF_YardLoad_Config_ID == 0)
        {
			setTF_VehicleType_ID (0);
			setTF_YardLoad_Config_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_YardLoad_Config (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_YardLoad_Config[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Bucket / Load.
		@param BucketPerLoad Bucket / Load	  */
	public void setBucketPerLoad (BigDecimal BucketPerLoad)
	{
		set_Value (COLUMNNAME_BucketPerLoad, BucketPerLoad);
	}

	/** Get Bucket / Load.
		@return Bucket / Load	  */
	public BigDecimal getBucketPerLoad () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BucketPerLoad);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tonnage / Load.
		@param SalesTonnagePerLoad Tonnage / Load	  */
	public void setSalesTonnagePerLoad (BigDecimal SalesTonnagePerLoad)
	{
		set_Value (COLUMNNAME_SalesTonnagePerLoad, SalesTonnagePerLoad);
	}

	/** Get Tonnage / Load.
		@return Tonnage / Load	  */
	public BigDecimal getSalesTonnagePerLoad () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SalesTonnagePerLoad);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Yard Load Configuration.
		@param TF_YardLoad_Config_ID Yard Load Configuration	  */
	public void setTF_YardLoad_Config_ID (int TF_YardLoad_Config_ID)
	{
		if (TF_YardLoad_Config_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_YardLoad_Config_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_YardLoad_Config_ID, Integer.valueOf(TF_YardLoad_Config_ID));
	}

	/** Get Yard Load Configuration.
		@return Yard Load Configuration	  */
	public int getTF_YardLoad_Config_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_YardLoad_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_YardLoad_Config_UU.
		@param TF_YardLoad_Config_UU TF_YardLoad_Config_UU	  */
	public void setTF_YardLoad_Config_UU (String TF_YardLoad_Config_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_YardLoad_Config_UU, TF_YardLoad_Config_UU);
	}

	/** Get TF_YardLoad_Config_UU.
		@return TF_YardLoad_Config_UU	  */
	public String getTF_YardLoad_Config_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_YardLoad_Config_UU);
	}
}