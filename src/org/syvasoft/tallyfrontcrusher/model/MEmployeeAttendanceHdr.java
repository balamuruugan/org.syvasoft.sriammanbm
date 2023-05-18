package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;

public class MEmployeeAttendanceHdr extends X_TF_AttendnaceHdr {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8442217771327095114L;

	public MEmployeeAttendanceHdr(Properties ctx, int TF_AttendnaceHdr_ID, String trxName) {
		super(ctx, TF_AttendnaceHdr_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MEmployeeAttendanceHdr(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public void generateAttendance(boolean reCreate) {
		if(reCreate) {
			String delSql = "DELETE FROM TF_EmployeeAttendance WHERE  TF_AttendnaceHdr_ID = " + getTF_AttendnaceHdr_ID();
			DB.executeUpdate(delSql, get_TrxName());
		}
		
		String whereClause = "AD_Org_ID = ? AND IsEmployee='Y' "
				+ "AND C_BPartner.C_BPartner_ID NOT IN (SELECT TF_EmployeeAttendance.C_BPartner_ID FROM "
				+ " TF_EmployeeAttendance WHERE TF_AttendnaceHdr_ID = ? )";
		
		List<TF_MBPartner> list = new Query(getCtx(), TF_MBPartner.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setOnlyActiveRecords(true)
				.setParameters(getAD_Org_ID(), getTF_AttendnaceHdr_ID())
				.setOrderBy("Name")
				.list();
		
		for(TF_MBPartner bp : list) {
			MEmployeeAttendance att = new MEmployeeAttendance(getCtx(), 0, get_TrxName());
			att.setTF_AttendnaceHdr_ID(getTF_AttendnaceHdr_ID());
			att.setAD_Org_ID(getAD_Org_ID());
			att.setC_BPartner_ID(bp.getC_BPartner_ID());
			att.setDateAcct(getDateAcct());
			att.setStatus(MEmployeeAttendance.STATUS_Present);
			att.saveEx();
		}
	}
	
	public List<MEmployeeAttendance> getAttendances() {
		List<MEmployeeAttendance> list = new Query(getCtx(), MEmployeeAttendance.Table_Name, "TF_AttendnaceHdr_ID = ?", get_TrxName())
				.setClient_ID()
				.setParameters(getTF_AttendnaceHdr_ID())
				.list();
		return list;
	}
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);			
		}
	}
	
	public void reverseIt() { 
		setProcessed(false);
		setDocStatus(DOCSTATUS_Drafted);
	}
	
}
