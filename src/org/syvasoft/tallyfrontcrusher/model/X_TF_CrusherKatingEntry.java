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

/** Generated Model for TF_CrusherKatingEntry
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_CrusherKatingEntry extends PO implements I_TF_CrusherKatingEntry, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20221011L;

    /** Standard Constructor */
    public X_TF_CrusherKatingEntry (Properties ctx, int TF_CrusherKatingEntry_ID, String trxName)
    {
      super (ctx, TF_CrusherKatingEntry_ID, trxName);
      /** if (TF_CrusherKatingEntry_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDocumentNo (null);
			setKatingEntryType (null);
// T
			setM_Product_ID (0);
			setProcessed (false);
			setTF_CrusherKatingEntry_ID (0);
			setTF_RentedVehicle_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_CrusherKatingEntry (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TF_CrusherKatingEntry[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Project getC_Project() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getC_Project_ID(), get_TrxName());	}

	/** Set Subcontract / Project.
		@param C_Project_ID 
		Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Subcontract / Project.
		@return Financial Project
	  */
	public int getC_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
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
	/** Overdue = OD */
	public static final String DOCSTATUS_Overdue = "OD";
	/** Due = DU */
	public static final String DOCSTATUS_Due = "DU";
	/** Upcoming = UP */
	public static final String DOCSTATUS_Upcoming = "UP";
	/** Partially Billed = PB */
	public static final String DOCSTATUS_PartiallyBilled = "PB";
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

	/** Tonnage = T */
	public static final String KATINGENTRYTYPE_Tonnage = "T";
	/** Load = L */
	public static final String KATINGENTRYTYPE_Load = "L";
	/** Set Kating Type.
		@param KatingEntryType Kating Type	  */
	public void setKatingEntryType (String KatingEntryType)
	{

		set_Value (COLUMNNAME_KatingEntryType, KatingEntryType);
	}

	/** Get Kating Type.
		@return Kating Type	  */
	public String getKatingEntryType () 
	{
		return (String)get_Value(COLUMNNAME_KatingEntryType);
	}

	public org.compiere.model.I_C_Invoice getLoaderInvoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getLoaderInvoice_ID(), get_TrxName());	}

	/** Set Loader Invoice.
		@param LoaderInvoice_ID Loader Invoice	  */
	public void setLoaderInvoice_ID (int LoaderInvoice_ID)
	{
		if (LoaderInvoice_ID < 1) 
			set_Value (COLUMNNAME_LoaderInvoice_ID, null);
		else 
			set_Value (COLUMNNAME_LoaderInvoice_ID, Integer.valueOf(LoaderInvoice_ID));
	}

	/** Get Loader Invoice.
		@return Loader Invoice	  */
	public int getLoaderInvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LoaderInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_RentedVehicle getLoaderVehicle() throws RuntimeException
    {
		return (I_TF_RentedVehicle)MTable.get(getCtx(), I_TF_RentedVehicle.Table_Name)
			.getPO(getLoaderVehicle_ID(), get_TrxName());	}

	/** Set Loader.
		@param LoaderVehicle_ID Loader	  */
	public void setLoaderVehicle_ID (int LoaderVehicle_ID)
	{
		if (LoaderVehicle_ID < 1) 
			set_Value (COLUMNNAME_LoaderVehicle_ID, null);
		else 
			set_Value (COLUMNNAME_LoaderVehicle_ID, Integer.valueOf(LoaderVehicle_ID));
	}

	/** Get Loader.
		@return Loader	  */
	public int getLoaderVehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LoaderVehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Loading Charge.
		@param Loading_Amount Loading Charge	  */
	public void setLoading_Amount (BigDecimal Loading_Amount)
	{
		set_Value (COLUMNNAME_Loading_Amount, Loading_Amount);
	}

	/** Get Loading Charge.
		@return Loading Charge	  */
	public BigDecimal getLoading_Amount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Loading_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Loading Price.
		@param Loading_Price Loading Price	  */
	public void setLoading_Price (BigDecimal Loading_Price)
	{
		set_Value (COLUMNNAME_Loading_Price, Loading_Price);
	}

	/** Get Loading Price.
		@return Loading Price	  */
	public BigDecimal getLoading_Price () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Loading_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_UOM getLoading_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getLoading_UOM_ID(), get_TrxName());	}

	/** Set Loading Charge Basis.
		@param Loading_UOM_ID Loading Charge Basis	  */
	public void setLoading_UOM_ID (int Loading_UOM_ID)
	{
		if (Loading_UOM_ID < 1) 
			set_Value (COLUMNNAME_Loading_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_Loading_UOM_ID, Integer.valueOf(Loading_UOM_ID));
	}

	/** Get Loading Charge Basis.
		@return Loading Charge Basis	  */
	public int getLoading_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Loading_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Regular = R */
	public static final String TF_BLUEMETAL_TYPE_Regular = "R";
	/** Wetmix = W */
	public static final String TF_BLUEMETAL_TYPE_Wetmix = "W";
	/** Regular + Geosand = RG */
	public static final String TF_BLUEMETAL_TYPE_RegularPlusGeosand = "RG";
	/** 40 MM only = 40 */
	public static final String TF_BLUEMETAL_TYPE_40MMOnly = "40";
	/** GSB = GSB */
	public static final String TF_BLUEMETAL_TYPE_GSB = "GSB";
	/** SO = SO */
	public static final String TF_BLUEMETAL_TYPE_SO = "SO";
	/** Set Production Type.
		@param TF_BlueMetal_Type Production Type	  */
	public void setTF_BlueMetal_Type (String TF_BlueMetal_Type)
	{

		set_Value (COLUMNNAME_TF_BlueMetal_Type, TF_BlueMetal_Type);
	}

	/** Get Production Type.
		@return Production Type	  */
	public String getTF_BlueMetal_Type () 
	{
		return (String)get_Value(COLUMNNAME_TF_BlueMetal_Type);
	}

	public I_TF_Crusher_Production getTF_Crusher_Production() throws RuntimeException
    {
		return (I_TF_Crusher_Production)MTable.get(getCtx(), I_TF_Crusher_Production.Table_Name)
			.getPO(getTF_Crusher_Production_ID(), get_TrxName());	}

	/** Set Crusher Production.
		@param TF_Crusher_Production_ID Crusher Production	  */
	public void setTF_Crusher_Production_ID (int TF_Crusher_Production_ID)
	{
		if (TF_Crusher_Production_ID < 1) 
			set_Value (COLUMNNAME_TF_Crusher_Production_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Crusher_Production_ID, Integer.valueOf(TF_Crusher_Production_ID));
	}

	/** Get Crusher Production.
		@return Crusher Production	  */
	public int getTF_Crusher_Production_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Crusher_Production_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Crusher Kating Entry.
		@param TF_CrusherKatingEntry_ID Crusher Kating Entry	  */
	public void setTF_CrusherKatingEntry_ID (int TF_CrusherKatingEntry_ID)
	{
		if (TF_CrusherKatingEntry_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherKatingEntry_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_CrusherKatingEntry_ID, Integer.valueOf(TF_CrusherKatingEntry_ID));
	}

	/** Get Crusher Kating Entry.
		@return Crusher Kating Entry	  */
	public int getTF_CrusherKatingEntry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_CrusherKatingEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_CrusherKatingEntry_UU.
		@param TF_CrusherKatingEntry_UU TF_CrusherKatingEntry_UU	  */
	public void setTF_CrusherKatingEntry_UU (String TF_CrusherKatingEntry_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_CrusherKatingEntry_UU, TF_CrusherKatingEntry_UU);
	}

	/** Get TF_CrusherKatingEntry_UU.
		@return TF_CrusherKatingEntry_UU	  */
	public String getTF_CrusherKatingEntry_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_CrusherKatingEntry_UU);
	}

	public I_TF_ProductionPlant getTF_ProductionPlant() throws RuntimeException
    {
		return (I_TF_ProductionPlant)MTable.get(getCtx(), I_TF_ProductionPlant.Table_Name)
			.getPO(getTF_ProductionPlant_ID(), get_TrxName());	}

	/** Set Production Plant.
		@param TF_ProductionPlant_ID Production Plant	  */
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID)
	{
		if (TF_ProductionPlant_ID < 1) 
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, null);
		else 
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, Integer.valueOf(TF_ProductionPlant_ID));
	}

	/** Get Production Plant.
		@return Production Plant	  */
	public int getTF_ProductionPlant_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ProductionPlant_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_TF_RentedVehicle getTF_RentedVehicle() throws RuntimeException
    {
		return (I_TF_RentedVehicle)MTable.get(getCtx(), I_TF_RentedVehicle.Table_Name)
			.getPO(getTF_RentedVehicle_ID(), get_TrxName());	}

	/** Set Rented Vehicle.
		@param TF_RentedVehicle_ID Rented Vehicle	  */
	public void setTF_RentedVehicle_ID (int TF_RentedVehicle_ID)
	{
		if (TF_RentedVehicle_ID < 1) 
			set_Value (COLUMNNAME_TF_RentedVehicle_ID, null);
		else 
			set_Value (COLUMNNAME_TF_RentedVehicle_ID, Integer.valueOf(TF_RentedVehicle_ID));
	}

	/** Get Rented Vehicle.
		@return Rented Vehicle	  */
	public int getTF_RentedVehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_RentedVehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Production = P */
	public static final String TF_SEND_TO_Production = "P";
	/** Stock = S */
	public static final String TF_SEND_TO_Stock = "S";
	/** Subcontract Production = T */
	public static final String TF_SEND_TO_SubcontractProduction = "T";
	/** Set Send To.
		@param TF_Send_To Send To	  */
	public void setTF_Send_To (String TF_Send_To)
	{

		set_Value (COLUMNNAME_TF_Send_To, TF_Send_To);
	}

	/** Get Send To.
		@return Send To	  */
	public String getTF_Send_To () 
	{
		return (String)get_Value(COLUMNNAME_TF_Send_To);
	}

	public I_TF_WeighmentEntry getTF_WeighmentEntry() throws RuntimeException
    {
		return (I_TF_WeighmentEntry)MTable.get(getCtx(), I_TF_WeighmentEntry.Table_Name)
			.getPO(getTF_WeighmentEntry_ID(), get_TrxName());	}

	/** Set Weighment Entry.
		@param TF_WeighmentEntry_ID Weighment Entry	  */
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID)
	{
		if (TF_WeighmentEntry_ID < 1) 
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, Integer.valueOf(TF_WeighmentEntry_ID));
	}

	/** Get Weighment Entry.
		@return Weighment Entry	  */
	public int getTF_WeighmentEntry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_WeighmentEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tonnage.
		@param Tonnage Tonnage	  */
	public void setTonnage (BigDecimal Tonnage)
	{
		set_Value (COLUMNNAME_Tonnage, Tonnage);
	}

	/** Get Tonnage.
		@return Tonnage	  */
	public BigDecimal getTonnage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Tonnage);
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

	/** Set Transportaion Charge.
		@param Transport_Amount Transportaion Charge	  */
	public void setTransport_Amount (BigDecimal Transport_Amount)
	{
		set_Value (COLUMNNAME_Transport_Amount, Transport_Amount);
	}

	/** Get Transportaion Charge.
		@return Transportaion Charge	  */
	public BigDecimal getTransport_Amount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Transport_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Transport Price.
		@param Transport_Price Transport Price	  */
	public void setTransport_Price (BigDecimal Transport_Price)
	{
		set_Value (COLUMNNAME_Transport_Price, Transport_Price);
	}

	/** Get Transport Price.
		@return Transport Price	  */
	public BigDecimal getTransport_Price () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Transport_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_UOM getTransport_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getTransport_UOM_ID(), get_TrxName());	}

	/** Set Tranport Charge Basis.
		@param Transport_UOM_ID Tranport Charge Basis	  */
	public void setTransport_UOM_ID (int Transport_UOM_ID)
	{
		if (Transport_UOM_ID < 1) 
			set_Value (COLUMNNAME_Transport_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_Transport_UOM_ID, Integer.valueOf(Transport_UOM_ID));
	}

	/** Get Tranport Charge Basis.
		@return Tranport Charge Basis	  */
	public int getTransport_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Transport_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Invoice getTransporterInvoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getTransporterInvoice_ID(), get_TrxName());	}

	/** Set Transporter Invoice.
		@param TransporterInvoice_ID Transporter Invoice	  */
	public void setTransporterInvoice_ID (int TransporterInvoice_ID)
	{
		if (TransporterInvoice_ID < 1) 
			set_Value (COLUMNNAME_TransporterInvoice_ID, null);
		else 
			set_Value (COLUMNNAME_TransporterInvoice_ID, Integer.valueOf(TransporterInvoice_ID));
	}

	/** Get Transporter Invoice.
		@return Transporter Invoice	  */
	public int getTransporterInvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TransporterInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}