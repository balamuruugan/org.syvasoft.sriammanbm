package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MQuarryRent;

public class ProcessQuarryRent extends SvrProcess {
	MQuarryRent qRent;
	private String docAction="CO";
	
	@Override
	protected void prepare() {
		qRent = new MQuarryRent(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!qRent.isProcessed())
			qRent.processIt(MBoulderReceipt.DOCACTION_Complete);
		else if(qRent.isProcessed() && docAction.equals("MO"))
			qRent.reverseIt();
		
		qRent.saveEx();
		return null;
	}

}
