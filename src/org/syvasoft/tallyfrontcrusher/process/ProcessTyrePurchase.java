package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTyrePurchase;

public class ProcessTyrePurchase extends SvrProcess {

	private String docAction="CO";
	MTyrePurchase tyrePO;
	public ProcessTyrePurchase() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void prepare() {
		tyrePO = new MTyrePurchase(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!tyrePO.isProcessed())
			tyrePO.processIt(DocAction.ACTION_Complete);
		else if(tyrePO.isProcessed() && docAction.equals("MO"))
			tyrePO.reverseIt();
		
		tyrePO.saveEx();
		return null;
	}

	

}
