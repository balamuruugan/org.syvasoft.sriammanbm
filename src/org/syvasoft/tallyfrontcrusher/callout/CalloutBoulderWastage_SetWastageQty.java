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
import org.syvasoft.tallyfrontcrusher.model.MSubcontractType;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;
import org.syvasoft.tallyfrontcrusher.process.GenerateTaxInvoiceLines;

public class CalloutBoulderWastage_SetWastageQty implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mTab.getValue(MBoulderWastage.COLUMNNAME_QtyReceived) != null && 
				mTab.getValue(MBoulderWastage.COLUMNNAME_QtyWastage) != null) {			
			BigDecimal qtyReceived = CalloutUtil.getBDValue(mTab, MBoulderWastage.COLUMNNAME_QtyReceived);
			BigDecimal qtyReceivedProduction = CalloutUtil.getBDValue(mTab, MBoulderWastage.COLUMNNAME_Production_QtyReceived);
			BigDecimal qtyReceivedStock = CalloutUtil.getBDValue(mTab, MBoulderWastage.COLUMNNAME_Stock_QtyReceived);
			BigDecimal qtyWastage = CalloutUtil.getBDValue(mTab, MBoulderWastage.COLUMNNAME_QtyWastage);
			
			BigDecimal qtyWastage_Production = BigDecimal.ZERO; 
			BigDecimal qtyWastage_Stock = BigDecimal.ZERO;
			
			if(qtyReceived.doubleValue() > 0) {
				qtyWastage_Production = qtyReceivedProduction.divide(qtyReceived, 6, RoundingMode.HALF_EVEN).multiply(qtyWastage).setScale(2, RoundingMode.HALF_EVEN);
				qtyWastage_Stock = qtyReceivedStock.divide(qtyReceived, 6, RoundingMode.HALF_EVEN).multiply(qtyWastage).setScale(2, RoundingMode.HALF_EVEN);;			
			}
			
			mTab.setValue(MBoulderWastage.COLUMNNAME_Production_QtyWastage, qtyWastage_Production);
			mTab.setValue(MBoulderWastage.COLUMNNAME_Stock_QtyWastage, qtyWastage_Stock);
		}
		
		return null;
	}

}
