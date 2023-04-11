package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MTRPackingDetail extends X_TF_TRPacking {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3405417337285321894L;

	public MTRPackingDetail(Properties ctx, int TF_TRPacking_ID, String trxName) {
		super(ctx, TF_TRPacking_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTRPackingDetail(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	
	
}
