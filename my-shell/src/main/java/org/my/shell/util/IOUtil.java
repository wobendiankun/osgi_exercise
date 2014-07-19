package org.my.shell.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class IOUtil {
	public static BufferedReader getReader(InputStream input){
		return new BufferedReader(
				new InputStreamReader(input));
	}
	public static PrintStream getWriter(OutputStream out){
		return new PrintStream(out);
	}
}
