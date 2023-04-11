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

/** Generated Model for TF_Shareholder
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_Shareholder extends PO implements I_TF_Shareholder, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171220L;

    /** Standard Constructor */
    public X_TF_Shareholder (Properties ctx, int TF_Shareholder_ID, String trxName)
    {
      super (ctx, TF_Shareholder_ID, trxName);
      /** if (TF_Shareholder_ID == 0)
        {
			setAccountGroup_ID (0);
			setInvestmentShare (Env.ZERO);
			setName (null);
			setProfitShare (Env.ZERO);
			setTF_Shareholder_ID (0);
			setTF_ShareholderType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Shareholder (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Shareholder[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_ElementValue getAccountGroup() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getAccountGroup_ID(), get_TrxName());	}

	/** Set Account Group.
		@param AccountGroup_ID Account Group	  */
	public void setAccountGroup_ID (int AccountGroup_ID)
	{
		if (AccountGroup_ID < 1) 
			set_Value (COLUMNNAME_AccountGroup_ID, null);
		else 
			set_Value (COLUMNNAME_AccountGroup_ID, Integer.valueOf(AccountGroup_ID));
	}

	/** Get Account Group.
		@return Account Group	  */
	public int getAccountGroup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AccountGroup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Balance.
		@param Balance Balance	  */
	public void setBalance (BigDecimal Balance)
	{
		throw new IllegalArgumentException ("Balance is virtual column");	}

	/** Get Balance.
		@return Balance	  */
	public BigDecimal getBalance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Balance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_ElementValue getCapitalAcct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getCapitalAcct_ID(), get_TrxName());	}

	/** Set Capital A/c.
		@param CapitalAcct_ID Capital A/c	  */
	public void setCapitalAcct_ID (int CapitalAcct_ID)
	{
		if (CapitalAcct_ID < 1) 
			set_Value (COLUMNNAME_CapitalAcct_ID, null);
		else 
			set_Value (COLUMNNAME_CapitalAcct_ID, Integer.valueOf(CapitalAcct_ID));
	}

	/** Get Capital A/c.
		@return Capital A/c	  */
	public int getCapitalAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CapitalAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Investment Receivable.
		@param Investment_Receivable Investment Receivable	  */
	public void setInvestment_Receivable (BigDecimal Investment_Receivable)
	{
		set_Value (COLUMNNAME_Investment_Receivable, Investment_Receivable);
	}

	/** Get Investment Receivable.
		@return Investment Receivable	  */
	public BigDecimal getInvestment_Receivable () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Investment_Receivable);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Investment Received.
		@param Investment_Received Investment Received	  */
	public void setInvestment_Received (BigDecimal Investment_Received)
	{
		set_Value (COLUMNNAME_Investment_Received, Investment_Received);
	}

	/** Get Investment Received.
		@return Investment Received	  */
	public BigDecimal getInvestment_Received () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Investment_Received);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Investment Share (%).
		@param InvestmentShare Investment Share (%)	  */
	public void setInvestmentShare (BigDecimal InvestmentShare)
	{
		set_Value (COLUMNNAME_InvestmentShare, InvestmentShare);
	}

	/** Get Investment Share (%).
		@return Investment Share (%)	  */
	public BigDecimal getInvestmentShare () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_InvestmentShare);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Name + Outstanding Balance.
		@param NameOutstanding Name + Outstanding Balance	  */
	public void setNameOutstanding (String NameOutstanding)
	{
		throw new IllegalArgumentException ("NameOutstanding is virtual column");	}

	/** Get Name + Outstanding Balance.
		@return Name + Outstanding Balance	  */
	public String getNameOutstanding () 
	{
		return (String)get_Value(COLUMNNAME_NameOutstanding);
	}

	/** Set Profit Share (%).
		@param ProfitShare Profit Share (%)	  */
	public void setProfitShare (BigDecimal ProfitShare)
	{
		set_Value (COLUMNNAME_ProfitShare, ProfitShare);
	}

	/** Get Profit Share (%).
		@return Profit Share (%)	  */
	public BigDecimal getProfitShare () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ProfitShare);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Shareholder.
		@param TF_Shareholder_ID Shareholder	  */
	public void setTF_Shareholder_ID (int TF_Shareholder_ID)
	{
		if (TF_Shareholder_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Shareholder_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Shareholder_ID, Integer.valueOf(TF_Shareholder_ID));
	}

	/** Get Shareholder.
		@return Shareholder	  */
	public int getTF_Shareholder_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Shareholder_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Shareholder_UU.
		@param TF_Shareholder_UU TF_Shareholder_UU	  */
	public void setTF_Shareholder_UU (String TF_Shareholder_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Shareholder_UU, TF_Shareholder_UU);
	}

	/** Get TF_Shareholder_UU.
		@return TF_Shareholder_UU	  */
	public String getTF_Shareholder_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Shareholder_UU);
	}

	public I_TF_Shareholder getTF_ShareholderMain() throws RuntimeException
    {
		return (I_TF_Shareholder)MTable.get(getCtx(), I_TF_Shareholder.Table_Name)
			.getPO(getTF_ShareholderMain_ID(), get_TrxName());	}

	/** Set Main Shareholder.
		@param TF_ShareholderMain_ID Main Shareholder	  */
	public void setTF_ShareholderMain_ID (int TF_ShareholderMain_ID)
	{
		if (TF_ShareholderMain_ID < 1) 
			set_Value (COLUMNNAME_TF_ShareholderMain_ID, null);
		else 
			set_Value (COLUMNNAME_TF_ShareholderMain_ID, Integer.valueOf(TF_ShareholderMain_ID));
	}

	/** Get Main Shareholder.
		@return Main Shareholder	  */
	public int getTF_ShareholderMain_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ShareholderMain_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_ShareholderType getTF_ShareholderType() throws RuntimeException
    {
		return (I_TF_ShareholderType)MTable.get(getCtx(), I_TF_ShareholderType.Table_Name)
			.getPO(getTF_ShareholderType_ID(), get_TrxName());	}

	/** Set Shareholder Type.
		@param TF_ShareholderType_ID Shareholder Type	  */
	public void setTF_ShareholderType_ID (int TF_ShareholderType_ID)
	{
		if (TF_ShareholderType_ID < 1) 
			set_Value (COLUMNNAME_TF_ShareholderType_ID, null);
		else 
			set_Value (COLUMNNAME_TF_ShareholderType_ID, Integer.valueOf(TF_ShareholderType_ID));
	}

	/** Get Shareholder Type.
		@return Shareholder Type	  */
	public int getTF_ShareholderType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ShareholderType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Unallocated Amt.
		@param UnallocatedAmt Unallocated Amt	  */
	public void setUnallocatedAmt (BigDecimal UnallocatedAmt)
	{
		set_Value (COLUMNNAME_UnallocatedAmt, UnallocatedAmt);
	}

	/** Get Unallocated Amt.
		@return Unallocated Amt	  */
	public BigDecimal getUnallocatedAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_UnallocatedAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}