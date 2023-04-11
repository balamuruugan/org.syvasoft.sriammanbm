package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MClient;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPriceList;
import org.compiere.model.MProduction;
import org.compiere.model.MProductionLine;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.Env;

public class MCrusherProduction extends X_TF_Crusher_Production {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3035302864622713550L;

	public MCrusherProduction(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCrusherProduction(Properties ctx, int TF_Crusher_Production_ID,	String trxName) {
		super(ctx, TF_Crusher_Production_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public List<MProduction> getProductions() {
		String where = " TF_Crusher_Production_ID = ?";
		List<MProduction> productions = new Query(getCtx(), MProduction.Table_Name, where, get_TrxName())
		.setClient_ID().setParameters(getTF_Crusher_Production_ID()).list();
		return productions;
	}
	
	public void deleteProductions() {		
		List<MProduction> productions = getProductions();
		for(MProduction prod : productions) {
			prod.deleteLines(get_TrxName());
			prod.deleteEx(true);
		}
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			TF_MProject proj = TF_MProject.getCrusherProductionSubcontractByWarehouse(getM_Warehouse_ID());
			if(proj != null) {
				setC_Project_ID(proj.getC_Project_ID());
			}
			MWarehouse wh = MWarehouse.get(getCtx(), getM_Warehouse_ID());
			setM_Locator_ID(wh.getDefaultLocator().get_ID());
		}
		
		return super.beforeSave(newRecord);
	}
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {		
		//if(newRecord || is_ValueChanged(COLUMNNAME_TF_BlueMetal_Type) || is_ValueChanged(COLUMNNAME_QtyUsed)) {
		//	createProduction(true);
		//}		
		return super.afterSave(newRecord, success);
	}

	public void createProduction(boolean reCreate){
		if(!reCreate && getIsCreated().equals("Y"))
			return;
		
		// Delete if there is any productions...
		deleteProductions();
		//RM - Raw Material, BM - Blue Metal
		double RMQtyUsed = getQtyUsed().doubleValue();		
		MCrusherProductionConfig[] configs = MCrusherProductionConfig.getMCrusherProductionConfig(getCtx(),
				getAD_Org_ID(),
				getTF_ProductionPlant_ID(),
				getTF_BlueMetal_Type(),
				getRM_Product_ID());
		//Creating Production Headers
		for(MCrusherProductionConfig config : configs) {
			double BMPercent = config.getPercent().doubleValue();			
			double BMUnitDivisor = config.getUnit_Divisor().doubleValue();
			double RMQtyUsedPerBlueMetal = RMQtyUsed * BMPercent / 100;
			double BMProductionQtyInUnit = RMQtyUsedPerBlueMetal / BMUnitDivisor;
			
			// Production Header
			MProduction prod = new MProduction(getCtx(), 0, get_TrxName());
			prod.setAD_Org_ID(getAD_Org_ID());
			prod.set_ValueOfColumn("TF_Crusher_Production_ID", getTF_Crusher_Production_ID());
			prod.setMovementDate(getMovementDate());
			prod.set_ValueOfColumn("ProductionType", "P+");
			prod.setM_Product_ID(config.getM_Product_ID());
			prod.setM_Locator_ID(getM_Locator_ID());
			prod.setProductionQty(new BigDecimal(BMProductionQtyInUnit).setScale(3, BigDecimal.ROUND_CEILING));
			prod.setIsCreated("Y");
			prod.set_ValueOfColumn("RM_Product_ID", getRM_Product_ID());
			prod.set_ValueOfColumn("QtyUsed", new BigDecimal(RMQtyUsedPerBlueMetal));
			prod.setDocStatus(MProduction.DOCSTATUS_Drafted);
			prod.saveEx();
			
			//Create End Product Production Line
			MProductionLine  line = new MProductionLine(prod);
			line.setLine(10);
			line.setM_Product_ID(config.getM_Product_ID());
			line.setM_Locator_ID(getM_Locator_ID());
			//line.setQtyUsed(prod.getProductionQty());
			line.setMovementQty(prod.getProductionQty());
			line.setPlannedQty(prod.getProductionQty());			
			line.saveEx();
			
			//Create Raw material (Boulder) Production Line
			MProductionLine  bomLine = new MProductionLine(prod);
			bomLine.setLine(20);
			bomLine.setM_Product_ID(config.getRM_Product_ID());
			bomLine.setM_Locator_ID(getM_Locator_ID());
			bomLine.setQtyUsed(new BigDecimal(RMQtyUsedPerBlueMetal));			
			bomLine.setMovementQty(new BigDecimal(RMQtyUsedPerBlueMetal));
			bomLine.setPlannedQty(bomLine.getQtyUsed());			
			bomLine.saveEx();
			
		}		
		setIsCreated("Y");		
	}
	
	public void createProductionBySales(int M_Product_ID){
				
		// Delete if there is any productions...
		//deleteProductions();
		//RM - Raw Material, BM - Blue Metal
		double RMQtyUsed = getQtyUsed().doubleValue();		
		MCrusherProductionConfig config = MCrusherProductionConfig.getMCrusherProductionConfig(getCtx(), getAD_Org_ID(), getTF_BlueMetal_Type(), M_Product_ID)[0];
		//Creating Production Headers		
			double BMPercent = config.getPercent().doubleValue();			
			double BMUnitDivisor = config.getUnit_Divisor().doubleValue();
			double RMQtyUsedPerBlueMetal = RMQtyUsed * BMPercent / 100;
			double BMProductionQtyInUnit = RMQtyUsedPerBlueMetal / BMUnitDivisor;
			
			// Production Header
			MProduction prod = new MProduction(getCtx(), 0, get_TrxName());
			prod.setAD_Org_ID(getAD_Org_ID());
			prod.set_ValueOfColumn("TF_Crusher_Production_ID", getTF_Crusher_Production_ID());
			prod.setMovementDate(getMovementDate());
			prod.set_ValueOfColumn("ProductionType", "P+");
			prod.setM_Product_ID(config.getM_Product_ID());
			prod.setM_Locator_ID(getM_Locator_ID());
			prod.setProductionQty(new BigDecimal(BMProductionQtyInUnit).setScale(3, BigDecimal.ROUND_CEILING));
			prod.setIsCreated("Y");
			prod.set_ValueOfColumn("RM_Product_ID", getRM_Product_ID());
			prod.set_ValueOfColumn("QtyUsed", new BigDecimal(RMQtyUsedPerBlueMetal));
			prod.setDocStatus(MProduction.DOCSTATUS_Drafted);
			prod.saveEx();
			
			//Create End Product Production Line
			MProductionLine  line = new MProductionLine(prod);
			line.setLine(10);
			line.setM_Product_ID(config.getM_Product_ID());
			line.setM_Locator_ID(getM_Locator_ID());
			//line.setQtyUsed(prod.getProductionQty());
			line.setMovementQty(prod.getProductionQty());
			line.setPlannedQty(prod.getProductionQty());			
			line.saveEx();
			
			//Create Raw material (Boulder) Production Line
			MProductionLine  bomLine = new MProductionLine(prod);
			bomLine.setLine(20);
			bomLine.setM_Product_ID(config.getRM_Product_ID());
			bomLine.setM_Locator_ID(getM_Locator_ID());
			bomLine.setQtyUsed(new BigDecimal(RMQtyUsedPerBlueMetal));			
			bomLine.setMovementQty(new BigDecimal(RMQtyUsedPerBlueMetal));
			bomLine.setPlannedQty(bomLine.getQtyUsed());			
			bomLine.saveEx();
	
		setIsCreated("Y");		
	}
	
	
	public String validateCrusherProduction() {		
		if(getProductions().size() == 0)
			return "Create Production lines!";
		
		return null;
			
	}
	
	public void createSubcontractInvoice() {
		if(getC_Project_ID() == 0)
			return;
		
		TF_MProject proj = new TF_MProject(getCtx(), getC_Project_ID(), get_TrxName());
		if(proj.isRequiredConsolidateInv())
			return;
				
		
		int invoiceItem_id = 0;
		int priceItem_id = 0;
		String priceItemName = null;
				
		
		invoiceItem_id = proj.getJobWork_Product_ID();
						
		priceItem_id = proj.getJobWork_Product_ID();
		priceItemName = proj.getJobWork_Product().getName();
		
		//Crusher Production Subcontract Purchase		
		BigDecimal purchasePrice = MJobworkProductPrice.getPrice(getCtx(), getC_Project_ID(), priceItem_id, getMovementDate()) ;
		if(purchasePrice == null) 
			throw new AdempiereException("Please setup Contract Price for " + priceItemName + "!");
		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), proj.getC_BPartner_ID(), get_TrxName());
		
		//Purchase Invoice Header
		MGLPostingConfig config = MGLPostingConfig.getMGLPostingConfig(getCtx());
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(config.getTransporterInvoiceDocType_ID());	// AP Invoice		
		invoice.setDateInvoiced(getMovementDate());
		invoice.setDateAcct(getMovementDate());
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
		//
		
		invoice.setBPartner(bp);
		invoice.setIsSOTrx(false);		
		
		
		String desc = "Crusher Production : " + getDocumentNo();
		if(getTF_WeighmentEntry_ID() > 0 ) {
			desc = desc + " | Ticket No: " + getTF_WeighmentEntry().getDocumentNo();
			invoice.setVehicleNo(getTF_WeighmentEntry().getVehicleNo());
		}
		invoice.setDescription(desc);
		
		//Price List
		int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
		if(bp.getPO_PriceList_ID() > 0)
			m_M_PriceList_ID = bp.getPO_PriceList_ID();
		if(m_M_PriceList_ID == 0) {
			MPriceList pl = new Query(getCtx(), MPriceList.Table_Name, "IsDefault='Y' AND IsActive='Y'", get_TrxName())
					.setClient_ID().first();
			if(pl != null)
				m_M_PriceList_ID = pl.getM_PriceList_ID();
		}
		invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		if(invoice.getC_Currency_ID() == 0)
			invoice.setC_Currency_ID(MClient.get(Env.getCtx()).getC_Currency_ID());
		
				
		invoice.saveEx();
		//End Invoice Header
		
		//Invoice Line - Vehicle Rental Charge
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		invLine.setM_Product_ID(invoiceItem_id , true);				
		
		invLine.setQty(getQtyUsed());
		invLine.setDescription(getDescription());
		
		invLine.setPriceActual(purchasePrice);
		invLine.setPriceList(purchasePrice);
		invLine.setPriceLimit(purchasePrice);
		invLine.setPriceEntered(purchasePrice);
		
		invLine.setC_Tax_ID(1000000);
		invLine.saveEx();
		
		//Invoice DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		setSubcon_Invoice_ID(invoice.getC_Invoice_ID());
		
		if(proj.getC_BPartnerSubcon2_ID() > 0) {
			CreateSubcontract2Invoice(proj.getC_BPartnerSubcon2_ID(), proj.getM_ProductSubcon2_ID(), proj.getPriceSubcon2());
		}
	}
	
	public void CreateSubcontract2Invoice(int C_BPartnerSubcon2_ID, int M_ProductSubcon2_ID, BigDecimal priceSubcon2) {
		if(M_ProductSubcon2_ID == 0)
			throw new AdempiereException("Please specify Product (Subcontract 2) in " + getC_Project().getName() +
					" Subcontract to Create Subcontract 2 Invoice!");
		
		if(priceSubcon2 == null || priceSubcon2.doubleValue() == 0)
			throw new AdempiereException("Please specify Contract Price (Subcontract 2) in " + getC_Project().getName() +
					" Subcontract to Create Subcontract 2 Invoice!");
		
		int invoiceItem_id = M_ProductSubcon2_ID;
		
		//Crusher Production Subcontract Purchase		
		BigDecimal purchasePrice = priceSubcon2;		
		
		TF_MBPartner bp = new TF_MBPartner(getCtx(), C_BPartnerSubcon2_ID, get_TrxName());
		
		//Purchase Invoice Header
		MGLPostingConfig config = MGLPostingConfig.getMGLPostingConfig(getCtx());
		TF_MInvoice invoice = new TF_MInvoice(getCtx(), 0, get_TrxName());
		invoice.setClientOrg(getAD_Client_ID(), getAD_Org_ID());
		invoice.setC_DocTypeTarget_ID(config.getTransporterInvoiceDocType_ID());	// AP Invoice		
		invoice.setDateInvoiced(getMovementDate());
		invoice.setDateAcct(getMovementDate());
		//
		invoice.setSalesRep_ID(Env.getAD_User_ID(getCtx()));
		//
		
		invoice.setBPartner(bp);
		invoice.setIsSOTrx(false);		
		
		
		String desc = "Crusher Production : " + getDocumentNo();
		if(getTF_WeighmentEntry_ID() > 0 ) {
			desc = desc + " | Ticket No: " + getTF_WeighmentEntry().getDocumentNo();			
			invoice.setVehicleNo(getTF_WeighmentEntry().getVehicleNo());
		}
		invoice.setDescription(desc);
		
		//Price List
		int m_M_PriceList_ID = Env.getContextAsInt(getCtx(), "#M_PriceList_ID");
		if(bp.getPO_PriceList_ID() > 0)
			m_M_PriceList_ID = bp.getPO_PriceList_ID();
		if(m_M_PriceList_ID == 0) {
			MPriceList pl = new Query(getCtx(), MPriceList.Table_Name, "IsDefault='Y' AND IsActive='Y'", get_TrxName())
					.setClient_ID().first();
			if(pl != null)
				m_M_PriceList_ID = pl.getM_PriceList_ID();
		}
		invoice.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
		if(invoice.getC_Currency_ID() == 0)
			invoice.setC_Currency_ID(MClient.get(Env.getCtx()).getC_Currency_ID());
		
				
		invoice.saveEx();
		//End Invoice Header
		
		//Invoice Line - Vehicle Rental Charge
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		invLine.setM_Product_ID(invoiceItem_id , true);				
		
		invLine.setQty(getQtyUsed());
		invLine.setDescription(getDescription());
		
		invLine.setPriceActual(purchasePrice);
		invLine.setPriceList(purchasePrice);
		invLine.setPriceLimit(purchasePrice);
		invLine.setPriceEntered(purchasePrice);
		
		invLine.setC_Tax_ID(1000000);
		invLine.saveEx();
		
		//Invoice DocAction
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		invoice.saveEx();
		setSubcon2_Invoice_ID(invoice.getC_Invoice_ID());
	}
	
	public String processIt(String DocAction) {
		String m_processMsg = validateCrusherProduction();
		
		if(m_processMsg != null)
			return m_processMsg;
		
		if(MProduction.DOCACTION_Prepare.equals(DocAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(MProduction.DOCACTION_Complete.equals(DocAction)) {
			List<MProduction> productions = getProductions();
			
			for(MProduction prod : productions) {
				boolean result = prod.processIt(DocAction);
				prod.saveEx();
				if(!result) {
					m_processMsg = " Not able to Complete the Production! ";
					break;
				}
			}			
			createSubcontractInvoice();
			
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
		}
		return m_processMsg;
	}
	
	public void reverseIt() {
		if(isProcessed() && getDocStatus().equals(DOCSTATUS_Completed)) {
			List<MProduction> productions = getProductions();			
			for(MProduction prod : productions) {
				prod.reverseCorrectIt();
				prod.saveEx();
			}
			setDocStatus(DOCSTATUS_Reversed);
			if(getSubcon2_Invoice_ID()>0) {			
				//throw new AdempiereException("You cannot modify this entry before Reverse Correct Subcontractor Invoice!");
				TF_MInvoice inv = new TF_MInvoice(getCtx(), getSubcon2_Invoice_ID(), get_TrxName());
				if(inv.getDocStatus().equals(DOCSTATUS_Completed))
					inv.reverseCorrectIt();
				inv.saveEx();
				setSubcon2_Invoice_ID(0);
			}		
			if(getSubcon_Invoice_ID()>0) {			
				//throw new AdempiereException("You cannot modify this entry before Reverse Correct Subcontractor Invoice!");
				TF_MInvoice inv = new TF_MInvoice(getCtx(), getSubcon_Invoice_ID(), get_TrxName());
				if(inv.getDocStatus().equals(DOCSTATUS_Completed))
					inv.reverseCorrectIt();
				inv.saveEx();				
				setSubcon_Invoice_ID(0);							
			}		
			
		}
	}
}
