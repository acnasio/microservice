package com.acnas.loan.app.data.es.cqrs.service.business;

import java.util.List;

import com.acnas.loan.app.data.es.cqrs.service.dto.LoanAppDTO;
import com.acnas.loan.app.data.es.cqrs.service.es.projection.AppliedLoanAppProjection;
import com.acnas.loan.app.data.es.cqrs.service.es.query.AppliedLoanAppEventQuery;
import com.acnas.loan.app.data.es.cqrs.service.es.query.AppliedLoanAppProjectionQuery;
import com.acnas.loan.app.data.es.cqrs.service.exception.BusinessException;

public interface LoanAppQueryService {
	
	 List<Object> getAllLoanAppEvents(AppliedLoanAppEventQuery orderLoanAppEventQuery) throws BusinessException;
	 
	 List<AppliedLoanAppProjection> getOrderedLoanAppProjection(AppliedLoanAppProjectionQuery orderedLoanAppProjectionQuery) throws BusinessException;
	 
}
