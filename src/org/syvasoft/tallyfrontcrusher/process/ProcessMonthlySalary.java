package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MSalaryHdr;

public class ProcessMonthlySalary extends SvrProcess {

	private String docAction="CO";	
	MSalaryHdr hdr = null;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if (name.equals("DocAction"))
				docAction =  para[i].getParameterAsString();
		}
		
		hdr = new MSalaryHdr(getCtx(), getRecord_ID(), get_TrxName());
	}

	@Override
	protected String doIt() throws Exception {
		if(!hdr.isProcessed() && docAction.equals("CO"))
			hdr.processIt(DocAction.ACTION_Complete);		
		else if(docAction.equals("MO"))
			hdr.reverseIt();
		
		hdr.saveEx();
		return null;
	}

}
