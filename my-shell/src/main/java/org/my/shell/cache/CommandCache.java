package org.my.shell.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.my.shell.command.Command;
import org.my.shell.command.HelpCommand;
import org.my.shell.command.InstallCommand;
import org.my.shell.command.StartCommand;
import org.my.shell.command.UninstallCommand;
import org.osgi.framework.BundleContext;

public class CommandCache {
	private final Map<String, Command> commands = new HashMap<String, Command>();
	private BundleContext context;
	private static CommandCache commandCache;

	private CommandCache() {

	}

	public static CommandCache getInstance(BundleContext context) {
		if (commandCache == null) {
			commandCache = new CommandCache();
			commandCache.context = context;
			commandCache.init();
		}
		return commandCache ;
	}

	private void init() {
		commands.put("install", new InstallCommand(this.context,
				"install <url> - Install the bundle jar at the given url."));
		commands.put("start", new StartCommand(this.context,
				"start <id> - Start the bundle with the given bundle id."));
		commands.put(
				"uninstall",
				new UninstallCommand(this.context,
						"uninstall <id> - Uninstall the bundle with the given bundle id."));
		commands.put(
				"help",
				new HelpCommand(this.context,
				"help - show all command usage"));
	}
	public Command get(String key){
		return this.commands.get(key); 
	}
	public static Set<String> keySet(){
		return commandCache.commands.keySet();
	}
}
