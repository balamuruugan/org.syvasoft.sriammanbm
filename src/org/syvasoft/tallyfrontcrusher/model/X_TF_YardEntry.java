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

/** Generated Model for TF_YardEntry
 *  @author iDempiere (generated) 
 *  @version Release 4.1 - $Id$ */
public class X_TF_YardEntry extends PO implements I_TF_YardEntry, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180614L;

    /** Standard Constructor */
    public X_TF_YardEntry (Properties ctx, int TF_YardEntry_ID, String trxName)
    {
      super (ctx, TF_YardEntry_ID, trxName);
      /** if (TF_YardEntry_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
			setDocumentNo (null);
			setPaymentRule (null);
// B
			setProcessed (false);
			setTF_VehicleType_ID (0);
			setTF_YardEntry_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_YardEntry (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_YardEntry[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Balance.
		@param Balance Balance	  */
	public void setBalance (BigDecimal Balance)
	{
		set_Value (COLUMNNAME_Balance, Balance);
	}

	/** Get Balance.
		@return Balance	  */
	public BigDecimal getBalance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Balance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Bucket / Load.
		@param BucketPerLoad Bucket / Load	  */
	public void setBucketPerLoad (BigDecimal BucketPerLoad)
	{
		set_Value (COLUMNNAME_BucketPerLoad, BucketPerLoad);
	}

	/** Get Bucket / Load.
		@return Bucket / Load	  */
	public BigDecimal getBucketPerLoad () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_BucketPerLoad);
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

	/** Set Cash Received.
		@param CashReceived Cash Received	  */
	public void setCashReceived (BigDecimal CashReceived)
	{
		set_Value (COLUMNNAME_CashReceived, CashReceived);
	}

	/** Get Cash Received.
		@return Cash Received	  */
	public BigDecimal getCashReceived () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CashReceived);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Account Date.
		@param DateAcct 
		Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct)
	{
		set_ValueNoCheck (COLUMNNAME_DateAcct, DateAcct);
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

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Suspended = SU */
	public static final String DOCSTATUS_Suspended = "SU";
	/** Activated = AC */
	public static final String DOCSTATUS_Activated = "AC";
	/** Canceled = CA */
	public static final String DOCSTATUS_Canceled = "CA";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
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

	/** Set Gross Weight Time.
		@param GrossWeightTime Gross Weight Time	  */
	public void setGrossWeightTime (Timestamp GrossWeightTime)
	{
		set_Value (COLUMNNAME_GrossWeightTime, GrossWeightTime);
	}

	/** Get Gross Weight Time.
		@return Gross Weight Time	  */
	public Timestamp getGrossWeightTime () 
	{
		return (Timestamp)get_Value(COLUMNNAME_GrossWeightTime);
	}

	/** Set Has Balance.
		@param HasBalance 
		Permit Sales / Non Permit Sales
	  */
	public void setHasBalance (boolean HasBalance)
	{
		set_Value (COLUMNNAME_HasBalance, Boolean.valueOf(HasBalance));
	}

	/** Get Has Balance.
		@return Permit Sales / Non Permit Sales
	  */
	public boolean isHasBalance () 
	{
		Object oo = get_Value(COLUMNNAME_HasBalance);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Load Amount.
		@param LoadAmount Load Amount	  */
	public void setLoadAmount (BigDecimal LoadAmount)
	{
		set_Value (COLUMNNAME_LoadAmount, LoadAmount);
	}

	/** Get Load Amount.
		@return Load Amount	  */
	public BigDecimal getLoadAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LoadAmount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
    {
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_Name)
			.getPO(getM_Warehouse_ID(), get_TrxName());	}

	/** Set Warehouse.
		@param M_Warehouse_ID 
		Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1) 
			set_Value (COLUMNNAME_M_Warehouse_ID, null);
		else 
			set_Value (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set MDP No.
		@param MDPNo MDP No	  */
	public void setMDPNo (String MDPNo)
	{
		set_Value (COLUMNNAME_MDPNo, MDPNo);
	}

	/** Get MDP No.
		@return MDP No	  */
	public String getMDPNo () 
	{
		return (String)get_Value(COLUMNNAME_MDPNo);
	}

	/** Set Party Name.
		@param PartyName Party Name	  */
	public void setPartyName (String PartyName)
	{
		set_Value (COLUMNNAME_PartyName, PartyName);
	}

	/** Get Party Name.
		@return Party Name	  */
	public String getPartyName () 
	{
		return (String)get_Value(COLUMNNAME_PartyName);
	}

	/** PaymentRule AD_Reference_ID=195 */
	public static final int PAYMENTRULE_AD_Reference_ID=195;
	/** Cash = B */
	public static final String PAYMENTRULE_Cash = "B";
	/** Credit Card = K */
	public static final String PAYMENTRULE_CreditCard = "K";
	/** Direct Deposit = T */
	public static final String PAYMENTRULE_DirectDeposit = "T";
	/** Check = S */
	public static final String PAYMENTRULE_Check = "S";
	/** On Credit = P */
	public static final String PAYMENTRULE_OnCredit = "P";
	/** Direct Debit = D */
	public static final String PAYMENTRULE_DirectDebit = "D";
	/** Mixed POS Payment = M */
	public static final String PAYMENTRULE_MixedPOSPayment = "M";
	/** Set Payment Rule.
		@param PaymentRule 
		How you pay the invoice
	  */
	public void setPaymentRule (String PaymentRule)
	{

		set_Value (COLUMNNAME_PaymentRule, PaymentRule);
	}

	/** Get Payment Rule.
		@return How you pay the invoice
	  */
	public String getPaymentRule () 
	{
		return (String)get_Value(COLUMNNAME_PaymentRule);
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

	/** Set Permit Issued Tonnage.
		@param PermitIssuedTonnage Permit Issued Tonnage	  */
	public void setPermitIssuedTonnage (BigDecimal PermitIssuedTonnage)
	{
		set_Value (COLUMNNAME_PermitIssuedTonnage, PermitIssuedTonnage);
	}

	/** Get Permit Issued Tonnage.
		@return Permit Issued Tonnage	  */
	public BigDecimal getPermitIssuedTonnage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PermitIssuedTonnage);
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

	/** Set Price / Load.
		@param PricePerLoad Price / Load	  */
	public void setPricePerLoad (BigDecimal PricePerLoad)
	{
		set_Value (COLUMNNAME_PricePerLoad, PricePerLoad);
	}

	/** Get Price / Load.
		@return Price / Load	  */
	public BigDecimal getPricePerLoad () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PricePerLoad);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
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

	/** In Progress = IP */
	public static final String STATUS_InProgress = "IP";
	/** Unbilled = CO */
	public static final String STATUS_Unbilled = "CO";
	/** Billed = CL */
	public static final String STATUS_Billed = "CL";
	/** Voided = VO */
	public static final String STATUS_Voided = "VO";
	/** Set Status.
		@param Status 
		Status of the currently running check
	  */
	public void setStatus (String Status)
	{

		set_Value (COLUMNNAME_Status, Status);
	}

	/** Get Status.
		@return Status of the currently running check
	  */
	public String getStatus () 
	{
		return (String)get_Value(COLUMNNAME_Status);
	}

	/** Set Tare Weight Time.
		@param TareWeightTime Tare Weight Time	  */
	public void setTareWeightTime (Timestamp TareWeightTime)
	{
		set_Value (COLUMNNAME_TareWeightTime, TareWeightTime);
	}

	/** Get Tare Weight Time.
		@return Tare Weight Time	  */
	public Timestamp getTareWeightTime () 
	{
		return (Timestamp)get_Value(COLUMNNAME_TareWeightTime);
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

	/** Set Yard Entry.
		@param TF_YardEntry_ID Yard Entry	  */
	public void setTF_YardEntry_ID (int TF_YardEntry_ID)
	{
		if (TF_YardEntry_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_YardEntry_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_YardEntry_ID, Integer.valueOf(TF_YardEntry_ID));
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

	/** Set TF_YardEntry_UU.
		@param TF_YardEntry_UU TF_YardEntry_UU	  */
	public void setTF_YardEntry_UU (String TF_YardEntry_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_YardEntry_UU, TF_YardEntry_UU);
	}

	/** Get TF_YardEntry_UU.
		@return TF_YardEntry_UU	  */
	public String getTF_YardEntry_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_YardEntry_UU);
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
			set_Value (COLUMNNAME_TF_YardEntryApprove_ID, null);
		else 
			set_Value (COLUMNNAME_TF_YardEntryApprove_ID, Integer.valueOf(TF_YardEntryApprove_ID));
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

	/** Set Total Amount.
		@param TotalAmt 
		Total Amount
	  */
	public void setTotalAmt (BigDecimal TotalAmt)
	{
		set_Value (COLUMNNAME_TotalAmt, TotalAmt);
	}

	/** Get Total Amount.
		@return Total Amount
	  */
	public BigDecimal getTotalAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set User Name.
		@param UserName User Name	  */
	public void setUserName (String UserName)
	{
		set_Value (COLUMNNAME_UserName, UserName);
	}

	/** Get User Name.
		@return User Name	  */
	public String getUserName () 
	{
		return (String)get_Value(COLUMNNAME_UserName);
	}

	/** Set Vehicle No.
		@param VehicleNo Vehicle No	  */
	public void setVehicleNo (String VehicleNo)
	{
		set_Value (COLUMNNAME_VehicleNo, VehicleNo);
	}

	/** Get Vehicle No.
		@return Vehicle No	  */
	public String getVehicleNo () 
	{
		return (String)get_Value(COLUMNNAME_VehicleNo);
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