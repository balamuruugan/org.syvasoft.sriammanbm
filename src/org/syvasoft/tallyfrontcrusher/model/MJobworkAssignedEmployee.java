package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MJobworkAssignedEmployee extends X_TF_Jobwork_AssignedEmployee {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6698970271793795505L;
	public MJobworkAssignedEmployee(Properties ctx, int TF_Jobwork_AssignedEmployee_ID, String trxName) {
		super(ctx, TF_Jobwork_AssignedEmployee_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MJobworkAssignedEmployee(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static MJobworkAssignedEmployee getJobwork(int AD_Org_ID, int C_BPartner_ID) {
		String whereClause = "AD_Org_ID = ? AND C_BPartner_ID = ? AND IsActive='Y' "
				+ " AND C_Project_ID IN (SELECT C_Project.C_Project_ID FROM C_Project WHERE DocStatus = 'IP')";
		MJobworkAssignedEmployee jwEmp = new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setClient_ID().setParameters(AD_Org_ID, C_BPartner_ID).first();
		return jwEmp;
	}
}
