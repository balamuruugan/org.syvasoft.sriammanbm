package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MGenerateTaxInvoice;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoice;

public class CreateTaxInvoice extends SvrProcess {
	private String docAction="CO";
	MGenerateTaxInvoice genTaxInvoice = null;
	protected void prepare() {
		genTaxInvoice = new MGenerateTaxInvoice(getCtx(), getRecord_ID(), get_TrxName());
		
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("DocAction"))
				docAction =  para[i].getParameterAsString();
		}
	}

	@Override
	protected String doIt() throws Exception {
		if(!genTaxInvoice.isProcessed())
		{				
			genTaxInvoice.processIt(DocAction.ACTION_Complete);	
			genTaxInvoice.saveEx();
			
			String whereClause = MGenerateTaxInvoice.COLUMNNAME_TF_Generate_Taxinvoice_ID + " = ? AND DocStatus = 'CO'"; 
			MTRTaxInvoice taxInvoice = new Query(getCtx(), MTRTaxInvoice.Table_Name, whereClause, get_TrxName())
					.setClient_ID()
					.setParameters(genTaxInvoice.getTF_Generate_Taxinvoice_ID())
					.first();
			if(taxInvoice != null) {
				//addLog(taxInvoice.get_Table_ID(), taxInvoice.getCreated(), null, taxInvoice.getDocumentNo() + " is created!", taxInvoice.get_Table_ID(), taxInvoice.get_ID());
				addLog(1, null, null, "Sales Tax Invoice: " + taxInvoice.getDocumentNo(),
						MTRTaxInvoice.Table_ID, taxInvoice.getTF_TRTaxInvoice_ID());
			}
			
		}
		else if(genTaxInvoice.isProcessed() && genTaxInvoice.getDocStatus().equals(MGenerateTaxInvoice.DOCSTATUS_Completed)) {
			genTaxInvoice.reverseIt();
			genTaxInvoice.saveEx();
		}
			
		return null;
	}


}
