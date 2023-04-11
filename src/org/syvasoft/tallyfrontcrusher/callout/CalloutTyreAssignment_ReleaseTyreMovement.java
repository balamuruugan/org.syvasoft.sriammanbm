package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTyreAssignment;
import org.syvasoft.tallyfrontcrusher.model.MTyreMovement;

public class CalloutTyreAssignment_ReleaseTyreMovement implements
		IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		int tMovID = 0;
		//Release Tyre Fields
		int fromVehicleID = 0;
		int fromTyrePositionID = 0;
		Timestamp assignedDate = null;
		BigDecimal releasedStartMeter = BigDecimal.ZERO;
		BigDecimal releasedEndMeter = BigDecimal.ZERO;
		BigDecimal assignedStartMeter = null;
		
		if(mTab.getValue(MTyreAssignment.COLUMNNAME_RD_TF_TyreMovement_ID) != null) {
			tMovID = (int) mTab.getValue(MTyreAssignment.COLUMNNAME_RD_TF_TyreMovement_ID);
			MTyreMovement tMov = new MTyreMovement(ctx, tMovID, null);
			fromVehicleID = tMov.getVehicle_ID();
			fromTyrePositionID = tMov.getTF_TyrePosition_ID();
			assignedDate = tMov.getMovementDate();
			releasedStartMeter = tMov.getStart_Meter();			
		}
		
		mTab.setValue(MTyreAssignment.COLUMNNAME_RD_From_Vehicle_ID, fromVehicleID);
		mTab.setValue(MTyreAssignment.COLUMNNAME_RD_TF_TyrePosition_ID, fromTyrePositionID);
		mTab.setValue(MTyreAssignment.COLUMNNAME_RD_AssignedDate, assignedDate);
		mTab.setValue(MTyreAssignment.COLUMNNAME_RD_Start_Meter, releasedStartMeter);
		
		return null;
	}

}
