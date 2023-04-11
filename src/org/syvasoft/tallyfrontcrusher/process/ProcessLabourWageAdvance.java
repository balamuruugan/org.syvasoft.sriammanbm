package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MLabourWageAdvance;

public class ProcessLabourWageAdvance extends SvrProcess {

	private String docAction="CO";	
	MLabourWageAdvance wageAdv;
	
	@Override
	protected void prepare() {
		wageAdv = new MLabourWageAdvance(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!wageAdv.isProcessed())
			wageAdv.processIt(DocAction.ACTION_Complete);
		else if(wageAdv.isProcessed() && docAction.equals("MO"))
			wageAdv.reverseIt();
		
		wageAdv.saveEx();
		return null;
	}

}
