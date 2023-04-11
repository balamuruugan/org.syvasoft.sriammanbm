package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

public class MCrusherProductionConfig extends X_TF_CrusherProduction_Config {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2432513476309373042L;

	public MCrusherProductionConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCrusherProductionConfig(Properties ctx,int TF_CrusherProduction_Config_ID, String trxName) {
		super(ctx, TF_CrusherProduction_Config_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static MCrusherProductionConfig[] getMCrusherProductionConfig(Properties ctx,
			int AD_Org_ID,
			int TF_ProductionPlant_ID,
			String TF_BlueMetal_Type, 
			int M_Product_ID) {
		String where = " AD_Org_ID = ? AND TF_ProductionPlant_ID = ? AND TF_BlueMetal_Type=? AND RM_Product_ID = ? ";
		List<MCrusherProductionConfig> prodConfigs = new Query(ctx, Table_Name, where, null)
		.setClient_ID().setParameters(AD_Org_ID, TF_ProductionPlant_ID, TF_BlueMetal_Type, M_Product_ID).setOnlyActiveRecords(true)
		.setOrderBy("TF_CrusherProduction_Config_ID").list();	
		MCrusherProductionConfig configs[] = new MCrusherProductionConfig[prodConfigs.size()];
		return prodConfigs.toArray(configs);
	}

	public static MCrusherProductionConfig[] getMCrusherProductionConfig(Properties ctx,
			int AD_Org_ID,
			String TF_BlueMetal_Type, int M_Product_ID) {
		String where = " AD_Org_ID = ? AND TF_BlueMetal_Type=? AND M_Product_ID = ? ";
		List<MCrusherProductionConfig> prodConfig = new Query(ctx, Table_Name, where, null)
		.setClient_ID().setParameters(AD_Org_ID, TF_BlueMetal_Type, M_Product_ID).setOnlyActiveRecords(true)
		.setOrderBy("TF_CrusherProduction_Config_ID").list();
		
		MCrusherProductionConfig configs[] = new MCrusherProductionConfig[prodConfig.size()];
		return prodConfig.toArray(configs);
	}
}
