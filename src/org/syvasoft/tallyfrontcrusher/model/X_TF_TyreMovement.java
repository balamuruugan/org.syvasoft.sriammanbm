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

/** Generated Model for TF_TyreMovement
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_TyreMovement extends PO implements I_TF_TyreMovement, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190218L;

    /** Standard Constructor */
    public X_TF_TyreMovement (Properties ctx, int TF_TyreMovement_ID, String trxName)
    {
      super (ctx, TF_TyreMovement_ID, trxName);
      /** if (TF_TyreMovement_ID == 0)
        {
			setMovementDate (new Timestamp( System.currentTimeMillis() ));
			setTF_Tyre_ID (0);
			setTF_TyreMovement_ID (0);
			setTF_TyrePosition_ID (0);
			setTF_TyreType_ID (0);
			setVehicle_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TyreMovement (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TyreMovement[")
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

	/** Set Removing KM.
		@param End_Meter Removing KM	  */
	public void setEnd_Meter (BigDecimal End_Meter)
	{
		set_Value (COLUMNNAME_End_Meter, End_Meter);
	}

	/** Get Removing KM.
		@return Removing KM	  */
	public BigDecimal getEnd_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_End_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set End Date.
		@param EndDate 
		Last effective date (inclusive)
	  */
	public void setEndDate (Timestamp EndDate)
	{
		set_Value (COLUMNNAME_EndDate, EndDate);
	}

	/** Get End Date.
		@return Last effective date (inclusive)
	  */
	public Timestamp getEndDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndDate);
	}

	/** Set Movement Date.
		@param MovementDate 
		Date a product was moved in or out of inventory
	  */
	public void setMovementDate (Timestamp MovementDate)
	{
		set_Value (COLUMNNAME_MovementDate, MovementDate);
	}

	/** Get Movement Date.
		@return Date a product was moved in or out of inventory
	  */
	public Timestamp getMovementDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_MovementDate);
	}

	/** Set Running Meter.
		@param Running_Meter Running Meter	  */
	public void setRunning_Meter (BigDecimal Running_Meter)
	{
		set_Value (COLUMNNAME_Running_Meter, Running_Meter);
	}

	/** Get Running Meter.
		@return Running Meter	  */
	public BigDecimal getRunning_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Running_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Fitting KM.
		@param Start_Meter Fitting KM	  */
	public void setStart_Meter (BigDecimal Start_Meter)
	{
		set_Value (COLUMNNAME_Start_Meter, Start_Meter);
	}

	/** Get Fitting KM.
		@return Fitting KM	  */
	public BigDecimal getStart_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Start_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_Tyre getTF_Tyre() throws RuntimeException
    {
		return (I_TF_Tyre)MTable.get(getCtx(), I_TF_Tyre.Table_Name)
			.getPO(getTF_Tyre_ID(), get_TrxName());	}

	/** Set Tyre.
		@param TF_Tyre_ID Tyre	  */
	public void setTF_Tyre_ID (int TF_Tyre_ID)
	{
		if (TF_Tyre_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_ID, Integer.valueOf(TF_Tyre_ID));
	}

	/** Get Tyre.
		@return Tyre	  */
	public int getTF_Tyre_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tyre Movement.
		@param TF_TyreMovement_ID Tyre Movement	  */
	public void setTF_TyreMovement_ID (int TF_TyreMovement_ID)
	{
		if (TF_TyreMovement_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreMovement_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreMovement_ID, Integer.valueOf(TF_TyreMovement_ID));
	}

	/** Get Tyre Movement.
		@return Tyre Movement	  */
	public int getTF_TyreMovement_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreMovement_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TyreMovement_UU.
		@param TF_TyreMovement_UU TF_TyreMovement_UU	  */
	public void setTF_TyreMovement_UU (String TF_TyreMovement_UU)
	{
		set_Value (COLUMNNAME_TF_TyreMovement_UU, TF_TyreMovement_UU);
	}

	/** Get TF_TyreMovement_UU.
		@return TF_TyreMovement_UU	  */
	public String getTF_TyreMovement_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TyreMovement_UU);
	}

	public I_TF_TyrePosition getTF_TyrePosition() throws RuntimeException
    {
		return (I_TF_TyrePosition)MTable.get(getCtx(), I_TF_TyrePosition.Table_Name)
			.getPO(getTF_TyrePosition_ID(), get_TrxName());	}

	/** Set Tyre Position.
		@param TF_TyrePosition_ID Tyre Position	  */
	public void setTF_TyrePosition_ID (int TF_TyrePosition_ID)
	{
		if (TF_TyrePosition_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyrePosition_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyrePosition_ID, Integer.valueOf(TF_TyrePosition_ID));
	}

	/** Get Tyre Position.
		@return Tyre Position	  */
	public int getTF_TyrePosition_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyrePosition_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyreType getTF_TyreType() throws RuntimeException
    {
		return (I_TF_TyreType)MTable.get(getCtx(), I_TF_TyreType.Table_Name)
			.getPO(getTF_TyreType_ID(), get_TrxName());	}

	/** Set Tyre Type.
		@param TF_TyreType_ID Tyre Type	  */
	public void setTF_TyreType_ID (int TF_TyreType_ID)
	{
		if (TF_TyreType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreType_ID, Integer.valueOf(TF_TyreType_ID));
	}

	/** Get Tyre Type.
		@return Tyre Type	  */
	public int getTF_TyreType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getVehicle() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getVehicle_ID(), get_TrxName());	}

	/** Set Vehicle.
		@param Vehicle_ID Vehicle	  */
	public void setVehicle_ID (int Vehicle_ID)
	{
		if (Vehicle_ID < 1) 
			set_Value (COLUMNNAME_Vehicle_ID, null);
		else 
			set_Value (COLUMNNAME_Vehicle_ID, Integer.valueOf(Vehicle_ID));
	}

	/** Get Vehicle.
		@return Vehicle	  */
	public int getVehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Vehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}