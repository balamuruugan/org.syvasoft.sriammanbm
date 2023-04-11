package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MMachineryType extends X_PM_MachineryType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7151703995226192713L;

	public MMachineryType(Properties ctx, int PM_MachineryType_ID, String trxName) {
		super(ctx, PM_MachineryType_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MMachineryType(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
