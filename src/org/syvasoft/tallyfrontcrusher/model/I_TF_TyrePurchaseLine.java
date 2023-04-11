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

/** Generated Interface for TF_TyrePurchaseLine
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_TF_TyrePurchaseLine 
{

    /** TableName=TF_TyrePurchaseLine */
    public static final String Table_Name = "TF_TyrePurchaseLine";

    /** AD_Table_ID=1000208 */
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

    /** Column name Brand */
    public static final String COLUMNNAME_Brand = "Brand";

	/** Set Brand	  */
	public void setBrand (String Brand);

	/** Get Brand	  */
	public String getBrand();

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

    /** Column name GSTAmount */
    public static final String COLUMNNAME_GSTAmount = "GSTAmount";

	/** Set GST Amount	  */
	public void setGSTAmount (BigDecimal GSTAmount);

	/** Get GST Amount	  */
	public BigDecimal getGSTAmount();

    /** Column name GSTRate */
    public static final String COLUMNNAME_GSTRate = "GSTRate";

	/** Set GST %	  */
	public void setGSTRate (BigDecimal GSTRate);

	/** Get GST %	  */
	public BigDecimal getGSTRate();

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

    /** Column name LineNo */
    public static final String COLUMNNAME_LineNo = "LineNo";

	/** Set Line.
	  * Line No
	  */
	public void setLineNo (int LineNo);

	/** Get Line.
	  * Line No
	  */
	public int getLineNo();

    /** Column name LineTotalAmt */
    public static final String COLUMNNAME_LineTotalAmt = "LineTotalAmt";

	/** Set Line Total.
	  * Total line amount incl. Tax
	  */
	public void setLineTotalAmt (BigDecimal LineTotalAmt);

	/** Get Line Total.
	  * Total line amount incl. Tax
	  */
	public BigDecimal getLineTotalAmt();

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

    /** Column name Size */
    public static final String COLUMNNAME_Size = "Size";

	/** Set Size	  */
	public void setSize (String Size);

	/** Get Size	  */
	public String getSize();

    /** Column name TF_TyrePurchase_ID */
    public static final String COLUMNNAME_TF_TyrePurchase_ID = "TF_TyrePurchase_ID";

	/** Set Tyre Purchase	  */
	public void setTF_TyrePurchase_ID (int TF_TyrePurchase_ID);

	/** Get Tyre Purchase	  */
	public int getTF_TyrePurchase_ID();

	public I_TF_TyrePurchase getTF_TyrePurchase() throws RuntimeException;

    /** Column name TF_TyrePurchaseLine_ID */
    public static final String COLUMNNAME_TF_TyrePurchaseLine_ID = "TF_TyrePurchaseLine_ID";

	/** Set Tyre Purchase Line	  */
	public void setTF_TyrePurchaseLine_ID (int TF_TyrePurchaseLine_ID);

	/** Get Tyre Purchase Line	  */
	public int getTF_TyrePurchaseLine_ID();

    /** Column name TF_TyrePurchaseLine_UU */
    public static final String COLUMNNAME_TF_TyrePurchaseLine_UU = "TF_TyrePurchaseLine_UU";

	/** Set TF_TyrePurchaseLine_UU	  */
	public void setTF_TyrePurchaseLine_UU (String TF_TyrePurchaseLine_UU);

	/** Get TF_TyrePurchaseLine_UU	  */
	public String getTF_TyrePurchaseLine_UU();

    /** Column name TF_TyreType_ID */
    public static final String COLUMNNAME_TF_TyreType_ID = "TF_TyreType_ID";

	/** Set Tyre Type	  */
	public void setTF_TyreType_ID (int TF_TyreType_ID);

	/** Get Tyre Type	  */
	public int getTF_TyreType_ID();

	public I_TF_TyreType getTF_TyreType() throws RuntimeException;

    /** Column name TyreNo */
    public static final String COLUMNNAME_TyreNo = "TyreNo";

	/** Set Tyre No	  */
	public void setTyreNo (String TyreNo);

	/** Get Tyre No	  */
	public String getTyreNo();

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
