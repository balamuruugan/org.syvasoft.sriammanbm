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

/** Generated Model for TF_CrusherPermitLedger
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_CrusherPermitLedger extends PO implements I_TF_CrusherPermitLedger, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180331L;

    /** Standard Constructor */
    public X_TF_CrusherPermitLedger (Properties ctx, int TF_CrusherPermitLedger_ID, String trxName)
    {
      super (ctx, TF_CrusherPermitLedger_ID, trxName);
      /** if (TF_CrusherPermitLedger_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
			setTF_CrusherPermitLedger_ID (0);
			setTF_PermitPurchase_ID (0);
			setTF_Quarry_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_CrusherPermitLedger (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_CrusherPermitLedger[")
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

	/** Set Purchased Amount.
		@param PurchasedAmt Purchased Amount	  */
	public void setPurchasedAmt (BigDecimal PurchasedAmt)
	{
		set_Value (COLUMNNAME_PurchasedAmt, PurchasedAmt);
	}

	/** Get Purchased Amount.
		@return Purchased Amount	  */
	public BigDecimal getPurchasedAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PurchasedAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Qty Purchased.
		@param QtyPurchased Qty Purchased	  */
	public void setQtyPurchased (BigDecimal QtyPurchased)
	{
		set_Value (COLUMNNAME_QtyPurchased, QtyPurchased);
	}

	/** Get Qty Purchased.
		@return Qty Purchased	  */
	public BigDecimal getQtyPurchased () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyPurchased);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

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

	/** Set TF_CrusherPermitLedger_UU.
		@param TF_CrusherPermitLedger_UU TF_CrusherPermitLedger_UU	  */
	public void setTF_CrusherPermitLedger_UU (String TF_CrusherPermitLedger_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_CrusherPermitLedger_UU, TF_CrusherPermitLedger_UU);
	}

	/** Get TF_CrusherPermitLedger_UU.
		@return TF_CrusherPermitLedger_UU	  */
	public String getTF_CrusherPermitLedger_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_CrusherPermitLedger_UU);
	}

	public I_TF_PermitPurchase getTF_PermitPurchase() throws RuntimeException
    {
		return (I_TF_PermitPurchase)MTable.get(getCtx(), I_TF_PermitPurchase.Table_Name)
			.getPO(getTF_PermitPurchase_ID(), get_TrxName());	}

	/** Set Permit Purchase Entry.
		@param TF_PermitPurchase_ID Permit Purchase Entry	  */
	public void setTF_PermitPurchase_ID (int TF_PermitPurchase_ID)
	{
		if (TF_PermitPurchase_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_PermitPurchase_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_PermitPurchase_ID, Integer.valueOf(TF_PermitPurchase_ID));
	}

	/** Get Permit Purchase Entry.
		@return Permit Purchase Entry	  */
	public int getTF_PermitPurchase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_PermitPurchase_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_PermitPurchaseLine getTF_PermitPurchaseLine() throws RuntimeException
    {
		return (I_TF_PermitPurchaseLine)MTable.get(getCtx(), I_TF_PermitPurchaseLine.Table_Name)
			.getPO(getTF_PermitPurchaseLine_ID(), get_TrxName());	}

	/** Set Permit Purchase Line.
		@param TF_PermitPurchaseLine_ID Permit Purchase Line	  */
	public void setTF_PermitPurchaseLine_ID (int TF_PermitPurchaseLine_ID)
	{
		if (TF_PermitPurchaseLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_PermitPurchaseLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_PermitPurchaseLine_ID, Integer.valueOf(TF_PermitPurchaseLine_ID));
	}

	/** Get Permit Purchase Line.
		@return Permit Purchase Line	  */
	public int getTF_PermitPurchaseLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_PermitPurchaseLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Quarry getTF_Quarry() throws RuntimeException
    {
		return (I_TF_Quarry)MTable.get(getCtx(), I_TF_Quarry.Table_Name)
			.getPO(getTF_Quarry_ID(), get_TrxName());	}

	/** Set Quarry.
		@param TF_Quarry_ID Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID)
	{
		if (TF_Quarry_ID < 1) 
			set_Value (COLUMNNAME_TF_Quarry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Quarry_ID, Integer.valueOf(TF_Quarry_ID));
	}

	/** Get Quarry.
		@return Quarry	  */
	public int getTF_Quarry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Quarry_ID);
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