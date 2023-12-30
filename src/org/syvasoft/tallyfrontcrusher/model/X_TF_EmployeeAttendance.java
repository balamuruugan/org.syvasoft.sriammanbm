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

/** Generated Model for TF_EmployeeAttendance
 *  @author iDempiere (generated) 
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="TF_EmployeeAttendance")
public class X_TF_EmployeeAttendance extends PO implements I_TF_EmployeeAttendance, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231229L;

    /** Standard Constructor */
    public X_TF_EmployeeAttendance (Properties ctx, int TF_EmployeeAttendance_ID, String trxName)
    {
      super (ctx, TF_EmployeeAttendance_ID, trxName);
      /** if (TF_EmployeeAttendance_ID == 0)
        {
			setAttendanceUnit (Env.ZERO);
// 1
			setC_BPartner_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
			setIsManual (false);
// N
			setStatus (null);
// A
			setTF_EmployeeAttendance_ID (0);
			setWorkingHours (Env.ZERO);
// 0
        } */
    }

    /** Standard Constructor */
    public X_TF_EmployeeAttendance (Properties ctx, int TF_EmployeeAttendance_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_EmployeeAttendance_ID, trxName, virtualColumns);
      /** if (TF_EmployeeAttendance_ID == 0)
        {
			setAttendanceUnit (Env.ZERO);
// 1
			setC_BPartner_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
			setIsManual (false);
// N
			setStatus (null);
// A
			setTF_EmployeeAttendance_ID (0);
			setWorkingHours (Env.ZERO);
// 0
        } */
    }

    /** Load Constructor */
    public X_TF_EmployeeAttendance (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_TF_EmployeeAttendance[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Attendance Unit.
		@param AttendanceUnit Attendance Unit
	*/
	public void setAttendanceUnit (BigDecimal AttendanceUnit)
	{
		set_Value (COLUMNNAME_AttendanceUnit, AttendanceUnit);
	}

	/** Get Attendance Unit.
		@return Attendance Unit	  */
	public BigDecimal getAttendanceUnit()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AttendanceUnit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Account Date.
		@param DateAcct Accounting Date
	*/
	public void setDateAcct (Timestamp DateAcct)
	{
		set_Value (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set In Time.
		@param DateInTime In Time
	*/
	public void setDateInTime (Timestamp DateInTime)
	{
		set_Value (COLUMNNAME_DateInTime, DateInTime);
	}

	/** Get In Time.
		@return In Time	  */
	public Timestamp getDateInTime()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateInTime);
	}

	/** Set Out Time.
		@param DateOutTime Out Time
	*/
	public void setDateOutTime (Timestamp DateOutTime)
	{
		set_Value (COLUMNNAME_DateOutTime, DateOutTime);
	}

	/** Get Out Time.
		@return Out Time	  */
	public Timestamp getDateOutTime()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateOutTime);
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

	/** Set Duration.
		@param Duration Normal Duration in Duration Unit
	*/
	public void setDuration (String Duration)
	{
		set_Value (COLUMNNAME_Duration, Duration);
	}

	/** Get Duration.
		@return Normal Duration in Duration Unit
	  */
	public String getDuration()
	{
		return (String)get_Value(COLUMNNAME_Duration);
	}

	/** Set Manual.
		@param IsManual This is a manual process
	*/
	public void setIsManual (boolean IsManual)
	{
		set_Value (COLUMNNAME_IsManual, Boolean.valueOf(IsManual));
	}

	/** Get Manual.
		@return This is a manual process
	  */
	public boolean isManual()
	{
		Object oo = get_Value(COLUMNNAME_IsManual);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Kuthavakkam = K */
	public static final String LOCATION_Kuthavakkam = "K";
	/** Office = O */
	public static final String LOCATION_Office = "O";
	/** Plant = P */
	public static final String LOCATION_Plant = "P";
	/** Set Location.
		@param Location Location
	*/
	public void setLocation (String Location)
	{

		throw new IllegalArgumentException ("Location is virtual column");	}

	/** Get Location.
		@return Location	  */
	public String getLocation()
	{
		return (String)get_Value(COLUMNNAME_Location);
	}

	/** Absent = A */
	public static final String STATUS_Absent = "A";
	/** Holiday = H */
	public static final String STATUS_Holiday = "H";
	/** Half Day Present = HD */
	public static final String STATUS_HalfDayPresent = "HD";
	/** Leave = L */
	public static final String STATUS_Leave = "L";
	/** Present = P */
	public static final String STATUS_Present = "P";
	/** Unknown = U */
	public static final String STATUS_Unknown = "U";
	/** Voided = V */
	public static final String STATUS_Voided = "V";
	/** Set Status.
		@param Status Status of the currently running check
	*/
	public void setStatus (String Status)
	{

		set_Value (COLUMNNAME_Status, Status);
	}

	/** Get Status.
		@return Status of the currently running check
	  */
	public String getStatus()
	{
		return (String)get_Value(COLUMNNAME_Status);
	}

	public I_TF_AttendnaceHdr getTF_AttendnaceHdr() throws RuntimeException
	{
		return (I_TF_AttendnaceHdr)MTable.get(getCtx(), I_TF_AttendnaceHdr.Table_ID)
			.getPO(getTF_AttendnaceHdr_ID(), get_TrxName());
	}

	/** Set Generate Attendance.
		@param TF_AttendnaceHdr_ID Generate Attendance
	*/
	public void setTF_AttendnaceHdr_ID (int TF_AttendnaceHdr_ID)
	{
		if (TF_AttendnaceHdr_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_AttendnaceHdr_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_AttendnaceHdr_ID, Integer.valueOf(TF_AttendnaceHdr_ID));
	}

	/** Get Generate Attendance.
		@return Generate Attendance	  */
	public int getTF_AttendnaceHdr_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_AttendnaceHdr_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Employee Attendance.
		@param TF_EmployeeAttendance_ID Employee Attendance
	*/
	public void setTF_EmployeeAttendance_ID (int TF_EmployeeAttendance_ID)
	{
		if (TF_EmployeeAttendance_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_EmployeeAttendance_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_EmployeeAttendance_ID, Integer.valueOf(TF_EmployeeAttendance_ID));
	}

	/** Get Employee Attendance.
		@return Employee Attendance	  */
	public int getTF_EmployeeAttendance_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_EmployeeAttendance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_EmployeeAttendance_UU.
		@param TF_EmployeeAttendance_UU TF_EmployeeAttendance_UU
	*/
	public void setTF_EmployeeAttendance_UU (String TF_EmployeeAttendance_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_EmployeeAttendance_UU, TF_EmployeeAttendance_UU);
	}

	/** Get TF_EmployeeAttendance_UU.
		@return TF_EmployeeAttendance_UU	  */
	public String getTF_EmployeeAttendance_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_EmployeeAttendance_UU);
	}

	public I_TF_EmpShift getTF_EmpShift() throws RuntimeException
	{
		return (I_TF_EmpShift)MTable.get(getCtx(), I_TF_EmpShift.Table_ID)
			.getPO(getTF_EmpShift_ID(), get_TrxName());
	}

	/** Set Employee Shift.
		@param TF_EmpShift_ID Employee Shift
	*/
	public void setTF_EmpShift_ID (int TF_EmpShift_ID)
	{
		if (TF_EmpShift_ID < 1)
			set_Value (COLUMNNAME_TF_EmpShift_ID, null);
		else
			set_Value (COLUMNNAME_TF_EmpShift_ID, Integer.valueOf(TF_EmpShift_ID));
	}

	/** Get Employee Shift.
		@return Employee Shift	  */
	public int getTF_EmpShift_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_EmpShift_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Working Hours.
		@param WorkingHours Working Hours
	*/
	public void setWorkingHours (BigDecimal WorkingHours)
	{
		set_Value (COLUMNNAME_WorkingHours, WorkingHours);
	}

	/** Get Working Hours.
		@return Working Hours	  */
	public BigDecimal getWorkingHours()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_WorkingHours);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}