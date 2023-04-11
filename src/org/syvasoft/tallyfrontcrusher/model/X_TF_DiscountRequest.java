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

/** Generated Model for TF_DiscountRequest
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_DiscountRequest extends PO implements I_TF_DiscountRequest, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200229L;

    /** Standard Constructor */
    public X_TF_DiscountRequest (Properties ctx, int TF_DiscountRequest_ID, String trxName)
    {
      super (ctx, TF_DiscountRequest_ID, trxName);
      /** if (TF_DiscountRequest_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_Order_ID (0);
			setC_UOM_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
			setDocumentNo (null);
			setIsRentInclusive (false);
// N
			setM_Product_ID (0);
			setPartyName (null);
			setProcessed (false);
			setTF_Destination_ID (0);
			setTF_DiscountRequest_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_DiscountRequest (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_DiscountRequest[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Approved Price.
		@param ApprovedPrice Approved Price	  */
	public void setApprovedPrice (BigDecimal ApprovedPrice)
	{
		set_Value (COLUMNNAME_ApprovedPrice, ApprovedPrice);
	}

	/** Get Approved Price.
		@return Approved Price	  */
	public BigDecimal getApprovedPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ApprovedPrice);
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

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getC_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param C_UOM_ID 
		Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID)
	{
		if (C_UOM_ID < 1) 
			set_Value (COLUMNNAME_C_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
	}

	/** Get UOM.
		@return Unit of Measure
	  */
	public int getC_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
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

	/** Requested = RQ */
	public static final String DISCNTSTATUS_Requested = "RQ";
	/** Approved = AP */
	public static final String DISCNTSTATUS_Approved = "AP";
	/** Closed = CL */
	public static final String DISCNTSTATUS_Closed = "CL";
	/** Voided = VO */
	public static final String DISCNTSTATUS_Voided = "VO";
	/** Set Discount Status.
		@param DiscntStatus Discount Status	  */
	public void setDiscntStatus (String DiscntStatus)
	{

		set_Value (COLUMNNAME_DiscntStatus, DiscntStatus);
	}

	/** Get Discount Status.
		@return Discount Status	  */
	public String getDiscntStatus () 
	{
		return (String)get_Value(COLUMNNAME_DiscntStatus);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Rent Inclusive.
		@param IsRentInclusive 
		Whether Unit Price includes rent?
	  */
	public void setIsRentInclusive (boolean IsRentInclusive)
	{
		set_Value (COLUMNNAME_IsRentInclusive, Boolean.valueOf(IsRentInclusive));
	}

	/** Get Rent Inclusive.
		@return Whether Unit Price includes rent?
	  */
	public boolean isRentInclusive () 
	{
		Object oo = get_Value(COLUMNNAME_IsRentInclusive);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Requested Price.
		@param ReqPrice Requested Price	  */
	public void setReqPrice (BigDecimal ReqPrice)
	{
		set_Value (COLUMNNAME_ReqPrice, ReqPrice);
	}

	/** Get Requested Price.
		@return Requested Price	  */
	public BigDecimal getReqPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ReqPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Standard Price.
		@param StdPrice Standard Price	  */
	public void setStdPrice (BigDecimal StdPrice)
	{
		set_Value (COLUMNNAME_StdPrice, StdPrice);
	}

	/** Get Standard Price.
		@return Standard Price	  */
	public BigDecimal getStdPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_StdPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_Destination getTF_Destination() throws RuntimeException
    {
		return (I_TF_Destination)MTable.get(getCtx(), I_TF_Destination.Table_Name)
			.getPO(getTF_Destination_ID(), get_TrxName());	}

	/** Set Destination.
		@param TF_Destination_ID Destination	  */
	public void setTF_Destination_ID (int TF_Destination_ID)
	{
		if (TF_Destination_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Destination_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Destination_ID, Integer.valueOf(TF_Destination_ID));
	}

	/** Get Destination.
		@return Destination	  */
	public int getTF_Destination_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Destination_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Discount Request.
		@param TF_DiscountRequest_ID Discount Request	  */
	public void setTF_DiscountRequest_ID (int TF_DiscountRequest_ID)
	{
		if (TF_DiscountRequest_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_DiscountRequest_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_DiscountRequest_ID, Integer.valueOf(TF_DiscountRequest_ID));
	}

	/** Get Discount Request.
		@return Discount Request	  */
	public int getTF_DiscountRequest_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_DiscountRequest_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_DiscountRequest_UU.
		@param TF_DiscountRequest_UU TF_DiscountRequest_UU	  */
	public void setTF_DiscountRequest_UU (String TF_DiscountRequest_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_DiscountRequest_UU, TF_DiscountRequest_UU);
	}

	/** Get TF_DiscountRequest_UU.
		@return TF_DiscountRequest_UU	  */
	public String getTF_DiscountRequest_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_DiscountRequest_UU);
	}
}