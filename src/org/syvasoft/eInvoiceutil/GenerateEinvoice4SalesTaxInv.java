package org.syvasoft.eInvoiceutil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.compiere.model.MInvoiceLine;
import org.compiere.model.MLocation;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.syvasoft.tallyfrontcrusher.model.MEInvoiceLog;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoice;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoiceLine;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrg;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class GenerateEinvoice4SalesTaxInv {

	MTRTaxInvoice _inv = null;
	public ArrayList<String> errors = null;
	String _docType = "INV";
	int errorCount = 0;
	String AuthenticationToken = null;
	TF_MOrg org=null;
	int AD_PInstance_ID  = 0;
	
	public static String AUTH_TOKEN = null;
	public static Timestamp AUTH_EXPIRY = null;
	
	public GenerateEinvoice4SalesTaxInv(MTRTaxInvoice inv, String docTyp, int PInstance_ID) {
		_inv = inv;
		errors =  new ArrayList<String>();
		_docType = docTyp;
		org = new TF_MOrg(getCtx(), inv.getAD_Org_ID(), inv.get_TrxName());
		AD_PInstance_ID = PInstance_ID;
	}

	private Properties getCtx() {
		return _inv.getCtx();
	}
	
	private String get_TrxName() {
		return _inv.get_TrxName();
	}
	
	private ArrayList<String> errorMsgs() {
		return errors;
	}
	
	private int getAD_PInstance_ID() {
		return AD_PInstance_ID;
	}
	
	private Timestamp getNow() {
		Date d = new Date();
		return new Timestamp(d.getTime());
	}
		
	private boolean isAuthTokenExpired() {
	
		if(AUTH_EXPIRY == null || AUTH_TOKEN == null) {
			return true;			
		}
		
	  long milliseconds1 = AUTH_EXPIRY.getTime();
	  long milliseconds2 = getNow().getTime();

	  long diff = milliseconds2 - milliseconds1;
	  //long diffSeconds = diff / 1000;
	  //long diffMinutes = diff / (60 * 1000);
	  long diffHours = diff / (60 * 60 * 1000);	  
	  //long diffDays = diff / (24 * 60 * 60 * 1000);
	
	  //TOKEN VALIDATITY IS 5 TO 6 HOURS ONLY
	  return diffHours > 4;
	  
	}
	
	public String printJSONObject() {
		
		MTRTaxInvoice inv = _inv;
		
		JSONObject jo = new JSONObject();
		jo.put("Version", "1.1");
		
		 TF_MBPartner bp = new TF_MBPartner(getCtx(),inv.getC_BPartner_ID(),get_TrxName());
			if(bp.getTaxID().length() == 15) {
			 boolean hasTCS = bp.isApplyTCS();
			 TF_MOrg org = new TF_MOrg(getCtx(),inv.getAD_Org_ID(),get_TrxName());
			 MOrgInfo orginfo = org.getInfo();
			 MLocation loc = new MLocation(getCtx(),orginfo.getC_Location_ID(),get_TrxName());
			 List<MTRTaxInvoiceLine> lines = inv.getLines();
			 JSONObject jsi = new JSONObject();
			 JSONArray arr = new JSONArray();
			 BigDecimal IGSTAmt = Env.ZERO;
			 BigDecimal CGSTAmt = Env.ZERO;
			 BigDecimal TotalCGST = Env.ZERO;
			 BigDecimal TotalIGST = Env.ZERO;
			 BigDecimal OtherCharges = Env.ZERO;
			 BigDecimal totalInvoiceLines = Env.ZERO;
			 int i = 0;
			 for (MTRTaxInvoiceLine line : lines)
			{
				 i++;
				 
				TF_MProduct prod = new TF_MProduct(getCtx(),line.getM_Product_ID() ,get_TrxName());
				

				if(inv.isInterState())
				{
					IGSTAmt = line.getIGST_Amt().setScale(2,RoundingMode.HALF_EVEN);
				}
				else
				{
					//CGSTAmt = line.getLineNetAmt().multiply(tax.getRate()).divide(Env.ONEHUNDRED).setScale(2,RoundingMode.HALF_EVEN);
					CGSTAmt = line.getCGST_Amt().setScale(2,RoundingMode.HALF_EVEN);
				}
				OtherCharges = inv.getTCSAmount().add(inv.getRoundOff()).setScale(2,RoundingMode.HALF_EVEN);
				
				TotalCGST = CGSTAmt.add(TotalCGST);
				TotalIGST = IGSTAmt.add(TotalIGST);
				try {
				String slNo = (i+1) + "";
					String IsServc = prod.getProductType().equals(TF_MProduct.PRODUCTTYPE_Item) ? "N" : "Y";
					jsi = new JSONObject();
					jsi = jsi.put("SlNo",slNo).put("IsServc",IsServc).put("PrdDesc",prod.getName()).put("HsnCd",prod.getHSNCode()).put("Barcde",prod.getHSNCode());
					 jsi.put("Qty",line.getQty().setScale(2, RoundingMode.HALF_EVEN))
					 .put("FreeQty",0)
					 .put("Unit",line.getC_UOM().getUOMSymbol())
					 .put("UnitPrice",line.getPrice().setScale(2, RoundingMode.HALF_EVEN))
					 .put("TotAmt",line.getTaxableAmount().setScale(2, RoundingMode.HALF_EVEN))
					 .put("Discount",0)
					 .put("PreTaxVal",1)
					 .put("AssAmt",line.getTaxableAmount().setScale(2, RoundingMode.HALF_EVEN))
					 .put("GstRt",line.getTaxRate())
					 .put("SgstAmt",CGSTAmt)
					 .put("IgstAmt",IGSTAmt)
					 .put("CgstAmt",CGSTAmt)
					 .put("CesRt",0)
					 .put("CesAmt",0)
					 .put("CesNonAdvlAmt",0)
					 .put("StateCesRt",0)
					 .put("StateCesAmt",0)
					 .put("StateCesNonAdvlAmt",0)
					 .put("OthChrg",0)
					 .put("TotItemVal",line.getLineTotalAmt().setScale(2, RoundingMode.HALF_EVEN))
					 .put("OrdLineRef",JSONObject.NULL)
					 .put("OrgCntry",JSONObject.NULL)
					 .put("PrdSlNo",JSONObject.NULL);
					 //jsonArrayBuilderItemList.add(jsi);
					 arr.put(jsi);
				}
				catch(Exception ex) {
					 errors.add("Incomplete Information in Product or Invoice Line #" + (i+1));
					 errors.add(ex.getMessage());				
				}
				
				totalInvoiceLines = totalInvoiceLines.add(line.getTaxableAmount().setScale(2, RoundingMode.HALF_EVEN)).setScale(2, RoundingMode.HALF_EVEN);
			}
			 
			 DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			 
			 try {		
			 jo.put("TranDtls",
			 (new JSONObject()).put("TaxSch", "GST")
	         .put("SupTyp", "B2B")
	         .put("RegRev", "N")
	         .put("EcmGstin", JSONObject.NULL)
	         .put("IgstOnIntra", "N"))
			 .put("DocDtls",
			 (new JSONObject()).put("Typ", _docType)
			 .put("No", inv.getDocumentNo())
			 .put("Dt", inv.getDateAcct().toLocalDateTime().format(FORMATTER)))
			 .put("SellerDtls",
			 (new JSONObject()).put("Gstin",org.getgstin())
			 .put("LglNm",org.getName())
			 .put("TrdNm",org.getName())
			 .put("Addr1",loc.getAddress1())
			 .put("Addr2",loc.getAddress2())
			 .put("Loc",loc.getCity())
			 .put("Pin",Integer.parseInt(org.getInfo().getC_Location().getPostal()))
			 .put("Stcd",org.getStateCode())
			 .put("Ph",orginfo.getPhone())
			 .put("Em",orginfo.getEMail()))
			 .put("BuyerDtls",
			 (new JSONObject()).put("Gstin",bp.getTaxID())
			 .put("LglNm",bp.getName())
			 .put("TrdNm",bp.getName())
			 .put("Pos",bp.getStateCode())
			 .put("Addr1",bp.getAddress1())
			 .put("Addr2",bp.getAddress2())
			 .put("Loc",bp.getCity())
			 .put("Pin",Integer.parseInt(bp.getPostal()))
			 .put("Stcd",bp.getStateCode())
			 .put("Ph",bp.getPhone())
			 .put("Em",JSONObject.NULL));
			 }
			 catch(Exception ex) {
				 errors.add("Incomplate Information in the Organization or Business Partner level");
				 errors.add(ex.getMessage());
			 }
			 OtherCharges = inv.getTCSAmount().setScale(2,RoundingMode.HALF_EVEN);
			 
			 BigDecimal rndOff = BigDecimal.ZERO;
			 if(OtherCharges.doubleValue() < 0 ) {
				 rndOff = OtherCharges;
				 OtherCharges = BigDecimal.ZERO;
			 }
			 
			 jo.put("ItemList", arr) //jsonArrayBuilderItemList)
			 .put("ValDtls",(new JSONObject()).put("AssVal",totalInvoiceLines)
			 .put("CgstVal",TotalCGST)
			 .put("SgstVal",TotalCGST)
			 .put("IgstVal",TotalIGST)
			 .put("CesVal",0)
			 .put("StCesVal",0)
			 .put("Discount",0)
			 .put("OthChrg",OtherCharges)
			 .put("RndOffAmt",inv.getRoundOff())
			 .put("TotInvVal",inv.getGrandTotal())
			 .put("TotInvValFc",inv.getTotal())
			 );
			 
			 System.out.println("JSON================>"+jo.toString());
			 return jo.toString();
			 
			}
			else 
				return "0";
	}

	private String eInvoiceAuthentication() {
		
		
		if(isAuthTokenExpired()) {
			AuthenticationToken =  null;
		}
		else {
			AuthenticationToken =  AUTH_TOKEN;
		}
		
			
		
		if(AuthenticationToken != null)
			return null;
		
		String inputLine=null;
		StringBuffer response = new StringBuffer();
		HttpURLConnection con;
		String status_code = null,status_desc=null;
		String link=org.geteInvoiceBaseURL().concat(org.geteInvAuthenticationURL());
		link = link+org.getEMail();
		URL url;
		try {
		url = new URL(link);
		con = (HttpURLConnection) url.openConnection(); 
		con.setRequestProperty("username",org.getUserName());
		con.setRequestProperty("password",org.getPassword());
		con.setRequestProperty("ip_address",org.getIP_Address());
		con.setRequestProperty("gstin",org.getgstin());
		con.setRequestProperty("client_id",org.getClient());
		con.setRequestProperty("client_secret",org.getClientValue());
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
			AuthenticationToken = jsonObjchild.getString("AuthToken");
			AUTH_TOKEN = AuthenticationToken;			
			AUTH_EXPIRY = getNow();
			
			System.out.println("Authentication Code=================================================>"+AuthenticationToken);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				errors.add("eInvoice Try2 : " + e1.getMessage());
			}
		return "Status Code:"+status_code+";Status Description:"+status_desc;
	}
	
	public String generateeInvoice() {
		
		boolean eInvoiceLiveMode = MSysConfig.getBooleanValue("eINVOICE_LIVE", false);
		
		if(!eInvoiceLiveMode) {
			return printJSONObject();
		}
		eInvoiceAuthentication();
		
		String inputLine = null;
		StringBuffer response = new StringBuffer();
		String link=org.geteInvoiceBaseURL().concat(org.geteInvoiceGenerationURL());		
		link = link+"?email="+org.getEMail();
		URL url;
		MEInvoiceLog eLog = new MEInvoiceLog(getCtx(), 0, get_TrxName());
		eLog.setAD_Org_ID(_inv.getAD_Org_ID());
		eLog.setAD_Table_ID(MTRTaxInvoice.Table_ID);
		eLog.setRecord_ID(_inv.get_ID());
		eLog.setC_Invoice_ID(_inv.get_ID());
		eLog.setTF_TRTaxInvoice_ID(_inv.getTF_TRTaxInvoice_ID());
		eLog.setAD_PInstance_ID(getAD_PInstance_ID());
		
		try {
		url = new URL(link);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("content-type","application/json;charset=UTF-8");
		con.setRequestProperty("ip_address",org.getIP_Address());
		con.setRequestProperty("client_id",org.getClient());
		con.setRequestProperty("client_secret",org.getClientValue());
		con.setRequestProperty("username",org.getUserName());
		System.out.println("Token===============================>"+AuthenticationToken);
		con.setRequestProperty("auth-token",AuthenticationToken);
		con.setRequestProperty("gstin",org.getgstin());
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(printJSONObject());
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();
		System.out.println("'POST' request to URL : " + wr.toString());
		System.out.println("Response Code : " + responseCode);
		System.out.println("Response Body : "+con.getResponseMessage());
		System.out.println("Response Stream---------------> : "+con.getContentType());
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		while ((inputLine = in.readLine()) != null) {
		response.append(inputLine); 
		}
		in.close();
		} 
        catch(Exception e) {
        	System.out.println("Exception======================>"+e);
        	errors.add("eInvoice Generation Try1 : " + e.getMessage());
        }
		try {
			System.out.println("Exception======================>"+response.toString());
			
			eLog.setResponseText(response.toString());
			
			JSONObject jsonObj = new JSONObject(response.toString());		
			System.out.println(jsonObj);
			
			if(jsonObj.has("data")) {
			
				JSONObject jsonObjchild = jsonObj.getJSONObject("data");
				String status = jsonObjchild.getString("Status");
				String IRN = jsonObjchild.getString("Irn");
				String AckNo = jsonObjchild.getNumber("AckNo").toString();
				String AckDt = jsonObjchild.getString("AckDt");
				String SignedQRCode = jsonObjchild.getString("SignedQRCode");
								
				eLog.setAckNo(AckNo);
				eLog.setAckDt(AckDt);
				eLog.setSignedQRCode(SignedQRCode);
				eLog.setIRN(IRN);
				
				_inv.setAckNo(AckNo);
				_inv.setAckDt(AckDt);
				_inv.setSignedQRCode(SignedQRCode);
				_inv.setIRN(IRN);
				_inv.saveEx();
				//addLog(0, null, null, "eInvoice is generated: " + inv.getDocumentNo() , inv.get_Table_ID() , inv.get_ID());
			}
			else {
				eLog.saveEx();
				//addLog(0, null, null, "eInvoice generation Error", eLog.get_Table_ID() , eLog.get_ID());
				errorCount ++;
			}
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			eLog.setResponseText(e1.getMessage());
			errors.add("Try2 : " + e1.getMessage());
			errorCount ++;
		}
	    eLog.saveEx();
		return "";//"ewayBillNo:"+ewayBillNo+";ewayBillDate: "+ewayBillDate+";validUpto:"+validUpto;
	}
	 
}
