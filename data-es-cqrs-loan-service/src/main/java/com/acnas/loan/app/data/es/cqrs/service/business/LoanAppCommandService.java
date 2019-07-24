/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.business;

import java.util.concurrent.CompletableFuture;

import com.acnas.loan.app.data.es.cqrs.service.dto.LoanAppDTO;
import com.acnas.loan.app.data.es.cqrs.service.exception.BusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoanAppCommandService.
 */
public interface LoanAppCommandService {
	
	/**
	 * Creates the loan app.
	 *
	 * @param tradeOrderDTO the trade order DTO
	 * @return the completable future
	 * @throws BusinessException the business exception
	 */
	public CompletableFuture<String> createLoanApp(LoanAppDTO tradeOrderDTO) throws BusinessException;
     

}
