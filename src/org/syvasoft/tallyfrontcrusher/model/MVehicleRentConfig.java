package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MVehicleRentConfig extends X_TF_VehicleRent_TajConfig {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8401430132407131437L;
	public MVehicleRentConfig(Properties ctx, int TF_VehicleRent_TajConfig_ID, String trxName) {
		super(ctx, TF_VehicleRent_TajConfig_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MVehicleRentConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}	

	public static BigDecimal getRate(int TF_RentedVehicle_ID, int TF_Destination_ID) {
		String whereClause = "M_Product_ID = (SELECT M_Product_ID FROM TF_RentedVehicle WHERE TF_RentedVehicle_ID = ?) " +
				" AND TF_Destination_ID = ? ";
		List<MVehicleRentConfig> rentConfigs = new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setOnlyActiveRecords(true).setParameters(TF_RentedVehicle_ID, TF_Destination_ID).list();
		if(rentConfigs.size() > 0)
			return rentConfigs.get(0).getRate();
		else
			return BigDecimal.ZERO;
	}
}
