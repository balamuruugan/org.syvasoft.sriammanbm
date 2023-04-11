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

public class CreateConsolidatedInvoiceFromUnbilledEntry extends SvrProcess {

	Timestamp dateAcct = null;
	int C_DocType_ID = 0;
	int C_Tax_ID = 0;
	Savepoint sp = null;
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if(name.equals("DateAcct"))
				dateAcct = para[i].getParameterAsTimestamp();
			else if(name.equals("C_Tax_ID"))
				C_Tax_ID = para[i].getParameterAsInt();
		}
	}

	@Override
	protected String doIt() throws Exception {
		String sql = "SELECT DISTINCT AD_Org_ID, C_BPartner_ID, IsPermitSales "
				+ " FROM TF_ConsolidatedInvoice_Detail WHERE DocStatus = 'CO' AND "
				+ "EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " 
				+ " T_Selection.AD_PInstance_ID= " + getAD_PInstance_ID() + " AND T_Selection.T_Selection_ID = TF_ConsolidatedInvoice_Detail.M_InOutLine_ID) "
				+ " GROUP BY AD_Org_ID, C_BPartner_ID, IsPermitSales";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = DB.prepareStatement(sql, get_TrxName());
			rs = pstmt.executeQuery();		
			while (rs.next()) {
				createConsolidatedInvoice(rs);
			}
		} catch (SQLException e) {
			rollback();
			throw new DBException(e, sql);
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}		
		return null;
	}
	
	private void createConsolidatedInvoice(ResultSet rsBP) throws SQLException {
		
		MTax tax = new MTax(getCtx(), C_Tax_ID, null);
		BigDecimal taxMultiplier = BigDecimal.ONE.add(tax.getRate().divide(new BigDecimal(100), 5, RoundingMode.HALF_EVEN));
		
		String whereClause = "tf_weighmententry_id IN (SELECT M_InOut.tf_weighmententry_id FROM M_InOut Where " + 
				" M_InOut_ID IN (SELECT M_InOutLine.M_InOut_ID FROM T_Selection JOIN M_InOutLine on M_InOutLine.M_InOutLine_ID = T_Selection.T_Selection_ID  "
				+ " WHERE T_Selection.AD_PInstance_ID = ?)) AND C_BPartner_ID = ? AND AD_Org_ID = ? AND  Status = 'CO' ";

		List<MWeighmentEntry> weighmententries = new Query(getCtx(),MWeighmentEntry.Table_Name,  whereClause, get_TrxName())
												.setParameters(getAD_PInstance_ID(),rsBP.getInt("C_BPartner_ID"),rsBP.getInt("AD_Org_ID")).list();
		
		for (MWeighmentEntry mWeighmentEntry : weighmententries) {
				//mWeighmentEntry.setGSTRate(tax.getRate());
				mWeighmentEntry.calculateTotalAmount();
				mWeighmentEntry.saveEx();
		}

		String sql = "SELECT c_bpartner_id, ispermitsales, m_product_id, c_uom_id, price,0 gstrate, " + 
				"	sum(netweightunit) netweightunit, round(price + Round(sum(rent_amt) / sum(netweightunit),2),2) unitprice "
				+ "	FROM tf_consolidatedinvoice_detail " + 
				"WHERE AD_Org_ID = ? AND c_bpartner_id = ? AND ispermitsales = ? AND EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " + 
				"				 	T_Selection.AD_PInstance_ID = ? AND T_Selection.T_Selection_ID = TF_ConsolidatedInvoice_Detail.M_InOutLine_ID) " + 
				"				GROUP BY c_bpartner_id, ispermitsales, m_product_id, c_uom_id, price " +
				"UNION ALL " +
				"SELECT c_bpartner_id, ispermitsales, m_product_pass_id, c_uom_id, passpriceperunit,0 gstrate, " + 
				"				 sum(permitissuedqty)netweightunit, passpriceperunit unitprice FROM tf_consolidatedinvoice_detail " + 
				"WHERE permitissuedqty > 0 AND AD_Org_ID = ? AND c_bpartner_id = ? AND ispermitsales = ? AND EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " + 
				"				 	T_Selection.AD_PInstance_ID = ? AND T_Selection.T_Selection_ID = TF_ConsolidatedInvoice_Detail.M_InOutLine_ID) " + 
				"				GROUP BY c_bpartner_id, ispermitsales, m_product_pass_id, c_uom_id, passpriceperunit;";
				
		
		PreparedStatement innerpstmt = null;
		ResultSet innerrs = null;
		Trx trx = Trx.get(get_TrxName(), false);
		try	{
			innerpstmt = DB.prepareStatement(sql, get_TrxName());
			ArrayList<Object> params = new ArrayList<Object>();
			params = new ArrayList<Object>();
			params.add(rsBP.getInt("AD_Org_ID"));
			params.add(rsBP.getInt("C_BPartner_ID"));
			params.add(rsBP.getString("IsPermitSales"));
			params.add(getAD_PInstance_ID());
			params.add(rsBP.getInt("AD_Org_ID"));
			params.add(rsBP.getInt("C_BPartner_ID"));
			params.add(rsBP.getString("IsPermitSales"));
			params.add(getAD_PInstance_ID());
			DB.setParameters(innerpstmt, params.toArray());
			innerrs = innerpstmt.executeQuery();	
			
			if(rsBP.getBoolean("ispermitsales")) {
				C_DocType_ID = TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx());
			}
			else {
				C_DocType_ID = TF_MOrder.NonGSTConsolidatedOrderDocType_ID(getCtx());
			}
			
			TF_MBPartner bp = new TF_MBPartner(getCtx(), rsBP.getInt("C_BPartner_ID"), get_TrxName());
			
			sp = trx.setSavepoint(bp.getName());
			MOrgInfo oInfo = MOrgInfo.get(getCtx(), rsBP.getInt("AD_Org_ID"), get_TrxName());
			int No_Tax_ID = MSysConfig.getIntValue("NO_TAX_ID", bp.getAD_Client_ID(), bp.getAD_Org_ID());
			int PASS_CATEGORY_ID = MSysConfig.getIntValue("PASS_CATEGORY_ID", 1000070, bp.getAD_Client_ID());
			
			//Validate invoice Date
			String sqlDate= "SELECT COUNT(*) FROM C_Order WHERE C_DocTypeTarget_ID =  ? AND DocStatus IN ('CO','CL') AND TRUNC(DateAcct) > TRUNC(?::timestamp without time zone)";
			int count = DB.getSQLValue(get_TrxName(), sqlDate, C_DocType_ID, dateAcct);
			if(count > 0) {
				String sqlLDate = "SELECT TO_CHAR(DateAcct,'DD/MM/YYYY') FROM C_Order WHERE C_DocTypeTarget_ID =  ? AND DocStatus IN ('CO','CL') ORDER BY DateAcct DESC LIMIT 1";
				String lastInvoice = DB.getSQLValueString(get_TrxName(), sqlLDate, C_DocType_ID);
				addLog("You cannot invoice prior than " + lastInvoice);
				throw new AdempiereException("To create new invoice, please select the last invoice date or later!");
			}
			
			TF_MOrder ord = new TF_MOrder(getCtx(), 0, get_TrxName());
			ord.setAD_Org_ID(rsBP.getInt("AD_Org_ID"));
			ord.setIsSOTrx(true);
			ord.setC_DocTypeTarget_ID(C_DocType_ID);
			ord.setC_DocType_ID(C_DocType_ID);
			ord.setDateAcct(dateAcct);
			ord.setDateOrdered(dateAcct);
			ord.setC_BPartner_ID(rsBP.getInt("C_BPartner_ID"));
			ord.setM_Warehouse_ID(oInfo.getM_Warehouse_ID());
			ord.setPaymentRule(TF_MOrder.PAYMENTRULE_OnCredit);
			ord.setItem1_IsPermitSales(rsBP.getBoolean("ispermitsales"));
			//Price List
			int m_M_PriceList_ID = MPriceList.getDefault(getCtx(), true).getM_PriceList_ID();							
			ord.setM_PriceList_ID(m_M_PriceList_ID);
			ord.setC_Currency_ID(MPriceList.get(getCtx(), m_M_PriceList_ID, get_TrxName()).getC_Currency_ID());
			ord.setTF_Destination_ID(bp.getTF_Destination_ID());
			ord.setOnAccount(false);
			ord.setC_Tax_ID(C_Tax_ID);
			ord.saveEx();
			
			//update Order in all the IO header
			//by BP
			
			String sqlOrderUpdate = "UPDATE M_InOut SET C_Order_ID = ? WHERE  M_InOut_ID IN (SELECT cons.M_InOut_ID FROM tf_consolidatedinvoice_detail cons " + 
									" WHERE (EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = cons.M_InOutLine_ID))"
									+ " AND cons.c_bpartner_id = ? AND cons.ispermitsales = ?)";
			
			
			params = new ArrayList<Object>();
			params.add(ord.getC_Order_ID());
			params.add(getAD_PInstance_ID());
			params.add(rsBP.getInt("C_BPartner_ID"));
			params.add(rsBP.getString("IsPermitSales"));
			DB.executeUpdateEx(sqlOrderUpdate, params.toArray(), get_TrxName());
			
			while (innerrs.next()) {
												
				BigDecimal unitprice = innerrs.getBigDecimal("unitprice");
				int M_PRoduct_ID = innerrs.getInt("m_product_id");
				BigDecimal qty = innerrs.getBigDecimal("netweightunit");				
				int C_UOM_ID = innerrs.getInt("c_uom_id");
			
				//create lines
				TF_MOrderLine ordLine = new TF_MOrderLine(ord);				
				
				TF_MProduct product = new TF_MProduct(getCtx(), innerrs.getInt("m_product_id"), get_TrxName());
				
				if(product.getM_Product_Category_ID() == PASS_CATEGORY_ID) {
					ordLine.setC_UOM_ID(product.getC_UOM_ID());
				}
				else {
					ordLine.setC_UOM_ID(C_UOM_ID);
					unitprice = innerrs.getBigDecimal("unitprice");//.multiply(taxMultiplier).setScale(2, RoundingMode.HALF_EVEN);
				}
				ordLine.setM_Product_ID(M_PRoduct_ID, C_UOM_ID);
				ordLine.setC_UOM_ID(C_UOM_ID);
				ordLine.setC_Tax_ID(C_Tax_ID);
				ordLine.setPriceActual(unitprice);
				ordLine.setPriceList(unitprice);
				ordLine.setPriceLimit(unitprice);
				ordLine.setPriceEntered(unitprice);
				ordLine.setQty(qty);				
				ordLine.saveEx();
				
				//Update all the iolines which are related for this consolidated order..
				//using update query for the IO Header associated with Order
				String sqlUpdateLine = "UPDATE M_InOutLine SET C_OrderLine_ID = ?, DocStatus = 'CL' WHERE M_InOut_ID IN (SELECT M_InOut_ID FROM M_InOut WHERE C_Order_ID = ?) "
						+ " AND M_Product_ID = ? AND C_UOM_ID = ?  AND Price = ? "
						+ " AND DocStatus = 'CO'";
				params = new ArrayList<Object>();
				params.add(ordLine.getC_OrderLine_ID());
				params.add(ordLine.getC_Order_ID());
				params.add(M_PRoduct_ID);
				params.add(C_UOM_ID);				
				params.add(innerrs.getBigDecimal("price"));
				DB.executeUpdateEx(sqlUpdateLine, params.toArray(), get_TrxName());
				
				/*String sqlUpdateWEs = "UPDATE tf_weighmententry SET Status = 'CL' WHERE  tf_weighmententry_id IN (SELECT M_InOut.tf_weighmententry_id FROM M_InOut Where " + 
										" M_InOut_ID IN (SELECT M_InOutLine.M_InOut_ID FROM T_Selection JOIN M_InOutLine on M_InOutLine.M_InOutLine_ID = T_Selection.T_Selection_ID  WHERE T_Selection.AD_PInstance_ID = ?)) " + 
										" AND C_BPartner_ID = ? AND  Status = 'CO' ";
				params = new ArrayList<Object>();
				params.add(getAD_PInstance_ID());
				params.add(rsBP.getInt("C_BPartner_ID"));		
				DB.executeUpdateEx(sqlUpdateWEs, params.toArray(), get_TrxName());*/
				
			}
			
			
			
			//complete document
			if (!ord.processIt(DocAction.ACTION_Complete))
				throw new AdempiereException("Failed when processing document - " + ord.getProcessMsg());
			ord.setDocStatus(TF_MOrder.DOCSTATUS_Completed);
			
			//ord.prepareIt();
			//ord.setDocStatus(TF_MOrder.DOCSTATUS_InProgress);
			ord.setProcessed(true);
			ord.saveEx();
											
			trx.releaseSavepoint(sp);
			addLog(ord.get_Table_ID(), null, null, " Sales Quick Entry : " +  ord.getDocumentNo() + " is created!", ord.get_Table_ID(), ord.get_ID());
		
			
		}
		catch (SQLException e) {
			rollback();
			//log.log(Level.SEVERE, "", e);
			throw new DBException(e, sql.toString());
		}
		finally	{
			DB.close(innerrs, innerpstmt);
			innerrs = null; innerpstmt = null;
		}
			
	}
}
