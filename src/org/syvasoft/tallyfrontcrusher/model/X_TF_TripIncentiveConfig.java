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

/** Generated Model for TF_TripIncentiveConfig
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_TripIncentiveConfig extends PO implements I_TF_TripIncentiveConfig, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220418L;

    /** Standard Constructor */
    public X_TF_TripIncentiveConfig (Properties ctx, int TF_TripIncentiveConfig_ID, String trxName)
    {
      super (ctx, TF_TripIncentiveConfig_ID, trxName);
      /** if (TF_TripIncentiveConfig_ID == 0)
        {
			setIncentive (Env.ZERO);
// 0
			setTF_TripIncentiveConfig_ID (0);
			setTF_VehicleType_ID (0);
			setValidFrom (new Timestamp( System.currentTimeMillis() ));
			setWeighmentEntryType (null);
        } */
    }

    /** Load Constructor */
    public X_TF_TripIncentiveConfig (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TripIncentiveConfig[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Incentive / OT.
		@param Incentive Incentive / OT	  */
	public void setIncentive (BigDecimal Incentive)
	{
		set_Value (COLUMNNAME_Incentive, Incentive);
	}

	/** Get Incentive / OT.
		@return Incentive / OT	  */
	public BigDecimal getIncentive () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Incentive);
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

	/** Set Trip Incentive Confgig.
		@param TF_TripIncentiveConfig_ID Trip Incentive Confgig	  */
	public void setTF_TripIncentiveConfig_ID (int TF_TripIncentiveConfig_ID)
	{
		if (TF_TripIncentiveConfig_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TripIncentiveConfig_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TripIncentiveConfig_ID, Integer.valueOf(TF_TripIncentiveConfig_ID));
	}

	/** Get Trip Incentive Confgig.
		@return Trip Incentive Confgig	  */
	public int getTF_TripIncentiveConfig_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TripIncentiveConfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TripIncentiveConfig_UU.
		@param TF_TripIncentiveConfig_UU TF_TripIncentiveConfig_UU	  */
	public void setTF_TripIncentiveConfig_UU (String TF_TripIncentiveConfig_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TripIncentiveConfig_UU, TF_TripIncentiveConfig_UU);
	}

	/** Get TF_TripIncentiveConfig_UU.
		@return TF_TripIncentiveConfig_UU	  */
	public String getTF_TripIncentiveConfig_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TripIncentiveConfig_UU);
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

	/** Sales = 1SO */
	public static final String WEIGHMENTENTRYTYPE_Sales = "1SO";
	/** Input = 2PO */
	public static final String WEIGHMENTENTRYTYPE_Input = "2PO";
	/** Own Production Receipt = 3PR */
	public static final String WEIGHMENTENTRYTYPE_OwnProductionReceipt = "3PR";
	/** Subcontract Production Receipt = 4SR */
	public static final String WEIGHMENTENTRYTYPE_SubcontractProductionReceipt = "4SR";
	/** Stock to Crusher = 5KA */
	public static final String WEIGHMENTENTRYTYPE_StockToCrusher = "5KA";
	/** Other Purchase = 8OP */
	public static final String WEIGHMENTENTRYTYPE_OtherPurchase = "8OP";
	/** Crusher to Stock = 9CA */
	public static final String WEIGHMENTENTRYTYPE_CrusherToStock = "9CA";
	/** Set Type.
		@param WeighmentEntryType Type	  */
	public void setWeighmentEntryType (String WeighmentEntryType)
	{

		set_Value (COLUMNNAME_WeighmentEntryType, WeighmentEntryType);
	}

	/** Get Type.
		@return Type	  */
	public String getWeighmentEntryType () 
	{
		return (String)get_Value(COLUMNNAME_WeighmentEntryType);
	}
}