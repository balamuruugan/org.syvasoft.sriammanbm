package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CreateTaxInvoiceSO extends SvrProcess {

	private int C_Order_ID = 0;
	@Override
	protected void prepare() {		
		C_Order_ID = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		TF_MOrder ord = new TF_MOrder(getCtx(), C_Order_ID, get_TrxName());
		ord.setOnAccount(true);
		ord.createTaxInvoice();
		ord.saveEx();
		return null;
	}

}
