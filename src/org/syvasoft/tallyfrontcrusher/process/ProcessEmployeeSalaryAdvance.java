package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MEmployeeSalaryAdvance;

public class ProcessEmployeeSalaryAdvance extends SvrProcess {
	private String docAction="CO";
	MEmployeeSalaryAdvance salaryAdv;
	
	@Override
	protected void prepare() {
		salaryAdv = new MEmployeeSalaryAdvance(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!salaryAdv.isProcessed())
			salaryAdv.processIt(DocAction.ACTION_Complete);
		else if(salaryAdv.isProcessed() && docAction.equals("MO"))
			salaryAdv.reverseIt();
		
		salaryAdv.saveEx();
		return null;
	}

}
