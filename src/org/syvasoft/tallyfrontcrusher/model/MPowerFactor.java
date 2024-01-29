package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;

public class MPowerFactor extends X_TF_PowerFactor {

	private static final long serialVersionUID = 1L;

	public MPowerFactor(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MPowerFactor(Properties ctx, int TF_PowerFactor_ID, String trxName, String[] virtualColumns) {
		super(ctx, TF_PowerFactor_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MPowerFactor(Properties ctx, int TF_PowerFactor_ID, String trxName) {
		super(ctx, TF_PowerFactor_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord || is_ValueChanged(COLUMNNAME_C_Period_ID)) {
			MPeriod p = new MPeriod(getCtx(), getC_Period_ID(), get_TrxName());
			setDateFrom(p.getStartDate());
			setDateTo(p.getEndDate());
		}
		return super.beforeSave(newRecord);
	}
	
	public void updatePowerFactor() {		
		setDocStatus(DOCSTATUS_InProgress);
		setopeningkwh(first().getopeningkwh());
		setopeningkvah(first().getopeningkvah());
		setclosingkwh(last().getclosingkwh());
		setclosingkvah(last().getclosingkvah());
		
		setkwhusage(getclosingkwh().subtract(getopeningkwh()));
		setkvahusage(getclosingkvah().subtract(getopeningkvah()));
		if(getUnitFactor().doubleValue() > 0)
			setunit(getclosingkwh().subtract(getopeningkwh()).multiply(getUnitFactor()));
		else
			setunit(BigDecimal.ZERO);
		
		BigDecimal pf = BigDecimal.ZERO;
		if(getkvahusage().doubleValue() > 0)
			pf = getkwhusage().divide(getkvahusage(), 2, RoundingMode.HALF_EVEN);
		setpowerfactor(pf);
	}
	
	public MPowerFactorLine first() {
		String whereClause = "TF_PowerFactor_ID = ?";
		MPowerFactorLine first = new Query(getCtx(), MPowerFactorLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_PowerFactor_ID())
				.setOrderBy("DateAcct, TF_PowerFactorLine_ID")
				.first();
		return first;
	}
	
	public MPowerFactorLine last() {
		String whereClause = "TF_PowerFactor_ID = ?";
		MPowerFactorLine last = new Query(getCtx(), MPowerFactorLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_PowerFactor_ID())
				.setOrderBy("DateAcct DESC, TF_PowerFactorLine_ID DESC")
				.first();
		return last;
	}
	
	public void processIt() {
		setDocStatus(DOCSTATUS_Completed);
		setProcessed(true);
	}
	
	public void reverseIt() {
		setProcessed(false);
		setDocStatus(DOCSTATUS_InProgress);
	}
	
	public void validateDate(Timestamp date) {
		MPeriod p = MPeriod.get(getCtx(), date, getAD_Org_ID(), get_TrxName());
		if(p.get_ID() != getC_Period_ID())
			throw new AdempiereException("Please enter correct Date of " + getC_Period().getName());
	}

}
