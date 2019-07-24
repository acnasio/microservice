/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acnas.loan.app.data.es.cqrs.service.es.aggregate.LoanAppAggregate;

// TODO: Auto-generated Javadoc
/**
 * The Class AxonConfig.
 */
@Configuration
public class AxonConfig {
	
	/**
	 * Loan app aggregate event sourcing repository.
	 *
	 * @param eventStore the event store
	 * @return the event sourcing repository
	 */
	@Bean
    EventSourcingRepository<LoanAppAggregate> loanAppAggregateEventSourcingRepository(EventStore eventStore){
		EventSourcingRepository<LoanAppAggregate> repository = EventSourcingRepository.builder(LoanAppAggregate.class).eventStore(eventStore).build();
        return repository;
    }

}
