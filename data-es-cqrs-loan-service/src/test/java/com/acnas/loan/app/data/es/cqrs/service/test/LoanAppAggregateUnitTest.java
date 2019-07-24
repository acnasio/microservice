/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.test;

import java.util.UUID;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.*;

import com.acnas.loan.app.data.es.cqrs.service.es.aggregate.LoanAppAggregate;
import com.acnas.loan.app.data.es.cqrs.service.es.command.ConfirmLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.command.FulfillLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.command.CreateLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppConfirmedEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppFulfilledEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppPlacedEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppAggregateUnitTest.
 */
public class LoanAppAggregateUnitTest {

    /** The fixture. */
    private FixtureConfiguration<LoanAppAggregate> fixture;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(LoanAppAggregate.class);
    }

    /**
     * Give no prior activity when place lon app command then should publish loan app placed event.
     */
    @Test
    public void giveNoPriorActivity_whenPlaceLonAppCommand_thenShouldPublishLoanAppPlacedEvent() {
        String orderId = UUID.randomUUID().toString();
        String product = "My home loan";
        String customerName = "myName";
        fixture.givenNoPriorActivity()
               .when(new CreateLoanAppCommand(orderId, product, customerName))
               .expectEvents(new LoanAppPlacedEvent(orderId, product, customerName));
    }

    /**
     * Given loan app placed event when confirm loan app command then should publish loan app confirmed event.
     */
    @Test
    public void givenLoanAppPlacedEvent_whenConfirmLoanAppCommand_thenShouldPublishLoanAppConfirmedEvent() {
        String orderId = UUID.randomUUID().toString();
        String product = "My home loan";
        String customerName = "myName";
        fixture.given(new LoanAppPlacedEvent(orderId, product, customerName))
               .when(new ConfirmLoanAppCommand(orderId))
               .expectEvents(new LoanAppConfirmedEvent(orderId));
    }

     

}