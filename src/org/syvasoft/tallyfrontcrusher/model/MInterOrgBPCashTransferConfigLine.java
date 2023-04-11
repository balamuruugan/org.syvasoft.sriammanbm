package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MInterOrgBPCashTransferConfigLine extends X_TF_OrgBPCashTrans_Configx {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7768100424870793670L;
	public MInterOrgBPCashTransferConfigLine(Properties ctx, int TF_OrgBPCashTrans_Configx_ID, String trxName) {
		super(ctx, TF_OrgBPCashTrans_Configx_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MInterOrgBPCashTransferConfigLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	
}
