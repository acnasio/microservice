/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.event.handler;

import java.util.HashMap;
import java.util.Map;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acnas.loan.app.data.es.cqrs.service.es.aggregate.LoanAppAggregate;
import com.acnas.loan.app.data.es.cqrs.service.es.event.BaseEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppConfirmedEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppFulfilledEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppPlacedEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.projection.AppliedLoanAppProjection;
import com.acnas.loan.app.data.es.cqrs.service.es.value.object.LoanAppStatus;
import com.acnas.loan.app.data.es.cqrs.service.repository.LoanAppProjectionRepository;
 

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppEventHandler.
 */
@Service
public class LoanAppEventHandler {
	
	/** The loan app projection repository. */
	@Autowired
	LoanAppProjectionRepository loanAppProjectionRepository;
	
	/** The loan app aggregate event sourcing repository. */
	@Autowired
	@Qualifier("loanAppAggregateEventSourcingRepository")
	EventSourcingRepository<LoanAppAggregate> loanAppAggregateEventSourcingRepository;

     

    /**
     * On.
     *
     * @param event the event
     */
    @EventHandler
    public void on(LoanAppPlacedEvent event) {
    	persistLoanAppProjection(buildQueryOrderedLoanApp(getLoanAppFromEvent(event)));
    }

    /**
     * On.
     *
     * @param event the event
     */
    @EventHandler
    public void on(LoanAppConfirmedEvent event) {
    	
    	//TODO
    	//decide whether we need to read from event store or simply go and update projection
    	LoanAppAggregate loanAppAggregate = getLoanAppFromEvent( event);
    	AppliedLoanAppProjection orderedLoanAppProjection =  buildQueryOrderedLoanApp(loanAppAggregate);
    	orderedLoanAppProjection.setOrderStatus(LoanAppStatus.CONFIRMED);
    	persistLoanAppProjection(orderedLoanAppProjection);
    }

    /**
     * On.
     *
     * @param event the event
     */
    @EventHandler
    public void on(LoanAppFulfilledEvent event) {
    	LoanAppAggregate tradeOrderAggregate = getLoanAppFromEvent( event);
    	AppliedLoanAppProjection orderedTradeProjection =  buildQueryOrderedLoanApp(tradeOrderAggregate);
    	orderedTradeProjection.setOrderStatus(LoanAppStatus.FULFILLED);
    	persistLoanAppProjection(orderedTradeProjection);
    }
    
    
    /**
     * Gets the loan app from event.
     *
     * @param event the event
     * @return the loan app from event
     */
    private LoanAppAggregate getLoanAppFromEvent(BaseEvent event){
        return loanAppAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }
    
    /**
     * Builds the query ordered loan app.
     *
     * @param tradeOrderAggregate the trade order aggregate
     * @return the applied loan app projection
     */
    private AppliedLoanAppProjection buildQueryOrderedLoanApp(LoanAppAggregate tradeOrderAggregate){
    	AppliedLoanAppProjection orderedLoanAppProjection = findExistingOrCreateQueryLoanAppProjection(tradeOrderAggregate.getLoanAppID());

    	orderedLoanAppProjection.setOrderId(tradeOrderAggregate.getLoanAppID());
    	orderedLoanAppProjection.setProduct(tradeOrderAggregate.getProduct());
    	orderedLoanAppProjection.setOrderStatus(LoanAppStatus.valueOf(tradeOrderAggregate.getStatus()));

        return orderedLoanAppProjection;
    }
    
    /**
     * Find existing or create query loan app projection.
     *
     * @param id the id
     * @return the applied loan app projection
     */
    private AppliedLoanAppProjection findExistingOrCreateQueryLoanAppProjection(String id){
    	AppliedLoanAppProjection returnValue = null;
    	AppliedLoanAppProjection existingValue = loanAppProjectionRepository.findOne(id);
    	if(existingValue != null) {
    		returnValue = existingValue;
    	}else {
    		 new AppliedLoanAppProjection();
    	}
    	return returnValue;
    }

    
    
    /**
     * Persist loan app projection.
     *
     * @param orderedLoanAppProjection the ordered loan app projection
     */
    private void persistLoanAppProjection(AppliedLoanAppProjection orderedLoanAppProjection){
    	loanAppProjectionRepository.save(orderedLoanAppProjection);
    	
    }
 

}