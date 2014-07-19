package org.my.shell.command;

import java.io.PrintStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.my.shell.log.LoggerFactory;
import org.my.shell.util.ConfigUtil;

public class LogCommandDecorator extends AbstractCommandDecorator {
	public LogCommandDecorator(Command command) {
		super(command);
	}

	static Logger logger=LoggerFactory.getLogger(LogCommandDecorator.class);
	
	public void execute(String args, PrintStream out) {
		logger.info(args+" begin...");
		this.command.execute(args, out);
		logger.info(args+" end...");
	}
	
	
}
