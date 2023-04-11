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

/** Generated Model for TF_Jobwork_Expense
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_Jobwork_Expense extends PO implements I_TF_Jobwork_Expense, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180119L;

    /** Standard Constructor */
    public X_TF_Jobwork_Expense (Properties ctx, int TF_Jobwork_Expense_ID, String trxName)
    {
      super (ctx, TF_Jobwork_Expense_ID, trxName);
      /** if (TF_Jobwork_Expense_ID == 0)
        {
			setC_ElementValue_ID (0);
			setTF_Jobwork_Expense_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Jobwork_Expense (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Jobwork_Expense[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValue_ID(), get_TrxName());	}

	/** Set Account Element.
		@param C_ElementValue_ID 
		Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID)
	{
		if (C_ElementValue_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
	}

	/** Get Account Element.
		@return Account Element
	  */
	public int getC_ElementValue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Jobwork Expense.
		@param TF_Jobwork_Expense_ID Jobwork Expense	  */
	public void setTF_Jobwork_Expense_ID (int TF_Jobwork_Expense_ID)
	{
		if (TF_Jobwork_Expense_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_Expense_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_Expense_ID, Integer.valueOf(TF_Jobwork_Expense_ID));
	}

	/** Get Jobwork Expense.
		@return Jobwork Expense	  */
	public int getTF_Jobwork_Expense_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Jobwork_Expense_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Jobwork_Expense_UU.
		@param TF_Jobwork_Expense_UU TF_Jobwork_Expense_UU	  */
	public void setTF_Jobwork_Expense_UU (String TF_Jobwork_Expense_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Jobwork_Expense_UU, TF_Jobwork_Expense_UU);
	}

	/** Get TF_Jobwork_Expense_UU.
		@return TF_Jobwork_Expense_UU	  */
	public String getTF_Jobwork_Expense_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Jobwork_Expense_UU);
	}

	/** Set Total Amount.
		@param TotalAmt 
		Total Amount
	  */
	public void setTotalAmt (BigDecimal TotalAmt)
	{
		set_ValueNoCheck (COLUMNNAME_TotalAmt, TotalAmt);
	}

	/** Get Total Amount.
		@return Total Amount
	  */
	public BigDecimal getTotalAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}