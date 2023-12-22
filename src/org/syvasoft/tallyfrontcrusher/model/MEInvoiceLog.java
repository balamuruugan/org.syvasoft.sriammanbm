package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MEInvoiceLog extends X_TF_EInvoiceLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2084568328973950216L;

	public MEInvoiceLog(Properties ctx, int TF_EInvoiceLog_ID, String trxName) {
		super(ctx, TF_EInvoiceLog_ID, trxName);
		
	}

	public MEInvoiceLog(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		
	}

}
