package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigInteger;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MUser;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MInterOrgBPCashTransferConfig;
import org.syvasoft.tallyfrontcrusher.model.MInterOrgBPCashTransferConfigLine;
import org.syvasoft.tallyfrontcrusher.model.MJobworkAssignedBPartner;
import org.syvasoft.tallyfrontcrusher.model.MJobworkAssignedEmployee;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class CalloutPayment_TFBPartner implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int bPartnerID = 0;		
		boolean isEmployee = false;
		if(mTab.getValue(TF_MPayment.COLUMNNAME_TF_BPartner_ID) != null) {
			bPartnerID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_TF_BPartner_ID);
			TF_MBPartner bp = new TF_MBPartner(ctx, bPartnerID, null);
			isEmployee = bp.isEmployee();
			if(isEmployee) {
				int AD_Org_ID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_AD_Org_ID);
				/*MJobworkAssignedEmployee jwEmp = MJobworkAssignedEmployee.getJobwork(AD_Org_ID, bPartnerID);
				if(jwEmp != null) {
					mTab.setValue(TF_MPayment.COLUMNNAME_C_Project_ID, jwEmp.getC_Project_ID());
				}
				else {
					mTab.setValue(TF_MPayment.COLUMNNAME_C_Project_ID, null);
				}*/
			}
			else {
				int AD_Org_ID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_AD_Org_ID);
				MJobworkAssignedBPartner jwBP = MJobworkAssignedBPartner.getJobwork(AD_Org_ID, bPartnerID);
				/*if(jwBP != null) {
					mTab.setValue(TF_MPayment.COLUMNNAME_C_Project_ID, jwBP.getC_Project_ID());
				}
				else {
					mTab.setValue(TF_MPayment.COLUMNNAME_C_Project_ID, null);
				}*/
			}
			if(bp.getUser1_ID() > 0)
				mTab.setValue(TF_MPayment.COLUMNNAME_User1_ID, bp.getUser1_ID());
			else
				mTab.setValue(TF_MPayment.COLUMNNAME_User1_ID, null);
		}
		else {
			MUser user = MUser.get(ctx, Env.getAD_User_ID(ctx));				
			bPartnerID = user.getC_BPartner_ID();			
		}
		mTab.setValue(TF_MPayment.COLUMNNAME_IsEmployee, isEmployee);
		mTab.setValue(TF_MPayment.COLUMNNAME_C_BPartner_ID, bPartnerID);
		
		boolean isReceipt = mTab.getValueAsBoolean(TF_MPayment.COLUMNNAME_IsReceipt);
		boolean isInterOrgBPCash = false;
		int C_BankAccount_ID = 0;
		
		if(mTab.getValue(TF_MPayment.COLUMNNAME_C_BankAccount_ID) != null)
			C_BankAccount_ID = (int) mTab.getValue(TF_MPayment.COLUMNNAME_C_BankAccount_ID);
		
		mTab.setValue(TF_MPayment.COLUMNNAME_IsInterOrgBPCashTransferX, isInterOrgBPCash);
		mTab.setValue(TF_MPayment.COLUMNNAME_TF_OrgBPCashTrans_Configx_ID, null);
		if(!isReceipt && bPartnerID > 0 && !isEmployee) {
			MInterOrgBPCashTransferConfigLine config = MInterOrgBPCashTransferConfig.getDefaultAddionalCashTransfer(C_BankAccount_ID, bPartnerID, false);
			if(config != null) {
				isInterOrgBPCash = true;
				config = MInterOrgBPCashTransferConfig.getDefaultAddionalCashTransfer(C_BankAccount_ID, bPartnerID, true);
				if(config != null) {
					mTab.setValue(TF_MPayment.COLUMNNAME_TF_OrgBPCashTrans_Configx_ID, config.getTF_OrgBPCashTrans_Configx_ID());										
				}				
				mTab.setValue(TF_MPayment.COLUMNNAME_IsInterOrgBPCashTransferX, isInterOrgBPCash);				
			}
		}
		 
		return null;
	}

}
