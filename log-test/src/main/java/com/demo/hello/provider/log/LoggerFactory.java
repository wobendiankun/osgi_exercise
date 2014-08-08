/**
 * 
 * @author wumingkun
 * @version 1.0.0
 * @Description 日志工厂类
 */

package com.demo.hello.provider.log;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author wumingkun
 * 
 */
public class LoggerFactory {
	public static final String CONFIG_DIR = "config";
	public static final String LOG4J_CONFIG = "myLog4j.properties";
	private static String fileName = getFileName();

	public static Logger getLogger(Class clazz) {
		Logger logger = Logger.getLogger(clazz);
		loadProperty();
		return logger;
	}

	private static String getFileName() {
		return System.getProperty("user.dir") + File.separator + CONFIG_DIR
				+ File.separator + LOG4J_CONFIG;
	}

	public static void loadProperty() {
		PropertyConfigurator.configure(fileName);
	}
}
