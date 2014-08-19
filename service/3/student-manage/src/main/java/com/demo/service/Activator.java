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
		System.out.println("register service start...");
		Dictionary<String, String> prop=new Hashtable<String, String>();
		prop.put("action", "student_action");
		context.registerService(IStudentManage.class.getName(), new StudentManage(), prop);
		System.out.println("register service end...");
	}

	public void stop(BundleContext context) throws Exception {

	}

}
