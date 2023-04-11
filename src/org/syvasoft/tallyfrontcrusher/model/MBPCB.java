package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBPCB extends X_TF_BPCB {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3995400749093771732L;

	public MBPCB(Properties ctx, int TF_BPCB_ID, String trxName) {
		super(ctx, TF_BPCB_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MBPCB(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
