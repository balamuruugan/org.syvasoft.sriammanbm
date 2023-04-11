package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MBoulderWastageHdr;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CalloutBoulderWastageHdr_SetOpeningMeter implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mTab.getValue(MBoulderWastageHdr.COLUMNNAME_DateAcct) != null) {
			String whereClause = "trunc(DateAcct) < ? AND DocStatus IN ('CO','CL') AND AD_Org_ID = ?";
			
			Timestamp dateacct = CalloutUtil.getTimestamp(mTab, MBoulderWastageHdr.COLUMNNAME_DateAcct);
			int ad_org_id = CalloutUtil.getIntValue(mTab, MBoulderWastageHdr.COLUMNNAME_AD_Org_ID);
			
			MBoulderWastageHdr hdr = new Query(ctx, MBoulderWastageHdr.Table_Name, whereClause, null)
					.setClient_ID()
					.setParameters(dateacct, ad_org_id)
					.setOrderBy("DateAcct Desc")
					.first();
			
			if(hdr != null) {
				mTab.setValue(MBoulderWastageHdr.COLUMNNAME_BS_Opening, hdr.getBS_Closing());
			}
		}
		
		return null;
	}

}
