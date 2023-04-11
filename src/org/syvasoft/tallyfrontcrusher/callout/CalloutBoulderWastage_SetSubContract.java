package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastage;
import org.syvasoft.tallyfrontcrusher.model.MSubcontractType;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;
import org.syvasoft.tallyfrontcrusher.process.GenerateTaxInvoiceLines;

public class CalloutBoulderWastage_SetSubContract implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int bpartner_id = 0;
		int warehouse_id = 0;
		if(mTab.getValue(MBoulderWastage.COLUMNNAME_Subcontractor_ID) != null && mTab.getValue(MBoulderWastage.COLUMNNAME_M_Warehouse_ID) != null) {
			bpartner_id = (int) mTab.getValue(MBoulderWastage.COLUMNNAME_Subcontractor_ID);
			warehouse_id = (int) mTab.getValue(MBoulderWastage.COLUMNNAME_M_Warehouse_ID);
			
			TF_MProject proj = new Query(ctx, TF_MProject.Table_Name, "C_BPartner_ID =? AND DocStatus='IP'", null)
					.setParameters(bpartner_id).first();
			
			if(proj != null) {
				MSubcontractType subcontType = new MSubcontractType(ctx, proj.getTF_SubcontractType_ID(), null);
				
				if(subcontType.getSubcontractType().equals(MSubcontractType.SUBCONTRACTTYPE_QuarryProducton)) {
					mTab.setValue(MBoulderWastage.COLUMNNAME_Quarry_Project_ID, proj.getC_Project_ID());
					
					TF_MProject crushproj = TF_MProject.getCrusherProductionSubcontractByWarehouse(warehouse_id);
					mTab.setValue(MBoulderWastage.COLUMNNAME_Crusher_Project_ID, crushproj.getC_Project_ID());
				}
				else if(subcontType.getSubcontractType().equals(MSubcontractType.SUBCONTRACTTYPE_CrusherProduction)) {
					mTab.setValue(MBoulderWastage.COLUMNNAME_Quarry_Project_ID, null);
					mTab.setValue(MBoulderWastage.COLUMNNAME_Crusher_Project_ID, proj.getC_Project_ID());
				}
				else {
					mTab.setValue(MBoulderWastage.COLUMNNAME_Quarry_Project_ID, null);
					mTab.setValue(MBoulderWastage.COLUMNNAME_Crusher_Project_ID, null);
				}
			}
			else {
				mTab.setValue(MBoulderWastage.COLUMNNAME_Quarry_Project_ID, null);
				mTab.setValue(MBoulderWastage.COLUMNNAME_Crusher_Project_ID, null);
			}
		}
		
		return null;
	}

}
