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

/** Generated Interface for TF_SubcontractType
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_SubcontractType 
{

    /** TableName=TF_SubcontractType */
    public static final String Table_Name = "TF_SubcontractType";

    /** AD_Table_ID=1000228 */
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

    /** Column name CreateBoulderReceipt */
    public static final String COLUMNNAME_CreateBoulderReceipt = "CreateBoulderReceipt";

	/** Set Create Boulder Receipt	  */
	public void setCreateBoulderReceipt (boolean CreateBoulderReceipt);

	/** Get Create Boulder Receipt	  */
	public boolean isCreateBoulderReceipt();

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

    /** Column name CreateInvFromKating */
    public static final String COLUMNNAME_CreateInvFromKating = "CreateInvFromKating";

	/** Set Create Invoice From Kating	  */
	public void setCreateInvFromKating (boolean CreateInvFromKating);

	/** Get Create Invoice From Kating	  */
	public boolean isCreateInvFromKating();

    /** Column name CreateInvFromSales */
    public static final String COLUMNNAME_CreateInvFromSales = "CreateInvFromSales";

	/** Set Create Invoice From Sales	  */
	public void setCreateInvFromSales (boolean CreateInvFromSales);

	/** Get Create Invoice From Sales	  */
	public boolean isCreateInvFromSales();

    /** Column name CreateMRFromSales */
    public static final String COLUMNNAME_CreateMRFromSales = "CreateMRFromSales";

	/** Set Create Material Receipt From Sales	  */
	public void setCreateMRFromSales (boolean CreateMRFromSales);

	/** Get Create Material Receipt From Sales	  */
	public boolean isCreateMRFromSales();

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

    /** Column name IncludeRMProduction */
    public static final String COLUMNNAME_IncludeRMProduction = "IncludeRMProduction";

	/** Set Include Raw Material Production.
	  * Indicates that there is Weighment Entry for Raw Material Incoming
	  */
	public void setIncludeRMProduction (boolean IncludeRMProduction);

	/** Get Include Raw Material Production.
	  * Indicates that there is Weighment Entry for Raw Material Incoming
	  */
	public boolean isIncludeRMProduction();

    /** Column name InvoiceFor */
    public static final String COLUMNNAME_InvoiceFor = "InvoiceFor";

	/** Set Invoice For	  */
	public void setInvoiceFor (String InvoiceFor);

	/** Get Invoice For	  */
	public String getInvoiceFor();

    /** Column name InvoicePriceFrom */
    public static final String COLUMNNAME_InvoicePriceFrom = "InvoicePriceFrom";

	/** Set Invoice Price From	  */
	public void setInvoicePriceFrom (String InvoicePriceFrom);

	/** Get Invoice Price From	  */
	public String getInvoicePriceFrom();

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

    /** Column name SubcontractType */
    public static final String COLUMNNAME_SubcontractType = "SubcontractType";

	/** Set Subcontract Type	  */
	public void setSubcontractType (String SubcontractType);

	/** Get Subcontract Type	  */
	public String getSubcontractType();

    /** Column name TF_SubcontractType_ID */
    public static final String COLUMNNAME_TF_SubcontractType_ID = "TF_SubcontractType_ID";

	/** Set Subcontract Type	  */
	public void setTF_SubcontractType_ID (int TF_SubcontractType_ID);

	/** Get Subcontract Type	  */
	public int getTF_SubcontractType_ID();

    /** Column name TF_SubcontractType_UU */
    public static final String COLUMNNAME_TF_SubcontractType_UU = "TF_SubcontractType_UU";

	/** Set TF_SubcontractType_UU	  */
	public void setTF_SubcontractType_UU (String TF_SubcontractType_UU);

	/** Get TF_SubcontractType_UU	  */
	public String getTF_SubcontractType_UU();

    /** Column name TrackMaterialMovement */
    public static final String COLUMNNAME_TrackMaterialMovement = "TrackMaterialMovement";

	/** Set Track Material Movement	  */
	public void setTrackMaterialMovement (boolean TrackMaterialMovement);

	/** Get Track Material Movement	  */
	public boolean isTrackMaterialMovement();

    /** Column name UnbilledKatingJobworkAcct_ID */
    public static final String COLUMNNAME_UnbilledKatingJobworkAcct_ID = "UnbilledKatingJobworkAcct_ID";

	/** Set Unbilled Kating Jobwork Account	  */
	public void setUnbilledKatingJobworkAcct_ID (int UnbilledKatingJobworkAcct_ID);

	/** Get Unbilled Kating Jobwork Account	  */
	public int getUnbilledKatingJobworkAcct_ID();

	public org.compiere.model.I_C_ElementValue getUnbilledKatingJobworkAcct() throws RuntimeException;

    /** Column name UnbillKatingReceivableAcct_ID */
    public static final String COLUMNNAME_UnbillKatingReceivableAcct_ID = "UnbillKatingReceivableAcct_ID";

	/** Set Unbilled Kating Jobwork Receivable	  */
	public void setUnbillKatingReceivableAcct_ID (int UnbillKatingReceivableAcct_ID);

	/** Get Unbilled Kating Jobwork Receivable	  */
	public int getUnbillKatingReceivableAcct_ID();

	public org.compiere.model.I_C_ElementValue getUnbillKatingReceivableAcct() throws RuntimeException;

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
