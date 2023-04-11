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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for TF_IncentiveConfig_Applicable
 *  @author iDempiere (generated) 
 *  @version Release 9 - $Id$ */
@org.adempiere.base.Model(table="TF_IncentiveConfig_Applicable")
public class X_TF_IncentiveConfig_Applicable extends PO implements I_TF_IncentiveConfig_Applicable, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230225L;

    /** Standard Constructor */
    public X_TF_IncentiveConfig_Applicable (Properties ctx, int TF_IncentiveConfig_Applicable_ID, String trxName)
    {
      super (ctx, TF_IncentiveConfig_Applicable_ID, trxName);
      /** if (TF_IncentiveConfig_Applicable_ID == 0)
        {
			setM_Product_Category_ID (0);
			setM_Product_ID (0);
			setTF_IncentiveConfig_Exld_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_IncentiveConfig_Applicable (Properties ctx, int TF_IncentiveConfig_Applicable_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_IncentiveConfig_Applicable_ID, trxName, virtualColumns);
      /** if (TF_IncentiveConfig_Applicable_ID == 0)
        {
			setM_Product_Category_ID (0);
			setM_Product_ID (0);
			setTF_IncentiveConfig_Exld_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_IncentiveConfig_Applicable (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_TF_IncentiveConfig_Applicable[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product_Category getM_Product_Category() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product_Category)MTable.get(getCtx(), org.compiere.model.I_M_Product_Category.Table_ID)
			.getPO(getM_Product_Category_ID(), get_TrxName());
	}

	/** Set Product Category.
		@param M_Product_Category_ID Category of a Product
	*/
	public void setM_Product_Category_ID (int M_Product_Category_ID)
	{
		if (M_Product_Category_ID < 1)
			set_Value (COLUMNNAME_M_Product_Category_ID, null);
		else
			set_Value (COLUMNNAME_M_Product_Category_ID, Integer.valueOf(M_Product_Category_ID));
	}

	/** Get Product Category.
		@return Category of a Product
	  */
	public int getM_Product_Category_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_Category_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_ID)
			.getPO(getM_Product_ID(), get_TrxName());
	}

	/** Set Product.
		@param M_Product_ID Product, Service, Item
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
	public int getM_Product_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Employee Incentive Configuration Exclude.
		@param TF_IncentiveConfig_Exld_ID Employee Incentive Configuration Exclude
	*/
	public void setTF_IncentiveConfig_Exld_ID (int TF_IncentiveConfig_Exld_ID)
	{
		if (TF_IncentiveConfig_Exld_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_IncentiveConfig_Exld_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_IncentiveConfig_Exld_ID, Integer.valueOf(TF_IncentiveConfig_Exld_ID));
	}

	/** Get Employee Incentive Configuration Exclude.
		@return Employee Incentive Configuration Exclude	  */
	public int getTF_IncentiveConfig_Exld_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_IncentiveConfig_Exld_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_IncentiveConfig_Exld_UU.
		@param TF_IncentiveConfig_Exld_UU TF_IncentiveConfig_Exld_UU
	*/
	public void setTF_IncentiveConfig_Exld_UU (String TF_IncentiveConfig_Exld_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_IncentiveConfig_Exld_UU, TF_IncentiveConfig_Exld_UU);
	}

	/** Get TF_IncentiveConfig_Exld_UU.
		@return TF_IncentiveConfig_Exld_UU	  */
	public String getTF_IncentiveConfig_Exld_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_IncentiveConfig_Exld_UU);
	}

	public I_TF_IncentiveConfig getTF_IncentiveConfig() throws RuntimeException
	{
		return (I_TF_IncentiveConfig)MTable.get(getCtx(), I_TF_IncentiveConfig.Table_ID)
			.getPO(getTF_IncentiveConfig_ID(), get_TrxName());
	}

	/** Set Employee Incentive Configuration.
		@param TF_IncentiveConfig_ID Employee Incentive Configuration
	*/
	public void setTF_IncentiveConfig_ID (int TF_IncentiveConfig_ID)
	{
		if (TF_IncentiveConfig_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_IncentiveConfig_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_IncentiveConfig_ID, Integer.valueOf(TF_IncentiveConfig_ID));
	}

	/** Get Employee Incentive Configuration.
		@return Employee Incentive Configuration	  */
	public int getTF_IncentiveConfig_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_IncentiveConfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}