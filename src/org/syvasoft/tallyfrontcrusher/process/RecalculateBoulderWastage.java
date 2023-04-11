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
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastageDtl;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastageHdr;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MInOut;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class RecalculateBoulderWastage extends SvrProcess {	

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		/*
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("C_DocType_ID"))
				C_DocType_ID = para[i].getParameterAsInt();			
			if(name.equals("AD_Org_ID"))
				AD_Org_ID = para[i].getParameterAsInt();
			if(name.equals("isSOTrx"))
				isSOTrx = para[i].getParameterAsBoolean();
			if(name.equals("DateFrom"))
				DateFrom = para[i].getParameterAsTimestamp();
			if(name.equals("DateTo"))
				DateTo = para[i].getParameterAsTimestamp();
		}
		 */
	}

	@Override
	protected String doIt() throws Exception {
			
		MBoulderWastageHdr bHdr = new MBoulderWastageHdr(getCtx(), getRecord_ID(), get_TrxName());

		if(bHdr.getDocStatus().equals(MBoulderWastageHdr.DOCSTATUS_Drafted)) {
			for(MBoulderWastageDtl dtl : bHdr.getLines()) {
				dtl.calculateScalpingQty();
				dtl.saveEx();
			}
		}
		
		return null;
	}

}
