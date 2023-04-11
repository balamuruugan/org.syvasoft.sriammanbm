package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MSubOrg extends X_TF_SubOrg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5510616028359707408L;

	public MSubOrg(Properties ctx, int TF_SubOrg_ID, String trxName) {
		super(ctx, TF_SubOrg_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSubOrg(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
