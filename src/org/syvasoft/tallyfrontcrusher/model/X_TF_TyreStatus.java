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

/** Generated Model for TF_TyreStatus
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_TF_TyreStatus extends PO implements I_TF_TyreStatus, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190209L;

    /** Standard Constructor */
    public X_TF_TyreStatus (Properties ctx, int TF_TyreStatus_ID, String trxName)
    {
      super (ctx, TF_TyreStatus_ID, trxName);
      /** if (TF_TyreStatus_ID == 0)
        {
			setChangeTyreType (false);
// N
			setIsAssignable (false);
// N
			setName (null);
			setSeqNo (0);
			setTF_TyreStatus_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_TF_TyreStatus (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TyreStatus[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Change Tyre Type.
		@param ChangeTyreType Change Tyre Type	  */
	public void setChangeTyreType (boolean ChangeTyreType)
	{
		set_Value (COLUMNNAME_ChangeTyreType, Boolean.valueOf(ChangeTyreType));
	}

	/** Get Change Tyre Type.
		@return Change Tyre Type	  */
	public boolean isChangeTyreType () 
	{
		Object oo = get_Value(COLUMNNAME_ChangeTyreType);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Assignable to Vehicle.
		@param IsAssignable Assignable to Vehicle	  */
	public void setIsAssignable (boolean IsAssignable)
	{
		set_Value (COLUMNNAME_IsAssignable, Boolean.valueOf(IsAssignable));
	}

	/** Get Assignable to Vehicle.
		@return Assignable to Vehicle	  */
	public boolean isAssignable () 
	{
		Object oo = get_Value(COLUMNNAME_IsAssignable);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Default.
		@param IsDefault 
		Default value
	  */
	public void setIsDefault (boolean IsDefault)
	{
		set_Value (COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
	}

	/** Get Default.
		@return Default value
	  */
	public boolean isDefault () 
	{
		Object oo = get_Value(COLUMNNAME_IsDefault);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Tyre Status.
		@param TF_TyreStatus_ID Tyre Status	  */
	public void setTF_TyreStatus_ID (int TF_TyreStatus_ID)
	{
		if (TF_TyreStatus_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreStatus_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreStatus_ID, Integer.valueOf(TF_TyreStatus_ID));
	}

	/** Get Tyre Status.
		@return Tyre Status	  */
	public int getTF_TyreStatus_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreStatus_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TyreStatus_UU.
		@param TF_TyreStatus_UU TF_TyreStatus_UU	  */
	public void setTF_TyreStatus_UU (String TF_TyreStatus_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TyreStatus_UU, TF_TyreStatus_UU);
	}

	/** Get TF_TyreStatus_UU.
		@return TF_TyreStatus_UU	  */
	public String getTF_TyreStatus_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TyreStatus_UU);
	}

	/** Stocked = ST */
	public static final String TYRESTATUSTYPE_Stocked = "ST";
	/** Running = RU */
	public static final String TYRESTATUSTYPE_Running = "RU";
	/** Set Status Type.
		@param TyreStatusType Status Type	  */
	public void setTyreStatusType (String TyreStatusType)
	{

		set_Value (COLUMNNAME_TyreStatusType, TyreStatusType);
	}

	/** Get Status Type.
		@return Status Type	  */
	public String getTyreStatusType () 
	{
		return (String)get_Value(COLUMNNAME_TyreStatusType);
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