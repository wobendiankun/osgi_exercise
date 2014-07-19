package org.my.shell.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.my.shell.util.ConfigUtil;

public class LoggerFactory {
	public static Logger getLogger(Class clazz){
		return Logger.getLogger(clazz);
	}
}
