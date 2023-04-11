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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for TF_WeighmentEntry_Payment
 *  @author iDempiere (generated) 
 *  @version Release 9 - $Id$ */
@org.adempiere.base.Model(table="TF_WeighmentEntry_Payment")
public class X_TF_WeighmentEntry_Payment extends PO implements I_TF_WeighmentEntry_Payment, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230105L;

    /** Standard Constructor */
    public X_TF_WeighmentEntry_Payment (Properties ctx, int TF_WeighmentEntry_Payment_ID, String trxName)
    {
      super (ctx, TF_WeighmentEntry_Payment_ID, trxName);
      /** if (TF_WeighmentEntry_Payment_ID == 0)
        {
			setAmount (Env.ZERO);
			setTenderType (null);
			setTF_WeighmentEntry_ID (0);
			setTF_WeighmentEntry_Payment_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_WeighmentEntry_Payment (Properties ctx, int TF_WeighmentEntry_Payment_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_WeighmentEntry_Payment_ID, trxName, virtualColumns);
      /** if (TF_WeighmentEntry_Payment_ID == 0)
        {
			setAmount (Env.ZERO);
			setTenderType (null);
			setTF_WeighmentEntry_ID (0);
			setTF_WeighmentEntry_Payment_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_WeighmentEntry_Payment (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
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
      StringBuilder sb = new StringBuilder ("X_TF_WeighmentEntry_Payment[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Amount.
		@param Amount Amount in a defined currency
	*/
	public void setAmount (BigDecimal Amount)
	{
		set_Value (COLUMNNAME_Amount, Amount);
	}

	/** Get Amount.
		@return Amount in a defined currency
	  */
	public BigDecimal getAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** TenderType AD_Reference_ID=214 */
	public static final int TENDERTYPE_AD_Reference_ID=214;
	/** Direct Deposit = A */
	public static final String TENDERTYPE_DirectDeposit = "A";
	/** Credit Card = C */
	public static final String TENDERTYPE_CreditCard = "C";
	/** Direct Debit = D */
	public static final String TENDERTYPE_DirectDebit = "D";
	/** GPay = G */
	public static final String TENDERTYPE_GPay = "G";
	/** IMPS = I */
	public static final String TENDERTYPE_IMPS = "I";
	/** Check = K */
	public static final String TENDERTYPE_Check = "K";
	/** NEFT = N */
	public static final String TENDERTYPE_NEFT = "N";
	/** PayTM = P */
	public static final String TENDERTYPE_PayTM = "P";
	/** RTGS = R */
	public static final String TENDERTYPE_RTGS = "R";
	/** Account = T */
	public static final String TENDERTYPE_Account = "T";
	/** UPI = U */
	public static final String TENDERTYPE_UPI = "U";
	/** Cash = X */
	public static final String TENDERTYPE_Cash = "X";
	/** Set Tender type.
		@param TenderType Method of Payment
	*/
	public void setTenderType (String TenderType)
	{

		set_ValueNoCheck (COLUMNNAME_TenderType, TenderType);
	}

	/** Get Tender type.
		@return Method of Payment
	  */
	public String getTenderType()
	{
		return (String)get_Value(COLUMNNAME_TenderType);
	}

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException
	{
		return (I_TF_WeighmentEntry)MTable.get(getCtx(), I_TF_WeighmentEntry.Table_ID)
			.getPO(getTF_WeighmentEntry_ID(), get_TrxName());
	}

	/** Set Weighment Entry.
		@param TF_WeighmentEntry_ID Weighment Entry
	*/
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID)
	{
		if (TF_WeighmentEntry_ID < 1)
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, null);
		else
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, Integer.valueOf(TF_WeighmentEntry_ID));
	}

	/** Get Weighment Entry.
		@return Weighment Entry	  */
	public int getTF_WeighmentEntry_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_WeighmentEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Weighment Entry Payment.
		@param TF_WeighmentEntry_Payment_ID Weighment Entry Payment
	*/
	public void setTF_WeighmentEntry_Payment_ID (int TF_WeighmentEntry_Payment_ID)
	{
		if (TF_WeighmentEntry_Payment_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_WeighmentEntry_Payment_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_WeighmentEntry_Payment_ID, Integer.valueOf(TF_WeighmentEntry_Payment_ID));
	}

	/** Get Weighment Entry Payment.
		@return Weighment Entry Payment	  */
	public int getTF_WeighmentEntry_Payment_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_WeighmentEntry_Payment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_WeighmentEntry_Payment_UU.
		@param TF_WeighmentEntry_Payment_UU TF_WeighmentEntry_Payment_UU
	*/
	public void setTF_WeighmentEntry_Payment_UU (String TF_WeighmentEntry_Payment_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_WeighmentEntry_Payment_UU, TF_WeighmentEntry_Payment_UU);
	}

	/** Get TF_WeighmentEntry_Payment_UU.
		@return TF_WeighmentEntry_Payment_UU	  */
	public String getTF_WeighmentEntry_Payment_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_WeighmentEntry_Payment_UU);
	}
}