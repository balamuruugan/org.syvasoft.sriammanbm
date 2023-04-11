package org.syvasoft.tallyfrontcrusher.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRentalContract;

public class ProcessRentalContract extends SvrProcess {

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
			throw new AdempiereException("Invalid Rental Contract Action");

	}

	@Override
	protected String doIt() throws Exception {
		MVehicleRentalContract rentContract = new MVehicleRentalContract(getCtx(), getRecord_ID(), get_TrxName());
		rentContract.processIt(docAction);
		rentContract.saveEx();
		return null;
	}

}
