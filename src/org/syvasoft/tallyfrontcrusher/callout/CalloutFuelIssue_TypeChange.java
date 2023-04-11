package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MFuelIssue;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class CalloutFuelIssue_TypeChange implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		//Empty Account Expense when Subcontract is empty
		
		if(mTab.getValue(MFuelIssue.COLUMNNAME_C_Project_ID) == null && !mField.getColumnName().equals(MFuelIssue.COLUMNNAME_Account_ID))
			mTab.setValue(MFuelIssue.COLUMNNAME_Account_ID, null);
		
		if(mTab.getValue(MFuelIssue.COLUMNNAME_Account_ID) != null)
			mTab.setValue(MFuelIssue.COLUMNNAME_C_UOM_ID, 100);
		
		if(mTab.getValue(MFuelIssue.COLUMNNAME_M_Product_ID) != null) {
			int productID = (int) mTab.getValue(MFuelIssue.COLUMNNAME_M_Product_ID);
			TF_MProduct p = new TF_MProduct(ctx, productID, null); 
			mTab.setValue(MFuelIssue.COLUMNNAME_C_UOM_ID, p.getC_UOM_ID());
		}
		
		return null;
	}

}
