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

/** Generated Model for TF_TripSheet_details
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="TF_TripSheet_details")
public class X_TF_TripSheet_details extends PO implements I_TF_TripSheet_details, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230812L;

    /** Standard Constructor */
    public X_TF_TripSheet_details (Properties ctx, int TF_TripSheet_details_ID, String trxName)
    {
      super (ctx, TF_TripSheet_details_ID, trxName);
      /** if (TF_TripSheet_details_ID == 0)
        {
			setTF_TripSheet_details_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_TripSheet_details (Properties ctx, int TF_TripSheet_details_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_TripSheet_details_ID, trxName, virtualColumns);
      /** if (TF_TripSheet_details_ID == 0)
        {
			setTF_TripSheet_details_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_TripSheet_details (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_TF_TripSheet_details[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Closing Meter.
		@param Closing_Meter Closing Meter
	*/
	public void setClosing_Meter (BigDecimal Closing_Meter)
	{
		set_Value (COLUMNNAME_Closing_Meter, Closing_Meter);
	}

	/** Get Closing Meter.
		@return Closing Meter	  */
	public BigDecimal getClosing_Meter()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Closing_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set End Time.
		@param EndTime End of the time span
	*/
	public void setEndTime (Timestamp EndTime)
	{
		set_Value (COLUMNNAME_EndTime, EndTime);
	}

	/** Get End Time.
		@return End of the time span
	  */
	public Timestamp getEndTime()
	{
		return (Timestamp)get_Value(COLUMNNAME_EndTime);
	}

	/** Set From1.
		@param From1 From1
	*/
	public void setFrom1 (String From1)
	{
		set_Value (COLUMNNAME_From1, From1);
	}

	/** Get From1.
		@return From1	  */
	public String getFrom1()
	{
		return (String)get_Value(COLUMNNAME_From1);
	}

	/** Set Line.
		@param LineNo Line No
	*/
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
		@return Line No
	  */
	public int getLineNo()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
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

	/** Set Opening Meter.
		@param Opening_Meter Opening Meter
	*/
	public void setOpening_Meter (BigDecimal Opening_Meter)
	{
		set_Value (COLUMNNAME_Opening_Meter, Opening_Meter);
	}

	/** Get Opening Meter.
		@return Opening Meter	  */
	public BigDecimal getOpening_Meter()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Opening_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** All Day = A */
	public static final String SHIFT_AllDay = "A";
	/** Day = D */
	public static final String SHIFT_Day = "D";
	/** Full Day = F */
	public static final String SHIFT_FullDay = "F";
	/** Night = N */
	public static final String SHIFT_Night = "N";
	/** Set Shift.
		@param Shift Shift
	*/
	public void setShift (String Shift)
	{

		set_Value (COLUMNNAME_Shift, Shift);
	}

	/** Get Shift.
		@return Shift	  */
	public String getShift()
	{
		return (String)get_Value(COLUMNNAME_Shift);
	}

	/** Set Start Time.
		@param StartTime Time started
	*/
	public void setStartTime (Timestamp StartTime)
	{
		set_Value (COLUMNNAME_StartTime, StartTime);
	}

	/** Get Start Time.
		@return Time started
	  */
	public Timestamp getStartTime()
	{
		return (Timestamp)get_Value(COLUMNNAME_StartTime);
	}

	public I_TF_Destination getTF_Destination() throws RuntimeException
	{
		return (I_TF_Destination)MTable.get(getCtx(), I_TF_Destination.Table_ID)
			.getPO(getTF_Destination_ID(), get_TrxName());
	}

	/** Set Destination.
		@param TF_Destination_ID Destination
	*/
	public void setTF_Destination_ID (int TF_Destination_ID)
	{
		if (TF_Destination_ID < 1)
			set_Value (COLUMNNAME_TF_Destination_ID, null);
		else
			set_Value (COLUMNNAME_TF_Destination_ID, Integer.valueOf(TF_Destination_ID));
	}

	/** Get Destination.
		@return Destination	  */
	public int getTF_Destination_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Destination_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TripSheet_details_ID.
		@param TF_TripSheet_details_ID TF_TripSheet_details_ID
	*/
	public void setTF_TripSheet_details_ID (int TF_TripSheet_details_ID)
	{
		if (TF_TripSheet_details_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_TripSheet_details_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_TripSheet_details_ID, Integer.valueOf(TF_TripSheet_details_ID));
	}

	/** Get TF_TripSheet_details_ID.
		@return TF_TripSheet_details_ID	  */
	public int getTF_TripSheet_details_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TripSheet_details_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TripSheet_details_UU.
		@param TF_TripSheet_details_UU TF_TripSheet_details_UU
	*/
	public void setTF_TripSheet_details_UU (String TF_TripSheet_details_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TripSheet_details_UU, TF_TripSheet_details_UU);
	}

	/** Get TF_TripSheet_details_UU.
		@return TF_TripSheet_details_UU	  */
	public String getTF_TripSheet_details_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_TripSheet_details_UU);
	}

	public I_TF_TripSheet getTF_TripSheet() throws RuntimeException
	{
		return (I_TF_TripSheet)MTable.get(getCtx(), I_TF_TripSheet.Table_ID)
			.getPO(getTF_TripSheet_ID(), get_TrxName());
	}

	/** Set Trip Sheet.
		@param TF_TripSheet_ID Trip Sheet
	*/
	public void setTF_TripSheet_ID (int TF_TripSheet_ID)
	{
		if (TF_TripSheet_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_TripSheet_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_TripSheet_ID, Integer.valueOf(TF_TripSheet_ID));
	}

	/** Get Trip Sheet.
		@return Trip Sheet	  */
	public int getTF_TripSheet_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TripSheet_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set To1.
		@param To1 To1
	*/
	public void setTo1 (String To1)
	{
		set_Value (COLUMNNAME_To1, To1);
	}

	/** Get To1.
		@return To1	  */
	public String getTo1()
	{
		return (String)get_Value(COLUMNNAME_To1);
	}

	/** Set Tonnage.
		@param Tonnage Tonnage
	*/
	public void setTonnage (BigDecimal Tonnage)
	{
		set_ValueNoCheck (COLUMNNAME_Tonnage, Tonnage);
	}

	/** Get Tonnage.
		@return Tonnage	  */
	public BigDecimal getTonnage()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Tonnage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}