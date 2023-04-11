package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MYardEntry;

public class CalloutYardEntry_CalcAmount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal TotalLoad = BigDecimal.ZERO;
		BigDecimal PermitIssuedQty = BigDecimal.ZERO;
		BigDecimal PermitIssuedPrice = BigDecimal.ZERO;
		BigDecimal ExtraBucketQty = BigDecimal.ZERO;
		BigDecimal ExtraBucketPrice = BigDecimal.ZERO;
		BigDecimal WPPermitPrice = BigDecimal.ZERO;
		BigDecimal WPQty = BigDecimal.ZERO;
		BigDecimal PermitCancelledQty = BigDecimal.ZERO;
		BigDecimal PermitSalesQty = BigDecimal.ZERO;
		
		TotalLoad = (BigDecimal) mTab.getValue(MYardEntry.COLUMNNAME_TotalLoad);
		PermitIssuedQty = (BigDecimal) mTab.getValue(MYardEntry.COLUMNNAME_PermitIssuedQty);
		PermitIssuedPrice = (BigDecimal) mTab.getValue(MYardEntry.COLUMNNAME_PermitPrice);
		ExtraBucketQty = (BigDecimal) mTab.getValue(MYardEntry.COLUMNNAME_ExtraBucketQty);
		ExtraBucketPrice = (BigDecimal) mTab.getValue(MYardEntry.COLUMNNAME_ExtraBucketPrice);
		WPPermitPrice = (BigDecimal) mTab.getValue(MYardEntry.COLUMNNAME_WpPrice);
		WPQty = (BigDecimal) mTab.getValue(MYardEntry.COLUMNNAME_WPQty);
		PermitCancelledQty = (BigDecimal) mTab.getValue(MYardEntry.COLUMNNAME_PermitCancelledQty);
		PermitSalesQty = PermitIssuedQty.subtract(PermitCancelledQty);
		WPQty = TotalLoad.subtract(PermitSalesQty);		 
		
		mTab.setValue(MYardEntry.COLUMNNAME_PermitSalesQty, PermitSalesQty);
		mTab.setValue(MYardEntry.COLUMNNAME_PermitAmount, PermitIssuedPrice.multiply(PermitSalesQty));		
		mTab.setValue(MYardEntry.COLUMNNAME_WPQty, WPQty);
		mTab.setValue(MYardEntry.COLUMNNAME_WPAmount, WPPermitPrice.multiply(WPQty));
		
		mTab.setValue(MYardEntry.COLUMNNAME_ExtraBucketAmount, ExtraBucketPrice.multiply(ExtraBucketQty));
		
		
		return null;
	}

}
