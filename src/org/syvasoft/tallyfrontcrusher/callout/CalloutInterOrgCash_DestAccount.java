package org.syvasoft.tallyfrontcrusher.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MQuery;
import org.compiere.model.Query;
import org.syvasoft.tallyfrontcrusher.model.MInterOrgCashTransfer;

public class CalloutInterOrgCash_DestAccount implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int destAcctID = 0;
		if(mTab.getValue(MInterOrgCashTransfer.COLUMNNAME_Dest_Acct_ID) != null)
			destAcctID = (int) mTab.getValue(MInterOrgCashTransfer.COLUMNNAME_Dest_Acct_ID);
		String whereClause = "(Dest_Acct_ID=? OR Src_Acct_ID=?) AND IsActive='Y'";
		MInterOrgCashTransfer config = new Query(ctx, MInterOrgCashTransfer.Table_Name, whereClause, null)
				.setClient_ID().setOrderBy("updated DESC").setParameters(destAcctID,destAcctID).first();
		int destOrgID = 0;
		int destCashID = 0;
		if(config == null) {
			
		}
		else if(config.getDest_Acct_ID() == destAcctID) {
			destOrgID = config.getDest_Org_ID();
			destCashID = config.getDest_BankAccount_ID();
		}
		else if(config.getSrc_Acct_ID() == destAcctID) {
			destOrgID = config.getSrc_Org_ID();
			destCashID = config.getSrc_BankAccount_ID();
		}
		
		mTab.setValue(MInterOrgCashTransfer.COLUMNNAME_Dest_Org_ID, destOrgID==0?null:destOrgID);
		mTab.setValue(MInterOrgCashTransfer.COLUMNNAME_Dest_BankAccount_ID, destCashID);
		
		return null;
	}

}
