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

public class PMCreateMaintenanceJob extends SvrProcess {
	
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		
		String sqlDue = "SELECT  s.PM_Schedule_ID,s.scheduletype, mtr.CurrentMeter," + 
				"	CASE WHEN s.NextMeter = mtr.CurrentMeter THEN 'DU' WHEN s.nextmeter > mtr.currentmeter THEN 'UP' " + 
				"	WHEN mtr.currentmeter - s.nextmeter <= s.overduemeter THEN 'DU' ELSE  'OD' END Status FROM " + 
				"	PM_Schedule s INNER JOIN PM_Machinery m ON s.PM_Machinery_ID = m.PM_Machinery_ID " + 
				"	INNER JOIN PM_Meter mtr ON s.PM_Machinery_ID = mtr.PM_Machinery_ID AND s.C_UOM_ID = mtr.C_UOM_ID " + 
				"WHERE	 " + 
				"	s.ScheduleType='U' AND (s.NextMeter - s.advanceremindermeter) <= mtr.CurrentMeter AND " + 
				"	(SELECT COUNT(*) FROM PM_Job j WHERE j.PM_Schedule_ID = s.PM_Schedule_ID " + 
				"	AND j.PM_Machinery_ID = s.PM_Machinery_ID AND j.C_UOM_ID = s.C_UOM_ID AND Processed='N') = 0 AND " + 
				"	s.IsActive='Y' AND m.IsActive='Y' " +
				"UNION	" +
				"SELECT s.PM_Schedule_ID,s.scheduletype, NULL," + 
				"	CASE WHEN trunc(s.DateNextRun) = trunc(now()) THEN 'DU' WHEN trunc(s.DateNextRun) > trunc(now()) THEN 'UP' " + 
				"	WHEN date_part('day',trunc(now()) - trunc(s.DateNextRun)) <= s.overduedays THEN 'DU' ELSE  'OD' END Status FROM " + 
				"	PM_Schedule s INNER JOIN PM_Machinery m ON s.PM_Machinery_ID = m.PM_Machinery_ID " + 
				"WHERE " + 
				"	s.ScheduleType='T' AND s.IsActive='Y' AND m.IsActive='Y' " + 
				"	AND (s.DateNextRun - s.advreminderdays) <= TRUNC(NOW()) AND " + 
				"	(SELECT COUNT(*) FROM PM_Job j WHERE j.PM_Schedule_ID = s.PM_Schedule_ID " + 
				"	AND j.PM_Machinery_ID = s.PM_Machinery_ID AND j.C_UOM_ID IS NULL AND Processed='N')= 0 ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pstmt = DB.prepareStatement(sqlDue, get_TrxName());
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			MPMSchedule schedule = new MPMSchedule(getCtx(), rs.getInt("PM_Schedule_ID"), get_TrxName());
			
			MPMJob job = new MPMJob(getCtx(), 0, get_TrxName());
			
			job.setAD_Org_ID(schedule.getAD_Org_ID());
			job.setName(schedule.getName());
			job.setPM_Machinery_ID(schedule.getPM_Machinery_ID());
			job.setPM_Schedule_ID(schedule.get_ID());
			
			if(schedule.getScheduleType().equals(MPMSchedule.SCHEDULETYPE_Usage)) {				
				job.setC_UOM_ID(schedule.getC_UOM_ID());
				
				job.setDueMeter(schedule.getNextMeter());
				job.setLastMeter(schedule.getLastMeter());
			}
			else if(schedule.getScheduleType().equals(MPMSchedule.SCHEDULETYPE_Time)) {
				job.setDateDue(schedule.getDateNextRun());
				job.setDateLastDue(schedule.getDateLastRun());
			}
			
			if(rs.getString("Status").equals("UP")) {
				job.setDocStatus(MPMJob.DOCSTATUS_Upcoming);
			}
			else if(rs.getString("Status").equals("DU")) {
				job.setDocStatus(MPMJob.DOCSTATUS_Due);
			}
			else if(rs.getString("Status").equals("OD")) {
				job.setDocStatus(MPMJob.DOCSTATUS_OverDue);
			}
			job.saveEx();
		}
		
		return null;
	}


}
