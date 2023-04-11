package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MSalaryIssueHdr;

public class CreateSalaryIssueEntries extends SvrProcess {

	int User1_ID = 0;
	public boolean reCreate = false;
	public MSalaryIssueHdr hdr = null;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("User1_ID"))
				User1_ID = para[i].getParameterAsInt();
			else if(name.equals("reCreate"))
				reCreate = para[i].getParameterAsBoolean();
		}
		
		hdr = new MSalaryIssueHdr(getCtx(), getRecord_ID(), get_TrxName());
	}

	@Override
	protected String doIt() throws Exception {
		if(reCreate)
			hdr.deleteLines();		
		hdr.createLines(User1_ID);
		return null;
	}

}
