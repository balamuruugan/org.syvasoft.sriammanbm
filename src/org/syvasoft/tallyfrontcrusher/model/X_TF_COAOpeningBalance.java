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

/** Generated Model for TF_COAOpeningBalance
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_COAOpeningBalance extends PO implements I_TF_COAOpeningBalance, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171125L;

    /** Standard Constructor */
    public X_TF_COAOpeningBalance (Properties ctx, int TF_COAOpeningBalance_ID, String trxName)
    {
      super (ctx, TF_COAOpeningBalance_ID, trxName);
      /** if (TF_COAOpeningBalance_ID == 0)
        {
			setC_ElementValue_ID (0);
			setOpeningDate (new Timestamp( System.currentTimeMillis() ));
			setTF_COAOpeningBalance_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_COAOpeningBalance (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_COAOpeningBalance[")
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
			set_ValueNoCheck (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
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

	/** Set Credit Balance.
		@param CreditBalance Credit Balance	  */
	public void setCreditBalance (BigDecimal CreditBalance)
	{
		set_Value (COLUMNNAME_CreditBalance, CreditBalance);
	}

	/** Get Credit Balance.
		@return Credit Balance	  */
	public BigDecimal getCreditBalance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CreditBalance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Debit Balance.
		@param DebitBalance Debit Balance	  */
	public void setDebitBalance (BigDecimal DebitBalance)
	{
		set_Value (COLUMNNAME_DebitBalance, DebitBalance);
	}

	/** Get Debit Balance.
		@return Debit Balance	  */
	public BigDecimal getDebitBalance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DebitBalance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_GL_Journal getGL_Journal() throws RuntimeException
    {
		return (org.compiere.model.I_GL_Journal)MTable.get(getCtx(), org.compiere.model.I_GL_Journal.Table_Name)
			.getPO(getGL_Journal_ID(), get_TrxName());	}

	/** Set Journal.
		@param GL_Journal_ID 
		General Ledger Journal
	  */
	public void setGL_Journal_ID (int GL_Journal_ID)
	{
		if (GL_Journal_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_GL_Journal_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_GL_Journal_ID, Integer.valueOf(GL_Journal_ID));
	}

	/** Get Journal.
		@return General Ledger Journal
	  */
	public int getGL_Journal_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GL_Journal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AS On.
		@param OpeningDate AS On	  */
	public void setOpeningDate (Timestamp OpeningDate)
	{
		set_Value (COLUMNNAME_OpeningDate, OpeningDate);
	}

	/** Get AS On.
		@return AS On	  */
	public Timestamp getOpeningDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_OpeningDate);
	}

	/** Set COA Opening Balance.
		@param TF_COAOpeningBalance_ID COA Opening Balance	  */
	public void setTF_COAOpeningBalance_ID (int TF_COAOpeningBalance_ID)
	{
		if (TF_COAOpeningBalance_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_COAOpeningBalance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_COAOpeningBalance_ID, Integer.valueOf(TF_COAOpeningBalance_ID));
	}

	/** Get COA Opening Balance.
		@return COA Opening Balance	  */
	public int getTF_COAOpeningBalance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_COAOpeningBalance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_COAOpeningBalance_UU.
		@param TF_COAOpeningBalance_UU TF_COAOpeningBalance_UU	  */
	public void setTF_COAOpeningBalance_UU (String TF_COAOpeningBalance_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_COAOpeningBalance_UU, TF_COAOpeningBalance_UU);
	}

	/** Get TF_COAOpeningBalance_UU.
		@return TF_COAOpeningBalance_UU	  */
	public String getTF_COAOpeningBalance_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_COAOpeningBalance_UU);
	}
}