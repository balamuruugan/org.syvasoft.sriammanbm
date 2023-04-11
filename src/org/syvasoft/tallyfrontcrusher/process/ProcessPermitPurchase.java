package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MPermitPurchase;
import org.syvasoft.tallyfrontcrusher.model.MQuarry;

public class ProcessPermitPurchase extends SvrProcess {
	private String docAction="CO";
	MPermitPurchase permitPurchase;
	@Override
	protected void prepare() {
		permitPurchase = new MPermitPurchase(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!permitPurchase.isProcessed())
			permitPurchase.processIt(DocAction.ACTION_Complete);
		else if(permitPurchase.isProcessed() && docAction.equals("MO"))
			permitPurchase.reverseIt();
		
		permitPurchase.saveEx();
		MQuarry quarry = new MQuarry(getCtx(), permitPurchase.getTF_Quarry_ID(), get_TrxName());
		quarry.setCurrentConsumedQty();		
		quarry.saveEx();
		
		return null;
	}

}
