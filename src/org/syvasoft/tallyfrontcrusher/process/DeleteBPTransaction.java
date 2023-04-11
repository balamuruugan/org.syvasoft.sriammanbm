package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.acct.Doc;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.MClient;
import org.compiere.model.MDocType;
import org.compiere.model.MInvoice;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.syvasoft.tallyfrontcrusher.model.MBPCB;
import org.syvasoft.tallyfrontcrusher.model.MDebitCreditNote;
import org.syvasoft.tallyfrontcrusher.model.MGLPostingConfig;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;

public class DeleteBPTransaction extends SvrProcess {
	
	int C_BPartner_ID = 0;
	int AD_Org_ID = 0; 
	Timestamp dateTo = null;
	MGLPostingConfig glConfig = null;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();						
			if(name.equals("C_BPartner_ID"))
				C_BPartner_ID = para[i].getParameterAsInt();
			else if(name.equals("AD_Org_ID"))
				AD_Org_ID = para[i].getParameterAsInt();
			else if(name.equals("DateTo"))
				dateTo = para[i].getParameterAsTimestamp();
		}
		
		glConfig = MGLPostingConfig.getMGLPostingConfig(getCtx());

	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = "IsCustomer = 'Y' AND ? IN (C_BPartner_ID, 0)";

		
		List<TF_MBPartner> list = new Query(getCtx(), TF_MBPartner.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(C_BPartner_ID)
				.list();
		
		String sql = "SELECT deleteBPTransaction(?,?,?)";
		int i = 0;
		for(TF_MBPartner bp : list) {
			
			C_BPartner_ID = bp.getC_BPartner_ID();
			
			//1. Save closing balance for date To
			BigDecimal closingBalance = getClosingBalance(AD_Org_ID, bp.getC_BPartner_ID(), dateTo);
			BigDecimal closingBalanceBefore = getClosingBalance(AD_Org_ID, C_BPartner_ID, null);
			MBPCB cb = new MBPCB(getCtx(), 0, get_TrxName());
			cb.setAD_Org_ID(AD_Org_ID);
			cb.setDateTo(dateTo);
			cb.setC_BPartner_ID(bp.getC_BPartner_ID());
			cb.setAmountCB(closingBalance);
			cb.setCBBefore(closingBalanceBefore);
			cb.setCBAfter(null);
			cb.setAD_PInstance_ID(getAD_PInstance_ID());
			cb.saveEx();
			
			
			//2. Delete all the allocation documents using MAllocationHdr.deleteEx;
			//2. Delete in 2 methods.. Using Invoice id association and Payment id association.
			/*
			List<MAllocationHdr> allocations = new Query(getCtx(), MAllocationHdr.Table_Name, whAllocation, get_TrxName())
					.setClient_ID()
					.setParameters(bp.getC_BPartner_ID(), AD_Org_ID, bp.getC_BPartner_ID(), dateTo)
					.list();
		
			
			for(MAllocationHdr alloc : allocations) {
				alloc.deleteEx(true);
				
			}
			*/
			
			//3. Delete Transactions
			DB.getSQLValue(get_TrxName(), sql,  bp.getC_BPartner_ID(), AD_Org_ID, dateTo);
			
			System.out.println("Deleted " + ++i + " / " + list.size());
			
			//4. Set opening balance
			setOpeningBalance(AD_Org_ID, C_BPartner_ID, closingBalance);
			//post debit/credit note immediately.
			
			//5. validation
			BigDecimal closingBalanceAfter = getClosingBalance(AD_Org_ID, C_BPartner_ID, null);
			cb.setCBAfter(closingBalanceAfter);
			cb.saveEx();
			bp.setOutstandingBalance(null);
			bp.saveEx();
			if(closingBalanceAfter.doubleValue() != closingBalanceBefore.doubleValue())
				throw new AdempiereException("Deletion of transaction cannot be committed for " + bp.getName() + " due to balance error!");
			
		}
		
		return null;
	}

	//pass null value to get closing balance as on today
	private BigDecimal getClosingBalance(int AD_Org_ID, int C_BPartner_ID, Timestamp dateTo) {
		String sql = "SELECT	\r\n" + 
				"	SUM(AmtAcct) closingBalance\r\n" + 
				"FROM\r\n" + 
				"	rv_fact_acct_day\r\n" + 
				"WHERE\r\n" + 
				"	AD_Org_ID =  ?  AND \r\n" + 
				"	C_BPartner_ID = ? AND	\r\n" + 
				"Account_ID IN (1000023, 1000028, 1000032, 1000035, 1000046, 1000047 ) \r\n" + 
				"AND DateAcct <= COALESCE(?,now())";
		
		BigDecimal cb = DB.getSQLValueBDEx(get_TrxName(), sql, AD_Org_ID, C_BPartner_ID, dateTo);
		
		if(cb != null)
			return cb;
		
		return BigDecimal.ZERO;
	}
	
	private void setOpeningBalance(int AD_Org_ID, int C_BPartner_ID, BigDecimal closingBalance) {
		
		if(closingBalance.doubleValue() == 0)
			return;
		
		String whereClause = "C_DocType.DocBaseType IN ('ARC','APC') AND IsSOTrx=?";
		boolean isDebit = closingBalance.doubleValue() > 0 ;
		MDocType dt = new Query(getCtx(), MDocType.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters( !isDebit ? "Y" : "N")
				.first();
		
		MDebitCreditNote cNote = new MDebitCreditNote(getCtx(), 0, get_TrxName());
		cNote.setAD_Org_ID(AD_Org_ID);
		cNote.setDateAcct(dateTo);
		cNote.setC_DocType_ID(dt.getC_DocType_ID());
		cNote.setC_ElementValue_ID(isDebit ? glConfig.getBP_DebitBalanceAcct_ID() : glConfig.getBP_CreditBalanceAcct_ID());
		cNote.setC_BPartner_ID(C_BPartner_ID);
		cNote.setAmount(closingBalance.abs());
		cNote.setDescription("Opening Balance set ");
		cNote.saveEx();
		cNote.processIt("CO");
		cNote.saveEx();
		
		MClient client = MClient.get(getCtx());		
		MAcctSchema[] ass= new MAcctSchema[1];
		ass[0] = client.getAcctSchema();
		Doc.postImmediate(ass, MInvoice.Table_ID, cNote.getC_Invoice_ID(), true, get_TrxName());
	}
	
}
