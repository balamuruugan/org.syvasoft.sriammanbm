package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MInterOrgCashTransfer;

public class CalloutInterOrgCash_SrcOrg implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int srcOrgID = 0;
		if(mTab.getValue(MInterOrgCashTransfer.COLUMNNAME_Src_Org_ID) != null)
			srcOrgID = (int) mTab.getValue(MInterOrgCashTransfer.COLUMNNAME_Src_Org_ID);
		String whereClause = "(Dest_Org_ID=? OR Src_Org_ID=?) AND IsActive='Y'";
		MInterOrgCashTransfer config = new Query(ctx, MInterOrgCashTransfer.Table_Name, whereClause, null)
				.setClient_ID().setOrderBy("updated DESC").setParameters(srcOrgID,srcOrgID).first();
		int srcAcctID = 0;
		int srcCashID = 0;
		if(config == null) {
			
		}
		else if(config.getDest_Org_ID() == srcOrgID) {
			srcAcctID = config.getDest_Acct_ID();
			srcCashID = config.getDest_BankAccount_ID();
		}
		else if(config.getSrc_Org_ID() == srcOrgID) {
			srcAcctID = config.getSrc_Acct_ID();
			srcCashID = config.getSrc_BankAccount_ID();
		}
		
		mTab.setValue(MInterOrgCashTransfer.COLUMNNAME_Src_Acct_ID, srcAcctID);
		mTab.setValue(MInterOrgCashTransfer.COLUMNNAME_Src_BankAccount_ID, srcCashID);
		
		return null;		
	}

}
