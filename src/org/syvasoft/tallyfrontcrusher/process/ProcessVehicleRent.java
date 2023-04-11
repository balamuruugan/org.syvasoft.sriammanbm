package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRent;

public class ProcessVehicleRent extends SvrProcess {
	private String docAction="CO";
	MVehicleRent vRent;
	@Override
	protected void prepare() {
		vRent = new MVehicleRent(getCtx(), getRecord_ID(), get_TrxName());
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
		if(!vRent.isProcessed())
			vRent.processIt(MBoulderReceipt.DOCACTION_Complete);
		else if(vRent.isProcessed() && docAction.equals("MO"))
			vRent.reverseIt();
		
		vRent.saveEx();
		return null;
	}

}
