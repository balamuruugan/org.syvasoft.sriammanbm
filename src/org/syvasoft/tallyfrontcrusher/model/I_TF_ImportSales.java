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

/** Generated Interface for TF_ImportSales
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_ImportSales 
{

    /** TableName=TF_ImportSales */
    public static final String Table_Name = "TF_ImportSales";

    /** AD_Table_ID=1000315 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

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

    /** Column name Amount */
    public static final String COLUMNNAME_Amount = "Amount";

	/** Set Amount.
	  * Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount);

	/** Get Amount.
	  * Amount in a defined currency
	  */
	public BigDecimal getAmount();

    /** Column name AmountRec */
    public static final String COLUMNNAME_AmountRec = "AmountRec";

	/** Set Amount Received	  */
	public void setAmountRec (int AmountRec);

	/** Get Amount Received	  */
	public int getAmountRec();

    /** Column name BankMemoNo */
    public static final String COLUMNNAME_BankMemoNo = "BankMemoNo";

	/** Set Bank Memo No	  */
	public void setBankMemoNo (String BankMemoNo);

	/** Get Bank Memo No	  */
	public String getBankMemoNo();

    /** Column name Bill */
    public static final String COLUMNNAME_Bill = "Bill";

	/** Set Bill	  */
	public void setBill (String Bill);

	/** Get Bill	  */
	public String getBill();

    /** Column name BillNo */
    public static final String COLUMNNAME_BillNo = "BillNo";

	/** Set Bill No	  */
	public void setBillNo (String BillNo);

	/** Get Bill No	  */
	public String getBillNo();

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

    /** Column name C_Order_ID */
    public static final String COLUMNNAME_C_Order_ID = "C_Order_ID";

	/** Set Order.
	  * Order
	  */
	public void setC_Order_ID (int C_Order_ID);

	/** Get Order.
	  * Order
	  */
	public int getC_Order_ID();

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException;

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

    /** Column name CashMemoNo */
    public static final String COLUMNNAME_CashMemoNo = "CashMemoNo";

	/** Set Cash Memo No	  */
	public void setCashMemoNo (String CashMemoNo);

	/** Get Cash Memo No	  */
	public String getCashMemoNo();

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

    /** Column name DB */
    public static final String COLUMNNAME_DB = "DB";

	/** Set DB	  */
	public void setDB (String DB);

	/** Get DB	  */
	public String getDB();

    /** Column name DCNo */
    public static final String COLUMNNAME_DCNo = "DCNo";

	/** Set DC No	  */
	public void setDCNo (String DCNo);

	/** Get DC No	  */
	public String getDCNo();

    /** Column name GPNo */
    public static final String COLUMNNAME_GPNo = "GPNo";

	/** Set GP No	  */
	public void setGPNo (String GPNo);

	/** Get GP No	  */
	public String getGPNo();

    /** Column name Imported */
    public static final String COLUMNNAME_Imported = "Imported";

	/** Set Imported	  */
	public void setImported (String Imported);

	/** Get Imported	  */
	public String getImported();

    /** Column name ImportMessage */
    public static final String COLUMNNAME_ImportMessage = "ImportMessage";

	/** Set Import Message	  */
	public void setImportMessage (String ImportMessage);

	/** Get Import Message	  */
	public String getImportMessage();

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

    /** Column name Material */
    public static final String COLUMNNAME_Material = "Material";

	/** Set Material	  */
	public void setMaterial (String Material);

	/** Get Material	  */
	public String getMaterial();

    /** Column name MrsNo */
    public static final String COLUMNNAME_MrsNo = "MrsNo";

	/** Set Mrs No	  */
	public void setMrsNo (String MrsNo);

	/** Get Mrs No	  */
	public String getMrsNo();

    /** Column name NetAmount */
    public static final String COLUMNNAME_NetAmount = "NetAmount";

	/** Set Net Amount	  */
	public void setNetAmount (BigDecimal NetAmount);

	/** Get Net Amount	  */
	public BigDecimal getNetAmount();

    /** Column name PaidBy */
    public static final String COLUMNNAME_PaidBy = "PaidBy";

	/** Set Paid By	  */
	public void setPaidBy (String PaidBy);

	/** Get Paid By	  */
	public String getPaidBy();

    /** Column name PartyName */
    public static final String COLUMNNAME_PartyName = "PartyName";

	/** Set Party Name	  */
	public void setPartyName (String PartyName);

	/** Get Party Name	  */
	public String getPartyName();

    /** Column name Price */
    public static final String COLUMNNAME_Price = "Price";

	/** Set Price.
	  * Price
	  */
	public void setPrice (BigDecimal Price);

	/** Get Price.
	  * Price
	  */
	public BigDecimal getPrice();

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

    /** Column name SNo */
    public static final String COLUMNNAME_SNo = "SNo";

	/** Set S No	  */
	public void setSNo (int SNo);

	/** Get S No	  */
	public int getSNo();

    /** Column name Tax */
    public static final String COLUMNNAME_Tax = "Tax";

	/** Set Tax	  */
	public void setTax (int Tax);

	/** Get Tax	  */
	public int getTax();

    /** Column name TaxAmount */
    public static final String COLUMNNAME_TaxAmount = "TaxAmount";

	/** Set Tax Amount	  */
	public void setTaxAmount (int TaxAmount);

	/** Get Tax Amount	  */
	public int getTaxAmount();

    /** Column name TF_ImportSales_ID */
    public static final String COLUMNNAME_TF_ImportSales_ID = "TF_ImportSales_ID";

	/** Set Import Sales	  */
	public void setTF_ImportSales_ID (int TF_ImportSales_ID);

	/** Get Import Sales	  */
	public int getTF_ImportSales_ID();

    /** Column name TF_ImportSales_UU */
    public static final String COLUMNNAME_TF_ImportSales_UU = "TF_ImportSales_UU";

	/** Set TF_ImportSales_UU	  */
	public void setTF_ImportSales_UU (String TF_ImportSales_UU);

	/** Get TF_ImportSales_UU	  */
	public String getTF_ImportSales_UU();

    /** Column name TF_RentedVehicle_ID */
    public static final String COLUMNNAME_TF_RentedVehicle_ID = "TF_RentedVehicle_ID";

	/** Set Rented Vehicle	  */
	public void setTF_RentedVehicle_ID (int TF_RentedVehicle_ID);

	/** Get Rented Vehicle	  */
	public int getTF_RentedVehicle_ID();

	public I_TF_RentedVehicle getTF_RentedVehicle() throws RuntimeException;

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

    /** Column name VNo */
    public static final String COLUMNNAME_VNo = "VNo";

	/** Set V No	  */
	public void setVNo (String VNo);

	/** Get V No	  */
	public String getVNo();

    /** Column name WeighmentNo */
    public static final String COLUMNNAME_WeighmentNo = "WeighmentNo";

	/** Set Weighment No	  */
	public void setWeighmentNo (String WeighmentNo);

	/** Get Weighment No	  */
	public String getWeighmentNo();
}
