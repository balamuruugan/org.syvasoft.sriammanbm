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

/** Generated Model for TF_TyrePosition
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_TyrePosition extends PO implements I_TF_TyrePosition, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190218L;

    /** Standard Constructor */
    public X_TF_TyrePosition (Properties ctx, int TF_TyrePosition_ID, String trxName)
    {
      super (ctx, TF_TyrePosition_ID, trxName);
      /** if (TF_TyrePosition_ID == 0)
        {
			setName (null);
			setSeqNo (0);
			setTF_TyrePosition_ID (0);
			setTrackRunningMeter (true);
// Y
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_TF_TyrePosition (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org 
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
      StringBuffer sb = new StringBuffer ("X_TF_TyrePosition[")
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

	/** Set Tyre Position.
		@param TF_TyrePosition_ID Tyre Position	  */
	public void setTF_TyrePosition_ID (int TF_TyrePosition_ID)
	{
		if (TF_TyrePosition_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyrePosition_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyrePosition_ID, Integer.valueOf(TF_TyrePosition_ID));
	}

	/** Get Tyre Position.
		@return Tyre Position	  */
	public int getTF_TyrePosition_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyrePosition_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TyrePosition_UU.
		@param TF_TyrePosition_UU TF_TyrePosition_UU	  */
	public void setTF_TyrePosition_UU (String TF_TyrePosition_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TyrePosition_UU, TF_TyrePosition_UU);
	}

	/** Get TF_TyrePosition_UU.
		@return TF_TyrePosition_UU	  */
	public String getTF_TyrePosition_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TyrePosition_UU);
	}

	/** Set Track Running Meter.
		@param TrackRunningMeter Track Running Meter	  */
	public void setTrackRunningMeter (boolean TrackRunningMeter)
	{
		set_Value (COLUMNNAME_TrackRunningMeter, Boolean.valueOf(TrackRunningMeter));
	}

	/** Get Track Running Meter.
		@return Track Running Meter	  */
	public boolean isTrackRunningMeter () 
	{
		Object oo = get_Value(COLUMNNAME_TrackRunningMeter);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}