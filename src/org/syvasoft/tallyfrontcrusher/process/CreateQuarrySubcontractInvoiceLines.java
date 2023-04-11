package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.exceptions.DBException;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MDestination;
import org.syvasoft.tallyfrontcrusher.model.MJobworkProductPrice;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoice;
import org.syvasoft.tallyfrontcrusher.model.MTRTaxInvoiceLine;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MBankAccount;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MProduct;
import org.syvasoft.tallyfrontcrusher.model.TF_MProject;

public class CreateQuarrySubcontractInvoiceLines extends SvrProcess {
	
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
		
		recordID = getRecord_ID(); //invoice id where cluase to get the current contract id
		//get invoice id from		
		invoice = new TF_MInvoice(getCtx(), recordID, get_TrxName()); 
		ProcessInfoParameter[] para = getParameter();
		m_AD_Client_ID = Env.getAD_Client_ID(getCtx());
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();			
	
			if (name.equals("DateFrom")) 
				m_DateFrom = para[i].getParameterAsTimestamp();
			else if (name.equals("DateTo")) 
				m_DateTo = para[i].getParameterAsTimestamp();			
			else if (name.equals("C_Project_ID")) 
				m_C_Project_ID = ((BigDecimal)para[i].getParameter()).intValue();		
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}

	}

	@Override
	protected String doIt() throws Exception {
		
		// if the invoice line item already created then it will not allow to create the invoice again.
		if(invoice.getLines().length>0)
			return "Invoice line item already created";
		
		String sql = "SELECT Max(C_Project_ID) as C_Project_ID,round(sum(QtyReceived),2) as QtyReceived,Max(C_UOM_ID) as C_UOM_ID, " + 
				"JobWork_Product_ID FROM TF_Boulder_Receipt WHERE Subcontractor_ID  = ? AND C_Project_ID = ? " + 
				" AND DateReceipt  >=? AND DateReceipt  <=?  " + 
				" AND DocStatus='CO'  "
				+ "AND Subcon_Invoice_ID IS NULL "
				+ "GROUP BY JobWork_Product_ID";
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DB.prepareStatement(sql, get_TrxName());
			ArrayList<Object> params = new ArrayList<Object>();
			
			params.add(invoice.getC_BPartner_ID()); 
			params.add(m_C_Project_ID);
			params.add(m_DateFrom);
			params.add(m_DateTo);			
		
			DB.setParameters(pstmt,params.toArray());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//to create the invoice line item by clicking button Create Quarry Subcontract Invoice Line
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

	private void createInvoiceLineItem(ResultSet rs) throws SQLException
	{		
				
		TF_MProject proj = new TF_MProject(getCtx(), rs.getInt("C_Project_ID"), get_TrxName());		
		proj.getC_Tax_ID();
		proj.getContract_Amt_Act();
			
			
		BigDecimal purchasePrice = MJobworkProductPrice.getPrice(getCtx(), rs.getInt("C_Project_ID"), rs.getInt("JobWork_Product_ID"), invoice.getDateAcct());
		//invoice.getLines().length
				
		MInvoiceLine invLine = new MInvoiceLine(invoice);
		invLine.setM_Product_ID(rs.getInt("JobWork_Product_ID") , true);				
		invLine.setQty(rs.getBigDecimal("QtyReceived"));		
		invLine.setDescription(proj.getDescription());		
		invLine.setPriceActual(purchasePrice);
		invLine.setPriceList(purchasePrice);
		invLine.setPriceLimit(purchasePrice);
		invLine.setPriceEntered(purchasePrice);		
		invLine.setC_Tax_ID(proj.getC_Tax_ID());
		invLine.saveEx();
		
		//Invoice Line - Vehicle Rental Charge				
	}

	
}