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
package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for PM_Schedule
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_PM_Schedule 
{

    /** TableName=PM_Schedule */
    public static final String Table_Name = "PM_Schedule";

    /** AD_Table_ID=1000309 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AdvanceReminderMeter */
    public static final String COLUMNNAME_AdvanceReminderMeter = "AdvanceReminderMeter";

	/** Set Advance Reminder Meter	  */
	public void setAdvanceReminderMeter (BigDecimal AdvanceReminderMeter);

	/** Get Advance Reminder Meter	  */
	public BigDecimal getAdvanceReminderMeter();

    /** Column name AdvReminderDays */
    public static final String COLUMNNAME_AdvReminderDays = "AdvReminderDays";

	/** Set Advance Reminder Days	  */
	public void setAdvReminderDays (int AdvReminderDays);

	/** Get Advance Reminder Days	  */
	public int getAdvReminderDays();

    /** Column name C_UOM_ID */
    public static final String COLUMNNAME_C_UOM_ID = "C_UOM_ID";

	/** Set UOM.
	  * Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID);

	/** Get UOM.
	  * Unit of Measure
	  */
	public int getC_UOM_ID();

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name DateLastRun */
    public static final String COLUMNNAME_DateLastRun = "DateLastRun";

	/** Set Date last run.
	  * Date the process was last run.
	  */
	public void setDateLastRun (Timestamp DateLastRun);

	/** Get Date last run.
	  * Date the process was last run.
	  */
	public Timestamp getDateLastRun();

    /** Column name DateNextRun */
    public static final String COLUMNNAME_DateNextRun = "DateNextRun";

	/** Set Date next run.
	  * Date the process will run next
	  */
	public void setDateNextRun (Timestamp DateNextRun);

	/** Get Date next run.
	  * Date the process will run next
	  */
	public Timestamp getDateNextRun();

    /** Column name Interval */
    public static final String COLUMNNAME_Interval = "Interval";

	/** Set Interval	  */
	public void setInterval (BigDecimal Interval);

	/** Get Interval	  */
	public BigDecimal getInterval();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name LastMeter */
    public static final String COLUMNNAME_LastMeter = "LastMeter";

	/** Set Last Meter	  */
	public void setLastMeter (BigDecimal LastMeter);

	/** Get Last Meter	  */
	public BigDecimal getLastMeter();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name NextMeter */
    public static final String COLUMNNAME_NextMeter = "NextMeter";

	/** Set Next Meter	  */
	public void setNextMeter (BigDecimal NextMeter);

	/** Get Next Meter	  */
	public BigDecimal getNextMeter();

    /** Column name OverDueDays */
    public static final String COLUMNNAME_OverDueDays = "OverDueDays";

	/** Set Over Due Days	  */
	public void setOverDueDays (int OverDueDays);

	/** Get Over Due Days	  */
	public int getOverDueDays();

    /** Column name OverDueMeter */
    public static final String COLUMNNAME_OverDueMeter = "OverDueMeter";

	/** Set Over Due Meter	  */
	public void setOverDueMeter (BigDecimal OverDueMeter);

	/** Get Over Due Meter	  */
	public BigDecimal getOverDueMeter();

    /** Column name PM_Machinery_ID */
    public static final String COLUMNNAME_PM_Machinery_ID = "PM_Machinery_ID";

	/** Set Machinery	  */
	public void setPM_Machinery_ID (int PM_Machinery_ID);

	/** Get Machinery	  */
	public int getPM_Machinery_ID();

	public I_PM_Machinery getPM_Machinery() throws RuntimeException;

    /** Column name PM_MachineryType_ID */
    public static final String COLUMNNAME_PM_MachineryType_ID = "PM_MachineryType_ID";

	/** Set Machinery Type	  */
	public void setPM_MachineryType_ID (int PM_MachineryType_ID);

	/** Get Machinery Type	  */
	public int getPM_MachineryType_ID();

	public I_PM_MachineryType getPM_MachineryType() throws RuntimeException;

    /** Column name PM_Period_ID */
    public static final String COLUMNNAME_PM_Period_ID = "PM_Period_ID";

	/** Set Maintenance Period	  */
	public void setPM_Period_ID (int PM_Period_ID);

	/** Get Maintenance Period	  */
	public int getPM_Period_ID();

	public I_PM_Period getPM_Period() throws RuntimeException;

    /** Column name PM_Schedule_ID */
    public static final String COLUMNNAME_PM_Schedule_ID = "PM_Schedule_ID";

	/** Set Maintenance Schedule	  */
	public void setPM_Schedule_ID (int PM_Schedule_ID);

	/** Get Maintenance Schedule	  */
	public int getPM_Schedule_ID();

    /** Column name PM_Schedule_UU */
    public static final String COLUMNNAME_PM_Schedule_UU = "PM_Schedule_UU";

	/** Set PM_Schedule_UU	  */
	public void setPM_Schedule_UU (String PM_Schedule_UU);

	/** Get PM_Schedule_UU	  */
	public String getPM_Schedule_UU();

    /** Column name ScheduleType */
    public static final String COLUMNNAME_ScheduleType = "ScheduleType";

	/** Set Schedule Type.
	  * Type of schedule
	  */
	public void setScheduleType (String ScheduleType);

	/** Get Schedule Type.
	  * Type of schedule
	  */
	public String getScheduleType();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
