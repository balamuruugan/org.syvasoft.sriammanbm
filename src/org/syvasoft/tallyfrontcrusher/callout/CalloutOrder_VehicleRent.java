package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MSysConfig;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MLumpSumRentConfig;
import org.syvasoft.tallyfrontcrusher.model.MRentedVehicle;
import org.syvasoft.tallyfrontcrusher.model.MWeighmentEntry;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_VehicleRent implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int TF_VehicleType_ID=0;
		BigDecimal Distance=BigDecimal.ZERO;
		BigDecimal RentAmt=BigDecimal.ZERO;
		BigDecimal Tonnage=BigDecimal.ZERO;

		int TF_Destination_ID = 0;
		int AD_Org_ID = 0;
		int TF_RentedVehicle_ID=0;
		int C_BPartner_ID = 0;
		int M_Product_ID = 0;
		int Vendor_ID = 0;
		
		if(mTab.getValue(TF_MOrder.COLUMNNAME_AD_Org_ID) != null) {
			AD_Org_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_AD_Org_ID);
		}
		if(mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID) != null) {
			C_BPartner_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID);
		}
		if(mTab.getValue(TF_MOrder.COLUMNNAME_TF_Destination_ID) != null) {
			TF_Destination_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_TF_Destination_ID);
		}
		if(mTab.getValue(TF_MOrder.COLUMNNAME_Item1_VehicleType_ID) != null) {
			TF_VehicleType_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_VehicleType_ID);
		}
		if(mTab.getValue(TF_MOrder.COLUMNNAME_Distance) != null) {
			Distance = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Distance);
		}
		if(mTab.getValue(TF_MOrder.COLUMNNAME_Item1_ID) != null) {
			M_Product_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_ID);
		}
		if(mTab.getValue(TF_MOrder.COLUMNNAME_TF_RentedVehicle_ID) != null) {
			TF_RentedVehicle_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_TF_RentedVehicle_ID);
		}
		
		if(mTab.getValue(TF_MOrder.COLUMNNAME_Tonnage) != null) {
			Tonnage = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Tonnage);
		}
		
/*
		if(TF_RentedVehicle_ID>0) {
			MRentedVehicle rv = new MRentedVehicle(ctx, TF_RentedVehicle_ID, null);
			Vendor_ID = rv.getC_BPartner_ID();
			//String TonnageBaseRent="N"; // MSysConfig.getValue("TONNAGE_VEHICLE_RENT","N");
			BigDecimal RateMT = MLumpSumRentConfig.getRateMT(ctx, AD_Org_ID, Vendor_ID, C_BPartner_ID, M_Product_ID, TF_Destination_ID, TF_VehicleType_ID, Distance, null);
			BigDecimal RateKM = MLumpSumRentConfig.getRateKm(ctx, AD_Org_ID, Vendor_ID, C_BPartner_ID, M_Product_ID, TF_Destination_ID, TF_VehicleType_ID, Distance, null);
			BigDecimal RateMTKM = MLumpSumRentConfig.getRateMTKm(ctx, AD_Org_ID, Vendor_ID, C_BPartner_ID, M_Product_ID, TF_Destination_ID, TF_VehicleType_ID, Distance, null);
			
			int TF_WeighmentEntry_ID = 0; 
			if(mTab.getValue(TF_MOrder.COLUMNNAME_TF_WeighmentEntry_ID) != null)
				TF_WeighmentEntry_ID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_TF_WeighmentEntry_ID);
			
			MWeighmentEntry we = new MWeighmentEntry(ctx, TF_WeighmentEntry_ID, null);
			int Rent_UOM_ID = 0;
			
			if(we.getRent_Amt().doubleValue() > 0) {
				RentAmt = we.getRent_Amt();
				mTab.setValue(TF_MOrder.COLUMNNAME_IsLumpSumRent, true);
				Rent_UOM_ID = MSysConfig.getIntValue("LOAD_UOM", 1000072, Env.getAD_Client_ID(ctx));
			}
			else if(RateMT.doubleValue() > 0) {
				mTab.setValue(TF_MOrder.COLUMNNAME_Rate, RateMT);
				RentAmt = RateMT.multiply(Tonnage);
				Rent_UOM_ID = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, Env.getAD_Client_ID(ctx));
			}
			else if(RateKM.doubleValue() > 0) {
				mTab.setValue(TF_MOrder.COLUMNNAME_Rate, RateKM);
				RentAmt = RateKM.multiply(Distance);
				Rent_UOM_ID = MSysConfig.getIntValue("KM_UOM", 1000071, Env.getAD_Client_ID(ctx));
			}
			else if(RateMTKM.doubleValue() > 0) {
				mTab.setValue(TF_MOrder.COLUMNNAME_Rate, RateMTKM);
				RentAmt = RateMTKM.multiply(Distance).multiply(Tonnage);
				Rent_UOM_ID = MSysConfig.getIntValue("KM_UOM", 1000071, Env.getAD_Client_ID(ctx));
			}
			else {								
				RentAmt=MLumpSumRentConfig.getLumpSumRent(ctx,AD_Org_ID,Vendor_ID, C_BPartner_ID, M_Product_ID, TF_Destination_ID, TF_VehicleType_ID, Distance, null);
				//if(RentAmt.doubleValue() > 0)
				mTab.setValue(TF_MOrder.COLUMNNAME_IsLumpSumRent, true);
				Rent_UOM_ID = MSysConfig.getIntValue("LOAD_UOM", 1000072, Env.getAD_Client_ID(ctx));
			}
			
			if(RentAmt.doubleValue() > 0)
				mTab.setValue(TF_MOrder.COLUMNNAME_Rent_Amt, RentAmt);
			
			mTab.setValue(TF_MOrder.COLUMNNAME_Rent_UOM_ID, Rent_UOM_ID == 0 ? null : Rent_UOM_ID);
			
		}
		*/
		return null;
	
	}
}
