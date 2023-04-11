package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.Env;

public class MYardEntry extends X_TF_YardEntry {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2551140800670796232L;

	private String Permit_SandType = TF_MOrder.ITEM1_SANDTYPE_PermitSand;
	private String WithoutPermit_SandType = TF_MOrder.ITEM1_SANDTYPE_WithoutPermit;
	private String ExtraBucket_SandType = TF_MOrder.ITEM1_SANDTYPE_ExtraBucket;
	
	private BigDecimal P_TonnagePerBucket = BigDecimal.ZERO;
	private BigDecimal W_TonnagePerBucket = BigDecimal.ZERO;
	private BigDecimal X_TonnagePerBucket = BigDecimal.ZERO;
	
		
	MSandBlockBucketConfig pConfig;
	MSandBlockBucketConfig wConfig;
	MSandBlockBucketConfig xConfig;
	
	private BigDecimal BucketPerLoad = BigDecimal.ZERO;
	private BigDecimal PermitTonnagePerLoad = BigDecimal.ZERO;
		
		
	
	public MYardEntry(Properties ctx, int TF_YardEntry_ID, String trxName) {
		super(ctx, TF_YardEntry_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MYardEntry(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	private void loadBucketConfiguration() {
		pConfig = MSandBlockBucketConfig.getBucketConfig(getAD_Org_ID(), Permit_SandType, getTF_VehicleType_ID());
		if(pConfig == null)
			throw new AdempiereException("No Sand Block Bucket Configuration found for Sand Type: P,  " + getTF_VehicleType().getName());		
		P_TonnagePerBucket = pConfig.getSalesTonnagePerBucket();
		
		wConfig = MSandBlockBucketConfig.getBucketConfig(getAD_Org_ID(), WithoutPermit_SandType, getTF_VehicleType_ID());
		if(wConfig == null)
			throw new AdempiereException("No Sand Block Bucket Configuration found for Sand Type: W,  " + getTF_VehicleType().getName());		
		W_TonnagePerBucket = wConfig.getSalesTonnagePerBucket();
		
		xConfig = MSandBlockBucketConfig.getBucketConfig(getAD_Org_ID(), ExtraBucket_SandType, 0);
		if(xConfig == null)
			throw new AdempiereException("No Sand Block Bucket Configuration found for Sand Type: X,  " + getTF_VehicleType().getName());		
		X_TonnagePerBucket = xConfig.getSalesTonnagePerBucket();	
		
		MYardLoadConfig lConfig = MYardLoadConfig.getMYardLoadConfig(getAD_Org_ID(), getTF_VehicleType_ID());
		if(lConfig == null)
			throw new AdempiereException("No Load Configuration for " + getTF_VehicleType().getName());
		BucketPerLoad = lConfig.getBucketPerLoad();
		PermitTonnagePerLoad = lConfig.getSalesTonnagePerLoad();
	}
	
	public boolean hasCreatedSalesEntry() {
		List<TF_MOrder> ords = new Query(getCtx(), TF_MOrder.Table_Name, "TF_YardEntry_ID=? AND DocStatus IN ('DR', 'CO', 'IP') ", get_TrxName())
				.setClient_ID().setParameters(getTF_YardEntry_ID()).list();		
		return ords.size() > 0;
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		//Yard Entry uploaded from Weighbridge Application.
		if(getStatus().equals(STATUS_Unbilled)) {
			if(getGrossWeightTime() != null) {
				setDateAcct(getGrossWeightTime());
			}
			
			//Permit Sales
			if(isHasBalance()) {
				setTotalLoad(BigDecimal.ONE);
				setPermitCancelledQty(BigDecimal.ZERO);
				setPermitSalesQty(BigDecimal.ONE);
				setPermitPrice(getPricePerLoad());
				setPermitAmount(getPricePerLoad());
				setWPQty(BigDecimal.ZERO);
				setWpPrice(BigDecimal.ZERO);
				setWPAmount(BigDecimal.ZERO);				
			}			
			//Without Permit Sales
			else {
				setTotalLoad(BigDecimal.ONE);
				setPermitCancelledQty(BigDecimal.ZERO);
				setPermitSalesQty(BigDecimal.ZERO);
				setPermitPrice(BigDecimal.ZERO);
				setPermitAmount(BigDecimal.ZERO);
				setWPQty(BigDecimal.ONE);
				setWpPrice(getPricePerLoad());
				setWPAmount(getPricePerLoad());
			}

		}
		return super.beforeSave(newRecord);
	}

	@Override
	protected boolean beforeDelete() {
		List<TF_MOrder> orders = new Query(getCtx(), TF_MOrder.Table_Name, "TF_YardEntry_ID=? ", get_TrxName())
				.setClient_ID().setParameters(getTF_YardEntry_ID()).list();
		for(TF_MOrder ord : orders) {
			ord.addDescription("Created from " + getDocumentNo());
			ord.setTF_YardEntry_ID(0);
			ord.setTF_YardEntryApprove_ID(0);
			ord.saveEx();
			if(ord.getDocStatus().equals(DOCSTATUS_Completed)) {				
				ord.voidIt();
				ord.saveEx();
			}			
		}
		return super.beforeDelete();
	}

	public void createSalesEntry(int C_DocType_ID, int M_Warehouse_ID) {
		loadBucketConfiguration();
		
		if(getPermitSalesQty().doubleValue() > 0) {
			TF_MOrder pOrd = new TF_MOrder(getCtx(), 0, get_TrxName());		
			createOrderHeader(pOrd, C_DocType_ID, M_Warehouse_ID);
			createPermitSalesLine(pOrd);
			createExtraBucketLine(pOrd);
			pOrd.saveEx();
		}
		
		//if (!pOrd.processIt(DocAction.ACTION_Prepare))
		//	throw new AdempiereException("Failed when processing document - " + pOrd.getProcessMsg());
		//pOrd.saveEx();
		
		//DocAction
		//pOrd.setDocAction(DocAction.ACTION_Complete);
		//pOrd.completeIt();
		//pOrd.setDocStatus(DOCSTATUS_Completed);
		//pOrd.saveEx();
		//if (!pOrd.processIt(DocAction.ACTION_Complete))
		//	throw new AdempiereException("Failed when processing document - " + pOrd.getProcessMsg());
		//pOrd.saveEx();
		//End DocAction
				
		if(getWPQty().doubleValue() == 0)
			return;
		
		TF_MOrder wOrd = new TF_MOrder(getCtx(), 0, get_TrxName());
		createOrderHeader(wOrd, C_DocType_ID, M_Warehouse_ID);
		createWithoutPermitSalesLine(wOrd);
		createExtraBucketLine(wOrd);
		wOrd.saveEx();
		
		//wOrd.setDocAction(DocAction.ACTION_Complete);
		//wOrd.completeIt();
		//wOrd.setDocStatus(DOCSTATUS_Completed);
		//wOrd.saveEx();
		
		//DocAction
		//if (!wOrd.processIt(DocAction.ACTION_Complete))
		//	throw new AdempiereException("Failed when processing document - " + wOrd.getProcessMsg());
		//wOrd.saveEx();
		//End DocAction
	}
	
	private void createOrderHeader(TF_MOrder ord, int C_DocType_ID, int M_Warehouse_ID) {
		ord.setAD_Org_ID(getAD_Org_ID());
		ord.setC_DocTypeTarget_ID(C_DocType_ID);
		ord.setC_DocType_ID(C_DocType_ID);
		ord.setM_Warehouse_ID(M_Warehouse_ID);
		ord.setDateAcct(getDateAcct());
		ord.setDateOrdered(getDateAcct());
		int C_BParner_ID = getC_BPartner_ID();
		if(C_BParner_ID == 0)
			C_BParner_ID = 1000020;		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), C_BParner_ID, get_TrxName());
		ord.setBPartner(bp);
		ord.setDescription(getDescription());
		ord.setPaymentRule(TF_MOrder.PAYMENTRULE_Cash);		
		//Price List
		int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
		if(bp.getPO_PriceList_ID() > 0)
			m_M_PriceList_ID = bp.getPO_PriceList_ID();			
		ord.setM_PriceList_ID(m_M_PriceList_ID);
		ord.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		ord.setIsSOTrx(true);
		ord.setTF_YardEntry_ID(getTF_YardEntry_ID());
		ord.setTF_YardEntryApprove_ID(getTF_YardEntryApprove_ID());		
	}
	
	private void createPermitSalesLine(TF_MOrder ord) {
		ord.setItem1_IsPermitSales(true);
		ord.setItem1_VehicleType_ID(getTF_VehicleType_ID());
		ord.setItem1_SandType(Permit_SandType);
		ord.setItem1_ID(pConfig.getM_Product_ID());
		ord.setItem1_UOM_ID(ord.getItem1().getC_UOM_ID());
		ord.setItem1_Tax_ID(1000000);
		
		BigDecimal bucketQty = BucketPerLoad.multiply(getPermitSalesQty());		
		ord.setItem1_BucketQty(bucketQty);
		BigDecimal bucketRate = getPermitPrice().divide(BucketPerLoad, 4, RoundingMode.HALF_EVEN);
		BigDecimal tonnePerBucket = pConfig.getSalesTonnagePerBucket(); 
		ord.setItem1_BucketRate(bucketRate);
		ord.setTonePerBucket(tonnePerBucket);
		ord.setItem1_TotalLoad(getPermitSalesQty());
		ord.setItem1_PermitIssued(getPermitIssuedQty().multiply(PermitTonnagePerLoad)); // need to confirm with taj.
		ord.setItem1_Qty(bucketQty.multiply(tonnePerBucket));
		BigDecimal price = bucketRate.divide(tonnePerBucket, 4, RoundingMode.HALF_EVEN);
		ord.setItem1_Price(price);
		ord.setItem1_Amt(ord.getItem1_Qty().multiply(ord.getItem1_Price()));		
	}
	
	private void createWithoutPermitSalesLine(TF_MOrder ord) {
		ord.setItem1_IsPermitSales(false);
		ord.setItem1_VehicleType_ID(getTF_VehicleType_ID());
		ord.setItem1_SandType(WithoutPermit_SandType);
		ord.setItem1_ID(wConfig.getM_Product_ID());
		ord.setItem1_UOM_ID(ord.getItem1().getC_UOM_ID());
		ord.setItem1_Tax_ID(1000000);
		
		BigDecimal bucketQty = BucketPerLoad.multiply(getWPQty());
		ord.setItem1_BucketQty(bucketQty);
		BigDecimal bucketRate = getWpPrice().divide(BucketPerLoad, 4, RoundingMode.HALF_EVEN);
		BigDecimal tonnePerBucket = xConfig.getSalesTonnagePerBucket(); 
		ord.setItem1_BucketRate(bucketRate);
		ord.setTonePerBucket(tonnePerBucket);
		ord.setItem1_TotalLoad(getWPQty());
		ord.setItem1_PermitIssued(BigDecimal.ZERO);
		ord.setItem1_Qty(bucketQty.multiply(tonnePerBucket));
		BigDecimal price = bucketRate.divide(tonnePerBucket, 4, RoundingMode.HALF_EVEN);
		ord.setItem1_Price(price);
		ord.setItem1_Amt(ord.getItem1_Qty().multiply(ord.getItem1_Price()));				
	}
	
	private void createExtraBucketLine(TF_MOrder ord) {
		if(getExtraBucketQty().doubleValue() == 0)
			return;
		ord.setItem2_IsPermitSales(false);
		ord.setItem2_SandType(ExtraBucket_SandType);
		ord.setItem2_ID(xConfig.getM_Product_ID());
		ord.setItem2_UOM_ID(ord.getItem2().getC_UOM_ID());
		ord.setItem2_Tax_ID(1000000);
		ord.setItem2_BucketQty(getExtraBucketQty());
		BigDecimal tonnePerBucket = xConfig.getSalesTonnagePerBucket();
		ord.setItem2_BucketRate(getExtraBucketPrice());
		ord.setItem2_TonePerBucket(tonnePerBucket);
		ord.setItem2_TotalLoad(BigDecimal.ZERO);		
		ord.setItem2_Qty(getExtraBucketQty().multiply(tonnePerBucket));
		BigDecimal price = getExtraBucketPrice().divide(tonnePerBucket, 4, RoundingMode.HALF_EVEN);
		ord.setItem2_Price(price);
		ord.setItem2_Amt(ord.getItem2_Qty().multiply(ord.getItem2_Price()));		
	}
	
	public void close() {
		if(isProcessed())
			throw new AdempiereException("Weighment Entry is already processed!");
		setStatus(STATUS_Billed);
		setProcessed(true);		
	}
	
	public void reverse() {
		setStatus(STATUS_Unbilled);		
		setProcessed(false);
	}
	
}
