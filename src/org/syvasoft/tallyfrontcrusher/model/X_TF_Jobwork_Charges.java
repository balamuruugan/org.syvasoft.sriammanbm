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

/** Generated Model for TF_Jobwork_Charges
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_Jobwork_Charges extends PO implements I_TF_Jobwork_Charges, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180119L;

    /** Standard Constructor */
    public X_TF_Jobwork_Charges (Properties ctx, int TF_Jobwork_Charges_ID, String trxName)
    {
      super (ctx, TF_Jobwork_Charges_ID, trxName);
      /** if (TF_Jobwork_Charges_ID == 0)
        {
			setC_Charge_ID (0);
			setTF_Jobwork_Charges_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Jobwork_Charges (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Jobwork_Charges[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException
    {
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getC_Charge_ID(), get_TrxName());	}

	/** Set Charge.
		@param C_Charge_ID 
		Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID)
	{
		if (C_Charge_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Charge_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
	}

	/** Get Charge.
		@return Additional document charges
	  */
	public int getC_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Charge_ID);
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

	/** Set Additional Charges / Advances.
		@param TF_Jobwork_Charges_ID Additional Charges / Advances	  */
	public void setTF_Jobwork_Charges_ID (int TF_Jobwork_Charges_ID)
	{
		if (TF_Jobwork_Charges_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_Charges_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_Charges_ID, Integer.valueOf(TF_Jobwork_Charges_ID));
	}

	/** Get Additional Charges / Advances.
		@return Additional Charges / Advances	  */
	public int getTF_Jobwork_Charges_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Jobwork_Charges_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Jobwork_Charges_UU.
		@param TF_Jobwork_Charges_UU TF_Jobwork_Charges_UU	  */
	public void setTF_Jobwork_Charges_UU (String TF_Jobwork_Charges_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Jobwork_Charges_UU, TF_Jobwork_Charges_UU);
	}

	/** Get TF_Jobwork_Charges_UU.
		@return TF_Jobwork_Charges_UU	  */
	public String getTF_Jobwork_Charges_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Jobwork_Charges_UU);
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