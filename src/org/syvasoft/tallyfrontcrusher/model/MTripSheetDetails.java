package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;
import org.compiere.model.Query;



import org.compiere.util.DB;

import io.keikai.ui.impl.ua.AbstractProtectedHandler;

public class MTripSheetDetails extends X_TF_TripSheet_details {

	private static final long serialVersionUID = 4068632459774339770L;
	public MTripSheetDetails(Properties ctx, int TF_TripSheet_details_ID, String trxName) {
		super(ctx, TF_TripSheet_details_ID, trxName);
		// TODO Auto-generated constructor stub
	}	
	public MTripSheetDetails(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord)
	{
		MTripSheet tripsheet = new MTripSheet(getCtx(), getTF_TripSheet_ID(), get_TrxName());
		
		if (getLineNo() == 0)
		{
			String sql = "SELECT COALESCE(MAX(LineNo),0)+10 FROM TF_TripSheet_details WHERE tf_tripsheet_ID = ?";
			int ii = DB.getSQLValue (get_TrxName(), sql, getTF_TripSheet_ID());
			setLineNo(ii);
			
			
		}
		if(getLineNo()==10)
			setOpening_Meter(tripsheet.getOpening_Meter());
		
		
			
				
		
		return true;
	}
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		updatenexttripopeningmeter();
		MTripSheet tripsheet = new MTripSheet(getCtx(), getTF_TripSheet_ID(), get_TrxName());
		
		if(get_ID()>0) {
			if(is_ValueChanged(COLUMNNAME_Closing_Meter)) {
			
			String Sql = "SELECT MAX(Closing_Meter) FROM TF_TripSheet_details WHERE tf_tripsheet_ID = ? ";
			BigDecimal cm = DB.getSQLValueBD(get_TrxName(), Sql, getTF_TripSheet_ID());
			BigDecimal om = tripsheet.getOpening_Meter();
		    BigDecimal rm = cm.subtract(om);
		 	
			tripsheet.setClosing_Meter(cm);
 	 	    tripsheet.setRunning_Meter(rm);
			
			
			tripsheet.saveEx();
			}
		}
		
		
		return success;
		
		
	}
	
	
	
	public void updatenexttripopeningmeter() {
	
	String whereClause = "TF_TripSheet_ID = ? AND LineNo > ? ";
	
	MTripSheetDetails loadtrips = new Query(getCtx(), MTripSheetDetails.Table_Name, whereClause, get_TrxName())
			.setClient_ID()
			.setParameters(getTF_TripSheet().getTF_TripSheet_ID(),getLineNo())
			.setOrderBy(COLUMNNAME_LineNo)
			.first();
	       
			if(loadtrips != null && is_ValueChanged(COLUMNNAME_Closing_Meter)) {
				loadtrips.setOpening_Meter(getClosing_Meter());
				loadtrips.saveEx();
			}
				
	
	
		
		
	}
		
				 
		
		 
	


	

}

