package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastage;

public class ProcessBoulderReceipt extends SvrProcess {
	private String docAction="CO";
	MBoulderReceipt br;
	int m_recordID = 0;
	@Override
	protected void prepare() {
		m_recordID = getRecord_ID();
		br = new MBoulderReceipt(getCtx(), m_recordID, get_TrxName());
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
		if(!br.isProcessed()) {
			m_processMsg =  br.processIt(MBoulderReceipt.DOCACTION_Complete);
			if(m_processMsg == null)
				br.saveEx();
			else
				rollback();
		}
		else if(br.isProcessed() && docAction.equals("MO")) {
			br.reverseIt();
			br.saveEx();
		}
			
		return m_processMsg;
	}

}
