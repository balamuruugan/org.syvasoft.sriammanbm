package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class CalloutPayment_CalcSalaryBalannceAmts implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		
		BigDecimal salaryAmt = BigDecimal.ZERO;
		BigDecimal salaryPaid = BigDecimal.ZERO;
		BigDecimal salaryBalance = BigDecimal.ZERO;
		BigDecimal advancePaid = BigDecimal.ZERO;
		BigDecimal advanceDeduct = BigDecimal.ZERO; 
		BigDecimal advanceBalance = BigDecimal.ZERO;
		
		if(mTab.getValueAsBoolean(TF_MPayment.COLUMNNAME_IsSalaryPayment)) {
			salaryAmt = (BigDecimal) mTab.getValue(TF_MPayment.COLUMNNAME_Salary_Amt);
			salaryPaid = (BigDecimal) mTab.getValue(TF_MPayment.COLUMNNAME_PayAmt);
			advancePaid = (BigDecimal) mTab.getValue(TF_MPayment.COLUMNNAME_Advance_Paid);
			advanceDeduct = (BigDecimal) mTab.getValue(TF_MPayment.COLUMNNAME_Advance_Deduct);
			
			//if(salaryAmt.doubleValue() > advancePaid.doubleValue()) 
			//	advanceDeduct = advancePaid;
			//else
			//	advanceDeduct = advancePaid.subtract(salaryAmt);
			
			advanceBalance = advancePaid.subtract(advanceDeduct);
			
			if(!mField.getColumnName().equals(TF_MPayment.COLUMNNAME_PayAmt))
				salaryPaid= salaryAmt.subtract(advanceDeduct);
			
			salaryBalance = salaryAmt.subtract(advanceDeduct).subtract(salaryPaid);
			
			///mTab.setValue(TF_MPayment.COLUMNNAME_PayAmt, salaryPaid);
		}
		
		mTab.setValue(TF_MPayment.COLUMNNAME_Advance_Deduct, advanceDeduct);
		mTab.setValue(TF_MPayment.COLUMNNAME_Advance_Balance, advanceBalance);
		mTab.setValue(TF_MPayment.COLUMNNAME_Salary_Payable, salaryBalance);
		
		
		return null;
	}

}
