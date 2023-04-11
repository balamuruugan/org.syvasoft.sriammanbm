package org.syvasoft.tallyfrontcrusher.process;

import java.util.logging.Level;

import org.compiere.model.MElementValue;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MQuarry;


public class CreateProfitCenterForQuarry extends SvrProcess {
	
	private int C_Element_ID = 0;	
	private String p_Name = null;
	private String p_Value = null;
	@Override
	protected void prepare() {		
		ProcessInfoParameter[] para = getParameter();		
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if (name.equals("Value"))
				p_Value = para[i].getParameterAsString();
			else if (name.equals("Name")) 
				p_Name = para[i].getParameterAsString();
			else if (name.equals("C_Element_ID")) 
				C_Element_ID = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
	}

	@Override
	protected String doIt() throws Exception {
		MElementValue ev = new MElementValue(getCtx(), 0, get_TrxName());
		ev.setName(p_Name);
		ev.setValue(p_Value);
		ev.setC_Element_ID(C_Element_ID);
		ev.setAD_Org_ID(0);
		ev.saveEx();
		
		MQuarry qry = new MQuarry(getCtx(), getRecord_ID(), get_TrxName());
		qry.setC_ElementValue_ID(ev.getC_ElementValue_ID());
		qry.saveEx();
		
		return null;
	}

}
