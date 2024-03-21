package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.eInvoiceutil.AddressAutoFillUtil;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.zkoss.poi.ss.formula.functions.Address;

public class CalloutBP_GetGSTINDetail implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		String taxId = CalloutUtil.getString(mTab, TF_MBPartner.COLUMNNAME_TaxID);
		if(taxId == null || taxId.length() <= 10)
			return "Invalid GST No";
		
		AddressAutoFillUtil addUtil = new AddressAutoFillUtil();
		addUtil.fetchAddress(ctx, taxId);
		
		mTab.setValue(TF_MBPartner.COLUMNNAME_Name, addUtil.Name);
		mTab.setValue(TF_MBPartner.COLUMNNAME_Address1, addUtil.Address1);
		mTab.setValue(TF_MBPartner.COLUMNNAME_Address2, addUtil.Address2);
		mTab.setValue(TF_MBPartner.COLUMNNAME_City, addUtil.City);
		mTab.setValue(TF_MBPartner.COLUMNNAME_StateCode, addUtil.statecode);
		mTab.setValue(TF_MBPartner.COLUMNNAME_RegionName, addUtil.Region);
		mTab.setValue(TF_MBPartner.COLUMNNAME_Postal, addUtil.zip);
		
		return null;
	}

}
