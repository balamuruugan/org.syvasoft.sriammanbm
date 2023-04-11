package org.syvasoft.tallyfrontcrusher.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.DocAction;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class ProcessSalesInvoice extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		TF_MOrder ord=new TF_MOrder(getCtx(), getRecord_ID(), get_TrxName());
		if(!ord.getDocStatus().equals(TF_MOrder.DOCSTATUS_Drafted))
			return null;
		if (!ord.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + ord.getProcessMsg());				
		ord.saveEx();
		return null;
	}

}
