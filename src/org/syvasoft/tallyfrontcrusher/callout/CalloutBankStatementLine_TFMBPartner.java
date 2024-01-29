package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MUser;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class CalloutBankStatementLine_TFMBPartner implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int bPartnerID = 0;		
		boolean isEmployee = false;
		
		if(mTab.getValue(TF_MPayment.COLUMNNAME_TF_BPartner_ID) != null) {
			bPartnerID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_TF_BPartner_ID);
			TF_MBPartner bp = new TF_MBPartner(ctx, bPartnerID, null);
			isEmployee = bp.isEmployee();
			
			if(bp.getUser1_ID() > 0)
				mTab.setValue(TF_MPayment.COLUMNNAME_User1_ID, bp.getUser1_ID());
			else
				mTab.setValue(TF_MPayment.COLUMNNAME_User1_ID, null);
		}
		else {
			MUser user = MUser.get(ctx, Env.getAD_User_ID(ctx));				
			bPartnerID = user.getC_BPartner_ID();			
		}
		
		mTab.setValue(TF_MPayment.COLUMNNAME_IsEmployee, isEmployee);
		mTab.setValue(TF_MPayment.COLUMNNAME_C_BPartner_ID, bPartnerID);
		
		return null;
	}

}
