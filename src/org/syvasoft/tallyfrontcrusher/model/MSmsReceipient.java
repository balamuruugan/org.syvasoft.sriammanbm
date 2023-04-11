package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MSmsReceipient extends X_TF_SmsRecipient {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3988199321806505181L;

	public MSmsReceipient(Properties ctx, int TF_SmsRecipient_ID, String trxName) {
		super(ctx, TF_SmsRecipient_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSmsReceipient(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
