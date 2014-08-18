package com.demo.action;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.demo.service.IStudentManage;


public class Activator implements BundleActivator{
	public void start(BundleContext context) throws Exception {
		System.out.println("action  begin...");
		ServiceReference sf=null;
		try {
			//查找Service
			sf=context.getServiceReference(IStudentManage.class.getName());
			//调用服务
			IStudentManage studentManage = (IStudentManage)context.getService(sf);
			studentManage.add();
		} finally {
			context.ungetService(sf);
		}
		System.out.println("action  end...");
	}

	public void stop(BundleContext context) throws Exception {
	}

}
