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

/** Generated Model for TF_CrusherPermitLedgerLine
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_CrusherPermitLedgerLine extends PO implements I_TF_CrusherPermitLedgerLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180331L;

    /** Standard Constructor */
    public X_TF_CrusherPermitLedgerLine (Properties ctx, int TF_CrusherPermitLedgerLine_ID, String trxName)
    {
      super (ctx, TF_CrusherPermitLedgerLine_ID, trxName);
      /** if (TF_CrusherPermitLedgerLine_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
			setM_Product_ID (0);
			setTF_CrusherPermitLedger_ID (0);
			setTF_CrusherPermitLedgerLine_ID (0);
			setTF_TaxInvoice_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_CrusherPermitLedgerLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_CrusherPermitLedgerLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Account Date.
		@param DateAcct 
		Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct)
	{
		set_ValueNoCheck (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
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

	/** Set Quantity Issued.
		@param QtyIssued Quantity Issued	  */
	public void setQtyIssued (BigDecimal QtyIssued)
	{
		set_Value (COLUMNNAME_QtyIssued, QtyIssued);
	}

	/** Get Quantity Issued.
		@return Quantity Issued	  */
	public BigDecimal getQtyIssued () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyIssued);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_CrusherPermitLedger getTF_CrusherPermitLedger() throws RuntimeException
    {
		return (I_TF_CrusherPermitLedger)MTable.get(getCtx(), I_TF_CrusherPermitLedger.Table_Name)
			.getPO(getTF_CrusherPermitLedger_ID(), get_TrxName());	}

	/** Set Crusher Permit Ledger.
		@param TF_CrusherPermitLedger_ID Crusher Permit Ledger	  */
	public void setTF_CrusherPermitLedger_ID (int TF_CrusherPermitLedger_ID)
	{
		if (TF_CrusherPermitLedger_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherPermitLedger_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherPermitLedger_ID, Integer.valueOf(TF_CrusherPermitLedger_ID));
	}

	/** Get Crusher Permit Ledger.
		@return Crusher Permit Ledger	  */
	public int getTF_CrusherPermitLedger_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CrusherPermitLedger_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Crusher Permit Ledger Line.
		@param TF_CrusherPermitLedgerLine_ID Crusher Permit Ledger Line	  */
	public void setTF_CrusherPermitLedgerLine_ID (int TF_CrusherPermitLedgerLine_ID)
	{
		if (TF_CrusherPermitLedgerLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherPermitLedgerLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherPermitLedgerLine_ID, Integer.valueOf(TF_CrusherPermitLedgerLine_ID));
	}

	/** Get Crusher Permit Ledger Line.
		@return Crusher Permit Ledger Line	  */
	public int getTF_CrusherPermitLedgerLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CrusherPermitLedgerLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_CrusherPermitLedgerLine_UU.
		@param TF_CrusherPermitLedgerLine_UU TF_CrusherPermitLedgerLine_UU	  */
	public void setTF_CrusherPermitLedgerLine_UU (String TF_CrusherPermitLedgerLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_CrusherPermitLedgerLine_UU, TF_CrusherPermitLedgerLine_UU);
	}

	/** Get TF_CrusherPermitLedgerLine_UU.
		@return TF_CrusherPermitLedgerLine_UU	  */
	public String getTF_CrusherPermitLedgerLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_CrusherPermitLedgerLine_UU);
	}

	public I_TF_TaxInvoice getTF_TaxInvoice() throws RuntimeException
    {
		return (I_TF_TaxInvoice)MTable.get(getCtx(), I_TF_TaxInvoice.Table_Name)
			.getPO(getTF_TaxInvoice_ID(), get_TrxName());	}

	/** Set Tax Invoice.
		@param TF_TaxInvoice_ID Tax Invoice	  */
	public void setTF_TaxInvoice_ID (int TF_TaxInvoice_ID)
	{
		if (TF_TaxInvoice_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TaxInvoice_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TaxInvoice_ID, Integer.valueOf(TF_TaxInvoice_ID));
	}

	/** Get Tax Invoice.
		@return Tax Invoice	  */
	public int getTF_TaxInvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TaxInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Unit Price.
		@param UnitPrice Unit Price	  */
	public void setUnitPrice (BigDecimal UnitPrice)
	{
		set_Value (COLUMNNAME_UnitPrice, UnitPrice);
	}

	/** Get Unit Price.
		@return Unit Price	  */
	public BigDecimal getUnitPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_UnitPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}