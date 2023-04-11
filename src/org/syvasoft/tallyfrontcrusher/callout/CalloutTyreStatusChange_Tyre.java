/**
 * 
 */
package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MTyre;
import org.syvasoft.tallyfrontcrusher.model.MTyreStatus;
import org.syvasoft.tallyfrontcrusher.model.MTyreStatusChange;

/**
 * @author syed
 *
 */
public class CalloutTyreStatusChange_Tyre implements IColumnCallout {

	/* (non-Javadoc)
	 * @see org.adempiere.base.IColumnCallout#start(java.util.Properties, int, org.compiere.model.GridTab, org.compiere.model.GridField, java.lang.Object, java.lang.Object)
	 */
	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value, Object oldValue) {
		int curr_TyreStatus_ID = 0;
		int curr_TyreType_ID = 0;
		boolean changeTyreType = false;
		if(mTab.getValue(MTyreStatusChange.COLUMNNAME_TF_Tyre_ID) != null) {
			MTyre tyre = new MTyre(null, (int) mTab.getValue(MTyreStatusChange.COLUMNNAME_TF_Tyre_ID), null);
			curr_TyreStatus_ID = tyre.getTF_TyreStatus_ID();
			curr_TyreType_ID = tyre.getCurrent_TyreType_ID();
			MTyreStatus tStaus = new MTyreStatus(ctx, curr_TyreStatus_ID, null);
			changeTyreType = tStaus.isChangeTyreType();
		}
		mTab.setValue(MTyreStatusChange.COLUMNNAME_Curr_TF_TyreStatus_ID, curr_TyreStatus_ID);
		mTab.setValue(MTyreStatusChange.COLUMNNAME_Curr_TF_TyreType_ID, curr_TyreType_ID);
		mTab.setValue(MTyreStatusChange.COLUMNNAME_ChangeTyreType, changeTyreType);
		return null;
	}

}
