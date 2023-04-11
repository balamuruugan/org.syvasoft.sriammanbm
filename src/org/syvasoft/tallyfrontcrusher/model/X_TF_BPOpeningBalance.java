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

/** Generated Model for TF_BPOpeningBalance
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_BPOpeningBalance extends PO implements I_TF_BPOpeningBalance, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171125L;

    /** Standard Constructor */
    public X_TF_BPOpeningBalance (Properties ctx, int TF_BPOpeningBalance_ID, String trxName)
    {
      super (ctx, TF_BPOpeningBalance_ID, trxName);
      /** if (TF_BPOpeningBalance_ID == 0)
        {
			setC_BPartner_ID (0);
			setOpeningDate (new Timestamp( System.currentTimeMillis() ));
			setTF_BPOpeningBalance_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_BPOpeningBalance (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_BPOpeningBalance[")
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

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
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

	/** Set Business Partner Opening Balance.
		@param TF_BPOpeningBalance_ID Business Partner Opening Balance	  */
	public void setTF_BPOpeningBalance_ID (int TF_BPOpeningBalance_ID)
	{
		if (TF_BPOpeningBalance_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_BPOpeningBalance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_BPOpeningBalance_ID, Integer.valueOf(TF_BPOpeningBalance_ID));
	}

	/** Get Business Partner Opening Balance.
		@return Business Partner Opening Balance	  */
	public int getTF_BPOpeningBalance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_BPOpeningBalance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_BPOpeningBalance_UU.
		@param TF_BPOpeningBalance_UU TF_BPOpeningBalance_UU	  */
	public void setTF_BPOpeningBalance_UU (String TF_BPOpeningBalance_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_BPOpeningBalance_UU, TF_BPOpeningBalance_UU);
	}

	/** Get TF_BPOpeningBalance_UU.
		@return TF_BPOpeningBalance_UU	  */
	public String getTF_BPOpeningBalance_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_BPOpeningBalance_UU);
	}
}