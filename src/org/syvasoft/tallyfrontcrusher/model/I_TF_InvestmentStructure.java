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

/** Generated Interface for TF_InvestmentStructure
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_InvestmentStructure 
{

    /** TableName=TF_InvestmentStructure */
    public static final String Table_Name = "TF_InvestmentStructure";

    /** AD_Table_ID=1000223 */
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

    /** Column name Balance */
    public static final String COLUMNNAME_Balance = "Balance";

	/** Set Balance	  */
	public void setBalance (BigDecimal Balance);

	/** Get Balance	  */
	public BigDecimal getBalance();

    /** Column name C_ElementValue_ID */
    public static final String COLUMNNAME_C_ElementValue_ID = "C_ElementValue_ID";

	/** Set Account Head.
	  * Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID);

	/** Get Account Head.
	  * Account Element
	  */
	public int getC_ElementValue_ID();

	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException;

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

    /** Column name EstimatedAmount */
    public static final String COLUMNNAME_EstimatedAmount = "EstimatedAmount";

	/** Set Estimated Amount	  */
	public void setEstimatedAmount (BigDecimal EstimatedAmount);

	/** Get Estimated Amount	  */
	public BigDecimal getEstimatedAmount();

    /** Column name EstimatedBalance */
    public static final String COLUMNNAME_EstimatedBalance = "EstimatedBalance";

	/** Set Estimated Balance	  */
	public void setEstimatedBalance (BigDecimal EstimatedBalance);

	/** Get Estimated Balance	  */
	public BigDecimal getEstimatedBalance();

    /** Column name GL_Journal_ID */
    public static final String COLUMNNAME_GL_Journal_ID = "GL_Journal_ID";

	/** Set Journal.
	  * General Ledger Journal
	  */
	public void setGL_Journal_ID (int GL_Journal_ID);

	/** Get Journal.
	  * General Ledger Journal
	  */
	public int getGL_Journal_ID();

	public org.compiere.model.I_GL_Journal getGL_Journal() throws RuntimeException;

    /** Column name GL_JournalInvAcct_ID */
    public static final String COLUMNNAME_GL_JournalInvAcct_ID = "GL_JournalInvAcct_ID";

	/** Set Investment a/c Adj	  */
	public void setGL_JournalInvAcct_ID (int GL_JournalInvAcct_ID);

	/** Get Investment a/c Adj	  */
	public int getGL_JournalInvAcct_ID();

	public org.compiere.model.I_GL_Journal getGL_JournalInvAcct() throws RuntimeException;

    /** Column name GL_JournalSubPartnerAdj_ID */
    public static final String COLUMNNAME_GL_JournalSubPartnerAdj_ID = "GL_JournalSubPartnerAdj_ID";

	/** Set Sub-Shareholder a/c Adj	  */
	public void setGL_JournalSubPartnerAdj_ID (int GL_JournalSubPartnerAdj_ID);

	/** Get Sub-Shareholder a/c Adj	  */
	public int getGL_JournalSubPartnerAdj_ID();

	public org.compiere.model.I_GL_Journal getGL_JournalSubPartnerAdj() throws RuntimeException;

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

    /** Column name Paid_Amount */
    public static final String COLUMNNAME_Paid_Amount = "Paid_Amount";

	/** Set Amount Paid	  */
	public void setPaid_Amount (BigDecimal Paid_Amount);

	/** Get Amount Paid	  */
	public BigDecimal getPaid_Amount();

    /** Column name Payable_Amount */
    public static final String COLUMNNAME_Payable_Amount = "Payable_Amount";

	/** Set Amount Payable	  */
	public void setPayable_Amount (BigDecimal Payable_Amount);

	/** Get Amount Payable	  */
	public BigDecimal getPayable_Amount();

    /** Column name TF_InvestmentStructure_ID */
    public static final String COLUMNNAME_TF_InvestmentStructure_ID = "TF_InvestmentStructure_ID";

	/** Set Investment Struture	  */
	public void setTF_InvestmentStructure_ID (int TF_InvestmentStructure_ID);

	/** Get Investment Struture	  */
	public int getTF_InvestmentStructure_ID();

    /** Column name TF_InvestmentStructure_UU */
    public static final String COLUMNNAME_TF_InvestmentStructure_UU = "TF_InvestmentStructure_UU";

	/** Set TF_InvestmentStructure_UU	  */
	public void setTF_InvestmentStructure_UU (String TF_InvestmentStructure_UU);

	/** Get TF_InvestmentStructure_UU	  */
	public String getTF_InvestmentStructure_UU();

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
