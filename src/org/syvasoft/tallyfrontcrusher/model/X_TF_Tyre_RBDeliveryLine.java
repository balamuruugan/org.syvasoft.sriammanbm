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

/** Generated Model for TF_Tyre_RBDeliveryLine
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_Tyre_RBDeliveryLine extends PO implements I_TF_Tyre_RBDeliveryLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190214L;

    /** Standard Constructor */
    public X_TF_Tyre_RBDeliveryLine (Properties ctx, int TF_Tyre_RBDeliveryLine_ID, String trxName)
    {
      super (ctx, TF_Tyre_RBDeliveryLine_ID, trxName);
      /** if (TF_Tyre_RBDeliveryLine_ID == 0)
        {
			setisReceived (false);
// N
			setLineNo (0);
// @SQL=SELECT COALESCE(MAX(LineNo),0) + 10 DefaultValue FROM TF_Tyre_RBDeliveryLine WHERE TF_Tyre_RBDelivery_ID=@TF_Tyre_RBDelivery_ID@
			setProcessed (false);
// N
			setTF_Tyre_ID (0);
			setTF_Tyre_RBDelivery_ID (0);
			setTF_Tyre_RBDeliveryLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Tyre_RBDeliveryLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Tyre_RBDeliveryLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Brand.
		@param Brand Brand	  */
	public void setBrand (String Brand)
	{
		set_Value (COLUMNNAME_Brand, Brand);
	}

	/** Get Brand.
		@return Brand	  */
	public String getBrand () 
	{
		return (String)get_Value(COLUMNNAME_Brand);
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

	/** Set Received.
		@param isReceived Received	  */
	public void setisReceived (boolean isReceived)
	{
		set_Value (COLUMNNAME_isReceived, Boolean.valueOf(isReceived));
	}

	/** Get Received.
		@return Received	  */
	public boolean isReceived () 
	{
		Object oo = get_Value(COLUMNNAME_isReceived);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Line.
		@param LineNo 
		Line No
	  */
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
		@return Line No
	  */
	public int getLineNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyreType getNew_TF_TyreType() throws RuntimeException
    {
		return (I_TF_TyreType)MTable.get(getCtx(), I_TF_TyreType.Table_Name)
			.getPO(getNew_TF_TyreType_ID(), get_TrxName());	}

	/** Set New Tyre Type.
		@param New_TF_TyreType_ID New Tyre Type	  */
	public void setNew_TF_TyreType_ID (int New_TF_TyreType_ID)
	{
		if (New_TF_TyreType_ID < 1) 
			set_Value (COLUMNNAME_New_TF_TyreType_ID, null);
		else 
			set_Value (COLUMNNAME_New_TF_TyreType_ID, Integer.valueOf(New_TF_TyreType_ID));
	}

	/** Get New Tyre Type.
		@return New Tyre Type	  */
	public int getNew_TF_TyreType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_New_TF_TyreType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Size.
		@param Size Size	  */
	public void setSize (String Size)
	{
		set_Value (COLUMNNAME_Size, Size);
	}

	/** Get Size.
		@return Size	  */
	public String getSize () 
	{
		return (String)get_Value(COLUMNNAME_Size);
	}

	public I_TF_Tyre getTF_Tyre() throws RuntimeException
    {
		return (I_TF_Tyre)MTable.get(getCtx(), I_TF_Tyre.Table_Name)
			.getPO(getTF_Tyre_ID(), get_TrxName());	}

	/** Set Tyre.
		@param TF_Tyre_ID Tyre	  */
	public void setTF_Tyre_ID (int TF_Tyre_ID)
	{
		if (TF_Tyre_ID < 1) 
			set_Value (COLUMNNAME_TF_Tyre_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Tyre_ID, Integer.valueOf(TF_Tyre_ID));
	}

	/** Get Tyre.
		@return Tyre	  */
	public int getTF_Tyre_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Tyre_RBDelivery getTF_Tyre_RBDelivery() throws RuntimeException
    {
		return (I_TF_Tyre_RBDelivery)MTable.get(getCtx(), I_TF_Tyre_RBDelivery.Table_Name)
			.getPO(getTF_Tyre_RBDelivery_ID(), get_TrxName());	}

	/** Set Tyre Rebutton Delivery.
		@param TF_Tyre_RBDelivery_ID Tyre Rebutton Delivery	  */
	public void setTF_Tyre_RBDelivery_ID (int TF_Tyre_RBDelivery_ID)
	{
		if (TF_Tyre_RBDelivery_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBDelivery_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBDelivery_ID, Integer.valueOf(TF_Tyre_RBDelivery_ID));
	}

	/** Get Tyre Rebutton Delivery.
		@return Tyre Rebutton Delivery	  */
	public int getTF_Tyre_RBDelivery_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_RBDelivery_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Rebutton Tyres.
		@param TF_Tyre_RBDeliveryLine_ID Rebutton Tyres	  */
	public void setTF_Tyre_RBDeliveryLine_ID (int TF_Tyre_RBDeliveryLine_ID)
	{
		if (TF_Tyre_RBDeliveryLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBDeliveryLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBDeliveryLine_ID, Integer.valueOf(TF_Tyre_RBDeliveryLine_ID));
	}

	/** Get Rebutton Tyres.
		@return Rebutton Tyres	  */
	public int getTF_Tyre_RBDeliveryLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_RBDeliveryLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Tyre_RBDeliveryLine_UU.
		@param TF_Tyre_RBDeliveryLine_UU TF_Tyre_RBDeliveryLine_UU	  */
	public void setTF_Tyre_RBDeliveryLine_UU (String TF_Tyre_RBDeliveryLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBDeliveryLine_UU, TF_Tyre_RBDeliveryLine_UU);
	}

	/** Get TF_Tyre_RBDeliveryLine_UU.
		@return TF_Tyre_RBDeliveryLine_UU	  */
	public String getTF_Tyre_RBDeliveryLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Tyre_RBDeliveryLine_UU);
	}

	public I_TF_Tyre_RBReceiptLine getTF_Tyre_RBReceiptLine() throws RuntimeException
    {
		return (I_TF_Tyre_RBReceiptLine)MTable.get(getCtx(), I_TF_Tyre_RBReceiptLine.Table_Name)
			.getPO(getTF_Tyre_RBReceiptLine_ID(), get_TrxName());	}

	/** Set Received Rebutton Tyre.
		@param TF_Tyre_RBReceiptLine_ID Received Rebutton Tyre	  */
	public void setTF_Tyre_RBReceiptLine_ID (int TF_Tyre_RBReceiptLine_ID)
	{
		if (TF_Tyre_RBReceiptLine_ID < 1) 
			set_Value (COLUMNNAME_TF_Tyre_RBReceiptLine_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Tyre_RBReceiptLine_ID, Integer.valueOf(TF_Tyre_RBReceiptLine_ID));
	}

	/** Get Received Rebutton Tyre.
		@return Received Rebutton Tyre	  */
	public int getTF_Tyre_RBReceiptLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_RBReceiptLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyreType getTF_TyreType() throws RuntimeException
    {
		return (I_TF_TyreType)MTable.get(getCtx(), I_TF_TyreType.Table_Name)
			.getPO(getTF_TyreType_ID(), get_TrxName());	}

	/** Set Tyre Type.
		@param TF_TyreType_ID Tyre Type	  */
	public void setTF_TyreType_ID (int TF_TyreType_ID)
	{
		if (TF_TyreType_ID < 1) 
			set_Value (COLUMNNAME_TF_TyreType_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TyreType_ID, Integer.valueOf(TF_TyreType_ID));
	}

	/** Get Tyre Type.
		@return Tyre Type	  */
	public int getTF_TyreType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}