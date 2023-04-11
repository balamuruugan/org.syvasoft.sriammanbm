package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MInterOrgCashTransferConfigLine extends X_TF_OrgCashTransfer_Configx {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8158335653076330043L;

	public MInterOrgCashTransferConfigLine(Properties ctx, int TF_OrgCashTransfer_Configx_ID, String trxName) {
		super(ctx, TF_OrgCashTransfer_Configx_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MInterOrgCashTransferConfigLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		TF_MCharge.createChargeFromAccount(getCtx(), getDest_Acct_ID(), null);
		return super.afterSave(newRecord, success);
	}

}
