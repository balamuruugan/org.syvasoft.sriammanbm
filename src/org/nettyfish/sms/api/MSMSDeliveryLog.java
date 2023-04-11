package org.nettyfish.sms.api;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;

public class MSMSDeliveryLog extends X_TF_SmsDeliveryLog {

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8579167268181365951L;

	public MSMSDeliveryLog(Properties ctx, int TF_SmsDeliveryLog_ID, String trxName) {
		super(ctx, TF_SmsDeliveryLog_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSMSDeliveryLog(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public void setResult(String result) {
		set_Value("Result", result);
	}

}
