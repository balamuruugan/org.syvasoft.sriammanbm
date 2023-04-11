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

/** Generated Model for VG_EmailAlertSetup
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_VG_EmailAlertSetup extends PO implements I_VG_EmailAlertSetup, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200303L;

    /** Standard Constructor */
    public X_VG_EmailAlertSetup (Properties ctx, int VG_EmailAlertSetup_ID, String trxName)
    {
      super (ctx, VG_EmailAlertSetup_ID, trxName);
      /** if (VG_EmailAlertSetup_ID == 0)
        {
			setIsEmailtoCreator (false);
// N
			setName (null);
			setR_MailText_ID (0);
			setValue (null);
			setVG_EmailAlertSetup_ID (0);
        } */
    }

    /** Load Constructor */
    public X_VG_EmailAlertSetup (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_VG_EmailAlertSetup[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Role getAD_Role() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Role)MTable.get(getCtx(), org.compiere.model.I_AD_Role.Table_Name)
			.getPO(getAD_Role_ID(), get_TrxName());	}

	/** Set Role.
		@param AD_Role_ID 
		Responsibility Role
	  */
	public void setAD_Role_ID (int AD_Role_ID)
	{
		if (AD_Role_ID < 0) 
			set_Value (COLUMNNAME_AD_Role_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Role_ID, Integer.valueOf(AD_Role_ID));
	}

	/** Get Role.
		@return Responsibility Role
	  */
	public int getAD_Role_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getAD_User_ID(), get_TrxName());	}

	/** Set User/Contact.
		@param AD_User_ID 
		User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1) 
			set_Value (COLUMNNAME_AD_User_ID, null);
		else 
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Email to Creator.
		@param IsEmailtoCreator Email to Creator	  */
	public void setIsEmailtoCreator (boolean IsEmailtoCreator)
	{
		set_Value (COLUMNNAME_IsEmailtoCreator, Boolean.valueOf(IsEmailtoCreator));
	}

	/** Get Email to Creator.
		@return Email to Creator	  */
	public boolean isEmailtoCreator () 
	{
		Object oo = get_Value(COLUMNNAME_IsEmailtoCreator);
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

	public org.compiere.model.I_R_MailText getR_MailText() throws RuntimeException
    {
		return (org.compiere.model.I_R_MailText)MTable.get(getCtx(), org.compiere.model.I_R_MailText.Table_Name)
			.getPO(getR_MailText_ID(), get_TrxName());	}

	/** Set Mail Template.
		@param R_MailText_ID 
		Text templates for mailings
	  */
	public void setR_MailText_ID (int R_MailText_ID)
	{
		if (R_MailText_ID < 1) 
			set_Value (COLUMNNAME_R_MailText_ID, null);
		else 
			set_Value (COLUMNNAME_R_MailText_ID, Integer.valueOf(R_MailText_ID));
	}

	/** Get Mail Template.
		@return Text templates for mailings
	  */
	public int getR_MailText_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_R_MailText_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Email Notification Setup.
		@param VG_EmailAlertSetup_ID Email Notification Setup	  */
	public void setVG_EmailAlertSetup_ID (int VG_EmailAlertSetup_ID)
	{
		if (VG_EmailAlertSetup_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_VG_EmailAlertSetup_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_VG_EmailAlertSetup_ID, Integer.valueOf(VG_EmailAlertSetup_ID));
	}

	/** Get Email Notification Setup.
		@return Email Notification Setup	  */
	public int getVG_EmailAlertSetup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_VG_EmailAlertSetup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set VG_EmailAlertSetup_UU.
		@param VG_EmailAlertSetup_UU VG_EmailAlertSetup_UU	  */
	public void setVG_EmailAlertSetup_UU (String VG_EmailAlertSetup_UU)
	{
		set_ValueNoCheck (COLUMNNAME_VG_EmailAlertSetup_UU, VG_EmailAlertSetup_UU);
	}

	/** Get VG_EmailAlertSetup_UU.
		@return VG_EmailAlertSetup_UU	  */
	public String getVG_EmailAlertSetup_UU () 
	{
		return (String)get_Value(COLUMNNAME_VG_EmailAlertSetup_UU);
	}
}