package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBPartner;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPriceList;
import org.compiere.model.MWarehouse;
import org.compiere.process.DocAction;
import org.compiere.util.Env;

public class MDebitCreditNote extends X_TF_DebitCreditNote {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5529298777010449285L;

	public MDebitCreditNote(Properties ctx, int TF_DebitCreditNote_ID, String trxName) {
		super(ctx, TF_DebitCreditNote_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MDebitCreditNote(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);			
			TF_MBPartner bp = null;

			if(getC_BPartner_ID() > 0) {
				 bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
			}
			
			createDebitNote(bp);
			

		}
	}

	public void reverseIt() {

		if(getC_Invoice_ID() > 0) {			
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getC_Invoice_ID(), get_TrxName());
			if(inv.getDocStatus().equals(DOCSTATUS_Completed))
				inv.reverseCorrectIt();
			inv.saveEx();
			//setC_Invoice_ID(0);
		}
		setProcessed(true);
		setDocStatus(DOCSTATUS_Reversed);
		
	}
	
	private void createDebitNote(TF_MBPartner bp) {	
		int bPartnerID = 0;

		if(bp != null)
			bPartnerID = bp.getC_BPartner_ID();

		if(bp == null)
			bp = new TF_MBPartner(getCtx(), bPartnerID, get_TrxName());
		
		//Debit Note Header
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setDocumentNo(getDocumentNo());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(getC_DocType_ID());			
		invoice.setDateInvoiced(getDateAcct());
		invoice.setDateAcct(getDateAcct());
		invoice.setIsSOTrx(getC_DocType().isSOTrx());
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
		//
		
		invoice.setBPartner(bp);
		//invoice.setIsSOTrx(false);		
		
		//String description = getDocumentNo();		
		//invoice.setDescription(getDocumentNo());
		if(getDescription() != null && getDescription().length() > 0)			 		
			invoice.addDescription(getDescription());
		
		//Price List
		int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
		//if(bp.getPO_PriceList_ID() > 0)
			//m_M_PriceList_ID = bp.getPO_PriceList_ID();			
		invoice.setM_PriceList_ID(m_M_PriceList_ID);
		invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		
		//Financial Dimension - Profit Center
		//invoice.setUser1_ID(getC_ElementValue_ID());
		//invoice.setC_Project_ID(getC_Project_ID());
		
		invoice.saveEx();
		//End Invoice Header
		
		//Invoice Line
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		TF_MCharge ch = TF_MCharge.createChargeFromAccount(getCtx(),getC_ElementValue_ID() , null);
		invLine.setC_Charge_ID(ch.getC_Charge_ID());
		//invLine.setC_UOM_ID(getC_UOM_ID());
		invLine.setQty(BigDecimal.ONE);
		BigDecimal price = getAmount(); 			
		
		invLine.setPriceActual(price);
		invLine.setPriceList(price);
		invLine.setPriceLimit(price);
		invLine.setPriceEntered(price);
		//invoice.addDescription("Expense incurred to " + bp.getName());			
		invLine.setC_Tax_ID(1000000);		
		
		invLine.saveEx();
		
		//Debit Note DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		//End DocAction
		
		setC_Invoice_ID(invoice.getC_Invoice_ID());		
		
	}

}
