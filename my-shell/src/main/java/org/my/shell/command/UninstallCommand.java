package org.my.shell.command;

import java.io.PrintStream;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

public class UninstallCommand extends BasicCommand {

	
	public UninstallCommand(BundleContext context, String help) {
		super(context, help);
	}

	public void execute(String args, PrintStream out) {
		 Bundle bundle = getBundle(args);
		 try {
			bundle.uninstall();
		} catch (BundleException e) {
			e.printStackTrace();
		}
	}
}
