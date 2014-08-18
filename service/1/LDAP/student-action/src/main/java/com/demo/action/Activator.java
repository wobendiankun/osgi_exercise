package com.demo.action;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;

import com.demo.service.IStudentManage;


public class Activator implements BundleActivator{
	public void start(BundleContext context) throws Exception {
		System.out.println("action  begin...");
		ServiceReference[] references=null;
		try {
			System.out.println("服务调用------------------");
			//查找Service
			String filter="(name=b)";
			references=context.getServiceReferences(IStudentManage.class.getName(), filter);
			//调用服务
			if(references.length==1){
				IStudentManage studentManage = (IStudentManage)context.getService(references[0]);
				studentManage.add();
			}else {
				throw new IllegalArgumentException("IStudentManage查找到多个实现类");
			}
			
		} finally {
			for(ServiceReference sf:references){
				context.ungetService(sf);
			}
			
		}
		System.out.println("action  end...");
	}

	public void stop(BundleContext context) throws Exception {
	}

}
