package org.nettyfish.sms.api;

import java.math.BigDecimal;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

public class ProcessTestSMS extends SvrProcess {

	int m_AD_Client_ID=0;
	int m_AD_Org_ID=0;
	String Message="";
	String Receipiants="";
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		m_AD_Client_ID = Env.getAD_Client_ID(getCtx());
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();			
			if (name.equals("AD_Org_ID"))				
				m_AD_Org_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("Receipiants"))
				Receipiants = para[i].getParameter().toString();			
			else if (name.equals("Message"))
				Message = para[i].getParameter().toString();
		}
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		SMSUtil sutil=new SMSUtil();
		String Result=sutil.SendSMS(m_AD_Client_ID, m_AD_Org_ID, Receipiants, Message,"0");
		return null;
	}

}
