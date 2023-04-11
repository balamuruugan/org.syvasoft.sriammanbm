package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCharge;
import org.compiere.model.MClient;
import org.compiere.model.MElementValue;
import org.compiere.model.MQuery;
import org.compiere.model.MTable;
import org.compiere.model.MTaxCategory;
import org.compiere.model.Query;
import org.compiere.model.X_C_Charge_Acct;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class TF_MCharge extends MCharge {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1233379119313586019L;
	public TF_MCharge(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	public TF_MCharge(Properties ctx, int C_Charge_ID, String trxName) {
		super(ctx, C_Charge_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	 /** Column name C_ElementValue_ID */
    public static final String COLUMNNAME_C_ElementValue_ID = "C_ElementValue_ID";
    
    public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValue_ID(), get_TrxName());	}

	/** Set Account Element.
		@param C_ElementValue_ID 
		Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID)
	{
		if (C_ElementValue_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
	}

	/** Get Account Element.
		@return Account Element
	  */
	public int getC_ElementValue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		//Set Default Tax Category
		if(newRecord && getC_TaxCategory_ID() == 0) {
			List<MTaxCategory> list = new Query(getCtx(), MTaxCategory.Table_Name, null, get_TrxName())
						.setClient_ID().setOrderBy("IsDefault DESC").list();			
			int defaultTaxCategory_ID = 0;
			if(list.size()>0) 
				defaultTaxCategory_ID = list.get(0).get_ID();
			setC_TaxCategory_ID(defaultTaxCategory_ID);
		}
		return super.beforeSave(newRecord);
	}
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		if(success && (newRecord || is_ValueChanged(COLUMNNAME_C_ElementValue_ID)) ) {
			
			if(success && newRecord)
				insert_Accounting("C_Charge_Acct", "C_AcctSchema_Default", null);
			
			if(getC_ElementValue_ID()>0) {
				MAccount account = getAccount(getC_ElementValue_ID());
				if(account.getC_ValidCombination_ID() == 0)
					account.saveEx(); // Create new account combination
				
				String sql = "UPDATE C_Charge_Acct SET CH_Expense_Acct=" + account.get_ID() + 
							" WHERE C_Charge_ID= " + getC_Charge_ID() + " AND C_AcctSchema_ID= " + account.getC_AcctSchema_ID();
				DB.executeUpdate(sql, get_TrxName());
							
			}
		}
		return success;
	}	
	
	 /**
     * Gets the account for the specified charge and element value.
     * The account is created if it doesn't already exist.
     * @param elementValueId    identifier for the element value
     * @return the account
     */
    private MAccount getAccount(int elementValueId)
    {
    	Properties ctx = Env.getCtx();
    	MAcctSchema m_acctSchema = MClient.get(getCtx()).getAcctSchema();
        MAccount defaultAccount = MAccount.getDefault(m_acctSchema, true); //  optional null
        MAccount account = MAccount.get(ctx,
            Env.getAD_Client_ID(ctx),
            Env.getAD_Org_ID(ctx),
            m_acctSchema.getC_AcctSchema_ID(),
            elementValueId,
            defaultAccount.getC_SubAcct_ID(),
            defaultAccount.getM_Product_ID(),
            defaultAccount.getC_BPartner_ID(),
            defaultAccount.getAD_OrgTrx_ID(),
            defaultAccount.getC_LocFrom_ID(),
            defaultAccount.getC_LocTo_ID(),
            defaultAccount.getC_SalesRegion_ID(),
            defaultAccount.getC_Project_ID(),
            defaultAccount.getC_Campaign_ID(),
            defaultAccount.getC_Activity_ID(),
            defaultAccount.getUser1_ID(),
            defaultAccount.getUser2_ID(),
            defaultAccount.getUserElement1_ID(),
            defaultAccount.getUserElement2_ID(),
            null);

        return account;
    }
    
    public static TF_MCharge getTF_MCharge(Properties ctx, int C_ElementValue_ID, String trxName) {
    	List<TF_MCharge> list = new Query(ctx, Table_Name, "C_ElementValue_ID=" + C_ElementValue_ID, trxName).setClient_ID().list();
    	if(list.size()>0)
    		return list.get(0);
    	else
    		return null;
    }
    
    public static TF_MCharge createChargeFromAccount(Properties ctx, int C_ElementValue_ID, String trxName) {
    	TF_MCharge charge = getTF_MCharge(ctx, C_ElementValue_ID, trxName);
    	if(charge == null && C_ElementValue_ID > 0) {
    		charge = new TF_MCharge(ctx, 0, trxName);
    		MElementValue acct = new MElementValue(ctx, C_ElementValue_ID, trxName);
    		charge.setAD_Org_ID(0);
    		charge.setName(acct.getName());
    		charge.setC_ElementValue_ID(C_ElementValue_ID);
    		charge.saveEx();
    	}
    	return charge;
    }

}
