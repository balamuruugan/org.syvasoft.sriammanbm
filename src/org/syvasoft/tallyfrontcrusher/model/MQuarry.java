package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

public class MQuarry extends X_TF_Quarry {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6167828883070286025L;

	public MQuarry(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MQuarry(Properties ctx, int TF_Quarry_ID, String trxName) {
		super(ctx, TF_Quarry_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public void setCurrentConsumedQty() {
		String sql = "SELECT SUM(PermitQty) FROM TF_PermitPurchase WHERE TF_Quarry_ID = ? AND"
				+ " DocStatus = 'CO' ";
		BigDecimal consumedQty = DB.getSQLValueBD(get_TrxName(), sql, getTF_Quarry_ID());
		if(consumedQty == null)
			consumedQty = BigDecimal.ZERO;		
		setQtyConsumed(consumedQty);				
	}

}
