package org.syvasoft.tallyfrontcrusher.process;

import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MPermitLedgerLine;

public class PostPermitIssueExpense extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		List<MPermitLedgerLine> lines = new Query(Env.getCtx(), MPermitLedgerLine.Table_Name, "GL_Journal_ID IS NULL", get_TrxName())
				.setClient_ID().list();
		
		for(MPermitLedgerLine line : lines) {
			line.postPermitExpense();
			line.saveEx();
		}
		
		return null;
	}

}
