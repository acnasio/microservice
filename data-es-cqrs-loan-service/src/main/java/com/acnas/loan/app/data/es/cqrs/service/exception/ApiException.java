package com.acnas.loan.app.data.es.cqrs.service.exception;

 
 
 
import com.acnas.loan.app.data.es.cqrs.service.util.DateType;
import com.acnas.loan.app.data.es.cqrs.service.util.ExceptionHandlerType;
import com.acnas.loan.app.data.es.cqrs.service.util.ExceptionUtil;

import lombok.AccessLevel;
import lombok.Getter;


public class ApiException extends Exception {
	
	private static final long serialVersionUID = 1L;
		
	@Getter (AccessLevel.PUBLIC)
    private final String operationName;
	
	@Getter (AccessLevel.PUBLIC)
    private final boolean parent;
	
	@Getter (AccessLevel.PUBLIC)
    private final String userMsg;
	
	@Getter (AccessLevel.PUBLIC)
    private final String handlerType;
	
	@Getter (AccessLevel.PUBLIC)
    private final Exception parentException;
	
	@Getter (AccessLevel.PUBLIC)
    private final String time;
	
	public ApiException(String inuserMsg, String inHandlerType, String inOperationName) {
		userMsg = inuserMsg;
		handlerType = inHandlerType;
		operationName = inOperationName;
		time = DateType.DATE_FORMAT_WITH_NANO_SECONDS.getDateAsString();
		parent = true;		
		parentException = null;		 
	}
	
	public ApiException(String message, String inuserMsg, String inHandlerType, String inOperationName) {
		super(message);
		userMsg = inuserMsg;
		handlerType = inHandlerType;
		operationName = inOperationName;
		time = DateType.DATE_FORMAT_WITH_NANO_SECONDS.getDateAsString();
		parent = true;		
		parentException = null;		 
	}

	public ApiException(String message, Exception exception, String inuserMsg, String inOperationName) {				
		super(message, exception);
		userMsg = inuserMsg;		
		operationName = inOperationName;
		time = ExceptionUtil.getFormattedTime(exception);
		handlerType = deriveHandlerFromException(exception);		
		parent = false;
		parentException = exception;
		
	}
	
	
	private static String deriveHandlerFromException(Exception e) {
		String derivedHandlerType = ExceptionUtil.getFormattedHandlerName(e);
		if (derivedHandlerType == null) {
			return ExceptionHandlerType.BUSINESS_EXCEPTION_HANDLER.getValue();
		} else {
			return derivedHandlerType;
		}
	}
	

}
