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

/** Generated Interface for M_Product
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_M_Product 
{

    /** TableName=M_Product */
    public static final String Table_Name = "M_Product";

    /** AD_Table_ID=208 */
    public static final int Table_ID = 208;

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

    /** Column name AggregateOSQty */
    public static final String COLUMNNAME_AggregateOSQty = "AggregateOSQty";

	/** Set Aggregate Opening Stock Qty.
	  * This opening stock qty is in the Aggregate Material Movement Report as opening stock
	  */
	public void setAggregateOSQty (BigDecimal AggregateOSQty);

	/** Get Aggregate Opening Stock Qty.
	  * This opening stock qty is in the Aggregate Material Movement Report as opening stock
	  */
	public BigDecimal getAggregateOSQty();

    /** Column name BillPrice */
    public static final String COLUMNNAME_BillPrice = "BillPrice";

	/** Set Bill Price	  */
	public void setBillPrice (BigDecimal BillPrice);

	/** Get Bill Price	  */
	public BigDecimal getBillPrice();

    /** Column name C_RevenueRecognition_ID */
    public static final String COLUMNNAME_C_RevenueRecognition_ID = "C_RevenueRecognition_ID";

	/** Set Revenue Recognition.
	  * Method for recording revenue
	  */
	public void setC_RevenueRecognition_ID (int C_RevenueRecognition_ID);

	/** Get Revenue Recognition.
	  * Method for recording revenue
	  */
	public int getC_RevenueRecognition_ID();

	public org.compiere.model.I_C_RevenueRecognition getC_RevenueRecognition() throws RuntimeException;

    /** Column name C_SubscriptionType_ID */
    public static final String COLUMNNAME_C_SubscriptionType_ID = "C_SubscriptionType_ID";

	/** Set Subscription Type.
	  * Type of subscription
	  */
	public void setC_SubscriptionType_ID (int C_SubscriptionType_ID);

	/** Get Subscription Type.
	  * Type of subscription
	  */
	public int getC_SubscriptionType_ID();

	public org.compiere.model.I_C_SubscriptionType getC_SubscriptionType() throws RuntimeException;

    /** Column name C_TaxCategory_ID */
    public static final String COLUMNNAME_C_TaxCategory_ID = "C_TaxCategory_ID";

	/** Set Tax Category.
	  * Tax Category
	  */
	public void setC_TaxCategory_ID (int C_TaxCategory_ID);

	/** Get Tax Category.
	  * Tax Category
	  */
	public int getC_TaxCategory_ID();

	public org.compiere.model.I_C_TaxCategory getC_TaxCategory() throws RuntimeException;

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

    /** Column name CashSalesPrice */
    public static final String COLUMNNAME_CashSalesPrice = "CashSalesPrice";

	/** Set Cash Sales Price	  */
	public void setCashSalesPrice (BigDecimal CashSalesPrice);

	/** Get Cash Sales Price	  */
	public BigDecimal getCashSalesPrice();

    /** Column name Classification */
    public static final String COLUMNNAME_Classification = "Classification";

	/** Set Classification.
	  * Classification for grouping
	  */
	public void setClassification (String Classification);

	/** Get Classification.
	  * Classification for grouping
	  */
	public String getClassification();

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

    /** Column name CostAdj_Inventory_ID */
    public static final String COLUMNNAME_CostAdj_Inventory_ID = "CostAdj_Inventory_ID";

	/** Set Cost Adjustment	  */
	public void setCostAdj_Inventory_ID (int CostAdj_Inventory_ID);

	/** Get Cost Adjustment	  */
	public int getCostAdj_Inventory_ID();

	public org.compiere.model.I_M_Inventory getCostAdj_Inventory() throws RuntimeException;

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

    /** Column name DescriptionURL */
    public static final String COLUMNNAME_DescriptionURL = "DescriptionURL";

	/** Set Description URL.
	  * URL for the description
	  */
	public void setDescriptionURL (String DescriptionURL);

	/** Get Description URL.
	  * URL for the description
	  */
	public String getDescriptionURL();

    /** Column name Discontinued */
    public static final String COLUMNNAME_Discontinued = "Discontinued";

	/** Set Discontinued.
	  * This product is no longer available
	  */
	public void setDiscontinued (boolean Discontinued);

	/** Get Discontinued.
	  * This product is no longer available
	  */
	public boolean isDiscontinued();

    /** Column name DiscontinuedAt */
    public static final String COLUMNNAME_DiscontinuedAt = "DiscontinuedAt";

	/** Set Discontinued At.
	  * Discontinued At indicates Date when product was discontinued
	  */
	public void setDiscontinuedAt (Timestamp DiscontinuedAt);

	/** Get Discontinued At.
	  * Discontinued At indicates Date when product was discontinued
	  */
	public Timestamp getDiscontinuedAt();

    /** Column name DiscontinuedBy */
    public static final String COLUMNNAME_DiscontinuedBy = "DiscontinuedBy";

	/** Set Discontinued by.
	  * Discontinued By
	  */
	public void setDiscontinuedBy (Timestamp DiscontinuedBy);

	/** Get Discontinued by.
	  * Discontinued By
	  */
	public Timestamp getDiscontinuedBy();

    /** Column name DocumentNote */
    public static final String COLUMNNAME_DocumentNote = "DocumentNote";

	/** Set Document Note.
	  * Additional information for a Document
	  */
	public void setDocumentNote (String DocumentNote);

	/** Get Document Note.
	  * Additional information for a Document
	  */
	public String getDocumentNote();

    /** Column name DownloadURL */
    public static final String COLUMNNAME_DownloadURL = "DownloadURL";

	/** Set Download URL.
	  * URL of the Download files
	  */
	public void setDownloadURL (String DownloadURL);

	/** Get Download URL.
	  * URL of the Download files
	  */
	public String getDownloadURL();

    /** Column name Group1 */
    public static final String COLUMNNAME_Group1 = "Group1";

	/** Set Group1	  */
	public void setGroup1 (String Group1);

	/** Get Group1	  */
	public String getGroup1();

    /** Column name Group2 */
    public static final String COLUMNNAME_Group2 = "Group2";

	/** Set Group2	  */
	public void setGroup2 (String Group2);

	/** Get Group2	  */
	public String getGroup2();

    /** Column name GSTRate */
    public static final String COLUMNNAME_GSTRate = "GSTRate";

	/** Set GST %	  */
	public void setGSTRate (BigDecimal GSTRate);

	/** Get GST %	  */
	public BigDecimal getGSTRate();

    /** Column name GuaranteeDays */
    public static final String COLUMNNAME_GuaranteeDays = "GuaranteeDays";

	/** Set Guarantee Days.
	  * Number of days the product is guaranteed or available
	  */
	public void setGuaranteeDays (int GuaranteeDays);

	/** Get Guarantee Days.
	  * Number of days the product is guaranteed or available
	  */
	public int getGuaranteeDays();

    /** Column name GuaranteeDaysMin */
    public static final String COLUMNNAME_GuaranteeDaysMin = "GuaranteeDaysMin";

	/** Set Min Guarantee Days.
	  * Minimum number of guarantee days
	  */
	public void setGuaranteeDaysMin (int GuaranteeDaysMin);

	/** Get Min Guarantee Days.
	  * Minimum number of guarantee days
	  */
	public int getGuaranteeDaysMin();

    /** Column name Help */
    public static final String COLUMNNAME_Help = "Help";

	/** Set Comment/Help.
	  * Comment or Hint
	  */
	public void setHelp (String Help);

	/** Get Comment/Help.
	  * Comment or Hint
	  */
	public String getHelp();

    /** Column name HSNCode */
    public static final String COLUMNNAME_HSNCode = "HSNCode";

	/** Set HSN Code	  */
	public void setHSNCode (String HSNCode);

	/** Get HSN Code	  */
	public String getHSNCode();

    /** Column name ImageURL */
    public static final String COLUMNNAME_ImageURL = "ImageURL";

	/** Set Image URL.
	  * URL of  image
	  */
	public void setImageURL (String ImageURL);

	/** Get Image URL.
	  * URL of  image
	  */
	public String getImageURL();

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

    /** Column name IsBOM */
    public static final String COLUMNNAME_IsBOM = "IsBOM";

	/** Set Bill of Materials.
	  * Bill of Materials
	  */
	public void setIsBOM (boolean IsBOM);

	/** Get Bill of Materials.
	  * Bill of Materials
	  */
	public boolean isBOM();

    /** Column name IsDropShip */
    public static final String COLUMNNAME_IsDropShip = "IsDropShip";

	/** Set Drop Shipment.
	  * Drop Shipments are sent from the Vendor directly to the Customer
	  */
	public void setIsDropShip (boolean IsDropShip);

	/** Get Drop Shipment.
	  * Drop Shipments are sent from the Vendor directly to the Customer
	  */
	public boolean isDropShip();

    /** Column name IsExcludeAutoDelivery */
    public static final String COLUMNNAME_IsExcludeAutoDelivery = "IsExcludeAutoDelivery";

	/** Set Exclude Auto Delivery.
	  * Exclude from automatic Delivery
	  */
	public void setIsExcludeAutoDelivery (boolean IsExcludeAutoDelivery);

	/** Get Exclude Auto Delivery.
	  * Exclude from automatic Delivery
	  */
	public boolean isExcludeAutoDelivery();

    /** Column name IsInvoicePrintDetails */
    public static final String COLUMNNAME_IsInvoicePrintDetails = "IsInvoicePrintDetails";

	/** Set Print detail records on invoice .
	  * Print detail BOM elements on the invoice
	  */
	public void setIsInvoicePrintDetails (boolean IsInvoicePrintDetails);

	/** Get Print detail records on invoice .
	  * Print detail BOM elements on the invoice
	  */
	public boolean isInvoicePrintDetails();

    /** Column name IsKanban */
    public static final String COLUMNNAME_IsKanban = "IsKanban";

	/** Set Kanban controlled.
	  * This part is Kanban controlled
	  */
	public void setIsKanban (boolean IsKanban);

	/** Get Kanban controlled.
	  * This part is Kanban controlled
	  */
	public boolean isKanban();

    /** Column name IsManufactured */
    public static final String COLUMNNAME_IsManufactured = "IsManufactured";

	/** Set Manufactured.
	  * This product is manufactured
	  */
	public void setIsManufactured (boolean IsManufactured);

	/** Get Manufactured.
	  * This product is manufactured
	  */
	public boolean isManufactured();

    /** Column name IsOwnBox */
    public static final String COLUMNNAME_IsOwnBox = "IsOwnBox";

	/** Set Own Box	  */
	public void setIsOwnBox (boolean IsOwnBox);

	/** Get Own Box	  */
	public boolean isOwnBox();

    /** Column name IsPhantom */
    public static final String COLUMNNAME_IsPhantom = "IsPhantom";

	/** Set Phantom.
	  * Phantom Component
	  */
	public void setIsPhantom (boolean IsPhantom);

	/** Get Phantom.
	  * Phantom Component
	  */
	public boolean isPhantom();

    /** Column name IsPickListPrintDetails */
    public static final String COLUMNNAME_IsPickListPrintDetails = "IsPickListPrintDetails";

	/** Set Print detail records on pick list.
	  * Print detail BOM elements on the pick list
	  */
	public void setIsPickListPrintDetails (boolean IsPickListPrintDetails);

	/** Get Print detail records on pick list.
	  * Print detail BOM elements on the pick list
	  */
	public boolean isPickListPrintDetails();

    /** Column name IsPurchased */
    public static final String COLUMNNAME_IsPurchased = "IsPurchased";

	/** Set Purchased.
	  * Organization purchases this product
	  */
	public void setIsPurchased (boolean IsPurchased);

	/** Get Purchased.
	  * Organization purchases this product
	  */
	public boolean isPurchased();

    /** Column name IsRented */
    public static final String COLUMNNAME_IsRented = "IsRented";

	/** Set Rented	  */
	public void setIsRented (boolean IsRented);

	/** Get Rented	  */
	public boolean isRented();

    /** Column name IsSelfService */
    public static final String COLUMNNAME_IsSelfService = "IsSelfService";

	/** Set Self-Service.
	  * This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public void setIsSelfService (boolean IsSelfService);

	/** Get Self-Service.
	  * This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public boolean isSelfService();

    /** Column name IsSold */
    public static final String COLUMNNAME_IsSold = "IsSold";

	/** Set Sold.
	  * Organization sells this product
	  */
	public void setIsSold (boolean IsSold);

	/** Get Sold.
	  * Organization sells this product
	  */
	public boolean isSold();

    /** Column name IsStocked */
    public static final String COLUMNNAME_IsStocked = "IsStocked";

	/** Set Stocked.
	  * Organization stocks this product
	  */
	public void setIsStocked (boolean IsStocked);

	/** Get Stocked.
	  * Organization stocks this product
	  */
	public boolean isStocked();

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

    /** Column name istoformule */
    public static final String COLUMNNAME_istoformule = "istoformule";

	/** Set istoformule	  */
	public void setistoformule (boolean istoformule);

	/** Get istoformule	  */
	public boolean istoformule();

    /** Column name IsVerified */
    public static final String COLUMNNAME_IsVerified = "IsVerified";

	/** Set Verified.
	  * The BOM configuration has been verified
	  */
	public void setIsVerified (boolean IsVerified);

	/** Get Verified.
	  * The BOM configuration has been verified
	  */
	public boolean isVerified();

    /** Column name IsWebStoreFeatured */
    public static final String COLUMNNAME_IsWebStoreFeatured = "IsWebStoreFeatured";

	/** Set Featured in Web Store.
	  * If selected, the product is displayed in the initial or any empty search
	  */
	public void setIsWebStoreFeatured (boolean IsWebStoreFeatured);

	/** Get Featured in Web Store.
	  * If selected, the product is displayed in the initial or any empty search
	  */
	public boolean isWebStoreFeatured();

    /** Column name LowLevel */
    public static final String COLUMNNAME_LowLevel = "LowLevel";

	/** Set Low Level.
	  * The Low Level is used to calculate the material plan and determines if a net requirement should be exploited
	  */
	public void setLowLevel (int LowLevel);

	/** Get Low Level.
	  * The Low Level is used to calculate the material plan and determines if a net requirement should be exploited
	  */
	public int getLowLevel();

    /** Column name M_AttributeSet_ID */
    public static final String COLUMNNAME_M_AttributeSet_ID = "M_AttributeSet_ID";

	/** Set Attribute Set.
	  * Product Attribute Set
	  */
	public void setM_AttributeSet_ID (int M_AttributeSet_ID);

	/** Get Attribute Set.
	  * Product Attribute Set
	  */
	public int getM_AttributeSet_ID();

	public org.compiere.model.I_M_AttributeSet getM_AttributeSet() throws RuntimeException;

    /** Column name M_AttributeSetInstance_ID */
    public static final String COLUMNNAME_M_AttributeSetInstance_ID = "M_AttributeSetInstance_ID";

	/** Set Attribute Set Instance.
	  * Product Attribute Set Instance
	  */
	public void setM_AttributeSetInstance_ID (int M_AttributeSetInstance_ID);

	/** Get Attribute Set Instance.
	  * Product Attribute Set Instance
	  */
	public int getM_AttributeSetInstance_ID();

	public I_M_AttributeSetInstance getM_AttributeSetInstance() throws RuntimeException;

    /** Column name M_FreightCategory_ID */
    public static final String COLUMNNAME_M_FreightCategory_ID = "M_FreightCategory_ID";

	/** Set Freight Category.
	  * Category of the Freight
	  */
	public void setM_FreightCategory_ID (int M_FreightCategory_ID);

	/** Get Freight Category.
	  * Category of the Freight
	  */
	public int getM_FreightCategory_ID();

	public org.compiere.model.I_M_FreightCategory getM_FreightCategory() throws RuntimeException;

    /** Column name M_Inventory_ID */
    public static final String COLUMNNAME_M_Inventory_ID = "M_Inventory_ID";

	/** Set Phys.Inventory.
	  * Parameters for a Physical Inventory
	  */
	public void setM_Inventory_ID (int M_Inventory_ID);

	/** Get Phys.Inventory.
	  * Parameters for a Physical Inventory
	  */
	public int getM_Inventory_ID();

	public org.compiere.model.I_M_Inventory getM_Inventory() throws RuntimeException;

    /** Column name M_Locator_ID */
    public static final String COLUMNNAME_M_Locator_ID = "M_Locator_ID";

	/** Set Locator.
	  * Warehouse Locator
	  */
	public void setM_Locator_ID (int M_Locator_ID);

	/** Get Locator.
	  * Warehouse Locator
	  */
	public int getM_Locator_ID();

	public I_M_Locator getM_Locator() throws RuntimeException;

    /** Column name M_PartType_ID */
    public static final String COLUMNNAME_M_PartType_ID = "M_PartType_ID";

	/** Set Part Type	  */
	public void setM_PartType_ID (int M_PartType_ID);

	/** Get Part Type	  */
	public int getM_PartType_ID();

	public org.compiere.model.I_M_PartType getM_PartType() throws RuntimeException;

    /** Column name M_Product_Category_ID */
    public static final String COLUMNNAME_M_Product_Category_ID = "M_Product_Category_ID";

	/** Set Product Category.
	  * Category of a Product
	  */
	public void setM_Product_Category_ID (int M_Product_Category_ID);

	/** Get Product Category.
	  * Category of a Product
	  */
	public int getM_Product_Category_ID();

	public org.compiere.model.I_M_Product_Category getM_Product_Category() throws RuntimeException;

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

    /** Column name M_Product_UU */
    public static final String COLUMNNAME_M_Product_UU = "M_Product_UU";

	/** Set M_Product_UU	  */
	public void setM_Product_UU (String M_Product_UU);

	/** Get M_Product_UU	  */
	public String getM_Product_UU();

    /** Column name M_SerNoCtl_ID */
    public static final String COLUMNNAME_M_SerNoCtl_ID = "M_SerNoCtl_ID";

	/** Set Serial No Control.
	  * Product Serial Number Control
	  */
	public void setM_SerNoCtl_ID (int M_SerNoCtl_ID);

	/** Get Serial No Control.
	  * Product Serial Number Control
	  */
	public int getM_SerNoCtl_ID();

	public org.compiere.model.I_M_SerNoCtl getM_SerNoCtl() throws RuntimeException;

    /** Column name MaintainPermitLedger */
    public static final String COLUMNNAME_MaintainPermitLedger = "MaintainPermitLedger";

	/** Set Maintain Permit Ledger	  */
	public void setMaintainPermitLedger (boolean MaintainPermitLedger);

	/** Get Maintain Permit Ledger	  */
	public boolean isMaintainPermitLedger();

    /** Column name MileageType */
    public static final String COLUMNNAME_MileageType = "MileageType";

	/** Set Mileage Type	  */
	public void setMileageType (String MileageType);

	/** Get Mileage Type	  */
	public String getMileageType();

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

    /** Column name OpeningDate */
    public static final String COLUMNNAME_OpeningDate = "OpeningDate";

	/** Set AS On	  */
	public void setOpeningDate (Timestamp OpeningDate);

	/** Get AS On	  */
	public Timestamp getOpeningDate();

    /** Column name PM_SpareGroup_ID */
    public static final String COLUMNNAME_PM_SpareGroup_ID = "PM_SpareGroup_ID";

	/** Set Spare Group	  */
	public void setPM_SpareGroup_ID (int PM_SpareGroup_ID);

	/** Get Spare Group	  */
	public int getPM_SpareGroup_ID();

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

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

    /** Column name ProductType */
    public static final String COLUMNNAME_ProductType = "ProductType";

	/** Set Product Type.
	  * Type of product
	  */
	public void setProductType (String ProductType);

	/** Get Product Type.
	  * Type of product
	  */
	public String getProductType();

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

    /** Column name R_MailText_ID */
    public static final String COLUMNNAME_R_MailText_ID = "R_MailText_ID";

	/** Set Mail Template.
	  * Text templates for mailings
	  */
	public void setR_MailText_ID (int R_MailText_ID);

	/** Get Mail Template.
	  * Text templates for mailings
	  */
	public int getR_MailText_ID();

	public org.compiere.model.I_R_MailText getR_MailText() throws RuntimeException;

    /** Column name S_ExpenseType_ID */
    public static final String COLUMNNAME_S_ExpenseType_ID = "S_ExpenseType_ID";

	/** Set Expense Type.
	  * Expense report type
	  */
	public void setS_ExpenseType_ID (int S_ExpenseType_ID);

	/** Get Expense Type.
	  * Expense report type
	  */
	public int getS_ExpenseType_ID();

	public org.compiere.model.I_S_ExpenseType getS_ExpenseType() throws RuntimeException;

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

    /** Column name SetOpeningStock */
    public static final String COLUMNNAME_SetOpeningStock = "SetOpeningStock";

	/** Set Set Opening Stock.
	  * Sets Opening Stock for the Product
	  */
	public void setSetOpeningStock (String SetOpeningStock);

	/** Get Set Opening Stock.
	  * Sets Opening Stock for the Product
	  */
	public String getSetOpeningStock();

    /** Column name ShelfDepth */
    public static final String COLUMNNAME_ShelfDepth = "ShelfDepth";

	/** Set Shelf Depth.
	  * Shelf depth required
	  */
	public void setShelfDepth (int ShelfDepth);

	/** Get Shelf Depth.
	  * Shelf depth required
	  */
	public int getShelfDepth();

    /** Column name ShelfHeight */
    public static final String COLUMNNAME_ShelfHeight = "ShelfHeight";

	/** Set Shelf Height.
	  * Shelf height required
	  */
	public void setShelfHeight (BigDecimal ShelfHeight);

	/** Get Shelf Height.
	  * Shelf height required
	  */
	public BigDecimal getShelfHeight();

    /** Column name ShelfWidth */
    public static final String COLUMNNAME_ShelfWidth = "ShelfWidth";

	/** Set Shelf Width.
	  * Shelf width required
	  */
	public void setShelfWidth (int ShelfWidth);

	/** Get Shelf Width.
	  * Shelf width required
	  */
	public int getShelfWidth();

    /** Column name SKU */
    public static final String COLUMNNAME_SKU = "SKU";

	/** Set SKU.
	  * Stock Keeping Unit
	  */
	public void setSKU (String SKU);

	/** Get SKU.
	  * Stock Keeping Unit
	  */
	public String getSKU();

    /** Column name SpareLife_UOM_ID */
    public static final String COLUMNNAME_SpareLife_UOM_ID = "SpareLife_UOM_ID";

	/** Set Spare Life UOM	  */
	public void setSpareLife_UOM_ID (int SpareLife_UOM_ID);

	/** Get Spare Life UOM	  */
	public int getSpareLife_UOM_ID();

	public org.compiere.model.I_C_UOM getSpareLife_UOM() throws RuntimeException;

    /** Column name SpareLIfeGreenLimit */
    public static final String COLUMNNAME_SpareLIfeGreenLimit = "SpareLIfeGreenLimit";

	/** Set Spare LIfe Green Limit	  */
	public void setSpareLIfeGreenLimit (BigDecimal SpareLIfeGreenLimit);

	/** Get Spare LIfe Green Limit	  */
	public BigDecimal getSpareLIfeGreenLimit();

    /** Column name SpareLIfeYellowLimit */
    public static final String COLUMNNAME_SpareLIfeYellowLimit = "SpareLIfeYellowLimit";

	/** Set Spare LIfe Yellow Limit	  */
	public void setSpareLIfeYellowLimit (BigDecimal SpareLIfeYellowLimit);

	/** Get Spare LIfe Yellow Limit	  */
	public BigDecimal getSpareLIfeYellowLimit();

    /** Column name SpareStdLife */
    public static final String COLUMNNAME_SpareStdLife = "SpareStdLife";

	/** Set Spare Standard Life.
	  * Spare Standard Life (in Spare Life UOM)
	  */
	public void setSpareStdLife (BigDecimal SpareStdLife);

	/** Get Spare Standard Life.
	  * Spare Standard Life (in Spare Life UOM)
	  */
	public BigDecimal getSpareStdLife();

    /** Column name Std_Load */
    public static final String COLUMNNAME_Std_Load = "Std_Load";

	/** Set Standard Load	  */
	public void setStd_Load (BigDecimal Std_Load);

	/** Get Standard Load	  */
	public BigDecimal getStd_Load();

    /** Column name TF_VehicleType_ID */
    public static final String COLUMNNAME_TF_VehicleType_ID = "TF_VehicleType_ID";

	/** Set Vehicle Type	  */
	public void setTF_VehicleType_ID (int TF_VehicleType_ID);

	/** Get Vehicle Type	  */
	public int getTF_VehicleType_ID();

    /** Column name TonnagePerUnit */
    public static final String COLUMNNAME_TonnagePerUnit = "TonnagePerUnit";

	/** Set Tonnage Per Unit	  */
	public void setTonnagePerUnit (BigDecimal TonnagePerUnit);

	/** Get Tonnage Per Unit	  */
	public BigDecimal getTonnagePerUnit();

    /** Column name TrackSpareLife */
    public static final String COLUMNNAME_TrackSpareLife = "TrackSpareLife";

	/** Set Track Spare Life	  */
	public void setTrackSpareLife (boolean TrackSpareLife);

	/** Get Track Spare Life	  */
	public boolean isTrackSpareLife();

    /** Column name UnitsPerPack */
    public static final String COLUMNNAME_UnitsPerPack = "UnitsPerPack";

	/** Set UnitsPerPack.
	  * The Units Per Pack indicates the no of units of a product packed together.
	  */
	public void setUnitsPerPack (int UnitsPerPack);

	/** Get UnitsPerPack.
	  * The Units Per Pack indicates the no of units of a product packed together.
	  */
	public int getUnitsPerPack();

    /** Column name UnitsPerPallet */
    public static final String COLUMNNAME_UnitsPerPallet = "UnitsPerPallet";

	/** Set Units Per Pallet.
	  * Units Per Pallet
	  */
	public void setUnitsPerPallet (BigDecimal UnitsPerPallet);

	/** Get Units Per Pallet.
	  * Units Per Pallet
	  */
	public BigDecimal getUnitsPerPallet();

    /** Column name UPC */
    public static final String COLUMNNAME_UPC = "UPC";

	/** Set UPC/EAN.
	  * Bar Code (Universal Product Code or its superset European Article Number)
	  */
	public void setUPC (String UPC);

	/** Get UPC/EAN.
	  * Bar Code (Universal Product Code or its superset European Article Number)
	  */
	public String getUPC();

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

    /** Column name ValueNumber */
    public static final String COLUMNNAME_ValueNumber = "ValueNumber";

	/** Set Value.
	  * Numeric Value
	  */
	public void setValueNumber (BigDecimal ValueNumber);

	/** Get Value.
	  * Numeric Value
	  */
	public BigDecimal getValueNumber();

    /** Column name VersionNo */
    public static final String COLUMNNAME_VersionNo = "VersionNo";

	/** Set Version No.
	  * Version Number
	  */
	public void setVersionNo (String VersionNo);

	/** Get Version No.
	  * Version Number
	  */
	public String getVersionNo();

    /** Column name Volume */
    public static final String COLUMNNAME_Volume = "Volume";

	/** Set Volume.
	  * Volume of a product
	  */
	public void setVolume (BigDecimal Volume);

	/** Get Volume.
	  * Volume of a product
	  */
	public BigDecimal getVolume();

    /** Column name Weight */
    public static final String COLUMNNAME_Weight = "Weight";

	/** Set Weight.
	  * Weight of a product
	  */
	public void setWeight (BigDecimal Weight);

	/** Get Weight.
	  * Weight of a product
	  */
	public BigDecimal getWeight();
}