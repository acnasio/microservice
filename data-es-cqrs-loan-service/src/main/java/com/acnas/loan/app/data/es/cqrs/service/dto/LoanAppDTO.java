package com.acnas.loan.app.data.es.cqrs.service.dto;

import lombok.Data;

@Data
public class LoanAppDTO {
	
	String orderId;
	String product;
	String customerName;

}
