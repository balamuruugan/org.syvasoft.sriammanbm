package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MJobworkAssignedVehicle extends X_TF_Jobwork_AssignedVehicle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8158587049940423292L;

	public MJobworkAssignedVehicle(Properties ctx, int TF_Jobwork_AssignedVehicle_ID, String trxName) {
		super(ctx, TF_Jobwork_AssignedVehicle_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MJobworkAssignedVehicle(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static MJobworkAssignedVehicle getJobwork(int AD_Org_ID, int M_Product_ID) {
		String whereClause = "AD_Org_ID = ? AND M_Product_ID = ? AND IsActive='Y' "
				+ " AND C_Project_ID IN (SELECT C_Project.C_Project_ID FROM C_Project WHERE DocStatus = 'IP')";
		MJobworkAssignedVehicle jwVehicle = new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setClient_ID().setParameters(AD_Org_ID, M_Product_ID).first();
		return jwVehicle;
	}
}
