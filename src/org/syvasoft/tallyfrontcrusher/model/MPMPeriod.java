package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MPMPeriod extends X_PM_Period {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6219721758949823418L;

	public MPMPeriod(Properties ctx, int PM_Period_ID, String trxName) {
		super(ctx, PM_Period_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MPMPeriod(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
