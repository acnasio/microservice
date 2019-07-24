/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.query.controller;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acnas.loan.app.data.es.cqrs.service.business.LoanAppCommandService;
import com.acnas.loan.app.data.es.cqrs.service.business.LoanAppQueryService;
import com.acnas.loan.app.data.es.cqrs.service.dto.LoanAppDTO;
import com.acnas.loan.app.data.es.cqrs.service.es.command.ConfirmLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.command.FulfillLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.command.CreateLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.projection.AppliedLoanAppProjection;
import com.acnas.loan.app.data.es.cqrs.service.es.query.AppliedLoanAppProjectionQuery;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppRestEndpoint.
 */
@RestController
public class LoanAppRestEndpoint {

    /** The loan app command service. */
    @Autowired
    LoanAppCommandService loanAppCommandService;
    
    /** The loan app query service. */
    @Autowired
    LoanAppQueryService loanAppQueryService;

    /**
     * Instantiates a new loan app rest endpoint.
     */
    public LoanAppRestEndpoint() {
         
    }

    /**
     * Ship order.
     */
    @PostMapping("/loanApp")
    public void shipOrder() {
    	//TODO - get from main source
        String orderId = UUID.randomUUID().toString();
        LoanAppDTO dto = new LoanAppDTO();
        dto.setOrderId(orderId);
        //TODO
        // move input to DTO
        dto.setProduct("my loan app for single family house");
        try {
        	loanAppCommandService.createLoanApp(dto);
        }catch(Exception e) {
        	
        }
        
    }

    /**
     * Ship unconfirmed order.
     */
    @PostMapping("/fulfill-unconfirmed-loanApp")
    public void shipUnconfirmedOrder() {
       //TODO
    }

    /**
     * Find all ordered products.
     *
     * @return the list
     */
    @GetMapping("/all-orders")
    public List<AppliedLoanAppProjection> findAllOrderedProducts() {
		/*
		 * return queryGateway.query(new OrderedTradeProjectionQuery(),
		 * ResponseTypes.multipleInstancesOf(OrderedTradeProjection.class)) .join();
		 */
    	return null;
    }

}
