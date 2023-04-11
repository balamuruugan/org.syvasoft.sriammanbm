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

/** Generated Model for PM_Schedule
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_PM_Schedule extends PO implements I_PM_Schedule, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200705L;

    /** Standard Constructor */
    public X_PM_Schedule (Properties ctx, int PM_Schedule_ID, String trxName)
    {
      super (ctx, PM_Schedule_ID, trxName);
      /** if (PM_Schedule_ID == 0)
        {
			setAdvanceReminderMeter (Env.ZERO);
// 0
			setAdvReminderDays (0);
// 0
			setInterval (Env.ZERO);
			setName (null);
			setOverDueDays (0);
// 0
			setOverDueMeter (Env.ZERO);
// 0
			setPM_Machinery_ID (0);
			setPM_MachineryType_ID (0);
			setPM_Schedule_ID (0);
			setScheduleType (null);
// U
        } */
    }

    /** Load Constructor */
    public X_PM_Schedule (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_PM_Schedule[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Advance Reminder Meter.
		@param AdvanceReminderMeter Advance Reminder Meter	  */
	public void setAdvanceReminderMeter (BigDecimal AdvanceReminderMeter)
	{
		set_Value (COLUMNNAME_AdvanceReminderMeter, AdvanceReminderMeter);
	}

	/** Get Advance Reminder Meter.
		@return Advance Reminder Meter	  */
	public BigDecimal getAdvanceReminderMeter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AdvanceReminderMeter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Advance Reminder Days.
		@param AdvReminderDays Advance Reminder Days	  */
	public void setAdvReminderDays (int AdvReminderDays)
	{
		set_Value (COLUMNNAME_AdvReminderDays, Integer.valueOf(AdvReminderDays));
	}

	/** Get Advance Reminder Days.
		@return Advance Reminder Days	  */
	public int getAdvReminderDays () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AdvReminderDays);
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

	/** Set Date last run.
		@param DateLastRun 
		Date the process was last run.
	  */
	public void setDateLastRun (Timestamp DateLastRun)
	{
		set_Value (COLUMNNAME_DateLastRun, DateLastRun);
	}

	/** Get Date last run.
		@return Date the process was last run.
	  */
	public Timestamp getDateLastRun () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateLastRun);
	}

	/** Set Date next run.
		@param DateNextRun 
		Date the process will run next
	  */
	public void setDateNextRun (Timestamp DateNextRun)
	{
		set_Value (COLUMNNAME_DateNextRun, DateNextRun);
	}

	/** Get Date next run.
		@return Date the process will run next
	  */
	public Timestamp getDateNextRun () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateNextRun);
	}

	/** Set Interval.
		@param Interval Interval	  */
	public void setInterval (BigDecimal Interval)
	{
		set_Value (COLUMNNAME_Interval, Interval);
	}

	/** Get Interval.
		@return Interval	  */
	public BigDecimal getInterval () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Interval);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Last Meter.
		@param LastMeter Last Meter	  */
	public void setLastMeter (BigDecimal LastMeter)
	{
		set_Value (COLUMNNAME_LastMeter, LastMeter);
	}

	/** Get Last Meter.
		@return Last Meter	  */
	public BigDecimal getLastMeter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LastMeter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Next Meter.
		@param NextMeter Next Meter	  */
	public void setNextMeter (BigDecimal NextMeter)
	{
		set_Value (COLUMNNAME_NextMeter, NextMeter);
	}

	/** Get Next Meter.
		@return Next Meter	  */
	public BigDecimal getNextMeter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NextMeter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Over Due Days.
		@param OverDueDays Over Due Days	  */
	public void setOverDueDays (int OverDueDays)
	{
		set_Value (COLUMNNAME_OverDueDays, Integer.valueOf(OverDueDays));
	}

	/** Get Over Due Days.
		@return Over Due Days	  */
	public int getOverDueDays () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_OverDueDays);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Over Due Meter.
		@param OverDueMeter Over Due Meter	  */
	public void setOverDueMeter (BigDecimal OverDueMeter)
	{
		set_Value (COLUMNNAME_OverDueMeter, OverDueMeter);
	}

	/** Get Over Due Meter.
		@return Over Due Meter	  */
	public BigDecimal getOverDueMeter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_OverDueMeter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_PM_Machinery getPM_Machinery() throws RuntimeException
    {
		return (I_PM_Machinery)MTable.get(getCtx(), I_PM_Machinery.Table_Name)
			.getPO(getPM_Machinery_ID(), get_TrxName());	}

	/** Set Machinery.
		@param PM_Machinery_ID Machinery	  */
	public void setPM_Machinery_ID (int PM_Machinery_ID)
	{
		if (PM_Machinery_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PM_Machinery_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PM_Machinery_ID, Integer.valueOf(PM_Machinery_ID));
	}

	/** Get Machinery.
		@return Machinery	  */
	public int getPM_Machinery_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_Machinery_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_PM_MachineryType getPM_MachineryType() throws RuntimeException
    {
		return (I_PM_MachineryType)MTable.get(getCtx(), I_PM_MachineryType.Table_Name)
			.getPO(getPM_MachineryType_ID(), get_TrxName());	}

	/** Set Machinery Type.
		@param PM_MachineryType_ID Machinery Type	  */
	public void setPM_MachineryType_ID (int PM_MachineryType_ID)
	{
		if (PM_MachineryType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PM_MachineryType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PM_MachineryType_ID, Integer.valueOf(PM_MachineryType_ID));
	}

	/** Get Machinery Type.
		@return Machinery Type	  */
	public int getPM_MachineryType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_MachineryType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_PM_Period getPM_Period() throws RuntimeException
    {
		return (I_PM_Period)MTable.get(getCtx(), I_PM_Period.Table_Name)
			.getPO(getPM_Period_ID(), get_TrxName());	}

	/** Set Maintenance Period.
		@param PM_Period_ID Maintenance Period	  */
	public void setPM_Period_ID (int PM_Period_ID)
	{
		if (PM_Period_ID < 1) 
			set_Value (COLUMNNAME_PM_Period_ID, null);
		else 
			set_Value (COLUMNNAME_PM_Period_ID, Integer.valueOf(PM_Period_ID));
	}

	/** Get Maintenance Period.
		@return Maintenance Period	  */
	public int getPM_Period_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_Period_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Maintenance Schedule.
		@param PM_Schedule_ID Maintenance Schedule	  */
	public void setPM_Schedule_ID (int PM_Schedule_ID)
	{
		if (PM_Schedule_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PM_Schedule_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PM_Schedule_ID, Integer.valueOf(PM_Schedule_ID));
	}

	/** Get Maintenance Schedule.
		@return Maintenance Schedule	  */
	public int getPM_Schedule_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_Schedule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PM_Schedule_UU.
		@param PM_Schedule_UU PM_Schedule_UU	  */
	public void setPM_Schedule_UU (String PM_Schedule_UU)
	{
		set_ValueNoCheck (COLUMNNAME_PM_Schedule_UU, PM_Schedule_UU);
	}

	/** Get PM_Schedule_UU.
		@return PM_Schedule_UU	  */
	public String getPM_Schedule_UU () 
	{
		return (String)get_Value(COLUMNNAME_PM_Schedule_UU);
	}

	/** Time = T */
	public static final String SCHEDULETYPE_Time = "T";
	/** Usage = U */
	public static final String SCHEDULETYPE_Usage = "U";
	/** Set Schedule Type.
		@param ScheduleType 
		Type of schedule
	  */
	public void setScheduleType (String ScheduleType)
	{

		set_Value (COLUMNNAME_ScheduleType, ScheduleType);
	}

	/** Get Schedule Type.
		@return Type of schedule
	  */
	public String getScheduleType () 
	{
		return (String)get_Value(COLUMNNAME_ScheduleType);
	}
}