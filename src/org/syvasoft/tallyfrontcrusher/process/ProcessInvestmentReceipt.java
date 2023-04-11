package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MInvestmentReceipt;
import org.syvasoft.tallyfrontcrusher.model.MInvestmentStructure;

public class ProcessInvestmentReceipt extends SvrProcess {

	private String docAction="CO";
	MInvestmentReceipt invReceipt;
	
	@Override
	protected void prepare() {
		invReceipt = new MInvestmentReceipt(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!invReceipt.isProcessed())
			invReceipt.processIt(DocAction.ACTION_Complete);
		else if(invReceipt.isProcessed() && docAction.equals("MO"))
			invReceipt.reverseIt();
			
		invReceipt.saveEx();
		MInvestmentStructure.updateInvestmentPaid(invReceipt.getAD_Org_ID(), get_TrxName());
		return null;
	}

}
