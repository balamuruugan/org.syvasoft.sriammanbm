package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;

public class CalloutInvoiceHeaderItemAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		//Item1
		BigDecimal qty1 =  (BigDecimal) mTab.getValue(TF_MInvoice.COLUMNNAME_Item1_Qty);
		BigDecimal price1 =  (BigDecimal) mTab.getValue(TF_MInvoice.COLUMNNAME_Item1_Price);
		BigDecimal amount1 = BigDecimal.ZERO;
		
		if(qty1 != null && price1 != null)
			amount1 = qty1.multiply(price1);
		
		mTab.setValue(TF_MInvoice.COLUMNNAME_Item1_Amt, amount1);
		
		
		//Item2
		BigDecimal qty2 =  (BigDecimal) mTab.getValue(TF_MInvoice.COLUMNNAME_Item2_Qty);
		BigDecimal price2 =  (BigDecimal) mTab.getValue(TF_MInvoice.COLUMNNAME_Item2_Price);
		BigDecimal amount2 = BigDecimal.ZERO;
		
		if(qty2 != null && price2 != null)
			amount2 = qty2.multiply(price2);
		
		mTab.setValue(TF_MInvoice.COLUMNNAME_Item2_Amt, amount2);
		
		return null;
	}

}
