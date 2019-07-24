package com.acnas.loan.app.data.es.cqrs.service.exception;

import org.apache.commons.lang.exception.ExceptionUtils;

public class ConfigException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConfigException(String message) {
		super(message);		
	} 
	
	public ConfigException(Exception exception) {
		super(ExceptionUtils.getFullStackTrace(exception));		
	} 

}
