package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.util.List;

import org.compiere.model.MProject;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.syvasoft.tallyfrontcrusher.callout.CalloutUtil;
import org.syvasoft.tallyfrontcrusher.model.MMachinery;
import org.syvasoft.tallyfrontcrusher.model.MQuarry;
import org.syvasoft.tallyfrontcrusher.model.MTripSheet;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.MTripSheetDetails;

public class ProcessCreateDetails extends SvrProcess {
   // MTripSheet tripsheet;
    
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		MTripSheet tripsheet = new MTripSheet(getCtx(), getRecord_ID(), get_TrxName());
		MMachinery machinery = new MMachinery(getCtx(),tripsheet.getPM_Machinery_ID(), get_TrxName());
		String Whereclause = " TF_RentedVehicle_ID = ? AND TareWeightTime >= ? AND GrossWeightTime <= ?  "
				               +"AND Status IN ('CO','CL')"
		                       +"AND NOT EXISTS (SELECT * FROM TF_TripSheet_details WHERE TF_WeighmentEntry_ID = TF_WeighmentEntry.TF_WeighmentEntry_ID) " ;
	
	
		List<MWeighmentEntry> list = new Query(getCtx(), MWeighmentEntry.Table_Name, Whereclause,get_TrxName())
				.setClient_ID()
				.setParameters(machinery.getTF_RentedVehicle_ID(),tripsheet.getDateStart(),tripsheet.getDateEnd())
				.list();
		
		
		for(MWeighmentEntry m : list) {
	    MTripSheetDetails td = new MTripSheetDetails(getCtx(), 0, get_TrxName());
	    MProject pro = new MProject(getCtx(), 0, get_TrxName());

	    
	    td.setAD_Org_ID(tripsheet.getAD_Org_ID());
	    td.setTF_TripSheet_ID(tripsheet.getTF_TripSheet_ID());
	    td.setM_Product_ID(m.getM_Product_ID());
	    td.setTonnage(m.getNetWeightUnit());
  
	    td.setTF_WeighmentEntry_ID(m.getTF_WeighmentEntry_ID());
	    td.setStartTime(m.getTareWeightTime());

	    if(m.getWeighmentEntryType().equals("3PR")) {
	    	td.setFrom1(m.getTF_Quarry().getName());
	    	td.setTo1(m.getM_Warehouse().getName());
	    }
	    else if(m.getWeighmentEntryType().equals("1SO")) {
	    	td.setFrom1(m.getM_Warehouse().getName());
	    	td.setTo1(m.getTF_Destination().getName());
	    }
	    else if(m.getWeighmentEntryType().equals("2PO")) {
	    	td.setFrom1(m.getTF_Destination().getName());
	    	td.setTo1(m.getM_Warehouse().getName());
	    }
	    else if(m.getWeighmentEntryType().equals("4SR")) {
	    	int weighment_id = m.get_ID();
	    	String sql = "SELECT q.Name  FROM TF_WeighmentEntry w LEFT JOIN "
	    			+ "C_Project pr ON w.C_Project_ID = pr.C_Project_ID LEFT JOIN "
	    			+ "TF_Quarry q ON pr.TF_Quarry_ID = q.TF_Quarry_ID "
	    			+ "WHERE w.TF_WeighmentEntry_ID = ?";
	    	String quarry = DB.getSQLValueString(get_TrxName(), sql, weighment_id);
	    	td.setFrom1(quarry);
	    	td.setTo1(m.getM_Warehouse().getName());
	    	
	    	
	    }
	    
	    
	    
	    
	    
	    td.saveEx();
	    
	    
		
		}
		
		return null;
	}
	

}
