package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.DocAction;
import org.compiere.util.DB;

public class MTyreStatusChange extends X_TF_TyreStatusChange {

	public MTyreStatusChange(Properties ctx, int TF_TyreStatusChange_ID,
			String trxName) {
		super(ctx, TF_TyreStatusChange_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyreStatusChange(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8261510390583803977L;
	
	private boolean isLatestDocument() {
		String sql = " SELECT COUNT(*) FROM TF_TyreStatusChange WHERE TF_Tyre_ID = ? AND DateAcct > ? ";
		int count = DB.getSQLValue(get_TrxName(), sql, getTF_Tyre_ID(), getDateAcct());
		sql = " SELECT COUNT(*) FROM TF_TyreMovement WHERE TF_Tyre_ID = ? AND MovementDate > ?";
		int count1 = DB.getSQLValue(get_TrxName(), sql, getTF_Tyre_ID(), getDateAcct());
		return (count == 0 && count1 == 0);
	}
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			if(isLatestDocument()) {
				MTyre tyre = new MTyre(getCtx(), getTF_Tyre_ID(), get_TrxName());
				tyre.setTF_TyreStatus_ID(getNew_TF_TyreStatus_ID());
				if(getNew_TF_TyreType_ID() > 0)
					tyre.setCurrent_TyreType_ID(getNew_TF_TyreType_ID());
				tyre.saveEx();
			}
			else {
				throw new AdempiereException("You cannot complete entry for the old date!");
			}

		}
	}
	public void reverseIt() {
		setProcessed(false);
		setDocStatus(DOCSTATUS_Drafted);
		
		if(isLatestDocument()) {
			MTyre tyre = new MTyre(getCtx(), getTF_Tyre_ID(), get_TrxName());
			tyre.setTF_TyreStatus_ID(getCurr_TF_TyreStatus_ID());
			tyre.setCurrent_TyreType_ID(getCurr_TF_TyreType_ID());
			tyre.saveEx();
		}
		else {
			throw new AdempiereException("You cannot reverse old entry for this tyre!");
		}
	}
}
