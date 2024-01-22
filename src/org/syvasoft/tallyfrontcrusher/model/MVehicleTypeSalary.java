package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MVehicleTypeSalary extends X_TF_VehicleTypeSalary {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5444549276169081581L;

	public MVehicleTypeSalary(Properties ctx, int TF_VehicleTypeSalary_ID, String trxName) {
		super(ctx, TF_VehicleTypeSalary_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MVehicleTypeSalary(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	
}
