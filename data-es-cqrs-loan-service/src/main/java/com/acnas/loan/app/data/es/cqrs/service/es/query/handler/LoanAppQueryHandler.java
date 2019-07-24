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
 

@Service
public class LoanAppQueryHandler {
	
	private final EventStore eventStore;

	@Autowired
	LoanAppProjectionRepository loanAppProjectionRepository;
	
	@Autowired
	@Qualifier("loanAppAggregateEventSourcingRepository")
	EventSourcingRepository<LoanAppAggregate> loanAppAggregateEventSourcingRepository;

    public LoanAppQueryHandler(EventStore eventStore) {
    	this.eventStore = eventStore;
    }

    @QueryHandler
    public List<AppliedLoanAppProjection> handle(AppliedLoanAppProjectionQuery query) {
    	return loanAppProjectionRepository.findByOrderId(query.getOrderId());
    }
    
    @QueryHandler
    public List<Object> getAllLoanAppEvents(AppliedLoanAppEventQuery appliedLoanAppEventQuery) throws BusinessException {
    	return eventStore.readEvents(appliedLoanAppEventQuery.getOrderId()).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }

}