package com.tb.wiredcoffee.web.init;

import org.springframework.web.reactive.support.AbstractAnnotationConfigDispatcherHandlerInitializer;

import com.tb.wiredcoffee.web.config.WebConfig;

public class ApiAppInitializer extends AbstractAnnotationConfigDispatcherHandlerInitializer {

	@Override
	protected Class<?>[] getConfigClasses() {
		
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String getServletMapping() {
		return "/";
	}

}
