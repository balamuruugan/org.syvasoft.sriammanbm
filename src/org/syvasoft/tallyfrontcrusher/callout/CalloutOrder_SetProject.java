package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MJobworkAssignedBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CalloutOrder_SetProject implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		//if(mTab.getValue(TF_MOrder.COLUMNNAME_C_Project_ID) != null)			
		//	return null;
		if(value != null)
		{
			int AD_Org_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_AD_Org_ID);
			int C_Project_ID = 0;
			if(mField.getColumnName().equals(TF_MOrder.COLUMNNAME_C_BPartner_ID)) {
				int C_BPartner_ID = 0;			
				if(mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID) != null)
					C_BPartner_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID);
				MJobworkAssignedBPartner jwBP = MJobworkAssignedBPartner.getJobwork(AD_Org_ID, C_BPartner_ID);
				if(jwBP != null)
					C_Project_ID = jwBP.getC_Project_ID();
			}
					
			if(C_Project_ID > 0)
				mTab.setValue(TF_MOrder.COLUMNNAME_C_Project_ID, C_Project_ID);
			else
				mTab.setValue(TF_MOrder.COLUMNNAME_C_Project_ID, null);
		}
		return null;
	}

}
