package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MCrusherProduction;

public class ProcessCrusherProduction extends SvrProcess {

	int m_recordID = 0;
	MCrusherProduction crProd;
	private String docAction="CO";
	@Override
	protected void prepare() {
		m_recordID = getRecord_ID();
		crProd = new MCrusherProduction(getCtx(), m_recordID, get_TrxName());
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
		String m_processMsg = null;
		if(!crProd.isProcessed()) {
				m_processMsg = crProd.processIt(MBoulderReceipt.DOCACTION_Complete);		
			if(m_processMsg == null)
				crProd.saveEx();
			else
				rollback();
		}
		else if(crProd.isProcessed() && docAction.equals("RE")) {
			crProd.reverseIt();
			crProd.saveEx();
		}
		
		return m_processMsg;
	}

}
