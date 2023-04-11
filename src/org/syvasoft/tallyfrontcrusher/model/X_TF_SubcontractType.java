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

/** Generated Model for TF_SubcontractType
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_SubcontractType extends PO implements I_TF_SubcontractType, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180224L;

    /** Standard Constructor */
    public X_TF_SubcontractType (Properties ctx, int TF_SubcontractType_ID, String trxName)
    {
      super (ctx, TF_SubcontractType_ID, trxName);
      /** if (TF_SubcontractType_ID == 0)
        {
			setCreateInvFromKating (false);
// N
			setInvoiceFor (null);
			setInvoicePriceFrom (null);
			setIsSOTrx (false);
// N
			setName (null);
			setSubcontractType (null);
// QP
			setTF_SubcontractType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_SubcontractType (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
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
      StringBuffer sb = new StringBuffer ("X_TF_SubcontractType[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Create Boulder Receipt.
		@param CreateBoulderReceipt Create Boulder Receipt	  */
	public void setCreateBoulderReceipt (boolean CreateBoulderReceipt)
	{
		set_Value (COLUMNNAME_CreateBoulderReceipt, Boolean.valueOf(CreateBoulderReceipt));
	}

	/** Get Create Boulder Receipt.
		@return Create Boulder Receipt	  */
	public boolean isCreateBoulderReceipt () 
	{
		Object oo = get_Value(COLUMNNAME_CreateBoulderReceipt);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Create Invoice From Kating.
		@param CreateInvFromKating Create Invoice From Kating	  */
	public void setCreateInvFromKating (boolean CreateInvFromKating)
	{
		set_Value (COLUMNNAME_CreateInvFromKating, Boolean.valueOf(CreateInvFromKating));
	}

	/** Get Create Invoice From Kating.
		@return Create Invoice From Kating	  */
	public boolean isCreateInvFromKating () 
	{
		Object oo = get_Value(COLUMNNAME_CreateInvFromKating);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Create Invoice From Sales.
		@param CreateInvFromSales Create Invoice From Sales	  */
	public void setCreateInvFromSales (boolean CreateInvFromSales)
	{
		set_Value (COLUMNNAME_CreateInvFromSales, Boolean.valueOf(CreateInvFromSales));
	}

	/** Get Create Invoice From Sales.
		@return Create Invoice From Sales	  */
	public boolean isCreateInvFromSales () 
	{
		Object oo = get_Value(COLUMNNAME_CreateInvFromSales);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Create Material Receipt From Sales.
		@param CreateMRFromSales Create Material Receipt From Sales	  */
	public void setCreateMRFromSales (boolean CreateMRFromSales)
	{
		set_Value (COLUMNNAME_CreateMRFromSales, Boolean.valueOf(CreateMRFromSales));
	}

	/** Get Create Material Receipt From Sales.
		@return Create Material Receipt From Sales	  */
	public boolean isCreateMRFromSales () 
	{
		Object oo = get_Value(COLUMNNAME_CreateMRFromSales);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Include Raw Material Production.
		@param IncludeRMProduction 
		Indicates that there is Weighment Entry for Raw Material Incoming
	  */
	public void setIncludeRMProduction (boolean IncludeRMProduction)
	{
		set_Value (COLUMNNAME_IncludeRMProduction, Boolean.valueOf(IncludeRMProduction));
	}

	/** Get Include Raw Material Production.
		@return Indicates that there is Weighment Entry for Raw Material Incoming
	  */
	public boolean isIncludeRMProduction () 
	{
		Object oo = get_Value(COLUMNNAME_IncludeRMProduction);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Jobwork = JW */
	public static final String INVOICEFOR_Jobwork = "JW";
	/** Product Received = PR */
	public static final String INVOICEFOR_ProductReceived = "PR";
	/** None = NO */
	public static final String INVOICEFOR_None = "NO";
	/** Set Invoice For.
		@param InvoiceFor Invoice For	  */
	public void setInvoiceFor (String InvoiceFor)
	{

		set_Value (COLUMNNAME_InvoiceFor, InvoiceFor);
	}

	/** Get Invoice For.
		@return Invoice For	  */
	public String getInvoiceFor () 
	{
		return (String)get_Value(COLUMNNAME_InvoiceFor);
	}

	/** Jobwork = JW */
	public static final String INVOICEPRICEFROM_Jobwork = "JW";
	/** Product Received = PR */
	public static final String INVOICEPRICEFROM_ProductReceived = "PR";
	/** None = NO */
	public static final String INVOICEPRICEFROM_None = "NO";
	/** Set Invoice Price From.
		@param InvoicePriceFrom Invoice Price From	  */
	public void setInvoicePriceFrom (String InvoicePriceFrom)
	{

		set_Value (COLUMNNAME_InvoicePriceFrom, InvoicePriceFrom);
	}

	/** Get Invoice Price From.
		@return Invoice Price From	  */
	public String getInvoicePriceFrom () 
	{
		return (String)get_Value(COLUMNNAME_InvoicePriceFrom);
	}

	/** Set Sales Transaction.
		@param IsSOTrx 
		This is a Sales Transaction
	  */
	public void setIsSOTrx (boolean IsSOTrx)
	{
		set_Value (COLUMNNAME_IsSOTrx, Boolean.valueOf(IsSOTrx));
	}

	/** Get Sales Transaction.
		@return This is a Sales Transaction
	  */
	public boolean isSOTrx () 
	{
		Object oo = get_Value(COLUMNNAME_IsSOTrx);
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

	/** Crusher Production = CP */
	public static final String SUBCONTRACTTYPE_CrusherProduction = "CP";
	/** Quarry Producton = QP */
	public static final String SUBCONTRACTTYPE_QuarryProducton = "QP";
	/** Sand Mining = SM */
	public static final String SUBCONTRACTTYPE_SandMining = "SM";
	/** Kating Project = KP */
	public static final String SUBCONTRACTTYPE_KatingProject = "KP";
	/** Sand Block Project = SP */
	public static final String SUBCONTRACTTYPE_SandBlockProject = "SP";
	/** Set Subcontract Type.
		@param SubcontractType Subcontract Type	  */
	public void setSubcontractType (String SubcontractType)
	{

		set_Value (COLUMNNAME_SubcontractType, SubcontractType);
	}

	/** Get Subcontract Type.
		@return Subcontract Type	  */
	public String getSubcontractType () 
	{
		return (String)get_Value(COLUMNNAME_SubcontractType);
	}

	/** Set Subcontract Type.
		@param TF_SubcontractType_ID Subcontract Type	  */
	public void setTF_SubcontractType_ID (int TF_SubcontractType_ID)
	{
		if (TF_SubcontractType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_SubcontractType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_SubcontractType_ID, Integer.valueOf(TF_SubcontractType_ID));
	}

	/** Get Subcontract Type.
		@return Subcontract Type	  */
	public int getTF_SubcontractType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_SubcontractType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_SubcontractType_UU.
		@param TF_SubcontractType_UU TF_SubcontractType_UU	  */
	public void setTF_SubcontractType_UU (String TF_SubcontractType_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_SubcontractType_UU, TF_SubcontractType_UU);
	}

	/** Get TF_SubcontractType_UU.
		@return TF_SubcontractType_UU	  */
	public String getTF_SubcontractType_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_SubcontractType_UU);
	}

	/** Set Track Material Movement.
		@param TrackMaterialMovement Track Material Movement	  */
	public void setTrackMaterialMovement (boolean TrackMaterialMovement)
	{
		set_Value (COLUMNNAME_TrackMaterialMovement, Boolean.valueOf(TrackMaterialMovement));
	}

	/** Get Track Material Movement.
		@return Track Material Movement	  */
	public boolean isTrackMaterialMovement () 
	{
		Object oo = get_Value(COLUMNNAME_TrackMaterialMovement);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_C_ElementValue getUnbilledKatingJobworkAcct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUnbilledKatingJobworkAcct_ID(), get_TrxName());	}

	/** Set Unbilled Kating Jobwork Account.
		@param UnbilledKatingJobworkAcct_ID Unbilled Kating Jobwork Account	  */
	public void setUnbilledKatingJobworkAcct_ID (int UnbilledKatingJobworkAcct_ID)
	{
		if (UnbilledKatingJobworkAcct_ID < 1) 
			set_Value (COLUMNNAME_UnbilledKatingJobworkAcct_ID, null);
		else 
			set_Value (COLUMNNAME_UnbilledKatingJobworkAcct_ID, Integer.valueOf(UnbilledKatingJobworkAcct_ID));
	}

	/** Get Unbilled Kating Jobwork Account.
		@return Unbilled Kating Jobwork Account	  */
	public int getUnbilledKatingJobworkAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_UnbilledKatingJobworkAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_ElementValue getUnbillKatingReceivableAcct() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getUnbillKatingReceivableAcct_ID(), get_TrxName());	}

	/** Set Unbilled Kating Jobwork Receivable.
		@param UnbillKatingReceivableAcct_ID Unbilled Kating Jobwork Receivable	  */
	public void setUnbillKatingReceivableAcct_ID (int UnbillKatingReceivableAcct_ID)
	{
		if (UnbillKatingReceivableAcct_ID < 1) 
			set_Value (COLUMNNAME_UnbillKatingReceivableAcct_ID, null);
		else 
			set_Value (COLUMNNAME_UnbillKatingReceivableAcct_ID, Integer.valueOf(UnbillKatingReceivableAcct_ID));
	}

	/** Get Unbilled Kating Jobwork Receivable.
		@return Unbilled Kating Jobwork Receivable	  */
	public int getUnbillKatingReceivableAcct_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_UnbillKatingReceivableAcct_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}