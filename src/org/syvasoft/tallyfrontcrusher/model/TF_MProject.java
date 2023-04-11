package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MProject;
import org.compiere.model.MProjectType;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class TF_MProject extends MProject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8652950032687595946L;

	public TF_MProject(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public TF_MProject(Properties ctx, int C_Project_ID, String trxName) {
		super(ctx, C_Project_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	 /** Column name C_UOM_ID */
    public static final String COLUMNNAME_C_UOM_ID = "C_UOM_ID";
    
	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getC_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param C_UOM_ID 
		Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID)
	{
		if (C_UOM_ID < 1) 
			set_Value (COLUMNNAME_C_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
	}

	/** Get UOM.
		@return Unit of Measure
	  */
	public int getC_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	 /** Column name Contract_Amt_Act */
    public static final String COLUMNNAME_Contract_Amt_Act = "Contract_Amt_Act";
    
    /** Set Contract Amt (Actual).
	@param Contract_Amt_Act Contract Amt (Actual)	  */
	public void setContract_Amt_Act (BigDecimal Contract_Amt_Act)
	{
		set_Value (COLUMNNAME_Contract_Amt_Act, Contract_Amt_Act);
	}
	
	/** Get Contract Amt (Actual).
		@return Contract Amt (Actual)	  */
	public BigDecimal getContract_Amt_Act () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Contract_Amt_Act);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	 /** Column name DocStatus */
    public static final String COLUMNNAME_DocStatus = "DocStatus";
    
    /** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Suspended = SU */
	public static final String DOCSTATUS_Suspended = "SU";
	/** Activated = AC */
	public static final String DOCSTATUS_Activated = "AC";
	/** Canceled = CA */
	public static final String DOCSTATUS_Canceled = "CA";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	
	/** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";
    
    /** Set Document No.
	@param DocumentNo 
	Document sequence number of the document
    */
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}
	
	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}
	
	 /** Column name IsSOTrx */
    public static final String COLUMNNAME_IsSOTrx = "IsSOTrx";
    
    /** Set Sales Transaction.
	@param IsSOTrx 
	This is a Sales Transaction
     */
	public void setIsSOTrx (boolean IsSOTrx)
	{
		set_ValueNoCheck (COLUMNNAME_IsSOTrx, Boolean.valueOf(IsSOTrx));
	}
	
	/** Get Sales Transaction.
		@return This is a Sales Transaction
	  */
	public boolean isSOTrx () 
	{
		Object oo = get_Value(COLUMNNAME_IsSOTrx);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Column name JobWork_Product_ID */
    public static final String COLUMNNAME_JobWork_Product_ID = "JobWork_Product_ID";
    
    public org.compiere.model.I_M_Product getJobWork_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getJobWork_Product_ID(), get_TrxName());	}

	/** Set Job Work.
		@param JobWork_Product_ID Job Work	  */
	public void setJobWork_Product_ID (int JobWork_Product_ID)
	{
		if (JobWork_Product_ID < 1) 
			set_Value (COLUMNNAME_JobWork_Product_ID, null);
		else 
			set_Value (COLUMNNAME_JobWork_Product_ID, Integer.valueOf(JobWork_Product_ID));
	}

	/** Get Job Work.
		@return Job Work	  */
	public int getJobWork_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_JobWork_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name QtyProcessed */
    public static final String COLUMNNAME_QtyProcessed = "QtyProcessed";
    
    /** Set Quantity Processed.
	@param QtyProcessed Quantity Processed	  */
	public void setQtyProcessed (BigDecimal QtyProcessed)
	{
		set_Value (COLUMNNAME_QtyProcessed, QtyProcessed);
	}
	
	/** Get Quantity Processed.
		@return Quantity Processed	  */
	public BigDecimal getQtyProcessed () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyProcessed);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Column name TF_Processing */
    public static final String COLUMNNAME_TF_Processing = "TF_Processing";
    
    /** Set Process Now.
	@param TF_Processing Process Now	  */
	public void setTF_Processing (String TF_Processing)
	{
		set_Value (COLUMNNAME_TF_Processing, TF_Processing);
	}
	
	/** Get Process Now.
		@return Process Now	  */
	public String getTF_Processing () 
	{
		return (String)get_Value(COLUMNNAME_TF_Processing);
	}
	
	/** Column name Unit_Price */
    public static final String COLUMNNAME_Unit_Price = "Unit_Price";
    /** Set Unit Price.
	@param Unit_Price Unit Price	  */
	public void setUnit_Price (BigDecimal Unit_Price)
	{
		set_Value (COLUMNNAME_Unit_Price, Unit_Price);
	}
	
	/** Get Unit Price.
		@return Unit Price	  */
	public BigDecimal getUnit_Price () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Unit_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Column name DocAction */
    public static final String COLUMNNAME_DocAction = "DocAction";
    
    /** Start = S */
	public static final String DOCACTION_Start = "S";
	/** End = E */
	public static final String DOCACTION_End = "E";
	/** Modify = D */
	public static final String DOCACTION_Modify = "D";
	/** Force Close = X */
	public static final String DOCACTION_ForceClose = "X";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}
	
	/** Column name SubcontractType */
    public static final String COLUMNNAME_SubcontractType = "SubcontractType";
    /** Crusher Production = CP */
	public static final String SUBCONTRACTTYPE_CrusherProduction = "CP";
	/** Quarry Producton = QP */
	public static final String SUBCONTRACTTYPE_QuarryProducton = "QP";
	/** Sand Mining = SM */
	public static final String SUBCONTRACTTYPE_SandMining = "SM";
	/** Kating Project = KP */
	public static final String SUBCONTRACTTYPE_KatingProject = "KP";
	/** Sand Block Project = SP */
	public static final String SUBCONTRACTTYPE_SandBlockProject = "SP";
	/** Set Subcontract Type.
		@param SubcontractType Subcontract Type	  */
	public void setSubcontractType (String SubcontractType)
	{

		set_Value (COLUMNNAME_SubcontractType, SubcontractType);
	}

	/** Get Subcontract Type.
		@return Subcontract Type	  */
	public String getSubcontractType () 
	{
		String stype = (String)get_Value(COLUMNNAME_SubcontractType);		
		if(stype == null) {
			MSubcontractType st = new MSubcontractType(getCtx(), getTF_SubcontractType_ID(), get_TrxName());
			stype = st.getSubcontractType();
		}
		return stype;		
	}

	/** Column name M_Warehouse_ID */
    public static final String COLUMNNAME_M_Warehouse_ID = "M_Warehouse_ID";
    public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
    {
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_Name)
			.getPO(getM_Warehouse_ID(), get_TrxName());	}

	/** Set Warehouse.
		@param M_Warehouse_ID 
		Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1) 
			set_Value (COLUMNNAME_M_Warehouse_ID, null);
		else 
			set_Value (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name TF_SubcontractType_ID */
    public static final String COLUMNNAME_TF_SubcontractType_ID = "TF_SubcontractType_ID";
    /** Set Subcontract Type.
	@param TF_SubcontractType_ID Subcontract Type	  */
	public void setTF_SubcontractType_ID (int TF_SubcontractType_ID)
	{
		if (TF_SubcontractType_ID < 1) 
			set_Value (COLUMNNAME_TF_SubcontractType_ID, null);
		else 
			set_Value (COLUMNNAME_TF_SubcontractType_ID, Integer.valueOf(TF_SubcontractType_ID));
	}
	
	/** Get Subcontract Type.
		@return Subcontract Type	  */
	public int getTF_SubcontractType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_SubcontractType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
    /** Column name TF_Quarry_ID */
    public static final String COLUMNNAME_TF_Quarry_ID = "TF_Quarry_ID";
    /** Set Quarry.
	@param TF_Quarry_ID Quarry	  */
	public void setTF_Quarry_ID (int TF_Quarry_ID)
	{
		if (TF_Quarry_ID < 1) 
			set_Value (COLUMNNAME_TF_Quarry_ID, null);
		else 
			set_Value (COLUMNNAME_TF_Quarry_ID, Integer.valueOf(TF_Quarry_ID));
	}
	
	/** Get Quarry.
		@return Quarry	  */
	public int getTF_Quarry_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_Quarry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name AD_OrgLinked_ID */
    public static final String COLUMNNAME_AD_OrgLinked_ID = "AD_OrgLinked_ID";
    /** Set Organization.
	@param AD_OrgLinked_ID 
	LInk Organization
     */
	public void setAD_OrgLinked_ID (int AD_OrgLinked_ID)
	{
		if (AD_OrgLinked_ID < 1) 
			set_Value (COLUMNNAME_AD_OrgLinked_ID, null);
		else 
			set_Value (COLUMNNAME_AD_OrgLinked_ID, Integer.valueOf(AD_OrgLinked_ID));
	}
	
	/** Get Organization.
		@return LInk Organization
	  */
	public int getAD_OrgLinked_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_OrgLinked_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name C_ProjectLinked_ID */
    public static final String COLUMNNAME_C_ProjectLinked_ID = "C_ProjectLinked_ID";
    public org.compiere.model.I_C_Project getC_ProjectLinked() throws RuntimeException
    {
		return (org.compiere.model.I_C_Project)MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
			.getPO(getC_ProjectLinked_ID(), get_TrxName());	}

	/** Set Link Subcontract.
		@param C_ProjectLinked_ID Link Subcontract	  */
	public void setC_ProjectLinked_ID (int C_ProjectLinked_ID)
	{
		if (C_ProjectLinked_ID < 1) 
			set_Value (COLUMNNAME_C_ProjectLinked_ID, null);
		else 
			set_Value (COLUMNNAME_C_ProjectLinked_ID, Integer.valueOf(C_ProjectLinked_ID));
	}

	/** Get Link Subcontract.
		@return Link Subcontract	  */
	public int getC_ProjectLinked_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ProjectLinked_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name CreateSalesInvoice */
    public static final String COLUMNNAME_CreateSalesInvoice = "CreateSalesInvoice";
    /** Set Create Sales Invoice.
	@param CreateSalesInvoice 
	Sales Invoice will be created for Purchase Invoice created for the Linked Project.
     */
	public void setCreateSalesInvoice (boolean CreateSalesInvoice)
	{
		set_Value (COLUMNNAME_CreateSalesInvoice, Boolean.valueOf(CreateSalesInvoice));
	}
	
	/** Get Create Sales Invoice.
		@return Sales Invoice will be created for Purchase Invoice created for the Linked Project.
	  */
	public boolean isCreateSalesInvoice () 
	{
		Object oo = get_Value(COLUMNNAME_CreateSalesInvoice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
    /** Column name C_DocTypeLink_ID */
    public static final String COLUMNNAME_C_DocTypeLink_ID = "C_DocTypeLink_ID";
	public org.compiere.model.I_C_DocType getC_DocTypeLink() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocTypeLink_ID(), get_TrxName());	}

	/** Set Link Purchase Invoice Doc Type.
		@param C_DocTypeLink_ID Link Purchase Invoice Doc Type	  */
	public void setC_DocTypeLink_ID (int C_DocTypeLink_ID)
	{
		if (C_DocTypeLink_ID < 1) 
			set_Value (COLUMNNAME_C_DocTypeLink_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocTypeLink_ID, Integer.valueOf(C_DocTypeLink_ID));
	}

	/** Get Link Purchase Invoice Doc Type.
		@return Link Purchase Invoice Doc Type	  */
	public int getC_DocTypeLink_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocTypeLink_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name C_DocTypeSalesInvoice_ID */
    public static final String COLUMNNAME_C_DocTypeSalesInvoice_ID = "C_DocTypeSalesInvoice_ID";
    
	public org.compiere.model.I_C_DocType getC_DocTypeSalesInvoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocTypeSalesInvoice_ID(), get_TrxName());	
	}

	/** Set Sales Invoice Doc Type.
		@param C_DocTypeSalesInvoice_ID Sales Invoice Doc Type	  */
	public void setC_DocTypeSalesInvoice_ID (int C_DocTypeSalesInvoice_ID)
	{
		if (C_DocTypeSalesInvoice_ID < 1) 
			set_Value (COLUMNNAME_C_DocTypeSalesInvoice_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocTypeSalesInvoice_ID, Integer.valueOf(C_DocTypeSalesInvoice_ID));
	}

	/** Get Sales Invoice Doc Type.
		@return Sales Invoice Doc Type	  */
	public int getC_DocTypeSalesInvoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocTypeSalesInvoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name C_BPartnerSubcon2_ID */
    public static final String COLUMNNAME_C_BPartnerSubcon2_ID = "C_BPartnerSubcon2_ID";
    public org.compiere.model.I_C_BPartner getC_BPartnerSubcon2() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartnerSubcon2_ID(), get_TrxName());	}

	/** Set Subcontractor 2.
		@param C_BPartnerSubcon2_ID Subcontractor 2	  */
	public void setC_BPartnerSubcon2_ID (int C_BPartnerSubcon2_ID)
	{
		if (C_BPartnerSubcon2_ID < 1) 
			set_Value (COLUMNNAME_C_BPartnerSubcon2_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartnerSubcon2_ID, Integer.valueOf(C_BPartnerSubcon2_ID));
	}

	/** Get Subcontractor 2.
		@return Subcontractor 2	  */
	public int getC_BPartnerSubcon2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartnerSubcon2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name M_ProductSubcon2_ID */
    public static final String COLUMNNAME_M_ProductSubcon2_ID = "M_ProductSubcon2_ID";
    public org.compiere.model.I_M_Product getM_ProductSubcon2() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_ProductSubcon2_ID(), get_TrxName());	}

	/** Set Product (Subcontract 2).
		@param M_ProductSubcon2_ID Product (Subcontract 2)	  */
	public void setM_ProductSubcon2_ID (int M_ProductSubcon2_ID)
	{
		if (M_ProductSubcon2_ID < 1) 
			set_Value (COLUMNNAME_M_ProductSubcon2_ID, null);
		else 
			set_Value (COLUMNNAME_M_ProductSubcon2_ID, Integer.valueOf(M_ProductSubcon2_ID));
	}

	/** Get Product (Subcontract 2).
		@return Product (Subcontract 2)	  */
	public int getM_ProductSubcon2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_ProductSubcon2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Column name PriceSubcon2 */
    public static final String COLUMNNAME_PriceSubcon2 = "PriceSubcon2";
    /** Set Contract Price (Subcon2).
	@param PriceSubcon2 Contract Price (Subcon2)	  */
	public void setPriceSubcon2 (BigDecimal PriceSubcon2)
	{
		set_Value (COLUMNNAME_PriceSubcon2, PriceSubcon2);
	}
	
	/** Get Contract Price (Subcon2).
		@return Contract Price (Subcon2)	  */
	public BigDecimal getPriceSubcon2 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PriceSubcon2);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	
	@Override
	protected boolean beforeSave(boolean newRecord) {
		//if(newRecord)
		//	setValue(getName());
		if(getDocumentNo() != null && (getValue() == null || getValue().length()==0))
			setValue(getDocumentNo());
		
		//Set Default Project Type - Subcontract
		MProjectType projType = new MProjectType(getCtx(), 1000000, get_TrxName());		
		setProjectType(projType);
		
		//Update Contract Amt Actual
		if(is_ValueChanged(COLUMNNAME_QtyProcessed) || is_ValueChanged(COLUMNNAME_Unit_Price))
			setContract_Amt_Act(getUnit_Price().multiply(getQtyProcessed()));
				
		//1. Jobwork is Mandatory when SubcontractType.Invoice For : Jobwork
		//2. Quarry is mandatory when SubcontractType.CreateBoulderReceipt is true
		
		MSubcontractType contractType = new MSubcontractType(getCtx(), getTF_SubcontractType_ID(), get_TrxName());
		setSubcontractType(contractType.getSubcontractType());
		setIsSOTrx(contractType.isSOTrx());
		if(contractType.getInvoiceFor().equals(MSubcontractType.INVOICEFOR_Jobwork) && getJobWork_Product_ID() == 0) {
			throw new AdempiereException("The selected Subcontract Type enforces that the Jobwork is mandatory");
		}
		if(contractType.isCreateBoulderReceipt() && getTF_Quarry_ID() == 0) {
			throw new AdempiereException("The selected Subcontract Type enforces that the Quarry is mandatory");
		}
		
		return super.beforeSave(newRecord);
	}
	
	
	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {		
		boolean ok = super.afterSave(newRecord, success);
		if(getC_BPartner_ID() > 0 && newRecord) {
			MJobworkAssignedBPartner jwBP = MJobworkAssignedBPartner.getJobwork(getAD_Org_ID(), getC_BPartner_ID());
			if(jwBP == null) {
				jwBP = new MJobworkAssignedBPartner(getCtx(), 0, get_TrxName());
				jwBP.setAD_Org_ID(getAD_Org_ID());
				jwBP.setC_BPartner_ID(getC_BPartner_ID());
				jwBP.setC_Project_ID(getC_Project_ID());
				jwBP.saveEx();
			}
		}
		return ok;
	}

	public void processIt(String docAction) {
		if(docAction.equals(DOCACTION_Start)) {
			setDocStatus(DOCSTATUS_InProgress);
			setProcessed(false);
		}
		else if(docAction.equals(DOCACTION_Modify)) {
			setDocStatus(DOCSTATUS_Drafted);
			setProcessed(false);
		}
		else if(docAction.equals(DOCACTION_End)) {
			setDocStatus(DOCSTATUS_Completed);
			setProcessed(true);
		}
		else if(docAction.equals(DOCACTION_ForceClose)) {
			setDocStatus(DOCSTATUS_Closed);
			setProcessed(true);
		}
	}
	
	public void updateQtyProcessed() {
		if(getSubcontractType().equals(SUBCONTRACTTYPE_KatingProject) ||
				getSubcontractType().equals(SUBCONTRACTTYPE_SandMining)) {
			String sql = "UPDATE C_Project SET QtyProcessed=COALESCE((SELECT  SUM(Tonnage) FROM TF_KatingEntry k "
					+ "WHERE k.C_Project_ID = C_Project.C_Project_ID AND DocStatus='CO'),0) WHERE C_Project_ID = " + getC_Project_ID();
			DB.executeUpdate(sql, get_TrxName());
			
			sql = "UPDATE C_Project SET Contract_Amt_Act=COALESCE((SELECT  SUM(Tonnage * Price) FROM TF_KatingEntry k "
					+ "WHERE k.C_Project_ID = C_Project.C_Project_ID AND DocStatus='CO'),0) WHERE C_Project_ID = " + getC_Project_ID();
			DB.executeUpdate(sql, get_TrxName());
		}
	}
	
	public void updateQtyBilled() {
		if(getSubcontractType().equals(SUBCONTRACTTYPE_KatingProject) ||
				getSubcontractType().equals(SUBCONTRACTTYPE_SandMining)) {
			String so = isSOTrx() ? "Y" : "N";
			String sql = "SELECT 	SUM(QtyInvoiced) FROM C_Invoice i INNER JOIN C_InvoiceLine il  "
					+ "ON i.C_Invoice_ID = il.C_Invoice_ID WHERE i.C_Project_ID = ? AND C_BPartner_ID = ? AND i.DocStatus = 'CO' AND i.IsSOTrx=?";
			BigDecimal qtyInvoiced = DB.getSQLValueBD(get_TrxName(), sql, getC_Project_ID(), getC_BPartner_ID(), so);
			if(qtyInvoiced == null)
				qtyInvoiced = BigDecimal.ZERO;
			setInvoicedQty(qtyInvoiced);
			
			//Set Amount 
			sql = " SELECT SUM(GrandTotal) FROM C_Invoice i WHERE i.C_Project_ID = ? AND C_BPartner_ID = ? AND i.DocStatus = 'CO' AND i.IsSOTrx=?";
			BigDecimal invoicedAmt = DB.getSQLValueBD(get_TrxName(), sql, getC_Project_ID(), getC_BPartner_ID(), so);
			if(invoicedAmt == null)
				invoicedAmt = BigDecimal.ZERO;
			setInvoicedAmt(invoicedAmt);
			
			
		}
	}
	
	public void updateBoulderReceiptBasedFields(MBoulderReceipt br) {
		
		if(getC_Project_ID() == br.getC_Project_ID() && getJobWork_Product_ID() == br.getJobWork_Product_ID()) {
			//Set Qty Processed
			setQtyProcessed(getQtyProcessed().add(br.getQtyReceived()));
			
			//Update Received Items
			MJobworkReceivedItems.addReceivedItem(getCtx(), getC_Project_ID(), br.getM_Product_ID(),
						br.getQtyReceived(), br.getC_UOM_ID(), br.get_TrxName());
		}
		
	}
	
	public void reverseBoulderReceiptBasedFields(MBoulderReceipt br) {
		
		if(getC_Project_ID() == br.getC_Project_ID() && getJobWork_Product_ID() == br.getJobWork_Product_ID()) {
			//Set Qty Processed
			setQtyProcessed(getQtyProcessed().subtract(br.getQtyReceived()));
			
			//Update Received Items
			MJobworkReceivedItems.addReceivedItem(getCtx(), getC_Project_ID(), br.getM_Product_ID(),
						br.getQtyReceived().negate(), br.getC_UOM_ID(), br.get_TrxName());
		}
		
	}
	
	public static TF_MProject getCrusherProductionSubcontractByWarehouse(int M_Warehouse_ID) {
		TF_MProject proj = new Query(Env.getCtx(), TF_MProject.Table_Name, "M_Warehouse_ID=? AND DocStatus='IP' "
				+ " AND C_Project.TF_SubcontractType_ID IN (SELECT a.TF_SubcontractType_ID FROM TF_SubcontractType a "
				+ " WHERE a.SubcontractType='CP' )", null)
				.setParameters(M_Warehouse_ID).first();
		return proj;
	}

	public static TF_MProject getProject(int M_Warehouse_ID) {
		TF_MProject proj = new Query(Env.getCtx(), TF_MProject.Table_Name, "M_Warehouse_ID=? AND DocStatus='IP' ", null)
				.setParameters(M_Warehouse_ID).first();
		return proj;
				
	}
	
	public static TF_MProject getLinkedProject(int C_Project_ID) {
		String whereClause = COLUMNNAME_C_ProjectLinked_ID + " = ? AND DocStatus = 'IP' ";
		TF_MProject proj = new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setClient_ID().setParameters(C_Project_ID).first();
		return proj;
	}
	
	/** Column name JobWorkWOTrans_Product_ID */
    public static final String COLUMNNAME_JobWorkWOTrans_Product_ID = "JobWorkWOTrans_Product_ID";
    public org.compiere.model.I_M_Product getJobWorkWOTrans_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getJobWorkWOTrans_Product_ID(), get_TrxName());	}

	/** Set Jobwork w/o Transport.
		@param JobWorkWOTrans_Product_ID Jobwork w/o Transport	  */
	public void setJobWorkWOTrans_Product_ID (int JobWorkWOTrans_Product_ID)
	{
		if (JobWorkWOTrans_Product_ID < 1) 
			set_Value (COLUMNNAME_JobWorkWOTrans_Product_ID, null);
		else 
			set_Value (COLUMNNAME_JobWorkWOTrans_Product_ID, Integer.valueOf(JobWorkWOTrans_Product_ID));
	}

	/** Get Jobwork w/o Transport.
		@return Jobwork w/o Transport	  */
	public int getJobWorkWOTrans_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_JobWorkWOTrans_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getC_Tax_ID(), get_TrxName());	}

	/** Column name C_Tax_ID */
    public static final String COLUMNNAME_C_Tax_ID = "C_Tax_ID";
    
	/** Set Tax.
		@param C_Tax_ID 
		Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID)
	{
		if (C_Tax_ID < 1) 
			set_Value (COLUMNNAME_C_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
	}

	/** Get Tax.
		@return Tax identifier
	  */
	public int getC_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	/** Column name RequiredConsolidateInv */
    public static final String COLUMNNAME_RequiredConsolidateInv = "RequiredConsolidateInv";
    
		/** Set Requires Consolidate Invoice.
		@param RequiredConsolidateInv Requires Consolidate Invoice	  */
	public void setRequiredConsolidateInv (boolean RequiredConsolidateInv)
	{
		set_Value (COLUMNNAME_RequiredConsolidateInv, Boolean.valueOf(RequiredConsolidateInv));
	}
	
	/** Get Requires Consolidate Invoice.
		@return Requires Consolidate Invoice	  */
	public boolean isRequiredConsolidateInv () 
	{
		Object oo = get_Value(COLUMNNAME_RequiredConsolidateInv);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

    /** Column name MinContract_UOM_ID */
    public static final String COLUMNNAME_MinContract_UOM_ID = "MinContract_UOM_ID";
    
    /** Column name MinContract_Amt */
    public static final String COLUMNNAME_MinContract_Amt = "MinContract_Amt";
    
    /** Set Minimum Contract Amount.
	@param MinContract_Amt Minimum Contract Amount	  */
	public void setMinContract_Amt (BigDecimal MinContract_Amt)
	{
		set_Value (COLUMNNAME_MinContract_Amt, MinContract_Amt);
	}
	
	/** Get Minimum Contract Amount.
		@return Minimum Contract Amount	  */
	public BigDecimal getMinContract_Amt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_MinContract_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_UOM getMinContract_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getMinContract_UOM_ID(), get_TrxName());	}

	/** Set Minimum Contract UOM.
		@param MinContract_UOM_ID 
		Minimum Contract Unit of Measure
	  */
	public void setMinContract_UOM_ID (int MinContract_UOM_ID)
	{
		if (MinContract_UOM_ID < 1) 
			set_Value (COLUMNNAME_MinContract_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_MinContract_UOM_ID, Integer.valueOf(MinContract_UOM_ID));
	}

	/** Get Minimum Contract UOM.
		@return Minimum Contract Unit of Measure
	  */
	public int getMinContract_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MinContract_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

}
