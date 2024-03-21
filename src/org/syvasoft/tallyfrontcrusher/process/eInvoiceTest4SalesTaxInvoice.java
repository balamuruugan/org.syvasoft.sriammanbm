package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.eInvoiceutil.GenerateEinvoice4SalesTaxInv;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoice;

public class eInvoiceTest4SalesTaxInvoice extends SvrProcess {


	int errorCount = 0;
	String printJSON = "N";
	String docType = "INV";
	int TF_TRTaxInvoice_ID = 0;
	
	@Override
	protected void prepare() {
		
		ProcessInfoParameter[] para = getParameter();
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("TF_TRTaxInvoice_ID"))
				TF_TRTaxInvoice_ID = para[i].getParameterAsInt();
			
			if(name.equals("docType")) 
				docType = para[i].getParameterAsString();
		}
	}

	@Override
	protected String doIt() throws Exception {
		MTRTaxInvoice inv = new MTRTaxInvoice(getCtx(), TF_TRTaxInvoice_ID, get_TrxName());
		GenerateEinvoice4SalesTaxInv eInv = new GenerateEinvoice4SalesTaxInv(inv, docType, getAD_PInstance_ID());
		
		
		String json = eInv.printJSONObject();
		
		for(String msg : eInv.errors) {
			addLog(msg);
		}
		
		return json;
	}

}
