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

/** Generated Model for TF_CrusherProduction_Config
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_CrusherProduction_Config extends PO implements I_TF_CrusherProduction_Config, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190204L;

    /** Standard Constructor */
    public X_TF_CrusherProduction_Config (Properties ctx, int TF_CrusherProduction_Config_ID, String trxName)
    {
      super (ctx, TF_CrusherProduction_Config_ID, trxName);
      /** if (TF_CrusherProduction_Config_ID == 0)
        {
			setM_Product_ID (0);
			setPercent (Env.ZERO);
// 0
			setRM_Product_ID (0);
			setTF_BlueMetal_Type (null);
			setTF_CrusherProduction_Config_ID (0);
			setUnit_Divisor (Env.ZERO);
// 0
        } */
    }

    /** Load Constructor */
    public X_TF_CrusherProduction_Config (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_CrusherProduction_Config[")
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

	/** Set Percent.
		@param Percent 
		Percentage
	  */
	public void setPercent (BigDecimal Percent)
	{
		set_Value (COLUMNNAME_Percent, Percent);
	}

	/** Get Percent.
		@return Percentage
	  */
	public BigDecimal getPercent () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Percent);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Production Formula.
		@param Production_Formula Production Formula	  */
	public void setProduction_Formula (BigDecimal Production_Formula)
	{
		set_Value (COLUMNNAME_Production_Formula, Production_Formula);
	}

	/** Get Production Formula.
		@return Production Formula	  */
	public BigDecimal getProduction_Formula () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Production_Formula);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_M_Product getRM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getRM_Product_ID(), get_TrxName());	}

	/** Set Raw Material.
		@param RM_Product_ID Raw Material	  */
	public void setRM_Product_ID (int RM_Product_ID)
	{
		if (RM_Product_ID < 1) 
			set_Value (COLUMNNAME_RM_Product_ID, null);
		else 
			set_Value (COLUMNNAME_RM_Product_ID, Integer.valueOf(RM_Product_ID));
	}

	/** Get Raw Material.
		@return Raw Material	  */
	public int getRM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RM_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Regular = R */
	public static final String TF_BLUEMETAL_TYPE_Regular = "R";
	/** Mix GSB = G */
	public static final String TF_BLUEMETAL_TYPE_MixGSB = "G";
	/** Mix WMM = W */
	public static final String TF_BLUEMETAL_TYPE_MixWMM = "W";
	/** Mix GSB + 40MM = G+ */
	public static final String TF_BLUEMETAL_TYPE_MixGSBPlus40MM = "G+";
	/** Mix WMM + 40MM = W+ */
	public static final String TF_BLUEMETAL_TYPE_MixWMMPlus40MM = "W+";
	/** Set Blue Metal Type.
		@param TF_BlueMetal_Type Blue Metal Type	  */
	public void setTF_BlueMetal_Type (String TF_BlueMetal_Type)
	{

		set_Value (COLUMNNAME_TF_BlueMetal_Type, TF_BlueMetal_Type);
	}

	/** Get Blue Metal Type.
		@return Blue Metal Type	  */
	public String getTF_BlueMetal_Type () 
	{
		return (String)get_Value(COLUMNNAME_TF_BlueMetal_Type);
	}

	/** Set Crusher Production Configuration.
		@param TF_CrusherProduction_Config_ID Crusher Production Configuration	  */
	public void setTF_CrusherProduction_Config_ID (int TF_CrusherProduction_Config_ID)
	{
		if (TF_CrusherProduction_Config_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherProduction_Config_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherProduction_Config_ID, Integer.valueOf(TF_CrusherProduction_Config_ID));
	}

	/** Get Crusher Production Configuration.
		@return Crusher Production Configuration	  */
	public int getTF_CrusherProduction_Config_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CrusherProduction_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_CrusherProduction_Config_UU.
		@param TF_CrusherProduction_Config_UU TF_CrusherProduction_Config_UU	  */
	public void setTF_CrusherProduction_Config_UU (String TF_CrusherProduction_Config_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_CrusherProduction_Config_UU, TF_CrusherProduction_Config_UU);
	}

	/** Get TF_CrusherProduction_Config_UU.
		@return TF_CrusherProduction_Config_UU	  */
	public String getTF_CrusherProduction_Config_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_CrusherProduction_Config_UU);
	}

	public I_TF_ProductionPlant getTF_ProductionPlant() throws RuntimeException
    {
		return (I_TF_ProductionPlant)MTable.get(getCtx(), I_TF_ProductionPlant.Table_Name)
			.getPO(getTF_ProductionPlant_ID(), get_TrxName());	}

	/** Set TF_ProductionPlant.
		@param TF_ProductionPlant_ID TF_ProductionPlant	  */
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID)
	{
		if (TF_ProductionPlant_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_ProductionPlant_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_ProductionPlant_ID, Integer.valueOf(TF_ProductionPlant_ID));
	}

	/** Get TF_ProductionPlant.
		@return TF_ProductionPlant	  */
	public int getTF_ProductionPlant_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ProductionPlant_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Unit Divisor.
		@param Unit_Divisor Unit Divisor	  */
	public void setUnit_Divisor (BigDecimal Unit_Divisor)
	{
		set_Value (COLUMNNAME_Unit_Divisor, Unit_Divisor);
	}

	/** Get Unit Divisor.
		@return Unit Divisor	  */
	public BigDecimal getUnit_Divisor () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Unit_Divisor);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}