package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MCashCounter extends X_TF_CashCounter {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2689797940599595121L;

	public MCashCounter(Properties ctx, int TF_CashCounter_ID, String trxName) {
		super(ctx, TF_CashCounter_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCashCounter(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	

}
