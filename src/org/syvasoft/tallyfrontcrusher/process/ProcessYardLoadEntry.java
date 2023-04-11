package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MYardLoadEntry;

public class ProcessYardLoadEntry extends SvrProcess {
	private String docAction="CO";
	MYardLoadEntry load = null;
	@Override
	protected void prepare() {
		load = new MYardLoadEntry(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!load.isProcessed())
			load.processIt(MBoulderReceipt.DOCACTION_Complete);
		else if(load.isProcessed() && docAction.equals("MO"))
			load.reverseIt();
		
		load.saveEx();		
		return null;
	}

}
