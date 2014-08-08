/** 
 * 
 * @author wumingkun
 * @version 1.0.0
 * @Description
 */

package com.demo.hello.provider;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.demo.hello.provider.log.LoggerFactory;

/**
 * @author wumingkun
 *
 */
public class Activator implements BundleActivator {
	
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		Logger logger =LoggerFactory.getLogger(Activator.class);
		logger.info("bundle start...");
	}

	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {

	}

}
