package org.nettyfish.sms.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.compiere.model.MSysConfig;
import org.compiere.util.Env;
import org.json.JSONException;


public class SMSUtil {

	public String SendSMS(int AD_Client_ID,int AD_Org_ID,String receipiants,String Message,String UniCode) {
		String result;
		String apikey=MSysConfig.getValue("SMS_APIKEY", AD_Client_ID, AD_Org_ID);
		String clientid=MSysConfig.getValue("SMS_CLIENTID", AD_Client_ID, AD_Org_ID).toString();
		String senderid=MSysConfig.getValue("SMS_SENDERID", AD_Client_ID, AD_Org_ID).toString();
		String smsGatewayURL=MSysConfig.getValue("SMS_HTTPAPI", AD_Client_ID, AD_Org_ID).toString();
		String fl = "0";
		String gwid = "2";
		String SMSENABLELOG=MSysConfig.getValue("SMS_ENABLE_LOG", AD_Client_ID, AD_Org_ID).toString();		
		//Message=Message.replace(" ", "%20");		
		if(receipiants == null || receipiants.length() == 0 ||  Message.length() == 0)
			return null;
		try {
						
				URL url = new URL(smsGatewayURL);				
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("POST");
				String urlParameters = "apikey=" + apikey + "&clientid=" + clientid + 
						"&msisdn=" + receipiants + "&sid=" + senderid 
						+ "&msg=" + Message + "&fl=" + fl + "&gwid=" +gwid;
				
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setUseCaches(false);
				DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();
				
				//conn.connect();				
				int responseCode = conn.getResponseCode();
				//System.out.println("\nSending 'POST' request to URL : " + url);
				//System.out.println("Post parameters : " + urlParameters);
				//System.out.println("Response Code : " + responseCode);
				
				BufferedReader rd = new BufferedReader(new
				InputStreamReader(conn.getInputStream()));
				String line;
				StringBuffer buffer = new StringBuffer();
				while ((line = rd.readLine()) != null){
					buffer.append(line).append("\n");
				}
				rd.close();
				conn.disconnect();
				result=buffer.toString();
				
				if(SMSENABLELOG.equals("Y")) {
					SaveSmsDeliveryLog(AD_Org_ID,receipiants,Message,result);
				}
				return null;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public void SaveSmsDeliveryLog(int AD_Org_ID,String Receipiants,String Message,String result) {
				
		MSMSDeliveryLog sdlog=new MSMSDeliveryLog(Env.getCtx(), 0, null);			
		
		sdlog.setAD_Org_ID(AD_Org_ID);
		sdlog.setRecipients(Receipiants);
		sdlog.setMessage(Message.replace("%20"," "));
		sdlog.setResult(result);
		//sdlog.setLoginStatus(jsonObj.getString("LoginStatus"));
		//sdlog.setBalance(jsonObj.getInt("Balance"));
		//sdlog.setBalanceStatus(jsonObj.getString("BalanceStatus"));
		//sdlog.setCurrentBalance(jsonObj.getInt("CurrentBalance"));
		//sdlog.setValidNumbers(jsonObj.getInt("ValidNumbers"));
		//sdlog.setSmsCount(jsonObj.getInt("SMSCount"));
		//sdlog.setMsgStatus(jsonObj.getString("MsgStatus"));
		//sdlog.setTransactionID(jsonObj.getString("Transaction_ID"));
		sdlog.saveEx();		
	}
	
}
