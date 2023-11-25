package org.syvasoft.tallyfrontcrusher.process;


import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;

import java.math.BigDecimal;
import java.util.List;


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
	
	

		String whereClause = " Status IN ('CO','UR') AND (EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
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
