package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MYardEntryApproveLine extends X_TF_YardEntryApproveLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5791698183112827087L;
	public MYardEntryApproveLine(Properties ctx, int TF_YardEntryApproveLine_ID, String trxName) {
		super(ctx, TF_YardEntryApproveLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MYardEntryApproveLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	
}
