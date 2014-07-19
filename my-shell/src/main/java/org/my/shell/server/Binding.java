/**
 * @file Bind.java
 * 
 * @author wumingkun
 * @version 1.0.0
 * @Description
 */

package org.my.shell.server;

/**
 * @author wumingkun
 *
 */
public interface Binding {
	void start();
	public void stop() throws InterruptedException;
}
