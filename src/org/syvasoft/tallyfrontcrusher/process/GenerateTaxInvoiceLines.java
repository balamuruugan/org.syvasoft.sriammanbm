package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.util.logging.Level;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MGenerateTaxInvoice;
import org.syvasoft.tallyfrontcrusher.model.MYardEntryApprove;

public class GenerateTaxInvoiceLines extends SvrProcess {
	private boolean recreate = false;
	private boolean ignoreVehicleRent = false;
	private BigDecimal invAmount = BigDecimal.ZERO;
	MGenerateTaxInvoice taxInvoice = null;
	
	protected void prepare() {
		for(ProcessInfoParameter para : getParameter())
		{
			String name = para.getParameterName();
			if("Recreate".equals(name))
				recreate = "Y".equals(para.getParameter());
			else if("IgnoreRent".equals(name))
				ignoreVehicleRent = "Y".equals(para.getParameter());
			else if("TotalInvAmt".equals(name) ) 
				invAmount = para.getParameterAsBigDecimal();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		taxInvoice = new MGenerateTaxInvoice(getCtx(), getRecord_ID(), get_TrxName());
	}

	@Override
	protected String doIt() throws Exception {
		if(taxInvoice.isProcessed())
			return "Already Processed";
		taxInvoice.setRoundOff(BigDecimal.ZERO);
		taxInvoice.setTotalInvAmt(invAmount);
		taxInvoice.saveEx();		
		if(taxInvoice.getTotalInvAmt().doubleValue() == 0)
			taxInvoice.createInvoiceLines(recreate, ignoreVehicleRent);
		else
			taxInvoice.createInvoiceLinesForInvoiceAmount(recreate, ignoreVehicleRent);
		taxInvoice.saveEx();
		return null;
	}
}
