package org.syvasoft.tallyfrontcrusher.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.Level;

import javax.naming.ldap.ManageReferralControl;

import org.adempiere.webui.apps.AEnv;
import org.compiere.model.MBPartner;
import org.compiere.model.MColumn;
import org.compiere.model.MRefList;
import org.compiere.model.MTable;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.model.X_AD_Reference;
import org.compiere.util.CCache;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Util;

public class TF_MailText extends X_R_MailText {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9037953250901970096L;
	public TF_MailText(Properties ctx, int R_MailText_ID, String trxName) {
		super(ctx, R_MailText_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public TF_MailText(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/** To User */
	private String m_recipientName = null;
	/**	Parse User			*/
	private MUser		m_user = null;
	/** Parse BPartner		*/
	private MBPartner	m_bpartner = null;
	/** Parse PO			*/
	private PO			m_po = null;
	/** Translated Header	*/
	private String		m_MailHeader = null;
	/** Translated Text		*/
	private String		m_MailText = null;
	/** Translated Text 2	*/
	private String		m_MailText2 = null;
	/** Translated Text 3	*/
	private String		m_MailText3 = null;
	/** Translation Cache	*/
	private static CCache<String,MMailTextTrl> s_cacheTrl = new CCache<String,MMailTextTrl> (Table_Name, 20);
	private String m_language = null;
	
	public void setRecipientName(String recipientName) {
		m_recipientName = recipientName; 
	}
	
	
	/**
	 * 	Get parsed/translated Mail Text
	 *	@param all concatinate all
	 *	@return parsed/translated text
	 */
	public String getMailText(boolean all)
	{
		if (m_MailText == null)
			translate();
		if (!all)
			return parse(m_MailText);
		//
		StringBuilder sb = new StringBuilder();
		sb.append(m_MailText);
		String s = m_MailText2;
		if (s != null && s.length() > 0)
			sb.append("\n").append(s);
		s = m_MailText3;
		if (s != null && s.length() > 0)
			sb.append("\n").append(s);
		//
		return parse(sb.toString());
	}	//	getMailText

	/**
	 * 	Get parsed/translated Mail Text
	 *	@return parsed/translated text
	 */
	public String getMailText()
	{
		if (m_MailText == null)
			translate();
		return parse (m_MailText);
	}	//	getMailText
	
	/**
	 * 	Get parsed/translated Mail Text 2
	 *	@return parsed/translated text
	 */
	public String getMailText2()
	{
		if (m_MailText == null)
			translate();
		return parse (m_MailText2);
	}	//	getMailText2

	/**
	 * 	Get parsed/translated Mail Text 2
	 *	@return parsed/translated text
	 */
	public String getMailText3()
	{
		if (m_MailText == null)
			translate();
		return parse (m_MailText3);
	}	//	getMailText3

	/**
	 * 	Get parsed/translated Mail Header
	 *	@return parsed/translated text
	 */
	public String getMailHeader()
	{
		if (m_MailHeader == null)
			translate();
		return parse(m_MailHeader);
	}	//	getMailHeader
	
	/**************************************************************************
	 * 	Parse Text
	 *	@param text text
	 *	@return parsed text
	 */
	private String parse (String text)
	{
		if (Util.isEmpty(text) || text.indexOf('@') == -1)
			return text;
		//set Recipient Name
		if(m_recipientName != null)
			text = text.replaceAll("@RecipientName@", m_recipientName);		
		//set record utl
		if(m_po != null)
			text = text.replaceAll("@URL@", AEnv.getZoomUrlTableID(m_po));
		//	Parse User
		text = parse (text, m_user);
		//	Parse BP
		text = parse (text, m_bpartner);
		//	Parse PO
		text = parse (text, m_po);
		//
		return text;
	}	//	parse
	
	/**
	 * 	Parse text
	 *	@param text text
	 *	@param po object
	 *	@return parsed text
	 */
	private String parse (String text, PO po)
	{
		if (po == null || text.indexOf('@') == -1)
			return text;

		String inStr = text;
		String token;
		StringBuilder outStr = new StringBuilder();

		int i = inStr.indexOf('@');
		while (i != -1)
		{
			outStr.append(inStr.substring(0, i));			// up to @
			inStr = inStr.substring(i+1, inStr.length());	// from first @

			int j = inStr.indexOf('@');						// next @
			if (j < 0)										// no second tag
			{
				inStr = "@" + inStr;
				break;
			}

			token = inStr.substring(0, j);

			//format string
			String format = "";
			int f = token.indexOf('<');
			if (f > 0 && token.endsWith(">")) {
				format = token.substring(f+1, token.length()-1);
				token = token.substring(0, f);
			}

			outStr.append(parseVariable(token, format,po));		// replace context

			inStr = inStr.substring(j+1, inStr.length());	// from second @
			i = inStr.indexOf('@');
			//outStr.append(System.getProperty("line.separator"));
		}

		outStr.append(inStr);				//	add remainder
		return outStr.toString();
	}	//	parse

	/**
	 * 	Parse Variable
	 *	@param variable variable
	 *	@param po po
	 *	@return translated variable or if not found the original tag
	 */
	private String parseVariable (String variable, PO po)
	{
		int index = po.get_ColumnIndex(variable);
		if (index == -1){
			StringBuilder msgreturn = new StringBuilder("@").append(variable).append("@");
			return msgreturn.toString();	//	keep for next
		}	
		//
		MColumn col = MColumn.get(Env.getCtx(), po.get_TableName(), variable);
		Object value = null;
		if (col != null && col.isSecure()) {
			value = "********";
		} else if (col.getAD_Reference_ID() == DisplayType.Date || col.getAD_Reference_ID() == DisplayType.DateTime || col.getAD_Reference_ID() == DisplayType.Time) {
			SimpleDateFormat sdf = DisplayType.getDateFormat(col.getAD_Reference_ID());
			value = sdf.format (po.get_Value(index));	
		} else if (col.getAD_Reference_ID() == DisplayType.YesNo) {
			if (po.get_ValueAsBoolean(variable))
				value = Msg.getMsg(Env.getCtx(), "Yes");
			else
				value = Msg.getMsg(Env.getCtx(), "No");
		} else {
			value = po.get_Value(index);
		}
		if (value == null)
			return "";
		return value.toString();
	}	//	translate
	
	/**
	 * 	Parse Variable
	 *	@param variable variable
	 *	@param po po
	 *	@return translated variable or if not found the original tag
	 */
	private String parseVariable (String variable, String format,PO po)
	{
		int index = po.get_ColumnIndex(variable);
		if (index == -1){
			int i = variable.indexOf('.');
			if(i != -1)
			{
				StringBuilder outStr = new StringBuilder();
				outStr.append(variable.substring(0, i));
				variable = variable.substring(i+1, variable.length());
				outStr.append("_ID"); //Foreign Key column

				index = po.get_ColumnIndex(outStr.toString());

				Integer subRecordId;

				if (index != -1){
					MColumn column = MColumn.get(Env.getCtx(), po.get_TableName(), po.get_ColumnName(index));
					MTable table = MTable.get(Env.getCtx(),column.getReferenceTableName());

					subRecordId = (Integer)po.get_Value(outStr.toString());
					if(subRecordId==null)
						return "";
					PO subPo = null;
					if(table != null)						
						subPo = table.getPO(subRecordId, get_TrxName());
					else
						subPo = po;
					return parseVariable(variable,format,subPo);
				}
			}

			StringBuilder msgreturn = new StringBuilder("@").append(variable).append("@");
			return msgreturn.toString();	//	keep for next
		}	
		//
		MColumn col = MColumn.get(Env.getCtx(), po.get_TableName(), variable);
		Object value = null;
		if (col != null && col.isSecure()) {
			value = "********";
		} else if (col.getAD_Reference_ID() == DisplayType.Date || col.getAD_Reference_ID() == DisplayType.DateTime || col.getAD_Reference_ID() == DisplayType.Time) {
			SimpleDateFormat sdf;
			if(format != null && format.length() > 0){
				sdf = new SimpleDateFormat(format, Env.getLanguage(Env.getCtx()).getLocale());
			}else{
				sdf = DisplayType.getDateFormat(col.getAD_Reference_ID());
			}
			if(po.get_Value(index)!=null)
				value = sdf.format (po.get_Value(index));	
		} else if (col.getAD_Reference_ID() == DisplayType.YesNo) {
			if (po.get_ValueAsBoolean(variable))
				value = Msg.getMsg(Env.getCtx(), "Yes");
			else
				value = Msg.getMsg(Env.getCtx(), "No");
		}else if (col.getAD_Reference_ID() == DisplayType.Number || col.getAD_Reference_ID() == DisplayType.Amount) {
			DecimalFormat df;
			if(format != null && format.length() > 0){
				df =  DisplayType.getNumberFormat(col.getAD_Reference_ID(),null,format);
			}else{
				df = DisplayType.getNumberFormat(col.getAD_Reference_ID());
			}
			if(po.get_Value(index)!=null)
				value = df.format (po.get_Value(index));	
		}else if (col.getAD_Reference_Value_ID() > 0) {
			X_AD_Reference refL = (X_AD_Reference) col.getAD_Reference_Value();
			MRefList rfl = MRefList.get(getCtx(), refL.getAD_Reference_ID(), po.get_Value(index).toString(), null);
			value = rfl.getName();
		}		
		else {
			value = po.get_Value(index);
		}
		if (value == null)
			return "";
		return value.toString();
	}	//	parseVariable
	
	/**
	 * 	Set User for parse
	 *	@param AD_User_ID user
	 */
	public void setUser (int AD_User_ID)
	{
		m_user = MUser.get (getCtx(), AD_User_ID);
	}	//	setUser
	
	/**
	 * 	Set User for parse
	 *	@param user user
	 */
	public void setUser (MUser user)
	{
		m_user = user;
	}	//	setUser
	
	/**
	 * 	Set BPartner for parse
	 *	@param C_BPartner_ID bp
	 */
	public void setBPartner (int C_BPartner_ID)
	{
		m_bpartner = new MBPartner (getCtx(), C_BPartner_ID, get_TrxName());
	}	//	setBPartner
	
	/**
	 * 	Set BPartner for parse
	 *	@param bpartner bp
	 */
	public void setBPartner (MBPartner bpartner)
	{
		m_bpartner = bpartner;
	}	//	setBPartner

	/**
	 * 	Set PO for parse
	 *	@param po po
	 */
	public void setPO (PO po)
	{
		m_po = po;
	}	//	setPO

	/**
	 * 	Set PO for parse
	 *	@param po po
	 *	@param analyse if set to true, search for BPartner/User
	 */
	public void setPO (PO po, boolean analyse)
	{
		m_po = po;
		if (analyse)
		{
			int index = po.get_ColumnIndex("C_BPartner_ID");
			if (index > 0)
			{
				Object oo = po.get_Value(index);
				if (oo instanceof Integer)
				{
					int C_BPartner_ID = ((Integer)oo).intValue();
					setBPartner(C_BPartner_ID);
				}
			}
			index = po.get_ColumnIndex("AD_User_ID");
			if (index > 0)
			{
				Object oo = po.get_Value(index);
				if (oo instanceof Integer)
				{
					int AD_User_ID = ((Integer)oo).intValue();
					setUser(AD_User_ID);
				}
			}
		}
	}	//	setPO

	/**
	 * 	Translate to BPartner Language
	 */
	private void translate()
	{
		//	Default if no Translation
		m_MailHeader = super.getMailHeader();
		m_MailText = super.getMailText();
		m_MailText2 = super.getMailText2();
		m_MailText3 = super.getMailText3();
		if ((m_bpartner != null && m_bpartner.getAD_Language() != null) || !Util.isEmpty(m_language))
		{
			String adLanguage = m_bpartner != null ? m_bpartner.getAD_Language() : m_language;
			StringBuilder key = new StringBuilder().append(adLanguage).append(get_ID());
			MMailTextTrl trl = s_cacheTrl.get(key.toString());
			if (trl == null)
			{
				trl = getTranslation(adLanguage);
				if (trl != null)
					s_cacheTrl.put(key.toString(), trl);
			}
			if (trl != null)
			{
				m_MailHeader = trl.MailHeader;
				m_MailText = trl.MailText;
				m_MailText2 = trl.MailText2;
				m_MailText3 = trl.MailText3;
			}
		}
	}	//	translate
	
	/**
	 * 	Get Translation
	 *	@param AD_Language language
	 *	@return trl
	 */
	private MMailTextTrl getTranslation (String AD_Language)
	{
		MMailTextTrl trl = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM R_MailText_Trl WHERE R_MailText_ID=? AND AD_Language=?";
		try
		{
			pstmt = DB.prepareStatement (sql, null);
			pstmt.setInt (1, getR_MailText_ID());
			pstmt.setString(2, AD_Language);
			rs = pstmt.executeQuery ();
			if (rs.next())
			{
				trl = new MMailTextTrl();
				trl.AD_Language = rs.getString("AD_Language");
				trl.MailHeader = rs.getString("MailHeader");
				trl.MailText = rs.getString("MailText");
				trl.MailText2 = rs.getString("MailText2");
				trl.MailText3 = rs.getString("MailText3");
			}
		}
		catch (Exception e)
		{
			log.log (Level.SEVERE, sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}

		return trl;
	}	//	getTranslation
	
	/**
	 *	MailText Translation VO
	 */
	static class MMailTextTrl
	{
		/** Language			*/
		String		AD_Language = null;
		/** Translated Header	*/
		String		MailHeader = null;
		/** Translated Text		*/
		String		MailText = null;
		/** Translated Text 2	*/
		String		MailText2 = null;
		/** Translated Text 3	*/
		String		MailText3 = null;
	}	//	MMailTextTrl
	
	public void setLanguage(String language)
	{
		m_language = language;
	}	

}
