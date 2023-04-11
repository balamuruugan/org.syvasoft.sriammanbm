package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MProductionPlant extends X_TF_ProductionPlant {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7357833202484622937L;
	public MProductionPlant(Properties ctx, int TF_ProductionPlant_ID, String trxName) {
		super(ctx, TF_ProductionPlant_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MProductionPlant(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	

}
