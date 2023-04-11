package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MDocType;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class CalloutPayment_DocumentType implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {		
		if(mTab.getValue(TF_MPayment.COLUMNNAME_C_DocType_ID) != null) {
			int C_DocType_ID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_C_DocType_ID);
			MDocType docType = new MDocType(ctx, C_DocType_ID, null);
			mTab.setValue(TF_MPayment.COLUMNNAME_IsReceipt, docType.isSOTrx());
			
			mTab.setValue(TF_MPayment.COLUMNNAME_TF_BPartner_ID, null);
			mTab.setValue(TF_MPayment.COLUMNNAME_IsInterOrgBPCashTransferX, false);
			mTab.setValue(TF_MPayment.COLUMNNAME_IsInterOrgCashTransferX, false);
			mTab.setValue(TF_MPayment.COLUMNNAME_TF_OrgBPCashTrans_Configx_ID, null);
			mTab.setValue(TF_MPayment.COLUMNNAME_TF_OrgCashTransfer_Configx_ID, null);
		}

		return null;
	}

}
