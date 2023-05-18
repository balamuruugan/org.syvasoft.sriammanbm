package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MEmployeeAttendanceHdr;

public class ProcessAttendance extends SvrProcess {

	private String docAction="CO";	
	MEmployeeAttendanceHdr att = null;
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();		
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if (name.equals("DocAction"))
				docAction =  para[i].getParameterAsString();
		}
		
		att = new MEmployeeAttendanceHdr(getCtx(), getRecord_ID(), get_TrxName());
		
	}

	@Override
	protected String doIt() throws Exception {
		
		if(!att.isProcessed())
			att.processIt(DocAction.ACTION_Complete);		
		else if(docAction.equals("MO"))
			att.reverseIt();		
		att.saveEx();
		
		return null;
	}

}
