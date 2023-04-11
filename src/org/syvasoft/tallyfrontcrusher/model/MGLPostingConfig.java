package org.syvasoft.tallyfrontcrusher.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

public class MGLPostingConfig extends X_TF_GLPosting_Config {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3100346545055203531L;

	public MGLPostingConfig(Properties ctx, int TF_GLPosting_Config_ID,
			String trxName) {
		super(ctx, TF_GLPosting_Config_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MGLPostingConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public static MGLPostingConfig getMGLPostingConfig(Properties ctx) {
		List<MGLPostingConfig> glConfig = new Query(ctx, Table_Name, "", null)
		.setClient_ID().list();
		if(glConfig.size() > 0)
			return glConfig.get(0);
		else
			return null;
	}
	
	public int getPFPayableAcct_ID() {
		return get_ValueAsInt("PFPayableAcct_ID");
	}
}
