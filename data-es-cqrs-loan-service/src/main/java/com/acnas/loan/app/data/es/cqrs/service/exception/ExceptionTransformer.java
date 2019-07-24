/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionTransformer.
 */
public class ExceptionTransformer {
	
	
	/**
	 * Derive global exception handler input.
	 *
	 * @param e the e
	 * @return the api exception
	 */
	ApiException deriveGlobalExceptionHandlerInput(Exception e) {
		return  new ApiException(null, e, null,null);	
		
		
	}

}
