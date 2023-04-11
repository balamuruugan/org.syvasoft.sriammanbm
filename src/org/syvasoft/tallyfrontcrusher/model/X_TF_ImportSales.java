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

/** Generated Model for TF_ImportSales
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_ImportSales extends PO implements I_TF_ImportSales, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200620L;

    /** Standard Constructor */
    public X_TF_ImportSales (Properties ctx, int TF_ImportSales_ID, String trxName)
    {
      super (ctx, TF_ImportSales_ID, trxName);
      /** if (TF_ImportSales_ID == 0)
        {
			setMaterial (null);
			setPartyName (null);
			setPrice (Env.ZERO);
			setProcessed (false);
// N
			setQty (Env.ZERO);
			setSNo (0);
			setTF_ImportSales_ID (0);
			setVNo (null);
			setWeighmentNo (null);
        } */
    }

    /** Load Constructor */
    public X_TF_ImportSales (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
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
      StringBuffer sb = new StringBuffer ("X_TF_ImportSales[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Amount.
		@param Amount 
		Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount)
	{
		set_ValueNoCheck (COLUMNNAME_Amount, Amount);
	}

	/** Get Amount.
		@return Amount in a defined currency
	  */
	public BigDecimal getAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Amount Received.
		@param AmountRec Amount Received	  */
	public void setAmountRec (int AmountRec)
	{
		set_Value (COLUMNNAME_AmountRec, Integer.valueOf(AmountRec));
	}

	/** Get Amount Received.
		@return Amount Received	  */
	public int getAmountRec () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AmountRec);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Bank Memo No.
		@param BankMemoNo Bank Memo No	  */
	public void setBankMemoNo (String BankMemoNo)
	{
		set_Value (COLUMNNAME_BankMemoNo, BankMemoNo);
	}

	/** Get Bank Memo No.
		@return Bank Memo No	  */
	public String getBankMemoNo () 
	{
		return (String)get_Value(COLUMNNAME_BankMemoNo);
	}

	/** Set Bill.
		@param Bill Bill	  */
	public void setBill (String Bill)
	{
		set_Value (COLUMNNAME_Bill, Bill);
	}

	/** Get Bill.
		@return Bill	  */
	public String getBill () 
	{
		return (String)get_Value(COLUMNNAME_Bill);
	}

	/** Set Bill No.
		@param BillNo Bill No	  */
	public void setBillNo (String BillNo)
	{
		set_Value (COLUMNNAME_BillNo, BillNo);
	}

	/** Get Bill No.
		@return Bill No	  */
	public String getBillNo () 
	{
		return (String)get_Value(COLUMNNAME_BillNo);
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
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
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

	public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getC_Tax_ID(), get_TrxName());	}

	/** Set Tax.
		@param C_Tax_ID 
		Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID)
	{
		if (C_Tax_ID < 1) 
			set_Value (COLUMNNAME_C_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
	}

	/** Get Tax.
		@return Tax identifier
	  */
	public int getC_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Cash Memo No.
		@param CashMemoNo Cash Memo No	  */
	public void setCashMemoNo (String CashMemoNo)
	{
		set_Value (COLUMNNAME_CashMemoNo, CashMemoNo);
	}

	/** Get Cash Memo No.
		@return Cash Memo No	  */
	public String getCashMemoNo () 
	{
		return (String)get_Value(COLUMNNAME_CashMemoNo);
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

	/** Set DB.
		@param DB DB	  */
	public void setDB (String DB)
	{
		set_Value (COLUMNNAME_DB, DB);
	}

	/** Get DB.
		@return DB	  */
	public String getDB () 
	{
		return (String)get_Value(COLUMNNAME_DB);
	}

	/** Set DC No.
		@param DCNo DC No	  */
	public void setDCNo (String DCNo)
	{
		set_Value (COLUMNNAME_DCNo, DCNo);
	}

	/** Get DC No.
		@return DC No	  */
	public String getDCNo () 
	{
		return (String)get_Value(COLUMNNAME_DCNo);
	}

	/** Set GP No.
		@param GPNo GP No	  */
	public void setGPNo (String GPNo)
	{
		set_Value (COLUMNNAME_GPNo, GPNo);
	}

	/** Get GP No.
		@return GP No	  */
	public String getGPNo () 
	{
		return (String)get_Value(COLUMNNAME_GPNo);
	}

	/** Set Imported.
		@param Imported Imported	  */
	public void setImported (String Imported)
	{
		set_Value (COLUMNNAME_Imported, Imported);
	}

	/** Get Imported.
		@return Imported	  */
	public String getImported () 
	{
		return (String)get_Value(COLUMNNAME_Imported);
	}

	/** Set Import Message.
		@param ImportMessage Import Message	  */
	public void setImportMessage (String ImportMessage)
	{
		set_Value (COLUMNNAME_ImportMessage, ImportMessage);
	}

	/** Get Import Message.
		@return Import Message	  */
	public String getImportMessage () 
	{
		return (String)get_Value(COLUMNNAME_ImportMessage);
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

	/** Set Material.
		@param Material Material	  */
	public void setMaterial (String Material)
	{
		set_Value (COLUMNNAME_Material, Material);
	}

	/** Get Material.
		@return Material	  */
	public String getMaterial () 
	{
		return (String)get_Value(COLUMNNAME_Material);
	}

	/** Set Mrs No.
		@param MrsNo Mrs No	  */
	public void setMrsNo (String MrsNo)
	{
		set_Value (COLUMNNAME_MrsNo, MrsNo);
	}

	/** Get Mrs No.
		@return Mrs No	  */
	public String getMrsNo () 
	{
		return (String)get_Value(COLUMNNAME_MrsNo);
	}

	/** Set Net Amount.
		@param NetAmount Net Amount	  */
	public void setNetAmount (BigDecimal NetAmount)
	{
		set_Value (COLUMNNAME_NetAmount, NetAmount);
	}

	/** Get Net Amount.
		@return Net Amount	  */
	public BigDecimal getNetAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NetAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Paid By.
		@param PaidBy Paid By	  */
	public void setPaidBy (String PaidBy)
	{
		set_Value (COLUMNNAME_PaidBy, PaidBy);
	}

	/** Get Paid By.
		@return Paid By	  */
	public String getPaidBy () 
	{
		return (String)get_Value(COLUMNNAME_PaidBy);
	}

	/** Set Party Name.
		@param PartyName Party Name	  */
	public void setPartyName (String PartyName)
	{
		set_Value (COLUMNNAME_PartyName, PartyName);
	}

	/** Get Party Name.
		@return Party Name	  */
	public String getPartyName () 
	{
		return (String)get_Value(COLUMNNAME_PartyName);
	}

	/** Set Price.
		@param Price 
		Price
	  */
	public void setPrice (BigDecimal Price)
	{
		set_Value (COLUMNNAME_Price, Price);
	}

	/** Get Price.
		@return Price
	  */
	public BigDecimal getPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Quantity.
		@param Qty 
		Quantity
	  */
	public void setQty (BigDecimal Qty)
	{
		set_Value (COLUMNNAME_Qty, Qty);
	}

	/** Get Quantity.
		@return Quantity
	  */
	public BigDecimal getQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set S No.
		@param SNo S No	  */
	public void setSNo (int SNo)
	{
		set_Value (COLUMNNAME_SNo, Integer.valueOf(SNo));
	}

	/** Get S No.
		@return S No	  */
	public int getSNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tax.
		@param Tax Tax	  */
	public void setTax (int Tax)
	{
		set_Value (COLUMNNAME_Tax, Integer.valueOf(Tax));
	}

	/** Get Tax.
		@return Tax	  */
	public int getTax () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Tax);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tax Amount.
		@param TaxAmount Tax Amount	  */
	public void setTaxAmount (int TaxAmount)
	{
		set_Value (COLUMNNAME_TaxAmount, Integer.valueOf(TaxAmount));
	}

	/** Get Tax Amount.
		@return Tax Amount	  */
	public int getTaxAmount () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TaxAmount);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Import Sales.
		@param TF_ImportSales_ID Import Sales	  */
	public void setTF_ImportSales_ID (int TF_ImportSales_ID)
	{
		if (TF_ImportSales_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_ImportSales_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_ImportSales_ID, Integer.valueOf(TF_ImportSales_ID));
	}

	/** Get Import Sales.
		@return Import Sales	  */
	public int getTF_ImportSales_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ImportSales_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_ImportSales_UU.
		@param TF_ImportSales_UU TF_ImportSales_UU	  */
	public void setTF_ImportSales_UU (String TF_ImportSales_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_ImportSales_UU, TF_ImportSales_UU);
	}

	/** Get TF_ImportSales_UU.
		@return TF_ImportSales_UU	  */
	public String getTF_ImportSales_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_ImportSales_UU);
	}

	public I_TF_RentedVehicle getTF_RentedVehicle() throws RuntimeException
    {
		return (I_TF_RentedVehicle)MTable.get(getCtx(), I_TF_RentedVehicle.Table_Name)
			.getPO(getTF_RentedVehicle_ID(), get_TrxName());	}

	/** Set Rented Vehicle.
		@param TF_RentedVehicle_ID Rented Vehicle	  */
	public void setTF_RentedVehicle_ID (int TF_RentedVehicle_ID)
	{
		if (TF_RentedVehicle_ID < 1) 
			set_Value (COLUMNNAME_TF_RentedVehicle_ID, null);
		else 
			set_Value (COLUMNNAME_TF_RentedVehicle_ID, Integer.valueOf(TF_RentedVehicle_ID));
	}

	/** Get Rented Vehicle.
		@return Rented Vehicle	  */
	public int getTF_RentedVehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_RentedVehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException
    {
		return (I_TF_WeighmentEntry)MTable.get(getCtx(), I_TF_WeighmentEntry.Table_Name)
			.getPO(getTF_WeighmentEntry_ID(), get_TrxName());	}

	/** Set Weighment Entry.
		@param TF_WeighmentEntry_ID Weighment Entry	  */
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID)
	{
		if (TF_WeighmentEntry_ID < 1) 
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, Integer.valueOf(TF_WeighmentEntry_ID));
	}

	/** Get Weighment Entry.
		@return Weighment Entry	  */
	public int getTF_WeighmentEntry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_WeighmentEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set V No.
		@param VNo V No	  */
	public void setVNo (String VNo)
	{
		set_Value (COLUMNNAME_VNo, VNo);
	}

	/** Get V No.
		@return V No	  */
	public String getVNo () 
	{
		return (String)get_Value(COLUMNNAME_VNo);
	}

	/** Set Weighment No.
		@param WeighmentNo Weighment No	  */
	public void setWeighmentNo (String WeighmentNo)
	{
		set_Value (COLUMNNAME_WeighmentNo, WeighmentNo);
	}

	/** Get Weighment No.
		@return Weighment No	  */
	public String getWeighmentNo () 
	{
		return (String)get_Value(COLUMNNAME_WeighmentNo);
	}
}