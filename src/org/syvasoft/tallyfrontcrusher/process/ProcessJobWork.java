package org.syvasoft.tallyfrontcrusher.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class ProcessJobWork extends SvrProcess {
	String docAction = null;
	@Override
	protected void prepare() {
		for(ProcessInfoParameter para : getParameter())
		{
			String name = para.getParameterName();
			if(name.equals("DocAction")) 
				docAction = para.getParameterAsString();			
		}
		if(docAction == null)
			throw new AdempiereException("Invalid Jobwork Document Action");

	}

	@Override
	protected String doIt() throws Exception {
		TF_MProject jobwork = new TF_MProject(getCtx(), getRecord_ID(), get_TrxName());
		jobwork.processIt(docAction);
		jobwork.saveEx();
		return null;
	}

}
