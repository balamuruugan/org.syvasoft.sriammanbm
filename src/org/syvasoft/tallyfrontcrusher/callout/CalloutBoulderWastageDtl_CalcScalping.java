package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastageDtl;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastageHdr;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CalloutBoulderWastageDtl_CalcScalping implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mTab.getValue(MBoulderWastageDtl.COLUMNNAME_AllowScalping_Percent) != null) {
			int boulder_WastageDtl_ID = CalloutUtil.getIntValue(mTab, MBoulderWastageDtl.COLUMNNAME_TF_Boulder_Wastage_DTL_ID);
			
			BigDecimal qty = CalloutUtil.getBDValue(mTab, MBoulderWastageDtl.COLUMNNAME_Qty);
			BigDecimal scalpingqty = CalloutUtil.getBDValue(mTab, MBoulderWastageDtl.COLUMNNAME_Scalping_Qty);
			BigDecimal allowingscalpingpercent = CalloutUtil.getBDValue(mTab, MBoulderWastageDtl.COLUMNNAME_AllowScalping_Percent);
			
			BigDecimal allowablescalpingQty = qty.multiply(allowingscalpingpercent).divide(new BigDecimal(100), 3, RoundingMode.HALF_EVEN).setScale(3, RoundingMode.HALF_EVEN);
			BigDecimal netqty = qty.subtract(scalpingqty).add(allowablescalpingQty);
			BigDecimal adjqty = scalpingqty.subtract(allowablescalpingQty);
			
			mTab.setValue(MBoulderWastageDtl.COLUMNNAME_AllowScalping_Qty, allowablescalpingQty);
			mTab.setValue(MBoulderWastageDtl.COLUMNNAME_NetQty, netqty);
			mTab.setValue(MBoulderWastageDtl.COLUMNNAME_QtyAdjustment, adjqty);
		}
		
		return null;
	}

}
