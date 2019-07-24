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
 

@Service
public class LoanAppEventHandler {
	
	@Autowired
	LoanAppProjectionRepository loanAppProjectionRepository;
	
	@Autowired
	@Qualifier("loanAppAggregateEventSourcingRepository")
	EventSourcingRepository<LoanAppAggregate> loanAppAggregateEventSourcingRepository;

     

    @EventHandler
    public void on(LoanAppPlacedEvent event) {
    	persistLoanAppProjection(buildQueryOrderedLoanApp(getLoanAppFromEvent(event)));
    }

    @EventHandler
    public void on(LoanAppConfirmedEvent event) {
    	
    	//TODO
    	//decide whether we need to read from event store or simply go and update projection
    	LoanAppAggregate loanAppAggregate = getLoanAppFromEvent( event);
    	AppliedLoanAppProjection orderedLoanAppProjection =  buildQueryOrderedLoanApp(loanAppAggregate);
    	orderedLoanAppProjection.setOrderStatus(LoanAppStatus.CONFIRMED);
    	persistLoanAppProjection(orderedLoanAppProjection);
    }

    @EventHandler
    public void on(LoanAppFulfilledEvent event) {
    	LoanAppAggregate tradeOrderAggregate = getLoanAppFromEvent( event);
    	AppliedLoanAppProjection orderedTradeProjection =  buildQueryOrderedLoanApp(tradeOrderAggregate);
    	orderedTradeProjection.setOrderStatus(LoanAppStatus.FULFILLED);
    	persistLoanAppProjection(orderedTradeProjection);
    }
    
    
    private LoanAppAggregate getLoanAppFromEvent(BaseEvent event){
        return loanAppAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }
    
    private AppliedLoanAppProjection buildQueryOrderedLoanApp(LoanAppAggregate tradeOrderAggregate){
    	AppliedLoanAppProjection orderedLoanAppProjection = findExistingOrCreateQueryLoanAppProjection(tradeOrderAggregate.getLoanAppID());

    	orderedLoanAppProjection.setOrderId(tradeOrderAggregate.getLoanAppID());
    	orderedLoanAppProjection.setProduct(tradeOrderAggregate.getProduct());
    	orderedLoanAppProjection.setOrderStatus(LoanAppStatus.valueOf(tradeOrderAggregate.getStatus()));

        return orderedLoanAppProjection;
    }
    
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

    
    
    private void persistLoanAppProjection(AppliedLoanAppProjection orderedLoanAppProjection){
    	loanAppProjectionRepository.save(orderedLoanAppProjection);
    	
    }
 

}