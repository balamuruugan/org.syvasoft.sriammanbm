package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

public class MEmpIncrementHistory extends X_TF_EmpIncrementHistory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2043711870507564857L;

	public MEmpIncrementHistory(Properties ctx, int TF_EmpIncrementHistory_ID, String trxName) {
		super(ctx, TF_EmpIncrementHistory_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MEmpIncrementHistory(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static boolean exists(Properties ctx, int AD_Org_ID, int C_BPartner_ID, int C_Period_ID, BigDecimal incrementAmt, String trxName ) {
		String sql = "SELECT COUNT(*) FROM TF_EmpIncrementHistory WHERE AD_Org_ID = ? AND C_BPartner_ID = ? AND C_Period_ID = ? AND IncrementAmt = ?";
		int cnt = DB.getSQLValue(trxName, sql, AD_Org_ID, C_BPartner_ID, C_Period_ID, incrementAmt);
		return cnt > 0;
	}
}
