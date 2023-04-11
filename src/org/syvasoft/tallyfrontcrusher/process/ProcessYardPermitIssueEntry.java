package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MYardPermitIssueEntry;

public class ProcessYardPermitIssueEntry extends SvrProcess {
	private String docAction="CO";
	MYardPermitIssueEntry issue;
	@Override
	protected void prepare() {
		issue = new MYardPermitIssueEntry(getCtx(), getRecord_ID(), get_TrxName());
		
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
		if(!issue.isProcessed())
			issue.processIt(MBoulderReceipt.DOCACTION_Complete);
		else if(issue.isProcessed() && docAction.equals("MO"))
			issue.reverseIt();
		
		issue.saveEx();		
		return null;
	}

}
