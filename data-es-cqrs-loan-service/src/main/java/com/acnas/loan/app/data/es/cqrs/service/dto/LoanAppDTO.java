/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.dto;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new loan app DTO.
 */
@Data
public class LoanAppDTO {
	
	/** The order id. */
	String orderId;
	
	/** The product. */
	String product;
	
	/** The customer name. */
	String customerName;

}
