package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTyrePurchase;
import org.syvasoft.tallyfrontcrusher.model.MTyreRequest;

public class ProcessTyreRequest extends SvrProcess {

	private String docAction="CO";
	MTyreRequest tr;
	
	@Override
	protected void prepare() {
		tr = new MTyreRequest(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!tr.isProcessed())
			tr.processIt(DocAction.ACTION_Complete);
		else if(tr.isProcessed() && docAction.equals("MO"))
			tr.reverseIt();
		
		tr.saveEx();
		return null;
	}

}
