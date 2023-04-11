package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MPMSchedule extends X_PM_Schedule {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4493818874217799686L;

	public MPMSchedule(Properties ctx, int PM_Schedule_ID, String trxName) {
		super(ctx, PM_Schedule_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MPMSchedule(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
