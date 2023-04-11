package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

public class MJobworkProductPrice extends X_TF_Jobwork_ProductPrice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 717308051736086616L;

	public MJobworkProductPrice(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MJobworkProductPrice(Properties ctx, int TF_Jobwork_ProductPrice_ID,
			String trxName) {
		super(ctx, TF_Jobwork_ProductPrice_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public static BigDecimal getPrice(Properties ctx, int C_Project_ID, int M_Product_ID, Timestamp priceDate) {
		String whereClause = " C_Project_ID = ? AND M_Product_ID = ? AND ValidFrom <= ?";
		List<MJobworkProductPrice> list = new Query(ctx, Table_Name, whereClause, null)
			.setParameters(C_Project_ID, M_Product_ID, priceDate).setOnlyActiveRecords(true)
			.setOrderBy("ValidFrom DESC").list();
						
		if(list.size()>0) {
			return list.get(0).getPriceList();
		}
		
		return null;
	}
}
