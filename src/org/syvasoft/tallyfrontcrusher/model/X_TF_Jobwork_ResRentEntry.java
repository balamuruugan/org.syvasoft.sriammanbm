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

/** Generated Model for TF_Jobwork_ResRentEntry
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_Jobwork_ResRentEntry extends PO implements I_TF_Jobwork_ResRentEntry, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180119L;

    /** Standard Constructor */
    public X_TF_Jobwork_ResRentEntry (Properties ctx, int TF_Jobwork_ResRentEntry_ID, String trxName)
    {
      super (ctx, TF_Jobwork_ResRentEntry_ID, trxName);
      /** if (TF_Jobwork_ResRentEntry_ID == 0)
        {
			setContractBase (null);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setProcessed (false);
			setTF_Jobwork_IssuedResource_ID (0);
			setTF_Jobwork_ResRentEntry_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Jobwork_ResRentEntry (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Jobwork_ResRentEntry[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set Account Date.
		@param DateAcct 
		Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct)
	{
		set_Value (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	public org.compiere.model.I_C_Invoice getSubcon_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getSubcon_Invoice_ID(), get_TrxName());	}

	/** Set Subcontractor Invoice.
		@param Subcon_Invoice_ID Subcontractor Invoice	  */
	public void setSubcon_Invoice_ID (int Subcon_Invoice_ID)
	{
		if (Subcon_Invoice_ID < 1) 
			set_Value (COLUMNNAME_Subcon_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_Subcon_Invoice_ID, Integer.valueOf(Subcon_Invoice_ID));
	}

	/** Get Subcontractor Invoice.
		@return Subcontractor Invoice	  */
	public int getSubcon_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Subcon_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Jobwork_IssuedResource getTF_Jobwork_IssuedResource() throws RuntimeException
    {
		return (I_TF_Jobwork_IssuedResource)MTable.get(getCtx(), I_TF_Jobwork_IssuedResource.Table_Name)
			.getPO(getTF_Jobwork_IssuedResource_ID(), get_TrxName());	}

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

	/** Set Rent Entry.
		@param TF_Jobwork_ResRentEntry_ID Rent Entry	  */
	public void setTF_Jobwork_ResRentEntry_ID (int TF_Jobwork_ResRentEntry_ID)
	{
		if (TF_Jobwork_ResRentEntry_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_ResRentEntry_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_ResRentEntry_ID, Integer.valueOf(TF_Jobwork_ResRentEntry_ID));
	}

	/** Get Rent Entry.
		@return Rent Entry	  */
	public int getTF_Jobwork_ResRentEntry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Jobwork_ResRentEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Jobwork_ResRentEntry_UU.
		@param TF_Jobwork_ResRentEntry_UU TF_Jobwork_ResRentEntry_UU	  */
	public void setTF_Jobwork_ResRentEntry_UU (String TF_Jobwork_ResRentEntry_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Jobwork_ResRentEntry_UU, TF_Jobwork_ResRentEntry_UU);
	}

	/** Get TF_Jobwork_ResRentEntry_UU.
		@return TF_Jobwork_ResRentEntry_UU	  */
	public String getTF_Jobwork_ResRentEntry_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Jobwork_ResRentEntry_UU);
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
}