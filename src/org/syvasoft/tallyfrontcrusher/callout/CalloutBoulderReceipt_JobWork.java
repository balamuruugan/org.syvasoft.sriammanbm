package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CalloutBoulderReceipt_JobWork implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		
		//1. Fill Subcontractor
		//2. Fill Jobwork Standard price
		int C_BPartner_ID = 0;
		BigDecimal stdPrice = BigDecimal.ZERO;
		int jobwork_id = 0;
		int c_uom_id = 0;
		int tf_quarry_id = 0;
		int warehouse_id = 0;
		
		if(value != null) {
			int C_Project_ID = (int) value;
			TF_MProject jobwork = new TF_MProject(ctx, C_Project_ID, null);
			stdPrice = jobwork.getUnit_Price();
			C_BPartner_ID = jobwork.getC_BPartner_ID();
			jobwork_id = jobwork.getJobWork_Product_ID();
			c_uom_id = jobwork.getC_UOM_ID();
			tf_quarry_id = jobwork.getTF_Quarry_ID();
			warehouse_id = jobwork.getM_Warehouse_ID();
		}
		
		mTab.setValue(MBoulderReceipt.COLUMNNAME_Subcontractor_ID, C_BPartner_ID == 0 ? null: C_BPartner_ID);
		mTab.setValue(MBoulderReceipt.COLUMNNAME_Jobwork_StdPrice, stdPrice);
		mTab.setValue(MBoulderReceipt.COLUMNNAME_JobWork_Product_ID, jobwork_id==0? null: jobwork_id);
		mTab.setValue(MBoulderReceipt.COLUMNNAME_C_UOM_ID, c_uom_id);
		mTab.setValue(MBoulderReceipt.COLUMNNAME_TF_Quarry_ID, tf_quarry_id);
		mTab.setValue(MBoulderReceipt.COLUMNNAME_M_Warehouse_ID, warehouse_id);
		
		return null;
	}

}
