package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MDocType;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;


public class MTRTaxInvoice extends X_TF_TRTaxInvoice {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3112068874449361280L;

	public MTRTaxInvoice(Properties ctx, int TF_TRTaxInvoice_ID, String trxName) {
		super(ctx, TF_TRTaxInvoice_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTRTaxInvoice(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public void reverseIt() {
		setProcessed(false);
		setDocStatus(DOCSTATUS_Drafted);
		
		//MOAInventoryTransaction.deleteSalesTaxInvoiceTransactions(getCtx(), getTF_TRTaxInvoice_ID(), get_TrxName());
		
		if(getC_Invoice_ID() > 0) {
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getC_Invoice_ID(), get_TrxName());
			if(inv.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!inv.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + inv.getProcessMsg());
				inv.saveEx();
			}
			setC_Invoice_ID(0);
		}
		if(getGL_Journal_ID() > 0) {
			MJournal j = new MJournal(getCtx(), getGL_Journal_ID(), get_TrxName());
			if(j.getDocStatus().equals(TF_MInvoice.DOCSTATUS_Completed)) {
				if (!j.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
				j.saveEx();
			}
			setGL_Journal_ID(0);
		}
	}

	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			MDocType[] dts = MDocType.getOfDocBaseType(getCtx(), "TIN");
			for(MDocType dt : dts) {
				if(dt.isSOTrx() && isSOTrx()) 
					setC_DocType_ID(dt.getC_DocType_ID());
				else if(!dt.isSOTrx() && !isSOTrx())
					setC_DocType_ID(dt.getC_DocType_ID());
			}
		}
		return super.beforeSave(newRecord);
	}
	
	public List<MTRTaxInvoiceLine> getLines() {
		List<MTRTaxInvoiceLine> lines = new Query(getCtx(), MTRTaxInvoiceLine.Table_Name,
				"TF_TRTaxInvoice_ID = ?", get_TrxName())
				.setClient_ID()
				.setParameters(getTF_TRTaxInvoice_ID())
				.list();
		return lines;
	}
	
	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
		
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			if(!isSOTrx())
				return;
			List<MTRTaxInvoiceLine> lines = new Query(getCtx(), MTRTaxInvoiceLine.Table_Name,
					"TF_TRTaxInvoice_ID = ?", get_TrxName())
					.setClient_ID()
					.setParameters(getTF_TRTaxInvoice_ID())
					.list();
			
			if(isPostTaxToCustomer()) {
				
				// Post GST to Supplier
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
					for(MTRTaxInvoiceLine line : lines) {
						if(line.getCGST_Rate().doubleValue() > 0 || line.getSGST_Rate().doubleValue() > 0) {
							//CGST
							invLine = new MInvoiceLine(invoice);
							TF_MCharge chrg = TF_MCharge.createChargeFromAccount(getCtx(), config.getC_ElementValueCGST_ID(), null);
							invLine.setC_Charge_ID(chrg.getC_Charge_ID());
							invLine.setC_Tax_ID(1000000);
							invLine.setQty(BigDecimal.ONE);			
							invLine.setPrice(line.getCGST_Amt());
							invLine.setDescription("CGST " +  line.getCGST_Rate() + "% of Rs." + line.getTaxableAmount());
							invLine.saveEx();
							
							//SGST
							invLine = new MInvoiceLine(invoice);
							chrg = TF_MCharge.createChargeFromAccount(getCtx(), config.getC_ElementValueSGST_ID(), null);
							invLine.setC_Charge_ID(chrg.getC_Charge_ID());
							invLine.setC_Tax_ID(1000000);
							invLine.setQty(BigDecimal.ONE);			
							invLine.setPrice(line.getSGST_Amt());
							invLine.setDescription("SGST " +  line.getSGST_Rate() + "% of Rs." + line.getTaxableAmount());
							invLine.saveEx();				
						}
						else {
							//IGST
							invLine = new MInvoiceLine(invoice);
							TF_MCharge chrg = TF_MCharge.createChargeFromAccount(getCtx(), config.getC_ElementValueIGST_ID(), null);
							invLine.setC_Charge_ID(chrg.getC_Charge_ID());
							invLine.setC_Tax_ID(1000000);
							invLine.setQty(BigDecimal.ONE);			
							invLine.setPrice(line.getIGST_Amt());
							invLine.setDescription("IGST " +  line.getIGST_Rate() + "% of Rs." + line.getTaxableAmount());
							invLine.saveEx();
						}
					}
					
					//End Invoice Line
					//DocAction
					if (!invoice.processIt(DocAction.ACTION_Complete))
						throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
					invoice.saveEx();
					
					setC_Invoice_ID(invoice.getC_Invoice_ID());
									
				}
			}
			else if(isPostGSTAsExpense()){
				int m_C_DocTypeTarget_ID = 1000000;
				MGLPostingConfig glConfig = MGLPostingConfig.getMGLPostingConfig(getCtx());
				if(glConfig.getC_ElementGSTPayable_ID() == 0)
					throw new AdempiereException("Please configure GST Payable Account in Settings!");
					
				
				TF_MJournal j = new TF_MJournal(getCtx(), 0, get_TrxName());
				j.setDescription("GST Expense Posted from Sales Tax Invoice:" + getDocumentNo() 
					+ " for Customer:" + (getPartyName() != null ? getPartyName() + " (Cash)" : getC_BPartner().getName()));
				j.setAD_Org_ID(getAD_Org_ID());
				j.setC_AcctSchema_ID(glConfig.getC_AcctSchema_ID());
				j.setC_Currency_ID(glConfig.getC_AcctSchema().getC_Currency_ID());
				j.setPostingType(TF_MJournal.POSTINGTYPE_Actual);
				j.setC_DocType_ID(m_C_DocTypeTarget_ID);
				j.setDateDoc(getDateAcct());
				j.setDateAcct(getDateAcct());
				j.setDocStatus(TF_MJournal.DOCSTATUS_Drafted);
				MPeriod period = MPeriod.get(getCtx(), getDateAcct());
				j.setC_Period_ID(period.getC_Period_ID());
				j.setGL_Category_ID(1000000);
				j.setC_ConversionType_ID(114);
				j.setC_Project_ID(0);
				j.saveEx();
				MJournalLine jl;
				BigDecimal gstPayable = BigDecimal.ZERO;
				int i = 10;
				for(MTRTaxInvoiceLine line : lines) {
					String product = line.getM_Product().getName();
					if(line.getCGST_Rate().doubleValue() > 0 || line.getSGST_Rate().doubleValue() > 0) {
						//CGST								
						jl = new MJournalLine(j);
						jl.setLine(i);			
						jl.setAccount_ID(glConfig.getC_ElementValueCGST_ID());
						jl.setC_BPartner_ID(getC_BPartner_ID());
						jl.setM_Product_ID(line.getM_Product_ID());
						jl.setAmtSourceDr(line.getCGST_Amt());
						jl.setAmtAcctDr(line.getCGST_Amt());
						jl.setDescription(product + " - CGST " +  line.getCGST_Rate() + "% of Rs." + line.getTaxableAmount());
						jl.setIsGenerated(true);
						jl.saveEx();						
						
						//SGST
						i = i + 10;
						jl = new MJournalLine(j);
						jl.setLine(i);			
						jl.setAccount_ID(glConfig.getC_ElementValueSGST_ID());
						jl.setC_BPartner_ID(getC_BPartner_ID());
						jl.setM_Product_ID(line.getM_Product_ID());
						jl.setAmtSourceDr(line.getSGST_Amt());
						jl.setAmtAcctDr(line.getSGST_Amt());
						jl.setDescription(product + " - SGST " +  line.getSGST_Rate() + "% of Rs." + line.getTaxableAmount());
						jl.setIsGenerated(true);
						jl.saveEx();
						gstPayable = line.getSGST_Amt().add(line.getCGST_Amt());
								
					}
					else {
						//IGST
						i = i + 10;
						jl = new MJournalLine(j);
						jl.setLine(i);			
						jl.setAccount_ID(glConfig.getC_ElementValueIGST_ID());
						jl.setM_Product_ID(line.getM_Product_ID());
						jl.setC_BPartner_ID(getC_BPartner_ID());		
						jl.setAmtSourceDr(line.getIGST_Amt());
						jl.setAmtAcctDr(line.getIGST_Amt());
						jl.setDescription(product + " - IGST " +  line.getIGST_Rate() + "% of Rs." + line.getTaxableAmount());
						jl.setIsGenerated(true);
						jl.saveEx();			
						gstPayable = line.getIGST_Amt();
					}
					//Cr - GST Payable
					i = i + 10;					
					double gstRate = line.getCGST_Rate().doubleValue() + line.getSGST_Rate().doubleValue() 
							+ line.getIGST_Rate().doubleValue();
					jl = new MJournalLine(j);
					jl.setLine(i);			
					jl.setAccount_ID(glConfig.getC_ElementGSTPayable_ID());
					jl.setC_BPartner_ID(getC_BPartner_ID());		
					jl.setM_Product_ID(line.getM_Product_ID());
					jl.setAmtSourceCr(gstPayable);
					jl.setAmtAcctCr(gstPayable);
					jl.setDescription(product + " - GST " + gstRate + "% of Rs." + line.getTaxableAmount());
					jl.setIsGenerated(true);
					jl.saveEx();
				}
				
												
				//DocAction
				if (!j.processIt(DocAction.ACTION_Complete))
					throw new AdempiereException("Failed when processing document - " + j.getProcessMsg());
				j.saveEx();
				
				setGL_Journal_ID(j.getGL_Journal_ID());
				
			}
			
		}
	}

	public String validateInvoiceDate() {
		//Invoice should be greater than or equal to running/latest invoice date.
		String whereClause = "AD_Org_ID = ? AND DocStatus = 'CO'";
		MTRTaxInvoice latestInv = new Query(getCtx(), get_TableName(), whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getAD_Org_ID())
				.setOrderBy("DateAcct DESC")
				.first();
		if(latestInv != null) {
			int interval = TimeUtil.getDaysBetween(latestInv.getDateAcct(), getDateAcct());
			String datestring = new SimpleDateFormat("dd/MM/yyyy").format(latestInv.getDateAcct());
			if(interval < 0)
				return "Current Invoice Date:" 
						+ datestring + " so Please do not enter old invoice date!";
			else
				return null;
		}
		else {
			return null;
		}
	}
}
