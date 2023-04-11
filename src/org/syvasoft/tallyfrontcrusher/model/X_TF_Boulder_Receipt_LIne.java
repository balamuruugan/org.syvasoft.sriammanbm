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

/** Generated Model for TF_Boulder_Receipt_LIne
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_Boulder_Receipt_LIne extends PO implements I_TF_Boulder_Receipt_LIne, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190201L;

    /** Standard Constructor */
    public X_TF_Boulder_Receipt_LIne (Properties ctx, int TF_Boulder_Receipt_LIne_ID, String trxName)
    {
      super (ctx, TF_Boulder_Receipt_LIne_ID, trxName);
      /** if (TF_Boulder_Receipt_LIne_ID == 0)
        {
			setTF_Boulder_Receipt_ID (0);
			setTF_Boulder_Receipt_LIne_ID (0);
			setVehicle_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Boulder_Receipt_LIne (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Boulder_Receipt_LIne[")
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

	/** Set Load.
		@param Load Load	  */
	public void setLoad (int Load)
	{
		set_Value (COLUMNNAME_Load, Integer.valueOf(Load));
	}

	/** Get Load.
		@return Load	  */
	public int getLoad () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Load);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Boulder_Receipt getTF_Boulder_Receipt() throws RuntimeException
    {
		return (I_TF_Boulder_Receipt)MTable.get(getCtx(), I_TF_Boulder_Receipt.Table_Name)
			.getPO(getTF_Boulder_Receipt_ID(), get_TrxName());	}

	/** Set Boulder Receipt.
		@param TF_Boulder_Receipt_ID Boulder Receipt	  */
	public void setTF_Boulder_Receipt_ID (int TF_Boulder_Receipt_ID)
	{
		if (TF_Boulder_Receipt_ID < 1) 
			set_Value (COLUMNNAME_TF_Boulder_Receipt_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Boulder_Receipt_ID, Integer.valueOf(TF_Boulder_Receipt_ID));
	}

	/** Get Boulder Receipt.
		@return Boulder Receipt	  */
	public int getTF_Boulder_Receipt_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Receipt_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Boulder Receipt Line.
		@param TF_Boulder_Receipt_LIne_ID Boulder Receipt Line	  */
	public void setTF_Boulder_Receipt_LIne_ID (int TF_Boulder_Receipt_LIne_ID)
	{
		if (TF_Boulder_Receipt_LIne_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Receipt_LIne_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Receipt_LIne_ID, Integer.valueOf(TF_Boulder_Receipt_LIne_ID));
	}

	/** Get Boulder Receipt Line.
		@return Boulder Receipt Line	  */
	public int getTF_Boulder_Receipt_LIne_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Receipt_LIne_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Boulder_Receipt_LIne_UU.
		@param TF_Boulder_Receipt_LIne_UU TF_Boulder_Receipt_LIne_UU	  */
	public void setTF_Boulder_Receipt_LIne_UU (String TF_Boulder_Receipt_LIne_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Boulder_Receipt_LIne_UU, TF_Boulder_Receipt_LIne_UU);
	}

	/** Get TF_Boulder_Receipt_LIne_UU.
		@return TF_Boulder_Receipt_LIne_UU	  */
	public String getTF_Boulder_Receipt_LIne_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Boulder_Receipt_LIne_UU);
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