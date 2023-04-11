package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MYardEntryApprove;

public class ApproveYardEntry extends SvrProcess {
	private String docAction="CO";
	MYardEntryApprove appYEntries = null;
	private boolean createSales = false;
	private int C_DocType_ID = 0;
	private int M_Warehouse_ID = 0;
	@Override
	protected void prepare() {
		appYEntries = new MYardEntryApprove(getCtx(), getRecord_ID(), get_TrxName());
		
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("DocAction"))
				docAction =  para[i].getParameterAsString();
			else if(name.equals("CreateSales"))
				createSales = para[i].getParameterAsBoolean();
			else if(name.equals("C_DocType_ID"))
				C_DocType_ID = para[i].getParameterAsInt();
			else if(name.equals("M_Warehouse_ID"))
				M_Warehouse_ID = para[i].getParameterAsInt();
		}
		appYEntries.setC_DocType_ID(C_DocType_ID);
		appYEntries.setM_Warehouse_ID(M_Warehouse_ID);
		if(appYEntries.isProcessed())
			createSales = false;
		appYEntries.setCreateSales(createSales);
	}

	@Override
	protected String doIt() throws Exception {
		if(!appYEntries.isProcessed())
			appYEntries.processIt(MBoulderReceipt.DOCACTION_Complete);
		else if(appYEntries.isProcessed() && docAction.equals("MO"))
			appYEntries.reverseIt();
		
		appYEntries.saveEx();	
		return null;
	}

}
