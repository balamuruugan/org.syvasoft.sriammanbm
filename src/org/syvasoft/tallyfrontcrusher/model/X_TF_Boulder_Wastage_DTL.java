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

/** Generated Model for TF_Boulder_Wastage_DTL
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_Boulder_Wastage_DTL extends PO implements I_TF_Boulder_Wastage_DTL, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220804L;

    /** Standard Constructor */
    public X_TF_Boulder_Wastage_DTL (Properties ctx, int TF_Boulder_Wastage_DTL_ID, String trxName)
    {
      super (ctx, TF_Boulder_Wastage_DTL_ID, trxName);
      /** if (TF_Boulder_Wastage_DTL_ID == 0)
        {
			setTF_Boulder_Wastage_DTL_ID (0);
			setTF_Boulder_Wastage_HDR_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Boulder_Wastage_DTL (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Boulder_Wastage_DTL[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Allow Scalping Percentage.
		@param AllowScalping_Percent Allow Scalping Percentage	  */
	public void setAllowScalping_Percent (BigDecimal AllowScalping_Percent)
	{
		set_Value (COLUMNNAME_AllowScalping_Percent, AllowScalping_Percent);
	}

	/** Get Allow Scalping Percentage.
		@return Allow Scalping Percentage	  */
	public BigDecimal getAllowScalping_Percent () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AllowScalping_Percent);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Allow Scalping Qty.
		@param AllowScalping_Qty Allow Scalping Qty	  */
	public void setAllowScalping_Qty (BigDecimal AllowScalping_Qty)
	{
		set_Value (COLUMNNAME_AllowScalping_Qty, AllowScalping_Qty);
	}

	/** Get Allow Scalping Qty.
		@return Allow Scalping Qty	  */
	public BigDecimal getAllowScalping_Qty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AllowScalping_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
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

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getC_Project_ID(), get_TrxName());	}

	/** Set Subcontract / Project.
		@param C_Project_ID 
		Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Subcontract / Project.
		@return Financial Project
	  */
	public int getC_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getJobWork_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getJobWork_Product_ID(), get_TrxName());	}

	/** Set Job Work.
		@param JobWork_Product_ID Job Work	  */
	public void setJobWork_Product_ID (int JobWork_Product_ID)
	{
		if (JobWork_Product_ID < 1) 
			set_Value (COLUMNNAME_JobWork_Product_ID, null);
		else 
			set_Value (COLUMNNAME_JobWork_Product_ID, Integer.valueOf(JobWork_Product_ID));
	}

	/** Get Job Work.
		@return Job Work	  */
	public int getJobWork_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_JobWork_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_InOut getM_InOut() throws RuntimeException
    {
		return (org.compiere.model.I_M_InOut)MTable.get(getCtx(), org.compiere.model.I_M_InOut.Table_Name)
			.getPO(getM_InOut_ID(), get_TrxName());	}

	/** Set Shipment/Receipt.
		@param M_InOut_ID 
		Material Shipment Document
	  */
	public void setM_InOut_ID (int M_InOut_ID)
	{
		if (M_InOut_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_InOut_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_InOut_ID, Integer.valueOf(M_InOut_ID));
	}

	/** Get Shipment/Receipt.
		@return Material Shipment Document
	  */
	public int getM_InOut_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_InOut_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Net Qty.
		@param NetQty Net Qty	  */
	public void setNetQty (BigDecimal NetQty)
	{
		set_Value (COLUMNNAME_NetQty, NetQty);
	}

	/** Get Net Qty.
		@return Net Qty	  */
	public BigDecimal getNetQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NetQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set No Trips.
		@param NoTrips No Trips	  */
	public void setNoTrips (int NoTrips)
	{
		set_Value (COLUMNNAME_NoTrips, Integer.valueOf(NoTrips));
	}

	/** Get No Trips.
		@return No Trips	  */
	public int getNoTrips () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_NoTrips);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Quantity.
		@param Qty 
		Quantity
	  */
	public void setQty (BigDecimal Qty)
	{
		set_Value (COLUMNNAME_Qty, Qty);
	}

	/** Get Quantity.
		@return Quantity
	  */
	public BigDecimal getQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Adjustment Qty.
		@param QtyAdjustment Adjustment Qty	  */
	public void setQtyAdjustment (BigDecimal QtyAdjustment)
	{
		set_Value (COLUMNNAME_QtyAdjustment, QtyAdjustment);
	}

	/** Get Adjustment Qty.
		@return Adjustment Qty	  */
	public BigDecimal getQtyAdjustment () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyAdjustment);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Scalping Qty.
		@param Scalping_Qty Scalping Qty	  */
	public void setScalping_Qty (BigDecimal Scalping_Qty)
	{
		set_Value (COLUMNNAME_Scalping_Qty, Scalping_Qty);
	}

	/** Get Scalping Qty.
		@return Scalping Qty	  */
	public BigDecimal getScalping_Qty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Scalping_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Boulder Wastage Detail.
		@param TF_Boulder_Wastage_DTL_ID Boulder Wastage Detail	  */
	public void setTF_Boulder_Wastage_DTL_ID (int TF_Boulder_Wastage_DTL_ID)
	{
		if (TF_Boulder_Wastage_DTL_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_DTL_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_DTL_ID, Integer.valueOf(TF_Boulder_Wastage_DTL_ID));
	}

	/** Get Boulder Wastage Detail.
		@return Boulder Wastage Detail	  */
	public int getTF_Boulder_Wastage_DTL_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Wastage_DTL_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Boulder_Wastage_DTL_UU.
		@param TF_Boulder_Wastage_DTL_UU TF_Boulder_Wastage_DTL_UU	  */
	public void setTF_Boulder_Wastage_DTL_UU (String TF_Boulder_Wastage_DTL_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_DTL_UU, TF_Boulder_Wastage_DTL_UU);
	}

	/** Get TF_Boulder_Wastage_DTL_UU.
		@return TF_Boulder_Wastage_DTL_UU	  */
	public String getTF_Boulder_Wastage_DTL_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Boulder_Wastage_DTL_UU);
	}

	public I_TF_Boulder_Wastage_HDR getTF_Boulder_Wastage_HDR() throws RuntimeException
    {
		return (I_TF_Boulder_Wastage_HDR)MTable.get(getCtx(), I_TF_Boulder_Wastage_HDR.Table_Name)
			.getPO(getTF_Boulder_Wastage_HDR_ID(), get_TrxName());	}

	/** Set Boulder Wastage Header.
		@param TF_Boulder_Wastage_HDR_ID Boulder Wastage Header	  */
	public void setTF_Boulder_Wastage_HDR_ID (int TF_Boulder_Wastage_HDR_ID)
	{
		if (TF_Boulder_Wastage_HDR_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_HDR_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_HDR_ID, Integer.valueOf(TF_Boulder_Wastage_HDR_ID));
	}

	/** Get Boulder Wastage Header.
		@return Boulder Wastage Header	  */
	public int getTF_Boulder_Wastage_HDR_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Wastage_HDR_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}