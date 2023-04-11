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

/** Generated Model for TF_VehicleRent_TajConfig
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_VehicleRent_TajConfig extends PO implements I_TF_VehicleRent_TajConfig, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171013L;

    /** Standard Constructor */
    public X_TF_VehicleRent_TajConfig (Properties ctx, int TF_VehicleRent_TajConfig_ID, String trxName)
    {
      super (ctx, TF_VehicleRent_TajConfig_ID, trxName);
      /** if (TF_VehicleRent_TajConfig_ID == 0)
        {
			setM_Product_ID (0);
			setTF_Destination_ID (0);
			setTF_VehicleRent_TajConfig_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_VehicleRent_TajConfig (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_VehicleRent_TajConfig[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Distance (km).
		@param Distance Distance (km)	  */
	public void setDistance (BigDecimal Distance)
	{
		throw new IllegalArgumentException ("Distance is virtual column");	}

	/** Get Distance (km).
		@return Distance (km)	  */
	public BigDecimal getDistance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Distance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Rate.
		@param Rate 
		Rate or Tax or Exchange
	  */
	public void setRate (BigDecimal Rate)
	{
		set_Value (COLUMNNAME_Rate, Rate);
	}

	/** Get Rate.
		@return Rate or Tax or Exchange
	  */
	public BigDecimal getRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_Destination getTF_Destination() throws RuntimeException
    {
		return (I_TF_Destination)MTable.get(getCtx(), I_TF_Destination.Table_Name)
			.getPO(getTF_Destination_ID(), get_TrxName());	}

	/** Set Destination.
		@param TF_Destination_ID Destination	  */
	public void setTF_Destination_ID (int TF_Destination_ID)
	{
		if (TF_Destination_ID < 1) 
			set_Value (COLUMNNAME_TF_Destination_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Destination_ID, Integer.valueOf(TF_Destination_ID));
	}

	/** Get Destination.
		@return Destination	  */
	public int getTF_Destination_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Destination_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Taj Vehicle Rent Config.
		@param TF_VehicleRent_TajConfig_ID Taj Vehicle Rent Config	  */
	public void setTF_VehicleRent_TajConfig_ID (int TF_VehicleRent_TajConfig_ID)
	{
		if (TF_VehicleRent_TajConfig_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_VehicleRent_TajConfig_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_VehicleRent_TajConfig_ID, Integer.valueOf(TF_VehicleRent_TajConfig_ID));
	}

	/** Get Taj Vehicle Rent Config.
		@return Taj Vehicle Rent Config	  */
	public int getTF_VehicleRent_TajConfig_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_VehicleRent_TajConfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_VehicleRent_TajConfig_UU.
		@param TF_VehicleRent_TajConfig_UU TF_VehicleRent_TajConfig_UU	  */
	public void setTF_VehicleRent_TajConfig_UU (String TF_VehicleRent_TajConfig_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_VehicleRent_TajConfig_UU, TF_VehicleRent_TajConfig_UU);
	}

	/** Get TF_VehicleRent_TajConfig_UU.
		@return TF_VehicleRent_TajConfig_UU	  */
	public String getTF_VehicleRent_TajConfig_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_VehicleRent_TajConfig_UU);
	}
}