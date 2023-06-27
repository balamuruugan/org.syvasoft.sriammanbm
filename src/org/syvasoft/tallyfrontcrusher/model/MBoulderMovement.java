package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.util.DB;
import org.compiere.util.Env;

public class MBoulderMovement extends X_TF_Boulder_Movement {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4027717865768847637L;

	public MBoulderMovement(Properties ctx, int TF_Boulder_Movement_ID, String trxName) {
		super(ctx, TF_Boulder_Movement_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MBoulderMovement(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static void createBoulderReceipt(String trxName, Timestamp dateMovement,int AD_Org_ID,  
			int M_Product_ID, BigDecimal QtyReceipt, int TF_WeighmentEntry_ID, int M_Warehouse_ID, int TF_Boulder_Wastage_ID, int C_Order_ID) {	
		
		MBoulderMovement bm = new MBoulderMovement(Env.getCtx(), 0, trxName);
		bm.setAD_Org_ID(AD_Org_ID);
		bm.setMovementDate(dateMovement);		
		bm.setM_Product_ID(M_Product_ID);
		bm.setQty_Receipt(QtyReceipt);
		bm.setTF_WeighmentEntry_ID(TF_WeighmentEntry_ID);		
		bm.setM_Warehouse_ID(M_Warehouse_ID);
		bm.setTF_Boulder_Wastage_ID(TF_Boulder_Wastage_ID);
		bm.setC_Order_ID(C_Order_ID);
		bm.saveEx();
	}
	
	public static void createBoulderReceipt(String trxName, Timestamp dateMovement,int AD_Org_ID,  
			int M_Product_ID, BigDecimal QtyReceipt, int TF_WeighmentEntry_ID, int M_Warehouse_ID, int TF_Boulder_Wastage_ID, int C_Order_ID, int TF_Boulder_Receipt_ID) {	
		
		MBoulderMovement bm = new MBoulderMovement(Env.getCtx(), 0, trxName);
		bm.setAD_Org_ID(AD_Org_ID);
		bm.setMovementDate(dateMovement);		
		bm.setM_Product_ID(M_Product_ID);
		bm.setQty_Receipt(QtyReceipt);
		bm.setTF_WeighmentEntry_ID(TF_WeighmentEntry_ID);		
		bm.setM_Warehouse_ID(M_Warehouse_ID);
		bm.setTF_Boulder_Wastage_ID(TF_Boulder_Wastage_ID);
		bm.setC_Order_ID(C_Order_ID);
		bm.setTF_Boulder_Receipt_ID(TF_Boulder_Receipt_ID);
		bm.saveEx();
	}
	
	public static void createBoulderIssue(String trxName, Timestamp dateMovement,int AD_Org_ID,  
			int M_Product_ID, BigDecimal QtyPayment, int TF_WeighmentEntry_ID, int M_Warehouse_ID, int TF_CrusherKatingEntry_ID) {	
		
		MBoulderMovement bm = new MBoulderMovement(Env.getCtx(), 0, trxName);
		bm.setAD_Org_ID(AD_Org_ID);
		bm.setMovementDate(dateMovement);		
		bm.setM_Product_ID(M_Product_ID);
		bm.setQty_Payment(QtyPayment);
		bm.setTF_CrusherKatingEntry_ID(TF_CrusherKatingEntry_ID);
		bm.setTF_WeighmentEntry_ID(TF_WeighmentEntry_ID);
		bm.setM_Warehouse_ID(M_Warehouse_ID);
		bm.saveEx();
		
	}
	
	public static void deleteBoulderMovement(int TF_WeighmentEntry_ID, String trxName) {
		String sql = "DELETE FROM TF_Boulder_Movement WHERE TF_WeighmentEntry_ID = " + TF_WeighmentEntry_ID;
		DB.executeUpdate(sql, trxName);
	}
	
	public static void deleteBoulderMovementFromBoulderWastage(int TF_Boulder_Wastage_ID, String trxName) {
		String sql = "DELETE FROM TF_Boulder_Movement WHERE TF_Boulder_Wastage_ID = " + TF_Boulder_Wastage_ID;
		DB.executeUpdate(sql, trxName);
	}
	
	public static void deleteBoulderMovementFromBoulderReceipt(int TF_Boulder_Receipt_ID, String trxName) {
		String sql = "DELETE FROM TF_Boulder_Movement WHERE TF_Boulder_Receipt_ID = " + TF_Boulder_Receipt_ID;
		DB.executeUpdate(sql, trxName);
	}
	
	public static void deleteByOrder(int C_Order_ID, String trxName) {
		String sql = "DELETE FROM TF_Boulder_Movement WHERE C_Order_ID = " + C_Order_ID;
		DB.executeUpdate(sql, trxName);
	}
	
	public static void deleteByKatingEntry(int TF_CrusherKatingEntry_ID, String trxName) {
		String sql = "DELETE FROM TF_Boulder_Movement WHERE TF_CrusherKatingEntry_ID = " + TF_CrusherKatingEntry_ID;
		DB.executeUpdate(sql, trxName);
	}
}
