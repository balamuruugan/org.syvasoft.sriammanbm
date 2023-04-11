package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;

public class MJobworkIssuedResource extends X_TF_Jobwork_IssuedResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5411092166182775782L;

	public MJobworkIssuedResource(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MJobworkIssuedResource(Properties ctx,
			int TF_Jobwork_IssuedResource_ID, String trxName) {
		super(ctx, TF_Jobwork_IssuedResource_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static int getJobworkID(int VehicleID) {
		String sql = " SELECT C_Project_ID FROM TF_Jobwork_IssuedResource WHERE M_Product_ID = ? AND " 
				+ " ContractStatus='A' ORDER BY Created DESC";
		int jobWorkID = DB.getSQLValue(null, sql, VehicleID);
		return jobWorkID;
	}
	
	public static MJobworkIssuedResource getByResource(Properties ctx, int C_Project_ID, int M_Product_ID, String trxName) {
		String whereClause = " C_Project_ID = ? AND M_Product_ID = ? AND ContractStatus = 'A' ";
		List<MJobworkIssuedResource> list = new Query(ctx, Table_Name, whereClause, trxName)
			.setParameters(C_Project_ID, M_Product_ID).setOrderBy(" ContractStatus ").list();
		MJobworkIssuedResource res = null;
		if(list.size() > 0) {
			res = list.get(0);
		}
		return res;		
	}

	public static List<MJobworkIssuedResource> getVehicleRentToDeduct(Properties ctx, int C_Project_ID) {
		String whereClause = " C_Project_ID = ? AND Qty > QtyDeducted";
		List<MJobworkIssuedResource> list = new Query(ctx, Table_Name, whereClause, null)
			.setParameters(C_Project_ID).list();
		return list;
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		//To keep the amount calculated from Rent Entry 
		if(!is_ValueChanged(COLUMNNAME_Contract_Amt_Act))
			setContract_Amt_Act(getQty().multiply(getUnit_Price()));
		//setDeductedAmt(getUnit_Price().multiply(getQtyDeducted()));
		if(is_ValueChanged(COLUMNNAME_ContractBase))
			updateTripSheetBasedFields();
		return super.beforeSave(newRecord);
	}
	
	public void updateTripSheetBasedFields() {
		//get Running Meter
		String sql = "SELECT SUM(Running_Meter) FROM TF_TripSheet WHERE C_Project_ID = ? AND Vehicle_ID = ? AND Processed='Y'";
		BigDecimal runningMeter = DB.getSQLValueBD(get_TrxName(), sql, getC_Project_ID(), getM_Product_ID());
		
		if(runningMeter == null)
			runningMeter = BigDecimal.ZERO;
		
		if(CONTRACTBASE_Meter.equals(getContractBase())) {
			setQty(runningMeter);
		}
		else if(CONTRACTBASE_Day.equals(getContractBase())) {
			sql = " SELECT COUNT(DISTINCT DateReport) FROM TF_TripSheet WHERE C_Project_ID = ? AND Vehicle_ID = ? AND Processed='Y'";
			BigDecimal qty = DB.getSQLValueBD(get_TrxName(), sql, getC_Project_ID(), getM_Product_ID());			
			if(qty != null)
				setQty(qty);
			else 
				setQty(BigDecimal.ZERO);
		}
		
		
		//get Total Wage
		sql = "SELECT SUM(Total_Wage) FROM TF_TripSheet WHERE C_Project_ID = ? AND Vehicle_ID = ? AND Processed='Y'";
		BigDecimal totalWage = DB.getSQLValueBD(get_TrxName(), sql, getC_Project_ID(), getM_Product_ID());
		
		if(totalWage!=null && !isOperatorWageIncluded()) {
			setOperatorTotalWage(totalWage);
		}
		else {
			setOperatorTotalWage(BigDecimal.ZERO);
		}
		
	}
	
}
