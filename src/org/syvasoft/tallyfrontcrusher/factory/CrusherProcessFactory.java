package org.syvasoft.tallyfrontcrusher.factory;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

public class CrusherProcessFactory implements IProcessFactory {

	@Override
	public ProcessCall newProcessInstance(String className) {
		ProcessCall process = null;
		try {
			Class<?> clazz = getClass().getClassLoader().loadClass(className);
			process =  (ProcessCall) clazz.newInstance();
		} catch (Exception e) {
		}
		
		return process;
	}

}
