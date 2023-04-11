package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MEmployeeSalaryIssue;

public class ProcessEmployeeSalaryIssue extends SvrProcess {
	private String docAction="CO";
	MEmployeeSalaryIssue salaryIssue;
	
	@Override
	protected void prepare() {
		salaryIssue = new MEmployeeSalaryIssue(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!salaryIssue.isProcessed())
			salaryIssue.processIt(DocAction.ACTION_Complete);
		else if(salaryIssue.isProcessed() && docAction.equals("MO"))
			salaryIssue.reverseIt();
		
		salaryIssue.saveEx();
		return null;
	}

}
