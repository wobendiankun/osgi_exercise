package com.demo.service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.demo.service.impl.StudentManageA;
import com.demo.service.impl.StudentManageB;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		System.out.println("注册服务开始....");
		//注册A
		Hashtable<String, String> dict=new Hashtable<String, String>();
		dict.put("name", "a");
		context.registerService(IStudentManage.class.getName(),
				new StudentManageA(), dict);
		//注册B
		dict=new Hashtable<String, String>();
		dict.put("name", "b");
		context.registerService(IStudentManage.class.getName(),
				new StudentManageB(), dict);
		System.out.println("注册服务结束....");
	}

	public void stop(BundleContext context) throws Exception {

	}

}
