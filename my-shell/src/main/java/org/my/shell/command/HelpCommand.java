/** 
 * @author wumingkun
 * @version 1.0.0
 * @Description
 */

package org.my.shell.command;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Set;

import org.my.shell.cache.CommandCache;
import org.osgi.framework.BundleContext;

/**
 * @author wumingkun
 *
 */
public class HelpCommand extends BasicCommand {

	/**
	 * @param context
	 * @param help
	 */
	public HelpCommand(BundleContext context, String help) {
		super(context, help);
	}

	/* (non-Javadoc)
	 * @see org.my.shell.command.Command#execute(java.lang.String, java.io.PrintStream)
	 */
	public void execute(String args, PrintStream out) {
		Set<String> set=CommandCache.keySet();
		Iterator<String> iterator=set.iterator();
		CommandCache cache=CommandCache.getInstance(context);
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			BasicCommand command=(BasicCommand)cache.get(key);
			out.println(command.getHelp());
		}
	}

}
