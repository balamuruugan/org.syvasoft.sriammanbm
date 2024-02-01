package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBankAccount;
import org.compiere.model.MBankStatement;
import org.compiere.model.Query;
import org.osgi.framework.AdminPermission;

public class TF_MBankStatement extends MBankStatement{

	private static final long serialVersionUID = -4117124451016213701L;

	public TF_MBankStatement(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MBankStatement(Properties ctx, int C_BankStatement_ID, String trxName) {
		super(ctx, C_BankStatement_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MBankStatement(MBankAccount account, boolean isManual) {
		super(account, isManual);
		// TODO Auto-generated constructor stub
	}

	public TF_MBankStatement(MBankAccount account) {
		super(account);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String completeIt() {
		// TODO Auto-generated method stub
		String msg = super.completeIt();
		
//		TF_MBankStatementLine bsline = new TF_MBankStatementLine(getCtx(),getC_BankStatement_ID(), get_TrxName());
		
		String whereClause = "IsActive = 'Y' AND C_BankStatement_ID = ?";
		List<TF_MBankStatementLine> bline = new Query(getCtx(), TF_MBankStatementLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getC_BankStatement_ID())
				.list();
		
		for(TF_MBankStatementLine bsline : bline) {
				if(bsline.getC_Payment_ID() <= 0) {
					throw new AdempiereException("Please update the Payment : "+ bsline.getLine());
				}	
		}
		return msg;
	}

}
