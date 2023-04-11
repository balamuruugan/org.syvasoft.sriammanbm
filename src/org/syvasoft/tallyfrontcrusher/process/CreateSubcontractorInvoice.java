package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MProductPricing;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MQuarry;

public class CreateSubcontractorInvoice extends SvrProcess {
	
	private int m_AD_Client_ID = 0;
	private int m_AD_Org_ID = 0;
	private boolean isSimulate = false;
	private int m_C_BPartner_ID = 0;
	private int m_M_Product_ID = 0;
	private int m_M_PriceList_ID = 0;
	private Timestamp m_DateInvoiced = null;
	private Timestamp m_DateReceipt_1 = null;
	private Timestamp m_DateReceipt_2 = null;
	private String m_DocAction = "PR";
	private int m_C_DocTypeTarget_ID = 0;
	private int m_TF_Quarry_ID = 0;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		m_AD_Client_ID = Env.getAD_Client_ID(getCtx());
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();			
			if (name.equals("AD_Org_ID"))				
				m_AD_Org_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("TF_Quarry_ID"))
				m_TF_Quarry_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("C_BPartner_ID"))
				m_C_BPartner_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("M_Product_ID"))
				m_M_Product_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("M_PriceList_ID"))
				m_M_PriceList_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("DocAction"))
				m_DocAction = para[i].getParameterAsString();
			else if (name.equals("IsSimulate"))
				isSimulate = para[i].getParameterAsBoolean();
			else if (name.equals("C_DocTypeTarget_ID")) 
				m_C_DocTypeTarget_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("DateInvoiced")) 
				m_DateInvoiced = para[i].getParameterAsTimestamp();
			else if (name.equals("DateReceipt")) {
				m_DateReceipt_1 = para[i].getParameterAsTimestamp();
				m_DateReceipt_2 = para[i].getParameter_ToAsTimestamp();
			}
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}

	}

	@Override
	protected String doIt() throws Exception {
		//Get Total QtyReceived between DateRange.
		String whereClause = " AD_Org_ID = ? AND TF_Quarry_ID = ? AND Subcontractor_ID=? " + 
				" AND DateReceipt >=? AND DateReceipt <=?  AND DocStatus='CO' AND Processed='Y' AND Subcon_Invoice_ID IS NULL " ;
		String sql = "SELECT SUM(QtyReceived) FROM TF_Boulder_Receipt WHERE " + whereClause; 
		BigDecimal QtyReceived = DB.getSQLValueBD(get_TrxName(), sql, m_AD_Org_ID, m_TF_Quarry_ID, m_C_BPartner_ID, m_DateReceipt_1, m_DateReceipt_2);
		if(QtyReceived == null)
			QtyReceived = BigDecimal.ZERO;
		//End Total QtyReceived
		
		//Get Unit Price from Latest Price List.
		sql = "SELECT plv.M_PriceList_Version_ID "
				+ "FROM M_PriceList_Version plv "
				+ "WHERE plv.M_PriceList_ID=? "	
				+ " AND plv.ValidFrom <= ? "
				+ "ORDER BY plv.ValidFrom DESC";
		
		int M_PriceList_Version_ID = DB.getSQLValueEx(null, sql, m_M_PriceList_ID, m_DateInvoiced);
		MProductPricing pp = new MProductPricing (m_M_Product_ID, m_C_BPartner_ID, QtyReceived, false);
		pp.setM_PriceList_Version_ID(M_PriceList_Version_ID);
		pp.setPriceDate(m_DateInvoiced);
		
		BigDecimal priceStd = pp.getPriceStd();
		if(priceStd == null)
			priceStd = BigDecimal.ZERO;
		//End Price
		
		
		addLog("Total Boulder Production Qty :  "  + QtyReceived.toString());
		addLog("Boulder Production Unit Price :  "  + priceStd.toString());
		addLog("Invoice Amount :  "  + priceStd.multiply(QtyReceived).toString());
				
		
		//Create AP Invoice.
		if(!isSimulate){
			
			if(priceStd.multiply(QtyReceived).intValue() ==0) {
				return "Could not create Subcontractor Invoice --> Invalid Invoice Amount"; 
			}
			
			MBPartner bp = new MBPartner(getCtx(), m_C_BPartner_ID, get_TrxName());
			MQuarry quarry = new MQuarry(getCtx(), m_TF_Quarry_ID, get_TrxName());
			
			//Invoice Header
			MInvoice invoice = new MInvoice(getCtx(), 0, get_TrxName());
			invoice.setClientOrg(m_AD_Client_ID, m_AD_Org_ID);
			invoice.setC_DocTypeTarget_ID(m_C_DocTypeTarget_ID);			
			invoice.setDateInvoiced(m_DateInvoiced);
			invoice.setDateAcct(m_DateInvoiced);
			//
			invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
			//
			invoice.setBPartner(bp);
			invoice.setIsSOTrx(false);
			invoice.setC_Currency_ID(pp.getC_Currency_ID());
			invoice.setM_PriceList_ID(m_M_PriceList_ID);
			
			//Financial Dimension - Profit Center
			invoice.setUser1_ID(quarry.getC_ElementValue_ID());
			invoice.saveEx();
			//End Invoice Header
			
			//Invoice Line
			MInvoiceLine invLine = new MInvoiceLine(invoice);
			invLine.setM_Product_ID(m_M_Product_ID, true);
			invLine.setQty(QtyReceived.intValue());
			invLine.saveEx();
			//End Invoice Line
			
			//Update back Invoice ID to Boulder Receipts.
			sql = " Update TF_Boulder_Receipt SET Subcon_Invoice_ID = ? WHERE " + whereClause;
			ArrayList<Object> params = new ArrayList<Object>();
			params.add(invoice.getC_Invoice_ID());
			params.add(m_AD_Org_ID);
			params.add(m_TF_Quarry_ID);
			params.add(m_C_BPartner_ID);
			params.add(m_DateReceipt_1);
			params.add(m_DateReceipt_2);			
			DB.executeUpdateEx(sql, params.toArray(), get_TrxName());
			//End Update
			
			
			//DocAction
			if (!invoice.processIt(m_DocAction))
				throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
			invoice.saveEx();
			//End DocAction
						
			
			addLog(0, null, null, "Invoice No : " + invoice.getDocumentNo() , MInvoice.Table_ID,invoice.getC_Invoice_ID());
			
		}		
		
		
		return null;
	}

}
