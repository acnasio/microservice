package com.acnas.loan.app.data.es.cqrs.service.exception;

public class ExceptionTransformer {
	
	
	ApiException deriveGlobalExceptionHandlerInput(Exception e) {
		return  new ApiException(null, e, null,null);	
		
		
	}

}
