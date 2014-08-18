package com.demo.action;

import java.util.SortedSet;
import java.util.TreeSet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

import com.demo.service.IStudentManage;


public class Activator implements BundleActivator{
	BundleContext context;
	UserManagerListener listener;
	public void start(BundleContext context) throws Exception {
		System.out.println("action listener begin...");
		this.context=context;
		listener=new UserManagerListener();
		System.out.println("服务调用------------------");
		synchronized (listener) {
		      String filter = "(" + Constants.OBJECTCLASS + "=" + IStudentManage.class.getName() + ")";
		      context.addServiceListener(listener, filter);
		      ServiceReference[] refs = context.getServiceReferences(null, filter);
		      if (refs != null) {
		        for (ServiceReference r : refs) {
		        	listener.serviceChanged(new ServiceEvent(ServiceEvent.REGISTERED, r));
		        }
		      }
		 }
		//查找Service
		IStudentManage studentManage=listener.getStudentManageService();
		//调用服务
		studentManage.add();
		System.out.println("action listener end...");
	}

	public void stop(BundleContext context) throws Exception {
	}
	//监听类
	class UserManagerListener implements ServiceListener {
		SortedSet<ServiceReference> studentManageRefs = new TreeSet<ServiceReference>();
		public synchronized void serviceChanged(ServiceEvent event) {
			switch (event.getType()) {
	        case ServiceEvent.REGISTERED:
	        	studentManageRefs.add(event.getServiceReference());
	          break;
	        case ServiceEvent.MODIFIED:
	          break;
	        case ServiceEvent.UNREGISTERING:
	        	studentManageRefs.remove(event.getServiceReference());
	          break;
	        default:
	          break;
	      }
		}
		 /**查找服务
		 * @return IStudentManage
		 */
		public synchronized IStudentManage getStudentManageService() {
		      if (studentManageRefs.size() > 0) {
		    	  System.out.println("size:"+studentManageRefs.size());
		        return (IStudentManage) context.getService(studentManageRefs.last());
		      }
		      return null;
		    }
	}
}
