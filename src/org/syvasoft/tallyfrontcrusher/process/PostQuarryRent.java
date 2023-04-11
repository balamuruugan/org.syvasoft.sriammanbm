package org.syvasoft.tallyfrontcrusher.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;

import org.adempiere.exceptions.DBException;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.model.MBoulderReceipt;
import org.syvasoft.tallyfrontcrusher.model.MQuarryRent;
import org.syvasoft.tallyfrontcrusher.model.MQuarryRentConfig;

public class PostQuarryRent extends SvrProcess {

	private int m_AD_Client_ID = 0;
	private int m_AD_Org_ID = 0;
	private boolean isSimulate = false;
	private Timestamp m_DateAcct = null;
	private Timestamp m_DateReceipt_1 = null;
	private Timestamp m_DateReceipt_2 = null;
	private int m_TF_Quarry_ID = 0;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		m_AD_Client_ID = Env.getAD_Client_ID(getCtx());
		for (int i = 0; i < para.length; i++)
		{						
			String name = para[i].getParameterName();			
			if (name.equals("AD_Org_ID"))				
				m_AD_Org_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("TF_Quarry_ID"))
				m_TF_Quarry_ID = ((BigDecimal)para[i].getParameter()).intValue();			
			else if (name.equals("IsSimulate"))
				isSimulate = para[i].getParameterAsBoolean();
			else if (name.equals("DateAcct"))
				m_DateAcct = para[i].getParameterAsTimestamp();
			else if (name.equals("DateReceipt")) {
				m_DateReceipt_1 = para[i].getParameterAsTimestamp();
				m_DateReceipt_2 = para[i].getParameter_ToAsTimestamp();
			}
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
	}

	@Override
	protected String doIt() throws Exception {
		String where = "TF_Quarry_ID = ? AND DocStatus = 'CO' AND Processed = 'Y' "  + //AND DateReceipt >= ? AND DateReceipt <= ?  " +
				" AND TF_Quarry_Rent_ID IS NULL " ;
	
		/*Commented to calculate No of load from Boulder Receipt Line.
		 *  String sql = "SELECT TF_Quarry_ID, Sum (vt.Std_Load) NoOfLoad " + 
					" FROM	TF_Boulder_Receipt br INNER JOIN M_Product p 	ON br.Vehicle_ID = p.M_Product_ID " +
					" INNER JOIN TF_VehicleType vt 	ON p.TF_VehicleType_ID = vt.TF_VehicleType_ID " +
					" WHERE " + where +  
					" GROUP BY TF_Quarry_ID";
		*/
		String sql = " SELECT TF_Quarry_ID, Sum (load) NoOfLoad FROM TF_Boulder_Receipt br INNER JOIN TF_Boulder_Receipt_Line bl " +
					" ON br.TF_Boulder_Receipt_ID = bl.TF_Boulder_Receipt_ID " +
				    " WHERE " + where + 
				    " GROUP BY TF_Quarry_ID";
		int no = 0;		
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		try	{
			pstmt = DB.prepareStatement(sql.toString(), get_TrxName());
			ArrayList<Object> params = new ArrayList<Object>();
			params.add(m_TF_Quarry_ID);
			//params.add(m_DateReceipt_1);
			//params.add(m_DateReceipt_2);
			DB.setParameters(pstmt,params.toArray());
			rs = pstmt.executeQuery();			
			while (rs.next()) {
				no++;				
				BigDecimal noofLoad = rs.getBigDecimal("NoOfLoad");
				MQuarryRentConfig rentConfig = MQuarryRentConfig.getMQuarryRentConfig(getCtx(), m_TF_Quarry_ID, m_DateAcct);
				//Create Vehicle Rent Entry
				MQuarryRent rent = new MQuarryRent(getCtx(), 0, get_TrxName());
				rent.setAD_Org_ID(m_AD_Org_ID);
				rent.setDateAcct(m_DateAcct);
				rent.setTF_Quarry_ID(m_TF_Quarry_ID);
				
				//If no salary config, skip to next salary entry.
				if(rentConfig == null) {					
					String errMsg = " NO RENT CONFIG -> Quarry:" + rent.getTF_Quarry().getName()  +							 
							" | Account Date:" + new SimpleDateFormat("MM/dd/yyyy").format(m_DateAcct);
					addLog(errMsg);
					continue;
				}
				//Create Quarry Rent Entry
				if(!isSimulate) {
					rent.setNoOfLoad(noofLoad);					
					rent.setStd_Rent(rentConfig.getStd_Rent());					
					rent.setIsCalculated(true);
					rent.setDescription("Generated from Boulder Receipts");									
					//rent.setDateFrom(m_DateReceipt_1);
					//rent.setDateTo(m_DateReceipt_2);
					rent.setC_ElementValue_ID(rent.getTF_Quarry().getC_ElementValue_ID());
					rent.saveEx();
					rent.processIt(MBoulderReceipt.DOCACTION_Complete);
					rent.saveEx();
					//End Quarry Rent Entry
					
					//Update Quarry Rent ID
					sql = " UPDATE TF_Boulder_Receipt SET TF_Quarry_Rent_ID = ? WHERE " + where;
					params = new ArrayList<Object>();
					params.add(rent.getTF_Quarry_Rent_ID());
					params.add(m_TF_Quarry_ID);
					//params.add(m_DateReceipt_1);
					//params.add(m_DateReceipt_2);										
					DB.executeUpdateEx(sql, params.toArray(), get_TrxName());
					//End Update
					
					String msg = "Quarry:" + rent.getTF_Quarry().getName() + 
								" | No of load:" + rent.getNoOfLoad().toString() +
								" | Rent:" + rent.getRent_Amt().toString();
					addLog(0, null,null, msg, MQuarryRent.Table_ID, rent.getTF_Quarry_Rent_ID());
				}// End Create
				else {
					String msg = "Quarry:" + rent.getTF_Quarry().getName() + 
							" | No of load:" + noofLoad.toString() +
							" | Rent:" + rentConfig.getStd_Rent().multiply(noofLoad).toString();
					addLog(msg);
				}
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
			
		if(isSimulate)
			return no + " Quarry Rent Entries will be posted!";
		else 
			return no + " Quarry Rent Entries have been posted!";
		
	}

}
