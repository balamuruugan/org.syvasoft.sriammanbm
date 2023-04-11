package org.syvasoft.tallyfrontcrusher.process;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.compiere.model.MAttachment;
import org.compiere.model.MOrder;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.syvasoft.tallyfrontcrusher.model.MFuelIssue;
import org.syvasoft.tallyfrontcrusher.model.TF_MOrg;

public class FileToAttachment extends SvrProcess {

	int AD_Org_ID = 0;
	
	@Override
	protected void prepare() {
		for(ProcessInfoParameter p : getParameter()) {
			String name = p.getParameterName();
			if(name.equals("AD_Org_ID")) 
				AD_Org_ID = p.getParameterAsInt();
		}
	}

	@Override
	protected String doIt() throws Exception {		
		int count = AttachToFuelIssue();
		return count + " files are attached";
	}

	private int AttachToFuelIssue() throws Exception {
		String whereClause = AD_Org_ID > 0 ? "AD_Org_ID = " + AD_Org_ID : "";
		List<MOrg> orgs = new Query(getCtx(), MOrg.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.list();
		int fileCount = 0;
		for(MOrg org : orgs) {
			String filepath = org.get_ValueAsString("StoreFilePath");
			if(filepath == null)
				continue;
			
			String value = org.getValue();
			String folderpath = filepath + value + "/";
			//URI uri = new URI(folderpath);
			File folder = new File(folderpath);
			
			if(folder.listFiles() != null)
			for(File f : folder.listFiles()) {
				String fileName = f.getName();
				if(fileName == null)
					continue;				
				fileName = fileName.replace(".jpg", "").replace(".png","");
				String docNo = value + "/" + fileName;
				String wh = "DocumentNo = ?";
				MFuelIssue issue = new Query(getCtx(), MFuelIssue.Table_Name, wh, get_TrxName())
						.setClient_ID()
						.setParameters(docNo)
						.first();
				if(issue == null)
					continue;
				
				//Create Attachment
				MAttachment att = issue.createAttachment();
				att.addEntry(f);
				att.saveEx();							
				
				f.delete();
				fileCount ++;
				System.out.println("Image attached for : " + docNo );
			}
		}
		
		return fileCount;
	}
}
