package org.syvasoft.tallyfrontcrusher.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MResourceType;
import org.compiere.util.Env;

public class TF_MResourceType extends MResourceType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8190020401300216847L;

	public TF_MResourceType(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MResourceType(Properties ctx, int S_ResourceType_ID,
			String trxName) {
		super(ctx, S_ResourceType_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	 /** Column name Std_Load */
    public static final String COLUMNNAME_Std_Load = "Std_Load";
    
    /** Set Standard Load.
	@param Std_Load Standard Load	  */
	public void setStd_Load (BigDecimal Std_Load)
	{
		set_Value (COLUMNNAME_Std_Load, Std_Load);
	}
	
	/** Get Standard Load.
		@return Standard Load	  */
	public BigDecimal getStd_Load () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Std_Load);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
	
	/** Column name ContractBase */
    public static final String COLUMNNAME_ContractBase = "ContractBase";
    
    /** Day = D */
	public static final String CONTRACTBASE_Day = "D";
	/** Meter = M */
	public static final String CONTRACTBASE_Meter = "M";
	/** Set Contract Base.
		@param ContractBase 
		Represents how the contract amount will be calculated.
	  */
	public void setContractBase (String ContractBase)
	{

		set_Value (COLUMNNAME_ContractBase, ContractBase);
	}

	/** Get Contract Base.
		@return Represents how the contract amount will be calculated.
	  */
	public String getContractBase () 
	{
		return (String)get_Value(COLUMNNAME_ContractBase);
	}

	/** Column name IsFuelIncluded */
    public static final String COLUMNNAME_IsFuelIncluded = "IsFuelIncluded";
    
    /** Set Fuel Included.
	@param IsFuelIncluded Fuel Included	  */
	public void setIsFuelIncluded (boolean IsFuelIncluded)
	{
		set_Value (COLUMNNAME_IsFuelIncluded, Boolean.valueOf(IsFuelIncluded));
	}

	/** Get Fuel Included.
	@return Fuel Included	  */
	public boolean isFuelIncluded () 
	{
		Object oo = get_Value(COLUMNNAME_IsFuelIncluded);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}


}
