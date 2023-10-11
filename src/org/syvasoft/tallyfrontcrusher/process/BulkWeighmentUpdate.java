package org.syvasoft.tallyfrontcrusher.process;


import org.compiere.process.SvrProcess;

public class BulkWeighmentUpdate extends SvrProcess {

	@Override
	protected void prepare() {
		


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
import org.syvasoft.tallyfrontcrusher.model.MPriceListUOM;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrderLine;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;

public class BulkWeighmentUpdate extends SvrProcess {

	boolean IsTaxIncluded = false;
	private BigDecimal GrossPrice = BigDecimal.ZERO;
	private BigDecimal GrossRent = BigDecimal.ZERO;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
		
			if(name.equals("IsTaxIncluded"))
				IsTaxIncluded = para[i].getParameterAsBoolean();
			if(name.equals("GrossPrice"))
				GrossPrice = para[i].getParameterAsBigDecimal();
			if(name.equals("GrossRent"))
				GrossRent = para[i].getParameterAsBigDecimal();
		}
	}

	@Override
	protected String doIt() throws Exception {
	
	

		String whereClause = " Status = 'CO' AND (EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
				" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = TF_WeighmentEntry.TF_WeighmentEntry_ID)) ";
		
		List<MWeighmentEntry> weighmententries = new Query(getCtx(),MWeighmentEntry.Table_Name,  whereClause, get_TrxName())
													.setParameters(getAD_PInstance_ID()) 
													.list();
		int i = 0;
		
		for (MWeighmentEntry wEntry : weighmententries) {
			
			if(wEntry.isPermitSales()) {
				wEntry.setIsTaxIncluded(IsTaxIncluded);
				wEntry.setRentIncludesTax(IsTaxIncluded);
			}
			
			GrossPrice = (GrossPrice == null) ? BigDecimal.ZERO : GrossPrice;			
			if(GrossPrice.doubleValue() > 0) {
				wEntry.setGrossPrice(GrossPrice);
			}
			
			GrossRent = (GrossRent == null) ? BigDecimal.ZERO : GrossRent;			
			if(GrossRent.doubleValue() > 0) {
				wEntry.setGrossRent(GrossRent);
			}
			
			wEntry.calculateTotalAmount();
			wEntry.saveEx();
			i++;
		}
				
		return i + " Weighment Entries are updated successfully!";
	}

}
