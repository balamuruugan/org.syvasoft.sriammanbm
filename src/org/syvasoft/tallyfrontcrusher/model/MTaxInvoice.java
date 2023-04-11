package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPriceList;
import org.compiere.process.DocAction;
import org.compiere.util.Env;

public class MTaxInvoice extends X_TF_TaxInvoice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5345401658705556449L;

	public MTaxInvoice(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTaxInvoice(Properties ctx, int TF_TaxInvoice_ID, String trxName) {
		super(ctx, TF_TaxInvoice_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public void calcAmounts() {
		setTaxableAmount(getQty().multiply(getPrice()));		
		BigDecimal divisor = new BigDecimal(100);		
		BigDecimal cgstAmt = getCGST_Rate().multiply(getTaxableAmount()).divide(divisor);
		BigDecimal sgstAmt = getSGST_Rate().multiply(getTaxableAmount()).divide(divisor);
		BigDecimal igstAmt = getIGST_Rate().multiply(getTaxableAmount()).divide(divisor);		
		
		setCGST_Amt(cgstAmt);
		setSGST_Amt(sgstAmt);
		setIGST_Amt(igstAmt);
		
		BigDecimal total = getTaxableAmount().add(cgstAmt).add(sgstAmt)
				.add(igstAmt);
		BigDecimal roundingOff = total.subtract(total.setScale(0, RoundingMode.HALF_UP));
		if(getRoundingOff().equals(BigDecimal.ZERO))
			setRoundingOff(roundingOff);
		
		setGrandTotal(total.add(getRoundingOff()));
	}
		
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			if(getMDPNo() != null && getMDPNo().length() > 0) {
				TF_MOrg org = new TF_MOrg(getCtx(), getAD_Org_ID(), get_TrxName());
				if( getQtyPermitDeducted().doubleValue() > 0) {
					if(org.getOrgType().equals(TF_MOrg.ORGTYPE_Crusher))
						MCrusherPermitLedger.issuePermit(this);
				}
				else 
					throw new AdempiereException("Permit Qty should be greater than ZERO!");
			}
			if(!isPostTaxToCustomer() && !isPostPermitAmtToCustomer() )
				return;
			
			if(isPostPermitAmtToCustomer() && getPermitAmount().doubleValue() <= 0) {
				throw new AdempiereException("Permit Amount should be greater than ZERO!");
			}
			
			MGLPostingConfig config = MGLPostingConfig.getMGLPostingConfig(getCtx());
			//Invoice Header
			TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
			invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
			invoice.setC_DocTypeTarget_ID(config.getDefaultSalesInvoiceDocType_ID());
			invoice.setDateInvoiced(getDateAcct());
			invoice.setDateAcct(getDateAcct());
			//
			invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
			//
			TF_MBPartner bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
			invoice.setBPartner(bp);
			invoice.setIsSOTrx(true);		
			
			
			//Price List
			int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
			if(bp.getM_PriceList_ID() > 0)
				m_M_PriceList_ID = bp.getM_PriceList_ID();			
			invoice.setM_PriceList_ID(m_M_PriceList_ID);
			invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
			invoice.setDescription("Tax Invoice: " + getDocumentNo());
			invoice.saveEx();
			//End Invoice Header
			
			//Invoice Line
			MInvoiceLine invLine = null;
			if(isPostTaxToCustomer()) {
				if(getCGST_Rate().doubleValue() > 0 || getSGST_Rate().doubleValue() > 0) {
					//CGST
					invLine = new MInvoiceLine(invoice);
					TF_MCharge chrg = TF_MCharge.createChargeFromAccount(getCtx(), config.getC_ElementValueCGST_ID(), null);
					invLine.setC_Charge_ID(chrg.getC_Charge_ID());
					invLine.setC_Tax_ID(1000000);
					invLine.setQty(BigDecimal.ONE);			
					invLine.setPrice(getCGST_Amt());
					invLine.setDescription("CGST " +  getCGST_Rate() + "% of Rs." + getTaxableAmount());
					invLine.saveEx();
					
					//SGST
					invLine = new MInvoiceLine(invoice);
					chrg = TF_MCharge.createChargeFromAccount(getCtx(), config.getC_ElementValueSGST_ID(), null);
					invLine.setC_Charge_ID(chrg.getC_Charge_ID());
					invLine.setC_Tax_ID(1000000);
					invLine.setQty(BigDecimal.ONE);			
					invLine.setPrice(getSGST_Amt());
					invLine.setDescription("SGST " +  getSGST_Rate() + "% of Rs." + getTaxableAmount());
					invLine.saveEx();				
				}
				else {
					//IGST
					invLine = new MInvoiceLine(invoice);
					TF_MCharge chrg = TF_MCharge.createChargeFromAccount(getCtx(), config.getC_ElementValueIGST_ID(), null);
					invLine.setC_Charge_ID(chrg.getC_Charge_ID());
					invLine.setC_Tax_ID(1000000);
					invLine.setQty(BigDecimal.ONE);			
					invLine.setPrice(getIGST_Amt());
					invLine.setDescription("IGST " +  getIGST_Rate() + "% of Rs." + getTaxableAmount());
					invLine.saveEx();
				}
			}
			if(isPostPermitAmtToCustomer()) {
				invLine = new MInvoiceLine(invoice);
				TF_MCharge chrg = TF_MCharge.createChargeFromAccount(getCtx(), config.getC_ElementValuePermitExp_ID(), null);
				invLine.setC_Charge_ID(chrg.getC_Charge_ID());
				invLine.setC_Tax_ID(1000000);
				invLine.setQty(BigDecimal.ONE);			
				invLine.setPrice(getPermitAmount());
				invLine.setDescription("For " + getM_Product().getName() + " Qty: " + getQty() + " MT" );
				invLine.saveEx();
			}			
				
			//End Invoice Line
			//DocAction
			if (!invoice.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
			invoice.saveEx();
			
			setC_Invoice_ID(invoice.getC_Invoice_ID());
			
			if(getTF_Weighment_Permit_ID() > 0) {
				MWeighmentPermitEntry wEntry = new MWeighmentPermitEntry(getCtx(), getTF_Weighment_Permit_ID(), get_TrxName());
				wEntry.closeIt();
				wEntry.saveEx();
			}
		}
	}
	
	public void reverseIt() {
		setDocStatus(DOCSTATUS_InProgress);
		setProcessed(false);		
		MCrusherPermitLedger.reverseIssuedPermit(this);
		if(getC_Invoice_ID() > 0) {
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getC_Invoice_ID(), get_TrxName());
			if(inv.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!inv.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + inv.getProcessMsg());
				inv.saveEx();
			}
			setC_Invoice_ID(0);
		}
		if(getTF_Weighment_Permit_ID() > 0) {
			MWeighmentPermitEntry wEntry = new MWeighmentPermitEntry(getCtx(), getTF_Weighment_Permit_ID(), get_TrxName());
			wEntry.reverseIt();
			wEntry.saveEx();
		}
	}
		 
	
}
