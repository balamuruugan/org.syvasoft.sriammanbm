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

/** Generated Model for TF_Tyre
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_Tyre extends PO implements I_TF_Tyre, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190209L;

    /** Standard Constructor */
    public X_TF_Tyre (Properties ctx, int TF_Tyre_ID, String trxName)
    {
      super (ctx, TF_Tyre_ID, trxName);
      /** if (TF_Tyre_ID == 0)
        {
			setPurchased_TyreType_ID (0);
			setTF_Tyre_ID (0);
			setTF_TyreStatus_ID (0);
			setTyreNo (null);
        } */
    }

    /** Load Constructor */
    public X_TF_Tyre (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Tyre[")
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

	public I_TF_TyreType getCurrent_TyreType() throws RuntimeException
    {
		return (I_TF_TyreType)MTable.get(getCtx(), I_TF_TyreType.Table_Name)
			.getPO(getCurrent_TyreType_ID(), get_TrxName());	}

	/** Set Current Tyre Type.
		@param Current_TyreType_ID Current Tyre Type	  */
	public void setCurrent_TyreType_ID (int Current_TyreType_ID)
	{
		if (Current_TyreType_ID < 1) 
			set_Value (COLUMNNAME_Current_TyreType_ID, null);
		else 
			set_Value (COLUMNNAME_Current_TyreType_ID, Integer.valueOf(Current_TyreType_ID));
	}

	/** Get Current Tyre Type.
		@return Current Tyre Type	  */
	public int getCurrent_TyreType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Current_TyreType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Date Purchased.
		@param DatePurchased Date Purchased	  */
	public void setDatePurchased (Timestamp DatePurchased)
	{
		set_Value (COLUMNNAME_DatePurchased, DatePurchased);
	}

	/** Get Date Purchased.
		@return Date Purchased	  */
	public Timestamp getDatePurchased () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DatePurchased);
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

	public org.compiere.model.I_M_Product getMounted_To() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getMounted_To_ID(), get_TrxName());	}

	/** Set Mounted To.
		@param Mounted_To_ID Mounted To	  */
	public void setMounted_To_ID (int Mounted_To_ID)
	{
		if (Mounted_To_ID < 1) 
			set_Value (COLUMNNAME_Mounted_To_ID, null);
		else 
			set_Value (COLUMNNAME_Mounted_To_ID, Integer.valueOf(Mounted_To_ID));
	}

	/** Get Mounted To.
		@return Mounted To	  */
	public int getMounted_To_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Mounted_To_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyreType getPurchased_TyreType() throws RuntimeException
    {
		return (I_TF_TyreType)MTable.get(getCtx(), I_TF_TyreType.Table_Name)
			.getPO(getPurchased_TyreType_ID(), get_TrxName());	}

	/** Set Purchased Tyre Type.
		@param Purchased_TyreType_ID Purchased Tyre Type	  */
	public void setPurchased_TyreType_ID (int Purchased_TyreType_ID)
	{
		if (Purchased_TyreType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Purchased_TyreType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Purchased_TyreType_ID, Integer.valueOf(Purchased_TyreType_ID));
	}

	/** Get Purchased Tyre Type.
		@return Purchased Tyre Type	  */
	public int getPurchased_TyreType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Purchased_TyreType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Running Meter.
		@param Running_Meter Running Meter	  */
	public void setRunning_Meter (BigDecimal Running_Meter)
	{
		set_Value (COLUMNNAME_Running_Meter, Running_Meter);
	}

	/** Get Running Meter.
		@return Running Meter	  */
	public BigDecimal getRunning_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Running_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Serial No.
		@param SerNo 
		Product Serial Number 
	  */
	public void setSerNo (String SerNo)
	{
		set_Value (COLUMNNAME_SerNo, SerNo);
	}

	/** Get Serial No.
		@return Product Serial Number 
	  */
	public String getSerNo () 
	{
		return (String)get_Value(COLUMNNAME_SerNo);
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

	/** Set TF_Tyre_UU.
		@param TF_Tyre_UU TF_Tyre_UU	  */
	public void setTF_Tyre_UU (String TF_Tyre_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Tyre_UU, TF_Tyre_UU);
	}

	/** Get TF_Tyre_UU.
		@return TF_Tyre_UU	  */
	public String getTF_Tyre_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Tyre_UU);
	}

	public I_TF_TyrePosition getTF_TyrePosition() throws RuntimeException
    {
		return (I_TF_TyrePosition)MTable.get(getCtx(), I_TF_TyrePosition.Table_Name)
			.getPO(getTF_TyrePosition_ID(), get_TrxName());	}

	/** Set Tyre Position.
		@param TF_TyrePosition_ID Tyre Position	  */
	public void setTF_TyrePosition_ID (int TF_TyrePosition_ID)
	{
		if (TF_TyrePosition_ID < 1) 
			set_Value (COLUMNNAME_TF_TyrePosition_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TyrePosition_ID, Integer.valueOf(TF_TyrePosition_ID));
	}

	/** Get Tyre Position.
		@return Tyre Position	  */
	public int getTF_TyrePosition_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyrePosition_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyrePurchase getTF_TyrePurchase() throws RuntimeException
    {
		return (I_TF_TyrePurchase)MTable.get(getCtx(), I_TF_TyrePurchase.Table_Name)
			.getPO(getTF_TyrePurchase_ID(), get_TrxName());	}

	/** Set Tyre Purchase.
		@param TF_TyrePurchase_ID Tyre Purchase	  */
	public void setTF_TyrePurchase_ID (int TF_TyrePurchase_ID)
	{
		if (TF_TyrePurchase_ID < 1) 
			set_Value (COLUMNNAME_TF_TyrePurchase_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TyrePurchase_ID, Integer.valueOf(TF_TyrePurchase_ID));
	}

	/** Get Tyre Purchase.
		@return Tyre Purchase	  */
	public int getTF_TyrePurchase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyrePurchase_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyreStatus getTF_TyreStatus() throws RuntimeException
    {
		return (I_TF_TyreStatus)MTable.get(getCtx(), I_TF_TyreStatus.Table_Name)
			.getPO(getTF_TyreStatus_ID(), get_TrxName());	}

	/** Set Tyre Status.
		@param TF_TyreStatus_ID Tyre Status	  */
	public void setTF_TyreStatus_ID (int TF_TyreStatus_ID)
	{
		if (TF_TyreStatus_ID < 1) 
			set_Value (COLUMNNAME_TF_TyreStatus_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TyreStatus_ID, Integer.valueOf(TF_TyreStatus_ID));
	}

	/** Get Tyre Status.
		@return Tyre Status	  */
	public int getTF_TyreStatus_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreStatus_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tyre No.
		@param TyreNo Tyre No	  */
	public void setTyreNo (String TyreNo)
	{
		set_Value (COLUMNNAME_TyreNo, TyreNo);
	}

	/** Get Tyre No.
		@return Tyre No	  */
	public String getTyreNo () 
	{
		return (String)get_Value(COLUMNNAME_TyreNo);
	}
}