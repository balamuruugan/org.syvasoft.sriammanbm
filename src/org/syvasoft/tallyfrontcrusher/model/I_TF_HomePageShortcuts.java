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

/** Generated Interface for TF_HomePageShortcuts
 *  @author iDempiere (generated) 
 *  @version Release 4.1
 */
@SuppressWarnings("all")
public interface I_TF_HomePageShortcuts 
{

    /** TableName=TF_HomePageShortcuts */
    public static final String Table_Name = "TF_HomePageShortcuts";

    /** AD_Table_ID=1000225 */
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

    /** Column name AD_Role_ID */
    public static final String COLUMNNAME_AD_Role_ID = "AD_Role_ID";

	/** Set Role.
	  * Responsibility Role
	  */
	public void setAD_Role_ID (int AD_Role_ID);

	/** Get Role.
	  * Responsibility Role
	  */
	public int getAD_Role_ID();

	public org.compiere.model.I_AD_Role getAD_Role() throws RuntimeException;

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

    /** Column name Info_Menu_ID */
    public static final String COLUMNNAME_Info_Menu_ID = "Info_Menu_ID";

	/** Set Info Window	  */
	public void setInfo_Menu_ID (int Info_Menu_ID);

	/** Get Info Window	  */
	public int getInfo_Menu_ID();

	public org.compiere.model.I_AD_Menu getInfo_Menu() throws RuntimeException;

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

    /** Column name Rpt_Menu_ID */
    public static final String COLUMNNAME_Rpt_Menu_ID = "Rpt_Menu_ID";

	/** Set Report	  */
	public void setRpt_Menu_ID (int Rpt_Menu_ID);

	/** Get Report	  */
	public int getRpt_Menu_ID();

	public org.compiere.model.I_AD_Menu getRpt_Menu() throws RuntimeException;

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public int getSeqNo();

    /** Column name TF_HomePageShortcuts_ID */
    public static final String COLUMNNAME_TF_HomePageShortcuts_ID = "TF_HomePageShortcuts_ID";

	/** Set Home Page Shortcuts	  */
	public void setTF_HomePageShortcuts_ID (int TF_HomePageShortcuts_ID);

	/** Get Home Page Shortcuts	  */
	public int getTF_HomePageShortcuts_ID();

    /** Column name TF_HomePageShortcuts_UU */
    public static final String COLUMNNAME_TF_HomePageShortcuts_UU = "TF_HomePageShortcuts_UU";

	/** Set TF_HomePageShortcuts_UU	  */
	public void setTF_HomePageShortcuts_UU (String TF_HomePageShortcuts_UU);

	/** Get TF_HomePageShortcuts_UU	  */
	public String getTF_HomePageShortcuts_UU();

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

    /** Column name Win_Menu_ID */
    public static final String COLUMNNAME_Win_Menu_ID = "Win_Menu_ID";

	/** Set Window	  */
	public void setWin_Menu_ID (int Win_Menu_ID);

	/** Get Window	  */
	public int getWin_Menu_ID();

	public org.compiere.model.I_AD_Menu getWin_Menu() throws RuntimeException;
}
