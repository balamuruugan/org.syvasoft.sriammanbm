package org.syvasoft.tallyfrontcrusher.process;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Savepoint;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MLocation;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.json.JSONException;
import org.json.JSONObject;
import org.syvasoft.tallyfrontcrusher.model.MEInvoiceLog;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrg;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class GenerateeInvoice extends SvrProcess{

	private String Result = null;
	TF_MOrg org=null;	
	String AuthenticationToken = null;
	Savepoint sp = null;
	
	int errorCount = 0;
	String printJSON = "N";
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("printJSON"))
				printJSON = para[i].getParameterAsString();
		}
		
	}

	@Override
	protected String doIt() throws Exception {		
	
		String whereClause = " DocStatus IN ('CL','CO') AND (EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
				" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = C_Invoice.C_Invoice_ID) OR C_Invoice_ID = ?) "
				+ "  ";
		List<TF_MInvoice> list = new Query(getCtx(), TF_MInvoice.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getAD_PInstance_ID(), getRecord_ID())
				.list();
		
		for(TF_MInvoice inv : list) {
			
			if(errorCount > 2)
				break;
			
			org = new TF_MOrg(getCtx(), inv.getAD_Org_ID(), get_TrxName());
			
			
			Trx trx = Trx.get(get_TrxName(), false);
			try {
				sp = trx.setSavepoint(inv.getDocumentNo());
				if(printJSON.equals("Y")) {
					addLog(printJSONObject(inv));
				}
				else {
					eInvoiceAuthentication();
					generateeInvoice(inv);
				}
				
				trx.releaseSavepoint(sp);
			}
			catch (Exception ex) {				
				if(sp != null)
					trx.rollback(sp);
				throw new AdempiereException(ex);
			}
		}
		return Result;
	}
	private String eInvoiceAuthentication() {
		
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
        	addLog("eInvoice Authentication : " + e.getMessage());
        }
		try {
			JSONObject jsonObj = new JSONObject(response.toString());
			System.out.println(jsonObj);
			JSONObject jsonObjchild = jsonObj.getJSONObject("data");
			AuthenticationToken = jsonObjchild.getString("AuthToken");
			System.out.println("Authentication Code=================================================>"+AuthenticationToken);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				addLog("eInvoice Try2 : " + e1.getMessage());
			}
		return "Status Code:"+status_code+";Status Description:"+status_desc;
	}
	
	private String generateeInvoice(TF_MInvoice inv) {
		String inputLine = null;
		StringBuffer response = new StringBuffer();
		String link=org.geteInvoiceBaseURL().concat(org.geteInvoiceGenerationURL());		
		link = link+"?email="+org.getEMail();
		URL url;
		MEInvoiceLog eLog = new MEInvoiceLog(getCtx(), 0, get_TrxName());
		eLog.setAD_Org_ID(inv.getAD_Org_ID());
		eLog.setAD_Table_ID(TF_MInvoice.Table_ID);
		eLog.setRecord_ID(inv.get_ID());
		eLog.setC_Invoice_ID(inv.get_ID());
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
		wr.writeBytes(printJSONObject(inv));
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
        	addLog("eInvoice Generation Try1 : " + e.getMessage());
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
				String AckNo = jsonObjchild.getString("AckNo");
				String AckDt = jsonObjchild.getString("AckDt");
				String SignedQRCode = jsonObjchild.getString("SignedQRCode");
								
				eLog.setAckNo(AckNo);
				eLog.setAckDt(AckDt);
				eLog.setSignedQRCode(SignedQRCode);
				eLog.setIRN(IRN);
				
				inv.setAckNo(AckNo);
				inv.setAckDt(AckDt);
				inv.setSignedQRCode(SignedQRCode);
				inv.setIRN(IRN);
				inv.saveEx();
				addLog(0, null, null, "eInvoice is generated: " + inv.getDocumentNo() , inv.get_Table_ID() , inv.get_ID());
			}
			else {
				eLog.saveEx();
				addLog(0, null, null, "eInvoice generation Error", eLog.get_Table_ID() , eLog.get_ID());
				errorCount ++;
			}
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			eLog.setResponseText(e1.getMessage());
			addLog("Try2 : " + e1.getMessage());
			errorCount ++;
		}
	    eLog.saveEx();
		return "";//"ewayBillNo:"+ewayBillNo+";ewayBillDate: "+ewayBillDate+";validUpto:"+validUpto;
	}
	 
		    
	public String printJSONObject(TF_MInvoice inv) {
		
		
		JSONObject jo = new JSONObject();
		jo.put("Version", "1.1");
		
		 TF_MBPartner bp = new TF_MBPartner(getCtx(),inv.getC_BPartner_ID(),get_TrxName());
		 boolean hasTCS = bp.isApplyTCS();
		 TF_MOrg org = new TF_MOrg(getCtx(),inv.getAD_Org_ID(),get_TrxName());
		 MOrgInfo orginfo = org.getInfo();
		 MLocation loc = new MLocation(getCtx(),orginfo.getC_Location_ID(),get_TrxName());
		 MInvoiceLine[] lines = inv.getLines(true);
		 JSONObject jsi = new JSONObject();
		 BigDecimal IGSTAmt = Env.ZERO;
		 BigDecimal CGSTAmt = Env.ZERO;
		 BigDecimal TotalCGST = Env.ZERO;
		 BigDecimal TotalIGST = Env.ZERO;
		 BigDecimal OtherCharges = Env.ZERO;
		 for (int i = 0; i < lines.length; i++)
		{
			 MInvoiceLine line = lines[i];
			TF_MProduct prod = new TF_MProduct(getCtx(),line.getM_Product_ID() ,get_TrxName());
			MTax tax = new MTax(getCtx(),line.getC_Tax_ID(),get_TrxName());
			
			if(hasTCS) {
				String whereClause= "C_TaxTCS_ID = ?";
				MTax tax1 = new Query(getCtx(), MTax.Table_Name, whereClause, get_TrxName())
						.setClient_ID()
						.setParameters(tax.get_ID())
						.first();
				if(tax1 != null) 
					tax = tax1;
			}
			
			if(tax.get_ValueAsBoolean("IsInterState"))
			{
				IGSTAmt = line.getLineNetAmt().multiply(tax.getRate()).divide(Env.ONEHUNDRED).setScale(2,RoundingMode.HALF_UP);	
			}
			else
			{
				CGSTAmt = line.getLineNetAmt().multiply(tax.getRate()).divide(Env.ONEHUNDRED).setScale(2,RoundingMode.HALF_EVEN);
				CGSTAmt = CGSTAmt.divide(new BigDecimal(2)).setScale(2,RoundingMode.HALF_EVEN);
			}
			OtherCharges = inv.getGrandTotal().subtract(inv.getTotalLines()).subtract(IGSTAmt).subtract(CGSTAmt).subtract(CGSTAmt);
			
			if(OtherCharges.doubleValue() < 0) {
				CGSTAmt = CGSTAmt.add(OtherCharges.divide(new BigDecimal(2), 2, RoundingMode.HALF_EVEN));
				OtherCharges = BigDecimal.ZERO;
			}
			
			TotalCGST = CGSTAmt.add(TotalCGST);
			TotalIGST = IGSTAmt.add(TotalIGST);
			try {
			String slNo = (i+1) + "";
				String IsServc = prod.getProductType().equals(TF_MProduct.PRODUCTTYPE_Item) ? "N" : "Y";
				jsi = jsi.put("SlNo",slNo).put("IsServc",IsServc).put("PrdDesc",prod.getName()).put("HsnCd",prod.getHSNCode()).put("Barcde",prod.getHSNCode());
				 jsi.put("Qty",line.getQtyEntered().setScale(2, RoundingMode.HALF_EVEN))
				 .put("FreeQty",0)
				 .put("Unit",line.getC_UOM().getUOMSymbol())
				 .put("UnitPrice",line.getPriceEntered().setScale(2, RoundingMode.HALF_EVEN))
				 .put("TotAmt",line.getLineNetAmt())
				 .put("Discount",0)
				 .put("PreTaxVal",1)
				 .put("AssAmt",line.getLineNetAmt().setScale(2, RoundingMode.HALF_EVEN))
				 .put("GstRt",tax.getRate())
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
				 .put("TotItemVal",line.getLineNetAmt().add(CGSTAmt).add(CGSTAmt).add(IGSTAmt).setScale(2, RoundingMode.HALF_EVEN))
				 .put("OrdLineRef",JSONObject.NULL)
				 .put("OrgCntry",JSONObject.NULL)
				 .put("PrdSlNo",JSONObject.NULL);
				 //jsonArrayBuilderItemList.add(jsi);
			}
			catch(Exception ex) {
				addLog("Incomplete Information in Product or Invoice Line #" + (i+1));
				addLog(ex.getMessage());
			}
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
		 (new JSONObject()).put("Typ", "INV")
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
			 addLog("Incomplate Information in the Organization or Business Partner level");
			 addLog(ex.getMessage());
		 }
		 OtherCharges = inv.getGrandTotal().subtract(inv.getTotalLines()).subtract(TotalCGST)
				 .subtract(TotalCGST).subtract(TotalIGST).setScale(2, RoundingMode.HALF_EVEN);
		 BigDecimal rndOff = BigDecimal.ZERO;
		 if(OtherCharges.doubleValue() < 0 ) {
			 rndOff = OtherCharges;
			 OtherCharges = BigDecimal.ZERO;
		 }
		 
		 jo.put("ItemList", jsi) //jsonArrayBuilderItemList)
		 .put("ValDtls",(new JSONObject()).put("AssVal",inv.getTotalLines())
		 .put("CgstVal",TotalCGST)
		 .put("SgstVal",TotalCGST)
		 .put("IgstVal",TotalIGST)
		 .put("CesVal",0)
		 .put("StCesVal",0)
		 .put("Discount",0)
		 .put("OthChrg",OtherCharges)
		 .put("RndOffAmt",rndOff)
		 .put("TotInvVal",inv.getGrandTotal())
		 .put("TotInvValFc",inv.getGrandTotal())
		 );
	
	

		 
		 System.out.println("JSON================>"+jo.toString());
		 return jo.toString();
	}


}
