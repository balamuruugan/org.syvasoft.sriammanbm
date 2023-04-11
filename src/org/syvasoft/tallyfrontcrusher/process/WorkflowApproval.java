package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.wf.MWFActivity;

public class WorkflowApproval extends SvrProcess{
	
	private String		p_IsApproved = null;
	private int			p_AD_Table_ID = 0;

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null && para[i].getParameter_To() == null)
				;
			else if (name.equals("IsApproved"))
			p_IsApproved = (String)para[i].getParameter();
			else if (name.equals("AD_Table_ID"))
			p_AD_Table_ID = para[i].getParameterAsInt();
		}
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		String sql="Select AD_WF_Activity_ID from AD_WF_Activity where WFState<>'CC' and AD_Table_ID="+p_AD_Table_ID+" and Record_ID="+getRecord_ID();
		int AD_WF_Activity_ID=DB.getSQLValue(get_TrxName(), sql);
		MWFActivity MWF = new MWFActivity(getCtx(),AD_WF_Activity_ID,get_TrxName());
		MWF.setUserChoice(Env.getAD_User_ID(getCtx()),p_IsApproved,20, null);
		MWF.save();
		return null;
	}

}