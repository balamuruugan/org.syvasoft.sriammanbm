package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MQuery;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Trx;

public class MTyre extends X_TF_Tyre {

	public MTyre(Properties ctx, int TF_Tyre_ID, String trxName) {
		super(ctx, TF_Tyre_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MTyre(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean beforeSave(boolean newRecord) {
		boolean ok = super.beforeSave(newRecord);
		if(getCurrent_TyreType_ID()==0)
			setCurrent_TyreType_ID(getPurchased_TyreType_ID());
		//if(newRecord || is_ValueChanged(COLUMNNAME_TyreNo)) {
			
		//}	
		if(newRecord) {
			String sql = "SELECT COUNT(*) FROM TF_Tyre WHERE TyreNo=?";
			int count = DB.getSQLValue(get_TrxName(), sql, getTyreNo());
			if(count > 0) 
				throw new AdempiereException("Tyre No:" + getTyreNo() + " is already existed!");
		}
		return ok;
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		boolean ok = super.afterSave(newRecord, success);
		
		if(newRecord) {
			createTyreLifeRecords(this);
		}
		//calcRunningMeter();
		return ok;
	}

	public static void createTyreLifeRecords(MTyre tyre) {
		List<MTyreType> types = new Query(tyre.getCtx(), MTyreType.Table_Name, "", null)
			.setClient_ID() .setOnlyActiveRecords(true).setOrderBy("SeqNo").list();
		int seq = 10;
		String trxName = tyre.get_TrxName(); // Trx.createTrxName();
		//Trx trans = Trx.get(trxName, true);
		//trxName = get_TrxName();
		try {
			for(MTyreType type : types) {
				MTyreLife tlife = new MTyreLife(tyre.getCtx(), 0, trxName);
				tlife.setAD_Org_ID(tyre.getAD_Org_ID());			
				tlife.setTF_Tyre_ID(tyre.getTF_Tyre_ID());
				tlife.setSeqNo(seq);
				tlife.setTF_TyreType_ID(type.getTF_TyreType_ID());
				tlife.setTyreCost(BigDecimal.ZERO);
				tlife.setEstRunning_Meter(type.getEstRunning_Meter());
				tlife.setActRunning_Meter(BigDecimal.ZERO);
				tlife.saveEx();
				seq = seq + 10;
			}
		}
		catch(Exception ex) {
			//trans.rollback();
			throw new AdempiereException(ex.getMessage());
		}
		finally {
			//trans.commit();
		}
	}
	
	public void calcRunningMeter() {
		String sql = "SELECT SUM(ActRunning_Meter) FROM TF_TyreLife WHERE TF_Tyre_ID=?";
		BigDecimal totRunningMeter = DB.getSQLValueBD(get_TrxName(), sql, getTF_Tyre_ID());
		if(totRunningMeter==null) {
			totRunningMeter = BigDecimal.ZERO;
		}
		setRunning_Meter(totRunningMeter);
	}
	
	public static MTyre createTyre(MTyrePurchase po, MTyrePurchaseLine tyrePOLine) {
		MTyre tyre = new MTyre(tyrePOLine.getCtx(), 0, tyrePOLine.get_TrxName());
		
		tyre.setAD_Org_ID(tyrePOLine.getAD_Org_ID());
		tyre.setTyreNo(tyrePOLine.getTyreNo());
		tyre.setSerNo(tyrePOLine.getTyreNo());
		tyre.setBrand(tyrePOLine.getBrand());
		tyre.setSize(tyrePOLine.getSize());
		tyre.setDatePurchased(po.getDateAcct());
		tyre.setC_BPartner_ID(po.getC_BPartner_ID());
		tyre.setTF_TyrePurchase_ID(po.getTF_TyrePurchase_ID());
		tyre.setPurchased_TyreType_ID(tyrePOLine.getTF_TyreType_ID());
		tyre.setCurrent_TyreType_ID(tyrePOLine.getTF_TyreType_ID());
		tyre.setRunning_Meter(BigDecimal.ZERO);
		tyre.setTF_TyreStatus_ID(1000004); //In stock
		tyre.saveEx();
		
		MTyreLife tLife = new Query(tyre.getCtx(), MTyreLife.Table_Name, "TF_Tyre_ID=? AND TF_TyreType_ID=?", tyre.get_TrxName())
			.setClient_ID()
			.setParameters(tyre.getTF_Tyre_ID(), tyre.getCurrent_TyreType_ID())
			.first();
		
		if(tLife == null)
			throw new AdempiereException("Tyre Life is not created for the new Tyre!");
		
		tLife.setTF_TyrePurchase_ID(po.getTF_TyrePurchase_ID());
		tLife.setTF_TyrePurchaseLine_ID(tyrePOLine.getTF_TyrePurchaseLine_ID());
		tLife.setTyreCost(tyrePOLine.getLineTotalAmt());
		tLife.saveEx();		
		
		return tyre;
	}
	
	public static void deleteTyres(MTyrePurchase po) {		
		List<MTyre> tyres = new Query(po.getCtx(), MTyre.Table_Name, "TF_TyrePurchase_ID = ?", po.get_TrxName())
			.setClient_ID()
			.setParameters(po.getTF_TyrePurchase_ID())
			.list();
		for(MTyre tyre : tyres) {			
			String sql = "DELETE FROM " + MTyreLife.Table_Name + " WHERE TF_Tyre_ID = " + tyre.getTF_Tyre_ID();
			DB.executeUpdate(sql, tyre.get_TrxName());
			tyre.delete(true);
		}
		
	}
	
	public boolean isAssignable() {
		String whereClause = "IsAssignable = 'Y' AND TF_TyreStatus_ID = " + getTF_TyreStatus_ID();
		return (new Query(getCtx(), MTyreStatus.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.first()) != null;
	}

	public int getlastTyreMovementID(int TyreTypeID,int TyreID) {
		int TF_TyreMovement_ID=0;
		String whereClause = "EndDate IS NULL AND TF_TyreType_ID="+TyreTypeID+" AND TF_Tyre_ID = " + TyreID;
		MTyreMovement movTyre=new Query(getCtx(), MTyreMovement.Table_Name, whereClause, get_TrxName())
								.setClient_ID()
								.first();
		if(movTyre!=null) {
			TF_TyreMovement_ID=movTyre.getTF_TyreMovement_ID();
		}
		return TF_TyreMovement_ID;
	}
	
	public void AssignTyre(String tyreAssignment,int TF_Tyre_ID,int Vehicle_ID,java.sql.Timestamp movementDate,int TF_TyrePosition_ID,BigDecimal StartMeter) {

		MTyre tyre=new MTyre(getCtx(), TF_Tyre_ID, get_TrxName());
		MTyreAssignment mTyreAssign=new MTyreAssignment(getCtx(), 0, get_TrxName());
		if(tyreAssignment.equals(MTyreAssignment.TYREASSIGNMENTTYPE_AssignFromStock) || 
				tyreAssignment.equals(MTyreAssignment.TYREASSIGNMENTTYPE_ReleaseAndAssign)) {
			if(!tyre.isAssignable()) {
				throw new AdempiereException("Invalid Tyre!. Please check current status of the Tyre!");
			}
			
			//Create Tyre Assignment
			mTyreAssign.setAD_Org_ID(getAD_Org_ID());
			mTyreAssign.setTF_TyreType_ID(tyre.getCurrent_TyreType_ID());
			mTyreAssign.setTyreAssignmentType(tyreAssignment);
			mTyreAssign.setTF_Tyre_ID(TF_Tyre_ID);
			mTyreAssign.setAD_TF_TyrePosition_ID(TF_TyrePosition_ID);
			mTyreAssign.setAD_To_Vehicle_ID(Vehicle_ID);
			mTyreAssign.setAD_MovementDate(movementDate);
			mTyreAssign.setAD_Start_Meter(StartMeter);
			mTyreAssign.saveEx();

			mTyreAssign.processIt(MTyreAssignment.DOCACTION_Complete);
			mTyreAssign.saveEx();

		}
	}
	
	public void ReleaseTyre(String tyreAssignment,int TF_Tyre_ID,int TF_TyreMovement_ID,java.sql.Timestamp releaseDate,BigDecimal EndMeter) {
		if(tyreAssignment.equals(MTyreAssignment.TYREASSIGNMENTTYPE_ReleaseToStock) ||
				tyreAssignment.equals(MTyreAssignment.TYREASSIGNMENTTYPE_ReleaseAndAssign)) {					
		
			if(TF_TyreMovement_ID==0) {
				throw new AdempiereException("Invalid Tyre Release!");
			}

			MTyreAssignment mTyreRelease=new MTyreAssignment(getCtx(), 0, get_TrxName());
			MTyre tyre=new MTyre(getCtx(), TF_Tyre_ID, get_TrxName());

			//Update Tyre Movement with End Meter and Date
			MTyreMovement tmov = new MTyreMovement(getCtx(), TF_TyreMovement_ID, get_TrxName());
			BigDecimal StartMeter=tmov.getStart_Meter();
			tmov.setEnd_Meter(EndMeter);
			tmov.setEndDate(releaseDate);
			tmov.setRunning_Meter(EndMeter.subtract(StartMeter));
			if(tmov.getDescription() != null)
				tmov.setDescription(tmov.getDescription() + " | " + getDescription());
			else
				tmov.setDescription(getDescription());
			tmov.saveEx();

			//Create Tyre Assignment
			mTyreRelease.setAD_Org_ID(getAD_Org_ID());
			mTyreRelease.setTF_TyreType_ID(tyre.getCurrent_TyreType_ID());
			mTyreRelease.setTyreAssignmentType(tyreAssignment);
			mTyreRelease.setTF_Tyre_ID(TF_Tyre_ID);
			mTyreRelease.setRD_TF_TyreMovement_ID(TF_TyreMovement_ID);
			mTyreRelease.setRD_TF_TyrePosition_ID(tmov.getTF_TyrePosition_ID());
			mTyreRelease.setRD_From_Vehicle_ID(tmov.getVehicle_ID());
			mTyreRelease.setRD_AssignedDate(tmov.getMovementDate());
			mTyreRelease.setRD_ReleasedDate(releaseDate);
			mTyreRelease.setRD_End_Meter(EndMeter);
			mTyreRelease.setRD_Running_Meter(EndMeter.subtract(StartMeter));
			mTyreRelease.saveEx();
			
			mTyreRelease.processIt(MTyreAssignment.DOCACTION_Complete);
			mTyreRelease.saveEx();
		}
	}

	public void TyreStatusChange(int TF_Tyre_ID,int TF_NewStatus_ID,String Reason) {
		
		MTyre t=new MTyre(getCtx(), TF_Tyre_ID, get_TrxName());
		
		MTyreStatusChange tChange=new MTyreStatusChange(getCtx(), 0, get_TrxName());
		tChange.setAD_Org_ID(getAD_Org_ID());
		tChange.setTF_Tyre_ID(TF_Tyre_ID);
		tChange.setCurr_TF_TyreStatus_ID(t.getTF_TyreStatus_ID());
		tChange.setCurr_TF_TyreType_ID(t.getCurrent_TyreType_ID());
		tChange.setNew_TF_TyreStatus_ID(TF_NewStatus_ID);
		tChange.setReason(Reason);
		tChange.saveEx();
		
		tChange.processIt(MTyreAssignment.DOCACTION_Complete);
		tChange.saveEx();
		
	}
}
