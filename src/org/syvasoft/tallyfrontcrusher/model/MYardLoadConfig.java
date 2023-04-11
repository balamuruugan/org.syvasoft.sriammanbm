package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MYardLoadConfig extends X_TF_YardLoad_Config {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8175302428198207709L;

	public MYardLoadConfig(Properties ctx, int TF_YardLoad_Config_ID, String trxName) {
		super(ctx, TF_YardLoad_Config_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MYardLoadConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static MYardLoadConfig getMYardLoadConfig(int AD_Org_ID, int TF_VehicleType_ID) {
		MYardLoadConfig config = new Query(Env.getCtx(), Table_Name, "AD_org_ID = ? AND TF_VehicleType_ID = ?", null)
				.setClient_ID().setParameters(AD_Org_ID, TF_VehicleType_ID).first();
		return config;
	}
}
