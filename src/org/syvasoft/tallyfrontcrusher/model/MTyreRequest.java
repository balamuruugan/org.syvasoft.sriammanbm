package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.process.DocAction;

public class MTyreRequest extends X_TF_TyreRequest {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4316882505063191610L;
	public MTyreRequest(Properties ctx, int TF_TyreRequest_ID, String trxName) {
		super(ctx, TF_TyreRequest_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MTyreRequest(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
		}
	}
	public void reverseIt() {
		setProcessed(false);
		setDocStatus(DOCSTATUS_InProgress);
	}

	

}
