package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPriceList;
import org.compiere.process.DocAction;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MBPOpeningBalance extends X_TF_BPOpeningBalance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3630556522861305909L;

	public MBPOpeningBalance(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MBPOpeningBalance(Properties ctx, int TF_BPOpeningBalance_ID, String trxName) {
		super(ctx, TF_BPOpeningBalance_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {		
		boolean ok = super.afterSave(newRecord, success);
		setOpeningBalance(newRecord);
		return ok;
	}

	@Override
	protected boolean beforeDelete() {		
		boolean ok = super.beforeDelete();
		if(getC_Invoice_ID() > 0) {
			throw new AdempiereException("Reset Debit or Credit Balance to ZERO to delete this recod!");
		}
		return ok;
	}

	public void setOpeningBalance(boolean newRecord) {
		if(newRecord || is_ValueChanged(COLUMNNAME_DebitBalance) || is_ValueChanged(COLUMNNAME_CreditBalance)
				|| is_ValueChanged(COLUMNNAME_OpeningDate)) {
			if(getC_Invoice_ID() > 0) {
				TF_MInvoice prevInv = new TF_MInvoice(getCtx(), getC_Invoice_ID(), get_TrxName());
				if(prevInv.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
					if (!prevInv.processIt(DocAction.ACTION_Reverse_Correct))
						throw new AdempiereException("Failed when processing document - " + prevInv.getProcessMsg());
					prevInv.saveEx();
				}								
			}
			
			BigDecimal DebitAmt = getDebitBalance();
			BigDecimal CreditAmt = getCreditBalance();
			boolean isSOTrx;			
			int m_C_DocTypeTarget_ID;
			int C_ElementValue_ID;
						
			
			MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(getCtx());
			if(DebitAmt.doubleValue()!=0) {
				m_C_DocTypeTarget_ID = glConfig.getBP_DebitDocType_ID();
				C_ElementValue_ID = glConfig.getBP_DebitBalanceAcct_ID();
				isSOTrx = true;
			}				
			else if(CreditAmt.doubleValue() != 0) {
				m_C_DocTypeTarget_ID = glConfig.getBP_CreditDocType_ID();
				C_ElementValue_ID = glConfig.getBP_CreditBalanceAcct_ID();
				isSOTrx = false;
			}
			else {
				DB.executeUpdate("UPDATE TF_BPOpeningBalance SET C_Invoice_ID=NULL  WHERE TF_BPOpeningBalance_ID ="
						+ getTF_BPOpeningBalance_ID(), get_TrxName());
				return;
			}
				
			
			if(getAD_Org_ID() == 0) {
				throw new AdempiereException("Opening Balance cannot be set for Global Business Partner (Organization=*)!");
			}
			
			TF_MBPartner bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
						
			//Invoice Header
			TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
			invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
			invoice.setC_DocTypeTarget_ID(m_C_DocTypeTarget_ID);			
			invoice.setDateInvoiced(getOpeningDate());
			invoice.setDateAcct(getOpeningDate());
			//
			invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
			//
			invoice.setBPartner(bp);
			invoice.setIsSOTrx(isSOTrx);		
			
			
			//Price List
			int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
			if(bp.getPO_PriceList_ID() > 0)
				m_M_PriceList_ID = bp.getPO_PriceList_ID();			
			invoice.setM_PriceList_ID(m_M_PriceList_ID);
			invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
			invoice.setDescription("Opening Balance Entered");
			invoice.saveEx();
			//End Invoice Header
			
			//Invoice Line
			MInvoiceLine invLine = new MInvoiceLine(invoice);
			TF_MCharge chrg = TF_MCharge.createChargeFromAccount(getCtx(), C_ElementValue_ID, null);
			invLine.setC_Charge_ID(chrg.getC_Charge_ID());			
			invLine.setQty(BigDecimal.ONE);
			if(isSOTrx)
				invLine.setPrice(DebitAmt);
			else
				invLine.setPrice(CreditAmt);
			invLine.saveEx();
			//End Invoice Line
			
			//DocAction
			if (!invoice.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
			invoice.saveEx();
			
			DB.executeUpdate("UPDATE TF_BPOpeningBalance SET C_Invoice_ID=" + invoice.getC_Invoice_ID() + " WHERE TF_BPOpeningBalance_ID ="
					+ getTF_BPOpeningBalance_ID(), get_TrxName());
			
		}
	}
	
}
