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

/** Generated Model for TF_OrgCashTransfer_Configx
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_OrgCashTransfer_Configx extends PO implements I_TF_OrgCashTransfer_Configx, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180228L;

    /** Standard Constructor */
    public X_TF_OrgCashTransfer_Configx (Properties ctx, int TF_OrgCashTransfer_Configx_ID, String trxName)
    {
      super (ctx, TF_OrgCashTransfer_Configx_ID, trxName);
      /** if (TF_OrgCashTransfer_Configx_ID == 0)
        {
			setC_DocType_ID (0);
			setDescription (null);
			setDest_Org_ID (0);
// @Dest_Org_ID@
			setTF_OrgCashTransfer_Config_ID (0);
			setTF_OrgCashTransfer_Configx_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_OrgCashTransfer_Configx (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_OrgCashTransfer_Configx[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

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

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_C_DocType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
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

	public org.compiere.model.I_C_ElementValue getDest_Acct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getDest_Acct_ID(), get_TrxName());	}

	/** Set Destination Org Account.
		@param Dest_Acct_ID Destination Org Account	  */
	public void setDest_Acct_ID (int Dest_Acct_ID)
	{
		if (Dest_Acct_ID < 1) 
			set_Value (COLUMNNAME_Dest_Acct_ID, null);
		else 
			set_Value (COLUMNNAME_Dest_Acct_ID, Integer.valueOf(Dest_Acct_ID));
	}

	/** Get Destination Org Account.
		@return Destination Org Account	  */
	public int getDest_Acct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Dest_Acct_ID);
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

	public I_TF_OrgCashTransfer_Config getTF_OrgCashTransfer_Config() throws RuntimeException
    {
		return (I_TF_OrgCashTransfer_Config)MTable.get(getCtx(), I_TF_OrgCashTransfer_Config.Table_Name)
			.getPO(getTF_OrgCashTransfer_Config_ID(), get_TrxName());	}

	/** Set Inter Org Cash Transfer.
		@param TF_OrgCashTransfer_Config_ID Inter Org Cash Transfer	  */
	public void setTF_OrgCashTransfer_Config_ID (int TF_OrgCashTransfer_Config_ID)
	{
		if (TF_OrgCashTransfer_Config_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_OrgCashTransfer_Config_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_OrgCashTransfer_Config_ID, Integer.valueOf(TF_OrgCashTransfer_Config_ID));
	}

	/** Get Inter Org Cash Transfer.
		@return Inter Org Cash Transfer	  */
	public int getTF_OrgCashTransfer_Config_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_OrgCashTransfer_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Destination Org Additional Cash Transfer.
		@param TF_OrgCashTransfer_Configx_ID Destination Org Additional Cash Transfer	  */
	public void setTF_OrgCashTransfer_Configx_ID (int TF_OrgCashTransfer_Configx_ID)
	{
		if (TF_OrgCashTransfer_Configx_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_OrgCashTransfer_Configx_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_OrgCashTransfer_Configx_ID, Integer.valueOf(TF_OrgCashTransfer_Configx_ID));
	}

	/** Get Destination Org Additional Cash Transfer.
		@return Destination Org Additional Cash Transfer	  */
	public int getTF_OrgCashTransfer_Configx_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_OrgCashTransfer_Configx_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}