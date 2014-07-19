package org.my.shell.command;

import java.io.PrintStream;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

public class InstallCommand extends BasicCommand {

	

	public InstallCommand(BundleContext context, String help) {
		super(context, help);
	}

	public void execute(String args, PrintStream out) {
		try {
			this.context.installBundle(args);
		} catch (BundleException e) {
			e.printStackTrace();
		}
	}

}
