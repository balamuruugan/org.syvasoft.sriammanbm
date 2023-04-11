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
import org.compiere.util.KeyNamePair;

/** Generated Model for TF_Jobwork_IssuedResource
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_Jobwork_IssuedResource extends PO implements I_TF_Jobwork_IssuedResource, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180119L;

    /** Standard Constructor */
    public X_TF_Jobwork_IssuedResource (Properties ctx, int TF_Jobwork_IssuedResource_ID, String trxName)
    {
      super (ctx, TF_Jobwork_IssuedResource_ID, trxName);
      /** if (TF_Jobwork_IssuedResource_ID == 0)
        {
			setContractBase (null);
			setContractStatus (null);
// A
			setIsFuelIncluded (true);
// Y
			setIsOperatorWageIncluded (false);
// N
			setM_Product_ID (0);
			setOperatorDeductedWage (Env.ZERO);
// 0
			setOperatorTotalWage (Env.ZERO);
// 0
			setTF_Jobwork_IssuedResource_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Jobwork_IssuedResource (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Jobwork_IssuedResource[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getC_Project_ID(), get_TrxName());	}

	/** Set Project.
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

	/** Get Project.
		@return Financial Project
	  */
	public int getC_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Close Date.
		@param CloseDate 
		Close Date
	  */
	public void setCloseDate (Timestamp CloseDate)
	{
		set_Value (COLUMNNAME_CloseDate, CloseDate);
	}

	/** Get Close Date.
		@return Close Date
	  */
	public Timestamp getCloseDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_CloseDate);
	}

	/** Set Contract Amt (Actual).
		@param Contract_Amt_Act Contract Amt (Actual)	  */
	public void setContract_Amt_Act (BigDecimal Contract_Amt_Act)
	{
		set_Value (COLUMNNAME_Contract_Amt_Act, Contract_Amt_Act);
	}

	/** Get Contract Amt (Actual).
		@return Contract Amt (Actual)	  */
	public BigDecimal getContract_Amt_Act () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Contract_Amt_Act);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Day = D */
	public static final String CONTRACTBASE_Day = "D";
	/** Meter = M */
	public static final String CONTRACTBASE_Meter = "M";
	/** Month = O */
	public static final String CONTRACTBASE_Month = "O";
	/** Set Contract Base.
		@param ContractBase 
		Represents how the contract amount will be calculated.
	  */
	public void setContractBase (String ContractBase)
	{

		set_Value (COLUMNNAME_ContractBase, ContractBase);
	}

	/** Get Contract Base.
		@return Represents how the contract amount will be calculated.
	  */
	public String getContractBase () 
	{
		return (String)get_Value(COLUMNNAME_ContractBase);
	}

	/** Active = A */
	public static final String CONTRACTSTATUS_Active = "A";
	/** Closed = C */
	public static final String CONTRACTSTATUS_Closed = "C";
	/** Set Contract Status.
		@param ContractStatus Contract Status	  */
	public void setContractStatus (String ContractStatus)
	{

		set_Value (COLUMNNAME_ContractStatus, ContractStatus);
	}

	/** Get Contract Status.
		@return Contract Status	  */
	public String getContractStatus () 
	{
		return (String)get_Value(COLUMNNAME_ContractStatus);
	}

	/** Set Deducted Amount.
		@param DeductedAmt Deducted Amount	  */
	public void setDeductedAmt (BigDecimal DeductedAmt)
	{
		set_Value (COLUMNNAME_DeductedAmt, DeductedAmt);
	}

	/** Get Deducted Amount.
		@return Deducted Amount	  */
	public BigDecimal getDeductedAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DeductedAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Fuel Included.
		@param IsFuelIncluded Fuel Included	  */
	public void setIsFuelIncluded (boolean IsFuelIncluded)
	{
		set_Value (COLUMNNAME_IsFuelIncluded, Boolean.valueOf(IsFuelIncluded));
	}

	/** Get Fuel Included.
		@return Fuel Included	  */
	public boolean isFuelIncluded () 
	{
		Object oo = get_Value(COLUMNNAME_IsFuelIncluded);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Operator Wage Included.
		@param IsOperatorWageIncluded Operator Wage Included	  */
	public void setIsOperatorWageIncluded (boolean IsOperatorWageIncluded)
	{
		set_Value (COLUMNNAME_IsOperatorWageIncluded, Boolean.valueOf(IsOperatorWageIncluded));
	}

	/** Get Operator Wage Included.
		@return Operator Wage Included	  */
	public boolean isOperatorWageIncluded () 
	{
		Object oo = get_Value(COLUMNNAME_IsOperatorWageIncluded);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getM_Product_ID()));
    }

	/** Set Operator Deducted Wage.
		@param OperatorDeductedWage Operator Deducted Wage	  */
	public void setOperatorDeductedWage (BigDecimal OperatorDeductedWage)
	{
		set_Value (COLUMNNAME_OperatorDeductedWage, OperatorDeductedWage);
	}

	/** Get Operator Deducted Wage.
		@return Operator Deducted Wage	  */
	public BigDecimal getOperatorDeductedWage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_OperatorDeductedWage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total Wage.
		@param OperatorTotalWage Total Wage	  */
	public void setOperatorTotalWage (BigDecimal OperatorTotalWage)
	{
		set_Value (COLUMNNAME_OperatorTotalWage, OperatorTotalWage);
	}

	/** Get Total Wage.
		@return Total Wage	  */
	public BigDecimal getOperatorTotalWage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_OperatorTotalWage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Quantity Deducted.
		@param QtyDeducted Quantity Deducted	  */
	public void setQtyDeducted (BigDecimal QtyDeducted)
	{
		set_Value (COLUMNNAME_QtyDeducted, QtyDeducted);
	}

	/** Get Quantity Deducted.
		@return Quantity Deducted	  */
	public BigDecimal getQtyDeducted () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyDeducted);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Issued Vehicles / Resources.
		@param TF_Jobwork_IssuedResource_ID Issued Vehicles / Resources	  */
	public void setTF_Jobwork_IssuedResource_ID (int TF_Jobwork_IssuedResource_ID)
	{
		if (TF_Jobwork_IssuedResource_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_IssuedResource_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_IssuedResource_ID, Integer.valueOf(TF_Jobwork_IssuedResource_ID));
	}

	/** Get Issued Vehicles / Resources.
		@return Issued Vehicles / Resources	  */
	public int getTF_Jobwork_IssuedResource_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Jobwork_IssuedResource_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Jobwork_IssuedResource_UU.
		@param TF_Jobwork_IssuedResource_UU TF_Jobwork_IssuedResource_UU	  */
	public void setTF_Jobwork_IssuedResource_UU (String TF_Jobwork_IssuedResource_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Jobwork_IssuedResource_UU, TF_Jobwork_IssuedResource_UU);
	}

	/** Get TF_Jobwork_IssuedResource_UU.
		@return TF_Jobwork_IssuedResource_UU	  */
	public String getTF_Jobwork_IssuedResource_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Jobwork_IssuedResource_UU);
	}

	/** Set Unit Price.
		@param Unit_Price Unit Price	  */
	public void setUnit_Price (BigDecimal Unit_Price)
	{
		set_Value (COLUMNNAME_Unit_Price, Unit_Price);
	}

	/** Get Unit Price.
		@return Unit Price	  */
	public BigDecimal getUnit_Price () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Unit_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_Charge getWage_Charge() throws RuntimeException
    {
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getWage_Charge_ID(), get_TrxName());	}

	/** Set Operator Wage Expense.
		@param Wage_Charge_ID Operator Wage Expense	  */
	public void setWage_Charge_ID (int Wage_Charge_ID)
	{
		if (Wage_Charge_ID < 1) 
			set_Value (COLUMNNAME_Wage_Charge_ID, null);
		else 
			set_Value (COLUMNNAME_Wage_Charge_ID, Integer.valueOf(Wage_Charge_ID));
	}

	/** Get Operator Wage Expense.
		@return Operator Wage Expense	  */
	public int getWage_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Wage_Charge_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}