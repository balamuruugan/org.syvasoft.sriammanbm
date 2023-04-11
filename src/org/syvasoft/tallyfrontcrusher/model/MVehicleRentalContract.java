package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MResource;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MVehicleRentalContract extends X_TF_Vehicle_Rental_Contract {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8181423157714990215L;

	public MVehicleRentalContract(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MVehicleRentalContract(Properties ctx,
			int TF_Vehicle_Rental_Contract_ID, String trxName) {
		super(ctx, TF_Vehicle_Rental_Contract_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		setContract_Amt_Act(getQty().multiply(getUnit_Price()));
		setInvoiced_Amt(getQtyInvoiced().multiply(getUnit_Price()));
		return super.beforeSave(newRecord);
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		
		return super.afterSave(newRecord, success);
	}
	
	public void processIt(String docAction) {
		if(docAction.equals(DOCACTION_Start)) {
			// Validations
			if(getOpening_Meter().doubleValue() <= 0) {
				throw new AdempiereException("Opening Meter should be greater than ZERO!");
			}
			else if(getUnit_Price().doubleValue() <= 0) {
				throw new AdempiereException("Invalid Unit Price!");
			}
					
			//Create resource if it is new
			TF_MResource res = TF_MResource.getTF_MResource(getCtx(), getVehicleNo());
			if(res == null) {
				res = new TF_MResource(getCtx(), 0, get_TrxName());
				res.setS_ResourceType_ID(getS_ResourceType_ID());
				res.setName(res.getS_ResourceType().getName() + "-" + getVehicleNo());
				res.setValue(getVehicleNo());				
				int userID = Env.getAD_User_ID(getCtx());
				res.setAD_User_ID(userID);
				int warehouseID = Env.getContextAsInt(getCtx(), "#M_Warehouse_ID");
				res.setM_Warehouse_ID(warehouseID);
				res.setIsAvailable(true);
				res.setIsRented(true);
			}
			else {
				res.setIsAvailable(true);
				res.setIsRented(true);
				res.setIsActive(true);
			}
			res.saveEx();
			
			setDocStatus(DOCSTATUS_InProgress);
			setS_Resource_ID(res.getS_Resource_ID());
			setM_Product_ID(res.getProduct().getM_Product_ID());			
			
		}
		else if(docAction.equals(DOCACTION_End)) {
			//Validations
			//1. Quantity Actual = Quantity Invoiced
			if(getQty().doubleValue() != getQtyInvoiced().doubleValue())
				throw new AdempiereException("Please Invoice the Uninvoiced qty!");
			//2. Diesel Issued Total Qty = Diesel Deducted Qty			
			if(isFuelIncluded() && getFuel_Issued_Total_Qty().doubleValue() != getFuel_Deducted_Qty().doubleValue())
				throw new AdempiereException("Please invoice to deduct the undeducted diesel!");
			
			TF_MResource res = TF_MResource.getTF_MResource(getCtx(), getVehicleNo());
			if(res != null) {
				res.setIsAvailable(false);
				res.setIsActive(false);
				res.saveEx();
			}
			setProcessed(true);
			setDocStatus(DOCSTATUS_Completed);
		}
		else if(docAction.equals(DOCACTION_Modify)) {
			TF_MResource res = TF_MResource.getTF_MResource(getCtx(), getVehicleNo());
			if(res != null) {
				res.setIsAvailable(false);
				res.setIsActive(false);
				res.saveEx();
			}
			setDocStatus(DOCSTATUS_Drafted);			
		}
		else if(docAction.equals(DOCACTION_ForceClose)) {
			TF_MResource res = TF_MResource.getTF_MResource(getCtx(), getVehicleNo());
			if(res != null) {
				res.setIsAvailable(false);
				res.setIsActive(false);
				res.saveEx();
			}
			setDocStatus(DOCSTATUS_Closed);
			setProcessed(true);
		}
	}
	
	public void updateTripSheetBasedFields() {
		int rentalContractID = getTF_Vehicle_Rental_Contract_ID();
		
		//Set Closing Meter
		String sql = "SELECT MAX(Closing_Meter) FROM TF_TripSheet WHERE TF_Vehicle_Rental_Contract_ID = ? AND Processed='Y'";
		BigDecimal closingMeter = DB.getSQLValueBD(get_TrxName(), sql, rentalContractID);			
		if(closingMeter != null)
			setClosing_Meter(closingMeter);
		else
			setClosing_Meter(BigDecimal.ZERO);
		
		//Set Running Meter
		sql = "SELECT SUM(Running_Meter) FROM TF_TripSheet WHERE TF_Vehicle_Rental_Contract_ID = ? AND Processed='Y'";
		BigDecimal runningMeter = DB.getSQLValueBD(get_TrxName(), sql, rentalContractID);
		if(runningMeter != null)
			setRunning_Meter(runningMeter);
		else
			setRunning_Meter(BigDecimal.ZERO);
		
		//Set Issued Fuel
		sql = "SELECT SUM(Received_Fuel) FROM TF_TripSheet WHERE TF_Vehicle_Rental_Contract_ID = ? AND Processed='Y'";
		BigDecimal receivedFuel = DB.getSQLValueBD(get_TrxName(), sql, rentalContractID);
		if(receivedFuel != null)
			setIssued_Fuel(receivedFuel);
		else
			setIssued_Fuel(BigDecimal.ZERO);
		
		if(CONTRACTBASE_Meter.equals(getContractBase())) {
			setQty(getRunning_Meter());
		}
		else if(CONTRACTBASE_Day.equals(getContractBase())) {
			sql = " SELECT COUNT(DISTINCT DateReport) FROM TF_TripSheet WHERE TF_Vehicle_Rental_Contract_ID =? AND Processed='Y'";
			BigDecimal qty = DB.getSQLValueBD(get_TrxName(), sql, rentalContractID);			
			if(qty != null)
				setQty(qty);
			else 
				setQty(BigDecimal.ZERO);
		}
		
	}
	
	public static int getActiveRentalContract(int VehicleID) {
		String sql = " SELECT TF_Vehicle_Rental_Contract_ID FROM TF_Vehicle_Rental_Contract WHERE M_Product_ID = ? AND " 
				+ " DocStatus='IP' ";
		int contractID = DB.getSQLValue(null, sql, VehicleID);
		return contractID;
	}

}
