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

/** Generated Model for TF_SandBlockBucket_Config
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_SandBlockBucket_Config extends PO implements I_TF_SandBlockBucket_Config, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180108L;

    /** Standard Constructor */
    public X_TF_SandBlockBucket_Config (Properties ctx, int TF_SandBlockBucket_Config_ID, String trxName)
    {
      super (ctx, TF_SandBlockBucket_Config_ID, trxName);
      /** if (TF_SandBlockBucket_Config_ID == 0)
        {
			setM_Product_ID (0);
			setSandType (null);
			setTF_SandBlockBucket_Config_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_SandBlockBucket_Config (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_SandBlockBucket_Config[")
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

	public org.compiere.model.I_M_Product getM_ProductPermitLedger() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_ProductPermitLedger_ID(), get_TrxName());	}

	/** Set Permit Ledger.
		@param M_ProductPermitLedger_ID Permit Ledger	  */
	public void setM_ProductPermitLedger_ID (int M_ProductPermitLedger_ID)
	{
		if (M_ProductPermitLedger_ID < 1) 
			set_Value (COLUMNNAME_M_ProductPermitLedger_ID, null);
		else 
			set_Value (COLUMNNAME_M_ProductPermitLedger_ID, Integer.valueOf(M_ProductPermitLedger_ID));
	}

	/** Get Permit Ledger.
		@return Permit Ledger	  */
	public int getM_ProductPermitLedger_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_ProductPermitLedger_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Permit Tonnage Per Bucket.
		@param PermitTonnagePerBucket Permit Tonnage Per Bucket	  */
	public void setPermitTonnagePerBucket (BigDecimal PermitTonnagePerBucket)
	{
		set_Value (COLUMNNAME_PermitTonnagePerBucket, PermitTonnagePerBucket);
	}

	/** Get Permit Tonnage Per Bucket.
		@return Permit Tonnage Per Bucket	  */
	public BigDecimal getPermitTonnagePerBucket () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitTonnagePerBucket);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Sales Rate Per Bucket.
		@param SalesRatePerBucket Sales Rate Per Bucket	  */
	public void setSalesRatePerBucket (BigDecimal SalesRatePerBucket)
	{
		set_Value (COLUMNNAME_SalesRatePerBucket, SalesRatePerBucket);
	}

	/** Get Sales Rate Per Bucket.
		@return Sales Rate Per Bucket	  */
	public BigDecimal getSalesRatePerBucket () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SalesRatePerBucket);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Sales Rate Per Tonne.
		@param SalesRatePerTon Sales Rate Per Tonne	  */
	public void setSalesRatePerTon (BigDecimal SalesRatePerTon)
	{
		set_Value (COLUMNNAME_SalesRatePerTon, SalesRatePerTon);
	}

	/** Get Sales Rate Per Tonne.
		@return Sales Rate Per Tonne	  */
	public BigDecimal getSalesRatePerTon () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SalesRatePerTon);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Sales Tonnage Per Bucket.
		@param SalesTonnagePerBucket Sales Tonnage Per Bucket	  */
	public void setSalesTonnagePerBucket (BigDecimal SalesTonnagePerBucket)
	{
		set_Value (COLUMNNAME_SalesTonnagePerBucket, SalesTonnagePerBucket);
	}

	/** Get Sales Tonnage Per Bucket.
		@return Sales Tonnage Per Bucket	  */
	public BigDecimal getSalesTonnagePerBucket () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SalesTonnagePerBucket);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** P = PM */
	public static final String SANDTYPE_P = "PM";
	/** X = EX */
	public static final String SANDTYPE_X = "EX";
	/** W = WP */
	public static final String SANDTYPE_W = "WP";
	/** Set Sand Type.
		@param SandType Sand Type	  */
	public void setSandType (String SandType)
	{

		set_Value (COLUMNNAME_SandType, SandType);
	}

	/** Get Sand Type.
		@return Sand Type	  */
	public String getSandType () 
	{
		return (String)get_Value(COLUMNNAME_SandType);
	}

	/** Set Sand Block Bucket Configuration.
		@param TF_SandBlockBucket_Config_ID Sand Block Bucket Configuration	  */
	public void setTF_SandBlockBucket_Config_ID (int TF_SandBlockBucket_Config_ID)
	{
		if (TF_SandBlockBucket_Config_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_SandBlockBucket_Config_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_SandBlockBucket_Config_ID, Integer.valueOf(TF_SandBlockBucket_Config_ID));
	}

	/** Get Sand Block Bucket Configuration.
		@return Sand Block Bucket Configuration	  */
	public int getTF_SandBlockBucket_Config_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_SandBlockBucket_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_SandBlockBucket_Config_UU.
		@param TF_SandBlockBucket_Config_UU TF_SandBlockBucket_Config_UU	  */
	public void setTF_SandBlockBucket_Config_UU (String TF_SandBlockBucket_Config_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_SandBlockBucket_Config_UU, TF_SandBlockBucket_Config_UU);
	}

	/** Get TF_SandBlockBucket_Config_UU.
		@return TF_SandBlockBucket_Config_UU	  */
	public String getTF_SandBlockBucket_Config_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_SandBlockBucket_Config_UU);
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
}