package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;

public class SetBPTotalOpenBalance extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		TF_MBPartner bp = new TF_MBPartner(getCtx(), getRecord_ID(), get_TrxName());
		bp.setOutstandingBalance(Env.getContextAsDate(getCtx(), "#Date") );
		bp.saveEx();
		bp.setSOCreditStatus();
		bp.saveEx();
		return null;
	}

}
