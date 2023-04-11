package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MWeighmentErrorLog extends X_TF_Weighment_ErrorLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5704048473366502456L;
	public MWeighmentErrorLog(Properties ctx, int TF_Weighment_ErrorLog_ID, String trxName) {
		super(ctx, TF_Weighment_ErrorLog_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MWeighmentErrorLog(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	

}
