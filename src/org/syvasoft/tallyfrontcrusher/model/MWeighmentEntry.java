package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MDocType;
import org.compiere.model.MInOutLine;
import org.compiere.model.MProduct;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.model.MUOM;
import org.compiere.model.MUOMConversion;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.syvasoft.tallyfrontcrusher.callout.CalloutUtil;



public class MWeighmentEntry extends X_TF_WeighmentEntry {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2613943323993702690L;
	
	public static String DayShiftStartTime =  MSysConfig.getValue("DAY_SHIFT_START_TIME", "06:00 AM"); 
	public static String DayShiftEndTime =  MSysConfig.getValue("DAY_SHIFT_END_TIME", "06:00 PM");
	public static String NightShiftStartTime =  MSysConfig.getValue("NIGHT_SHIFT_START_TIME", "06:00 PM");
	public static String NightShiftEndTime =  MSysConfig.getValue("NIGHT_SHIFT_END_TIME", "06:00 AM");
	
	private static final CLogger s_log = CLogger.getCLogger(MWeighmentEntry.class);
	
	public MWeighmentEntry(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	public MWeighmentEntry(Properties ctx, int TF_WeighmentEntry_ID, String trxName) {
		super(ctx, TF_WeighmentEntry_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public void calculateTotalAmount() {
		BigDecimal netWeight = BigDecimal.ZERO;
		BigDecimal tareWeight = getTareWeight();
		BigDecimal grossWeight = getGrossWeight(); 
		
		setNetWeight(grossWeight.subtract(tareWeight));
		
		netWeight = getNetWeight();
		int tonnage_uom_id = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, Env.getAD_Client_ID(getCtx()));
		
		BigDecimal qtyMT = netWeight.divide(new BigDecimal(1000));
		
		/*if(getC_UOM_ID() != tonnage_uom_id)
			netweightunit = MWeighmentEntry.qtyUOMConvert(tonnage_uom_id, getC_UOM_ID(), getM_Product_ID(), netWeight.divide(new BigDecimal(1000)), getM_Product_Attribute_ID());
		*/
		
		if(getC_UOM_ID() == tonnage_uom_id)
			setNetWeightUnit(qtyMT);
		
		BigDecimal qty = getNetWeightUnit();
		if(getUnloadingWeight() != null && getUnloadingWeight().doubleValue() > 0)
			qty = getUnloadingWeight();
		
		BigDecimal price = getGrossPrice();
		BigDecimal rentprice = getGrossRent();
		BigDecimal passqty = getPermitIssuedQty();
		BigDecimal passprice = getPassPricePerUnit();
		BigDecimal billprice = getBillPrice();
		BigDecimal otherCharges = getOtherCharges();
		
		int passID = getM_Product_Pass_ID();
		int freight_uom_id = getFreightRule_ID();
		int C_UOM_ID = getC_UOM_ID();
		
		boolean isTaxIncluded = isTaxIncluded();
		boolean isRentIncludesTax = isRentIncludesTax();
		
		BigDecimal PassAmount = BigDecimal.ZERO;
		BigDecimal priceExcludesTax = BigDecimal.ZERO;
		BigDecimal rentExcludesTax = BigDecimal.ZERO;
		
		TF_MProduct prod=new TF_MProduct(getCtx(), getM_Product_ID(), null);
		MTax tax = new MTax(getCtx(), prod.getTax_ID(true, false, false), null);				
		BigDecimal taxRate = tax.getRate();
		BigDecimal hundred = new BigDecimal("100");
		
		if(isTaxIncluded) {
			priceExcludesTax = price.divide(BigDecimal.ONE.add(taxRate.divide(hundred,2,RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);	
		}
		else {
			priceExcludesTax = price;	
		}
		
		if(isRentIncludesTax) {
			rentExcludesTax = rentprice.divide(BigDecimal.ONE.add(taxRate.divide(hundred,2,RoundingMode.HALF_UP)), 2, RoundingMode.HALF_UP);	
		}
		else {
			rentExcludesTax = rentprice;	
		}
			
		BigDecimal Amount = qty.multiply(priceExcludesTax).setScale(2, RoundingMode.HALF_EVEN);
		
		if(passqty != null && passprice != null) {
			PassAmount = passqty.multiply(passprice);
		}
		
		BigDecimal GrandTotalAmt = BigDecimal.ZERO;
		BigDecimal RentAmount = BigDecimal.ZERO;// CalloutUtil.getBDValue(mTab, MWeighmentEntry.COLUMNNAME_Rent_Amt);
		
		if(passID > 0) {
			PassAmount = passqty.multiply(passprice).setScale(2, RoundingMode.HALF_EVEN);
		}
		
		if(freight_uom_id > 0) {
			//int KM_UOM_ID = MSysConfig.getIntValue("KM_UOM", 1000071, Env.getAD_Client_ID(ctx));
			//int MT_KM_UOM_ID = MSysConfig.getIntValue("MT_KM_UOM", 1000093, Env.getAD_Client_ID(ctx));
			//int MT_UOM_ID = MSysConfig.getIntValue("MT_UOM", 1000069, Env.getAD_Client_ID(getCtx()));
			int LOAD_UOM_ID = MSysConfig.getIntValue("LOAD_UOM", 1000072, Env.getAD_Client_ID(getCtx()));
			
			if(freight_uom_id == LOAD_UOM_ID) {
				RentAmount = rentExcludesTax;
			}	
			else if(freight_uom_id == tonnage_uom_id) {
				RentAmount = rentExcludesTax.multiply(qtyMT);
			}
			else if(C_UOM_ID == freight_uom_id) {
				RentAmount = rentExcludesTax.multiply(qty);
			}
			else {
				throw new AdempiereException("Invalid Freight UOM!");
			}
		}
		
		RentAmount = RentAmount.setScale(2, RoundingMode.HALF_EVEN);
		
		BigDecimal GstAmt = BigDecimal.ZERO;
		BigDecimal TCSAmt = BigDecimal.ZERO;
		
		BigDecimal driverTips = getDriverTips();
		BigDecimal discountAmt = getDiscountAmount();
		BigDecimal gstrate = getGSTRate();
		Boolean ApplyTax = isPermitSales();
		Boolean ApplyTCS = isApplyTCS();
		Boolean BillPriceGST = isBillPriceGST();
		Boolean IncludePassAmtInvoice = isIncludePassAmtInvoice();
		
		BigDecimal unitPrice = BigDecimal.ZERO;
		BigDecimal amt = BigDecimal.ZERO;
		
		if(ApplyTax) {
			if(IncludePassAmtInvoice) {
				amt = PassAmount;
			}
			GstAmt = amt.add(RentAmount).add(Amount).add(otherCharges).multiply(gstrate.divide(new BigDecimal(100))).setScale(2, RoundingMode.HALF_EVEN);
		}
		else if(BillPriceGST) {
			GstAmt = (billprice.multiply(qty)).multiply(gstrate.divide(new BigDecimal(100))).setScale(2, RoundingMode.HALF_EVEN);
		}
		
		
		
		BigDecimal TotalAmount = BigDecimal.ZERO;
		
		if(ApplyTax) {
			TotalAmount = Amount.add(GstAmt).add(RentAmount).add(otherCharges);
			//if(IncludePassAmtInvoice) 
			{
				TotalAmount = TotalAmount.add(PassAmount);
			}
		}
		else if(BillPriceGST) {
			TotalAmount = (billprice.multiply(qty)).add(GstAmt);
		}
		
		if(ApplyTCS && (ApplyTax || BillPriceGST)) {
			TCSAmt = TotalAmount.multiply(new BigDecimal(0.001)).setScale(2, RoundingMode.HALF_EVEN);
		}
			
		
		BigDecimal SalesAmt = Amount.add(RentAmount).add(PassAmount).add(GstAmt).add(TCSAmt);
		GrandTotalAmt = Amount.add(RentAmount).add(PassAmount).add(otherCharges).add(GstAmt).add(TCSAmt).subtract(driverTips).subtract(discountAmt).setScale(2, RoundingMode.HALF_EVEN);
		
		setPrice(priceExcludesTax);
		setFreightPrice(rentExcludesTax);	
		setRent_Amt(RentAmount);
		setGSTAmount(GstAmt);		
		setAmount(Amount);
		setPermitPassAmount(PassAmount);
		setTotalAmt(GrandTotalAmt);
		setTCSAmount(TCSAmt);
	}
	
	void CreateBP() {
		if(getPartyName()!=null && getC_BPartner_ID()==0) {
			
			//Check Customer with Phone No
			String whereClause=" AD_Org_ID = ? AND lower(replace(Phone,' ',''))=lower(replace(?,' ','')) and IsCustomer='Y'";
			TF_MBPartner bp = new Query(getCtx(), TF_MBPartner.Table_Name, whereClause, get_TrxName())
					.setClient_ID().setParameters(getAD_Org_ID(), getPhone().replace(" ", "")).first();
			if(bp != null)
				setC_BPartner_ID(bp.getC_BPartner_ID());
			else{
				//Get Destination
				String CustomerDest="";
				if(getTF_Destination_ID()>0) {
					MDestination destc=new MDestination(getCtx(), getTF_Destination_ID(), get_TrxName());
					CustomerDest=destc.getName();
				}
				else {
					CustomerDest=getNewDestination();
				}
				TF_MBPartner bpnew=new TF_MBPartner(getCtx(), 0, get_TrxName());
				bpnew.setAD_Org_ID(getAD_Org_ID());
				bpnew.setValue(getPhone() != null ? getPhone() : getPartyName().toUpperCase());
				bpnew.setName(getPartyName());
				bpnew.setC_BP_Group_ID(1000001);
				bpnew.setPhone(getPhone());
				bpnew.setContactName(getPartyName());
				bpnew.setAddress1(CustomerDest); //set Destination
				bpnew.setCity(CustomerDest); // Set Destination
				bpnew.setIsCustomer(true);
				bpnew.setTF_CustomerType_ID(1000000);
				bpnew.setC_Country_ID(208);
				bpnew.saveEx();
				
				setC_BPartner_ID(bpnew.getC_BPartner_ID());
			}
		}
	}
	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		//CreateBP();
		if(getDiscountAmount() == null) {
			setDiscountAmount(BigDecimal.ZERO);
		}
		
		if(getDriverTips() == null) {
			setDriverTips(BigDecimal.ZERO);
		}
		
		if(isPermitSales() && isBillPriceGST()) {
			throw new AdempiereUserError("Please choose either Apply tax or Bill Price GST");
		}
		
		if(!getStatus().equals(STATUS_Voided)) {
			CreateDestination();
			CreateCustomerVehicle();
			
			if(getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_OwnProductionReceipt) || 
					getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_SubcontractProductionReceipt) ||
					getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_Input)) {
				CreateQuarry();
			}
			
			if(getTF_RentedVehicle_ID() > 0 && (getVehicleNo() == null || getVehicleNo().length() == 0))
					setVehicleNo(getTF_RentedVehicle().getVehicleNo());
			
			if(getC_BPartner_ID() == 0 && (getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_Sales)
					|| getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_OtherPurchase))
					) { // && (getPaymentRule().equals(PAYMENTRULE_Cash) ||  getPaymentRule().equals("O"))) {
				TF_MBPartner bp = new Query(getCtx(), TF_MBPartner.Table_Name, " IsPOSCashBP='Y'", get_TrxName())
						.setClient_ID().first();
				if(bp != null) {
					setC_BPartner_ID(bp.getC_BPartner_ID());				
				}
				
			}
			
			/*if(getPaymentRule().equals(PAYMENTRULE_Cash))
				setPaymentRule(PAYMENTRULE_OnCredit);
			*/
			if(getTF_RentedVehicle_ID()>0) {
				String rvwhere=" AD_Org_ID = ? AND COALESCE(Tareweight,0)!=? AND IsTransporter='N' AND TF_RentedVehicle_ID=?";
				MRentedVehicle rv= new Query(getCtx(), MRentedVehicle.Table_Name, rvwhere, get_TrxName())
						.setClient_ID()
						.setParameters(getAD_Org_ID(), getTareWeight(),getTF_RentedVehicle_ID())
						.first();
				
				if(rv!=null) {
					if(rv.getTareWeight()!=null) {
						rv.setOldTareweight(rv.getTareWeight());
					}
					rv.setTareWeight(getTareWeight());
					rv.saveEx();
				}
						
			}
			
			
			if(!newRecord && getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_Sales)
					&& MSysConfig.getBooleanValue("WEIGHMENT_REVIEW", false)) {
				if(is_Changed() && getStatus().equals(STATUS_Unbilled) && !is_ValueChanged(COLUMNNAME_Status)) {
					setStatus(STATUS_UnderReview);
				}
			}
			
			if(newRecord) {
				if(isSecondary()) {
					if(getTF_WeighmentEntryPrimary_ID() == 0 && getPrimaryDocumentNo() != null)
						setTF_WeighmentEntryPrimary_ID(getTF_WeighmentEntryPrimary_ID(getPrimaryDocumentNo()));
					//else if(getPrimaryDocumentNo() == null)
					//	throw new AdempiereException("Invalid Secondary Entry without Primary DC Reference");
					
					setInvoiceType(INVOICETYPE_TPWeight);
				}
				else {
					setPrimaryDocumentNo(getDocumentNo());
				}
			}
			
			if(isCreateTwoInvoices() && isSecondary()) {
				throw new AdempiereException("Secondary DC cannot be created as TP and Non TP Invoices!");
			}
		}
		
		if(getStatus().equals(STATUS_Voided)) {
			voidWeighmentEntry();
			setStatus(STATUS_Voided);
			setProcessed(true);
		}
		
		//set AD_User_ID
		if(newRecord) {
			
			MLoadingSlip loadingslip = new Query(getCtx(), MLoadingSlip.Table_Name, "DocumentNo = '"+ getDocumentNo() + "'", get_TrxName())
					.setClient_ID().first();
			
			if(loadingslip != null) {
				setLoadedTime(loadingslip.getLoadedTime());
				setLoader_User_ID(loadingslip.getAD_User_ID());
				loadingslip.setStatus(MLoadingSlip.STATUS_Unbilled);
				loadingslip.saveEx();
			}
			
			if(getCompletedBy() == null) {
				MUser user = TF_MUser.get(getCtx(), getUserName(), get_TrxName());
				if(user != null) {
					setAD_User_ID(user.getAD_User_ID());
				}
			}
			else {
				MUser user = TF_MUser.get(getCtx(), getCompletedBy(), get_TrxName());
				if(user != null) {
					setAD_User_ID(user.getAD_User_ID());
				}
			}
			
			if(MSysConfig.getValue("WEIGHMENT_TRIPSHEET_CREATION").equals("Y")){
				CreateTripSheetForOwnVehicle();
				
				if(getPM_Machinery_ID() > 0) {
					CreateTripSheetForLoader();
				}
				
				if(getQuarryProductionType() != null) {
					CreateTripSheetForQuarryProductionType();
				}
			}			
		}

		boolean ok = super.beforeSave(newRecord);
		return ok;
	}
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		//self referencing to facilitate easy info search.		
		if(!isSecondary() && getTF_WeighmentEntryPrimary_ID() == 0) {
			String updateSql = "UPDATE TF_WeighmentEntry SET DateAcct = TRUNC(GrossWeightTime), TF_WeighmentEntryPrimary_ID = " + getTF_WeighmentEntry_ID() +
			 " WHERE TF_WeighmentEntry_ID =  " + getTF_WeighmentEntry_ID();
			DB.executeUpdate(updateSql, get_TrxName());
		}
		
		if(getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_OwnProductionReceipt) || 
				getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_SubcontractProductionReceipt) ||
				getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_Input)) {
			UpdateQuarryQty();
			MQuarryToken.completeToken(this);
		}
		
		TF_MProduct product = new TF_MProduct(getCtx(), getM_Product_ID(), get_TrxName());
		
		if(newRecord) {
			boolean counterEntry = MSysConfig.getValue("COUNTER_SUBCONTRACT_ENTRY", "N").equals("Y");
			if(counterEntry && product.getM_Product_Category_ID() == 1000050 && getWeighmentEntryType().equals(MWeighmentEntry.WEIGHMENTENTRYTYPE_Sales)) {
				CreateWeighmentEntry_SR();
			}
		}
		
		return super.afterSave(newRecord, success);
	}
	
	void CreateWeighmentEntry_SR() {
		MWeighmentEntry we = new MWeighmentEntry(getCtx(), 0, get_TrxName());
		
		we.setAD_Org_ID(getAD_Org_ID());
		we.setDateAcct(getDateAcct());
		we.setDocumentNo(getDocumentNo() + "-SR");
		we.setWeighmentEntryType(MWeighmentEntry.WEIGHMENTENTRYTYPE_SubcontractProductionReceipt);
		we.setStatus(MWeighmentEntry.STATUS_Unbilled);
		
		//Subcontractor
		TF_MProject project = new Query(getCtx(), TF_MProject.Table_Name, "AD_Org_ID = "+ getAD_Org_ID() +" AND DocStatus = 'IP'", get_TrxName())
				.setClient_ID()
				.setOnlyActiveRecords(true)
				.first();
		
		we.setC_Project_ID(project.getC_Project_ID());
		we.setC_BPartner_ID(project.getC_BPartner_ID());
		
		we.setM_Warehouse_ID(getM_Warehouse_ID());
		//we.setC_BPartner_ID(getC_BPartnerCust_ID());
		
		we.setTF_VehicleType_ID(getTF_VehicleType_ID());
		we.setTF_RentedVehicle_ID(getTF_RentedVehicle_ID());
		we.setVehicleNo(getVehicleNo());
		we.setPM_Machinery_ID(getPM_Machinery_ID());
		
		we.setM_Product_ID(getM_Product_ID());
		we.setTareWeight(getTareWeight());
		we.setTareWeightTime(getTareWeightTime());
		we.setGrossWeight(getGrossWeight());
		we.setGrossWeightTime(getGrossWeightTime());
		we.setNetWeight(getNetWeight());
		we.setNetWeightUnit(getNetWeightUnit());
		we.setC_UOM_ID(getC_UOM_ID());
		
		we.setC_BPDriver_ID(getC_BPDriver_ID());
		we.setDriverName(getDriverName());
		we.setIsRequiredTaxInvoicePerLoad(isRequiredTaxInvoicePerLoad());
		we.setTF_Send_To(MWeighmentEntry.TF_SEND_TO_Production);
		
		we.setStatus(MWeighmentEntry.STATUS_Unbilled);
		we.setRef_WeighmentEntry_ID(getTF_WeighmentEntry_ID());
		
		MProductionPlant pplant = new Query(getCtx(), MProductionPlant.Table_Name, "AD_Org_ID = ? AND IsDefault = ? ", get_TrxName())
				.setClient_ID()
				.setOnlyActiveRecords(true)
				.setParameters(getAD_Org_ID(), true)
				.first();
		
		we.setTF_ProductionPlant_ID(pplant.getTF_ProductionPlant_ID());
		
		we.setCompletedBy(getCompletedBy());
		we.saveEx();
		
	}	
	
	public static boolean checkTime(String starttimes, String currentTime, String endtimes) {
	    try {
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

	        Date startime = simpleDateFormat.parse(starttimes);
	        Date endtime = simpleDateFormat.parse(endtimes);

	        //current time
	        Date current_time = simpleDateFormat.parse(currentTime);

	    if (current_time.after(startime) && current_time.before(endtime)) {
	            return true;
	      }
	    else if (current_time.after(startime) && current_time.after(endtime)) {
	         return true; //overlap condition check
	      }
	     else {
	            return false;
	     }
	    } 
	    catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return false;
	} 
	
	String GetHoursMins(Timestamp weighmentDate) {
		Format f = new SimpleDateFormat("HH:mm");
	    String strResult = f.format(weighmentDate);
	    return strResult;
	}
	
	void CreateTripSheetForOwnVehicle() {
		MRentedVehicle rentedVehicle = new MRentedVehicle(getCtx(), getTF_RentedVehicle_ID(), get_TrxName());
		
		if(rentedVehicle.isOwnVehicle()) {
			String where = " AD_Org_ID = ? AND M_Product_ID = " + rentedVehicle.getM_Product_ID();
			
			MMachinery machinery = new Query(getCtx(), MMachinery.Table_Name, where, get_TrxName()).setClient_ID().setParameters(getAD_Org_ID()).first();
			
			if(machinery != null) {
				CreateTripSheet(machinery);
			}
		}
		
	}
	
	void CreateTripSheetForLoader() {
		MMachinery machinery = new MMachinery(getCtx(), getPM_Machinery_ID(), get_TrxName());		
		if(machinery != null) {
			CreateTripSheet(machinery);
		}
	}
	
	void CreateTripSheetForQuarryProductionType() {
		String where = "QuarryProductionType  = '" + getQuarryProductionType() + "'";
		
		MMachinery machinery = new Query(getCtx(), MMachinery.Table_Name, where, get_TrxName()).first();
		
		if(machinery != null) {
			CreateTripSheet(machinery);
		}
	}
	
	void CreateTripSheet(MMachinery machinery) {
		MMachineryType machineryType = new MMachineryType(getCtx(), machinery.getPM_MachineryType_ID(), get_TrxName());
		
		String currentTime = GetHoursMins(getGrossWeightTime());
		boolean isDayShift = checkTime(DayShiftStartTime, currentTime, DayShiftEndTime);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date startTime = null;
		Date endTime = null;

		Timestamp startime;
		Timestamp endtime;
		Timestamp dateTime = getGrossWeightTime();
		String shiftType;
		if(isDayShift) {
			try {
	            startTime = sdf.parse(DayShiftStartTime);
	            endTime = sdf.parse(DayShiftEndTime);			            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			startime = new Timestamp(getGrossWeightTime().getYear(), getGrossWeightTime().getMonth(), getGrossWeightTime().getDate(), startTime.getHours(), startTime.getMinutes(), 0, 0);
			endtime = new Timestamp(getGrossWeightTime().getYear(), getGrossWeightTime().getMonth(), getGrossWeightTime().getDate(), endTime.getHours(), endTime.getMinutes(), 0, 0);
			
			shiftType = MTripSheet.SHIFT_Day;
		}
		else {
			boolean isNextDay = checkTime("00:00", currentTime, "06:01");
			
			try {
	            startTime = sdf.parse(NightShiftStartTime);
	            endTime = sdf.parse(NightShiftEndTime);			            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }			
			
			if(isNextDay) {
				Calendar cal = Calendar.getInstance();
		        cal.setTime(getGrossWeightTime());// w ww.  j ava  2  s  .co m
		        cal.add(Calendar.DATE, -1); 
		        
				dateTime = new Timestamp(cal.getTime().getTime());
			}	
			
			startime = new Timestamp(dateTime.getYear(), dateTime.getMonth(), dateTime.getDate(), startTime.getHours(), startTime.getMinutes(), 0, 0);
			endtime = new Timestamp(dateTime.getYear(), dateTime.getMonth(), dateTime.getDate(), endTime.getHours(), endTime.getMinutes(), 0, 0);
			
			shiftType = MTripSheet.SHIFT_Night;					
		}
		
		Timestamp currtime = new Timestamp(dateTime.getYear(), dateTime.getMonth(), dateTime.getDate(), 0, 0, 0, 0);
		
		String whereclause = "PM_Machinery_ID = ? AND DateReport = ? AND Shift = ?";
		
		MTripSheet sheets = new Query(getCtx(), MTripSheet.Table_Name, whereclause, get_TrxName()).setClient_ID().setParameters(machinery.getPM_Machinery_ID(), currtime, shiftType).first();
		
		if(sheets == null) {
			MTripSheet tripSheet = new MTripSheet(getCtx(), 0, get_TrxName());
			tripSheet.setAD_Org_ID(getAD_Org_ID());
			tripSheet.setTF_Quarry_ID(getTF_Quarry_ID());
			tripSheet.setPM_Machinery_ID(machinery.getPM_Machinery_ID());
			tripSheet.setVehicle_ID(machinery.getM_Product_ID());
			tripSheet.setC_UOM_ID(machineryType.getC_UOM_ID());
			
			tripSheet.setDateReport(dateTime);
			tripSheet.setDateStart(startime);
			tripSheet.setDateEnd(endtime);
			tripSheet.setShift(shiftType);
			
			tripSheet.saveEx();
		}
	}
	
	void CreateQuarry() {
		
		/*if(getMLNo() != null) {
			MQuarry quarry = MQuarry.getQuarry(getMLNo(), getWeighmentEntryType(), getC_BPartner_ID(), getM_Product_ID(), getTF_Destination_ID(), getC_UOM_ID(), 0);
			
			if(quarry == null) {
				quarry = new MQuarry(getCtx(), 0, get_TrxName());
				quarry.setAD_Org_ID(getAD_Org_ID());
				quarry.setName(getMLNo());
				quarry.setValue(getMLNo());
				quarry.setWeighmentEntryType(getWeighmentEntryType());
				quarry.setC_BPartner_ID(getC_BPartner_ID());
				quarry.setM_Product_ID(getM_Product_ID());
				quarry.setTF_Destination_ID(getTF_Destination_ID());
				quarry.setC_UOM_ID(getC_UOM_ID());
				quarry.saveEx();
			}
			
			setTF_Quarry_ID(quarry.getTF_Quarry_ID());
		}*/
	}
	
	void UpdateQuarryQty() {
		
	/*	if(getMLNo() != null) {
			String where = "Value = '" + getMLNo() + "'";
			
			MQuarry quarry = new Query(getCtx(), MQuarry.Table_Name, where, get_TrxName()).first();
			
			String sql = "SELECT SUM(PermitIssuedQty) FROM TF_WeighmentEntry WHERE MLNo  = ? "
						+ " AND Status != 'VO' AND WeighmentEntryType = ?";
			BigDecimal totalTPWeight = DB.getSQLValueBD(get_TrxName(), sql, getMLNo(), getWeighmentEntryType());
			
			sql = "SELECT SUM(NetWeightUnit) FROM TF_WeighmentEntry WHERE MLNo  = ? "
					+ " AND Status != 'VO' AND IsSecondary = 'N' AND WeighmentEntryType = ?";
			BigDecimal netweightUnit = DB.getSQLValueBD(get_TrxName(), sql, getMLNo(), getWeighmentEntryType());
			
			if(!isSecondary()) {
				quarry.setActualQty(netweightUnit);
			}
			
			quarry.setDeliveredTPQty(totalTPWeight);
			quarry.setBalanceQty(netweightUnit.subtract(totalTPWeight));
			quarry.saveEx();			
		}*/
	}

	void CreateCustomerVehicle() {
		TF_MBPartner bp = null;
		
		if(getTF_RentedVehicle_ID() > 0)
			return;
		
		if(getC_BPartner_ID()>0) {
			bp=new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
		}
		else {
			if(getC_BPartner_ID() == 0) {
				bp = new Query(getCtx(), TF_MBPartner.Table_Name, " IsPOSCashBP='Y'", get_TrxName())
						.setClient_ID().first();
			}
		}
		
		Boolean createNewVehicle = MSysConfig.getBooleanValue("NEW_VEHICLE_FOR_CASH_CUSTOMER", false, getAD_Client_ID(), getAD_Org_ID());
		if(!bp.getIsPOSCashBP() || createNewVehicle) {
			String whereClause=" AD_Org_ID = ? AND UPPER(replace(vehicleno,' ',''))='"+getVehicleNo().replace(" ","").toUpperCase()+"'";
			
			MRentedVehicle rentedVehicle = new Query(getCtx(), MRentedVehicle.Table_Name, whereClause, get_TrxName())
											.setClient_ID().setParameters(getAD_Org_ID())
											.first();
			
			if(rentedVehicle != null) {
				setTF_RentedVehicle_ID(rentedVehicle.getTF_RentedVehicle_ID());
			}
			else {
				MRentedVehicle rentedVehiclenew = new MRentedVehicle(getCtx(), 0, get_TrxName());
				int C_UOM_ID = MSysConfig.getIntValue("Vehicle_UOM_ID", 100);
				int Product_Category_ID = MSysConfig.getIntValue("Vehicle_Product_Category_ID", 1000055);
				
				rentedVehiclenew.setAD_Org_ID(getAD_Org_ID());
				rentedVehiclenew.setVehicleNo(getVehicleNo().replace(" ","").toUpperCase());

				if(getTransporter_ID() > 0) {
					rentedVehiclenew.setC_BPartner_ID(getTransporter_ID());
					rentedVehiclenew.setIsTransporter(true);
				}
				else {
					rentedVehiclenew.setC_BPartner_ID(getC_BPartner_ID());
				}
				
				rentedVehiclenew.setTareWeight(getTareWeight());
				
				if(bp.isVendor())
					rentedVehiclenew.setVehicleSOPOType(MRentedVehicle.VEHICLESOPOTYPE_Both);
				else
					rentedVehiclenew.setVehicleSOPOType(MRentedVehicle.VEHICLESOPOTYPE_Both);
				rentedVehiclenew.setTF_VehicleType_ID(getTF_VehicleType_ID());
				rentedVehiclenew.setM_Product_Category_ID(Product_Category_ID);
				rentedVehiclenew.setC_UOM_ID(C_UOM_ID);
				rentedVehiclenew.setIsActive(true);
				rentedVehiclenew.saveEx();
				
				setTF_RentedVehicle_ID(rentedVehiclenew.get_ID());
			}
		}
	}
	void CreateDestination() {
		if(getNewDestination()!=null && getTF_Destination_ID()==0) {
			String whereClause=" AD_Org_ID = ? AND UPPER(replace(Name,' ',''))='"+getNewDestination().replace(" ","").toUpperCase()+"'";
			MDestination dest=new Query(getCtx(),MDestination.Table_Name, whereClause,get_TrxName())
					.setClient_ID().setParameters(getAD_Org_ID())
					.first();
			if(dest!=null) {
				setTF_Destination_ID(dest.getTF_Destination_ID());
			}
			else {
				MDestination destnew=new MDestination(getCtx(), 0, get_TrxName());
				destnew.setAD_Org_ID(getAD_Org_ID());
				destnew.setName(getNewDestination());
				destnew.setDistance(BigDecimal.ZERO);
				destnew.setRate(BigDecimal.ZERO);
				destnew.setIsActive(true);
				destnew.saveEx();
				
				setTF_Destination_ID(destnew.get_ID());
			}
		}
	}
	
	public void close() {		
			if(getStatus().equals(STATUS_Billed) && !isCreateTwoInvoices())
				throw new AdempiereException("Weighment Entry is already processed!");
			setStatus(STATUS_Billed);
			//setProcessed(true);
	}
	public void reverse() {
		setStatus(STATUS_Unbilled);		
		//setProcessed(false);
		//Only Shipment document will set processed as True
		//or false while reversing shipment document.
	}
	
	public BigDecimal getCFTMultiplyRate() {
		if(getNetWeightUnit() == null)
			return null;
		if(getNetWeight().doubleValue() == getNetWeightUnit().doubleValue())
			return BigDecimal.ONE;
		return getNetWeightUnit().divide(getNetWeight()
					.divide(new BigDecimal(1000), 2, RoundingMode.HALF_EVEN)
					, 2, RoundingMode.HALF_EVEN);
	}
	
	public boolean isGST() {
		//BigDecimal royaltyPassQty = getPassQtyIssued();
		//if(royaltyPassQty == null)
		//	royaltyPassQty = BigDecimal.ZERO;
		
		//return getGSTAmount().doubleValue() > 0;
		return (isPermitSales() || isBillPriceGST());
	}
	
	/***
	 * Returns Sales Quick Entry Document Type ID
	 * @return
	 */
	public int getC_DocType_ID(String WeighmentEntryType) {
		
		if(WeighmentEntryType.equals(WEIGHMENTENTRYTYPE_Sales)) {
			if(isGST())
				return TF_MOrder.GSTConsolidatedOrderDocType_ID(getCtx());
			else
				return TF_MOrder.NonGSTConsolidatedOrderDocType_ID(getCtx());
		}
		else if(WeighmentEntryType.equals(WEIGHMENTENTRYTYPE_Input)) {
			if(isGST())
				return TF_MOrder.GSTPurchaeDocType_ID(getCtx());
			else
				return TF_MOrder.NonGSTPurchaeDocType_ID(getCtx());
		}
		return 0;
	}
	
	public int getRoyaltyPassPurchase_DocType_ID() {
		return TF_MOrder.RoyaltyPassOrderPurchaseDocType_ID(getCtx());
	}
	
	public int getRoyaltyPass_DocType_ID() {
		return TF_MOrder.RoyaltyPassOrderDocType_ID(getCtx());
	}
	
	public static int getTransporterInvoiceDocType_ID() {
		return TF_MOrder.getC_TransporterInvoiceDocType_ID();
	}
	
	public static int getC_ServiceInvoiceDocType_ID() {
		return TF_MOrder.getC_ServiceInvoiceDocType_ID();
	}
	
	/***
	 * Returns Shipment (Customer) Document Type ID
	 * @return
	 */
	public int getC_DocTypeShipment_ID() {
		MDocType dt = new MDocType(getCtx(), getC_DocType_ID(getWeighmentEntryType()), get_TrxName());
		return dt.getC_DocTypeShipment_ID();                                                                           
	}
	
	public int getC_DocTypeInvoice_ID() {
		MDocType dt = new MDocType(getCtx(), getC_DocType_ID(getWeighmentEntryType()), get_TrxName());
		return dt.getC_DocTypeInvoice_ID();
	}
	
	public int getRoyaltyPassProduct_ID() {
		return MSysConfig.getIntValue("ROYALTY_PASS_PRODUCT_ID", 0, getAD_Client_ID(), getAD_Org_ID());
	}
	
	public int getInvoiceSeq_Id() {
		return MSysConfig.getIntValue("INVOICE_SEQ_ID", 0, getAD_Client_ID(), getAD_Org_ID());
	}
	
	public int getC_Tax_ID(boolean ReverseCharge) {
		TF_MProduct p = new TF_MProduct(getCtx(), getM_Product_ID(), get_TrxName());
		TF_MBPartner bp = new TF_MBPartner(getCtx(), getC_BPartner_ID(), get_TrxName());
		
		if(MSysConfig.getValue("APPLY_GST_ALWAYS").equals("Y") && getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_Sales)) {
			if(isApplyTCS()) {
				return p.getTax_ID(getGSTRate(), true, isApplyTCS(), bp.isInterState(),ReverseCharge);
			}
			else {
				return p.getTax_ID(getGSTRate(), true, false, bp.isInterState(),ReverseCharge);
			}
		}
		else {
			if(isApplyTCS()) {
				return p.getTax_ID(getGSTRate(), isGST(), isApplyTCS(), bp.isInterState(),ReverseCharge);
			}
			else {
				return p.getTax_ID(getGSTRate(), isGST(), false, bp.isInterState(),ReverseCharge);
			}
		}			
	}
	
	public int getM_InOut_ID() {
		String whereClause = "TF_WeighmentEntry_ID = ? AND DocStatus IN ('CO','CL')";		
		TF_MInOut inout = new Query(getCtx(), TF_MInOut.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_WeighmentEntry_ID())
				.first();
		if(inout != null)
			return inout.get_ID();
		else
			return 0;
	}
	
	public int getM_InOutLine_ID() {
		String whereClause = "TF_WeighmentEntry_ID = ? AND DocStatus IN ('CO','CL')";		
		TF_MInOut inout = new Query(getCtx(), TF_MInOut.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_WeighmentEntry_ID())
				.first();
		
			
		if(inout != null) {
			for(MInOutLine line : inout.getLines()) {
				if(line.getM_Product_ID() == getM_Product_ID()) {
					return line.get_ID();
				}
			}
		}
		
		 return 0;
	}
	
	
	public int getM_InOutLine_ID(int M_Product_ID) {
		String whereClause = "TF_WeighmentEntry_ID = ? AND DocStatus IN ('CO','CL')";		
		TF_MInOut inout = new Query(getCtx(), TF_MInOut.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_WeighmentEntry_ID())
				.first();
		
			
		if(inout != null) {
			for(MInOutLine line : inout.getLines()) {
				if(line.getM_Product_ID() == M_Product_ID) {
					return line.get_ID();
				}
			}
		}
		
		 return 0;
	}
	
	public int getTF_WeighmentEntryPrimary_ID(String documentNo) {
		String whereClause = "DocumentNo = ? ";
		MWeighmentEntry wEntry = new Query(getCtx(), Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(documentNo)
				.first();
		if(wEntry != null)
			return wEntry.get_ID();
		else
			return 0;
	}
	
	public void shipped() {
		setProcessed(true);
		if(!isRequiredTaxInvoicePerLoad() && !getStatus().equals(STATUS_Billed))
		   setStatus(STATUS_Unbilled);
	}
	
	public void reverseShipped() {
		setProcessed(false);
	}
	
	public BigDecimal getMT() {
		return getNetWeight().divide(new BigDecimal(1000), 3, RoundingMode.HALF_EVEN);
	}
	
	public int getMT_UOM_ID() {
		return MSysConfig.getIntValue("TONNAGE_UOM", 1000069, getAD_Client_ID());
	}
	
	public int getMTKM_UOM_ID() {
		return MSysConfig.getIntValue("MT_KM_UOM", 1000081, getAD_Client_ID());
	}
			
	public static BigDecimal qtyUOMConvert(int C_UOM_From_ID, int C_UOM_To_ID, int M_Product_ID, BigDecimal qty, int M_Product_Attribute_ID) {
		String whereClause = "IsActive='Y' AND C_UOM_ID=? AND C_UOM_TO_ID=? AND M_Product_ID = ? AND "
				+ " (CASE WHEN ? = 0 THEN M_Product_Attribute_ID IS NULL ELSE M_Product_Attribute_ID = ? END) ";
		
		MUOMConversion uomconv = new Query(Env.getCtx(),  MUOMConversion.Table_Name, whereClause, null)
									 .setParameters(C_UOM_From_ID, C_UOM_To_ID, M_Product_ID, M_Product_Attribute_ID, M_Product_Attribute_ID).first();
		
		BigDecimal retValue = null;
		int precision = 2;
		
		if(uomconv != null) {
			retValue = uomconv.getMultiplyRate();
			
			MUOM uomTo = new MUOM(Env.getCtx(), C_UOM_To_ID, null);
			
			precision = uomTo.getStdPrecision();
			
			if (retValue == null)
			{
				if (s_log.isLoggable(Level.INFO)) s_log.info ("NOT found - FromUOM=" + C_UOM_From_ID + ", ToUOM=" + C_UOM_To_ID);
				return null;
			}
			
			qty = retValue.multiply(qty);
			if (retValue.scale() > precision)
				qty = qty.setScale(precision, BigDecimal.ROUND_HALF_UP);			
		}
		
		return qty;
	}
	public BigDecimal getMovementQty() {
		int MT_UOM_ID = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, getAD_Client_ID());
		TF_MProduct prod = new TF_MProduct(getCtx(), getM_Product_ID(), get_TrxName());
		BigDecimal divideRate = prod.getDivideRate(prod.getC_UOM_ID(), getC_UOM_ID());
		BigDecimal MT = getNetWeight().divide(new BigDecimal(1000), 2, RoundingMode.HALF_EVEN);		
		
		if(getC_UOM_ID() == 0)
			return MT;
		
		//Commented to enforce only the MT should be posted in the aggregate and boulder movements.
		//BigDecimal qtyMovement = MT.divide(divideRate,2, RoundingMode.HALF_EVEN);
		BigDecimal qtyMovement = getNetWeightUnit();
		
		return qtyMovement;
		//return MT;
	}
	
	public BigDecimal getUOMQtyConverted(BigDecimal qty) {
		int tonnage_uom_id = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, Env.getAD_Client_ID(getCtx()));
		
		qty = qtyUOMConvert(tonnage_uom_id, getC_UOM_ID(), getM_Product_ID(), qty, getM_Product_Attribute_ID());
		
		if(getC_UOM_ID() == MSysConfig.getIntValue("CFT_UOM", 1000076, getAD_Client_ID()))
			qty = qty.setScale(0, BigDecimal.ROUND_UP);
		
		return qty;
	}
	
	public BigDecimal getBilledQty() {
		int tonnage_uom_id = MSysConfig.getIntValue("TONNAGE_UOM", 1000069, Env.getAD_Client_ID(getCtx()));
		BigDecimal qty = getNetWeight();
		if(getC_UOM_ID() == tonnage_uom_id)
			qty = qty.divide(new BigDecimal(1000));
		else
			qty = getNetWeightUnit();
		
		if((!isSecondary() && getInvoiceType().equals(INVOICETYPE_TPWeight)) || isSecondary())
			qty = getUOMQtyConverted(getPermitIssuedQty());		
				
		
		
		return qty;
	}
	
	public BigDecimal getTPBilledQty() {
		return getUOMQtyConverted(getPermitIssuedQty());
	}
	
	public BigDecimal getTotalTPWeight() {		
		String sql = "SELECT SUM(PermitIssuedQty) FROM TF_WeighmentEntry WHERE ? IN (TF_WeighmentEntry_ID, TF_WeighmentEntryPrimary_ID) "
				+ " AND Status != 'VO'";
		BigDecimal totalTPWeight = DB.getSQLValueBD(get_TrxName(), sql, getTF_WeighmentEntry_ID());
		if(totalTPWeight == null)
			totalTPWeight = BigDecimal.ZERO;
		totalTPWeight = getUOMQtyConverted(totalTPWeight);
		return totalTPWeight;
	}
	
	
	@Override
	public int getC_Order_ID() {
		if(getC_OrderLine_ID() > 0)
			return getC_OrderLine().getC_Order_ID();
		
		return super.getC_Order_ID();
	}
	
	public BigDecimal getMaterialPriceIncludedRent() {
		if(getRent_Amt() == null || getRent_Amt().doubleValue() == 0)
			return getPrice();
		
		BigDecimal unitRent = BigDecimal.ZERO;
		
		//Incomplete Functionality
		//if(MSysConfig.getValue("INCLUDE_RENT_AMOUNT_IN_INVOICE").equals("Y"))
		//if(isIncludeRentAmtInvoice()) {
		if(getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_Sales)) {
			unitRent = getRent_Amt().divide(getNetWeightUnit(), 2,RoundingMode.HALF_EVEN);
		}
		
		return getPrice().add(unitRent);
	}
	
	public BigDecimal getUnitGST(BigDecimal price) {
		if(getGSTAmount() == null || getGSTAmount().doubleValue() == 0)
			return price;
		
		BigDecimal gst = BigDecimal.ZERO;
		
		gst = getGSTAmount().divide(getNetWeightUnit(), 2,RoundingMode.HALF_EVEN);
		
		BigDecimal tcs = BigDecimal.ZERO;
		
		if(getTCSAmount() == null || getTCSAmount().doubleValue() == 0)
			tcs = BigDecimal.ZERO;
		else
			tcs = getTCSAmount().divide(getNetWeightUnit(), 2,RoundingMode.HALF_EVEN);
		
		gst = gst.add(tcs);
		
		return price.add(gst);
	}
	public BigDecimal getMaterialPriceIncludedRoyaltyPass(BigDecimal price) {
		if(getPermitPassAmount() == null || getPermitPassAmount().doubleValue() == 0 || getPermitIssuedQty() == null || getPermitIssuedQty().doubleValue() == 0)
			return price;
		
		BigDecimal unitPassAmt = BigDecimal.ZERO;
		
		//if(MSysConfig.getValue("INCLUDE_PASS_AMOUNT_IN_INVOICE", getAD_Client_ID(), getAD_Org_ID()).equals("Y"))
		if(isIncludePassAmtInvoice())
			unitPassAmt = getPermitPassAmount().divide(getNetWeightUnit(), 2,RoundingMode.HALF_EVEN);
		
		return price.add(unitPassAmt);
	}
	
	public void voidWeighmentEntry() {
		String oWhereClause = "TF_WeighmentEntry_ID = ? AND C_BPartner_ID = ? AND DocStatus IN ('CO','CL')";
		
		try {
			String msg = null;
			
			//Boulder Receipt
			List<MBoulderReceipt> boulders = new Query(getCtx(), MBoulderReceipt.Table_Name, "TF_WeighmentEntry_ID = ? AND DocStatus ='CO'", get_TrxName())
					.setClient_ID()
					.setParameters(getTF_WeighmentEntry_ID())
					.list();
			
			for(MBoulderReceipt br : boulders) {
				br.reverseIt();
				br.setDocStatus(MBoulderReceipt.DOCSTATUS_Voided);
				br.setProcessed(true);
				br.saveEx();
			}
			
			
			//Shipment
			TF_MInOut io = new Query(getCtx(), TF_MInOut.Table_Name, oWhereClause, get_TrxName())
					.setClient_ID()
					.setParameters(getTF_WeighmentEntry_ID(), getC_BPartner_ID())
					.first();
			if(io != null) {
				io.setDocAction(DocAction.ACTION_Reverse_Correct);
				io.reverseCorrectIt();
				io.setDocStatus(TF_MOrder.DOCSTATUS_Reversed);
				io.saveEx();
			}
			
			//Order
			List<TF_MOrder> orders = new Query(getCtx(), TF_MOrder.Table_Name, oWhereClause, get_TrxName())
					.setClient_ID()
					.setParameters(getTF_WeighmentEntry_ID(), getC_BPartner_ID())
					.list();
			for(TF_MOrder sale : orders) {				
				sale.setDocAction(DocAction.ACTION_Void);
				sale.voidIt();
				sale.setDocStatus(TF_MOrder.DOCSTATUS_Voided);
				sale.saveEx();
			}
			//Invoice
			List<TF_MInvoice> invList = new Query(getCtx(), TF_MInvoice.Table_Name, oWhereClause, get_TrxName())
					.setClient_ID()
					.setParameters(getTF_WeighmentEntry_ID(), getC_BPartner_ID())
					.list();
			for(TF_MInvoice inv : invList) {
				
				//Keep the existing invoice no while reversing
				if(!MSysConfig.getBooleanValue(MSysConfig.Invoice_ReverseUseNewNumber, true, getAD_Client_ID()) && invList.size() == 1) {						
					
					String sql = "SELECT COUNT(*) FROM C_Invoice WHERE TF_WeighmentEntry_ID = ?";
					int revCount = DB.getSQLValue(get_TrxName(), sql, getTF_WeighmentEntry_ID());
					revCount = revCount / 2 + 1;
					inv.setDocumentNo(inv.getDocumentNo() + "-"+  revCount);
					inv.saveEx();
				}
				
				inv.setDocAction(DocAction.ACTION_Reverse_Correct);
				inv.voidIt();
				inv.setDocStatus(TF_MOrder.DOCSTATUS_Reversed);
				inv.saveEx();
			}
			
			String whereClauseCB = "DocStatus = 'CO' AND C_InVoice_ID IN (SELECT C_Invoice_ID FROM C_Invoice "
					+ " WHERE C_Payment.C_Invoice_ID = C_Invoice.C_Invoice_ID AND C_Invoice.DocStatus='RE' AND C_Invoice.TF_WeighmentEntry_ID = ?) ";
			List<TF_MPayment> cbList = new Query(getCtx(), TF_MPayment.Table_Name, whereClauseCB, get_TrxName())
					.setClient_ID()
					.setParameters(getTF_WeighmentEntry_ID())
					.list();
			
			for(TF_MPayment p : cbList) {
				p.setDocAction(DocAction.ACTION_Reverse_Correct);
				p.reverseCorrectIt();
				p.setDocStatus(TF_MOrder.DOCSTATUS_Reversed);
				p.saveEx();
			}
			
			// Driver Tips Reverse
			oWhereClause = "TF_WeighmentEntry_ID = ? AND DocStatus IN ('CO','CL')";
			cbList = new Query(getCtx(), TF_MPayment.Table_Name, oWhereClause, get_TrxName())
					.setClient_ID()
					.setParameters(getTF_WeighmentEntry_ID())
					.list();
			
			for(TF_MPayment p : cbList) {
				p.setDocAction(DocAction.ACTION_Reverse_Correct);
				p.reverseCorrectIt();
				p.setDocStatus(TF_MOrder.DOCSTATUS_Reversed);
				p.saveEx();
			}
			
			
			
			//Stock to Hopper
			List<MCrusherKatingEntry> cartings = new Query(getCtx(), MCrusherKatingEntry.Table_Name, "TF_WeighmentEntry_ID = ? AND DocStatus IN ('CO','CL')", get_TrxName())
					.setClient_ID()
					.setParameters(getTF_WeighmentEntry_ID())
					.list();
			for(MCrusherKatingEntry ka : cartings) {
				ka.reverseIt();
				ka.setDocStatus(MCrusherKatingEntry.DOCSTATUS_Voided);
				ka.setProcessed(true);
				ka.saveEx();
			}
			
			List<MWeighmentEntry> wentries = new Query(getCtx(), MWeighmentEntry.Table_Name, "Ref_WeighmentEntry_ID = ? AND Status  IN ('CO','CL')", get_TrxName())
					.setClient_ID()
					.setParameters(getTF_WeighmentEntry_ID())
					.list();
			
			for(MWeighmentEntry we : wentries) {
				we.voidWeighmentEntry();
				we.setStatus(MBoulderReceipt.DOCSTATUS_Voided);
				we.saveEx();
			}
		}
		catch (Exception ex) {
			throw new AdempiereException(ex.getMessage());
		}	
	}				

	public int getC_BankAccount_ID() {
		TF_MUser user = new TF_MUser(getCtx(), getAD_User_ID(), get_TrxName());
		if(user.getC_BankAccount_ID() == 0)
			return TF_MBankAccount.getDefaultCashAccount(getCtx(), getAD_Org_ID(), get_TrxName());
		return user.getC_BankAccount_ID();
	}

	
	public boolean hasShipmentGenerated() {
		String whereClause = "TF_WeighmentEntry_ID = ? AND DocStatus IN ('CO','CL')";
		
		
		TF_MInOut io  = new Query(getCtx(), TF_MInOut.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_WeighmentEntry_ID())
				.first();
		
		int count = 0;
		
		if(io != null) {
			count = 1;
			io.createMaterialMovement(this, null);
		}
		
		return count > 0;
	}
	
	public void rePostMaterialMovements() {
		TF_MProduct p = new TF_MProduct(getCtx(), getM_Product_ID(), get_TrxName());
		BigDecimal qty = getMT();
		
		MBoulderMovement.deleteBoulderMovement(getTF_WeighmentEntry_ID(), get_TrxName());
		MSubcontractMaterialMovement.deleteWeighmentMovement(getTF_WeighmentEntry_ID(), get_TrxName());
		
		if(getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_Sales)) {
			int BoulderID = MSysConfig.getIntValue("BOULDER_ID", 1000233, getAD_Client_ID(), getAD_Org_ID());
			MProduct rm = MProduct.get(getCtx(), BoulderID);			
			//Need to add support for CFT sales and the resepctive MT material movement.
			if(getM_Product_ID() != BoulderID) {				
				TF_MProductCategory pc = new TF_MProductCategory(getCtx(), getM_Product().getM_Product_Category_ID(), get_TrxName());
				if(p.isGenerateMovementRecord())
					MSubcontractMaterialMovement.createMaterialMovement(get_TrxName(), getGrossWeightTime(), getAD_Org_ID(), getC_Order_ID(), 
							getC_BPartner_ID(), getM_Product_ID(), getMovementQty(), getTF_WeighmentEntry_ID());
			}
			else if(p.isGenerateMovementRecord() && getM_Product_ID() == BoulderID) {
				MBoulderMovement.createBoulderIssue(get_TrxName(), getGrossWeightTime(), getAD_Org_ID(), getM_Product_ID(),
						getMovementQty(), getTF_WeighmentEntry_ID(), getM_Warehouse_ID(), 0);
			}
		}
		else if(getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_Input)) {
			
			if(p.isGenerateMovementRecord() && MWeighmentEntry.TF_SEND_TO_Production.equals(getTF_Send_To())) {
				MSubcontractMaterialMovement.createRawmaterialMovement(get_TrxName(), getGrossWeightTime(), getAD_Org_ID(),				
						0, 0, getM_Product_ID(), getTF_WeighmentEntry_ID(), 0, getMovementQty());
			}
			else if(p.isGenerateMovementRecord() && MWeighmentEntry.TF_SEND_TO_Stock.equals(getTF_Send_To())) {
				MBoulderMovement.createBoulderReceipt(get_TrxName(), getGrossWeightTime(), getAD_Org_ID(), getM_Product_ID(), getMovementQty(), getTF_WeighmentEntry_ID(), getM_Warehouse_ID(), 0, 0);
			}
		}
		else if(getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_SubcontractProductionReceipt) || 
				getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_OwnProductionReceipt)) {
			//SINCE already created properly
			//it is not implemented
		}		
		else if(getWeighmentEntryType().equals(WEIGHMENTENTRYTYPE_StockToCrusher)) {
			if(getTF_Send_To().equals("P") && p.isGenerateMovementRecord()) {				
				MBoulderMovement.createBoulderIssue(get_TrxName(), getGrossWeightTime(), getAD_Org_ID(), getM_Product_ID(), qty, getTF_WeighmentEntry_ID(), getM_Warehouse_ID(), 0);
				MSubcontractMaterialMovement.createRawmaterialMovement(get_TrxName(), getGrossWeightTime(), getAD_Org_ID(), 0, 0, getM_Product_ID(), getTF_WeighmentEntry_ID(), qty, 0, 0,0);
			}
		}
	}
	
	public List<MWeighmentPayment> getPayments() {
		
		String whereClause = "TF_WeighmentEntry_ID = ?";
		List<MWeighmentPayment> list = new Query(getCtx(), MWeighmentPayment.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(getTF_WeighmentEntry_ID())
				.list();
		
		return list;
	}
	
	public BigDecimal getTotalMixedPayment() {
		String sql = "SELECT COALESCE(SUM(Amount),0) FROM TF_WeighmentEntry_Payment WHERE TF_WeighmentEntry_ID = " + getTF_WeighmentEntry_ID();
		BigDecimal TotalMixedPayment = DB.getSQLValueBDEx(get_TrxName(), sql);
		return TotalMixedPayment;
	}
	
	public BigDecimal getSalesTotalAmount() {
		return getTotalAmt().add(getDriverTips()).add(getDiscountAmount());
	}
}
