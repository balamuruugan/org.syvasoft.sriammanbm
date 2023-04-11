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

/** Generated Interface for TF_Vehicle_Rental_Contract
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_TF_Vehicle_Rental_Contract 
{

    /** TableName=TF_Vehicle_Rental_Contract */
    public static final String Table_Name = "TF_Vehicle_Rental_Contract";

    /** AD_Table_ID=1000187 */
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

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Vendor.
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Vendor.
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_Charge_ID */
    public static final String COLUMNNAME_C_Charge_ID = "C_Charge_ID";

	/** Set Charge.
	  * Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID);

	/** Get Charge.
	  * Additional document charges
	  */
	public int getC_Charge_ID();

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException;

    /** Column name C_ElementValue_ID */
    public static final String COLUMNNAME_C_ElementValue_ID = "C_ElementValue_ID";

	/** Set Account Element.
	  * Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID);

	/** Get Account Element.
	  * Account Element
	  */
	public int getC_ElementValue_ID();

	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException;

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

    /** Column name Closing_Meter */
    public static final String COLUMNNAME_Closing_Meter = "Closing_Meter";

	/** Set Closing Meter	  */
	public void setClosing_Meter (BigDecimal Closing_Meter);

	/** Get Closing Meter	  */
	public BigDecimal getClosing_Meter();

    /** Column name Contract_Amt_Act */
    public static final String COLUMNNAME_Contract_Amt_Act = "Contract_Amt_Act";

	/** Set Contract Amt (Actual)	  */
	public void setContract_Amt_Act (BigDecimal Contract_Amt_Act);

	/** Get Contract Amt (Actual)	  */
	public BigDecimal getContract_Amt_Act();

    /** Column name Contract_Amt_Est */
    public static final String COLUMNNAME_Contract_Amt_Est = "Contract_Amt_Est";

	/** Set Contract Amt (Estimated)	  */
	public void setContract_Amt_Est (BigDecimal Contract_Amt_Est);

	/** Get Contract Amt (Estimated)	  */
	public BigDecimal getContract_Amt_Est();

    /** Column name ContractBase */
    public static final String COLUMNNAME_ContractBase = "ContractBase";

	/** Set Contract Base.
	  * Represents how the contract amount will be calculated.
	  */
	public void setContractBase (String ContractBase);

	/** Get Contract Base.
	  * Represents how the contract amount will be calculated.
	  */
	public String getContractBase();

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

    /** Column name DateEnd */
    public static final String COLUMNNAME_DateEnd = "DateEnd";

	/** Set End Date	  */
	public void setDateEnd (Timestamp DateEnd);

	/** Get End Date	  */
	public Timestamp getDateEnd();

    /** Column name DateStart */
    public static final String COLUMNNAME_DateStart = "DateStart";

	/** Set Date Start.
	  * Date Start for this Order
	  */
	public void setDateStart (Timestamp DateStart);

	/** Get Date Start.
	  * Date Start for this Order
	  */
	public Timestamp getDateStart();

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

    /** Column name Fuel_Deducted_Qty */
    public static final String COLUMNNAME_Fuel_Deducted_Qty = "Fuel_Deducted_Qty";

	/** Set Fuel Deducted Qty	  */
	public void setFuel_Deducted_Qty (BigDecimal Fuel_Deducted_Qty);

	/** Get Fuel Deducted Qty	  */
	public BigDecimal getFuel_Deducted_Qty();

    /** Column name Fuel_Issued_Total_Qty */
    public static final String COLUMNNAME_Fuel_Issued_Total_Qty = "Fuel_Issued_Total_Qty";

	/** Set Fuel Issued Total Qty	  */
	public void setFuel_Issued_Total_Qty (BigDecimal Fuel_Issued_Total_Qty);

	/** Get Fuel Issued Total Qty	  */
	public BigDecimal getFuel_Issued_Total_Qty();

    /** Column name Fuel_Price */
    public static final String COLUMNNAME_Fuel_Price = "Fuel_Price";

	/** Set Fuel Price	  */
	public void setFuel_Price (BigDecimal Fuel_Price);

	/** Get Fuel Price	  */
	public BigDecimal getFuel_Price();

    /** Column name Fuel_Total_Cost */
    public static final String COLUMNNAME_Fuel_Total_Cost = "Fuel_Total_Cost";

	/** Set Fuel Total Cost	  */
	public void setFuel_Total_Cost (BigDecimal Fuel_Total_Cost);

	/** Get Fuel Total Cost	  */
	public BigDecimal getFuel_Total_Cost();

    /** Column name Invoiced_Amt */
    public static final String COLUMNNAME_Invoiced_Amt = "Invoiced_Amt";

	/** Set Invoiced Amount	  */
	public void setInvoiced_Amt (BigDecimal Invoiced_Amt);

	/** Get Invoiced Amount	  */
	public BigDecimal getInvoiced_Amt();

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

    /** Column name IsFuelIncluded */
    public static final String COLUMNNAME_IsFuelIncluded = "IsFuelIncluded";

	/** Set Fuel Included	  */
	public void setIsFuelIncluded (boolean IsFuelIncluded);

	/** Get Fuel Included	  */
	public boolean isFuelIncluded();

    /** Column name Issued_Fuel */
    public static final String COLUMNNAME_Issued_Fuel = "Issued_Fuel";

	/** Set Issued Fuel	  */
	public void setIssued_Fuel (BigDecimal Issued_Fuel);

	/** Get Issued Fuel	  */
	public BigDecimal getIssued_Fuel();

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

    /** Column name Opening_Fuel */
    public static final String COLUMNNAME_Opening_Fuel = "Opening_Fuel";

	/** Set Opening Fuel	  */
	public void setOpening_Fuel (BigDecimal Opening_Fuel);

	/** Get Opening Fuel	  */
	public BigDecimal getOpening_Fuel();

    /** Column name Opening_Meter */
    public static final String COLUMNNAME_Opening_Meter = "Opening_Meter";

	/** Set Opening Meter	  */
	public void setOpening_Meter (BigDecimal Opening_Meter);

	/** Get Opening Meter	  */
	public BigDecimal getOpening_Meter();

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

    /** Column name Qty */
    public static final String COLUMNNAME_Qty = "Qty";

	/** Set Quantity.
	  * Quantity
	  */
	public void setQty (BigDecimal Qty);

	/** Get Quantity.
	  * Quantity
	  */
	public BigDecimal getQty();

    /** Column name QtyInvoiced */
    public static final String COLUMNNAME_QtyInvoiced = "QtyInvoiced";

	/** Set Quantity Invoiced.
	  * Invoiced Quantity
	  */
	public void setQtyInvoiced (BigDecimal QtyInvoiced);

	/** Get Quantity Invoiced.
	  * Invoiced Quantity
	  */
	public BigDecimal getQtyInvoiced();

    /** Column name Running_Meter */
    public static final String COLUMNNAME_Running_Meter = "Running_Meter";

	/** Set Running Meter	  */
	public void setRunning_Meter (BigDecimal Running_Meter);

	/** Get Running Meter	  */
	public BigDecimal getRunning_Meter();

    /** Column name S_Resource_ID */
    public static final String COLUMNNAME_S_Resource_ID = "S_Resource_ID";

	/** Set Resource.
	  * Resource
	  */
	public void setS_Resource_ID (int S_Resource_ID);

	/** Get Resource.
	  * Resource
	  */
	public int getS_Resource_ID();

	public org.compiere.model.I_S_Resource getS_Resource() throws RuntimeException;

    /** Column name S_ResourceType_ID */
    public static final String COLUMNNAME_S_ResourceType_ID = "S_ResourceType_ID";

	/** Set Resource Type	  */
	public void setS_ResourceType_ID (int S_ResourceType_ID);

	/** Get Resource Type	  */
	public int getS_ResourceType_ID();

	public org.compiere.model.I_S_ResourceType getS_ResourceType() throws RuntimeException;

    /** Column name TF_Vehicle_Rental_Contract_ID */
    public static final String COLUMNNAME_TF_Vehicle_Rental_Contract_ID = "TF_Vehicle_Rental_Contract_ID";

	/** Set Vehicle Rental Contract	  */
	public void setTF_Vehicle_Rental_Contract_ID (int TF_Vehicle_Rental_Contract_ID);

	/** Get Vehicle Rental Contract	  */
	public int getTF_Vehicle_Rental_Contract_ID();

    /** Column name TF_Vehicle_Rental_Contract_UU */
    public static final String COLUMNNAME_TF_Vehicle_Rental_Contract_UU = "TF_Vehicle_Rental_Contract_UU";

	/** Set TF_Vehicle_Rental_Contract_UU	  */
	public void setTF_Vehicle_Rental_Contract_UU (String TF_Vehicle_Rental_Contract_UU);

	/** Get TF_Vehicle_Rental_Contract_UU	  */
	public String getTF_Vehicle_Rental_Contract_UU();

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

    /** Column name VehicleNo */
    public static final String COLUMNNAME_VehicleNo = "VehicleNo";

	/** Set Vehicle No	  */
	public void setVehicleNo (String VehicleNo);

	/** Get Vehicle No	  */
	public String getVehicleNo();
}
