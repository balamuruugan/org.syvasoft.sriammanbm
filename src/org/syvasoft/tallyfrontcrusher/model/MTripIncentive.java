package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;
import org.syvasoft.tallyfrontcrusher.process.GenerateTaxInvoiceLines;

public class MTripIncentive extends X_TF_TripIncentive {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6501155574861042742L;

	public MTripIncentive(Properties ctx, int TF_TripIncentive_ID, String trxName) {
		super(ctx, TF_TripIncentive_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTripIncentive(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static void generateIncentiveLines(Properties ctx, MTripSheet ts) {
		String whereClause = "TF_TripSheet_ID = ? ";
		List<MWeighmentEntry> list = new Query(ctx, MWeighmentEntry.Table_Name, whereClause, ts.get_TrxName())
				.setClient_ID()
				.setParameters(ts.get_ID())
				.setOrderBy("GrossWeightTime")
				.list();
		
		String sqlDelete = "DELETE FROM TF_TripIncentive WHERE TF_TripSheet_ID = " + ts.get_ID() + " AND IsGenerated='Y'";
		DB.executeUpdate(sqlDelete, ts.get_TrxName());
		
		for(MWeighmentEntry we : list) {
			
			BigDecimal incentive = MTripIncentiveConfig.getIncentive(ctx, we.getAD_Org_ID(), we.getWeighmentEntryType(), we.getTF_Destination_ID(), we.getTF_VehicleType_ID(), we.getGrossWeightTime());
			
			MTripIncentive inc = new MTripIncentive(ctx, 0, ts.get_TrxName());
			inc.setTF_TripSheet_ID(ts.getTF_TripSheet_ID());
			inc.setAD_Org_ID(ts.getAD_Org_ID());
			inc.setTF_WeighmentEntry_ID(we.get_ID());
			inc.setInvoiceNo(we.getInvoiceNo());
			inc.setC_BPartner_ID(we.getC_BPartner_ID());
			inc.setNetWeightUnit(we.getNetWeightUnit());
			inc.setTF_Destination_ID(we.getTF_Destination_ID());
			inc.setIncentive(incentive);
			inc.setIsGenerated(true);
			inc.saveEx();
			
		}
				
	}

}
