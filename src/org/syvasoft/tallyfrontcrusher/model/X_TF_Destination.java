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
import org.compiere.util.KeyNamePair;

/** Generated Model for TF_Destination
 *  @author iDempiere (generated) 
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="TF_Destination")
public class X_TF_Destination extends PO implements I_TF_Destination, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231226L;

    /** Standard Constructor */
    public X_TF_Destination (Properties ctx, int TF_Destination_ID, String trxName)
    {
      super (ctx, TF_Destination_ID, trxName);
      /** if (TF_Destination_ID == 0)
        {
			setDistance (Env.ZERO);
			setName (null);
			setTF_Destination_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_Destination (Properties ctx, int TF_Destination_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_Destination_ID, trxName, virtualColumns);
      /** if (TF_Destination_ID == 0)
        {
			setDistance (Env.ZERO);
			setName (null);
			setTF_Destination_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Destination (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_TF_Destination[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
	{
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_ID)
			.getPO(getC_Project_ID(), get_TrxName());
	}

	/** Set Subcontract / Project.
		@param C_Project_ID Financial Project
	*/
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Subcontract / Project.
		@return Financial Project
	  */
	public int getC_Project_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Distance (km).
		@param Distance Distance (km)
	*/
	public void setDistance (BigDecimal Distance)
	{
		set_Value (COLUMNNAME_Distance, Distance);
	}

	/** Get Distance (km).
		@return Distance (km)	  */
	public BigDecimal getDistance()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Distance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Latitude.
		@param Latitude Latitude
	*/
	public void setLatitude (String Latitude)
	{
		set_Value (COLUMNNAME_Latitude, Latitude);
	}

	/** Get Latitude.
		@return Latitude	  */
	public String getLatitude()
	{
		return (String)get_Value(COLUMNNAME_Latitude);
	}

	/** Set Longitude.
		@param Longitude Longitude
	*/
	public void setLongitude (String Longitude)
	{
		set_Value (COLUMNNAME_Longitude, Longitude);
	}

	/** Get Longitude.
		@return Longitude	  */
	public String getLongitude()
	{
		return (String)get_Value(COLUMNNAME_Longitude);
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Rate.
		@param Rate Rate or Tax or Exchange
	*/
	public void setRate (BigDecimal Rate)
	{
		set_Value (COLUMNNAME_Rate, Rate);
	}

	/** Get Rate.
		@return Rate or Tax or Exchange
	  */
	public BigDecimal getRate()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Destination.
		@param TF_Destination_ID Destination
	*/
	public void setTF_Destination_ID (int TF_Destination_ID)
	{
		if (TF_Destination_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_Destination_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_Destination_ID, Integer.valueOf(TF_Destination_ID));
	}

	/** Get Destination.
		@return Destination	  */
	public int getTF_Destination_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Destination_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Destination_UU.
		@param TF_Destination_UU TF_Destination_UU
	*/
	public void setTF_Destination_UU (String TF_Destination_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Destination_UU, TF_Destination_UU);
	}

	/** Get TF_Destination_UU.
		@return TF_Destination_UU	  */
	public String getTF_Destination_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_Destination_UU);
	}

	public I_TF_ProductionPlant getTF_ProductionPlant() throws RuntimeException
	{
		return (I_TF_ProductionPlant)MTable.get(getCtx(), I_TF_ProductionPlant.Table_ID)
			.getPO(getTF_ProductionPlant_ID(), get_TrxName());
	}

	/** Set Production Plant.
		@param TF_ProductionPlant_ID Production Plant
	*/
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID)
	{
		if (TF_ProductionPlant_ID < 1)
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, null);
		else
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, Integer.valueOf(TF_ProductionPlant_ID));
	}

	/** Get Production Plant.
		@return Production Plant	  */
	public int getTF_ProductionPlant_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ProductionPlant_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Production = P */
	public static final String TF_SEND_TO_Production = "P";
	/** Stock = S */
	public static final String TF_SEND_TO_Stock = "S";
	/** Subcontract Production = T */
	public static final String TF_SEND_TO_SubcontractProduction = "T";
	/** Set Send To.
		@param TF_Send_To Send To
	*/
	public void setTF_Send_To (String TF_Send_To)
	{

		set_Value (COLUMNNAME_TF_Send_To, TF_Send_To);
	}

	/** Get Send To.
		@return Send To	  */
	public String getTF_Send_To()
	{
		return (String)get_Value(COLUMNNAME_TF_Send_To);
	}
}