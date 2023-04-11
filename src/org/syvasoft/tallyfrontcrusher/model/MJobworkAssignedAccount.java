package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MJobworkAssignedAccount extends X_TF_Jobwork_AssignedAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8504782411309208940L;
	
	public MJobworkAssignedAccount(Properties ctx, int TF_Jobwork_AssignedAccount_ID, String trxName) {
		super(ctx, TF_Jobwork_AssignedAccount_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MJobworkAssignedAccount(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static MJobworkAssignedAccount getJobwork(int AD_Org_ID, int C_ElementValue_ID) {
		String whereClause = "AD_Org_ID = ? AND C_ElementValue_ID = ? AND IsActive='Y' "
				+ " AND C_Project_ID IN (SELECT C_Project.C_Project_ID FROM C_Project WHERE DocStatus = 'IP')";
		MJobworkAssignedAccount	jwAcct = new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setClient_ID().setParameters(AD_Org_ID, C_ElementValue_ID).first();
		return jwAcct;
	}
	
}
