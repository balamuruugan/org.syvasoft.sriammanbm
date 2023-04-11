package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MCrusherKatingEntry;

public class ProcessCrusherKatingEntry extends SvrProcess {
	private String docAction="CO";
	MCrusherKatingEntry kating;
	@Override
	protected void prepare() {
		kating = new MCrusherKatingEntry(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!kating.isProcessed())
			kating.processIt(DocAction.ACTION_Complete);
		else if(kating.isProcessed() && docAction.equals("MO"))
			kating.reverseIt();
		
		kating.saveEx();
		return null;
	}

}
