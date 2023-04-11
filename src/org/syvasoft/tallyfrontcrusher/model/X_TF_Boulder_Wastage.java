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

/** Generated Model for TF_Boulder_Wastage
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_Boulder_Wastage extends PO implements I_TF_Boulder_Wastage, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220720L;

    /** Standard Constructor */
    public X_TF_Boulder_Wastage (Properties ctx, int TF_Boulder_Wastage_ID, String trxName)
    {
      super (ctx, TF_Boulder_Wastage_ID, trxName);
      /** if (TF_Boulder_Wastage_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
			setDocStatus (null);
// DR
			setDocumentNo (null);
			setProcessed (false);
			setTF_Boulder_Wastage_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_Boulder_Wastage (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Boulder_Wastage[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Project getCrusher_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getCrusher_Project_ID(), get_TrxName());	}

	/** Set Crusher Subcontract.
		@param Crusher_Project_ID Crusher Subcontract	  */
	public void setCrusher_Project_ID (int Crusher_Project_ID)
	{
		if (Crusher_Project_ID < 1) 
			set_Value (COLUMNNAME_Crusher_Project_ID, null);
		else 
			set_Value (COLUMNNAME_Crusher_Project_ID, Integer.valueOf(Crusher_Project_ID));
	}

	/** Get Crusher Subcontract.
		@return Crusher Subcontract	  */
	public int getCrusher_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Crusher_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Account Date.
		@param DateAcct 
		Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct)
	{
		set_ValueNoCheck (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
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

	/** DocAction AD_Reference_ID=135 */
	public static final int DOCACTION_AD_Reference_ID=135;
	/** Complete = CO */
	public static final String DOCACTION_Complete = "CO";
	/** Approve = AP */
	public static final String DOCACTION_Approve = "AP";
	/** Reject = RJ */
	public static final String DOCACTION_Reject = "RJ";
	/** Post = PO */
	public static final String DOCACTION_Post = "PO";
	/** Void = VO */
	public static final String DOCACTION_Void = "VO";
	/** Close = CL */
	public static final String DOCACTION_Close = "CL";
	/** Reverse - Correct = RC */
	public static final String DOCACTION_Reverse_Correct = "RC";
	/** Reverse - Accrual = RA */
	public static final String DOCACTION_Reverse_Accrual = "RA";
	/** Invalidate = IN */
	public static final String DOCACTION_Invalidate = "IN";
	/** Re-activate = RE */
	public static final String DOCACTION_Re_Activate = "RE";
	/** <None> = -- */
	public static final String DOCACTION_None = "--";
	/** Prepare = PR */
	public static final String DOCACTION_Prepare = "PR";
	/** Unlock = XL */
	public static final String DOCACTION_Unlock = "XL";
	/** Wait Complete = WC */
	public static final String DOCACTION_WaitComplete = "WC";
	/** Suspend = SU */
	public static final String DOCACTION_Suspend = "SU";
	/** Cancel = CA */
	public static final String DOCACTION_Cancel = "CA";
	/** Activate = AC */
	public static final String DOCACTION_Activate = "AC";
	/** Start  = ST */
	public static final String DOCACTION_Start = "ST";
	/** Modify = MO */
	public static final String DOCACTION_Modify = "MO";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Suspended = SU */
	public static final String DOCSTATUS_Suspended = "SU";
	/** Activated = AC */
	public static final String DOCSTATUS_Activated = "AC";
	/** Canceled = CA */
	public static final String DOCSTATUS_Canceled = "CA";
	/** Overdue = OD */
	public static final String DOCSTATUS_Overdue = "OD";
	/** Due = DU */
	public static final String DOCSTATUS_Due = "DU";
	/** Upcoming = UP */
	public static final String DOCSTATUS_Upcoming = "UP";
	/** Partially Billed = PB */
	public static final String DOCSTATUS_PartiallyBilled = "PB";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Send to Production Received Qty .
		@param Production_QtyReceived Send to Production Received Qty 	  */
	public void setProduction_QtyReceived (BigDecimal Production_QtyReceived)
	{
		set_Value (COLUMNNAME_Production_QtyReceived, Production_QtyReceived);
	}

	/** Get Send to Production Received Qty .
		@return Send to Production Received Qty 	  */
	public BigDecimal getProduction_QtyReceived () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Production_QtyReceived);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Send to Production Wastage Qty.
		@param Production_QtyWastage Send to Production Wastage Qty	  */
	public void setProduction_QtyWastage (BigDecimal Production_QtyWastage)
	{
		set_Value (COLUMNNAME_Production_QtyWastage, Production_QtyWastage);
	}

	/** Get Send to Production Wastage Qty.
		@return Send to Production Wastage Qty	  */
	public BigDecimal getProduction_QtyWastage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Production_QtyWastage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Qty Received.
		@param QtyReceived Qty Received	  */
	public void setQtyReceived (BigDecimal QtyReceived)
	{
		set_Value (COLUMNNAME_QtyReceived, QtyReceived);
	}

	/** Get Qty Received.
		@return Qty Received	  */
	public BigDecimal getQtyReceived () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyReceived);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total Wastage Qty.
		@param QtyWastage Total Wastage Qty	  */
	public void setQtyWastage (BigDecimal QtyWastage)
	{
		set_Value (COLUMNNAME_QtyWastage, QtyWastage);
	}

	/** Get Total Wastage Qty.
		@return Total Wastage Qty	  */
	public BigDecimal getQtyWastage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyWastage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_Project getQuarry_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getQuarry_Project_ID(), get_TrxName());	}

	/** Set Quarry Subcontract.
		@param Quarry_Project_ID Quarry Subcontract	  */
	public void setQuarry_Project_ID (int Quarry_Project_ID)
	{
		if (Quarry_Project_ID < 1) 
			set_Value (COLUMNNAME_Quarry_Project_ID, null);
		else 
			set_Value (COLUMNNAME_Quarry_Project_ID, Integer.valueOf(Quarry_Project_ID));
	}

	/** Get Quarry Subcontract.
		@return Quarry Subcontract	  */
	public int getQuarry_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Quarry_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Send to Stock Received Qty.
		@param Stock_QtyReceived Send to Stock Received Qty	  */
	public void setStock_QtyReceived (BigDecimal Stock_QtyReceived)
	{
		set_Value (COLUMNNAME_Stock_QtyReceived, Stock_QtyReceived);
	}

	/** Get Send to Stock Received Qty.
		@return Send to Stock Received Qty	  */
	public BigDecimal getStock_QtyReceived () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Stock_QtyReceived);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Send to Stock Wastage Qty.
		@param Stock_QtyWastage Send to Stock Wastage Qty	  */
	public void setStock_QtyWastage (BigDecimal Stock_QtyWastage)
	{
		set_Value (COLUMNNAME_Stock_QtyWastage, Stock_QtyWastage);
	}

	/** Get Send to Stock Wastage Qty.
		@return Send to Stock Wastage Qty	  */
	public BigDecimal getStock_QtyWastage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Stock_QtyWastage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_BPartner getSubcontractor() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getSubcontractor_ID(), get_TrxName());	}

	/** Set Subcontractor.
		@param Subcontractor_ID Subcontractor	  */
	public void setSubcontractor_ID (int Subcontractor_ID)
	{
		if (Subcontractor_ID < 1) 
			set_Value (COLUMNNAME_Subcontractor_ID, null);
		else 
			set_Value (COLUMNNAME_Subcontractor_ID, Integer.valueOf(Subcontractor_ID));
	}

	/** Get Subcontractor.
		@return Subcontractor	  */
	public int getSubcontractor_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Subcontractor_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Boulder Wastage.
		@param TF_Boulder_Wastage_ID Boulder Wastage	  */
	public void setTF_Boulder_Wastage_ID (int TF_Boulder_Wastage_ID)
	{
		if (TF_Boulder_Wastage_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_ID, Integer.valueOf(TF_Boulder_Wastage_ID));
	}

	/** Get Boulder Wastage.
		@return Boulder Wastage	  */
	public int getTF_Boulder_Wastage_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Wastage_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Boulder_Wastage_UU.
		@param TF_Boulder_Wastage_UU TF_Boulder_Wastage_UU	  */
	public void setTF_Boulder_Wastage_UU (String TF_Boulder_Wastage_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Boulder_Wastage_UU, TF_Boulder_Wastage_UU);
	}

	/** Get TF_Boulder_Wastage_UU.
		@return TF_Boulder_Wastage_UU	  */
	public String getTF_Boulder_Wastage_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Boulder_Wastage_UU);
	}
}