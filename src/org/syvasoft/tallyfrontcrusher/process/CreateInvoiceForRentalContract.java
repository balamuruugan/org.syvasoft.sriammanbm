package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBPartner;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPriceList;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MVehicleRentalContract;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;

public class CreateInvoiceForRentalContract extends SvrProcess {
	private int recordID = 0;
	private int m_AD_Client_ID = 0;
	private int m_AD_Org_ID = 0;
	private Timestamp m_DateInvoiced = null;
	private String m_DocAction = "PR";
	private int m_C_DocTypeTarget_ID = 0;
	private boolean updateQtyActual = false;
	
	@Override
	protected void prepare() {
		recordID = getRecord_ID();
		ProcessInfoParameter[] para = getParameter();
		m_AD_Client_ID = Env.getAD_Client_ID(getCtx());
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();			
			if (name.equals("AD_Org_ID"))				
				m_AD_Org_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("DateInvoiced")) 
				m_DateInvoiced = para[i].getParameterAsTimestamp();
			else if (name.equals("UpdateQtyActual"))
				updateQtyActual = para[i].getParameterAsString().equals("Y");
			else if (name.equals("DocAction"))
				m_DocAction = para[i].getParameterAsString();			
			else if (name.equals("C_DocTypeTarget_ID")) 
				m_C_DocTypeTarget_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
	}

	@Override
	protected String doIt() throws Exception {
		String msg = null;
		MVehicleRentalContract rc = new MVehicleRentalContract(getCtx(), recordID, get_TrxName());
		
		if(updateQtyActual && rc.getContractBase().equals(MVehicleRentalContract.CONTRACTBASE_Month)) {
			String sql = " SELECT (SELECT date_part ('year', f) * 12 + date_part ('month', f) FROM age (now(), TF_Vehicle_Rental_Contract.DateStart) f) " 
					+ " FROM TF_Vehicle_Rental_Contract WHERE TF_Vehicle_Rental_Contract_ID = ?";
			BigDecimal newQty = DB.getSQLValueBD(get_TrxName(), sql, recordID);
			if(newQty != null) 
				rc.setQty(newQty);
		}
		
		BigDecimal invQty = rc.getQty().subtract(rc.getQtyInvoiced());
		if(invQty.doubleValue() > 0) {
			BigDecimal fuelQtyDeducted = BigDecimal.ZERO;			
			if(rc.isFuelIncluded()) {
				fuelQtyDeducted = rc.getFuel_Issued_Total_Qty().subtract(rc.getFuel_Deducted_Qty());
			}
			
			MBPartner bp = new MBPartner(getCtx(), rc.getC_BPartner_ID(), get_TrxName());
			
			//Invoice Header
			TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
			invoice.setClientOrg(m_AD_Client_ID, m_AD_Org_ID);
			invoice.setC_DocTypeTarget_ID(m_C_DocTypeTarget_ID);			
			invoice.setDateInvoiced(m_DateInvoiced);
			invoice.setDateAcct(m_DateInvoiced);
			//
			invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
			//
			invoice.setBPartner(bp);
			invoice.setIsSOTrx(false);
			invoice.set_ValueOfColumn(MVehicleRentalContract.COLUMNNAME_TF_Vehicle_Rental_Contract_ID, rc.getTF_Vehicle_Rental_Contract_ID());
			
			//Price List
			int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
			if(bp.getPO_PriceList_ID() > 0)
				m_M_PriceList_ID = bp.getPO_PriceList_ID();			
			invoice.setM_PriceList_ID(m_M_PriceList_ID);
			invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
			
			//Financial Dimension - Profit Center
			invoice.setUser1_ID(rc.getC_ElementValue_ID());
			
			invoice.saveEx();
			//End Invoice Header
			
			//Invoice Line - Vehicle Rental Charge
			MInvoiceLine invLine = new MInvoiceLine(invoice);
			invLine.setM_Product_ID(rc.getM_Product_ID(), true);
			invLine.setQty(invQty);
			invLine.setDescription("Rental Charge");			
			invLine.setPriceActual(rc.getUnit_Price());
			invLine.setPriceList(rc.getUnit_Price());
			invLine.setPriceLimit(rc.getUnit_Price());
			invLine.setPriceEntered(rc.getUnit_Price());
			
			//Set UOM for Contract Base - Month 
			if(rc.getContractBase().equals(MVehicleRentalContract.CONTRACTBASE_Month)) {
				String sql = "SELECT C_UOM_ID FROM C_UOM WHERE ContractBase=? AND AD_Client_ID IN (0,?) AND IsActive='Y'";
				int uomID = DB.getSQLValue(null, sql, rc.getContractBase(),m_AD_Client_ID);
				invLine.setC_UOM_ID(uomID);
			}
			invLine.saveEx();
			//Add Qty Invoice to Rental Contract
			rc.setQtyInvoiced(rc.getQtyInvoiced().add(invQty));
			//End Invoice Line
			
			//Invoice Line - Deduct Fuel Charge
			if(fuelQtyDeducted.doubleValue() > 0) {				
				invLine = new MInvoiceLine(invoice);
				invLine.setC_Charge_ID(rc.getC_Charge_ID());
				invLine.setQty(fuelQtyDeducted.negate());				
				invLine.setPrice(rc.getFuel_Price());
				invLine.saveEx();
				//Add Fuel Deduction Amount & Qty to Rental Contract
				rc.setFuel_Deducted_Qty(rc.getFuel_Deducted_Qty().add(fuelQtyDeducted));
				rc.setFuel_Total_Cost(rc.getFuel_Total_Cost().add(fuelQtyDeducted.multiply(rc.getFuel_Price())));
			}//End Invoice Line
			
			//DocAction
			if (!invoice.processIt(m_DocAction))
				throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
			invoice.saveEx();
			//End DocAction
			
			//Update Rental Contract with Latest Invoice & Fuel Deduction details
			rc.saveEx();
			
			addLog(0, null, null, "Invoice No : " + invoice.getDocumentNo() , MInvoice.Table_ID,invoice.getC_Invoice_ID());
		}
		else {
			msg = "This rental contract is already invoiced completely!";
		}
		return msg;
	}

}
