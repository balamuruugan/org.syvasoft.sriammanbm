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

/** Generated Interface for TF_CounterTrans
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_CounterTrans 
{

    /** TableName=TF_CounterTrans */
    public static final String Table_Name = "TF_CounterTrans";

    /** AD_Table_ID=1000293 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 2 - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(2);

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

    /** Column name CounterTransType */
    public static final String COLUMNNAME_CounterTransType = "CounterTransType";

	/** Set Counter Transaction Type	  */
	public void setCounterTransType (String CounterTransType);

	/** Get Counter Transaction Type	  */
	public String getCounterTransType();

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

    /** Column name Src_Bpartner_ID */
    public static final String COLUMNNAME_Src_Bpartner_ID = "Src_Bpartner_ID";

	/** Set Source Business Partner	  */
	public void setSrc_Bpartner_ID (int Src_Bpartner_ID);

	/** Get Source Business Partner	  */
	public int getSrc_Bpartner_ID();

	public org.compiere.model.I_C_BPartner getSrc_Bpartner() throws RuntimeException;

    /** Column name Src_DocType_ID */
    public static final String COLUMNNAME_Src_DocType_ID = "Src_DocType_ID";

	/** Set Source Document Type	  */
	public void setSrc_DocType_ID (int Src_DocType_ID);

	/** Get Source Document Type	  */
	public int getSrc_DocType_ID();

	public org.compiere.model.I_C_DocType getSrc_DocType() throws RuntimeException;

    /** Column name Src_Org_ID */
    public static final String COLUMNNAME_Src_Org_ID = "Src_Org_ID";

	/** Set Source Organization	  */
	public void setSrc_Org_ID (int Src_Org_ID);

	/** Get Source Organization	  */
	public int getSrc_Org_ID();

    /** Column name TF_CounterTrans_ID */
    public static final String COLUMNNAME_TF_CounterTrans_ID = "TF_CounterTrans_ID";

	/** Set Counter Transaction Setup	  */
	public void setTF_CounterTrans_ID (int TF_CounterTrans_ID);

	/** Get Counter Transaction Setup	  */
	public int getTF_CounterTrans_ID();

    /** Column name TF_CounterTrans_UU */
    public static final String COLUMNNAME_TF_CounterTrans_UU = "TF_CounterTrans_UU";

	/** Set TF_CounterTrans_UU	  */
	public void setTF_CounterTrans_UU (String TF_CounterTrans_UU);

	/** Get TF_CounterTrans_UU	  */
	public String getTF_CounterTrans_UU();

    /** Column name To_Bpartner_ID */
    public static final String COLUMNNAME_To_Bpartner_ID = "To_Bpartner_ID";

	/** Set To Business Partner	  */
	public void setTo_Bpartner_ID (int To_Bpartner_ID);

	/** Get To Business Partner	  */
	public int getTo_Bpartner_ID();

	public org.compiere.model.I_C_BPartner getTo_Bpartner() throws RuntimeException;

    /** Column name To_Doctype_ID */
    public static final String COLUMNNAME_To_Doctype_ID = "To_Doctype_ID";

	/** Set To Document Type	  */
	public void setTo_Doctype_ID (int To_Doctype_ID);

	/** Get To Document Type	  */
	public int getTo_Doctype_ID();

	public org.compiere.model.I_C_DocType getTo_Doctype() throws RuntimeException;

    /** Column name To_Org_ID */
    public static final String COLUMNNAME_To_Org_ID = "To_Org_ID";

	/** Set To Organization	  */
	public void setTo_Org_ID (int To_Org_ID);

	/** Get To Organization	  */
	public int getTo_Org_ID();

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
