package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;



import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.process.DocAction;

public class MPOSPayment extends X_C_POSPayment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8702210418634654996L;

	public MPOSPayment(Properties ctx, int C_POSPayment_ID, String trxName) {
		super(ctx, C_POSPayment_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MPOSPayment(Properties ctx, int C_POSPayment_ID, String trxName, String... virtualColumns) {
		super(ctx, C_POSPayment_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MPOSPayment(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	/** Set Shipment/Receipt.
		@param M_InOut_ID Material Shipment Document
	*/
	public void setM_InOut_ID (int M_InOut_ID)
	{
		if (M_InOut_ID < 1)
			set_Value (COLUMNNAME_M_InOut_ID, null);
		else
			set_Value (COLUMNNAME_M_InOut_ID, Integer.valueOf(M_InOut_ID));
	}

	/** Get Shipment/Receipt.
		@return Material Shipment Document
	  */
	public int getM_InOut_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_InOut_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public static MPOSPayment createPOSPayment(Properties ctx,int AD_Org_ID, int C_Order_ID, String tenderType, BigDecimal amount, String trxName) {
		MPOSTenderType tt = MPOSTenderType.get(ctx, AD_Org_ID, tenderType);
		if (tt == null)
			throw new AdempiereException("Please configure Tender Type:" + tenderType);
		
		MPOSPayment p = new MPOSPayment(ctx, 0, trxName);
		p.setAD_Org_ID(AD_Org_ID);
		p.setC_Order_ID(C_Order_ID);
		p.setC_BankAccount_ID(C_Order_ID);
		p.setTenderType(tt.getTenderType());
		p.setC_BankAccount_ID(tt.getC_BankAccount_ID());
		p.setC_POSTenderType_ID(tt.getC_POSTenderType_ID());
		p.setPayAmt(amount);
		if(tt.isGuarantee())
			p.setIsActive(false);
		p.saveEx();
		
		return p;
	}
	
	public static MPOSPayment createPOSPayment(Properties ctx,int AD_Org_ID, int M_InOut_ID, int TF_WeighmentEntry_ID, String tenderType, BigDecimal amount, String trxName) {
		MPOSTenderType tt = MPOSTenderType.get(ctx, AD_Org_ID, tenderType);
		if (tt == null)
			throw new AdempiereException("Please configure Tender Type:" + tenderType);
		
		MPOSPayment p = new MPOSPayment(ctx, 0, trxName);
		p.setAD_Org_ID(AD_Org_ID);
		p.setM_InOut_ID(M_InOut_ID);
		p.setTF_WeighmentEntry_ID(TF_WeighmentEntry_ID);
		p.setC_BankAccount_ID(M_InOut_ID);
		p.setTenderType(tt.getTenderType());
		p.setC_BankAccount_ID(tt.getC_BankAccount_ID());
		p.setC_POSTenderType_ID(tt.getC_POSTenderType_ID());
		p.setPayAmt(amount);
		if(tt.isGuarantee())
			p.setIsActive(false);
		p.saveEx();
		
		return p;
	}
	
	public void processIt() {
		if(!isActive())
			return;
		
		//create cash book entry
		TF_MOrder ord = new TF_MOrder(getCtx(), getC_Order_ID(), get_TrxName());
		TF_MInOut inOut = new TF_MInOut(getCtx(), getM_InOut_ID(), get_TrxName());
		
		if(getC_Order_ID() > 0) {
			MWeighmentEntry we = new MWeighmentEntry(getCtx(), ord.getTF_WeighmentEntry_ID(), get_TrxName());
			TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
			payment.setAD_Org_ID(ord.getAD_Org_ID());
			payment.setDateAcct(ord.getDateAcct());
			payment.setDateTrx(payment.getDateAcct());
			payment.setDateBankTrx(payment.getDateAcct());
			payment.setDescription("Invoice No : " + we.getInvoiceNo());		
			payment.setC_DocType_ID(ord.isSOTrx());
			payment.setTF_WeighmentEntry_ID(we.getTF_WeighmentEntry_ID());
			payment.setC_Order_ID(getC_Order_ID());
			payment.setC_Invoice_ID(ord.getC_Invoice_ID());
			payment.setC_BankAccount_ID(getC_BankAccount_ID());
			payment.setTF_BPartner_ID(ord.getC_BPartner_ID());
			payment.setC_BPartner_ID(ord.getC_BPartner_ID());		
			payment.setPayAmt(getPayAmt());
			payment.setC_Currency_ID(304);
			payment.setDocStatus(TF_MOrder.DOCSTATUS_InProgress);
			payment.setTenderType(getTenderType());
			payment.saveEx();
			payment.processIt(DocAction.ACTION_Complete);
			payment.saveEx();
			
			setC_Payment_ID(payment.getC_Payment_ID());
			setProcessed(true);
		}
		
		else if(getM_InOut_ID() > 0) {
			MWeighmentEntry we = new MWeighmentEntry(getCtx(), inOut.getTF_WeighmentEntry_ID(), get_TrxName());
			TF_MPayment payment = new TF_MPayment(getCtx(), 0, get_TrxName());
			payment.setAD_Org_ID(inOut.getAD_Org_ID());
			payment.setDateAcct(inOut.getDateAcct());
			payment.setDateTrx(payment.getDateAcct());
			payment.setDateBankTrx(payment.getDateAcct());
			payment.setDescription("DC No : " + we.getDocumentNo());		
			payment.setC_DocType_ID(inOut.isSOTrx());
			payment.setTF_WeighmentEntry_ID(we.getTF_WeighmentEntry_ID());
			payment.setC_BankAccount_ID(getC_BankAccount_ID());
			payment.setTF_BPartner_ID(inOut.getC_BPartner_ID());
			payment.setC_BPartner_ID(inOut.getC_BPartner_ID());		
			payment.setPayAmt(getPayAmt());
			payment.setC_Currency_ID(304);
			payment.setDocStatus(TF_MInOut.DOCSTATUS_InProgress);
			payment.setTenderType(getTenderType());
			payment.saveEx();
			payment.processIt(DocAction.ACTION_Complete);
			payment.saveEx();
			
			setC_Payment_ID(payment.getC_Payment_ID());
			setProcessed(true);
		}
	}
	
	public void reversetIt() {
		//reverse correct cashbook entry
		//set isACtive as N
		if(getC_Payment_ID() > 0) {
			setIsActive(false);
			TF_MPayment p = new TF_MPayment(getCtx(), getC_Payment_ID(), get_TrxName());
			if(p.getDocStatus().equals(TF_MPayment.DOCSTATUS_Completed)) {
				p.reverseCorrectIt();
				p.saveEx();
			}
		}
	}
	
	public static void reversePayments(Properties ctx, int C_Order_ID, String trxName) {
		String whereClause = "C_Order_ID = ? AND Processed = 'Y' AND IsActive = 'Y' ";
		List<MPOSPayment> payments = new Query(ctx, Table_Name, whereClause, trxName)
				.setClient_ID()
				.setParameters(C_Order_ID)
				.list();
		
		for(MPOSPayment p : payments) {
			p.reversetIt();
			p.saveEx();
		}
	}
	
	public static void reversePayments(Properties ctx, int M_InOut_ID, int TF_WeighmentEntry_ID, String trxName) {
		String whereClause = "M_InOut_ID = ? AND TF_WeighmentEntry_ID = ? AND Processed = 'Y' AND IsActive = 'Y' ";
		List<MPOSPayment> payments = new Query(ctx, Table_Name, whereClause, trxName)
				.setClient_ID()
				.setParameters(M_InOut_ID, TF_WeighmentEntry_ID)
				.list();
		
		for(MPOSPayment p : payments) {
			p.reversetIt();
			p.saveEx();
		}
	}
	
}
