package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MDestination;
import org.syvasoft.tallyfrontcrusher.model.MLumpSumRentConfig;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_Destination implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal distance = BigDecimal.ZERO;
		BigDecimal RateKM=BigDecimal.ZERO;
		if(mTab.getValue(TF_MOrder.COLUMNNAME_TF_Destination_ID) != null) {
			int destination_id = (int) mTab.getValue(TF_MOrder.COLUMNNAME_TF_Destination_ID);
			MDestination dest = new MDestination(ctx, destination_id, null);
			distance = dest.getDistance();
		}
		mTab.setValue(TF_MOrder.COLUMNNAME_Distance, distance);
		return null;
	}

}
