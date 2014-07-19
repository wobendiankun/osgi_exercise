package org.my.shell.command;

import java.io.PrintWriter;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public abstract class BasicCommand implements Command {
	BundleContext context;
	String help;
	
	public BasicCommand(BundleContext context, String help) {
		super();
		this.context = context;
		this.help = help;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public Bundle getBundle(String id) {
	    Bundle bundle = null;
	    if (id != null) {
	      bundle = this.context.getBundle(Long.parseLong(id.trim()));
	    }
	    if (bundle == null) {
	      throw new IllegalArgumentException("No such bundle: " + id);
	    }
	    return bundle;
	  }
}
