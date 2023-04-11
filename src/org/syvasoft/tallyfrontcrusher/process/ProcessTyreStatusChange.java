package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTyreStatusChange;

public class ProcessTyreStatusChange extends SvrProcess {

	private String docAction="CO";
	MTyreStatusChange tStChange;
	@Override
	protected void prepare() {
		tStChange = new MTyreStatusChange(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!tStChange.isProcessed())
			tStChange.processIt(DocAction.ACTION_Complete);
		else if(tStChange.isProcessed() && docAction.equals("MO"))
			tStChange.reverseIt();
		
		tStChange.saveEx();
		
		return null;		
	}

}
