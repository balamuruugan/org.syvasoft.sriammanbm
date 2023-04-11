package org.syvasoft.tallyfrontcrusher.process;

import java.util.ArrayList;
import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.syvasoft.tallyfrontcrusher.model.TF_MInOut;
import org.syvasoft.tallyfrontcrusher.model.TF_MInOutLine;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class VoidTransporterInvoice extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = " DocStatus = 'CL' AND (EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
				" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = M_InOutLIne.M_InOutLIne_ID))"
				+ "  ";
		
		List<TF_MInOutLine> list = new Query(getCtx(), TF_MInOutLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getAD_PInstance_ID())
				.list();
		
		for(TF_MInOutLine ioLine : list) {
			int C_Order_ID = ioLine.getM_InOut().getC_Order_ID();
			TF_MInOut inout = new TF_MInOut(getCtx(), ioLine.getM_InOut_ID(), get_TrxName());
			
			if(C_Order_ID > 0) {
				TF_MOrder ord = new TF_MOrder(getCtx(), C_Order_ID, get_TrxName());
				if(ord.getDocStatus().equals(TF_MOrder.DOCSTATUS_Voided))
					continue;
				ord.setDocAction(DocAction.ACTION_Void);
				ord.voidIt();
				ord.setDocStatus(TF_MOrder.DOCSTATUS_Voided);
				ord.saveEx();
				
				String sqlOrderUpdate = "UPDATE M_InOut SET C_Order_ID = NULL WHERE C_Order_ID = ?";
				ArrayList<Object> params = new ArrayList<Object>();
				params = new ArrayList<Object>();
				params.add(C_Order_ID);				
				DB.executeUpdateEx(sqlOrderUpdate, params.toArray(), get_TrxName());
			}
		}
		
		return null;
	}

}
