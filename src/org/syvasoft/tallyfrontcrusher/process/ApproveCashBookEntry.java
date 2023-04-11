package org.syvasoft.tallyfrontcrusher.process;

import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class ApproveCashBookEntry extends SvrProcess {

	@Override
	protected void prepare() {
		

	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = "EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
					" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = C_Payment.C_Payment_ID) "
					+ " AND C_Payment.DocStatus='IP' ";
		
		List<TF_MPayment> entries = new Query(getCtx(), TF_MPayment.Table_Name, whereClause, get_TrxName())
				.setClient_ID().setParameters(getAD_PInstance_ID()).list();
		int i = 0;
		for(TF_MPayment cashEntry : entries) {
			if(!cashEntry.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + cashEntry.getProcessMsg());
			cashEntry.saveEx();
			i++;
		}
		return "Approved " + i + " Cash Book Entries";
	}

}
