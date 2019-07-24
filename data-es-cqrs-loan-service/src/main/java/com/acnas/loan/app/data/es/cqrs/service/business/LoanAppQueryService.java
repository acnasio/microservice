/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.business;

import java.util.List;

import com.acnas.loan.app.data.es.cqrs.service.dto.LoanAppDTO;
import com.acnas.loan.app.data.es.cqrs.service.es.projection.AppliedLoanAppProjection;
import com.acnas.loan.app.data.es.cqrs.service.es.query.AppliedLoanAppEventQuery;
import com.acnas.loan.app.data.es.cqrs.service.es.query.AppliedLoanAppProjectionQuery;
import com.acnas.loan.app.data.es.cqrs.service.exception.BusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoanAppQueryService.
 */
public interface LoanAppQueryService {
	
	 /**
 	 * Gets the all loan app events.
 	 *
 	 * @param orderLoanAppEventQuery the order loan app event query
 	 * @return the all loan app events
 	 * @throws BusinessException the business exception
 	 */
 	List<Object> getAllLoanAppEvents(AppliedLoanAppEventQuery orderLoanAppEventQuery) throws BusinessException;
	 
	 /**
 	 * Gets the ordered loan app projection.
 	 *
 	 * @param orderedLoanAppProjectionQuery the ordered loan app projection query
 	 * @return the ordered loan app projection
 	 * @throws BusinessException the business exception
 	 */
 	List<AppliedLoanAppProjection> getOrderedLoanAppProjection(AppliedLoanAppProjectionQuery orderedLoanAppProjectionQuery) throws BusinessException;
	 
}
