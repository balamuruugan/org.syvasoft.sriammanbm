package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

public class MTyrePosition extends X_TF_TyrePosition {

	public MTyrePosition(Properties ctx, int TF_TyreStatus_ID, String trxName) {
		super(ctx, TF_TyreStatus_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyrePosition(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6273991242133491564L;
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			//	Get SeqNo
			if (getSeqNo() == 0)
			{
				String sql = "SELECT COALESCE(MAX(SeqNo),0)+10 FROM TF_TyrePosition";
				int ii = DB.getSQLValue (get_TrxName(), sql);
				setSeqNo(ii);
			}
		}
		return super.beforeSave(newRecord);
	}
}
