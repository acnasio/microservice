package com.acnas.loan.app.data.es.cqrs.service.exception;

import org.apache.commons.lang.exception.ExceptionUtils;

public class LocationException extends Exception {
	
	public LocationException(String message) {
		super(message);		
	}
	
	public LocationException(Exception exception) {
		super(ExceptionUtils.getFullStackTrace(exception));		
	}

}
