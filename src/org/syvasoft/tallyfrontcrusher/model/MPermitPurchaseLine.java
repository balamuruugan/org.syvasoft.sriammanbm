package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MPermitPurchaseLine extends X_TF_PermitPurchaseLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6196244137000343039L;

	public MPermitPurchaseLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MPermitPurchaseLine(Properties ctx, int TF_PermitPurchaseLine_ID, String trxName) {
		super(ctx, TF_PermitPurchaseLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

}
