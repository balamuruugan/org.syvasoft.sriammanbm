package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTyre;
import org.syvasoft.tallyfrontcrusher.model.MTyreAssignment;

public class ProcessTyreInfoAssignment extends SvrProcess{

	private Timestamp movementDate;
	private int Vehicle_ID,TyrePosition_ID;
	private BigDecimal StartMeter;
	MTyreAssignment tAssign;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		tAssign=new MTyreAssignment(getCtx(), getRecord_ID(), get_TrxName());
		ProcessInfoParameter[] para = getParameter();
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("AD_MovementDate"))
				movementDate=para[i].getParameterAsTimestamp();
			if(name.equals("M_Product_ID"))
				Vehicle_ID=para[i].getParameterAsInt();
			if(name.equals("TF_TyrePosition_ID"))
				TyrePosition_ID=para[i].getParameterAsInt();
			if(name.equals("RD_Start_Meter"))
				StartMeter=para[i].getParameterAsBigDecimal();
		}

	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		String whereClause = " EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
				 " T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = TF_Tyre.TF_Tyre_ID)"; 
		
		List<MTyre> tyres = new Query(getCtx(), MTyre.Table_Name, whereClause, get_TrxName())
				.setClient_ID().setParameters(getAD_PInstance_ID()).list();
		for (MTyre mTyre : tyres) {
			mTyre.AssignTyre(MTyreAssignment.TYREASSIGNMENTTYPE_AssignFromStock,mTyre.getTF_Tyre_ID(), Vehicle_ID,movementDate,TyrePosition_ID,StartMeter);
		}
		return null;
	}

}
