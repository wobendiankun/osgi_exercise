/**
 * @author wumingkun
 * @version 1.0.0
 * @Description
 */

package org.my.shell.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

/**
 * @author wumingkun
 * 
 */
public class ConfigUtil {
	private static Properties properties = new Properties();
	private static String path;
	private static int port;

	public static int getPort() {
		return port;
	}
	static {
		setPath();
		initHost();
	}

	private static void initHost() {
		InputStream inputStream = null;
		try {
			File file = new File(path + Constant.SERVERSORKET_CONFIG_FILENAME);
			inputStream = new FileInputStream(file);
			properties.load(inputStream);
			port = Integer.parseInt(properties.get("port").toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			properties = null;
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 */
	private static void setPath() {
		path = System.getProperty("user.dir") + File.separator
		+ Constant.CONFIG_FILEPATH + File.separator;
	}

}
