package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MCustomerType extends X_TF_CustomerType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 768901440102859162L;

	public MCustomerType(Properties ctx, int TF_CustomerType_ID, String trxName) {
		super(ctx, TF_CustomerType_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCustomerType(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
