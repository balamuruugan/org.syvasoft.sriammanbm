package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTyreAssignment;

public class ProcessTyreAssignment extends SvrProcess {

	private String docAction="CO";
	MTyreAssignment tAssign;
	@Override
	protected void prepare() {
		tAssign = new MTyreAssignment(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!tAssign.isProcessed())
			tAssign.processIt(DocAction.ACTION_Complete);
		else if(tAssign.isProcessed() && docAction.equals("MO"))
			tAssign.reverseIt();
		
		tAssign.saveEx();
		
		return null;
	}

}
