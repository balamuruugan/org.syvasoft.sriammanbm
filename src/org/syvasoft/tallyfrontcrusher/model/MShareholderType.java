package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MShareholderType extends X_TF_ShareholderType {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8212354247785168237L;

	public MShareholderType(Properties ctx, int TF_ShareholderType_ID, String trxName) {
		super(ctx, TF_ShareholderType_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MShareholderType(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	
}
