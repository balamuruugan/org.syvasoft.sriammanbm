package org.syvasoft.tallyfrontcrusher.process;

import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MMessage;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Trx;
import org.compiere.util.Util;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastageHdr;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MInOut;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class VoidWeighmentEntry extends SvrProcess {	

	private int TF_WeighmentEntry_ID = 0;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("TF_WeighmentEntry_ID"))
				TF_WeighmentEntry_ID = para[i].getParameterAsInt();			
		}
	}

	@Override
	protected String doIt() throws Exception {
		MWeighmentEntry wEntry = new MWeighmentEntry(getCtx(), TF_WeighmentEntry_ID, get_TrxName());
		
		
		if(wEntry.getDescription() != null && wEntry.getDescription().contains("ERROR:") && wEntry.getStatus().equals(MWeighmentEntry.STATUS_Error)) 
			wEntry.setDescription(null);
		
		Trx trx = Trx.get(get_TrxName(), false);
		Savepoint sp = null;
		try {
			String msg = null;
			sp = trx.setSavepoint(wEntry.getDocumentNo());
			
			if(wEntry.getWeighmentEntryType().equalsIgnoreCase(MWeighmentEntry.WEIGHMENTENTRYTYPE_Sales) || 
					wEntry.getWeighmentEntryType().equalsIgnoreCase(MWeighmentEntry.WEIGHMENTENTRYTYPE_Input)) {
				if(wEntry.getStatus().equals(MWeighmentEntry.STATUS_Billed) && !wEntry.isRequiredTaxInvoicePerLoad()) {
					throw new AdempiereException("Weighment Entry No: " + wEntry.getDocumentNo() +" cannot be modified since it is billed under Consolidated Invoice.!");
				}
			}
			if(wEntry.getWeighmentEntryType().equalsIgnoreCase(MWeighmentEntry.WEIGHMENTENTRYTYPE_SubcontractProductionReceipt) || 
					wEntry.getWeighmentEntryType().equalsIgnoreCase(MWeighmentEntry.WEIGHMENTENTRYTYPE_StockToCrusher)) {
				String whereClause = " M_Product_ID = ? AND M_Warehouse_ID = ?  AND TRUNC(DateAcct) = ? AND DocStatus IN ('CO','CL') ";
				
				List<MBoulderWastageHdr> bhdr = new Query(getCtx(), MBoulderWastageHdr.Table_Name, whereClause, get_TrxName())
											.setClient_ID()
											.setParameters(wEntry.getM_Product_ID(), wEntry.getM_Warehouse_ID(), wEntry.getDateAcct())
											.list();					
				if(bhdr.size() > 0) {
					MMessage message = MMessage.get(getCtx(), "ModifyWE_BoulderWastage");
					throw new AdempiereException(message.getMsgText());
				}
			}
			wEntry.setStatus(MWeighmentEntry.STATUS_Voided);
			wEntry.setProcessed(false);
			wEntry.saveEx();
			
			trx.releaseSavepoint(sp);
		}
		catch (Exception ex) {
			if(sp != null)
				trx.rollback(sp);
		
			throw ex;
		}			

		return null;
	}

}
