package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CalloutOrder_Warehouse implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int warehouseID = 0;
		int projectID = 0;
		if(mTab.getValue(TF_MOrder.COLUMNNAME_M_Warehouse_ID) != null)
			warehouseID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_M_Warehouse_ID);
		
		TF_MProject proj = TF_MProject.getCrusherProductionSubcontractByWarehouse(warehouseID);
		if(proj != null)
			projectID = proj.getC_Project_ID();
		if(projectID > 0)
			mTab.setValue(TF_MOrder.COLUMNNAME_C_Project_ID, projectID!=0?projectID:null);
		
		return null;
	}

}
