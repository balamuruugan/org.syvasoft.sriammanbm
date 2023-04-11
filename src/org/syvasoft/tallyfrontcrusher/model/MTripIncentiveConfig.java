package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;

public class MTripIncentiveConfig extends X_TF_TripIncentiveConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8769632484103271902L;

	public MTripIncentiveConfig(Properties ctx, int TF_TripIncentiveConfig_ID, String trxName) {
		super(ctx, TF_TripIncentiveConfig_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTripIncentiveConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static BigDecimal getIncentive(Properties ctx, int AD_Org_ID, String WeighmentEntryType,
			int TF_Destination_ID, int TF_VehicleType_ID, Timestamp dateAcct) {
		String whereClause = "AD_Org_ID = ? AND WeighmentEntryType = ? AND TF_Destination_ID = ? AND"
				+ " TF_VehicleType_ID = ? AND IsActive ='Y' AND ValidFrom <= TRUNC(?::timestamp)";
		MTripIncentiveConfig config = new Query(ctx, Table_Name, whereClause, null)
				.setClient_ID()
				.setParameters(AD_Org_ID, WeighmentEntryType, TF_Destination_ID, TF_VehicleType_ID, dateAcct)
				.setOrderBy("ValidFrom DESC")
				.first();
		
		if(config  != null)
			return config.getIncentive();
		
		whereClause = "AD_Org_ID = ? AND WeighmentEntryType = ? AND TF_Destination_ID IS NULL AND"
				+ " TF_VehicleType_ID = ? AND IsActive ='Y' AND ValidFrom <= TRUNC(?::timestamp)";
		
		config = new Query(ctx, Table_Name, whereClause, null)
				.setClient_ID()
				.setParameters(AD_Org_ID, WeighmentEntryType, TF_VehicleType_ID, dateAcct)
				.setOrderBy("ValidFrom DESC")
				.first();
		
		if(config  != null)
			return config.getIncentive();
		else
			return BigDecimal.ZERO;
		
	}
}
