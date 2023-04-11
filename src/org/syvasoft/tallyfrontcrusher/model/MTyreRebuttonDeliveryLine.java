package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;

public class MTyreRebuttonDeliveryLine extends X_TF_Tyre_RBDeliveryLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7207825818918452464L;

	public MTyreRebuttonDeliveryLine(Properties ctx,
			int TF_Tyre_RBDeliveryLine_ID, String trxName) {
		super(ctx, TF_Tyre_RBDeliveryLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyreRebuttonDeliveryLine(Properties ctx, ResultSet rs,
			String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		MTyreType tyreType = (MTyreType) getTF_TyreType();
		MTyreType toTyreType = new Query(getCtx(), MTyreType.Table_Name, "SeqNo > ? ", get_TrxName())
			.setClient_ID()
			.setParameters(tyreType.getSeqNo())
			.setOrderBy("SeqNo")
			.first();
		if(toTyreType != null) 
			setNew_TF_TyreType_ID(toTyreType.getTF_TyreType_ID());
		else
			throw new AdempiereException("This tyre cannot be sent for Rebutton!");
		
		return super.beforeSave(newRecord);
	}
	
	public void setRebuttonReceiptLine(int TF_Tyre_RBReceiptLine_ID) {
		if(TF_Tyre_RBReceiptLine_ID > 0 ) {
			if(getTF_Tyre_RBReceiptLine_ID() == 0)
				setTF_Tyre_RBReceiptLine_ID(TF_Tyre_RBReceiptLine_ID);
			else
				throw new AdempiereException(getTF_Tyre().getTyreNo() + " is already received!");
		}
		else {
			if(getTF_Tyre_RBReceiptLine_ID() > 0)
				setTF_Tyre_RBReceiptLine_ID(0);			
		}
	}

}
