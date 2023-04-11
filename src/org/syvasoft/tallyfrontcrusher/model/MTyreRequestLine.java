package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;

public class MTyreRequestLine extends X_TF_TyreRequestLine {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3114424266486154800L;
	public MTyreRequestLine(Properties ctx, int TF_TyreRequestLine_ID, String trxName) {
		super(ctx, TF_TyreRequestLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MTyreRequestLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		// TODO Auto-generated method stub
		if(getEnd_Meter().compareTo(getStart_Meter())==-1) {
			throw new AdempiereException("Removing KM cannot be less than Fitting KM");
		}
		return super.afterSave(newRecord, success);
	}
	
	

}
