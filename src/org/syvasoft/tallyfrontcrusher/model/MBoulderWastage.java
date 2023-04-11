package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MBoulderWastage extends X_TF_Boulder_Wastage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4027717865768847637L;

	public MBoulderWastage(Properties ctx, int TF_Boulder_Wastage_ID, String trxName) {
		super(ctx, TF_Boulder_Wastage_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MBoulderWastage(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}	
	
	public String processIt(String DocAction) {
		
		if(MBoulderReceipt.DOCACTION_Prepare.equals(DocAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(MBoulderReceipt.DOCACTION_Complete.equals(DocAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
		}
		
		return null;
	}
	
	public void reverseIt() {
		
		String whereClasue = " TF_Boulder_Wastage_ID = ?";
		
		List<MBoulderReceipt> brs = new Query(getCtx(), MBoulderReceipt.Table_Name, whereClasue, get_TrxName())
										.setClient_ID().setParameters(getTF_Boulder_Wastage_ID()).list();
		
		for (MBoulderReceipt mBoulderReceipt : brs) {
			mBoulderReceipt.reverseIt();
			mBoulderReceipt.setDocStatus(MBoulderReceipt.DOCSTATUS_Voided);
			mBoulderReceipt.setProcessed(true);
			mBoulderReceipt.saveEx();
		}
		
		setProcessed(false);
		setDocStatus(DOCSTATUS_Drafted);
	}
	
	public static BigDecimal getReceiptQtyForCrusher(int AD_Org_ID, Timestamp DateAcct, String trxName) {
		// Consolidated invoice line will be created only for the new Products which are not in Invoice Lines already.
		String sql = "SELECT SUM(netweightunit) FROM tf_weighmententry WHERE "
				+ "((weighmententrytype ='4SR' AND tf_send_to='P') OR weighmententrytype='5KA') AND TRUNC(dateacct) = ? "
				+ "AND status IN ('CL') AND ad_org_id = ?";

		PreparedStatement pstmt =  null;
		BigDecimal expVar = BigDecimal.ZERO;
		
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();;			
		params.add(DateAcct);
		params.add(AD_Org_ID);
		expVar = DB.getSQLValueBD(trxName, sql, params);
		expVar = (expVar == null) ? BigDecimal.ZERO : expVar;
		return expVar;
	}
	
	public static BigDecimal getReceiptQtyForQuarry(int AD_Org_ID, Timestamp DateAcct, String trxName) {
		// Consolidated invoice line will be created only for the new Products which are not in Invoice Lines already.
		String sql = "SELECT SUM(netweightunit) FROM tf_weighmententry WHERE "
				+ "weighmententrytype ='4SR' AND TRUNC(dateacct) = ? AND status IN ('CL') AND ad_org_id = ?";

		PreparedStatement pstmt =  null;
		BigDecimal expVar = BigDecimal.ZERO;
		
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();;			
		params.add(DateAcct);
		params.add(AD_Org_ID);
		expVar = DB.getSQLValueBD(trxName, sql, params);
		expVar = (expVar == null) ? BigDecimal.ZERO : expVar;
		return expVar;
	}
	
	public static BigDecimal getReceiptQtyForMaintenance(int AD_Org_ID, Timestamp DateAcct, String trxName) {
		// Consolidated invoice line will be created only for the new Products which are not in Invoice Lines already.
		String sql = "SELECT SUM(netweightunit) FROM tf_weighmententry WHERE "
				+ "((weighmententrytype ='4SR' AND tf_send_to='P') OR weighmententrytype='5KA') AND TRUNC(dateacct) = ? "
				+ "AND status IN ('CL') AND ad_org_id = ?";

		PreparedStatement pstmt =  null;
		BigDecimal expVar = BigDecimal.ZERO;
		
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();;			
		params.add(DateAcct);
		params.add(AD_Org_ID);
		expVar = DB.getSQLValueBD(trxName, sql, params);
		expVar = (expVar == null) ? BigDecimal.ZERO : expVar;
		return expVar;
	}
}
