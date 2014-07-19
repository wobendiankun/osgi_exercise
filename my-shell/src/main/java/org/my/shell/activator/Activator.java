package org.my.shell.activator;

import java.net.ServerSocket;

import org.apache.log4j.Logger;
import org.my.shell.command.LogCommandDecorator;
import org.my.shell.log.LoggerFactory;
import org.my.shell.server.Binding;
import org.my.shell.server.TelnetBinding;
import org.my.shell.util.ConfigUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {
	static Logger logger=LoggerFactory.getLogger(Activator.class);
	private  Binding binding;
	public void start(BundleContext context) throws Exception {
		binding=new TelnetBinding(context, new ServerSocket(ConfigUtil.getPort()));
		binding.start();
		logger.info("server start... - listening on port "+ConfigUtil.getPort());
		
	}
	public void stop(BundleContext context) throws Exception {
		binding.stop();
		logger.info("server stop...");
	}

}
