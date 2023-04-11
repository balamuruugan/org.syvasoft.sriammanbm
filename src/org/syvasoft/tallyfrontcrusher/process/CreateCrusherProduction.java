package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MCrusherProduction;

public class CreateCrusherProduction extends SvrProcess {
	
	private int p_TF_Crusher_Production_ID = 0;
	private boolean recreate = false;
	private String p_TF_BlueMetal_Type = null;
	private BigDecimal p_QtyUsed = null;
	
	@Override
	protected void prepare() {
		for(ProcessInfoParameter para : getParameter())
		{
			String name = para.getParameterName();
			if("Recreate".equals(name))
				recreate = "Y".equals(para.getParameter());
			else if(name.equals("TF_BlueMetal_Type")) 
				p_TF_BlueMetal_Type = para.getParameterAsString();
			else if(name.equals("QtyUsed"))
				p_QtyUsed = para.getParameterAsBigDecimal();
		}
		p_TF_Crusher_Production_ID = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		MCrusherProduction crusherProd = new MCrusherProduction(getCtx(), p_TF_Crusher_Production_ID, get_TrxName());
		
		if(crusherProd.getIsCreated().equals("Y") && !recreate)
			return "Blue Metal Productions were already created!";
		
		crusherProd.setQtyUsed(p_QtyUsed);
		crusherProd.setTF_BlueMetal_Type(p_TF_BlueMetal_Type);
		crusherProd.saveEx();
		crusherProd.createProduction(recreate);
		crusherProd.saveEx();
		
		return "Blue Metal productions are created successfully!";
	}

}
