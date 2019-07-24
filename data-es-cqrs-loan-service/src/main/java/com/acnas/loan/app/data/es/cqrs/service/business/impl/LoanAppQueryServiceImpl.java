package com.acnas.loan.app.data.es.cqrs.service.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.springframework.stereotype.Service;

import com.acnas.loan.app.data.es.cqrs.service.business.LoanAppQueryService;
import com.acnas.loan.app.data.es.cqrs.service.es.projection.AppliedLoanAppProjection;
import com.acnas.loan.app.data.es.cqrs.service.es.query.AppliedLoanAppEventQuery;
import com.acnas.loan.app.data.es.cqrs.service.es.query.AppliedLoanAppProjectionQuery;
import com.acnas.loan.app.data.es.cqrs.service.exception.BusinessException;

import org.axonframework.queryhandling.QueryGateway;

@Service
public class LoanAppQueryServiceImpl implements LoanAppQueryService {
	
	
	private final EventStore eventStore;
	private final QueryGateway queryGateway;
	
	
	
	public LoanAppQueryServiceImpl(EventStore eventStore,QueryGateway queryGateway) {
        this.eventStore = eventStore;
        this.queryGateway = queryGateway;
    }



	@Override
	public List<Object> getAllLoanAppEvents(AppliedLoanAppEventQuery orderLoanAppEventQuery) throws BusinessException {
		return queryGateway.query(orderLoanAppEventQuery,
				 ResponseTypes.multipleInstancesOf(Object.class)) .join();
	}



	@Override
	public List<AppliedLoanAppProjection> getOrderedLoanAppProjection(AppliedLoanAppProjectionQuery orderedLoanAppProjectionQuery)
			throws BusinessException {
		
		return queryGateway.query(orderedLoanAppProjectionQuery,
				 ResponseTypes.multipleInstancesOf(AppliedLoanAppProjection.class)) .join();
		
		 
	}
	
	

	/*
	 * @Override public List<Object> getAllTraderOrderEvents(String orderID) throws
	 * BusinessException { List<Object> rerturnValue = null; try { rerturnValue =
	 * eventStore.readEvents(orderID).asStream().map( s ->
	 * s.getPayload()).collect(Collectors.toList()); } catch(Exception e) { //TODO
	 * //prepare business exception and throw }
	 * 
	 * return rerturnValue;
	 * 
	 * }
	 */

}
