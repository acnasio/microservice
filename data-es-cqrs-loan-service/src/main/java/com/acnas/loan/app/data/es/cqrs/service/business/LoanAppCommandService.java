package com.acnas.loan.app.data.es.cqrs.service.business;

import java.util.concurrent.CompletableFuture;

import com.acnas.loan.app.data.es.cqrs.service.dto.LoanAppDTO;
import com.acnas.loan.app.data.es.cqrs.service.exception.BusinessException;

public interface LoanAppCommandService {
	
	public CompletableFuture<String> createLoanApp(LoanAppDTO tradeOrderDTO) throws BusinessException;
     

}
