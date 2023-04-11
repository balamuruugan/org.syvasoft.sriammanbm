package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MJobworkExpenseEntry;

public class ProcessJobworkExpenseEntry extends SvrProcess {

	private String docAction="CO";	
	private MJobworkExpenseEntry expEntry;
	
	@Override
	protected void prepare() {
		
		expEntry = new MJobworkExpenseEntry(getCtx(), getRecord_ID(), get_TrxName());
		
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
		if(!expEntry.isProcessed())
			expEntry.processIt(DocAction.ACTION_Complete);		
		else if(docAction.equals("MO"))
			expEntry.reverseIt();
		
		expEntry.saveEx();
		return null;	
		
	}

}
