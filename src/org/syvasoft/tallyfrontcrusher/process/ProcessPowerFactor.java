package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MPowerFactor;

public class ProcessPowerFactor extends SvrProcess{

	int m_recordID = 0;
	private String docAction="CO";	
	MPowerFactor pf = null;
	@Override
	protected void prepare() {
		m_recordID = getRecord_ID();
		
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
		pf = new MPowerFactor(getCtx(), m_recordID, get_TrxName());
		if(!pf.isProcessed()) {
			pf.processIt();
		}
		else if(pf.isProcessed() && docAction.equals("MO")) {
			pf.reverseIt();
		}
		pf.saveEx();
		return null;
	}
}
