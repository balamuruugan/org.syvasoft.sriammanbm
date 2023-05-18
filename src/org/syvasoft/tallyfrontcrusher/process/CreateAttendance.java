package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MEmployeeAttendanceHdr;


public class CreateAttendance extends SvrProcess{

	public boolean reCreate = false;
	
	@Override
	protected void prepare() {
		for(ProcessInfoParameter p : getParameter()) {
			String name = p.getParameterName();
			if(name.equals("reCreate")) {
				reCreate = p.getParameterAsBoolean();
			}
		}
	}
	
	@Override
	protected String doIt() throws Exception {

		MEmployeeAttendanceHdr hdr = new MEmployeeAttendanceHdr(getCtx(), getRecord_ID(), get_TrxName());
		hdr.generateAttendance(reCreate);
		hdr.saveEx();
		
		return null;
	}
	

}
