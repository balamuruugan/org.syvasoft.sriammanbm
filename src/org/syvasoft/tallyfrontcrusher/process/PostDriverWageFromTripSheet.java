package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.adempiere.exceptions.DBException;
import org.compiere.process.DocAction;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MLabourWage;
import org.syvasoft.tallyfrontcrusher.model.MLabourWageConfig;
import org.syvasoft.tallyfrontcrusher.model.MQuarry;

public class PostDriverWageFromTripSheet extends SvrProcess {

	@Override
	protected void prepare() {		

	}

	@Override
	protected String doIt() throws Exception {		
		String sql = "UPDATE TF_TripSheet SET processing='I' WHERE Processed ='Y' AND TF_Labour_Wage_ID IS NULL";
		DB.executeUpdate(sql, get_TrxName());
		
		sql = " SELECT  C_BPartner_ID, DateReport, TF_VehicleType_ID, TF_Quarry_ID,  SUM(RUNNING_METER) Running_Meter FROM " +
				" TF_TripSheet ts INNER JOIN M_Product p ON ts.Vehicle_ID = p.M_Product_ID " +
				" WHERE ts.processing='I' AND ts.C_BPartner_ID IS NOT NULL " +
				" GROUP BY C_BPartner_ID, DateReport, p.TF_VehicleType_ID, TF_Quarry_ID " +
				" ORDER BY 1, 2, 3, 4 DESC ";
		int no = 0;		
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		try	{
			pstmt = DB.prepareStatement(sql.toString(), get_TrxName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				no++;
				int C_BPartner_ID = rs.getInt("C_BPartner_ID");
				Timestamp dateReport = rs.getTimestamp("DateReport");
				int TF_VehicleType_ID = rs.getInt("TF_VehicleType_ID");
				int TF_Quarry_ID = rs.getInt("TF_Quarry_ID");
				BigDecimal Running_Meter = rs.getBigDecimal("Running_Meter");
				
				sql = "SELECT  SUM(RUNNING_METER) FROM TF_TripSheet ts INNER JOIN M_Product p ON ts.Vehicle_ID = p.M_Product_ID " +
						" WHERE ts.processing='I' AND C_BPartner_ID =? AND DateReport=? AND TF_VehicleType_ID=? " +
						" GROUP BY C_BPartner_ID, DateReport, p.TF_VehicleType_ID ";
				BigDecimal totalMeter = DB.getSQLValueBD(get_TrxName(), sql, C_BPartner_ID, dateReport, TF_VehicleType_ID);				
				MLabourWageConfig wageConfig = MLabourWageConfig.getLabourWageConfig(getCtx(), C_BPartner_ID, TF_VehicleType_ID, dateReport);
				BigDecimal presentDays = Running_Meter.divide(totalMeter, 2, RoundingMode.HALF_UP);
				
				//Create Labour Wage Entry
				MLabourWage wage = new MLabourWage(getCtx(), 0, get_TrxName());
				wage.setAD_Org_ID(Env.getAD_Org_ID(getCtx()));
				wage.setDateAcct(dateReport);
				wage.setC_BPartner_ID(C_BPartner_ID);
				wage.setTF_VehicleType_ID(TF_VehicleType_ID);
				
				//If no wage config, skip to next wage entry
				if(wageConfig == null) {
					String errMsg = " NO WAGE CONFIG : Labour: " + wage.getC_BPartner().getName() + 
							" | VehicleType:" + wage.getTF_VehicleType().getName() +
							" | Account Date: " + new SimpleDateFormat("MM/dd/yyyy").format(dateReport);
					addLog(errMsg);
					continue;
				}
				
				//Create Wage Entry
				wage.setStd_Days(wageConfig.getStd_Days());
				wage.setStd_Wage(wageConfig.getStd_Wage());
				wage.setPresent_Days(presentDays);
				wage.setIncentive(BigDecimal.ZERO);
				wage.setIsCalculated(true);				
				wage.setDescription("Generated from TripSheet" );
				MQuarry quarry = new MQuarry(getCtx(), TF_Quarry_ID, get_TrxName());
				wage.setC_ElementValue_ID(quarry.getC_ElementValue_ID());
				
				wage.saveEx();
				wage.processIt(DocAction.ACTION_Prepare);
				wage.saveEx();
				//End Create
				
				//Update Wage Entry ID Ref into TripSheet Entries
				sql = "Update TF_TripSheet SET TF_Labour_Wage_ID = ? WHERE TF_Labour_Wage_ID IS NULL AND " +
						" C_BPartner_ID = ? AND DateReport = ? AND (COALESCE(TF_Quarry_ID,0) = COALESCE(?,0))" +
						" AND Vehicle_ID IN (SELECT M_Product_ID FROM M_Product WHERE TF_VehicleType_ID = ? ) ";
				ArrayList<Object> params = new ArrayList<Object>();
				params.add(wage.getTF_Labour_Wage_ID());
				params.add(C_BPartner_ID);
				params.add(dateReport);
				params.add(TF_Quarry_ID);
				params.add(TF_VehicleType_ID);				
				DB.executeUpdateEx(sql, params.toArray(), get_TrxName());
				//End Update
				
				String msg = "Labour:" + wage.getC_BPartner().getName() + 
						" | Present Days:" + wage.getPresent_Days().toString() +
						" | Wage:" + wage.getTotal_Wage().toString();
				addLog(0, null,null, msg, MLabourWage.Table_ID, wage.getTF_Labour_Wage_ID());
				
			}
		}
		catch (SQLException e) {
			rollback();
			//log.log(Level.SEVERE, "", e);
			throw new DBException(e, sql.toString());
		}
		finally	{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		sql = "UPDATE TF_TripSheet SET processing=NULL WHERE processing='I'";
		DB.executeUpdate(sql, get_TrxName());
		return no + " Wage Entries have been posted!";
	}

}
