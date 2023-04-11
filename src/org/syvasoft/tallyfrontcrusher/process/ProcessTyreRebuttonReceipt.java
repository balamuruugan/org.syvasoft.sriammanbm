package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTyreRebuttonReceipt;

public class ProcessTyreRebuttonReceipt extends SvrProcess {

	MTyreRebuttonReceipt rb = null;
	private String docAction="CO";
	
	@Override
	protected void prepare() {
		rb = new MTyreRebuttonReceipt(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!rb.isProcessed())
			rb.processIt(DocAction.ACTION_Complete);
		else if(rb.isProcessed() && docAction.equals("MO"))
			rb.reverseIt();
		
		rb.saveEx();
		return null;
	}

}
