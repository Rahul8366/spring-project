package com.student.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {StudentConfig.class};// In this method we are passing the studentconfig class object where, we have passed the packages in order to let spring know that, which are the classes it needs to create object for
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"}; // In this method we are accepting all the url coming as request,by passing a base url inside an string type array {""}
		
	}

}
