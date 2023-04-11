package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;

public class MCounterTransactionSetup extends X_TF_CounterTrans {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6231910160981619118L;

	public MCounterTransactionSetup(Properties ctx, int TF_CounterTrans_ID, String trxName) {
		super(ctx, TF_CounterTrans_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCounterTransactionSetup(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static MCounterTransactionSetup getCounterTransaction(Properties ctx, int Src_Org_ID, int Src_DocType_ID, int Src_Bpartner_ID) {
		String whereClause = "Src_Org_ID = ? AND Src_DocType_ID = ? AND Src_Bpartner_ID = ? ";
		MCounterTransactionSetup counterSetup = new Query(ctx, Table_Name, whereClause, null)
				.setClient_ID()
				.setParameters(Src_Org_ID, Src_DocType_ID, Src_Bpartner_ID)
				.setOnlyActiveRecords(true)
				.first();
		return counterSetup;
	}
	
	public int getCounterProduct_ID(int Src_Org_ID, int Src_Product_ID) {
		String whereClause = "Src_Org_ID = ? AND Src_Product_ID = ? AND COALESCE(TF_CounterTrans_ID, 0) IN (0,?)";
		MCounterTransProductSetup cProduct = new Query(getCtx(), MCounterTransProductSetup.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setOnlyActiveRecords(true)
				.setParameters(Src_Org_ID, Src_Product_ID, getTF_CounterTrans_ID())
				.setOrderBy("COALESCE(TF_CounterTrans_ID, 0) DESC")
				.first();
		
		if(cProduct != null)
			return cProduct.getTo_Product_ID();
		else
			return Src_Product_ID;
		
	}

}
