package org.syvasoft.tallyfrontcrusher.process;

import java.sql.Timestamp;
import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MTyre;
import org.syvasoft.tallyfrontcrusher.model.MTyreAssignment;
import org.syvasoft.tallyfrontcrusher.model.MTyreRebuttonDelivery;
import org.syvasoft.tallyfrontcrusher.model.MTyreRebuttonDeliveryLine;
import org.syvasoft.tallyfrontcrusher.model.MTyreStatusChange;

public class ProcessTyreInfoRebuttonRelease extends SvrProcess {

	private Timestamp AcctDate;
	private int C_BPartner_ID,AD_Org_ID;
	MTyreRebuttonDelivery mReDelivery;
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		mReDelivery=new MTyreRebuttonDelivery(getCtx(), getRecord_ID(), get_TrxName());
		ProcessInfoParameter[] para = getParameter();
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();

			if(name.equals("AD_Org_ID"))
				AD_Org_ID=para[i].getParameterAsInt();
			if(name.equals("DateAcct"))
				AcctDate=para[i].getParameterAsTimestamp();
			if(name.equals("C_BPartner_ID"))
				C_BPartner_ID=para[i].getParameterAsInt();
		}

	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		String whereClause = " EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
				 " T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = TF_Tyre.TF_Tyre_ID)"; 
		
		List<MTyre> tyres = new Query(getCtx(), MTyre.Table_Name, whereClause, get_TrxName())
				.setClient_ID().setParameters(getAD_PInstance_ID()).list();
		if(tyres.size()>0) {
			MTyreRebuttonDelivery rDelivery=new MTyreRebuttonDelivery(getCtx(), 0, get_TrxName());
			rDelivery.setAD_Org_ID(AD_Org_ID);
			rDelivery.setDateAcct(AcctDate);
			rDelivery.setC_BPartner_ID(C_BPartner_ID);
			rDelivery.setDocStatus(MTyreRebuttonDelivery.DOCSTATUS_Drafted);
			rDelivery.saveEx();
			
			MTyreRebuttonDeliveryLine rDeliveryLine;
			int i=10;
			for (MTyre mTyre : tyres) {
				rDeliveryLine=new MTyreRebuttonDeliveryLine(getCtx(), 0, get_TrxName());
				rDeliveryLine.setLineNo(i);
				rDeliveryLine.setTF_Tyre_RBDelivery_ID(rDelivery.get_ID());
				rDeliveryLine.setTF_Tyre_ID(mTyre.getTF_Tyre_ID());
				rDeliveryLine.setTF_TyreType_ID(mTyre.getCurrent_TyreType_ID());
				rDeliveryLine.setSize(mTyre.getSize());
				rDeliveryLine.setBrand(mTyre.getBrand());
				rDeliveryLine.saveEx();
				i=i+10;
			}
			
			rDelivery.processIt(MTyreAssignment.DOCACTION_Complete);
			rDelivery.saveEx();
		}

		return null;
	}

}
