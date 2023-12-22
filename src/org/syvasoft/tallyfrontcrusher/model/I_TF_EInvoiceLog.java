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

/** Generated Interface for TF_EInvoiceLog
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_EInvoiceLog 
{

    /** TableName=TF_EInvoiceLog */
    public static final String Table_Name = "TF_EInvoiceLog";

    /** AD_Table_ID=1000390 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

    /** Load Meta Data */

    /** Column name AckDt */
    public static final String COLUMNNAME_AckDt = "AckDt";

	/** Set AckDt	  */
	public void setAckDt (String AckDt);

	/** Get AckDt	  */
	public String getAckDt();

    /** Column name AckNo */
    public static final String COLUMNNAME_AckNo = "AckNo";

	/** Set AckNo	  */
	public void setAckNo (String AckNo);

	/** Get AckNo	  */
	public String getAckNo();

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

    /** Column name AD_PInstance_ID */
    public static final String COLUMNNAME_AD_PInstance_ID = "AD_PInstance_ID";

	/** Set Process Instance.
	  * Instance of the process
	  */
	public void setAD_PInstance_ID (int AD_PInstance_ID);

	/** Get Process Instance.
	  * Instance of the process
	  */
	public int getAD_PInstance_ID();

	public org.compiere.model.I_AD_PInstance getAD_PInstance() throws RuntimeException;

    /** Column name AD_Table_ID */
    public static final String COLUMNNAME_AD_Table_ID = "AD_Table_ID";

	/** Set Table.
	  * Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID);

	/** Get Table.
	  * Database Table information
	  */
	public int getAD_Table_ID();

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException;

    /** Column name C_Invoice_ID */
    public static final String COLUMNNAME_C_Invoice_ID = "C_Invoice_ID";

	/** Set Invoice.
	  * Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID);

	/** Get Invoice.
	  * Invoice Identifier
	  */
	public int getC_Invoice_ID();

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException;

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

    /** Column name IRN */
    public static final String COLUMNNAME_IRN = "IRN";

	/** Set IRN	  */
	public void setIRN (String IRN);

	/** Get IRN	  */
	public String getIRN();

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

    /** Column name Record_ID */
    public static final String COLUMNNAME_Record_ID = "Record_ID";

	/** Set Record ID.
	  * Direct internal record ID
	  */
	public void setRecord_ID (int Record_ID);

	/** Get Record ID.
	  * Direct internal record ID
	  */
	public int getRecord_ID();

    /** Column name ResponseText */
    public static final String COLUMNNAME_ResponseText = "ResponseText";

	/** Set Response Text.
	  * Request Response Text
	  */
	public void setResponseText (String ResponseText);

	/** Get Response Text.
	  * Request Response Text
	  */
	public String getResponseText();

    /** Column name SignedQRCode */
    public static final String COLUMNNAME_SignedQRCode = "SignedQRCode";

	/** Set SignedQRCode	  */
	public void setSignedQRCode (String SignedQRCode);

	/** Get SignedQRCode	  */
	public String getSignedQRCode();

    /** Column name TF_EInvoiceLog_ID */
    public static final String COLUMNNAME_TF_EInvoiceLog_ID = "TF_EInvoiceLog_ID";

	/** Set e Invoice Log	  */
	public void setTF_EInvoiceLog_ID (int TF_EInvoiceLog_ID);

	/** Get e Invoice Log	  */
	public int getTF_EInvoiceLog_ID();

    /** Column name TF_EInvoiceLog_UU */
    public static final String COLUMNNAME_TF_EInvoiceLog_UU = "TF_EInvoiceLog_UU";

	/** Set TF_EInvoiceLog_UU	  */
	public void setTF_EInvoiceLog_UU (String TF_EInvoiceLog_UU);

	/** Get TF_EInvoiceLog_UU	  */
	public String getTF_EInvoiceLog_UU();

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
