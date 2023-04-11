package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MWeighmentPayment extends X_TF_WeighmentEntry_Payment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7685340176610982588L;

	public MWeighmentPayment(Properties ctx, int TF_WeighmentEntry_Payment_ID, String trxName) {
		super(ctx, TF_WeighmentEntry_Payment_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MWeighmentPayment(Properties ctx, int TF_WeighmentEntry_Payment_ID, String trxName,
			String... virtualColumns) {
		super(ctx, TF_WeighmentEntry_Payment_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MWeighmentPayment(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
