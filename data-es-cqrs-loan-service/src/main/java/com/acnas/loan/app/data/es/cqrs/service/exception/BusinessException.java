package com.acnas.loan.app.data.es.cqrs.service.exception;


import org.springframework.beans.factory.annotation.Value;

import com.acnas.loan.app.data.es.cqrs.service.util.DateType;
import com.acnas.loan.app.data.es.cqrs.service.util.ExceptionHandlerType;
import com.acnas.loan.app.data.es.cqrs.service.util.ExceptionUtil;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class BusinessException extends Exception {

	 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Value("${spring.application.name}")
	private String serviceName;

	@Getter
	@Setter(AccessLevel.PUBLIC)
	private String operationName;

	@Getter(AccessLevel.PUBLIC)
	private final String handlerType;

	@Getter(AccessLevel.PUBLIC)
	private final boolean parent;

	@Getter(AccessLevel.PUBLIC)
	private final Exception parentException;
	
	@Getter(AccessLevel.PUBLIC)
	private final String time;

	public BusinessException() {
		time = DateType.DATE_FORMAT_WITH_NANO_SECONDS.getDateAsString();
		parent = true;
		handlerType = ExceptionHandlerType.BUSINESS_EXCEPTION_HANDLER.getValue();
		parentException = null;		 
	}
	
	public BusinessException(String message) {
		super(message);
		time = DateType.DATE_FORMAT_WITH_NANO_SECONDS.getDateAsString();
		parent = true;
		handlerType = ExceptionHandlerType.BUSINESS_EXCEPTION_HANDLER.getValue();
		parentException = null;		 
	}

	public BusinessException(String message, Exception exception) {				
		super(message, exception);
		time = ExceptionUtil.getFormattedTime(exception);
		handlerType = deriveHandlerFromException(exception);		
		parent = false;
		parentException = exception;
		
	}

	private String deriveHandlerFromException(Exception e) {
		String derivedHandlerType = ExceptionUtil.getFormattedHandlerName(e);
		if (derivedHandlerType == null) {
			return ExceptionHandlerType.BUSINESS_EXCEPTION_HANDLER.getValue();
		} else {
			return derivedHandlerType;
		}
	}

}
