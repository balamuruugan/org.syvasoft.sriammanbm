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

/** Generated Model for TF_CounterTransLine
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_CounterTransLine extends PO implements I_TF_CounterTransLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20191213L;

    /** Standard Constructor */
    public X_TF_CounterTransLine (Properties ctx, int TF_CounterTransLine_ID, String trxName)
    {
      super (ctx, TF_CounterTransLine_ID, trxName);
      /** if (TF_CounterTransLine_ID == 0)
        {
			setSrc_Org_ID (0);
// @Src_Org_ID@
			setSrc_Product_ID (0);
			setTF_CounterTransLine_ID (0);
			setTo_Org_ID (0);
// @To_Org_ID@
			setTo_Product_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_CounterTransLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_CounterTransLine[")
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

	public I_TF_CounterTrans getTF_CounterTrans() throws RuntimeException
    {
		return (I_TF_CounterTrans)MTable.get(getCtx(), I_TF_CounterTrans.Table_Name)
			.getPO(getTF_CounterTrans_ID(), get_TrxName());	}

	/** Set Counter Transaction Setup.
		@param TF_CounterTrans_ID Counter Transaction Setup	  */
	public void setTF_CounterTrans_ID (int TF_CounterTrans_ID)
	{
		if (TF_CounterTrans_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CounterTrans_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CounterTrans_ID, Integer.valueOf(TF_CounterTrans_ID));
	}

	/** Get Counter Transaction Setup.
		@return Counter Transaction Setup	  */
	public int getTF_CounterTrans_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CounterTrans_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Counter Transaction Product Setup.
		@param TF_CounterTransLine_ID Counter Transaction Product Setup	  */
	public void setTF_CounterTransLine_ID (int TF_CounterTransLine_ID)
	{
		if (TF_CounterTransLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CounterTransLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CounterTransLine_ID, Integer.valueOf(TF_CounterTransLine_ID));
	}

	/** Get Counter Transaction Product Setup.
		@return Counter Transaction Product Setup	  */
	public int getTF_CounterTransLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CounterTransLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_CounterTransLine_UU.
		@param TF_CounterTransLine_UU TF_CounterTransLine_UU	  */
	public void setTF_CounterTransLine_UU (String TF_CounterTransLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_CounterTransLine_UU, TF_CounterTransLine_UU);
	}

	/** Get TF_CounterTransLine_UU.
		@return TF_CounterTransLine_UU	  */
	public String getTF_CounterTransLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_CounterTransLine_UU);
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
}