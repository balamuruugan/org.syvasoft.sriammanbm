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

/** Generated Model for TF_CrusherKatingConfig
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_CrusherKatingConfig extends PO implements I_TF_CrusherKatingConfig, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180520L;

    /** Standard Constructor */
    public X_TF_CrusherKatingConfig (Properties ctx, int TF_CrusherKatingConfig_ID, String trxName)
    {
      super (ctx, TF_CrusherKatingConfig_ID, trxName);
      /** if (TF_CrusherKatingConfig_ID == 0)
        {
			setKatingEntryType (null);
// T
			setTF_CrusherKatingConfig_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_CrusherKatingConfig (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_CrusherKatingConfig[")
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

	/** Tonnage = T */
	public static final String KATINGENTRYTYPE_Tonnage = "T";
	/** Load = L */
	public static final String KATINGENTRYTYPE_Load = "L";
	/** Set Kating Type.
		@param KatingEntryType Kating Type	  */
	public void setKatingEntryType (String KatingEntryType)
	{

		set_Value (COLUMNNAME_KatingEntryType, KatingEntryType);
	}

	/** Get Kating Type.
		@return Kating Type	  */
	public String getKatingEntryType () 
	{
		return (String)get_Value(COLUMNNAME_KatingEntryType);
	}

	public I_TF_RentedVehicle getLoaderVehicle() throws RuntimeException
    {
		return (I_TF_RentedVehicle)MTable.get(getCtx(), I_TF_RentedVehicle.Table_Name)
			.getPO(getLoaderVehicle_ID(), get_TrxName());	}

	/** Set Loader.
		@param LoaderVehicle_ID Loader	  */
	public void setLoaderVehicle_ID (int LoaderVehicle_ID)
	{
		if (LoaderVehicle_ID < 1) 
			set_Value (COLUMNNAME_LoaderVehicle_ID, null);
		else 
			set_Value (COLUMNNAME_LoaderVehicle_ID, Integer.valueOf(LoaderVehicle_ID));
	}

	/** Get Loader.
		@return Loader	  */
	public int getLoaderVehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LoaderVehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Loading Price.
		@param Loading_Price Loading Price	  */
	public void setLoading_Price (BigDecimal Loading_Price)
	{
		set_Value (COLUMNNAME_Loading_Price, Loading_Price);
	}

	/** Get Loading Price.
		@return Loading Price	  */
	public BigDecimal getLoading_Price () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Loading_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Crusher Kating Entry Configuration.
		@param TF_CrusherKatingConfig_ID Crusher Kating Entry Configuration	  */
	public void setTF_CrusherKatingConfig_ID (int TF_CrusherKatingConfig_ID)
	{
		if (TF_CrusherKatingConfig_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherKatingConfig_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherKatingConfig_ID, Integer.valueOf(TF_CrusherKatingConfig_ID));
	}

	/** Get Crusher Kating Entry Configuration.
		@return Crusher Kating Entry Configuration	  */
	public int getTF_CrusherKatingConfig_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CrusherKatingConfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_CrusherKatingConfig_UU.
		@param TF_CrusherKatingConfig_UU TF_CrusherKatingConfig_UU	  */
	public void setTF_CrusherKatingConfig_UU (String TF_CrusherKatingConfig_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_CrusherKatingConfig_UU, TF_CrusherKatingConfig_UU);
	}

	/** Get TF_CrusherKatingConfig_UU.
		@return TF_CrusherKatingConfig_UU	  */
	public String getTF_CrusherKatingConfig_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_CrusherKatingConfig_UU);
	}

	/** Set Transport Price.
		@param Transport_Price Transport Price	  */
	public void setTransport_Price (BigDecimal Transport_Price)
	{
		set_Value (COLUMNNAME_Transport_Price, Transport_Price);
	}

	/** Get Transport Price.
		@return Transport Price	  */
	public BigDecimal getTransport_Price () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Transport_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}