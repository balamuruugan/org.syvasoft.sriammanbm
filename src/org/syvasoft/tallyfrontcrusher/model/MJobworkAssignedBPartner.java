package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MJobworkAssignedBPartner extends X_TF_Jobwork_AssignedBPartner {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6885852206798360428L;

	public MJobworkAssignedBPartner(Properties ctx, int TF_Jobwork_AssignedBPartner_ID, String trxName) {
		super(ctx, TF_Jobwork_AssignedBPartner_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MJobworkAssignedBPartner(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static MJobworkAssignedBPartner getJobwork(int AD_Org_ID, int C_BPartner_ID) {
		String whereClause = "AD_Org_ID = ? AND C_BPartner_ID = ? AND IsActive='Y' "
				+ " AND C_Project_ID IN (SELECT C_Project.C_Project_ID FROM C_Project WHERE DocStatus = 'IP')";
		MJobworkAssignedBPartner jwBP = new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setClient_ID().setParameters(AD_Org_ID, C_BPartner_ID).first();
		return jwBP;
	}

}
