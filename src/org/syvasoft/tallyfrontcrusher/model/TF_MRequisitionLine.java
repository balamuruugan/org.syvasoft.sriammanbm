package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.Query;

public class TF_MRequisitionLine extends MRequisitionLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8086375269293054622L;

	public TF_MRequisitionLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MRequisitionLine(Properties ctx, int TF_Destination_ID, String trxName) {
		super(ctx, TF_Destination_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		TF_MOrder.addProductPricingIfNot(getM_Product_ID(), getM_Requisition().getM_PriceList_ID(), getC_BPartner_ID(), 
				getQty(), getPriceActual(), getM_Requisition().getDateRequired(), false);
		
		boolean success = super.beforeSave(newRecord);
		return success;
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		return super.afterSave(newRecord, success);
	}

	
}
