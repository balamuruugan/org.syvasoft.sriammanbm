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

/** Generated Model for TF_RMSubcon_Movement
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="TF_RMSubcon_Movement")
public class X_TF_RMSubcon_Movement extends PO implements I_TF_RMSubcon_Movement, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230627L;

    /** Standard Constructor */
    public X_TF_RMSubcon_Movement (Properties ctx, int TF_RMSubcon_Movement_ID, String trxName)
    {
      super (ctx, TF_RMSubcon_Movement_ID, trxName);
      /** if (TF_RMSubcon_Movement_ID == 0)
        {
			setM_Product_ID (0);
			setMovementDate (new Timestamp( System.currentTimeMillis() ));
			setTF_RMSubcon_Movement_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_RMSubcon_Movement (Properties ctx, int TF_RMSubcon_Movement_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_RMSubcon_Movement_ID, trxName, virtualColumns);
      /** if (TF_RMSubcon_Movement_ID == 0)
        {
			setM_Product_ID (0);
			setMovementDate (new Timestamp( System.currentTimeMillis() ));
			setTF_RMSubcon_Movement_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_RMSubcon_Movement (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_TF_RMSubcon_Movement[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
	{
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_ID)
			.getPO(getC_Invoice_ID(), get_TrxName());
	}

	/** Set Invoice.
		@param C_Invoice_ID Invoice Identifier
	*/
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1)
			set_Value (COLUMNNAME_C_Invoice_ID, null);
		else
			set_Value (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException
	{
		return (org.compiere.model.I_C_Order)MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_ID)
			.getPO(getC_Order_ID(), get_TrxName());
	}

	/** Set Order.
		@param C_Order_ID Order
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
	public int getC_Order_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
	{
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_ID)
			.getPO(getC_Project_ID(), get_TrxName());
	}

	/** Set Subcontract / Project.
		@param C_Project_ID Financial Project
	*/
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Subcontract / Project.
		@return Financial Project
	  */
	public int getC_Project_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_ID)
			.getPO(getM_Product_ID(), get_TrxName());
	}

	/** Set Product.
		@param M_Product_ID Product, Service, Item
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
	public int getM_Product_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
	{
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_ID)
			.getPO(getM_Warehouse_ID(), get_TrxName());
	}

	/** Set Warehouse.
		@param M_Warehouse_ID Storage Warehouse and Service Point
	*/
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1)
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Movement Date.
		@param MovementDate Date a product was moved in or out of inventory
	*/
	public void setMovementDate (Timestamp MovementDate)
	{
		set_ValueNoCheck (COLUMNNAME_MovementDate, MovementDate);
	}

	/** Get Movement Date.
		@return Date a product was moved in or out of inventory
	  */
	public Timestamp getMovementDate()
	{
		return (Timestamp)get_Value(COLUMNNAME_MovementDate);
	}

	/** Set Processed.
		@param Processed The document has been processed
	*/
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed()
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
		@param Processing Process Now
	*/
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing()
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

	/** Set Payment Qty.
		@param Qty_Payment Payment Qty
	*/
	public void setQty_Payment (BigDecimal Qty_Payment)
	{
		set_Value (COLUMNNAME_Qty_Payment, Qty_Payment);
	}

	/** Get Payment Qty.
		@return Payment Qty	  */
	public BigDecimal getQty_Payment()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty_Payment);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Receipt Qty.
		@param Qty_Receipt Receipt Qty
	*/
	public void setQty_Receipt (BigDecimal Qty_Receipt)
	{
		set_Value (COLUMNNAME_Qty_Receipt, Qty_Receipt);
	}

	/** Get Receipt Qty.
		@return Receipt Qty	  */
	public BigDecimal getQty_Receipt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Qty_Receipt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_Boulder_Receipt getTF_Boulder_Receipt() throws RuntimeException
	{
		return (I_TF_Boulder_Receipt)MTable.get(getCtx(), I_TF_Boulder_Receipt.Table_ID)
			.getPO(getTF_Boulder_Receipt_ID(), get_TrxName());
	}

	/** Set Boulder Receipt.
		@param TF_Boulder_Receipt_ID Boulder Receipt
	*/
	public void setTF_Boulder_Receipt_ID (int TF_Boulder_Receipt_ID)
	{
		if (TF_Boulder_Receipt_ID < 1)
			set_Value (COLUMNNAME_TF_Boulder_Receipt_ID, null);
		else
			set_Value (COLUMNNAME_TF_Boulder_Receipt_ID, Integer.valueOf(TF_Boulder_Receipt_ID));
	}

	/** Get Boulder Receipt.
		@return Boulder Receipt	  */
	public int getTF_Boulder_Receipt_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Receipt_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Boulder_Wastage getTF_Boulder_Wastage() throws RuntimeException
	{
		return (I_TF_Boulder_Wastage)MTable.get(getCtx(), I_TF_Boulder_Wastage.Table_ID)
			.getPO(getTF_Boulder_Wastage_ID(), get_TrxName());
	}

	/** Set Boulder Wastage.
		@param TF_Boulder_Wastage_ID Boulder Wastage
	*/
	public void setTF_Boulder_Wastage_ID (int TF_Boulder_Wastage_ID)
	{
		if (TF_Boulder_Wastage_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_ID, Integer.valueOf(TF_Boulder_Wastage_ID));
	}

	/** Get Boulder Wastage.
		@return Boulder Wastage	  */
	public int getTF_Boulder_Wastage_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Wastage_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_CrusherKatingEntry getTF_CrusherKatingEntry() throws RuntimeException
	{
		return (I_TF_CrusherKatingEntry)MTable.get(getCtx(), I_TF_CrusherKatingEntry.Table_ID)
			.getPO(getTF_CrusherKatingEntry_ID(), get_TrxName());
	}

	/** Set Crusher Kating Entry.
		@param TF_CrusherKatingEntry_ID Crusher Kating Entry
	*/
	public void setTF_CrusherKatingEntry_ID (int TF_CrusherKatingEntry_ID)
	{
		if (TF_CrusherKatingEntry_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_CrusherKatingEntry_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_CrusherKatingEntry_ID, Integer.valueOf(TF_CrusherKatingEntry_ID));
	}

	/** Get Crusher Kating Entry.
		@return Crusher Kating Entry	  */
	public int getTF_CrusherKatingEntry_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CrusherKatingEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Subcontract Material Movement.
		@param TF_RMSubcon_Movement_ID Subcontract Material Movement
	*/
	public void setTF_RMSubcon_Movement_ID (int TF_RMSubcon_Movement_ID)
	{
		if (TF_RMSubcon_Movement_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_RMSubcon_Movement_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_RMSubcon_Movement_ID, Integer.valueOf(TF_RMSubcon_Movement_ID));
	}

	/** Get Subcontract Material Movement.
		@return Subcontract Material Movement	  */
	public int getTF_RMSubcon_Movement_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_RMSubcon_Movement_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_RMSubcon_Movement_UU.
		@param TF_RMSubcon_Movement_UU TF_RMSubcon_Movement_UU
	*/
	public void setTF_RMSubcon_Movement_UU (String TF_RMSubcon_Movement_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_RMSubcon_Movement_UU, TF_RMSubcon_Movement_UU);
	}

	/** Get TF_RMSubcon_Movement_UU.
		@return TF_RMSubcon_Movement_UU	  */
	public String getTF_RMSubcon_Movement_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_RMSubcon_Movement_UU);
	}

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException
	{
		return (I_TF_WeighmentEntry)MTable.get(getCtx(), I_TF_WeighmentEntry.Table_ID)
			.getPO(getTF_WeighmentEntry_ID(), get_TrxName());
	}

	/** Set Weighment Entry.
		@param TF_WeighmentEntry_ID Weighment Entry
	*/
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID)
	{
		if (TF_WeighmentEntry_ID < 1)
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, null);
		else
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, Integer.valueOf(TF_WeighmentEntry_ID));
	}

	/** Get Weighment Entry.
		@return Weighment Entry	  */
	public int getTF_WeighmentEntry_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_WeighmentEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}