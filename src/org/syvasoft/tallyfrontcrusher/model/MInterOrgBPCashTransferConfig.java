package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MInterOrgBPCashTransferConfig extends X_TF_OrgBPCashTransfer_Config {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8527418949512067017L;
	
	public MInterOrgBPCashTransferConfig(Properties ctx, int TF_OrgBPCashTransfer_Config_ID, String trxName) {
		super(ctx, TF_OrgBPCashTransfer_Config_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MInterOrgBPCashTransferConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static MInterOrgBPCashTransferConfig getConfig(int Src_BankAccount_ID, int Dest_Partner_ID) {
		String whereClause = "Src_BankAccount_ID = ? AND Dest_Partner_ID = ? AND IsActive='Y'";
		MInterOrgBPCashTransferConfig config = new Query(Env.getCtx(), MInterOrgBPCashTransferConfig.Table_Name, whereClause, null)
				.setParameters(Src_BankAccount_ID, Dest_Partner_ID).first();			
		return config;
	}
	
	public static MInterOrgBPCashTransferConfigLine getDefaultAddionalCashTransfer(int Src_BankAccount_ID, int Dest_Partner_ID, boolean onlyDefault) {
		String whereClause = " TF_OrgBPCashTransfer_Config_ID IN (SELECT TF_OrgBPCashTransfer_Config_ID FROM "
				+ " TF_OrgBPCashTransfer_Config WHERE Src_BankAccount_ID = ? AND Dest_Partner_ID = ? AND IsActive= 'Y' ) "
				+ " AND IsActive= 'Y' " + (onlyDefault ? " AND IsDefault='Y'" : "");
		MInterOrgBPCashTransferConfigLine config = new Query(Env.getCtx(), MInterOrgBPCashTransferConfigLine.Table_Name, whereClause, null)
				.setClient_ID().setParameters(Src_BankAccount_ID, Dest_Partner_ID).first();
		return config;
	}
	
}
