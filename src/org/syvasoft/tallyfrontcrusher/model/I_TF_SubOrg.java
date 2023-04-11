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

/** Generated Interface for TF_SubOrg
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_SubOrg 
{

    /** TableName=TF_SubOrg */
    public static final String Table_Name = "TF_SubOrg";

    /** AD_Table_ID=1000291 */
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

    /** Column name Address */
    public static final String COLUMNNAME_Address = "Address";

	/** Set Address	  */
	public void setAddress (String Address);

	/** Get Address	  */
	public String getAddress();

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

    /** Column name ReportHeading */
    public static final String COLUMNNAME_ReportHeading = "ReportHeading";

	/** Set Report Heading	  */
	public void setReportHeading (String ReportHeading);

	/** Get Report Heading	  */
	public String getReportHeading();

    /** Column name TF_SalesTaxInvoiceSequence_ID */
    public static final String COLUMNNAME_TF_SalesTaxInvoiceSequence_ID = "TF_SalesTaxInvoiceSequence_ID";

	/** Set Sales Tax Invoice Sequence	  */
	public void setTF_SalesTaxInvoiceSequence_ID (int TF_SalesTaxInvoiceSequence_ID);

	/** Get Sales Tax Invoice Sequence	  */
	public int getTF_SalesTaxInvoiceSequence_ID();

	public org.compiere.model.I_AD_Sequence getTF_SalesTaxInvoiceSequence() throws RuntimeException;

    /** Column name TF_SubOrg_ID */
    public static final String COLUMNNAME_TF_SubOrg_ID = "TF_SubOrg_ID";

	/** Set Sub Organization	  */
	public void setTF_SubOrg_ID (int TF_SubOrg_ID);

	/** Get Sub Organization	  */
	public int getTF_SubOrg_ID();

    /** Column name TF_SubOrg_UU */
    public static final String COLUMNNAME_TF_SubOrg_UU = "TF_SubOrg_UU";

	/** Set TF_SubOrg_UU	  */
	public void setTF_SubOrg_UU (String TF_SubOrg_UU);

	/** Get TF_SubOrg_UU	  */
	public String getTF_SubOrg_UU();

    /** Column name TF_URDPOSequence_ID */
    public static final String COLUMNNAME_TF_URDPOSequence_ID = "TF_URDPOSequence_ID";

	/** Set URD Purchase Invoice Sequence	  */
	public void setTF_URDPOSequence_ID (int TF_URDPOSequence_ID);

	/** Get URD Purchase Invoice Sequence	  */
	public int getTF_URDPOSequence_ID();

	public org.compiere.model.I_AD_Sequence getTF_URDPOSequence() throws RuntimeException;

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
