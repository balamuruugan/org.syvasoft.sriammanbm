package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MJobworkCharges extends X_TF_Jobwork_Charges {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5143416734054550326L;

	public MJobworkCharges(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MJobworkCharges(Properties ctx, int TF_Jobwork_Charges_ID,
			String trxName) {
		super(ctx, TF_Jobwork_Charges_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static void updateJobworkCharges(Properties ctx, int C_Project_ID, int C_Charge_ID, BigDecimal amount, String trxName) {
		String whereClause = " C_Project_ID = ? AND C_Charge_ID = ? ";
		List<MJobworkCharges> charges = new Query(ctx, Table_Name, whereClause, trxName)
			.setParameters(C_Project_ID, C_Charge_ID).list();
		MJobworkCharges charge = null;
		if(charges.size() > 0) {
			charge = charges.get(0);
			charge.setTotalAmt(charge.getTotalAmt().add(amount));
		}
		else {
			charge = new MJobworkCharges(ctx, 0, trxName);
			charge.setAD_Org_ID(Env.getAD_Org_ID(ctx));
			charge.setC_Project_ID(C_Project_ID);
			charge.setC_Charge_ID(C_Charge_ID);
			charge.setTotalAmt(amount);
			charge.setDeductedAmt(BigDecimal.ZERO);
		}
		
		charge.saveEx();
			
	}
	
	public static List<MJobworkCharges> getChargesToDeduct(Properties ctx, int C_Project_ID) {
		String whereClause = " C_Project_ID = ? AND TotalAmt > DeductedAmt" ; 
		List<MJobworkCharges> list = new Query(ctx, Table_Name, whereClause, null)
			.setParameters(C_Project_ID).list();
		return list;
	}
	
}
