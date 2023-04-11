package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MYardEntryConfig extends X_TF_YardEntry_Config {

	/**
	 * 
	 */
	private static final long serialVersionUID = -440075994234393843L;

	public MYardEntryConfig(Properties ctx, int TF_YardEntry_Config_ID, String trxName) {
		super(ctx, TF_YardEntry_Config_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MYardEntryConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			//String sql = "SELECT COUNT(*) FROM " + Table_Name + 
			//		" WHERE AD_Org_ID = ? AND TF_VehicleType_ID = ? ";
			//int count = DB.getSQLValue(get_TrxName(), sql, getAD_Org_ID(), getTF_VehicleType_ID());
			//if(count > 0)
			//	throw new AdempiereException("Please specify new Vehicle Type!");
		}
		
		return super.beforeSave(newRecord);
	}

	public static MYardEntryConfig getConfig(int AD_Org_ID, int TF_VehicleType_ID) {
		MYardEntryConfig config = new Query(Env.getCtx(), Table_Name, "AD_Org_ID = ? AND TF_VehicleType_ID =  ?"
				+ " AND COALESCE(C_BPartner_ID,1000020) = 1000020", null)
				.setClient_ID().setOnlyActiveRecords(true).setParameters(AD_Org_ID, TF_VehicleType_ID).first();
		return config;
	}
	
	public static MYardEntryConfig getConfig(int AD_Org_ID, int TF_VehicleType_ID, int C_BPartner_ID) {
		if(C_BPartner_ID == 0)
			C_BPartner_ID = 1000020;
			
		MYardEntryConfig config = new Query(Env.getCtx(), Table_Name, "AD_Org_ID = ? AND TF_VehicleType_ID =  ?"
				+ " AND COALESCE(C_BPartner_ID,1000020) = ?", null)
				.setClient_ID().setOnlyActiveRecords(true).setParameters(AD_Org_ID, TF_VehicleType_ID, C_BPartner_ID).first();
		if(config == null)
			config = getConfig(AD_Org_ID, TF_VehicleType_ID);
		return config;
	}	
	
	public static MYardEntryConfig getXBckConfig(int AD_Org_ID) {
		MYardEntryConfig config = new Query(Env.getCtx(), Table_Name, "AD_Org_ID = ? "
				+ " AND ExtraBucketPrice > 0", null)
				.setClient_ID().setOnlyActiveRecords(true).setParameters(AD_Org_ID).first();		
		return config;
	}
	
}
