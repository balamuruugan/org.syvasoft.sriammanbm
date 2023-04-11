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

/** Generated Interface for C_Project
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_C_Project 
{

    /** TableName=C_Project */
    public static final String Table_Name = "C_Project";

    /** AD_Table_ID=203 */
    public static final int Table_ID = 203;

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

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

    /** Column name AD_OrgLinked_ID */
    public static final String COLUMNNAME_AD_OrgLinked_ID = "AD_OrgLinked_ID";

	/** Set Organization.
	  * LInk Organization
	  */
	public void setAD_OrgLinked_ID (int AD_OrgLinked_ID);

	/** Get Organization.
	  * LInk Organization
	  */
	public int getAD_OrgLinked_ID();

    /** Column name AD_OrgTrx_ID */
    public static final String COLUMNNAME_AD_OrgTrx_ID = "AD_OrgTrx_ID";

	/** Set Trx Organization.
	  * Performing or initiating organization
	  */
	public void setAD_OrgTrx_ID (int AD_OrgTrx_ID);

	/** Get Trx Organization.
	  * Performing or initiating organization
	  */
	public int getAD_OrgTrx_ID();

    /** Column name AD_User_ID */
    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";

	/** Set User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID);

	/** Get User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID();

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException;

    /** Column name C_Activity_ID */
    public static final String COLUMNNAME_C_Activity_ID = "C_Activity_ID";

	/** Set Activity.
	  * Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID);

	/** Get Activity.
	  * Business Activity
	  */
	public int getC_Activity_ID();

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException;

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_BPartner_Location_ID */
    public static final String COLUMNNAME_C_BPartner_Location_ID = "C_BPartner_Location_ID";

	/** Set Partner Location.
	  * Identifies the (ship to) address for this Business Partner
	  */
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID);

	/** Get Partner Location.
	  * Identifies the (ship to) address for this Business Partner
	  */
	public int getC_BPartner_Location_ID();

	public org.compiere.model.I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException;

    /** Column name C_BPartnerSR_ID */
    public static final String COLUMNNAME_C_BPartnerSR_ID = "C_BPartnerSR_ID";

	/** Set BPartner (Agent).
	  * Business Partner (Agent or Sales Rep)
	  */
	public void setC_BPartnerSR_ID (int C_BPartnerSR_ID);

	/** Get BPartner (Agent).
	  * Business Partner (Agent or Sales Rep)
	  */
	public int getC_BPartnerSR_ID();

	public org.compiere.model.I_C_BPartner getC_BPartnerSR() throws RuntimeException;

    /** Column name C_BPartnerSubcon2_ID */
    public static final String COLUMNNAME_C_BPartnerSubcon2_ID = "C_BPartnerSubcon2_ID";

	/** Set Subcontractor 2	  */
	public void setC_BPartnerSubcon2_ID (int C_BPartnerSubcon2_ID);

	/** Get Subcontractor 2	  */
	public int getC_BPartnerSubcon2_ID();

	public org.compiere.model.I_C_BPartner getC_BPartnerSubcon2() throws RuntimeException;

    /** Column name C_Campaign_ID */
    public static final String COLUMNNAME_C_Campaign_ID = "C_Campaign_ID";

	/** Set Campaign.
	  * Marketing Campaign
	  */
	public void setC_Campaign_ID (int C_Campaign_ID);

	/** Get Campaign.
	  * Marketing Campaign
	  */
	public int getC_Campaign_ID();

	public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException;

    /** Column name C_Currency_ID */
    public static final String COLUMNNAME_C_Currency_ID = "C_Currency_ID";

	/** Set Currency.
	  * The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID);

	/** Get Currency.
	  * The Currency for this record
	  */
	public int getC_Currency_ID();

	public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException;

    /** Column name C_DocTypeLink_ID */
    public static final String COLUMNNAME_C_DocTypeLink_ID = "C_DocTypeLink_ID";

	/** Set Link Purchase Invoice Doc Type	  */
	public void setC_DocTypeLink_ID (int C_DocTypeLink_ID);

	/** Get Link Purchase Invoice Doc Type	  */
	public int getC_DocTypeLink_ID();

	public org.compiere.model.I_C_DocType getC_DocTypeLink() throws RuntimeException;

    /** Column name C_DocTypeSalesInvoice_ID */
    public static final String COLUMNNAME_C_DocTypeSalesInvoice_ID = "C_DocTypeSalesInvoice_ID";

	/** Set Sales Invoice Doc Type	  */
	public void setC_DocTypeSalesInvoice_ID (int C_DocTypeSalesInvoice_ID);

	/** Get Sales Invoice Doc Type	  */
	public int getC_DocTypeSalesInvoice_ID();

	public org.compiere.model.I_C_DocType getC_DocTypeSalesInvoice() throws RuntimeException;

    /** Column name C_PaymentTerm_ID */
    public static final String COLUMNNAME_C_PaymentTerm_ID = "C_PaymentTerm_ID";

	/** Set Payment Term.
	  * The terms of Payment (timing, discount)
	  */
	public void setC_PaymentTerm_ID (int C_PaymentTerm_ID);

	/** Get Payment Term.
	  * The terms of Payment (timing, discount)
	  */
	public int getC_PaymentTerm_ID();

	public org.compiere.model.I_C_PaymentTerm getC_PaymentTerm() throws RuntimeException;

    /** Column name C_Phase_ID */
    public static final String COLUMNNAME_C_Phase_ID = "C_Phase_ID";

	/** Set Standard Phase.
	  * Standard Phase of the Project Type
	  */
	public void setC_Phase_ID (int C_Phase_ID);

	/** Get Standard Phase.
	  * Standard Phase of the Project Type
	  */
	public int getC_Phase_ID();

	public org.compiere.model.I_C_Phase getC_Phase() throws RuntimeException;

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

    /** Column name C_Project_UU */
    public static final String COLUMNNAME_C_Project_UU = "C_Project_UU";

	/** Set C_Project_UU	  */
	public void setC_Project_UU (String C_Project_UU);

	/** Get C_Project_UU	  */
	public String getC_Project_UU();

    /** Column name C_ProjectLinked_ID */
    public static final String COLUMNNAME_C_ProjectLinked_ID = "C_ProjectLinked_ID";

	/** Set Link Subcontract	  */
	public void setC_ProjectLinked_ID (int C_ProjectLinked_ID);

	/** Get Link Subcontract	  */
	public int getC_ProjectLinked_ID();

	public org.compiere.model.I_C_Project getC_ProjectLinked() throws RuntimeException;

    /** Column name C_ProjectType_ID */
    public static final String COLUMNNAME_C_ProjectType_ID = "C_ProjectType_ID";

	/** Set Project Type.
	  * Type of the project
	  */
	public void setC_ProjectType_ID (String C_ProjectType_ID);

	/** Get Project Type.
	  * Type of the project
	  */
	public String getC_ProjectType_ID();

    /** Column name C_Tax_ID */
    public static final String COLUMNNAME_C_Tax_ID = "C_Tax_ID";

	/** Set Tax.
	  * Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID);

	/** Get Tax.
	  * Tax identifier
	  */
	public int getC_Tax_ID();

	public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException;

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

    /** Column name CommittedAmt */
    public static final String COLUMNNAME_CommittedAmt = "CommittedAmt";

	/** Set Committed Amount.
	  * The (legal) commitment amount
	  */
	public void setCommittedAmt (BigDecimal CommittedAmt);

	/** Get Committed Amount.
	  * The (legal) commitment amount
	  */
	public BigDecimal getCommittedAmt();

    /** Column name CommittedQty */
    public static final String COLUMNNAME_CommittedQty = "CommittedQty";

	/** Set Committed Quantity.
	  * The (legal) commitment Quantity
	  */
	public void setCommittedQty (BigDecimal CommittedQty);

	/** Get Committed Quantity.
	  * The (legal) commitment Quantity
	  */
	public BigDecimal getCommittedQty();

    /** Column name Contract_Amt_Act */
    public static final String COLUMNNAME_Contract_Amt_Act = "Contract_Amt_Act";

	/** Set Contract Amt (Actual)	  */
	public void setContract_Amt_Act (BigDecimal Contract_Amt_Act);

	/** Get Contract Amt (Actual)	  */
	public BigDecimal getContract_Amt_Act();

    /** Column name CopyFrom */
    public static final String COLUMNNAME_CopyFrom = "CopyFrom";

	/** Set Copy From.
	  * Copy From Record
	  */
	public void setCopyFrom (String CopyFrom);

	/** Get Copy From.
	  * Copy From Record
	  */
	public String getCopyFrom();

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

    /** Column name CreateInvoice */
    public static final String COLUMNNAME_CreateInvoice = "CreateInvoice";

	/** Set Create Invoice	  */
	public void setCreateInvoice (String CreateInvoice);

	/** Get Create Invoice	  */
	public String getCreateInvoice();

    /** Column name CreateSalesInvoice */
    public static final String COLUMNNAME_CreateSalesInvoice = "CreateSalesInvoice";

	/** Set Create Sales Invoice.
	  * Sales Invoice will be created for Purchase Invoice created for the Linked Project.
	  */
	public void setCreateSalesInvoice (boolean CreateSalesInvoice);

	/** Get Create Sales Invoice.
	  * Sales Invoice will be created for Purchase Invoice created for the Linked Project.
	  */
	public boolean isCreateSalesInvoice();

    /** Column name DateContract */
    public static final String COLUMNNAME_DateContract = "DateContract";

	/** Set Contract Date.
	  * The (planned) effective date of this document.
	  */
	public void setDateContract (Timestamp DateContract);

	/** Get Contract Date.
	  * The (planned) effective date of this document.
	  */
	public Timestamp getDateContract();

    /** Column name DateFinish */
    public static final String COLUMNNAME_DateFinish = "DateFinish";

	/** Set Finish Date.
	  * Finish or (planned) completion date
	  */
	public void setDateFinish (Timestamp DateFinish);

	/** Get Finish Date.
	  * Finish or (planned) completion date
	  */
	public Timestamp getDateFinish();

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

    /** Column name GenerateTo */
    public static final String COLUMNNAME_GenerateTo = "GenerateTo";

	/** Set Generate To.
	  * Generate To
	  */
	public void setGenerateTo (String GenerateTo);

	/** Get Generate To.
	  * Generate To
	  */
	public String getGenerateTo();

    /** Column name InvoicedAmt */
    public static final String COLUMNNAME_InvoicedAmt = "InvoicedAmt";

	/** Set Invoiced Amount.
	  * The amount invoiced
	  */
	public void setInvoicedAmt (BigDecimal InvoicedAmt);

	/** Get Invoiced Amount.
	  * The amount invoiced
	  */
	public BigDecimal getInvoicedAmt();

    /** Column name InvoicedQty */
    public static final String COLUMNNAME_InvoicedQty = "InvoicedQty";

	/** Set Quantity Invoiced .
	  * The quantity invoiced
	  */
	public void setInvoicedQty (BigDecimal InvoicedQty);

	/** Get Quantity Invoiced .
	  * The quantity invoiced
	  */
	public BigDecimal getInvoicedQty();

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

    /** Column name IsCommitCeiling */
    public static final String COLUMNNAME_IsCommitCeiling = "IsCommitCeiling";

	/** Set Commitment is Ceiling.
	  * The commitment amount/quantity is the chargeable ceiling 
	  */
	public void setIsCommitCeiling (boolean IsCommitCeiling);

	/** Get Commitment is Ceiling.
	  * The commitment amount/quantity is the chargeable ceiling 
	  */
	public boolean isCommitCeiling();

    /** Column name IsCommitment */
    public static final String COLUMNNAME_IsCommitment = "IsCommitment";

	/** Set Commitment.
	  * Is this document a (legal) commitment?
	  */
	public void setIsCommitment (boolean IsCommitment);

	/** Get Commitment.
	  * Is this document a (legal) commitment?
	  */
	public boolean isCommitment();

    /** Column name IsSOTrx */
    public static final String COLUMNNAME_IsSOTrx = "IsSOTrx";

	/** Set Sales Transaction.
	  * This is a Sales Transaction
	  */
	public void setIsSOTrx (boolean IsSOTrx);

	/** Get Sales Transaction.
	  * This is a Sales Transaction
	  */
	public boolean isSOTrx();

    /** Column name IsSummary */
    public static final String COLUMNNAME_IsSummary = "IsSummary";

	/** Set Summary Level.
	  * This is a summary entity
	  */
	public void setIsSummary (boolean IsSummary);

	/** Get Summary Level.
	  * This is a summary entity
	  */
	public boolean isSummary();

    /** Column name JobWork_Product_ID */
    public static final String COLUMNNAME_JobWork_Product_ID = "JobWork_Product_ID";

	/** Set Job Work	  */
	public void setJobWork_Product_ID (int JobWork_Product_ID);

	/** Get Job Work	  */
	public int getJobWork_Product_ID();

	public org.compiere.model.I_M_Product getJobWork_Product() throws RuntimeException;

    /** Column name JobWorkWOTrans_Product_ID */
    public static final String COLUMNNAME_JobWorkWOTrans_Product_ID = "JobWorkWOTrans_Product_ID";

	/** Set Jobwork w/o Transport	  */
	public void setJobWorkWOTrans_Product_ID (int JobWorkWOTrans_Product_ID);

	/** Get Jobwork w/o Transport	  */
	public int getJobWorkWOTrans_Product_ID();

	public org.compiere.model.I_M_Product getJobWorkWOTrans_Product() throws RuntimeException;

    /** Column name M_PriceList_Version_ID */
    public static final String COLUMNNAME_M_PriceList_Version_ID = "M_PriceList_Version_ID";

	/** Set Price List Version.
	  * Identifies a unique instance of a Price List
	  */
	public void setM_PriceList_Version_ID (int M_PriceList_Version_ID);

	/** Get Price List Version.
	  * Identifies a unique instance of a Price List
	  */
	public int getM_PriceList_Version_ID();

	public org.compiere.model.I_M_PriceList_Version getM_PriceList_Version() throws RuntimeException;

    /** Column name M_ProductSubcon2_ID */
    public static final String COLUMNNAME_M_ProductSubcon2_ID = "M_ProductSubcon2_ID";

	/** Set Product (Subcontract 2)	  */
	public void setM_ProductSubcon2_ID (int M_ProductSubcon2_ID);

	/** Get Product (Subcontract 2)	  */
	public int getM_ProductSubcon2_ID();

	public org.compiere.model.I_M_Product getM_ProductSubcon2() throws RuntimeException;

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

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Note */
    public static final String COLUMNNAME_Note = "Note";

	/** Set Note.
	  * Optional additional user defined information
	  */
	public void setNote (String Note);

	/** Get Note.
	  * Optional additional user defined information
	  */
	public String getNote();

    /** Column name PlannedAmt */
    public static final String COLUMNNAME_PlannedAmt = "PlannedAmt";

	/** Set Planned Amount.
	  * Planned amount for this project
	  */
	public void setPlannedAmt (BigDecimal PlannedAmt);

	/** Get Planned Amount.
	  * Planned amount for this project
	  */
	public BigDecimal getPlannedAmt();

    /** Column name PlannedMarginAmt */
    public static final String COLUMNNAME_PlannedMarginAmt = "PlannedMarginAmt";

	/** Set Planned Margin.
	  * Project's planned margin amount
	  */
	public void setPlannedMarginAmt (BigDecimal PlannedMarginAmt);

	/** Get Planned Margin.
	  * Project's planned margin amount
	  */
	public BigDecimal getPlannedMarginAmt();

    /** Column name PlannedQty */
    public static final String COLUMNNAME_PlannedQty = "PlannedQty";

	/** Set Planned Quantity.
	  * Planned quantity for this project
	  */
	public void setPlannedQty (BigDecimal PlannedQty);

	/** Get Planned Quantity.
	  * Planned quantity for this project
	  */
	public BigDecimal getPlannedQty();

    /** Column name POReference */
    public static final String COLUMNNAME_POReference = "POReference";

	/** Set Order Reference.
	  * Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	  */
	public void setPOReference (String POReference);

	/** Get Order Reference.
	  * Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	  */
	public String getPOReference();

    /** Column name PriceSubcon2 */
    public static final String COLUMNNAME_PriceSubcon2 = "PriceSubcon2";

	/** Set Contract Price (Subcon2)	  */
	public void setPriceSubcon2 (BigDecimal PriceSubcon2);

	/** Get Contract Price (Subcon2)	  */
	public BigDecimal getPriceSubcon2();

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

    /** Column name ProjectBalanceAmt */
    public static final String COLUMNNAME_ProjectBalanceAmt = "ProjectBalanceAmt";

	/** Set Project Balance.
	  * Total Project Balance
	  */
	public void setProjectBalanceAmt (BigDecimal ProjectBalanceAmt);

	/** Get Project Balance.
	  * Total Project Balance
	  */
	public BigDecimal getProjectBalanceAmt();

    /** Column name ProjectCategory */
    public static final String COLUMNNAME_ProjectCategory = "ProjectCategory";

	/** Set Project Category.
	  * Project Category
	  */
	public void setProjectCategory (String ProjectCategory);

	/** Get Project Category.
	  * Project Category
	  */
	public String getProjectCategory();

    /** Column name ProjectLineLevel */
    public static final String COLUMNNAME_ProjectLineLevel = "ProjectLineLevel";

	/** Set Line Level.
	  * Project Line Level
	  */
	public void setProjectLineLevel (String ProjectLineLevel);

	/** Get Line Level.
	  * Project Line Level
	  */
	public String getProjectLineLevel();

    /** Column name ProjInvoiceRule */
    public static final String COLUMNNAME_ProjInvoiceRule = "ProjInvoiceRule";

	/** Set Invoice Rule.
	  * Invoice Rule for the project
	  */
	public void setProjInvoiceRule (String ProjInvoiceRule);

	/** Get Invoice Rule.
	  * Invoice Rule for the project
	  */
	public String getProjInvoiceRule();

    /** Column name QtyProcessed */
    public static final String COLUMNNAME_QtyProcessed = "QtyProcessed";

	/** Set Quantity Processed	  */
	public void setQtyProcessed (BigDecimal QtyProcessed);

	/** Get Quantity Processed	  */
	public BigDecimal getQtyProcessed();

    /** Column name RequiredConsolidateInv */
    public static final String COLUMNNAME_RequiredConsolidateInv = "RequiredConsolidateInv";

	/** Set Requires Consolidate Invoice	  */
	public void setRequiredConsolidateInv (boolean RequiredConsolidateInv);

	/** Get Requires Consolidate Invoice	  */
	public boolean isRequiredConsolidateInv();

    /** Column name RptSubcontract */
    public static final String COLUMNNAME_RptSubcontract = "RptSubcontract";

	/** Set Subcontract Report	  */
	public void setRptSubcontract (String RptSubcontract);

	/** Get Subcontract Report	  */
	public String getRptSubcontract();

    /** Column name SalesRep_ID */
    public static final String COLUMNNAME_SalesRep_ID = "SalesRep_ID";

	/** Set Sales Representative.
	  * Sales Representative or Company Agent
	  */
	public void setSalesRep_ID (int SalesRep_ID);

	/** Get Sales Representative.
	  * Sales Representative or Company Agent
	  */
	public int getSalesRep_ID();

	public org.compiere.model.I_AD_User getSalesRep() throws RuntimeException;

    /** Column name SubcontractType */
    public static final String COLUMNNAME_SubcontractType = "SubcontractType";

	/** Set Subcontract Type	  */
	public void setSubcontractType (String SubcontractType);

	/** Get Subcontract Type	  */
	public String getSubcontractType();

    /** Column name TF_Processing */
    public static final String COLUMNNAME_TF_Processing = "TF_Processing";

	/** Set Process Now	  */
	public void setTF_Processing (String TF_Processing);

	/** Get Process Now	  */
	public String getTF_Processing();

    /** Column name TF_Quarry_ID */
    public static final String COLUMNNAME_TF_Quarry_ID = "TF_Quarry_ID";

	/** Set Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID);

	/** Get Quarry	  */
	public int getTF_Quarry_ID();

    /** Column name TF_SubcontractType_ID */
    public static final String COLUMNNAME_TF_SubcontractType_ID = "TF_SubcontractType_ID";

	/** Set Subcontract Type	  */
	public void setTF_SubcontractType_ID (int TF_SubcontractType_ID);

	/** Get Subcontract Type	  */
	public int getTF_SubcontractType_ID();

    /** Column name UnbilledAmt */
    public static final String COLUMNNAME_UnbilledAmt = "UnbilledAmt";

	/** Set Unbilled Amt	  */
	public void setUnbilledAmt (BigDecimal UnbilledAmt);

	/** Get Unbilled Amt	  */
	public BigDecimal getUnbilledAmt();

    /** Column name UnbilledQty */
    public static final String COLUMNNAME_UnbilledQty = "UnbilledQty";

	/** Set Unbilled Qty	  */
	public void setUnbilledQty (BigDecimal UnbilledQty);

	/** Get Unbilled Qty	  */
	public BigDecimal getUnbilledQty();

    /** Column name Unit_Price */
    public static final String COLUMNNAME_Unit_Price = "Unit_Price";

	/** Set Unit Price	  */
	public void setUnit_Price (BigDecimal Unit_Price);

	/** Get Unit Price	  */
	public BigDecimal getUnit_Price();

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

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();
}
