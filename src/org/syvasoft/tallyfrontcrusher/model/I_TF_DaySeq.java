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

/** Generated Interface for TF_DaySeq
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_TF_DaySeq 
{

    /** TableName=TF_DaySeq */
    public static final String Table_Name = "TF_DaySeq";

    /** AD_Table_ID=1000306 */
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

    /** Column name DateSeq */
    public static final String COLUMNNAME_DateSeq = "DateSeq";

	/** Set Sequence Date	  */
	public void setDateSeq (Timestamp DateSeq);

	/** Get Sequence Date	  */
	public Timestamp getDateSeq();

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

    /** Column name seq */
    public static final String COLUMNNAME_seq = "seq";

	/** Set Seq No	  */
	public void setseq (BigDecimal seq);

	/** Get Seq No	  */
	public BigDecimal getseq();

    /** Column name SeqType */
    public static final String COLUMNNAME_SeqType = "SeqType";

	/** Set Sequence Type	  */
	public void setSeqType (String SeqType);

	/** Get Sequence Type	  */
	public String getSeqType();

    /** Column name TF_DaySeq_ID */
    public static final String COLUMNNAME_TF_DaySeq_ID = "TF_DaySeq_ID";

	/** Set Day wise Sequence No	  */
	public void setTF_DaySeq_ID (int TF_DaySeq_ID);

	/** Get Day wise Sequence No	  */
	public int getTF_DaySeq_ID();

    /** Column name TF_DaySeq_UU */
    public static final String COLUMNNAME_TF_DaySeq_UU = "TF_DaySeq_UU";

	/** Set TF_DaySeq_UU	  */
	public void setTF_DaySeq_UU (String TF_DaySeq_UU);

	/** Get TF_DaySeq_UU	  */
	public String getTF_DaySeq_UU();

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
