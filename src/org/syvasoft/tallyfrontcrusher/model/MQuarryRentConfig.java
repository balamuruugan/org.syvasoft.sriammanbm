package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;


public class MQuarryRentConfig extends X_TF_Quarry_Rent_Config {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6504829138407851775L;

	public MQuarryRentConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MQuarryRentConfig(Properties ctx, int TF_Quarry_Rent_Config_ID,
			String trxName) {
		super(ctx, TF_Quarry_Rent_Config_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static MQuarryRentConfig getMQuarryRentConfig(Properties ctx, int TF_Quarry_ID, Timestamp dateAcct) {
		String where = " TF_Quarry_ID = ? AND ValidFrom <= ? ";
		List<MQuarryRentConfig> rentConfig = new Query(ctx, Table_Name, where, null)
		.setClient_ID().setParameters(TF_Quarry_ID, dateAcct).setOnlyActiveRecords(true)
		.setOrderBy("ValidFrom DESC").list();
		if(rentConfig.size() > 0)
			return rentConfig.get(0);
		else
			return null;
	}
}
