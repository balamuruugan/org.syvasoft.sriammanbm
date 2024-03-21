package org.syvasoft.eInvoiceutil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import org.compiere.model.MRefList;
import org.compiere.model.MReference;
import org.compiere.model.MSysConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrg;

public class AddressAutoFillUtil {

	public ArrayList<String> errors = null;
	String _docType = "INV";
	int errorCount = 0;
	String AuthenticationToken = null;
	TF_MOrg org=null;
	int AD_PInstance_ID  = 0;
	
	public String Name = null;
	public String Address1 = null;
	public String Address2 = null;
	public String Address3 = null;
	public String City = null;
	public String statecode = null;
	public String Region = null;
	public String zip = null;
	public String email = MSysConfig.getValue("EINVOICE_email", "bala@syvasoft.com");
	public String authenticate_url =  MSysConfig.getValue("EINVOICE_AUTH_URL","https://api.mastergst.com/einvoice/authenticate?");
	public String getGSTINDetail_url = MSysConfig.getValue("EINVOICE_GETGSTIN_DETAIL_URL", "https://api.mastergst.com/einvoice/type/GSTNDETAILS/version/V1_03?");
	
	public AddressAutoFillUtil() {
		// TODO Auto-generated constructor stub
	}

	String userName = MSysConfig.getValue("EINVOICE_USERNAME", "mastergst");
	String password = MSysConfig.getValue("EINVOICE_PASSWORD", "Malli#123");
	String ipaddress = MSysConfig.getValue("EINVOICE_IPADDRESS", "192.46.211.251"); 
	String client_id = MSysConfig.getValue("EINVOICE_CLIENT_ID", "caae5fa9-42f3-4a59-a5fc-ff722980647e");
	String secretkey = MSysConfig.getValue("EINVOICE_CLIENT_KEY", "2bd9d794-e89e-4f35-989a-ff6f77a0cf0a");
	String GSTIN = MSysConfig.getValue("EINVOICE_GSTIN", "29AABCT1332L000");
	
	private String eInvoiceAuthentication() {
						
		
		String inputLine=null;
		StringBuffer response = new StringBuffer();
		HttpURLConnection con;
		String status_code = null,status_desc=null;
		String link = authenticate_url;
		link = link+ email;
		URL url;
		try {
		url = new URL(link);
		con = (HttpURLConnection) url.openConnection(); 
		con.setRequestProperty("username",userName);
		con.setRequestProperty("password",password);
		con.setRequestProperty("ip_address", ipaddress);
		con.setRequestProperty("gstin",GSTIN);
		con.setRequestProperty("client_id",client_id);
		con.setRequestProperty("client_secret",secretkey);
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		int responseCode = con.getResponseCode();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine); 
			}
		in.close();
		 
		} 
        catch(Exception e) {
        	errors.add("eInvoice Authentication : " + e.getMessage());
        }
		try {
			System.out.println(response.toString());
			
			JSONObject jsonObj = new JSONObject(response.toString());
			System.out.println(jsonObj);
			JSONObject jsonObjchild = jsonObj.getJSONObject("data");
			AuthenticationToken = jsonObjchild.getString("AuthToken");			
			
			System.out.println("Authentication Code=================================================>"+AuthenticationToken);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				errors.add("eInvoice Try2 : " + e1.getMessage());
			}
		//fetchAddress();
		
		return "Status Code:"+status_code+";Status Description:"+status_desc;
	}
	
	public void fetchAddress(Properties ctx, String bp_gstin) {
		eInvoiceAuthentication();
		
		//TradeName = Name
		//AddrBno = Address1
		//AddrSt = Address2
		//AddrLoc = Address3
		//StateCode = Statecode
		//AddrPncd = Pincode
		//Region = Text of (StateCode)
		
		
		String inputLine=null;
		StringBuffer response = new StringBuffer();
		HttpURLConnection con;		
		String link = getGSTINDetail_url;
		link = link+ email + "&param1=" + bp_gstin;
		URL url;
		try {
		url = new URL(link);
		con = (HttpURLConnection) url.openConnection(); 
		con.setRequestProperty("username",userName);		
		con.setRequestProperty("ip_address", ipaddress);
		con.setRequestProperty("gstin",GSTIN);
		con.setRequestProperty("client_id",client_id);
		con.setRequestProperty("client_secret",secretkey);
		con.setRequestProperty("auth-token",AuthenticationToken);
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		int responseCode = con.getResponseCode();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine); 
			}
		in.close();
		 
		} 
        catch(Exception e) {
        	errors.add("eInvoice Authentication : " + e.getMessage());
        }
		try {
			JSONObject jsonObj = new JSONObject(response.toString());
			System.out.println(jsonObj);
			JSONObject jsonObjchild = jsonObj.getJSONObject("data");			
			Name = jsonObjchild.getString("TradeName");
			Address1 = jsonObjchild.getString("AddrBno");
			Address2 = jsonObjchild.getString("AddrSt");
			City = jsonObjchild.getString("AddrLoc");
			statecode = jsonObjchild.getString("StateCode");
			zip  = jsonObjchild.getString("AddrPncd");			
			MRefList rl = MRefList.get(ctx, 1000198, statecode, null);
			Region = rl.getName();
			
			System.out.println("Authentication Code=================================================>"+AuthenticationToken);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				errors.add("eInvoice Try2 : " + e1.getMessage());
			}
		
	}
	
}
