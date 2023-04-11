package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MInventory;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MProduct;
import org.compiere.model.MWarehouse;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class SetOpeningStock extends SvrProcess {

	private int m_AD_Client_ID = 0;
	private int m_AD_Org_ID = 0;
	private Timestamp MovementDate = null;
	private boolean IsReversePrevOpeningStock = false;
	private int C_DocType_ID = 0;
	private int M_Product_ID = 0;
	private BigDecimal OpeningStock = BigDecimal.ZERO;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		m_AD_Client_ID = Env.getAD_Client_ID(getCtx());
		m_AD_Org_ID = Env.getAD_Org_ID(getCtx());
		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
			if (name.equals("M_Product_ID"))
				M_Product_ID = para[i].getParameterAsInt();
			else if (name.equals("MovementDate")) 
				MovementDate = para[i].getParameterAsTimestamp();			
			else if (name.equals("OpeningStock")) 
				OpeningStock = para[i].getParameterAsBigDecimal();			
			else if (name.equals("IsReversePrevOpeningStock"))
				IsReversePrevOpeningStock = para[i].getParameterAsString().equals("Y");			
			else if (name.equals("C_DocType_ID"))
				C_DocType_ID = para[i].getParameterAsInt();			
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}


	}

	@Override
	protected String doIt() throws Exception {
		int M_Warehouse_ID = Env.getContextAsInt(getCtx(), "#M_Warehouse_ID");
		MWarehouse wh = MWarehouse.get(getCtx(), M_Warehouse_ID, get_TrxName());
		MProduct prod = new MProduct(getCtx(), M_Product_ID, get_TrxName());
		
		int M_Inventory_ID = prod.get_ValueAsInt("M_Inventory_ID");
		
		if(M_Inventory_ID > 0 && !IsReversePrevOpeningStock)
			throw new AdempiereException("Please select [Reverse Prev. Opening Stock]");		
		else if (M_Inventory_ID == 0 || (M_Inventory_ID > 0 && IsReversePrevOpeningStock)) {
		
			if(IsReversePrevOpeningStock) {
				MInventory prevInv = new MInventory(getCtx(), M_Inventory_ID, get_TrxName());
				if (!prevInv.processIt(DocAction.ACTION_Reverse_Correct))
					throw new AdempiereException("Failed when processing document - " + prevInv.getProcessMsg());
				prevInv.saveEx();
			}
			
			//Physical Inventory Header
			MInventory inv = new MInventory(getCtx(), 0, get_TrxName());
			inv.setC_DocType_ID(C_DocType_ID);
			String desc = prod.getName() + " Opening Stock Entry ";
			inv.setM_Warehouse_ID(M_Warehouse_ID);
			inv.setDescription(desc);
			inv.setMovementDate(MovementDate);					
			inv.setDocStatus(MInventory.DOCSTATUS_Drafted);		
			inv.saveEx();
			//End Physical Inventory Header
			
			
			//Inventory Line
			int M_Locator_ID = wh.getDefaultLocator().get_ID();
			String sql = "SELECT SUM(QtyOnHand) FROM M_StorageOnHand "
					+ "WHERE M_Product_ID=?"	//	1
					+ " AND M_Locator_ID=?";
			BigDecimal QtyBook = DB.getSQLValueBD(get_TrxName(), sql, M_Product_ID, M_Locator_ID);
			if(QtyBook == null)
				QtyBook = BigDecimal.ZERO;
			BigDecimal QtyCount = QtyBook.add(OpeningStock);
			MInventoryLine invLine = new MInventoryLine(inv, M_Locator_ID, M_Product_ID, 0, QtyBook, QtyCount, null); 
			invLine.setInventoryType(MInventoryLine.INVENTORYTYPE_InventoryDifference);
			invLine.setDescription(inv.getDescription());
			invLine.saveEx();
			//Inventory Line
			
			inv.processIt(DocAction.ACTION_Complete);
			inv.saveEx();
			
			//Update Inventory ID back to Product Master.
			prod.set_ValueOfColumn("M_Inventory_ID", inv.getM_Inventory_ID());		
			prod.saveEx();
			
			return "Opening Stock has been set!";
		}
		
		return null;
	}

}
