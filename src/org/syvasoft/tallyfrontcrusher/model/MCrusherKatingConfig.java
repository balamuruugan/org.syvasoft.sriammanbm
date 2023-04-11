package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MCrusherKatingConfig extends X_TF_CrusherKatingConfig {


	/**
	 * 
	 */
	private static final long serialVersionUID = 9048969011279343972L;


	public MCrusherKatingConfig(Properties ctx, int TF_CrusherKatingConfig_ID, String trxName) {
		super(ctx, TF_CrusherKatingConfig_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	
	public MCrusherKatingConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static MCrusherKatingConfig getConfig(int AD_Org_ID) {
		MCrusherKatingConfig config = new Query(Env.getCtx(), Table_Name, "AD_Org_ID = ?", null)
				.setClient_ID().setOnlyActiveRecords(true).setParameters(AD_Org_ID).first();		
		return config;
	}
}
