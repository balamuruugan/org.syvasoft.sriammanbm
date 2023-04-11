package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;

public class MDriverBetaConfig extends X_TF_DriverBeta_Config {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7867415960367673641L;

	public MDriverBetaConfig(Properties ctx, int TF_DriverBeta_Config_ID, String trxName) {
		super(ctx, TF_DriverBeta_Config_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MDriverBetaConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static BigDecimal getDriverBetaAmount(Properties ctx,int AD_Org_ID, int TF_VehicleType_ID, String trxName) {
		
		String Where=" AD_Org_ID=? AND TF_VehicleType_ID=?";

		MDriverBetaConfig betaConfig= new Query(ctx,Table_Name , Where, trxName)
				.setClient_ID()
				.setOnlyActiveRecords(true)
				.setParameters(AD_Org_ID, TF_VehicleType_ID).first();
		
		if(betaConfig == null)
			return BigDecimal.ZERO;
		else
			return betaConfig.getDriverBetaAmount();
	}

}
