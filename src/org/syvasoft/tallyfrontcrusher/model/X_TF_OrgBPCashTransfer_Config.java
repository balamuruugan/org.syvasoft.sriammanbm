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

/** Generated Model for TF_OrgBPCashTransfer_Config
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_OrgBPCashTransfer_Config extends PO implements I_TF_OrgBPCashTransfer_Config, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180228L;

    /** Standard Constructor */
    public X_TF_OrgBPCashTransfer_Config (Properties ctx, int TF_OrgBPCashTransfer_Config_ID, String trxName)
    {
      super (ctx, TF_OrgBPCashTransfer_Config_ID, trxName);
      /** if (TF_OrgBPCashTransfer_Config_ID == 0)
        {
			setDest_BankAccount_ID (0);
			setDest_Org_ID (0);
// @Dest_Org_ID@
			setDest_Partner_ID (0);
			setDirection (null);
// O
			setRequiredApproval (true);
// Y
			setSrc_BankAccount_ID (0);
			setSrc_Org_ID (0);
			setSrc_Partner_ID (0);
			setTF_OrgBPCashTransfer_Config_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_OrgBPCashTransfer_Config (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client 
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
      StringBuffer sb = new StringBuffer ("X_TF_OrgBPCashTransfer_Config[")
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

	public org.compiere.model.I_C_BankAccount getDest_BankAccount() throws RuntimeException
    {
		return (org.compiere.model.I_C_BankAccount)MTable.get(getCtx(), org.compiere.model.I_C_BankAccount.Table_Name)
			.getPO(getDest_BankAccount_ID(), get_TrxName());	}

	/** Set Destination Org Bank/Cash.
		@param Dest_BankAccount_ID Destination Org Bank/Cash	  */
	public void setDest_BankAccount_ID (int Dest_BankAccount_ID)
	{
		if (Dest_BankAccount_ID < 1) 
			set_Value (COLUMNNAME_Dest_BankAccount_ID, null);
		else 
			set_Value (COLUMNNAME_Dest_BankAccount_ID, Integer.valueOf(Dest_BankAccount_ID));
	}

	/** Get Destination Org Bank/Cash.
		@return Destination Org Bank/Cash	  */
	public int getDest_BankAccount_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Dest_BankAccount_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Destination Organization.
		@param Dest_Org_ID Destination Organization	  */
	public void setDest_Org_ID (int Dest_Org_ID)
	{
		if (Dest_Org_ID < 1) 
			set_Value (COLUMNNAME_Dest_Org_ID, null);
		else 
			set_Value (COLUMNNAME_Dest_Org_ID, Integer.valueOf(Dest_Org_ID));
	}

	/** Get Destination Organization.
		@return Destination Organization	  */
	public int getDest_Org_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Dest_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getDest_Partner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getDest_Partner_ID(), get_TrxName());	}

	/** Set Destination Org Business Partner.
		@param Dest_Partner_ID Destination Org Business Partner	  */
	public void setDest_Partner_ID (int Dest_Partner_ID)
	{
		if (Dest_Partner_ID < 1) 
			set_Value (COLUMNNAME_Dest_Partner_ID, null);
		else 
			set_Value (COLUMNNAME_Dest_Partner_ID, Integer.valueOf(Dest_Partner_ID));
	}

	/** Get Destination Org Business Partner.
		@return Destination Org Business Partner	  */
	public int getDest_Partner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Dest_Partner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Project getDest_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getDest_Project_ID(), get_TrxName());	}

	/** Set Destination Org Project.
		@param Dest_Project_ID Destination Org Project	  */
	public void setDest_Project_ID (int Dest_Project_ID)
	{
		if (Dest_Project_ID < 1) 
			set_Value (COLUMNNAME_Dest_Project_ID, null);
		else 
			set_Value (COLUMNNAME_Dest_Project_ID, Integer.valueOf(Dest_Project_ID));
	}

	/** Get Destination Org Project.
		@return Destination Org Project	  */
	public int getDest_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Dest_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Bidirection = B */
	public static final String DIRECTION_Bidirection = "B";
	/** Only Source Org Pays to Destination Org = O */
	public static final String DIRECTION_OnlySourceOrgPaysToDestinationOrg = "O";
	/** Set Cash Transfer Direction.
		@param Direction Cash Transfer Direction	  */
	public void setDirection (String Direction)
	{

		set_Value (COLUMNNAME_Direction, Direction);
	}

	/** Get Cash Transfer Direction.
		@return Cash Transfer Direction	  */
	public String getDirection () 
	{
		return (String)get_Value(COLUMNNAME_Direction);
	}

	/** Set Required Approval.
		@param RequiredApproval 
		Indicates that the transaction is required Approval
	  */
	public void setRequiredApproval (boolean RequiredApproval)
	{
		set_Value (COLUMNNAME_RequiredApproval, Boolean.valueOf(RequiredApproval));
	}

	/** Get Required Approval.
		@return Indicates that the transaction is required Approval
	  */
	public boolean isRequiredApproval () 
	{
		Object oo = get_Value(COLUMNNAME_RequiredApproval);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_C_BankAccount getSrc_BankAccount() throws RuntimeException
    {
		return (org.compiere.model.I_C_BankAccount)MTable.get(getCtx(), org.compiere.model.I_C_BankAccount.Table_Name)
			.getPO(getSrc_BankAccount_ID(), get_TrxName());	}

	/** Set Source Org Bank/Cash.
		@param Src_BankAccount_ID Source Org Bank/Cash	  */
	public void setSrc_BankAccount_ID (int Src_BankAccount_ID)
	{
		if (Src_BankAccount_ID < 1) 
			set_Value (COLUMNNAME_Src_BankAccount_ID, null);
		else 
			set_Value (COLUMNNAME_Src_BankAccount_ID, Integer.valueOf(Src_BankAccount_ID));
	}

	/** Get Source Org Bank/Cash.
		@return Source Org Bank/Cash	  */
	public int getSrc_BankAccount_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Src_BankAccount_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Source Organization.
		@param Src_Org_ID Source Organization	  */
	public void setSrc_Org_ID (int Src_Org_ID)
	{
		if (Src_Org_ID < 1) 
			set_Value (COLUMNNAME_Src_Org_ID, null);
		else 
			set_Value (COLUMNNAME_Src_Org_ID, Integer.valueOf(Src_Org_ID));
	}

	/** Get Source Organization.
		@return Source Organization	  */
	public int getSrc_Org_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Src_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getSrc_Partner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getSrc_Partner_ID(), get_TrxName());	}

	/** Set Source Org Business Partner.
		@param Src_Partner_ID Source Org Business Partner	  */
	public void setSrc_Partner_ID (int Src_Partner_ID)
	{
		if (Src_Partner_ID < 1) 
			set_Value (COLUMNNAME_Src_Partner_ID, null);
		else 
			set_Value (COLUMNNAME_Src_Partner_ID, Integer.valueOf(Src_Partner_ID));
	}

	/** Get Source Org Business Partner.
		@return Source Org Business Partner	  */
	public int getSrc_Partner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Src_Partner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Inter Organization BP Cash Transfer.
		@param TF_OrgBPCashTransfer_Config_ID Inter Organization BP Cash Transfer	  */
	public void setTF_OrgBPCashTransfer_Config_ID (int TF_OrgBPCashTransfer_Config_ID)
	{
		if (TF_OrgBPCashTransfer_Config_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_OrgBPCashTransfer_Config_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_OrgBPCashTransfer_Config_ID, Integer.valueOf(TF_OrgBPCashTransfer_Config_ID));
	}

	/** Get Inter Organization BP Cash Transfer.
		@return Inter Organization BP Cash Transfer	  */
	public int getTF_OrgBPCashTransfer_Config_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_OrgBPCashTransfer_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_OrgBPCashTransfer_Config_UU.
		@param TF_OrgBPCashTransfer_Config_UU TF_OrgBPCashTransfer_Config_UU	  */
	public void setTF_OrgBPCashTransfer_Config_UU (String TF_OrgBPCashTransfer_Config_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_OrgBPCashTransfer_Config_UU, TF_OrgBPCashTransfer_Config_UU);
	}

	/** Get TF_OrgBPCashTransfer_Config_UU.
		@return TF_OrgBPCashTransfer_Config_UU	  */
	public String getTF_OrgBPCashTransfer_Config_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_OrgBPCashTransfer_Config_UU);
	}
}