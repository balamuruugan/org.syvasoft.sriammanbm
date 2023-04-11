package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

public class MTyreType extends X_TF_TyreType {

	public MTyreType(Properties ctx, int TF_TyreType_ID, String trxName) {
		super(ctx, TF_TyreType_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyreType(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3863585981336831979L;

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			//	Get SeqNo
			if (getSeqNo() == 0)
			{
				String sql = "SELECT COALESCE(MAX(SeqNo),0)+10 FROM TF_TyreType";
				int ii = DB.getSQLValue (get_TrxName(), sql);
				setSeqNo(ii);
			}
		}
		return super.beforeSave(newRecord);
	}

}
