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

/** Generated Model for TF_EInvoiceLog
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_EInvoiceLog extends PO implements I_TF_EInvoiceLog, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220413L;

    /** Standard Constructor */
    public X_TF_EInvoiceLog (Properties ctx, int TF_EInvoiceLog_ID, String trxName)
    {
      super (ctx, TF_EInvoiceLog_ID, trxName);
      /** if (TF_EInvoiceLog_ID == 0)
        {
			setTF_EInvoiceLog_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_EInvoiceLog (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
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
      StringBuffer sb = new StringBuffer ("X_TF_EInvoiceLog[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AckDt.
		@param AckDt AckDt	  */
	public void setAckDt (String AckDt)
	{
		set_Value (COLUMNNAME_AckDt, AckDt);
	}

	/** Get AckDt.
		@return AckDt	  */
	public String getAckDt () 
	{
		return (String)get_Value(COLUMNNAME_AckDt);
	}

	/** Set AckNo.
		@param AckNo AckNo	  */
	public void setAckNo (String AckNo)
	{
		set_Value (COLUMNNAME_AckNo, AckNo);
	}

	/** Get AckNo.
		@return AckNo	  */
	public String getAckNo () 
	{
		return (String)get_Value(COLUMNNAME_AckNo);
	}

	public org.compiere.model.I_AD_PInstance getAD_PInstance() throws RuntimeException
    {
		return (org.compiere.model.I_AD_PInstance)MTable.get(getCtx(), org.compiere.model.I_AD_PInstance.Table_Name)
			.getPO(getAD_PInstance_ID(), get_TrxName());	}

	/** Set Process Instance.
		@param AD_PInstance_ID 
		Instance of the process
	  */
	public void setAD_PInstance_ID (int AD_PInstance_ID)
	{
		if (AD_PInstance_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_PInstance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_PInstance_ID, Integer.valueOf(AD_PInstance_ID));
	}

	/** Get Process Instance.
		@return Instance of the process
	  */
	public int getAD_PInstance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_PInstance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Table)MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
			.getPO(getAD_Table_ID(), get_TrxName());	}

	/** Set Table.
		@param AD_Table_ID 
		Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_Table_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set IRN.
		@param IRN IRN	  */
	public void setIRN (String IRN)
	{
		set_ValueNoCheck (COLUMNNAME_IRN, IRN);
	}

	/** Get IRN.
		@return IRN	  */
	public String getIRN () 
	{
		return (String)get_Value(COLUMNNAME_IRN);
	}

	/** Set Record ID.
		@param Record_ID 
		Direct internal record ID
	  */
	public void setRecord_ID (int Record_ID)
	{
		if (Record_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_Record_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Record_ID, Integer.valueOf(Record_ID));
	}

	/** Get Record ID.
		@return Direct internal record ID
	  */
	public int getRecord_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Record_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Response Text.
		@param ResponseText 
		Request Response Text
	  */
	public void setResponseText (String ResponseText)
	{
		set_ValueNoCheck (COLUMNNAME_ResponseText, ResponseText);
	}

	/** Get Response Text.
		@return Request Response Text
	  */
	public String getResponseText () 
	{
		return (String)get_Value(COLUMNNAME_ResponseText);
	}

	/** Set SignedQRCode.
		@param SignedQRCode SignedQRCode	  */
	public void setSignedQRCode (String SignedQRCode)
	{
		set_Value (COLUMNNAME_SignedQRCode, SignedQRCode);
	}

	/** Get SignedQRCode.
		@return SignedQRCode	  */
	public String getSignedQRCode () 
	{
		return (String)get_Value(COLUMNNAME_SignedQRCode);
	}

	/** Set e Invoice Log.
		@param TF_EInvoiceLog_ID e Invoice Log	  */
	public void setTF_EInvoiceLog_ID (int TF_EInvoiceLog_ID)
	{
		if (TF_EInvoiceLog_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_EInvoiceLog_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_EInvoiceLog_ID, Integer.valueOf(TF_EInvoiceLog_ID));
	}

	/** Get e Invoice Log.
		@return e Invoice Log	  */
	public int getTF_EInvoiceLog_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_EInvoiceLog_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_EInvoiceLog_UU.
		@param TF_EInvoiceLog_UU TF_EInvoiceLog_UU	  */
	public void setTF_EInvoiceLog_UU (String TF_EInvoiceLog_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_EInvoiceLog_UU, TF_EInvoiceLog_UU);
	}

	/** Get TF_EInvoiceLog_UU.
		@return TF_EInvoiceLog_UU	  */
	public String getTF_EInvoiceLog_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_EInvoiceLog_UU);
	}
}