package org.syvasoft.tallyfrontcrusher.process;

import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MMachinery;
import org.syvasoft.tallyfrontcrusher.model.MTripSheet;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.M_TF_TripSheet_details;

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
		String Whereclause = " TF_RentedVehicle_ID = ? AND TareWeightTime >= ? AND GrossWeightTime <= ?" ;
	
	
		List<MWeighmentEntry> list = new Query(getCtx(), MWeighmentEntry.Table_Name, Whereclause,get_TrxName())
				.setClient_ID()
				.setParameters(machinery.getTF_RentedVehicle_ID(),tripsheet.getDateStart(),tripsheet.getDateEnd())
				.list();
		
		
		for(MWeighmentEntry m : list) {
	    M_TF_TripSheet_details td = new M_TF_TripSheet_details(getCtx(), 0, get_TrxName());
	    td.setAD_Org_ID(tripsheet.getAD_Org_ID());
	    td.setTF_TripSheet_ID(tripsheet.getTF_TripSheet_ID());
	    td.setM_Product_ID(m.getM_Product_ID());
	    td.setTF_WeighmentEntry_ID(m.getTF_WeighmentEntry_ID());
	    td.setStartTime(m.getTareWeightTime());
	    td.setEndTime(m.getGrossWeightTime());
	    td.saveEx();
		
		}
		
		return null;
	}
	

}
