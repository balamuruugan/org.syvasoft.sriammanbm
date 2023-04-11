package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.acct.Doc_BankStatement;
import org.compiere.process.DocAction;

public class MToken extends X_TF_Token {
	
	private static final long serialVersionUID = -8086398266293054622L;

	public MToken(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MToken(Properties ctx, int TF_Destination_ID, String trxName) {
		super(ctx, TF_Destination_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			String documentNo = MDaySequence.getNextSequence(getCtx(), getAD_Org_ID(), 
					getDateAcct(), "TOKEN", "00", get_TrxName());
			setDocumentNo(documentNo);
		}
		return super.beforeSave(newRecord);
	}
	public void processIt(String docAction) {
		if(docAction.equals(DocAction.ACTION_Complete))
			setProcessed(true);
	}
	public void reverseIt() {
		//setDocStatus(DOCSTATUS_InProgress);
		setProcessed(false);		

	}
	public void close() {
		if(getStatus().equals(STATUS_Closed))
			throw new AdempiereException("Token No is already closed!");
		setStatus(STATUS_Closed);		
	}
	public void reverse() {
		setStatus(STATUS_Open);		
	}
	
}
