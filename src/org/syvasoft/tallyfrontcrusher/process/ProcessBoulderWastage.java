package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastage;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastageHdr;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;

public class ProcessBoulderWastage extends SvrProcess {
	private String docAction="CO";
	MBoulderWastageHdr bw;
	int m_recordID = 0;
	@Override
	protected void prepare() {
		m_recordID = getRecord_ID();
		bw = new MBoulderWastageHdr(getCtx(), m_recordID, get_TrxName());
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
		if(!bw.isProcessed()) {
			m_processMsg = bw.processIt(MBoulderReceipt.DOCACTION_Complete);
			if(m_processMsg == null)
				bw.saveEx();
			else
				rollback();
		}
		else if(bw.isProcessed() && docAction.equals("MO")) {
			bw.reverseIt();
			bw.saveEx();
		}
			
		return m_processMsg;
	}

}
