package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MQuarry;
import org.syvasoft.tallyfrontcrusher.model.MTaxInvoice;

public class ProcessTaxInvoice extends SvrProcess {
	private String docAction="CO";
	MTaxInvoice inv;
	@Override
	protected void prepare() {
		inv = new MTaxInvoice(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!inv.isProcessed())
			inv.processIt(DocAction.ACTION_Complete);
		else if(inv.isProcessed() && docAction.equals("MO"))
			inv.reverseIt();
		
		inv.saveEx();		
		return null;
	}

}
