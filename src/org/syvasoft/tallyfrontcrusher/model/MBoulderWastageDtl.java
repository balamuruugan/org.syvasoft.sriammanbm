package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MSysConfig;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MBoulderWastageDtl extends X_TF_Boulder_Wastage_DTL {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4027717865768847637L;

	public MBoulderWastageDtl(Properties ctx, int TF_Boulder_Wastage_ID, String trxName) {
		super(ctx, TF_Boulder_Wastage_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MBoulderWastageDtl(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		boolean ok = super.beforeSave(newRecord);
		return ok;
	}
	public void createLines(TF_MProject project, int C_BPartner_ID, int JobWork_Product_ID, MBoulderWastageHdr bwastagehdr) {
		setAD_Org_ID(bwastagehdr.getAD_Org_ID());
		setC_BPartner_ID(C_BPartner_ID);
		setC_Project_ID(project.getC_Project_ID());
		setJobWork_Product_ID(JobWork_Product_ID);
		setTF_Boulder_Wastage_HDR_ID(bwastagehdr.getTF_Boulder_Wastage_HDR_ID());
		
		calculateScalpingQty();
	}
	
	public void calculateScalpingQty() {
		MBoulderWastageHdr bwastagehdr = new MBoulderWastageHdr(getCtx(), getTF_Boulder_Wastage_HDR_ID(), get_TrxName());
		TF_MProject project = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());
		
		if(project.getSubcontractType().equals(TF_MProject.SUBCONTRACTTYPE_QuarryProducton)) {
			BigDecimal qtyReceived = MBoulderWastageHdr.getReceiptQtyForQuarry(bwastagehdr.getAD_Org_ID(), getC_BPartner_ID(), bwastagehdr.getM_Product_ID(), bwastagehdr.getM_Warehouse_ID(), bwastagehdr.getDateAcct(), null);			
			setQty(qtyReceived);

			int tripCount = MBoulderWastageHdr.getTripsForQuarry(bwastagehdr.getAD_Org_ID(), getC_BPartner_ID(), bwastagehdr.getM_Product_ID(), bwastagehdr.getM_Warehouse_ID(), bwastagehdr.getDateAcct(), null);
			setNoTrips(tripCount);
		}
		else {
			BigDecimal qtyReceived = MBoulderWastageHdr.getReceiptQtyForCrusher(bwastagehdr.getAD_Org_ID(), 0, bwastagehdr.getM_Product_ID(), bwastagehdr.getM_Warehouse_ID(), bwastagehdr.getDateAcct(), null);			
			setQty(qtyReceived);

			int tripCount = MBoulderWastageHdr.getTripsForCrusher(bwastagehdr.getAD_Org_ID(), 0, bwastagehdr.getM_Product_ID(), bwastagehdr.getM_Warehouse_ID(), bwastagehdr.getDateAcct(), null);
			setNoTrips(tripCount);
		}
		
		BigDecimal scalpingQty =  getQty().multiply(bwastagehdr.getScalping_Percent()).divide(new BigDecimal(100), 3, RoundingMode.HALF_EVEN).setScale(3, RoundingMode.HALF_EVEN);;
		setScalping_Qty(scalpingQty);
		
		double allowscalping_percentage = MSysConfig.getDoubleValue("ALLOWABLE_SCALPING_PERCENTAGE", 3, getAD_Client_ID(), getAD_Org_ID());
		setAllowScalping_Percent(new BigDecimal(allowscalping_percentage));
		
		
		BigDecimal allowablescalpingQty =  getQty().multiply(getAllowScalping_Percent()).divide(new BigDecimal(100), 3, RoundingMode.HALF_EVEN).setScale(3, RoundingMode.HALF_EVEN);
		setAllowScalping_Qty(allowablescalpingQty);
		
		BigDecimal netQty = BigDecimal.ZERO;
		
		if(getScalping_Qty().subtract(getAllowScalping_Qty()).doubleValue() > 0) {
			netQty = getQty().subtract(getScalping_Qty()).add(getAllowScalping_Qty()); 
			setNetQty(netQty);
			setQtyAdjustment(getScalping_Qty().subtract(getAllowScalping_Qty()));
		}
		else {
			netQty = getQty();
			setNetQty(netQty);
			setQtyAdjustment(BigDecimal.ZERO);
		}			
	}
	
	public void createSubcontractServiceReceipt(MBoulderWastageHdr header) {
		if(getQtyAdjustment().doubleValue() > 0) {
			TF_MProject proj = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());
			int invoiceItem_id = 0;
			int priceItem_id = 0;
			String priceItemName = null;			
	
			invoiceItem_id = getJobWork_Product_ID();			
			priceItem_id = getJobWork_Product_ID();
			priceItemName = getJobWork_Product().getName();
			
			BigDecimal purchasePrice = null;
			//Subcontract Purchase Price		
			if(proj.getC_BPartner_ID() == getC_BPartner_ID())
				purchasePrice = MJobworkProductPrice.getPrice(getCtx(), getC_Project_ID(), priceItem_id, header.getDateAcct());
			else if(proj.getC_BPartnerSubcon2_ID() == getC_BPartner_ID())
				purchasePrice = proj.getPriceSubcon2();
			
			if(purchasePrice == null) 
				throw new AdempiereException("Please setup Contract Price for " + priceItemName + "!");
			
			TF_MBPartner bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
			
			int ServiceReceiptId = MSysConfig.getIntValue("SERVICE_RECEIPT_ID", 1000068, Env.getAD_Client_ID(Env.getCtx()));
			
			MDocType dt = new MDocType(getCtx(), ServiceReceiptId, get_TrxName());
			
			//Service Receipt Header		
			TF_MInOut inout = new TF_MInOut(getCtx(), 0, get_TrxName());
			inout.materialReceipt = false;		
			inout.setIsSOTrx(false);
			inout.setC_DocType_ID(ServiceReceiptId);
			inout.setMovementType(MInOut.MOVEMENTTYPE_VendorReceipts);		
			inout.setDateAcct(header.getDateAcct());
			inout.setMovementDate(header.getDateAcct());		
			inout.setC_BPartner_ID(getC_BPartner_ID());
			inout.setC_BPartner_Location_ID(bp.getPrimaryC_BPartner_Location_ID());
			inout.setAD_User_ID(bp.getAD_User_ID());
			inout.setM_Warehouse_ID(header.getM_Warehouse_ID());
			inout.setPriorityRule(TF_MInOut.PRIORITYRULE_Medium);
			inout.setFreightCostRule(TF_MInOut.FREIGHTCOSTRULE_FreightIncluded);
			inout.saveEx(get_TrxName());
			
			//Material Receipt Line
			MInOutLine ioLine = new MInOutLine(inout);
			MWarehouse wh = (MWarehouse) header.getM_Warehouse();
			
			ioLine.setLine(10);
			ioLine.setM_Product_ID(invoiceItem_id);
			ioLine.setM_Locator_ID(wh.getDefaultLocator().get_ID());
			
			BigDecimal qty = getQtyAdjustment().negate();		 
			
			ioLine.setQty(qty);
			
			TF_MProduct product = new TF_MProduct(getCtx(), header.getM_Product_ID(), get_TrxName());
			ioLine.setC_UOM_ID(product.getC_UOM_ID());
			ioLine.set_ValueOfColumn("Price", purchasePrice);	
			ioLine.set_ValueOfColumn("DocStatus", "CO");		
			ioLine.setDescription("Boulder Wastage Adjustment");
			ioLine.saveEx(get_TrxName());
			
			//Material Receipt DocAction
			if (!inout.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + inout.getProcessMsg());
			
			inout.saveEx();
			
			setM_InOut_ID(inout.getM_InOut_ID());
		}
		//createTransportMaterialReceipt();
	}
	
	public void reverseSubcontractServiceReceipt() {
		if(getM_InOut_ID() > 0) {
			TF_MInOut inout = new TF_MInOut(getCtx(), getM_InOut_ID(), get_TrxName());
			inout.reverseCorrectIt();
			inout.saveEx();
			setM_InOut_ID(0);
		}
	}
	}
