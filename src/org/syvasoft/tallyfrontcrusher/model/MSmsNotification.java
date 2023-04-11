package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MSmsNotification extends X_TF_SmsNotification {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7211450842876080363L;

	public MSmsNotification(Properties ctx, int TF_SmsNotification_ID, String trxName) {
		super(ctx, TF_SmsNotification_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSmsNotification(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
