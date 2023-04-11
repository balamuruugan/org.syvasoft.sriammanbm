package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.PO;

public class MJobworkResourceRentEntry extends X_TF_Jobwork_ResRentEntry {

	public MJobworkResourceRentEntry(Properties ctx, ResultSet rs,
			String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MJobworkResourceRentEntry(Properties ctx,
			int TF_Jobwork_ResRentEntry_ID, String trxName) {
		super(ctx, TF_Jobwork_ResRentEntry_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6578907354246098099L;

	@Override
	protected boolean beforeSave(boolean newRecord) {
		MJobworkIssuedResource res = new MJobworkIssuedResource(getCtx(), getTF_Jobwork_IssuedResource_ID(), get_TrxName());
		double amt = getContract_Amt_Act().doubleValue();
		double price = getUnit_Price().doubleValue();
		double qty = getQty().doubleValue();
		
		qty = amt / price;
		
		setQty(new BigDecimal(qty));
		
		
		if(newRecord) {			
			res.setQty(res.getQty().add(getQty()));
			res.setContract_Amt_Act(res.getContract_Amt_Act().add(getContract_Amt_Act()));
			res.saveEx();
		}
		else if(is_ValueChanged(COLUMNNAME_Contract_Amt_Act)) {
			BigDecimal diffQty = (BigDecimal) get_ValueDifference(COLUMNNAME_Qty);
			BigDecimal diffAmt = (BigDecimal) get_ValueDifference(COLUMNNAME_Contract_Amt_Act);
			if(diffQty != null)
				res.setQty(res.getQty().add(diffQty));
			if(diffAmt != null)
				res.setContract_Amt_Act(res.getContract_Amt_Act().add(diffAmt));
			res.saveEx();
			
		}
		return super.beforeSave(newRecord);
	}

	@Override
	protected boolean beforeDelete() {
		MJobworkIssuedResource res = new MJobworkIssuedResource(getCtx(), getTF_Jobwork_IssuedResource_ID(), get_TrxName());
		res.setQty(res.getQty().subtract(getQty()));
		res.setContract_Amt_Act(res.getContract_Amt_Act().subtract(getContract_Amt_Act()));
		res.saveEx();
		return super.beforeDelete();
	}

	
}
