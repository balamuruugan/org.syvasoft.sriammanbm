package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MBPartner;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MLabourWage extends X_TF_Labour_Wage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4592649387238430143L;

	public MLabourWage(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		
	}

	public MLabourWage(Properties ctx, int TF_Labour_Wage_ID, String trxName) {
		super(ctx, TF_Labour_Wage_ID, trxName);
		
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(isCalculated()) {
			setEarned_Wage(getStd_Wage().multiply(getPresent_Days().divide(getStd_Days())));
			if(getIncentive() == null)
				setIncentive(BigDecimal.ZERO);			
		}
		setTotal_Wage(getEarned_Wage().add(getIncentive()));
		
		//If the Employee is created from Quick Entry
		if(!getC_BPartner().isEmployee()) {
			MBPartner bp = new MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
			bp.setIsEmployee(true);
			bp.setIsCustomer(false);
			bp.setIsVendor(false);
			bp.saveEx();
		}
		return super.beforeSave(newRecord);
	}
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			//Posting GL journal for Labour Wage 
			MJournal j = new MJournal(getCtx(), 0, get_TrxName());
			j.setDescription("Generated from Labour Wage - " + getDocumentNo());
			j.setC_AcctSchema_ID(Env.getContextAsInt(getCtx(), "$C_AcctSchema_ID"));
			j.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
			j.setPostingType(MJournal.POSTINGTYPE_Actual);
			j.setC_DocType_ID(1000000);
			j.setDateDoc(getDateAcct());
			j.setDateAcct(getDateAcct());
			j.setDocStatus(DOCSTATUS_Drafted);
			MPeriod period = MPeriod.get(getCtx(), getDateAcct());
			j.setC_Period_ID(period.getC_Period_ID());
			j.setGL_Category_ID(1000000);
			j.setC_ConversionType_ID(114);
			j.saveEx();
			
			boolean postIncentive = getIncentive().doubleValue() != 0;
			boolean postEarnedWage = getEarned_Wage().doubleValue() != 0;
						
			MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(getCtx());
			MJournalLine jl;
			//Earned Wage Dr
			if(postEarnedWage) {
				jl = new MJournalLine(j);
				jl.setLine(10);			
				jl.setAccount_ID(glConfig.getWageExpenseAcct_ID());
				jl.setC_BPartner_ID(getC_BPartner_ID());
				jl.setUser1_ID(getC_ElementValue_ID()); // Quarry Profit Center
				jl.setAmtSourceDr(getEarned_Wage());
				jl.setAmtAcctDr(getEarned_Wage());
				jl.setIsGenerated(true);
				jl.saveEx();
			}
			
			//Incentive Dr
			if(postIncentive) {
				jl = new MJournalLine(j);
				jl.setLine(20);			
				jl.setAccount_ID(glConfig.getWageIncentiveAcct_ID());
				jl.setC_BPartner_ID(getC_BPartner_ID());
				jl.setUser1_ID(getC_ElementValue_ID()); // Quarry Profit Center
				jl.setAmtSourceDr(getIncentive());
				jl.setAmtAcctDr(getIncentive());
				jl.setIsGenerated(true);
				jl.saveEx();
			}
			
			//Total Wage Cr
			jl = new MJournalLine(j);
			jl.setLine(30);			
			jl.setAccount_ID(glConfig.getWagePayableAcct_ID());
			jl.setC_BPartner_ID(getC_BPartner_ID());
			jl.setUser1_ID(getC_ElementValue_ID()); // Quarry Profit Center
			jl.setAmtSourceCr(getTotal_Wage());
			jl.setAmtAcctCr(getTotal_Wage());
			jl.setIsGenerated(true);
			jl.saveEx();
			
			j.processIt(MJournal.ACTION_Complete);
			j.saveEx();
			
			setGL_Journal_ID(j.getGL_Journal_ID());
		}
		
	}

	public void reverseIt() {
		if(getGL_Journal_ID()>0) {
			MJournal j = new MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
			j.reverseCorrectIt();
			j.saveEx();
			
			setGL_Journal_ID(0);
			setProcessed(false);
			setDocStatus(DOCSTATUS_Drafted);
		}
	}
	
	@Override
	protected boolean beforeDelete() {
		String sql = "UPDATE TF_TripSheet SET TF_Labour_Wage_ID = NULL WHERE TF_Labour_Wage_ID = " + getTF_Labour_Wage_ID();
		DB.executeUpdate(sql, get_TrxName());
		return super.beforeDelete();
	}
	

}
