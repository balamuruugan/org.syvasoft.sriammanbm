package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MCounterTransProductSetup extends X_TF_CounterTransLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5425317226392185241L;

	public MCounterTransProductSetup(Properties ctx, int TF_CounterTransLine_ID, String trxName) {
		super(ctx, TF_CounterTransLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCounterTransProductSetup(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
