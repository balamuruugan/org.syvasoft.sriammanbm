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

/** Generated Model for TF_TyreLife
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_TyreLife extends PO implements I_TF_TyreLife, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190307L;

    /** Standard Constructor */
    public X_TF_TyreLife (Properties ctx, int TF_TyreLife_ID, String trxName)
    {
      super (ctx, TF_TyreLife_ID, trxName);
      /** if (TF_TyreLife_ID == 0)
        {
			setOpening_Meter (Env.ZERO);
// 0
			setSeqNo (0);
			setTF_Tyre_ID (0);
			setTF_TyreLife_ID (0);
			setTF_TyreType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TyreLife (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TyreLife[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Actual Running Meter.
		@param ActRunning_Meter Actual Running Meter	  */
	public void setActRunning_Meter (BigDecimal ActRunning_Meter)
	{
		set_Value (COLUMNNAME_ActRunning_Meter, ActRunning_Meter);
	}

	/** Get Actual Running Meter.
		@return Actual Running Meter	  */
	public BigDecimal getActRunning_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ActRunning_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Estimated Running Meter.
		@param EstRunning_Meter Estimated Running Meter	  */
	public void setEstRunning_Meter (BigDecimal EstRunning_Meter)
	{
		set_Value (COLUMNNAME_EstRunning_Meter, EstRunning_Meter);
	}

	/** Get Estimated Running Meter.
		@return Estimated Running Meter	  */
	public BigDecimal getEstRunning_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_EstRunning_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Expiry Date.
		@param ExpiryDate Expiry Date	  */
	public void setExpiryDate (Timestamp ExpiryDate)
	{
		set_Value (COLUMNNAME_ExpiryDate, ExpiryDate);
	}

	/** Get Expiry Date.
		@return Expiry Date	  */
	public Timestamp getExpiryDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ExpiryDate);
	}

	/** Set Opening Meter.
		@param Opening_Meter Opening Meter	  */
	public void setOpening_Meter (BigDecimal Opening_Meter)
	{
		set_Value (COLUMNNAME_Opening_Meter, Opening_Meter);
	}

	/** Get Opening Meter.
		@return Opening Meter	  */
	public BigDecimal getOpening_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Opening_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Opening Date.
		@param OpeningDate Opening Date	  */
	public void setOpeningDate (Timestamp OpeningDate)
	{
		set_Value (COLUMNNAME_OpeningDate, OpeningDate);
	}

	/** Get Opening Date.
		@return Opening Date	  */
	public Timestamp getOpeningDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_OpeningDate);
	}

	/** Set Sequence.
		@param SeqNo 
		Method of ordering records; lowest number comes first
	  */
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_ID, Integer.valueOf(TF_Tyre_ID));
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

	/** Set Tyre Life.
		@param TF_TyreLife_ID Tyre Life	  */
	public void setTF_TyreLife_ID (int TF_TyreLife_ID)
	{
		if (TF_TyreLife_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreLife_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreLife_ID, Integer.valueOf(TF_TyreLife_ID));
	}

	/** Get Tyre Life.
		@return Tyre Life	  */
	public int getTF_TyreLife_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreLife_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TyreLife_UU.
		@param TF_TyreLife_UU TF_TyreLife_UU	  */
	public void setTF_TyreLife_UU (String TF_TyreLife_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TyreLife_UU, TF_TyreLife_UU);
	}

	/** Get TF_TyreLife_UU.
		@return TF_TyreLife_UU	  */
	public String getTF_TyreLife_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TyreLife_UU);
	}

	public I_TF_TyrePurchase getTF_TyrePurchase() throws RuntimeException
    {
		return (I_TF_TyrePurchase)MTable.get(getCtx(), I_TF_TyrePurchase.Table_Name)
			.getPO(getTF_TyrePurchase_ID(), get_TrxName());	}

	/** Set Tyre Purchase.
		@param TF_TyrePurchase_ID Tyre Purchase	  */
	public void setTF_TyrePurchase_ID (int TF_TyrePurchase_ID)
	{
		if (TF_TyrePurchase_ID < 1) 
			set_Value (COLUMNNAME_TF_TyrePurchase_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TyrePurchase_ID, Integer.valueOf(TF_TyrePurchase_ID));
	}

	/** Get Tyre Purchase.
		@return Tyre Purchase	  */
	public int getTF_TyrePurchase_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyrePurchase_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyrePurchaseLine getTF_TyrePurchaseLine() throws RuntimeException
    {
		return (I_TF_TyrePurchaseLine)MTable.get(getCtx(), I_TF_TyrePurchaseLine.Table_Name)
			.getPO(getTF_TyrePurchaseLine_ID(), get_TrxName());	}

	/** Set Tyre Purchase Line.
		@param TF_TyrePurchaseLine_ID Tyre Purchase Line	  */
	public void setTF_TyrePurchaseLine_ID (int TF_TyrePurchaseLine_ID)
	{
		if (TF_TyrePurchaseLine_ID < 1) 
			set_Value (COLUMNNAME_TF_TyrePurchaseLine_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TyrePurchaseLine_ID, Integer.valueOf(TF_TyrePurchaseLine_ID));
	}

	/** Get Tyre Purchase Line.
		@return Tyre Purchase Line	  */
	public int getTF_TyrePurchaseLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyrePurchaseLine_ID);
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
			set_ValueNoCheck (COLUMNNAME_TF_TyreType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreType_ID, Integer.valueOf(TF_TyreType_ID));
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

	/** Set Tyre Cost.
		@param TyreCost Tyre Cost	  */
	public void setTyreCost (BigDecimal TyreCost)
	{
		set_Value (COLUMNNAME_TyreCost, TyreCost);
	}

	/** Get Tyre Cost.
		@return Tyre Cost	  */
	public BigDecimal getTyreCost () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TyreCost);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}