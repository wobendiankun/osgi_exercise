package com.demo.action.tracker;

import org.omg.PortableInterceptor.INACTIVE;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import com.demo.action.log.LogStudentManager;
import com.demo.service.IStudentManage;

public class StudentManagerTracker extends ServiceTracker {
	
	public StudentManagerTracker(BundleContext context) {
		super(context, IStudentManage.class.getName(), null);
	}

	@Override
	public Object addingService(ServiceReference reference) {
		IStudentManage manage=new LogStudentManager(context, reference);
		return manage;
	}

	@Override
	public void open() {
		super.open();
	}
	
}
