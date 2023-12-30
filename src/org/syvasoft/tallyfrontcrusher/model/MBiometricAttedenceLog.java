package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.util.DB;

public class MBiometricAttedenceLog extends X_TF_BiometricAttendence {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3389888168309404354L;
	public MBiometricAttedenceLog(Properties ctx, int TF_BiometricAttendence_ID, String trxName) {
		super(ctx, TF_BiometricAttendence_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public MBiometricAttedenceLog(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public void setShift() {
		String whereClause = "AD_Org_ID = ? AND C_BPartner_ID = ? AND DateFrom <= ? AND IsActive = 'Y'";
		MEmpShiftAssign curShift = new Query(getCtx(), MEmpShiftAssign.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getAD_Org_ID(), getC_BPartner_ID(), getAttendenceTime())
				.setOrderBy("DateFrom DESC")
				.first();
		
				
		//if(curShift == null) {
		//	setTF_EmpShift_ID(MEmployeeShift.getDefault_ID(getCtx(), getAD_Org_ID()));		
		//}
		
		if(curShift != null) {
			setTF_EmpShift_ID(curShift.getTF_EmpShift_ID());
		}
		else {
			throw new AdempiereException("Please assign Shift for " + getC_BPartner().getName());
		}		
		
		MEmployeeShift es = new MEmployeeShift(getCtx(), getTF_EmpShift_ID(), get_TrxName());
		setDateAcct(es.getDateAcct(getAttendenceTime(), getInOutMode()));
		setProcessed(false);
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			setShift();
		}
		return super.beforeSave(newRecord);
	}
	
}
