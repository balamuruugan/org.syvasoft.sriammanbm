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

/** Generated Model for TF_AdditionalTrans
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_AdditionalTrans extends PO implements I_TF_AdditionalTrans, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200404L;

    /** Standard Constructor */
    public X_TF_AdditionalTrans (Properties ctx, int TF_AdditionalTrans_ID, String trxName)
    {
      super (ctx, TF_AdditionalTrans_ID, trxName);
      /** if (TF_AdditionalTrans_ID == 0)
        {
			setDescription (null);
			setSrc_DocType_ID (0);
			setSrc_Org_ID (0);
			setSrc_Product_ID (0);
			setTF_AdditionalTrans_ID (0);
			setTo_Bpartner_ID (0);
			setTo_Doctype_ID (0);
			setTo_Org_ID (0);
			setTo_Product_ID (0);
			setToQtyRatio (Env.ZERO);
// 1
        } */
    }

    /** Load Constructor */
    public X_TF_AdditionalTrans (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client 
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
      StringBuffer sb = new StringBuffer ("X_TF_AdditionalTrans[")
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

	public org.compiere.model.I_C_BPartner getSrc_Bpartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getSrc_Bpartner_ID(), get_TrxName());	}

	/** Set Source Business Partner.
		@param Src_Bpartner_ID Source Business Partner	  */
	public void setSrc_Bpartner_ID (int Src_Bpartner_ID)
	{
		if (Src_Bpartner_ID < 1) 
			set_Value (COLUMNNAME_Src_Bpartner_ID, null);
		else 
			set_Value (COLUMNNAME_Src_Bpartner_ID, Integer.valueOf(Src_Bpartner_ID));
	}

	/** Get Source Business Partner.
		@return Source Business Partner	  */
	public int getSrc_Bpartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Src_Bpartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getSrc_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getSrc_DocType_ID(), get_TrxName());	}

	/** Set Source Document Type.
		@param Src_DocType_ID Source Document Type	  */
	public void setSrc_DocType_ID (int Src_DocType_ID)
	{
		if (Src_DocType_ID < 1) 
			set_Value (COLUMNNAME_Src_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_Src_DocType_ID, Integer.valueOf(Src_DocType_ID));
	}

	/** Get Source Document Type.
		@return Source Document Type	  */
	public int getSrc_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Src_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Source Organization.
		@param Src_Org_ID Source Organization	  */
	public void setSrc_Org_ID (int Src_Org_ID)
	{
		if (Src_Org_ID < 1) 
			set_Value (COLUMNNAME_Src_Org_ID, null);
		else 
			set_Value (COLUMNNAME_Src_Org_ID, Integer.valueOf(Src_Org_ID));
	}

	/** Get Source Organization.
		@return Source Organization	  */
	public int getSrc_Org_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Src_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getSrc_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getSrc_Product_ID(), get_TrxName());	}

	/** Set Source Product.
		@param Src_Product_ID Source Product	  */
	public void setSrc_Product_ID (int Src_Product_ID)
	{
		if (Src_Product_ID < 1) 
			set_Value (COLUMNNAME_Src_Product_ID, null);
		else 
			set_Value (COLUMNNAME_Src_Product_ID, Integer.valueOf(Src_Product_ID));
	}

	/** Get Source Product.
		@return Source Product	  */
	public int getSrc_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Src_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Additional Transaction Setup.
		@param TF_AdditionalTrans_ID Additional Transaction Setup	  */
	public void setTF_AdditionalTrans_ID (int TF_AdditionalTrans_ID)
	{
		if (TF_AdditionalTrans_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_AdditionalTrans_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_AdditionalTrans_ID, Integer.valueOf(TF_AdditionalTrans_ID));
	}

	/** Get Additional Transaction Setup.
		@return Additional Transaction Setup	  */
	public int getTF_AdditionalTrans_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_AdditionalTrans_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_AdditionalTrans_UU.
		@param TF_AdditionalTrans_UU TF_AdditionalTrans_UU	  */
	public void setTF_AdditionalTrans_UU (String TF_AdditionalTrans_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_AdditionalTrans_UU, TF_AdditionalTrans_UU);
	}

	/** Get TF_AdditionalTrans_UU.
		@return TF_AdditionalTrans_UU	  */
	public String getTF_AdditionalTrans_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_AdditionalTrans_UU);
	}

	public org.compiere.model.I_C_BPartner getTo_Bpartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getTo_Bpartner_ID(), get_TrxName());	}

	/** Set To Business Partner.
		@param To_Bpartner_ID To Business Partner	  */
	public void setTo_Bpartner_ID (int To_Bpartner_ID)
	{
		if (To_Bpartner_ID < 1) 
			set_Value (COLUMNNAME_To_Bpartner_ID, null);
		else 
			set_Value (COLUMNNAME_To_Bpartner_ID, Integer.valueOf(To_Bpartner_ID));
	}

	/** Get To Business Partner.
		@return To Business Partner	  */
	public int getTo_Bpartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_To_Bpartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getTo_Doctype() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getTo_Doctype_ID(), get_TrxName());	}

	/** Set To Document Type.
		@param To_Doctype_ID To Document Type	  */
	public void setTo_Doctype_ID (int To_Doctype_ID)
	{
		if (To_Doctype_ID < 1) 
			set_Value (COLUMNNAME_To_Doctype_ID, null);
		else 
			set_Value (COLUMNNAME_To_Doctype_ID, Integer.valueOf(To_Doctype_ID));
	}

	/** Get To Document Type.
		@return To Document Type	  */
	public int getTo_Doctype_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_To_Doctype_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set To Organization.
		@param To_Org_ID To Organization	  */
	public void setTo_Org_ID (int To_Org_ID)
	{
		if (To_Org_ID < 1) 
			set_Value (COLUMNNAME_To_Org_ID, null);
		else 
			set_Value (COLUMNNAME_To_Org_ID, Integer.valueOf(To_Org_ID));
	}

	/** Get To Organization.
		@return To Organization	  */
	public int getTo_Org_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_To_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getTo_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getTo_Product_ID(), get_TrxName());	}

	/** Set To Product.
		@param To_Product_ID To Product	  */
	public void setTo_Product_ID (int To_Product_ID)
	{
		if (To_Product_ID < 1) 
			set_Value (COLUMNNAME_To_Product_ID, null);
		else 
			set_Value (COLUMNNAME_To_Product_ID, Integer.valueOf(To_Product_ID));
	}

	/** Get To Product.
		@return To Product	  */
	public int getTo_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_To_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set To Qty Ratio.
		@param ToQtyRatio To Qty Ratio	  */
	public void setToQtyRatio (BigDecimal ToQtyRatio)
	{
		set_Value (COLUMNNAME_ToQtyRatio, ToQtyRatio);
	}

	/** Get To Qty Ratio.
		@return To Qty Ratio	  */
	public BigDecimal getToQtyRatio () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ToQtyRatio);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set To Unit Price.
		@param ToUnitPrice To Unit Price	  */
	public void setToUnitPrice (BigDecimal ToUnitPrice)
	{
		set_Value (COLUMNNAME_ToUnitPrice, ToUnitPrice);
	}

	/** Get To Unit Price.
		@return To Unit Price	  */
	public BigDecimal getToUnitPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ToUnitPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set To Unit Price Ratio.
		@param ToUnitPriceRatio To Unit Price Ratio	  */
	public void setToUnitPriceRatio (BigDecimal ToUnitPriceRatio)
	{
		set_Value (COLUMNNAME_ToUnitPriceRatio, ToUnitPriceRatio);
	}

	/** Get To Unit Price Ratio.
		@return To Unit Price Ratio	  */
	public BigDecimal getToUnitPriceRatio () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ToUnitPriceRatio);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_UOM getToUom() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getToUom_ID(), get_TrxName());	}

	/** Set To UOM.
		@param ToUom_ID To UOM	  */
	public void setToUom_ID (int ToUom_ID)
	{
		if (ToUom_ID < 1) 
			set_Value (COLUMNNAME_ToUom_ID, null);
		else 
			set_Value (COLUMNNAME_ToUom_ID, Integer.valueOf(ToUom_ID));
	}

	/** Get To UOM.
		@return To UOM	  */
	public int getToUom_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ToUom_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}