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

/** Generated Model for TF_TyreAssignment
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_TyreAssignment extends PO implements I_TF_TyreAssignment, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190505L;

    /** Standard Constructor */
    public X_TF_TyreAssignment (Properties ctx, int TF_TyreAssignment_ID, String trxName)
    {
      super (ctx, TF_TyreAssignment_ID, trxName);
      /** if (TF_TyreAssignment_ID == 0)
        {
			setDocAction (null);
// CO
			setDocStatus (null);
// DR
			setDocumentNo (null);
			setProcessed (false);
			setTF_Tyre_ID (0);
			setTF_TyreAssignment_ID (0);
			setTF_TyreType_ID (0);
			setTyreAssignmentType (null);
        } */
    }

    /** Load Constructor */
    public X_TF_TyreAssignment (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_TyreAssignment[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Movement Date.
		@param AD_MovementDate Movement Date	  */
	public void setAD_MovementDate (Timestamp AD_MovementDate)
	{
		set_Value (COLUMNNAME_AD_MovementDate, AD_MovementDate);
	}

	/** Get Movement Date.
		@return Movement Date	  */
	public Timestamp getAD_MovementDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_AD_MovementDate);
	}

	/** Set Assigned Start Meter.
		@param AD_Start_Meter Assigned Start Meter	  */
	public void setAD_Start_Meter (BigDecimal AD_Start_Meter)
	{
		set_Value (COLUMNNAME_AD_Start_Meter, AD_Start_Meter);
	}

	/** Get Assigned Start Meter.
		@return Assigned Start Meter	  */
	public BigDecimal getAD_Start_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AD_Start_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_TyreMovement getAD_TF_TyreMovement() throws RuntimeException
    {
		return (I_TF_TyreMovement)MTable.get(getCtx(), I_TF_TyreMovement.Table_Name)
			.getPO(getAD_TF_TyreMovement_ID(), get_TrxName());	}

	/** Set Assigned Tyre Movement.
		@param AD_TF_TyreMovement_ID Assigned Tyre Movement	  */
	public void setAD_TF_TyreMovement_ID (int AD_TF_TyreMovement_ID)
	{
		if (AD_TF_TyreMovement_ID < 1) 
			set_Value (COLUMNNAME_AD_TF_TyreMovement_ID, null);
		else 
			set_Value (COLUMNNAME_AD_TF_TyreMovement_ID, Integer.valueOf(AD_TF_TyreMovement_ID));
	}

	/** Get Assigned Tyre Movement.
		@return Assigned Tyre Movement	  */
	public int getAD_TF_TyreMovement_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_TF_TyreMovement_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyrePosition getAD_TF_TyrePosition() throws RuntimeException
    {
		return (I_TF_TyrePosition)MTable.get(getCtx(), I_TF_TyrePosition.Table_Name)
			.getPO(getAD_TF_TyrePosition_ID(), get_TrxName());	}

	/** Set To Tyre Position.
		@param AD_TF_TyrePosition_ID To Tyre Position	  */
	public void setAD_TF_TyrePosition_ID (int AD_TF_TyrePosition_ID)
	{
		if (AD_TF_TyrePosition_ID < 1) 
			set_Value (COLUMNNAME_AD_TF_TyrePosition_ID, null);
		else 
			set_Value (COLUMNNAME_AD_TF_TyrePosition_ID, Integer.valueOf(AD_TF_TyrePosition_ID));
	}

	/** Get To Tyre Position.
		@return To Tyre Position	  */
	public int getAD_TF_TyrePosition_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_TF_TyrePosition_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getAD_To_Vehicle() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getAD_To_Vehicle_ID(), get_TrxName());	}

	/** Set To Vehicle.
		@param AD_To_Vehicle_ID To Vehicle	  */
	public void setAD_To_Vehicle_ID (int AD_To_Vehicle_ID)
	{
		if (AD_To_Vehicle_ID < 1) 
			set_Value (COLUMNNAME_AD_To_Vehicle_ID, null);
		else 
			set_Value (COLUMNNAME_AD_To_Vehicle_ID, Integer.valueOf(AD_To_Vehicle_ID));
	}

	/** Get To Vehicle.
		@return To Vehicle	  */
	public int getAD_To_Vehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_To_Vehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
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

	/** DocAction AD_Reference_ID=135 */
	public static final int DOCACTION_AD_Reference_ID=135;
	/** Complete = CO */
	public static final String DOCACTION_Complete = "CO";
	/** Approve = AP */
	public static final String DOCACTION_Approve = "AP";
	/** Reject = RJ */
	public static final String DOCACTION_Reject = "RJ";
	/** Post = PO */
	public static final String DOCACTION_Post = "PO";
	/** Void = VO */
	public static final String DOCACTION_Void = "VO";
	/** Close = CL */
	public static final String DOCACTION_Close = "CL";
	/** Reverse - Correct = RC */
	public static final String DOCACTION_Reverse_Correct = "RC";
	/** Reverse - Accrual = RA */
	public static final String DOCACTION_Reverse_Accrual = "RA";
	/** Invalidate = IN */
	public static final String DOCACTION_Invalidate = "IN";
	/** Re-activate = RE */
	public static final String DOCACTION_Re_Activate = "RE";
	/** <None> = -- */
	public static final String DOCACTION_None = "--";
	/** Prepare = PR */
	public static final String DOCACTION_Prepare = "PR";
	/** Unlock = XL */
	public static final String DOCACTION_Unlock = "XL";
	/** Wait Complete = WC */
	public static final String DOCACTION_WaitComplete = "WC";
	/** Suspend = SU */
	public static final String DOCACTION_Suspend = "SU";
	/** Cancel = CA */
	public static final String DOCACTION_Cancel = "CA";
	/** Activate = AC */
	public static final String DOCACTION_Activate = "AC";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
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

	/** Set Assigned Date.
		@param RD_AssignedDate Assigned Date	  */
	public void setRD_AssignedDate (Timestamp RD_AssignedDate)
	{
		set_Value (COLUMNNAME_RD_AssignedDate, RD_AssignedDate);
	}

	/** Get Assigned Date.
		@return Assigned Date	  */
	public Timestamp getRD_AssignedDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_RD_AssignedDate);
	}

	/** Set End Meter.
		@param RD_End_Meter End Meter	  */
	public void setRD_End_Meter (BigDecimal RD_End_Meter)
	{
		set_Value (COLUMNNAME_RD_End_Meter, RD_End_Meter);
	}

	/** Get End Meter.
		@return End Meter	  */
	public BigDecimal getRD_End_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RD_End_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_M_Product getRD_From_Vehicle() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getRD_From_Vehicle_ID(), get_TrxName());	}

	/** Set From Vehicle.
		@param RD_From_Vehicle_ID From Vehicle	  */
	public void setRD_From_Vehicle_ID (int RD_From_Vehicle_ID)
	{
		if (RD_From_Vehicle_ID < 1) 
			set_Value (COLUMNNAME_RD_From_Vehicle_ID, null);
		else 
			set_Value (COLUMNNAME_RD_From_Vehicle_ID, Integer.valueOf(RD_From_Vehicle_ID));
	}

	/** Get From Vehicle.
		@return From Vehicle	  */
	public int getRD_From_Vehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RD_From_Vehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Released Date.
		@param RD_ReleasedDate Released Date	  */
	public void setRD_ReleasedDate (Timestamp RD_ReleasedDate)
	{
		set_Value (COLUMNNAME_RD_ReleasedDate, RD_ReleasedDate);
	}

	/** Get Released Date.
		@return Released Date	  */
	public Timestamp getRD_ReleasedDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_RD_ReleasedDate);
	}

	/** Set Running Meter.
		@param RD_Running_Meter Running Meter	  */
	public void setRD_Running_Meter (BigDecimal RD_Running_Meter)
	{
		set_Value (COLUMNNAME_RD_Running_Meter, RD_Running_Meter);
	}

	/** Get Running Meter.
		@return Running Meter	  */
	public BigDecimal getRD_Running_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RD_Running_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Assigned Start Meter.
		@param RD_Start_Meter Assigned Start Meter	  */
	public void setRD_Start_Meter (BigDecimal RD_Start_Meter)
	{
		set_Value (COLUMNNAME_RD_Start_Meter, RD_Start_Meter);
	}

	/** Get Assigned Start Meter.
		@return Assigned Start Meter	  */
	public BigDecimal getRD_Start_Meter () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RD_Start_Meter);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_TF_TyreMovement getRD_TF_TyreMovement() throws RuntimeException
    {
		return (I_TF_TyreMovement)MTable.get(getCtx(), I_TF_TyreMovement.Table_Name)
			.getPO(getRD_TF_TyreMovement_ID(), get_TrxName());	}

	/** Set Release Tyre Movement.
		@param RD_TF_TyreMovement_ID Release Tyre Movement	  */
	public void setRD_TF_TyreMovement_ID (int RD_TF_TyreMovement_ID)
	{
		if (RD_TF_TyreMovement_ID < 1) 
			set_Value (COLUMNNAME_RD_TF_TyreMovement_ID, null);
		else 
			set_Value (COLUMNNAME_RD_TF_TyreMovement_ID, Integer.valueOf(RD_TF_TyreMovement_ID));
	}

	/** Get Release Tyre Movement.
		@return Release Tyre Movement	  */
	public int getRD_TF_TyreMovement_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RD_TF_TyreMovement_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyrePosition getRD_TF_TyrePosition() throws RuntimeException
    {
		return (I_TF_TyrePosition)MTable.get(getCtx(), I_TF_TyrePosition.Table_Name)
			.getPO(getRD_TF_TyrePosition_ID(), get_TrxName());	}

	/** Set From Tyre Position.
		@param RD_TF_TyrePosition_ID From Tyre Position	  */
	public void setRD_TF_TyrePosition_ID (int RD_TF_TyrePosition_ID)
	{
		if (RD_TF_TyrePosition_ID < 1) 
			set_Value (COLUMNNAME_RD_TF_TyrePosition_ID, null);
		else 
			set_Value (COLUMNNAME_RD_TF_TyrePosition_ID, Integer.valueOf(RD_TF_TyrePosition_ID));
	}

	/** Get From Tyre Position.
		@return From Tyre Position	  */
	public int getRD_TF_TyrePosition_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RD_TF_TyrePosition_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Scrap = S */
	public static final String SENDTO_Scrap = "S";
	/** Rebutton = R */
	public static final String SENDTO_Rebutton = "R";
	/** Set Send To.
		@param SendTo Send To	  */
	public void setSendTo (String SendTo)
	{

		set_Value (COLUMNNAME_SendTo, SendTo);
	}

	/** Get Send To.
		@return Send To	  */
	public String getSendTo () 
	{
		return (String)get_Value(COLUMNNAME_SendTo);
	}

	public I_TF_Tyre getTF_Tyre() throws RuntimeException
    {
		return (I_TF_Tyre)MTable.get(getCtx(), I_TF_Tyre.Table_Name)
			.getPO(getTF_Tyre_ID(), get_TrxName());	}

	/** Set Tyre.
		@param TF_Tyre_ID Tyre	  */
	public void setTF_Tyre_ID (int TF_Tyre_ID)
	{
		if (TF_Tyre_ID < 1) 
			set_Value (COLUMNNAME_TF_Tyre_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Tyre_ID, Integer.valueOf(TF_Tyre_ID));
	}

	/** Get Tyre.
		@return Tyre	  */
	public int getTF_Tyre_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_Tyre_RBDelivery getTF_Tyre_RBDelivery() throws RuntimeException
    {
		return (I_TF_Tyre_RBDelivery)MTable.get(getCtx(), I_TF_Tyre_RBDelivery.Table_Name)
			.getPO(getTF_Tyre_RBDelivery_ID(), get_TrxName());	}

	/** Set Tyre Rebutton Delivery.
		@param TF_Tyre_RBDelivery_ID Tyre Rebutton Delivery	  */
	public void setTF_Tyre_RBDelivery_ID (int TF_Tyre_RBDelivery_ID)
	{
		if (TF_Tyre_RBDelivery_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBDelivery_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Tyre_RBDelivery_ID, Integer.valueOf(TF_Tyre_RBDelivery_ID));
	}

	/** Get Tyre Rebutton Delivery.
		@return Tyre Rebutton Delivery	  */
	public int getTF_Tyre_RBDelivery_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Tyre_RBDelivery_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tyre Assignment / Release.
		@param TF_TyreAssignment_ID Tyre Assignment / Release	  */
	public void setTF_TyreAssignment_ID (int TF_TyreAssignment_ID)
	{
		if (TF_TyreAssignment_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreAssignment_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreAssignment_ID, Integer.valueOf(TF_TyreAssignment_ID));
	}

	/** Get Tyre Assignment / Release.
		@return Tyre Assignment / Release	  */
	public int getTF_TyreAssignment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreAssignment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_TyreAssignment_UU.
		@param TF_TyreAssignment_UU TF_TyreAssignment_UU	  */
	public void setTF_TyreAssignment_UU (String TF_TyreAssignment_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_TyreAssignment_UU, TF_TyreAssignment_UU);
	}

	/** Get TF_TyreAssignment_UU.
		@return TF_TyreAssignment_UU	  */
	public String getTF_TyreAssignment_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_TyreAssignment_UU);
	}

	public I_TF_TyreStatusChange getTF_TyreStatusChange() throws RuntimeException
    {
		return (I_TF_TyreStatusChange)MTable.get(getCtx(), I_TF_TyreStatusChange.Table_Name)
			.getPO(getTF_TyreStatusChange_ID(), get_TrxName());	}

	/** Set Tyre Status Change.
		@param TF_TyreStatusChange_ID Tyre Status Change	  */
	public void setTF_TyreStatusChange_ID (int TF_TyreStatusChange_ID)
	{
		if (TF_TyreStatusChange_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreStatusChange_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreStatusChange_ID, Integer.valueOf(TF_TyreStatusChange_ID));
	}

	/** Get Tyre Status Change.
		@return Tyre Status Change	  */
	public int getTF_TyreStatusChange_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreStatusChange_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_TyreType getTF_TyreType() throws RuntimeException
    {
		return (I_TF_TyreType)MTable.get(getCtx(), I_TF_TyreType.Table_Name)
			.getPO(getTF_TyreType_ID(), get_TrxName());	}

	/** Set Tyre Type.
		@param TF_TyreType_ID Tyre Type	  */
	public void setTF_TyreType_ID (int TF_TyreType_ID)
	{
		if (TF_TyreType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_TyreType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_TyreType_ID, Integer.valueOf(TF_TyreType_ID));
	}

	/** Get Tyre Type.
		@return Tyre Type	  */
	public int getTF_TyreType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TyreType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Assign from Stock = AS */
	public static final String TYREASSIGNMENTTYPE_AssignFromStock = "AS";
	/** Release to Stock = RS */
	public static final String TYREASSIGNMENTTYPE_ReleaseToStock = "RS";
	/** Release and Assign = RA */
	public static final String TYREASSIGNMENTTYPE_ReleaseAndAssign = "RA";
	/** Set Tyre Assignment Type.
		@param TyreAssignmentType Tyre Assignment Type	  */
	public void setTyreAssignmentType (String TyreAssignmentType)
	{

		set_Value (COLUMNNAME_TyreAssignmentType, TyreAssignmentType);
	}

	/** Get Tyre Assignment Type.
		@return Tyre Assignment Type	  */
	public String getTyreAssignmentType () 
	{
		return (String)get_Value(COLUMNNAME_TyreAssignmentType);
	}
}