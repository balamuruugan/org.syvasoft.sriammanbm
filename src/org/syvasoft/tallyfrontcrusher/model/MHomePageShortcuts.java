package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MHomePageShortcuts extends X_TF_HomePageShortcuts {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6467144753994964669L;

	public MHomePageShortcuts(Properties ctx, int TF_HomePageShortcuts_ID, String trxName) {
		super(ctx, TF_HomePageShortcuts_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MHomePageShortcuts(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static String MENUTYPE_Info="Info_Menu_ID";
	public static String MENUTYPE_Window="Win_Menu_ID";
	public static String MENUTYPE_Report="Rpt_Menu_ID";
	
	public static List<MHomePageShortcuts> getShortcuts(int AD_Role_ID, String menuType) {
		String whereClause = " AD_Role_ID = ? AND " + menuType + " IS NOT NULL AND IsActive='Y'";		
		List<MHomePageShortcuts> list = new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setParameters(AD_Role_ID).list();
		return list;
	}
}
