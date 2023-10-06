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

public class RemoveWeighmentEntyFromOrder extends SvrProcess {

	int RecordId = 0;
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();	
		RecordId = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		MWeighmentEntry mWeighmentEntry = new MWeighmentEntry(getCtx(), RecordId, get_TrxName());
		TF_MOrder ord = new TF_MOrder(getCtx(), mWeighmentEntry.getC_Order_ID(), get_TrxName());
		
		if(mWeighmentEntry.getStatus().equals(MWeighmentEntry.STATUS_Unbilled)) {
			mWeighmentEntry.setC_Order_ID(0);
			mWeighmentEntry.saveEx();
			ord.createConsolidatedOrderLines();
		}
		else {
			throw new AdempiereException("Can't remove the closed Weighment Entry!");
		}
		return null;
	}
}
