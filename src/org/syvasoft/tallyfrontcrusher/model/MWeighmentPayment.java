package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;

public class MWeighmentPayment extends X_TF_WeighmentEntry_Payment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7685340176610982588L;

	public MWeighmentPayment(Properties ctx, int TF_WeighmentEntry_Payment_ID, String trxName) {
		super(ctx, TF_WeighmentEntry_Payment_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MWeighmentPayment(Properties ctx, int TF_WeighmentEntry_Payment_ID, String trxName,
			String... virtualColumns) {
		super(ctx, TF_WeighmentEntry_Payment_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MWeighmentPayment(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		validatePayment();
		return super.afterSave(newRecord, success);
	}
	
	/*
	 * Mixed Payment Validation
		Before save of Weighment Payment, 
		1. weighment entry payment rule should be Mixed Payment
		2. total amount of weighment payment should not exceed the sales amount
	*/
	 
	private void validatePayment() {
		MWeighmentEntry we = (MWeighmentEntry) getTF_WeighmentEntry();
		
		if(!we.getPaymentRule().equals(MWeighmentEntry.PAYMENTRULE_MixedPayment))
			throw new AdempiereException("Mixed Tender Payment cannot be saved due to invalid payment rule!");
		
		BigDecimal SalesAmount = we.getSalesTotalAmount();
		BigDecimal TotalMixedPayment = we.getTotalMixedPayment();
		
		if(SalesAmount.doubleValue() < TotalMixedPayment.doubleValue())
			throw new AdempiereException("Mixed Tender Payments exceeds the sales amount!");
		
	}
}
