package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.compiere.model.MUserRoles;
import org.compiere.util.Util;

public class MEmailAlertSetupCC extends X_VG_EmailAlertSetup_CC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 292721037219884773L;
	public MEmailAlertSetupCC(Properties ctx, int VG_EmailAlertSetup_CC_ID, String trxName) {
		super(ctx, VG_EmailAlertSetup_CC_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MEmailAlertSetupCC(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public List<String> getEmailIds() {
		ArrayList<String> Emaillist = new ArrayList<String>();
		if(getAD_Role_ID() > 0) {					
			MUserRoles[] list = MUserRoles.getOfRole(getCtx(), getAD_Role_ID());
			for(MUserRoles u : list) {					
				String emailAddress = u.getAD_User().getEMail();
				if(!Util.isEmpty(emailAddress, true))
					Emaillist.add(emailAddress);						
			}					
		}
		
		if(getAD_User_ID() > 0) {
			String emailAddress = getAD_User().getEMail();
			if(!Util.isEmpty(emailAddress, true))
				Emaillist.add(emailAddress);	
		}
		
		return Emaillist;
	}
}
