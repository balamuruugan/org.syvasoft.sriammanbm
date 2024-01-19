package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;

public class MVehicleType extends X_TF_VehicleType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2898457429379407730L;

	public MVehicleType(Properties ctx, int TF_VehicleType_ID, String trxName) {
		super(ctx, TF_VehicleType_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MVehicleType(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		
		return super.beforeSave(newRecord);
	}
	
	public BigDecimal getWage(Timestamp dateAcct, BigDecimal distance) {
		String whereClause = "TF_VehicleType_ID = ? AND DateFrom <= ? and MinKM < ? AND MaxKM >= ?";
		MVehicleTypeSalary wagePercent = new Query(getCtx(), MVehicleTypeSalary.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_VehicleType_ID(), dateAcct, distance, distance)
				.setOrderBy("DateFrom DESC")
				.first();
		if(wagePercent != null)
			return wagePercent.getStd_Wage();
		
		return BigDecimal.ZERO;
	}

		
}
