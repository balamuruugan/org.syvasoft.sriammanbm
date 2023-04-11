package org.syvasoft.tallyfrontcrusher.process;

import java.sql.Timestamp;
import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;

public class RepostMaterialMovement extends SvrProcess {

	private Timestamp dateAcct = null;
	private String weighType = null;
	private int AD_Org_ID = 0;
	@Override
	protected void prepare() {
		for(ProcessInfoParameter para : getParameter())
		{
			String name = para.getParameterName();
			if("DateAcct".equals(name))
				dateAcct = para.getParameterAsTimestamp();
			else if ("WeighmentEntryType".equals(name)) {
				weighType = para.getParameterAsString();			
			}
			else if("AD_Org_ID".equals(name)) {
				AD_Org_ID = para.getParameterAsInt();
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = "AD_Org_ID = ? AND WeighmentEntryType = ? AND TRUNC(GrossWeightTime) >= ? AND"
				+ " Status IN ('CO','CL') AND Processed='Y' AND NOT EXISTS(SELECT * FROM TF_RMSubcon_Movement  WHERE "
				+ " TF_RMSubcon_Movement.TF_WeighmentEntry_ID = TF_WeighmentEntry.TF_WeighmentEntry_ID) AND NOT EXISTS(SELECT * FROM TF_Boulder_Movement WHERE "  
				+ " TF_Boulder_Movement.TF_WeighmentEntry_ID = TF_WeighmentEntry.TF_WeighmentEntry_ID)" ;
		
		List<MWeighmentEntry> list = new Query(getCtx(), MWeighmentEntry.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(AD_Org_ID, weighType, dateAcct)
				.setOrderBy("GrossWeightTime")
				.list();
		
		for(MWeighmentEntry w : list) {
			w.rePostMaterialMovements();
			w.saveEx();
		}
		
		return null;
	}

}
