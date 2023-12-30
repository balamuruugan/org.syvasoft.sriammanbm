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

/** Generated Model for TF_EmpShiftAssignment
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_EmpShiftAssignment extends PO implements I_TF_EmpShiftAssignment, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220127L;

    /** Standard Constructor */
    public X_TF_EmpShiftAssignment (Properties ctx, int TF_EmpShiftAssignment_ID, String trxName)
    {
      super (ctx, TF_EmpShiftAssignment_ID, trxName);
      /** if (TF_EmpShiftAssignment_ID == 0)
        {
			setC_BPartner_ID (0);
			setDateFrom (new Timestamp( System.currentTimeMillis() ));
			setTF_EmpShift_ID (0);
			setTF_ShiftAssignment_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_EmpShiftAssignment (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_EmpShiftAssignment[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Date From.
		@param DateFrom 
		Starting date for a range
	  */
	public void setDateFrom (Timestamp DateFrom)
	{
		set_Value (COLUMNNAME_DateFrom, DateFrom);
	}

	/** Get Date From.
		@return Starting date for a range
	  */
	public Timestamp getDateFrom () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateFrom);
	}

	public I_TF_EmpShift getTF_EmpShift() throws RuntimeException
    {
		return (I_TF_EmpShift)MTable.get(getCtx(), I_TF_EmpShift.Table_Name)
			.getPO(getTF_EmpShift_ID(), get_TrxName());	}

	/** Set Employee Shift.
		@param TF_EmpShift_ID Employee Shift	  */
	public void setTF_EmpShift_ID (int TF_EmpShift_ID)
	{
		if (TF_EmpShift_ID < 1) 
			set_Value (COLUMNNAME_TF_EmpShift_ID, null);
		else 
			set_Value (COLUMNNAME_TF_EmpShift_ID, Integer.valueOf(TF_EmpShift_ID));
	}

	/** Get Employee Shift.
		@return Employee Shift	  */
	public int getTF_EmpShift_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_EmpShift_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Assign Shift.
		@param TF_ShiftAssignment_ID Assign Shift	  */
	public void setTF_ShiftAssignment_ID (int TF_ShiftAssignment_ID)
	{
		if (TF_ShiftAssignment_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_ShiftAssignment_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_ShiftAssignment_ID, Integer.valueOf(TF_ShiftAssignment_ID));
	}

	/** Get Assign Shift.
		@return Assign Shift	  */
	public int getTF_ShiftAssignment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ShiftAssignment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_ShiftAssignment_UU.
		@param TF_ShiftAssignment_UU TF_ShiftAssignment_UU	  */
	public void setTF_ShiftAssignment_UU (String TF_ShiftAssignment_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_ShiftAssignment_UU, TF_ShiftAssignment_UU);
	}

	/** Get TF_ShiftAssignment_UU.
		@return TF_ShiftAssignment_UU	  */
	public String getTF_ShiftAssignment_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_ShiftAssignment_UU);
	}
}