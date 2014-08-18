package com.demo.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.demo.service.impl.StudentManage;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		System.out.println("注册服务开始....");
		context.registerService(IStudentManage.class.getName(),
				new StudentManage(), null);
		System.out.println("注册服务结束....");
	}

	public void stop(BundleContext context) throws Exception {

	}

}
