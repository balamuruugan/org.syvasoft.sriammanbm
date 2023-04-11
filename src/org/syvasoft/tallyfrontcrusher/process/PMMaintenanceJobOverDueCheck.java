package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.compiere.util.Util;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MDestination;
import org.syvasoft.tallyfrontcrusher.model.MGenerateTaxInvoice;
import org.syvasoft.tallyfrontcrusher.model.MLumpSumRentConfig;
import org.syvasoft.tallyfrontcrusher.model.MPMJob;
import org.syvasoft.tallyfrontcrusher.model.MPMSchedule;
import org.syvasoft.tallyfrontcrusher.model.MPriceListUOM;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoice;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoiceLine;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MBankAccount;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrderLine;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;
import org.syvasoft.tallyfrontcrusher.model.MGenerateTaxInvoice;

public class PMMaintenanceJobOverDueCheck extends SvrProcess {
	
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		
		// Update Job Status from Pending to Due Status
		String sqlDue = "SELECT j.pm_job_id FROM " + 
				"	PM_Job J inner JOIN pm_schedule S ON J.pm_schedule_id = S.pm_schedule_id " + 
				"	INNER JOIN PM_Meter mtr ON s.PM_Machinery_ID = mtr.PM_Machinery_ID AND s.C_UOM_ID = mtr.C_UOM_ID " + 
				" WHERE " + 
				"	s.ScheduleType='U' AND s.IsActive='Y' AND j.IsActive='Y' AND j.docstatus='UP' " + 
				"	AND mtr.currentmeter - j.duemeter BETWEEN 0 AND S.overduemeter " +
				" UNION " + 
					" SELECT j.pm_job_id FROM " + 
					"	PM_Job J inner JOIN pm_schedule S ON J.pm_schedule_id = S.pm_schedule_id " + 
					" WHERE " + 
					"	s.ScheduleType='T' AND s.IsActive='Y' AND j.IsActive='Y' AND j.docstatus='UP' " + 
					"	AND date_part('day',trunc(now()) - trunc(j.datedue)) BETWEEN 0 AND s.overduedays";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pstmt = DB.prepareStatement(sqlDue, get_TrxName());
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			MPMJob job = new MPMJob(getCtx(), rs.getInt("pm_job_id"), get_TrxName());			
			job.setDocStatus(MPMJob.DOCSTATUS_Due);
			job.saveEx();
		}
		
		String sqlOverDue = "SELECT j.pm_job_id FROM " + 
				"	PM_Job J inner JOIN pm_schedule S ON J.pm_schedule_id = S.pm_schedule_id " + 
				"	INNER JOIN PM_Meter mtr ON s.PM_Machinery_ID = mtr.PM_Machinery_ID AND s.C_UOM_ID = mtr.C_UOM_ID " + 
				" WHERE " + 
				"	s.ScheduleType='U' AND s.IsActive='Y' AND j.IsActive='Y' AND j.docstatus in ('UP','DU') " + 
				"	AND mtr.currentmeter - j.duemeter > S.overduemeter " +
				" UNION " + 
					" SELECT j.pm_job_id FROM " + 
					"	PM_Job J inner JOIN pm_schedule S ON J.pm_schedule_id = S.pm_schedule_id " + 
					" WHERE " + 
					"	s.ScheduleType='T' AND s.IsActive='Y' AND j.IsActive='Y' AND j.docstatus in ('UP','DU') " + 
					"	AND date_part('day',trunc(now()) - trunc(j.datedue)) > s.overduedays";
		
		pstmt = DB.prepareStatement(sqlOverDue, get_TrxName());
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			MPMJob job = new MPMJob(getCtx(), rs.getInt("pm_job_id"), get_TrxName());			
			job.setDocStatus(MPMJob.DOCSTATUS_OverDue);
			job.saveEx();
		}
		return null;
	}


}
