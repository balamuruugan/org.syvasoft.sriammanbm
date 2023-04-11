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

/** Generated Model for TF_TyreRequestLine
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_TyreRequestLine extends PO implements I_TF_TyreRequestLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190515L;

    /** Standard Constructor */
    public X_TF_TyreRequestLine (Properties ctx, int TF_TyreRequestLine_ID, String trxName)
    {
      super (ctx, TF_TyreRequestLine_ID, trxName);
      /** if (TF_TyreRequestLine_ID == 0)
        {
			setBrand (null);
			setEnd_Meter (Env.ZERO);
			setM_Product_ID (0);
			setSize (null);
			setTF_Tyre_ID (0);
			setTF_TyreRequest_ID (0);
			setTF_TyreRequestLine_ID (0);
			setTF_TyreType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TyreRequestLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TyreRequestLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Brand.
		@param Brand Brand	  */
	public void setBrand (String Brand)
	{
		set_Value (COLUMNNAME_Brand, Brand);
	}

	/** Get Brand.
		@return Brand	  */
	public String getBrand () 
	{
		return (String)get_Value(COLUMNNAME_Brand);
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

	/** Set Line.
		@param LineNo 
		Line No
	  */
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
		@return Line No
	  */
	public int getLineNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Price.
		@param Price 
		Price
	  */
	public void setPrice (BigDecimal Price)
	{
		set_Value (COLUMNNAME_Price, Price);
	}

	/** Get Price.
		@return Price
	  */
	public BigDecimal getPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Size.
		@param Size Size	  */
	public void setSize (String Size)
	{
		set_Value (COLUMNNAME_Size, Size);
	}

	/** Get Size.
		@return Size	  */
	public String getSize () 
	{
		return (String)get_Value(COLUMNNAME_Size);
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

	public I_TF_TyreRequest getTF_TyreRequest() throws RuntimeException
    {
		return (I_TF_TyreRequest)MTable.get(getCtx(), I_TF_TyreRequest.Table_Name)
			.getPO(getTF_TyreRequest_ID(), get_TrxName());	}

	/** Set TF_TyreRequest.
		@param TF_TyreRequest_ID TF_TyreRequest	  */
	public void setTF_TyreRequest_ID (int TF_TyreRequest_ID)
	{
		if (TF_TyreRequest_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreRequest_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreRequest_ID, Integer.valueOf(TF_TyreRequest_ID));
	}

	/** Get TF_TyreRequest.
		@return TF_TyreRequest	  */
	public int getTF_TyreRequest_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreRequest_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TyreRequestLine.
		@param TF_TyreRequestLine_ID TF_TyreRequestLine	  */
	public void setTF_TyreRequestLine_ID (int TF_TyreRequestLine_ID)
	{
		if (TF_TyreRequestLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreRequestLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreRequestLine_ID, Integer.valueOf(TF_TyreRequestLine_ID));
	}

	/** Get TF_TyreRequestLine.
		@return TF_TyreRequestLine	  */
	public int getTF_TyreRequestLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreRequestLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TyreRequestLine_UU.
		@param TF_TyreRequestLine_UU TF_TyreRequestLine_UU	  */
	public void setTF_TyreRequestLine_UU (String TF_TyreRequestLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TyreRequestLine_UU, TF_TyreRequestLine_UU);
	}

	/** Get TF_TyreRequestLine_UU.
		@return TF_TyreRequestLine_UU	  */
	public String getTF_TyreRequestLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TyreRequestLine_UU);
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
			set_Value (COLUMNNAME_TF_TyreType_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TyreType_ID, Integer.valueOf(TF_TyreType_ID));
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
}