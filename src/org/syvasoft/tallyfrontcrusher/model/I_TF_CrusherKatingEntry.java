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

/** Generated Interface for TF_CrusherKatingEntry
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_CrusherKatingEntry 
{

    /** TableName=TF_CrusherKatingEntry */
    public static final String Table_Name = "TF_CrusherKatingEntry";

    /** AD_Table_ID=1000269 */
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

    /** Column name KatingEntryType */
    public static final String COLUMNNAME_KatingEntryType = "KatingEntryType";

	/** Set Kating Type	  */
	public void setKatingEntryType (String KatingEntryType);

	/** Get Kating Type	  */
	public String getKatingEntryType();

    /** Column name LoaderInvoice_ID */
    public static final String COLUMNNAME_LoaderInvoice_ID = "LoaderInvoice_ID";

	/** Set Loader Invoice	  */
	public void setLoaderInvoice_ID (int LoaderInvoice_ID);

	/** Get Loader Invoice	  */
	public int getLoaderInvoice_ID();

	public org.compiere.model.I_C_Invoice getLoaderInvoice() throws RuntimeException;

    /** Column name LoaderVehicle_ID */
    public static final String COLUMNNAME_LoaderVehicle_ID = "LoaderVehicle_ID";

	/** Set Loader	  */
	public void setLoaderVehicle_ID (int LoaderVehicle_ID);

	/** Get Loader	  */
	public int getLoaderVehicle_ID();

	public I_TF_RentedVehicle getLoaderVehicle() throws RuntimeException;

    /** Column name Loading_Amount */
    public static final String COLUMNNAME_Loading_Amount = "Loading_Amount";

	/** Set Loading Charge	  */
	public void setLoading_Amount (BigDecimal Loading_Amount);

	/** Get Loading Charge	  */
	public BigDecimal getLoading_Amount();

    /** Column name Loading_Price */
    public static final String COLUMNNAME_Loading_Price = "Loading_Price";

	/** Set Loading Price	  */
	public void setLoading_Price (BigDecimal Loading_Price);

	/** Get Loading Price	  */
	public BigDecimal getLoading_Price();

    /** Column name Loading_UOM_ID */
    public static final String COLUMNNAME_Loading_UOM_ID = "Loading_UOM_ID";

	/** Set Loading Charge Basis	  */
	public void setLoading_UOM_ID (int Loading_UOM_ID);

	/** Get Loading Charge Basis	  */
	public int getLoading_UOM_ID();

	public org.compiere.model.I_C_UOM getLoading_UOM() throws RuntimeException;

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

    /** Column name TF_BlueMetal_Type */
    public static final String COLUMNNAME_TF_BlueMetal_Type = "TF_BlueMetal_Type";

	/** Set Production Type	  */
	public void setTF_BlueMetal_Type (String TF_BlueMetal_Type);

	/** Get Production Type	  */
	public String getTF_BlueMetal_Type();

    /** Column name TF_Crusher_Production_ID */
    public static final String COLUMNNAME_TF_Crusher_Production_ID = "TF_Crusher_Production_ID";

	/** Set Crusher Production	  */
	public void setTF_Crusher_Production_ID (int TF_Crusher_Production_ID);

	/** Get Crusher Production	  */
	public int getTF_Crusher_Production_ID();

	public I_TF_Crusher_Production getTF_Crusher_Production() throws RuntimeException;

    /** Column name TF_CrusherKatingEntry_ID */
    public static final String COLUMNNAME_TF_CrusherKatingEntry_ID = "TF_CrusherKatingEntry_ID";

	/** Set Crusher Kating Entry	  */
	public void setTF_CrusherKatingEntry_ID (int TF_CrusherKatingEntry_ID);

	/** Get Crusher Kating Entry	  */
	public int getTF_CrusherKatingEntry_ID();

    /** Column name TF_CrusherKatingEntry_UU */
    public static final String COLUMNNAME_TF_CrusherKatingEntry_UU = "TF_CrusherKatingEntry_UU";

	/** Set TF_CrusherKatingEntry_UU	  */
	public void setTF_CrusherKatingEntry_UU (String TF_CrusherKatingEntry_UU);

	/** Get TF_CrusherKatingEntry_UU	  */
	public String getTF_CrusherKatingEntry_UU();

    /** Column name TF_ProductionPlant_ID */
    public static final String COLUMNNAME_TF_ProductionPlant_ID = "TF_ProductionPlant_ID";

	/** Set Production Plant	  */
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID);

	/** Get Production Plant	  */
	public int getTF_ProductionPlant_ID();

	public I_TF_ProductionPlant getTF_ProductionPlant() throws RuntimeException;

    /** Column name TF_RentedVehicle_ID */
    public static final String COLUMNNAME_TF_RentedVehicle_ID = "TF_RentedVehicle_ID";

	/** Set Rented Vehicle	  */
	public void setTF_RentedVehicle_ID (int TF_RentedVehicle_ID);

	/** Get Rented Vehicle	  */
	public int getTF_RentedVehicle_ID();

	public I_TF_RentedVehicle getTF_RentedVehicle() throws RuntimeException;

    /** Column name TF_Send_To */
    public static final String COLUMNNAME_TF_Send_To = "TF_Send_To";

	/** Set Send To	  */
	public void setTF_Send_To (String TF_Send_To);

	/** Get Send To	  */
	public String getTF_Send_To();

    /** Column name TF_WeighmentEntry_ID */
    public static final String COLUMNNAME_TF_WeighmentEntry_ID = "TF_WeighmentEntry_ID";

	/** Set Weighment Entry	  */
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID);

	/** Get Weighment Entry	  */
	public int getTF_WeighmentEntry_ID();

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException;

    /** Column name Tonnage */
    public static final String COLUMNNAME_Tonnage = "Tonnage";

	/** Set Tonnage	  */
	public void setTonnage (BigDecimal Tonnage);

	/** Get Tonnage	  */
	public BigDecimal getTonnage();

    /** Column name TotalLoad */
    public static final String COLUMNNAME_TotalLoad = "TotalLoad";

	/** Set Total Load	  */
	public void setTotalLoad (BigDecimal TotalLoad);

	/** Get Total Load	  */
	public BigDecimal getTotalLoad();

    /** Column name Transport_Amount */
    public static final String COLUMNNAME_Transport_Amount = "Transport_Amount";

	/** Set Transportaion Charge	  */
	public void setTransport_Amount (BigDecimal Transport_Amount);

	/** Get Transportaion Charge	  */
	public BigDecimal getTransport_Amount();

    /** Column name Transport_Price */
    public static final String COLUMNNAME_Transport_Price = "Transport_Price";

	/** Set Transport Price	  */
	public void setTransport_Price (BigDecimal Transport_Price);

	/** Get Transport Price	  */
	public BigDecimal getTransport_Price();

    /** Column name Transport_UOM_ID */
    public static final String COLUMNNAME_Transport_UOM_ID = "Transport_UOM_ID";

	/** Set Tranport Charge Basis	  */
	public void setTransport_UOM_ID (int Transport_UOM_ID);

	/** Get Tranport Charge Basis	  */
	public int getTransport_UOM_ID();

	public org.compiere.model.I_C_UOM getTransport_UOM() throws RuntimeException;

    /** Column name TransporterInvoice_ID */
    public static final String COLUMNNAME_TransporterInvoice_ID = "TransporterInvoice_ID";

	/** Set Transporter Invoice	  */
	public void setTransporterInvoice_ID (int TransporterInvoice_ID);

	/** Get Transporter Invoice	  */
	public int getTransporterInvoice_ID();

	public org.compiere.model.I_C_Invoice getTransporterInvoice() throws RuntimeException;

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
}
