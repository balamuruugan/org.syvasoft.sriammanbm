package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoice;

public class ProcessTRTaxInvoice extends SvrProcess {

	private String docAction="CO";
	MTRTaxInvoice TRTaxInv;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		TRTaxInv = new MTRTaxInvoice(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!TRTaxInv.isProcessed())
			TRTaxInv.processIt(DocAction.ACTION_Complete);		
		else if(docAction.equals("MO"))
			TRTaxInv.reverseIt();
		TRTaxInv.saveEx();

		return null;
	}

}
