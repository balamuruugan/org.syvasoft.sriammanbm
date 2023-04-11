package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.util.IProcessUI;
import org.compiere.acct.Doc;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.MClient;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MDestination;
import org.syvasoft.tallyfrontcrusher.model.MLumpSumRentConfig;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MBPartner;
import org.syvasoft.tallyfrontcrusher.model.TF_MInOut;
import org.syvasoft.tallyfrontcrusher.model.TF_MInOutLine;
import org.syvasoft.tallyfrontcrusher.model.TF_MInvoice;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;
import org.syvasoft.tallyfrontcrusher.model.TF_MPayment;

public class UpdateTransporterDC extends SvrProcess {
	
	private int Freight_UOM_ID = 0;
	private BigDecimal GrossRent = BigDecimal.ZERO;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();		
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();
		
			if(name.equals("FreightRule_ID"))
				Freight_UOM_ID = para[i].getParameterAsInt();
			if(name.equals("GrossRent"))
				GrossRent = para[i].getParameterAsBigDecimal();
			
		}

	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = " DocStatus IN ('CO','UR') AND EXISTS (SELECT T_Selection_ID FROM T_Selection WHERE " +
				" T_Selection.AD_PInstance_ID=? AND T_Selection.T_Selection_ID = M_InOutLIne.M_InOutLIne_ID)";
		
		List<TF_MInOutLine> list = new Query(getCtx(), TF_MInOutLine.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getAD_PInstance_ID())
				.setOrderBy("(SELECT C_BPartner_ID FROM M_InOut WHERE M_InOut.M_InOut_ID = M_InOutLine.M_InOut_ID), "
						+ "(SELECT MovementDate FROM M_InOut WHERE M_InOut.M_InOut_ID = M_InOutLine.M_InOut_ID)")
				.list();
		
		for(TF_MInOutLine ioLine : list) {
			TF_MInOut inout = new TF_MInOut(getCtx(), ioLine.getM_InOut_ID(), get_TrxName());
			MWeighmentEntry we = new MWeighmentEntry(getCtx(), inout.getTF_WeighmentEntry_ID(), get_TrxName());
			
			MDestination dest = new MDestination(getCtx(), we.getTF_Destination_ID(), get_TrxName());
			MRentedVehicle rv = new MRentedVehicle(getCtx(), we.getTF_RentedVehicle_ID(), get_TrxName());
			TF_MBPartner bp = new TF_MBPartner(getCtx(), rv.getC_BPartner_ID(), get_TrxName());
			
			int Rent_UOM_ID = 0;
			BigDecimal qty = BigDecimal.ZERO;
			BigDecimal price = BigDecimal.ZERO;		
			BigDecimal rentMargin = BigDecimal.ZERO;
			
			int Load_UOM_ID = MSysConfig.getIntValue("LOAD_UOM", 1000072, we.getAD_Client_ID());
			int KM_UOM_ID = MSysConfig.getIntValue("KM_UOM", 1000071, we.getAD_Client_ID());
			int MT_KM_UOM_ID = MSysConfig.getIntValue("MT_KM_UOM", 1000093, we.getAD_Client_ID());
			int MT_UOM = MSysConfig.getIntValue("MT_UOM", 1000069, we.getAD_Client_ID());
			
			BigDecimal RateMTKM = BigDecimal.ZERO;
			BigDecimal Distance = BigDecimal.ZERO;
			//Get Vehicle Rent from Shipment Line
			whereClause = "M_InOut_ID = ? AND M_Product_ID = ? ";
			TF_MInOutLine srcLine = new Query(getCtx(), TF_MInOutLine.Table_Name, whereClause, get_TrxName())
					.setClient_ID()
					.setParameters(ioLine.getM_InOut_ID(), rv.getM_Product_ID())
					.first();
			
			boolean ENABLE_TRANSPORTER_RENT_CONFIG = MSysConfig.getBooleanValue("ENABLE_TRANSPORTER_RENT_CONFIG", false, Env.getAD_Client_ID(getCtx()));
			
			
			Rent_UOM_ID = Freight_UOM_ID;
			
			if(Freight_UOM_ID == Load_UOM_ID)
			{
				Rent_UOM_ID = Load_UOM_ID;
				qty = BigDecimal.ONE;
				
			}
			else if(Freight_UOM_ID == KM_UOM_ID)
			{
				Rent_UOM_ID = KM_UOM_ID;
				qty = dest.getDistance();									
			}
			else if(Freight_UOM_ID == MT_KM_UOM_ID)
			{
				Rent_UOM_ID = MT_KM_UOM_ID;
				qty = we.getMT();									
				RateMTKM = price;
			}
			else if(Freight_UOM_ID == MT_UOM)
			{
				Rent_UOM_ID = MT_UOM;
				qty = we.getMT();									
				RateMTKM = price;
			}
			else
			{
				Rent_UOM_ID = Freight_UOM_ID;
				
				if(Rent_UOM_ID == we.getC_UOM_ID())
					qty = we.getNetWeightUnit();
				else
					qty = BigDecimal.ZERO;
			}
				
			ioLine.setQty(qty);
			
			ioLine.setC_UOM_ID(Rent_UOM_ID);
			ioLine.setTF_Destination_ID(we.getTF_Destination_ID());
			ioLine.setDistance(dest.getDistance());
			ioLine.setRateMTKM(RateMTKM);
			
			if(GrossRent.doubleValue() > 0)
				ioLine.setPrice(GrossRent);
			
		
			ioLine.set_ValueOfColumn("DocStatus", MWeighmentEntry.STATUS_Unbilled);
			if(we.getTF_Destination_ID() > 0)
				ioLine.setDescription("Destination : " + dest.getName());
			
			ioLine.saveEx();
		}
		
		return null;
	}

}
