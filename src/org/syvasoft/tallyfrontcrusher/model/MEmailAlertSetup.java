package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;
import org.compiere.model.MUser;
import org.compiere.model.Query;


public class MEmailAlertSetup extends X_VG_EmailAlertSetup {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4752035787933747782L;

	public MEmailAlertSetup(Properties ctx, int VG_EmailAlertSetup_ID, String trxName) {
		super(ctx, VG_EmailAlertSetup_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MEmailAlertSetup(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static MEmailAlertSetup get(Properties ctx,int AD_Org_ID, String value, String trxName) {
		return new Query(ctx, Table_Name, "AD_Org_ID = ? AND Value = ?", trxName).setClient_ID().setParameters(AD_Org_ID, value)
				.setOnlyActiveRecords(true)
				.first();
	}
	
	public List<MEmailAlertSetupCC> getCCs() {
		List<MEmailAlertSetupCC> list = new Query(getCtx(), MEmailAlertSetupCC.Table_Name, COLUMNNAME_VG_EmailAlertSetup_ID + " = ? ", get_TrxName())
				.setClient_ID().setOnlyActiveRecords(true).setParameters(getVG_EmailAlertSetup_ID()).list();
		return list;
	}
	
	public String getEmailAddress(int AD_User_ID) {
		MUser user = MUser.get(getCtx(), AD_User_ID);
		return user.getEMail();
	}
	
	
}
