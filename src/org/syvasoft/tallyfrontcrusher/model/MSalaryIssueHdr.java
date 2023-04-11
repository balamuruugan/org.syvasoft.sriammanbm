package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.process.DocAction;

public class MSalaryIssueHdr extends X_TF_SalaryIssueHdr {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8637844455103593565L;

	public MSalaryIssueHdr(Properties ctx, int TF_SalaryIssueHdr_ID, String trxName) {
		super(ctx, TF_SalaryIssueHdr_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSalaryIssueHdr(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	
	public void createLines(int User1_ID) {
		
		for(TF_MBPartner bp : TF_MBPartner.getEmployeeList(getCtx(), getAD_Org_ID(), User1_ID, get_TrxName())) {
			if(exists(bp.getC_BPartner_ID()))
				continue;
			
			MEmployeeSalaryIssue s = new MEmployeeSalaryIssue(getCtx(), 0, get_TrxName());
			s.setTF_SalaryIssueHdr_ID(getTF_SalaryIssueHdr_ID());
			s.setDefaults(bp);
			s.saveEx();
		}
	}
	
	public boolean exists(int C_BPartner_ID) {
		String whereClause = "C_BPartner_ID = ? AND TF_SalaryIssueHdr_ID = ? ";
		MEmployeeSalaryIssue s =  new Query(getCtx(), MEmployeeSalaryIssue.Table_Name, whereClause, get_TrxName()) 
			.setParameters(C_BPartner_ID, getTF_SalaryIssueHdr_ID())
			.first();
		return s != null;
	}
	
	public List<MEmployeeSalaryIssue> getLines() {
		String whereClause = "TF_SalaryIssueHdr_ID = ?";
		List<MEmployeeSalaryIssue> sList = new Query(getCtx(), MEmployeeSalaryIssue.Table_Name, whereClause, get_TrxName())
				.setParameters(getTF_SalaryIssueHdr_ID())
				.list();
		return sList;
	}
	
	public void deleteLines() {
		for(MEmployeeSalaryIssue s : getLines()) {
			s.deleteEx(false);			
		}
	}
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			List<MEmployeeSalaryIssue> sList = getLines();
			
			for(MEmployeeSalaryIssue s : sList) {
				//if(!s.validateSalary()) 
				{
				//	throw new AdempiereException("Employee : " + s.getC_BPartner().getName() + " has ZERO Salary Amount !");
				}
			}
			
			
			for(MEmployeeSalaryIssue s : sList) {
				s.processIt(docAction);
				s.saveEx();
			}
			
		}
	}
	
	public void reverseIt() {
		setProcessed(true);
		setDocStatus(DOCSTATUS_InProgress);
		setProcessed(false);
		
		for(MEmployeeSalaryIssue s : getLines()) {
			s.reverseIt();
			s.saveEx();
		}
	}
}
