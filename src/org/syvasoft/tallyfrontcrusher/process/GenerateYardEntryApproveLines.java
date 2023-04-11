package org.syvasoft.tallyfrontcrusher.process;

import java.util.logging.Level;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MYardEntryApprove;

public class GenerateYardEntryApproveLines extends SvrProcess {
	private boolean recreate = false;
	MYardEntryApprove yeApprove = null;
	@Override
	protected void prepare() {
		for(ProcessInfoParameter para : getParameter())
		{
			String name = para.getParameterName();
			if("Recreate".equals(name))
				recreate = "Y".equals(para.getParameter());
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		yeApprove = new MYardEntryApprove(getCtx(), getRecord_ID(), get_TrxName());		

	}

	@Override
	protected String doIt() throws Exception {
		if(yeApprove.isProcessed())
			return "Already Processed";
		yeApprove.createYardEntryLines(recreate);
		yeApprove.saveEx();
		return null;
	}

}
