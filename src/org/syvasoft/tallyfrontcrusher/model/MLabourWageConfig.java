package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

public class MLabourWageConfig extends X_TF_Labour_Wage_Config {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7846375739555349913L;

	public MLabourWageConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MLabourWageConfig(Properties ctx, int TF_Labour_Wage_Config_ID,
			String trxName) {
		super(ctx, TF_Labour_Wage_Config_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static MLabourWageConfig getLabourWageConfig(Properties ctx, int C_BPartner_ID, int TF_VehicleType_ID, Timestamp dateAcct) {
		String where = "(C_BPartner_ID = ? OR TF_VehicleType_ID = ?) AND ValidFrom <= ? ";
		List<MLabourWageConfig> wageConfigs = new Query(ctx, Table_Name, where, null)
			.setClient_ID().setParameters(C_BPartner_ID, TF_VehicleType_ID, dateAcct)
			.setOnlyActiveRecords(true)
			.setOrderBy("COALESCE(TF_VehicleType_ID,0) DESC, COALESCE(C_BPartner_ID,0) DESC, ValidFrom DESC").list();
		if(wageConfigs.size() > 0)
			return wageConfigs.get(0);
		else
			return null;
	}
}
