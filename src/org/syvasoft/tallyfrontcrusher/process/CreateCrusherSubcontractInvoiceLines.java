package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;

import org.adempiere.exceptions.DBException;
import org.compiere.model.MInvoiceLine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MJobworkProductPrice;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CreateCrusherSubcontractInvoiceLines extends SvrProcess {
	
	private int m_C_BPartner_ID = 0;
	private int m_C_Project_ID = 0;
	
	private int recordID = 0;
	private int m_AD_Client_ID = 0;
	private int m_AD_Org_ID = 0;
	private String m_DocAction = "PR";
	private int m_C_DocTypeTarget_ID = 0;
	private BigDecimal jobWorkUnitPrice = BigDecimal.ZERO;
	private Timestamp m_DateFrom = null;
	private Timestamp m_DateTo  = null;
	private Timestamp m_DateAcct  = null;  //Account Date* full NAME PACKAGE NAME check report and process in system side
	private Timestamp m_DateInvoiced   = null;
	 
	private boolean isSimulate = false;
	TF_MInvoice invoice = null;

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

		recordID = getRecord_ID(); // invoice id where cluase to get the current contract id
		// get invoice id from
		invoice = new TF_MInvoice(getCtx(), recordID, get_TrxName());
		ProcessInfoParameter[] para = getParameter();
		m_AD_Client_ID = Env.getAD_Client_ID(getCtx());
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();

			if (name.equals("DateFrom"))
				m_DateFrom = para[i].getParameterAsTimestamp();
			else if (name.equals("DateTo"))
				m_DateTo = para[i].getParameterAsTimestamp();
			else if (name.equals("C_Project_ID"))
				m_C_Project_ID = ((BigDecimal) para[i].getParameter()).intValue();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}

	}

	@Override
	protected String doIt() throws Exception {

		// if the invoice line item already created then it will not allow to create the
		// invoice again.
		if (invoice.getLines().length > 0)
			return "Invoice line item already created";	

		String sql = "SELECT round(sum(Qty_Receipt),2) as QtyReceived FROM TF_RMSubcon_Movement"
				+ " WHERE MovementDate >= ? AND MovementDate <= ? " + " AND C_Invoice_ID IS NULL";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DB.prepareStatement(sql, get_TrxName());
			ArrayList<Object> params = new ArrayList<Object>();
			params.add(m_DateFrom);
			params.add(m_DateTo);
			DB.setParameters(pstmt, params.toArray());
			rs = pstmt.executeQuery();		
			while (rs.next()) {
				// to create the invoice line item by clicking button Create Crusher Production Invoice line button				
				createInvoiceLineItem(rs);
			}
		} catch (SQLException e) {
			rollback();
			throw new DBException(e, sql);
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}

		return "Invoice line item created";

	}

	private void createInvoiceLineItem(ResultSet rs) throws SQLException {

		TF_MProject proj = new TF_MProject(getCtx(), invoice.getC_Project_ID(), get_TrxName());

		BigDecimal minContractAmt = proj.getMinContract_Amt();
		BigDecimal purchasePrice = MJobworkProductPrice.getPrice(getCtx(), invoice.getC_Project_ID(),
				proj.getJobWork_Product_ID(), invoice.getDateAcct());
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		BigDecimal amount = purchasePrice.multiply(rs.getBigDecimal("QtyReceived"));		
		invLine.setM_Product_ID(proj.getJobWork_Product_ID(), true);
		if (amount.compareTo(minContractAmt) < 0) {
			purchasePrice = minContractAmt;				
			invLine.setC_UOM_ID(106); 				
			invLine.setQty(1);
			
		} else {			
			invLine.setQty(rs.getBigDecimal("QtyReceived"));
			invLine.setC_UOM_ID(proj.getC_UOM_ID());
		}		
		
		invLine.setDescription(proj.getDescription());
		invLine.setPriceActual(purchasePrice);
		invLine.setPriceList(purchasePrice);
		invLine.setPriceLimit(purchasePrice);
		invLine.setPriceEntered(purchasePrice);
		invLine.setC_Tax_ID(proj.getC_Tax_ID());
		
		invLine.saveEx();

	}
}

	