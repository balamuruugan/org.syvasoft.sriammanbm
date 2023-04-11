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

/** Generated Interface for TF_Shareholder
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_Shareholder 
{

    /** TableName=TF_Shareholder */
    public static final String Table_Name = "TF_Shareholder";

    /** AD_Table_ID=1000222 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

    /** Load Meta Data */

    /** Column name AccountGroup_ID */
    public static final String COLUMNNAME_AccountGroup_ID = "AccountGroup_ID";

	/** Set Account Group	  */
	public void setAccountGroup_ID (int AccountGroup_ID);

	/** Get Account Group	  */
	public int getAccountGroup_ID();

	public org.compiere.model.I_C_ElementValue getAccountGroup() throws RuntimeException;

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

    /** Column name Balance */
    public static final String COLUMNNAME_Balance = "Balance";

	/** Set Balance	  */
	public void setBalance (BigDecimal Balance);

	/** Get Balance	  */
	public BigDecimal getBalance();

    /** Column name CapitalAcct_ID */
    public static final String COLUMNNAME_CapitalAcct_ID = "CapitalAcct_ID";

	/** Set Capital A/c	  */
	public void setCapitalAcct_ID (int CapitalAcct_ID);

	/** Get Capital A/c	  */
	public int getCapitalAcct_ID();

	public org.compiere.model.I_C_ElementValue getCapitalAcct() throws RuntimeException;

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

    /** Column name Investment_Receivable */
    public static final String COLUMNNAME_Investment_Receivable = "Investment_Receivable";

	/** Set Investment Receivable	  */
	public void setInvestment_Receivable (BigDecimal Investment_Receivable);

	/** Get Investment Receivable	  */
	public BigDecimal getInvestment_Receivable();

    /** Column name Investment_Received */
    public static final String COLUMNNAME_Investment_Received = "Investment_Received";

	/** Set Investment Received	  */
	public void setInvestment_Received (BigDecimal Investment_Received);

	/** Get Investment Received	  */
	public BigDecimal getInvestment_Received();

    /** Column name InvestmentShare */
    public static final String COLUMNNAME_InvestmentShare = "InvestmentShare";

	/** Set Investment Share (%)	  */
	public void setInvestmentShare (BigDecimal InvestmentShare);

	/** Get Investment Share (%)	  */
	public BigDecimal getInvestmentShare();

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

    /** Column name NameOutstanding */
    public static final String COLUMNNAME_NameOutstanding = "NameOutstanding";

	/** Set Name + Outstanding Balance	  */
	public void setNameOutstanding (String NameOutstanding);

	/** Get Name + Outstanding Balance	  */
	public String getNameOutstanding();

    /** Column name ProfitShare */
    public static final String COLUMNNAME_ProfitShare = "ProfitShare";

	/** Set Profit Share (%)	  */
	public void setProfitShare (BigDecimal ProfitShare);

	/** Get Profit Share (%)	  */
	public BigDecimal getProfitShare();

    /** Column name TF_Shareholder_ID */
    public static final String COLUMNNAME_TF_Shareholder_ID = "TF_Shareholder_ID";

	/** Set Shareholder	  */
	public void setTF_Shareholder_ID (int TF_Shareholder_ID);

	/** Get Shareholder	  */
	public int getTF_Shareholder_ID();

    /** Column name TF_Shareholder_UU */
    public static final String COLUMNNAME_TF_Shareholder_UU = "TF_Shareholder_UU";

	/** Set TF_Shareholder_UU	  */
	public void setTF_Shareholder_UU (String TF_Shareholder_UU);

	/** Get TF_Shareholder_UU	  */
	public String getTF_Shareholder_UU();

    /** Column name TF_ShareholderMain_ID */
    public static final String COLUMNNAME_TF_ShareholderMain_ID = "TF_ShareholderMain_ID";

	/** Set Main Shareholder	  */
	public void setTF_ShareholderMain_ID (int TF_ShareholderMain_ID);

	/** Get Main Shareholder	  */
	public int getTF_ShareholderMain_ID();

	public I_TF_Shareholder getTF_ShareholderMain() throws RuntimeException;

    /** Column name TF_ShareholderType_ID */
    public static final String COLUMNNAME_TF_ShareholderType_ID = "TF_ShareholderType_ID";

	/** Set Shareholder Type	  */
	public void setTF_ShareholderType_ID (int TF_ShareholderType_ID);

	/** Get Shareholder Type	  */
	public int getTF_ShareholderType_ID();

	public I_TF_ShareholderType getTF_ShareholderType() throws RuntimeException;

    /** Column name UnallocatedAmt */
    public static final String COLUMNNAME_UnallocatedAmt = "UnallocatedAmt";

	/** Set Unallocated Amt	  */
	public void setUnallocatedAmt (BigDecimal UnallocatedAmt);

	/** Get Unallocated Amt	  */
	public BigDecimal getUnallocatedAmt();

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
