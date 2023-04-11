package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastageHdr;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CalloutBoulderWastageHdr_BeltScaleQty implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mTab.getValue(MBoulderWastageHdr.COLUMNNAME_BS_Opening) != null && mTab.getValue(MBoulderWastageHdr.COLUMNNAME_BS_Closing) != null) {
			BigDecimal opening = CalloutUtil.getBDValue(mTab, MBoulderWastageHdr.COLUMNNAME_BS_Opening);
			BigDecimal closing = CalloutUtil.getBDValue(mTab, MBoulderWastageHdr.COLUMNNAME_BS_Closing);
			
			mTab.setValue(MBoulderWastageHdr.COLUMNNAME_BS_Qty, closing.subtract(opening));
		}
		
		return null;
	}

}
