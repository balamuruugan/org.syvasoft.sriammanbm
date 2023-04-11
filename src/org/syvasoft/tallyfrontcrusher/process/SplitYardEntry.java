package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MYardEntryApproveLine;

public class SplitYardEntry extends SvrProcess {
	MYardEntryApproveLine yEntry = null;
	BigDecimal permitSalesQty = BigDecimal.ZERO;
	BigDecimal permitPrice = BigDecimal.ZERO;
	BigDecimal WPQty = BigDecimal.ZERO;
	BigDecimal WpPrice = BigDecimal.ZERO;
	
	@Override
	protected void prepare() {
		yEntry = new MYardEntryApproveLine(getCtx(), getRecord_ID(), get_TrxName());
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if (name.equals("PermitSalesQty"))
				permitSalesQty =  para[i].getParameterAsBigDecimal();
			else if(name.equals("PermitPrice"))
				permitPrice = para[i].getParameterAsBigDecimal();
			else if(name.equals("WPQty"))
				WPQty = para[i].getParameterAsBigDecimal();
			else if(name.equals("WpPrice"))
				WpPrice = para[i].getParameterAsBigDecimal();
		}

	}

	@Override
	protected String doIt() throws Exception {
		if(permitSalesQty.doubleValue() == 0 && WPQty.doubleValue() == 0 )
			throw new AdempiereException("Please Specify atleast Permit or WP Qty!");
		if(permitSalesQty.doubleValue() > 0 && permitPrice.doubleValue() == 0)
			throw new AdempiereException("Invalid Permit Price!");
		if(WPQty.doubleValue() > 0 && WpPrice.doubleValue() == 0)
			throw new AdempiereException("Invalid W/P Price!");
		
		if(yEntry.getPermitSalesQty().doubleValue() <= permitSalesQty.doubleValue() && permitSalesQty.doubleValue() > 0)
			throw new AdempiereException("Specify Permit Sales Qty less than " +  yEntry.getPermitSalesQty());
		if(yEntry.getWPQty().doubleValue() <= WPQty.doubleValue() && WPQty.doubleValue() > 0)
			throw new AdempiereException("Specify WP Qty less than " +  yEntry.getPermitSalesQty());
		
		
		MYardEntryApproveLine newYEntry = new MYardEntryApproveLine(getCtx(), 0, get_TrxName());
		newYEntry.setAD_Org_ID(yEntry.getAD_Org_ID());
		newYEntry.setTF_YardEntryApprove_ID(yEntry.getTF_YardEntryApprove_ID());
		newYEntry.setDateAcct(yEntry.getDateAcct());
		newYEntry.setTF_VehicleType_ID(yEntry.getTF_VehicleType_ID());
		newYEntry.setC_BPartner_ID(yEntry.getC_BPartner_ID());
		newYEntry.setTotalLoad(WPQty.add(permitSalesQty));
		newYEntry.setPermitIssuedQty(permitSalesQty);
		newYEntry.setPermitCancelledQty(BigDecimal.ZERO);
		newYEntry.setPermitSalesQty(permitSalesQty);
		newYEntry.setPermitPrice(permitPrice);
		newYEntry.setPermitAmount(permitSalesQty.multiply(permitPrice));
		newYEntry.setExtraBucketQty(BigDecimal.ZERO);
		newYEntry.setExtraBucketPrice(BigDecimal.ZERO);
		newYEntry.setExtraBucketAmount(BigDecimal.ZERO);
		newYEntry.setWPQty(WPQty);
		newYEntry.setWpPrice(WpPrice);
		newYEntry.setWPAmount(WPQty.multiply(WpPrice));
		newYEntry.setDescription(yEntry.getDescription());
		newYEntry.setDiscountAmt(BigDecimal.ZERO);
		newYEntry.setBucket_Discount(BigDecimal.ZERO);
		newYEntry.saveEx();
		
		
		yEntry.setTotalLoad(yEntry.getTotalLoad().subtract(WPQty).subtract(permitSalesQty));
		yEntry.setPermitIssuedQty(yEntry.getPermitIssuedQty().subtract(permitSalesQty));
		
		yEntry.setPermitSalesQty(yEntry.getPermitSalesQty().subtract(permitSalesQty));
		yEntry.setPermitAmount(yEntry.getPermitSalesQty().multiply(yEntry.getPermitPrice()));
		
		yEntry.setWPQty(yEntry.getWPQty().subtract(WPQty));
		yEntry.setWPAmount(yEntry.getWPQty().multiply(yEntry.getWpPrice()));
		
		yEntry.saveEx();
		
		return "New Yard Entry is created from Current Record!";
	}

}
