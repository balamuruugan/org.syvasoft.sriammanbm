package org.syvasoft.tallyfrontcrusher.process;

import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTyre;
import org.syvasoft.tallyfrontcrusher.model.MTyreAssignment;
import org.syvasoft.tallyfrontcrusher.model.MTyreStatusChange;

public class ProcessTyreInfoStatusChange extends SvrProcess {

	private int TF_NewStatus_ID;
	private String Reason;
	MTyreStatusChange mTyreStatusChange;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		mTyreStatusChange=new MTyreStatusChange(getCtx(), getRecord_ID(), get_TrxName());
		ProcessInfoParameter[] para = getParameter();
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("New_TF_TyreStatus_ID"))
				TF_NewStatus_ID=para[i].getParameterAsInt();
			if(name.equals("Reason"))
				Reason=para[i].getParameterAsString();
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
			mTyre.TyreStatusChange(mTyre.getTF_Tyre_ID(),TF_NewStatus_ID , Reason);
		}
		return null;
	}

}
