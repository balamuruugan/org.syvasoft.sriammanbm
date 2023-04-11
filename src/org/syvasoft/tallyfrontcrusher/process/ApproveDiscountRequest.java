package org.syvasoft.tallyfrontcrusher.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MDiscountRequest;

public class ApproveDiscountRequest extends SvrProcess {

	@Override
	protected void prepare() {
		

	}

	@Override
	protected String doIt() throws Exception {
		MDiscountRequest dr = new MDiscountRequest(getCtx(), getRecord_ID(), get_TrxName());
		if(dr.getDiscntStatus().equals(MDiscountRequest.DISCNTSTATUS_Requested))
			dr.setDiscntStatus(MDiscountRequest.DISCNTSTATUS_Approved);
		else
			throw new AdempiereException("Invalid Approve action!");
		dr.setProcessed(true);
		dr.saveEx();
		return null;
	}

}
