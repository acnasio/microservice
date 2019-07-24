package com.acnas.loan.app.data.es.cqrs.service.exception;

import net.logstash.logback.encoder.org.apache.commons.lang.exception.ExceptionUtils;

public class PubnubConfigurationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PubnubConfigurationException() {
		
	}
	
	public PubnubConfigurationException(Exception e) {
		super(ExceptionUtils.getFullStackTrace(e));		
	}

}
