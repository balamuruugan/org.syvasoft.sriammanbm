package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MDebitCreditNote;

public class ProcessDebitCreditNote extends SvrProcess {

	private String docAction="CO";	
	MDebitCreditNote  DCNote;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		DCNote = new MDebitCreditNote(getCtx(), getRecord_ID(), get_TrxName());
		ProcessInfoParameter[] para = getParameter();
	
			for (int i = 0; i < para.length; i++)
			{						
				String name = para[i].getParameterName();
				if (name.equals("DocAction"))
					docAction =  para[i].getParameterAsString();
			}
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		if(!DCNote.isProcessed())
			DCNote.processIt(DocAction.ACTION_Complete);		
		else if(docAction.equals("RE"))
			DCNote.reverseIt();
		
		DCNote.saveEx();

		return null;
	}

	
}
