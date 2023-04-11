package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.compiere.util.Util;
import org.syvasoft.tallyfrontcrusher.model.MSandBlockBucketConfig;
import org.syvasoft.tallyfrontcrusher.model.MYardEntry;
import org.syvasoft.tallyfrontcrusher.model.MYardLoadConfig;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CreateSalesEntryFromUnbilledYardEntry extends SvrProcess {
	
	private String Permit_SandType = TF_MOrder.ITEM1_SANDTYPE_PermitSand;
	private String WithoutPermit_SandType = TF_MOrder.ITEM1_SANDTYPE_WithoutPermit;
	private String ExtraBucket_SandType = TF_MOrder.ITEM1_SANDTYPE_ExtraBucket;
		
	MSandBlockBucketConfig pConfig;
	MSandBlockBucketConfig wConfig;
	MSandBlockBucketConfig xConfig;
	
	private BigDecimal BucketPerLoad = BigDecimal.ZERO;
	private BigDecimal PermitTonnagePerLoad = BigDecimal.ZERO;
		
	private int C_DocType_ID = 0;
	private int AD_Org_ID = 0;
	private Timestamp DateFrom = null;
	private Timestamp DateTo = null;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("C_DocType_ID"))
				C_DocType_ID = para[i].getParameterAsInt();			
			if(name.equals("AD_Org_ID"))
				AD_Org_ID = para[i].getParameterAsInt();
			if(name.equals("DateFrom"))
				DateFrom = para[i].getParameterAsTimestamp();
			if(name.equals("DateTo"))
				DateTo = para[i].getParameterAsTimestamp();
		}
	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = " AD_Org_ID = ? AND DateAcct >= ? AND DateAcct <= ? AND "
				+ " Status = 'CO' AND (SELECT OrgType FROM AD_Org WHERE "				
				+ "AD_Org.AD_Org_ID = TF_YardEntry.AD_Org_ID) = 'S'"
				+ " AND NOT EXISTS(SELECT C_Order.TF_YardEntry_ID FROM C_Order WHERE "
				+ "C_Order.TF_YardEntry_ID =  TF_YardEntry.TF_YardEntry_ID)";
		int i = 0;
		List<MYardEntry> yEntries = new Query(getCtx(), MYardEntry.Table_Name, whereClause, get_TrxName())
				.setClient_ID().setParameters(AD_Org_ID, DateFrom, DateTo).list();
		for(MYardEntry yEntry : yEntries) {
			Trx trx = Trx.get(get_TrxName(), false);
			Savepoint sp = null;
			try {
				loadBucketConfiguration(yEntry);
				if(yEntry.getPermitSalesQty().doubleValue() > 0) {
					TF_MOrder pOrd = new TF_MOrder(getCtx(), 0, get_TrxName());		
					createOrderHeader(yEntry, pOrd, C_DocType_ID, yEntry.getM_Warehouse_ID());
					createPermitSalesLine(yEntry, pOrd);
					createExtraBucketLine(yEntry, pOrd);
					pOrd.saveEx();
					
					TF_MOrder ord = pOrd;
					sp = trx.setSavepoint(yEntry.getDocumentNo());
					ord.setDocAction(DocAction.ACTION_Complete);
					ord.completeIt();
					ord.setDocStatus(TF_MOrder.DOCSTATUS_Completed);
					ord.saveEx();
					
					String error = DocumentEngine.postImmediate(Env.getCtx(), ord.getAD_Client_ID(), ord.get_Table_ID(), ord.get_ID(), true, ord.get_TrxName());				
					if (! Util.isEmpty(error)) {
							throw new AdempiereException(error);
					}
					trx.releaseSavepoint(sp);
					addLog(ord.get_Table_ID(), ord.getCreated(), null, ord.getDocumentNo() + " is created!", ord.get_Table_ID(), ord.get_ID());
					
				}
				if(yEntry.getWPQty().doubleValue() > 0) {
					TF_MOrder wOrd = new TF_MOrder(getCtx(), 0, get_TrxName());
					createOrderHeader(yEntry, wOrd, C_DocType_ID, yEntry.getM_Warehouse_ID());
					createWithoutPermitSalesLine(yEntry, wOrd);
					createExtraBucketLine(yEntry, wOrd);
					wOrd.saveEx();
					
					TF_MOrder ord = wOrd;
					sp = trx.setSavepoint(yEntry.getDocumentNo());
					ord.setDocAction(DocAction.ACTION_Complete);
					ord.completeIt();
					ord.setDocStatus(TF_MOrder.DOCSTATUS_Completed);
					ord.saveEx();
										
					String error = DocumentEngine.postImmediate(Env.getCtx(), ord.getAD_Client_ID(), ord.get_Table_ID(), ord.get_ID(), true, ord.get_TrxName());				
					if (! Util.isEmpty(error)) {
							throw new AdempiereException(error);
					}
					trx.releaseSavepoint(sp);
					addLog(ord.get_Table_ID(), ord.getCreated(), null, ord.getDocumentNo() + " is created!", ord.get_Table_ID(), ord.get_ID());
					
				}
			}
			catch (Exception ex) {
				if(sp != null)
					trx.rollback(sp);
				String desc = yEntry.getDescription();
				if(desc == null)
					desc = "";
				if(!desc.contains("ERROR:")) {
					yEntry.setDescription(desc + 
							" | ERROR: " + ex.getMessage());					
				}					
				yEntry.saveEx();
				addLog(yEntry.get_Table_ID(), yEntry.getGrossWeightTime(), null, ex.getMessage(), yEntry.get_Table_ID(), yEntry.get_ID());
			}
			i++;
		}
		return i + " Yard Entries are processed!";			
	}
	
	private void loadBucketConfiguration(MYardEntry ye) {
		pConfig = MSandBlockBucketConfig.getBucketConfig(ye.getAD_Org_ID(), Permit_SandType, ye.getTF_VehicleType_ID());
		if(pConfig == null)
			throw new AdempiereException("No Sand Block Bucket Configuration found for Sand Type: P,  " + ye.getTF_VehicleType().getName());		
		//P_TonnagePerBucket = pConfig.getSalesTonnagePerBucket();
		
		wConfig = MSandBlockBucketConfig.getBucketConfig(ye.getAD_Org_ID(), WithoutPermit_SandType, ye.getTF_VehicleType_ID());
		if(wConfig == null)
			throw new AdempiereException("No Sand Block Bucket Configuration found for Sand Type: W,  " + ye.getTF_VehicleType().getName());		
		//W_TonnagePerBucket = wConfig.getSalesTonnagePerBucket();
		
		xConfig = MSandBlockBucketConfig.getBucketConfig(ye.getAD_Org_ID(), ExtraBucket_SandType, 0);
		if(xConfig == null)
			throw new AdempiereException("No Sand Block Bucket Configuration found for Sand Type: X,  " + ye.getTF_VehicleType().getName());		
		//X_TonnagePerBucket = xConfig.getSalesTonnagePerBucket();
		
		MYardLoadConfig lConfig = MYardLoadConfig.getMYardLoadConfig(ye.getAD_Org_ID(), ye.getTF_VehicleType_ID());
		if(lConfig == null)
			throw new AdempiereException("No Load Configuration for " + ye.getTF_VehicleType().getName());
		BucketPerLoad = lConfig.getBucketPerLoad();
		PermitTonnagePerLoad = lConfig.getSalesTonnagePerLoad();
	}
	
	private void createOrderHeader(MYardEntry ye, TF_MOrder ord, int C_DocType_ID, int M_Warehouse_ID) {
		ord.setAD_Org_ID(ye.getAD_Org_ID());
		ord.setC_DocTypeTarget_ID(C_DocType_ID);
		ord.setC_DocType_ID(C_DocType_ID);
		ord.setM_Warehouse_ID(M_Warehouse_ID);
		ord.setDateAcct(ye.getDateAcct());
		ord.setDateOrdered(ye.getDateAcct());
		int C_BParner_ID = ye.getC_BPartner_ID();
		if(C_BParner_ID == 0)
			C_BParner_ID = 1000020;		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), C_BParner_ID, get_TrxName());
		ord.setBPartner(bp);
		ord.setDescription(ye.getDescription());
		if(ord.getDescription() != null)
			ord.addDescription("Customer Name : " + ye.getPartyName());
		else
			ord.setDescription("Customer Name : " + ye.getPartyName());
		
		ord.setPaymentRule(ye.getPaymentRule());		
		//Price List
		int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
		if(bp.getPO_PriceList_ID() > 0)
			m_M_PriceList_ID = bp.getPO_PriceList_ID();			
		ord.setM_PriceList_ID(m_M_PriceList_ID);
		ord.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		ord.setIsSOTrx(true);
		ord.setTF_YardEntry_ID(ye.getTF_YardEntry_ID());				
	}
	
	private void createPermitSalesLine(MYardEntry ye, TF_MOrder ord) {
		ord.setItem1_IsPermitSales(true);
		ord.setItem1_VehicleType_ID(ye.getTF_VehicleType_ID());
		ord.setItem1_SandType(Permit_SandType);
		ord.setItem1_ID(pConfig.getM_Product_ID());
		ord.setItem1_UOM_ID(ord.getItem1().getC_UOM_ID());
		ord.setItem1_Tax_ID(1000000);
		
		BigDecimal bucketQty = BucketPerLoad.multiply(ye.getPermitSalesQty());		
		ord.setItem1_BucketQty(bucketQty);
		BigDecimal bucketRate = ye.getPermitPrice().divide(BucketPerLoad, 4, RoundingMode.HALF_EVEN);
		BigDecimal tonnePerBucket = pConfig.getSalesTonnagePerBucket(); 
		ord.setItem1_BucketRate(bucketRate);
		ord.setTonePerBucket(tonnePerBucket);
		ord.setItem1_TotalLoad(ye.getPermitSalesQty());
		if(ye.getPermitIssuedTonnage() != null && ye.getPermitIssuedTonnage().doubleValue() > 0)
			ord.setItem1_PermitIssued(ye.getPermitIssuedTonnage());
		else
			ord.setItem1_PermitIssued(ye.getPermitIssuedQty().multiply(PermitTonnagePerLoad));
		ord.setItem1_Qty(bucketQty.multiply(tonnePerBucket));
		BigDecimal price = bucketRate.divide(tonnePerBucket, 4, RoundingMode.HALF_EVEN);
		ord.setItem1_Price(price);
		ord.setItem1_Amt(ord.getItem1_Qty().multiply(ord.getItem1_Price()));		
	}
	
	private void createWithoutPermitSalesLine(MYardEntry ye, TF_MOrder ord) {
		ord.setItem1_IsPermitSales(false);
		ord.setItem1_VehicleType_ID(ye.getTF_VehicleType_ID());
		ord.setItem1_SandType(WithoutPermit_SandType);
		ord.setItem1_ID(wConfig.getM_Product_ID());
		ord.setItem1_UOM_ID(ord.getItem1().getC_UOM_ID());
		ord.setItem1_Tax_ID(1000000);
		
		BigDecimal bucketQty = BucketPerLoad.multiply(ye.getWPQty());
		ord.setItem1_BucketQty(bucketQty);
		BigDecimal bucketRate = ye.getWpPrice().divide(BucketPerLoad, 4, RoundingMode.HALF_EVEN);
		BigDecimal tonnePerBucket = xConfig.getSalesTonnagePerBucket(); 
		ord.setItem1_BucketRate(bucketRate);
		ord.setTonePerBucket(tonnePerBucket);
		ord.setItem1_TotalLoad(ye.getWPQty());
		ord.setItem1_PermitIssued(BigDecimal.ZERO);
		ord.setItem1_Qty(bucketQty.multiply(tonnePerBucket));
		BigDecimal price = bucketRate.divide(tonnePerBucket, 4, RoundingMode.HALF_EVEN);
		ord.setItem1_Price(price);
		ord.setItem1_Amt(ord.getItem1_Qty().multiply(ord.getItem1_Price()));				
	}
	
	private void createExtraBucketLine(MYardEntry ye, TF_MOrder ord) {
		if(ye.getExtraBucketQty().doubleValue() == 0)
			return;
		ord.setItem2_IsPermitSales(false);
		ord.setItem2_SandType(ExtraBucket_SandType);
		ord.setItem2_ID(xConfig.getM_Product_ID());
		ord.setItem2_UOM_ID(ord.getItem2().getC_UOM_ID());
		ord.setItem2_Tax_ID(1000000);
		ord.setItem2_BucketQty(ye.getExtraBucketQty());
		BigDecimal tonnePerBucket = xConfig.getSalesTonnagePerBucket();
		ord.setItem2_BucketRate(ye.getExtraBucketPrice());
		ord.setItem2_TonePerBucket(tonnePerBucket);
		ord.setItem2_TotalLoad(BigDecimal.ZERO);		
		ord.setItem2_Qty(ye.getExtraBucketQty().multiply(tonnePerBucket));
		BigDecimal price = ye.getExtraBucketPrice().divide(tonnePerBucket, 4, RoundingMode.HALF_EVEN);
		ord.setItem2_Price(price);
		ord.setItem2_Amt(ord.getItem2_Qty().multiply(ord.getItem2_Price()));		
	}

}
