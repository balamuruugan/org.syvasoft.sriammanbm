package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class CalloutPayment_WeighmentEntry implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int TF_WeighmentEntry_ID = CalloutUtil.getIntValue(mTab, TF_MPayment.COLUMNNAME_TF_WeighmentEntry_ID);
		int TF_BPartner_ID = CalloutUtil.getIntValue(mTab, TF_MPayment.COLUMNNAME_TF_BPartner_ID);
		
		MWeighmentEntry wentry = new MWeighmentEntry(ctx, TF_WeighmentEntry_ID, null);
		String dcNo = wentry.getDocumentNo();
		BigDecimal balance = BigDecimal.ZERO;
		String sql = "SELECT COALESCE(balanceamount,0) AS balanceamount FROM DC_ReportOneTimeCust_View WHERE DC_ReportOneTimeCust_View.TF_WeighmentEntry_ID = "+TF_WeighmentEntry_ID;
		balance = DB.getSQLValueBD(null, sql);
		
		String desc = null;
		if(TF_BPartner_ID > 0 && TF_WeighmentEntry_ID > 0) 
			desc = "Payment Received for DC# " + dcNo;
		else 
			mTab.setValue(TF_MPayment.COLUMNNAME_TF_WeighmentEntry_ID, null); //resetting dc when no bp is selected
		
		mTab.setValue(TF_MPayment.COLUMNNAME_Description, desc);
		mTab.setValue(TF_MPayment.COLUMNNAME_PayAmt, balance);

		return null;
	}

}
