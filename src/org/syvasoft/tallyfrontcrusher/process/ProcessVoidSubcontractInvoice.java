package org.syvasoft.tallyfrontcrusher.process;

import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.List;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Trx;
import org.syvasoft.tallyfrontcrusher.model.MCrusherProduction;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;

public class ProcessVoidSubcontractInvoice extends SvrProcess{

	private int AD_Org_ID = 0;
	private Timestamp DateFrom = null;
	private Timestamp DateTo = null;
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
	
			for (int i = 0; i < para.length; i++)
			{						
				String name = para[i].getParameterName();
				if(name.equals("AD_Org_ID"))
					AD_Org_ID = para[i].getParameterAsInt();
				if(name.equals("DateFrom"))
					DateFrom = para[i].getParameterAsTimestamp();
				if(name.equals("DateTo"))
					DateTo = para[i].getParameterAsTimestamp();
			}
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		String whereClause = " AD_Org_ID = ? AND TRUNC(MovementDate) >= ? AND TRUNC(MovementDate) <= ? AND Subcon_Invoice_ID IS NOT NULL AND DocStatus = 'CO'";
		
		List<MCrusherProduction> crusherEntries = new Query(getCtx(), MCrusherProduction.Table_Name, whereClause, get_TrxName())
				.setClient_ID().setParameters(AD_Org_ID, DateFrom, DateTo).list();
		
		for(MCrusherProduction crusherEntry : crusherEntries) {
						
			TF_MInvoice invoice = new TF_MInvoice(getCtx(), crusherEntry.getSubcon_Invoice_ID(), get_TrxName());
			
			if(invoice != null) {
				if(invoice.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
					invoice.reverseCorrectIt();
					invoice.saveEx();
				}
			}
		}
		return "Processed Successfully";
	}
}
