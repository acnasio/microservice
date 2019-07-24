/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.query.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acnas.loan.app.data.es.cqrs.service.es.aggregate.LoanAppAggregate;
import com.acnas.loan.app.data.es.cqrs.service.es.projection.AppliedLoanAppProjection;
import com.acnas.loan.app.data.es.cqrs.service.es.query.AppliedLoanAppEventQuery;
import com.acnas.loan.app.data.es.cqrs.service.es.query.AppliedLoanAppProjectionQuery;
import com.acnas.loan.app.data.es.cqrs.service.exception.BusinessException;
import com.acnas.loan.app.data.es.cqrs.service.repository.LoanAppProjectionRepository;
 

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppQueryHandler.
 */
@Service
public class LoanAppQueryHandler {
	
	/** The event store. */
	private final EventStore eventStore;

	/** The loan app projection repository. */
	@Autowired
	LoanAppProjectionRepository loanAppProjectionRepository;
	
	/** The loan app aggregate event sourcing repository. */
	@Autowired
	@Qualifier("loanAppAggregateEventSourcingRepository")
	EventSourcingRepository<LoanAppAggregate> loanAppAggregateEventSourcingRepository;

    /**
     * Instantiates a new loan app query handler.
     *
     * @param eventStore the event store
     */
    public LoanAppQueryHandler(EventStore eventStore) {
    	this.eventStore = eventStore;
    }

    /**
     * Handle.
     *
     * @param query the query
     * @return the list
     */
    @QueryHandler
    public List<AppliedLoanAppProjection> handle(AppliedLoanAppProjectionQuery query) {
    	return loanAppProjectionRepository.findByOrderId(query.getOrderId());
    }
    
    /**
     * Gets the all loan app events.
     *
     * @param appliedLoanAppEventQuery the applied loan app event query
     * @return the all loan app events
     * @throws BusinessException the business exception
     */
    @QueryHandler
    public List<Object> getAllLoanAppEvents(AppliedLoanAppEventQuery appliedLoanAppEventQuery) throws BusinessException {
    	return eventStore.readEvents(appliedLoanAppEventQuery.getOrderId()).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }

}