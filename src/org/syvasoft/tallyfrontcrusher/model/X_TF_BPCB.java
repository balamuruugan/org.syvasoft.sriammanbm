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

/** Generated Model for TF_BPCB
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_BPCB extends PO implements I_TF_BPCB, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220311L;

    /** Standard Constructor */
    public X_TF_BPCB (Properties ctx, int TF_BPCB_ID, String trxName)
    {
      super (ctx, TF_BPCB_ID, trxName);
      /** if (TF_BPCB_ID == 0)
        {
			setAmountCB (Env.ZERO);
			setDateTo (new Timestamp( System.currentTimeMillis() ));
			setTF_BPCB_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_BPCB (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_BPCB[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_PInstance getAD_PInstance() throws RuntimeException
    {
		return (org.compiere.model.I_AD_PInstance)MTable.get(getCtx(), org.compiere.model.I_AD_PInstance.Table_Name)
			.getPO(getAD_PInstance_ID(), get_TrxName());	}

	/** Set Process Instance.
		@param AD_PInstance_ID 
		Instance of the process
	  */
	public void setAD_PInstance_ID (int AD_PInstance_ID)
	{
		if (AD_PInstance_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_PInstance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_PInstance_ID, Integer.valueOf(AD_PInstance_ID));
	}

	/** Get Process Instance.
		@return Instance of the process
	  */
	public int getAD_PInstance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_PInstance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Amount CB.
		@param AmountCB Amount CB	  */
	public void setAmountCB (BigDecimal AmountCB)
	{
		set_Value (COLUMNNAME_AmountCB, AmountCB);
	}

	/** Get Amount CB.
		@return Amount CB	  */
	public BigDecimal getAmountCB () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmountCB);
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

	/** Set Closing Balance After.
		@param CBAfter Closing Balance After	  */
	public void setCBAfter (BigDecimal CBAfter)
	{
		set_Value (COLUMNNAME_CBAfter, CBAfter);
	}

	/** Get Closing Balance After.
		@return Closing Balance After	  */
	public BigDecimal getCBAfter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CBAfter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Closing Balance Before.
		@param CBBefore Closing Balance Before	  */
	public void setCBBefore (BigDecimal CBBefore)
	{
		set_Value (COLUMNNAME_CBBefore, CBBefore);
	}

	/** Get Closing Balance Before.
		@return Closing Balance Before	  */
	public BigDecimal getCBBefore () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CBBefore);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Date To.
		@param DateTo 
		End date of a date range
	  */
	public void setDateTo (Timestamp DateTo)
	{
		set_Value (COLUMNNAME_DateTo, DateTo);
	}

	/** Get Date To.
		@return End date of a date range
	  */
	public Timestamp getDateTo () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTo);
	}

	/** Set Closing Balance.
		@param TF_BPCB_ID Closing Balance	  */
	public void setTF_BPCB_ID (int TF_BPCB_ID)
	{
		if (TF_BPCB_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_BPCB_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_BPCB_ID, Integer.valueOf(TF_BPCB_ID));
	}

	/** Get Closing Balance.
		@return Closing Balance	  */
	public int getTF_BPCB_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_BPCB_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_BPCB_UU.
		@param TF_BPCB_UU TF_BPCB_UU	  */
	public void setTF_BPCB_UU (String TF_BPCB_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_BPCB_UU, TF_BPCB_UU);
	}

	/** Get TF_BPCB_UU.
		@return TF_BPCB_UU	  */
	public String getTF_BPCB_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_BPCB_UU);
	}
}