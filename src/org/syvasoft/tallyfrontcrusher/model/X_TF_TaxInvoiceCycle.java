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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for TF_TaxInvoiceCycle
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_TaxInvoiceCycle extends PO implements I_TF_TaxInvoiceCycle, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200214L;

    /** Standard Constructor */
    public X_TF_TaxInvoiceCycle (Properties ctx, int TF_TaxInvoiceCycle_ID, String trxName)
    {
      super (ctx, TF_TaxInvoiceCycle_ID, trxName);
      /** if (TF_TaxInvoiceCycle_ID == 0)
        {
			setLastDayofMonth (false);
// N
			setName (null);
			setTF_TaxInvoiceCycle_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TaxInvoiceCycle (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client 
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
      StringBuffer sb = new StringBuffer ("X_TF_TaxInvoiceCycle[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set Invoice Day.
		@param InvoiceDay 
		Day of Invoice Generation
	  */
	public void setInvoiceDay (int InvoiceDay)
	{
		set_Value (COLUMNNAME_InvoiceDay, Integer.valueOf(InvoiceDay));
	}

	/** Get Invoice Day.
		@return Day of Invoice Generation
	  */
	public int getInvoiceDay () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_InvoiceDay);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set 2nd Invoice Day of the month.
		@param InvoiceDay2 2nd Invoice Day of the month	  */
	public void setInvoiceDay2 (int InvoiceDay2)
	{
		set_Value (COLUMNNAME_InvoiceDay2, Integer.valueOf(InvoiceDay2));
	}

	/** Get 2nd Invoice Day of the month.
		@return 2nd Invoice Day of the month	  */
	public int getInvoiceDay2 () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_InvoiceDay2);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set 3rd Invoice Day of the month.
		@param InvoiceDay3 3rd Invoice Day of the month	  */
	public void setInvoiceDay3 (int InvoiceDay3)
	{
		set_Value (COLUMNNAME_InvoiceDay3, Integer.valueOf(InvoiceDay3));
	}

	/** Get 3rd Invoice Day of the month.
		@return 3rd Invoice Day of the month	  */
	public int getInvoiceDay3 () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_InvoiceDay3);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Invoice on last day of the month.
		@param LastDayofMonth Invoice on last day of the month	  */
	public void setLastDayofMonth (boolean LastDayofMonth)
	{
		set_Value (COLUMNNAME_LastDayofMonth, Boolean.valueOf(LastDayofMonth));
	}

	/** Get Invoice on last day of the month.
		@return Invoice on last day of the month	  */
	public boolean isLastDayofMonth () 
	{
		Object oo = get_Value(COLUMNNAME_LastDayofMonth);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Tax Invoice Cycle.
		@param TF_TaxInvoiceCycle_ID Tax Invoice Cycle	  */
	public void setTF_TaxInvoiceCycle_ID (int TF_TaxInvoiceCycle_ID)
	{
		if (TF_TaxInvoiceCycle_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TaxInvoiceCycle_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TaxInvoiceCycle_ID, Integer.valueOf(TF_TaxInvoiceCycle_ID));
	}

	/** Get Tax Invoice Cycle.
		@return Tax Invoice Cycle	  */
	public int getTF_TaxInvoiceCycle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TaxInvoiceCycle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TaxInvoiceCycle_UU.
		@param TF_TaxInvoiceCycle_UU TF_TaxInvoiceCycle_UU	  */
	public void setTF_TaxInvoiceCycle_UU (String TF_TaxInvoiceCycle_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TaxInvoiceCycle_UU, TF_TaxInvoiceCycle_UU);
	}

	/** Get TF_TaxInvoiceCycle_UU.
		@return TF_TaxInvoiceCycle_UU	  */
	public String getTF_TaxInvoiceCycle_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TaxInvoiceCycle_UU);
	}
}