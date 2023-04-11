package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;

public class MDaySequence extends X_TF_DaySeq {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2792396183059705816L;

	public MDaySequence(Properties ctx, int TF_DaySeq_ID, String trxName) {
		super(ctx, TF_DaySeq_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MDaySequence(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public String getNextSeqNo(String format) {
		format = "999" + format;
		String sql = "SELECT TRIM(TO_CHAR(?,?))";
		return DB.getSQLValueString(get_TrxName(), sql, getseq(), format);		
	}
	
	public static String getNextSequence(Properties ctx, int AD_Org_ID, 			
			Timestamp dateSeq, String type, String format, String trxName) {
		String whereClause = "AD_Org_ID = ? AND SeqType=? AND DateSeq=TRUNC(?::timestamp)";
		MDaySequence daySeq = new Query(ctx, Table_Name, whereClause, trxName)
				.setClient_ID()
				.setParameters(AD_Org_ID, type, dateSeq)
				.first();
		if(daySeq == null) {
			daySeq = new MDaySequence(ctx, 0, trxName);
			daySeq.setAD_Org_ID(AD_Org_ID);
			daySeq.setSeqType(type);
			daySeq.setDateSeq(dateSeq);
			daySeq.setseq(BigDecimal.ONE);			
		}
		else {
			daySeq.setseq(daySeq.getseq().add(BigDecimal.ONE));			
		}
		daySeq.saveEx();
		return daySeq.getNextSeqNo(format);
	}

}
