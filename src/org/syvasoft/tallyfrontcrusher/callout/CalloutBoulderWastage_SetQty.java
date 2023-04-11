package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastage;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastageHdr;
import org.syvasoft.tallyfrontcrusher.model.MSubcontractType;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;
import org.syvasoft.tallyfrontcrusher.process.GenerateTaxInvoiceLines;

public class CalloutBoulderWastage_SetQty implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int product_id = 0;
		int warehouse_id = 0;
		int ad_org_id = 0;
		Timestamp dateacct;
		
		if(mTab.getValue(MBoulderWastageHdr.COLUMNNAME_M_Product_ID) != null && 
				mTab.getValue(MBoulderWastageHdr.COLUMNNAME_M_Warehouse_ID) != null && 
				mTab.getValue(MBoulderWastageHdr.COLUMNNAME_DateAcct) != null) {
			product_id = CalloutUtil.getIntValue(mTab, MBoulderWastageHdr.COLUMNNAME_M_Product_ID);
			warehouse_id = CalloutUtil.getIntValue(mTab, MBoulderWastageHdr.COLUMNNAME_M_Warehouse_ID);
			dateacct = CalloutUtil.getTimestamp(mTab, MBoulderWastageHdr.COLUMNNAME_DateAcct);			
			ad_org_id = CalloutUtil.getIntValue(mTab, MBoulderWastageHdr.COLUMNNAME_AD_Org_ID);
			
			BigDecimal qtyBeltScale = CalloutUtil.getBDValue(mTab, MBoulderWastageHdr.COLUMNNAME_BS_Qty);
			BigDecimal qtyReceived = MBoulderWastageHdr.getReceiptQtyForCrusher(ad_org_id, 0, product_id, warehouse_id, dateacct, null);			
			mTab.setValue(MBoulderWastageHdr.COLUMNNAME_Crusher_Qty, qtyReceived);
			
			int tripCount = MBoulderWastageHdr.getTripsForCrusher(ad_org_id, 0, product_id, warehouse_id, dateacct, null);			
			mTab.setValue(MBoulderWastageHdr.COLUMNNAME_Crusher_Trip, tripCount);
			
			BigDecimal qtyScalping = qtyReceived.subtract(qtyBeltScale);
			mTab.setValue(MBoulderWastageHdr.COLUMNNAME_Scalping_Qty, qtyScalping);
			
			if(qtyReceived.doubleValue() > 0) {
				BigDecimal scalpingPercent = qtyScalping.divide(qtyReceived, 6, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_EVEN);
				mTab.setValue(MBoulderWastageHdr.COLUMNNAME_Scalping_Percent, scalpingPercent);
			}
		}
		
		return null;
	}

}
