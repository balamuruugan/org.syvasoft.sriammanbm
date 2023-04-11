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

/** Generated Model for TF_SubOrg
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_SubOrg extends PO implements I_TF_SubOrg, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190612L;

    /** Standard Constructor */
    public X_TF_SubOrg (Properties ctx, int TF_SubOrg_ID, String trxName)
    {
      super (ctx, TF_SubOrg_ID, trxName);
      /** if (TF_SubOrg_ID == 0)
        {
			setName (null);
			setTF_SubOrg_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_SubOrg (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_SubOrg[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Address.
		@param Address Address	  */
	public void setAddress (String Address)
	{
		set_Value (COLUMNNAME_Address, Address);
	}

	/** Get Address.
		@return Address	  */
	public String getAddress () 
	{
		return (String)get_Value(COLUMNNAME_Address);
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

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
    {
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_Name)
			.getPO(getM_Warehouse_ID(), get_TrxName());	}

	/** Set Warehouse.
		@param M_Warehouse_ID 
		Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1) 
			set_Value (COLUMNNAME_M_Warehouse_ID, null);
		else 
			set_Value (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Report Heading.
		@param ReportHeading Report Heading	  */
	public void setReportHeading (String ReportHeading)
	{
		set_Value (COLUMNNAME_ReportHeading, ReportHeading);
	}

	/** Get Report Heading.
		@return Report Heading	  */
	public String getReportHeading () 
	{
		return (String)get_Value(COLUMNNAME_ReportHeading);
	}

	public org.compiere.model.I_AD_Sequence getTF_SalesTaxInvoiceSequence() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Sequence)MTable.get(getCtx(), org.compiere.model.I_AD_Sequence.Table_Name)
			.getPO(getTF_SalesTaxInvoiceSequence_ID(), get_TrxName());	}

	/** Set Sales Tax Invoice Sequence.
		@param TF_SalesTaxInvoiceSequence_ID Sales Tax Invoice Sequence	  */
	public void setTF_SalesTaxInvoiceSequence_ID (int TF_SalesTaxInvoiceSequence_ID)
	{
		if (TF_SalesTaxInvoiceSequence_ID < 1) 
			set_Value (COLUMNNAME_TF_SalesTaxInvoiceSequence_ID, null);
		else 
			set_Value (COLUMNNAME_TF_SalesTaxInvoiceSequence_ID, Integer.valueOf(TF_SalesTaxInvoiceSequence_ID));
	}

	/** Get Sales Tax Invoice Sequence.
		@return Sales Tax Invoice Sequence	  */
	public int getTF_SalesTaxInvoiceSequence_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_SalesTaxInvoiceSequence_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Sub Organization.
		@param TF_SubOrg_ID Sub Organization	  */
	public void setTF_SubOrg_ID (int TF_SubOrg_ID)
	{
		if (TF_SubOrg_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_SubOrg_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_SubOrg_ID, Integer.valueOf(TF_SubOrg_ID));
	}

	/** Get Sub Organization.
		@return Sub Organization	  */
	public int getTF_SubOrg_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_SubOrg_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_SubOrg_UU.
		@param TF_SubOrg_UU TF_SubOrg_UU	  */
	public void setTF_SubOrg_UU (String TF_SubOrg_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_SubOrg_UU, TF_SubOrg_UU);
	}

	/** Get TF_SubOrg_UU.
		@return TF_SubOrg_UU	  */
	public String getTF_SubOrg_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_SubOrg_UU);
	}

	public org.compiere.model.I_AD_Sequence getTF_URDPOSequence() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Sequence)MTable.get(getCtx(), org.compiere.model.I_AD_Sequence.Table_Name)
			.getPO(getTF_URDPOSequence_ID(), get_TrxName());	}

	/** Set URD Purchase Invoice Sequence.
		@param TF_URDPOSequence_ID URD Purchase Invoice Sequence	  */
	public void setTF_URDPOSequence_ID (int TF_URDPOSequence_ID)
	{
		if (TF_URDPOSequence_ID < 1) 
			set_Value (COLUMNNAME_TF_URDPOSequence_ID, null);
		else 
			set_Value (COLUMNNAME_TF_URDPOSequence_ID, Integer.valueOf(TF_URDPOSequence_ID));
	}

	/** Get URD Purchase Invoice Sequence.
		@return URD Purchase Invoice Sequence	  */
	public int getTF_URDPOSequence_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_URDPOSequence_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}