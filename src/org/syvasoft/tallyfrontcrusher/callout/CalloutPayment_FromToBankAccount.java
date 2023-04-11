package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MUser;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MGLPostingConfig;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class CalloutPayment_FromToBankAccount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int ElementValue_ID = 0;		
		if(mField.getColumnName().equals(TF_MPayment.COLUMNNAME_FromTo_BankAccount_ID)) {
			boolean isInter = mTab.getValue(TF_MPayment.COLUMNNAME_FromTo_BankAccount_ID) != null;
			if(!isInter) { 
				mTab.setValue(TF_MPayment.COLUMNNAME_FromTo_BankAccount_ID, null);	
				mTab.setValue(TF_MPayment.COLUMNNAME_C_ElementValue_ID, null);
				mTab.setValue(TF_MPayment.COLUMNNAME_Description, null);
			}
			else {
				Env.setContext(ctx, WindowNo, "IsEmployee", false);
				mTab.setValue(TF_MPayment.COLUMNNAME_TF_BPartner_ID, 0);
				mTab.setValue(TF_MPayment.COLUMNNAME_Description, null);
			}
		}
		if(mTab.getValue(TF_MPayment.COLUMNNAME_FromTo_BankAccount_ID) != null) {
			ElementValue_ID = MGLPostingConfig.getMGLPostingConfig(ctx).getInterBankInTransit_ID();
			if(ElementValue_ID == 0)
				throw new AdempiereException("Inter Bank In Transit is not configured yet!");
			mTab.setValue(TF_MPayment.COLUMNNAME_TF_BPartner_ID, 0);
			MUser user = MUser.get(ctx, Env.getAD_User_ID(ctx));				
			int bPartnerID = user.getC_BPartner_ID();
			mTab.setValue(TF_MPayment.COLUMNNAME_C_BPartner_ID, bPartnerID);
			
			boolean isReceipt = mTab.getValueAsBoolean(TF_MPayment.COLUMNNAME_IsReceipt);
			int ac1 = (int) mTab.getValue(TF_MPayment.COLUMNNAME_C_BankAccount_ID);
			int ac2 = (int) mTab.getValue(TF_MPayment.COLUMNNAME_FromTo_BankAccount_ID);
			String desc = "";
			if(isReceipt) {
				desc = TF_MPayment.getInterCashBookDescription(ac2, ac1);
			}
			else {
				desc = TF_MPayment.getInterCashBookDescription(ac1, ac2);
			}
			mTab.setValue(TF_MPayment.COLUMNNAME_Description, desc);
		}
		mTab.setValue(TF_MPayment.COLUMNNAME_C_ElementValue_ID, ElementValue_ID);		
		return null;
	}

}
