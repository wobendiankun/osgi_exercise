package com.demo.action.log;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.demo.service.IStudentManage;

public class LogStudentManager implements IStudentManage {
	IStudentManage studentManage;
	BundleContext context;
	ServiceReference reference;
	
	public LogStudentManager(BundleContext context, ServiceReference reference) {
		this.context = context;
		this.reference = reference;
	}

	public void add() {
		studentManage=(IStudentManage) context.getService(reference);
		System.out.println("log start...");
		studentManage.add();
		System.out.println("log end...");
	}

}
