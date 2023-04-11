package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

public class MAdditionalTransactionSetup extends X_TF_AdditionalTrans {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8683387500390040151L;

	public MAdditionalTransactionSetup(Properties ctx, int TF_AdditionalTrans_ID, String trxName) {
		super(ctx, TF_AdditionalTrans_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAdditionalTransactionSetup(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static List<MAdditionalTransactionSetup>  getAdditionalTransaction(Properties ctx, int Src_Org_ID, int Src_DocType_ID, 
			int Src_Bpartner_ID, int Src_Product_ID) {
		String whereClause = "Src_Org_ID = ? AND COALESCE(Src_DocType_ID,0) = ? AND "
				+ " COALESCE(Src_Bpartner_ID,0) IN (?,0) AND Src_Product_ID = ? ";
		List<MAdditionalTransactionSetup> transSetup = new Query(ctx, Table_Name, whereClause, null)
				.setClient_ID()
				.setParameters(Src_Org_ID, Src_DocType_ID, Src_Bpartner_ID, Src_Product_ID)
				.setOnlyActiveRecords(true)
				.setOrderBy("COALESCE(Src_DocType_ID,0) DESC")
				.list();		
		//This list has to be redefined
		
		return transSetup;
	}

}
