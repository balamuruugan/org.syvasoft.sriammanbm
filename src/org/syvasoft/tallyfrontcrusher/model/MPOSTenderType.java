package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;

public class MPOSTenderType extends X_C_POSTenderType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5916656557189858092L;

	public MPOSTenderType(Properties ctx, int C_POSTenderType_ID, String trxName) {
		super(ctx, C_POSTenderType_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MPOSTenderType(Properties ctx, int C_POSTenderType_ID, String trxName, String... virtualColumns) {
		super(ctx, C_POSTenderType_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MPOSTenderType(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static MPOSTenderType get(Properties ctx, int AD_Org_ID, String tenderType) {
		String whereClause = "AD_Org_ID = ? AND TenderType = ? AND IsActive = 'Y'";
		MPOSTenderType tt = new Query(ctx, Table_Name, whereClause, null)
				.setClient_ID()
				.setParameters(AD_Org_ID, tenderType)
				.first();
		return tt;
	}
	
}
