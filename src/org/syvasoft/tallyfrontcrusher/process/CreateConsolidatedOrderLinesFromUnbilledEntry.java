package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.exceptions.DBException;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MPriceList;
import org.compiere.model.MProcessPara;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Trx;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrderLine;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class CreateConsolidatedOrderLinesFromUnbilledEntry extends SvrProcess {

	int C_Order_ID = 0;
	int C_DocTypeTarget_ID = 0;
	boolean IsTaxIncluded = false;
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();	
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (name.equals("C_Order_ID"))
				C_Order_ID = para[i].getParameterAsInt();		
			else if(name.equals("IsTaxIncluded"))
				IsTaxIncluded = para[i].getParameterAsBoolean();
			else if(name.equals("C_DocTypeTarget_ID"))
				C_DocTypeTarget_ID = para[i].getParameterAsInt();
		}
	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = " Status = 'CO' AND (EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
				" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = TF_WeighmentEntry.TF_WeighmentEntry_ID)) ";
		
		List<MWeighmentEntry> weighmententries = new Query(getCtx(),MWeighmentEntry.Table_Name,  whereClause, get_TrxName())
													.setParameters(getAD_PInstance_ID()) 
													.list();
		TF_MOrder ord = new TF_MOrder(getCtx(), C_Order_ID, get_TrxName());
		
		for (MWeighmentEntry mWeighmentEntry : weighmententries) {
				if(C_DocTypeTarget_ID == TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx()) && 
						!mWeighmentEntry.isPermitSales() && IsTaxIncluded) {
					mWeighmentEntry.setIsPermitSales(true);
					mWeighmentEntry.setIsTaxIncluded(true);
					mWeighmentEntry.setRentIncludesTax(true);
					mWeighmentEntry.calculateTotalAmount();
				}
				else if(C_DocTypeTarget_ID == TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx()) && 
						!mWeighmentEntry.isPermitSales() && !IsTaxIncluded) {
					mWeighmentEntry.setIsPermitSales(true);
					mWeighmentEntry.calculateTotalAmount();
				}
				
				mWeighmentEntry.setC_Order_ID(C_Order_ID);
				mWeighmentEntry.saveEx();
		}
		
		ord.createConsolidatedOrderLines();
		return null;
	}
}
