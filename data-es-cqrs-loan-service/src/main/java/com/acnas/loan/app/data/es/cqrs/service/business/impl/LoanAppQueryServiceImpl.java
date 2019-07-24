/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppQueryServiceImpl.
 */
@Service
public class LoanAppQueryServiceImpl implements LoanAppQueryService {
	
	
	/** The event store. */
	private final EventStore eventStore;
	
	/** The query gateway. */
	private final QueryGateway queryGateway;
	
	
	
	/**
	 * Instantiates a new loan app query service impl.
	 *
	 * @param eventStore the event store
	 * @param queryGateway the query gateway
	 */
	public LoanAppQueryServiceImpl(EventStore eventStore,QueryGateway queryGateway) {
        this.eventStore = eventStore;
        this.queryGateway = queryGateway;
    }



	/**
	 * Gets the all loan app events.
	 *
	 * @param orderLoanAppEventQuery the order loan app event query
	 * @return the all loan app events
	 * @throws BusinessException the business exception
	 */
	@Override
	public List<Object> getAllLoanAppEvents(AppliedLoanAppEventQuery orderLoanAppEventQuery) throws BusinessException {
		return queryGateway.query(orderLoanAppEventQuery,
				 ResponseTypes.multipleInstancesOf(Object.class)) .join();
	}



	/**
	 * Gets the ordered loan app projection.
	 *
	 * @param orderedLoanAppProjectionQuery the ordered loan app projection query
	 * @return the ordered loan app projection
	 * @throws BusinessException the business exception
	 */
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
