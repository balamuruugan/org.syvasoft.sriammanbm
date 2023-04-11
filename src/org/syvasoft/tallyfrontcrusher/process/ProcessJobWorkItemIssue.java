package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MJobworkItemIssue;

public class ProcessJobWorkItemIssue extends SvrProcess {

	private String docAction="CO";	
	MJobworkItemIssue itemIssue;
	
	@Override
	protected void prepare() {
		
		itemIssue = new MJobworkItemIssue(getCtx(), getRecord_ID(), get_TrxName());
		
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
		if(!itemIssue.isProcessed())
			itemIssue.processIt(DocAction.ACTION_Complete);		
		else if(docAction.equals("MO"))
			itemIssue.reverseIt();
		
		itemIssue.saveEx();
		return null;		
	}

}
