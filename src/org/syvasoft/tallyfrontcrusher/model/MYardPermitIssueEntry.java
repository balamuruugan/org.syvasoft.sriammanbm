package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.DocAction;
import org.compiere.util.DB;

public class MYardPermitIssueEntry extends X_TF_YardPermitIssue_Entry {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1244633259727671057L;

	public MYardPermitIssueEntry(Properties ctx, int TF_YardPermitIssue_Entry_ID, String trxName) {
		super(ctx, TF_YardPermitIssue_Entry_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MYardPermitIssueEntry(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
		MYardCustomerVehicle v = MYardCustomerVehicle.addCustomerVehicle(getCtx(), getAD_Org_ID(), getTF_VehicleType_ID(), getVehicleNo(), 
				getC_BPartner_ID(), get_TrxName());
		setTF_YardCustomerVehicle_ID(v.getTF_YardCustomerVehicle_ID());
		
		if(newRecord && getDocStatus().equals(DOCSTATUS_Completed) && 
				getPermitIssue_Type().equals(PERMITISSUE_TYPE_Issued)) {
			String sqlTime = "SELECT Created FROM TF_YardPermitIssue_Entry WHERE " +
					" DateAcct = ? AND TF_YardCustomerVehicle_ID = ?  ORDER BY Created Desc ";
			Timestamp prevTime = DB.getSQLValueTSEx(get_TrxName(), sqlTime, getDateAcct(), getTF_YardCustomerVehicle_ID());
			
			String sql = "SELECT (EXTRACT(EPOCH FROM now() - ?) / 60)::numeric ";			
			BigDecimal interval = DB.getSQLValueBD(get_TrxName(), sql, prevTime);
			
			if(interval == null) 
				interval = new BigDecimal(70);
			if(interval.doubleValue() <= 60 )
				throw new AdempiereException("Permit is already issued for Vehicle: " + v.getVehicleNo() + " !");
		}
		
		if(newRecord) {
			String sql = "SELECT COUNT(*) FROM TF_YardPermitIssue_Entry WHERE AD_Org_ID = ? AND TRIM(MDPNo) = TRIM(?)"
					+ " AND PermitIssue_Type = ?";
			int count = DB.getSQLValue(get_TrxName(), sql, getAD_Org_ID(), getMDPNo(), getPermitIssue_Type());
			if(count > 0) {
				String type = getPermitIssue_Type().equals(PERMITISSUE_TYPE_Issued) ? "issued" : "cancelled";
				throw new AdempiereException("MDPNo is already "+ type +". Please specify new MDP No!");
			}
		}
		
		
		
		if(!newRecord && is_ValueChanged(COLUMNNAME_TF_VehicleType_ID)) {
			v.setTF_VehicleType_ID(getTF_VehicleType_ID());
			v.saveEx();
		}
		
		if(!newRecord && is_ValueChanged(COLUMNNAME_C_BPartner_ID)) {
			v.setC_BPartner_ID(getC_BPartner_ID());
			v.saveEx();
		}
		
		if(getC_BPartner_ID() == 0)
			setC_BPartner_ID(v.getC_BPartner_ID());
				
		setTF_VehicleType_ID(v.getTF_VehicleType_ID());
		
		//if(getBucketPerLoad().doubleValue() == 0) {
		MYardLoadConfig config = MYardLoadConfig.getMYardLoadConfig(getAD_Org_ID(), getTF_VehicleType_ID());
		if(config == null)
			throw new AdempiereException("Please set Yard Load Configuration for the selected Vehicle Type!");
		setBucketQty(config.getBucketPerLoad());
		setTonnage(config.getSalesTonnagePerLoad());		
		
		if(getDescription() == null || getDescription().length() ==0 || !getDescription().contains("Bucket Qty")) {
			String desc = getMDPNo() + " | " + getTF_VehicleType().getName() + ": " + getTF_YardCustomerVehicle().getVehicleNo() +
					", Bucket Qty: " + getBucketQty() + ", Tonnage: " + getTonnage();
			if(getDescription() != null && getDescription().length() > 0)
				desc = desc + " | " + getDescription();
			setDescription(desc);
		}
		
		return super.beforeSave(newRecord);
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		boolean ok = super.afterSave(newRecord, success);
		if(newRecord && getDocStatus().equals(DOCSTATUS_Completed)) {
			processIt(DocAction.ACTION_Complete);
			String sql = "UPDATE " + Table_Name + " SET Processed='Y' WHERE " + COLUMNNAME_TF_YardPermitIssue_Entry_ID + " = " + getTF_YardPermitIssue_Entry_ID();
			DB.executeUpdate(sql, get_TrxName());
		}
		if(newRecord) {
			String sql = "SELECT COUNT(*) FROM TF_YardPermitIssue_Entry WHERE AD_Org_ID = ? AND DateAcct = ? AND TF_YardCustomerVehicle_ID = ?";
			int tripNo = DB.getSQLValue(get_TrxName(), sql, getAD_Org_ID(), getDateAcct(), getTF_YardCustomerVehicle_ID());
			String sqlUpdate = "UPDATE TF_YardPermitIssue_Entry SET TripNo = " + tripNo + " WHERE TF_YardPermitIssue_Entry_ID = " +
					getTF_YardPermitIssue_Entry_ID();
			DB.executeUpdate(sqlUpdate, get_TrxName());
		}
		return ok;
	}

	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
		}
	}
	
	public void reverseIt() {
		setProcessed(false);
		setDocStatus(DOCSTATUS_InProgress);	
	}
}
