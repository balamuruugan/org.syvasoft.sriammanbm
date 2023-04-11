package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CalloutBoulderReceipt_Warehouse implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int warehoulse_id = 0;
		if(mTab.getValue(MBoulderReceipt.COLUMNNAME_M_Warehouse_ID) != null) {
			warehoulse_id = (int) mTab.getValue(MBoulderReceipt.COLUMNNAME_M_Warehouse_ID);
		}
		TF_MProject proj = new Query(ctx, TF_MProject.Table_Name, "M_Warehouse_ID=? AND DocStatus='IP'", null)
				.setParameters(warehoulse_id).first();
		//if(proj != null)
		//	mTab.setValue(MBoulderReceipt.COLUMNNAME_TF_Send_To, MBoulderReceipt.TF_SEND_TO_SubcontractProduction);
		return null;
	}

}
