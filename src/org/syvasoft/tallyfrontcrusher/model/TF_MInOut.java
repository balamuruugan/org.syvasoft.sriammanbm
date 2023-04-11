package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrder;
import org.compiere.model.MPeriod;
import org.compiere.model.MProduct;
import org.compiere.model.MRMA;
import org.compiere.model.MSysConfig;
import org.compiere.model.MWarehouse;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.Env;
import org.compiere.util.Msg;


public class TF_MInOut extends MInOut {

	/**
	 * 
	 */
	private static final long serialVersionUID = -662134145363709054L;

	public TF_MInOut(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MInOut(Properties ctx, int M_InOut_ID, String trxName) {
		super(ctx, M_InOut_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	

	public TF_MInOut (MOrder order, int C_DocTypeShipment_ID, Timestamp movementDate)
	{
		super(order, C_DocTypeShipment_ID, movementDate);
	}
	
	/** Column name TF_WeighmentEntry_ID */
    public static final String COLUMNNAME_TF_WeighmentEntry_ID = "TF_WeighmentEntry_ID";
    
	/** Set TF_WeighmentEntry_ID.
		@param TF_WeighmentEntry_ID 
		Weighment Entry
	*/
	public void setTF_WeighmentEntry_ID (int TF_WeighmentEntry_ID)
	{
		if (TF_WeighmentEntry_ID < 1) 
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_WeighmentEntry_ID, Integer.valueOf(TF_WeighmentEntry_ID));
	}

	/** Get TF_WeighmentEntry_ID.
		@return TF_WeighmentEntry_ID
	  */
	public int getTF_WeighmentEntry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_WeighmentEntry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	boolean createConsolidatedTransportInvoice = MSysConfig.getBooleanValue("CONSOLIDATED_TRANSPORT_INVOICE_ENABLED", true , getAD_Client_ID(), getAD_Org_ID());
	
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

	public boolean materialReceipt = true;
	public boolean stopRecursive = false;
	/**
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

		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());

		//  Order OR RMA can be processed on a shipment/receipt
		if (getC_Order_ID() != 0 && getM_RMA_ID() != 0)
		{
		    m_processMsg = "@OrderOrRMA@";
		    return DocAction.STATUS_Invalid;
		}
		//	Std Period open?
		if (!MPeriod.isOpen(getCtx(), getDateAcct(), dt.getDocBaseType(), getAD_Org_ID()))
		{
			m_processMsg = "@PeriodClosed@";
			return DocAction.STATUS_Invalid;
		}

		/*
		//	Credit Check		if (isSOTrx() && !isReversal())
		{
			
			I_C_Order order = getC_Order();
			if (order != null && MDocType.DOCSUBTYPESO_PrepayOrder.equals(order.getC_DocType().getDocSubTypeSO())
					&& !MSysConfig.getBooleanValue(MSysConfig.CHECK_CREDIT_ON_PREPAY_ORDER, true, getAD_Client_ID(), getAD_Org_ID())) {
				// ignore -- don't validate Prepay Orders depending on sysconfig parameter
			} else {
				MBPartner bp = new MBPartner (getCtx(), getC_BPartner_ID(), get_TrxName());
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
				if (!MBPartner.SOCREDITSTATUS_NoCreditCheck.equals(bp.getSOCreditStatus())
						&& Env.ZERO.compareTo(bp.getSO_CreditLimit()) != 0)
				{
					BigDecimal notInvoicedAmt = MBPartner.getNotInvoicedAmt(getC_BPartner_ID());
					if (MBPartner.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus(notInvoicedAmt)))
					{
						m_processMsg = "@BPartnerOverSCreditHold@ - @TotalOpenBalance@="
							+ bp.getTotalOpenBalance() + ", @NotInvoicedAmt@=" + notInvoicedAmt
							+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
						return DocAction.STATUS_Invalid;
					}
				}
			}
		}*/
		
		
		//	Lines
		MInOutLine[] lines = getLines(true);
		if (lines == null || lines.length == 0)
		{
			m_processMsg = "@NoLines@";
			return DocAction.STATUS_Invalid;
		}
		BigDecimal Volume = Env.ZERO;
		BigDecimal Weight = Env.ZERO;

		//	Mandatory Attributes
		for (int i = 0; i < lines.length; i++)
		{
			MInOutLine line = lines[i];
			MProduct product = line.getProduct();
			if (product != null)
			{
				Volume = Volume.add(product.getVolume().multiply(line.getMovementQty()));
				Weight = Weight.add(product.getWeight().multiply(line.getMovementQty()));
			}
			//
			if (line.getM_AttributeSetInstance_ID() != 0)
				continue;
			if (product != null && product.isASIMandatory(isSOTrx()))
			{
				if (product.getAttributeSet() != null && !product.getAttributeSet().excludeTableEntry(MInOutLine.Table_ID, isSOTrx())) {
					m_processMsg = "@M_AttributeSet_ID@ @IsMandatory@ (@Line@ #" + lines[i].getLine() +
									", @M_Product_ID@=" + product.getValue() + ")";
					return DocAction.STATUS_Invalid;
				}
			}
		}
		setVolume(Volume);
		setWeight(Weight);

		if (!isReversal())	//	don't change reversal
		{
			createConfirmation();
		}

		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;

		m_justPrepared = true;
		if (!DOCACTION_Complete.equals(getDocAction()))
			setDocAction(DOCACTION_Complete);
		return DocAction.STATUS_InProgress;
	}	//	prepareIt
	
	public TF_MInOutLine getRawmaterialLine() {
		if(isSOTrx())
			return null;
		int Boulder_ID = MSysConfig.getIntValue("BOULDER_ID", 1018390, getAD_Client_ID(), getAD_Org_ID());
		String whereClause = "M_InOut_ID = ? AND M_Product_ID = ?";
		return new Query(getCtx(), TF_MInOutLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getM_InOut_ID(), Boulder_ID)
				.first();
	}
	
	@Override
	public String completeIt() {
		
		MWeighmentEntry we = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
		
		if(getTF_WeighmentEntry_ID() > 0) {			
			
			if(we.getWeighmentEntryType().equals(MWeighmentEntry.WEIGHMENTENTRYTYPE_Sales) && isSOTrx())
				we.shipped();
			else if(!we.getWeighmentEntryType().equals(MWeighmentEntry.WEIGHMENTENTRYTYPE_Sales) && !isSOTrx() )
				we.shipped();			
			
			we.saveEx();
			
			if(createConsolidatedTransportInvoice)
				createTransportMaterialReceipt();
			
			TF_MInOutLine ioLine = getRawmaterialLine();
			if(getC_DocType_ID() == we.getC_DocTypeShipment_ID() || ioLine != null) {
				
				createMaterialMovement(we, ioLine);
				m_processMsg = postCrusherProduction(we, ioLine);
			}			
		}
		String error = super.completeIt();
		// TODO Auto-generated method stub
		
		if(getTF_WeighmentEntry_ID() > 0) {			
			if(isSOTrx() && getC_DocType_ID() == 1000055)
				updateDispenseQty(we, false);
		}
		
		return error;
	}
	
	@Override
	public boolean reverseCorrectIt() {
		
		MWeighmentEntry we = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
		
		if(getTF_WeighmentEntry_ID() >0) {			
			
			if(we.getWeighmentEntryType().equals(MWeighmentEntry.WEIGHMENTENTRYTYPE_Sales) && isSOTrx())
				we.reverseShipped();
			else if(!we.getWeighmentEntryType().equals(MWeighmentEntry.WEIGHMENTENTRYTYPE_Sales) && !isSOTrx() )
				we.reverseShipped();				
			we.saveEx();
			
			if(isSOTrx() && getC_DocType_ID() == 1000055)
				updateDispenseQty(we, true);
			
			reverseTransportMaterialReceipt();
			reverseServiceInvoiceOrder();
		}
		
		MSubcontractMaterialMovement.deleteWeighmentMovement(getTF_WeighmentEntry_ID(), get_TrxName());
		MBoulderMovement.deleteByOrder(getC_Order_ID(), get_TrxName());
		MBoulderMovement.deleteBoulderMovement(getTF_WeighmentEntry_ID(), get_TrxName());
		
		if(getTF_Crusher_Production_ID() > 0) {
			MCrusherProduction crProd = new MCrusherProduction(getCtx(), getTF_Crusher_Production_ID(), get_TrxName());
			crProd.reverseIt();
			crProd.saveEx();
			setTF_Crusher_Production_ID(0);
		}
		reverseFuelIssue();
		boolean error = super.reverseCorrectIt();
		// TODO Auto-generated method stub
		
		return error;
	}
	
	public void createTransportMaterialReceipt() {
		
		int No_Tax_ID = MSysConfig.getIntValue("NO_TAX_ID", 1000033, getAD_Client_ID(), getAD_Org_ID());
		
		MWeighmentEntry we = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
				
		if(we.getWeighmentEntryType().equals(MWeighmentEntry.WEIGHMENTENTRYTYPE_OwnProductionReceipt) || we.getWeighmentEntryType().equals(MWeighmentEntry.WEIGHMENTENTRYTYPE_SubcontractProductionReceipt))
			return;
		
		if(we.getTF_RentedVehicle_ID() == 0)
			return;
		
		MRentedVehicle rv = new MRentedVehicle(getCtx(), we.getTF_RentedVehicle_ID(), get_TrxName());
		if(rv.isOwnVehicle() || !rv.isTransporter())
			return;
		
		if(rv.isTransporter() && we.isCustomerTransporter())
			return;
		
		//Don't Create Material Receipt for the same Transporter
		//It stops the recursive loop
		if(isSOTrx() && (rv.getC_BPartner_ID() == getC_BPartner_ID()))
			return;
		
		if(!isSOTrx() && we.isRentInclusive())
			return;
		
		MDocType dt = new MDocType(getCtx(), we.getTransporterInvoiceDocType_ID(), get_TrxName());
		
		if(getC_DocType_ID() == dt.getC_DocTypeShipment_ID())
			return;
		
		MDestination dest = new MDestination(getCtx(), we.getTF_Destination_ID(), get_TrxName());
		TF_MBPartner bp = new TF_MBPartner(getCtx(), rv.getC_BPartner_ID(), get_TrxName());
		
		TF_MInOut inout = new TF_MInOut(getCtx(), 0, get_TrxName());
		inout.materialReceipt = false;
		inout.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());		
		inout.setIsSOTrx(false);
		inout.setC_DocType_ID(dt.getC_DocTypeShipment_ID());
		inout.setMovementType(MInOut.MOVEMENTTYPE_VendorReceipts);		
		inout.setDateAcct(getDateAcct());
		inout.setMovementDate(getDateAcct());
		inout.setC_BPartner_ID(rv.getC_BPartner_ID());
		inout.setC_BPartner_Location_ID(bp.getPrimaryC_BPartner_Location_ID());
		inout.setAD_User_ID(bp.getAD_User_ID());
		inout.setM_Warehouse_ID(getM_Warehouse_ID());
		inout.setPriorityRule(TF_MInOut.PRIORITYRULE_Medium);
		inout.setFreightCostRule(TF_MInOut.FREIGHTCOSTRULE_FreightIncluded);
		inout.saveEx(get_TrxName());
		
		//Material Receipt Line
		TF_MInOutLine ioLine = new TF_MInOutLine(inout);
		MWarehouse wh = (MWarehouse) getM_Warehouse();
		
		ioLine.setLine(10);
		ioLine.setM_Product_ID(rv.getM_Product_ID());
		ioLine.setM_Locator_ID(wh.getDefaultLocator().get_ID());
		
		
		int Rent_UOM_ID = 0;
		BigDecimal qty = BigDecimal.ZERO;
		BigDecimal price = BigDecimal.ZERO;		
		BigDecimal rentMargin = BigDecimal.ZERO;
		
		int Load_UOM_ID = MSysConfig.getIntValue("LOAD_UOM", 1000072, we.getAD_Client_ID());
		int KM_UOM_ID = MSysConfig.getIntValue("KM_UOM", 1000071, we.getAD_Client_ID());
		int MT_KM_UOM_ID = MSysConfig.getIntValue("MT_KM_UOM", 1000093, we.getAD_Client_ID());
		int MT_UOM = MSysConfig.getIntValue("MT_UOM", 1000069, we.getAD_Client_ID());
		
		BigDecimal RateMTKM = BigDecimal.ZERO;
		BigDecimal Distance = BigDecimal.ZERO;
		//Get Vehicle Rent from Shipment Line
		String whereClause = "M_InOut_ID = ? AND M_Product_ID = ? ";
		TF_MInOutLine srcLine = new Query(getCtx(), TF_MInOutLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getM_InOut_ID(), rv.getM_Product_ID())
				.first();
		
		boolean ENABLE_TRANSPORTER_RENT_CONFIG = MSysConfig.getBooleanValue("ENABLE_TRANSPORTER_RENT_CONFIG", false, Env.getAD_Client_ID(getCtx()));
		
		if(isSOTrx()) {
			
			if(ENABLE_TRANSPORTER_RENT_CONFIG) {
				MLumpSumRentConfig lumpsumConfig = MLumpSumRentConfig.getFreightConfig(getCtx(), we.getAD_Org_ID(), we.getTransporter_ID(), we.getC_BPartner_ID(), we.getM_Product_ID(), 
						we.getTF_Destination_ID(), we.getTF_VehicleType_ID(), dest.getDistance(), get_TrxName(),"Y");
				
				if(lumpsumConfig != null) {
					//ioLine.set_ValueOfColumn("FreightRule", we.getFreightRule());
					price = lumpsumConfig.getCustomerFreightPrice(we.getC_BPartner_ID());
					
					if(lumpsumConfig.getC_UOM_ID() == Load_UOM_ID)
					{
						Rent_UOM_ID = Load_UOM_ID;
						qty = BigDecimal.ONE;
						
					}
					else if(lumpsumConfig.getC_UOM_ID() == KM_UOM_ID)
					{
						Rent_UOM_ID = KM_UOM_ID;
						qty = dest.getDistance();									
					}
					else if(lumpsumConfig.getC_UOM_ID() == MT_KM_UOM_ID)
					{
						Rent_UOM_ID = MT_KM_UOM_ID;
						qty = we.getMT();									
						RateMTKM = price;
					}
					else if(lumpsumConfig.getC_UOM_ID() == MT_UOM)
					{
						Rent_UOM_ID = MT_UOM;
						qty = we.getMT();									
						RateMTKM = price;
					}
					else
					{
						Rent_UOM_ID = lumpsumConfig.getC_UOM_ID();
						
						if(Rent_UOM_ID == we.getC_UOM_ID())
							qty = we.getNetWeightUnit();
						else
							qty = BigDecimal.ZERO;
					}
					
				}
				else {
					Rent_UOM_ID = Load_UOM_ID;
					qty = BigDecimal.ONE;
					price = BigDecimal.ZERO;
				}
			}
			else {
				if(srcLine != null) {
					Rent_UOM_ID = srcLine.getC_UOM_ID();
					qty = srcLine.getQtyEntered();
					Object srcPrice = srcLine.get_Value("Price");
					if(srcPrice != null)
						price = (BigDecimal) srcPrice; 
					
					//put transporter freight charge without margin.
					if(srcLine.getTF_LumpSumRent_Config_ID() > 0) { 
						MLumpSumRentConfig rentConfig = new MLumpSumRentConfig(getCtx(), srcLine.getTF_LumpSumRent_Config_ID(), get_TrxName());
						price = rentConfig.getFreightPrice();
						
						ioLine.setC_Tax_ID(rentConfig.getC_Tax_ID());
						ioLine.setIsTaxIncluded(rentConfig.isTaxIncluded());
						ioLine.set_ValueOfColumn("TF_LumpSumRent_Config_ID", rentConfig.getTF_LumpSumRent_Config_ID());
					}			
					else {
						ioLine.setC_Tax_ID(No_Tax_ID);
					}
					RateMTKM = srcLine.getRateMTKM();
				}
				else {
					Rent_UOM_ID = we.getC_UOM_ID();
					qty = we.getNetWeightUnit();
				}
			}
			/*rentMargin = price.multiply(srcLine.getRentMargin().divide(new BigDecimal(100)));
			price = price.subtract(rentMargin);*/
			
			ioLine.setQty(qty);
			ioLine.setC_UOM_ID(Rent_UOM_ID);
			ioLine.setTF_Destination_ID(we.getTF_Destination_ID());
			ioLine.setDistance(dest.getDistance());
			ioLine.setRateMTKM(RateMTKM);
			ioLine.setPrice(price);
		}
		else
		{
			Rent_UOM_ID = we.getFreightRule_ID();
			
			if(we.getFreightRule_ID() == Load_UOM_ID)
			{
				Rent_UOM_ID = Load_UOM_ID;
				qty = BigDecimal.ONE;							
			}
			else if(we.getFreightRule_ID() == KM_UOM_ID)
			{
				Rent_UOM_ID = KM_UOM_ID;
				qty = dest.getDistance();							
			}
			else if(we.getFreightRule_ID() == MT_KM_UOM_ID)
			{
				Rent_UOM_ID = MT_KM_UOM_ID;
				qty = we.getMT();							
				RateMTKM =  price;
			}
			else if(we.getFreightRule_ID() == MT_UOM)
			{
				Rent_UOM_ID = MT_UOM;
				qty = we.getMT();									
				RateMTKM = price;
			}
			else
			{
				Rent_UOM_ID = we.getFreightRule_ID();
				qty = we.getNetWeightUnit();							
			}
			
			//put transporter freight charge without margin.
			if(we.getTF_LumpSumRent_Config_ID() > 0) { 
				MLumpSumRentConfig rentConfig = new MLumpSumRentConfig(getCtx(), we.getTF_LumpSumRent_Config_ID(), get_TrxName());
				price = rentConfig.getFreightPrice();
				
				ioLine.setC_Tax_ID(rentConfig.getC_Tax_ID());
				ioLine.setIsTaxIncluded(rentConfig.isTaxIncluded());
				ioLine.set_ValueOfColumn("TF_LumpSumRent_Config_ID", rentConfig.getTF_LumpSumRent_Config_ID());
			}			
			else {
				price = we.getFreightPrice();
				ioLine.setC_Tax_ID(No_Tax_ID);
			}
			
			ioLine.setQty(qty);
			ioLine.setC_UOM_ID(Rent_UOM_ID);
			ioLine.setTF_Destination_ID(we.getTF_Destination_ID());
			ioLine.setDistance(dest.getDistance());
			ioLine.setRateMTKM(RateMTKM);
			ioLine.setPrice(price);
			
		}
		
		ioLine.set_ValueOfColumn("DocStatus", MWeighmentEntry.STATUS_Unbilled);
		if(we.getTF_Destination_ID() > 0)
			ioLine.setDescription("Destination : " + dest.getName());		
		ioLine.saveEx(get_TrxName());
		
		//Material Receipt DocAction
		if (!inout.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + inout.getProcessMsg());
		
		inout.saveEx();
	}
	
	public void reverseFuelIssue() {
		List<TF_MInOutLine> inoutines = new Query(getCtx(), TF_MInOutLine.Table_Name, " M_InOut_ID = " + getM_InOut_ID(), get_TrxName()).list();
		
		for(TF_MInOutLine inoutline : inoutines) {
			if(inoutline.getTF_Fuel_Issue_ID() > 0) {
				MFuelIssue fissue = new MFuelIssue(getCtx(), inoutline.getTF_Fuel_Issue_ID(), get_TrxName());
				if(fissue.getDocStatus().equals(DOCSTATUS_Completed)) {
					fissue.reverseIt();
					fissue.setDocStatus(MFuelIssue.DOCSTATUS_Voided);
					fissue.setProcessing(true);
					fissue.saveEx();
				}
				inoutline.setTF_Fuel_Issue_ID(0);
				inoutline.saveEx();
				
			}
		}
	}
	public void reverseTransportMaterialReceipt() {
		MWeighmentEntry we = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
		
		if(we.getTF_RentedVehicle_ID() == 0)
			return;
		
		MRentedVehicle rv = new MRentedVehicle(getCtx(), we.getTF_RentedVehicle_ID(), get_TrxName());
		if(rv.isOwnVehicle() || !rv.isTransporter())
			return;
		
		//Don't reverse Material Receipt for other than Transporters
		//It stops the recursive loop
		if(rv.getC_BPartner_ID() == getC_BPartner_ID())
			return;
		
		String whereClause = "TF_WeighmentEntry_ID = ? AND MovementType = ? AND DocStatus = 'CO' AND M_InOut_ID != ? ";
		List<TF_MInOut> list = new Query(getCtx(), TF_MInOut.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_WeighmentEntry_ID(), MInOut.MOVEMENTTYPE_VendorReceipts, getM_InOut_ID())
				.list();
		
		for(TF_MInOut io : list) {			
			{				
				String OnAccountValue = "N"; //(we.isPermitSales()) ? "Y" : "N";
				
				MDocType dt = new Query(getCtx(),MDocType.Table_Name,"OnAccount = '" + OnAccountValue + "' AND C_DocTypeShipment_ID = " + io.getC_DocType_ID() ,get_TrxName()).first();
				
				String where = " C_Order_ID = " + io.getC_Order_ID() + " AND DocStatus IN ('CL','CO') AND C_DocTypeTarget_ID = " + dt.getC_DocType_ID();
				List<TF_MOrder> porders = new Query(getCtx(), TF_MOrder.Table_Name, where, get_TrxName())
						.setClient_ID()
						.list();
				
				
				if(io.getDocStatus().equals(DOCSTATUS_Completed) && !stopRecursive) {
					io.stopRecursive = true;
					io.reverseCorrectIt();
				}
				io.saveEx();
				
				for(TF_MOrder purchase : porders) {				
					purchase.setDocAction(DocAction.ACTION_Void);
					purchase.voidIt();
					purchase.setDocStatus(TF_MOrder.DOCSTATUS_Voided);
					purchase.saveEx();
				}
			}
		}
	}
	
	public void reverseServiceInvoiceOrder() {					
		MWeighmentEntry we = new MWeighmentEntry(getCtx(), getTF_WeighmentEntry_ID(), get_TrxName());
		if(getC_DocType_ID() == MSysConfig.getIntValue("TRANSPORTER_RECEIPT_ID",1000077) ||
				getC_DocType_ID() == MSysConfig.getIntValue("SERVICE_RECEIPT_ID",1000078)) {
			
			String OnAccountValue = "N"; //(we.isPermitSales()) ? "Y" : "N";
			
			MDocType dt = new Query(getCtx(),MDocType.Table_Name,"OnAccount = '" + OnAccountValue + "' AND C_DocTypeShipment_ID = " + getC_DocType_ID() ,get_TrxName()).first();
			
			String where = " C_Order_ID = " + getC_Order_ID() + " AND DocStatus IN ('CL','CO') AND C_DocTypeTarget_ID = " + dt.getC_DocType_ID();
			List<TF_MOrder> porders = new Query(getCtx(), TF_MOrder.Table_Name, where, get_TrxName())
					.setClient_ID()
					.list();
			
			for(TF_MOrder purchase : porders) {				
				purchase.setDocAction(DocAction.ACTION_Void);
				purchase.voidIt();
				purchase.setDocStatus(TF_MOrder.DOCSTATUS_Voided);
				purchase.saveEx();
			}
		}
	}
	
	public void createMaterialMovement(MWeighmentEntry wEntry, TF_MInOutLine io) {		
		if(!materialReceipt)
			return;
		TF_MProduct product = new TF_MProduct(getCtx(), wEntry.getM_Product_ID(), get_TrxName());
		//int BoulderID = MSysConfig.getIntValue("BOULDER_ID", 1000233, getAD_Client_ID(), getAD_Org_ID());
		if(!isSOTrx()) {
			if(product.isGenerateMovementRecord() && MWeighmentEntry.TF_SEND_TO_Production.equals(wEntry.getTF_Send_To())) {
				MSubcontractMaterialMovement.createRawmaterialMovement(get_TrxName(), getDateAcct(), getAD_Org_ID(),				
						0, 0, product.getM_Product_ID(), getTF_WeighmentEntry_ID(), 0, wEntry.getMovementQty());
			}
			else if(product.isGenerateMovementRecord() && MWeighmentEntry.TF_SEND_TO_Stock.equals(wEntry.getTF_Send_To())) {
				MBoulderMovement.createBoulderReceipt(get_TrxName(), getDateAcct(), getAD_Org_ID(), product.getM_Product_ID(), wEntry.getMovementQty(), getTF_WeighmentEntry_ID(), getM_Warehouse_ID(), 0, getC_Order_ID());
			}
		}
		else {
			int BoulderID = MSysConfig.getIntValue("BOULDER_ID", 1000233, getAD_Client_ID(), getAD_Org_ID());
			//MProduct rm = MProduct.get(getCtx(), BoulderID);
			TF_MProduct p = new TF_MProduct(getCtx(), wEntry.getM_Product_ID(), get_TrxName());
			//Need to add support for CFT sales and the resepctive MT material movement.
			if(wEntry.getM_Product_ID() != BoulderID) {				
				//TF_MProductCategory pc = new TF_MProductCategory(getCtx(), wEntry.getM_Product().getM_Product_Category_ID(), get_TrxName());
				
				if(p.isGenerateMovementRecord())
					MSubcontractMaterialMovement.createMaterialMovement(get_TrxName(), getDateAcct(), getAD_Org_ID(), getC_Order_ID(), 
							getC_BPartner_ID(), wEntry.getM_Product_ID(), wEntry.getMovementQty(), getTF_WeighmentEntry_ID());
			}
			else if(p.isGenerateMovementRecord() && wEntry.getM_Product_ID() == BoulderID && getTF_WeighmentEntry_ID() > 0) {
				MBoulderMovement.createBoulderIssue(get_TrxName(), getDateAcct(), getAD_Org_ID(), wEntry.getM_Product_ID(),
						wEntry.getMovementQty(), getTF_WeighmentEntry_ID(), getM_Warehouse_ID(), 0);
			}
		}
	}
	
	public String postCrusherProduction(MWeighmentEntry wEntry, TF_MInOutLine ioLIne) {
		
		if(wEntry.getTF_Send_To().equals(MWeighmentEntry.TF_SEND_TO_Stock))
			return null;
		
		String aggregateStockApproach = MSysConfig.getValue("AGGREGATE_STOCK_APPROACH","B", getAD_Client_ID(), getAD_Org_ID());
		int Boulder_ID = MSysConfig.getIntValue("BOULDER_ID",getAD_Client_ID(), getAD_Org_ID());
		
		TF_MProduct product = new TF_MProduct(getCtx(), wEntry.getM_Product_ID(), get_TrxName());
		
		if(aggregateStockApproach.equals("B") && isSOTrx() && product.isStocked() && Boulder_ID != wEntry.getM_Product_ID()) {
			
				MCrusherProduction cProd = new MCrusherProduction(getCtx(), 0, get_TrxName());
				MCrusherProductionConfig pConfig = MCrusherProductionConfig.getMCrusherProductionConfig(getCtx(), getAD_Org_ID(), "SO", wEntry.getM_Product_ID())[0];
				if(pConfig == null)
					return null;
				cProd.setAD_Org_ID(getAD_Org_ID());					
				cProd.setTF_BlueMetal_Type("SO");
				cProd.setTF_ProductionPlant_ID(pConfig.getTF_ProductionPlant_ID());
				cProd.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
				cProd.setMovementDate(getMovementDate());
				cProd.setC_UOM_ID(wEntry.getC_UOM_ID());		
				cProd.setM_Warehouse_ID(getM_Warehouse_ID());
				MWarehouse wh = MWarehouse.get(getCtx(), getM_Warehouse_ID());
				cProd.setM_Locator_ID(wh.getDefaultLocator().get_ID());
				cProd.setRM_Product_ID(Boulder_ID);
				cProd.setQtyUsed(wEntry.getNetWeightUnit());				
				cProd.setDocStatus(DOCSTATUS_Drafted);
				cProd.setDocAction(DOCACTION_Prepare);
				cProd.saveEx();
				
				//Update Crusher Production Reference to Material Receipt
				setTF_Crusher_Production_ID(cProd.getTF_Crusher_Production_ID());
				
				cProd.createProductionBySales(wEntry.getM_Product_ID());
				cProd.saveEx();		
				//End Create
				
				//Post Crusher Production
				m_processMsg = cProd.processIt(DOCACTION_Complete);
				if(m_processMsg == null)			
					cProd.saveEx();				
			
			}
		else if(!isSOTrx() && aggregateStockApproach.equals("O") && 
					product.isGenerateMovementRecord())  {
				TF_MOrder ord = new TF_MOrder(getCtx(), getC_Order_ID(), get_TrxName());
				BigDecimal prodQty = (wEntry != null ? wEntry.getNetWeightUnit() : ioLIne.getMovementQty()); 
				int M_ProductionPlant_ID = (wEntry != null ? wEntry.getTF_ProductionPlant_ID() : ord.getTF_ProductionPlant_ID());
				String BlueMetalType = (wEntry != null ? wEntry.getTF_BlueMetal_Type() : ord.getTF_BlueMetal_Type());
				String desc = (wEntry != null ? "DC : " + wEntry.getDocumentNo() : "Order: " + ord.getDocumentNo());
				
				
				//Create Crusher Production
				MCrusherProduction cProd = new MCrusherProduction(getCtx(), 0, get_TrxName());
				cProd.setAD_Org_ID(getAD_Org_ID());
				cProd.setTF_ProductionPlant_ID(M_ProductionPlant_ID);		
				cProd.setTF_BlueMetal_Type(BlueMetalType);
				cProd.setTF_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
				cProd.setMovementDate(getMovementDate());
				cProd.setC_UOM_ID(wEntry.getC_UOM_ID());		
				cProd.setM_Warehouse_ID(getM_Warehouse_ID());
				MWarehouse wh = MWarehouse.get(getCtx(), getM_Warehouse_ID());
				cProd.setM_Locator_ID(wh.getDefaultLocator().get_ID());
				cProd.setRM_Product_ID(wEntry.getM_Product_ID());
				cProd.setQtyUsed(prodQty);				
				cProd.setDescription("Order No" + getDocumentNo());
				cProd.setDocStatus(DOCSTATUS_Drafted);
				cProd.setDocAction(DOCACTION_Prepare);
				cProd.saveEx();
				
				//Update Crusher Production Reference to Material Receipt
				setTF_Crusher_Production_ID(cProd.getTF_Crusher_Production_ID());
				
				cProd.createProduction(true);
				cProd.saveEx();		
				//End Create
				
				//Post Crusher Production
				m_processMsg = cProd.processIt(DOCACTION_Complete);
				if(m_processMsg == null)			
					cProd.saveEx();
			}
		
		return m_processMsg;
	}	

	public void updateDispenseQty(MWeighmentEntry wEntry, boolean isReverse) {
		MDispensePlanLine dispensePlanLine = new MDispensePlanLine(getCtx(), wEntry.getTF_DispensePlanLine_ID(), get_TrxName());
		
		TF_MOrderLine orderline = new TF_MOrderLine(getCtx(),wEntry.getC_OrderLine_ID(), get_TrxName());
		
		if(wEntry.getTF_DispensePlanLine_ID() > 0) {
			if(!isReverse) {
				dispensePlanLine.setQtyDelivered(orderline.getQtyDelivered());
				dispensePlanLine.setDeliveredDPQty(dispensePlanLine.getDeliveredDPQty().add(wEntry.getNetWeightUnit()));
			}
			else {
				dispensePlanLine.setQtyDelivered(orderline.getQtyDelivered());
				dispensePlanLine.setDeliveredDPQty(dispensePlanLine.getDeliveredDPQty().subtract(wEntry.getNetWeightUnit()));
			}
			dispensePlanLine.setBalanceQty(dispensePlanLine.getQtyOrdered().subtract(dispensePlanLine.getQtyDelivered()));
			dispensePlanLine.setBalanceDPQty(dispensePlanLine.getDispenseQty().subtract(dispensePlanLine.getDeliveredDPQty()));
			
			dispensePlanLine.saveEx();
		}
	}
}
