package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.TimeUtil;

public class MTyreAssignment extends X_TF_TyreAssignment {

	
	public MTyreAssignment(Properties ctx, int TF_TyreAssignment_ID,
			String trxName) {
		super(ctx, TF_TyreAssignment_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MTyreAssignment(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void updateTyreLifeRunningMeter() {
		//Update Tyre Life's Running Meter
		MTyreLife tlife = MTyreLife.getTyreLife(getTF_Tyre_ID(), getTF_TyreType_ID(), get_TrxName());
		if(tlife == null) {					
			throw new AdempiereException("Please Create Tyre Life Record for Tyre Type : " + getTF_TyreType().getName());
		}
		tlife.calcActualRunningMeter();
		tlife.saveEx();
	}	
	
	private boolean isLatestAssignedTyreMovement() {
		String sql = "SELECT COUNT(*) FROM TF_TyreMovement WHERE TF_Tyre_ID = ? AND TF_TyreType_ID = ? AND MovementDate>?";
		int count = DB.getSQLValue(get_TrxName(), sql, getTF_Tyre_ID(), getTF_TyreType_ID(), getAD_MovementDate());
		return (count == 0);
	}
	
	private boolean isLatestReleasedTyreMovement() {
		String sql = "SELECT COUNT(*) FROM TF_TyreMovement WHERE TF_Tyre_ID = ? AND TF_TyreType_ID = ? AND EndDate>?";
		int count = DB.getSQLValue(get_TrxName(), sql, getTF_Tyre_ID(), getTF_TyreType_ID(), getRD_ReleasedDate());
		return (count == 0);
	}
	private boolean isLatestReleaseDocument() {
		String sql = " SELECT COUNT(*) FROM TF_TyreMovement WHERE TF_Tyre_ID = ? AND MovementDate > ?";
		int count1 = DB.getSQLValue(get_TrxName(), sql, getTF_Tyre_ID(), getRD_ReleasedDate());
		return (count1 == 0);
	}
	
	private boolean isLatestTyreChangeDocument() {
		String sql = " SELECT COUNT(*) FROM TF_TyreStatusChange WHERE TF_Tyre_ID = ? AND DateAcct > ? ";
		int count = DB.getSQLValue(get_TrxName(), sql, getTF_Tyre_ID(), getRD_ReleasedDate());
		return (count == 0);
	}
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			if(getRD_AssignedDate() != null && getRD_ReleasedDate() != null &&
					TimeUtil.getDaysBetween(getRD_AssignedDate(), getRD_ReleasedDate())<=0) {
				throw new AdempiereException("You cannot give less than assignment Date for Release Date");				
			}
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			MTyre tyre = new MTyre(getCtx(), getTF_Tyre_ID(), get_TrxName());
			//Release Tyre
			if(getTyreAssignmentType().equals(TYREASSIGNMENTTYPE_ReleaseToStock) ||
					getTyreAssignmentType().equals(TYREASSIGNMENTTYPE_ReleaseAndAssign)) {					
				
				if(getRD_TF_TyreMovement_ID()==0) {
					throw new AdempiereException("Invalid Tyre Release!");
				}
				
				//Update Tyre Movement with End Meter and Date
				MTyreMovement tmov = new MTyreMovement(getCtx(), getRD_TF_TyreMovement_ID(), get_TrxName());
				tmov.setEnd_Meter(getRD_End_Meter());
				tmov.setEndDate(getRD_ReleasedDate());
				tmov.setRunning_Meter(getRD_Running_Meter());
				if(tmov.getDescription() != null)
					tmov.setDescription(tmov.getDescription() + " | " + getDescription());
				else
					tmov.setDescription(getDescription());
				tmov.saveEx();
				
				updateTyreLifeRunningMeter();
				
				//Update Tyre Status info
				if(isLatestReleasedTyreMovement()) {
					tyre.setTF_TyreStatus_ID(MTyreStatus.getTyreStatus(MTyreStatus.TYRESTATUSTYPE_Stocked));				
					tyre.setMounted_To_ID(0);
					tyre.setTF_TyrePosition_ID(0);
				}
				else {
					throw new AdempiereException("You cannot complete entry for the old date!");
				}
				tyre.calcRunningMeter();
			}
			
			//Assign Tyre
			if(getTyreAssignmentType().equals(TYREASSIGNMENTTYPE_AssignFromStock) || 
					getTyreAssignmentType().equals(TYREASSIGNMENTTYPE_ReleaseAndAssign)) {
				if(!tyre.isAssignable()) {
					throw new AdempiereException("Invalid Tyre!. Please check current status of the Tyre!");
				}
				//Create Tyre Movement
				MTyreMovement tmov = new MTyreMovement(getCtx(), 0, get_TrxName());
				tmov.setTF_Tyre_ID(getTF_Tyre_ID());
				tmov.setTF_TyreType_ID(getTF_TyreType_ID());
				tmov.setMovementDate(getAD_MovementDate());
				tmov.setVehicle_ID(getAD_To_Vehicle_ID());
				tmov.setTF_TyrePosition_ID(getAD_TF_TyrePosition_ID());
				tmov.setStart_Meter(getAD_Start_Meter());
				tmov.setRunning_Meter(BigDecimal.ZERO);
				tmov.setDescription(getDescription());
				tmov.saveEx();
				
				setAD_TF_TyreMovement_ID(tmov.getTF_TyreMovement_ID());
				
				//Update Tyre Status info
				if(isLatestAssignedTyreMovement()) {
					tyre.setTF_TyreStatus_ID(MTyreStatus.getTyreStatus(MTyreStatus.TYRESTATUSTYPE_Running));
					tyre.setMounted_To_ID(tmov.getVehicle_ID());
					tyre.setTF_TyrePosition_ID(tmov.getTF_TyrePosition_ID());
				}
				else {
					throw new AdempiereException("You cannot complete entry for the old date!");
				}

				tyre.calcRunningMeter();				
			}
			tyre.saveEx();
			
			if(getTyreAssignmentType().equals(TYREASSIGNMENTTYPE_ReleaseToStock) && getSendTo()!=null) {
				//Send to Scrap
				if(getSendTo().equals("S")) {
					SendToScrap(tyre);
				}
				//Send to Rebutton
				else if(getSendTo().equals("R")) {
					SendToRebutton(tyre);
				}
			}
		}
	}
	private void SendToScrap(MTyre tyre) {
		MTyreStatusChange ts=new MTyreStatusChange(getCtx(), 0, get_TrxName());
		ts.setAD_Org_ID(getAD_Org_ID());
		ts.setTF_Tyre_ID(getTF_Tyre_ID());
		ts.setDateAcct(getRD_ReleasedDate());
		ts.setCurr_TF_TyreStatus_ID(tyre.getTF_TyreStatus().getTF_TyreStatus_ID());
		ts.setNew_TF_TyreStatus_ID(MTyreStatus.SCRAPPED);
		ts.setCurr_TF_TyreType_ID(tyre.getCurrent_TyreType_ID());
		ts.setNew_TF_TyreType_ID(MTyreStatus.SCRAPPED);
		ts.setReason("Scrapped");
		ts.setDocStatus(DOCSTATUS_Drafted);
		ts.saveEx();
		ts.processIt(DOCACTION_Complete);
		ts.saveEx();
		
		setTF_TyreStatusChange_ID(ts.getTF_TyreStatusChange_ID());
	}
	private void SendToRebutton(MTyre tyre) {
		MTyreRebuttonDelivery tr=new MTyreRebuttonDelivery(getCtx(), 0, get_TrxName());
		tr.setAD_Org_ID(getAD_Org_ID());
		tr.setDateAcct(getRD_ReleasedDate());
		tr.setC_BPartner_ID(getC_BPartner_ID());
		tr.setDocStatus(DOCSTATUS_Drafted);
		tr.saveEx();
		
		MTyreRebuttonDeliveryLine trl=new MTyreRebuttonDeliveryLine(getCtx(), 0, get_TrxName());
		trl.setAD_Org_ID(getAD_Org_ID());
		trl.setTF_Tyre_RBDelivery_ID(tr.getTF_Tyre_RBDelivery_ID());
		trl.setLineNo(10);
		trl.setTF_Tyre_ID(getTF_Tyre_ID());
		trl.setTF_TyreType_ID(getTF_TyreType_ID());
		trl.setBrand(tyre.getBrand());
		trl.setDescription(tyre.getDescription());
		trl.setSize(tyre.getSize());
		trl.saveEx();
		
		setTF_Tyre_RBDelivery_ID(tr.getTF_Tyre_RBDelivery_ID());
		
		tr.processIt(DOCACTION_Complete);
		tr.saveEx();
	}
	public void reverseIt() {
		setProcessed(false);
		setDocStatus(DOCSTATUS_Drafted);
		
		MTyre tyre = new MTyre(getCtx(), getTF_Tyre_ID(), get_TrxName());

		//Reverse Scrap Tyre Entry
		if(getTF_TyreStatusChange_ID()>0) {
			if(isLatestTyreChangeDocument()) {
				MTyreStatusChange ts=new MTyreStatusChange(getCtx(), getTF_TyreStatusChange_ID(), get_TrxName());
				ts.reverseIt();
				ts.setDocStatus(DOCSTATUS_Voided);
				ts.setProcessed(true);
				ts.saveEx();
				setTF_TyreStatusChange_ID(0);
			}
		}
		
		//Reverse the Rebutton Tyre Entry
		if(getTF_Tyre_RBDelivery_ID()>0) {
			if(isLatestReleaseDocument()) {
				MTyreRebuttonDelivery tr=new MTyreRebuttonDelivery(getCtx(), getTF_Tyre_RBDelivery_ID(), get_TrxName());
				tr.reverseIt();
				tr.setDocStatus(DOCSTATUS_Voided);
				tr.setProcessed(true);
				tr.saveEx();
				setTF_Tyre_RBDelivery_ID(0);
			}
			else {
				throw new AdempiereException("You cannot reverse the entry for old date!");
			}
		}

		//Reverse Assign Tyre Entry
		if(getAD_TF_TyreMovement_ID() > 0 && getTyreAssignmentType().equals(TYREASSIGNMENTTYPE_AssignFromStock)) {
			//Assigned Tyre Movement
			MTyreMovement tMov = new MTyreMovement(getCtx(),getAD_TF_TyreMovement_ID() , get_TrxName());
			if(tMov.getEndDate() != null ) {
				throw new AdempiereException("You cannot reverse the assigned tyre entry until you reverse the released tyre entry!");
			}
			setAD_TF_TyreMovement_ID(0);
			tMov.delete(true);
			
			
			//Reverse Tyre Status info
			if(isLatestAssignedTyreMovement()) {
				tyre.setTF_TyreStatus_ID(MTyreStatus.getTyreStatus(MTyreStatus.TYRESTATUSTYPE_Stocked));				
				tyre.setMounted_To_ID(0);
				tyre.setTF_TyrePosition_ID(0);
			}
			else {
				throw new AdempiereException("You cannot reverse the entry for old date!");
			}

			tyre.calcRunningMeter();
		}
		
		//Reverse Release Tyre Entry
		if(getRD_TF_TyreMovement_ID() > 0 && getTyreAssignmentType().equals(TYREASSIGNMENTTYPE_ReleaseToStock)) {						
			//Reverse TyreMovement
			MTyreMovement tMov = new MTyreMovement(getCtx(),getRD_TF_TyreMovement_ID() , get_TrxName());
			tMov.setEnd_Meter(null);
			tMov.setRunning_Meter(BigDecimal.ZERO);
			tMov.setEndDate(null);
			tMov.saveEx();
			
			//Reverse Actual Running Meter in Tyre Life Record			
			updateTyreLifeRunningMeter();		
			
			//Reverse Tyre Status info
			if(isLatestReleasedTyreMovement()) {
				tyre.setTF_TyreStatus_ID(MTyreStatus.getTyreStatus(MTyreStatus.TYRESTATUSTYPE_Running));				
				tyre.setMounted_To_ID(getRD_From_Vehicle_ID());
				tyre.setTF_TyrePosition_ID(getRD_TF_TyrePosition_ID());
			}
			else {
				throw new AdempiereException("You cannot reverse the entry for old date!");
			}

			tyre.calcRunningMeter();
		}		
		tyre.saveEx();
	}
}
