 
package com.acnas.loan.app.data.es.cqrs.service.util;
 
 
public enum ExceptionHandlerType {
	
	DATA_ACCESS_EXCEPTION_HANDLER ("DATA_ACCESS_EXCEPTION_HANDLER"), 
	MESSAGING_EXCEPTION_HANDLER("MESSAGING_EXCEPTION_HANDLER"), 
	BUSINESS_EXCEPTION_HANDLER("BUSINESS_EXCEPTION_HANDLER"),
	INPUT_EXCEPTION_HANDLER("INPUT_EXCEPTION_HANDLER"),
	SECURITY_EXCEPTION_HANDLER("SECURITY_EXCEPTION_HANDLER"),
	EVENTING_EXCEPTION_HANDLER("EVENTING_EXCEPTION_HANDLER");
	
	
	/**
	 * Static method to find an exception handler type by value.
	 * 
	 * @param value input value
	 * @return {@link ExceptionHandlerType} identified by the input value
	 */
	public static ExceptionHandlerType findByValue (String value) {
        if (value != null) {
            for (ExceptionHandlerType authorityName : ExceptionHandlerType.values()) {
                if (value.equalsIgnoreCase(authorityName.getValue())) {
                    return authorityName;
                }
            }
        }

        return null;
    }
	
	
    /**
	 * Method to find a exception handler value.
	 * 
	 * @return string value of the exception handler name 
	 */
    public String getValue(){
    	return value;
    }
    
    private ExceptionHandlerType(String value){
        this.value = value;
    }
    private final String value;
}