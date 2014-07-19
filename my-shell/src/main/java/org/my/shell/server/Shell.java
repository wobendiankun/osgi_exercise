package org.my.shell.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.my.shell.command.Command;

public class Shell implements Runnable {
	private final Command command;
	private final BufferedReader in;
	private final PrintStream out;

	public Shell(Command command, BufferedReader in, PrintStream out) {
		this.command = command;
		this.in = in;
		this.out = out;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			this.out.print("-> ");
			this.out.flush();
			String cmdLine;
			try {
				cmdLine = this.in.readLine();
			} catch (IOException ex) {
				if (!Thread.currentThread().isInterrupted()) {
					ex.printStackTrace(this.out);
					this.out.println("Unable to read from stdin - exiting now");
				}
				return;
			}

			if (cmdLine == null) {
				this.out.println("Bye bye");
				return;
			}
			try {
				this.command.execute(cmdLine, out);
			} catch (Throwable t) {
				t.printStackTrace(this.out);
			}
		}
	}

}
