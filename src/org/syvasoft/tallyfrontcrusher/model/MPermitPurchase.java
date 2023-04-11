package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MPermitPurchase extends X_TF_PermitPurchase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7851195614811119351L;

	public MPermitPurchase(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MPermitPurchase(Properties ctx, int TF_PermitPurchase_ID, String trxName) {
		super(ctx, TF_PermitPurchase_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public BigDecimal getRemainingBreakupQty() {
		String sql = "SELECT SUM(PermitQty) FROM TF_PermitPurchaseLine WHERE TF_PermitPurchase_ID = ?";
		BigDecimal balanceQty = DB.getSQLValueBD(get_TrxName(), sql, getTF_PermitPurchase_ID());
		if(balanceQty == null)
			balanceQty = BigDecimal.ZERO;
		return balanceQty;
	}
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			if(getPermitQty().doubleValue() - getRemainingBreakupQty().doubleValue() != 0) {
				throw new AdempiereException("Please add / adjust Permit Breakup Quantities for Materials without any balance in Permit Purchase Qty!");
			}
			
			MCrusherPermitLedger.purchasePermit(this);
			if(getC_ElementValue_ID() > 0 && getC_BankAccount_ID() > 0) {
				TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
				payment.setAD_Org_ID(getAD_Org_ID());			
				payment.setOnAccount(true);
				payment.setDateTrx(getDateAcct());
				payment.setDateAcct(getDateAcct());	
				payment.setDateBankTrx(getDateAcct());
				payment.setC_BankAccount_ID(getC_BankAccount_ID());
				payment.setC_DocType_ID(1000009);
				payment.setIsReceipt(false);
				payment.setC_ElementValue_ID(getC_ElementValue_ID());
				TF_MCharge charge = TF_MCharge.createChargeFromAccount(getCtx(), payment.getC_ElementValue_ID(), get_TrxName());
				if(charge != null )
					payment.setC_Charge_ID(charge.get_ID());
				MUser user = MUser.get(getCtx(), Env.getAD_User_ID(getCtx()));				
				int bPartnerID = user.getC_BPartner_ID();	
				payment.setC_BPartner_ID(bPartnerID);		
				payment.setC_Currency_ID(Env.getContextAsInt(getCtx(), "$C_Currency_ID"));
				payment.setPayAmt(getPermitAmount());
				payment.setTenderType(TF_MPayment.TENDERTYPE_Cash);
				String desc = "Permit Purchase:" + getDocumentNo();
				if(getDescription() != null)
					desc = desc + " | " + getDescription();
				payment.setDescription(desc);
				payment.saveEx();
				if(!payment.processIt(DocAction.ACTION_Complete))
					throw new AdempiereException("Failed when processing document - " + payment.getProcessMsg());
				payment.saveEx();
				setC_Payment_ID(payment.getC_Payment_ID());
			}
			
		}
	}
	public void reverseIt() {
		setDocStatus(DOCSTATUS_InProgress);
		setProcessed(false);		
		MCrusherPermitLedger.reversePurchasedPermit(getAD_Org_ID(), getTF_PermitPurchase_ID(), get_TrxName());
		if(getC_Payment_ID() > 0) {
			TF_MPayment payment = new TF_MPayment(getCtx(), getC_Payment_ID(), get_TrxName());
			if(payment.getDocStatus().equals(DOCSTATUS_Completed)){
				 if(!payment.reverseCorrectIt())
					 throw new AdempiereException("Cash Book Payment cannot be reversed!");
				 payment.saveEx();
			}
			setC_Payment_ID(0);
		}
	}
		
}
