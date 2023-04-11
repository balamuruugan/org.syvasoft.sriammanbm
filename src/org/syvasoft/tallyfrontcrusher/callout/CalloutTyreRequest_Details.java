package org.syvasoft.tallyfrontcrusher.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.syvasoft.tallyfrontcrusher.model.MTyre;
import org.syvasoft.tallyfrontcrusher.model.MTyreRequest;
import org.syvasoft.tallyfrontcrusher.model.MTyreRequestLine;

public class CalloutTyreRequest_Details implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		if(mTab.getValue(MTyreRequestLine.COLUMNNAME_M_Product_ID)!=null && mTab.getValue(MTyreRequestLine.COLUMNNAME_TF_Tyre_ID)!=null) {
			
			int TF_Tyre_ID=0;
			TF_Tyre_ID=(int) mTab.getValue(MTyreRequestLine.COLUMNNAME_TF_Tyre_ID);
			MTyre t=new MTyre(ctx,TF_Tyre_ID , null);
			mTab.setValue(MTyreRequestLine.COLUMNNAME_Size, t.getSize());
			mTab.setValue(MTyreRequestLine.COLUMNNAME_Brand, t.getBrand());
			mTab.setValue(MTyreRequestLine.COLUMNNAME_TF_TyreType_ID, t.getCurrent_TyreType_ID());
			
			String sql="SELECT Start_Meter "
						+"FROM TF_TyreMovement WHERE End_Meter IS NULL"
						+" AND TF_Tyre_ID=? AND Vehicle_ID=?";
			BigDecimal StartMeter = DB.getSQLValueBD(null, sql, TF_Tyre_ID, t.getMounted_To_ID());
			mTab.setValue(MTyreRequestLine.COLUMNNAME_Start_Meter, StartMeter);
			
		}
		return null;
	}

}
