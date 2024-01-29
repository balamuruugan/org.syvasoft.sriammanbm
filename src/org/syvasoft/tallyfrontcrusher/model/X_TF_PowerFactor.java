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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for TF_PowerFactor
 *  @author iDempiere (generated) 
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="TF_PowerFactor")
public class X_TF_PowerFactor extends PO implements I_TF_PowerFactor, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231107L;

    /** Standard Constructor */
    public X_TF_PowerFactor (Properties ctx, int TF_PowerFactor_ID, String trxName)
    {
      super (ctx, TF_PowerFactor_ID, trxName);
      /** if (TF_PowerFactor_ID == 0)
        {
			setC_Period_ID (0);
			setProcessed (false);
// N
			setTF_PowerFactor_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_TF_PowerFactor (Properties ctx, int TF_PowerFactor_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, TF_PowerFactor_ID, trxName, virtualColumns);
      /** if (TF_PowerFactor_ID == 0)
        {
			setC_Period_ID (0);
			setProcessed (false);
// N
			setTF_PowerFactor_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_PowerFactor (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_TF_PowerFactor[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Period getC_Period() throws RuntimeException
	{
		return (org.compiere.model.I_C_Period)MTable.get(getCtx(), org.compiere.model.I_C_Period.Table_ID)
			.getPO(getC_Period_ID(), get_TrxName());
	}

	/** Set Period.
		@param C_Period_ID Period of the Calendar
	*/
	public void setC_Period_ID (int C_Period_ID)
	{
		if (C_Period_ID < 1)
			set_Value (COLUMNNAME_C_Period_ID, null);
		else
			set_Value (COLUMNNAME_C_Period_ID, Integer.valueOf(C_Period_ID));
	}

	/** Get Period.
		@return Period of the Calendar
	  */
	public int getC_Period_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Period_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set closingkvah.
		@param closingkvah closingkvah
	*/
	public void setclosingkvah (BigDecimal closingkvah)
	{
		set_Value (COLUMNNAME_closingkvah, closingkvah);
	}

	/** Get closingkvah.
		@return closingkvah	  */
	public BigDecimal getclosingkvah()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_closingkvah);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set closingkwh.
		@param closingkwh closingkwh
	*/
	public void setclosingkwh (BigDecimal closingkwh)
	{
		set_Value (COLUMNNAME_closingkwh, closingkwh);
	}

	/** Get closingkwh.
		@return closingkwh	  */
	public BigDecimal getclosingkwh()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_closingkwh);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Date From.
		@param DateFrom Starting date for a range
	*/
	public void setDateFrom (Timestamp DateFrom)
	{
		set_Value (COLUMNNAME_DateFrom, DateFrom);
	}

	/** Get Date From.
		@return Starting date for a range
	  */
	public Timestamp getDateFrom()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateFrom);
	}

	/** Set Date To.
		@param DateTo End date of a date range
	*/
	public void setDateTo (Timestamp DateTo)
	{
		set_Value (COLUMNNAME_DateTo, DateTo);
	}

	/** Get Date To.
		@return End date of a date range
	  */
	public Timestamp getDateTo()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTo);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** Activated = AC */
	public static final String DOCSTATUS_Activated = "AC";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Canceled = CA */
	public static final String DOCSTATUS_Canceled = "CA";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Due = DU */
	public static final String DOCSTATUS_Due = "DU";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Overdue = OD */
	public static final String DOCSTATUS_Overdue = "OD";
	/** Partially Billed = PB */
	public static final String DOCSTATUS_PartiallyBilled = "PB";
	/** Pending = PE */
	public static final String DOCSTATUS_Pending = "PE";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Rejected = RJ */
	public static final String DOCSTATUS_Rejected = "RJ";
	/** Suspended = SU */
	public static final String DOCSTATUS_Suspended = "SU";
	/** Upcoming = UP */
	public static final String DOCSTATUS_Upcoming = "UP";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Set Document Status.
		@param DocStatus The current status of the document
	*/
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus()
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set Document No.
		@param DocumentNo Document sequence number of the document
	*/
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo()
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set kvahusage.
		@param kvahusage kvahusage
	*/
	public void setkvahusage (BigDecimal kvahusage)
	{
		set_Value (COLUMNNAME_kvahusage, kvahusage);
	}

	/** Get kvahusage.
		@return kvahusage	  */
	public BigDecimal getkvahusage()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_kvahusage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set kwhusage.
		@param kwhusage kwhusage
	*/
	public void setkwhusage (BigDecimal kwhusage)
	{
		set_Value (COLUMNNAME_kwhusage, kwhusage);
	}

	/** Get kwhusage.
		@return kwhusage	  */
	public BigDecimal getkwhusage()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_kwhusage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set openingkvah.
		@param openingkvah openingkvah
	*/
	public void setopeningkvah (BigDecimal openingkvah)
	{
		set_Value (COLUMNNAME_openingkvah, openingkvah);
	}

	/** Get openingkvah.
		@return openingkvah	  */
	public BigDecimal getopeningkvah()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_openingkvah);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set openingkwh.
		@param openingkwh openingkwh
	*/
	public void setopeningkwh (BigDecimal openingkwh)
	{
		set_Value (COLUMNNAME_openingkwh, openingkwh);
	}

	/** Get openingkwh.
		@return openingkwh	  */
	public BigDecimal getopeningkwh()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_openingkwh);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set powerfactor.
		@param powerfactor powerfactor
	*/
	public void setpowerfactor (BigDecimal powerfactor)
	{
		set_Value (COLUMNNAME_powerfactor, powerfactor);
	}

	/** Get powerfactor.
		@return powerfactor	  */
	public BigDecimal getpowerfactor()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_powerfactor);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Processed.
		@param Processed The document has been processed
	*/
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed()
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Process Now.
		@param Processing Process Now
	*/
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing()
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set TF_PowerFactor.
		@param TF_PowerFactor_ID TF_PowerFactor
	*/
	public void setTF_PowerFactor_ID (int TF_PowerFactor_ID)
	{
		if (TF_PowerFactor_ID < 1)
			set_ValueNoCheck (COLUMNNAME_TF_PowerFactor_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_TF_PowerFactor_ID, Integer.valueOf(TF_PowerFactor_ID));
	}

	/** Get TF_PowerFactor.
		@return TF_PowerFactor	  */
	public int getTF_PowerFactor_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_PowerFactor_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_PowerFactor_UU.
		@param TF_PowerFactor_UU TF_PowerFactor_UU
	*/
	public void setTF_PowerFactor_UU (String TF_PowerFactor_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_PowerFactor_UU, TF_PowerFactor_UU);
	}

	/** Get TF_PowerFactor_UU.
		@return TF_PowerFactor_UU	  */
	public String getTF_PowerFactor_UU()
	{
		return (String)get_Value(COLUMNNAME_TF_PowerFactor_UU);
	}

	/** Set unit.
		@param unit unit
	*/
	public void setunit (BigDecimal unit)
	{
		set_Value (COLUMNNAME_unit, unit);
	}

	/** Get unit.
		@return unit	  */
	public BigDecimal getunit()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_unit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Unit Factor.
		@param UnitFactor Unit Factor
	*/
	public void setUnitFactor (BigDecimal UnitFactor)
	{
		set_Value (COLUMNNAME_UnitFactor, UnitFactor);
	}

	/** Get Unit Factor.
		@return Unit Factor	  */
	public BigDecimal getUnitFactor()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_UnitFactor);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}