package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MLabourWage;

public class ProcessLabourWage extends SvrProcess {

	private String docAction="CO";	
	MLabourWage wage; 
	
	@Override
	protected void prepare() {
		wage = new MLabourWage(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!wage.isProcessed())		
			wage.processIt(DocAction.ACTION_Complete);
		else if(wage.isProcessed() && docAction.equals("MO"))
			wage.reverseIt();
		wage.saveEx();
		return null;
	}

}
