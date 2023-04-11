package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MDocType;
import org.compiere.model.MPayment;
import org.compiere.model.MUser;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class CalloutPaymentCashType implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {		
		String cashType = null;
		int C_DocType_ID = 1000009;
		if(value != null) {
			
			cashType = value.toString();		
			if(cashType.equals("C") || cashType.equals("R"))
				C_DocType_ID = 1000008;
			else if(cashType.equals("E") || cashType.equals("V") || cashType.equals("Y"))
				C_DocType_ID = 1000009;
			
			if(cashType.equals("E") || cashType.equals("R") || cashType.equals("Y")) {
				mTab.setValue(MPayment.COLUMNNAME_DiscountAmt, BigDecimal.ZERO);
				mTab.setValue(MPayment.COLUMNNAME_WriteOffAmt, BigDecimal.ZERO);
				mTab.setValue(MPayment.COLUMNNAME_OverUnderAmt, BigDecimal.ZERO);
				
				//Set current user's bpartner since it is mandatory field.
				if(cashType.equals("E") || cashType.equals("R")) {					
					MUser user = MUser.get(ctx, Env.getAD_User_ID(ctx));				
					mTab.setValue(MPayment.COLUMNNAME_C_BPartner_ID, user.getC_BPartner_ID());
				}
			}
			else {
				mTab.setValue(TF_MPayment.COLUMNNAME_C_ElementValue_ID, BigDecimal.ZERO);
				mTab.setValue(MPayment.COLUMNNAME_C_BPartner_ID, 0);
			}
		}
		mTab.setValue(MPayment.COLUMNNAME_C_DocType_ID, C_DocType_ID);
		mTab.setValue(MPayment.COLUMNNAME_IsReceipt, MDocType.get(ctx, C_DocType_ID).isSOTrx());
		return null;
	}

}
