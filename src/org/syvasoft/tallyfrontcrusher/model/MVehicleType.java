package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

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

		
}
