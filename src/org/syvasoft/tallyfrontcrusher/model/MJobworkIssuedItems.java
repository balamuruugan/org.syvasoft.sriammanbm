package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MJobworkIssuedItems extends X_TF_Jobwork_IssuedItems {

	/**
	 * 
	 */
	private static final long serialVersionUID = -151546964733680647L;

	public MJobworkIssuedItems(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MJobworkIssuedItems(Properties ctx, int TF_Jobwork_IssuedItems_ID,
			String trxName) {
		super(ctx, TF_Jobwork_IssuedItems_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static void addIssuedItem(Properties ctx, int C_Project_ID, int M_Product_ID, int C_UOM_ID, BigDecimal qty, String trxName) {
		String whereClause = " C_Project_ID = ? AND M_Product_ID = ? AND C_UOM_ID = ? ";
		List<MJobworkIssuedItems> list = new Query(ctx, Table_Name, whereClause, trxName)
				.setParameters(C_Project_ID, M_Product_ID, C_UOM_ID).list();
		
		MJobworkIssuedItems item = null;
		if(list.size() > 0) {
			item = list.get(0);
			item.setQtyIssued(item.getQtyIssued().add(qty));			
		}
		else {
			item = new MJobworkIssuedItems(ctx, 0, trxName);
			item.setAD_Org_ID(Env.getAD_Org_ID(ctx));
			item.setC_Project_ID(C_Project_ID);
			item.setM_Product_ID(M_Product_ID);
			item.setC_UOM_ID(C_UOM_ID);
			item.setQtyIssued(qty);
			item.setQtyDeducted(BigDecimal.ZERO);
		}
		
		item.saveEx();		
	}
	
	public static List<MJobworkIssuedItems> getIssuedItemsToDeduct(Properties ctx, int C_Project_ID) {
		String whereClause = " C_Project_ID = ? AND QtyIssued > QtyDeducted";
		List<MJobworkIssuedItems> list = new Query(ctx, Table_Name, whereClause, null)
			.setParameters(C_Project_ID).list();
		return list;
	}
	
	public static List<MJobworkIssuedItems> getIssuedItemsToDeduct(Properties ctx, int C_Project_ID, int M_Product_ID) {
		String whereClause = " C_Project_ID = ? AND QtyIssued > QtyDeducted AND M_Product_ID = ? ";
		List<MJobworkIssuedItems> list = new Query(ctx, Table_Name, whereClause, null)
			.setParameters(C_Project_ID, M_Product_ID).list();
		return list;
	}
}
