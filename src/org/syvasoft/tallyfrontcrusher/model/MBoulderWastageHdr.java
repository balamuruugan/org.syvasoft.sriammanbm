package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MMessage;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MBoulderWastageHdr extends X_TF_Boulder_Wastage_HDR {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4027717865768847637L;

	public MBoulderWastageHdr(Properties ctx, int TF_Boulder_Wastage_ID, String trxName) {
		super(ctx, TF_Boulder_Wastage_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MBoulderWastageHdr(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		if(newRecord) {
			createLines();	
		}
		
		if(is_ValueChanged(COLUMNNAME_Scalping_Percent)) {
			for(MBoulderWastageDtl dtl : getLines()) {
				dtl.calculateScalpingQty();
				dtl.saveEx();
			}
		}
		return super.afterSave(newRecord, success);
	}
	
	public void createLines() {
		String whereClause = "AD_Org_ID = ? AND DocStatus = 'IP'";
		
		List<TF_MProject> projects = new Query(getCtx(), TF_MProject.Table_Name, whereClause, get_TrxName())
								.setParameters(getAD_Org_ID())
								.setClient_ID()
								.list();
		
		for(TF_MProject project : projects) {			
			if(project.getC_BPartner_ID() > 0) {				
				MBoulderWastageDtl dtl = new MBoulderWastageDtl(getCtx(), 0, get_TrxName());
				dtl.createLines(project, project.getC_BPartner_ID(), project.getJobWork_Product_ID(), this);
				dtl.saveEx();
			}
			if(project.getC_BPartnerSubcon2_ID() > 0) {
				MBoulderWastageDtl dtl = new MBoulderWastageDtl(getCtx(), 0, get_TrxName());
				dtl.createLines(project, project.getC_BPartnerSubcon2_ID(), project.getM_ProductSubcon2_ID(), this);
				dtl.saveEx();
			}
		}
	}
	public String processIt(String DocAction) {
		
		if(MBoulderReceipt.DOCACTION_Prepare.equals(DocAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(MBoulderReceipt.DOCACTION_Complete.equals(DocAction)) {
			for(MBoulderWastageDtl dtl : getLines()) {
				dtl.createSubcontractServiceReceipt(this);
				dtl.saveEx();
			}
			
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
		}
		
		return null;
	}
	
	public void reverseIt() {
		
		String sql =  " SELECT COUNT(*) FROM m_inout JOIN m_inoutline ON m_inout.m_inout_id = m_inoutline.m_inout_id WHERE " + 
						" m_inout.m_inout_id IN (SELECT tf_boulder_wastage_dtl.m_inout_id FROM tf_boulder_wastage_dtl WHERE " + 
						" tf_boulder_wastage_dtl.tf_boulder_wastage_hdr_id = ?) AND m_inoutline.docstatus = 'CL'";
		
		PreparedStatement pstmt =  null;
		BigDecimal count = BigDecimal.ZERO;
		
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();;			
		params.add(getTF_Boulder_Wastage_HDR_ID());
		
		count = DB.getSQLValueBD(get_TrxName(), sql, params);
		
		if(count.doubleValue() > 0) {
			MMessage message = MMessage.get(getCtx(), "Boulder_Wastage_Modify");
			throw new AdempiereException(message.getMsgText());
		}
		
		String whereClasue = " TF_Boulder_Wastage_ID = ?";
		
		List<MBoulderReceipt> brs = new Query(getCtx(), MBoulderReceipt.Table_Name, whereClasue, get_TrxName())
										.setClient_ID().setParameters(getTF_Boulder_Wastage_HDR_ID()).list();
		
		for(MBoulderWastageDtl dtl : getLines()) {
			dtl.reverseSubcontractServiceReceipt();
			dtl.saveEx();
		}
		
		setProcessed(false);
		setDocStatus(DOCSTATUS_Drafted);
	}
	
	
	public static BigDecimal getReceiptQtyForCrusher(int AD_Org_ID, int C_BPartner_ID, int M_Product_ID, int M_Warehouse_ID, Timestamp DateAcct, String trxName) {
		// Consolidated invoice line will be created only for the new Products which are not in Invoice Lines already.
		String sql = "SELECT SUM(netweightunit) FROM tf_weighmententry WHERE "
				+ "((weighmententrytype ='4SR' AND tf_send_to='P') OR weighmententrytype='5KA') AND TRUNC(dateacct) = ? "
				+ "AND status IN ('CL') AND ad_org_id = ? AND m_product_id = ? AND m_warehouse_id = ?";

		PreparedStatement pstmt =  null;
		BigDecimal expVar = BigDecimal.ZERO;
		
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();;			
		params.add(DateAcct);
		params.add(AD_Org_ID);
		params.add(M_Product_ID);
		params.add(M_Warehouse_ID);
		
		if(C_BPartner_ID > 0) {
			params.add(C_BPartner_ID);
			sql = sql + " AND C_BPartner_ID = ?";
		}
		
		expVar = DB.getSQLValueBD(trxName, sql, params);
		expVar = (expVar == null) ? BigDecimal.ZERO : expVar;
		return expVar;
	}
	
	public static BigDecimal getReceiptQtyForQuarry(int AD_Org_ID, int C_BPartner_ID, int M_Product_ID, int M_Warehouse_ID, Timestamp DateAcct, String trxName) {
		// Consolidated invoice line will be created only for the new Products which are not in Invoice Lines already.
		String sql = "SELECT SUM(netweightunit) FROM tf_weighmententry WHERE "
				+ "weighmententrytype ='4SR' AND TRUNC(dateacct) = ? AND status IN ('CL') "
				+ " AND ad_org_id = ? AND m_product_id = ? AND m_warehouse_id = ?";

		PreparedStatement pstmt =  null;
		BigDecimal expVar = BigDecimal.ZERO;
		
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();;			
		params.add(DateAcct);
		params.add(AD_Org_ID);
		params.add(M_Product_ID);
		params.add(M_Warehouse_ID);
		
		if(C_BPartner_ID > 0) {
			params.add(C_BPartner_ID);
			sql = sql + " AND C_BPartner_ID = ?";
		}
		
		expVar = DB.getSQLValueBD(trxName, sql, params);
		expVar = (expVar == null) ? BigDecimal.ZERO : expVar;
		return expVar;
	}
		
	public static int getTripsForCrusher(int AD_Org_ID, int C_BPartner_ID, int M_Product_ID, int M_Warehouse_ID, Timestamp DateAcct, String trxName) {
		// Consolidated invoice line will be created only for the new Products which are not in Invoice Lines already.
		String sql = "SELECT COUNT(netweightunit) FROM tf_weighmententry WHERE "
				+ "((weighmententrytype ='4SR' AND tf_send_to='P') OR weighmententrytype='5KA') AND TRUNC(dateacct) = ? "
				+ "AND status IN ('CL')  AND ad_org_id = ? AND m_product_id = ? AND m_warehouse_id = ?";

		PreparedStatement pstmt =  null;
		BigDecimal expVar = BigDecimal.ZERO;
		
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();;			
		params.add(DateAcct);
		params.add(AD_Org_ID);
		params.add(M_Product_ID);
		params.add(M_Warehouse_ID);
		
		if(C_BPartner_ID > 0) {
			params.add(C_BPartner_ID);
			sql = sql + " AND C_BPartner_ID = ?";
		}
		
		expVar = DB.getSQLValueBD(trxName, sql, params);
		expVar = (expVar == null) ? BigDecimal.ZERO : expVar;
		return expVar.intValue();
	}
	
	public static int getTripsForQuarry(int AD_Org_ID, int C_BPartner_ID, int M_Product_ID, int M_Warehouse_ID,  Timestamp DateAcct, String trxName) {
		// Consolidated invoice line will be created only for the new Products which are not in Invoice Lines already.
		String sql = "SELECT COUNT(netweightunit) FROM tf_weighmententry WHERE "
				+ "weighmententrytype ='4SR' AND TRUNC(dateacct) = ? AND status IN ('CL') "
				+ " AND ad_org_id = ? AND m_product_id = ? AND m_warehouse_id = ?";

		PreparedStatement pstmt =  null;
		BigDecimal expVar = BigDecimal.ZERO;
		
		ArrayList<Object> params = new ArrayList<Object>();
		params = new ArrayList<Object>();;			
		params.add(DateAcct);
		params.add(AD_Org_ID);
		params.add(M_Product_ID);
		params.add(M_Warehouse_ID);
		
		if(C_BPartner_ID > 0) {
			params.add(C_BPartner_ID);
			sql = sql + " AND C_BPartner_ID = ?";
		}
		
		expVar = DB.getSQLValueBD(trxName, sql, params);
		expVar = (expVar == null) ? BigDecimal.ZERO : expVar;
		return expVar.intValue();
	}	
	
	public List<MBoulderWastageDtl> getLines() {
		String whereClause = "TF_Boulder_Wastage_HDR_ID = ?";
		List<MBoulderWastageDtl> reqlines = new Query(getCtx(), MBoulderWastageDtl.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_Boulder_Wastage_HDR_ID())
				.list();
		return reqlines;
	}
}
