package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MBankStatement;
import org.compiere.model.MBankStatementLine;
import org.compiere.model.MTable;
import org.compiere.model.MUser;
import org.compiere.util.Env;

public class TF_MBankStatementLine extends MBankStatementLine {

	public TF_MBankStatementLine(Properties ctx, int C_BankStatementLine_ID, String trxName) {
		super(ctx, C_BankStatementLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MBankStatementLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MBankStatementLine(MBankStatement statement) {
		super(statement);
		// TODO Auto-generated constructor stub
	}

	public TF_MBankStatementLine(MBankStatement statement, int lineNo) {
		super(statement, lineNo);
		// TODO Auto-generated constructor stub
	}

	public TF_MBankStatementLine(Properties ctx, int C_BankStatementLine_ID, String trxName, String... virtualColumns) {
		super(ctx, C_BankStatementLine_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	/** Column name C_ElementValue_ID */
    public static final String COLUMNNAME_C_ElementValue_ID = "C_ElementValue_ID";
	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValue_ID(), get_TrxName());	}

	/** Set Account Element.
		@param C_ElementValue_ID 
		Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID)
	{
		if (C_ElementValue_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
	}

	/** Get Account Element.
		@return Account Element
	  */
	public int getC_ElementValue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name TF_BPartner_ID */
    public static final String COLUMNNAME_TF_BPartner_ID = "TF_BPartner_ID";
    public org.compiere.model.I_C_BPartner getTF_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getTF_BPartner_ID(), get_TrxName());	}

	/** Set Customer / Vendor.
		@param TF_BPartner_ID Customer / Vendor	  */
	public void setTF_BPartner_ID (int TF_BPartner_ID)
	{
		if (TF_BPartner_ID < 1) 
			set_Value (COLUMNNAME_TF_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_TF_BPartner_ID, Integer.valueOf(TF_BPartner_ID));
	}

	
    public static final String COLUMNNAME_Receipt = "Receipt";
    public static final String COLUMNNAME_Payment = "Payment";
    
	public void setReceipt(BigDecimal receiptAmt) {
		set_Value (COLUMNNAME_Receipt, receiptAmt);
	}
	
	public BigDecimal getReceipt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Receipt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	public BigDecimal getPayment()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Payment);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	public void setPayment(BigDecimal paymentAmt) {
		set_Value (COLUMNNAME_Payment, paymentAmt);
	}
	
	
	/** Get Customer / Vendor.
		@return Customer / Vendor	  */
	public int getTF_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		
		TF_MBankStatement bs = new TF_MBankStatement(getCtx(), getC_BankStatement_ID(), get_TrxName());
		
		if(bs.getDocStatus().equals(TF_MBankStatement.DOCSTATUS_Drafted) || bs.getDocStatus().equals(TF_MBankStatement.DOCSTATUS_InProgress)) {
			if(getStmtAmt().doubleValue() == 0) {
				if(getReceipt().doubleValue() > 0)
					setStmtAmt(getReceipt());
				else
					setStmtAmt(getPayment().negate());
			}
		}
		if(newRecord) {
			setTrxAmt(getStmtAmt());
		}
		if(getC_Payment_ID() > 0) {
			TF_MPayment pay = new TF_MPayment(getCtx(), getC_Payment_ID(), get_TrxName());
			setDescription(pay.getDescription());
		}
		
		return super.beforeSave(newRecord);
	}
}
