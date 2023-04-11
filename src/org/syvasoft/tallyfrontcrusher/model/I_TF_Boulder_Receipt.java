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
package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for TF_Boulder_Receipt
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_Boulder_Receipt 
{

    /** TableName=TF_Boulder_Receipt */
    public static final String Table_Name = "TF_Boulder_Receipt";

    /** AD_Table_ID=1000168 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name C_Project_ID */
    public static final String COLUMNNAME_C_Project_ID = "C_Project_ID";

	/** Set Subcontract / Project.
	  * Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID);

	/** Get Subcontract / Project.
	  * Financial Project
	  */
	public int getC_Project_ID();

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException;

    /** Column name C_UOM_ID */
    public static final String COLUMNNAME_C_UOM_ID = "C_UOM_ID";

	/** Set UOM.
	  * Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID);

	/** Get UOM.
	  * Unit of Measure
	  */
	public int getC_UOM_ID();

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException;

    /** Column name CP_Invoice_ID */
    public static final String COLUMNNAME_CP_Invoice_ID = "CP_Invoice_ID";

	/** Set Crusher Production Invoice	  */
	public void setCP_Invoice_ID (int CP_Invoice_ID);

	/** Get Crusher Production Invoice	  */
	public int getCP_Invoice_ID();

	public org.compiere.model.I_C_Invoice getCP_Invoice() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name CreateSubcontractorInvoice */
    public static final String COLUMNNAME_CreateSubcontractorInvoice = "CreateSubcontractorInvoice";

	/** Set Create Subcontractor Invoice	  */
	public void setCreateSubcontractorInvoice (String CreateSubcontractorInvoice);

	/** Get Create Subcontractor Invoice	  */
	public String getCreateSubcontractorInvoice();

    /** Column name DateAcct */
    public static final String COLUMNNAME_DateAcct = "DateAcct";

	/** Set Account Date.
	  * Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct);

	/** Get Account Date.
	  * Accounting Date
	  */
	public Timestamp getDateAcct();

    /** Column name DateReceipt */
    public static final String COLUMNNAME_DateReceipt = "DateReceipt";

	/** Set Receipt Date	  */
	public void setDateReceipt (Timestamp DateReceipt);

	/** Get Receipt Date	  */
	public Timestamp getDateReceipt();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name DocAction */
    public static final String COLUMNNAME_DocAction = "DocAction";

	/** Set Document Action.
	  * The targeted status of the document
	  */
	public void setDocAction (String DocAction);

	/** Get Document Action.
	  * The targeted status of the document
	  */
	public String getDocAction();

    /** Column name DocStatus */
    public static final String COLUMNNAME_DocStatus = "DocStatus";

	/** Set Document Status.
	  * The current status of the document
	  */
	public void setDocStatus (String DocStatus);

	/** Get Document Status.
	  * The current status of the document
	  */
	public String getDocStatus();

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

    /** Column name Driver_ID */
    public static final String COLUMNNAME_Driver_ID = "Driver_ID";

	/** Set Driver	  */
	public void setDriver_ID (int Driver_ID);

	/** Get Driver	  */
	public int getDriver_ID();

	public org.compiere.model.I_C_BPartner getDriver() throws RuntimeException;

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Job_Order_ID */
    public static final String COLUMNNAME_Job_Order_ID = "Job_Order_ID";

	/** Set Job Order Receipt.
	  * To receive the incoming boulder.
	  */
	public void setJob_Order_ID (int Job_Order_ID);

	/** Get Job Order Receipt.
	  * To receive the incoming boulder.
	  */
	public int getJob_Order_ID();

	public org.compiere.model.I_C_Order getJob_Order() throws RuntimeException;

    /** Column name Jobwork_Journal_ID */
    public static final String COLUMNNAME_Jobwork_Journal_ID = "Jobwork_Journal_ID";

	/** Set Jobwork Journal	  */
	public void setJobwork_Journal_ID (int Jobwork_Journal_ID);

	/** Get Jobwork Journal	  */
	public int getJobwork_Journal_ID();

	public org.compiere.model.I_GL_Journal getJobwork_Journal() throws RuntimeException;

    /** Column name Jobwork_PriceActual */
    public static final String COLUMNNAME_Jobwork_PriceActual = "Jobwork_PriceActual";

	/** Set Job Work Actual Price	  */
	public void setJobwork_PriceActual (BigDecimal Jobwork_PriceActual);

	/** Get Job Work Actual Price	  */
	public BigDecimal getJobwork_PriceActual();

    /** Column name JobWork_Product_ID */
    public static final String COLUMNNAME_JobWork_Product_ID = "JobWork_Product_ID";

	/** Set Job Work	  */
	public void setJobWork_Product_ID (int JobWork_Product_ID);

	/** Get Job Work	  */
	public int getJobWork_Product_ID();

	public org.compiere.model.I_M_Product getJobWork_Product() throws RuntimeException;

    /** Column name Jobwork_StdPrice */
    public static final String COLUMNNAME_Jobwork_StdPrice = "Jobwork_StdPrice";

	/** Set Job Work Price	  */
	public void setJobwork_StdPrice (BigDecimal Jobwork_StdPrice);

	/** Get Job Work Price	  */
	public BigDecimal getJobwork_StdPrice();

    /** Column name Jobwork_VarJournal_ID */
    public static final String COLUMNNAME_Jobwork_VarJournal_ID = "Jobwork_VarJournal_ID";

	/** Set Jobwork Variance Journal	  */
	public void setJobwork_VarJournal_ID (int Jobwork_VarJournal_ID);

	/** Get Jobwork Variance Journal	  */
	public int getJobwork_VarJournal_ID();

	public org.compiere.model.I_GL_Journal getJobwork_VarJournal() throws RuntimeException;

    /** Column name M_Inventory_ID */
    public static final String COLUMNNAME_M_Inventory_ID = "M_Inventory_ID";

	/** Set Inventory Receipt.
	  * Parameters for a Physical Inventory
	  */
	public void setM_Inventory_ID (int M_Inventory_ID);

	/** Get Inventory Receipt.
	  * Parameters for a Physical Inventory
	  */
	public int getM_Inventory_ID();

	public org.compiere.model.I_M_Inventory getM_Inventory() throws RuntimeException;

    /** Column name M_Product_ID */
    public static final String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/** Set Product.
	  * Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID);

	/** Get Product.
	  * Product, Service, Item
	  */
	public int getM_Product_ID();

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException;

    /** Column name M_Transaction_ID */
    public static final String COLUMNNAME_M_Transaction_ID = "M_Transaction_ID";

	/** Set Inventory Transaction	  */
	public void setM_Transaction_ID (int M_Transaction_ID);

	/** Get Inventory Transaction	  */
	public int getM_Transaction_ID();

	public org.compiere.model.I_M_Transaction getM_Transaction() throws RuntimeException;

    /** Column name M_Warehouse_ID */
    public static final String COLUMNNAME_M_Warehouse_ID = "M_Warehouse_ID";

	/** Set Warehouse.
	  * Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID);

	/** Get Warehouse.
	  * Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID();

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException;

    /** Column name NoOfLoad */
    public static final String COLUMNNAME_NoOfLoad = "NoOfLoad";

	/** Set No of Load	  */
	public void setNoOfLoad (BigDecimal NoOfLoad);

	/** Get No of Load	  */
	public BigDecimal getNoOfLoad();

    /** Column name PO_PriceList_ID */
    public static final String COLUMNNAME_PO_PriceList_ID = "PO_PriceList_ID";

	/** Set Purchase Pricelist.
	  * Price List used by this Business Partner
	  */
	public void setPO_PriceList_ID (int PO_PriceList_ID);

	/** Get Purchase Pricelist.
	  * Price List used by this Business Partner
	  */
	public int getPO_PriceList_ID();

	public org.compiere.model.I_M_PriceList getPO_PriceList() throws RuntimeException;

    /** Column name PostDriverSalary */
    public static final String COLUMNNAME_PostDriverSalary = "PostDriverSalary";

	/** Set Post Driver Salary Entry	  */
	public void setPostDriverSalary (String PostDriverSalary);

	/** Get Post Driver Salary Entry	  */
	public String getPostDriverSalary();

    /** Column name PostQuarryRent */
    public static final String COLUMNNAME_PostQuarryRent = "PostQuarryRent";

	/** Set Post Quarry Rent Entry	  */
	public void setPostQuarryRent (String PostQuarryRent);

	/** Get Post Quarry Rent Entry	  */
	public String getPostQuarryRent();

    /** Column name PostVehicleRent */
    public static final String COLUMNNAME_PostVehicleRent = "PostVehicleRent";

	/** Set Post Vehicle Rent Entry	  */
	public void setPostVehicleRent (String PostVehicleRent);

	/** Get Post Vehicle Rent Entry	  */
	public String getPostVehicleRent();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

    /** Column name QtyReceived */
    public static final String COLUMNNAME_QtyReceived = "QtyReceived";

	/** Set Qty Received	  */
	public void setQtyReceived (BigDecimal QtyReceived);

	/** Get Qty Received	  */
	public BigDecimal getQtyReceived();

    /** Column name Quarry_Invoice_ID */
    public static final String COLUMNNAME_Quarry_Invoice_ID = "Quarry_Invoice_ID";

	/** Set Quarry Invoice.
	  * To receive the incoming boulder.
	  */
	public void setQuarry_Invoice_ID (int Quarry_Invoice_ID);

	/** Get Quarry Invoice.
	  * To receive the incoming boulder.
	  */
	public int getQuarry_Invoice_ID();

	public org.compiere.model.I_C_Invoice getQuarry_Invoice() throws RuntimeException;

    /** Column name Subcon_Invoice_ID */
    public static final String COLUMNNAME_Subcon_Invoice_ID = "Subcon_Invoice_ID";

	/** Set Subcontractor Invoice	  */
	public void setSubcon_Invoice_ID (int Subcon_Invoice_ID);

	/** Get Subcontractor Invoice	  */
	public int getSubcon_Invoice_ID();

	public org.compiere.model.I_C_Invoice getSubcon_Invoice() throws RuntimeException;

    /** Column name Subcon2_Invoice_ID */
    public static final String COLUMNNAME_Subcon2_Invoice_ID = "Subcon2_Invoice_ID";

	/** Set Subcontractor 2 Invoice	  */
	public void setSubcon2_Invoice_ID (int Subcon2_Invoice_ID);

	/** Get Subcontractor 2 Invoice	  */
	public int getSubcon2_Invoice_ID();

	public org.compiere.model.I_C_Invoice getSubcon2_Invoice() throws RuntimeException;

    /** Column name Subcontractor_ID */
    public static final String COLUMNNAME_Subcontractor_ID = "Subcontractor_ID";

	/** Set Subcontractor	  */
	public void setSubcontractor_ID (int Subcontractor_ID);

	/** Get Subcontractor	  */
	public int getSubcontractor_ID();

	public org.compiere.model.I_C_BPartner getSubcontractor() throws RuntimeException;

    /** Column name TF_BlueMetal_Type */
    public static final String COLUMNNAME_TF_BlueMetal_Type = "TF_BlueMetal_Type";

	/** Set Production Type	  */
	public void setTF_BlueMetal_Type (String TF_BlueMetal_Type);

	/** Get Production Type	  */
	public String getTF_BlueMetal_Type();

    /** Column name TF_Boulder_Receipt_ID */
    public static final String COLUMNNAME_TF_Boulder_Receipt_ID = "TF_Boulder_Receipt_ID";

	/** Set Boulder Receipt	  */
	public void setTF_Boulder_Receipt_ID (int TF_Boulder_Receipt_ID);

	/** Get Boulder Receipt	  */
	public int getTF_Boulder_Receipt_ID();

    /** Column name TF_Boulder_Receipt_UU */
    public static final String COLUMNNAME_TF_Boulder_Receipt_UU = "TF_Boulder_Receipt_UU";

	/** Set TF_Boulder_Receipt_UU	  */
	public void setTF_Boulder_Receipt_UU (String TF_Boulder_Receipt_UU);

	/** Get TF_Boulder_Receipt_UU	  */
	public String getTF_Boulder_Receipt_UU();

    /** Column name TF_Boulder_Wastage_ID */
    public static final String COLUMNNAME_TF_Boulder_Wastage_ID = "TF_Boulder_Wastage_ID";

	/** Set Boulder Wastage	  */
	public void setTF_Boulder_Wastage_ID (int TF_Boulder_Wastage_ID);

	/** Get Boulder Wastage	  */
	public int getTF_Boulder_Wastage_ID();

	public I_TF_Boulder_Wastage getTF_Boulder_Wastage() throws RuntimeException;

    /** Column name TF_Crusher_Production_ID */
    public static final String COLUMNNAME_TF_Crusher_Production_ID = "TF_Crusher_Production_ID";

	/** Set Crusher Production	  */
	public void setTF_Crusher_Production_ID (int TF_Crusher_Production_ID);

	/** Get Crusher Production	  */
	public int getTF_Crusher_Production_ID();

	public I_TF_Crusher_Production getTF_Crusher_Production() throws RuntimeException;

    /** Column name TF_Employee_Salary_ID */
    public static final String COLUMNNAME_TF_Employee_Salary_ID = "TF_Employee_Salary_ID";

	/** Set Employee Salary	  */
	public void setTF_Employee_Salary_ID (int TF_Employee_Salary_ID);

	/** Get Employee Salary	  */
	public int getTF_Employee_Salary_ID();

	public I_TF_Employee_Salary getTF_Employee_Salary() throws RuntimeException;

    /** Column name TF_ProductionPlant_ID */
    public static final String COLUMNNAME_TF_ProductionPlant_ID = "TF_ProductionPlant_ID";

	/** Set Production Plant	  */
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID);

	/** Get Production Plant	  */
	public int getTF_ProductionPlant_ID();

	public I_TF_ProductionPlant getTF_ProductionPlant() throws RuntimeException;

    /** Column name TF_Quarry_ID */
    public static final String COLUMNNAME_TF_Quarry_ID = "TF_Quarry_ID";

	/** Set Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID);

	/** Get Quarry	  */
	public int getTF_Quarry_ID();

	public I_TF_Quarry getTF_Quarry() throws RuntimeException;

    /** Column name TF_Quarry_Rent_ID */
    public static final String COLUMNNAME_TF_Quarry_Rent_ID = "TF_Quarry_Rent_ID";

	/** Set Quarry Rent	  */
	public void setTF_Quarry_Rent_ID (int TF_Quarry_Rent_ID);

	/** Get Quarry Rent	  */
	public int getTF_Quarry_Rent_ID();

	public I_TF_Quarry_Rent getTF_Quarry_Rent() throws RuntimeException;

    /** Column name TF_RMSubcon_Movement_ID */
    public static final String COLUMNNAME_TF_RMSubcon_Movement_ID = "TF_RMSubcon_Movement_ID";

	/** Set Subcontract Material Movement	  */
	public void setTF_RMSubcon_Movement_ID (int TF_RMSubcon_Movement_ID);

	/** Get Subcontract Material Movement	  */
	public int getTF_RMSubcon_Movement_ID();

	public I_TF_RMSubcon_Movement getTF_RMSubcon_Movement() throws RuntimeException;

    /** Column name TF_Send_To */
    public static final String COLUMNNAME_TF_Send_To = "TF_Send_To";

	/** Set Send To	  */
	public void setTF_Send_To (String TF_Send_To);

	/** Get Send To	  */
	public String getTF_Send_To();

    /** Column name TF_Vehicle_Rent_ID */
    public static final String COLUMNNAME_TF_Vehicle_Rent_ID = "TF_Vehicle_Rent_ID";

	/** Set Vehicle Rent	  */
	public void setTF_Vehicle_Rent_ID (int TF_Vehicle_Rent_ID);

	/** Get Vehicle Rent	  */
	public int getTF_Vehicle_Rent_ID();

	public I_TF_Vehicle_Rent getTF_Vehicle_Rent() throws RuntimeException;

    /** Column name TF_WeighmentEntry_ID */
    public static final String COLUMNNAME_TF_WeighmentEntry_ID = "TF_WeighmentEntry_ID";

	/** Set Weighment Entry	  */
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID);

	/** Get Weighment Entry	  */
	public int getTF_WeighmentEntry_ID();

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException;

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name Vehicle_ID */
    public static final String COLUMNNAME_Vehicle_ID = "Vehicle_ID";

	/** Set Vehicle	  */
	public void setVehicle_ID (int Vehicle_ID);

	/** Get Vehicle	  */
	public int getVehicle_ID();

	public org.compiere.model.I_M_Product getVehicle() throws RuntimeException;

    /** Column name Vehicle_Rent_Journal_ID */
    public static final String COLUMNNAME_Vehicle_Rent_Journal_ID = "Vehicle_Rent_Journal_ID";

	/** Set Vehicle Rent Journal	  */
	public void setVehicle_Rent_Journal_ID (int Vehicle_Rent_Journal_ID);

	/** Get Vehicle Rent Journal	  */
	public int getVehicle_Rent_Journal_ID();

	public org.compiere.model.I_GL_Journal getVehicle_Rent_Journal() throws RuntimeException;

    /** Column name VehicleNo */
    public static final String COLUMNNAME_VehicleNo = "VehicleNo";

	/** Set Vehicle No	  */
	public void setVehicleNo (String VehicleNo);

	/** Get Vehicle No	  */
	public String getVehicleNo();
}
