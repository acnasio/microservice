package com.acnas.loan.app.data.es.cqrs.service.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.acnas.loan.app.data.es.cqrs.service.util.DateType;
import com.acnas.loan.app.data.es.cqrs.service.util.ExceptionHandlerType;
import com.acnas.loan.app.data.es.cqrs.service.util.ExceptionUtil;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class EventingException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ExceptionUtil exceptionUtil;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	@Getter @Setter(AccessLevel.PUBLIC)
    private String operationName;
	
	@Getter (AccessLevel.PUBLIC)
    private final String handlerType;
	
	@Getter (AccessLevel.PUBLIC)
    private final boolean parent;
	
	@Getter (AccessLevel.PUBLIC)
    private final String time;
	
	@Getter(AccessLevel.PUBLIC)
	private final Exception parentException;
	
	public EventingException() {
		time = DateType.DATE_FORMAT_WITH_NANO_SECONDS.getDateAsString();		
		handlerType = ExceptionHandlerType.EVENTING_EXCEPTION_HANDLER.getValue();
		parent = true;	
		parentException = null;
		
	}

			
	
	public EventingException(String message, Exception exception) {
		super(message, exception);
		time = exceptionUtil.getFormattedTime(exception);
		handlerType = deriveHandlerFromException(exception);		
		parent = false;
		parentException = exception;
	}
	
	private String deriveHandlerFromException(Exception e) {
		String derivedHandlerType = exceptionUtil.getFormattedHandlerName(e);
		if (derivedHandlerType == null) {
			return ExceptionHandlerType.EVENTING_EXCEPTION_HANDLER.getValue();
		} else {
			return derivedHandlerType;
		}
	}

}
