/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.acnas.loan.app.data.es.cqrs.service.util.DateType;
import com.acnas.loan.app.data.es.cqrs.service.util.ExceptionHandlerType;
import com.acnas.loan.app.data.es.cqrs.service.util.ExceptionUtil;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class EventingException.
 */
public class EventingException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The exception util. */
	@Autowired
	ExceptionUtil exceptionUtil;
	
	/** The service name. */
	@Value("${spring.application.name}")
	private String serviceName;
	
	/**
	 * Gets the operation name.
	 *
	 * @return the operation name
	 */
	@Getter /**
  * Sets the operation name.
  *
  * @param operationName the new operation name
  */
 @Setter(AccessLevel.PUBLIC)
    private String operationName;
	
	/**
	 * Gets the handler type.
	 *
	 * @return the handler type
	 */
	@Getter (AccessLevel.PUBLIC)
    private final String handlerType;
	
	/**
	 * Checks if is parent.
	 *
	 * @return true, if is parent
	 */
	@Getter (AccessLevel.PUBLIC)
    private final boolean parent;
	
	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	@Getter (AccessLevel.PUBLIC)
    private final String time;
	
	/**
	 * Gets the parent exception.
	 *
	 * @return the parent exception
	 */
	@Getter(AccessLevel.PUBLIC)
	private final Exception parentException;
	
	/**
	 * Instantiates a new eventing exception.
	 */
	public EventingException() {
		time = DateType.DATE_FORMAT_WITH_NANO_SECONDS.getDateAsString();		
		handlerType = ExceptionHandlerType.EVENTING_EXCEPTION_HANDLER.getValue();
		parent = true;	
		parentException = null;
		
	}

			
	
	/**
	 * Instantiates a new eventing exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public EventingException(String message, Exception exception) {
		super(message, exception);
		time = exceptionUtil.getFormattedTime(exception);
		handlerType = deriveHandlerFromException(exception);		
		parent = false;
		parentException = exception;
	}
	
	/**
	 * Derive handler from exception.
	 *
	 * @param e the e
	 * @return the string
	 */
	private String deriveHandlerFromException(Exception e) {
		String derivedHandlerType = exceptionUtil.getFormattedHandlerName(e);
		if (derivedHandlerType == null) {
			return ExceptionHandlerType.EVENTING_EXCEPTION_HANDLER.getValue();
		} else {
			return derivedHandlerType;
		}
	}

}
