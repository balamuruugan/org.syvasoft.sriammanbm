/**
 * 
 */
package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBPartner;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPriceList;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.TF_MCharge;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;

/**
 * @author syed
 *
 */
public class SetBPOpeningBalance extends SvrProcess {

	private int m_AD_Client_ID = 0;
	private int m_AD_Org_ID = 0;
	private int C_BPartner_ID = 0;
	private Timestamp dateAcct = null;
	private BigDecimal DebitAmt = BigDecimal.ZERO;
	private BigDecimal CreditAmt = BigDecimal.ZERO;
	private int C_ElementValue_ID = 0;
	private boolean IsReversePrevOpeningBalance = false;
	private int Cust_C_DocTypeTarget_ID = 0;
	private int Vendor_C_DocTypeTarget_ID = 0;
	/* (non-Javadoc)
	 * @see org.compiere.process.SvrProcess#prepare()
	 */
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		m_AD_Client_ID = Env.getAD_Client_ID(getCtx());
		m_AD_Org_ID = Env.getAD_Org_ID(getCtx());
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if (name.equals("C_BPartner_ID"))
				C_BPartner_ID = para[i].getParameterAsInt();
			else if (name.equals("DateAcct")) 
				dateAcct = para[i].getParameterAsTimestamp();			
			else if (name.equals("DebitAmt")) 
				DebitAmt = para[i].getParameterAsBigDecimal();
			else if (name.equals("CreditAmt")) 
				CreditAmt = para[i].getParameterAsBigDecimal();
			else if (name.equals("IsReversePrevOpeningBalance"))
				IsReversePrevOpeningBalance = para[i].getParameterAsString().equals("Y");
			else if (name.equals("C_ElementValue_ID"))
				C_ElementValue_ID = para[i].getParameterAsInt();
			else if (name.equals("Cust_C_DocTypeTarget_ID"))
				Cust_C_DocTypeTarget_ID = para[i].getParameterAsInt();
			else if (name.equals("Vendor_C_DocTypeTarget_ID"))
				Vendor_C_DocTypeTarget_ID = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}

	}

	/* (non-Javadoc)
	 * @see org.compiere.process.SvrProcess#doIt()
	 */
	@Override
	protected String doIt() throws Exception {
		int m_C_DocTypeTarget_ID = 0;
		MBPartner bp = new MBPartner(getCtx(), C_BPartner_ID, get_TrxName());
		int C_Invoice_ID = bp.get_ValueAsInt("C_Invoice_ID");
				
		if(C_Invoice_ID > 0 && !IsReversePrevOpeningBalance)
			throw new AdempiereException("Please select [Reverse Prev. Opening Balance]");		
		else if (C_Invoice_ID == 0 || (C_Invoice_ID > 0 && IsReversePrevOpeningBalance)) {
			
			if(IsReversePrevOpeningBalance) {
				TF_MInvoice prevInv = new TF_MInvoice(getCtx(), C_Invoice_ID, get_TrxName());
				if (!prevInv.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + prevInv.getProcessMsg());
				prevInv.saveEx();
								
			}
			
			boolean isSOTrx;			
			if(DebitAmt.doubleValue()!=0) {
				m_C_DocTypeTarget_ID = Cust_C_DocTypeTarget_ID;
				isSOTrx = true;
			}				
			else {
				m_C_DocTypeTarget_ID = Vendor_C_DocTypeTarget_ID;
				isSOTrx = false;
			}
			
			//Invoice Header
			TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
			invoice.setClientOrg(m_AD_Client_ID, m_AD_Org_ID);
			invoice.setC_DocTypeTarget_ID(m_C_DocTypeTarget_ID);			
			invoice.setDateInvoiced(dateAcct);
			invoice.setDateAcct(dateAcct);
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
			invoice.setDescription("Opening Balance Entry");
			invoice.saveEx();
			//End Invoice Header
			
			//Invoice Line
			MInvoiceLine invLine = new MInvoiceLine(invoice);
			TF_MCharge chrg = TF_MCharge.createChargeFromAccount(getCtx(), C_ElementValue_ID, null);
			invLine.setC_Charge_ID(chrg.getC_Charge_ID());
			invLine.setDescription("Opening Balance Entry");
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
			
			DB.executeUpdate("UPDATE C_BPartner SET C_Invoice_ID=" + invoice.getC_Invoice_ID() + " WHERE C_BPartner_ID ="
					+ bp.getC_BPartner_ID(), get_TrxName());				
			
			return "Opening Balance has been set!";			
		}
		return null;
	}

}
