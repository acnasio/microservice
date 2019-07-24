package com.acnas.loan.app.data.es.cqrs.service.business.impl;

import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.acnas.loan.app.data.es.cqrs.service.business.LoanAppCommandService;
import com.acnas.loan.app.data.es.cqrs.service.dto.LoanAppDTO;
import com.acnas.loan.app.data.es.cqrs.service.es.command.CreateLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.exception.BusinessException;

@Service
public class LoanAppCommandServiceImpl  implements LoanAppCommandService{
	
	private final CommandGateway commandGateway;
	
	
	public LoanAppCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

	@Override
	public CompletableFuture<String> createLoanApp(LoanAppDTO loanAppDTO) throws BusinessException {
		CreateLoanAppCommand createLoanAppCommand = new CreateLoanAppCommand(loanAppDTO.getOrderId(),loanAppDTO.getProduct(), loanAppDTO.getCustomerName());
		return commandGateway.send(createLoanAppCommand);
	}

}
