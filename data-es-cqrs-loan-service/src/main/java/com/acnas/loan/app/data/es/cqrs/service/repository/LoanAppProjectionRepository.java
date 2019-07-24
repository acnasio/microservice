/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.acnas.loan.app.data.es.cqrs.service.es.projection.*;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoanAppProjectionRepository.
 */
public interface LoanAppProjectionRepository extends CrudRepository<AppliedLoanAppProjection, String>{
	
	/**
	 * Find by order id.
	 *
	 * @param orderId the order id
	 * @return the list
	 */
	List<AppliedLoanAppProjection> findByOrderId(String orderId);

}
