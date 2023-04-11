package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MInventory;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MWarehouse;
import org.compiere.process.DocAction;
import org.compiere.util.DB;

public class MItemReceiptOtherSrc extends X_TF_ItemReceipt_OtherSrc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6285975378188106418L;

	public MItemReceiptOtherSrc(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MItemReceiptOtherSrc(Properties ctx, int TF_ItemReceipt_OtherSrc_ID,
			String trxName) {
		super(ctx, TF_ItemReceipt_OtherSrc_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public void processIt(String docAction) {
		if(DocAction.ACTION_Prepare.equals(docAction)) {
			setDocStatus(DOCSTATUS_InProgress);
		}
		else if(DocAction.ACTION_Complete.equals(docAction)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
			
			//Physical Inventory Header
			MInventory inv = new MInventory(getCtx(), 0, get_TrxName());
			inv.setC_DocType_ID(1000023);
			String desc = getDescription();
			inv.setM_Warehouse_ID(getM_Warehouse_ID());
			inv.setDescription(desc);
			inv.setMovementDate(getDateAcct());					
			inv.setDocStatus(MInventory.DOCSTATUS_Drafted);		
			inv.saveEx();
			//End Physical Inventory Header
			
			MWarehouse wh = new MWarehouse(getCtx(), getM_Warehouse_ID(), get_TrxName());
			
			//Inventory Line
			int M_Locator_ID = wh.getDefaultLocator().get_ID();
			String sql = "SELECT SUM(QtyOnHand) FROM M_StorageOnHand "
					+ "WHERE M_Product_ID=?"	//	1
					+ " AND M_Locator_ID=?";
			BigDecimal QtyBook = DB.getSQLValueBD(get_TrxName(), sql, getM_Product_ID(), M_Locator_ID);
			BigDecimal QtyCount = QtyBook.add(getQty());
			TF_MCharge ch = TF_MCharge.createChargeFromAccount(getCtx(), getC_ElementValue_ID(), null);
			MInventoryLine invLine = new MInventoryLine(inv, M_Locator_ID, getM_Product_ID(), 0, QtyBook, QtyCount, null); 
			invLine.setInventoryType(MInventoryLine.INVENTORYTYPE_ChargeAccount);			
			invLine.setC_Charge_ID(ch.getC_Charge_ID());
			invLine.setDescription(inv.getDescription());
			invLine.saveEx();
			//Inventory Line
			
			inv.processIt(DocAction.ACTION_Complete);
			inv.saveEx();
			
			setM_Inventory_ID(inv.getM_Inventory_ID());
		}
	}
	
	public void reverseIt() {
		if(getM_Inventory_ID() > 0) {
			
			MInventory inv = new MInventory(getCtx(), getM_Inventory_ID(), get_TrxName());
			inv.reverseCorrectIt();
			inv.saveEx();
			
			setM_Inventory_ID(0);
			setProcessed(false);
			setDocStatus(DOCSTATUS_Drafted);
		}
	}
}
