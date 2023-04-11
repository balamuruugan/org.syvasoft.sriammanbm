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

/** Generated Model for TF_Boulder_Receipt
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_Boulder_Receipt extends PO implements I_TF_Boulder_Receipt, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220719L;

    /** Standard Constructor */
    public X_TF_Boulder_Receipt (Properties ctx, int TF_Boulder_Receipt_ID, String trxName)
    {
      super (ctx, TF_Boulder_Receipt_ID, trxName);
      /** if (TF_Boulder_Receipt_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDateReceipt (new Timestamp( System.currentTimeMillis() ));
			setDocAction (null);
// CO
			setDocStatus (null);
// DR
			setDocumentNo (null);
			setJobwork_PriceActual (Env.ZERO);
// 0
			setJobwork_StdPrice (Env.ZERO);
// 0
			setM_Product_ID (0);
			setM_Warehouse_ID (0);
			setProcessed (false);
			setTF_Boulder_Receipt_ID (0);
			setTF_Quarry_ID (0);
			setTF_Send_To (null);
// S
        } */
    }

    /** Load Constructor */
    public X_TF_Boulder_Receipt (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_Boulder_Receipt[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getC_Project_ID(), get_TrxName());	}

	/** Set Subcontract / Project.
		@param C_Project_ID 
		Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1) 
			set_Value (COLUMNNAME_C_Project_ID, null);
		else 
			set_Value (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Subcontract / Project.
		@return Financial Project
	  */
	public int getC_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getC_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param C_UOM_ID 
		Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID)
	{
		if (C_UOM_ID < 1) 
			set_Value (COLUMNNAME_C_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
	}

	/** Get UOM.
		@return Unit of Measure
	  */
	public int getC_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getCP_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getCP_Invoice_ID(), get_TrxName());	}

	/** Set Crusher Production Invoice.
		@param CP_Invoice_ID Crusher Production Invoice	  */
	public void setCP_Invoice_ID (int CP_Invoice_ID)
	{
		if (CP_Invoice_ID < 1) 
			set_Value (COLUMNNAME_CP_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_CP_Invoice_ID, Integer.valueOf(CP_Invoice_ID));
	}

	/** Get Crusher Production Invoice.
		@return Crusher Production Invoice	  */
	public int getCP_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CP_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Create Subcontractor Invoice.
		@param CreateSubcontractorInvoice Create Subcontractor Invoice	  */
	public void setCreateSubcontractorInvoice (String CreateSubcontractorInvoice)
	{
		set_Value (COLUMNNAME_CreateSubcontractorInvoice, CreateSubcontractorInvoice);
	}

	/** Get Create Subcontractor Invoice.
		@return Create Subcontractor Invoice	  */
	public String getCreateSubcontractorInvoice () 
	{
		return (String)get_Value(COLUMNNAME_CreateSubcontractorInvoice);
	}

	/** Set Account Date.
		@param DateAcct 
		Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct)
	{
		set_Value (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set Receipt Date.
		@param DateReceipt Receipt Date	  */
	public void setDateReceipt (Timestamp DateReceipt)
	{
		set_Value (COLUMNNAME_DateReceipt, DateReceipt);
	}

	/** Get Receipt Date.
		@return Receipt Date	  */
	public Timestamp getDateReceipt () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateReceipt);
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

	public org.compiere.model.I_C_BPartner getDriver() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getDriver_ID(), get_TrxName());	}

	/** Set Driver.
		@param Driver_ID Driver	  */
	public void setDriver_ID (int Driver_ID)
	{
		if (Driver_ID < 1) 
			set_Value (COLUMNNAME_Driver_ID, null);
		else 
			set_Value (COLUMNNAME_Driver_ID, Integer.valueOf(Driver_ID));
	}

	/** Get Driver.
		@return Driver	  */
	public int getDriver_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Driver_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Order getJob_Order() throws RuntimeException
    {
		return (org.compiere.model.I_C_Order)MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
			.getPO(getJob_Order_ID(), get_TrxName());	}

	/** Set Job Order Receipt.
		@param Job_Order_ID 
		To receive the incoming boulder.
	  */
	public void setJob_Order_ID (int Job_Order_ID)
	{
		if (Job_Order_ID < 1) 
			set_Value (COLUMNNAME_Job_Order_ID, null);
		else 
			set_Value (COLUMNNAME_Job_Order_ID, Integer.valueOf(Job_Order_ID));
	}

	/** Get Job Order Receipt.
		@return To receive the incoming boulder.
	  */
	public int getJob_Order_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Job_Order_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_GL_Journal getJobwork_Journal() throws RuntimeException
    {
		return (org.compiere.model.I_GL_Journal)MTable.get(getCtx(), org.compiere.model.I_GL_Journal.Table_Name)
			.getPO(getJobwork_Journal_ID(), get_TrxName());	}

	/** Set Jobwork Journal.
		@param Jobwork_Journal_ID Jobwork Journal	  */
	public void setJobwork_Journal_ID (int Jobwork_Journal_ID)
	{
		if (Jobwork_Journal_ID < 1) 
			set_Value (COLUMNNAME_Jobwork_Journal_ID, null);
		else 
			set_Value (COLUMNNAME_Jobwork_Journal_ID, Integer.valueOf(Jobwork_Journal_ID));
	}

	/** Get Jobwork Journal.
		@return Jobwork Journal	  */
	public int getJobwork_Journal_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Jobwork_Journal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Job Work Actual Price.
		@param Jobwork_PriceActual Job Work Actual Price	  */
	public void setJobwork_PriceActual (BigDecimal Jobwork_PriceActual)
	{
		set_Value (COLUMNNAME_Jobwork_PriceActual, Jobwork_PriceActual);
	}

	/** Get Job Work Actual Price.
		@return Job Work Actual Price	  */
	public BigDecimal getJobwork_PriceActual () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Jobwork_PriceActual);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_M_Product getJobWork_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getJobWork_Product_ID(), get_TrxName());	}

	/** Set Job Work.
		@param JobWork_Product_ID Job Work	  */
	public void setJobWork_Product_ID (int JobWork_Product_ID)
	{
		if (JobWork_Product_ID < 1) 
			set_Value (COLUMNNAME_JobWork_Product_ID, null);
		else 
			set_Value (COLUMNNAME_JobWork_Product_ID, Integer.valueOf(JobWork_Product_ID));
	}

	/** Get Job Work.
		@return Job Work	  */
	public int getJobWork_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_JobWork_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Job Work Price.
		@param Jobwork_StdPrice Job Work Price	  */
	public void setJobwork_StdPrice (BigDecimal Jobwork_StdPrice)
	{
		set_Value (COLUMNNAME_Jobwork_StdPrice, Jobwork_StdPrice);
	}

	/** Get Job Work Price.
		@return Job Work Price	  */
	public BigDecimal getJobwork_StdPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Jobwork_StdPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_GL_Journal getJobwork_VarJournal() throws RuntimeException
    {
		return (org.compiere.model.I_GL_Journal)MTable.get(getCtx(), org.compiere.model.I_GL_Journal.Table_Name)
			.getPO(getJobwork_VarJournal_ID(), get_TrxName());	}

	/** Set Jobwork Variance Journal.
		@param Jobwork_VarJournal_ID Jobwork Variance Journal	  */
	public void setJobwork_VarJournal_ID (int Jobwork_VarJournal_ID)
	{
		if (Jobwork_VarJournal_ID < 1) 
			set_Value (COLUMNNAME_Jobwork_VarJournal_ID, null);
		else 
			set_Value (COLUMNNAME_Jobwork_VarJournal_ID, Integer.valueOf(Jobwork_VarJournal_ID));
	}

	/** Get Jobwork Variance Journal.
		@return Jobwork Variance Journal	  */
	public int getJobwork_VarJournal_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Jobwork_VarJournal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Inventory getM_Inventory() throws RuntimeException
    {
		return (org.compiere.model.I_M_Inventory)MTable.get(getCtx(), org.compiere.model.I_M_Inventory.Table_Name)
			.getPO(getM_Inventory_ID(), get_TrxName());	}

	/** Set Inventory Receipt.
		@param M_Inventory_ID 
		Parameters for a Physical Inventory
	  */
	public void setM_Inventory_ID (int M_Inventory_ID)
	{
		if (M_Inventory_ID < 1) 
			set_Value (COLUMNNAME_M_Inventory_ID, null);
		else 
			set_Value (COLUMNNAME_M_Inventory_ID, Integer.valueOf(M_Inventory_ID));
	}

	/** Get Inventory Receipt.
		@return Parameters for a Physical Inventory
	  */
	public int getM_Inventory_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Inventory_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public org.compiere.model.I_M_Transaction getM_Transaction() throws RuntimeException
    {
		return (org.compiere.model.I_M_Transaction)MTable.get(getCtx(), org.compiere.model.I_M_Transaction.Table_Name)
			.getPO(getM_Transaction_ID(), get_TrxName());	}

	/** Set Inventory Transaction.
		@param M_Transaction_ID Inventory Transaction	  */
	public void setM_Transaction_ID (int M_Transaction_ID)
	{
		if (M_Transaction_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Transaction_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Transaction_ID, Integer.valueOf(M_Transaction_ID));
	}

	/** Get Inventory Transaction.
		@return Inventory Transaction	  */
	public int getM_Transaction_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Transaction_ID);
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
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
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

	/** Set No of Load.
		@param NoOfLoad No of Load	  */
	public void setNoOfLoad (BigDecimal NoOfLoad)
	{
		throw new IllegalArgumentException ("NoOfLoad is virtual column");	}

	/** Get No of Load.
		@return No of Load	  */
	public BigDecimal getNoOfLoad () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NoOfLoad);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_M_PriceList getPO_PriceList() throws RuntimeException
    {
		return (org.compiere.model.I_M_PriceList)MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_Name)
			.getPO(getPO_PriceList_ID(), get_TrxName());	}

	/** Set Purchase Pricelist.
		@param PO_PriceList_ID 
		Price List used by this Business Partner
	  */
	public void setPO_PriceList_ID (int PO_PriceList_ID)
	{
		if (PO_PriceList_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_PO_PriceList_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_PO_PriceList_ID, Integer.valueOf(PO_PriceList_ID));
	}

	/** Get Purchase Pricelist.
		@return Price List used by this Business Partner
	  */
	public int getPO_PriceList_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PO_PriceList_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Post Driver Salary Entry.
		@param PostDriverSalary Post Driver Salary Entry	  */
	public void setPostDriverSalary (String PostDriverSalary)
	{
		set_Value (COLUMNNAME_PostDriverSalary, PostDriverSalary);
	}

	/** Get Post Driver Salary Entry.
		@return Post Driver Salary Entry	  */
	public String getPostDriverSalary () 
	{
		return (String)get_Value(COLUMNNAME_PostDriverSalary);
	}

	/** Set Post Quarry Rent Entry.
		@param PostQuarryRent Post Quarry Rent Entry	  */
	public void setPostQuarryRent (String PostQuarryRent)
	{
		set_Value (COLUMNNAME_PostQuarryRent, PostQuarryRent);
	}

	/** Get Post Quarry Rent Entry.
		@return Post Quarry Rent Entry	  */
	public String getPostQuarryRent () 
	{
		return (String)get_Value(COLUMNNAME_PostQuarryRent);
	}

	/** Set Post Vehicle Rent Entry.
		@param PostVehicleRent Post Vehicle Rent Entry	  */
	public void setPostVehicleRent (String PostVehicleRent)
	{
		set_Value (COLUMNNAME_PostVehicleRent, PostVehicleRent);
	}

	/** Get Post Vehicle Rent Entry.
		@return Post Vehicle Rent Entry	  */
	public String getPostVehicleRent () 
	{
		return (String)get_Value(COLUMNNAME_PostVehicleRent);
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

	public org.compiere.model.I_C_Invoice getQuarry_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getQuarry_Invoice_ID(), get_TrxName());	}

	/** Set Quarry Invoice.
		@param Quarry_Invoice_ID 
		To receive the incoming boulder.
	  */
	public void setQuarry_Invoice_ID (int Quarry_Invoice_ID)
	{
		if (Quarry_Invoice_ID < 1) 
			set_Value (COLUMNNAME_Quarry_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_Quarry_Invoice_ID, Integer.valueOf(Quarry_Invoice_ID));
	}

	/** Get Quarry Invoice.
		@return To receive the incoming boulder.
	  */
	public int getQuarry_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Quarry_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getSubcon_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getSubcon_Invoice_ID(), get_TrxName());	}

	/** Set Subcontractor Invoice.
		@param Subcon_Invoice_ID Subcontractor Invoice	  */
	public void setSubcon_Invoice_ID (int Subcon_Invoice_ID)
	{
		if (Subcon_Invoice_ID < 1) 
			set_Value (COLUMNNAME_Subcon_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_Subcon_Invoice_ID, Integer.valueOf(Subcon_Invoice_ID));
	}

	/** Get Subcontractor Invoice.
		@return Subcontractor Invoice	  */
	public int getSubcon_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Subcon_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getSubcon2_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getSubcon2_Invoice_ID(), get_TrxName());	}

	/** Set Subcontractor 2 Invoice.
		@param Subcon2_Invoice_ID Subcontractor 2 Invoice	  */
	public void setSubcon2_Invoice_ID (int Subcon2_Invoice_ID)
	{
		if (Subcon2_Invoice_ID < 1) 
			set_Value (COLUMNNAME_Subcon2_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_Subcon2_Invoice_ID, Integer.valueOf(Subcon2_Invoice_ID));
	}

	/** Get Subcontractor 2 Invoice.
		@return Subcontractor 2 Invoice	  */
	public int getSubcon2_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Subcon2_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Regular = R */
	public static final String TF_BLUEMETAL_TYPE_Regular = "R";
	/** Wetmix = W */
	public static final String TF_BLUEMETAL_TYPE_Wetmix = "W";
	/** Regular + Geosand = RG */
	public static final String TF_BLUEMETAL_TYPE_RegularPlusGeosand = "RG";
	/** 40 MM only = 40 */
	public static final String TF_BLUEMETAL_TYPE_40MMOnly = "40";
	/** GSB = GSB */
	public static final String TF_BLUEMETAL_TYPE_GSB = "GSB";
	/** SO = SO */
	public static final String TF_BLUEMETAL_TYPE_SO = "SO";
	/** Set Production Type.
		@param TF_BlueMetal_Type Production Type	  */
	public void setTF_BlueMetal_Type (String TF_BlueMetal_Type)
	{

		set_Value (COLUMNNAME_TF_BlueMetal_Type, TF_BlueMetal_Type);
	}

	/** Get Production Type.
		@return Production Type	  */
	public String getTF_BlueMetal_Type () 
	{
		return (String)get_Value(COLUMNNAME_TF_BlueMetal_Type);
	}

	/** Set Boulder Receipt.
		@param TF_Boulder_Receipt_ID Boulder Receipt	  */
	public void setTF_Boulder_Receipt_ID (int TF_Boulder_Receipt_ID)
	{
		if (TF_Boulder_Receipt_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Receipt_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Boulder_Receipt_ID, Integer.valueOf(TF_Boulder_Receipt_ID));
	}

	/** Get Boulder Receipt.
		@return Boulder Receipt	  */
	public int getTF_Boulder_Receipt_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Boulder_Receipt_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_Boulder_Receipt_UU.
		@param TF_Boulder_Receipt_UU TF_Boulder_Receipt_UU	  */
	public void setTF_Boulder_Receipt_UU (String TF_Boulder_Receipt_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_Boulder_Receipt_UU, TF_Boulder_Receipt_UU);
	}

	/** Get TF_Boulder_Receipt_UU.
		@return TF_Boulder_Receipt_UU	  */
	public String getTF_Boulder_Receipt_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_Boulder_Receipt_UU);
	}

	public I_TF_Boulder_Wastage getTF_Boulder_Wastage() throws RuntimeException
    {
		return (I_TF_Boulder_Wastage)MTable.get(getCtx(), I_TF_Boulder_Wastage.Table_Name)
			.getPO(getTF_Boulder_Wastage_ID(), get_TrxName());	}

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

	public I_TF_Crusher_Production getTF_Crusher_Production() throws RuntimeException
    {
		return (I_TF_Crusher_Production)MTable.get(getCtx(), I_TF_Crusher_Production.Table_Name)
			.getPO(getTF_Crusher_Production_ID(), get_TrxName());	}

	/** Set Crusher Production.
		@param TF_Crusher_Production_ID Crusher Production	  */
	public void setTF_Crusher_Production_ID (int TF_Crusher_Production_ID)
	{
		if (TF_Crusher_Production_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Crusher_Production_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Crusher_Production_ID, Integer.valueOf(TF_Crusher_Production_ID));
	}

	/** Get Crusher Production.
		@return Crusher Production	  */
	public int getTF_Crusher_Production_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Crusher_Production_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Employee_Salary getTF_Employee_Salary() throws RuntimeException
    {
		return (I_TF_Employee_Salary)MTable.get(getCtx(), I_TF_Employee_Salary.Table_Name)
			.getPO(getTF_Employee_Salary_ID(), get_TrxName());	}

	/** Set Employee Salary.
		@param TF_Employee_Salary_ID Employee Salary	  */
	public void setTF_Employee_Salary_ID (int TF_Employee_Salary_ID)
	{
		if (TF_Employee_Salary_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Employee_Salary_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Employee_Salary_ID, Integer.valueOf(TF_Employee_Salary_ID));
	}

	/** Get Employee Salary.
		@return Employee Salary	  */
	public int getTF_Employee_Salary_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Employee_Salary_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_ProductionPlant getTF_ProductionPlant() throws RuntimeException
    {
		return (I_TF_ProductionPlant)MTable.get(getCtx(), I_TF_ProductionPlant.Table_Name)
			.getPO(getTF_ProductionPlant_ID(), get_TrxName());	}

	/** Set Production Plant.
		@param TF_ProductionPlant_ID Production Plant	  */
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID)
	{
		if (TF_ProductionPlant_ID < 1) 
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, null);
		else 
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, Integer.valueOf(TF_ProductionPlant_ID));
	}

	/** Get Production Plant.
		@return Production Plant	  */
	public int getTF_ProductionPlant_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ProductionPlant_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Quarry getTF_Quarry() throws RuntimeException
    {
		return (I_TF_Quarry)MTable.get(getCtx(), I_TF_Quarry.Table_Name)
			.getPO(getTF_Quarry_ID(), get_TrxName());	}

	/** Set Quarry.
		@param TF_Quarry_ID Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID)
	{
		if (TF_Quarry_ID < 1) 
			set_Value (COLUMNNAME_TF_Quarry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Quarry_ID, Integer.valueOf(TF_Quarry_ID));
	}

	/** Get Quarry.
		@return Quarry	  */
	public int getTF_Quarry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Quarry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Quarry_Rent getTF_Quarry_Rent() throws RuntimeException
    {
		return (I_TF_Quarry_Rent)MTable.get(getCtx(), I_TF_Quarry_Rent.Table_Name)
			.getPO(getTF_Quarry_Rent_ID(), get_TrxName());	}

	/** Set Quarry Rent.
		@param TF_Quarry_Rent_ID Quarry Rent	  */
	public void setTF_Quarry_Rent_ID (int TF_Quarry_Rent_ID)
	{
		if (TF_Quarry_Rent_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Quarry_Rent_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Quarry_Rent_ID, Integer.valueOf(TF_Quarry_Rent_ID));
	}

	/** Get Quarry Rent.
		@return Quarry Rent	  */
	public int getTF_Quarry_Rent_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Quarry_Rent_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_RMSubcon_Movement getTF_RMSubcon_Movement() throws RuntimeException
    {
		return (I_TF_RMSubcon_Movement)MTable.get(getCtx(), I_TF_RMSubcon_Movement.Table_Name)
			.getPO(getTF_RMSubcon_Movement_ID(), get_TrxName());	}

	/** Set Subcontract Material Movement.
		@param TF_RMSubcon_Movement_ID Subcontract Material Movement	  */
	public void setTF_RMSubcon_Movement_ID (int TF_RMSubcon_Movement_ID)
	{
		if (TF_RMSubcon_Movement_ID < 1) 
			set_Value (COLUMNNAME_TF_RMSubcon_Movement_ID, null);
		else 
			set_Value (COLUMNNAME_TF_RMSubcon_Movement_ID, Integer.valueOf(TF_RMSubcon_Movement_ID));
	}

	/** Get Subcontract Material Movement.
		@return Subcontract Material Movement	  */
	public int getTF_RMSubcon_Movement_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_RMSubcon_Movement_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Production = P */
	public static final String TF_SEND_TO_Production = "P";
	/** Stock = S */
	public static final String TF_SEND_TO_Stock = "S";
	/** Subcontract Production = T */
	public static final String TF_SEND_TO_SubcontractProduction = "T";
	/** Set Send To.
		@param TF_Send_To Send To	  */
	public void setTF_Send_To (String TF_Send_To)
	{

		set_Value (COLUMNNAME_TF_Send_To, TF_Send_To);
	}

	/** Get Send To.
		@return Send To	  */
	public String getTF_Send_To () 
	{
		return (String)get_Value(COLUMNNAME_TF_Send_To);
	}

	public I_TF_Vehicle_Rent getTF_Vehicle_Rent() throws RuntimeException
    {
		return (I_TF_Vehicle_Rent)MTable.get(getCtx(), I_TF_Vehicle_Rent.Table_Name)
			.getPO(getTF_Vehicle_Rent_ID(), get_TrxName());	}

	/** Set Vehicle Rent.
		@param TF_Vehicle_Rent_ID Vehicle Rent	  */
	public void setTF_Vehicle_Rent_ID (int TF_Vehicle_Rent_ID)
	{
		if (TF_Vehicle_Rent_ID < 1) 
			set_Value (COLUMNNAME_TF_Vehicle_Rent_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Vehicle_Rent_ID, Integer.valueOf(TF_Vehicle_Rent_ID));
	}

	/** Get Vehicle Rent.
		@return Vehicle Rent	  */
	public int getTF_Vehicle_Rent_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Vehicle_Rent_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException
    {
		return (I_TF_WeighmentEntry)MTable.get(getCtx(), I_TF_WeighmentEntry.Table_Name)
			.getPO(getTF_WeighmentEntry_ID(), get_TrxName());	}

	/** Set Weighment Entry.
		@param TF_WeighmentEntry_ID Weighment Entry	  */
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID)
	{
		if (TF_WeighmentEntry_ID < 1) 
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, Integer.valueOf(TF_WeighmentEntry_ID));
	}

	/** Get Weighment Entry.
		@return Weighment Entry	  */
	public int getTF_WeighmentEntry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_WeighmentEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getVehicle() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getVehicle_ID(), get_TrxName());	}

	/** Set Vehicle.
		@param Vehicle_ID Vehicle	  */
	public void setVehicle_ID (int Vehicle_ID)
	{
		if (Vehicle_ID < 1) 
			set_Value (COLUMNNAME_Vehicle_ID, null);
		else 
			set_Value (COLUMNNAME_Vehicle_ID, Integer.valueOf(Vehicle_ID));
	}

	/** Get Vehicle.
		@return Vehicle	  */
	public int getVehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Vehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_GL_Journal getVehicle_Rent_Journal() throws RuntimeException
    {
		return (org.compiere.model.I_GL_Journal)MTable.get(getCtx(), org.compiere.model.I_GL_Journal.Table_Name)
			.getPO(getVehicle_Rent_Journal_ID(), get_TrxName());	}

	/** Set Vehicle Rent Journal.
		@param Vehicle_Rent_Journal_ID Vehicle Rent Journal	  */
	public void setVehicle_Rent_Journal_ID (int Vehicle_Rent_Journal_ID)
	{
		if (Vehicle_Rent_Journal_ID < 1) 
			set_Value (COLUMNNAME_Vehicle_Rent_Journal_ID, null);
		else 
			set_Value (COLUMNNAME_Vehicle_Rent_Journal_ID, Integer.valueOf(Vehicle_Rent_Journal_ID));
	}

	/** Get Vehicle Rent Journal.
		@return Vehicle Rent Journal	  */
	public int getVehicle_Rent_Journal_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Vehicle_Rent_Journal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Vehicle No.
		@param VehicleNo Vehicle No	  */
	public void setVehicleNo (String VehicleNo)
	{
		set_Value (COLUMNNAME_VehicleNo, VehicleNo);
	}

	/** Get Vehicle No.
		@return Vehicle No	  */
	public String getVehicleNo () 
	{
		return (String)get_Value(COLUMNNAME_VehicleNo);
	}
}