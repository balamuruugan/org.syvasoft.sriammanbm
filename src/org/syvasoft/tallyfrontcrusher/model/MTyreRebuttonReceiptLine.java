package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.DB;

public class MTyreRebuttonReceiptLine extends X_TF_Tyre_RBReceiptLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5107097528383528037L;

	public MTyreRebuttonReceiptLine(Properties ctx,
			int TF_Tyre_RBReceiptLine_ID, String trxName) {
		super(ctx, TF_Tyre_RBReceiptLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyreRebuttonReceiptLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {		
	
		MTyreRebuttonReceipt.calcTotalAmount(getCtx(), getTF_Tyre_RBReceipt_ID(), get_TrxName());
		return super.afterSave(newRecord, success);
	}

	@Override
	protected boolean afterDelete(boolean success) {
		MTyreRebuttonReceipt.calcTotalAmount(getCtx(), getTF_Tyre_RBReceipt_ID(), get_TrxName());
		return super.afterDelete(success);
	}
	
	
}
