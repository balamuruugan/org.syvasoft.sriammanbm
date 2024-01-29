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

/** Generated Interface for TF_PowerFactorLine
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_TF_PowerFactorLine 
{

    /** TableName=TF_PowerFactorLine */
    public static final String Table_Name = "TF_PowerFactorLine";

    /** AD_Table_ID=1000607 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name closingkvah */
    public static final String COLUMNNAME_closingkvah = "closingkvah";

	/** Set closingkvah	  */
	public void setclosingkvah (BigDecimal closingkvah);

	/** Get closingkvah	  */
	public BigDecimal getclosingkvah();

    /** Column name closingkwh */
    public static final String COLUMNNAME_closingkwh = "closingkwh";

	/** Set closingkwh	  */
	public void setclosingkwh (BigDecimal closingkwh);

	/** Get closingkwh	  */
	public BigDecimal getclosingkwh();

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

    /** Column name kvahusage */
    public static final String COLUMNNAME_kvahusage = "kvahusage";

	/** Set kvahusage	  */
	public void setkvahusage (BigDecimal kvahusage);

	/** Get kvahusage	  */
	public BigDecimal getkvahusage();

    /** Column name kwhusage */
    public static final String COLUMNNAME_kwhusage = "kwhusage";

	/** Set kwhusage	  */
	public void setkwhusage (BigDecimal kwhusage);

	/** Get kwhusage	  */
	public BigDecimal getkwhusage();

    /** Column name openingkvah */
    public static final String COLUMNNAME_openingkvah = "openingkvah";

	/** Set openingkvah	  */
	public void setopeningkvah (BigDecimal openingkvah);

	/** Get openingkvah	  */
	public BigDecimal getopeningkvah();

    /** Column name openingkwh */
    public static final String COLUMNNAME_openingkwh = "openingkwh";

	/** Set openingkwh	  */
	public void setopeningkwh (BigDecimal openingkwh);

	/** Get openingkwh	  */
	public BigDecimal getopeningkwh();

    /** Column name powerfactor */
    public static final String COLUMNNAME_powerfactor = "powerfactor";

	/** Set powerfactor	  */
	public void setpowerfactor (BigDecimal powerfactor);

	/** Get powerfactor	  */
	public BigDecimal getpowerfactor();

    /** Column name TF_PowerFactor_ID */
    public static final String COLUMNNAME_TF_PowerFactor_ID = "TF_PowerFactor_ID";

	/** Set TF_PowerFactor	  */
	public void setTF_PowerFactor_ID (int TF_PowerFactor_ID);

	/** Get TF_PowerFactor	  */
	public int getTF_PowerFactor_ID();

	public I_TF_PowerFactor getTF_PowerFactor() throws RuntimeException;

    /** Column name TF_PowerFactorLine_ID */
    public static final String COLUMNNAME_TF_PowerFactorLine_ID = "TF_PowerFactorLine_ID";

	/** Set PowerFactorLine	  */
	public void setTF_PowerFactorLine_ID (int TF_PowerFactorLine_ID);

	/** Get PowerFactorLine	  */
	public int getTF_PowerFactorLine_ID();

    /** Column name TF_PowerFactorLine_UU */
    public static final String COLUMNNAME_TF_PowerFactorLine_UU = "TF_PowerFactorLine_UU";

	/** Set TF_PowerFactorLine_UU	  */
	public void setTF_PowerFactorLine_UU (String TF_PowerFactorLine_UU);

	/** Get TF_PowerFactorLine_UU	  */
	public String getTF_PowerFactorLine_UU();

    /** Column name unit */
    public static final String COLUMNNAME_unit = "unit";

	/** Set unit	  */
	public void setunit (BigDecimal unit);

	/** Get unit	  */
	public BigDecimal getunit();

    /** Column name UnitFactor */
    public static final String COLUMNNAME_UnitFactor = "UnitFactor";

	/** Set Unit Factor	  */
	public void setUnitFactor (BigDecimal UnitFactor);

	/** Get Unit Factor	  */
	public BigDecimal getUnitFactor();

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
