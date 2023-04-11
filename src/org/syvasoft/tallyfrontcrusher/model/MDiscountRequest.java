package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MClient;
import org.compiere.model.MNote;
import org.compiere.model.MUser;
import org.compiere.util.EMail;
import org.compiere.util.Env;

public class MDiscountRequest extends X_TF_DiscountRequest {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6077541940782954617L;

	public MDiscountRequest(Properties ctx, int TF_DiscountRequest_ID, String trxName) {
		super(ctx, TF_DiscountRequest_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MDiscountRequest(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public void closeIt() {
		setProcessed(true);
		setDiscntStatus(DISCNTSTATUS_Closed);
	}
	
	public void voidIt() {
		setProcessed(true);
		setDiscntStatus(DISCNTSTATUS_Voided);
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			if(getPartyName() == null) {
				setPartyName(getC_BPartner().getName());
			}
		}
		return super.beforeSave(newRecord);
	}
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		try {
			if(DISCNTSTATUS_Requested.equals(getDiscntStatus()) && newRecord) {
				sendEmailforDiscountRequest();
			}
			else if(!newRecord && DISCNTSTATUS_Approved.equals(getDiscntStatus()) 
					&& is_ValueChanged(COLUMNNAME_DiscntStatus)) {
				sendEmailforDiscountApproved();
			}
		}
		catch (Exception ex) {
			throw ex;
			//createNote(ex.getMessage());
		}
		return super.afterSave(newRecord, success);
	}
	
	private void sendEmailforDiscountRequest() {
		
		MEmailAlertSetup alertType = MEmailAlertSetup.get(getCtx(), getAD_Org_ID(), 
				"DISCOUNT_REQUEST", get_TrxName());
		
		if(alertType == null)
			return;
		
		TF_MailText mailText = new TF_MailText(getCtx(), alertType.getR_MailText_ID(), get_TrxName());
		mailText.setRecipientName(alertType.getAD_User().getName());
		mailText.setUser(getUpdatedBy());
		mailText.setBPartner(getC_BPartner_ID());
		mailText.setPO(this);
		
		MUser sender = MUser.get(getCtx(), getCreatedBy());
		
		MClient m_client = MClient.get(getCtx(), getAD_Client_ID());
		EMail email = new EMail(m_client, sender.getEMail(), "", "", "");
		email.createAuthenticator (m_client.getRequestUser(), m_client.getRequestUserPW());
		String toEmailId = alertType.getAD_User().getEMail();		
		email.addTo(toEmailId);
		
		for(MEmailAlertSetupCC ccAlert : alertType.getCCs()) {
			for(String emailId : ccAlert.getEmailIds()) {
				if(!emailId.equals(toEmailId) && !emailId.equals(sender.getEMail()))
					email.addCc(emailId);
			}
		}
		email.addBcc(sender.getEMail());
		email.setSubject(mailText.getMailHeader());
		if(mailText.isHtml()) {			
			email.setMessageHTML(mailText.getMailText(true));
		}
		else {
			email.setMessageText(mailText.getMailText(true));
		}
		boolean OK = EMail.SENT_OK.equals(email.send());
		if(!OK) {
			log.log(Level.WARNING, "Discount Request Error: " + getDocumentNo());
			createNote(email.getSentMsg());
		}
	}
	
	private void sendEmailforDiscountApproved() {
		
		MEmailAlertSetup alertType = MEmailAlertSetup.get(getCtx(), getAD_Org_ID(), 
				"DISCOUNT_APPROVED", get_TrxName());
		
		if(alertType == null)
			return;
		
		String toEmailId = null;
		if(alertType.isEmailtoCreator()) {
			toEmailId = alertType.getEmailAddress(getCreatedBy());
		}
		else {
			throw new AdempiereException("Invalid Email Notification Setup!");
		}
		MUser user = MUser.get(getCtx(), getCreatedBy()); 
		TF_MailText mailText = new TF_MailText(getCtx(), alertType.getR_MailText_ID(), get_TrxName());
		mailText.setRecipientName(user.getName());
		mailText.setUser(getUpdatedBy());
		mailText.setBPartner(getC_BPartner_ID());
		mailText.setPO(this);
		
		MUser sender = MUser.get(getCtx(), getUpdatedBy());
		
		MClient m_client = MClient.get(getCtx(), getAD_Client_ID());
		EMail email = new EMail(m_client, sender.getEMail(), "", "", "");
		email.createAuthenticator (m_client.getRequestUser(), m_client.getRequestUserPW());
		
		
		
		email.addTo(toEmailId);
		
		for(MEmailAlertSetupCC ccAlert : alertType.getCCs()) {
			for(String emailId : ccAlert.getEmailIds()) {
				if(!emailId.equals(toEmailId) && !emailId.equals(sender.getEMail()))
					email.addCc(emailId);
			}
		}
		email.addBcc(sender.getEMail());
		email.setSubject(mailText.getMailHeader());
		if(mailText.isHtml()) {			
			email.setMessageHTML(mailText.getMailText(true));
		}
		else {
			email.setMessageText(mailText.getMailText(true));
		}
		boolean OK = EMail.SENT_OK.equals(email.send());
		if(!OK) {
			log.log(Level.WARNING, "Discount Request Approved Error: " + getDocumentNo());
			createNote(email.getSentMsg());
		}
	}
	
	public void createNote(String message) {
		MNote note = new MNote(getCtx(), 0, get_TrxName());
		note.setAD_Org_ID(getAD_Org_ID());
		note.setAD_Message_ID("EmailError");
		note.setReference("Email notification error for quote: " + getDocumentNo());
		note.setTextMsg(message);
		note.setRecord(Table_ID, get_ID());
		note.setAD_User_ID(Env.getAD_User_ID(getCtx()));
		note.saveEx();
	}
}
