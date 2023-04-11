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
/** Generated Model - DO NOT CHANGE */
package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for TF_HomePageShortcuts
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_HomePageShortcuts extends PO implements I_TF_HomePageShortcuts, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171218L;

    /** Standard Constructor */
    public X_TF_HomePageShortcuts (Properties ctx, int TF_HomePageShortcuts_ID, String trxName)
    {
      super (ctx, TF_HomePageShortcuts_ID, trxName);
      /** if (TF_HomePageShortcuts_ID == 0)
        {
			setAD_Role_ID (0);
			setTF_HomePageShortcuts_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_HomePageShortcuts (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_TF_HomePageShortcuts[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Role getAD_Role() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Role)MTable.get(getCtx(), org.compiere.model.I_AD_Role.Table_Name)
			.getPO(getAD_Role_ID(), get_TrxName());	}

	/** Set Role.
		@param AD_Role_ID 
		Responsibility Role
	  */
	public void setAD_Role_ID (int AD_Role_ID)
	{
		if (AD_Role_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_AD_Role_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_Role_ID, Integer.valueOf(AD_Role_ID));
	}

	/** Get Role.
		@return Responsibility Role
	  */
	public int getAD_Role_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Menu getInfo_Menu() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Menu)MTable.get(getCtx(), org.compiere.model.I_AD_Menu.Table_Name)
			.getPO(getInfo_Menu_ID(), get_TrxName());	}

	/** Set Info Window.
		@param Info_Menu_ID Info Window	  */
	public void setInfo_Menu_ID (int Info_Menu_ID)
	{
		if (Info_Menu_ID < 1) 
			set_Value (COLUMNNAME_Info_Menu_ID, null);
		else 
			set_Value (COLUMNNAME_Info_Menu_ID, Integer.valueOf(Info_Menu_ID));
	}

	/** Get Info Window.
		@return Info Window	  */
	public int getInfo_Menu_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Info_Menu_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Menu getRpt_Menu() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Menu)MTable.get(getCtx(), org.compiere.model.I_AD_Menu.Table_Name)
			.getPO(getRpt_Menu_ID(), get_TrxName());	}

	/** Set Report.
		@param Rpt_Menu_ID Report	  */
	public void setRpt_Menu_ID (int Rpt_Menu_ID)
	{
		if (Rpt_Menu_ID < 1) 
			set_Value (COLUMNNAME_Rpt_Menu_ID, null);
		else 
			set_Value (COLUMNNAME_Rpt_Menu_ID, Integer.valueOf(Rpt_Menu_ID));
	}

	/** Get Report.
		@return Report	  */
	public int getRpt_Menu_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Rpt_Menu_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Sequence.
		@param SeqNo 
		Method of ordering records; lowest number comes first
	  */
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Home Page Shortcuts.
		@param TF_HomePageShortcuts_ID Home Page Shortcuts	  */
	public void setTF_HomePageShortcuts_ID (int TF_HomePageShortcuts_ID)
	{
		if (TF_HomePageShortcuts_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_HomePageShortcuts_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_HomePageShortcuts_ID, Integer.valueOf(TF_HomePageShortcuts_ID));
	}

	/** Get Home Page Shortcuts.
		@return Home Page Shortcuts	  */
	public int getTF_HomePageShortcuts_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_HomePageShortcuts_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_HomePageShortcuts_UU.
		@param TF_HomePageShortcuts_UU TF_HomePageShortcuts_UU	  */
	public void setTF_HomePageShortcuts_UU (String TF_HomePageShortcuts_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_HomePageShortcuts_UU, TF_HomePageShortcuts_UU);
	}

	/** Get TF_HomePageShortcuts_UU.
		@return TF_HomePageShortcuts_UU	  */
	public String getTF_HomePageShortcuts_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_HomePageShortcuts_UU);
	}

	public org.compiere.model.I_AD_Menu getWin_Menu() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Menu)MTable.get(getCtx(), org.compiere.model.I_AD_Menu.Table_Name)
			.getPO(getWin_Menu_ID(), get_TrxName());	}

	/** Set Window.
		@param Win_Menu_ID Window	  */
	public void setWin_Menu_ID (int Win_Menu_ID)
	{
		if (Win_Menu_ID < 1) 
			set_Value (COLUMNNAME_Win_Menu_ID, null);
		else 
			set_Value (COLUMNNAME_Win_Menu_ID, Integer.valueOf(Win_Menu_ID));
	}

	/** Get Window.
		@return Window	  */
	public int getWin_Menu_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Win_Menu_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}