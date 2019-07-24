/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.acnas.loan.app.data.es.cqrs.service.es.command.ConfirmLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.command.FulfillLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.command.CreateLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppConfirmedEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppFulfilledEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppPlacedEvent;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppAggregate.
 */
@Aggregate

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data
public class LoanAppAggregate {

    /** The loan app ID. */
    @AggregateIdentifier
    private String loanAppID;
    
    /** The customer name. */
    private String customerName;
    
    /** The product. */
    private String product;
    
    /** The status. */
    private String status;
    
    /** The app confirmed. */
    private boolean appConfirmed;

    /**
     * Instantiates a new loan app aggregate.
     *
     * @param command the command
     */
    @CommandHandler
    public LoanAppAggregate(CreateLoanAppCommand command) {
        apply(new LoanAppPlacedEvent(command.getId(), command.getProduct(), command.getCustomerName()));
    }

    /**
     * Handle.
     *
     * @param command the command
     */
    @CommandHandler
    public void handle(ConfirmLoanAppCommand command) {
        apply(new LoanAppConfirmedEvent(loanAppID));
    }

    /**
     * Handle.
     *
     * @param command the command
     */
    @CommandHandler
    public void handle(FulfillLoanAppCommand command) {
        if (!appConfirmed) {
            throw new IllegalStateException("Cannot confirm the status of the loan application now ");
        }

        apply(new LoanAppFulfilledEvent(loanAppID));
    }

    /**
     * On.
     *
     * @param event the event
     */
    @EventSourcingHandler
    public void on(LoanAppPlacedEvent event) {
        this.loanAppID = event.getId();
        appConfirmed = false;
    }

    /**
     * On.
     *
     * @param event the event
     */
    @EventSourcingHandler
    public void on(LoanAppConfirmedEvent event) {
    	appConfirmed = true;
    }

    /**
     * Instantiates a new loan app aggregate.
     */
    protected LoanAppAggregate() {
         
    }

}