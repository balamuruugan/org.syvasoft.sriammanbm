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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for TF_Weighment_ErrorLog
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_Weighment_ErrorLog extends PO implements I_TF_Weighment_ErrorLog, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180505L;

    /** Standard Constructor */
    public X_TF_Weighment_ErrorLog (Properties ctx, int TF_Weighment_ErrorLog_ID, String trxName)
    {
      super (ctx, TF_Weighment_ErrorLog_ID, trxName);
      /** if (TF_Weighment_ErrorLog_ID == 0)
        {
			setDateError (new Timestamp( System.currentTimeMillis() ));
			setTF_Weighment_ErrorLog_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Weighment_ErrorLog (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Weighment_ErrorLog[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Classname.
		@param Classname 
		Java Classname
	  */
	public void setClassname (String Classname)
	{
		set_Value (COLUMNNAME_Classname, Classname);
	}

	/** Get Classname.
		@return Java Classname
	  */
	public String getClassname () 
	{
		return (String)get_Value(COLUMNNAME_Classname);
	}

	/** Set Date Error.
		@param DateError Date Error	  */
	public void setDateError (Timestamp DateError)
	{
		set_Value (COLUMNNAME_DateError, DateError);
	}

	/** Get Date Error.
		@return Date Error	  */
	public Timestamp getDateError () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateError);
	}

	/** Set Message.
		@param Message 
		EMail Message
	  */
	public void setMessage (String Message)
	{
		set_Value (COLUMNNAME_Message, Message);
	}

	/** Get Message.
		@return EMail Message
	  */
	public String getMessage () 
	{
		return (String)get_Value(COLUMNNAME_Message);
	}

	/** Set Method Name.
		@param MethodName Method Name	  */
	public void setMethodName (String MethodName)
	{
		set_Value (COLUMNNAME_MethodName, MethodName);
	}

	/** Get Method Name.
		@return Method Name	  */
	public String getMethodName () 
	{
		return (String)get_Value(COLUMNNAME_MethodName);
	}

	/** Set Weighment Entry Error Log.
		@param TF_Weighment_ErrorLog_ID Weighment Entry Error Log	  */
	public void setTF_Weighment_ErrorLog_ID (int TF_Weighment_ErrorLog_ID)
	{
		if (TF_Weighment_ErrorLog_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Weighment_ErrorLog_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Weighment_ErrorLog_ID, Integer.valueOf(TF_Weighment_ErrorLog_ID));
	}

	/** Get Weighment Entry Error Log.
		@return Weighment Entry Error Log	  */
	public int getTF_Weighment_ErrorLog_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Weighment_ErrorLog_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Weighment_ErrorLog_UU.
		@param TF_Weighment_ErrorLog_UU TF_Weighment_ErrorLog_UU	  */
	public void setTF_Weighment_ErrorLog_UU (String TF_Weighment_ErrorLog_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Weighment_ErrorLog_UU, TF_Weighment_ErrorLog_UU);
	}

	/** Get TF_Weighment_ErrorLog_UU.
		@return TF_Weighment_ErrorLog_UU	  */
	public String getTF_Weighment_ErrorLog_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Weighment_ErrorLog_UU);
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
}