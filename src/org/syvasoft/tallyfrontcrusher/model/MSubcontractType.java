package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MSubcontractType extends X_TF_SubcontractType {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1527798287488310885L;

	public MSubcontractType(Properties ctx, int TF_SubcontractType_ID, String trxName) {
		super(ctx, TF_SubcontractType_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSubcontractType(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(INVOICEFOR_Jobwork.equals(getInvoiceFor())) {
			setCreateInvFromSales(false);
			setCreateMRFromSales(false);
		}
		return super.beforeSave(newRecord);
	}

	
}
