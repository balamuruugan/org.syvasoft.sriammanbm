package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MJobworkExpense extends X_TF_Jobwork_Expense {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8810055436206978047L;

	public MJobworkExpense(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MJobworkExpense(Properties ctx, int TF_Jobwork_Expense_ID,
			String trxName) {
		super(ctx, TF_Jobwork_Expense_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public static void updateJobworkExpense(Properties ctx, int C_Project_ID, int C_ElementValue_ID, BigDecimal amount, String trxName) {
		String whereClause = " C_Project_ID = ? AND C_ElementValue_ID = ? ";
		List<MJobworkExpense> expenses = new Query(ctx, Table_Name, whereClause, trxName)
			.setParameters(C_Project_ID, C_ElementValue_ID).list();
		MJobworkExpense exp = null;
		if(expenses.size() > 0) {
			exp = expenses.get(0);
			exp.setTotalAmt(exp.getTotalAmt().add(amount));
		}
		else {
			exp = new MJobworkExpense(ctx, 0, trxName);
			exp.setAD_Org_ID(Env.getAD_Org_ID(ctx));
			exp.setC_Project_ID(C_Project_ID);
			exp.setC_ElementValue_ID(C_ElementValue_ID);
			exp.setTotalAmt(amount);
			exp.setDeductedAmt(BigDecimal.ZERO);
		}
		
		exp.saveEx();
		
	}
	
	public static List<MJobworkExpense> getExpensesToDeduct(Properties ctx, int C_Project_ID) {
		String whereClause = " C_Project_ID = ? AND TotalAmt > DeductedAmt" ; 
		List<MJobworkExpense> list = new Query(ctx, Table_Name, whereClause, null)
		.setParameters(C_Project_ID).list();
		return list;
	}
}
