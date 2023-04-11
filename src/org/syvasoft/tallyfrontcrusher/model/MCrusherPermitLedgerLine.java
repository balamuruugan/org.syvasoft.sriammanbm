package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MCrusherPermitLedgerLine extends X_TF_CrusherPermitLedgerLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7885052198758197488L;

	public MCrusherPermitLedgerLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCrusherPermitLedgerLine(Properties ctx, int TF_CrusherPermitLedgerLine_ID, String trxName) {
		super(ctx, TF_CrusherPermitLedgerLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

}
