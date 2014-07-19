package org.my.shell.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.my.shell.command.Command;
import org.my.shell.command.ExecuteCommand;
import org.my.shell.command.LogCommandDecorator;
import org.my.shell.util.IOUtil;
import org.osgi.framework.BundleContext;

/**
 * @author wumingkun
 * 
 */
public class TelnetBinding implements Runnable, Binding {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.my.shell.thread.Bind#bind()
	 */
	Thread thread = new Thread(this, "ServerSorketThread");
	ServerSocket serverSocket;
	BundleContext context;

	public TelnetBinding(BundleContext context,
			ServerSocket serverSocket) {
		this.context = context;
		this.serverSocket = serverSocket;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.my.shell.thread.Bind#start()
	 */
	public void start() {
		thread.start();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Socket socket = this.serverSocket.accept();
				Shell shell = null;
				BufferedReader in=IOUtil.getReader(socket.getInputStream());
				PrintStream out=IOUtil.getWriter(socket.getOutputStream());
				shell = new Shell(
							new LogCommandDecorator(new ExecuteCommand(context)),
							in,
							out);
				Thread shellThread = new Thread(shell);
				shellThread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public void stop() throws InterruptedException {
		thread.interrupt();
	    try {
	    	serverSocket.close();
	    } catch (IOException e) {
	      // Ignore
	    }
	    thread.join();
	}

}
