package com.demo.action;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.demo.action.log.LogStudentManager;
import com.demo.action.tracker.StudentManagerTracker;
import com.demo.service.IStudentManage;

public class Activator implements BundleActivator{
	StudentManagerTracker managerTracker ;
	public void start(BundleContext context) throws Exception {
		System.out.println("action start begin...");
		managerTracker=new StudentManagerTracker(context);
		managerTracker.open();
		IStudentManage service=(IStudentManage)managerTracker.getService();
		service.add();
		System.out.println("action start end...");
	}

	public void stop(BundleContext context) throws Exception {
		managerTracker.close();
	}

}
