package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MBPartner;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalLine;
import org.compiere.model.MPeriod;
import org.compiere.model.MPriceList;
import org.compiere.model.MResource;
import org.compiere.model.MSysConfig;
import org.compiere.process.DocAction;
import org.compiere.util.Env;

public class MVehicleRent extends X_TF_Vehicle_Rent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4964964952091340862L;

	public MVehicleRent(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MVehicleRent(Properties ctx, int TF_Vehicle_Rent_ID, String trxName) {
		super(ctx, TF_Vehicle_Rent_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	public void processIt(String DocAction) {
		if(MBoulderReceipt.DOCACTION_Prepare.equals(DocAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(MBoulderReceipt.DOCACTION_Complete.equals(DocAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			MRentedVehicle vehicle = new MRentedVehicle(getCtx(), getVehicle_ID(), get_TrxName());
			MBPartner bp = new MBPartner(getCtx(), vehicle.getC_BPartner_ID(), get_TrxName());
			if(isSOTrx()) {
				bp = new MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
			}
			//Invoice Header
			TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
			invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
			if(isSOTrx()) 
				invoice.setC_DocTypeTarget_ID(MGLPostingConfig.getMGLPostingConfig(getCtx()).getDefaultSalesInvoiceDocType_ID());
			else
				invoice.setC_DocTypeTarget_ID(MGLPostingConfig.getMGLPostingConfig(getCtx()).getTransporterInvoiceDocType_ID());
			
			invoice.setDateInvoiced(getDateAcct());
			invoice.setDateAcct(getDateAcct());
			//
			invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
			//
			invoice.setBPartner(bp);
			invoice.setIsSOTrx(isSOTrx());		
			invoice.setDescription(getDescription());
			
			//Price List
			int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
			if(!isSOTrx() && bp.getPO_PriceList_ID() > 0)
				m_M_PriceList_ID = bp.getPO_PriceList_ID();
			else
				m_M_PriceList_ID = bp.getM_PriceList_ID();			
			invoice.setM_PriceList_ID(m_M_PriceList_ID);
			invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
			
			//Financial Dimension - Profit Center
			invoice.setC_Project_ID(getC_Project_ID());
			
			invoice.saveEx();
			//End Invoice Header
			
			//Invoice Line - Vehicle Rental Charge
			MInvoiceLine invLine = new MInvoiceLine(invoice);
			invLine.setM_Product_ID(vehicle.getM_Product_ID(), true);
			invLine.setC_UOM_ID(getC_UOM_ID());
			invLine.setQty(getQty());			
			invLine.setPriceActual(getPrice());
			invLine.setPriceList(getPrice());
			invLine.setPriceLimit(getPrice());
			invLine.setPriceEntered(getPrice());			
			invLine.saveEx();
			
			//DocAction
			if (!invoice.processIt(DocAction))
				throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
			invoice.saveEx();
			//End DocAction
			
			setC_Invoice_ID(invoice.getC_Invoice_ID());
		}
	}
	
	public void reverseIt() {
		if(getC_Invoice_ID() > 0 ) {
			TF_MInvoice inv = new TF_MInvoice(getCtx(), getC_Invoice_ID(), get_TrxName());
			if(inv.getDocStatus().equals(DocAction.ACTION_Complete))
				inv.reverseCorrectIt();
			inv.saveEx();
			setC_Invoice_ID(0);
		}
		setDocStatus(DOCSTATUS_InProgress);
		setProcessed(false);
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		
		return super.beforeSave(newRecord);
	}
	
}
