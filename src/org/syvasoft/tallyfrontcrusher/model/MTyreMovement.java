package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.DB;

public class MTyreMovement extends X_TF_TyreMovement {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6856522115873096265L;

	public MTyreMovement(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		
	}

	public MTyreMovement(Properties ctx, int TF_TyreMovement_ID, String trxName) {
		super(ctx, TF_TyreMovement_ID, trxName);
		
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		
		if(getEndDate() != null && getEnd_Meter().equals(BigDecimal.ZERO))
			throw new AdempiereException("Please enter Removing Meter!");
		
		if(getStart_Meter().doubleValue() > 0 && getEnd_Meter().doubleValue() > 0) {
			setRunning_Meter(getEnd_Meter().subtract(getStart_Meter()));
		}
		else {
			setRunning_Meter(BigDecimal.ZERO);
		}
		
		return super.beforeSave(newRecord);
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		//updateTyreLifeRunningMeter();
		return super.afterSave(newRecord, success);
	}

	@Override
	protected boolean beforeDelete() {
		// TODO Auto-generated method stub
		return super.beforeDelete();
	}

	@Override
	protected boolean afterDelete(boolean success) {
		//updateTyreLifeRunningMeter();
		return super.afterDelete(success);
	}

	
	private void updateTyreLifeRunningMeter() {
		//Update Tyre Life's Running Meter
		MTyreLife tlife = MTyreLife.getTyreLife(getTF_Tyre_ID(), getTF_TyreType_ID(), get_TrxName());
		if(tlife == null) {					
			throw new AdempiereException("Please Create Tyre Life Record for Tyre Type : " + getTF_TyreType().getName());
		}
		tlife.calcActualRunningMeter();
		tlife.saveEx();
		
		MTyre tyre = (MTyre) getTF_Tyre();
		if(isLatestReleasedTyreMovement() && getEndDate() != null) {
			tyre.setTF_TyreStatus_ID(MTyreStatus.getTyreStatus(MTyreStatus.TYRESTATUSTYPE_Stocked));				
			tyre.setMounted_To_ID(0);
			tyre.setTF_TyrePosition_ID(0);
		}
		if(isLatestAssignedTyreMovement() && getEndDate() == null) {
			tyre.setTF_TyreStatus_ID(MTyreStatus.getTyreStatus(MTyreStatus.TYRESTATUSTYPE_Running));
			tyre.setMounted_To_ID(getVehicle_ID());
			tyre.setTF_TyrePosition_ID(getTF_TyrePosition_ID());
		}
		tyre.calcRunningMeter();
		tyre.saveEx(get_TrxName());
		
	}	

	private boolean isLatestAssignedTyreMovement() {
		String sql = "SELECT COUNT(*) FROM TF_TyreMovement WHERE TF_Tyre_ID = ? AND TF_TyreType_ID = ? AND MovementDate>?";
		int count = DB.getSQLValue(get_TrxName(), sql, getTF_Tyre_ID(), getTF_TyreType_ID(), getMovementDate());
		return (count == 0);
	}
	
	
	private boolean isLatestReleasedTyreMovement() {
		String sql = "SELECT COUNT(*) FROM TF_TyreMovement WHERE TF_Tyre_ID = ? AND TF_TyreType_ID = ? AND EndDate>?";
		int count = DB.getSQLValue(get_TrxName(), sql, getTF_Tyre_ID(), getTF_TyreType_ID(), getEndDate());
		return (count == 0);
	}
	

}
