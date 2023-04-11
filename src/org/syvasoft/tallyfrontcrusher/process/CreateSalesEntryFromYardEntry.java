package org.syvasoft.tallyfrontcrusher.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MYardEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CreateSalesEntryFromYardEntry extends SvrProcess {

	MYardEntry ye = null;
	private int C_DocType_ID = 0;
	private int M_Warehouse_ID = 0;
	
	@Override
	protected void prepare() {
		ye = new MYardEntry(getCtx(), getRecord_ID(), get_TrxName());
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("C_DocType_ID"))
				C_DocType_ID = para[i].getParameterAsInt();
			else if(name.equals("M_Warehouse_ID"))
				M_Warehouse_ID = para[i].getParameterAsInt();
		}
	}

	@Override
	protected String doIt() throws Exception {
		if(!ye.hasCreatedSalesEntry()) {
			ye.createSalesEntry(C_DocType_ID, M_Warehouse_ID);
			ye.saveEx();
		}
		else {
			return "Sales Entries are already created!";
		}
		
		return "Sales Entries are created!";
	}

}
