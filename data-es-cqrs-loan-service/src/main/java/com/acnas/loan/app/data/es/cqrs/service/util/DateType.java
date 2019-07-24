 
package com.acnas.loan.app.data.es.cqrs.service.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.logstash.logback.encoder.org.apache.commons.lang.exception.ExceptionUtils;
 
 
public enum DateType {
	
	
	
	//common date format 
	DATE_FORMAT_WITH_NANO_SECONDS ("MM.dd.yyyy HH:mm:ss:SSSSSSS");
	
	// Date value
    private final String value;
    private static final Logger LOGGER = LoggerFactory.getLogger(DateType.class);
    
    //Private constructor
    private DateType(String value){
        this.value = value;
    }
    
    /**
	 * Method to find a Date value.
	 * 
	 * @return {@link String} value of the formatted date 
	 */
    public String getValue(){
    	return value;
    }
    
    /**
	 * Method to get the date as string.
	 * 
	 * @return {@link String} value of the formatted date 
	 */
    public String getDateAsString(){
    	DateFormat dateFormat = new SimpleDateFormat(value);
    	return dateFormat.format(new Date());    	
    }
    
     
    /**
	 * Method to get the date as string using the given input date object.
	 * @param {@link Date)
	 * @return {@link String} value of the formatted date 
	 */
    public String getDateAsString(Date date){
    	DateFormat dateFormat = new SimpleDateFormat(value);
    	return dateFormat.format(date);    	
    }
    
     
    
    
    
    /**
	 * Method to get the date as formatted date object using the given input date object.
	 * @param {@link String)
	 * @return {@link Date} formatted date 
	 */
    public Date getStringAsDate(String date){
    	Date returnValue = null;
    	DateFormat dateFormat = new SimpleDateFormat(value);
    	try {
    		returnValue =  dateFormat.parse(date);
		} catch (ParseException e) {			
			LOGGER.error("exception in getStringAsDate method: {}", ExceptionUtils.getFullStackTrace(e));
		} 
    	return returnValue;
    }
    /**
	 * Method to get the date as string using the given input string object.
	 * @param {@link String)
	 * @return {@link String} value of the formatted date 
	 */
    public String getDateStringFormated(String date){
    	String returnValue = null;
    	DateFormat dateFormat = new SimpleDateFormat(value);
    	try {
    		Date parsedDate =  dateFormat.parse(date);
    		returnValue = dateFormat.format(parsedDate);    		
		} catch (ParseException e) {			
			LOGGER.error("exception in getAfterDateAsString method: {}", ExceptionUtils.getFullStackTrace(e));
		} 
    	return returnValue;
    }
    
    /**
	 * Method to get the after date out of two given input date object.
	 * @param {@link Date)
	 * @return {@link Date} value of the after date object with format support 
	 */
    public Date getAfterDateAsString(Date date1, Date date2){
    	Date returnValue = null;
    	DateFormat dateFormat = new SimpleDateFormat(value);
    	try {
    		String date1Formated = dateFormat.format(date1);
    		String date2Formated = dateFormat.format(date2);
    		Date date1Parsed =  dateFormat.parse(date1Formated);
    		Date date2Parsed =  dateFormat.parse(date2Formated);
    		if(date1Parsed.compareTo(date2Parsed) > 0){
    			returnValue = date1Parsed;
    		}else{
    			returnValue = date2Parsed;
    		}    		
    		
		} catch (ParseException e) {
			LOGGER.error("exception in getAfterDateAsString method: {}", ExceptionUtils.getFullStackTrace(e));

		} 
    	return returnValue;
    }
    
    /**
	 * Method to get the after date out of two given input string date object.
	 * @param {@link String)
	 * @return {@link Date} value of the after date object as string with format support 
	 */
    public String getAfterDateAsString(String date1, String date2){
    	String returnValue = null;
    	DateFormat dateFormat = new SimpleDateFormat(value);
    	try {
    		Date date1Parsed = dateFormat.parse(date1);
    		Date date2Parsed = dateFormat.parse(date2);    		
    		if(date1Parsed.compareTo(date2Parsed) > 0){
    			returnValue = dateFormat.format(date1Parsed);
    		}else{
    			returnValue = dateFormat.format(date2Parsed);
    		}    		
    		
		} catch (ParseException e) {
			LOGGER.error("exception in getAfterDateAsString method: {}", ExceptionUtils.getFullStackTrace(e));
		} 
    	return returnValue;
    }
    
    public long getDateDifferenceInMilliSeconds(String oldDate, String currentDate){
    	long returnValue = 0L;
    	DateFormat dateFormat = new SimpleDateFormat(value);
    	try {
    		Date oldDateParsed = dateFormat.parse(oldDate);
    		Date currentDateParsed = dateFormat.parse(currentDate);    		
    		long returnValueAslong = currentDateParsed.getTime() - oldDateParsed.getTime();
    		long returnValueAsSeconds = TimeUnit.MILLISECONDS.toSeconds(returnValueAslong);
    		returnValue = returnValueAsSeconds * 1000;    		
		} catch (ParseException e) {
			LOGGER.error("exception in getAfterDateAsString method: {}", ExceptionUtils.getFullStackTrace(e));
		}     	
    	return returnValue;
    }
    
    
    public String getDateDifferenceInMilliSecondsAsString(String oldDate, String currentDate){
    	String  returnValue = null;
    	DateFormat dateFormat = new SimpleDateFormat(value);
    	try {
    		Date oldDateParsed = dateFormat.parse(oldDate);
    		Date currentDateParsed = dateFormat.parse(currentDate);    		
    		returnValue = (currentDateParsed.getTime() - oldDateParsed.getTime() +"").trim();
    		  		
		} catch (ParseException e) {
			LOGGER.error("exception in getDateDifferenceInMilliSecondsAsString method: {}", ExceptionUtils.getFullStackTrace(e));
		}   
    	LOGGER.debug("return date difference in milli second string: {}", returnValue);
    	return returnValue;
    }


}


