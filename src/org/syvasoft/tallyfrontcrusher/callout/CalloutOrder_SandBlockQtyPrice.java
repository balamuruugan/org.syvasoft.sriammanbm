package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.syvasoft.tallyfrontcrusher.model.MSandBlockBucketConfig;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrder;

public class CalloutOrder_SandBlockQtyPrice implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		
		
		BigDecimal item1_BucketQty = BigDecimal.ONE;
		BigDecimal item2_BucketQty = BigDecimal.ONE;
		BigDecimal item1_BucketRate = BigDecimal.ZERO;
		BigDecimal item2_BucketRate = BigDecimal.ZERO;
		BigDecimal item1_TonePerBucket = BigDecimal.ZERO;
		BigDecimal item2_TonePerBucket = BigDecimal.ZERO;
		BigDecimal item1_Qty = BigDecimal.ZERO;
		BigDecimal item2_Qty = BigDecimal.ZERO;
		String orgType  = (String) mTab.getValue(TF_MOrder.COLUMNNAME_OrgType);
		
		if(orgType != null)
		{
			if(!orgType.equals(TF_MOrder.ORGTYPE_SandBlockBucket) || !mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_IsSOTrx))
				return null;
			
			if(mTab.getValue(TF_MOrder.COLUMNNAME_Item1_BucketQty) != null)
				item1_BucketQty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_BucketQty);
			if(mTab.getValue(TF_MOrder.COLUMNNAME_Item2_BucketQty) != null)
				item2_BucketQty = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_BucketQty);
			if(mTab.getValue(TF_MOrder.COLUMNNAME_Item1_BucketRate) != null)
				item1_BucketRate = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_BucketRate);
			if(mTab.getValue(TF_MOrder.COLUMNNAME_Item2_BucketRate) != null)
				item2_BucketRate = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_BucketRate);
			if(mTab.getValue(TF_MOrder.COLUMNNAME_TonePerBucket) != null)
				item1_TonePerBucket = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_TonePerBucket);
			if(mTab.getValue(TF_MOrder.COLUMNNAME_Item2_TonePerBucket) != null)
				item2_TonePerBucket = (BigDecimal) mTab.getValue(TF_MOrder.COLUMNNAME_Item2_TonePerBucket);
			
			
			if(mField.getColumnName().equals(TF_MOrder.COLUMNNAME_Item1_BucketQty)) {
				boolean isPermitSales = mTab.getValueAsBoolean(TF_MOrder.COLUMNNAME_Item1_IsPermitSales);
				int tf_vehicletype_id = 0;
				if(mTab.getValue(TF_MOrder.COLUMNNAME_Item1_VehicleType_ID) != null)
					tf_vehicletype_id = (int) mTab.getValue(TF_MOrder.COLUMNNAME_Item1_VehicleType_ID);
				int orgID = (int) mTab.getValue(TF_MOrder.COLUMNNAME_AD_Org_ID) ;
				if(isPermitSales) {
					MSandBlockBucketConfig config = MSandBlockBucketConfig.getBucketConfig(orgID, MSandBlockBucketConfig.SANDTYPE_P, tf_vehicletype_id);
					if(config != null)
						mTab.setValue(TF_MOrder.COLUMNNAME_Item1_PermitIssued, item1_BucketQty.multiply(config.getPermitTonnagePerBucket()));
				}
			}
			
			item1_Qty = item1_BucketQty.multiply(item1_TonePerBucket);
			item2_Qty = item2_BucketQty.multiply(item2_TonePerBucket);
			
			BigDecimal item1_UnitPrice = BigDecimal.ZERO;
			BigDecimal item2_UnitPrice = BigDecimal.ZERO;
			
			if(item1_Qty.doubleValue()!=0) {			
				item1_UnitPrice = item1_BucketRate.multiply(item1_BucketQty).divide(item1_Qty,3, RoundingMode.HALF_EVEN);
			}
			if(item2_Qty.doubleValue() !=0) {
				item2_UnitPrice = item2_BucketRate.multiply(item2_BucketQty).divide(item2_Qty, 3, RoundingMode.HALF_EVEN);
			}	
			
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Qty, item1_Qty);		
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Price, item1_UnitPrice);
			mTab.setValue(TF_MOrder.COLUMNNAME_Item1_Amt, item1_BucketQty.multiply(item1_BucketRate).divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN));
			mTab.setValue(TF_MOrder.COLUMNNAME_Item2_Qty, item2_Qty);		
			mTab.setValue(TF_MOrder.COLUMNNAME_Item2_Price, item2_UnitPrice);
			mTab.setValue(TF_MOrder.COLUMNNAME_Item2_Amt, item2_BucketQty.multiply(item2_BucketRate).divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN));
		}
		return null;
	}

}
