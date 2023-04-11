package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MInvoice;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MJobworkResourceRentEntry;
import org.syvasoft.tallyfrontcrusher.model.MSubcontractType;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CalloutInvoice_Subcontract implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		int M_Project_ID = 0;
		if(mTab.getValue(MInvoice.COLUMNNAME_C_Project_ID) != null) {
			M_Project_ID = (int) mTab.getValue(MInvoice.COLUMNNAME_C_Project_ID);
			TF_MProject proj = new TF_MProject(ctx, M_Project_ID, null);			
			mTab.setValue(MInvoice.COLUMNNAME_C_BPartner_ID, proj.getC_BPartner_ID());
			mTab.setValue("SubcontractType", proj.getSubcontractType());
		}
		else {
			mTab.setValue("SubcontractType", null);
		}
		return null;
	}

}
