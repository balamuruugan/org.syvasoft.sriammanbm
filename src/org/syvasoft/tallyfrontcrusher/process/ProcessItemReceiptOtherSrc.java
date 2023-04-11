package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MItemReceiptOtherSrc;

public class ProcessItemReceiptOtherSrc extends SvrProcess {

	private String docAction = "CO";
	MItemReceiptOtherSrc itemReceipt;
	@Override
	protected void prepare() {
		
		itemReceipt = new MItemReceiptOtherSrc(getCtx(), getRecord_ID(), get_TrxName());
		
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
		if(!itemReceipt.isProcessed())
			itemReceipt.processIt(DocAction.ACTION_Complete);
		else if(docAction.equals("MO"))
			itemReceipt.reverseIt();
		
		itemReceipt.saveEx();
		return null;
	}

}
