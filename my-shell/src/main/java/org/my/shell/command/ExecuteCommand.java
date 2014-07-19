package org.my.shell.command;

import java.io.PrintStream;

import org.my.shell.cache.CommandCache;
import org.osgi.framework.BundleContext;


public class ExecuteCommand implements Command {
	BundleContext context;
	
	public ExecuteCommand(BundleContext context) {
		this.context = context;
	}

	public void execute(String args, PrintStream out) {
		int idx = args.indexOf(' ');

	    boolean found = false;

	    Command command = CommandCache.getInstance(
	    						this.context)
	    						.get((idx > 0) ? args.substring(0, idx) : args);

	    if (command != null) {
	      found = true;

	      try {
	        command.execute((idx > 0) ? args.substring(idx) : null, out);
	      } catch (Exception ex) {
	        ex.printStackTrace(out);
	        out.println("Unable to execute: " + args);
	      }
	    }
	  
	    if (!found && !(args.trim().length() == 0)) {
	      out.println("Unknown command: " + args);
	    }
	  }
}
