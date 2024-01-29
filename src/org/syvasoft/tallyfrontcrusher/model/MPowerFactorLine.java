package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.util.DB;

public class MPowerFactorLine extends X_TF_PowerFactorLine{

	private static final long serialVersionUID = 1L;
	
	private MPowerFactor _parent = null;

	public MPowerFactorLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MPowerFactorLine(Properties ctx, int TF_PowerFactorLine_ID, String trxName, String[] virtualColumns) {
		super(ctx, TF_PowerFactorLine_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MPowerFactorLine(Properties ctx, int TF_PowerFactorLine_ID, String trxName) {
		super(ctx, TF_PowerFactorLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public static BigDecimal getOpeningKWH(Timestamp dateReport, int AD_Org_ID) {
		String sql = " SELECT closingkwh FROM TF_PowerFactorLine  WHERE DateAcct <= ? AND AD_Org_ID = ? " +
				"  ORDER BY DateAcct DESC,closingkwh DESC";		
		BigDecimal openingKWH = DB.getSQLValueBD(null, sql, dateReport, AD_Org_ID);
		if(openingKWH== null)
			openingKWH = BigDecimal.ZERO;
		return openingKWH;
	}
	
	public static BigDecimal getOpeningKVAH(Timestamp dateReport) {
		String sql = " SELECT closingkvah FROM TF_PowerFactorLine  WHERE DateAcct <= ?  " +
				"  ORDER BY DateAcct DESC, closingkvah DESC";		
		BigDecimal openingKWH = DB.getSQLValueBD(null, sql, dateReport);
		if(openingKWH== null)
			openingKWH = BigDecimal.ZERO;
		return openingKWH;
	}
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		updateParent();
		return super.afterSave(newRecord, success);
	}
	
	@Override
	protected boolean afterDelete(boolean success) {
		updateParent();
		return super.afterDelete(success);
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord || is_ValueChanged(COLUMNNAME_DateAcct)) {
			getParent().validateDate(getDateAcct());
		}
		return super.beforeSave(newRecord);
	}
	
	private void updateParent() {		
		getParent().updatePowerFactor();
		getParent().saveEx();
	}
	
	private MPowerFactor getParent() {
		if(_parent == null)
			_parent = new MPowerFactor(getCtx(), getTF_PowerFactor_ID(), get_TrxName());
		
		return _parent;
	}
}
