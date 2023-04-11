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

/** Generated Model for TF_YardEntryApproveLine
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_YardEntryApproveLine extends PO implements I_TF_YardEntryApproveLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180609L;

    /** Standard Constructor */
    public X_TF_YardEntryApproveLine (Properties ctx, int TF_YardEntryApproveLine_ID, String trxName)
    {
      super (ctx, TF_YardEntryApproveLine_ID, trxName);
      /** if (TF_YardEntryApproveLine_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @DateAcct@
			setTF_VehicleType_ID (0);
			setTF_YardEntryApprove_ID (0);
			setTF_YardEntryApproveLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_YardEntryApproveLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_YardEntryApproveLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Buckets Discounted.
		@param Bucket_Discount Buckets Discounted	  */
	public void setBucket_Discount (BigDecimal Bucket_Discount)
	{
		set_Value (COLUMNNAME_Bucket_Discount, Bucket_Discount);
	}

	/** Get Buckets Discounted.
		@return Buckets Discounted	  */
	public BigDecimal getBucket_Discount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Bucket_Discount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Account Date.
		@param DateAcct 
		Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct)
	{
		set_Value (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Discount Amount.
		@param DiscountAmt 
		Calculated amount of discount
	  */
	public void setDiscountAmt (BigDecimal DiscountAmt)
	{
		set_Value (COLUMNNAME_DiscountAmt, DiscountAmt);
	}

	/** Get Discount Amount.
		@return Calculated amount of discount
	  */
	public BigDecimal getDiscountAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DiscountAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Extra Bucket Amount.
		@param ExtraBucketAmount Extra Bucket Amount	  */
	public void setExtraBucketAmount (BigDecimal ExtraBucketAmount)
	{
		set_Value (COLUMNNAME_ExtraBucketAmount, ExtraBucketAmount);
	}

	/** Get Extra Bucket Amount.
		@return Extra Bucket Amount	  */
	public BigDecimal getExtraBucketAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ExtraBucketAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Extra Bucket Price.
		@param ExtraBucketPrice Extra Bucket Price	  */
	public void setExtraBucketPrice (BigDecimal ExtraBucketPrice)
	{
		set_Value (COLUMNNAME_ExtraBucketPrice, ExtraBucketPrice);
	}

	/** Get Extra Bucket Price.
		@return Extra Bucket Price	  */
	public BigDecimal getExtraBucketPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ExtraBucketPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Extra Bucket Qty.
		@param ExtraBucketQty Extra Bucket Qty	  */
	public void setExtraBucketQty (BigDecimal ExtraBucketQty)
	{
		set_Value (COLUMNNAME_ExtraBucketQty, ExtraBucketQty);
	}

	/** Get Extra Bucket Qty.
		@return Extra Bucket Qty	  */
	public BigDecimal getExtraBucketQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ExtraBucketQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Permit Amount.
		@param PermitAmount Permit Amount	  */
	public void setPermitAmount (BigDecimal PermitAmount)
	{
		set_Value (COLUMNNAME_PermitAmount, PermitAmount);
	}

	/** Get Permit Amount.
		@return Permit Amount	  */
	public BigDecimal getPermitAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Permit Cancelled Qty.
		@param PermitCancelledQty Permit Cancelled Qty	  */
	public void setPermitCancelledQty (BigDecimal PermitCancelledQty)
	{
		set_Value (COLUMNNAME_PermitCancelledQty, PermitCancelledQty);
	}

	/** Get Permit Cancelled Qty.
		@return Permit Cancelled Qty	  */
	public BigDecimal getPermitCancelledQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitCancelledQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Permit Issued Qty.
		@param PermitIssuedQty Permit Issued Qty	  */
	public void setPermitIssuedQty (BigDecimal PermitIssuedQty)
	{
		set_Value (COLUMNNAME_PermitIssuedQty, PermitIssuedQty);
	}

	/** Get Permit Issued Qty.
		@return Permit Issued Qty	  */
	public BigDecimal getPermitIssuedQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitIssuedQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Permit Price.
		@param PermitPrice Permit Price	  */
	public void setPermitPrice (BigDecimal PermitPrice)
	{
		set_Value (COLUMNNAME_PermitPrice, PermitPrice);
	}

	/** Get Permit Price.
		@return Permit Price	  */
	public BigDecimal getPermitPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Permit Sales Qty.
		@param PermitSalesQty Permit Sales Qty	  */
	public void setPermitSalesQty (BigDecimal PermitSalesQty)
	{
		set_Value (COLUMNNAME_PermitSalesQty, PermitSalesQty);
	}

	/** Get Permit Sales Qty.
		@return Permit Sales Qty	  */
	public BigDecimal getPermitSalesQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitSalesQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
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

	public I_TF_VehicleType getTF_VehicleType() throws RuntimeException
    {
		return (I_TF_VehicleType)MTable.get(getCtx(), I_TF_VehicleType.Table_Name)
			.getPO(getTF_VehicleType_ID(), get_TrxName());	}

	/** Set Vehicle Type.
		@param TF_VehicleType_ID Vehicle Type	  */
	public void setTF_VehicleType_ID (int TF_VehicleType_ID)
	{
		if (TF_VehicleType_ID < 1) 
			set_Value (COLUMNNAME_TF_VehicleType_ID, null);
		else 
			set_Value (COLUMNNAME_TF_VehicleType_ID, Integer.valueOf(TF_VehicleType_ID));
	}

	/** Get Vehicle Type.
		@return Vehicle Type	  */
	public int getTF_VehicleType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_VehicleType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_YardEntry getTF_YardEntry() throws RuntimeException
    {
		return (I_TF_YardEntry)MTable.get(getCtx(), I_TF_YardEntry.Table_Name)
			.getPO(getTF_YardEntry_ID(), get_TrxName());	}

	/** Set Yard Entry.
		@param TF_YardEntry_ID Yard Entry	  */
	public void setTF_YardEntry_ID (int TF_YardEntry_ID)
	{
		if (TF_YardEntry_ID < 1) 
			set_Value (COLUMNNAME_TF_YardEntry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_YardEntry_ID, Integer.valueOf(TF_YardEntry_ID));
	}

	/** Get Yard Entry.
		@return Yard Entry	  */
	public int getTF_YardEntry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_YardEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_YardEntryApprove getTF_YardEntryApprove() throws RuntimeException
    {
		return (I_TF_YardEntryApprove)MTable.get(getCtx(), I_TF_YardEntryApprove.Table_Name)
			.getPO(getTF_YardEntryApprove_ID(), get_TrxName());	}

	/** Set Approve Yard Entry.
		@param TF_YardEntryApprove_ID Approve Yard Entry	  */
	public void setTF_YardEntryApprove_ID (int TF_YardEntryApprove_ID)
	{
		if (TF_YardEntryApprove_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_YardEntryApprove_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_YardEntryApprove_ID, Integer.valueOf(TF_YardEntryApprove_ID));
	}

	/** Get Approve Yard Entry.
		@return Approve Yard Entry	  */
	public int getTF_YardEntryApprove_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_YardEntryApprove_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Yard Entry Generated.
		@param TF_YardEntryApproveLine_ID Yard Entry Generated	  */
	public void setTF_YardEntryApproveLine_ID (int TF_YardEntryApproveLine_ID)
	{
		if (TF_YardEntryApproveLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_YardEntryApproveLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_YardEntryApproveLine_ID, Integer.valueOf(TF_YardEntryApproveLine_ID));
	}

	/** Get Yard Entry Generated.
		@return Yard Entry Generated	  */
	public int getTF_YardEntryApproveLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_YardEntryApproveLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_YardEntryApproveLine_UU.
		@param TF_YardEntryApproveLine_UU TF_YardEntryApproveLine_UU	  */
	public void setTF_YardEntryApproveLine_UU (String TF_YardEntryApproveLine_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_YardEntryApproveLine_UU, TF_YardEntryApproveLine_UU);
	}

	/** Get TF_YardEntryApproveLine_UU.
		@return TF_YardEntryApproveLine_UU	  */
	public String getTF_YardEntryApproveLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_YardEntryApproveLine_UU);
	}

	/** Set Total Load.
		@param TotalLoad Total Load	  */
	public void setTotalLoad (BigDecimal TotalLoad)
	{
		set_Value (COLUMNNAME_TotalLoad, TotalLoad);
	}

	/** Get Total Load.
		@return Total Load	  */
	public BigDecimal getTotalLoad () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalLoad);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set W/P Amount.
		@param WPAmount W/P Amount	  */
	public void setWPAmount (BigDecimal WPAmount)
	{
		set_Value (COLUMNNAME_WPAmount, WPAmount);
	}

	/** Get W/P Amount.
		@return W/P Amount	  */
	public BigDecimal getWPAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_WPAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set W/P Price.
		@param WpPrice W/P Price	  */
	public void setWpPrice (BigDecimal WpPrice)
	{
		set_Value (COLUMNNAME_WpPrice, WpPrice);
	}

	/** Get W/P Price.
		@return W/P Price	  */
	public BigDecimal getWpPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_WpPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set W/P Qty.
		@param WPQty W/P Qty	  */
	public void setWPQty (BigDecimal WPQty)
	{
		set_Value (COLUMNNAME_WPQty, WPQty);
	}

	/** Get W/P Qty.
		@return W/P Qty	  */
	public BigDecimal getWPQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_WPQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}