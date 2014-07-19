package org.my.shell.command;

import java.io.PrintStream;

public interface Command {
	void execute(String args,PrintStream out);
}
