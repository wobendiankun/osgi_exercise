package org.my.shell.command;

import java.io.PrintWriter;

import org.osgi.framework.BundleContext;

public abstract class AbstractCommandDecorator implements Command {
	Command command;
	public AbstractCommandDecorator(Command command) {
		this.command=command;
	}
}
