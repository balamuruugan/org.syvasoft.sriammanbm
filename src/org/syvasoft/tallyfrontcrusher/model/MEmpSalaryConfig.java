package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import org.compiere.model.Query;


public class MEmpSalaryConfig extends X_TF_Emp_Salary_Config {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2133231791780771862L;

	public MEmpSalaryConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);		
	}
	
	public MEmpSalaryConfig(Properties ctx, int TF_Emp_Salary_Config_ID,
			String trxName) {
		super(ctx, TF_Emp_Salary_Config_ID, trxName);		
	}
	
	public static MEmpSalaryConfig getEmpSalaryConfig(Properties ctx, int C_BPartner_ID, int TF_VehicleType_ID, Timestamp dateAcct) {
		String where = "(C_BPartner_ID = ? OR TF_VehicleType_ID = ?) AND ValidFrom <= ? ";
		List<MEmpSalaryConfig> salConfigs = new Query(ctx, Table_Name, where, null)
		.setClient_ID().setParameters(C_BPartner_ID, TF_VehicleType_ID, dateAcct)
		.setOnlyActiveRecords(true)
		.setOrderBy("COALESCE(TF_VehicleType_ID,0) DESC, COALESCE(C_BPartner_ID,0) DESC, ValidFrom DESC").list();
		if(salConfigs.size() > 0)
			return salConfigs.get(0);
		else
			return null;
	}
	
	public static MEmpSalaryConfig getEmpSalaryConfig(Properties ctx, int C_BPartner_ID, int TF_VehicleType_ID) {
		String where = "(C_BPartner_ID = ? OR TF_VehicleType_ID = ?) ";
		List<MEmpSalaryConfig> salConfigs = new Query(ctx, Table_Name, where, null)
		.setClient_ID().setParameters(C_BPartner_ID, TF_VehicleType_ID )
		.setOnlyActiveRecords(true)
		.setOrderBy("COALESCE(TF_VehicleType_ID,0) DESC,COALESCE(C_BPartner_ID,0) DESC, DateFrom DESC").list();
		if(salConfigs.size() > 0)
			return salConfigs.get(0);
		else
			return null;
	}
	
	public static MEmpSalaryConfig getEmpSalaryConfig(Properties ctx, int C_BPartner_ID, Timestamp dateAcct) {
		String where = "C_BPartner_ID = ? AND ValidFrom <= ? ";
		List<MEmpSalaryConfig> salConfigs = new Query(ctx, Table_Name, where, null)
		.setClient_ID().setParameters(C_BPartner_ID,  dateAcct)
		.setOnlyActiveRecords(true)
		.setOrderBy("COALESCE(C_BPartner_ID,0) DESC, ValidFrom DESC").list();
		if(salConfigs.size() > 0)
			return salConfigs.get(0);
		else
			return null;
	}
		
}
