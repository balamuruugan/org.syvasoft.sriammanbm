package org.syvasoft.tallyfrontcrusher.process;

import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class ChangeCashAccount extends SvrProcess {

	private int C_BankAccount_ID = 0;
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();						
			if(name.equals("C_BankAccount_ID"))
				C_BankAccount_ID = para[i].getParameterAsInt();			
		}
	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = "EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
				" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = C_Payment.C_Payment_ID) "
				+ " AND C_Payment.DocStatus='CO'";
		
		List<TF_MPayment> list = new Query(getCtx(), TF_MPayment.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getAD_PInstance_ID())
				.list();
		
		for(TF_MPayment payment : list) {
			payment.changeCashAccount = true;
			payment.setC_BankAccount_ID(C_BankAccount_ID);
			payment.saveEx();
			
			String error = DocumentEngine.postImmediate(Env.getCtx(), getAD_Client_ID(), payment.get_Table_ID(), payment.get_ID(), true, get_TrxName());
			if(error != null)
				throw new AdempiereException(error);
			
			//counter cash book entry reposting
			if(payment.getRef_Payment_ID() > 0) {
				TF_MPayment counter = new TF_MPayment(getCtx(), payment.getRef_Payment_ID(), get_TrxName());
				counter.setFromTo_BankAccount_ID(C_BankAccount_ID);
				counter.changeCashAccount = true;
				counter.saveEx();
				error = DocumentEngine.postImmediate(Env.getCtx(), getAD_Client_ID(), counter.get_Table_ID(), counter.get_ID(), true, get_TrxName());
				if(error != null)
					throw new AdempiereException(error);
			}	
		}
		
		return null;
	}

}