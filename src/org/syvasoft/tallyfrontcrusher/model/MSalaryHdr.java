package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.process.DocAction;

public class MSalaryHdr extends X_TF_SalaryHdr {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7358503767052935898L;

	public MSalaryHdr(Properties ctx, int TF_SalaryHdr_ID, String trxName) {
		super(ctx, TF_SalaryHdr_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSalaryHdr(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	
	public void createLines(int User1_ID) {
				
		for(TF_MBPartner bp : TF_MBPartner.getEmployeeList(getCtx(), getAD_Org_ID(), User1_ID, get_TrxName())) {
			if(exists(bp.getC_BPartner_ID()))
				continue;
			
			MEmployeeSalaryOld s = new MEmployeeSalaryOld(getCtx(), 0, get_TrxName());
			s.setTF_SalaryHdr_ID(getTF_SalaryHdr_ID());
			s.suppressValidation = true;
			s.setDefaults(bp);
			s.saveEx();
		}
	}

	public boolean exists(int C_BPartner_ID) {
		String whereClause = "C_BPartner_ID = ? AND TF_SalaryHdr_ID = ? ";
		MEmployeeSalaryOld s = new Query(getCtx(), MEmployeeSalaryOld.Table_Name, whereClause, get_TrxName()) 
				.setParameters(C_BPartner_ID, getTF_SalaryHdr_ID())
				.first();
		return s != null ;
	}
	
	public List<MEmployeeSalaryOld> getLines() {
		String whereClause = "TF_SalaryHdr_ID = ?";
		List<MEmployeeSalaryOld> sList = new Query(getCtx(), MEmployeeSalaryOld.Table_Name, whereClause, get_TrxName())
				.setParameters(getTF_SalaryHdr_ID())
				.list();
		return sList;
	}
	
	public void deleteLines() {
		for(MEmployeeSalaryOld s : getLines()) {
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
			
			List<MEmployeeSalaryOld> sList = getLines();
			
			for(MEmployeeSalaryOld s : sList) {
				if(!s.validateSalary()) {
					throw new AdempiereException("Employee : " + s.getC_BPartner().getName() + " has ZERO Salary Amount !");
				}
			}
			
			
			for(MEmployeeSalaryOld s : sList) {
				s.processIt(docAction);
				s.saveEx();
			}
			
		}
	}
	
	public void reverseIt() {
		setProcessed(false);
		setDocStatus(DOCSTATUS_InProgress);
		
		for(MEmployeeSalaryOld s : getLines()) {
			s.reverseIt();
			s.saveEx();
		}
	}
}
