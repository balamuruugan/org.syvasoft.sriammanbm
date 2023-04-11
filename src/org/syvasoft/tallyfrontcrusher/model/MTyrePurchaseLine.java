package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.DB;

public class MTyrePurchaseLine extends X_TF_TyrePurchaseLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3079688589585705340L;

	public MTyrePurchaseLine(Properties ctx, int TF_TyrePurchaseLine_ID,
			String trxName) {
		super(ctx, TF_TyrePurchaseLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyrePurchaseLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		
		String sql = "SELECT COUNT(*) FROM TF_Tyre WHERE TyreNo=?";
		if(newRecord) {
			int count = DB.getSQLValue(get_TrxName(), sql, getTyreNo());
			if(count > 0) 
				throw new AdempiereException("Tyre No:" + getTyreNo() + " is already existed!");
		}
		MTyrePurchase.calcTotalAmount(getCtx(), getTF_TyrePurchase_ID(), get_TrxName());
		return super.afterSave(newRecord, success);
	}
	
	@Override
	protected boolean afterDelete(boolean success) {
		MTyrePurchase.calcTotalAmount(getCtx(), getTF_TyrePurchase_ID(), get_TrxName());
		return super.afterDelete(success);
	}

}
