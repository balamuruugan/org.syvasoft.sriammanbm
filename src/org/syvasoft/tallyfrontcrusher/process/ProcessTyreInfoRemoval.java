package org.syvasoft.tallyfrontcrusher.process;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTyre;
import org.syvasoft.tallyfrontcrusher.model.MTyreAssignment;

public class ProcessTyreInfoRemoval extends SvrProcess {
	
	private Timestamp ReleaseDate;
	private BigDecimal EndMeter;
	MTyreAssignment tAssign;

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		tAssign=new MTyreAssignment(getCtx(), getRecord_ID(), get_TrxName());
		ProcessInfoParameter[] para = getParameter();
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("RD_ReleasedDate"))
				ReleaseDate=para[i].getParameterAsTimestamp();
			if(name.equals("End_Meter"))
				EndMeter=para[i].getParameterAsBigDecimal();
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
			mTyre.ReleaseTyre(MTyreAssignment.TYREASSIGNMENTTYPE_ReleaseToStock,
					mTyre.getTF_Tyre_ID(),
					mTyre.getlastTyreMovementID(mTyre.getCurrent_TyreType_ID(),
							mTyre.getTF_Tyre_ID()) ,ReleaseDate,EndMeter);
		}

		return null;
	}

}
