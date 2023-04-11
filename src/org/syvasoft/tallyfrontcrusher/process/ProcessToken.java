package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTaxInvoice;
import org.syvasoft.tallyfrontcrusher.model.MToken;

public class ProcessToken extends SvrProcess {

	private String docAction="CO";
	MToken token;

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		token = new MToken(getCtx(), getRecord_ID(), get_TrxName());
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
		// TODO Auto-generated method stub
		if(!token.isProcessed())
			token.processIt(DocAction.ACTION_Complete);
		else if(token.isProcessed() && docAction.equals("MO"))
			token.reverseIt();
		token.saveEx();		
		
		return null;
	}

}
