package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MImportSales extends X_TF_ImportSales {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8583592726280289784L;

	public MImportSales(Properties ctx, int TF_ImportSales_ID, String trxName) {
		super(ctx, TF_ImportSales_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MImportSales(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	
}
