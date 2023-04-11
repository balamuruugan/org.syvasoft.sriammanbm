package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.MResource;
import org.compiere.model.MTable;
import org.compiere.model.Query;

public class TF_MResource extends MResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -662134160983709054L;

	public TF_MResource(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public TF_MResource(Properties ctx, int S_Resource_ID, String trxName) {
		super(ctx, S_Resource_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	/** Column name IsRented */
    public static final String COLUMNNAME_IsRented = "IsRented";
    /** Set Rented.
	@param IsRented Rented	  */
	public void setIsRented (boolean IsRented)
	{
		set_Value (COLUMNNAME_IsRented, Boolean.valueOf(IsRented));
	}
	
	/** Get Rented.
		@return Rented	  */
	public boolean isRented () 
	{
		Object oo = get_Value(COLUMNNAME_IsRented);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
	
	/** Column name C_ElementValue_ID */
    public static final String COLUMNNAME_C_ElementValue_ID = "C_ElementValue_ID";
    
	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValue_ID(), get_TrxName());	}

	/** Set Account Element.
		@param C_ElementValue_ID 
		Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID)
	{
		if (C_ElementValue_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
	}

	/** Get Account Element.
		@return Account Element
	  */
	public int getC_ElementValue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
	
	public static TF_MResource getTF_MResource(Properties ctx, String value) {
		List<TF_MResource> list = new Query(ctx, Table_Name, "Value=?", null)
			.setClient_ID().setParameters(value).list();
		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
}
