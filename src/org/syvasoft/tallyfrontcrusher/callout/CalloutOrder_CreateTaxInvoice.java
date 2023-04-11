package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBPartner;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPricing;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MPriceListUOM;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_CreateTaxInvoice implements IColumnCallout{
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(value != null) {
			boolean isSOTrx = Env.getContext(ctx, WindowNo, "IsSOTrx").equals("Y");
			
			if(isSOTrx) {
				if(mField.getColumnName().equals(TF_MOrder.COLUMNNAME_C_BPartner_ID)) {
					int partner_id = (int)mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID); 
					TF_MBPartner partner = new TF_MBPartner(ctx, partner_id, null);
					boolean isRequiredTaxInvoice = false;
					isRequiredTaxInvoice = partner.IsRequiredTaxInvoicePerLoad();
					mTab.setValue(TF_MOrder.COLUMNNAME_OnAccount, isRequiredTaxInvoice);
				}
			}
		}
		return null;
	}
}
