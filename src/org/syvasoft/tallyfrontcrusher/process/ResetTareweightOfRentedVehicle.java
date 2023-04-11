package org.syvasoft.tallyfrontcrusher.process;

import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

public class ResetTareweightOfRentedVehicle extends SvrProcess {

	@Override
	protected void prepare() {
		
	}

	@Override
	protected String doIt() throws Exception {

		String sql = "UPDATE TF_RentedVehicle SET OldTareWeight = TareWeight "
				+ " WHERE IsTransporter='N'";
		DB.executeUpdate(sql, get_TrxName());
		
		sql = "UPDATE TF_RentedVehicle SET DateTareweightExpiry = NULL, "
				+ "TareWeight = NULL WHERE IsTransporter='N'";
		DB.executeUpdate(sql, get_TrxName());
		return null;
	}

}
