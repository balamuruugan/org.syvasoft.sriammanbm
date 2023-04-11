package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MPermitLedger extends X_TF_PermitLedger {

	/**
	 * 
	 */
	private static final long serialVersionUID = 365467937833277793L;

	public MPermitLedger(Properties ctx, int TF_PermitLedger_ID, String trxName) {
		super(ctx, TF_PermitLedger_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MPermitLedger(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}	

	public BigDecimal getQtyBalance() {
		return getQtyPurchased().subtract(getQtyIssued());
	}	
	
	public void updateQtyIssued() {
		String sql = " UPDATE TF_PermitLedger a SET QtyIssued = (SELECT SUM(b.QtyIssued) FROM TF_PermitLedgerLine b WHERE " +
				" b.TF_PermitLedger_ID = a.TF_PermitLedger_ID) WHERE a.TF_PermitLedger_ID = " + getTF_PermitLedger_ID();
		DB.executeUpdate(sql, get_TrxName());
	}
	
	public static BigDecimal getAvailablePermitStockQty(int M_ProductPermitLedger_ID, String trxName) {
		String sql = "SELECT SUM(QtyPurchased-COALESCE(QtyIssued,0)) FROM TF_PermitLedger WHERE M_Product_ID = ?";
		BigDecimal qty = DB.getSQLValueBD(trxName, sql, M_ProductPermitLedger_ID);
		if(qty == null)
			return BigDecimal.ZERO;
		else
			return qty;
	}
	
	public static MPermitLedger getAvailablePermit (int M_ProductPermitLedger_ID, String trxName) {
		String whereClause = "M_Product_ID = ? AND QtyPurchased > COALESCE(QtyIssued,0)";
		MPermitLedger permit = new Query(Env.getCtx(), Table_Name, whereClause, trxName)
				.setClient_ID().setParameters(M_ProductPermitLedger_ID).setOrderBy("DateAcct, TF_PermitLedger_ID").first();
		return permit;
	}
	
	public static void reversePurchasedPermit(int AD_Org_ID, int C_OrderLine_ID, String trxName) {
		MPermitLedger pmLedger = new Query(Env.getCtx(), Table_Name, "AD_Org_ID = ? AND C_OrderLine_ID = ? ", trxName)
				.setClient_ID().setParameters(AD_Org_ID, C_OrderLine_ID).first();
		if(pmLedger.getQtyIssued().doubleValue() > 0)
			throw new AdempiereException("You cannot reverse the issued permit!");
		
		String sql = "DELETE FROM TF_PermitLedger WHERE C_OrderLine_ID = " + C_OrderLine_ID;
		DB.executeUpdate(sql, trxName);
	}
	
	public static void reverseIssuedPermit(int AD_Org_ID, int C_OrderLine_ID, String trxName) {
		
		List<MPermitLedgerLine> lines = new Query(Env.getCtx(), MPermitLedgerLine.Table_Name, "C_OrderLine_ID = ?", trxName)
				.setClient_ID().setParameters(C_OrderLine_ID).list();
		
		for(MPermitLedgerLine line : lines) {
			line.reversePermitExpense();
			line.saveEx();
		}
		
		String sql = " DELETE FROM TF_PermitLedgerLine WHERE C_OrderLine_ID = " + C_OrderLine_ID;
		DB.executeUpdate(sql, trxName);
		
		sql = " UPDATE TF_PermitLedger a SET QtyIssued = COALESCE((SELECT SUM(b.QtyIssued) FROM TF_PermitLedgerLine b WHERE " +
				" b.TF_PermitLedger_ID = a.TF_PermitLedger_ID),0) WHERE AD_Org_ID =" + AD_Org_ID;
		DB.executeUpdate(sql, trxName);
	}
}
