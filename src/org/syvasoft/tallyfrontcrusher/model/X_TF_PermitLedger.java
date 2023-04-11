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
import org.compiere.util.KeyNamePair;

/** Generated Model for TF_PermitLedger
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_PermitLedger extends PO implements I_TF_PermitLedger, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180110L;

    /** Standard Constructor */
    public X_TF_PermitLedger (Properties ctx, int TF_PermitLedger_ID, String trxName)
    {
      super (ctx, TF_PermitLedger_ID, trxName);
      /** if (TF_PermitLedger_ID == 0)
        {
			setC_Order_ID (0);
			setC_OrderLine_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
			setM_Product_ID (0);
			setTF_PermitLedger_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_PermitLedger (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_PermitLedger[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException
    {
		return (org.compiere.model.I_C_Order)MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
			.getPO(getC_Order_ID(), get_TrxName());	}

	/** Set Order.
		@param C_Order_ID 
		Order
	  */
	public void setC_Order_ID (int C_Order_ID)
	{
		if (C_Order_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Order_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
	}

	/** Get Order.
		@return Order
	  */
	public int getC_Order_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException
    {
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
			.getPO(getC_OrderLine_ID(), get_TrxName());	}

	/** Set Sales Order Line.
		@param C_OrderLine_ID 
		Sales Order Line
	  */
	public void setC_OrderLine_ID (int C_OrderLine_ID)
	{
		if (C_OrderLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_OrderLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_OrderLine_ID, Integer.valueOf(C_OrderLine_ID));
	}

	/** Get Sales Order Line.
		@return Sales Order Line
	  */
	public int getC_OrderLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_OrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getM_Product_ID()));
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

	/** Set Permit Ledger.
		@param TF_PermitLedger_ID Permit Ledger	  */
	public void setTF_PermitLedger_ID (int TF_PermitLedger_ID)
	{
		if (TF_PermitLedger_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_PermitLedger_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_PermitLedger_ID, Integer.valueOf(TF_PermitLedger_ID));
	}

	/** Get Permit Ledger.
		@return Permit Ledger	  */
	public int getTF_PermitLedger_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_PermitLedger_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_PermitLedger_UU.
		@param TF_PermitLedger_UU TF_PermitLedger_UU	  */
	public void setTF_PermitLedger_UU (String TF_PermitLedger_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_PermitLedger_UU, TF_PermitLedger_UU);
	}

	/** Get TF_PermitLedger_UU.
		@return TF_PermitLedger_UU	  */
	public String getTF_PermitLedger_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_PermitLedger_UU);
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