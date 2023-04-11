package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MTyreLife extends X_TF_TyreLife {

	public MTyreLife(Properties ctx, int TF_TyreLife_ID, String trxName) {
		super(ctx, TF_TyreLife_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTyreLife(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1918825772813492028L;

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			//	Get SeqNo
			if (getSeqNo() == 0)
			{
				String sql = "SELECT COALESCE(MAX(SeqNo),0)+10 FROM TF_TyreLife";
				int ii = DB.getSQLValue (get_TrxName(), sql);
				setSeqNo(ii);
			}
		}
		calcActualRunningMeter();
		return super.beforeSave(newRecord);
	}
	
	
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		MTyre tyre = (MTyre) getTF_Tyre();
		tyre.calcRunningMeter();
		tyre.saveEx();
		return super.afterSave(newRecord, success);
	}

	public void calcActualRunningMeter() {
		String sql = "SELECT SUM(Running_Meter) FROM TF_TyreMovement WHERE TF_Tyre_ID=? AND TF_TyreType_ID=? "
				+ " AND 'Y' = (SELECT TrackRunningMeter FROM TF_TyrePosition p WHERE "
				+ " p.TF_TyrePosition_ID = TF_TyreMovement.TF_TyrePosition_ID)";
		BigDecimal totRunningMeter = DB.getSQLValueBD(get_TrxName(), sql, getTF_Tyre_ID(), getTF_TyreType_ID());
		if(totRunningMeter==null) {
			totRunningMeter = BigDecimal.ZERO;
		}
		setActRunning_Meter(totRunningMeter.add(getOpening_Meter()));
	}
	
	public static MTyreLife getTyreLife(int TF_Tyre_ID, int TF_TyreType_ID, String trxName) {
		MTyreLife tlife = new Query(Env.getCtx(), Table_Name, "TF_Tyre_ID=? AND TF_TyreType_ID=?", trxName)
			.setParameters(TF_Tyre_ID, TF_TyreType_ID).first();
		return tlife;
	}
}
