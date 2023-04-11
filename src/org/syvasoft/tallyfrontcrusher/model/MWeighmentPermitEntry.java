package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.DB;

public class MWeighmentPermitEntry extends X_TF_Weighment_Permit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3838332495434521433L;

	public MWeighmentPermitEntry(Properties ctx, int TF_Weighment_Permit_ID, String trxName) {
		super(ctx, TF_Weighment_Permit_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MWeighmentPermitEntry(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		
		if(getC_BPartner_ID() == 0 && getPaymentRule().equals(PAYMENTRULE_Cash)) {
			TF_MBPartner bp = new Query(getCtx(), TF_MBPartner.Table_Name, "IsPOSCashBP='Y'", get_TrxName())
					.setClient_ID().first();
			if(bp != null)
				setC_BPartner_ID(bp.getC_BPartner_ID());
		}
		
		String sql = "SELECT TF_WeighmentEntry_ID FROM TF_WeighmentEntry WHERE DocumentNo = ?";
		int TF_WeighmentEntry_ID = DB.getSQLValue(get_TrxName(), sql, getActualDocumentNo());
		if(TF_WeighmentEntry_ID > 0) {
			setTF_WeighmentEntry_ID(TF_WeighmentEntry_ID);
		}
		else {
			sql = "SELECT TF_YardEntry_ID FROM TF_YardEntry WHERE DocumentNo= ?";
			int TF_YardEntry_ID = DB.getSQLValue(get_TrxName(), sql, getActualDocumentNo());
			if(TF_YardEntry_ID > 0) {
				setTF_YardEntry_ID(TF_YardEntry_ID);
			}
		}
					
		
		return super.beforeSave(newRecord);
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		if(newRecord && getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_Sales)
				&& getStatus().equals(STATUS_Unbilled)) {
			MTaxInvoice inv = new MTaxInvoice(getCtx(), 0, get_TrxName());
			inv.setAD_Org_ID(getAD_Org_ID());
			inv.setTF_Weighment_Permit_ID(getTF_Weighment_Permit_ID());
			inv.setDateAcct(getGrossWeightTime());
			inv.setC_BPartner_ID(getC_BPartner_ID());
			inv.setPartyName(getPartyName());
			inv.setM_Product_ID(getM_Product_ID());
			inv.setQty(getPermitIssuedQty());
			inv.setC_UOM_ID(inv.getM_Product().getC_UOM_ID());			
			inv.setPrice(getPrice());
			inv.setTaxableAmount(inv.getQty().multiply(inv.getPrice()));
			inv.setCGST_Rate(new BigDecimal(2.5));
			inv.setSGST_Rate(new BigDecimal(2.5));
			inv.setIGST_Rate(BigDecimal.ZERO);
			inv.setVehicleNo(getVehicleNo());
			
			BigDecimal amount = inv.getTaxableAmount();
			
			BigDecimal divisor = new BigDecimal(100);		
			BigDecimal cgstAmt = inv.getCGST_Rate().multiply(amount).divide(divisor);
			BigDecimal sgstAmt = inv.getSGST_Rate().multiply(amount).divide(divisor);
			BigDecimal igstAmt = inv.getIGST_Rate().multiply(amount).divide(divisor);
			
			inv.setSGST_Amt(sgstAmt);
			inv.setCGST_Amt(cgstAmt);
			inv.setIGST_Amt(igstAmt);
			inv.setRoundingOff(BigDecimal.ZERO);
			
			BigDecimal total = amount.add(cgstAmt).add(sgstAmt)
					.add(igstAmt).add(inv.getRoundingOff());
			inv.setGrandTotal(total);
			inv.setDestination(getTF_Destination().getName());
			inv.setMDPNo(getMDPNo());
			inv.setQtyPermitDeducted(getPermitIssuedQty());
			inv.setPostPermitAmtToCustomer(false);
			inv.setPostPermitAmtToCustomer(false);
			inv.setDescription(getDescription());
			inv.setDocStatus(inv.DOCSTATUS_Drafted);
			inv.saveEx();
			
			inv.processIt(DocAction.ACTION_Complete);
			inv.saveEx();
			
			String sql = "UPDATE TF_Weighment_Permit SET Status='" + STATUS_Billed + "', Processed='Y' "
					+ " WHERE TF_Weighment_Permit_ID = " + getTF_Weighment_Permit_ID();
			DB.executeUpdate(sql, get_TrxName());
			
		}
		return super.afterSave(newRecord, success);
	}

	public void reverseIt() {
		setProcessed(false);
		setStatus(STATUS_Unbilled);
	}
	
	public void closeIt() {
		setProcessed(true);
		setStatus(STATUS_Billed);
	}
	
}
