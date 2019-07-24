/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.business.impl;

import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.acnas.loan.app.data.es.cqrs.service.business.LoanAppCommandService;
import com.acnas.loan.app.data.es.cqrs.service.dto.LoanAppDTO;
import com.acnas.loan.app.data.es.cqrs.service.es.command.CreateLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.exception.BusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppCommandServiceImpl.
 */
@Service
public class LoanAppCommandServiceImpl  implements LoanAppCommandService{
	
	/** The command gateway. */
	private final CommandGateway commandGateway;
	
	
	/**
	 * Instantiates a new loan app command service impl.
	 *
	 * @param commandGateway the command gateway
	 */
	public LoanAppCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

	/**
	 * Creates the loan app.
	 *
	 * @param loanAppDTO the loan app DTO
	 * @return the completable future
	 * @throws BusinessException the business exception
	 */
	@Override
	public CompletableFuture<String> createLoanApp(LoanAppDTO loanAppDTO) throws BusinessException {
		CreateLoanAppCommand createLoanAppCommand = new CreateLoanAppCommand(loanAppDTO.getOrderId(),loanAppDTO.getProduct(), loanAppDTO.getCustomerName());
		return commandGateway.send(createLoanAppCommand);
	}

}
