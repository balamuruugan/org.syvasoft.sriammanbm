package org.syvasoft.tallyfrontcrusher.process;

import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Trx;
import org.compiere.util.Util;
import org.syvasoft.tallyfrontcrusher.model.MLoadingSlip;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MInOut;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class UpdateLoadingSlip extends SvrProcess {	

	private String DocumentNo = "";
	private String Description = "";
	private String ProductName = "";
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("DocumentNo"))
				DocumentNo = para[i].getParameterAsString();
			else if(name.equals("Description"))
				Description = para[i].getParameterAsString();
			else if(name.equals("ProductName"))
				ProductName = para[i].getParameterAsString();
				
		}
		 
	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = " DocumentNo = ?";
			
		MLoadingSlip loadingSlip = new Query(getCtx(), MLoadingSlip.Table_Name, whereClause, get_TrxName())
									.setClient_ID()
									.setParameters(DocumentNo)
									.first();
		
		if(loadingSlip != null) {
			loadingSlip.setLoadedTime(null);
			loadingSlip.setAD_User_ID(0);
			loadingSlip.setStatus(MLoadingSlip.STATUS_InProgress);
			loadingSlip.setDescription(Description);
			loadingSlip.setProductName(ProductName);
			loadingSlip.setProcessed(false);
			loadingSlip.saveEx();
		}
		return null;
	}

}
