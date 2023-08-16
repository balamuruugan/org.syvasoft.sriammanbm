package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.util.DB;

import io.keikai.ui.impl.ua.AbstractProtectedHandler;

public class M_TF_TripSheet_details extends X_TF_TripSheet_details {

	private static final long serialVersionUID = 4068632459774339770L;
	public M_TF_TripSheet_details(Properties ctx, int TF_TripSheet_details_ID, String trxName) {
		super(ctx, TF_TripSheet_details_ID, trxName);
		// TODO Auto-generated constructor stub
	}	
	public M_TF_TripSheet_details(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord)
	{
		MTripSheet tripsheet = new MTripSheet(getCtx(), 0, get_TrxName());
		
		if (getLineNo() == 0)
		{
			String sql = "SELECT COALESCE(MAX(LineNo),0)+10 FROM TF_TripSheet_details WHERE tf_tripsheet_ID = ?";
			int ii = DB.getSQLValue (get_TrxName(), sql, getTF_TripSheet_ID());
			setLineNo(ii);
			
		}
		
	
		
		
		
		
		
		return true;
	}
	

	

}
