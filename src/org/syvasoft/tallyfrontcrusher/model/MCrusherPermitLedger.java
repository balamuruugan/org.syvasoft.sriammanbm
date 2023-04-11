package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MCrusherPermitLedger extends X_TF_CrusherPermitLedger {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4657186805647677725L;

	public MCrusherPermitLedger(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCrusherPermitLedger(Properties ctx, int TF_CrusherPermitLedger_ID, String trxName) {
		super(ctx, TF_CrusherPermitLedger_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public BigDecimal getQtyBalance() {		
		return getQtyPurchased().subtract(getQtyIssued()!= null ? getQtyIssued() : BigDecimal.ZERO);
	}
	
	public void updateQtyIssued() {
		String sql = " UPDATE TF_CrusherPermitLedger a SET QtyIssued = (SELECT SUM(b.QtyIssued) FROM TF_CrusherPermitLedgerLine b WHERE " +
				" b.TF_CrusherPermitLedger_ID = a.TF_CrusherPermitLedger_ID) WHERE a.TF_CrusherPermitLedger_ID = " + getTF_CrusherPermitLedger_ID();						
		DB.executeUpdate(sql, get_TrxName());		
		
		updateHeaderQtyIssued(getTF_PermitPurchase_ID(), get_TrxName());
	}
	
	public static void updateHeaderQtyIssued(int TF_PermitPurchase_ID, String trxName) {
		String sql = "SELECT SUM(COALESCE(QtyIssued,0)) FROM TF_CrusherPermitLedger WHERE "
				+ " M_Product_ID IS NOT NULL AND TF_PermitPurchase_ID = ? ";
		BigDecimal headerQtyIssued = DB.getSQLValueBD(trxName, sql, TF_PermitPurchase_ID);
		
		sql = "UPDATE TF_CrusherPermitLedger SET QtyIssued = " + headerQtyIssued + " WHERE "
				+ " TF_PermitPurchase_ID = " + TF_PermitPurchase_ID 
				+ " AND  M_Product_ID IS NULL ";
		DB.executeUpdate(sql, trxName);
	}
	
	public static BigDecimal getAvailablePermitStockQty(int AD_Org_ID, int M_Product_ID, String trxName) {
		String sql = "SELECT SUM(QtyPurchased-COALESCE(QtyIssued,0)) FROM TF_CrusherPermitLedger WHERE "
				+ "AD_Org_ID = ? AND M_Product_ID = ?";
		BigDecimal qty = DB.getSQLValueBD(trxName, sql, AD_Org_ID, M_Product_ID);
		if(qty == null)
			return BigDecimal.ZERO;
		else
			return qty;
	}
	
	public static MCrusherPermitLedger getAvailablePermitLot(int AD_Org_ID, int M_Product_ID, String trxName) {
		String whereClause = "AD_Org_ID = ? AND M_Product_ID = ? AND QtyPurchased > COALESCE(QtyIssued,0)";
		MCrusherPermitLedger pl = new Query(Env.getCtx(), Table_Name, whereClause, trxName)
				.setClient_ID().setParameters(AD_Org_ID, M_Product_ID).setOrderBy("DateAcct, TF_CrusherPermitLedger_ID")
				.first();
		
		return pl;
	}
	
	public static void purchasePermit(MPermitPurchase pur) {		
		MCrusherPermitLedger pl = new MCrusherPermitLedger(pur.getCtx(), 0, pur.get_TrxName()); 
		pl.setAD_Org_ID(pur.getAD_Org_ID());
		pl.setTF_Quarry_ID(pur.getTF_Quarry_ID());
		pl.setDateAcct(pur.getDateAcct());
		pl.setTF_PermitPurchase_ID(pur.getTF_PermitPurchase_ID());
		pl.setQtyPurchased(pur.getPermitQty());
		pl.setUnitPrice(pur.getPrice());
		pl.setPurchasedAmt(pur.getPermitAmount());
		pl.setDescription(pur.getDescription());
		pl.saveEx();
		
		List<MPermitPurchaseLine> lines = new Query(pur.getCtx(), MPermitPurchaseLine.Table_Name, "TF_PermitPurchase_ID= ? ", pur.get_TrxName())
				.setClient_ID().setParameters(pur.getTF_PermitPurchase_ID()).list();
		
		for(MPermitPurchaseLine line : lines) {
			pl = new MCrusherPermitLedger(pur.getCtx(), 0, pur.get_TrxName()); 
			pl.setAD_Org_ID(pur.getAD_Org_ID());
			pl.setTF_Quarry_ID(pur.getTF_Quarry_ID());
			pl.setDateAcct(pur.getDateAcct());
			pl.setTF_PermitPurchase_ID(pur.getTF_PermitPurchase_ID());
			pl.setTF_PermitPurchaseLine_ID(line.getTF_PermitPurchaseLine_ID());
			pl.setM_Product_ID(line.getM_Product_ID());
			pl.setQtyPurchased(line.getPermitQty());
			pl.setUnitPrice(pur.getPrice());
			pl.setPurchasedAmt(pur.getPrice().multiply(line.getPermitQty()));
			pl.setDescription(line.getDescription() != null ? line.getDescription() : pur.getDescription());
			pl.saveEx();	
		}
	}
	
	public static void reversePurchasedPermit(int AD_Org_ID, int TF_PermitPurchase_ID, String trxName) {
		MCrusherPermitLedger pl = new Query(Env.getCtx(), Table_Name, "TF_PermitPurchase_ID = ? AND "
				+ "TF_PermitPurchaseLine_ID IS NULL", trxName)
				.setClient_ID().setParameters(TF_PermitPurchase_ID).first();
		if(pl != null && pl.getQtyIssued().doubleValue() > 0) {
			throw new AdempiereException("You cannot reverse the issued permits!");
		}
		String sql = "DELETE FROM TF_CrusherPermitLedger WHERE TF_PermitPurchase_ID = " + TF_PermitPurchase_ID;
		DB.executeUpdate(sql, trxName);
	}
	
	public static void issuePermit(MTaxInvoice inv) {
		BigDecimal qtyIssue = inv.getQtyPermitDeducted();
		BigDecimal qtyPermitStock = MCrusherPermitLedger.getAvailablePermitStockQty(inv.getAD_Org_ID(), inv.getM_Product_ID(), inv.get_TrxName());
		if(qtyPermitStock.doubleValue() < qtyIssue.doubleValue())
			throw new AdempiereException("Insufficient Permit Stock Available!");
		while(qtyIssue.doubleValue()>0) {
			MCrusherPermitLedger permit = getAvailablePermitLot(inv.getAD_Org_ID(), inv.getM_Product_ID(), inv.get_TrxName());
			BigDecimal qtyIssued = BigDecimal.ZERO;
			if(permit.getQtyBalance().doubleValue() > qtyIssue.doubleValue())
				qtyIssued = qtyIssue;
			else
				qtyIssued = permit.getQtyBalance();
			
			MCrusherPermitLedgerLine pmLine = new MCrusherPermitLedgerLine(inv.getCtx(), 0, inv.get_TrxName());
			pmLine.setAD_Org_ID(inv.getAD_Org_ID());
			pmLine.setTF_CrusherPermitLedger_ID(permit.getTF_CrusherPermitLedger_ID());
			pmLine.setTF_TaxInvoice_ID(inv.getTF_TaxInvoice_ID());			
			pmLine.setM_Product_ID(inv.getM_Product_ID());
			pmLine.setDescription(inv.getDescription());
			pmLine.setQtyIssued(qtyIssued);;
			pmLine.setDateAcct(inv.getDateAcct());
			pmLine.setUnitPrice(permit.getUnitPrice());			
			pmLine.saveEx();
			permit.updateQtyIssued();
			permit.saveEx();
			qtyIssue = qtyIssue.subtract(qtyIssued);
		}
	}
	
	public static void reverseIssuedPermit(MTaxInvoice inv) {		
		List<MCrusherPermitLedgerLine> plines = new Query(inv.getCtx(), MCrusherPermitLedgerLine.Table_Name, "TF_TaxInvoice_ID = ?", inv.get_TrxName())
				.setClient_ID().setParameters(inv.getTF_TaxInvoice_ID()).list();
		
		String sql = " DELETE FROM TF_CrusherPermitLedgerLine WHERE TF_TaxInvoice_ID = " + inv.getTF_TaxInvoice_ID();
		DB.executeUpdate(sql, inv.get_TrxName());
		
		sql = " UPDATE TF_CrusherPermitLedger a SET QtyIssued = COALESCE((SELECT SUM(b.QtyIssued) FROM TF_CrusherPermitLedgerLine b WHERE " +
				" b.TF_CrusherPermitLedger_ID = a.TF_CrusherPermitLedger_ID),0) WHERE a.AD_Org_ID = " + inv.getAD_Org_ID()
				+ " AND a.M_Product_ID = " + inv.getM_Product_ID();
		DB.executeUpdate(sql, inv.get_TrxName());
		//update qtyissued for all permit lots.
		for(MCrusherPermitLedgerLine line : plines) {
			updateHeaderQtyIssued(line.getTF_CrusherPermitLedger().getTF_PermitPurchase_ID(), inv.get_TrxName());
		}
	}
}
