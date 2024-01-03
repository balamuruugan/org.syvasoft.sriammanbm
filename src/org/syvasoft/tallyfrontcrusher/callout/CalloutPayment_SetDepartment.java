package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBPartner;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MMachinery;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutPayment_SetDepartment implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		if(value != null) {
			int machineryID = (int) value;
			MMachinery m = new MMachinery(ctx, machineryID, null);
			if(m.getUser1_ID() > 0)
				mTab.setValue(TF_MInvoice.COLUMNNAME_User1_ID, m.getUser1_ID());
			else
				mTab.setValue(TF_MInvoice.COLUMNNAME_User1_ID, null);
		}
		return null;
	}

}
