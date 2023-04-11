package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MTaxInvoiceCycle extends X_TF_TaxInvoiceCycle {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1474177260863763299L;

	public MTaxInvoiceCycle(Properties ctx, int TF_TaxInvoiceCycle_ID, String trxName) {
		super(ctx, TF_TaxInvoiceCycle_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTaxInvoiceCycle(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public boolean IsImmediateTaxInvoiceRequired() {
		return getInvoiceDay() == 0 && !isLastDayofMonth();
	}

}
