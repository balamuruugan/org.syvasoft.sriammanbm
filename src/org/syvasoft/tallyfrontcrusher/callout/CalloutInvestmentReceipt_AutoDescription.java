package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.syvasoft.tallyfrontcrusher.model.MInvestmentReceipt;
import org.syvasoft.tallyfrontcrusher.model.MShareholder;
import org.syvasoft.tallyfrontcrusher.model.TF_MBankAccount;
import org.syvasoft.tallyfrontcrusher.model.TF_MElementValue;

public class CalloutInvestmentReceipt_AutoDescription implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int TF_Shareholder_ID = 0;
		int C_BankAccount_ID = 0;
		int C_ElementValue_ID = 0;
		String description=null;
		String invReceiptType = (String) mTab.getValue(MInvestmentReceipt.COLUMNNAME_InvestmentReceiptType);
		if(invReceiptType.equals(MInvestmentReceipt.INVESTMENTRECEIPTTYPE_CapitalACToCashAC))
			mTab.setValue(MInvestmentReceipt.COLUMNNAME_C_ElementValue_ID, null);
			
		if(mTab.getValue(MInvestmentReceipt.COLUMNNAME_TF_Shareholder_ID) != null)
			TF_Shareholder_ID = (int) mTab.getValue(MInvestmentReceipt.COLUMNNAME_TF_Shareholder_ID);
		if(mTab.getValue(MInvestmentReceipt.COLUMNNAME_C_BankAccount_ID) != null)
			C_BankAccount_ID = (int) mTab.getValue(MInvestmentReceipt.COLUMNNAME_C_BankAccount_ID);
		if(mTab.getValue(MInvestmentReceipt.COLUMNNAME_C_ElementValue_ID) != null)
			C_ElementValue_ID = (int) mTab.getValue(MInvestmentReceipt.COLUMNNAME_C_ElementValue_ID);
		
		MShareholder sh = new MShareholder(ctx, TF_Shareholder_ID, null);		
		TF_MElementValue acct = new TF_MElementValue(ctx, C_ElementValue_ID, null);
		BigDecimal amt = BigDecimal.ZERO;
		BigDecimal amt2 = BigDecimal.ZERO;
		String sql = "SELECT  Round(((SELECT SUM(Payable_Amount) FROM TF_InvestmentStructure i WHERE i.AD_Org_ID = s.AD_Org_ID " +
				" AND i.C_ElementValue_ID = " + C_ElementValue_ID + " ) * s.InvestmentShare / 100 - COALESCE((SELECT SUM(PayAmt) FROM TF_InvestmentReceipt r " +
				"  WHERE r.TF_Shareholder_ID = s.TF_Shareholder_ID AND r.C_ElementValue_ID = "+ C_ElementValue_ID + " AND " +
				" r.DocStatus = 'CO' AND Processed ='Y'),0)), 2) " +
				" FROM 	TF_Shareholder s  WHERE s.TF_Shareholder_ID = ?" ;
				
		amt = DB.getSQLValueBD(null, sql, TF_Shareholder_ID);
		if(amt == null)
			amt = BigDecimal.ZERO;
		if(!mField.getColumnName().equals(MInvestmentReceipt.COLUMNNAME_PayAmt)) {
		
			mTab.setValue(MInvestmentReceipt.COLUMNNAME_PayAmt, amt);
			mTab.setValue(MInvestmentReceipt.COLUMNNAME_Payable_Amount, amt2);
			
		}
		else {
			amt2 = (BigDecimal) mTab.getValue(MInvestmentReceipt.COLUMNNAME_PayAmt);
			if(C_ElementValue_ID != 0)
				mTab.setValue(MInvestmentReceipt.COLUMNNAME_Payable_Amount, amt.subtract(amt2));
			amt = amt2;
		}
				
		if(TF_Shareholder_ID != 0 && C_BankAccount_ID != 0 && C_ElementValue_ID != 0)
			description = sh.getName() + " paid Rs." + amt.toString() + " for " + acct.getName();
		else if(TF_Shareholder_ID != 0 && C_BankAccount_ID != 0 && C_ElementValue_ID == 0)
			description = sh.getName() + " paid Rs." + amt.toString() + " for initial expenses";
		
		mTab.setValue(MInvestmentReceipt.COLUMNNAME_Description, description);
				
		return null;
	}

}
