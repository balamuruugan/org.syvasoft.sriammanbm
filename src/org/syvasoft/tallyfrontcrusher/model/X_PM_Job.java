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

/** Generated Model for PM_Job
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_PM_Job extends PO implements I_PM_Job, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200706L;

    /** Standard Constructor */
    public X_PM_Job (Properties ctx, int PM_Job_ID, String trxName)
    {
      super (ctx, PM_Job_ID, trxName);
      /** if (PM_Job_ID == 0)
        {
			setDocStatus (null);
// DU
			setName (null);
			setPM_Job_ID (0);
			setPM_Machinery_ID (0);
			setProcessed (false);
// N
        } */
    }

    /** Load Constructor */
    public X_PM_Job (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_PM_Job[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set Completed Meter.
		@param CompletedMeter Completed Meter	  */
	public void setCompletedMeter (BigDecimal CompletedMeter)
	{
		set_Value (COLUMNNAME_CompletedMeter, CompletedMeter);
	}

	/** Get Completed Meter.
		@return Completed Meter	  */
	public BigDecimal getCompletedMeter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CompletedMeter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Date Completed.
		@param DateCompleted Date Completed	  */
	public void setDateCompleted (Timestamp DateCompleted)
	{
		set_Value (COLUMNNAME_DateCompleted, DateCompleted);
	}

	/** Get Date Completed.
		@return Date Completed	  */
	public Timestamp getDateCompleted () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateCompleted);
	}

	/** Set Due Date.
		@param DateDue Due Date	  */
	public void setDateDue (Timestamp DateDue)
	{
		set_Value (COLUMNNAME_DateDue, DateDue);
	}

	/** Get Due Date.
		@return Due Date	  */
	public Timestamp getDateDue () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateDue);
	}

	/** Set End Date.
		@param DateEnd End Date	  */
	public void setDateEnd (Timestamp DateEnd)
	{
		set_Value (COLUMNNAME_DateEnd, DateEnd);
	}

	/** Get End Date.
		@return End Date	  */
	public Timestamp getDateEnd () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateEnd);
	}

	/** Set Previous Due Date.
		@param DateLastDue Previous Due Date	  */
	public void setDateLastDue (Timestamp DateLastDue)
	{
		set_Value (COLUMNNAME_DateLastDue, DateLastDue);
	}

	/** Get Previous Due Date.
		@return Previous Due Date	  */
	public Timestamp getDateLastDue () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateLastDue);
	}

	/** Set Date Start.
		@param DateStart 
		Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart)
	{
		set_Value (COLUMNNAME_DateStart, DateStart);
	}

	/** Get Date Start.
		@return Date Start for this Order
	  */
	public Timestamp getDateStart () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateStart);
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

	/** Due = DU */
	public static final String DOCSTATUS_Due = "DU";
	/** Over Due = OD */
	public static final String DOCSTATUS_OverDue = "OD";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Upcoming = UP */
	public static final String DOCSTATUS_Upcoming = "UP";
	/** Start Maintenance Job = ST */
	public static final String DOCSTATUS_StartMaintenanceJob = "ST";
	/** Modify Maintenance Job = MO */
	public static final String DOCSTATUS_ModifyMaintenanceJob = "MO";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
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

	/** Set Due Meter.
		@param DueMeter Due Meter	  */
	public void setDueMeter (BigDecimal DueMeter)
	{
		set_Value (COLUMNNAME_DueMeter, DueMeter);
	}

	/** Get Due Meter.
		@return Due Meter	  */
	public BigDecimal getDueMeter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DueMeter);
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

	/** Set Maintenance Job.
		@param PM_Job_ID Maintenance Job	  */
	public void setPM_Job_ID (int PM_Job_ID)
	{
		if (PM_Job_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PM_Job_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PM_Job_ID, Integer.valueOf(PM_Job_ID));
	}

	/** Get Maintenance Job.
		@return Maintenance Job	  */
	public int getPM_Job_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_Job_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PM_Job_UU.
		@param PM_Job_UU PM_Job_UU	  */
	public void setPM_Job_UU (String PM_Job_UU)
	{
		set_ValueNoCheck (COLUMNNAME_PM_Job_UU, PM_Job_UU);
	}

	/** Get PM_Job_UU.
		@return PM_Job_UU	  */
	public String getPM_Job_UU () 
	{
		return (String)get_Value(COLUMNNAME_PM_Job_UU);
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

	public I_PM_Schedule getPM_Schedule() throws RuntimeException
    {
		return (I_PM_Schedule)MTable.get(getCtx(), I_PM_Schedule.Table_Name)
			.getPO(getPM_Schedule_ID(), get_TrxName());	}

	/** Set Maintenance Schedule.
		@param PM_Schedule_ID Maintenance Schedule	  */
	public void setPM_Schedule_ID (int PM_Schedule_ID)
	{
		if (PM_Schedule_ID < 1) 
			set_Value (COLUMNNAME_PM_Schedule_ID, null);
		else 
			set_Value (COLUMNNAME_PM_Schedule_ID, Integer.valueOf(PM_Schedule_ID));
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
}