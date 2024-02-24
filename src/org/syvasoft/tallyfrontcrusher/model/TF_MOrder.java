package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.exceptions.DBException;
import org.adempiere.exceptions.InvoiceFullyMatchedException;
import org.adempiere.exceptions.ProductNotOnPriceListException;
import org.compiere.model.MBPartner;
import org.compiere.model.MBankAccount;
import org.compiere.model.MConversionRate;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MOrderPaySchedule;
import org.compiere.model.MPeriod;
import org.compiere.model.MPriceList;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPrice;
import org.compiere.model.MProductPricing;
import org.compiere.model.MResource;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTable;
import org.compiere.model.MTax;
import org.compiere.model.MUOMConversion;
import org.compiere.model.MUser;
import org.compiere.model.MWarehouse;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Trx;
import org.compiere.util.Util;
import org.syvasoft.tallyfrontcrusher.process.GenerateTaxInvoiceLines;

public class TF_MOrder extends MOrder {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1285576200459103590L;

	public TF_MOrder(Properties ctx, int C_Order_ID, String trxName) {
		super(ctx, C_Order_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MOrder(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		
	}
	
	   /** Column name IsInterState */
	public static final String COLUMNNAME_IsInterState = "IsInterState";
	/** Set Inter State.
	@param IsInterState Inter State	  */
	public void setIsInterState (boolean IsInterState)
	{
		set_Value (COLUMNNAME_IsInterState, Boolean.valueOf(IsInterState));
	}
	
	/** Get Inter State.
		@return Inter State	  */
	public boolean isInterState () 
	{
		Object oo = get_Value(COLUMNNAME_IsInterState);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}


	 /** Column name Item1_Amt */
    public static final String COLUMNNAME_Item1_Amt = "Item1_Amt";
    
    /** Set Item1 Amount.
	@param Item1_Amt Item1 Amount	  */
	public void setItem1_Amt (BigDecimal Item1_Amt)
	{
		set_Value (COLUMNNAME_Item1_Amt, Item1_Amt);
	}
	
	/** Get Item1 Amount.
		@return Item1 Amount	  */
	public BigDecimal getItem1_Amt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	public static String COLUMNNAME_QtyIssued = "QtyIssued";
	/** Set Quantity Issued.
	@param QtyIssued Quantity Issued	  */
	public void setQtyIssued (BigDecimal QtyIssued)
	{
		set_Value (COLUMNNAME_QtyIssued, QtyIssued);
	}
	
	/** Get Quantity Issued.
		@return Quantity Issued	  */
	public BigDecimal getQtyIssued () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyIssued);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public static String COLUMNNAME_PM_Machinery_ID   = "PM_Machinery_ID";
	/** Set Machinery.
	@param PM_Machinery_ID Machinery	  */
	public void setPM_Machinery_ID (int PM_Machinery_ID)
	{
		if (PM_Machinery_ID < 1) 
			set_Value (COLUMNNAME_PM_Machinery_ID, null);
		else 
			set_Value (COLUMNNAME_PM_Machinery_ID, Integer.valueOf(PM_Machinery_ID));
	}
	
	/** Get Machinery.
		@return Machinery	  */
	public int getPM_Machinery_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PM_Machinery_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name Item1_C_OrderLine_ID */
    public static final String COLUMNNAME_Item1_C_OrderLine_ID = "Item1_C_OrderLine_ID";
    
	public org.compiere.model.I_C_OrderLine getItem1_C_OrderLine() throws RuntimeException
    {
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
			.getPO(getItem1_C_OrderLine_ID(), get_TrxName());	}

	/** Set Item1 OrderLine ID.
		@param Item1_C_OrderLine_ID Item1 OrderLine ID	  */
	public void setItem1_C_OrderLine_ID (int Item1_C_OrderLine_ID)
	{
		if (Item1_C_OrderLine_ID < 1) 
			set_Value (COLUMNNAME_Item1_C_OrderLine_ID, null);
		else 
			set_Value (COLUMNNAME_Item1_C_OrderLine_ID, Integer.valueOf(Item1_C_OrderLine_ID));
	}

	/** Get Item1 OrderLine ID.
		@return Item1 OrderLine ID	  */
	public int getItem1_C_OrderLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Item1_C_OrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name Item1_ID */
    public static final String COLUMNNAME_Item1_ID = "Item1_ID";
    
    public org.compiere.model.I_M_Product getItem1() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getItem1_ID(), get_TrxName());	}

	/** Set Item1.
		@param Item1_ID Item1	  */
	public void setItem1_ID (int Item1_ID)
	{
		if (Item1_ID < 1) 
			set_Value (COLUMNNAME_Item1_ID, null);
		else 
			set_Value (COLUMNNAME_Item1_ID, Integer.valueOf(Item1_ID));
	}

	/** Get Item1.
		@return Item1	  */
	public int getItem1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Item1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name Item1_UOM_ID */
    public static final String COLUMNNAME_Item1_UOM_ID = "Item1_UOM_ID";
    public org.compiere.model.I_C_UOM getItem1_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getItem1_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param Item1_UOM_ID UOM	  */
	public void setItem1_UOM_ID (int Item1_UOM_ID)
	{
		if (Item1_UOM_ID < 1) 
			set_Value (COLUMNNAME_Item1_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_Item1_UOM_ID, Integer.valueOf(Item1_UOM_ID));
	}

	/** Get UOM.
		@return UOM	  */
	public int getItem1_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Item1_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name Item1_Tax_ID */
    public static final String COLUMNNAME_Item1_Tax_ID = "Item1_Tax_ID";
    
    public org.compiere.model.I_C_Tax getItem1_Tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getItem1_Tax_ID(), get_TrxName());	}

	/** Set Tax.
		@param Item1_Tax_ID 
		Tax Identifier
	  */
	public void setItem1_Tax_ID (int Item1_Tax_ID)
	{
		if (Item1_Tax_ID < 1) 
			set_Value (COLUMNNAME_Item1_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_Item1_Tax_ID, Integer.valueOf(Item1_Tax_ID));
	}

	/** Get Tax.
		@return Tax Identifier
	  */
	public int getItem1_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Item1_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name Item1_Tax_ID */
    public static final String COLUMNNAME_C_Tax_ID = "C_Tax_ID";
    
  	public void setC_Tax_ID (int C_Tax_ID)
	{
		if (C_Tax_ID < 1) 
			set_Value (COLUMNNAME_C_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
	}

	/** Get Tax.
		@return Tax Identifier
	  */
	public int getC_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name Item1_IsUpdatePrice */
    public static final String COLUMNNAME_Item1_IsUpdatePrice = "Item1_IsUpdatePrice";
    /** Set Update Price.
	@param Item1_IsUpdatePrice 
	Update Price into Price List
	  */
	public void setItem1_IsUpdatePrice (boolean Item1_IsUpdatePrice)
	{
		set_Value (COLUMNNAME_Item1_IsUpdatePrice, Boolean.valueOf(Item1_IsUpdatePrice));
	}
	
	/** Get Update Price.
		@return Update Price into Price List
	  */
	public boolean isItem1_IsUpdatePrice () 
	{
		Object oo = get_Value(COLUMNNAME_Item1_IsUpdatePrice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

    /** Column name IsLumpSumRent */
    public static final String COLUMNNAME_IsLumpSumRent = "IsLumpSumRent";
    
	/** Set Lump Sum Rent.
	@param IsLumpSumRent Lump Sum Rent	  */
	public void setIsLumpSumRent (boolean IsLumpSumRent)
	{
		set_Value (COLUMNNAME_IsLumpSumRent, Boolean.valueOf(IsLumpSumRent));
	}
	
	/** Get Lump Sum Rent.
		@return Lump Sum Rent	  */
	public boolean isLumpSumRent () 
	{
		Object oo = get_Value(COLUMNNAME_IsLumpSumRent);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
    
	/** Column name Item1_Price */
    public static final String COLUMNNAME_Item1_Price = "Item1_Price";
    
    /** Set Item1 Price.
	@param Item1_Price Item1 Price	  */
	public void setItem1_Price (BigDecimal Item1_Price)
	{
		set_Value (COLUMNNAME_Item1_Price, Item1_Price);
	}
	
	/** Get Item1 Price.
		@return Item1 Price	  */
	public BigDecimal getItem1_Price () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Column name Item1_Qty */
	public static final String COLUMNNAME_Item1_Qty = "Item1_Qty";
	
	/** Set Item1 Qty.
	@param Item1_Qty Item1 Qty	  */
	public void setItem1_Qty (BigDecimal Item1_Qty)
	{
	set_Value (COLUMNNAME_Item1_Qty, Item1_Qty);
	}
	
	/** Get Item1 Qty.
	@return Item1 Qty	  */
	public BigDecimal getItem1_Qty () 
	{
	BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_Qty);
	if (bd == null)
		 return Env.ZERO;
	return bd;
	}
	
	/** Column name Item2_Amt */
	public static final String COLUMNNAME_Item2_Amt = "Item2_Amt";
	
	/** Set Item2 Amount.
	@param Item2_Amt Item2 Amount	  */
	public void setItem2_Amt (BigDecimal Item2_Amt)
	{
	set_Value (COLUMNNAME_Item2_Amt, Item2_Amt);
	}
	
	/** Get Item2 Amount.
	@return Item2 Amount	  */
	public BigDecimal getItem2_Amt () 
	{
	BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item2_Amt);
	if (bd == null)
		 return Env.ZERO;
	return bd;
	}
	
	/** Column name Item2_C_OrderLine_ID */
	public static final String COLUMNNAME_Item2_C_OrderLine_ID = "Item2_C_OrderLine_ID";
	
	public org.compiere.model.I_C_OrderLine getItem2_C_OrderLine() throws RuntimeException
	{
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
			.getPO(getItem2_C_OrderLine_ID(), get_TrxName());	}
	
	/** Set Item2 OrderLine ID.
		@param Item2_C_OrderLine_ID Item2 OrderLine ID	  */
	public void setItem2_C_OrderLine_ID (int Item2_C_OrderLine_ID)
	{
		if (Item2_C_OrderLine_ID < 1) 
			set_Value (COLUMNNAME_Item2_C_OrderLine_ID, null);
		else 
			set_Value (COLUMNNAME_Item2_C_OrderLine_ID, Integer.valueOf(Item2_C_OrderLine_ID));
	}
	
	/** Get Item2 OrderLine ID.
		@return Item2 OrderLine ID	  */
	public int getItem2_C_OrderLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Item2_C_OrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name Item2_ID */
	public static final String COLUMNNAME_Item2_ID = "Item2_ID";
	
	public org.compiere.model.I_M_Product getItem2() throws RuntimeException
	{
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getItem2_ID(), get_TrxName());	}
	
	/** Set Item2.
		@param Item2_ID Item2	  */
	public void setItem2_ID (int Item2_ID)
	{
		if (Item2_ID < 1) 
			set_Value (COLUMNNAME_Item2_ID, null);
		else 
			set_Value (COLUMNNAME_Item2_ID, Integer.valueOf(Item2_ID));
	}
	
	/** Get Item2.
		@return Item2	  */
	public int getItem2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Item2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name Item2_Price */
	public static final String COLUMNNAME_Item2_Price = "Item2_Price";
	
	/** Set Item2 Price.
	@param Item2_Price Item2 Price	  */
	public void setItem2_Price (BigDecimal Item2_Price)
	{
	set_Value (COLUMNNAME_Item2_Price, Item2_Price);
	}
	
	/** Get Item2 Price.
	@return Item2 Price	  */
	public BigDecimal getItem2_Price () 
	{
	BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item2_Price);
	if (bd == null)
		 return Env.ZERO;
	return bd;
	}
	
	
	/** Column name Item2_Qty */
	public static final String COLUMNNAME_Item2_Qty = "Item2_Qty";
	
	/** Set Item2 Qty.
	@param Item2_Qty Item2 Qty	  */
	public void setItem2_Qty (BigDecimal Item2_Qty)
	{
	set_Value (COLUMNNAME_Item2_Qty, Item2_Qty);
	}
	
	/** Get Item2 Qty.
	@return Item2 Qty	  */
	public BigDecimal getItem2_Qty () 
	{
	BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item2_Qty);
	if (bd == null)
		 return Env.ZERO;
	return bd;
	}

	/** Column name Vehicle_ID */
    public static final String COLUMNNAME_Vehicle_ID = "Vehicle_ID";
    
    public org.compiere.model.I_C_OrderLine getVehicle_C_OrderLine() throws RuntimeException
    {
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
			.getPO(getVehicle_C_OrderLine_ID(), get_TrxName());	}

    /** Column name Vehicle_C_OrderLine_ID */
    public static final String COLUMNNAME_Vehicle_C_OrderLine_ID = "Vehicle_C_OrderLine_ID";
	/** Set Vehicle OrderLine ID.
		@param Vehicle_C_OrderLine_ID Vehicle OrderLine ID	  */
	public void setVehicle_C_OrderLine_ID (int Vehicle_C_OrderLine_ID)
	{
		if (Vehicle_C_OrderLine_ID < 1) 
			set_Value (COLUMNNAME_Vehicle_C_OrderLine_ID, null);
		else 
			set_Value (COLUMNNAME_Vehicle_C_OrderLine_ID, Integer.valueOf(Vehicle_C_OrderLine_ID));
	}

	/** Get Vehicle OrderLine ID.
		@return Vehicle OrderLine ID	  */
	public int getVehicle_C_OrderLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Vehicle_C_OrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getVehicle() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getVehicle_ID(), get_TrxName());	}

	/** Set Vehicle.
		@param Vehicle_ID Vehicle	  */
	public void setVehicle_ID (int Vehicle_ID)
	{
		if (Vehicle_ID < 1) 
			set_Value (COLUMNNAME_Vehicle_ID, null);
		else 
			set_Value (COLUMNNAME_Vehicle_ID, Integer.valueOf(Vehicle_ID));
	}

	/** Get Vehicle.
		@return Vehicle	  */
	public int getVehicle_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Vehicle_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	 /** Column name VehicleNo */
    public static final String COLUMNNAME_VehicleNo = "VehicleNo";

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
	
    public static final String COLUMNNAME_InvoiceNo = "InvoiceNo";

	public void setInvoiceNo (String InvoiceNo)
	{
		set_Value (COLUMNNAME_InvoiceNo, InvoiceNo);
	}

	public String getInvoiceNo () 
	{
		return (String)get_Value(COLUMNNAME_InvoiceNo);
	}
    
	public static final String COLUMNNAME_POReference = "POReference";

	public void setPOReference (String POReference)
	{
		set_Value (COLUMNNAME_POReference, POReference);
	}
	public String getPOReference  () 
	{
		return (String)get_Value(COLUMNNAME_POReference);
	}
	public static final String COLUMNNAME_PODate = "PODate";
	
	public void setPODate (Timestamp PODate)
	{
		set_Value (COLUMNNAME_PODate, PODate);
	}
	
	public Timestamp getPODate  () 
	{
		return (Timestamp)get_Value(COLUMNNAME_PODate);
	}
	
	public static final String COLUMNNAME_eWayBillNo = "eWayBillNo";

	public void seteWayBillNo (String eWayBillNo)
	{
		set_Value (COLUMNNAME_eWayBillNo, eWayBillNo);
	}
	public String geteWayBillNo () 
	{
		return (String)get_Value(COLUMNNAME_eWayBillNo);
	}
	public static final String COLUMNNAME_eWayDate = "eWayDate";
	
	public void seteWayDate (Timestamp eWayDate)
	{
		set_Value (COLUMNNAME_eWayDate, eWayDate);
	}
	
	public Timestamp geteWayDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_eWayDate);
	}
	
    public static final String COLUMNNAME_ReverseCharge = "ReverseCharge";
    
	public void setReverseCharge (boolean ReverseCharge)
	{
		set_Value (COLUMNNAME_ReverseCharge, Boolean.valueOf(ReverseCharge));
	}
	
	/** Get Show Rent Breakup.
		@return Show Rent Breakup	  */
	public boolean isReverseCharge () 
	{
		Object oo = get_Value(COLUMNNAME_ReverseCharge);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	 /** Column name Rent_Amt */
    public static final String COLUMNNAME_Rent_Amt = "Rent_Amt";
    
    /** Set Rent (Amount).
	@param Rent_Amt Rent (Amount)	  */
	public void setRent_Amt (BigDecimal Rent_Amt)
	{
		set_Value (COLUMNNAME_Rent_Amt, Rent_Amt);
	}
	
	/** Get Rent (Amount).
		@return Rent (Amount)	  */
	public BigDecimal getRent_Amt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Rent_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Column name TF_WeighmentEntry_ID */
    public static final String COLUMNNAME_TF_WeighmentEntry_ID = "TF_WeighmentEntry_ID";
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
	
	public static final String COLUMNNAME_C_Ship_Location_ID  = "C_Ship_Location_ID";
    
	public void setC_Ship_Location_ID  (int C_Ship_Location_ID)
	{
		if (C_Ship_Location_ID  < 1) 
			set_Value (COLUMNNAME_C_Ship_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_Ship_Location_ID, Integer.valueOf(C_Ship_Location_ID ));
	}
	
	public int getC_Ship_Location_ID  () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Ship_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name TF_Token_ID */
    public static final String COLUMNNAME_TF_Token_ID = "TF_Token_ID";
    /** Set Token No.
	@param TF_Token_ID Weighment Entry	  */
	public void setTF_Token_ID (int TF_Token_ID)
	{
		if (TF_Token_ID < 1) 
			set_Value (COLUMNNAME_TF_Token_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Token_ID, Integer.valueOf(TF_Token_ID));
	}
	
	/** Get Token No.
		@return Token No	  */
	public int getTF_Token_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Token_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
    
	 /** Column name TF_DriverTips_Pay_ID */
    public static final String COLUMNNAME_TF_DriverTips_Pay_ID = "TF_DriverTips_Pay_ID";
    public org.compiere.model.I_C_Payment getTF_DriverTips_Pay() throws RuntimeException
    {
		return (org.compiere.model.I_C_Payment)MTable.get(getCtx(), org.compiere.model.I_C_Payment.Table_Name)
			.getPO(getTF_DriverTips_Pay_ID(), get_TrxName());	}

	/** Set Driver Tips Payment.
		@param TF_DriverTips_Pay_ID Driver Tips Payment	  */
	public void setTF_DriverTips_Pay_ID (int TF_DriverTips_Pay_ID)
	{
		if (TF_DriverTips_Pay_ID < 1) 
			set_Value (COLUMNNAME_TF_DriverTips_Pay_ID, null);
		else 
			set_Value (COLUMNNAME_TF_DriverTips_Pay_ID, Integer.valueOf(TF_DriverTips_Pay_ID));
	}

	/** Get Driver Tips Payment.
		@return Driver Tips Payment	  */
	public int getTF_DriverTips_Pay_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_DriverTips_Pay_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	 /** Column name DriverTips */
    public static final String COLUMNNAME_DriverTips = "DriverTips";
    /** Set Driver Tips.
	@param DriverTips Driver Tips	  */
	public void setDriverTips (BigDecimal DriverTips)
	{
		set_Value (COLUMNNAME_DriverTips, DriverTips);
	}
	
	/** Get Driver Tips.
		@return Driver Tips	  */
	public BigDecimal getDriverTips () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DriverTips);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name IssueToSubcontract_ID */
    public static final String COLUMNNAME_IssueToSubcontract_ID = "IssueToSubcontract_ID";
    public org.compiere.model.I_C_Project getIssueToSubcontract() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getIssueToSubcontract_ID(), get_TrxName());	}

	/** Set Issue to Subcontract.
		@param IssueToSubcontract_ID Issue to Subcontract	  */
	public void setIssueToSubcontract_ID (int IssueToSubcontract_ID)
	{
		if (IssueToSubcontract_ID < 1) 
			set_Value (COLUMNNAME_IssueToSubcontract_ID, null);
		else 
			set_Value (COLUMNNAME_IssueToSubcontract_ID, Integer.valueOf(IssueToSubcontract_ID));
	}

	/** Get Issue to Subcontract.
		@return Issue to Subcontract	  */
	public int getIssueToSubcontract_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_IssueToSubcontract_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name TF_Destination_ID */
    public static final String COLUMNNAME_TF_Destination_ID = "TF_Destination_ID";
    /** Set Destination.
	@param TF_Destination_ID Destination	  */
	public void setTF_Destination_ID (int TF_Destination_ID)
	{
		if (TF_Destination_ID < 1) 
			set_Value (COLUMNNAME_TF_Destination_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Destination_ID, Integer.valueOf(TF_Destination_ID));
	}
	
	/** Get Destination.
		@return Destination	  */
	public int getTF_Destination_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Destination_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name Distance */
    public static final String COLUMNNAME_Distance = "Distance";
    /** Set Distance (km).
	@param Distance Distance (km)	  */
	public void setDistance (BigDecimal Distance)
	{
		set_Value (COLUMNNAME_Distance, Distance);
	}
	
	/** Get Distance (km).
		@return Distance (km)	  */
	public BigDecimal getDistance () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Distance);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name Tonnage */
    public static final String COLUMNNAME_Tonnage = "Tonnage";
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
			 return Env.ONE;
		else if(bd.doubleValue() == 0)
			return Env.ONE;
		return bd;
	}

	/** Column name TF_RentedVehicle_ID */
    public static final String COLUMNNAME_TF_RentedVehicle_ID = "TF_RentedVehicle_ID";
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

	/** Column name Rate */
    public static final String COLUMNNAME_Rate = "Rate";
    /** Set Rate / ton / km.
	@param Rate 
	Rate per tone and  km
	  */
	public void setRate (BigDecimal Rate)
	{
		set_Value (COLUMNNAME_Rate, Rate);
	}
	
	/** Get Rate / ton / km.
		@return Rate per tone and  km
	  */
	public BigDecimal getRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
    /** Column name TransporterInvoice_ID */
    public static final String COLUMNNAME_TransporterInvoice_ID = "TransporterInvoice_ID";
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

	/** Column name Item1_UnitPrice */
    public static final String COLUMNNAME_Item1_UnitPrice = "Item1_UnitPrice";
    /** Set Unit Price.
	@param Item1_UnitPrice Unit Price	  */
	public void setItem1_UnitPrice (BigDecimal Item1_UnitPrice)
	{
		set_Value (COLUMNNAME_Item1_UnitPrice, Item1_UnitPrice);
	}
	
	/** Get Unit Price.
		@return Unit Price	  */
	public BigDecimal getItem1_UnitPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_UnitPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Column name Item1_UnitRent */
    public static final String COLUMNNAME_Item1_UnitRent = "Item1_UnitRent";
    /** Set Unit Rent.
	@param Item1_UnitRent Unit Rent	  */
	public void setItem1_UnitRent (BigDecimal Item1_UnitRent)
	{
		set_Value (COLUMNNAME_Item1_UnitRent, Item1_UnitRent);
	}
	
	/** Get Unit Rent.
		@return Unit Rent	  */
	public BigDecimal getItem1_UnitRent () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_UnitRent);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Column name RentMargin */
    public static final String COLUMNNAME_RentMargin = "RentMargin";
    /** Set Rent Margin.
	@param RentMargin Rent Margin	  */
	public void setRentMargin (BigDecimal RentMargin)
	{
		set_Value (COLUMNNAME_RentMargin, RentMargin);
	}
	
	/** Get Rent Margin.
		@return Rent Margin	  */
	public BigDecimal getRentMargin () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RentMargin);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Column name RentPayable */
    public static final String COLUMNNAME_RentPayable = "RentPayable";
    /** Set Rent Payable.
	@param RentPayable 
	Rent Payable for Transporter
  */
	public void setRentPayable (BigDecimal RentPayable)
	{
		set_Value (COLUMNNAME_RentPayable, RentPayable);
	}
	
	/** Get Rent Payable.
		@return Rent Payable for Transporter
	  */
	public BigDecimal getRentPayable () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RentPayable);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
    /** Column name IsRentBreakup */
    public static final String COLUMNNAME_IsRentBreakup = "IsRentBreakup";

    /** Set Show Rent Breakup.
	@param IsRentBreakup Show Rent Breakup	  */
	public void setIsRentBreakup (boolean IsRentBreakup)
	{
		set_Value (COLUMNNAME_IsRentBreakup, Boolean.valueOf(IsRentBreakup));
	}
	
	/** Get Show Rent Breakup.
		@return Show Rent Breakup	  */
	public boolean isRentBreakup () 
	{
		Object oo = get_Value(COLUMNNAME_IsRentBreakup);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Column name IsTaxIncluded for client */
    public static final String COLUMNNAME_IsTaxIncluded1 = "IsTaxIncluded1";

	/** Set Price includes Tax.
	  * Tax is included in the price 
	  */
	public void setIsTaxIncluded1 (boolean IsTaxIncluded1)
	{
		set_Value (COLUMNNAME_IsTaxIncluded1, Boolean.valueOf(IsTaxIncluded1));
	}

	/** Get Price includes Tax.
	  * Tax is included in the price 
	  */
	public boolean isTaxIncluded1()
	{
		Object oo = get_Value(COLUMNNAME_IsTaxIncluded1);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}


	/** Column name IsRentInclusive */
    public static final String COLUMNNAME_IsRentInclusive = "IsRentInclusive";
    /** Set Rent Inclusive.
	@param IsRentInclusive 
	Whether Unit Price includes rent?
  */
	public void setIsRentInclusive (boolean IsRentInclusive)
	{
		set_Value (COLUMNNAME_IsRentInclusive, Boolean.valueOf(IsRentInclusive));
	}
	
	/** Get Rent Inclusive.
		@return Whether Unit Price includes rent?
	  */
	public boolean isRentInclusive () 
	{
		Object oo = get_Value(COLUMNNAME_IsRentInclusive);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Column name Subcon_Invoice_ID */
    public static final String COLUMNNAME_Subcon_Invoice_ID = "Subcon_Invoice_ID";
    public static final String COLUMNNAME_Subcon_Invoice2_ID = "Subcon_Invoice2_ID";
    public org.compiere.model.I_C_Invoice getSubcon_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getSubcon_Invoice_ID(), get_TrxName());	}

	/** Set Subcontractor Invoice.
		@param Subcon_Invoice_ID Subcontractor Invoice	  */
	public void setSubcon_Invoice_ID (int Subcon_Invoice_ID)
	{
		if (Subcon_Invoice_ID < 1) 
			set_Value (COLUMNNAME_Subcon_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_Subcon_Invoice_ID, Integer.valueOf(Subcon_Invoice_ID));
	}

	/** Get Subcontractor Invoice.
		@return Subcontractor Invoice	  */
	public int getSubcon_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Subcon_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Subcontractor2 Invoice.
	@param Subcon_Invoice_ID Subcontractor Invoice	  */
	public void setSubcon_Invoice2_ID (int Subcon_Invoice2_ID)
	{
		if (Subcon_Invoice2_ID < 1) 
			set_Value (COLUMNNAME_Subcon_Invoice2_ID, null);
		else 
			set_Value (COLUMNNAME_Subcon_Invoice2_ID, Integer.valueOf(Subcon_Invoice2_ID));
	}
	
	/** Get Subcontractor2 Invoice.
		@return Subcontractor Invoice	  */
	public int getSubcon_Invoice2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Subcon_Invoice2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	

    /** Column name Subcon_Receipt_ID */
    public static final String COLUMNNAME_Subcon_Receipt_ID = "Subcon_Receipt_ID";
    public org.compiere.model.I_M_InOut getSubcon_Receipt() throws RuntimeException
    {
		return (org.compiere.model.I_M_InOut)MTable.get(getCtx(), org.compiere.model.I_M_InOut.Table_Name)
			.getPO(getSubcon_Receipt_ID(), get_TrxName());	}

	/** Set Subcontractor Material Receipt.
		@param Subcon_Receipt_ID Subcontractor Material Receipt	  */
	public void setSubcon_Receipt_ID (int Subcon_Receipt_ID)
	{
		if (Subcon_Receipt_ID < 1) 
			set_Value (COLUMNNAME_Subcon_Receipt_ID, null);
		else 
			set_Value (COLUMNNAME_Subcon_Receipt_ID, Integer.valueOf(Subcon_Receipt_ID));
	}

	/** Get Subcontractor Material Receipt.
		@return Subcontractor Material Receipt	  */
	public int getSubcon_Receipt_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Subcon_Receipt_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	 
	
	/** Column name Item2_UOM_ID */
    public static final String COLUMNNAME_Item2_UOM_ID = "Item2_UOM_ID";
	public org.compiere.model.I_C_UOM getItem2_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getItem2_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param Item2_UOM_ID UOM	  */
	public void setItem2_UOM_ID (int Item2_UOM_ID)
	{
		if (Item2_UOM_ID < 1) 
			set_Value (COLUMNNAME_Item2_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_Item2_UOM_ID, Integer.valueOf(Item2_UOM_ID));
	}

	/** Get UOM.
		@return UOM	  */
	public int getItem2_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Item2_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name Item2_Tax_ID */
    public static final String COLUMNNAME_Item2_Tax_ID = "Item2_Tax_ID";
    public org.compiere.model.I_C_Tax getItem2_Tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getItem2_Tax_ID(), get_TrxName());	}

	/** Set Tax.
		@param Item2_Tax_ID 
		Tax Identifier
	  */
	public void setItem2_Tax_ID (int Item2_Tax_ID)
	{
		if (Item2_Tax_ID < 1) 
			set_Value (COLUMNNAME_Item2_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_Item2_Tax_ID, Integer.valueOf(Item2_Tax_ID));
	}

	/** Get Tax.
		@return Tax Identifier
	  */
	public int getItem2_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Item2_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name OrgType */
    public static final String COLUMNNAME_OrgType = "OrgType";    
    /** Crusher = C */
    /** Crusher = C */
	public static final String ORGTYPE_Crusher = "C";
	/** Sand Block Bucket = S */
	public static final String ORGTYPE_SandBlockBucket = "S";
	/** Trading = T */
	public static final String ORGTYPE_Trading = "T";
	/** Head Office = H */
	public static final String ORGTYPE_HeadOffice = "H";
	/** Sand Block Weighbridge = W */
	public static final String ORGTYPE_SandBlockWeighbridge = "W";
    /** Set Organization Type.
	@param OrgType Organization Type	  */
	public void setOrgType (String OrgType)
	{
	
		set_Value (COLUMNNAME_OrgType, OrgType);
	}
	
	/** Get Organization Type.
		@return Organization Type	  */
	public String getOrgType () 
	{
		return (String)get_Value(COLUMNNAME_OrgType);
	}
	
	/** Column name Item1_BucketQty */
    public static final String COLUMNNAME_Item1_BucketQty = "Item1_BucketQty";
    /** Set Bucket Qty.
	@param Item1_BucketQty Bucket Qty	  */
	public void setItem1_BucketQty (BigDecimal Item1_BucketQty)
	{
		set_Value (COLUMNNAME_Item1_BucketQty, Item1_BucketQty);
	}
	
	/** Get Bucket Qty.
		@return Bucket Qty	  */
	public BigDecimal getItem1_BucketQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_BucketQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name Item2_BucketQty */
    public static final String COLUMNNAME_Item2_BucketQty = "Item2_BucketQty";
    /** Set Bucket Qty.
	@param Item2_BucketQty Bucket Qty	  */
	public void setItem2_BucketQty (BigDecimal Item2_BucketQty)
	{
		set_Value (COLUMNNAME_Item2_BucketQty, Item2_BucketQty);
	}
	
	/** Get Bucket Qty.
		@return Bucket Qty	  */
	public BigDecimal getItem2_BucketQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item2_BucketQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

    /** Column name TonePerBucket */
    public static final String COLUMNNAME_TonePerBucket = "TonePerBucket";
    /** Set Tone (per Bucket).
	@param TonePerBucket Tone (per Bucket)	  */
	public void setTonePerBucket (BigDecimal TonePerBucket)
	{
		set_Value (COLUMNNAME_TonePerBucket, TonePerBucket);
	}
	
	/** Get Tone (per Bucket).
		@return Tone (per Bucket)	  */
	public BigDecimal getTonePerBucket () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TonePerBucket);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
    
	/** Column name Item1_IsPermitSales */
    public static final String COLUMNNAME_Item1_IsPermitSales = "Item1_IsPermitSales";
    /** Set Permit Sales.
	@param Item1_IsPermitSales Permit Sales	  */
	public void setItem1_IsPermitSales (boolean Item1_IsPermitSales)
	{
		set_Value (COLUMNNAME_Item1_IsPermitSales, Boolean.valueOf(Item1_IsPermitSales));
	}
	/** Column name Item2_IsPermitSales */
    public static final String COLUMNNAME_Item2_IsPermitSales = "Item2_IsPermitSales";
    /** Set Permit Sales.
	@param Item2_IsPermitSales Permit Sales	  */
	public void setItem2_IsPermitSales (boolean Item2_IsPermitSales)
	{
		set_Value (COLUMNNAME_Item2_IsPermitSales, Boolean.valueOf(Item2_IsPermitSales));
	}
	
	/** Get Permit Sales.
		@return Permit Sales	  */
	public boolean isItem2_IsPermitSales () 
	{
		Object oo = get_Value(COLUMNNAME_Item2_IsPermitSales);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Get Permit Sales.
	@return Permit Sales	  */
	public boolean isItem1_IsPermitSales () 
	{
		Object oo = get_Value(COLUMNNAME_Item1_IsPermitSales);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
    /** Column name Item1_BucketRate */
    public static final String COLUMNNAME_Item1_BucketRate = "Item1_BucketRate";
    
    /** Set Bucket Rate.
	@param Item1_BucketRate Bucket Rate	  */
	public void setItem1_BucketRate (BigDecimal Item1_BucketRate)
	{
		set_Value (COLUMNNAME_Item1_BucketRate, Item1_BucketRate);
	}
	
	/** Get Bucket Rate.
		@return Bucket Rate	  */
	public BigDecimal getItem1_BucketRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_BucketRate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name Item2_BucketRate */
    public static final String COLUMNNAME_Item2_BucketRate = "Item2_BucketRate";
    /** Set Bucket Rate.
	@param Item2_BucketRate Bucket Rate	  */
	public void setItem2_BucketRate (BigDecimal Item2_BucketRate)
	{
		set_Value (COLUMNNAME_Item2_BucketRate, Item2_BucketRate);
	}
	
	/** Get Bucket Rate.
		@return Bucket Rate	  */
	public BigDecimal getItem2_BucketRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item2_BucketRate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	/** Column name Item2_TonePerBucket */
    public static final String COLUMNNAME_Item2_TonePerBucket = "Item2_TonePerBucket";
    /** Set Tone (per Bucket).
	@param Item2_TonePerBucket Tone (per Bucket)	  */
	public void setItem2_TonePerBucket (BigDecimal Item2_TonePerBucket)
	{
		set_Value (COLUMNNAME_Item2_TonePerBucket, Item2_TonePerBucket);
	}
	
	/** Get Tone (per Bucket).
		@return Tone (per Bucket)	  */
	public BigDecimal getItem2_TonePerBucket () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item2_TonePerBucket);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name Item1_Desc */
    public static final String COLUMNNAME_Item1_Desc = "Item1_Desc";
    /** Set Description.
	@param Item1_Desc Description	  */
	public void setItem1_Desc (String Item1_Desc)
	{
		set_Value (COLUMNNAME_Item1_Desc, Item1_Desc);
	}
	
	/** Get Description.
		@return Description	  */
	public String getItem1_Desc () 
	{
		return (String)get_Value(COLUMNNAME_Item1_Desc);
	}
	
    /** Column name Item2_Desc */
    public static final String COLUMNNAME_Item2_Desc = "Item2_Desc";
    /** Set Description.
	@param Item2_Desc Description	  */
	public void setItem2_Desc (String Item2_Desc)
	{
		set_Value (COLUMNNAME_Item2_Desc, Item2_Desc);
	}
	
	/** Get Description.
		@return Description	  */
	public String getItem2_Desc () 
	{
		return (String)get_Value(COLUMNNAME_Item2_Desc);
	}

	/** Column name Item1_SandType */
    public static final String COLUMNNAME_Item1_SandType = "Item1_SandType";
    /** Permit Sand = PM */
	public static final String ITEM1_SANDTYPE_PermitSand = "PM";
	/** Extra Bucket = EX */
	public static final String ITEM1_SANDTYPE_ExtraBucket = "EX";
	/** Without Permit = WP */
	public static final String ITEM1_SANDTYPE_WithoutPermit = "WP";
	/** Set Sand Type.
		@param Item1_SandType Sand Type	  */
	public void setItem1_SandType (String Item1_SandType)
	{

		set_Value (COLUMNNAME_Item1_SandType, Item1_SandType);
	}

	/** Get Sand Type.
	@return Sand Type	  */
	public String getItem1_SandType () 
	{
		return (String)get_Value(COLUMNNAME_Item1_SandType);
	}

	/** Column name Item2_SandType */
    public static final String COLUMNNAME_Item2_SandType = "Item2_SandType";
    /** Permit Sand = PM */
	public static final String ITEM2_SANDTYPE_PermitSand = "PM";
	/** Extra Bucket = EX */
	public static final String ITEM2_SANDTYPE_ExtraBucket = "EX";
	/** Without Permit = WP */
	public static final String ITEM2_SANDTYPE_WithoutPermit = "WP";
	/** Set Sand Type.
		@param Item2_SandType Sand Type	  */
	public void setItem2_SandType (String Item2_SandType)
	{

		set_Value (COLUMNNAME_Item2_SandType, Item2_SandType);
	}

	/** Get Sand Type.
		@return Sand Type	  */
	public String getItem2_SandType () 
	{
		return (String)get_Value(COLUMNNAME_Item2_SandType);
	}

	/** Column name Item1_TotalLoad */
    public static final String COLUMNNAME_Item1_TotalLoad = "Item1_TotalLoad";
    /** Set Total Load.
	@param Item1_TotalLoad Total Load	  */
	public void setItem1_TotalLoad (BigDecimal Item1_TotalLoad)
	{
		set_Value (COLUMNNAME_Item1_TotalLoad, Item1_TotalLoad);
	}
	
	/** Get Total Load.
		@return Total Load	  */
	public BigDecimal getItem1_TotalLoad () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_TotalLoad);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name Item2_TotalLoad */
    public static final String COLUMNNAME_Item2_TotalLoad = "Item2_TotalLoad";
    /** Set Total Load.
	@param Item2_TotalLoad Total Load	  */
	public void setItem2_TotalLoad (BigDecimal Item2_TotalLoad)
	{
		set_Value (COLUMNNAME_Item2_TotalLoad, Item2_TotalLoad);
	}
	
	/** Get Total Load.
		@return Total Load	  */
	public BigDecimal getItem2_TotalLoad () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item2_TotalLoad);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
    
	/** Column name Item1_PermitIssued */
    public static final String COLUMNNAME_Item1_PermitIssued = "Item1_PermitIssued";

	/** Set Permit Issued.
		@param Item1_PermitIssued Permit Issued	  */
	public void setItem1_PermitIssued (BigDecimal Item1_PermitIssued)
	{
		set_Value (COLUMNNAME_Item1_PermitIssued, Item1_PermitIssued);
	}

	/** Get Permit Issued.
		@return Permit Issued	  */
	public BigDecimal getItem1_PermitIssued () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_PermitIssued);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name Item1_VehicleType_ID */
    public static final String COLUMNNAME_Item1_VehicleType_ID = "Item1_VehicleType_ID";

	/** Set Vehicle Type.
		@param Item1_VehicleType_ID Vehicle Type	  */
	public void setItem1_VehicleType_ID (int Item1_VehicleType_ID)
	{
		if (Item1_VehicleType_ID < 1) 
			set_Value (COLUMNNAME_Item1_VehicleType_ID, null);
		else 
			set_Value (COLUMNNAME_Item1_VehicleType_ID, Integer.valueOf(Item1_VehicleType_ID));
	}

	/** Get Vehicle Type.
		@return Vehicle Type	  */
	public int getItem1_VehicleType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Item1_VehicleType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Column name TF_YardEntry_ID */
    public static final String COLUMNNAME_TF_YardEntry_ID = "TF_YardEntry_ID";
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
	/** Column name TF_YardEntryApprove_ID */
    public static final String COLUMNNAME_TF_YardEntryApprove_ID = "TF_YardEntryApprove_ID";
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
	
	/** Column name OnAccount */
    public static final String COLUMNNAME_OnAccount = "OnAccount";
    /** Set On Account.
	@param OnAccount On Account	  */
	public void setOnAccount (boolean OnAccount)
	{
		set_Value (COLUMNNAME_OnAccount, Boolean.valueOf(OnAccount));
	}
	
	/** Get On Account.
		@return On Account	  */
	public boolean isOnAccount () 
	{
		Object oo = get_Value(COLUMNNAME_OnAccount);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Column name MDPNo */
    public static final String COLUMNNAME_MDPNo = "MDPNo";
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
	
	/** Column name TF_TaxInvoice_ID */
    public static final String COLUMNNAME_TF_TaxInvoice_ID = "TF_TaxInvoice_ID";
    
    /** Column name SalesDiscountAmt */
    public static final String COLUMNNAME_SalesDiscountAmt = "SalesDiscountAmt";

    /** Column name C_PaymentSalesDiscount_ID */
    public static final String COLUMNNAME_C_PaymentSalesDiscount_ID = "C_PaymentSalesDiscount_ID";

    public static final String COLUMNNAME_TF_TRTaxInvoice_ID = "TF_TRTaxInvoice_ID";
    /** Set Tax Invoice.
	@param TF_TaxInvoice_ID Tax Invoice	  */
	public void setTF_TaxInvoice_ID (int TF_TaxInvoice_ID)
	{
		if (TF_TaxInvoice_ID < 1) 
			set_Value (COLUMNNAME_TF_TaxInvoice_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TaxInvoice_ID, Integer.valueOf(TF_TaxInvoice_ID));
	}
		
	/** Get Tax Invoice.
		@return Tax Invoice	  */
	public int getTF_TaxInvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TaxInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Set Tax Invoice.
	@param TF_TRTaxInvoice_ID Tax Invoice	  */
	public void setTF_TRTaxInvoice_ID(int TF_TRTaxInvoice_ID)
	{
		if (TF_TRTaxInvoice_ID < 1) 
			set_Value (COLUMNNAME_TF_TRTaxInvoice_ID, null);
		else 
			set_Value (COLUMNNAME_TF_TRTaxInvoice_ID, Integer.valueOf(TF_TRTaxInvoice_ID));
	}
	
	/** Get Tax Invoice.
	@return Tax Invoice	  */
	public int getTF_TRTaxInvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_TRTaxInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	/** Column name Rent_Tax_ID */
    public static final String COLUMNNAME_Rent_Tax_ID = "Rent_Tax_ID";
    public org.compiere.model.I_C_Tax getRent_Tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getRent_Tax_ID(), get_TrxName());	}

	/** Set Tax for Delivery.
		@param Rent_Tax_ID Tax for Delivery	  */
	public void setRent_Tax_ID (int Rent_Tax_ID)
	{
		if (Rent_Tax_ID < 1) 
			set_Value (COLUMNNAME_Rent_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_Rent_Tax_ID, Integer.valueOf(Rent_Tax_ID));
	}

	/** Get Tax for Delivery.
		@return Tax for Delivery	  */
	public int getRent_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Rent_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name PartyName */
    public static final String COLUMNNAME_PartyName = "PartyName";
	/** Get Party Name.
	@return Party Name	  */
	public String getPartyName () 
	{
		return (String)get_Value(COLUMNNAME_PartyName);
	}
		/** Set Party Name.
		@param PartyName Party Name	  */
	public void setPartyName (String PartyName)
	{
		set_Value (COLUMNNAME_PartyName, PartyName);
	}
	
	/** Column name Phone */
    public static final String COLUMNNAME_Phone = "Phone";
	/** Set Phone.
	@param Phone 
	Identifies a telephone number
  */
	public void setPhone (String Phone)
	{
		set_Value (COLUMNNAME_Phone, Phone);
	}
	
	/** Get Phone.
		@return Identifies a telephone number
	  */
	public String getPhone () 
	{
		return (String)get_Value(COLUMNNAME_Phone);
	}
	
	 /** Column name DiscntStatus */
    public static final String COLUMNNAME_DiscntStatus = "DiscntStatus";
    
	/** Requested = RQ */
	public static final String DISCNTSTATUS_Requested = "RQ";
	/** Approved = AP */
	public static final String DISCNTSTATUS_Approved = "AP";
	/** Closed = CL */
	public static final String DISCNTSTATUS_Closed = "CL";
	/** Voided = VO */
	public static final String DISCNTSTATUS_Voided = "VO";
	/** Set Discount Status.
		@param DiscntStatus Discount Status	  */
	public void setDiscntStatus (String DiscntStatus)
	{

		set_Value (COLUMNNAME_DiscntStatus, DiscntStatus);
	}

	/** Get Discount Status.
		@return Discount Status	  */
	public String getDiscntStatus () 
	{
		return (String)get_Value(COLUMNNAME_DiscntStatus);
	}


    /** Column name TF_DiscountRequest_ID */
    public static final String COLUMNNAME_TF_DiscountRequest_ID = "TF_DiscountRequest_ID";

	/** Set Discount Request.
	@param TF_DiscountRequest_ID Discount Request	  */
	public void setTF_DiscountRequest_ID (int TF_DiscountRequest_ID)
	{
		if (TF_DiscountRequest_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_DiscountRequest_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_DiscountRequest_ID, Integer.valueOf(TF_DiscountRequest_ID));
	}
	
	/** Get Discount Request.
		@return Discount Request	  */
	public int getTF_DiscountRequest_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_DiscountRequest_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Column name TF_BlueMetal_Type */
    public static final String COLUMNNAME_TF_BlueMetal_Type = "TF_BlueMetal_Type";

	/** Regular = R */
	public static final String TF_BLUEMETAL_TYPE_Regular = "R";
	/** Wetmix = W */
	public static final String TF_BLUEMETAL_TYPE_Wetmix = "W";
	/** Regular + Geosand = RG */
	public static final String TF_BLUEMETAL_TYPE_RegularPlusGeosand = "RG";
	/** 40 MM only = 40 */
	public static final String TF_BLUEMETAL_TYPE_40MMOnly = "40";
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

    /** Column name TF_ProductionPlant_ID */
    public static final String COLUMNNAME_TF_ProductionPlant_ID = "TF_ProductionPlant_ID";

	/** Set TF_ProductionPlant.
	@param TF_ProductionPlant_ID TF_ProductionPlant	  */
	public void setTF_ProductionPlant_ID (int TF_ProductionPlant_ID)
	{
		if (TF_ProductionPlant_ID < 1) 
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, null);
		else 
			set_Value (COLUMNNAME_TF_ProductionPlant_ID, Integer.valueOf(TF_ProductionPlant_ID));
	}
	
	/** Get TF_ProductionPlant.
		@return TF_ProductionPlant	  */
	public int getTF_ProductionPlant_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ProductionPlant_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Column name TF_Send_To */
    public static final String COLUMNNAME_TF_Send_To = "TF_Send_To";

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

    /** Column name TF_Crusher_Production_ID */
    public static final String COLUMNNAME_TF_Crusher_Production_ID = "TF_Crusher_Production_ID";
	/** Set Crusher Production.
	@param TF_Crusher_Production_ID Crusher Production	  */
	public void setTF_Crusher_Production_ID (int TF_Crusher_Production_ID)
	{
		if (TF_Crusher_Production_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_Crusher_Production_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_Crusher_Production_ID, Integer.valueOf(TF_Crusher_Production_ID));
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
	/** Column name CreateTransportInvoice */
    public static final String COLUMNNAME_CreateTransporterInvoice = "CreateTransporterInvoice";
    /** Set Create Transport Invoice.
	@param CreateTransportInvoice Create Transport Invoice	  */
	public void setCreateTransporterInvoice (boolean CreateTransportInvoice)
	{
		set_Value (COLUMNNAME_CreateTransporterInvoice, Boolean.valueOf(CreateTransportInvoice));
	}
	
	/** Get Create Transport Invoice.
		@return Create Transport Invoice	  */
	public boolean isCreateTransportInvoice () 
	{
		Object oo = get_Value(COLUMNNAME_CreateTransporterInvoice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Column name IsRoyaltyPassInclusive */
    public static final String COLUMNNAME_IsRoyaltyPassInclusive = "IsRoyaltyPassInclusive";
	/** Set Royalty Pass Inclusive.
	@param IsRoyaltyPassInclusive Royalty Pass Inclusive	  */
	public void setIsRoyaltyPassInclusive (boolean IsRoyaltyPassInclusive)
	{
		set_Value (COLUMNNAME_IsRoyaltyPassInclusive, Boolean.valueOf(IsRoyaltyPassInclusive));
	}
	
	/** Get Royalty Pass Inclusive.
		@return Royalty Pass Inclusive	  */
	public boolean isRoyaltyPassInclusive () 
	{
		Object oo = get_Value(COLUMNNAME_IsRoyaltyPassInclusive);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
    /** Column name IsRoyaltyPassBreakup */
    public static final String COLUMNNAME_IsRoyaltyPassBreakup = "IsRoyaltyPassBreakup";
    
	/** Set Show Royalty Pass Breakup.
	@param IsRoyaltyPassBreakup Show Royalty Pass Breakup	  */
	public void setIsRoyaltyPassBreakup (boolean IsRoyaltyPassBreakup)
	{
		set_Value (COLUMNNAME_IsRoyaltyPassBreakup, Boolean.valueOf(IsRoyaltyPassBreakup));
	}
	
	/** Get Show Royalty Pass Breakup.
		@return Show Royalty Pass Breakup	  */
	public boolean isRoyaltyPassBreakup () 
	{
		Object oo = get_Value(COLUMNNAME_IsRoyaltyPassBreakup);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	 /** Column name M_Product_Category_ID */
    public static final String COLUMNNAME_M_Product_Category_ID = "M_Product_Category_ID";	
	public org.compiere.model.I_M_Product_Category getM_Product_Category() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product_Category)MTable.get(getCtx(), org.compiere.model.I_M_Product_Category.Table_Name)
			.getPO(getM_Product_Category_ID(), get_TrxName());	}

	/** Set Product Category.
		@param M_Product_Category_ID 
		Category of a Product
	  */
	public void setM_Product_Category_ID (int M_Product_Category_ID)
	{
		if (M_Product_Category_ID < 1) 
			set_Value (COLUMNNAME_M_Product_Category_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_Category_ID, Integer.valueOf(M_Product_Category_ID));
	}

	/** Get Product Category.
		@return Category of a Product
	  */
	public int getM_Product_Category_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_Category_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
    /** Column name M_Locator_ID */	
    public static final String COLUMNNAME_M_Locator_ID = "M_Locator_ID";
	public org.compiere.model.I_M_Locator getM_Locator() throws RuntimeException
    {
		return (org.compiere.model.I_M_Locator)MTable.get(getCtx(), org.compiere.model.I_M_Locator.Table_Name)
			.getPO(getM_Locator_ID(), get_TrxName());	}

	/** Set Locator.
		@param M_Locator_ID 
		Warehouse Locator
	  */
	public void setM_Locator_ID (int M_Locator_ID)
	{
		if (M_Locator_ID < 1) 
			set_Value (COLUMNNAME_M_Locator_ID, null);
		else 
			set_Value (COLUMNNAME_M_Locator_ID, Integer.valueOf(M_Locator_ID));
	}

	/** Get Locator.
		@return Warehouse Locator
	  */
	public int getM_Locator_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Locator_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	public int C_Tax_ID = 0;
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {		
		success = super.afterSave(newRecord, success);
		
		updateQuickOrderLines();
		//updateVehicleRentLine();
		//updateRentedVehicleRentLine();
		if(isItem1_IsUpdatePrice() && isSOTrx()) {
			TF_MOrder.updateProductPricing(getItem1_ID(), getM_PriceList_ID(), getC_BPartner_ID(), 
					getItem1_Qty(), getItem1_UnitPrice(), getDateOrdered(), isSOTrx());
		}
		
		return success;
	}
	
	private void setLinePrice(MOrderLine line, BigDecimal price) {
		line.setPriceActual(price);
		line.setPriceList(price);
		line.setPriceLimit(price);
		line.setPriceEntered(price);
	}
	
	private void setOrderLine(MOrderLine line, int product_ID, BigDecimal qty, BigDecimal price) {
		line.setM_Product_ID(product_ID, true);
		line.setQty(qty);
		setLinePrice(line, price);
	}
	
	private void setOrderLine(MOrderLine line, int product_ID, int C_UOM_ID, BigDecimal qty, BigDecimal price) {
		line.setM_Product_ID(product_ID, true);
		line.setQtyEntered(qty);
		BigDecimal multiplyRate =  MUOMConversion.getProductRateTo(getCtx(), product_ID, C_UOM_ID);
		
		MWeighmentEntry wEntry = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
		if(getTF_WeighmentEntry_ID() > 0 && wEntry.getCFTMultiplyRate() != null && multiplyRate.doubleValue() != 1)
			multiplyRate = wEntry.getCFTMultiplyRate();
		
		if(multiplyRate != null) {						
			line.setQtyOrdered (qty.divide(multiplyRate,3, RoundingMode.HALF_EVEN));
		}
		else {
			line.setQtyOrdered(qty); 
			multiplyRate = BigDecimal.ONE;
		}
		
		line.setPriceActual(price);
		//line.setPriceActual(price.multiply(multiplyRate)); // Price in Default UOM such as Tonnage
		line.setPriceList(price); // Price for the Sales UOM
		line.setPriceLimit(line.getPriceActual()); // 
		line.setPriceEntered(price); // Price for the Sales UOM
	}
	
    /** Column name Item1_PassUnitPrice */
    public static final String COLUMNNAME_Item1_PassUnitPrice = "Item1_PassUnitPrice";
	/** Set Royalty Pass Unit Price.
	@param Item1_PassUnitPrice Royalty Pass Unit Price	  */
	public void setItem1_PassUnitPrice (BigDecimal Item1_PassUnitPrice)
	{
		set_Value (COLUMNNAME_Item1_PassUnitPrice, Item1_PassUnitPrice);
	}
	
	/** Get Royalty Pass Unit Price.
		@return Royalty Pass Unit Price	  */
	public BigDecimal getItem1_PassUnitPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Item1_PassUnitPrice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Column name Terms & Conditions */
    public static final String COLUMNNAME_TermsAndCondition = "TermsAndCondition";
    
	public void setTermsAndCondition (String TermsAndCondition)
	{
		set_Value (COLUMNNAME_TermsAndCondition, TermsAndCondition);
	}

	public String getTermsAndCondition () 
	{		
		return (String)get_Value(COLUMNNAME_TermsAndCondition);
	}
	
	/** Column name Rent_UOM_ID */
    public static final String COLUMNNAME_Rent_UOM_ID = "Rent_UOM_ID";
    public org.compiere.model.I_C_UOM getRent_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getRent_UOM_ID(), get_TrxName());	}

	/** Set Delivery UOM.
		@param Rent_UOM_ID Delivery UOM	  */
	public void setRent_UOM_ID (int Rent_UOM_ID)
	{
		if (Rent_UOM_ID < 1) 
			set_Value (COLUMNNAME_Rent_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_Rent_UOM_ID, Integer.valueOf(Rent_UOM_ID));
	}

	/** Get Delivery UOM.
		@return Delivery UOM	  */
	public int getRent_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Rent_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name C_BankAccount_ID */
    public static final String COLUMNNAME_C_BankAccount_ID = "C_BankAccount_ID";
	public org.compiere.model.I_C_BankAccount getC_BankAccount() throws RuntimeException
    {
		return (org.compiere.model.I_C_BankAccount)MTable.get(getCtx(), org.compiere.model.I_C_BankAccount.Table_Name)
			.getPO(getC_BankAccount_ID(), get_TrxName());	}

	/** Set Bank/Cash Account.
		@param C_BankAccount_ID 
		Account at the Bank
	  */
	public void setC_BankAccount_ID (int C_BankAccount_ID)
	{
		if (C_BankAccount_ID < 1) 
			set_Value (COLUMNNAME_C_BankAccount_ID, null);
		else 
			set_Value (COLUMNNAME_C_BankAccount_ID, Integer.valueOf(C_BankAccount_ID));
	}

	/** Get Bank/Cash Account.
		@return Account at the Bank
	  */
	public int getC_BankAccount_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BankAccount_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
		
	
	public void updateQuickOrderLines() {
		TF_MOrderLine ordLine = null;
		//Delete empty item lines
		if(is_ValueChanged(COLUMNNAME_Item1_ID) || (getItem1_ID() == 0 && getItem1_C_OrderLine_ID() > 0)) {
			ordLine = new TF_MOrderLine(getCtx(), getItem1_C_OrderLine_ID(), get_TrxName());
			if(ordLine.get_ID() > 0) {
				DB.executeUpdate("UPDATE C_Order SET " + COLUMNNAME_Item1_C_OrderLine_ID + " = NULL " +
						" WHERE C_Order_ID =" + getC_Order_ID(), get_TrxName());
				ordLine.setQtyReserved(BigDecimal.ZERO);
				ordLine.delete(false);
				setItem1_C_OrderLine_ID(0);
			}
		}
		if(is_ValueChanged(COLUMNNAME_Item2_ID) || (getItem2_ID() == 0 && getItem2_C_OrderLine_ID() > 0)) {
			ordLine = new TF_MOrderLine(getCtx(), getItem2_C_OrderLine_ID(), get_TrxName());
			if(ordLine.get_ID() > 0) {
				DB.executeUpdate("UPDATE C_Order SET " + COLUMNNAME_Item2_C_OrderLine_ID + " = NULL " +
						" WHERE C_Order_ID =" + getC_Order_ID(), get_TrxName());
				ordLine.setQtyReserved(BigDecimal.ZERO);				
				ordLine.delete(false);
				setItem2_C_OrderLine_ID(0);
			}
		} // End Delete
		
		//Update modified item lines.		
		//Item1
		if(getItem1_ID() > 0 && (is_ValueChanged(COLUMNNAME_Item1_ID) || is_ValueChanged(COLUMNNAME_Item1_Qty)
				|| is_ValueChanged(COLUMNNAME_Item1_Tax_ID)
				|| is_ValueChanged(COLUMNNAME_Item1_TotalLoad) || is_ValueChanged(COLUMNNAME_Item1_VehicleType_ID)
				|| is_ValueChanged(COLUMNNAME_Item1_SandType)
				|| is_ValueChanged(COLUMNNAME_M_Warehouse_ID)
				|| is_ValueChanged(COLUMNNAME_M_Locator_ID)
				|| is_ValueChanged(COLUMNNAME_M_Product_Category_ID)
				|| is_ValueChanged(COLUMNNAME_Item1_Price) || getItem1_C_OrderLine_ID() == 0)) {
			
			if(getItem1_C_OrderLine_ID() > 0) 
				ordLine = new TF_MOrderLine(getCtx(), getItem1_C_OrderLine_ID(), get_TrxName());
			else
				ordLine = new TF_MOrderLine(this);
			TF_MOrder.addProductPricingIfNot(getItem1_ID(), getM_PriceList_ID(), getC_BPartner_ID(), getItem1_Qty(), getItem1_Price(), 
					getDateOrdered(), getC_DocType().isSOTrx());
			setOrderLine(ordLine, getItem1_ID(), getItem1_UOM_ID(), getItem1_Qty(), getItem1_Price());
			
			ordLine.setC_Tax_ID(getItem1_Tax_ID());
			
			//For SO, From header itself, price is updated.
			if(!isSOTrx())
				ordLine.setIsUpdatePrice(isItem1_IsUpdatePrice());
			
			ordLine.setC_UOM_ID(getItem1_UOM_ID());
			
			//Sand Block fields
			//these should be updated in invoice line at:
			// 1. Create Subcontract Invoice
			// 2. CrusherEventHandler.
			ordLine.setBucketQty(getItem1_BucketQty());
			ordLine.setSandType(getItem1_SandType());
			ordLine.setIsPermitSales(isItem1_IsPermitSales());
			ordLine.setTonePerBucket(getTonePerBucket());
			ordLine.setBucketRate(getItem1_BucketRate());
			ordLine.setDescription(getItem1_Desc());
			ordLine.setTotalLoad(getItem1_TotalLoad());
			ordLine.setTF_VehicleType_ID(getItem1_VehicleType_ID());
			ordLine.set_ValueOfColumn("M_WarehouseNew_ID", getM_Warehouse_ID() == 0 ? null : getM_Warehouse_ID() );
			ordLine.set_ValueOfColumn(COLUMNNAME_M_Locator_ID, getM_Locator_ID() == 0 ? null : getM_Locator_ID());
			ordLine.set_ValueOfColumn(COLUMNNAME_M_Product_Category_ID, getM_Product_Category_ID() ==0 ? null : getM_Product_Category_ID());

			ordLine.saveEx();
			
			//FIX: Set Bucket Rate based Total amount			
			if(getOrgType().equals(ORGTYPE_SandBlockBucket)) {
			DB.executeUpdate("UPDATE C_OrderLine SET " + TF_MOrderLine.COLUMNNAME_LineNetAmt + " = "
					+ getItem1_Amt() + " WHERE C_OrderLine_ID = " + ordLine.getC_OrderLine_ID(), get_TrxName());
			}
			
			//ordLine.setLineNetAmt(getItem1_Amt());
			DB.executeUpdate("UPDATE C_Order SET " + COLUMNNAME_Item1_C_OrderLine_ID + " = "
				+ ordLine.getC_OrderLine_ID() + " WHERE C_Order_ID = " + getC_Order_ID(), get_TrxName());
			setItem1_C_OrderLine_ID(ordLine.getC_OrderLine_ID());
		}
		//Item 2
		if(getItem2_ID() > 0 && (is_ValueChanged(COLUMNNAME_Item2_ID) || is_ValueChanged(COLUMNNAME_Item2_Qty)
				|| is_ValueChanged(COLUMNNAME_Item2_Price) || getItem2_C_OrderLine_ID() == 0)) {
			
			//do not create Royalty Pass Invoice Line when the Royalty Pass Inclusive in the material price
			if(!isRoyaltyPassBreakup() && getItem2_ID() == MSysConfig.getIntValue("ROYALTY_PASS_PRODUCT_ID", 1000329, getAD_Client_ID(), getAD_Org_ID()))
				return;
			
			if(getItem2_C_OrderLine_ID() > 0)
				ordLine = new TF_MOrderLine(getCtx(), getItem2_C_OrderLine_ID(), get_TrxName());
			else
				ordLine = new TF_MOrderLine(this);
			TF_MOrder.addProductPricingIfNot(getItem2_ID(), getM_PriceList_ID(), getC_BPartner_ID(), getItem2_Qty(), getItem2_Price(), 
					getDateOrdered(), getC_DocType().isSOTrx());
			setOrderLine(ordLine, getItem2_ID(), getItem2_UOM_ID(), getItem2_Qty(), getItem2_Price());
			
			ordLine.setC_Tax_ID(getItem2_Tax_ID());
			ordLine.setC_UOM_ID(getItem2_UOM_ID());
			
			//Sand Block fields
			//these should be updated in invoice line at:
			// 1. Create Subcontract Invoice
			// 2. CrusherEventHandler.
			ordLine.setBucketQty(getItem2_BucketQty());
			ordLine.setSandType(getItem2_SandType());
			ordLine.setIsPermitSales(isItem2_IsPermitSales());
			ordLine.setTonePerBucket(getItem2_TonePerBucket());
			ordLine.setBucketRate(getItem2_BucketRate());
			ordLine.setDescription(getItem2_Desc());
			ordLine.setTotalLoad(getItem2_TotalLoad());			
			//ordLine.setTF_VehicleType_ID(getItem1_VehicleType_ID()); //from first line.
			ordLine.saveEx();			
			
			//FIX: Set Bucket Rate based Total amount
			if(getOrgType().equals(ORGTYPE_SandBlockBucket)) {
				DB.executeUpdate("UPDATE C_OrderLine SET " + TF_MOrderLine.COLUMNNAME_LineNetAmt + " = "
						+ getItem2_Amt() + " WHERE C_OrderLine_ID = " + ordLine.getC_OrderLine_ID(), get_TrxName());
			}
			
			DB.executeUpdate("UPDATE C_Order SET " + COLUMNNAME_Item2_C_OrderLine_ID + " = "
				+ ordLine.getC_OrderLine_ID() + " WHERE C_Order_ID = " + getC_Order_ID(), get_TrxName());
			setItem2_C_OrderLine_ID(ordLine.getC_OrderLine_ID());
		}
		
		
	}
	
	public void updateVehicleRentLine() {
		MOrderLine ordLine = null;
		//Delete empty item lines
		if(is_ValueChanged(COLUMNNAME_Vehicle_ID) || (getVehicle_ID() == 0 && getVehicle_C_OrderLine_ID() > 0)) {
			ordLine = new MOrderLine(getCtx(), getVehicle_C_OrderLine_ID(), get_TrxName());
			if(ordLine.get_ID() > 0) {
				ordLine.setQtyReserved(BigDecimal.ZERO);
				ordLine.delete(false);
				DB.executeUpdate("UPDATE C_Order SET " + COLUMNNAME_Vehicle_C_OrderLine_ID + " = NULL " +
						" WHERE C_Order_ID =" + getC_Order_ID(), get_TrxName());
				setVehicle_C_OrderLine_ID(0);
			}			
		}//End Delete
		
		//Update modified Vehicle Rent line.		
		//Vehicle Rent
		if(getVehicle_ID() > 0 && (is_ValueChanged(COLUMNNAME_Vehicle_ID) || is_ValueChanged(COLUMNNAME_Rent_Amt)
				|| getVehicle_C_OrderLine_ID() == 0)) {
			
			if(getVehicle_C_OrderLine_ID() > 0) 
				ordLine = new MOrderLine(getCtx(), getVehicle_C_OrderLine_ID(), get_TrxName());
			else
				ordLine = new MOrderLine(this);
			
			TF_MOrder.addProductPricingIfNot(getVehicle_ID(), getM_PriceList_ID(), getC_BPartner_ID(), BigDecimal.ONE, getRent_Amt(), 
					getDateOrdered(), getC_DocType().isSOTrx());
			setOrderLine(ordLine, getVehicle_ID(), BigDecimal.ONE, getRent_Amt());
			MResource res = MResource.get(getCtx(), getVehicle().getS_Resource_ID());			
			ordLine.setUser1_ID(res.get_ValueAsInt("C_ElementValue_ID"));
			ordLine.setDescription("Hire charges ");
			ordLine.saveEx();
			DB.executeUpdate("UPDATE C_Order SET " + COLUMNNAME_Vehicle_C_OrderLine_ID + " = "
				+ ordLine.getC_OrderLine_ID() + " WHERE C_Order_ID = " + getC_Order_ID(), get_TrxName());	
		}
	}

	public void updateRentedVehicleRentLine() {
		TF_MOrderLine ordLine = null;
		//Delete empty item lines
		if(!isRentBreakup() || is_ValueChanged(COLUMNNAME_TF_RentedVehicle_ID) || (getTF_RentedVehicle_ID() == 0 && getVehicle_C_OrderLine_ID() > 0)) {
			ordLine = new TF_MOrderLine(getCtx(), getVehicle_C_OrderLine_ID(), get_TrxName());
			if(ordLine.get_ID() > 0) {
				ordLine.setQtyReserved(BigDecimal.ZERO);
				ordLine.delete(false);
				DB.executeUpdate("UPDATE C_Order SET " + COLUMNNAME_Vehicle_C_OrderLine_ID + " = NULL " +
						" WHERE C_Order_ID =" + getC_Order_ID(), get_TrxName());
				setVehicle_C_OrderLine_ID(0);
			}			
		}//End Delete
		
		//if(createConsolidatedTransportInvoice)
		//	return;
		
		//Update modified Vehicle Rent line.		
		//Vehicle Rent
		if(isRentBreakup())
		 if(getTF_RentedVehicle_ID() > 0 && (is_ValueChanged(COLUMNNAME_TF_RentedVehicle_ID) || is_ValueChanged(COLUMNNAME_Rent_Amt)
				|| getVehicle_C_OrderLine_ID() == 0 || is_ValueChanged(COLUMNNAME_IsTaxIncluded1))) {
			
			if(getVehicle_C_OrderLine_ID() > 0) 
				ordLine = new TF_MOrderLine(getCtx(), getVehicle_C_OrderLine_ID(), get_TrxName());
			else
				ordLine = new TF_MOrderLine(this);
			MRentedVehicle rentVehicle = new MRentedVehicle(getCtx(), getTF_RentedVehicle_ID(), get_TrxName());
			int productID = rentVehicle.getM_Product_ID();
			int defaultTaxID = 0;
			BigDecimal rentAmount = new BigDecimal(0);
			
			if(getRent_Tax_ID() > 0)
			{
				defaultTaxID = getRent_Tax_ID();
								
				//rentAmount = getRent_Amt().divide(BigDecimal.ONE.add(taxRate.divide(hundred,2,RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);
				rentAmount = getRent_Amt();
			}
			else
			{
				defaultTaxID = Env.getContextAsInt(getCtx(), "#C_Tax_ID");
				rentAmount = getDistance().multiply(getRate());
			}
			ordLine.setC_Tax_ID(defaultTaxID);
			
			TF_MOrder.addProductPricingIfNot(productID, getM_PriceList_ID(), getC_BPartner_ID(), BigDecimal.ONE, rentAmount, 
					getDateOrdered(), getC_DocType().isSOTrx());
			
			int load_uom_id = MSysConfig.getIntValue("LOAD_UOM", 1000072, getAD_Client_ID());
			
			BigDecimal price = rentAmount;
			BigDecimal qty = BigDecimal.ONE;
			String desc = null;
			if(!isLumpSumRent() && 
					getRate().multiply(getTonnage()).multiply(getDistance()).doubleValue() == getRent_Amt().doubleValue()) {
				qty = getDistance();
				price = getRate().multiply(getTonnage());
				BigDecimal rate = getRate();
				load_uom_id  = MSysConfig.getIntValue("KM_UOM", 1000071, getAD_Client_ID());
				
				desc = "Tonnage : " + getTonnage().doubleValue()
						+ ", Rate/ton/km : " + rate.doubleValue();
			}
			else if(getRate().multiply(getTonnage()).doubleValue() == getRent_Amt().doubleValue() ) {
				load_uom_id = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, getAD_Client_ID());
				qty = getTonnage();
				price = getRate();				
				//hdrDescription = hdrDescription + ", Tonnage : " + getTonnage().doubleValue();
			}
			else if(getRate().multiply(getDistance()).doubleValue() == getRent_Amt().doubleValue() ) {
				load_uom_id = MSysConfig.getIntValue("KM_UOM", 1000071, getAD_Client_ID());
				
				qty = getDistance();
				price = getRate();				
				//hdrDescription = hdrDescription + ", Tonnage : " + getTonnage().doubleValue();
			}
			else {
				load_uom_id = MSysConfig.getIntValue("LOAD_UOM", 1000072, getAD_Client_ID());
				
				qty = BigDecimal.ONE;
				price = getRent_Amt();				
				desc = "Tonnage : " + getTonnage().doubleValue();
			}		
			
			setOrderLine(ordLine, productID, qty, price);
			
			ordLine.setC_UOM_ID(load_uom_id);
			
			//MResource res = MResource.get(getCtx(), getVehicle().getS_Resource_ID());
			//ordLine.setUser1_ID(res.get_ValueAsInt("C_ElementValue_ID"));
			ordLine.setDescription("Transportation charges" +
				(desc != null ? ", " + desc : ""));
						
			
			ordLine.saveEx();
			DB.executeUpdate("UPDATE C_Order SET " + COLUMNNAME_Vehicle_C_OrderLine_ID + " = "
				+ ordLine.getC_OrderLine_ID() + " WHERE C_Order_ID = " + getC_Order_ID(), get_TrxName());	
		}
	}
	
	/**************************************************************************
	 *	Prepare Document
	 * 	@return new status (In Progress or Invalid) 
	 */
	@Override
	public String prepareIt()
	{
		if (log.isLoggable(Level.INFO)) log.info(toString());
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		MDocType dt = MDocType.get(getCtx(), getC_DocTypeTarget_ID());

		//	Std Period open?
		if (!MPeriod.isOpen(getCtx(), getDateAcct(), dt.getDocBaseType(), getAD_Org_ID()))
		{
			m_processMsg = "@PeriodClosed@";
			return DocAction.STATUS_Invalid;
		}
		
		if (isSOTrx() && getDeliveryViaRule().equals(DELIVERYVIARULE_Shipper))
		{
			if (getM_Shipper_ID() == 0)
			{
				m_processMsg = "@FillMandatory@" + Msg.getElement(getCtx(), COLUMNNAME_M_Shipper_ID);
				return DocAction.STATUS_Invalid;
			}
			
			if (!calculateFreightCharge())
				return DocAction.STATUS_Invalid;
		}

		//	Lines
		MOrderLine[] lines = getLines(true, MOrderLine.COLUMNNAME_M_Product_ID);
		if (lines.length == 0)
		{
			m_processMsg = "@NoLines@";
			return DocAction.STATUS_Invalid;
		}
				
		// Bug 1564431
		if (getDeliveryRule() != null && getDeliveryRule().equals(MOrder.DELIVERYRULE_CompleteOrder)) 
		{
			for (int i = 0; i < lines.length; i++) 
			{
				MOrderLine line = lines[i];
				MProduct product = line.getProduct();
				if (product != null && product.isExcludeAutoDelivery())
				{
					m_processMsg = "@M_Product_ID@ "+product.getValue()+" @IsExcludeAutoDelivery@";
					return DocAction.STATUS_Invalid;
				}
			}
		}
		
		//	Convert DocType to Target
		if (getC_DocType_ID() != getC_DocTypeTarget_ID() )
		{
			//	Cannot change Std to anything else if different warehouses
			if (getC_DocType_ID() != 0)
			{
				MDocType dtOld = MDocType.get(getCtx(), getC_DocType_ID());
				if (MDocType.DOCSUBTYPESO_StandardOrder.equals(dtOld.getDocSubTypeSO())		//	From SO
					&& !MDocType.DOCSUBTYPESO_StandardOrder.equals(dt.getDocSubTypeSO()))	//	To !SO
				{
					for (int i = 0; i < lines.length; i++)
					{
						if (lines[i].getM_Warehouse_ID() != getM_Warehouse_ID())
						{
							log.warning("different Warehouse " + lines[i]);
							m_processMsg = "@CannotChangeDocType@";
							return DocAction.STATUS_Invalid;
						}
					}
				}
			}
			
			//	New or in Progress/Invalid
			if (DOCSTATUS_Drafted.equals(getDocStatus()) 
				|| DOCSTATUS_InProgress.equals(getDocStatus())
				|| DOCSTATUS_Invalid.equals(getDocStatus())
				|| getC_DocType_ID() == 0)
			{
				setC_DocType_ID(getC_DocTypeTarget_ID());
			}
			else	//	convert only if offer
			{
				if (dt.isOffer())
					setC_DocType_ID(getC_DocTypeTarget_ID());
				else
				{
					m_processMsg = "@CannotChangeDocType@";
					return DocAction.STATUS_Invalid;
				}
			}
		}	//	convert DocType

		//	Mandatory Product Attribute Set Instance
		for (MOrderLine line : getLines()) {
			if (line.getM_Product_ID() > 0 && line.getM_AttributeSetInstance_ID() == 0) {
				MProduct product = line.getProduct();
				if (product.isASIMandatory(isSOTrx())) {
					if (product.getAttributeSet() != null && !product.getAttributeSet().excludeTableEntry(MOrderLine.Table_ID, isSOTrx())) {
						StringBuilder msg = new StringBuilder("@M_AttributeSet_ID@ @IsMandatory@ (@Line@ #")
							.append(line.getLine())
							.append(", @M_Product_ID@=")
							.append(product.getValue())
							.append(")");
						m_processMsg = msg.toString();
						return DocAction.STATUS_Invalid;
					}
				}
			}
		}

		//	Lines
		if (explodeBOM())
			lines = getLines(true, MOrderLine.COLUMNNAME_M_Product_ID);
		if (!reserveStock(dt, lines))
		{
			String innerMsg = CLogger.retrieveErrorString("");
			m_processMsg = "Cannot reserve Stock";
			if (! Util.isEmpty(innerMsg))
				m_processMsg = m_processMsg + " -> " + innerMsg;
			return DocAction.STATUS_Invalid;
		}
		if (!calculateTaxTotal())
		{
			m_processMsg = "Error calculating tax";
			return DocAction.STATUS_Invalid;
		}
		
		if (   getGrandTotal().signum() != 0
			&& (PAYMENTRULE_OnCredit.equals(getPaymentRule()) || PAYMENTRULE_DirectDebit.equals(getPaymentRule())))
		{
			if (!createPaySchedule())
			{
				m_processMsg = "@ErrorPaymentSchedule@";
				return DocAction.STATUS_Invalid;
			}
		} else {
			if (MOrderPaySchedule.getOrderPaySchedule(getCtx(), getC_Order_ID(), 0, get_TrxName()).length > 0) 
			{
				m_processMsg = "@ErrorPaymentSchedule@";
				return DocAction.STATUS_Invalid;
			}
		}
		
		//	Credit Check
		if (isSOTrx())
		{
			if (   MDocType.DOCSUBTYPESO_POSOrder.equals(dt.getDocSubTypeSO())
		|| PAYMENTRULE_Cash.equals(getPaymentRule())
					&& !MSysConfig.getBooleanValue(MSysConfig.CHECK_CREDIT_ON_CASH_POS_ORDER, true, getAD_Client_ID(), getAD_Org_ID())) {
				// ignore -- don't validate for Cash POS Orders depending on sysconfig parameter
			} else if (MDocType.DOCSUBTYPESO_PrepayOrder.equals(dt.getDocSubTypeSO())
					&& !MSysConfig.getBooleanValue(MSysConfig.CHECK_CREDIT_ON_PREPAY_ORDER, true, getAD_Client_ID(), getAD_Org_ID())) {
				// ignore -- don't validate Prepay Orders depending on sysconfig parameter
			} else {
				MBPartner bp = new MBPartner (getCtx(), getBill_BPartner_ID(), get_TrxName()); // bill bp is guaranteed on beforeSave

				if (getGrandTotal().signum() > 0)  // IDEMPIERE-365 - just check credit if is going to increase the debt
				{		 

					if (MBPartner.SOCREDITSTATUS_CreditStop.equals(bp.getSOCreditStatus()))
					{
						m_processMsg = "@BPartnerCreditStop@ - @TotalOpenBalance@=" 
								+ bp.getTotalOpenBalance()
								+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
						return DocAction.STATUS_Invalid;
					}
					if (MBPartner.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus()))
					{
						m_processMsg = "@BPartnerCreditHold@ - @TotalOpenBalance@=" 
								+ bp.getTotalOpenBalance() 
								+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
						return DocAction.STATUS_Invalid;
					}
					BigDecimal grandTotal = MConversionRate.convertBase(getCtx(), 
							getGrandTotal(), getC_Currency_ID(), getDateOrdered(), 
							getC_ConversionType_ID(), getAD_Client_ID(), getAD_Org_ID());
					if (MBPartner.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus(grandTotal)))
					{
						m_processMsg = "@BPartnerOverOCreditHold@ - @TotalOpenBalance@=" 
								+ bp.getTotalOpenBalance() + ", @GrandTotal@=" + grandTotal
								+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
						return DocAction.STATUS_Invalid;
					}
				}
			}  
		}
		
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		m_justPrepared = true;
	//	if (!DOCACTION_Complete.equals(getDocAction()))		don't set for just prepare 
	//		setDocAction(DOCACTION_Complete);
		return DocAction.STATUS_InProgress;
	}	//	prepareIt
	
	@Override
	public String completeIt() {
		//if(getTF_RentedVehicle_ID() > 0 && getRent_Amt().doubleValue() <= 0 && isSOTrx()  )
		//	throw new AdempiereException("Please specify Rent Amount!");
		//MRentedVehicle rv = new MRentedVehicle(getCtx(), getTF_RentedVehicle_ID(), get_TrxName());
		/*if(getTF_RentedVehicle_ID() > 0 && getRent_Amt().doubleValue() <= 0 && !isSOTrx() && 
				isCreateTransportInvoice() && rv.isTransporter() )
			throw new AdempiereException("Please specify Rent Amount!");
		*/
		
		if(isSOTrx() && MSysConfig.getBooleanValue("DISCOUNT_REQUEST_ENABLED", false)) {
			MPriceListUOM priceUOM = MPriceListUOM.getPriceListUOM(getCtx(), getItem1_ID(), getItem1_UOM_ID(), getC_BPartner_ID(),getTF_Destination_ID(), true, getDateAcct());
			BigDecimal price=getItem1_UnitPrice();
			BigDecimal priceMin = BigDecimal.ZERO;
			if(priceUOM != null)
				priceMin = priceUOM.getPriceMin();
			else 
				throw new AdempiereException("Please define Price in the Sales Price List by UOM!");
			if(price.compareTo(priceMin)<0 ) {
				if(getTF_DiscountRequest_ID() == 0) {
					throw new AdempiereException("You cannot complete sales entry product price less than min price. Please create discount request");
				}
				else {
					MDiscountRequest dr = new MDiscountRequest(getCtx(), getTF_DiscountRequest_ID(), get_TrxName());
					if(dr.getDiscntStatus().equals(MDiscountRequest.DISCNTSTATUS_Approved)) {
						if(dr.getApprovedPrice().doubleValue() > getItem1_UnitPrice().doubleValue()) {
							throw new AdempiereException("Please enter Approved Discounted Price to complete the order!");
						}
						else {
							dr.closeIt();
							dr.saveEx();
						}
					}
					else {
						throw new AdempiereException("Your discount request is waiting for approval!");
					}
				}
			}
		}
		//createSubcontractPurchaseEntry();
			
		postCrusherProduction();
		
		String msg = super.completeIt();
		purchasePermit();
		issuePermit();		
		
		//if(!createConsolidatedTransportInvoice)
		//	createTransporterInvoice();
		//else
		//	createTransportMaterialReceipt();
		
		//createAdditionalInvoice();
		closeWeighmentEntry();
		closeTokenNo();
		closeYardEntry();
		createInvoiceCustomer();
		createInvoiceVendor();
		//postDriverSalary();
		if(getC_DocTypeTarget_ID() == GSTConsolidatedOrderDocType_ID(getCtx())) {
			createConsolidatedTaxInvoice();
		}
		else {
			createTaxInvoice();	
		}
		
		createCashSalesDiscountPayment();
		completeWeighmentEntriesForConsolidateInvoice();
		
		postMixedPayment();
		
		return msg;
	}
	
	boolean createConsolidatedTransportInvoice = MSysConfig.getBooleanValue("CONSOLIDATED_TRANSPORT_INVOICE_ENABLED", true , getAD_Client_ID(), getAD_Org_ID());
	
	/** Mixed Payment = O */
	public static final String PAYMENTRULE_MixedPayment = "O";
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		MRentedVehicle rv = new MRentedVehicle(getCtx(), getTF_RentedVehicle_ID(), get_TrxName());		
		if(getTF_RentedVehicle_ID()>0 && getRent_Amt().doubleValue()==0 && isSOTrx()) {
			//if((rv.isOwnVehicle() && isSOTrx()) || rv.isTransporter()) { //to allow without rent 
			if(rv.isTransporter()) {
				if(!createConsolidatedTransportInvoice && getC_BPartner_ID() != rv.getC_BPartner_ID())
					throw new AdempiereUserError("Invalid Rent Amount");
			}
		}
		
		if(!isSOTrx()) {
			setDriverTips(BigDecimal.ZERO);
		}
		
		if(! (getPaymentRule().equals("B") ||  getPaymentRule().equals("O"))) {
			setSalesDiscountAmt(BigDecimal.ZERO);
		}
		
		TF_MProject proj = TF_MProject.getCrusherProductionSubcontractByWarehouse(getM_Warehouse_ID());
		if(proj != null && getC_Project_ID() == 0)
			setC_Project_ID(proj.getC_Project_ID());
		
		TF_MOrg org = new TF_MOrg(getCtx(), getAD_Org_ID(), get_TrxName());
		setOrgType(org.getOrgType());
		
		if(newRecord) {
			setDateAcct(getDateOrdered());
			
			String whereclause = " C_DocType_ID = ?";
			MPrintDocSetup printdocSetup = new Query(getCtx(), MPrintDocSetup.Table_Name, whereclause, get_TrxName())
					.setClient_ID().setParameters(getC_DocTypeTarget_ID()).first();
			
			if(printdocSetup != null) {
				setTermsAndCondition(printdocSetup.getTermsConditions());
			}
		}
		
		
		if(newRecord || is_ValueChanged(COLUMNNAME_DateOrdered)) {
			if(getC_DocTypeTarget_ID() == TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx()) || getC_DocTypeTarget_ID() == TF_MOrder.NonGSTConsolidatedOrderDocType_ID(getCtx())) {
				validateInvoiceDate();	
			}
		}
		
		if(newRecord && getTermsAndCondition() == null) {
			
			String whereclause = " C_DocType_ID = ?";
			MPrintDocSetup printdocSetup = new Query(getCtx(), MPrintDocSetup.Table_Name, whereclause, get_TrxName())
					.setClient_ID().setParameters(getC_DocTypeTarget_ID()).first();
			
			if(printdocSetup != null) {
				setTermsAndCondition(printdocSetup.getTermsConditions());
			}
		}
		
		return super.beforeSave(newRecord);
	}

	@Override
	public boolean voidIt() {
		
		MDocType dt = (MDocType) getC_DocTypeTarget();
		String DocSubTypeSO = dt.getDocSubTypeSO();
		MBoulderMovement.deleteByOrder(getC_Order_ID(), get_TrxName());
		MSubcontractMaterialMovement.deleteSalesEntryMovement(getC_Order_ID(), get_TrxName());
		//POS Order's MR and Invoice should be reversed.
		
		 if(DocSubTypeSO != null && ((!isSOTrx() && MDocType.DOCSUBTYPESO_POSOrder.equals(DocSubTypeSO)) || DocSubTypeSO.equals("IN") ||
				getC_DocType_ID() == 1000050 || getC_DocType_ID() == 1000041 || 
				getC_DocType_ID() == getC_VendorInvoiceDocType_ID() ||
				getC_DocType_ID() == GSTOrderDocType_ID(getCtx()) || getC_DocType_ID() == NonGSTOrderDocType_ID(getCtx()) ||
				getC_DocType_ID() == GSTConsolidatedOrderDocType_ID(getCtx()) || getC_DocType_ID() == NonGSTConsolidatedOrderDocType_ID(getCtx()))) {
			//MR/Shipment reverse Correct
			List<MInOut> inOutList = new Query(getCtx(), MInOut.Table_Name, "C_Order_ID=? AND DocStatus=? AND C_DocType_ID != ?", get_TrxName())
				.setClient_ID().setParameters(getC_Order_ID(),DOCSTATUS_Completed, getC_VendorInvoiceDocType_ID()).list();
			for(MInOut inout : inOutList) {
				if(getC_DocTypeTarget_ID() == getC_TransporterInvoiceDocType_ID() || getC_DocTypeTarget_ID() == getC_ServiceInvoiceDocType_ID())
					continue;
				
				if(!inout.reverseCorrectIt())
					return false;				
				inout.saveEx();
			}
			
			
			//Invoice reverse Correct
			List<TF_MInvoice> invList = new Query(getCtx(), TF_MInvoice.Table_Name, "C_Order_ID=? AND DocStatus=?", get_TrxName())
				.setClient_ID().setParameters(getC_Order_ID(), DOCSTATUS_Completed).list();
			for(TF_MInvoice inv : invList) {
				//Keep the existing invoice no while reversing
				if(!MSysConfig.getBooleanValue(MSysConfig.Invoice_ReverseUseNewNumber, true, getAD_Client_ID()) && invList.size() == 1) {						
					
					String sql = "SELECT COUNT(*) FROM C_Invoice WHERE C_Order_ID = ? OR TF_WeighmentEntry_ID = ?";
					int revCount = DB.getSQLValue(get_TrxName(), sql, getC_Order_ID(), getTF_WeighmentEntry_ID());
					revCount = revCount / 2 + 1;
					inv.setDocumentNo(inv.getDocumentNo() + "-"+  revCount);
					inv.saveEx();
				}
				if(!inv.reverseCorrectIt())
					return false;
				inv.saveEx();
			}
			
			reverseTransportReceiptStatus();			
		}
		else if(DocSubTypeSO != null && DocSubTypeSO.equals("SI")) {			
			//Invoice reverse Correct
			List<TF_MInvoice> invList = new Query(getCtx(), TF_MInvoice.Table_Name, "C_Order_ID=? AND DocStatus=?", get_TrxName())
				.setClient_ID().setParameters(getC_Order_ID(), DOCSTATUS_Completed).list();
			for(TF_MInvoice inv : invList) {
				//Keep the existing invoice no while reversing
				if(!MSysConfig.getBooleanValue(MSysConfig.Invoice_ReverseUseNewNumber, true, getAD_Client_ID()) && invList.size() == 1) {						
					
					String sql = "SELECT COUNT(*) FROM C_Invoice WHERE TF_WeighmentEntry_ID = ?";
					int revCount = DB.getSQLValue(get_TrxName(), sql, getTF_WeighmentEntry_ID());
					revCount = revCount / 2 + 1;
					inv.setDocumentNo(inv.getDocumentNo() + "-"+  revCount);
					inv.saveEx();
				}
				if(!inv.reverseCorrectIt())
					return false;
				inv.saveEx();
			}
			
			reverseTransportReceiptStatus();
			
			if(getC_DocTypeTarget_ID() == TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx()) || getC_DocTypeTarget_ID() == TF_MOrder.NonGSTConsolidatedOrderDocType_ID(getCtx())) {
				reverseWeighmentEntries();
			}
		}
		
		
		if(getTF_DriverTips_Pay_ID() > 0) {
			TF_MPayment payment = new TF_MPayment(getCtx(), getTF_DriverTips_Pay_ID(), get_TrxName());
			if(payment.getDocStatus().equals(DOCSTATUS_Completed)) {
				payment.reverseCorrectIt();
			}
			payment.saveEx();
		}

		if(getC_PaymentSalesDiscount_ID() > 0) {
			TF_MPayment payment = new TF_MPayment(getCtx(), getC_PaymentSalesDiscount_ID(), get_TrxName());
			if(payment.getDocStatus().equals(DOCSTATUS_Completed)) {
				payment.reverseCorrectIt();
			}
			payment.saveEx();
		}

		if(getTF_DiscountRequest_ID() > 0) {
			MDiscountRequest dr = new MDiscountRequest(getCtx(), getTF_DiscountRequest_ID(), get_TrxName());
			dr.voidIt();
			dr.saveEx();
		}
		
		if(getDocStatus().equals(DOCSTATUS_Completed)) {
			MJobworkItemIssue.ReverseFromPO(this);		
			reverseTransporterInvoice();
			//reverseTransportMaterialReceipt();		
			reverseWeighmentEntry();		
			reverseTokenNo();
			reverseYardEntry();
		    reverseSubcontractPurchaseEntry();
			reverseIssuedPermit();
			reversePurchasedPermit();
			reverseCrusherProduction();
			voidTaxInvoice();
			voidTR_TaxInvoice();
			reverseAdditionalTransactions();
			reverseConsolidateInvoice(false);
		}
		reverseDriverSalary();
		reverseMixedPayment();
		
		return super.voidIt();
	}
	
	@Override
	public boolean reActivateIt() {
		
		if(getTF_WeighmentEntry_ID() > 0)
			throw new AdempiereException("Re-activate is not allowed for the single DC invoice. Kindly use Weighment Info to modify the DC.");
		
		MDocType dt = (MDocType) getC_DocTypeTarget();
		String DocSubTypeSO = dt.getDocSubTypeSO();
		MBoulderMovement.deleteByOrder(getC_Order_ID(), get_TrxName());
		MSubcontractMaterialMovement.deleteSalesEntryMovement(getC_Order_ID(), get_TrxName());
		//POS Order's MR and Invoice should be reversed.
		if((!isSOTrx() && MDocType.DOCSUBTYPESO_POSOrder.equals(DocSubTypeSO)) || DocSubTypeSO.equals("IN") ||
				getC_DocType_ID() == 1000050 || getC_DocType_ID() == 1000041 || 
				getC_DocType_ID() == getC_VendorInvoiceDocType_ID() ||
				getC_DocType_ID() == GSTOrderDocType_ID(getCtx()) || getC_DocType_ID() == NonGSTOrderDocType_ID(getCtx()) ||
				getC_DocType_ID() == GSTConsolidatedOrderDocType_ID(getCtx()) || getC_DocType_ID() == NonGSTConsolidatedOrderDocType_ID(getCtx())) {
			//MR/Shipment reverse Correct
			List<MInOut> inOutList = new Query(getCtx(), MInOut.Table_Name, "C_Order_ID=? AND DocStatus=? AND C_DocType_ID != ?", get_TrxName())
				.setClient_ID().setParameters(getC_Order_ID(),DOCSTATUS_Completed, getC_VendorInvoiceDocType_ID()).list();
			for(MInOut inout : inOutList) {
				if(getC_DocTypeTarget_ID() == getC_TransporterInvoiceDocType_ID() || getC_DocTypeTarget_ID() == getC_ServiceInvoiceDocType_ID())
					continue;
				
				if(!inout.reverseCorrectIt())
					return false;				
				inout.saveEx();
			}
			
			
			//Invoice reverse Correct
			List<TF_MInvoice> invList = new Query(getCtx(), TF_MInvoice.Table_Name, "C_Order_ID=? AND DocStatus=?", get_TrxName())
				.setClient_ID().setParameters(getC_Order_ID(), DOCSTATUS_Completed).list();
			for(TF_MInvoice inv : invList) {
				//Keep the existing invoice no while reversing
				if(!MSysConfig.getBooleanValue(MSysConfig.Invoice_ReverseUseNewNumber, true, getAD_Client_ID()) && invList.size() == 1) {						
					
					String sql = "SELECT COUNT(*) FROM C_Invoice WHERE C_Order_ID = ?";
					int revCount = DB.getSQLValue(get_TrxName(), sql, getC_Order_ID());
					revCount = revCount / 2 + 1;
					inv.setDocumentNo(inv.getDocumentNo() + "-"+  revCount);
					inv.saveEx();
				}
				if(!inv.reverseCorrectIt())
					return false;
				inv.saveEx();
			}
			
			reverseTransportReceiptStatus();			
		}
		else if(DocSubTypeSO.equals("SI")) {			
			//Invoice reverse Correct
			List<TF_MInvoice> invList = new Query(getCtx(), TF_MInvoice.Table_Name, "C_Order_ID=? AND DocStatus=?", get_TrxName())
				.setClient_ID().setParameters(getC_Order_ID(), DOCSTATUS_Completed).list();
			for(TF_MInvoice inv : invList) {
				//Keep the existing invoice no while reversing
				if(!MSysConfig.getBooleanValue(MSysConfig.Invoice_ReverseUseNewNumber, true, getAD_Client_ID()) && invList.size() == 1) {						
					
					String sql = "SELECT COUNT(*) FROM C_Invoice WHERE TF_WeighmentEntry_ID = ?";
					int revCount = DB.getSQLValue(get_TrxName(), sql, getTF_WeighmentEntry_ID());
					revCount = revCount / 2 + 1;
					inv.setDocumentNo(inv.getDocumentNo() + "-"+  revCount);
					inv.saveEx();
				}
				if(!inv.reverseCorrectIt())
					return false;
				inv.saveEx();
			}
			
			reverseTransportReceiptStatus();
			
			if(getC_DocTypeTarget_ID() == TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx()) || getC_DocTypeTarget_ID() == TF_MOrder.NonGSTConsolidatedOrderDocType_ID(getCtx())) {
				reverseWeighmentEntries();
			}
		}
		
			
		if(getTF_DriverTips_Pay_ID() > 0) {
			TF_MPayment payment = new TF_MPayment(getCtx(), getTF_DriverTips_Pay_ID(), get_TrxName());
			if(payment.getDocStatus().equals(DOCSTATUS_Completed)){
				payment.reverseCorrectIt();
			}
			payment.saveEx();
		}

		if(getC_PaymentSalesDiscount_ID()> 0) {
			TF_MPayment payment = new TF_MPayment(getCtx(), getC_PaymentSalesDiscount_ID(), get_TrxName());
			if(payment.getDocStatus().equals(DOCSTATUS_Completed)){
				payment.reverseCorrectIt();
			}
			payment.saveEx();
		}
		
		
		MJobworkItemIssue.ReverseFromPO(this);
		reverseTransporterInvoice();
		reverseWeighmentEntry();
		reverseTokenNo();
		reverseYardEntry();
		reverseSubcontractPurchaseEntry();
		reverseIssuedPermit();
		reversePurchasedPermit();
		reverseCrusherProduction();
		voidTaxInvoice();
		voidTR_TaxInvoice();
		reverseConsolidateInvoice(true);
		reverseDriverSalary();
		
		if(getC_DocTypeTarget_ID() == TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx()) || getC_DocTypeTarget_ID() == TF_MOrder.NonGSTConsolidatedOrderDocType_ID(getCtx())) {
			reverseWeighmentEntries();
		}
		
		return super.reActivateIt();
	}

	public void createTransporterInvoice() {
		if(getTF_RentedVehicle_ID() == 0 || getRent_Amt().doubleValue() == 0)
			return;
		MRentedVehicle rv = new MRentedVehicle(getCtx(), getTF_RentedVehicle_ID(), get_TrxName());
		if(rv.isOwnVehicle() || getC_BPartner_ID() == rv.getC_BPartner_ID())
			return;
		//if(getRent_Amt().doubleValue() > 0 && getTF_RentedVehicle_ID() == 0)
		//	throw new AdempiereException("Please Select Rented Vehicle or Reset Rent (Amount) to ZERO!");
		//if(getTF_RentedVehicle_ID() > 0 && getRent_Amt().doubleValue() ==0)
		//	throw new AdempiereException("Rent (Amount) should be greater ZERO!");
		
		if(!isSOTrx() && !isCreateTransportInvoice())
			return;
		
		
		MRentedVehicle vehicle = new MRentedVehicle(getCtx(), getTF_RentedVehicle_ID(), get_TrxName());
		if(vehicle.isOwnVehicle())
			return;
		
		MBPartner bp = new MBPartner(getCtx(), vehicle.getC_BPartner_ID(), get_TrxName());
		//Invoice Header
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(MGLPostingConfig.getMGLPostingConfig(getCtx()).getTransporterInvoiceDocType_ID());			
		invoice.setDateInvoiced(getDateOrdered());
		invoice.setDateAcct(getDateOrdered());
		invoice.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
		//
		invoice.setBPartner(bp);
		invoice.setPaymentRule(PAYMENTRULE_OnCredit);
		invoice.setIsSOTrx(false);		
		
		//Price List
		int m_M_PriceList_ID = MPriceList.getDefault(getCtx(), false).getM_PriceList_ID();
					
		invoice.setM_PriceList_ID(m_M_PriceList_ID);
		invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		
		//Financial Dimension - Profit Center
		invoice.setUser1_ID(getUser1_ID());
		
		invoice.saveEx();
		//End Invoice Header
		
		//Invoice Line - Vehicle Rental Charge
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		invLine.setM_Product_ID(vehicle.getM_Product_ID(), true);
		invLine.setDescription("Vehicle Rent");
		
		String hdrDescription = "";
			
		MDestination dest = new MDestination(getCtx(), getTF_Destination_ID(), get_TrxName());
		if(isSOTrx()) {
			hdrDescription = "Destination : " + dest.getName();
		}
		else {
			hdrDescription = "Source : " + dest.getName();
		}
		if(!isLumpSumRent() && 
				getRate().multiply(getTonnage()).multiply(getDistance()).doubleValue() == getRent_Amt().doubleValue()) {
			invLine.setQty(getDistance());
			BigDecimal price = getRate().multiply(getTonnage());
			BigDecimal rate = getRate();
			if(isSOTrx()) {
				price = getRentPayable().divide(getDistance(), 2, RoundingMode.HALF_UP);
				rate = price.divide(getTonnage(), 2, RoundingMode.HALF_UP);
			}
			int KM_uom_id = MSysConfig.getIntValue("KM_UOM", 1000071, getAD_Client_ID());
			invLine.setC_UOM_ID(KM_uom_id);
			invLine.setPriceActual(price);
			invLine.setPriceList(price);
			invLine.setPriceLimit(price);
			invLine.setPriceEntered(price);
			hdrDescription = hdrDescription + ", Tonnage : " + getTonnage().doubleValue()
					+ ", Rate/ton/km : " + rate.doubleValue();
		}
		else if(getRate().multiply(getTonnage()).doubleValue() == getRent_Amt().doubleValue() ) {
			int Tonne_uom_id = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, getAD_Client_ID());
			invLine.setC_UOM_ID(Tonne_uom_id);
			invLine.setQty(getTonnage());
			BigDecimal price = getRate();
			if(isSOTrx()) {
				price = getRentPayable().divide(getTonnage(), 2, RoundingMode.HALF_EVEN);
			}
			invLine.setPriceActual(price);
			invLine.setPriceList(price);
			invLine.setPriceLimit(price);
			invLine.setPriceEntered(price);
			//hdrDescription = hdrDescription + ", Tonnage : " + getTonnage().doubleValue();
		}
		else if(getRate().multiply(getDistance()).doubleValue() == getRent_Amt().doubleValue() ) {
			int KM_uom_id = MSysConfig.getIntValue("KM_UOM", 1000071, getAD_Client_ID());
			invLine.setC_UOM_ID(KM_uom_id);
			invLine.setQty(getDistance());
			BigDecimal price = getRate();
			if(isSOTrx()) {
				price = getRentPayable().divide(getTonnage(), 2, RoundingMode.HALF_EVEN);
			}
			invLine.setPriceActual(price);
			invLine.setPriceList(price);
			invLine.setPriceLimit(price);
			invLine.setPriceEntered(price);
			//hdrDescription = hdrDescription + ", Tonnage : " + getTonnage().doubleValue();
		}
		else {
			int load_uom_id = MSysConfig.getIntValue("LOAD_UOM", 1000072, getAD_Client_ID());
			invLine.setC_UOM_ID(load_uom_id);
			invLine.setQty(BigDecimal.ONE);
			BigDecimal price = getRent_Amt();
			if(isSOTrx()) {
				price = getRentPayable();
			}
			invLine.setPriceActual(price);
			invLine.setPriceList(price);
			invLine.setPriceLimit(price);
			invLine.setPriceEntered(price);
			hdrDescription = hdrDescription + ", Tonnage : " + getTonnage().doubleValue();
		}
		invLine.addDescription(hdrDescription);
		invLine.saveEx();
		invoice.saveEx();
		
		//DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		//End DocAction
		
		setTransporterInvoice_ID(invoice.getC_Invoice_ID());
		
	}
	
	public void reverseTransporterInvoice() {
		if(getTransporterInvoice_ID() > 0 ) {
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getTransporterInvoice_ID(), get_TrxName());
			if(inv.getDocStatus().equals(DOCSTATUS_Completed))
				inv.reverseCorrectIt();
			inv.saveEx();			
		}
	}
	
	public void closeWeighmentEntry()
	{
		if(getTF_WeighmentEntry_ID() > 0) {
			MWeighmentEntry weighment = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
			
			if(weighment.getStatus().equals(weighment.STATUS_Unbilled) || weighment.getStatus().equals(weighment.STATUS_UnderReview) || weighment.getStatus().equals(weighment.STATUS_Pending)) {
				weighment.close();
				weighment.saveEx();
			}			
		}
	}
	
	public void closeTokenNo()
	{
		if(getTF_Token_ID() > 0) {
			MToken token = new MToken(getCtx(), getTF_Token_ID(), get_TrxName());
			token.close();
			token.saveEx();
		}
	}
	
	public void reverseWeighmentEntry() {
		if(getTF_WeighmentEntry_ID() > 0) {
			MWeighmentEntry weighment = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
			weighment.reverse();
			weighment.saveEx();
		}
	}
	
	public void reverseTokenNo()
	{
		if(getTF_Token_ID() > 0) {
			MToken token = new MToken(getCtx(), getTF_Token_ID(), get_TrxName());
			token.reverse();
			token.saveEx();
		}
	}
	
	public void closeYardEntry() {
		if(getTF_YardEntry_ID() > 0 ) {
			MYardEntry ye = new MYardEntry(getCtx(), getTF_YardEntry_ID(), get_TrxName());
			//If Yard Entry created From Weighbridge App
			if(ye.getTotalAmt().doubleValue() > 0) {
				ye.close();
				ye.saveEx();
			}
		}
	}
	
	public void reverseYardEntry() {
		if(getTF_YardEntry_ID() > 0 ) {
			MYardEntry ye = new MYardEntry(getCtx(), getTF_YardEntry_ID(), get_TrxName());
			//If Yard Entry created From Weighbridge App
			if(ye.getTotalAmt().doubleValue() > 0) {
				ye.reverse();
				ye.saveEx();
			}
		}
	}
	
	public void reverseCrusherProduction() {
		if(getTF_Crusher_Production_ID() > 0) {
			MCrusherProduction crProd = new MCrusherProduction(getCtx(), getTF_Crusher_Production_ID(), get_TrxName());
			crProd.reverseIt();
			crProd.saveEx();
			setTF_Crusher_Production_ID(0);
		}		
	}
	public static MProductPricing getProductPricing(int M_Product_ID, int M_PriceList_ID, int C_BPartner_ID, 
			BigDecimal Qty,	Timestamp priceDate, boolean isSOTrx) {
		//Get Unit Price from Latest Price List.
		String sql = "SELECT plv.M_PriceList_Version_ID "
				+ "FROM M_PriceList_Version plv "
				+ "WHERE plv.M_PriceList_ID=? "	
				+ " AND plv.ValidFrom <= ? "
				+ "ORDER BY plv.ValidFrom DESC";
		
		int M_PriceList_Version_ID = DB.getSQLValueEx(null, sql, M_PriceList_ID, priceDate);
		MProductPricing pp = new MProductPricing (M_Product_ID, C_BPartner_ID, Qty, isSOTrx, null);		
		pp.setM_PriceList_ID(M_PriceList_ID);
		pp.setM_PriceList_Version_ID(M_PriceList_Version_ID);
		pp.setPriceDate(priceDate);		
		return pp;
	}
	
	public static MProductPrice addProductPricingIfNot(int M_Product_ID, int M_PriceList_ID, int C_BPartner_ID, 
			BigDecimal Qty, BigDecimal price, Timestamp priceDate, boolean isSOTrx) {
		//Get Unit Price from Latest Price List.
		if(M_Product_ID == 0)
			return null;
		String sql = "SELECT plv.M_PriceList_Version_ID "
				+ "FROM M_PriceList_Version plv "
				+ "WHERE plv.M_PriceList_ID=? "	
				+ " AND plv.ValidFrom <= ? "
				+ "ORDER BY plv.ValidFrom DESC";
		MProductPrice prodPrice = null;		
		int M_PriceList_Version_ID = DB.getSQLValueEx(null, sql, M_PriceList_ID, priceDate);	
		sql = " SELECT Count(*) FROM M_ProductPrice WHERE M_PriceList_Version_ID =? AND M_Product_ID =? AND IsActive='Y'";
		BigDecimal count = DB.getSQLValueBD(null, sql, M_PriceList_Version_ID,M_Product_ID);
		if(count == null || count.doubleValue() == 0) {
			prodPrice = new MProductPrice(Env.getCtx(), M_PriceList_Version_ID, M_Product_ID, null);
		}
		else {
			prodPrice = MProductPrice.get(Env.getCtx(), M_PriceList_Version_ID, M_Product_ID, null);
		}
		prodPrice.setPrices(price, price, price);		
		prodPrice.saveEx();
		return prodPrice;
	}
	
	public static MProductPrice updateProductPricing(int M_Product_ID, int M_PriceList_ID, int C_BPartner_ID, 
			BigDecimal Qty, BigDecimal price, Timestamp priceDate, boolean isSOTrx) {
		//Get Unit Price from Latest Price List.
		String sql = "SELECT plv.M_PriceList_Version_ID "
				+ "FROM M_PriceList_Version plv "
				+ "WHERE plv.M_PriceList_ID=? "	
				+ " AND plv.ValidFrom <= ? "
				+ "ORDER BY plv.ValidFrom DESC";
		MProductPrice prodPrice = null;
		int M_PriceList_Version_ID = DB.getSQLValueEx(null, sql, M_PriceList_ID, priceDate);
		prodPrice = MProductPrice.get(Env.getCtx(), M_PriceList_Version_ID, M_Product_ID, null);
		if(prodPrice != null) {						
			prodPrice.setPrices(price, price, price);		
			prodPrice.saveEx();	
		}
		return prodPrice;
	}
	
	public void createRawMaterialReceipt() {
		if(isSOTrx())
			return;
		int BoulderID = MSysConfig.getIntValue("BOULDER_ID", 1000233, getAD_Client_ID(), getAD_Org_ID());
		if(BoulderID == getItem1_ID() && TF_SEND_TO_Production.equals(getTF_Send_To())) {
			MSubcontractMaterialMovement.createRawmaterialMovement(get_TrxName(), getDateAcct(), getAD_Org_ID(),				
					0, 0, getItem1_ID(), getTF_WeighmentEntry_ID(), getC_Order_ID(), getItem1_Qty());
		}
		else if(BoulderID == getItem1_ID() && TF_SEND_TO_Stock.equals(getTF_Send_To())) {
			MBoulderMovement.createBoulderReceipt(get_TrxName(), getDateAcct(), getAD_Org_ID(), 
					BoulderID, getItem1_Qty(), getTF_WeighmentEntry_ID(), 
					getM_Warehouse_ID(), 0, getC_Order_ID());
		}
	}
	
	public String postCrusherProduction() {
		
		if(isSOTrx()) {
			return null;
		}
		
	//	createRawMaterialReceipt();	
		
		String m_processMsg = null;
		
		if(MSysConfig.getValue("AGGREGATE_STOCK_APPROACH","B", getAD_Client_ID(), getAD_Org_ID()).equals("B")
				|| getTF_ProductionPlant_ID() == 0)
			return null;
		
		//Create Crusher Production
		MCrusherProduction cProd = new MCrusherProduction(getCtx(), 0, get_TrxName());
		cProd.setAD_Org_ID(getAD_Org_ID());
		cProd.setTF_ProductionPlant_ID(getTF_ProductionPlant_ID());		
		cProd.setTF_BlueMetal_Type(getTF_BlueMetal_Type());
		cProd.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
		cProd.setMovementDate(getDateAcct());
		cProd.setC_UOM_ID(getItem1_UOM_ID());		
		cProd.setM_Warehouse_ID(getM_Warehouse_ID());
		MWarehouse wh = MWarehouse.get(getCtx(), getM_Warehouse_ID());
		cProd.setM_Locator_ID(wh.getDefaultLocator().get_ID());
		cProd.setRM_Product_ID(getItem1_ID());
		cProd.setQtyUsed(getItem1_Qty());
		cProd.setDescription("Created from Purchase Quick Entry : " + getDocumentNo());
		cProd.setDocStatus(DOCSTATUS_Drafted);
		cProd.setDocAction(DOCACTION_Prepare);
		cProd.saveEx();
		
		//Update Crusher Production Reference to Boulder Receipt
		setTF_Crusher_Production_ID(cProd.getTF_Crusher_Production_ID());
		
		cProd.createProduction(true);
		cProd.saveEx();		
		//End Create
		
		//Post Crusher Production
		m_processMsg = cProd.processIt(DOCACTION_Complete);
		if(m_processMsg == null)			
			cProd.saveEx();
		return m_processMsg;
	}
	
	
	public void createSubcontractPurchaseEntry() {
		if(!isSOTrx()) {		
			return;
		}
		else if(getC_Project_ID() == 0 && isSOTrx()) {
			//Boulder based approach - tracking issued qty
			int Boulder_ID = MSysConfig.getIntValue("BOULDER_ID", 1000099, getAD_Client_ID(), getAD_Org_ID());
			MProduct rm = MProduct.get(getCtx(), Boulder_ID);
			if(getItem1().getC_UOM_ID() == rm.getC_UOM_ID() && getItem1_ID() != Boulder_ID) {				
				TF_MProductCategory pc = new TF_MProductCategory(getCtx(), getItem1().getM_Product_Category_ID(), get_TrxName());
				if(pc.isTrackMaterialMovement())
					MSubcontractMaterialMovement.createMaterialMovement(get_TrxName(), getDateAcct(), getAD_Org_ID(), getC_Order_ID(), 
							getC_BPartner_ID(), getItem1_ID(), getItem1_Qty(), getTF_WeighmentEntry_ID());
			}
			else if(getItem1_ID() == Boulder_ID && getTF_WeighmentEntry_ID() > 0) {
				MBoulderMovement.createBoulderIssue(get_TrxName(), getDateAcct(), getAD_Org_ID(), getItem1_ID(),
						getItem1_Qty(), getTF_WeighmentEntry_ID(), getM_Warehouse_ID(),0);
			}
			return;
		}
		
		if(getC_Project_ID() == 0)
			return;
		
		TF_MProject proj = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());
		if(!TF_MProject.SUBCONTRACTTYPE_CrusherProduction.equals(proj.getSubcontractType()) &&
				proj.getM_Warehouse_ID() != getM_Warehouse_ID())
			return;
		
		MSubcontractType st = new MSubcontractType(getCtx(), proj.getTF_SubcontractType_ID(), get_TrxName());
		
		if(st.isTrackMaterialMovement())
			MSubcontractMaterialMovement.createMaterialMovement(get_TrxName(), getDateAcct(),getAD_Org_ID(), getC_Project_ID(),
					getC_Invoice_ID(), proj.getC_BPartner_ID(), getItem1_ID(), getItem1_Qty(),
					getTF_WeighmentEntry_ID());
		
		//Do not create invoice from sales
		//if(!st.isCreateInvFromSales())
		//	return;
		
		int priceItem_Id = 0;
		int priceItem2_id = 0;
		if(st.getInvoicePriceFrom().equals(MSubcontractType.INVOICEPRICEFROM_Jobwork)) { 
			priceItem_Id = proj.getJobWork_Product_ID();
			priceItem2_id = proj.getJobWork_Product_ID();
		}		
		else {
			priceItem_Id = getItem1_ID();
			priceItem2_id = getItem2_ID();
		}
		//Crusher Production Subcontract Purchase		
		BigDecimal purchasePrice = MJobworkProductPrice.getPrice(getCtx(), getC_Project_ID(), priceItem_Id, getDateAcct()) ;
		BigDecimal purchasePrice2 = MJobworkProductPrice.getPrice(getCtx(), getC_Project_ID(), priceItem2_id, getDateAcct()) ;
		
		if(purchasePrice == null)
			throw new AdempiereException("Please setup Contract Price for " + getItem1().getName() + "!");
		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), proj.getC_BPartner_ID(), get_TrxName());
		
		//Invoice Header
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(1000005);	// AP Invoice		
		invoice.setDateInvoiced(getDateOrdered());
		invoice.setDateAcct(getDateAcct());
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));		
		//
		
		invoice.setBPartner(bp);
		invoice.setIsSOTrx(false);		
		invoice.setVehicleNo(getVehicleNo());		
		invoice.setDescription("(" + getDocumentNo() + ")");
		if(getTF_WeighmentEntry_ID() > 0) {
			MWeighmentEntry entry = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
			invoice.addDescription("Ticket No: " + entry.getDocumentNo());
		}
		//Price List
		int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
		if(bp.getPO_PriceList_ID() > 0)
			m_M_PriceList_ID = bp.getPO_PriceList_ID();			
		invoice.setM_PriceList_ID(m_M_PriceList_ID);
		invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		
		//Financial Dimension - Profit Center
		invoice.setUser1_ID(getUser1_ID());
		invoice.setC_Project_ID(getC_Project_ID());
		
		invoice.saveEx();
		//End Invoice Header
		
		//Invoice Line - Item1
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		invLine.setM_Product_ID(priceItem_Id , true);
		invLine.setQty(getItem1_Qty());					
		invLine.setPriceActual(purchasePrice);
		invLine.setPriceList(purchasePrice);
		invLine.setPriceLimit(purchasePrice);
		invLine.setPriceEntered(purchasePrice);		
		invLine.setC_Tax_ID(1000000);
		//invLine.setDescription(getItem1_Desc());
		invLine.saveEx();		
		
		//Invoice Line - Item2
		MInvoiceLine invLine2 = new MInvoiceLine(invoice);
		if(getItem2_ID() > 0) { 
			invLine2.setM_Product_ID(getItem2_ID() , true);
			invLine2.setQty(getItem2_Qty());					
			invLine2.setPriceActual(purchasePrice2);
			invLine2.setPriceList(purchasePrice2);
			invLine2.setPriceLimit(purchasePrice2);
			invLine2.setPriceEntered(purchasePrice2);		
			invLine2.setC_Tax_ID(1000000);
			invLine2.saveEx();
		}
		/*
		//MM Receipt
		if(st.isCreateMRFromSales()) {
			MInOut inout = new MInOut(invoice, 1000014, getDateAcct(), getM_Warehouse_ID());
			inout.setDescription(invoice.getDescription());
			inout.setMovementType(MInOut.MOVEMENTTYPE_VendorReceipts);
			inout.saveEx(get_TrxName());
			
			//Material Receipt Line - Item 1
			MInOutLine ioLine = new MInOutLine(inout);
			MWarehouse wh = (MWarehouse) getM_Warehouse();
			ioLine.setInvoiceLine(invLine, wh.getDefaultLocator().get_ID(), getItem1_Qty());
			ioLine.setQty(getItem1_Qty());
			ioLine.saveEx(get_TrxName());
			
			//Material Receipt Line - Item 2
			MInOutLine ioLine2 = new MInOutLine(inout);
			if(getItem2_ID() > 0) {
				ioLine2.setInvoiceLine(invLine2, wh.getDefaultLocator().get_ID(), getItem2_Qty());
				ioLine2.setQty(getItem2_Qty());
				ioLine2.saveEx(get_TrxName());
			}
			
			//Material Receipt DocAction
			if (!inout.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
			inout.saveEx();
			//End DocAction
			
			invLine.setM_InOutLine_ID(ioLine.getM_InOutLine_ID());
			invLine.saveEx();
			
			if(getItem2_ID() > 0) {
				invLine2.setM_InOutLine_ID(ioLine2.getM_InOutLine_ID());
				invLine2.saveEx();
			}
			
			setSubcon_Receipt_ID(inout.getM_InOut_ID());
		}
		*/
		//Invoice DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		//End DocAction
		
		setSubcon_Invoice_ID(invoice.getC_Invoice_ID());
		
		//create subcontractor 2 invoice
		if(proj.getC_BPartnerSubcon2_ID() > 0) {
			CreateSubcontract2Invoice(proj.getC_BPartnerSubcon2_ID(), proj.getM_ProductSubcon2_ID(), proj.getPriceSubcon2());
		}
	}
	
	public void CreateSubcontract2Invoice(int C_BPartnerSubcon2_ID, int M_ProductSubcon2_ID, BigDecimal priceSubcon2) {
		if(M_ProductSubcon2_ID == 0)
			throw new AdempiereException("Please specify Product (Subcontract 2) in " + getC_Project().getName() +
					" Subcontract to Create Subcontract 2 Invoice!");
		
		if(priceSubcon2 == null || priceSubcon2.doubleValue() == 0)
			throw new AdempiereException("Please specify Contract Price (Subcontract 2) in " + getC_Project().getName() +
					" Subcontract to Create Subcontract 2 Invoice!");
		
		int invoiceItem_id = M_ProductSubcon2_ID;
		
		//Crusher Production Subcontract Purchase		
		BigDecimal purchasePrice = priceSubcon2;		
		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), C_BPartnerSubcon2_ID, get_TrxName());
		
		//Purchase Invoice Header
		MGLPostingConfig config = MGLPostingConfig.getMGLPostingConfig(getCtx());
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(config.getTransporterInvoiceDocType_ID());	// AP Invoice		
		invoice.setDateInvoiced(getDateAcct());
		invoice.setDateAcct(getDateAcct());
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
		invoice.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
		//
		
		invoice.setBPartner(bp);
		invoice.setIsSOTrx(false);		
		invoice.setVehicleNo(getVehicleNo());
		
		String desc = "Sales Entry : " + getDocumentNo();		
		invoice.setDescription(desc);
		
		//Price List
		int m_M_PriceList_ID = MPriceList.getDefault(getCtx(), true).getM_PriceList_ID();		
		invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		if(invoice.getC_Currency_ID() == 0)
			invoice.setC_Currency_ID(getC_Currency_ID());
		
				
		invoice.saveEx();
		//End Invoice Header
		
		//Invoice Line - Vehicle Rental Charge
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		invLine.setM_Product_ID(invoiceItem_id , true);				
		
		invLine.setQty(getItem1_Qty());
		invLine.setDescription(getDescription());
		
		invLine.setPriceActual(purchasePrice);
		invLine.setPriceList(purchasePrice);
		invLine.setPriceLimit(purchasePrice);
		invLine.setPriceEntered(purchasePrice);
		
		invLine.setC_Tax_ID(1000000);
		invLine.saveEx();
		
		//Invoice DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		setSubcon_Invoice2_ID(invoice.getC_Invoice_ID());
	}
	
	public void reverseSubcontractPurchaseEntry() {
		MSubcontractMaterialMovement.deleteSalesEntryMovement(getC_Order_ID(), get_TrxName());
		MSubcontractMaterialMovement.deleteWeighmentMovement(getTF_WeighmentEntry_ID(), get_TrxName());
		MBoulderMovement.deleteBoulderMovement(getTF_WeighmentEntry_ID(), get_TrxName());
		if(getSubcon_Invoice_ID() > 0) {			
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getSubcon_Invoice_ID(), get_TrxName());
			if(inv.getDocStatus().equals(DOCSTATUS_Completed)) {
				inv.reverseCorrectIt();
				inv.saveEx();
			}
			MSubcontractMaterialMovement.deleteInvoiceMovement(inv.getC_Invoice_ID(), get_TrxName());
			//setSubcon_Invoice_ID(0);
		}
		if(getSubcon_Receipt_ID() > 0) {
			MInOut io = new MInOut(getCtx(), getSubcon_Receipt_ID(), get_TrxName());
			if(io.getDocStatus().equals(DOCSTATUS_Completed)) {
				io.reverseCorrectIt();
				io.saveEx();
			}
			setSubcon_Receipt_ID(0);
		}
		if(getSubcon_Invoice2_ID() > 0) {			
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getSubcon_Invoice2_ID(), get_TrxName());
			if(inv.getDocStatus().equals(DOCSTATUS_Completed)) {
				inv.reverseCorrectIt();
				inv.saveEx();
			}
			//MSubcontractMaterialMovement.deleteInvoiceMovement(inv.getC_Invoice_ID(), get_TrxName());
			//setSubcon_Invoice_ID(0);
		}
		
	}
	
	//Only for purchase
	public void purchasePermit() {
		if(!isSOTrx()) {
			TF_MProduct prod = new TF_MProduct(getCtx(), getItem1_ID(), get_TrxName());			
			if(prod.isMaintainPermitLedger()) {
				MPermitLedger pl = new MPermitLedger(getCtx(), 0, get_TrxName());
				pl.setAD_Org_ID(getAD_Org_ID());
				pl.setC_Order_ID(getC_Order_ID());
				pl.setC_OrderLine_ID(getItem1_C_OrderLine_ID());
				pl.setM_Product_ID(getItem1_ID());
				pl.setDateAcct(getDateAcct());
				pl.setDescription(getDescription());
				pl.setQtyPurchased(getItem1_Qty());
				pl.setUnitPrice(getItem1_Price());
				pl.setPurchasedAmt(getItem1_Amt());
				pl.setQtyIssued(BigDecimal.ZERO);
				pl.saveEx();
			}
		}
	}
		
	public void reversePurchasedPermit() {
		if(!isSOTrx()) {
			TF_MProduct prod = new TF_MProduct(getCtx(), getItem1_ID(), get_TrxName());
			if(prod.isMaintainPermitLedger())
				MPermitLedger.reversePurchasedPermit(getAD_Org_ID(), getItem1_C_OrderLine_ID(), get_TrxName());
		}
	}
	
	//Only For Sales
	public void issuePermit() {		
		if(!isSOTrx()) 
			return;
		
		if(!(getOrgType().equals(ORGTYPE_SandBlockBucket) || getOrgType().equals(ORGTYPE_SandBlockWeighbridge)))
			return;
		
		MSandBlockBucketConfig config = MSandBlockBucketConfig.getBucketConfig(getAD_Org_ID(), MSandBlockBucketConfig.SANDTYPE_P, getItem1_VehicleType_ID());
		if(isItem1_IsPermitSales() && (config == null || config.getM_ProductPermitLedger_ID() == 0)) {
			MVehicleType vType = new MVehicleType(getCtx(), getItem1_VehicleType_ID(), get_TrxName());
			throw new AdempiereException("For " + vType.getName() + ", please configure Permit Ledger in Sand Block Bucket Configuration!");
		}
		if(config != null && isItem1_IsPermitSales() && getItem1_ID() == config.getM_Product_ID()
				&& config.getM_ProductPermitLedger_ID() > 0) {
			BigDecimal qtyIssue = getItem1_PermitIssued(); 
					//getItem1_BucketQty().multiply(config.getPermitTonnagePerBucket());
			BigDecimal qtyPermitStock = MPermitLedger.getAvailablePermitStockQty(config.getM_ProductPermitLedger_ID(), get_TrxName());
			if(qtyPermitStock.doubleValue() < qtyIssue.doubleValue())
				throw new AdempiereException("Insufficient Permit Stock Available!");
			while(qtyIssue.doubleValue()>0) {
				MPermitLedger permit = MPermitLedger.getAvailablePermit(config.getM_ProductPermitLedger_ID(), get_TrxName());
				BigDecimal qtyIssued = BigDecimal.ZERO;
				if(permit.getQtyBalance().doubleValue() > qtyIssue.doubleValue())
					qtyIssued = qtyIssue;
				else
					qtyIssued = permit.getQtyBalance();
				
				MPermitLedgerLine pmLine = new MPermitLedgerLine(getCtx(), 0, get_TrxName());
				pmLine.setAD_Org_ID(getAD_Org_ID());
				pmLine.setC_Order_ID(getC_Order_ID());
				pmLine.setC_OrderLine_ID(getItem1_C_OrderLine_ID());
				pmLine.setTF_PermitLedger_ID(permit.getTF_PermitLedger_ID());
				pmLine.setM_Product_ID(getItem1_ID());
				pmLine.setDescription(getItem1_Desc());
				pmLine.setQtyIssued(qtyIssued);;
				pmLine.setDateAcct(getDateAcct());
				pmLine.setUnitPrice(permit.getUnitPrice());
				pmLine.setTonePerBucket(config.getPermitTonnagePerBucket());
				pmLine.saveEx();
				permit.updateQtyIssued();
				permit.saveEx();
				qtyIssue = qtyIssue.subtract(qtyIssued);
			}				
		}	
	}
	
	public void reverseIssuedPermit() {
		if(isItem1_IsPermitSales() && isSOTrx())
			MPermitLedger.reverseIssuedPermit(getAD_Org_ID(), getItem1_C_OrderLine_ID(), get_TrxName());
	}
	
	public void createTaxInvoice() {
		if(!isOnAccount() || getTF_TRTaxInvoice_ID() > 0 || !isSOTrx())
			return;
		
		/*if(getItem1_PermitIssued().doubleValue() <= 0)
			throw new AdempiereException("Invalid Permit Issued!");*/
		
		MWeighmentEntry wEntry = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
		
		if(!wEntry.isPermitSales() && !wEntry.isBillPriceGST())
			return;
		
		MTRTaxInvoice inv = new MTRTaxInvoice(getCtx(),0, get_TrxName());
		inv.setAD_Org_ID(getAD_Org_ID());
		inv.setDateAcct(getDateAcct());
		inv.setTF_WeighmentEntry_ID(wEntry.getTF_WeighmentEntry_ID());
		inv.setDocumentNo(wEntry.getDocumentNo());
		inv.setM_Warehouse_ID(getM_Warehouse_ID());
		inv.setPartyName(getPartyName());
		inv.setPostTaxToCustomer(false);
		inv.setPostGSTAsExpense(false);
		inv.setC_BPartner_ID(getC_BPartner_ID());
		inv.setDateSupply(getDateAcct());
		inv.setIsSOTrx(true);
		
		TF_MBPartner partner = new TF_MBPartner(getCtx(),getC_BPartner_ID(),get_TrxName());
		if(wEntry != null && partner.getIsPOSCashBP() && getPartyName() == null) {
			inv.setPartyName(wEntry.getPartyName());
		}
		
		if(wEntry.getTaxID() != null) {
			inv.setTaxID(wEntry.getTaxID());
		}
		else
		{
			inv.setTaxID(partner.getTaxID());
		}
			
		inv.setDocumentNo(wEntry.getInvoiceNo());
		inv.setBillingName(wEntry.getBillingName());
		MDestination dest = new MDestination(getCtx(), getTF_Destination_ID(), get_TrxName());
		
		inv.setPlaceOfSupply(dest.getName());
		
		inv.setVehicleNo(getVehicleNo());		
		//inv.calcAmounts();		

		if(wEntry.getC_BankAccount_ID() > 0) {
			inv.setC_BankAccount_ID(wEntry.getC_BankAccount_ID());
		}
		else {
			String whereClause = "AD_Org_ID=?";
			MBankAccount ba = new Query(getCtx(),MBankAccount.Table_Name,whereClause,get_TrxName())
				.setParameters(wEntry.getAD_Org_ID()).setOnlyActiveRecords(true).setOrderBy("IsDefault DESC").first();
			inv.setC_BankAccount_ID(ba.getC_BankAccount_ID());
		}
		inv.setApplyTCS(wEntry.isApplyTCS());
		inv.saveEx();

		//item1
		MTRTaxInvoiceLine invLine = new MTRTaxInvoiceLine(inv);
		invLine.setAD_Org_ID(getAD_Org_ID());
		invLine.setM_Product_ID(getItem1_ID());
		invLine.setC_UOM_ID(getItem1_UOM_ID());
		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
		//MCustomerType custType = new MCustomerType(getCtx(), bp.getTF_CustomerType_ID(), get_TrxName());
		TF_MProduct prod=new TF_MProduct(getCtx(), getItem1_ID(), get_TrxName());
		
		BigDecimal divisor = new BigDecimal(1.05);
		divisor = divisor.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal price = BigDecimal.ZERO;	
		if(wEntry.isPermitSales()) {
			if(getItem1_Price() == null || getItem1_Price().doubleValue() == 0)
				throw new AdempiereException("Please set Item Price for " + prod.getName());
		
			price =	wEntry.getMaterialPriceIncludedRent();
		}
		else {
			if(wEntry.getBillPrice() == null || wEntry.getBillPrice().doubleValue() == 0)
				throw new AdempiereException("Please set Bill Price for " + prod.getName());
				
			price = wEntry.getBillPrice();	
		}
		
		/*
		if(isRentBreakup())
		{
			if(isRentInclusive()) {
				price = getItem1_UnitPrice();
			}
			else {
				price = getItem1_UnitPrice().add(getItem1_UnitRent());
			}
		}
		
		if(custType.getBillingPriceRatio().doubleValue() > 0)
			price = price.multiply(custType.getBillingPriceRatio());
		*/
		
		//Set Qty based on Customer Type Billing Qty Ratio
		// When BillingQtyRation is ZERO then Based on the amount BillingQty has to be calcualted. 
		BigDecimal qty = getItem1_Qty();
		//if(custType.getBillingQtyRatio().doubleValue() > 0)
		//	qty = qty.multiply(custType.getBillingQtyRatio());
		//else {
			//qty = getGrandTotal().divide(price, 2, RoundingMode.HALF_EVEN);
		//}
		invLine.setQty(qty);
		
		
		//Exclude Tax amount from Price
		//TF_MProduct prod = new TF_MProduct(getCtx(), getItem1_ID(), get_TrxName());
		MTax tax = new MTax(getCtx(), prod.getTax_ID(wEntry.getGSTRate(), true, wEntry.isApplyTCS(), partner.isInterState(), isReverseCharge()), get_TrxName());
		
		if(wEntry.isApplyTCS())	{
			String whereClause = "C_TaxTCS_ID = ?";
			tax = new Query(getCtx(), MTax.Table_Name,  whereClause, get_TrxName()).setClient_ID().setParameters(tax.getC_Tax_ID()).first();
		}
		
		BigDecimal taxRate = tax.getRate();
		BigDecimal hundred = new BigDecimal("100");				
		invLine.setPrice(price);
		invLine.setTaxableAmount(price.multiply(invLine.getQty()));
						
		BigDecimal SGST_Rate = taxRate.divide(new BigDecimal(2), 2, RoundingMode.HALF_EVEN);				
		invLine.setSGST_Rate(SGST_Rate);
		invLine.setCGST_Rate(SGST_Rate);
		invLine.setIGST_Rate(BigDecimal.ZERO);
		invLine.setIGST_Amt(BigDecimal.ZERO);
		
		invLine.calcAmounts();
		invLine.saveEx();

		if(getItem2_ID()>0)
		{
			//item2
			MTRTaxInvoiceLine invLine2 = new MTRTaxInvoiceLine(inv);
			invLine2.setAD_Org_ID(getAD_Org_ID());
			invLine2.setM_Product_ID(getItem2_ID());
			invLine2.setC_UOM_ID(getItem2_UOM_ID());
			
			TF_MBPartner bp2 = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
			//MCustomerType custType = new MCustomerType(getCtx(), bp.getTF_CustomerType_ID(), get_TrxName());
			TF_MProduct prod2=new TF_MProduct(getCtx(), getItem2_ID(), get_TrxName());
			
			
			//Set Price based on Customer Type Billing Price Ratio
			
			BigDecimal divisor2 = new BigDecimal(1.05);
			divisor2 = divisor2.setScale(2, RoundingMode.HALF_EVEN);
			BigDecimal price2 = BigDecimal.ZERO;	
			if(wEntry.isPermitSales()) {
				if(getItem2_Price() == null || getItem2_Price().doubleValue() == 0)
					throw new AdempiereException("Please set Item 2 Price for " + prod2.getName());
			
				price2 =getItem2_Price();
			}
			else {
				if(prod2.getBillPrice() == null || prod2.getBillPrice().doubleValue() == 0)
					throw new AdempiereException("Please set Bill Price for " + prod2.getName());
					
				price2 = prod2.getBillPrice();	
			}
			
			
			//Set Qty based on Customer Type Billing Qty Ratio
			BigDecimal qty2 = getItem2_Qty();
			invLine2.setQty(qty2);
			
			
			//Exclude Tax amount from Price
			MTax tax2 = new MTax(getCtx(), prod2.getTax_ID(true, partner.isInterState(), isReverseCharge()), get_TrxName());				
			BigDecimal taxRate2 = tax2.getRate();
			BigDecimal hundred2 = new BigDecimal("100");				
			BigDecimal priceExcludesTax2 = price2.divide(BigDecimal.ONE
					.add(taxRate2.divide(hundred2,2,RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);				
			invLine2.setPrice(priceExcludesTax2);
			invLine2.setTaxableAmount(priceExcludesTax2.multiply(invLine2.getQty()));
							
			BigDecimal SGST_Rate2 = taxRate2.divide(new BigDecimal(2), 2, RoundingMode.HALF_EVEN);				
			invLine2.setSGST_Rate(SGST_Rate2);
			invLine2.setCGST_Rate(SGST_Rate2);
			invLine2.setIGST_Rate(BigDecimal.ZERO);
			invLine2.setIGST_Amt(BigDecimal.ZERO);
			
			invLine2.calcAmounts();
			invLine2.saveEx();
		}
		
		/*if(wEntry.isApplyTCS()) {
			BigDecimal TotalAmount = inv.getGrandTotal();			
			BigDecimal TCSAmt = TotalAmount.multiply(new BigDecimal(0.001)).setScale(2, RoundingMode.HALF_EVEN);
			
			TotalAmount = TotalAmount.add(TCSAmt);
			
			BigDecimal RoundOffAmt = BigDecimal.ZERO;
			RoundOffAmt = TotalAmount.setScale(0, RoundingMode.HALF_UP).subtract(TotalAmount);
			inv.setRoundOff(RoundOffAmt);
			inv.setTotal(TotalAmount.add(RoundOffAmt));
		}*/
		//No Rent Included
		
		setTF_TRTaxInvoice_ID(inv.getTF_TRTaxInvoice_ID());
		inv.processIt(DOCACTION_Complete);
		inv.saveEx();
	}
	
	public void createConsolidatedTaxInvoice() {
		if(!isOnAccount() || getTF_TRTaxInvoice_ID() > 0 || !isSOTrx())
			return;
		
		/*if(getItem1_PermitIssued().doubleValue() <= 0)
			throw new AdempiereException("Invalid Permit Issued!");*/
		
		/*String sql = "SELECT m_product_id, c_uom_id, billprice,gstrate, SUM(netweightunit) netweightunit, SUM(rent_amt) / SUM(netweightunit) unitrent FROM "  
						+ "( SELECT"
						+ 	"	w.m_product_id,w.c_uom_id, CASE WHEN w.ispermitsales = 'Y' THEN w.price ELSE w.billprice END billprice,w.netweightunit,W.gstrate,"
						+ 	" CASE WHEN w.ispermitsales = 'Y' THEN  w.rent_amt ELSE 0 END rent_amt  FROM " 
						+ "	tf_weighmententry w INNER JOIN m_inout ON m_inout.tf_weighmententry_id = w.tf_weighmententry_id " 
						+	" WHERE w.isrequiredtaxinvoiceperload = 'N' AND m_inout.c_order_id = ? AND (w.ispermitsales ='Y' OR w.billpricegst = 'Y') )"
						+ " we GROUP BY m_product_id, c_uom_id, billprice,gstrate;";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Trx trx = Trx.get(get_TrxName(), false);
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();*/
		
		//try	{
			/*pstmt = DB.prepareStatement(sql, get_TrxName());			
			params.add(getC_Order_ID());
			DB.setParameters(pstmt, params.toArray());			
			rs = pstmt.executeQuery();*/
			
			String whereClause = "C_Order_ID = ?";
			TF_MInvoice invoice = new Query(getCtx(), TF_MInvoice.Table_Name, whereClause, get_TrxName()).setParameters(getC_Order_ID()).setClient_ID().first();
			
			MTRTaxInvoice inv = new MTRTaxInvoice(getCtx(),0, get_TrxName());
			inv.setAD_Org_ID(getAD_Org_ID());
			
			if(invoice.getDocumentNo() != null) {
				inv.setDocumentNo(invoice.getDocumentNo());
			}
			
			inv.setDateAcct(getDateAcct());
			inv.setM_Warehouse_ID(getM_Warehouse_ID());
			inv.setPartyName(getPartyName());
			inv.setPostTaxToCustomer(false);
			inv.setPostGSTAsExpense(false);
			inv.setC_BPartner_ID(getC_BPartner_ID());
			inv.setDateSupply(getDateAcct());
			inv.setIsSOTrx(true);
			
			TF_MBPartner partner = new TF_MBPartner(getCtx(),getC_BPartner_ID(),get_TrxName());
			inv.setTaxID(partner.getTaxID());
				
			inv.setBillingName(partner.getName());
			MDestination dest = new MDestination(getCtx(), getTF_Destination_ID(), get_TrxName());
			
			inv.setPlaceOfSupply(dest.getName());
			
			inv.setVehicleNo(getVehicleNo());		
			//inv.calcAmounts();
			
			String whereTax = "C_TaxTCS_ID  = ? ";
			boolean ApplyTCS = new Query(getCtx(), MTax.Table_Name, whereTax, get_TrxName())
					.setParameters(getC_Tax_ID())
					.count() > 0;
					
			whereClause = "AD_Org_ID=?";
			MBankAccount ba = new Query(getCtx(),MBankAccount.Table_Name,whereClause,get_TrxName())
				.setParameters(getAD_Org_ID()).setOnlyActiveRecords(true).setOrderBy("IsDefault DESC").first();
			inv.setC_BankAccount_ID(ba.getC_BankAccount_ID());
			inv.setApplyTCS(ApplyTCS);
			inv.saveEx();
				
			MTax tax = new MTax(getCtx(), getC_Tax_ID(), get_TrxName());	
			BigDecimal hundred = new BigDecimal("100");
			BigDecimal taxRate = (BigDecimal) tax.get_Value("DisplayRate");
			if(taxRate == null)
				taxRate = tax.getRate();
			
			
			int PASS_CATEGORY_ID = MSysConfig.getIntValue("PASS_CATEGORY_ID", 1000062, Env.getAD_Client_ID(getCtx()));
			
			for(MOrderLine orderline : getLines()) {
				
				TF_MProduct product = new TF_MProduct(getCtx(), orderline.getM_Product_ID(), get_TrxName());
				
				if(PASS_CATEGORY_ID != product.getM_Product_Category_ID()) {
					//item1
					MTRTaxInvoiceLine invLine = new MTRTaxInvoiceLine(inv);
					invLine.setAD_Org_ID(getAD_Org_ID());
					invLine.setM_Product_ID(orderline.getM_Product_ID());
					invLine.setC_UOM_ID(orderline.getC_UOM_ID());
					
					BigDecimal price = orderline.getPriceEntered();					
					
					if(ApplyTCS) {
						price = price.divide(BigDecimal.ONE
								.add(new BigDecimal(0.1).divide(hundred,4,RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);		
					}
					
					price = price.divide(BigDecimal.ONE
							.add(taxRate.divide(hundred,4,RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);								 
					
					BigDecimal qty = orderline.getQtyEntered();
					invLine.setQty(qty);
									
					//Exclude Tax amount from Price
					//TF_MProduct prod = new TF_MProduct(getCtx(), getItem1_ID(), get_TrxName());
					invLine.setPrice(price);
					invLine.setTaxableAmount(price.multiply(invLine.getQty()));
									
					BigDecimal SGST_Rate = taxRate.divide(new BigDecimal(2), 2, RoundingMode.HALF_EVEN);				
					invLine.setSGST_Rate(SGST_Rate);
					invLine.setCGST_Rate(SGST_Rate);
					invLine.setIGST_Rate(BigDecimal.ZERO);
					invLine.setIGST_Amt(BigDecimal.ZERO);
					
					invLine.calcAmounts();
					invLine.saveEx();
				}
			}
			
			setTF_TRTaxInvoice_ID(inv.getTF_TRTaxInvoice_ID());
			inv.processIt(DOCACTION_Complete);
			inv.saveEx();
	/*	}
		catch (SQLException e) {
			throw new DBException(e, sql.toString());
		}
		finally	{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}*/
		
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();
		params = new ArrayList<Object>();
		String sqlUpdateWEs = "UPDATE tf_weighmententry SET Status = 'CL' WHERE  tf_weighmententry_id IN (SELECT M_InOut.tf_weighmententry_id FROM M_InOut Where " + 
				" m_inout.c_order_id = ?) AND  Status = 'CO' ";
		params = new ArrayList<Object>();
		params.add(getC_Order_ID());		
		DB.executeUpdateEx(sqlUpdateWEs, params.toArray(), get_TrxName());
	}
	
	public void createConsolidatedOrderLines() {
		
		for(MOrderLine ordLine : getLines()) {
			ordLine.delete(true, get_TrxName());
		}
		
		String sql = "SELECT m_product_id, c_uom_id, price,SUM(netweightunit) netweightunit FROM "  
						+ "( SELECT"
						+ 	"	w.m_product_id,w.c_uom_id, round((w.amount + w.rent_amt + w.permitpassamount) / w.netweightunit, 2) price,w.netweightunit FROM " 
						+ "	tf_weighmententry w  WHERE w.c_order_id = ?)"
						+ " we GROUP BY m_product_id, c_uom_id, price;";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Trx trx = Trx.get(get_TrxName(), false);
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();
		
		try	{
			pstmt = DB.prepareStatement(sql, get_TrxName());			
			params.add(getC_Order_ID());
			DB.setParameters(pstmt, params.toArray());			
			rs = pstmt.executeQuery();
			TF_MBPartner bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
			
			while (rs.next()) {
				int M_Product_ID = rs.getInt("m_product_id");
				int C_UOM_ID = rs.getInt("c_uom_id");
				BigDecimal netweightunit = rs.getBigDecimal("netweightunit");
				BigDecimal price = rs.getBigDecimal("price");
				
				TF_MOrderLine ordLine = new TF_MOrderLine(this);
				ordLine.setM_Product_ID(M_Product_ID, true);
				ordLine.setC_UOM_ID(C_UOM_ID);								
				ordLine.setQty(netweightunit);
				ordLine.setPriceActual(price);
				ordLine.setPriceList(price);
				ordLine.setPriceLimit(price);
				ordLine.setPriceEntered(price);
				ordLine.setC_Order_ID(getC_Order_ID());
				TF_MProduct prod = new TF_MProduct(getCtx(), M_Product_ID, get_TrxName());
				ordLine.setC_Tax_ID(prod.getTax_ID((getC_DocTypeTarget_ID() == GSTConsolidatedOrderDocType_ID(getCtx())), bp.isInterState(), isReverseCharge()));
				ordLine.saveEx();
			}	
		}
		catch (SQLException e) {
			throw new DBException(e, sql.toString());
		}
		finally	{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		/*
		params = new ArrayList<Object>();
		String sqlUpdateWEs = "UPDATE tf_weighmententry SET Status = 'CL' WHERE  tf_weighmententry.c_order_id = ? AND  Status = 'CO'";
		params = new ArrayList<Object>();
		params.add(getC_Order_ID());		
		DB.executeUpdateEx(sqlUpdateWEs, params.toArray(), get_TrxName());*/
	}
	
	
	public void voidTaxInvoice() {
		if(getTF_TaxInvoice_ID() > 0) {
			MTaxInvoice inv = new MTaxInvoice(getCtx(), getTF_TaxInvoice_ID(), get_TrxName());
			inv.reverseIt();
			inv.setDocStatus(DOCSTATUS_Voided);
			inv.setProcessed(true);
			inv.saveEx();
			setTF_TaxInvoice_ID(0);
		}
	}

	public void voidTR_TaxInvoice() {
		if(getTF_TRTaxInvoice_ID() > 0) {
			MTRTaxInvoice inv = new MTRTaxInvoice(getCtx(), getTF_TRTaxInvoice_ID(), get_TrxName());
			inv.reverseIt();
			inv.setDocStatus(DOCSTATUS_Voided);
			inv.setProcessed(true);
			inv.saveEx();
			setTF_TRTaxInvoice_ID(0);
		}
	}
	
	/** Set Cash Sales Discount.
	@param SalesDiscountAmt Cash Sales Discount	  */
	public void setSalesDiscountAmt (BigDecimal SalesDiscountAmt)
	{
		set_Value (COLUMNNAME_SalesDiscountAmt, SalesDiscountAmt);
	}
	
	/** Get Cash Sales Discount.
		@return Cash Sales Discount	  */
	public BigDecimal getSalesDiscountAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_SalesDiscountAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_Payment getC_PaymentSalesDiscount() throws RuntimeException
    {
		return (org.compiere.model.I_C_Payment)MTable.get(getCtx(), org.compiere.model.I_C_Payment.Table_Name)
			.getPO(getC_PaymentSalesDiscount_ID(), get_TrxName());	}

	/** Set Sales Discount Payment.
		@param C_PaymentSalesDiscount_ID Sales Discount Payment	  */
	public void setC_PaymentSalesDiscount_ID (int C_PaymentSalesDiscount_ID)
	{
		if (C_PaymentSalesDiscount_ID < 1) 
			set_Value (COLUMNNAME_C_PaymentSalesDiscount_ID, null);
		else 
			set_Value (COLUMNNAME_C_PaymentSalesDiscount_ID, Integer.valueOf(C_PaymentSalesDiscount_ID));
	}

	/** Get Sales Discount Payment.
		@return Sales Discount Payment	  */
	public int getC_PaymentSalesDiscount_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PaymentSalesDiscount_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	
	private void createCashSalesDiscountPayment() {
		if(get_Value(TF_MOrder.COLUMNNAME_SalesDiscountAmt) == null)
			return;
		BigDecimal amt = (BigDecimal) get_Value(TF_MOrder.COLUMNNAME_SalesDiscountAmt);
		if(amt.doubleValue() == 0)
			return;
		
		MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(getCtx());
		
		//Create Driver Tips Charge if it is not there already.
		//It should be in atomic transaction to get account settings of Charge for the current docaction transaction.
		TF_MCharge charge = TF_MCharge.createChargeFromAccount(getCtx(), glConfig.getSalesDiscountAcct_ID(), null);
		
		//Get Invoice Document no
		String Where=" C_Order_ID = ? AND DocStatus = 'CO'";
		
		MInvoice inv = new Query(getCtx(), MInvoice.Table_Name,Where, get_TrxName())
				.setClient_ID()
				.setOnlyActiveRecords(true)
				.setParameters(getC_Order_ID())
				.first();
		
		String invoiceNo="";
		if(inv!=null) {
			invoiceNo=inv.getDocumentNo();
		}

		//Posting Payment Document for Driver Tips
		TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
		payment.setAD_Org_ID(getAD_Org_ID());
		payment.setDateAcct(getDateAcct());
		payment.setDateTrx(getDateAcct());
		payment.setDescription("Cash Sales Discount for "+ invoiceNo);
		//* Commented for Laxmi Stone */
		//payment.setCashType(TF_MPayment.CASHTYPE_GeneralExpense);
		payment.setC_DocType_ID(false);		
		payment.setC_Charge_ID(charge.getC_Charge_ID());
		payment.setUser1_ID(getUser1_ID()); // Profit Center
		payment.setC_ElementValue_ID(glConfig.getSalesDiscountAcct_ID());
		payment.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
		
		payment.setC_BankAccount_ID(getC_BankAccount_ID());
		//payment.setC_BankAccount_ID(TF_MBankAccount.getDefaultCashAccount(getCtx(), getAD_Org_ID(), null));
		MUser user = MUser.get(getCtx(), Env.getAD_User_ID(getCtx()));
		payment.setC_BPartner_ID(user.getC_BPartner_ID());
		payment.setPayAmt(amt);
		payment.setC_Currency_ID(getC_Currency_ID());
		payment.setDocStatus(TF_MOrder.DOCSTATUS_InProgress);
		payment.setTenderType(TF_MPayment.TENDERTYPE_Cash);
		payment.saveEx();
		payment.processIt(DocAction.ACTION_Complete);
		payment.saveEx();
		
		TF_MOrder mOrder=new TF_MOrder(getCtx(), get_ID(), get_TrxName());
		mOrder.set_ValueOfColumn(TF_MOrder.COLUMNNAME_C_PaymentSalesDiscount_ID, payment.getC_Payment_ID());
		mOrder.saveEx();
		
	}
	
	public void createAdditionalInvoice() {
		String whereClause = "C_Order_ID = ? AND DocStatus='CO'";
		TF_MInvoice srcInv = new Query(getCtx(), TF_MInvoice.Table_Name, whereClause, get_TrxName())
			.setClient_ID()
			.setParameters(getC_Order_ID())
			.first();
		if(srcInv == null)
			return;
		String weighmentNo = null;
		if(srcInv.getC_Order_ID() > 0) {
			TF_MOrder ord = new TF_MOrder(srcInv.getCtx(), srcInv.getC_Order_ID(), srcInv.get_TrxName());
			if(ord.getTF_WeighmentEntry_ID() > 0) {
				MWeighmentEntry wEntry = new MWeighmentEntry(srcInv.getCtx(), ord.getTF_WeighmentEntry_ID(), srcInv.get_TrxName());
				weighmentNo = wEntry.getDocumentNo();
			}
		}
		for (MInvoiceLine srcLine : srcInv.getLines()) {
			
			List<MAdditionalTransactionSetup> ctransSetups = MAdditionalTransactionSetup.getAdditionalTransaction
					(srcInv.getCtx(), srcInv.getAD_Org_ID(), srcInv.getC_DocTypeTarget_ID(), srcInv.getC_BPartner_ID(), srcLine.getM_Product_ID());
			for(MAdditionalTransactionSetup ctransSetup : ctransSetups) {
				
				TF_MBPartner bp = new TF_MBPartner(srcInv.getCtx(), ctransSetup.getTo_Bpartner_ID(), srcInv.get_TrxName());
				
				//Invoice Header
				TF_MInvoice invoice = new TF_MInvoice(srcInv.getCtx(), 0, srcInv.get_TrxName());
				invoice.setClientOrg(srcInv.getAD_Client_ID(), ctransSetup.getTo_Org_ID());
				invoice.setC_DocTypeTarget_ID(ctransSetup.getTo_Doctype_ID());	// Counter Doc
				invoice.setIsSOTrx(ctransSetup.getTo_Doctype().isSOTrx());
				invoice.setDateInvoiced(srcInv.getDateInvoiced());
				invoice.setDateAcct(srcInv.getDateAcct());
				//
				invoice.setSalesRep_ID(Env.getAD_User_ID(srcInv.getCtx()));		
				//
				
				invoice.setBPartner(bp);				
				invoice.setVehicleNo(srcInv.getVehicleNo());
				if(weighmentNo != null)
					invoice.setDescription("Ticket No: " + weighmentNo);
				else
					invoice.addDescription("Ref Invoice: " + srcInv.getDocumentNo());
				if(srcInv.getDescription() != null)
					invoice.addDescription(srcInv.getDescription());
				
				//Price List
				int m_M_PriceList_ID = Env.getContextAsInt(srcInv.getCtx(), "#M_PriceList_ID");
				
				if(!srcInv.isSOTrx() && bp.getM_PriceList_ID() > 0)
					m_M_PriceList_ID = bp.getM_PriceList_ID();
				else if(srcInv.isSOTrx() && bp.getPO_PriceList_ID() > 0)
					m_M_PriceList_ID = bp.getPO_PriceList_ID();
				
				invoice.setM_PriceList_ID(m_M_PriceList_ID);
				invoice.setC_Currency_ID(MPriceList.get(srcInv.getCtx(), m_M_PriceList_ID, srcInv.get_TrxName()).getC_Currency_ID());
				
				//Financial Dimension - Profit Center		
				//invoice.setC_Project_ID(counterProj.getC_Project_ID());
				invoice.setRef_Invoice_ID(srcInv.getC_Invoice_ID());
				invoice.saveEx();
				
				//Create Invoice Line
				MInvoiceLine invLine = new MInvoiceLine(invoice);				
				invLine.setM_Product_ID(ctransSetup.getTo_Product_ID(), true);
				invLine.setQty(srcLine.getQtyInvoiced().multiply(ctransSetup.getToQtyRatio().setScale(2, RoundingMode.HALF_EVEN)));
				invLine.setC_UOM_ID(ctransSetup.getToUom_ID() > 0 ? ctransSetup.getToUom_ID() : srcLine.getC_UOM_ID());
				BigDecimal price = ctransSetup.getToUnitPriceRatio().multiply(srcLine.getPriceEntered()).setScale(2, RoundingMode.HALF_EVEN);
				if(ctransSetup.getToUnitPrice().doubleValue() > 0) {
					price = ctransSetup.getToUnitPrice();
				}
				invLine.setPriceActual(price);
				invLine.setPriceList(price);
				invLine.setPriceLimit(price);
				invLine.setPriceEntered(price);				
				invLine.setC_Tax_ID(srcLine.getC_Tax_ID());
				invLine.setDescription(srcLine.getDescription());				
				invLine.saveEx();				
				
				//Invoice DocAction
				if (!invoice.processIt(DocAction.ACTION_Complete))
					throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
				invoice.saveEx();
								
			}
		}
	}
	private void reverseAdditionalTransactions() {
		String whereClause = "C_Order_ID = ? AND DocStatus='RE'";
		TF_MInvoice srcInv = new Query(getCtx(), TF_MInvoice.Table_Name, whereClause, get_TrxName())
			.setClient_ID()
			.setParameters(getC_Order_ID())
			.first();
		if(srcInv == null)
			return;
		String whereClause2 = "Ref_Invoice_ID = ? AND DocStatus = 'CO'";
		List<TF_MInvoice> refInvoices = new Query(srcInv.getCtx(), TF_MInvoice.Table_Name, whereClause2, srcInv.get_TrxName())
				.setClient_ID()
				.setParameters(srcInv.getC_Invoice_ID())
				.list();
		for(TF_MInvoice inv : refInvoices) {			
			if(inv.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				inv.reverseCorrectIt();
				inv.saveEx();
			}
		}
	}
	
	public static int GSTOrderDocType_ID(Properties ctx) {
		//int DocType_ID = MSysConfig.getIntValue("GST_ORDER_ID", 1000063, Env.getAD_Client_ID(ctx));
		int DocType_ID = MSysConfig.getIntValue("GST_ORDER_ID", 1000062, Env.getAD_Client_ID(ctx));
		return DocType_ID;
	}
	
	public static int GSTConsolidatedOrderDocType_ID(Properties ctx) {
		//int DocType_ID = MSysConfig.getIntValue("GST_ORDER_ID", 1000063, Env.getAD_Client_ID(ctx));
		int DocType_ID = MSysConfig.getIntValue("CONSOLIDATED_INVOICE_ORDER_ID", 1000093, Env.getAD_Client_ID(ctx));
		return DocType_ID;
	}

	public static int NonGSTConsolidatedOrderDocType_ID(Properties ctx) {
		//int DocType_ID = MSysConfig.getIntValue("GST_ORDER_ID", 1000063, Env.getAD_Client_ID(ctx));
		int DocType_ID = MSysConfig.getIntValue("NONGST_CONSOLIDATED_INVOICE_ORDER_ID", 1000092, Env.getAD_Client_ID(ctx));
		return DocType_ID;
	}
	
	public static int NonGSTOrderDocType_ID(Properties ctx) {
		int DocType_ID = MSysConfig.getIntValue("NONGST_ORDER_ID", 1000062, Env.getAD_Client_ID(ctx));
		return DocType_ID;
	}
	
	public static int GSTPurchaeDocType_ID(Properties ctx) {
		//int DocType_ID = MSysConfig.getIntValue("GST_ORDER_ID", 1000063, Env.getAD_Client_ID(ctx));
		int DocType_ID = MSysConfig.getIntValue("GST_PURCHASE_ID", 1000062, Env.getAD_Client_ID(ctx));
		return DocType_ID;
	}

	public static int NonGSTPurchaeDocType_ID(Properties ctx) {
		int DocType_ID = MSysConfig.getIntValue("NONGST_PURCHASE_ID", 1000062, Env.getAD_Client_ID(ctx));
		return DocType_ID;
	}
	
	public static int RoyaltyPassOrderPurchaseDocType_ID(Properties ctx) {
		int DocType_ID = MSysConfig.getIntValue("ROYALTY_PASS_PURCHASE_DOCTYPE_ID", 1000062, Env.getAD_Client_ID(ctx));
		return DocType_ID;
	}
	
	public static int RoyaltyPassOrderDocType_ID(Properties ctx) {
		int DocType_ID = MSysConfig.getIntValue("ROYALTY_PASS_DOCTYPE_ID", 1000062, Env.getAD_Client_ID(ctx));
		return DocType_ID;
	}
	
	public static int BoulderSalesOrderDocType_ID(Properties ctx) {
		//int DocType_ID = MSysConfig.getIntValue("GST_ORDER_ID", 1000063, Env.getAD_Client_ID(ctx));
		int DocType_ID = MSysConfig.getIntValue("BOULDER_SALES_INVOICE_ORDER_ID", 1000099, Env.getAD_Client_ID(ctx));
		return DocType_ID;
	}
	
//	public static int BoulderSalesInvoiceDocType_ID(Properties ctx) {
//		//int DocType_ID = MSysConfig.getIntValue("GST_ORDER_ID", 1000063, Env.getAD_Client_ID(ctx));
//		int DocType_ID = MSysConfig.getIntValue("BOULDER_SALES_INVOICE_ID", 1000100, Env.getAD_Client_ID(ctx));
//		return DocType_ID;
//	}

	public boolean firstInvoice = true;
	public void createInvoiceCustomer() {
		
		MWeighmentEntry weighment = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
		
		if(getC_DocTypeTarget_ID() != TF_MOrder.GSTOrderDocType_ID(getCtx()) &&
				getC_DocTypeTarget_ID() != TF_MOrder.NonGSTOrderDocType_ID(getCtx()) && 
				getC_DocTypeTarget_ID() != TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx()) && 
				getC_DocTypeTarget_ID() != TF_MOrder.NonGSTConsolidatedOrderDocType_ID(getCtx()) &&
				getC_DocTypeTarget_ID() != TF_MOrder.RoyaltyPassOrderDocType_ID(getCtx()) &&
				getC_DocTypeTarget_ID() != TF_MOrder.BoulderSalesOrderDocType_ID(getCtx()))
			return;
		
		//Invoice Header
		TF_MBPartner bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
		
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setC_Order_ID(getC_Order_ID());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(getC_DocTypeTarget().getC_DocTypeInvoice_ID());	// Counter Doc
		invoice.setIsSOTrx(isSOTrx());
		invoice.setDateInvoiced(getDateAcct());
		invoice.setDateAcct(getDateAcct());
		invoice.setVehicleNo(getVehicleNo());
		invoice.setC_Project_ID(getC_Project_ID());
		//fetching already generated invoice no in case of reversing and recreating the existing invoices.
		/*if(getC_DocTypeTarget_ID() == GSTOrderDocType_ID(getCtx())) {
			invoice.setDocumentNo(weighment.getInvoiceNo());		
			if(invoice.getDocumentNo() == null)
				invoice.setDocumentNo(weighment.getDocumentNo());
		}
		else {
			invoice.setDocumentNo(weighment.getDocumentNo());
		}*/
		
		//
		invoice.setDocumentNo(getInvoiceNo());
	/*	if(getC_DocTypeTarget_ID() == GSTConsolidatedOrderDocType_ID(getCtx()) || getC_DocTypeTarget_ID() == NonGSTConsolidatedOrderDocType_ID(getCtx())) {
			
			if(getInvoiceNo() != null)
				invoice.setDocumentNo(getInvoiceNo());
			//invoice.setDocumentNo(weighment.getInvoiceNo());
		}*/
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));		
		
		invoice.setC_PaymentTerm_ID(getC_PaymentTerm_ID());
		//
		invoice.setC_Ship_Location_ID(getC_Ship_Location_ID());
		invoice.setBPartner(bp);	
		invoice.setOrder(this);
		invoice.setVehicleNo(getVehicleNo());
		invoice.setDescription(getDescription());
		invoice.setPaymentRule(getPaymentRule());
		//Price List
				
		
		invoice.setM_PriceList_ID(getM_PriceList_ID());
		invoice.setC_Currency_ID(getC_Currency_ID());
		
		//Financial Dimension - Profit Center		
		//invoice.setC_Project_ID(counterProj.getC_Project_ID());
		invoice.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
		
		invoice.setPOReference(getPOReference());
		invoice.setPODate(getPODate());
		invoice.seteWayBillNo(geteWayBillNo());
		invoice.seteWayDate(geteWayDate());
		invoice.setReverseCharge(isReverseCharge());
		invoice.setIsInterState(isInterState());
		invoice.setTermsAndCondition(getTermsAndCondition());
		invoice.saveEx();
		
		for(MOrderLine oLine : getLines() ) {
			//Create Invoice Line
			MInvoiceLine invLine = new MInvoiceLine(invoice);
			int M_Product_ID = oLine.getM_Product_ID();
			invLine.setM_Product_ID(M_Product_ID , true);
			invLine.setC_UOM_ID(oLine.getC_UOM_ID());
			invLine.setQty(oLine.getQtyOrdered());
			invLine.setPriceActual(oLine.getPriceActual());
			invLine.setPriceList(oLine.getPriceList());
			invLine.setPriceLimit(oLine.getPriceLimit());
			invLine.setPriceEntered(oLine.getPriceEntered());		
			invLine.setC_Tax_ID(oLine.getC_Tax_ID());
			invLine.setDescription(oLine.getDescription());
			invLine.setC_Project_ID(getC_Project_ID());
			if(oLine.getPriceEntered().doubleValue() == 0) {
				throw new AdempiereException("Invalid Price at Line: " + oLine.getLine() + " for Product Name : " + oLine.getM_Product().getName());
			}
			
			invLine.setM_InOutLine_ID(weighment.getM_InOutLine_ID(invLine.getM_Product_ID()));
			
			invLine.saveEx();
		}
		
		if(getInvoiceNo() == null)
			setInvoiceNo(invoice.getDocumentNo());
		
		//Invoice DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
	}
	
	public void completeWeighmentEntriesForConsolidateInvoice() {
		if(getTF_WeighmentEntry_ID() > 0)
			return;
		
		//String whereClause = " TF_WeighmentEntry_ID IN (SELECT i.TF_WeighmentEntry_ID FROM M_InOut i WHERE i.C_Order_ID = ? ) AND Processed = 'Y' AND Status='CO'";
		String whereClause = " C_Order_ID = ? AND Status='CO'";
	

		List<MWeighmentEntry> wEntries = new Query(getCtx(), MWeighmentEntry.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getC_Order_ID())
				.list();
		for(MWeighmentEntry we : wEntries) {
			we.close();
			we.saveEx();
		}
	}

	public void reverseConsolidateInvoice(boolean reactivate) {	
		if(getTF_WeighmentEntry_ID() > 0 || getC_DocTypeTarget_ID() == getC_TransporterInvoiceDocType_ID() || getC_DocTypeTarget_ID() == getC_ServiceInvoiceDocType_ID())
			return;
		
		//String whereClause = " TF_WeighmentEntry_ID IN (SELECT i.TF_WeighmentEntry_ID FROM M_InOut i WHERE i.C_Order_ID = ? ) AND Processed = 'Y' AND Status='CL'";
		
		String whereClause = " C_Order_ID = ? AND Status='CL'";
		List<MWeighmentEntry> wEntries = new Query(getCtx(), MWeighmentEntry.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getC_Order_ID())
				.list();
		for(MWeighmentEntry we : wEntries) {
			if(!reactivate)
				we.setC_Order_ID(0);
			
			we.reverse();
			we.saveEx();
		}
		
		String sqlUpdate = "UPDATE M_InOut SET C_Order_ID = NULL WHERE C_Order_ID = " + getC_Order_ID();
		DB.executeUpdate(sqlUpdate, get_TrxName());
	}
	
	public void createTransportMaterialReceipt() {
		if(getTF_RentedVehicle_ID() == 0)
			return;
		
		MRentedVehicle rv = new MRentedVehicle(getCtx(), getTF_RentedVehicle_ID(), get_TrxName());
		if(rv.isOwnVehicle() || !rv.isTransporter())
			return;
				
		MDestination dest = new MDestination(getCtx(), getTF_Destination_ID(), get_TrxName());
		TF_MBPartner bp = new TF_MBPartner(getCtx(), rv.getC_BPartner_ID(), get_TrxName());
		
		TF_MInOut inout = new TF_MInOut(getCtx(), 0, get_TrxName());
		inout.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());		
		
		inout.setC_DocType_ID(MGLPostingConfig.getMGLPostingConfig(getCtx()).getMaterialReceipt_DocType_ID());
		inout.setMovementType(MInOut.MOVEMENTTYPE_VendorReceipts);
		inout.setDateAcct(getDateAcct());		
		inout.setC_BPartner_ID(rv.getC_BPartner_ID());
		inout.setC_BPartner_Location_ID(bp.getPrimaryC_BPartner_Location_ID());
		inout.setAD_User_ID(bp.getAD_User_ID());
		inout.setM_Warehouse_ID(getM_Warehouse_ID());
		inout.setPriorityRule(TF_MInOut.PRIORITYRULE_Medium);
		inout.setFreightCostRule(TF_MInOut.FREIGHTCOSTRULE_FreightIncluded);
		inout.saveEx(get_TrxName());
		
		//Material Receipt Line
		MInOutLine ioLine = new MInOutLine(inout);
		MWarehouse wh = (MWarehouse) getM_Warehouse();
		
		ioLine.setLine(10);
		ioLine.setM_Product_ID(rv.getM_Product_ID());
		ioLine.setM_Locator_ID(wh.getDefaultLocator().get_ID());
		
		
		int Rent_UOM_ID = 0;
		BigDecimal qty = BigDecimal.ZERO;
		BigDecimal price = BigDecimal.ZERO;		
					
		//Setting correct UOM for Vehicle Rent
		if(!isLumpSumRent() && 
				getRate().multiply(getTonnage()).multiply(getDistance()).doubleValue() == getRent_Amt().doubleValue()) {
			qty = getDistance();
			price = getRate().multiply(getTonnage());			
			if(isSOTrx()) {
				price = getRentPayable().divide(getDistance(), 2, RoundingMode.HALF_UP);
				//rate = price.divide(getTonnage(), 2, RoundingMode.HALF_UP);
			}
			Rent_UOM_ID = MSysConfig.getIntValue("KM_UOM", 1000071, getAD_Client_ID());		
			
		}
		else if(getRate().multiply(getTonnage()).doubleValue() == getRent_Amt().doubleValue() ) {
			Rent_UOM_ID = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, getAD_Client_ID());			
			qty = getTonnage();
			price = getRate();
			if(isSOTrx()) {
				price = getRentPayable().divide(getTonnage(), 2, RoundingMode.HALF_EVEN);
			}			
		}
		else if(getRate().multiply(getDistance()).doubleValue() == getRent_Amt().doubleValue() ) {
			Rent_UOM_ID = MSysConfig.getIntValue("KM_UOM", 1000071, getAD_Client_ID());			
			qty = getDistance();
			price = getRate();
			if(isSOTrx()) {
				price = getRentPayable().divide(getTonnage(), 2, RoundingMode.HALF_EVEN);
			}			
			//hdrDescription = hdrDescription + ", Tonnage : " + getTonnage().doubleValue();
		}
		else {
			Rent_UOM_ID = MSysConfig.getIntValue("LOAD_UOM", 1000072, getAD_Client_ID());			
			qty = BigDecimal.ONE;
			price = getRent_Amt();
			if(isSOTrx()) {
				price = getRentPayable();
			}			
		}
		
		ioLine.setQty(qty);
		ioLine.setC_UOM_ID(Rent_UOM_ID);
		ioLine.set_ValueOfColumn("Price", price);
		ioLine.setDescription("Destination : " + dest.getName());		
		ioLine.saveEx(get_TrxName());
		
		//Material Receipt DocAction
		if (!inout.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + inout.getProcessMsg());
		
		inout.saveEx();
	}
	
	public void reverseTransportMaterialReceipt() {
		String whereClause = "TF_WeighmentEntry_ID = ? AND MovementType = ? AND DocStatus = 'CO'";
		List<TF_MInOut> list = new Query(getCtx(), TF_MInOut.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_WeighmentEntry_ID(), MInOut.MOVEMENTTYPE_VendorReceipts)
				.list();
		for(TF_MInOut io : list) {
			if(io.getDocStatus().equals(DOCSTATUS_Completed))
				io.reverseCorrectIt();
			io.saveEx();
		}
	}
	
	public List<TF_MInvoice> getTFInvoices() {
		String whereClause = "C_Order_ID = ? AND DocStatus IN ('CO','CL')";
		List<TF_MInvoice> list = new Query(getCtx(), TF_MInvoice.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getC_Order_ID())
				.list();
		return list;
	}
	
	public static int getC_TransporterInvoiceDocType_ID() {
		int DocType_ID = MSysConfig.getIntValue("TRANSPORTER_INVOICE_ORDER_ID", 1000064, Env.getAD_Client_ID(Env.getCtx()));
		return DocType_ID;
	}
	
	public static int getC_ServiceInvoiceDocType_ID() {
		int DocType_ID = MSysConfig.getIntValue("SERVICE_ORDER_ID", 1000068, Env.getAD_Client_ID(Env.getCtx()));
		return DocType_ID;
	}
	
	public int getC_VendorInvoiceDocType_ID() {
		int DocType_ID = MSysConfig.getIntValue("VENDORINVOICE_ORDER_ID", 1000061, Env.getAD_Client_ID(getCtx()));
		return DocType_ID;
	}
	
	public void createInvoiceVendor() {
		MDocType dt = (MDocType) getC_DocTypeTarget();
		String DocSubTypeSO = dt.getDocSubTypeSO();
		
		if(DocSubTypeSO == null || (!DocSubTypeSO.equals("IN") && !DocSubTypeSO.equals("SI")))
			return;
							
		if(isSOTrx())
			return;
		
		//Invoice Header
		TF_MBPartner bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
		
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setC_Order_ID(getC_Order_ID());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(getC_DocTypeTarget().getC_DocTypeInvoice_ID());	// Counter Doc
		invoice.setIsSOTrx(isSOTrx());
		invoice.setDateInvoiced(getDateAcct());
		invoice.setDateAcct(getDateAcct());
		
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));		
		
		invoice.setC_PaymentTerm_ID(getC_PaymentTerm_ID());
		//
		
		invoice.setBPartner(bp);				
		invoice.setVehicleNo(getVehicleNo());
		invoice.setDescription(getDescription());
		invoice.setPaymentRule(getPaymentRule());
		//Price List
				
		
		invoice.setM_PriceList_ID(getM_PriceList_ID());
		invoice.setC_Currency_ID(getC_Currency_ID());
		
		//Financial Dimension - Profit Center		
		//invoice.setC_Project_ID(counterProj.getC_Project_ID());
		invoice.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
		
		if(getTF_WeighmentEntry_ID() > 0) {
			MWeighmentEntry we = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
			
			if(we.getInvoiceNo() != null) {
				invoice.setDocumentNo(we.getInvoiceNo());
			}
			else {
				invoice.setDocumentNo(we.getDocumentNo());
			}
		}
		invoice.saveEx();
		
		for(MOrderLine oLine : getLines() ) {
			//Create Invoice Line
			MInvoiceLine invLine = new MInvoiceLine(invoice);
			int M_Product_ID = oLine.getM_Product_ID();
			invLine.setM_Product_ID(M_Product_ID , true);
			invLine.setC_UOM_ID(oLine.getC_UOM_ID());
			invLine.setQty(oLine.getQtyOrdered());
			invLine.setPriceActual(oLine.getPriceActual());
			invLine.setPriceList(oLine.getPriceList());
			invLine.setPriceLimit(oLine.getPriceLimit());
			invLine.setPriceEntered(oLine.getPriceEntered());		
			invLine.setC_Tax_ID(oLine.getC_Tax_ID());
			invLine.setDescription(oLine.getDescription());
			invLine.setC_Project_ID(getC_Project_ID());
			invLine.setC_OrderLine_ID(oLine.getC_OrderLine_ID());
			if(oLine.getPriceEntered().doubleValue() == 0) {
				throw new AdempiereException("Invalid Price at Line: " + oLine.getLine() + " for Product Name : " + oLine.getM_Product().getName());
			}			
			invLine.saveEx();
		}
		
		//Invoice DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
	}
	
	private void reverseTransportReceiptStatus() {
		String whereClause = " C_OrderLIne_ID IN (SELECT C_OrderLine.C_OrderLine_ID FROM C_OrderLine WHERE C_OrderLine.C_Order_ID = ?)";
		List<TF_MInOutLine> ioLists = new Query(getCtx(), TF_MInOutLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getC_Order_ID())
				.list();
		for(TF_MInOutLine ioLine : ioLists) {
			ioLine.set_ValueOfColumn("DocStatus", MWeighmentEntry.STATUS_Unbilled);
			ioLine.setC_OrderLine_ID(0);
			ioLine.saveEx();
		}
	}
	
	private void reverseWeighmentEntries() {
		String whereClause = " C_Order_ID = ?";
		List<TF_MInOut> ioLists = new Query(getCtx(), TF_MInOut.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getC_Order_ID())
				.list();
		for(TF_MInOut io : ioLists) {
			MWeighmentEntry we = new MWeighmentEntry(getCtx(), io.getTF_WeighmentEntry_ID(), get_TrxName());
			
			we.setStatus(MWeighmentEntry.STATUS_Unbilled);
			we.saveEx();
			
			io.setC_Order_ID(0);
			io.saveEx();
		}
	}
	
	public void postMixedPayment() {
		if(!isSOTrx())
			return;
		
		if(getC_DocTypeTarget_ID() != TF_MOrder.GSTOrderDocType_ID(getCtx()) &&
				getC_DocTypeTarget_ID() != TF_MOrder.NonGSTOrderDocType_ID(getCtx()) && 
				getC_DocTypeTarget_ID() != TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx()) && 
				getC_DocTypeTarget_ID() != TF_MOrder.NonGSTConsolidatedOrderDocType_ID(getCtx()))
			return;
		
		if(getTF_WeighmentEntry_ID() == 0)
			return;
		
		MWeighmentEntry we = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
		List<MWeighmentPayment> list = we.getPayments();
		for(MWeighmentPayment p : list) {
			MPOSPayment pos =  MPOSPayment.createPOSPayment(getCtx(), getAD_Org_ID(), getC_Order_ID(), p.getTenderType(), p.getAmount(), get_TrxName());
			pos.processIt();
			pos.saveEx();
		}
		
	}
	
	public void reverseMixedPayment() {
		if(!isSOTrx())
			return;
		MPOSPayment.reversePayments(getCtx(), getC_Order_ID(), get_TrxName());		
		
	}
	
	public void validateInvoiceDate() {
		if(getInvoiceNo() == null) {
			int inv_DocType_ID = getC_DocTypeTarget().getC_DocTypeInvoice_ID();
			//Invoice should be greater than or equal to running/latest invoice date.
			String whereClause = "AD_Org_ID = ? AND DocStatus = 'CO' AND DateAcct > ? AND C_DocTypeTarget_ID = ?";
			TF_MInvoice latestInv = new Query(getCtx(), TF_MInvoice.Table_Name, whereClause, get_TrxName())
					.setClient_ID()
					.setParameters(getAD_Org_ID(), getDateOrdered(), inv_DocType_ID)
					.first();
			
			if(latestInv != null) {
				String datestring = new SimpleDateFormat("dd/MM/yyyy").format(latestInv.getDateAcct());
				throw new AdempiereException("Current Invoice Date : " + datestring + ". So, please do not enter old invoice date!");
			}
		}
	}
	
public void postDriverSalary() {
		
		MWeighmentEntry we = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
		
		if(we.getC_BPDriver_ID() == 0)
			return;
		
		MRentedVehicle rv=new MRentedVehicle(getCtx(), getTF_RentedVehicle_ID(), get_TrxName());
		MDestination dest = new MDestination(getCtx(), we.getTF_Destination_ID(), get_TrxName());
		
		if(dest.getDistance().doubleValue() == 0)
			throw new AdempiereException("Please configure distance for Destination - " + dest.getName());
		
		MVehicleType vType=new MVehicleType(getCtx(), rv.getTF_VehicleType_ID(), get_TrxName());
		BigDecimal Wage=vType.getWage(getDateAcct(), dest.getDistance());
		
		if(Wage.doubleValue() == 0)
			throw new AdempiereException("Please configure Wage for Driver salary " + getDocumentNo());
		
		
		MEmployeeSalaryOld salary = new MEmployeeSalaryOld(getCtx(), 0, get_TrxName());
		
		salary.setAD_Org_ID(getAD_Org_ID());
		salary.setDateAcct(getDateAcct());
		salary.setPresent_Days(BigDecimal.ONE);
		salary.setC_BPartner_ID(we.getC_BPDriver_ID());				
		salary.setSalary_Amt(Wage);
		salary.setIncentive(BigDecimal.ZERO);
		salary.setDescription(getDocumentNo());
		salary.setDocStatus(MEmployeeSalaryOld.DOCSTATUS_Drafted);
		salary.setC_Order_ID(getC_Order_ID());	
		salary.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
		salary.saveEx();
		
		salary.processIt(DocAction.ACTION_Complete);
		salary.saveEx();
	}
	
	public void reverseDriverSalary() {
		String whereClause = "C_Order_ID = ? AND DocStatus = 'CO'";
		MEmployeeSalaryOld salary = new Query(getCtx(), MEmployeeSalaryOld.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getC_Order_ID())
				.first();
		if(salary != null) {
			salary.reverseIt();
			salary.deleteEx(true);
		}
			
	}
}
