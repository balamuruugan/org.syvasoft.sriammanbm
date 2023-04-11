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

/** Generated Model for TF_DaySeq
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_DaySeq extends PO implements I_TF_DaySeq, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200304L;

    /** Standard Constructor */
    public X_TF_DaySeq (Properties ctx, int TF_DaySeq_ID, String trxName)
    {
      super (ctx, TF_DaySeq_ID, trxName);
      /** if (TF_DaySeq_ID == 0)
        {
			setDateSeq (new Timestamp( System.currentTimeMillis() ));
			setseq (Env.ZERO);
// 0
			setSeqType (null);
			setTF_DaySeq_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_DaySeq (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_DaySeq[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Sequence Date.
		@param DateSeq Sequence Date	  */
	public void setDateSeq (Timestamp DateSeq)
	{
		set_Value (COLUMNNAME_DateSeq, DateSeq);
	}

	/** Get Sequence Date.
		@return Sequence Date	  */
	public Timestamp getDateSeq () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateSeq);
	}

	/** Set Seq No.
		@param seq Seq No	  */
	public void setseq (BigDecimal seq)
	{
		set_Value (COLUMNNAME_seq, seq);
	}

	/** Get Seq No.
		@return Seq No	  */
	public BigDecimal getseq () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_seq);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Sequence Type.
		@param SeqType Sequence Type	  */
	public void setSeqType (String SeqType)
	{
		set_Value (COLUMNNAME_SeqType, SeqType);
	}

	/** Get Sequence Type.
		@return Sequence Type	  */
	public String getSeqType () 
	{
		return (String)get_Value(COLUMNNAME_SeqType);
	}

	/** Set Day wise Sequence No.
		@param TF_DaySeq_ID Day wise Sequence No	  */
	public void setTF_DaySeq_ID (int TF_DaySeq_ID)
	{
		if (TF_DaySeq_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_DaySeq_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_DaySeq_ID, Integer.valueOf(TF_DaySeq_ID));
	}

	/** Get Day wise Sequence No.
		@return Day wise Sequence No	  */
	public int getTF_DaySeq_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_DaySeq_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_DaySeq_UU.
		@param TF_DaySeq_UU TF_DaySeq_UU	  */
	public void setTF_DaySeq_UU (String TF_DaySeq_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_DaySeq_UU, TF_DaySeq_UU);
	}

	/** Get TF_DaySeq_UU.
		@return TF_DaySeq_UU	  */
	public String getTF_DaySeq_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_DaySeq_UU);
	}
}