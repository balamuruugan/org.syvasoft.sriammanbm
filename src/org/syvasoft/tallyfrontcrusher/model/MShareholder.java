package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MShareholder extends X_TF_Shareholder {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7253800620024766732L;

	public MShareholder(Properties ctx, int TF_Shareholder_ID, String trxName) {
		super(ctx, TF_Shareholder_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MShareholder(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getProfitShare(boolean isIncludedSubShareholders) {
		if(isIncludedSubShareholders) {
			String sql = "SELECT  SUM(ProfitShare) FROM TF_Shareholder WHERE AD_org_ID = ? AND  ? IN (TF_Shareholder_ID, TF_ShareholderMain_ID)";
			BigDecimal profitShare = DB.getSQLValueBD(get_TrxName(), sql, getAD_Org_ID(), getTF_Shareholder_ID());
			if(profitShare != null)
				return profitShare;
			else
				return BigDecimal.ZERO;
		}
		else {
			return getProfitShare();
		}
			
	}
	
	public List<MShareholder> getSubShareholders() {
		String whereClause = "AD_Org_ID = ? AND TF_ShareholderMain_ID = ?";
		List<MShareholder> subPartners = new Query(getCtx(), Table_Name, whereClause, get_TrxName())
				.setClient_ID().setParameters(getAD_Org_ID(), getTF_Shareholder_ID()).list();
		return subPartners;
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(getCapitalAcct_ID() == 0) {
			setCapitalAcct_ID(createAccount(getName(), getName()));
		}
		return super.beforeSave(newRecord);
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		if(newRecord || is_ValueChanged(COLUMNNAME_InvestmentShare))
			updateInvestmentReceivable(getAD_Org_ID(), get_TrxName());
		return super.afterSave(newRecord, success);
	}

	private int createAccount(String value, String name) {
		int elementID = Env.getContextAsInt(getCtx(), "#C_Element_ID");
		String where = "C_Element_ID = ? AND UPPER(TRIM(Name))=UPPER(TRIM(?))";
		List<TF_MElementValue> accts = new Query(getCtx(), TF_MElementValue.Table_Name, where, get_TrxName())
				.setClient_ID().setParameters(elementID, name).list();
		if(accts.size() > 0 ) {
			return accts.get(0).getC_ElementValue_ID();
		}
		else {
			 TF_MElementValue acct = new TF_MElementValue(getCtx(), 0, get_TrxName());		 
			 acct.setC_Element_ID(elementID);
			 acct.setValue(name);
			 acct.setName(name);
			 acct.setAccountGroup_ID(getAccountGroup_ID());
			 acct.setAccountType(TF_MElementValue.ACCOUNTTYPE_OwnerSEquity);
			 acct.setAccountSign(TF_MElementValue.ACCOUNTSIGN_Natural);
			 acct.setPostActual(true);
			 acct.setPostBudget(true);
			 acct.setPostStatistical(true);
			 acct.setIsSummary(false);
			 acct.setIsBankAccount(false);
			 acct.setIsDocControlled(false);
			 acct.setDefaultOrg_ID(getAD_Org_ID());
			 acct.saveEx();
			// TF_MCharge.createChargeFromAccount(getCtx(), acct.getC_ElementValue_ID(), get_TrxName());
		 return acct.getC_ElementValue_ID();
		}
	}
	
	public static void updateInvestmentReceivable(int AD_Org_ID, String trxName) {
		String sql = "UPDATE TF_Shareholder s SET Investment_Receivable = " +
				" COALESCE(ROUND((SELECT SUM(Payable_Amount) FROM TF_InvestmentStructure i " +
				" WHERE i.AD_Org_ID = s.AD_Org_ID) * InvestmentShare / 100,2),0) " +
				" WHERE	AD_Org_ID = " + AD_Org_ID;		
		DB.executeUpdate(sql, trxName);
	}
	
	public static void updateInvestmentReceived(int AD_Org_ID, String trxName) {
		String sql = "UPDATE TF_Shareholder s SET Investment_Received = " +
				" COALESCE(ROUND((SELECT SUM(PayAmt) FROM TF_InvestmentReceipt i " +
				" WHERE i.AD_Org_ID = s.AD_Org_ID AND i.TF_Shareholder_ID = s.TF_Shareholder_ID"
				+ " AND i.DocStatus = 'CO' AND InvestmentReceiptType IN ('B','C') ),2),0) " +
				" WHERE	AD_Org_ID = " + AD_Org_ID;		
		DB.executeUpdate(sql, trxName);				
	}
	
	public static void updateUnallocatedAmt(int AD_Org_ID, String trxName) {
		String sql = "UPDATE TF_Shareholder s SET UnallocatedAmt = " +
				" COALESCE((SELECT SUM ( CASE WHEN InvestmentReceiptType = 'C' THEN r.PayAmt ELSE r.PayAmt * -1 END )  " +
				" FROM TF_InvestmentReceipt r WHERE r.TF_Shareholder_ID = s.TF_Shareholder_ID AND "
				+ " s.AD_Org_ID = r.AD_Org_ID AND r.DocStatus = 'CO' AND r.InvestmentReceiptType IN ('C','P')),0)" +
				" WHERE	s.AD_Org_ID = " + AD_Org_ID;		
		DB.executeUpdate(sql, trxName);	
	}
	
}
