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

/** Generated Model for TF_CounterTrans
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_CounterTrans extends PO implements I_TF_CounterTrans, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20191213L;

    /** Standard Constructor */
    public X_TF_CounterTrans (Properties ctx, int TF_CounterTrans_ID, String trxName)
    {
      super (ctx, TF_CounterTrans_ID, trxName);
      /** if (TF_CounterTrans_ID == 0)
        {
			setCounterTransType (null);
			setDescription (null);
			setSrc_Bpartner_ID (0);
			setSrc_DocType_ID (0);
			setSrc_Org_ID (0);
			setTF_CounterTrans_ID (0);
			setTo_Bpartner_ID (0);
			setTo_Doctype_ID (0);
			setTo_Org_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_CounterTrans (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_CounterTrans[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Boulder Producion = BOULDERPRO */
	public static final String COUNTERTRANSTYPE_BoulderProducion = "BOULDERPRO";
	/** Sales/Purchase Invoice = POINVOICE */
	public static final String COUNTERTRANSTYPE_SalesPurchaseInvoice = "POINVOICE";
	/** Item Issue/Receipt = ITEMISSUE */
	public static final String COUNTERTRANSTYPE_ItemIssueReceipt = "ITEMISSUE";
	/** Sales/Purchase Tax Invoice = TAXINVOICE */
	public static final String COUNTERTRANSTYPE_SalesPurchaseTaxInvoice = "TAXINVOICE";
	/** Debit/Credit Note = DCNOTE */
	public static final String COUNTERTRANSTYPE_DebitCreditNote = "DCNOTE";
	/** Set Counter Transaction Type.
		@param CounterTransType Counter Transaction Type	  */
	public void setCounterTransType (String CounterTransType)
	{

		set_Value (COLUMNNAME_CounterTransType, CounterTransType);
	}

	/** Get Counter Transaction Type.
		@return Counter Transaction Type	  */
	public String getCounterTransType () 
	{
		return (String)get_Value(COLUMNNAME_CounterTransType);
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

	public org.compiere.model.I_C_BPartner getSrc_Bpartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getSrc_Bpartner_ID(), get_TrxName());	}

	/** Set Source Business Partner.
		@param Src_Bpartner_ID Source Business Partner	  */
	public void setSrc_Bpartner_ID (int Src_Bpartner_ID)
	{
		if (Src_Bpartner_ID < 1) 
			set_Value (COLUMNNAME_Src_Bpartner_ID, null);
		else 
			set_Value (COLUMNNAME_Src_Bpartner_ID, Integer.valueOf(Src_Bpartner_ID));
	}

	/** Get Source Business Partner.
		@return Source Business Partner	  */
	public int getSrc_Bpartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Src_Bpartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getSrc_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getSrc_DocType_ID(), get_TrxName());	}

	/** Set Source Document Type.
		@param Src_DocType_ID Source Document Type	  */
	public void setSrc_DocType_ID (int Src_DocType_ID)
	{
		if (Src_DocType_ID < 1) 
			set_Value (COLUMNNAME_Src_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_Src_DocType_ID, Integer.valueOf(Src_DocType_ID));
	}

	/** Get Source Document Type.
		@return Source Document Type	  */
	public int getSrc_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Src_DocType_ID);
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

	/** Set Counter Transaction Setup.
		@param TF_CounterTrans_ID Counter Transaction Setup	  */
	public void setTF_CounterTrans_ID (int TF_CounterTrans_ID)
	{
		if (TF_CounterTrans_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CounterTrans_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CounterTrans_ID, Integer.valueOf(TF_CounterTrans_ID));
	}

	/** Get Counter Transaction Setup.
		@return Counter Transaction Setup	  */
	public int getTF_CounterTrans_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CounterTrans_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_CounterTrans_UU.
		@param TF_CounterTrans_UU TF_CounterTrans_UU	  */
	public void setTF_CounterTrans_UU (String TF_CounterTrans_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_CounterTrans_UU, TF_CounterTrans_UU);
	}

	/** Get TF_CounterTrans_UU.
		@return TF_CounterTrans_UU	  */
	public String getTF_CounterTrans_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_CounterTrans_UU);
	}

	public org.compiere.model.I_C_BPartner getTo_Bpartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getTo_Bpartner_ID(), get_TrxName());	}

	/** Set To Business Partner.
		@param To_Bpartner_ID To Business Partner	  */
	public void setTo_Bpartner_ID (int To_Bpartner_ID)
	{
		if (To_Bpartner_ID < 1) 
			set_Value (COLUMNNAME_To_Bpartner_ID, null);
		else 
			set_Value (COLUMNNAME_To_Bpartner_ID, Integer.valueOf(To_Bpartner_ID));
	}

	/** Get To Business Partner.
		@return To Business Partner	  */
	public int getTo_Bpartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_To_Bpartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getTo_Doctype() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getTo_Doctype_ID(), get_TrxName());	}

	/** Set To Document Type.
		@param To_Doctype_ID To Document Type	  */
	public void setTo_Doctype_ID (int To_Doctype_ID)
	{
		if (To_Doctype_ID < 1) 
			set_Value (COLUMNNAME_To_Doctype_ID, null);
		else 
			set_Value (COLUMNNAME_To_Doctype_ID, Integer.valueOf(To_Doctype_ID));
	}

	/** Get To Document Type.
		@return To Document Type	  */
	public int getTo_Doctype_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_To_Doctype_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set To Organization.
		@param To_Org_ID To Organization	  */
	public void setTo_Org_ID (int To_Org_ID)
	{
		if (To_Org_ID < 1) 
			set_Value (COLUMNNAME_To_Org_ID, null);
		else 
			set_Value (COLUMNNAME_To_Org_ID, Integer.valueOf(To_Org_ID));
	}

	/** Get To Organization.
		@return To Organization	  */
	public int getTo_Org_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_To_Org_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}