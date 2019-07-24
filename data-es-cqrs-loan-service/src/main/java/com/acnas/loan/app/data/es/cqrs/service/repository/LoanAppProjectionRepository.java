package com.acnas.loan.app.data.es.cqrs.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.acnas.loan.app.data.es.cqrs.service.es.projection.*;

public interface LoanAppProjectionRepository extends CrudRepository<AppliedLoanAppProjection, String>{
	
	List<AppliedLoanAppProjection> findByOrderId(String orderId);

}
