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

/** Generated Model for TF_YardCustomerVehicle
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_YardCustomerVehicle extends PO implements I_TF_YardCustomerVehicle, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180207L;

    /** Standard Constructor */
    public X_TF_YardCustomerVehicle (Properties ctx, int TF_YardCustomerVehicle_ID, String trxName)
    {
      super (ctx, TF_YardCustomerVehicle_ID, trxName);
      /** if (TF_YardCustomerVehicle_ID == 0)
        {
			setTF_VehicleType_ID (0);
			setTF_YardCustomerVehicle_ID (0);
			setVehicleNo (null);
        } */
    }

    /** Load Constructor */
    public X_TF_YardCustomerVehicle (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_YardCustomerVehicle[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Permit Price.
		@param PermitPrice Permit Price	  */
	public void setPermitPrice (BigDecimal PermitPrice)
	{
		set_Value (COLUMNNAME_PermitPrice, PermitPrice);
	}

	/** Get Permit Price.
		@return Permit Price	  */
	public BigDecimal getPermitPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Yard Customer Vehicle.
		@param TF_YardCustomerVehicle_ID Yard Customer Vehicle	  */
	public void setTF_YardCustomerVehicle_ID (int TF_YardCustomerVehicle_ID)
	{
		if (TF_YardCustomerVehicle_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_YardCustomerVehicle_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_YardCustomerVehicle_ID, Integer.valueOf(TF_YardCustomerVehicle_ID));
	}

	/** Get Yard Customer Vehicle.
		@return Yard Customer Vehicle	  */
	public int getTF_YardCustomerVehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_YardCustomerVehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_YardCustomerVehicle_UU.
		@param TF_YardCustomerVehicle_UU TF_YardCustomerVehicle_UU	  */
	public void setTF_YardCustomerVehicle_UU (String TF_YardCustomerVehicle_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_YardCustomerVehicle_UU, TF_YardCustomerVehicle_UU);
	}

	/** Get TF_YardCustomerVehicle_UU.
		@return TF_YardCustomerVehicle_UU	  */
	public String getTF_YardCustomerVehicle_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_YardCustomerVehicle_UU);
	}

	/** Set Vehicle No.
		@param VehicleNo Vehicle No	  */
	public void setVehicleNo (String VehicleNo)
	{
		set_Value (COLUMNNAME_VehicleNo, VehicleNo);
	}

	/** Get Vehicle No.
		@return Vehicle No	  */
	public String getVehicleNo () 
	{
		return (String)get_Value(COLUMNNAME_VehicleNo);
	}
}