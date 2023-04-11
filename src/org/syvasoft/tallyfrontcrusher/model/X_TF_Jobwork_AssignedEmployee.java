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

/** Generated Model for TF_Jobwork_AssignedEmployee
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_Jobwork_AssignedEmployee extends PO implements I_TF_Jobwork_AssignedEmployee, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180119L;

    /** Standard Constructor */
    public X_TF_Jobwork_AssignedEmployee (Properties ctx, int TF_Jobwork_AssignedEmployee_ID, String trxName)
    {
      super (ctx, TF_Jobwork_AssignedEmployee_ID, trxName);
      /** if (TF_Jobwork_AssignedEmployee_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_Project_ID (0);
			setTF_Jobwork_AssignedEmployee_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Jobwork_AssignedEmployee (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Jobwork_AssignedEmployee[")
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
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
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

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getC_Project_ID(), get_TrxName());	}

	/** Set Project.
		@param C_Project_ID 
		Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Project.
		@return Financial Project
	  */
	public int getC_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Jobwork Assigned Employee.
		@param TF_Jobwork_AssignedEmployee_ID Jobwork Assigned Employee	  */
	public void setTF_Jobwork_AssignedEmployee_ID (int TF_Jobwork_AssignedEmployee_ID)
	{
		if (TF_Jobwork_AssignedEmployee_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_AssignedEmployee_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Jobwork_AssignedEmployee_ID, Integer.valueOf(TF_Jobwork_AssignedEmployee_ID));
	}

	/** Get Jobwork Assigned Employee.
		@return Jobwork Assigned Employee	  */
	public int getTF_Jobwork_AssignedEmployee_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Jobwork_AssignedEmployee_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Jobwork_AssignedEmployee_UU.
		@param TF_Jobwork_AssignedEmployee_UU TF_Jobwork_AssignedEmployee_UU	  */
	public void setTF_Jobwork_AssignedEmployee_UU (String TF_Jobwork_AssignedEmployee_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Jobwork_AssignedEmployee_UU, TF_Jobwork_AssignedEmployee_UU);
	}

	/** Get TF_Jobwork_AssignedEmployee_UU.
		@return TF_Jobwork_AssignedEmployee_UU	  */
	public String getTF_Jobwork_AssignedEmployee_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Jobwork_AssignedEmployee_UU);
	}
}