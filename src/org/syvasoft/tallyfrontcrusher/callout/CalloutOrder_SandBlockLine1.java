package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MSandBlockBucketConfig;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_SandBlockLine1 implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(value != null)
		{
			String orgType  = (String) mTab.getValue(TF_MOrder.COLUMNNAME_OrgType);
			boolean isPermitSales = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_Item1_IsPermitSales);
			
			if(orgType != null)
			{
				if(orgType.equals(TF_MOrder.ORGTYPE_SandBlockWeighbridge)) {
					if(isPermitSales)
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_SandType, TF_MOrder.ITEM1_SANDTYPE_PermitSand);
					else
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_SandType, TF_MOrder.ITEM1_SANDTYPE_WithoutPermit);
				}
				
				if(!orgType.equals(TF_MOrder.ORGTYPE_SandBlockBucket) || !mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsSOTrx))
					return null;
				
				if(mTab.getValue(TF_MOrder.COLUMNNAME_C_BPartner_ID) == null)
					return null;
				
				
				int tf_vehicletype_id = 0;
				if(mTab.getValue(TF_MOrder.COLUMNNAME_Item1_VehicleType_ID) != null)
					tf_vehicletype_id = (int) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_VehicleType_ID);
				int orgID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_AD_Org_ID) ;
				MSandBlockBucketConfig config ;
				if(isPermitSales) {			
					if(!mField.getColumnName().equals(TF_MOrder.COLUMNNAME_Item2_BucketQty)) {
						if(mField.getColumnName().equals(TF_MOrder.COLUMNNAME_Item1_BucketQty)) {
							BigDecimal item1_BucketQty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_BucketQty);
							if(item1_BucketQty.equals(BigDecimal.ZERO)) {
								mTab.setValue(TF_MOrder.COLUMNNAME_Item1_ID, null);
								return null;
							}
							else if (mTab.getValue(TF_MOrder.COLUMNNAME_Item1_ID) != null) {
								return null;
							}					
						}
						config = MSandBlockBucketConfig.getBucketConfig(orgID, MSandBlockBucketConfig.SANDTYPE_P, tf_vehicletype_id);
						if(config == null) {
							mTab.setValue(TF_MOrder.COLUMNNAME_Item1_ID, null);
							mTab.setValue(TF_MOrder.COLUMNNAME_Item1_SandType, null);
							mTab.setValue(TF_MOrder.COLUMNNAME_Item1_BucketRate, BigDecimal.ZERO);
							mTab.setValue(TF_MOrder.COLUMNNAME_TonePerBucket, BigDecimal.ZERO);
							mTab.setValue(TF_MOrder.COLUMNNAME_TF_RentedVehicle_ID, null);
							
							if(tf_vehicletype_id != 0) 
								return "Sand Block Bucket Configuration is not found for Current Vehicle Type & Sand Type!";
							return null;
						}
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_ID, config.getM_Product_ID());
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_SandType, config.getSandType());
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_BucketRate, config.getSalesRatePerBucket());
						mTab.setValue(TF_MOrder.COLUMNNAME_TonePerBucket, config.getSalesTonnagePerBucket());
						BigDecimal price = config.getSalesRatePerBucket().divide(config.getSalesTonnagePerBucket(), 3, RoundingMode.HALF_EVEN);
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Price, price);
					}
					
													
				}
				else {
					config = MSandBlockBucketConfig.getBucketConfig(orgID, MSandBlockBucketConfig.SANDTYPE_W, tf_vehicletype_id);
					if(config == null) {
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_ID, null);
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_SandType, null);
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_BucketRate, BigDecimal.ZERO);
						mTab.setValue(TF_MOrder.COLUMNNAME_TonePerBucket, BigDecimal.ZERO);
						mTab.setValue(TF_MOrder.COLUMNNAME_TF_RentedVehicle_ID, null);
						if(tf_vehicletype_id != 0)
							return ("Sand Block Bucket Configuration is not found for Current Vehicle Type & Sand Type!");
						return null;
					}
					mTab.setValue(TF_MOrder.COLUMNNAME_Item1_ID, config.getM_Product_ID());
					mTab.setValue(TF_MOrder.COLUMNNAME_Item1_SandType, config.getSandType());
					mTab.setValue(TF_MOrder.COLUMNNAME_Item1_BucketRate, config.getSalesRatePerBucket());
					mTab.setValue(TF_MOrder.COLUMNNAME_TonePerBucket, config.getSalesTonnagePerBucket());
					mTab.setValue(TF_MOrder.COLUMNNAME_Item2_ID, null);
					mTab.setValue(TF_MOrder.COLUMNNAME_Item1_PermitIssued, BigDecimal.ZERO);
				}
				
				BigDecimal item2_BucketQty = BigDecimal.ZERO;
				if(mField.getColumnName().equals(TF_MOrder.COLUMNNAME_Item2_BucketQty)) {
					if(mTab.getValue(TF_MOrder.COLUMNNAME_Item2_BucketQty) != null)
						item2_BucketQty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_BucketQty);
					if(item2_BucketQty.doubleValue() != 0) {
						config = MSandBlockBucketConfig.getBucketConfig(orgID, MSandBlockBucketConfig.SANDTYPE_X, 0);
						if(config == null) {
							mTab.setValue(TF_MOrder.COLUMNNAME_Item2_ID, null);
							mTab.setValue(TF_MOrder.COLUMNNAME_Item2_SandType, null);
							mTab.setValue(TF_MOrder.COLUMNNAME_Item2_BucketRate, BigDecimal.ZERO);
							mTab.setValue(TF_MOrder.COLUMNNAME_Item2_TonePerBucket, BigDecimal.ZERO);						
							return ("Sand Block Bucket Configuration is not found for Extra Bucket!");
						}
						mTab.setValue(TF_MOrder.COLUMNNAME_Item2_ID, config.getM_Product_ID());
						mTab.setValue(TF_MOrder.COLUMNNAME_Item2_SandType, config.getSandType());
						mTab.setValue(TF_MOrder.COLUMNNAME_Item2_BucketRate, config.getSalesRatePerBucket());
						mTab.setValue(TF_MOrder.COLUMNNAME_Item2_TonePerBucket, config.getSalesTonnagePerBucket());
					}
					else {
						mTab.setValue(TF_MOrder.COLUMNNAME_Item2_ID, null);
					}
				}	
				
				//mTab.setValue(TF_MOrder.COLUMNNAME_Item2_ID, item1_id);
				//mTab.setValue(TF_MOrder.COLUMNNAME_Item2_Tax_ID, item1_tax);
				//mTab.setValue(TF_MOrder.COLUMNNAME_Item2_UOM_ID, item1_uom);
				//mTab.setValue(TF_MOrder.COLUMNNAME_Item2_Price, unitPrice);		
				
				return null;
			}
		}
		return null;
	}
}
