package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MJobworkReceivedItems extends X_TF_Jobwork_ReceivedItems {

	/**
	 * 
	 */
	private static final long serialVersionUID = 795785156956831137L;

	public MJobworkReceivedItems(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MJobworkReceivedItems(Properties ctx,
			int TF_Jobwork_ReceivedItems_ID, String trxName) {
		super(ctx, TF_Jobwork_ReceivedItems_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public static void addReceivedItem(Properties ctx, int C_Project_ID, int M_Product_ID, BigDecimal qty, int C_UOM_ID, String trxName) {
		
		String whereClause = " C_Project_ID = ? AND M_Product_ID = ? AND C_UOM_ID = ? ";
		List<MJobworkReceivedItems> list = new Query(ctx, Table_Name, whereClause, trxName)
			.setParameters(C_Project_ID, M_Product_ID, C_UOM_ID).list();
		MJobworkReceivedItems receivedItem = null;
		if(list.size()>0) {
			receivedItem = list.get(0);
			receivedItem.setQtyReceived(receivedItem.getQtyReceived().add(qty));
		}
		else {
			receivedItem = new MJobworkReceivedItems(ctx, 0, trxName);
			receivedItem.setAD_Org_ID(Env.getAD_Org_ID(ctx));
			receivedItem.setC_Project_ID(C_Project_ID);
			receivedItem.setM_Product_ID(M_Product_ID);
			receivedItem.setQtyReceived(qty);
			receivedItem.setC_UOM_ID(C_UOM_ID);
		}
		
		receivedItem.saveEx();
	}
}
