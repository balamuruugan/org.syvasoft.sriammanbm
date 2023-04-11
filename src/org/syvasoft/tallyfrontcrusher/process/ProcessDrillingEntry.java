package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MDrillingEntry;

public class ProcessDrillingEntry extends SvrProcess {
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		MDrillingEntry de = new MDrillingEntry(getCtx(), getRecord_ID(), get_TrxName());
		if(!de.isProcessed()) 
			de.processIt(DocAction.ACTION_Complete);
		else
			de.reverseIt();
		de.saveEx();
		return null;
	}
	
	

}
