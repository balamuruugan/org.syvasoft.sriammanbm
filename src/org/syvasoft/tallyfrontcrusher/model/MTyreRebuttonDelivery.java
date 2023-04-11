package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.process.DocAction;


public class MTyreRebuttonDelivery extends X_TF_Tyre_RBDelivery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6503478766354203321L;

	public MTyreRebuttonDelivery(Properties ctx, int TF_Tyre_RBDelivery_ID,
			String trxName) {
		super(ctx, TF_Tyre_RBDelivery_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyreRebuttonDelivery(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			String whereClause = "TF_Tyre_RBDelivery_ID = ? AND TF_Tyre_ID IN (SELECT TF_Tyre_ID "
					+ " FROM TF_Tyre t WHERE t.TF_Tyre_ID = TF_Tyre_RBDeliveryLine.TF_Tyre_ID AND "
					+ " TF_TyreStatus_ID != 1000004) ";
			List<MTyreRebuttonDeliveryLine> errorLines = new Query(getCtx(), MTyreRebuttonDeliveryLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_Tyre_RBDelivery_ID())
				.list();
			if(errorLines.size()>0) {
				StringBuilder sb = new StringBuilder("Tyres Not in Stock > ");
				for(MTyreRebuttonDeliveryLine line : errorLines) {
					sb.append("Tyre No: " + line.getTF_Tyre().getTyreNo() +", ");
				}
				throw new AdempiereException(sb.toString());
			}
			
			whereClause = " TF_Tyre_RBDelivery_ID = ?";
			
			List<MTyreRebuttonDeliveryLine> lines = new Query(getCtx(), MTyreRebuttonDeliveryLine.Table_Name, whereClause, get_TrxName())
			.setClient_ID()
			.setParameters(getTF_Tyre_RBDelivery_ID())
			.list();
			for(MTyreRebuttonDeliveryLine line : lines) {
				line.setProcessed(true);
				line.saveEx();
				MTyre tyre = (MTyre) line.getTF_Tyre();
				tyre.setTF_TyreStatus_ID(MTyreStatus.SENT_TO_REBUTTON); // Sent To rebutton
				tyre.saveEx(get_TrxName());
			}
		}
	}
	
	public void reverseIt() {
		
		setProcessed(false);
		setDocStatus(DOCSTATUS_InProgress);
		
		String whereClause = " TF_Tyre_RBDelivery_ID = ?";
		
		List<MTyreRebuttonDeliveryLine> lines = new Query(getCtx(), MTyreRebuttonDeliveryLine.Table_Name, whereClause, get_TrxName())
		.setClient_ID()
		.setParameters(getTF_Tyre_RBDelivery_ID())
		.list();
		for(MTyreRebuttonDeliveryLine line : lines) {
			line.setProcessed(false);
			line.saveEx();
			MTyre tyre = (MTyre) line.getTF_Tyre();
			tyre.setTF_TyreStatus_ID(MTyreStatus.IN_STOCK); // In Stock
			tyre.saveEx(get_TrxName());
		}
		
	}
		

}
