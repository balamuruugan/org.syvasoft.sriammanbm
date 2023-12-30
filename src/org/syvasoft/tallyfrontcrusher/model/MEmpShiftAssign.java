package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.syvasoft.tallyfrontcrusher.model.X_TF_EmpShiftAssignment;

public class MEmpShiftAssign extends X_TF_EmpShiftAssignment {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2312275794052786246L;

	public MEmpShiftAssign(Properties ctx, int TF_EmpShiftAssignment_ID, String trxName) {
		super(ctx, TF_EmpShiftAssignment_ID, trxName);
		
	}

	public MEmpShiftAssign(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		
	}

}
