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

/** Generated Model for TF_EmpIncrementHistory
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_EmpIncrementHistory extends PO implements I_TF_EmpIncrementHistory, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220709L;

    /** Standard Constructor */
    public X_TF_EmpIncrementHistory (Properties ctx, int TF_EmpIncrementHistory_ID, String trxName)
    {
      super (ctx, TF_EmpIncrementHistory_ID, trxName);
      /** if (TF_EmpIncrementHistory_ID == 0)
        {
			setIncrementAmt (Env.ZERO);
			setTF_EmpIncrementHistory_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_EmpIncrementHistory (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_EmpIncrementHistory[")
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

	public org.compiere.model.I_C_Period getC_Period() throws RuntimeException
    {
		return (org.compiere.model.I_C_Period)MTable.get(getCtx(), org.compiere.model.I_C_Period.Table_Name)
			.getPO(getC_Period_ID(), get_TrxName());	}

	/** Set Period.
		@param C_Period_ID 
		Period of the Calendar
	  */
	public void setC_Period_ID (int C_Period_ID)
	{
		if (C_Period_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Period_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Period_ID, Integer.valueOf(C_Period_ID));
	}

	/** Get Period.
		@return Period of the Calendar
	  */
	public int getC_Period_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Period_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Increment Amount.
		@param IncrementAmt Increment Amount	  */
	public void setIncrementAmt (BigDecimal IncrementAmt)
	{
		set_Value (COLUMNNAME_IncrementAmt, IncrementAmt);
	}

	/** Get Increment Amount.
		@return Increment Amount	  */
	public BigDecimal getIncrementAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_IncrementAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Increment History.
		@param TF_EmpIncrementHistory_ID Increment History	  */
	public void setTF_EmpIncrementHistory_ID (int TF_EmpIncrementHistory_ID)
	{
		if (TF_EmpIncrementHistory_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_EmpIncrementHistory_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_EmpIncrementHistory_ID, Integer.valueOf(TF_EmpIncrementHistory_ID));
	}

	/** Get Increment History.
		@return Increment History	  */
	public int getTF_EmpIncrementHistory_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_EmpIncrementHistory_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_EmpIncrementHistory_UU.
		@param TF_EmpIncrementHistory_UU TF_EmpIncrementHistory_UU	  */
	public void setTF_EmpIncrementHistory_UU (String TF_EmpIncrementHistory_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_EmpIncrementHistory_UU, TF_EmpIncrementHistory_UU);
	}

	/** Get TF_EmpIncrementHistory_UU.
		@return TF_EmpIncrementHistory_UU	  */
	public String getTF_EmpIncrementHistory_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_EmpIncrementHistory_UU);
	}
}