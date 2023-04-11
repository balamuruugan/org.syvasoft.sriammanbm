package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MLabourWageIssue;

public class ProcessLabourWageIssue extends SvrProcess {

	private String docAction="CO";
	MLabourWageIssue wageIssue; 
	
	@Override
	protected void prepare() {
		wageIssue = new MLabourWageIssue(getCtx(), getRecord_ID(), get_TrxName());
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if (name.equals("DocAction"))
				docAction =  para[i].getParameterAsString();
		}

	}

	@Override
	protected String doIt() throws Exception {
		if(!wageIssue.isProcessed())
			wageIssue.processIt(DocAction.ACTION_Complete);
		else if(wageIssue.isProcessed() && docAction.equals("MO"))
			wageIssue.reverseIt();
		
		wageIssue.saveEx();
		return null;
	}

}
